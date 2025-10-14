package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int plan_id;
    private Date start_date;
    private Date end_date;
    @Enumerated(EnumType.STRING)
    private Status statut;
    private Date created_at;

    public Subscription() {

    }

    public Subscription(Status statut, int id, int user_id, int plan_id, Date start_date, Date end_date, Date created_at) {
        this.statut = statut;
        this.id = id;
        this.user_id = user_id;
        this.plan_id = plan_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    @OneToMany(mappedBy = "subscription")
    private List<Plan> plans =new ArrayList<Plan>();

}
