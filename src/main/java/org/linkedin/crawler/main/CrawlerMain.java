package org.linkedin.crawler.main;

import org.linkedin.crawler.interfaces.Crawler;

/**
 * Hello world!
 *
 */
public class CrawlerMain {
	public static void main(String[] args) {
		Crawler test = CrawlerImpl
				.newInstance("https://www.linkedin.com/in/adonissettouf?trk=nav_responsive_tab_profile_pic");
		test.crawl();
	}
}
