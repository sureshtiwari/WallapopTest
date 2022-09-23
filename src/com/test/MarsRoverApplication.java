package com.test;

import com.test.entities.*;
import com.test.service.MarsRoverService;
import com.test.service.RoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MarsRoverApplication {

    private static final Logger logger = LoggerFactory.getLogger(MarsRoverApplication.class);

    public static void main(String[] args) {
        Planet mars = new Mars();
        Rover marsRover = new MarsRover();
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        mars.length = reader.nextInt();
        System.out.println("Insert vertical map size:");
        mars.breadth = reader.nextInt();
        System.out.println("Insert horizontal initial rover position:");
        marsRover.roverPosition.x = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        marsRover.roverPosition.y = reader.nextInt();
        System.out.println("Insert initial rover direction:");
        marsRover.direction = reader.next(); //n = north, e = east, w = west, s = south
        RoverService marsRoverService = new MarsRoverService();
        String choice;
        do {
            System.out.println("Would you like to add Obstacles : y for yes , n for No");
            choice = reader.next();
            if (choice.equals("y")) {

                System.out.println("Enter Obstacles x Coordinate : ");
                int x = reader.nextInt();
                System.out.println("Enter Obstacles y Coordinate : ");
                int y = reader.nextInt();
                Position position = new Position(x,y);
                if (position.validatePosition(mars))
                    mars.obstacles.add(position);
                else {
                    System.out.println("Please Enter the correct Coordinates for Obstacle");
                    logger.debug("Invalid Coordinates");
                }
            }
        } while (choice.equals("y"));
        Command command = new MarsRoverCommand();
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            command.code = reader.next();
            if (command.code.equals("f"))
                marsRoverService.moveForward(mars, marsRover);
            if (command.code.equals("b"))
                marsRoverService.moveBackwards(mars, marsRover);
            marsRoverService.changeDirection(marsRover, command);
            System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.roverPosition.x, marsRover.roverPosition.y, marsRover.direction));
        } while (true);
    }
}

