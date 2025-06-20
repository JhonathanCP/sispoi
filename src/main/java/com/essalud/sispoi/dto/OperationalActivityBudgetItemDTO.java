package com.essalud.sispoi.dto;

import java.time.LocalDateTime;

import com.essalud.sispoi.model.enums.MonthEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
public class OperationalActivityBudgetItemDTO {

    @NotNull
    private OperationalActivityDTO operationalActivity;

    @NotNull
    private BudgetItemDTO budgetItem;

    private Double amount;

    private MonthEnum month;

    private LocalDateTime createTime;

}
