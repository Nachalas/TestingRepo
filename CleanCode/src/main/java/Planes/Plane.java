package Planes;

import java.util.Objects;

abstract public class Plane {
    String model;
    private int maxPlaneSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String planeModelName, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = planeModelName;
        this.maxPlaneSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return this.model;
    }

    public int getMaxPlaneSpeed() {
        return this.maxPlaneSpeed;
    }

    public int getMaxFlightDistance() {
        return this.maxFlightDistance;
    }

    public int getMinLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxPlaneSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        Plane objectAsPlane = (Plane) object;
        return maxPlaneSpeed == objectAsPlane.maxPlaneSpeed &&
                maxFlightDistance == objectAsPlane.maxFlightDistance &&
                maxLoadCapacity == objectAsPlane.maxLoadCapacity &&
                Objects.equals(model, objectAsPlane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxPlaneSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
