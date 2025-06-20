package com.essalud.sispoi.service.impl;

import com.essalud.sispoi.model.OperationalActivityBudgetItem;
import com.essalud.sispoi.model.OperationalActivityBudgetItemPK;
import com.essalud.sispoi.repo.IOperationalActivityBudgetItemRepo;
import com.essalud.sispoi.repo._IGenericRepo;
import com.essalud.sispoi.service.IOperationalActivityBudgetItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationalActivityBudgetItemServiceImpl extends _CRUDImpl<OperationalActivityBudgetItem, OperationalActivityBudgetItemPK> implements IOperationalActivityBudgetItemService{

    @Autowired
    private IOperationalActivityBudgetItemRepo repo;

    @Override
    protected _IGenericRepo<OperationalActivityBudgetItem, OperationalActivityBudgetItemPK> getRepo() {
        return repo;
    }

}