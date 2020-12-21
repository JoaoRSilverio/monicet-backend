package pt.geniusgrow.monicet.exceptions;

public class ResourceNotFoundException extends Exception {
    private String message;
    public ResourceNotFoundException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
