package domain;

public abstract class Prescription {

    // Create an "EquipmentPrescription" subclass

    protected String patient;

    public Prescription(String patient) {
        this.patient = patient;
    }

    public abstract String getDescription();
}
