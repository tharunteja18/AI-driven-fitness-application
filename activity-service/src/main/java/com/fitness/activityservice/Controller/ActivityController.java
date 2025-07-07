package com.fitness.activityservice.Controller;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {

    private ActivityService activityService;

    @PostMapping("/trackActivity")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request)
    {
        return new ResponseEntity<ActivityResponse>(activityService.trackActivity(request), HttpStatus.CREATED);
    }

    // Fetch all activities by userId
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId)
    {
        return new ResponseEntity<List<ActivityResponse>>(activityService.getUserActivities(userId), HttpStatus.OK);
    }

    @GetMapping("/{activityId}")
    //Fetch activity by Id
    public ResponseEntity<ActivityResponse> getUserActivityById(@PathVariable String activityId)
    {
        return new ResponseEntity<ActivityResponse>(activityService.getUserActivityById(activityId), HttpStatus.OK);
    }
}
