package com.essalud.sispoi.service.impl;

import com.essalud.sispoi.model.StrategicObjective;
import com.essalud.sispoi.repo.IStrategicObjectiveRepo;
import com.essalud.sispoi.repo._IGenericRepo;
import com.essalud.sispoi.service.IStrategicObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategicObjectiveServiceImpl extends _CRUDImpl<StrategicObjective, Integer> implements IStrategicObjectiveService{

    @Autowired
    private IStrategicObjectiveRepo repo;

    @Override
    protected _IGenericRepo<StrategicObjective, Integer> getRepo() {
        return repo;
    }

}