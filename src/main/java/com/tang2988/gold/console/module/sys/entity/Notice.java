package com.tang2988.gold.console.module.sys.entity;

import java.util.Date;

public class Notice {
	
	public Long noticeId;
	
	public String title;
	public String title2;
	public String content;
	public Date noticeTime;
	public String remark;
	public Date createTime;
	public Integer versionNo;
	public Notice() {
	}
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", title=" + title
				+ ", title2=" + title2 + ", content=" + content
				+ ", noticeTime=" + noticeTime + ", remark=" + remark
				+ ", createTime=" + createTime + ", versionNo=" + versionNo
				+ "]";
	}
	

}
