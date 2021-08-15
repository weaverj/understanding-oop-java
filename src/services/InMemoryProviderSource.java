package services;

import domain.Credentials;
import domain.Provider;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProviderSource {

    private static final ArrayList<Provider> inMemoryProviders;

    /*
      Create a fixed, static list of providers that will always be returned.  There will be only one instance
      of a given one of these providers - with the same object ID - all the time.
     */
    static {
        inMemoryProviders = new ArrayList<>();
        inMemoryProviders.add(new Provider("Bill Blue", Credentials.MD));
        inMemoryProviders.add(new Provider("Carol Cyan", Credentials.MD));
        inMemoryProviders.add(new Provider("George Green", Credentials.NP));
        inMemoryProviders.add(new Provider("Mila Magenta", Credentials.RN));
    }

    public List<Provider> getAllProviders() {
        return inMemoryProviders;
    }

    public Provider getProviderByName(String name) {
        return inMemoryProviders.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    /*
      Alternative - create a new object for each provider each time.  The data returned is the same, but each
      provider will have a different object ID each time.
     */
    private List<Provider> createAllProviders() {
        ArrayList<Provider> providers = new ArrayList<>();
        providers.add(new Provider("Bill Blue", Credentials.MD));
        providers.add(new Provider("Carol Cyan", Credentials.MD));
        providers.add(new Provider("George Green", Credentials.NP));
        providers.add(new Provider("Mila Magenta", Credentials.RN));
        return providers;
    }

}
