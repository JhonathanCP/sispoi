package com.essalud.sispoi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Priority {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPriority;

    @Column(length = 70, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;
    
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

}
