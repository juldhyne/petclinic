package be.heh.petclinic.web;

import be.heh.petclinic.component.visit.VisitComponent;
import be.heh.petclinic.domain.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VisitRestController {

	@Autowired
	private VisitComponent visitComponentImpl;

    @GetMapping("api/v1/visits/{id:[\\d]+}")
    public ResponseEntity<Visit> getVisitsById(@PathVariable int id) {
        Visit visit = visitComponentImpl.getVisitById(id);
        if (visit == null) {
            return new ResponseEntity<Visit>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Visit>(visit, HttpStatus.OK);
    }

    @GetMapping("api/v1/visits/p/{id:[\\d]+}")
    public ResponseEntity<Visit[]> getVisitsByPetId(@PathVariable int id) {

        Visit[] visits = visitComponentImpl.getVisitsByPetId(id);
        if (visits.length == 0) {
            return new ResponseEntity<Visit[]>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Visit[]>(visits, HttpStatus.OK);
    }

	@PostMapping("api/v1/visits")
	public ResponseEntity<Visit> insertVisit(@RequestBody Visit visit){
        visitComponentImpl.insertVisit(visit);
		return new ResponseEntity<Visit>(visit,HttpStatus.OK);
	}

	//	Todo
	// 	Make range request ?
}