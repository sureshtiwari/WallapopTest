package com.test.service;

import com.test.entities.Planet;
import com.test.entities.Rover;
import com.test.entities.Command;

public interface RoverService {

    void moveForward(Planet planet, Rover rover);

    void moveBackwards(Planet planet, Rover rover);

    void changeDirection(Rover rover, Command marsRoverCommand);
}
