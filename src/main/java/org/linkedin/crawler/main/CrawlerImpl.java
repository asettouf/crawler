package org.linkedin.crawler.main;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.linkedin.crawler.interfaces.Crawler;

public class CrawlerImpl implements Crawler {

	private Document linkedinPage;
	private final static Logger logger = LogManager.getLogger();

	private CrawlerImpl() {
		super();
	}

	private CrawlerImpl(Document linkedinPage) {
		super();
		this.linkedinPage = linkedinPage;
	}

	public static Crawler newInstance(String baseUri) {
		logger.debug("Creating new crawler");
		Document result = null;
		try {
			result = Jsoup.connect(baseUri).get();
		} catch (IOException e) {
			logger.warn("This crawler probably doesn't do what you want");
			logger.error("Error while creating document, default crawler will be returned", e);
		}
		if (result == null) {
			return new CrawlerImpl();
		} else {
			return new CrawlerImpl(result);
		}
	}

	public void run() {

	}

	public void crawl() {
		logger.debug("Page " + isPageCorrect());
	}
	
	private boolean isPageCorrect(){
		if (this.linkedinPage.text().contains("Google")) {
			logger.debug("This is google!");
			logger.debug(linkedinPage);
			return true;
		} else {
			logger.debug("Shit I fucked up");
			logger.debug(linkedinPage.baseUri());
			return false;
		}
	}

	// defensive copying
	public Document getLinkedinPage() {
		return new Document(linkedinPage.baseUri());
	}

}
