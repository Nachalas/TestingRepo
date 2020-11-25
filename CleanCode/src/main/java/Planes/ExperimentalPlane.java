package Planes;

import models.ClassificationLevel;
import models.ExperimentalType;

public class ExperimentalPlane extends Plane{

    private ExperimentalType experimentalPlaneType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(
            String planeModelName, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
            ExperimentalType type, ClassificationLevel classificationLevel) {
        super(planeModelName, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getExperimentalPlaneType() {
        return experimentalPlaneType;
    }

    public void setExperimentalPlaneType(ExperimentalType experimentalPlaneType) {
        this.experimentalPlaneType = experimentalPlaneType;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
