package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Actions implements Serializable {
	private Integer actid;
	private String title;
	private String url;
	@Override
	public String toString() {
		return "Actions [actid=" + actid + ", title=" + title + ", url=" + url + ", groups=" + groups + "]";
	}
	private Groups groups;
	public Integer getActid() {
		return actid;
	}
	public void setActid(Integer actid) {
		this.actid = actid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	
}
