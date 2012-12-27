package com.hashedin.test;
import java.util.List;

import com.hashedin.movie.models.Movie;
import com.hashedin.movie.moviebuff.MovieBuff;
//import com.hashedin.movie.moviebuff.MovieManager;
import com.hashedin.movie.parser.HardCodeParser;
import com.hashedin.movie.parser.MDBParser;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieBuffTest {

	@Test
	public void test() {
		MDBParser mdb=new HardCodeParser();
		//MovieManager movieManager=new MovieManager();
		MovieBuff movieBuff=new MovieBuff(mdb.getMovieDatabase());
		
		List<Movie> movie=movieBuff.getMostWatchedMovie();
	    assertEquals(2, movie.size());
	    
	    
	}

}
