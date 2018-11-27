package be.heh.petclinic.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(String exception) {
        super(exception);
    }
}
