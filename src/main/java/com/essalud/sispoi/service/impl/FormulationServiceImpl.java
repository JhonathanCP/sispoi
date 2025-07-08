package com.essalud.sispoi.service.impl;

import com.essalud.sispoi.model.Dependency;
import com.essalud.sispoi.model.Formulation;
import com.essalud.sispoi.repo.IFormulationRepo;
import com.essalud.sispoi.repo._IGenericRepo;
import com.essalud.sispoi.service.IFormulationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormulationServiceImpl extends _CRUDImpl<Formulation, Integer> implements IFormulationService{

    @Autowired
    private IFormulationRepo repo;

    @Override
    protected _IGenericRepo<Formulation, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Formulation> findByDependencyAndYear(Dependency dependency, Integer year) {
        return repo.findByDependencyAndYear(dependency, year);
    }

}