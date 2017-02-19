package org.linkedin.crawler.main;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CrawlerTest {

	private static CrawlerImpl crawlerTest;

	@Before
	public void initCrawler() {
		crawlerTest = CrawlerImpl
				.newInstance("https://www.linkedin.com/in/adonissettouf?trk=nav_responsive_tab_profile_pic");
	}

	@Test
	public void test() {
		assertTrue("Crawler is not working", crawlerTest.isPageCorrect("Adonis Settouf"));
	}

}
