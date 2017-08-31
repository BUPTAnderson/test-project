package org.training.log;

import org.apache.log4j.Logger;

/**
 * Created by anderson on 17-8-30.
 */
public class TestCategory
{
    public static Logger logger = Logger.getLogger(TestCategory.class);
    public static void main(String[] args)
    {
        while (true) {
            logger.info("+++++++++++++++++++++++++++++++++");
            try {
                Thread.currentThread().sleep(200L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
