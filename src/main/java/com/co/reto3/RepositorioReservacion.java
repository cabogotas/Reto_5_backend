package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservaciones> ReservacionStatusRepositorio (String status){
        return crud5.findAllByStatus(status);
    }

    public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
        return crud5.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud5.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }

}
