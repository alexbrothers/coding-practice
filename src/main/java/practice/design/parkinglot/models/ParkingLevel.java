package practice.design.parkinglot.models;

import practice.design.parkinglot.exceptions.IllegalVehicleTypeException;
import practice.design.parkinglot.exceptions.NoParkingSpotAvailableException;
import practice.design.parkinglot.interfaces.ParkingCoordinator;

import java.util.*;

public class ParkingLevel implements ParkingCoordinator {

    private int level;
    private Queue<MotorcycleParkingSpot> openMotorcycleSpots;
    private Queue<CarParkingSpot> openCarSpots;
    private Queue<BusParkingSpot> openBusSpots;
    private Map<Integer, ParkingSpot> usedSpots;

    public ParkingLevel(int level, List<MotorcycleParkingSpot> motorcycleParkingSpots, List<CarParkingSpot> carParkingSpots, List<BusParkingSpot> busParkingSpots) {
        this.level = level;
        this.openMotorcycleSpots = new LinkedList<>(motorcycleParkingSpots);
        this.openCarSpots = new LinkedList<>(carParkingSpots);
        this.openBusSpots = new LinkedList<>(busParkingSpots);
        this.usedSpots = new HashMap<>();
    }

    @Override
    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle) throws NoParkingSpotAvailableException, IllegalVehicleTypeException {
        switch (vehicle.getVehicleType()) {
            case MOTORCYCLE:
                if (openMotorcycleSpots.isEmpty()) {
                    throw new NoParkingSpotAvailableException(String.format("No available motorcycle spots on level %d", this.level));
                }
                MotorcycleParkingSpot motorcycleParkingSpot = openMotorcycleSpots.poll();
                motorcycleParkingSpot.setUsed(true);
                usedSpots.put(motorcycleParkingSpot.getParkingSpotId(), motorcycleParkingSpot);
                return motorcycleParkingSpot;
            case CAR:
                if (openCarSpots.isEmpty()) {
                    throw new NoParkingSpotAvailableException(String.format("No available car spots on level %d", this.level));
                }
                CarParkingSpot carParkingSpot = openCarSpots.poll();
                carParkingSpot.setUsed(true);
                usedSpots.put(carParkingSpot.getParkingSpotId(), carParkingSpot);
                return carParkingSpot;
            case BUS:
                if (openBusSpots.isEmpty()) {
                    throw new NoParkingSpotAvailableException(String.format("No available bus spots on level %d", this.level));
                }
                BusParkingSpot busParkingSpot = openBusSpots.poll();
                busParkingSpot.setUsed(true);
                usedSpots.put(busParkingSpot.getParkingSpotId(), busParkingSpot);
                return busParkingSpot;
            default:
                throw new IllegalVehicleTypeException();
        }
    }

    public void freeSpot(int parkingSpotId) {
        ParkingSpot spot = this.usedSpots.get(parkingSpotId);
        if (spot instanceof MotorcycleParkingSpot) {
            openMotorcycleSpots.offer((MotorcycleParkingSpot) spot);
        }
        else if (spot instanceof CarParkingSpot) {
            openCarSpots.offer((CarParkingSpot) spot);
        }
        else if (spot instanceof BusParkingSpot) {
            openBusSpots.offer((BusParkingSpot) spot);
        }
        else {
            System.out.println("Unknown vehicle type");
        }
    }
}
