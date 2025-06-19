package com.essalud.sispoi.service.impl;

import com.essalud.sispoi.model.OperationalActivity;
import com.essalud.sispoi.repo.IOperationalActivityRepo;
import com.essalud.sispoi.repo._IGenericRepo;
import com.essalud.sispoi.service.IOperationalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationalActivityServiceImpl extends _CRUDImpl<OperationalActivity, Integer> implements IOperationalActivityService{

    @Autowired
    private IOperationalActivityRepo repo;

    @Override
    protected _IGenericRepo<OperationalActivity, Integer> getRepo() {
        return repo;
    }

}