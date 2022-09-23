package com.test.service;

import com.test.entities.Command;
import com.test.entities.Planet;
import com.test.entities.Position;
import com.test.entities.Rover;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarsRoverService implements RoverService {

    private static final Logger logger = LoggerFactory.getLogger(MarsRoverService.class);

    @Override
    public void moveForward(Planet planet, Rover rover) {
        Position currentPosition = new Position(rover.roverPosition.x,rover.roverPosition.y);
        switch (rover.direction) {
            case "n":
                if (rover.roverPosition.y + 1 == planet.breadth)
                    rover.roverPosition.y = 0;
                else
                    rover.roverPosition.y += 1;
                break;

            case "w":
                if (rover.roverPosition.x - 1 < 0)
                    rover.roverPosition.x = planet.length - 1;
                else
                    rover.roverPosition.x -= 1;
                break;

            case "s":
                if (rover.roverPosition.y - 1 < 0)
                    rover.roverPosition.y = planet.breadth - 1;
                else
                    rover.roverPosition.y -= 1;
                break;

            case "e":
                if (rover.roverPosition.x + 1 == planet.length)
                    rover.roverPosition.x = 0;
                else
                    rover.roverPosition.x += 1;
                break;
            default:
                logger.debug("invalid command");
        }
        if (checkForObstacles(planet,rover.roverPosition)) {
            rover.roverPosition = currentPosition;
            System.out.println("Cannot Perform movement due to Obstacle");
            logger.debug("There is an obstacles on the path");
        }
    }

    @Override
    public void moveBackwards(Planet planet, Rover rover) {
        switch (rover.direction) {
            case "n":
                if (rover.roverPosition.y - 1 < 0)
                    rover.roverPosition.y = planet.breadth - 1;
                else
                    rover.roverPosition.y -= 1;
                break;

            case "w":
                if (rover.roverPosition.x + 1 == planet.length)
                    rover.roverPosition.x = 0;
                else
                    rover.roverPosition.x += 1;
                break;

            case "s":
                if (rover.roverPosition.y + 1 == planet.breadth)
                    rover.roverPosition.y = 0;
                else
                    rover.roverPosition.y += 1;
                break;
            case "e":
                if (rover.roverPosition.x - 1 < 0)
                    rover.roverPosition.x = planet.length - 1;
                else
                    rover.roverPosition.x -= 1;
                break;
            default:
                logger.debug("invalid command");
        }


    }

    @Override
    public void changeDirection(Rover rover, Command marsRoverCommand) {
        if (marsRoverCommand.code.equals("l")) {
            switch (rover.direction) {
                case "n":
                    rover.direction = "w";
                    break;
                case "w":
                    rover.direction = "s";
                    break;
                case "s":
                    rover.direction = "e";
                    break;
                case "e":
                    rover.direction = "n";
                    break;
                default:
                    logger.debug("Invalid Command");
            }
        }
        if (marsRoverCommand.code.equals("r")) {
            switch (rover.direction) {
                case "n":
                    rover.direction = "e";
                    break;
                case "e":
                    rover.direction = "s";
                    break;
                case "s":
                    rover.direction = "w";
                    break;
                case "w":
                    rover.direction = "n";
                    break;
                default:
                    logger.debug("invalid Command");
            }
        }
    }

    public boolean checkForObstacles(Planet planet,Position position)
    {
        for (Position obstacles:planet.obstacles) {
            if(obstacles.x==position.x && obstacles.y==position.y)
                return true;
        }
        return false;
    }
}


