package ru.sbt;

import eu.bitwalker.useragentutils.UserAgent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user18 on 27.10.2016.
 */
public class StatisticUserAgent {
    public static final StatisticUserAgent INSTANCE = new StatisticUserAgent();
    private static final Map<String, Integer> browserCount = new HashMap<>();
    private static final Map<String, Integer> osCount = new HashMap<>();

    public static void addUserAgent(String userAgentHeader) {
        String browser = UserAgent.parseUserAgentString(userAgentHeader).getBrowser().getName();
        String os = UserAgent.parseUserAgentString(userAgentHeader).getOperatingSystem().getName();
        browserCount.put(browser, (browserCount.containsKey(browser) ? browserCount.get(browser) : 0) + 1);
        osCount.put(os, (osCount.containsKey(os) ? osCount.get(os) : 0) + 1);
    }

    public Map<String, Integer> getBrowserCount() {
        return browserCount;
    }

    public Map<String, Integer> getOsCount() {
        return osCount;
    }

    public static String statistic() {
        String rezult = "<html><body>Browser<br>-------------------<br>";
        for (Map.Entry<String, Integer> entry : browserCount.entrySet()) {
            rezult += entry.getKey() + " - " + Integer.toString(entry.getValue()) + "<br>";
        }
        rezult += "<br>System<br>-------------------<br>";
        for (Map.Entry<String, Integer> entry : osCount.entrySet()) {
            rezult += entry.getKey() + " - " + Integer.toString(entry.getValue()) + "<br>";
        }
        return rezult + "</html></body>";
    }
}
