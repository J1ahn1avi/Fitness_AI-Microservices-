package com.example.activityservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.activityservice.dto.ActivityRequest;
import com.example.activityservice.dto.ActivityResponse;
import com.example.activityservice.model.Activity;
import com.example.activityservice.repository.ActivityRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivityService {

    // Manual logger - no Lombok needed
    private static final Logger log = LoggerFactory.getLogger(ActivityService.class);

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    private final RabbitTemplate rabbitTemplate ;
    
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    public ActivityService(ActivityRepository activityRepository, UserValidationService userValidationService) {
        this.activityRepository = activityRepository;
		this.userValidationService = userValidationService;
		this.rabbitTemplate = new RabbitTemplate();
    }

    public ActivityResponse trackActivity(ActivityRequest request) {
    	boolean isValidUser = userValidationService.validateUser(request.getUserId());
    	if(!isValidUser) {
    		throw new RuntimeException("Invalid user: "+ request.getUserId());
    	}
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        log.info("Activity tracked for user: {}", request.getUserId());  // ← log works now
        try {
        	rabbitTemplate.convertAndSend(exchange,routingKey,savedActivity);
        }catch(Exception e){
        	log.error("Failed to publish activity to RabbitMQ: ", e);        }
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }

	public List<ActivityResponse> getUserActivities(String userId) {
		List<Activity> activities=activityRepository.findByUserId(userId);
		return activities.stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}

	public ActivityResponse getActivityById(String activityId) {
		
		return activityRepository.findById(activityId)
				.map(this::mapToResponse)
				.orElseThrow(() ->new  RuntimeException("Activity not found with id : "+activityId));
	}
}