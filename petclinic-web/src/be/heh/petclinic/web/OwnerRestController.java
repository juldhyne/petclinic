package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;

@RestController
public class OwnerRestController {

	@Autowired
	private OwnerComponent ownerComponentImpl;
    
	@GetMapping("api/v1/owners")
	public ResponseEntity<Collection<Owner>> getOwners(){
	
		Collection<Owner> owners = ownerComponentImpl.getOwners();
		if(owners.isEmpty()){
			return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
	}

	@GetMapping("api/v1/owners/{id:[\\d]+}")
	public ResponseEntity<Owner> getOwners(@PathVariable int id ) throws EmptyResultDataAccessException {
        Owner  owner = ownerComponentImpl.getOwners(id);
		return new ResponseEntity<Owner>(owner,HttpStatus.FOUND);
	}

	@GetMapping("api/v1/owners/l/{lastname:[\\D]+}")
	public ResponseEntity<Collection<Owner>> getOwners(@PathVariable String lastname ){
		Collection<Owner> owner = ownerComponentImpl.getOwners(lastname);
		if(owner.isEmpty()){
			return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Owner>>(owner,HttpStatus.OK);
	}

	// @PostMapping("api/", method = RequestMethod.POST)
	// public ResponseEntity<Owner> getOwner(@RequestParam int id){
	
	// 	Owner owner = ownerComponentImpl.getOwner(id);
	// 	if(owners.isEmpty()){
	// 		return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
	// 	}
	// 	return new ResponseEntity<Owner>(owners,HttpStatus.OK);
	// }

}