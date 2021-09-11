package service;

import contant.DirectionConstants;
import entity.Axis;
import enums.Direction;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Data
public class MarsRoverService {

    private static final Logger logger = LogManager.getLogger(MarsRoverService.class);

    /**
     * Shows direction according to the axis
     *
     * @param axis
     */
    public void showDirection(Axis axis) {

        String direction;

        switch (axis.getCurrentMovingDirection()) {

            case 1:
                direction = Direction.NORTH.getDirection();
                break;
            case 2:
                direction = Direction.EAST.getDirection();
                break;
            case 3:
                direction = Direction.SOUTH.getDirection();
                break;
            case 4:
                direction = Direction.WEST.getDirection();
                break;
            default:
                logger.error("Moving direction should be North , East, South or West. Other parameters are not accepted");
                throw new IllegalArgumentException(
                        "Moving direction should be North , East, South or West. Other parameters are not accepted");

        }
        System.out.println("(" + axis.getXAxis() + "," + axis.getYAxis() + ") " + direction);
        logger.info("(" + axis.getXAxis() + "," + axis.getYAxis() + ") " + direction);
    }

    /**
     * Processes given commands
     *
     * @param marsRoverCommands
     * @param axis
     */
    public void processCommands(String marsRoverCommands, Axis axis) {

        for (int command = 0; command < marsRoverCommands.length(); command++) {
            processSingleCommand(marsRoverCommands.charAt(command), axis);
        }
    }

    /**
     * Processes single command for each move from the axis
     *
     * @param marsRoverCommand
     * @param axis
     */
    public void processSingleCommand(Character marsRoverCommand, Axis axis) {

        switch (marsRoverCommand) {
            case DirectionConstants.LEFT:
                turnLeft(axis);
                break;
            case DirectionConstants.RIGHT:
                turnRight(axis);
                break;
            case DirectionConstants.FORWARD:
                moveForward(axis);
                break;
            case DirectionConstants.BACKWARD:
                moveBackward(axis);
                break;
            default:
                throw new IllegalArgumentException(
                        "Proper accepted commands are L R F and B");
        }
    }

    /**
     * Rover moves forward
     *
     * @param axis
     */
    public void moveForward(Axis axis) {

        if (axis.getCurrentMovingDirection() == DirectionConstants.North) {
            axis.setYAxis(axis.getYAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.East) {
            axis.setXAxis(axis.getXAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.South) {
            axis.setYAxis(axis.getYAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.West) {
            axis.setXAxis(axis.getXAxis() - 1);
        }
    }

    /**
     * Rover moves backward
     *
     * @param axis
     */
    public void moveBackward(Axis axis) {

        if (axis.getCurrentMovingDirection() == DirectionConstants.North) {
            axis.setYAxis(axis.getYAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.East) {
            axis.setXAxis(axis.getXAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.South) {
            axis.setYAxis(axis.getYAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionConstants.West) {
            axis.setXAxis(axis.getXAxis() + 1);
        }
    }

    /**
     * Rover turns left
     *
     * @param axis
     */
    public void turnLeft(Axis axis) {
        axis.setCurrentMovingDirection((axis.getCurrentMovingDirection() - 1) < DirectionConstants.North ? DirectionConstants.West : axis.getCurrentMovingDirection() - 1);
    }

    /**
     * Rover turns right
     *
     * @param axis
     */
    public void turnRight(Axis axis) {
        axis.setCurrentMovingDirection((axis.getCurrentMovingDirection() + 1) > DirectionConstants.West ? DirectionConstants.North : axis.getCurrentMovingDirection() + 1);
    }

}
