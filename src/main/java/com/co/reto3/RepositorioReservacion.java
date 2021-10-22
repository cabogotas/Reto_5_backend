package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioReservacion {

    @Autowired
    private InterfaceReservacion crud5;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud5.findAll();
    }

    public Optional<Reservaciones> getReservation(int id){
        return crud5.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){
        return crud5.save(reservation);
    }

    public void delete(Reservaciones reservation){
        crud5.delete(reservation);
    }

}
