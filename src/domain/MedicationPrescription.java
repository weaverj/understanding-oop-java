package domain;

public class MedicationPrescription extends Prescription {

    private final Medication medication;

    private String doseStrength;
    private String doseForm;
    private String doseQuantity;
    private String frequency;
    private String duration;

    public MedicationPrescription(String patient, Medication medication) {
        super(patient);
        this.medication = medication;
    }

    public void setDoseStrength(String doseStrength) {
        this.doseStrength = doseStrength;
    }

    public void setDoseForm(String doseForm) {
        this.doseForm = doseForm;
    }

    public void setDoseQuantity(String doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return medication.getMedicationName().concat(" prescription for ").concat(patient).concat(": ").concat("Take "
                .concat(doseQuantity).concat(" ").concat(doseStrength).concat(" ")
                .concat(doseForm).concat(" ").concat(frequency).concat(" for ").concat(duration));
    }
}
