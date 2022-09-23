package com.test.service;

import com.test.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRoverServiceTest {

    private Planet mars;
    private RoverService marsRoverService;
    private Rover marsRover;

    @BeforeEach
    public void setup()
    {
        mars= new Mars();
        mars.length=7;
        mars.breadth=7;
        marsRoverService=new MarsRoverService();
        marsRover = new MarsRover();
        marsRover.roverPosition.x=0;
        marsRover.roverPosition.y=0;
        marsRover.direction="n";
    }

    @Test
    public void moveForwardTest()
    {
        marsRoverService.moveForward(mars,marsRover);
        Assertions.assertEquals(marsRover.roverPosition.x,0);
        Assertions.assertEquals(marsRover.roverPosition.y,1);
    }

    @Test
    public void moveBackwardsTest()
    {
        marsRoverService.moveBackwards(mars,marsRover);
        Assertions.assertEquals(marsRover.roverPosition.x,0);
        Assertions.assertEquals(marsRover.roverPosition.y,6);
    }

    @Test
    public void changeDirectionLeftTest()
    {
        MarsRoverCommand marsRoverCommand = new MarsRoverCommand();
        marsRoverCommand.code="l";
        marsRoverService.changeDirection(marsRover,marsRoverCommand);
        Assertions.assertEquals(marsRover.direction,"w");
    }

    @Test
    public void changeDirectionRightTest()
    {
        MarsRoverCommand marsRoverCommand = new MarsRoverCommand();
        marsRoverCommand.code="r";
        marsRoverService.changeDirection(marsRover,marsRoverCommand);
        Assertions.assertEquals(marsRover.direction,"e");
    }
}
