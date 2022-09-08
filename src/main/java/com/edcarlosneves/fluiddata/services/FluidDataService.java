package com.edcarlosneves.fluiddata.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edcarlosneves.fluiddata.models.FluidDataModel;
import com.edcarlosneves.fluiddata.repositories.FluidDataRepository;

@Service
public class FluidDataService {
    final FluidDataRepository fluidDataRepository;

    public FluidDataService(FluidDataRepository fluidDataRepository) {
        this.fluidDataRepository = fluidDataRepository;
    }

    @Transactional
    public FluidDataModel save(FluidDataModel fluidDataModel) {
        return fluidDataRepository.save(fluidDataModel);
    }

    public Page<FluidDataModel> findAll(Pageable pageable) {
        return fluidDataRepository.findAll(pageable);

    }

    public Optional<FluidDataModel> findById(UUID id) {
        return fluidDataRepository.findById(id);
    }

}
