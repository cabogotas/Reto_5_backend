package com.co.reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Crear tabla

@Entity
@Table(name = "reservations")
public class Reservaciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";

    //Crear relaciones

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;

    private String score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public String getScore() {
        return score;
    }

    public Cliente getClient() {
        return client;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
