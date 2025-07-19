package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityAiService {

    private final GeminiService geminiService;

    public String generateRecommendation(Activity activity) {
        String prompt = createPromptForActivity(activity);
        String aiResponse = geminiService.getAnswer(prompt);
        log.info("RESPONSE FROM AI: {}", aiResponse);
        return aiResponse;
    }

    private String createPromptForActivity(Activity activity) {
        // TODO Auto-generated method stub
        return String.format("""
                Analyze this fitness activity and provide detailed recommendations in the following EXACT JSON format:
                {
                    "analysis":{
                    "overall": "Overall analysis here",
                    "pace": "pace analysis here",
                    "heartRate": "heart rate analysis here",
                    "caloriesBurned": "calories burned analysis here",
                    },
                    "improvements":[{
                    "area": "Area name",
                    "Recommendation": "Detailed recommendation"
                    }],
                    "suggestions":[
                    {
                    "workout": "Workout name",
                    "description": "Detailed workout description"
                    }],
                    "safety":[
                    "Safety point 1",
                    "Safety point 2",
                    ]
                }
                Analyze this activity:
                Activity Type: %s
                Duration: %d minutes
                Calories Burned: %d
                Additional Metrics: %s
                
                Provide detailed analysis focusing on performance, improvements, next workout suggestions, and safety quideline.
                JSON format shown above.
                """,
                activity.getType(),
                activity.getDuration(),
                activity.getCaloriesBurned(),
                activity.getAdditionalMetrics());
                }
    }