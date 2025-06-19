package com.essalud.sispoi.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OperationalActivityBudgetItemPK implements Serializable{

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "id_budget_item")
    private BudgetItem budgetItem;


    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "id_operational_activity")
    private OperationalActivity operationalActivity;

}
