package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;


@RestController
public class VetRestController {

	@Autowired
	private VetComponent vetComponentImpl;
<<<<<<< HEAD

=======
    
	//@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
	@GetMapping("api/v1/vets")
	public ResponseEntity<Collection<Vet>> getVets(){
	
		Collection<Vet> vets = vetComponentImpl.getVets();
		if(vets.isEmpty()){
			return new ResponseEntity<Collection<Vet>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Vet>>(vets,HttpStatus.OK);
	}
	//	Todo
	// 	Make range request ?
}