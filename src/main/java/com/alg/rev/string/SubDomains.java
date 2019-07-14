package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomains {
	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String domians : cpdomains) {
			String[] singleDomian = domians.split("\\s+");

			subdomain(Integer.valueOf(singleDomian[0]), singleDomian[1], counts);
		}
		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, Integer> count : counts.entrySet()) {
			result.add(new String(count.getValue() + " " + count.getKey()));
		}
		return result;
	}

	public static void subdomain(int count, String domains, Map<String, Integer> counts) {

		while (domains != null) {
			if (counts.get(domains) == null) {
				counts.put(domains, count);
			} else {
				counts.put(domains, counts.get(domains) + count);
			}
			if (domains.indexOf('.') == -1) {
				domains = null;
			} else {
				domains = domains.substring(domains.indexOf('.') + 1, domains.length());
			}

		}
	}

	public static void main(String[] args) {
		subdomainVisits(new String[] { "9001 discuss.leetcode.com", "50 yahoo.com" });

	}

}
