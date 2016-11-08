import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by toddkinsman on 11/8/16.
 */
public class Home {

    private final Logger logger = Logger.getLogger(this.getClass());

    int childLimit;
    volatile List<Child> trickTreaters;

    public Home() {
        childLimit = 10;
        trickTreaters = new LinkedList<Child>();

    }

    public void handOutCandy() {

        Child child;

        synchronized (trickTreaters) {
            while (trickTreaters.size() == 0) {


                try {
                    trickTreaters.wait();
                } catch (InterruptedException iex) {
                    logger.info("Interuption of waiting in home");
                }
            }


            child = (Child) ((LinkedList<?>)trickTreaters).poll();
            logger.info("Trick or treater found in queue by name " + child.getChildName());
        }


        try {

            logger.info("Handing out candy to " + child.getChildName());

            //how long it takes to hand out candy
            TimeUnit.SECONDS.sleep(3);

        } catch(InterruptedException iex) {
            logger.info("The interruption of handing out candy" + iex);
        }

        logger.info("Finishing handing out candy to " + child.getChildName() + " at time " + child.getInTime());

    }

    public void addVisitor(Child child) {

        logger.info("Child " + child.getChildName() + " rings doorbell at " + child.getInTime());

        synchronized (trickTreaters) {

            if (trickTreaters.size() == childLimit) {
                System.out.println("No space available for child " + child.getChildName());
                System.out.println("Child " + child.getChildName() + " leaves...");
                return;
            }

            ((LinkedList<Child>)trickTreaters).offer(child);

            logger.info("Child " + child.getChildName() + " got in candy line");

            if (trickTreaters.size() == 1) {
                trickTreaters.notify();
            }
        }
    }


}
