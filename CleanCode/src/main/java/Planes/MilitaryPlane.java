package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryPlaneType;

    public MilitaryPlane(String planeModelName, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(planeModelName, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = type;
    }

    public MilitaryType getMilitaryPlaneType() {
        return militaryPlaneType;
    }

    public void setMilitaryPlaneType(MilitaryType militaryPlaneType) {
        this.militaryPlaneType = militaryPlaneType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryPlaneType +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MilitaryPlane)) return false;
        if (!super.equals(object)) return false;
        MilitaryPlane objectAsMilitaryPlane = (MilitaryPlane) object;
        return militaryPlaneType == objectAsMilitaryPlane.militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }
}
