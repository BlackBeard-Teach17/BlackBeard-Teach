package com.blackbeard.teach;

public class AircraftFactory {
    /**
     * Aircraft Factory creates an aircraft instance based on what is passed to it.
     * @param type -
     * @param name
     * @param longitude
     * @param latitude
     * @param height
     * @return
     */
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (longitude < 0 || latitude < 0 )
        {
            throw new IllegalArgumentException("Wrong Aircraft parameters");
        }
        Flyable newOne;
        if (type.equals("Baloon")){
           newOne = new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        else if (type.equals("Helicopter"))
        {
            newOne = new Helicopter(name, new Coordinates(longitude, latitude, height));
        }
        else if (type.equals("JetPlane"))
        {
            newOne = new JetPlane(name, new Coordinates(longitude, latitude, height));
        }
        else
        {
            throw new IllegalArgumentException("Aircraft type does not exist");
        }
        return newOne;
    }
}
