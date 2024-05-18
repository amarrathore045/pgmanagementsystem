package com.pg.app.exceptions;

public class BuildingIdNotFoundException extends Exception{
    public BuildingIdNotFoundException (String errorMessage){
        super(errorMessage);
    }
}
