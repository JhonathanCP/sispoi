package com.essalud.sispoi.repo;

import java.util.List;

import com.essalud.sispoi.model.OperationalActivityBudgetItem;
import com.essalud.sispoi.model.OperationalActivityBudgetItemPK;


public interface IOperationalActivityBudgetItemRepo extends _IGenericRepo<OperationalActivityBudgetItem, OperationalActivityBudgetItemPK>{

    List<OperationalActivityBudgetItem> findByOperationalActivity_IdOperationalActivity(Integer idOperationalActivity);

    void deleteByOperationalActivity_IdOperationalActivity(Integer idOperationalActivity);

    OperationalActivityBudgetItem findByOperationalActivity_IdOperationalActivityAndBudgetItem_IdBudgetItem(Integer idOperationalActivity, Integer idBudgetItem);

    void deleteByOperationalActivity_IdOperationalActivityAndBudgetItem_IdBudgetItem(Integer idOperationalActivity, Integer idBudgetItem);

}