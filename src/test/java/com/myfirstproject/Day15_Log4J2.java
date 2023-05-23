package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());
    @Test
    public void loggerTest1 (){
        logger.fatal("Fatal log ... ");
        logger.error("Error log ... ");
        logger.warn("Warning log ... ");//NOT YET
        logger.debug("Debug log ... ");//NOT YET
        logger.info("Info log ... ");//NOT YET

    }
    @Test
    public void logTest2 (){
        LoggerUtils.fatal("Fatal log");
        LoggerUtils.info("Info log");
        LoggerUtils.error("Error log");

    }
}
