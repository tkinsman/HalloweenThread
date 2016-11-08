import org.apache.log4j.Logger;

/**
 * Created by toddkinsman on 11/8/16.
 */
public class Riley implements Runnable {

    private final Logger logger = Logger.getLogger(this.getClass());

    Home home;

    public Riley(Home home) {
        this.home = home;
    }

    public void run() {
        logger.info("Trick or treating started");
        try {
            logger.info("Riley watches TV");
            Thread.sleep(1000);
        } catch (InterruptedException iex) {
            logger.info("Interruped riley: " + iex);
        }

        logger.info("Riley answers the door");
        while (true) {

            home.handOutCandy();

        }
    }
}
