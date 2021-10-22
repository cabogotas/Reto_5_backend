package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCliente {

    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId){
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        } else {
            Optional<Cliente> evt=metodosCrud.getCliente(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> evt=metodosCrud.getCliente(client.getIdClient());
            if(evt.isPresent()){
                if(client.getName()!=null){
                    evt.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evt.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else{
                return client;
            }
        } else{
            return client;
        }
    }

    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
