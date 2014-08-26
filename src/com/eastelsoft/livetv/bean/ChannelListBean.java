package com.eastelsoft.livetv.bean;

import java.util.List;

public class ChannelListBean {

	private String id;
	private String name;
	private String audio_only;
	private String m3u8;
	
	private LogoBean logo;
	private SnapBean snap;
	private CurProgramBean cur_program;
	private NextProgramBean next_program;
	private List<ChannelStreamBean> channel_stream;
	private List<RecordStreamBean> record_stream;
	
	private Object cmid;
	
	public CurProgramBean getCur_program() {
		return cur_program;
	}
	public void setCur_program(CurProgramBean cur_program) {
		this.cur_program = cur_program;
	}
	public Object getCmid() {
		return cmid;
	}
	public void setCmid(Object cmid) {
		this.cmid = cmid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAudio_only() {
		return audio_only;
	}
	public void setAudio_only(String audio_only) {
		this.audio_only = audio_only;
	}
	public String getM3u8() {
		return m3u8;
	}
	public void setM3u8(String m3u8) {
		this.m3u8 = m3u8;
	}
	public LogoBean getLogo() {
		return logo;
	}
	public void setLogo(LogoBean logo) {
		this.logo = logo;
	}
	public SnapBean getSnap() {
		return snap;
	}
	public void setSnap(SnapBean snap) {
		this.snap = snap;
	}
	public NextProgramBean getNext_program() {
		return next_program;
	}
	public void setNext_program(NextProgramBean next_program) {
		this.next_program = next_program;
	}
	public List<ChannelStreamBean> getChannel_stream() {
		return channel_stream;
	}
	public void setChannel_stream(List<ChannelStreamBean> channel_stream) {
		this.channel_stream = channel_stream;
	}
	public List<RecordStreamBean> getRecord_stream() {
		return record_stream;
	}
	public void setRecord_stream(List<RecordStreamBean> record_stream) {
		this.record_stream = record_stream;
	}
	
}
