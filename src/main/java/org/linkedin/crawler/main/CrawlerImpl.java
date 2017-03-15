package org.linkedin.crawler.main;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.linkedin.crawler.interfaces.Crawler;
import org.linkedin.crawler.utils.Section;

public class CrawlerImpl implements Crawler {

	private Document linkedinPage;
	private final String defaultUrl = "http://google.fr";
	private final static Logger logger = LogManager.getLogger();
	private final Elements crawlSection;
	@SuppressWarnings("unused")
	private Section section;

	@Override
	public void run() {
		this.crawl();

	}

	private CrawlerImpl() {
		super();
		this.crawlSection = null;
		try {
			this.linkedinPage = Jsoup.connect(defaultUrl).get();
		} catch (IOException e) {
			this.linkedinPage = null;
			logger.error("Error creating the default crawler", e);
		}
	}

	private CrawlerImpl(Document linkedinPage, Section section) {
		super();
		this.linkedinPage = linkedinPage;
		this.section = section;
		this.crawlSection = this.linkedinPage
				.select("#" + section.getIdAttribute());
	}

	public static CrawlerImpl newInstance(String baseUri, Section section) {
		logger.debug("Creating new crawler");
		Document result = null;
		try {
			result = Jsoup.connect(baseUri).get();
		} catch (IOException e) {
			logger.error(
					"Error while creating document, default crawler will be returned with google url",
					e);
		}
		if (result == null) {
			return new CrawlerImpl();
		} else {
			return new CrawlerImpl(result, section);
		}
	}

	@Override
	public void crawl() {
		logger.debug(this.crawlSection.html());

	}

	public boolean isPageCorrect(String checker) {
		logger.debug("Checking page is correct");
		if (this.linkedinPage.text().contains(checker)) {
			logger.debug("This is linkedin!");
			logger.debug(linkedinPage.text());
			return true;
		} else {
			logger.debug("Shit I fucked up");
			logger.debug(linkedinPage.text());
			return false;
		}
	}

}
