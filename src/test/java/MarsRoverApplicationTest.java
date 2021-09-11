import contant.DirectionContants;
import entity.Axis;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.MarsRoverService;

import static org.junit.Assert.assertEquals;

public class MarsRoverApplicationTest {

    public static final int North = 1;
    public static final int East = 2;
    public static final int South = 3;
    public static final int West = 4;
    private MarsRoverService marsRoverService = new MarsRoverService();
    private Axis axis;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @Before
    public void setUp() {
        axis = new Axis(0, 0, DirectionContants.North);
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
    public void testTurnLeft() {

        marsRoverService.turnLeft(axis);
        assertEquals(West, axis.getCurrentMovingDirection());
    }

    @Test
    public void testTurnRight() {

        axis.setCurrentMovingDirection(4);
        marsRoverService.turnRight(axis);
        assertEquals(North, axis.getCurrentMovingDirection());
    }

    @Test
    public void testProcess() {

        axis.setCurrentMovingDirection(3);
        marsRoverService.processSingleCommand('L', axis);
        assertEquals(East, axis.getCurrentMovingDirection());

        marsRoverService.processSingleCommand('R', axis);
        assertEquals(South, axis.getCurrentMovingDirection());
    }
}
