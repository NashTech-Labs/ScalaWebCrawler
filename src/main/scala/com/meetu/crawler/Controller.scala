package com.meetu.crawler

import edu.uci.ics.crawler4j.crawler.CrawlConfig
import edu.uci.ics.crawler4j.crawler.CrawlController
import edu.uci.ics.crawler4j.fetcher.PageFetcher
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer

object Controller extends App {
  val crawlStorageFolder = "/data/crawl/root"
  val numberOfCrawlers = 7

  val config = new CrawlConfig
  config.setCrawlStorageFolder(crawlStorageFolder)

  val pageFetcher = new PageFetcher(config)
  val robotstxtConfig = new RobotstxtConfig
  val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)

  val controller = new CrawlController(config, pageFetcher, robotstxtServer)

  controller.addSeed("http://www.ics.uci.edu/~welling/")
  controller.addSeed("http://www.ics.uci.edu/~lopes/")
  controller.addSeed("http://www.ics.uci.edu/")

  controller.start(classOf[Crawler], numberOfCrawlers)
}