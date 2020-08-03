package driving.school.controller;

import com.fasterxml.jackson.annotation.JsonView;
import driving.school.model.RideDate;
import driving.school.model.Views;
import driving.school.services.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RideTeacherController {
    RideService rideService;

    public RideTeacherController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/ride/teacher/{teacherId}")
    @JsonView(Views.UserView.class)
    @ResponseStatus(HttpStatus.OK)
    public List<RideDate> getAllRideByTeacher(@PathVariable String teacherId) {
        return rideService.getAllRideByTeacherId(teacherId);
    }

}
