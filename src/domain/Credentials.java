package domain;

import java.util.Arrays;

public enum Credentials {
    MD("Medical Doctor", "M.D.", true),
    NP("Nurse Practitioner", "N.P.", true),
    RN("Registered Nurse", "R.N.", false);

    private final String name;
    private final String abbreviation;
    private final boolean canPrescribe;

    Credentials(String name, String abbreviation, boolean canPrescribe) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.canPrescribe = canPrescribe;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public boolean isCanPrescribe() {
        return canPrescribe;
    }

    public static Credentials getByAbbreviation(String abbreviation) {
       return Arrays.stream(values()).filter(c -> c.abbreviation.equalsIgnoreCase(abbreviation)).findFirst().get();
    }

}
