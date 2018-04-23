This app uses a MVVM architectual pattern.
The data in Weather Fragment xml is bound to the Weather ViewModel. It observes it and updates the UI when the viewmodel changes(when the API call is made in this case).
The observable uses Live data to do this.
This app implements design patterns observers and singletons(WeatherAPI, and Volley obj)

Instructions:
This app was written in java in Android Studio
Please clone the repository using git and open and run in Android studio