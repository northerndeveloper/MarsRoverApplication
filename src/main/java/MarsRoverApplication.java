import contant.DirectionConstants;
import entity.Axis;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.MarsRoverService;

public class MarsRoverApplication {

    private static final Logger logger = LogManager.getLogger(MarsRoverApplication.class);

    private static MarsRoverService marsRoverService = new MarsRoverService();

    /**
     * Main method of Mars Rover Application
     *
     * @param args
     */
    public static void main(String args[]) {
        MarsRoverApplication rover = new MarsRoverApplication();
        Axis axis = new Axis(4, 2, DirectionConstants.East);
        logger.info("Mars Rover Application will work from initial x coordinate" + 4 + " for y coordinate "
                + 2 + " for Direction East");
        logger.info(" Commands executed for the mars rover is " + "FLFFFRFLB");
        marsRoverService.processCommands("FLFFFRFLB", axis);
        marsRoverService.showDirection(axis);
    }
}
