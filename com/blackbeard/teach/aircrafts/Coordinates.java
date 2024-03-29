package com.blackbeard.teach.aircrafts;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    /**
     * This will initialize the longitude, latitude, height based on passed parameters
     * @param longitude - positive longitude to be initialized
     * @param latitude - positive latitude to be initialized
     * @param height - Height in the range of 0-100 to be initialized.
     */
    Coordinates (int longitude, int latitude, int height)
    {
        /*Possible need for input validation is in the required range
          Is this right??? I have no idea!! So yes it is right for now
         */
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
