Command line OpenWeather API application to pull current weather data from any city.  
To test the weatherAPI you will need to clone the repository with Git and then build the project with maven.  
The project is a proof of concept of a simple command line weatherAPI application to stream weather data on cities across the world.  
PS C:\Users\zuck1\WeatherAPI\WeatherAPI_1\weatherapp1> mvn compile exec:java "-Dexec.mainClass=com.example.Main"  

```
PS C:\Users\zuck1\WeatherAPI\WeatherAPI_1\weatherapp1> mvn compile exec:java "-Dexec.mainClass=com.example.Main"
[INFO] Scanning for projects...
[INFO] Building weatherapp1 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ weatherapp1 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\zuck1\WeatherAPI\WeatherAPI_1\weatherapp1\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ weatherapp1 ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] --- exec:3.6.3:java (default-cli) @ weatherapp1 ---

===== Weather Application Menu =====
1. Add a city to favorites
2. Remove a city from favorites
3. Display favorite city weather
4. Display weather for any city
5. Exit
Select an option (1-5): 1

To add a city to your favorites fill out the following fields -> (City Name, State Code, Country Code)
City Name : Pittsburgh
State Code : PA
Country Code : US
https://api.openweathermap.org/data/2.5/weather?lat=40.4416941&lon=-79.9900861&appid=38da3800bb2c7aa2137b87590e81e874
Added Pittsburgh to favorites.
Current size of favorites list : 1

===== Weather Application Menu =====
1. Add a city to favorites
2. Remove a city from favorites
3. Display favorite city weather
4. Display weather for any city
5. Exit
Select an option (1-5): 1

To add a city to your favorites fill out the following fields -> (City Name, State Code, Country Code)
City Name : Berlin
State Code :
Country Code : DE
https://api.openweathermap.org/data/2.5/weather?lat=52.5170365&lon=13.3888599&appid=38da3800bb2c7aa2137b87590e81e874
Added Berlin to favorites.
Current size of favorites list : 2

===== Weather Application Menu =====
1. Add a city to favorites
2. Remove a city from favorites
3. Display favorite city weather
4. Display weather for any city
5. Exit
Select an option (1-5): 3

Listing options to display...
Index : 0 : location : Pittsburgh
Index : 1 : location : Berlin

Select index to display : 1

Current Weather Conditions
Location : Berlin
Conditions : broken clouds
Temperature : 30.0
Feels Like : 23.0
Max Temp : 31.0
Min Temp : 29.0
Atmospheric Pressure : 999
Humidity : 93
Visibility : 7000
Wind Speed : 3.13/mph
Wind Direction (Degrees) : 182

===== Weather Application Menu =====
1. Add a city to favorites
2. Remove a city from favorites
3. Display favorite city weather
4. Display weather for any city
5. Exit
Select an option (1-5):
```
