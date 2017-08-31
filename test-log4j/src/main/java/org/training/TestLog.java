package org.training;

import org.apache.log4j.Logger;

/**
 * Created by anderson on 17-8-30.
 */
public class TestLog
{
    public static Logger logger = Logger.getLogger("apiCallLogger");

    public static void main(String[] args)
    {
        int i = 0;
        while (true) {
            logger.info("---------------------------");
            try {
                Thread.currentThread().sleep(200L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
