package practice.design.parkinglot.exceptions;

public class IllegalVehicleTypeException extends Exception {

    private static final String DEFAULT_MESSAGE = "Illegal vehicle type";

    public IllegalVehicleTypeException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalVehicleTypeException(String message) {
        super(message);
    }

}
