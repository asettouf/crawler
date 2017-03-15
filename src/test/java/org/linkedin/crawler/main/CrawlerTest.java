package org.linkedin.crawler.main;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.linkedin.crawler.utils.Section;

public class CrawlerTest {

	private static CrawlerImpl crawlerTest;

	@Before
	public void initCrawler() {
		crawlerTest = CrawlerImpl
				.newInstance("https://www.linkedin.com/in/adonissettouf?trk=nav_responsive_tab_profile_pic", Section.EDUCATION);
	}

	@Test
	public void test() {
		assertTrue("Crawler is not working", crawlerTest.isPageCorrect("Adonis Settouf"));
	}

}
