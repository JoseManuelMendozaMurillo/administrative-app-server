package com.ventuit.adminstrativeapp.businesses.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.Check;

import com.ventuit.adminstrativeapp.core.models.ExtendedBaseModel;
import com.ventuit.adminstrativeapp.utils.RegexUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "businesses")
@Check(name = "businesses_rfc_ck_01", constraints = "CHAR_LENGTH(rfc) IN (12, 13)") // Check constraint for RFC length
public class BusinessesModel extends ExtendedBaseModel {
    // TODO: Check relationships of this table

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = true)
    private String description;

    @Column(length = 13, nullable = false, unique = true)
    @Size(min = 12, max = 13, message = "RFC must be 12 or 13 characters long")
    @Pattern(regexp = RegexUtils.RFC_PATTERN, message = "Invalid RFC format")
    private String rfc;

    @Column()
    private LocalDate establishmentDate;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean active;

    @Column(nullable = true)
    private Integer activeChangedBy;

    @Column(nullable = true)
    private LocalDateTime activeChangedAt;

    @OneToOne()
    @JoinColumn(name = "industry_id", nullable = false)
    private IndustriesModel industry;

    @OneToOne()
    @JoinColumn(name = "business_type_id", nullable = false)
    private BusinessesTypeModel businessesType;

    @OneToOne()
    @JoinColumn(name = "tax_regimen_id", nullable = false)
    private TypesRegimensTaxesModel taxRegimen;

}