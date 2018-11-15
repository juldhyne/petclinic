package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;

import java.util.List;
import java.util.Collection;

@RestController
public class OwnerRestController {

	@Autowired
	private OwnerComponent ownerComponentImpl;
    
	//@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping("api/v1/owners")
	public ResponseEntity<Collection<Owner>> getOwners(){
	
		Collection<Owner> owners = ownerComponentImpl.getOwners();
		if(owners.isEmpty()){
			return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
	}

	@GetMapping("api/v1/owner/{id:[\\d]+}")
	public ResponseEntity<Owner> getOwner(@PathVariable int id ){
		Owner owner = ownerComponentImpl.getOwner(id);
		if(owner == null){
			return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Owner>(owner,HttpStatus.OK);
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