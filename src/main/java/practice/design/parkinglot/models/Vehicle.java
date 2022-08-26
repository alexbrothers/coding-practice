package practice.design.parkinglot.models;

public class Vehicle {

    private final VehicleType vehicleType;
    private final String licensePlate;
    private final String vehicleMake;
    private final String vehicleModel;
    private final Color color;

    public Vehicle(VehicleType vehicleType, String licensePlate, String vehicleMake, String vehicleModel, Color color) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public Color getColor() {
        return color;
    }
}
