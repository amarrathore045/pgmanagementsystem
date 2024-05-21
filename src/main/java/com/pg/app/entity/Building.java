package com.pg.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buildings")
@Data
@AllArgsConstructor
public class Building {
    @Id
    private String buildingID;
    private String buildingName;
    private int numberOfFloors;
    private String roomType;
    private int availableRooms;
    private int bookedRooms;
}
