package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int subscription_id;
    private int feature_id;
    private int used_value;
    private LocalDate recorded_at;
    public Usage() {

    }
    public Usage(int subscription_id, int id, int feature_id, int used_value, LocalDate recorded_at) {
        this.subscription_id = subscription_id;
        this.id = id;
        this.feature_id = feature_id;
        this.used_value = used_value;
        this.recorded_at = recorded_at;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    public int getUsed_value() {
        return used_value;
    }

    public void setUsed_value(int used_value) {
        this.used_value = used_value;
    }

    public LocalDate getRecorded_at() {
        return recorded_at;
    }

    public void setRecorded_at(LocalDate recorded_at) {
        this.recorded_at = recorded_at;
    }
    @OneToOne
    @JoinColumn(name="usage_id")
    private Feature feature;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
