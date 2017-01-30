package com.kudva.oh.model;

import java.util.Date;

public class ChannelInfo {
	private int channelNo;
	private String channelName;
	private String channelCategory;
	private String date;
	public int getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(int channelNo) {
		this.channelNo = channelNo;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelCategory() {
		return channelCategory;
	}
	public void setChannelCategory(String channelCategory) {
		this.channelCategory = channelCategory;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
