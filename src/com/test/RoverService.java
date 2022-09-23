package com.test;

public interface RoverService {

    void moveForward(Planet planet, Rover rover);

    void moveBackwards(Planet planet, Rover rover);

    void changeDirection(Planet planet, Rover rover,Command marsRoverCommand);
}
