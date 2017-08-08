package com.example.HtmlElementsTask;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MapUtils {

	private static void insertToMap(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			map.computeIfPresent(key, (k, v) -> v + 1);
		} else {
			map.put(key, 1);
		}
	}
	
	public static Map<String, Integer> createMap(Elements elements) {
		Map<String, Integer> links = new HashMap<>();
		String[] adress;
		String domain = "";

		for (Element e : elements) {
			adress = e.attr("href").replaceAll("http(s)?://", "").split("/");
			domain = adress[0].replaceAll("www\\.", "");
			insertToMap(links, domain);
		}
		return links;
	}	
}
