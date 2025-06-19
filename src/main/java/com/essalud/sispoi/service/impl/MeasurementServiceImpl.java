package com.essalud.sispoi.service.impl;

import com.essalud.sispoi.model.Measurement;
import com.essalud.sispoi.repo.IMeasurementRepo;
import com.essalud.sispoi.repo._IGenericRepo;
import com.essalud.sispoi.service.IMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementServiceImpl extends _CRUDImpl<Measurement, Integer> implements IMeasurementService{

    @Autowired
    private IMeasurementRepo repo;

    @Override
    protected _IGenericRepo<Measurement, Integer> getRepo() {
        return repo;
    }

}