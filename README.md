# Harvester

This app is an example meant to show how android apps could gather usage data in a way users would likely not be fond of. It shows a way to harvest user data from an android device. The harvested location data is stored and meant (not working atm) to be send to a server.

The locations are passively harvested even when the app is in background, terminated or the device is in standby mode. 

The app itself is showing a google api map which sets markers for stored and newly registered locations. It is mainly intended for visualizing the locations which could also be received passively while the app was not even running. In a real world app this could be built out into an app providing functionality regarding maps and location a user could wish for and want - and thus hiding the real intention of collecting data from the device. The data would then still be gathered as is and send to some server for use in a way that should be prohibited. 

The necessary permission for accessing location data is added to the manifest file of the app without directly being presented to the user. The user would only notice
the permissions of the app by looking at the app info page or in case the app would be available via google play store by having a look at the corresponding page there. 

This is what the app is doing exactly:
- When the activity is started, it presents the user a map. For all stored locations it will place markers on the map.
- The activity starts a pending intent in the form of a broadcast receiver
- this broadcast receiver is idle until the event of a newly received location, it then stores the location in the shared preferences file
  of the application so it remains persistent
- after the storing of the location the receiver intent goes idle again
- if the amount of stored locations is 6 (adjustable via constant), the locations are to be uploaded to a server known by the app and the locations are removed from
  the shared preferences file; this is done to limit the amount of stored data and to limit the amount of times data is send
- the intent stays available and working as described even while the app is in background, terminated or the device is in stand by
- the minimum interval between two registered locations for an updates is set to 1s, the minimum distance between two locations is
  set to 50m (0.01 difference for decimal coordinates is sufficient for registering new locations)

At the start of the app the map will further focus on either the last registered location or the city of Ulm, Germany (about 48.4 latitude, 9.99 longitude decimal degrees). This has absolutely nothing to do with the writer of the app or some university this is linked to. I promise.


The app is working with Android API 21 upwards and compiled against API 23. It was tested on an emulated Nexus 5X running an x86 Android 5.0 (API 23).
