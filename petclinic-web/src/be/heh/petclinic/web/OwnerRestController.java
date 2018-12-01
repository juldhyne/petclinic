package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;

@RestController
public class OwnerRestController {

	@Autowired
	private OwnerComponent ownerComponentImpl;
    
	@GetMapping("api/v1/owners")
	public ResponseEntity<Owner[]> getOwners(){
		Owner[] owners = ownerComponentImpl.getOwners();
		return new ResponseEntity<Owner[]>(owners,HttpStatus.FOUND);
	}

	@GetMapping("api/v1/owners/{id:[\\d]+}")
	public ResponseEntity<Owner> getOwners(@PathVariable int id ) throws EmptyResultDataAccessException {
        Owner  owner = ownerComponentImpl.getOwners(id);
		return new ResponseEntity<Owner>(owner,HttpStatus.FOUND);
	}

	@GetMapping("api/v1/owners/l/{lastname:[\\D]+}")
	public ResponseEntity<Owner[]> getOwners(@PathVariable String lastname ){
		Owner[] owner = ownerComponentImpl.getOwners(lastname);
		return new ResponseEntity<Owner[]>(owner,HttpStatus.OK);
	}

}