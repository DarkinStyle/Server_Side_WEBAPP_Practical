package com.utar.myemployeeapp_full.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;



public class LoggingGeneral {

    private Logger logger = LogManager.getRootLogger();
    public Logger getLogger() {
        return logger;
    }
    public void setEntryPoints(HttpServletRequest request)
    {
        logger.info("Entry Points" + request.getServletPath());
    }

    public void setExitPoints(HttpServletRequest request)
    {
        logger.info("Exit Points" + request.getServletPath());
    }
}
