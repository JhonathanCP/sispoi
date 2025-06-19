package com.essalud.sispoi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class OperationalActivity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperationalActivity;

    @Column(length = 16, nullable = false)
    private String sapCode;

    @Column(length = 70, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_strategic_action", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_STRATEGIC_ACTION"))
    private StrategicAction strategicAction;

    @ManyToOne
    @JoinColumn(name = "id_formulation", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_FORMULATION"))
    private Formulation formulation;

    @ManyToOne
    @JoinColumn(name = "id_financial_fund", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_FINANCIAL_FUND"))
    private FinancialFund financialFund;

    @ManyToOne
    @JoinColumn(name = "id_management_center", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_MANAGEMENT_CENTER"))
    private ManagementCenter managementCenter;

    @ManyToOne
    @JoinColumn(name = "id_cost_center", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_COST_CENTER"))
    private CostCenter costCenter;

    @ManyToOne
    @JoinColumn(name = "id_measurement", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_MEASUREMENT"))
    private Measurement measurement;

    @ManyToOne
    @JoinColumn(name = "id_priority", nullable = false, foreignKey = @ForeignKey(name = "FK_OPERATIONAL_ACTIVITY_PRIORITY"))
    private Priority priority;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

}
