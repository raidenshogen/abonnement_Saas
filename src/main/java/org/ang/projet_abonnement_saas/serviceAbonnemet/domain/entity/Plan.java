package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private plans plan;
    private String description;
    private BigDecimal price;
    private Date duration;

    private boolean is_active;

    public Plan() {

    }
    public Plan(plans plan, int id, String description, BigDecimal price, Date duration, boolean is_active) {
        this.plan = plan;
        this.id = id;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.is_active = is_active;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public plans getPlan() {
        return plan;
    }

    public void setPlan(plans plan) {
        this.plan = plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @ManyToMany(mappedBy = "plans")
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
    @ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="subscription_id")
    private Subscription subscription;

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
