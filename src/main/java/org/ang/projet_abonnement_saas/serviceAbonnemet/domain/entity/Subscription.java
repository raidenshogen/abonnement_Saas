package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private LocalDate start_date;
    private LocalDate end_date;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status statut;
    private LocalDate created_at;

    public Subscription() {

    }

    public Subscription(String userId,LocalDate start_date, LocalDate end_date,Plan p) {
        this.statut = Status.active;
        this.userId = userId;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_at = LocalDate.now();
        this.plan = p;
    }

    @OneToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

}
