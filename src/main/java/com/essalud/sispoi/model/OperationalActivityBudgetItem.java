package com.essalud.sispoi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private MonthEnum month;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

}