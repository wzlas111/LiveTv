package com.eastelsoft.livetv.dao;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eastelsoft.livetv.bean.ChannelListBean;
import com.eastelsoft.livetv.http.HttpMethod;
import com.eastelsoft.livetv.http.HttpUtility;
import com.eastelsoft.livetv.utils.Constants;
import com.eastelsoft.livetv.utils.URLHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ChannelListDao {

	public ChannelListDao() {
		
	}
	
	public String getJSON() throws Exception {
		String urlString = URLHelper.URL_CHANNEL_LIST;
		
		Map<String, String> params = new HashMap<>();
		params.put("appkey", Constants.APP_KEY);
		params.put("appid", Constants.APP_ID);
		
		String result = HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, urlString, params);
		return result;
	}
	
	public List<ChannelListBean> getBean() throws Exception {
		String jsonString = getJSON();
		jsonString = jsonString.replace("[]", "null");
		Gson gson = new Gson();
		Type listType = new TypeToken<List<ChannelListBean>>(){}.getType(); 
		List<ChannelListBean> listBean = null;
		try {
			listBean = gson.fromJson(jsonString, listType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBean;
	}
}
