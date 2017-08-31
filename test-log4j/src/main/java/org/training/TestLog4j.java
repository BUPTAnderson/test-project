package org.training;

import org.apache.log4j.Logger;

/**
 * Created by anderson on 17-8-29.
 */
public class TestLog4j
{
    public static Logger logger = Logger.getLogger("apiCallLogger");
    public static Logger logger2 = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args)
    {
        long i = 0L;
//        int j = 0;
        while (true) {
            logger.info("i=" + i++ + "\t, test minute file");
//            logger2.error("jj=" + j++ + ", test");
            try {
                Thread.currentThread().sleep(1000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
