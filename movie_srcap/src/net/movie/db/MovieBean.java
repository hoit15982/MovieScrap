package net.movie.db;

import java.util.Date;

public class MovieBean {
	private int ms_no;				//no
	private String mb_id;			//id session으로 받아올 id 값
	private String ms_title;		//title 한글명
	private String ms_subtitle;	//subtitle 영어명
	private String ms_director;	//director 감독
	private String ms_actor;		//actor 배우
	private int ms_pubDate;			//pubDate 개봉년도
	private int ms_userRating;			//userRating
	private String ms_img;			//image
	private String ms_story;		//줄거리 다른 API 참고
	private String ms_review;		//작성된 리뷰 (textarea)
	private Date ms_regdate;		//스크랩 날짜
	
	
	public int getMs_no() {
		return ms_no;
	}
	public void setMs_no(int ms_no) {
		this.ms_no = ms_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMs_title() {
		return ms_title;
	}
	public void setMs_title(String ms_title) {
		this.ms_title = ms_title;
	}
	public String getMs_subtitle() {
		return ms_subtitle;
	}
	public void setMs_subtitle(String ms_subtitle) {
		this.ms_subtitle = ms_subtitle;
	}
	public String getMs_director() {
		return ms_director;
	}
	public void setMs_director(String ms_director) {
		this.ms_director = ms_director;
	}
	public String getMs_actor() {
		return ms_actor;
	}
	public void setMs_actor(String ms_actor) {
		this.ms_actor = ms_actor;
	}
	public int getMs_pubDate() {
		return ms_pubDate;
	}
	public void setMs_pubDate(int ms_pubDate) {
		this.ms_pubDate = ms_pubDate;
	}
	public int getMs_userRating() {
		return ms_userRating;
	}
	public void setMs_userRating(int ms_userRating) {
		this.ms_userRating = ms_userRating;
	}
	public String getMs_img() {
		return ms_img;
	}
	public void setMs_img(String ms_img) {
		this.ms_img = ms_img;
	}
	public String getMs_story() {
		return ms_story;
	}
	public void setMs_story(String ms_story) {
		this.ms_story = ms_story;
	}
	public String getMs_review() {
		return ms_review;
	}
	public void setMs_review(String ms_review) {
		this.ms_review = ms_review;
	}
	public Date getMs_regdate() {
		return ms_regdate;
	}
	public void setMs_regdate(Date ms_regdate) {
		this.ms_regdate = ms_regdate;
	}
	
	

	

}
