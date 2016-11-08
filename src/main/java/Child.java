import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by toddkinsman on 11/8/16.
 */
public class Child implements Runnable {

    private final Logger logger = Logger.getLogger(this.getClass());

    private String childName;
    private String childCostume;
    Date inTime;

    Home home;

    public Child(Home home) {
        this.home = home;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildCostume() {
        return childCostume;
    }

    public void setChildCostume(String childCostume) {
        this.childCostume = childCostume;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    private synchronized void goTrickOrTreating()
    {
        home.addVisitor(this);


    }
    public void run() {
        goTrickOrTreating();
    }
}
