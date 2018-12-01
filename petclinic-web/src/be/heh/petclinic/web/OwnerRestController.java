package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerRestController {

    @Autowired
    private OwnerComponent ownerComponentImpl;

    @GetMapping("api/v1/owners")
    public ResponseEntity<Owner[]> getOwners() {
        Owner[] owners = ownerComponentImpl.getOwners();
        return new ResponseEntity<Owner[]>(owners, HttpStatus.OK);
    }

    @GetMapping("api/v1/owners/{id:[\\d]+}")
    public ResponseEntity<Owner> getOwners(@PathVariable int id) throws EmptyResultDataAccessException {
        Owner owner = ownerComponentImpl.getOwners(id);
        return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }

    @GetMapping("api/v1/owners/l/{lastname:[\\D]+}")
    public ResponseEntity<Owner[]> getOwners(@PathVariable String lastname) {
        Owner[] owner = ownerComponentImpl.getOwners(lastname);
        return new ResponseEntity<Owner[]>(owner, HttpStatus.OK);
    }

    @PostMapping("api/v1/owners")
    public ResponseEntity<Owner> insertOwner(@RequestBody Owner owner) {
        ownerComponentImpl.insertOwner(owner);
        return new ResponseEntity<Owner>(owner, HttpStatus.CREATED);
    }

    @PutMapping("api/v1/owners/{id:[\\d]+}")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner, @PathVariable int id) {
        owner.setId(id);
        ownerComponentImpl.updateOwner(owner);
        return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }
}