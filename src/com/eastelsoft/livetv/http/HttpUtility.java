package com.eastelsoft.livetv.http;

import java.util.Map;

public class HttpUtility {

	private static HttpUtility httpUtility = new HttpUtility();

    private HttpUtility() {
    }

    public static HttpUtility getInstance() {
        return httpUtility;
    }

    public String executeNormalTask(HttpMethod httpMethod, String url, Map<String, String> param) throws Exception {
        return new JavaHttpUtility().executeNormalTask(httpMethod, url, param);
    }

}
