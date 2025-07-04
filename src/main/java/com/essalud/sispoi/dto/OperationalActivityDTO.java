package com.essalud.sispoi.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
public class OperationalActivityDTO {

    @EqualsAndHashCode.Include
    private Integer idOperationalActivity;

    @NotNull
    @Size(max = 16)
    private String sapCode;

    @NotNull
    @Size(max = 500)
    private String name;
    
    private Boolean active = true;

    @NotNull
    private StrategicActionDTO strategicAction;

    @NotNull
    private FormulationDTO formulation;

    @NotNull
    private FinancialFundDTO financialFund;

    @NotNull
    private ManagementCenterDTO managementCenter;

    @NotNull
    private CostCenterDTO costCenter;

    @NotNull
    private MeasurementTypeDTO measurementType;

    @NotNull
    @Size(max = 250)
    private String measurementUnit;

    private Float executedGoal;

    private Float expectedGoal;

    @JsonManagedReference
    private List<GoalDTO> goals;

    @NotNull
    private PriorityDTO priority;

    private LocalDateTime createTime;

}
