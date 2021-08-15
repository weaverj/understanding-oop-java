package domain;

public class Medication {

    private String medicationName;
    private String className;
    private boolean controlledSubstance;

    public Medication(String medicationName, String className, boolean controlledSubstance) {
        this.medicationName = medicationName;
        this.className = className;
        this.controlledSubstance = controlledSubstance;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getClassName() {
        return className;
    }

    public boolean isControlledSubstance() {
        return controlledSubstance;
    }
}
