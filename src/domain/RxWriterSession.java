package domain;

import java.util.ArrayList;

// This class represents the work a provider is doing during a patient visit.
public class RxWriterSession {

    private final Provider provider;
    private ArrayList<Prescription> untransmittedPrescriptions;
    private String currentPatient;

    public RxWriterSession(Provider provider, String patientName) {
        this.provider = provider;
        this.untransmittedPrescriptions = new ArrayList<>();
        this.currentPatient = patientName;
    }

    public void startPrescriptionsForPatent(String patientName) {
        this.currentPatient = patientName;
        this.untransmittedPrescriptions = new ArrayList<>();
    }

    public boolean hasUntransmittedPrescriptions() {
        return !untransmittedPrescriptions.isEmpty();
    }

    public ArrayList<Prescription> getUntransmittedPrescriptions() {
        return untransmittedPrescriptions;
    }

    public Provider getProvider() {
        return provider;
    }

    public String getCurrentPatient() {
        return currentPatient;
    }

    public void writeMedPrescription(Medication med, String strength, String form, String quantity,
                                     String frequency, String duration) {
        MedicationPrescription rx = new MedicationPrescription(getCurrentPatient(), med);
        rx.setDoseStrength(strength);
        rx.setDoseForm(form);
        rx.setDoseQuantity(quantity);
        rx.setFrequency(frequency);
        rx.setDuration(duration);
        untransmittedPrescriptions.add(rx);
    }
}
