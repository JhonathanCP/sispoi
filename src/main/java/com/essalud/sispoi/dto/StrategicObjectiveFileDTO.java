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
public class StrategicObjectiveFileDTO {

    @EqualsAndHashCode.Include
    private Integer idStrategicObjectiveFile;

    @NotNull
    @Size(max = 70)
    private String name;

    @Size(max = 15)
    private String fileExtension;

    private Boolean active = true;

    private LocalDateTime createTime;

    private byte[] file;

}
