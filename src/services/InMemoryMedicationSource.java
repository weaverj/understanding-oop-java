package services;

import domain.Medication;

import java.util.ArrayList;

public class InMemoryMedicationSource {

    private static final ArrayList<Medication> medList;

    static {
        medList = new ArrayList<>();
        medList.add(new Medication("Aspirin", "Analgesic", false));
        medList.add(new Medication("Acetaminophen", "Analgesic", false));
        medList.add(new Medication("simvastatin", "Antihyperlipidemics", false));
        medList.add(new Medication("Diazepam", "Antianxiety", true));
    }

    public ArrayList<Medication> getPrescribableMeds() {
        return medList;
    }

    public Medication getMedictaionByName(String medName) {
        return medList.stream().filter(p -> p.getMedicationName().equalsIgnoreCase(medName)).findFirst().orElse(null);
    }
}
