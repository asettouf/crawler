package org.linkedin.crawler.main;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.linkedin.crawler.interfaces.Crawler;

public class CrawlerImpl implements Crawler {

	private Document linkedinPage;
	private final String defaultUrl = "http://google.fr";
	private final static Logger logger = LogManager.getLogger();

	private CrawlerImpl() {
		super();
		try {
			this.linkedinPage = Jsoup.connect(defaultUrl).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CrawlerImpl(Document linkedinPage) {
		super();
		this.linkedinPage = linkedinPage;
	}

	public static CrawlerImpl newInstance(String baseUri) {
		logger.debug("Creating new crawler");
		Document result = null;
		try {
			result = Jsoup.connect(baseUri).get();
		} catch (IOException e) {
			logger.error("Error while creating document, default crawler will be returned with google url", e);
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
		logger.debug("Page " + isPageCorrect("LinkedIn"));

	}

	public boolean isPageCorrect(String checker) {
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

	// defensive copying
	public Document getLinkedinPage() {
		return new Document(linkedinPage.baseUri());
	}

}
