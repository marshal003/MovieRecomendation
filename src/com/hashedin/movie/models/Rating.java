package com.hashedin.movie.models;

public class Rating {
	private Movie movie;
	private User user;
	int rating;
	public Rating(Movie movie, User user, int rating) {
		
		this.movie = movie;
		this.user = user;
		this.rating = rating;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	


}
