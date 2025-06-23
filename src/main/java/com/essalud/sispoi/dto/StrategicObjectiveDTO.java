package com.essalud.sispoi.dto;

import java.time.LocalDateTime;

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
public class StrategicObjectiveDTO {

    @EqualsAndHashCode.Include
    private Integer idStrategicObjective;

    @NotNull
    @Size(max = 70)
    private String name;

    private StrategicObjectiveFileDTO strategicObjectiveFile;

    @NotNull
    private StrategicObjectiveDTO strategicObjective;
    
    private Boolean active = true;

    private LocalDateTime createTime;

}
