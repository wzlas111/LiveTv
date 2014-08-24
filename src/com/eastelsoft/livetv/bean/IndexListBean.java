package com.eastelsoft.livetv.bean;

public class IndexListBean {

	private String id;
	private String order_id;
	private String content_id;
	private String title;
	private String brief;
	private String publish_time;
	
	private IndexPicBean indexpic;
	private VideoBean video;
	private ColumnInfoBean column_info;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	public IndexPicBean getIndexpic() {
		return indexpic;
	}
	public void setIndexpic(IndexPicBean indexpic) {
		this.indexpic = indexpic;
	}
	public VideoBean getVideo() {
		return video;
	}
	public void setVideo(VideoBean video) {
		this.video = video;
	}
	public ColumnInfoBean getColumn_info() {
		return column_info;
	}
	public void setColumn_info(ColumnInfoBean column_info) {
		this.column_info = column_info;
	}
	
}
