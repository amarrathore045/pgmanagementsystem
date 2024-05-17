package com.pg.app.services;

import com.pg.app.entity.Building;
import com.pg.app.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BuildingServicesImpl implements BuildingServices{
    @Autowired
    BuildingRepo buildingRepo;

    @Override
    public Building saveBuilding(Building building) {
        String buildingId = UUID.randomUUID().toString().split("-")[0];
        building.setBuildingID(buildingId);
        buildingRepo.save(building);
        return building;
    }

    @Override
    public Building updateBuilding(Building building) {
        return null;
    }

    @Override
    public Building getBuilding(int buildingId) {
        return null;
    }

    @Override
    public void deleteBuilding(int buildingId) {

    }
}
