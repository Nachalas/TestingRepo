package model.planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    private int passengersCapacity;

    public PassengerPlane(String planeModelName, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(planeModelName, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PassengerPlane)) return false;
        if (!super.equals(object)) return false;
        PassengerPlane objectAsPassengerPlane = (PassengerPlane) object;
        return passengersCapacity == objectAsPassengerPlane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
