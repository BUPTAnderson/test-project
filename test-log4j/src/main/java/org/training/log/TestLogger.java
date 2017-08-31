package org.training.log;

import org.apache.log4j.Logger;

/**
 * Created by anderson on 17-8-30.
 */
public class TestLogger
{
    public static Logger logger = Logger.getLogger(TestLogger.class);
    public static void main(String[] args)
    {
        while (true) {
            logger.info("========================================");
            try {
                Thread.currentThread().sleep(200L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
