package amazon;

public class NoLockerFoundException extends Exception {

    public NoLockerFoundException(String errorMessage) {
        super(errorMessage);
    }

}
