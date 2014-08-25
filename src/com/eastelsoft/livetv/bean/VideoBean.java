package com.eastelsoft.livetv.bean;

public class VideoBean {

	private String host;
	private String dir;
	private String filepath;
	private String filename;
	private String is_audio;
	private String duration;
	private String start;
	private String bitrate;
	
	public String getUrl() {
		return host + "/" + filepath + filename.replace("m3u8", "mp4");
//		return host + "/" + filepath + filename;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getIs_audio() {
		return is_audio;
	}
	public void setIs_audio(String is_audio) {
		this.is_audio = is_audio;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getBitrate() {
		return bitrate;
	}
	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}
	
}
