package be.heh.petclinic.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.heh.petclinic.component.visit.VisitComponent;
import be.heh.petclinic.domain.Visit;


@RestController
public class VisitRestController {

	@Autowired
	private VisitComponent visitComponentImpl;

	@GetMapping("api/v1/visits/{id:[\\d]+}")
	public ResponseEntity<Visit> getVisitsById(@PathVariable int id){
		Visit visit = visitComponentImpl.getVisitById(id);
		if(visit == null){
			return new ResponseEntity<Visit>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Visit>(visit,HttpStatus.OK);
	}

	@GetMapping("api/v1/visits/p/{id:[\\d]+}")
	public ResponseEntity<Collection<Visit>> getVisitsByPetId(@PathVariable int id){
	
		Collection<Visit> visits = visitComponentImpl.getVisitsByPetId(id);
		if(visits.isEmpty()){
			return new ResponseEntity<Collection<Visit>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Visit>>(visits,HttpStatus.OK);
	}
	//	Todo
	// 	Make range request ?
}