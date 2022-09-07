package com.edcarlosneves.fluiddata.dtos;

import javax.validation.constraints.NotBlank;

public class FluidDataDto {

    @NotBlank
    private String FluidName;

    private float fluidTemperature;

    private float fluidPressure;

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
