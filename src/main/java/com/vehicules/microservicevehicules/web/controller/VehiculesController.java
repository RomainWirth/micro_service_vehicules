package com.vehicules.microservicevehicules.web.controller;

import com.vehicules.microservicevehicules.model.Vehicule;
import com.vehicules.microservicevehicules.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/vehicules")

@RestController
public class VehiculesController {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @GetMapping
    public ArrayList<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Vehicule displayOneVehicule(@PathVariable int id) {
        return vehiculeRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody Vehicule addNewVehicule (@RequestBody Vehicule newVehicule) {
        return vehiculeRepository.save(newVehicule);
    }

    @PutMapping("/{id}")
    public @ResponseBody Vehicule updateVehicule(@PathVariable int id, @RequestBody Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @DeleteMapping("/id")
    public Vehicule deleteVehicule(@PathVariable int id) {
        return vehiculeRepository.deleteById(id);
    }

}
