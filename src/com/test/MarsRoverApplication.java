package com.test;

import com.test.entities.*;
import com.test.service.MarsRoverService;
import com.test.service.RoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MarsRoverApplication {

    private static final Logger logger = LoggerFactory.getLogger(MarsRoverApplication.class);

    public static void main(String args[])
    {
        Planet mars = new Mars();
        Rover marsRover = new MarsRover();
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        mars.length = reader.nextInt();
        System.out.println("Insert vertical map size:");
        mars.breadth = reader.nextInt();
        System.out.println("Insert horizontal initial rover position:");
        marsRover.x = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        marsRover.y = reader.nextInt();
        System.out.println("Insert initial rover direction:");
        marsRover.direction = reader.next(); //n = north, e = east, w = west, s = south
        RoverService marsRoverService = new MarsRoverService();
        Command command = new MarsRoverCommand();
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            command.code = reader.next();
            if (command.code.equals("f"))
                marsRoverService.moveForward(mars,marsRover);
            if (command.code.equals("b"))
                marsRoverService.moveBackwards(mars,marsRover);
            marsRoverService.changeDirection(marsRover,command);
            System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.x, marsRover.y, marsRover.direction));
        } while (true);
    }
}
