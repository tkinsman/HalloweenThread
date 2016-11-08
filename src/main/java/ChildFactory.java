import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by toddkinsman on 11/8/16.
 */
public class ChildFactory implements Runnable {

    private final Logger logger = Logger.getLogger(this.getClass());

    Home home;

    public ChildFactory(Home home) {
        this.home = home;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(home);
            child.setInTime(new Date());
            Thread thChile = new Thread(child);
            child.setChildName("" + thChile.getId());
            thChile.start();

            try
            {
                logger.info("Child " + child.getChildName() + " created");
                Thread.sleep(2000);
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}
