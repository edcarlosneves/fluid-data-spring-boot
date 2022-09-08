package com.edcarlosneves.fluiddata.controllers;

import java.util.concurrent.Flow.Publisher;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edcarlosneves.fluiddata.dtos.FluidDataDto;
import com.edcarlosneves.fluiddata.models.FluidDataModel;
import com.edcarlosneves.fluiddata.services.FluidDataService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/fluid-data")
public class FluidDataController {
    final FluidDataService fluidDataService;

    public FluidDataController(FluidDataService fluidDataService) {
        this.fluidDataService = fluidDataService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFluidData(@RequestBody @Valid FluidDataDto fluidDataDto) {
        var fluidDataModel = new FluidDataModel();
        BeanUtils.copyProperties(fluidDataDto, fluidDataModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fluidDataService.save(fluidDataModel));
    }

    @RequestMapping
    public ResponseEntity<Page<FluidDataModel>> getAllFluidData(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(fluidDataService.findAll(pageable));
    }

}
