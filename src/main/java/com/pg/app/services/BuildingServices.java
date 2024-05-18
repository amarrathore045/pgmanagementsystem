package com.pg.app.services;

import com.pg.app.entity.Building;
import com.pg.app.exceptions.BuildingIdNotFoundException;

import java.util.Optional;

public interface BuildingServices {
    public Building saveBuilding(Building building);
    public Building updateBuilding(Building building);
    public Optional<Building> getBuilding(int buildingId) throws BuildingIdNotFoundException;
    public void deleteBuilding(int buildingId);
}
