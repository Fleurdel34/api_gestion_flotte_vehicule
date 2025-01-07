package fr.studi.transport.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value= ApiRegistration.API + ApiRegistration.REST_VEHICULE)
public class VehiculeController {

    /**
     *
     * @return
     */

    @GetMapping
    public String getAllVehicules(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    public String getVehiculeById(){

    }
}
