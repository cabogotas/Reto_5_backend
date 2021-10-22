package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorBoat {

    @Autowired
    private ServiciosBoat servicios;
    @GetMapping("/all")
    public List<Boat> getBoats(){
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int idBoat){
        return servicios.getBoat(idBoat);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat){
        return servicios.save(boat);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat) {
        return servicios.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boatId) {
        return servicios.deleteBoat(boatId);
    }
}
