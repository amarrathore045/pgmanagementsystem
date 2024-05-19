package com.pg.app.services;

import com.pg.app.entity.Building;
import com.pg.app.exceptions.BuildingIdNotFoundException;
import com.pg.app.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
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
    public Optional<Building> getBuilding(String buildingId) throws BuildingIdNotFoundException {
        Optional<Building> building;
        building = Optional.ofNullable(buildingRepo.findById(buildingId)
                .orElseThrow(() -> new BuildingIdNotFoundException("Id not found")));

        return building;
    }

    @Override
    public void deleteBuilding(String buildingId) {
        buildingRepo.deleteById(buildingId);
    }
}
