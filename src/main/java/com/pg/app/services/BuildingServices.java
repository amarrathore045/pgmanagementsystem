package com.pg.app.services;

import com.pg.app.entity.Building;

public interface BuildingServices {
    public Building saveBuilding(Building building);
    public Building updateBuilding(Building building);
    public Building getBuilding(int buildingId);
    public void deleteBuilding(int buildingId);
}
