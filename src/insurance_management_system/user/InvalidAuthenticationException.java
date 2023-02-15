package insurance_management_system.user;

public class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
