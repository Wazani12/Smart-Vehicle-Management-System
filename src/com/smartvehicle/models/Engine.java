package com.smartvehicle.models;

import com.smartvehicle.enums.EngineType;

public class Engine {
    private int horsepower;
    private EngineType type;
    private boolean healthy;

    public Engine(int horsepower, EngineType type) {
        this.horsepower = horsepower;
        this.type = type;
        this.healthy = true;
    }

    public int getHorsepower() { return horsepower; }
    public EngineType getType() { return type; }
    public boolean isHealthy() { return healthy; }
    public void setHealthy(boolean healthy) { this.healthy = healthy; }
}
