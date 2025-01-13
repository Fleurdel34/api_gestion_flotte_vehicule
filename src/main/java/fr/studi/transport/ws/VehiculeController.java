package fr.studi.transport.ws;

import fr.studi.transport.pojo.Vehicule;
import fr.studi.transport.service.VehiculeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return vehiculeService.getVehiculeId(id);
    }
}
