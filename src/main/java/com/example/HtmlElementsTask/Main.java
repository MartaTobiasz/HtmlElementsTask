package com.example.HtmlElementsTask;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {		
		Document doc = Jsoup.connect("http://wawalove.pl").get();
		Elements elements = doc.select("a[href~=http(s)?://]");
		Map<String, Integer> links = MapUtils.createMap(elements);
		links.entrySet().stream().filter(s -> s.getValue() > 2).forEach(System.out::println);	
		links.entrySet().stream().filter(s -> !s.getKey().contains("wp")).forEach(System.out::println);	
	}
}
