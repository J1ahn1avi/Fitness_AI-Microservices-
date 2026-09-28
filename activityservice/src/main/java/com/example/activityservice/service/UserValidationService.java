package com.example.activityservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidationService {
	private final WebClient userServiceWebClient = null;
	private static final Logger log = LoggerFactory.getLogger(UserValidationService.class);
	public boolean validateUser(String userId) {
		log.info("Calling User Validation API for userId: {}", userId);
		try {
			return userServiceWebClient.get()
				.uri("/api/users/{userId}/validate",userId)
				.retrieve()
				.bodyToMono(Boolean.class)
				.block();
			}
		catch(WebClientResponseException e){
			if(e.getStatusCode()==HttpStatus.NOT_FOUND)
				throw new RuntimeException("User not found: "+userId);
			else if (e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new RuntimeException("Invalid Request: " + userId);
		}
		return false;
	}
}
