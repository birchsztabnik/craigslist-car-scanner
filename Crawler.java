package com.gmail.birchyboy.s;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler {
	public static Elements get_elements(String url)
	{
		try {
			Document doc = Jsoup.connect(url).get();
			return doc.getElementsByClass("result-title hdrlnk");
		} catch (IOException e) {
			System.out.println("Couldn't connect to "+url);
			e.printStackTrace();
		}
		return null;
	}
}
