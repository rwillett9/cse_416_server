package com.example.sparks.controller;

import javax.servlet.http.HttpSession;

import com.example.sparks.Entities.DistrictPlan;
import com.example.sparks.Entities.State;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/district") // This means URL's start with /demo (after Application path)
@CrossOrigin
public class DistrictController {
    // @Autowired // This means to get the bean called userRepository
    //      // Which is auto-generated by Spring, we will use it to handle the data
    // private StateRepository stateRepository;
    
    @Autowired
    HttpSession httpSession;

    // @TODO: test this
    @GetMapping(path = "/test")
    public State districtControllerTest() {
        State state = (State) httpSession.getAttribute("state");
        
        return state;
    }

    // @TODO: test this
    @PostMapping(path = "/add-test-plan")
    public String addTestDistrictPlan() {
        DistrictPlan plan1 = new DistrictPlan();
        plan1.setCompactness(.3);
        plan1.setEfficiencyGap(.6);

        DistrictPlan plan2 = new DistrictPlan();
        plan2.setCompactness(.7);
        plan2.setEfficiencyGap(.1);

        return "added";
    }
}