package ui;

import domain.*;
import services.InMemoryMedicationSource;
import services.InMemoryProviderSource;

import java.util.Scanner;

// Responsible for interacting with the user / prescriber.
public class ClinicUI {

    private final Scanner scanner = new Scanner(System.in);
    private RxWriterSession session = null;
    private final InMemoryProviderSource providerSource = new InMemoryProviderSource();
    private final InMemoryMedicationSource medicationSource = new InMemoryMedicationSource();
    private final ElectronicRxTransmitter rxTransmitter = new ElectronicRxTransmitter();

    public void start() {
        System.out.println("Welcome to RxWriter!\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu();
        }
        System.out.println("\nExiting System...\n");
    }

    private String displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Display all providers");
        System.out.println("2. Sign in as provider");
        System.out.println("3. Write a prescription");
        System.out.println("4. Transmit prescriptions");
        System.out.println("X. Exit System.");
        System.out.print("Option: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":   listProviders();
                        return option;
            case "2":   signIn();
                        return option;
            case "3":   writePrescription();
                        return option;
            case "4":   transmitPrescriptions();
                        return option;
            default:    if (!option.equalsIgnoreCase("x")) {
                            System.out.println("Invalid option, please re-enter.");
                        }
                        return option;
        }
    }

    private void listProviders() {
        System.out.println("");
        for (Provider provider : providerSource.getAllProviders()) {
            System.out.println(provider);
        }
        System.out.println("");
    }

    private void signIn() {
        listProviders();
        System.out.print("\nEnter name of provider: ");
        String providerName = scanner.nextLine();
        Provider selectedProvider = providerSource.getProviderByName(providerName);
        if (selectedProvider == null) {
            System.out.println("\nProvider not found!  Try again.\n");
        } else {
            System.out.print("\nEnter name of patient for this session: ");
            String patientName = scanner.nextLine();
            session = new RxWriterSession(selectedProvider, patientName);
            System.out.println("\nWelcome " + selectedProvider.getName()
                + ", " + selectedProvider.getCredentials().getAbbreviation()
                + ".  You are prescribing for: " + patientName);
        }
    }

    private boolean isSignedIn() {
        return (session != null && session.getProvider() != null);
    }

    private void writePrescription() {
        if (!isSignedIn()) {
            System.out.println("\nMust be signed in first!\n");
            return;
        }
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayRxWritingMenu();
        }
    }


    private String displayRxWritingMenu() {
        System.out.println("");
        System.out.println("Please select an option:");
        System.out.println("1. Prescribe a medication");
        System.out.println("2. Prescribe medical equipment");
        System.out.println("X. Finish prescribing");
        System.out.print("Option: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":   prescribeMed();
                        return option;
            case "2":   prescribeEquipment();
                        return option;
            default:    if (!option.equalsIgnoreCase("x")) {
                            System.out.println("Invalid option, please re-enter.");
                        }
                        System.out.println();
                        return option;
        }
    }

    private void listMedications() {
        System.out.println("\n");
        for (Medication med : medicationSource.getPrescribableMeds()) {
            System.out.println(med.getMedicationName());
        }
    }

    private void prescribeMed() {
        listMedications();
        System.out.print("\nEnter name of medication: ");
        String medName = scanner.nextLine();
        Medication selectedMed = medicationSource.getMedictaionByName(medName);
        if (selectedMed == null) {
            System.out.println("\nMedication not found!  Try again.\n");
        } else {
            createMedPrescription(selectedMed);
        }
    }

    private void createMedPrescription(Medication selectedMed) {
        System.out.print("\nEnter strength (in mg or ml, etc): ");
        String strength = scanner.nextLine();
        System.out.print("\nEnter dose form (tablet, capsule, etc): ");
        String form = scanner.nextLine();
        System.out.print("\nEnter single dose quantity: ");
        String quantity = scanner.nextLine();
        System.out.print("\nEnter dose frequency (daily, etc): ");
        String frequency = scanner.nextLine();
        System.out.print("\nEnter prescription duration: ");
        String duration = scanner.nextLine();
        session.writeMedPrescription(selectedMed, strength, form, quantity, frequency, duration);
    }

    private void prescribeEquipment() {
        System.out.println("Not implemented yet!");
    }


    private void transmitPrescriptions() {
        if (!isSignedIn() || !session.hasUntransmittedPrescriptions()) {
            System.out.println("\nMust be signed in and have written prescriptions for patient!\n");
            return;
        }
        listPrescriptions();
        displayTransmitRxMenu();
    }

    private void listPrescriptions() {
        System.out.println("Prescriptions written currently for " + session.getCurrentPatient() + "\n");
        for (Prescription rx : session.getUntransmittedPrescriptions()) {
            System.out.println(rx.getDescription());
        }
        System.out.println("");
    }

    private void displayTransmitRxMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Transmit to pharmacy electronically");
        System.out.println("2. Send to clinic printer (not implemented yet)");
        System.out.print("Option: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":   rxTransmitter.transmitPrescriptions(session.getUntransmittedPrescriptions());
                        System.exit(0);
            case "2":   System.out.println("Not yet implemented");
            default:    System.out.println("Invalid option, please re-enter.");
        }
    }

}
