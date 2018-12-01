package be.heh.petclinic.web;

import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VetRestController {

    @Autowired
    private VetComponent vetComponentImpl;

    @GetMapping("api/v1/vets")
    public ResponseEntity<Vet[]> getVets() {

        Vet[] vets = vetComponentImpl.getVets();
        if (vets.length == 0) {
            return new ResponseEntity<Vet[]>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vet[]>(vets, HttpStatus.OK);
    }
    //	Todo
    // 	Make range request ?
}