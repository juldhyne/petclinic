package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Pet;


@RestController
public class PetRestController {

	@Autowired
	private PetComponent petComponentImpl;
	
	@GetMapping("api/v1/pets")
	public ResponseEntity<Collection<Pet>> getPets(){
		Collection<Pet> pets = petComponentImpl.getPets();
		if(pets.isEmpty()){
			return new ResponseEntity<Collection<Pet>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Pet>>(pets,HttpStatus.OK);
	}

	@GetMapping("api/v1/pets/{id:[\\d]+}")
	public ResponseEntity<Pet> getPets(@PathVariable int id){
		Pet pet = petComponentImpl.getPets(id);
		if(pet == null){
			return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pet>(pet,HttpStatus.OK);
	}

	@GetMapping("api/v1/pets/{type:[\\D]+}")
	public ResponseEntity<Collection<Pet>> getPets(@PathVariable String type){
		Collection<Pet> pets = petComponentImpl.getPets(type);
		if(pets.isEmpty()){
			return new ResponseEntity<Collection<Pet>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Pet>>(pets,HttpStatus.OK);
	}

	@GetMapping("api/v1/pets/u/{id:[\\d]+}")
	public ResponseEntity<Collection<Pet>> getPetsByOwnerId(@PathVariable int id){
		Collection<Pet> pets = petComponentImpl.getPetsByOwnerId(id);
		if(pets.isEmpty()){
			return new ResponseEntity<Collection<Pet>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Pet>>(pets,HttpStatus.OK);
	}
}