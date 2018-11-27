package be.heh.petclinic.exception;

public class VisitNotFoundException extends RuntimeException{
    public VisitNotFoundException(String exception) {
        super(exception);
    }
}
