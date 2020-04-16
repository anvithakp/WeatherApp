# WeatherApp
 
App Features:
 
Current Location Capability added via Android Fused Location Provider which is used to display the weather of the current location.
Used Glide library for efficient download of weather icons download & display in imageview
Displayed 5-day weather forecast by an API call to openweathermap.
Feature to dynamically load weather data of a user-desired-location.
 
Android Features used:
 
Used data binding to make a data class directly available to a view
Implemented Navigation for better user experience
Binded views to the ViewModel classes in the app so that the views in the layout communicate directly with the ViewModel objects.
Used LiveData as the data-binding source to notify the UI about changes in the weather data.
Made use of RecyclerView for efficiently displaying large lists.
Made a web service API request and handled the response and implemented a network layer using the Retrofit library.
Parsed the JSON response from the web service into the weather app’s live data using the Moshi Library.
