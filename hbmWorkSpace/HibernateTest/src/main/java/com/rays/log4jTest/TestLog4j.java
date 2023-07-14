package com.rays.log4jTest;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {

		Logger log = Logger.getLogger(TestLog4j.class);

		log.debug("run dubug........");
		log.info("run info.....");
		log.warn("run warn......");
		log.error("run error.....");
		log.fatal("run fatal......");

		int i = 0;
		int a = 5;

		try {
			int b = a / i;
			System.out.println("B = " + b);
		} catch (Exception e) {
			log.debug("run debug");
		}

	}

}
