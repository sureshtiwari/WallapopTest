package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarsRoverService implements RoverService {

    private static final Logger logger = LoggerFactory.getLogger(MarsRoverService.class);

    @Override
    public void moveForward(Planet planet, Rover rover) {
        switch (rover.direction) {
            case "n":
                if (rover.y + 1 == planet.breadth)
                    rover.y = 0;
                else
                    rover.y += 1;
                break;

            case "w":
                if (rover.x - 1 < 0)
                    rover.x = planet.length - 1;
                else
                    rover.x -= 1;
                break;

            case "s":
                if (rover.y - 1 < 0)
                    rover.y = planet.breadth - 1;
                else
                    rover.y -= 1;
                break;

            case "e":
                if (rover.x + 1 == planet.length)
                    rover.x = 0;
                else
                    rover.x += 1;
                break;
            default:
                logger.debug("invalid command");
        }
    }

    @Override
    public void moveBackwards(Planet planet, Rover rover) {
        switch (rover.direction) {
            case "n":
                if (rover.y - 1 < 0)
                    rover.y = planet.breadth - 1;
                else
                    rover.y -= 1;
                break;

            case "w":
                if (rover.x + 1 == planet.length)
                    rover.x = 0;
                else
                    rover.x += 1;
                break;

            case "s":
                if (rover.y + 1 == planet.breadth)
                    rover.y = 0;
                else
                    rover.y += 1;
                break;
            case "e":
                if (rover.x - 1 < 0)
                    rover.x = planet.length - 1;
                else
                    rover.x -= 1;
                break;
            default:
                logger.debug("invalid command");
        }


    }

    @Override
    public void changeDirection(Planet planet, Rover rover, Command marsRoverCommand) {
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
                default:logger.debug("Invalid Command");
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
                    default:logger.debug("invalid Command");
                }
            }
        }
    }
}
