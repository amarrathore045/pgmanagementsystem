package com.pg.app.services;

import com.pg.app.entity.Building;
import com.pg.app.exceptions.BuildingIdNotFoundException;
import com.pg.app.repo.BuildingRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Slf4j
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
    public Optional<Building> updateBuilding(Building building) throws BuildingIdNotFoundException {
        String buildingId = building.getBuildingID();
        Optional<Building> buildingObj = Optional.ofNullable(buildingRepo.findById(buildingId)
                .orElseThrow(() -> new BuildingIdNotFoundException("Id not found")));
        Building updatedBuilding = new Building(building.getBuildingID(),building.getBuildingName(),
                building.getNumberOfFloors(),building.getRoomType(),building.getAvailableRooms(),
                building.getBookedRooms());
//        updatedBuilding.setBuildingID(building.getBuildingID());
//        updatedBuilding.setBuildingName(building.getBuildingName());
//        updatedBuilding.setAvailableRooms(building.getAvailableRooms());
//        updatedBuilding.setRoomType(building.getRoomType());
//        updatedBuilding.setBookedRooms(building.getBookedRooms());
//        updatedBuilding.setNumberOfFloors(building.getNumberOfFloors());
        buildingRepo.save(updatedBuilding);

        return Optional.of(updatedBuilding);
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
