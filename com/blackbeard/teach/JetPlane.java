package com.blackbeard.teach;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    /**
     * JetPlane constructor with aurguments from the base class Aircraft
     * @param name -
     * @param coordinates -
     */
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    /**
     * This will request the weather from the weatherTower and based on the
     * conditions, it will modify the coordinates
     * If the height of the flyable is 0 (meaning the flight has landed)
     * it will unregister it from the weatherTower
     */

    public void updateConditions()
    {
        if (weatherTower.getWeather(coordinates).equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "This is some nice weather we are having. Nice clear blue skies"));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        if (weatherTower.getWeather(coordinates).equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "Captain Teach here! This weather is taking a turn for the worst!"));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        if (weatherTower.getWeather(coordinates).equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "JetPlane to WeatherTower, we can't see a thing over here!"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

        }
        if (weatherTower.getWeather(coordinates).equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "Command, JetPlane Captain Teach! Reporting sightings of whiteWalkers on the wings"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "is crash landing brace yourself! MAYDAY!MAYDAY!"));
            weatherTower.unregister(this);
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        LogMessage.addString(LogMessage.formatStringTowerJetPlane(this, "registered to weather."));
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
