package andre.locationharvester;

/**
 * Created by Andre on 5/24/2016.
 */
public final class Constants {
    /*
     name of the set containing the locations for storing in shared preferences
     */
    public static final String LOCATION_SET_KEY = "locationsHarvested";

    public static final String SHARED_PREF_FILENAME = "locationHarversterPrefs";
    /*
     the maximum number of locations to be stored in the set in shared prefs
     */
    public static final int MAX_SET_SIZE = 6;

    public static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    /*
     minimum distance between two locations for registering the new one
     */
    public static final int UPDATE_DISTANCE_M = 50;

    /*
     maximum update interval for receiving locations
     */
    public static final int UPDATE_INTERVAL_MS = 10 * 1000;

    /*
     update interval for receiving locations
     */
    public static final int UPDATE_FASTEST_INTERVAL_MS = 1000;

    private Constants() {
        throw new AssertionError();
    }

    public void test(String foo) {

    }

    static final int REQUEST_TAKE_PHOTO = 1;
}
