package com.pg.app.repo;

import com.pg.app.entity.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepo extends MongoRepository<Building,String> {
}
