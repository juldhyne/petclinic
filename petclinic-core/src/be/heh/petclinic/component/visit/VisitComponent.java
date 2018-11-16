package be.heh.petclinic.component.visit;

import java.util.List;
import be.heh.petclinic.domain.Visit;

public interface VisitComponent {

    Visit getVisitById(int id);

    List<Visit> getVisitsByPetId(int petId);

}
