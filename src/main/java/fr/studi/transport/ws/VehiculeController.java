package fr.studi.transport.ws;

import fr.studi.transport.pojo.Vehicule;
import fr.studi.transport.service.VehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value= ApiRegistration.API + ApiRegistration.REST_VEHICULE)
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    /**
     * return all cars
     * @return list of cars
     */

    @GetMapping
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.getAllVehicules();
    }


    /**
     * return only car
     * @return one car
     */

    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id){
        return vehiculeService.getVehiculeById(id);
    }

    @PostMapping
    public Vehicule createVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.createVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculeById(@PathVariable Long id){
        vehiculeService.deleteVehiculeById(id);
    }

    @GetMapping(ApiRegistration.REST_IMMATRICULATION + "/{immatriculation}")
    public Vehicule getVoitureByImmatriculation(@PathVariable String immatriculation){
       return vehiculeService.getVehiculeByImmatriculation(immatriculation);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehiculeById(@PathVariable ("id") Long id, @RequestBody Vehicule vehicule){
        return vehiculeService.updateVehiculeById(id, vehicule);
    }

}
