package model.planes;

import model.Plane;
import model.enums.MilitaryPlaneType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryPlaneType militaryPlaneType;

    public MilitaryPlane(String planeModelName, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneType type) {
        super(planeModelName, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = type;
    }

    public MilitaryPlaneType getMilitaryPlaneType() {
        return militaryPlaneType;
    }

    public void setMilitaryPlaneType(MilitaryPlaneType militaryPlaneType) {
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
