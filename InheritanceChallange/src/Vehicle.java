public class Vehicle {
    private String typeofVehicle;
    private String TransportationType;
    private boolean isPrivate;

    public Vehicle(String typeofVehicle, String transportationType, boolean isPrivate) {
        this.typeofVehicle = typeofVehicle;
        TransportationType = transportationType;
        this.isPrivate = isPrivate;
    }

    public String getTypeofVehicle() {
        return typeofVehicle;
    }

    public String getTransportationType() {
        return TransportationType;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
