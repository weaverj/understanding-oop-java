package services;

import domain.Credentials;
import domain.Provider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileProviderSource {

    public List<Provider> getAllProviders() {
        return readProvidersFromFile();
    }

    private static List<Provider> readProvidersFromFile() {
        ArrayList<Provider> providers = new ArrayList<>();
        InputStream stream = CsvFileProviderSource.class.getResourceAsStream("providers.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            line = reader.readLine();
            while (line != null) {
                providers.add(createProviderFromLine(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return providers;
    }

    private static Provider createProviderFromLine(String line) {
        String[] values = line.split(",");
        return new Provider(values[0], Credentials.getByAbbreviation(values[1]));
    }

}
