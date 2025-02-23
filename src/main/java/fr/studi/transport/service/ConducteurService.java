package fr.studi.transport.service;

import fr.studi.transport.pojo.Conducteur;

import fr.studi.transport.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    public List<Conducteur> getAllConducteurs(){
        return conducteurRepository.findAll();

    }

    public Conducteur getConducteurId(Long id){
        return conducteurRepository.findById(id).stream()
                .filter(conducteur -> conducteur.getConducteurId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Conducteur createConducteur(Conducteur conducteur){
        conducteur.setConducteurId(counter.getAndIncrement()); // id=1, le suivant aura 2
        conducteurList.add(conducteur);
        return conducteur;
    }

    public void deleteConducteurById(Long id){
        conducteurList.removeIf(conducteur -> conducteur.getConducteurId().equals(id));
    }


}
