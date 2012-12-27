package com.hashedin.movie.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import com.hashedin.movie.models.MovieDatabase;
import com.hashedin.movie.models.Movie;
import com.hashedin.movie.models.Genre;
import com.hashedin.movie.models.Rating;
import com.hashedin.movie.models.User;

public class HardCodeParser implements MDBParser {
    
	@Override
public  MovieDatabase getMovieDatabase() {
		// TODO Auto-generated method stub
		Map<Integer,Movie> movieMap=movieFileParser();
		
	    Map<Integer,User> userMap=userFileParser();
		
		List<Rating>listOfMovieRating=ratingFileParser(movieMap,userMap);
		
		
		return new MovieDatabase(movieMap,userMap,listOfMovieRating);
	}
    private Map<Integer,Movie>movieFileParser()
    {
    	Map<Integer,Movie> movieMap=new HashMap<Integer,Movie>();
		Set<Genre> genre=new HashSet<Genre>();
		genre.add(Genre.ACTION);
	    movieMap.put(100, new Movie(100,"xyz","12-01-2011","12-01-2011","http://imdb/xyz",genre));
	    genre.clear();
	    genre.add(Genre.COMEDY);
	    genre.add(Genre.ACTION);
	    movieMap.put(101, new Movie(101,"xy","12-01-2011","12-01-2011","http://imdb/xy",genre));
	    return movieMap;
		
    }
    private Map<Integer,User>userFileParser()
    {
    	 Map<Integer,User> userMap=new HashMap<Integer,User>();
 		 userMap.put(12,new User(12,12,'m',"s/wdeveloper",122345 ));
 		 userMap.put(13,new User(13,22,'f',"s/wdeveloper",126345 ));
 		 userMap.put(14,new User(14,25,'f',"s/wdeveloper",127345 ));
		 
    	 return userMap;
    }
    private List<Rating>ratingFileParser(Map<Integer,Movie>movieMap,Map<Integer,User>userMap)
    {
    	List<Rating>listOfMovieRating=new ArrayList<Rating>();
		listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(12),8));
		listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(13),6));
		listOfMovieRating.add(new Rating(movieMap.get(101),userMap.get(14),5));
		listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(14),9));
		listOfMovieRating.add(new Rating(movieMap.get(101),userMap.get(12),4));
		
		return listOfMovieRating;
		
    }
}
