package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCliente {

    @Autowired
    private InterfaceCliente crud3;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud3.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return crud3.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud3.save(cliente);
    }

    public void delete(Cliente cliente){
        crud3.delete(cliente);
    }

}
