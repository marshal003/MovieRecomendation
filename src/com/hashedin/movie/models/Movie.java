package com.hashedin.movie.models;

import java.util.Set;

public class Movie {
	int movieID;
	String title;
	String releaseDate;
	String videoReleaseDate;
	String url;
	Set<Genre> genre;


public Movie(int movieID, String title, String releaseDate,
			String videoReleaseDate, String url, Set<Genre> genre) {
		
		this.movieID = movieID;
		this.title = title;
		this.releaseDate = releaseDate;
		this.videoReleaseDate = videoReleaseDate;
		this.url = url;
		this.genre = genre;
	}
public Movie()
{
	
}
public int getMovieID() {
	return movieID;
}
public void setMovieID(int movieID) {
	this.movieID = movieID;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
public String getVideoReleaseDate() {
	return videoReleaseDate;
}
public void setVideoReleaseDate(String videoReleaseDate) {
	this.videoReleaseDate = videoReleaseDate;
}
public String getURL() {
	return url;
}
public void setURL(String uRL) {
	url = uRL;
}
public Set<Genre> getGenre() {
	return genre;
}
public void setGenre(Set<Genre> genre) {
	this.genre = genre;
}
@Override
public String toString() {
	return "Movie [movieID=" + movieID + ", title=" + title + ", releaseDate="
			+ releaseDate + ", videoReleaseDate=" + videoReleaseDate + ", url="
			+ url + ", genre=" + genre + "]";
}

}
