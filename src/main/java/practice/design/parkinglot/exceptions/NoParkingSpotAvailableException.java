package practice.design.parkinglot.exceptions;

public class NoParkingSpotAvailableException extends Exception {

    private static final String DEFAULT_MESSAGE = "No parking spot available";

    public NoParkingSpotAvailableException() {
        super(DEFAULT_MESSAGE);
    }

    public NoParkingSpotAvailableException(String message) {
        super(message);
    }

}
