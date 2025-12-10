package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private plans plan;
    private String description;
    private BigDecimal price;


    public Plan() {

    }
    public Plan(plans plan, int id, String description, BigDecimal price) {
        this.plan = plan;
        this.id = id;
        this.description = description;
        this.price = price;
    }



    @OneToMany(mappedBy = "plan")
    private List<Feature> features;


    @OneToOne(mappedBy = "plan", fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private Subscription sub;


    }
