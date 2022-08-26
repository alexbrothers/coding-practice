package practice.design.parkinglot.models;

import practice.design.parkinglot.exceptions.IllegalVehicleTypeException;
import practice.design.parkinglot.exceptions.NoParkingSpotAvailableException;

import java.time.Instant;
import java.util.List;

public class ParkingLot {

    private List<ParkingLevel> parkingLevels;
    private Address address;

    public ParkingLot(List<ParkingLevel> parkingLevels, Address address) {
        this.parkingLevels = parkingLevels;
        this.address = address;
    }

    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public Address getAddress() {
        return address;
    }

    public ParkingTicket enter(Vehicle vehicle) throws IllegalVehicleTypeException, NoParkingSpotAvailableException {
        ParkingSpot spot = null;
        for (int i = 0; i < parkingLevels.size(); i++) {
            try {
                spot = parkingLevels.get(i).getAvailableParkingSpot(vehicle);
                return createParkingTicket(i, spot, vehicle);
            } catch (NoParkingSpotAvailableException e) {
                System.out.println(e.getMessage());
            } catch (IllegalVehicleTypeException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        throw new NoParkingSpotAvailableException();
    }

    private ParkingTicket createParkingTicket(int level, ParkingSpot parkingSpot, Vehicle vehicle) {
        return new ParkingTicket(level, parkingSpot.getParkingSpotId(), vehicle, Instant.now().getEpochSecond());
    }

    public void exit(ParkingTicket parkingTicket) {
        this.parkingLevels.get(parkingTicket.getLevel()).freeSpot(parkingTicket.getParkingSpotId());
    }
}
