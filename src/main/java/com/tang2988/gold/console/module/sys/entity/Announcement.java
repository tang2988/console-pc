package com.tang2988.gold.console.module.sys.entity;

public class Announcement {
	
	public Long announcementId;
	public String title;
	public String content;
	public String imageruri;
	public Announcement() {
	}
	public Long getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageruri() {
		return imageruri;
	}
	public void setImageruri(String imageruri) {
		this.imageruri = imageruri;
	}
	public String toString() {
		return "Announcement [announcementId=" + announcementId + ", title="
				+ title + ", content=" + content + ", imageruri=" + imageruri
				+ "]";
	}
	
	


}
