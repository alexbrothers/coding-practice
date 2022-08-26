package practice.design.parkinglot.models;

public abstract class ParkingSpot {
    private int parkingSpotId;
    private boolean used;

    public ParkingSpot(int parkingSpotId, boolean used) {
        this.parkingSpotId = parkingSpotId;
        this.used = used;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
