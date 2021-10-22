package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosBoat {

    @Autowired
    private RepositorioBoat metodosCrud;
    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBoat(int idBoat){
        return metodosCrud.getBoat(idBoat);
    }

    public Boat save(Boat boat){
        if(boat.getId()==null){
            return metodosCrud.save(boat);
        } else {
            Optional<Boat> evt=metodosCrud.getBoat(boat.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(boat);
            } else {
                return boat;
            }
        }
    }

    public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> evt=metodosCrud.getBoat(boat.getId());
            if(evt.isPresent()){
                if(boat.getName()!=null){
                    evt.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    evt.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    evt.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    evt.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    evt.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else{
                return boat;
            }
        } else {
            return boat;
        }
    }

    public boolean deleteBoat(int boatId){
        Boolean aBoolean = getBoat(boatId).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
