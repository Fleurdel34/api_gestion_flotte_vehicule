package fr.studi.transport.service;

import fr.studi.transport.pojo.Vehicule;
import fr.studi.transport.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules(){
        return vehiculeRepository.findAll();

    }

    public Vehicule getVehiculeById(Long id){
        return vehiculeRepository.findById(id).stream()
                .filter(vehicule -> vehicule.getVehiculeId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Vehicule createVehicule(Vehicule vehicule){
        if(vehiculeRepository.existsById(vehicule.getVehiculeId())){
            return null;
        }else{
            return vehiculeRepository.save(vehicule);
        }
    }

    public void deleteVehiculeById(Long id){
        vehiculeRepository.deleteById(id);
    }

}
