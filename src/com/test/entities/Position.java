package com.test.entities;

public class Position {
    public int x;
    public int y;

    public boolean validatePosition(Planet planet)
    {
        if(this.x>=0 && this.x<planet.length && this.y>=0 && this.y<planet.breadth)
            return true;
        return false;
    }

    public Position(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
