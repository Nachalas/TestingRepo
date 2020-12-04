package model;

import model.planes.ExperimentalPlane;
import model.enums.MilitaryPlaneType;
import model.planes.MilitaryPlane;
import model.planes.PassengerPlane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getListOfPassengerPlanes() {
        List<? extends Plane> l = this.planes;
        List<PassengerPlane> x = new ArrayList<>();
        for (Plane p : l) {
            if (p instanceof PassengerPlane) {x.add((PassengerPlane) p);
            }
        }
        return x;
    }

    public List<MilitaryPlane> getListOfMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getListOfPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getListOfTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getListOfMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getListOfBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getListOfMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getListOfExperimentalPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortByMaxPlaneSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxPlaneSpeed));
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    public List<? extends Plane> getListOfPlanes() {
        return planes;
    }

    @Override
    public String toString() {
       return new StringBuilder().append("model.Airport{")
               .append("Planes=").append(planes)
               .append("}").toString();
    }

}
