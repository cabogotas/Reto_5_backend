package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud4;

    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud4.findAll();
    }

    public Optional<Mensaje> getMensaje(int id){
        return crud4.findById(id);
    }

    public Mensaje save(Mensaje mensaje){
        return crud4.save(mensaje);
    }

    public void delete(Mensaje mensaje){
        crud4.delete(mensaje);
    }

}
