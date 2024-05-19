package com.pg.app.services;

import com.pg.app.entity.Building;
import com.pg.app.exceptions.BuildingIdNotFoundException;

import java.util.Optional;

public interface BuildingServices {
    public Building saveBuilding(Building building);
    public Building updateBuilding(Building building);
    public Optional<Building> getBuilding(String buildingId) throws BuildingIdNotFoundException;
    public void deleteBuilding(String buildingId);
}
