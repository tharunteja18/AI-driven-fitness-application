package com.fitness.activityservice.Controller;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
@Slf4j
public class ActivityController {

    private ActivityService activityService;

    @PostMapping("/trackActivity")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request)
    {
        log.info("Received activity request: {}", request);
        return new ResponseEntity<ActivityResponse>(activityService.trackActivity(request), HttpStatus.CREATED);
    }

    // Fetch all activities by userId
    // one user can have multiple activities
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId)
    {
        log.info("Received request to fetch activities for user: {}", userId);
        return new ResponseEntity<List<ActivityResponse>>(activityService.getUserActivities(userId), HttpStatus.OK);
    }

    //Fetch activity by id
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getUserActivityById(@PathVariable String activityId)
    {
        log.info("Received request to fetch activity with id: {}", activityId);
        return new ResponseEntity<ActivityResponse>(activityService.getUserActivityById(activityId), HttpStatus.OK);
    }
}
