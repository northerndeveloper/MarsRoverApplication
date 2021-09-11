import contant.DirectionConstants;
import entity.Axis;
import org.junit.Before;
import org.junit.Test;
import service.MarsRoverService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Positive and Negative cases for Mars Rover Application
 */
public class MarsRoverApplicationTest {

    public static final int North = 1;
    public static final int East = 2;
    public static final int South = 3;
    public static final int West = 4;
    private MarsRoverService marsRoverService = new MarsRoverService();
    private Axis axis;

    @Before
    public void setUp() {
        axis = new Axis(0, 0, DirectionConstants.North);
    }

    @Test
    public void testMoveBackward() {

        axis = new Axis(2, 2, 1);
        marsRoverService.moveBackward(axis);
        assertEquals(1, axis.getYAxis());

        axis.setCurrentMovingDirection(2);
        marsRoverService.moveBackward(axis);
        assertEquals(1, axis.getXAxis());

        axis.setCurrentMovingDirection(3);
        marsRoverService.moveBackward(axis);
        assertEquals(2, axis.getYAxis());

        axis.setCurrentMovingDirection(4);
        marsRoverService.moveBackward(axis);
        assertEquals(2, axis.getXAxis());
    }

    @Test
    public void testMoveBackwardFails() {

        axis = new Axis(3, 3, 1);
        marsRoverService.moveBackward(axis);
        assertNotEquals(4, axis.getYAxis());
    }

    @Test
    public void testMoveForward() {

        axis = new Axis(3, 3, 1);
        marsRoverService.moveForward(axis);
        assertEquals(4, axis.getYAxis());

        axis.setCurrentMovingDirection(2);
        marsRoverService.moveForward(axis);
        assertEquals(4, axis.getXAxis());

        axis.setCurrentMovingDirection(3);
        marsRoverService.moveForward(axis);
        assertEquals(3, axis.getYAxis());

        axis.setCurrentMovingDirection(4);
        marsRoverService.moveForward(axis);
        assertEquals(3, axis.getXAxis());
    }

    @Test
    public void testMoveForwardFails() {

        axis = new Axis(3, 3, 1);
        marsRoverService.moveForward(axis);
        assertNotEquals(2, axis.getYAxis());
    }

    @Test
    public void testTurnLeft() {

        marsRoverService.turnLeft(axis);
        assertEquals(West, axis.getCurrentMovingDirection());
    }

    @Test
    public void testTurnLeftFails() {

        marsRoverService.turnLeft(axis);
        assertNotEquals(East, axis.getCurrentMovingDirection());
    }

    @Test
    public void testTurnRight() {

        axis.setCurrentMovingDirection(4);
        marsRoverService.turnRight(axis);
        assertEquals(North, axis.getCurrentMovingDirection());
    }

    @Test
    public void testTurnRightFails() {

        axis.setCurrentMovingDirection(4);
        marsRoverService.turnRight(axis);
        assertNotEquals(South, axis.getCurrentMovingDirection());
    }

    @Test
    public void testProcess() {

        axis.setCurrentMovingDirection(3);
        marsRoverService.processSingleCommand('L', axis);
        assertEquals(East, axis.getCurrentMovingDirection());

        marsRoverService.processSingleCommand('R', axis);
        assertEquals(South, axis.getCurrentMovingDirection());
    }

    @Test
    public void testProcessFails() {

        axis.setCurrentMovingDirection(3);
        marsRoverService.processSingleCommand('R', axis);
        assertNotEquals(North, axis.getCurrentMovingDirection());

        marsRoverService.processSingleCommand('L', axis);
        assertNotEquals(East, axis.getCurrentMovingDirection());
    }
}
