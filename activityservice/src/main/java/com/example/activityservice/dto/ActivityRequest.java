package com.example.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import com.example.activityservice.model.ActivityType;

import lombok.Data;

@Data
public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
	@Override
	public String toString() {
		return "ActivityRequest [userId=" + userId + ", type=" + type + ", duration=" + duration + ", caloriesBurned="
				+ caloriesBurned + ", startTime=" + startTime + ", additionalMetrics=" + additionalMetrics
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public ActivityRequest(String userId, ActivityType type, Integer duration, Integer caloriesBurned,
			LocalDateTime startTime, Map<String, Object> additionalMetrics) {
		super();
		this.userId = userId;
		this.type = type;
		this.duration = duration;
		this.caloriesBurned = caloriesBurned;
		this.startTime = startTime;
		this.additionalMetrics = additionalMetrics;
	}
	public ActivityRequest() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public int hashCode() {
		return Objects.hash(additionalMetrics, caloriesBurned, duration, startTime, type, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityRequest other = (ActivityRequest) obj;
		return Objects.equals(additionalMetrics, other.additionalMetrics)
				&& Objects.equals(caloriesBurned, other.caloriesBurned) && Objects.equals(duration, other.duration)
				&& Objects.equals(startTime, other.startTime) && type == other.type
				&& Objects.equals(userId, other.userId);
	}
	
    
    
}