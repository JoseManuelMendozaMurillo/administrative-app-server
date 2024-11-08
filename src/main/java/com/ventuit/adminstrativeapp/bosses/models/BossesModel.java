package com.ventuit.adminstrativeapp.bosses.models;

import java.sql.Date;
import java.util.Set;

import com.ventuit.adminstrativeapp.core.models.BaseModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "bosses")
public class BossesModel extends BaseModel {

    @Column(nullable = false, unique = true)
    private String keycloakUserId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = true)
    private String surname;

    @Column(length = 30, nullable = true, unique = true)
    private String phone;

    @Column(nullable = true)
    private Date birthdate;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private Set<BossesBusinessesModel> bossesBusinesses;

}
