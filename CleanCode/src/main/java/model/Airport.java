package model;

import model.enums.ClassificationLevel;
import model.enums.ExperimentalPlaneType;
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
        return this.planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getListOfMilitaryPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getListOfExperimentalPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getListOfPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .get();
    }

    public List<MilitaryPlane> getListOfMilitaryPlanesOfType(MilitaryPlaneType militaryPlaneType) {
        return getListOfMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getMilitaryPlaneType().equals(militaryPlaneType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getListOfExperimentalPlanesOfType(ExperimentalPlaneType experimentalPlaneType) {
        return getListOfExperimentalPlanes().stream()
                .filter(experimentalPlane -> experimentalPlane.getExperimentalPlaneType().equals(experimentalPlaneType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getListOfExperimentalPlanesOfClassificationLevel(ClassificationLevel classificationLevel) {
        return getListOfExperimentalPlanes().stream()
                .filter(experimentalPlane -> experimentalPlane.getClassificationLevel().equals(classificationLevel))
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
