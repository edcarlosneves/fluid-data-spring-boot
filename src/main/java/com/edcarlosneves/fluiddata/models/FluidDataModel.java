package com.edcarlosneves.fluiddata.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FLUID_DATA")
public class FluidDataModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String FluidName;

    @Column(nullable = false)
    private float fluidTemperature;

    @Column(nullable = false)
    private float fluidPressure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFluidName() {
        return FluidName;
    }

    public void setFluidName(String fluidName) {
        FluidName = fluidName;
    }

    public float getFluidTemperature() {
        return fluidTemperature;
    }

    public void setFluidTemperature(float fluidTemperature) {
        this.fluidTemperature = fluidTemperature;
    }

    public float getFluidPressure() {
        return fluidPressure;
    }

    public void setFluidPressure(float fluidPressure) {
        this.fluidPressure = fluidPressure;
    }

}
