import model.Airport;
import model.planes.ExperimentalPlane;
import model.enums.ClassificationLevel;
import model.enums.ExperimentalPlaneType;
import model.enums.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.Test;
import model.planes.MilitaryPlane;
import model.planes.PassengerPlane;
import model.Plane;

import java.util.*;
import java.util.stream.Collector;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> passengerPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
    );

    private static List<Plane> militaryPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );

    private static List<Plane> militaryBomberPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER)
    );

    private static List<Plane> militaryFighterPlanes = Arrays.asList(
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER)
    );

    private static List<Plane> militaryTransportPlanes = Arrays.asList(
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );

    private static List<Plane> experimentalPlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> experimentalHighAltitudePlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET)
    );

    private static List<Plane> experimentalVTOLPlanes = Arrays.asList(
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> experimentalSecretPlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET)
    );

    private static List<Plane> experimentalTopSecretPlanes = Arrays.asList(
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetListOfMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> airportMilitaryPlanes = airport.getListOfMilitaryPlanes();
        Assert.assertTrue(
                (militaryPlanes.size() == airportMilitaryPlanes.size())
                && militaryPlanes.containsAll(airportMilitaryPlanes)
                && airportMilitaryPlanes.containsAll(militaryPlanes)
        );
    }

    @Test
    public void testGetListOfPassengerPlanes() {
        Airport airport = new Airport(planes);
        List<PassengerPlane> airportPassengerPlanes = airport.getListOfPassengerPlanes();
        Assert.assertTrue(
                (passengerPlanes.size() == airportPassengerPlanes.size())
                        && passengerPlanes.containsAll(airportPassengerPlanes)
                        && airportPassengerPlanes.containsAll(passengerPlanes)
        );
    }

    @Test
    public void testGetListOfExperimentalPlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> airportExperimentalPlanes = airport.getListOfExperimentalPlanes();
        Assert.assertTrue(
                (experimentalPlanes.size() == airportExperimentalPlanes.size())
                        && experimentalPlanes.containsAll(airportExperimentalPlanes)
                        && airportExperimentalPlanes.containsAll(experimentalPlanes)
        );
    }

    @Test
    public void testGetListOfMilitaryBomberPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> airportMilitaryBomberPlanes = airport.getListOfMilitaryPlanesOfType(MilitaryPlaneType.BOMBER);
        Assert.assertTrue(
                (militaryBomberPlanes.size() == airportMilitaryBomberPlanes.size())
                        && militaryBomberPlanes.containsAll(airportMilitaryBomberPlanes)
                        && airportMilitaryBomberPlanes.containsAll(militaryBomberPlanes)
        );
    }

    @Test
    public void testGetListOfMilitaryFighterPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> airportMilitaryFighterPlanes = airport.getListOfMilitaryPlanesOfType(MilitaryPlaneType.FIGHTER);
        Assert.assertTrue(
                (militaryFighterPlanes.size() == airportMilitaryFighterPlanes.size())
                        && militaryFighterPlanes.containsAll(airportMilitaryFighterPlanes)
                        && airportMilitaryFighterPlanes.containsAll(militaryFighterPlanes)
        );
    }

    @Test
    public void testGetListOfMilitaryTransportPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> airportMilitaryTransportPlanes = airport.getListOfMilitaryPlanesOfType(MilitaryPlaneType.TRANSPORT);
        Assert.assertTrue(
                (militaryTransportPlanes.size() == airportMilitaryTransportPlanes.size())
                        && militaryTransportPlanes.containsAll(airportMilitaryTransportPlanes)
                        && airportMilitaryTransportPlanes.containsAll(militaryTransportPlanes)
        );
    }

    @Test
    public void testGetListOfExperimentalHighAltitudePlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> airportExperimentalHighAltitudePlanes = airport.getListOfExperimentalPlanesOfType(ExperimentalPlaneType.HIGH_ALTITUDE);
        Assert.assertTrue(
                (experimentalHighAltitudePlanes.size() == airportExperimentalHighAltitudePlanes.size())
                        && experimentalHighAltitudePlanes.containsAll(airportExperimentalHighAltitudePlanes)
                        && airportExperimentalHighAltitudePlanes.containsAll(experimentalHighAltitudePlanes)
        );
    }

    @Test
    public void testGetListOfExperimentalVTOLPlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> airportExperimentalVTOLPlanes = airport.getListOfExperimentalPlanesOfType(ExperimentalPlaneType.VTOL);
        Assert.assertTrue(
                (experimentalVTOLPlanes.size() == airportExperimentalVTOLPlanes.size())
                        && experimentalVTOLPlanes.containsAll(airportExperimentalVTOLPlanes)
                        && airportExperimentalVTOLPlanes.containsAll(experimentalVTOLPlanes)
        );
    }

    @Test
    public void testGetListOfExperimentalSecretPlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> airportExperimentalSecretPlanes = airport.getListOfExperimentalPlanesOfClassificationLevel(ClassificationLevel.SECRET);
        Assert.assertTrue(
                (experimentalSecretPlanes.size() == airportExperimentalSecretPlanes.size())
                        && experimentalSecretPlanes.containsAll(airportExperimentalSecretPlanes)
                        && airportExperimentalSecretPlanes.containsAll(experimentalSecretPlanes)
        );
    }

    @Test
    public void testGetListOfExperimentalTopSecretPlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> airportExperimentalTopSecretPlanes = airport.getListOfExperimentalPlanesOfClassificationLevel(ClassificationLevel.TOP_SECRET);
        Assert.assertTrue(
                (experimentalTopSecretPlanes.size() == airportExperimentalTopSecretPlanes.size())
                        && experimentalTopSecretPlanes.containsAll(airportExperimentalTopSecretPlanes)
                        && airportExperimentalTopSecretPlanes.containsAll(experimentalTopSecretPlanes)
        );
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        Airport airport = new Airport(planes);
        airport.sortByMaxFlightDistance();
        List<? extends Plane> airportPlanes = airport.getListOfPlanes();
        Assert.assertEquals(planes, airportPlanes);
    }

    @Test
    public void testSortByMaxPlaneSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxPlaneSpeed));
        Airport airport = new Airport(planes);
        airport.sortByMaxPlaneSpeed();
        List<? extends Plane> airportPlanes = airport.getListOfPlanes();
        Assert.assertEquals(planes, airportPlanes);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> airportPlanes = airport.getListOfPlanes();
        Assert.assertEquals(planes, airportPlanes);
    }
}
