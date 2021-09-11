import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverApplicationTest {

    public static final int North = 1;
    public static final int East = 2;
    public static final int South = 3;
    public static final int West = 4;
    private MarsRoverApplication marsRoverApplication = new MarsRoverApplication();


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @Before
    public void setUp()  {
        marsRoverApplication.yAxis = 0;
        marsRoverApplication.xAxis = 0;
        marsRoverApplication.currentMovingDirection = North;
    }

    @Test
    public void testMoveBackward() {

        marsRoverApplication.yAxis = 2;
        marsRoverApplication.xAxis = 2;

        marsRoverApplication.currentMovingDirection = 1;
        marsRoverApplication.moveBackward();
        assertEquals(1, marsRoverApplication.yAxis);

        marsRoverApplication.currentMovingDirection = 2;
        marsRoverApplication.moveBackward();
        assertEquals(1, marsRoverApplication.xAxis);

        marsRoverApplication.currentMovingDirection = 3;
        marsRoverApplication.moveBackward();
        assertEquals(2, marsRoverApplication.yAxis);

        marsRoverApplication.currentMovingDirection = 4;
        marsRoverApplication.moveBackward();
        assertEquals(2, marsRoverApplication.xAxis);
    }

    @Test
    public void testMoveForward() {

        marsRoverApplication.yAxis = 3;
        marsRoverApplication.xAxis = 3;

        marsRoverApplication.currentMovingDirection = 1;
        marsRoverApplication.moveForward();
        assertEquals(4, marsRoverApplication.yAxis);

        marsRoverApplication.currentMovingDirection = 2;
        marsRoverApplication.moveForward();
        assertEquals(4, marsRoverApplication.xAxis);

        marsRoverApplication.currentMovingDirection = 3;
        marsRoverApplication.moveForward();
        assertEquals(3, marsRoverApplication.yAxis);

        marsRoverApplication.currentMovingDirection = 4;
        marsRoverApplication.moveForward();
        assertEquals(3, marsRoverApplication.xAxis);
    }

    @Test
    public void testTurnLeft() {

        marsRoverApplication.turnLeft();
        assertEquals(West, marsRoverApplication.currentMovingDirection);
    }

    @Test
    public void testTurnRight() {

        marsRoverApplication.currentMovingDirection = 4;
        marsRoverApplication.turnRight();
        assertEquals(North, marsRoverApplication.currentMovingDirection);
    }

    @Test
    public void testProcess() {

        marsRoverApplication.currentMovingDirection = 3;
        marsRoverApplication.processSingleCommand('L');
        assertEquals(East, marsRoverApplication.currentMovingDirection);

        marsRoverApplication.processSingleCommand('R');
        assertEquals(South, marsRoverApplication.currentMovingDirection);
    }
}
