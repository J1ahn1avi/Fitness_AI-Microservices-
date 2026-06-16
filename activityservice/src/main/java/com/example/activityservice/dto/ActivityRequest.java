package com.example.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.activityservice.model.ActivityType;

import lombok.Data;
@Data
public class ActivityRequest {
	private String userId;
	private ActivityType type;
	private Integer duriation;
	private Integer caloriesBurned;
	private LocalDateTime createdAt;
	private Map<String, Object> addtionalMetrics;
}
