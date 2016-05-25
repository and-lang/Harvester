package andre.locationharvester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.LocationResult;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

import static andre.locationharvester.Constants.LOCATION_SET_KEY;
import static andre.locationharvester.Constants.MAX_SET_SIZE;
import static andre.locationharvester.Constants.SHARED_PREF_FILENAME;

/**
 * Created by Andre on 5/16/2016.
 */
public class LocationReceiver extends BroadcastReceiver {

    private String TAG = this.getClass().getSimpleName();

    private LocationResult locationResult;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (LocationResult.hasResult(intent)) {
            this.locationResult = LocationResult.extractResult(intent);
            Log.i(TAG, "Location Received: " + this.locationResult.toString());

            SharedPreferences prefs = context.getSharedPreferences(SHARED_PREF_FILENAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            storeLocation(locationResult, prefs, editor);
        }
    }

    private void storeLocation(LocationResult locationResult, SharedPreferences prefs, SharedPreferences.Editor editor) {
        /*
        transform newly received location into Json string
        (shared preferences cannot store objects like Location but can store Strings)
        */
        Gson gson = new Gson();
        Location newLocation = locationResult.getLastLocation();
        String jsonLocation = gson.toJson(newLocation);

        /*
        add location in json format to a new set containing the values of the set from the shared prefs;
        if no set is stored in shared prefs, a new one is created
        */
        Set<String> set = new HashSet<String>(prefs.getStringSet(LOCATION_SET_KEY, new HashSet<String>()));
        set.add(jsonLocation);

        /*
        if the maximum set size is reached, send data to server and clear set in shared prefs;
        if the set is below the maximum desired size, store it in shared pref
        */
        if (set.size() == MAX_SET_SIZE) {
            // TODO send data to server
            editor.remove(LOCATION_SET_KEY);
            editor.apply();
        } else {
            // if set is below maximum desired size, store it in shared prefs
            editor.putStringSet(LOCATION_SET_KEY, set);
            editor.apply();
        }

        Log.i("set contains: ", set.toString());
    }
}
