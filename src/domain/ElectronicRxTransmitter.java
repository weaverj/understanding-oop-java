package domain;

import java.util.List;

public class ElectronicRxTransmitter {

    public void transmitPrescriptions(List<Prescription> prescriptions) {
        System.out.println("\nPrescriptions received electronically at pharmacy: ");
        for (Prescription rx : prescriptions) {
            System.out.println("\t" + rx.getDescription());
        }
        System.out.println("");
    }

}
