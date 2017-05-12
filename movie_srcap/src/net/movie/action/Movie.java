package net.movie.action;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
	private String title;
	private String titleOrg;
	private int prodYear;
	private String director;
	private ArrayList<String> actor;
	private String poster;
	
	private String docId;
	private String movieSeq;
	private String movieId;
	
	
	private String nation;
	private String company;
	private String plot;
	private String genre;

	

	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieSeq() {
		return movieSeq;
	}
	public void setMovieSeq(String movieSeq) {
		this.movieSeq = movieSeq;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleOrg() {
		return titleOrg;
	}
	public void setTitleOrg(String titleOrg) {
		this.titleOrg = titleOrg;
	}
	public int getProdYear() {
		return prodYear;
	}
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public ArrayList<String> getActor() {
		return actor;
	}
	public void setActor(ArrayList<String> actor) {
		this.actor = actor;
	}
	
	
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", titleOrg=" + titleOrg + ", prodYear=" + prodYear + ", director=" + director
				+ ", actor=" + actor + ", poster=" + poster + "]";
	}


	
}
