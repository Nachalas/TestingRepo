package model;

import java.util.Objects;

abstract public class Plane {
    protected String model;
    protected int maxPlaneSpeed;
    protected int maxFlightDistance;
    protected int maxLoadCapacity;

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

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Plane{")
                .append("model='").append(model).append("'")
                .append(", maxSpeed=").append(maxPlaneSpeed)
                .append(", maxFlightDistance=").append(maxFlightDistance)
                .append(", maxLoadCapacity=").append(maxLoadCapacity)
                .append("}").toString();
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
