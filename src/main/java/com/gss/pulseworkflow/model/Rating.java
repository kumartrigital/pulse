package com.gss.pulseworkflow.model;

public class Rating {
	
	private String year;
	private String avgRating;
	public Rating(String year, String avgRating) {
		super();
		this.year = year;
		this.avgRating = avgRating;
	}
	public Rating() {
		super();
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public String toString() {
		return "Rating [year=" + year + ", avgRating=" + avgRating + "]";
	} 
	
	

}
