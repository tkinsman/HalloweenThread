import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 11/8/16.
 */
public class HalloweenMainTest {


    public static void main (String[] args) {

        Home home = new Home();

        Riley riley = new Riley(home);
        ChildFactory childFactory = new ChildFactory(home);

        Thread cfThread = new Thread(childFactory);
        Thread rThread = new Thread(riley);

        rThread.start();
        cfThread.start();

    }


}