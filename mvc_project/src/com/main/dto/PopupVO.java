package com.main.dto;

import java.util.Date;

public class PopupVO {
	private int po_idx;
	private String po_device;
	private Date po_begin_time;
	private Date po_end_time;
	private int po_disable_hours;
	private int po_left;
	private int po_top;
	private int po_height;
	private int po_width;
	private String po_subject;
	private String po_content;
	
	public int getPo_idx() {
		return po_idx;
	}
	public void setPo_idx(int po_idx) {
		this.po_idx = po_idx;
	}
	public String getPo_device() {
		return po_device;
	}
	public void setPo_device(String po_device) {
		this.po_device = po_device;
	}
	public Date getPo_begin_time() {
		return po_begin_time;
	}
	public void setPo_begin_time(Date po_begin_time) {
		this.po_begin_time = po_begin_time;
	}
	public Date getPo_end_time() {
		return po_end_time;
	}
	public void setPo_end_time(Date po_end_time) {
		this.po_end_time = po_end_time;
	}
	public int getPo_disable_hours() {
		return po_disable_hours;
	}
	public void setPo_disable_hours(int po_disable_hours) {
		this.po_disable_hours = po_disable_hours;
	}
	public int getPo_left() {
		return po_left;
	}
	public void setPo_left(int po_left) {
		this.po_left = po_left;
	}
	public int getPo_top() {
		return po_top;
	}
	public void setPo_top(int po_top) {
		this.po_top = po_top;
	}
	public int getPo_height() {
		return po_height;
	}
	public void setPo_height(int po_height) {
		this.po_height = po_height;
	}
	public int getPo_width() {
		return po_width;
	}
	public void setPo_width(int po_width) {
		this.po_width = po_width;
	}
	public String getPo_subject() {
		return po_subject;
	}
	public void setPo_subject(String po_subject) {
		this.po_subject = po_subject;
	}
	public String getPo_content() {
		return po_content;
	}
	public void setPo_content(String po_content) {
		this.po_content = po_content;
	}
	@Override
	public String toString() {
		return "PopupVO [po_idx=" + po_idx + ", po_device=" + po_device + ", po_begin_time=" + po_begin_time
				+ ", po_end_time=" + po_end_time + ", po_disable_hours=" + po_disable_hours + ", po_left=" + po_left
				+ ", po_top=" + po_top + ", po_height=" + po_height + ", po_width=" + po_width + ", po_subject="
				+ po_subject + ", po_content=" + po_content + "]";
	}

}
