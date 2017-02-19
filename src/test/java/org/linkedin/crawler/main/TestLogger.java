package org.linkedin.crawler.main;

import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLogger {
	private final static Logger logger = LogManager.getLogger();
	@Test
	public void test() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        logger.debug(logger.getName());
		fail("Not yet implemented");
	}

}
