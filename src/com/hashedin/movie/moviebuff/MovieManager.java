package com.hashedin.movie.moviebuff;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hashedin.movie.models.*;
//import com.hashedin.movie.models.MovieDatabase;
//import com.hashedin.movie.models.Rating;
import com.hashedin.movie.parser.*;
//import com.hashedin.movie.parser.HardCodeParser;
//import com.hashedin.movie.parser.MDBParser;

public class MovieManager {


public static void main(String args[])
{
	MDBParser mdb=new FileParser("movie.data","user.data","ratings.data","genre.data");
	//MDBParser mdb=new HardCodeParser();
	MovieBuff movieBuff=new MovieBuff(mdb.getMovieDatabase());
	
	DisplayResults display=new DisplayResults();
	
	List<Movie>mostWatchedMovies=movieBuff.getMostWatchedMovie();
	System.out.println("displayMostWatchedMovie");
	display.displayMostWatchedMovie(mostWatchedMovies);
	
	//List<Movie>topMovieByGenre=movieBuff.getTopMovieByGenre();
	//displayList(topMovieByGenre);
	
	Map<Integer,List<Movie>>topMovieByYear=movieBuff.getTopMovieByYear();
	System.out.println("displayTopMovieByYear");
	display.displayTopMovieByYear(topMovieByYear);
	
	List<Genre> genre=movieBuff.getMostWathedGenre();
	System.out.println("\n\ndisplayMostWatchedGenre");
	display.displayGenreList(genre);

	List<User> mostActiveUser=movieBuff.getMostActiveUser();
	System.out.println("\n\ndisplayMostActiveUser");
	display.displayUserList(mostActiveUser);
	
	Set<Genre> genreSet=movieBuff.getHighestRatedGenre();
	System.out.println("\n\ndisplayHighestRatedGenre");
    display.displayGenreSet(genreSet);
	
	
}





 

}