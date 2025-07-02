package com.essalud.sispoi.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import com.essalud.sispoi.model.enums.MonthEnum;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(OperationalActivityBudgetItemPK.class)
public class OperationalActivityBudgetItem {

    @Id
    private OperationalActivity operationalActivity;

    @Id
    private BudgetItem budgetItem;

    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private LocalDateTime createTime;

    // @Column(nullable = false)
    // private Double amount;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false, length = 16)
    // private MonthEnum month;

    @ElementCollection
    @CollectionTable(
        name = "operational_activity_budget_item_month_amount",
        joinColumns = {
            @jakarta.persistence.JoinColumn(name = "id_operational_activity", referencedColumnName = "id_operational_activity"),
            @jakarta.persistence.JoinColumn(name = "id_budget_item", referencedColumnName = "id_budget_item")
        }
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "month")
    @Column(name = "amount")
    private Map<MonthEnum, Double> monthAmounts = new EnumMap<>(MonthEnum.class);

    @ManyToOne
    @JoinColumn (name = "id_expense_type", referencedColumnName = "idExpenseType", nullable = false)
    private ExpenseType expenseType;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

}