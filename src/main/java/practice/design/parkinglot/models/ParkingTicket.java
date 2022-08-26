package practice.design.parkinglot.models;

public class ParkingTicket {

    private int level;
    private int parkingSpotId;
    private Vehicle vehicle;
    private long enteredAt;

    public ParkingTicket(int level, int parkingSpotId, Vehicle vehicle, long enteredAt) {
        this.level = level;
        this.parkingSpotId = parkingSpotId;
        this.vehicle = vehicle;
        this.enteredAt = enteredAt;
    }

    public int getLevel() {
        return level;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEnteredAt() {
        return enteredAt;
    }
}
