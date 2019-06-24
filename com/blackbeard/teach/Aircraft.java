package com.blackbeard.teach;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    //Default constructor
    public Aircraft() {}
    protected Aircraft (String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private long nextId()
    {
        return idCounter++;
    }
}
