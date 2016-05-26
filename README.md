# Harvester

This app is an example meant to show how android apps could gather usage data in a way users would likely not be fond of. It shows a way to harvest user data from an android device. The harvested location data is stored and meant (not working atm) to be send to a server.

The locations are passively harvested even when the app is in background, terminated or the device is in standby mode. 

The app itself is showing a google api map which sets markers for stored and newly registered locations. It is mainly intended for visualizing the locations which could also be received passively while the app was not even running. In a real world app this could be built out into a app providing functionality regarding maps and location, a user could wish for and want. The data would then still be gathered as is and send to some server for use in a way that should be prohibited. 

The app is working with Android API 21 upwards and compiled against API 23. It was tested on an emulated Nexus 5X running an x86 Android 5.0 (API 23).

This is what the app is doing exactly:
- When the activity is started, it presents the use a map. For all stored locations it will place markers on the map.


