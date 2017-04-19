package com.main.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	
	private String bo_table;
	
	private int bo_idx;
	private int bo_eq;
	private String bo_writer;
	private String bo_member;
	private String bo_subject;
	private String bo_content;
	private int bo_is_secret;
	private int bo_is_notice;	
	private String bo_file;
	private String bo_pass;
	private int bo_ref;
	private int bo_level;
	private int bo_step;
	private int bo_hit;
	private Date bo_regdate;
	private int bo_is_view;
	private String bo_ip;
	private String bo_1;
	private String bo_2;
	private String bo_3;
	private String bo_4;
	private String bo_5;
	

	public int getBo_eq() {
		return bo_eq;
	}
	public void setBo_eq(int bo_eq) {
		this.bo_eq = bo_eq;
	}

	public String getBo_table() {
		return bo_table;
	}
	public void setBo_table(String bo_table) {
		this.bo_table = bo_table;
	}
	public int getBo_is_secret() {
		return bo_is_secret;
	}
	public void setBo_is_secret(int bo_is_secret) {
		this.bo_is_secret = bo_is_secret;
	}
	public int getBo_is_notice() {
		return bo_is_notice;
	}
	public void setBo_is_notice(int bo_is_notice) {
		this.bo_is_notice = bo_is_notice;
	}
	public int getBo_is_view() {
		return bo_is_view;
	}
	public void setBo_is_view(int bo_is_view) {
		this.bo_is_view = bo_is_view;
	}
	public int getBo_idx() {
		return bo_idx;
	}
	public void setBo_idx(int bo_idx) {
		this.bo_idx = bo_idx;
	}

	public String getBo_writer() {
		return bo_writer;
	}
	public void setBo_writer(String bo_writer) {
		this.bo_writer = bo_writer;
	}
	public String getBo_member() {
		return bo_member;
	}
	public void setBo_member(String bo_member) {
		this.bo_member = bo_member;
	}
	public String getBo_subject() {
		return bo_subject;
	}
	public void setBo_subject(String bo_subject) {
		this.bo_subject = bo_subject;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}

	public String getBo_file() {
		return bo_file;
	}
	public void setBo_file(String bo_file) {
		this.bo_file = bo_file;
	}
	public String getBo_pass() {
		return bo_pass;
	}
	public void setBo_pass(String bo_pass) {
		this.bo_pass = bo_pass;
	}
	public int getBo_ref() {
		return bo_ref;
	}
	public void setBo_ref(int bo_ref) {
		this.bo_ref = bo_ref;
	}
	public int getBo_level() {
		return bo_level;
	}
	public void setBo_level(int bo_level) {
		this.bo_level = bo_level;
	}
	public int getBo_step() {
		return bo_step;
	}
	public void setBo_step(int bo_step) {
		this.bo_step = bo_step;
	}
	public int getBo_hit() {
		return bo_hit;
	}
	public void setBo_hit(int bo_hit) {
		this.bo_hit = bo_hit;
	}
	public Date getBo_regdate() {
		return bo_regdate;
	}
	public void setBo_regdate(Date bo_regdate) {
		this.bo_regdate = bo_regdate;
	}

	public String getBo_ip() {
		return bo_ip;
	}
	public void setBo_ip(String bo_ip) {
		this.bo_ip = bo_ip;
	}
	public String getBo_1() {
		return bo_1;
	}
	public void setBo_1(String bo_1) {
		this.bo_1 = bo_1;
	}
	public String getBo_2() {
		return bo_2;
	}
	public void setBo_2(String bo_2) {
		this.bo_2 = bo_2;
	}
	public String getBo_3() {
		return bo_3;
	}
	public void setBo_3(String bo_3) {
		this.bo_3 = bo_3;
	}
	public String getBo_4() {
		return bo_4;
	}
	public void setBo_4(String bo_4) {
		this.bo_4 = bo_4;
	}
	public String getBo_5() {
		return bo_5;
	}
	public void setBo_5(String bo_5) {
		this.bo_5 = bo_5;
	}
	@Override
	public String toString() {
		return "BoardVO [bo_table=" + bo_table + ", bo_idx=" + bo_idx + ", bo_eq=" + bo_eq + ", bo_writer=" + bo_writer
				+ ", bo_member=" + bo_member + ", bo_subject=" + bo_subject + ", bo_content=" + bo_content
				+ ", bo_is_secret=" + bo_is_secret + ", bo_is_notice=" + bo_is_notice + ", bo_file=" + bo_file
				+ ", bo_pass=" + bo_pass + ", bo_ref=" + bo_ref + ", bo_level=" + bo_level + ", bo_step=" + bo_step
				+ ", bo_hit=" + bo_hit + ", bo_regdate=" + bo_regdate + ", bo_is_view=" + bo_is_view + ", bo_ip="
				+ bo_ip + ", bo_1=" + bo_1 + ", bo_2=" + bo_2 + ", bo_3=" + bo_3 + ", bo_4=" + bo_4 + ", bo_5=" + bo_5
				+ "]";
	}
	
}
