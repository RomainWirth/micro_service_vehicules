package com.vehicules.microservicevehicules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vehicules.microservicevehicules.model.Vehicule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
    ArrayList<Vehicule> findAll();
    Vehicule findById(int id);
    Vehicule deleteById(int id);
    Vehicule save(Vehicule vehicule);
}
