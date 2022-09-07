package com.edcarlosneves.fluiddata.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edcarlosneves.fluiddata.models.FluidDataModel;

public interface FluidDataRepository extends JpaRepository<FluidDataModel, UUID> {

}
