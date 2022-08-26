package practice.design.parkinglot.interfaces;

import practice.design.parkinglot.exceptions.IllegalVehicleTypeException;
import practice.design.parkinglot.exceptions.NoParkingSpotAvailableException;
import practice.design.parkinglot.models.ParkingSpot;
import practice.design.parkinglot.models.Vehicle;

public interface ParkingCoordinator {

    ParkingSpot getAvailableParkingSpot(Vehicle vehicle) throws NoParkingSpotAvailableException, IllegalVehicleTypeException;

}
