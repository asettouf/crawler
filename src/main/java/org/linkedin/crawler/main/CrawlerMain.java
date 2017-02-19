package org.linkedin.crawler.main;

import org.linkedin.crawler.interfaces.Crawler;

/**
 * Hello world!
 *
 */
public class CrawlerMain 
{
    public static void main( String[] args ){
    	Crawler test = CrawlerImpl.newInstance("https://www.google.fr");
    	test.crawl();
    }
}
