package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRecommendation {

    private final RecommendationRepository recommendationRepository;


    public ResponseEntity<List<Recommendation>> getUserRecommendation(String userId) {
        return new ResponseEntity<List<Recommendation>>(recommendationRepository.findByUserId(userId), HttpStatus.OK);

    }

    public ResponseEntity<Recommendation> getActivityRecommendation(String activityId) {
        return new ResponseEntity<Recommendation>(recommendationRepository.findByActivityId(activityId).orElseThrow(() -> new RuntimeException("Recommendation not found")), HttpStatus.OK);
    }
}
