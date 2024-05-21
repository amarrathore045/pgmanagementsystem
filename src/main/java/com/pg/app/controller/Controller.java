package com.pg.app.controller;

import com.pg.app.entity.Building;
import com.pg.app.exceptions.BuildingIdNotFoundException;
import com.pg.app.services.BuildingServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Slf4j
@RestController
@RequestMapping ("/api/v1")
public class Controller {
    @Autowired
    BuildingServicesImpl service;

    @GetMapping("/hello")
    public String hello() {
        return ("Hello there");
    }

    @GetMapping("/building/{buildingId}")
    public Optional<Building> getBuilding(@PathVariable String buildingId) throws BuildingIdNotFoundException {
        return service.getBuilding(buildingId);
    }

    @PostMapping("/building")
    @ResponseStatus(HttpStatus.CREATED)
    public Building saveBuilding(@RequestBody Building building){
        return service.saveBuilding(building);
    }
    @PutMapping("/building")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Building> updateBuilding(@RequestBody Building building) throws BuildingIdNotFoundException {
        log.info(String.valueOf(building));
        return service.updateBuilding(building);
    }
}
