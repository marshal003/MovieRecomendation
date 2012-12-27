package com.hashedin.movie.moviebuff;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hashedin.movie.models.Genre;
import com.hashedin.movie.models.Movie;
import com.hashedin.movie.models.User;

public class DisplayResults {

	

	public void displayTopMovieByYear(Map<Integer, List<Movie>> topMovieByYear) {
		
		for(Integer year:topMovieByYear.keySet())
		{
			System.out.print(year);
			for(Movie movie:topMovieByYear.get(year))
				System.out.print(" "+movie.getTitle());
			System.out.println();
		}
	}

	public void displayGenreList(List<Genre> genreList) {
		
		for(Genre genre:genreList)
			System.out.println(genre);
		
	}

	public void displayUserList(List<User> mostActiveUser) {
		for(User user:mostActiveUser)
			System.out.print(user);
		
		
	}

	public void displayGenreSet(Set<Genre>genreSet) {
       
		for(Genre genre:genreSet)
			System.out.println(genre);
	}

	public void displayMostWatchedMovie(List<Movie> mostWatchedMovies) {
		// TODO Auto-generated method stub
		for(Movie movie:mostWatchedMovies)
			System.out.println(movie.getTitle());
	}

}
