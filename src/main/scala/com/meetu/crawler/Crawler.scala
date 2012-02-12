package com.meetu.crawler

import edu.uci.ics.crawler4j.crawler.WebCrawler
import java.util.regex.Pattern
import edu.uci.ics.crawler4j.url.WebURL
import edu.uci.ics.crawler4j.crawler.Page
import edu.uci.ics.crawler4j.parser.HtmlParseData

class Crawler extends WebCrawler {

  val FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g"
    + "|png|tiff?|mid|mp2|mp3|mp4"
    + "|wav|avi|mov|mpeg|ram|m4v|pdf"
    + "|rm|smil|wmv|swf|wma|zip|rar|gz))$")

  override def shouldVisit(url: WebURL): Boolean = {
    val href = url.getURL.toLowerCase
    !FILTERS.matcher(href).matches() && href.startsWith("http://www.ics.uci.edu/")
  }

  override def visit(page: Page): Unit = {
    val url = page.getWebURL.getURL
    println("URL: " + url)

    page.getParseData match {
      case parsedData: HtmlParseData =>
        val text = parsedData.getText
        val html = parsedData.getHtml
        val links = parsedData.getOutgoingUrls
        println("Text Length: " + text.length)
        println("Html Length: " + html.length)
        println("Putgoing Links: " + links.size)
    }

  }

}