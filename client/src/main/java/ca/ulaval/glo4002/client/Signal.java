package ca.ulaval.glo4002.client;

public class Signal {

    public enum DetectorType {
        MainDoor, SecondaryDoor, MovementDetector
    };

    private DetectorType detectorType;
    private int delayToContactEmergency;

    public Signal(DetectorType detectorType, int delayToContactEmergency) {
        this.detectorType = detectorType;
        this.delayToContactEmergency = delayToContactEmergency;
    }

    public DetectorType getDetectorType() {
        return detectorType;
    }

    public int getDelayToContactEmergency() {
        return delayToContactEmergency;
    }
}