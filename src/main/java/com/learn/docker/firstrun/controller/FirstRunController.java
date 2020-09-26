package com.learn.docker.firstrun.controller;

import com.google.gson.Gson;
import com.learn.docker.firstrun.model.Person;
import com.learn.docker.firstrun.service.FirstRunService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstRunController {

    private final FirstRunService firstRunService;
    private final Gson gson;

    public FirstRunController(FirstRunService firstRunService) {
        this.firstRunService = firstRunService;
        this.gson = new Gson();
    }

    @GetMapping("/getPersonDetails")
    public ResponseEntity<String> getPersonDetails(@RequestParam(value = "id") String id) {
        String person = gson.toJson(this.firstRunService.getPersonDetails(id));
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/storePersonDetails")
    public ResponseEntity<String> storePersonDetails(@RequestBody Person person) {
        return ResponseEntity.ok().body(this.firstRunService.storePersonDetails(person));
    }
}
