package com.fitness.aiservice.Controller;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.service.ServiceRecommendation;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final ServiceRecommendation serviceRecommendation;

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId) {
        return   ResponseEntity.ok(serviceRecommendation.getUserRecommendation(userId));
    }

    @GetMapping("activity/{activityId}")
    public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable String activityId) {
        return  ResponseEntity.ok(serviceRecommendation.getActivityRecommendation(activityId));
    }
}
