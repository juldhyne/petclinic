package be.heh.petclinic.web;

import java.util.Collection;

import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Pet;


@RestController
public class PetRestController {

	@Autowired
	private PetComponent petComponentImpl;
	
	@GetMapping("api/v1/pets")
	public ResponseEntity<Pet[]> getPets(){
		Pet[] pets = petComponentImpl.getPets();
		if(pets.length == 0){
			return new ResponseEntity<Pet[]>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pet[]>(pets,HttpStatus.OK);
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
	public ResponseEntity<Pet[]> getPets(@PathVariable String type){
		Pet[] pets = petComponentImpl.getPets(type);
		if(pets.length == 0){
			return new ResponseEntity<Pet[]>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pet[]>(pets,HttpStatus.OK);
	}

	@GetMapping("api/v1/pets/o/{id:[\\d]+}")
	public ResponseEntity<Pet[]> getPetsByOwnerId(@PathVariable int id){
		Pet[] pets = petComponentImpl.getPetsByOwnerId(id);
		if(pets.length == 0){
			return new ResponseEntity<Pet[]>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pet[]>(pets,HttpStatus.OK);
	}

	@PostMapping("api/v1/pets")
	public ResponseEntity<Pet> insertPet(@RequestBody Pet pet){
		petComponentImpl.insertPet(pet);
		return new ResponseEntity<Pet>(pet,HttpStatus.CREATED);
	}
	@PutMapping("api/v1/pets/{id:[\\d]+}")
	public ResponseEntity<Pet> updatePet(@RequestBody Pet pet, @PathVariable int id) {
		pet.setId(id);
		petComponentImpl.updatePet(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
}