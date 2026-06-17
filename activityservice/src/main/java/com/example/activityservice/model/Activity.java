package com.example.activityservice.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "activities")

public class Activity {
    @Id
    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;

    @Field("metrics")
    private Map<String, Object> additionalMetrics;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Map<String, Object> getAdditionalMetrics() {
		return additionalMetrics;
	}

	public void setAdditionalMetrics(Map<String, Object> additionalMetrics) {
		this.additionalMetrics = additionalMetrics;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Activity(String id, String userId, ActivityType type, Integer duration, Integer caloriesBurned,
            LocalDateTime startTime, Map<String, Object> additionalMetrics,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
this.id = id;
this.userId = userId;
this.type = type;
this.duration = duration;
this.caloriesBurned = caloriesBurned;
this.startTime = startTime;
this.additionalMetrics = additionalMetrics;
this.createdAt = createdAt;
this.updatedAt = updatedAt;
}

	public static class ActivityBuilder {
        private String id;
        private String userId;
        private ActivityType type;
        private Integer duration;
        private Integer caloriesBurned;
        private LocalDateTime startTime;
        private Map<String, Object> additionalMetrics;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public ActivityBuilder id(String id) { this.id = id; return this; }
        public ActivityBuilder userId(String userId) { this.userId = userId; return this; }
        public ActivityBuilder type(ActivityType type) { this.type = type; return this; }
        public ActivityBuilder duration(Integer duration) { this.duration = duration; return this; }
        public ActivityBuilder caloriesBurned(Integer caloriesBurned) { this.caloriesBurned = caloriesBurned; return this; }
        public ActivityBuilder startTime(LocalDateTime startTime) { this.startTime = startTime; return this; }
        public ActivityBuilder additionalMetrics(Map<String, Object> additionalMetrics) { this.additionalMetrics = additionalMetrics; return this; }
        public ActivityBuilder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public ActivityBuilder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }

        public Activity build() {
            return new Activity(id, userId, type, duration, caloriesBurned, startTime, additionalMetrics, createdAt, updatedAt);
        }
    }

	public static ActivityBuilder builder() {
        return new ActivityBuilder();
    }
	
	

	
}