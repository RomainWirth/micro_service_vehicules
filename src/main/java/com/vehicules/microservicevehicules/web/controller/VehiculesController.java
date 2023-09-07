package com.vehicules.microservicevehicules.web.controller;

import com.vehicules.microservicevehicules.model.Vehicule;
import com.vehicules.microservicevehicules.repository.VehiculeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

//import java.net.URI;
//import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/vehicules")

@Api("API pour les opérations CRUD sur les véhicules")
@RestController
public class VehiculesController {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @ApiOperation("Méthode pour récupérer tous les véhicules")
    @GetMapping
    public ArrayList<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @ApiOperation("Méthode pour récupérer un seul véhicule selon son id")
    @GetMapping("/{id}")
    public @ResponseBody Vehicule displayOneVehicule(@PathVariable int id) {
        return vehiculeRepository.findById(id);
    }

    @ApiOperation("Méthode pour ajouter un nouveau véhicule")
    @PostMapping
    public @ResponseBody Vehicule addNewVehicule (@RequestBody Vehicule newVehicule) {
        return vehiculeRepository.save(newVehicule);
    }

    @PostMapping("/all")
    public @ResponseBody List<Vehicule> addMultipleVehicules (@RequestBody List<Vehicule> vehicules) {
        for (Vehicule vehicule: vehicules) {
            vehiculeRepository.save(vehicule);
        }
        return vehicules;
    }

    @ApiOperation("Méthode pour modifier un véhicule")
    @PutMapping("/{id}")
    public @ResponseBody Vehicule updateVehicule(@PathVariable int id, @RequestBody Vehicule vehicule) {
        vehicule.setId(id);
        return vehiculeRepository.save(vehicule);
    }

    @ApiOperation("Méthode pour supprimer un véhicule de la DB")
    @DeleteMapping("/{id}")
    public Vehicule deleteVehicule(@PathVariable int id) {
        return vehiculeRepository.deleteById(id);
    }

    @PostMapping("/available")
    public List<Vehicule> findAvailableVehicules(@RequestBody List<Integer> reservedVehiculesIds) {
//        List<Vehicule> vehicules = new ArrayList<>();
//        for (int reservedVehiculeId: reservedVehiculesIds) {
//            for (Vehicule vehicule: vehiculeRepository.findAll()) {
//                if (reservedVehiculeId != vehicule.getId()) {
//                    vehicules.add(vehicule);
//                }
//            }
//        }
//        return vehicules;
        return vehiculeRepository.getAvailableVehicules(reservedVehiculesIds);
    }



}
