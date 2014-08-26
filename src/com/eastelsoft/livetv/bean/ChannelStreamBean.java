package com.eastelsoft.livetv.bean;

public class ChannelStreamBean {

	private String url;
	private String m3u8;
	private String bitrate;
	private String live_url;
	private String live_m3u8;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getM3u8() {
		return m3u8;
	}
	public void setM3u8(String m3u8) {
		this.m3u8 = m3u8;
	}
	public String getBitrate() {
		return bitrate;
	}
	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}
	public String getLive_url() {
		return live_url;
	}
	public void setLive_url(String live_url) {
		this.live_url = live_url;
	}
	public String getLive_m3u8() {
		return live_m3u8;
	}
	public void setLive_m3u8(String live_m3u8) {
		this.live_m3u8 = live_m3u8;
	}
	
}
