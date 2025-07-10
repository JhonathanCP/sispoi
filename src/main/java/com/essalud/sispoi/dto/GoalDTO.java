package com.essalud.sispoi.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GoalDTO {

    @EqualsAndHashCode.Include
    private Integer idGoal;

    private Boolean active = true;

    @JsonBackReference
    @NotNull
    private OperationalActivityDTO operationalActivity;

    @Min(1)
    @Max(4)
    @NotNull
    private Integer goalOrder;

    @NotNull
    private Double value;

    private LocalDateTime createTime;

}
