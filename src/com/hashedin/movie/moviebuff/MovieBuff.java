package com.hashedin.movie.moviebuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hashedin.movie.models.Genre;
import com.hashedin.movie.models.Movie;
import com.hashedin.movie.models.User;
//import com.hashedin.movie.models.MovieDatabase;
import com.hashedin.movie.models.*;

public class MovieBuff {
	private MovieDatabase movieDatabase;

	public MovieBuff(MovieDatabase movieDatabse) {
		
		this.movieDatabase = movieDatabse;
	}
    
	public List<Movie> getMostWatchedMovie() {
		
		List<Rating>movieRatingList=movieDatabase.getMovieRatingList();
		Map<Movie,Integer>mapMovieToWatchCount=new HashMap<Movie,Integer>();
		List<Movie>mostWatchedMovies=new ArrayList<Movie>();
		for(Rating rating:movieRatingList)
		{
			Movie movie=rating.getMovie();
			int watchCount;
			if(mapMovieToWatchCount.containsKey(movie))
			{
				watchCount=mapMovieToWatchCount.get(movie);
			    watchCount+=1;
			}
			else
				watchCount=1;
			mapMovieToWatchCount.put(movie, watchCount);
		}
		//Movie mostWatchedMovie=null;
		int maxWatchCount=Integer.MIN_VALUE;
		for(Movie movie:mapMovieToWatchCount.keySet())
		{
			int watchCount=mapMovieToWatchCount.get(movie);
			if(watchCount>maxWatchCount)
			{
				mostWatchedMovies.clear();
				mostWatchedMovies.add(movie);
				maxWatchCount=watchCount;
			}
			else if(watchCount==maxWatchCount)
			{
				mostWatchedMovies.add(movie);
		    }
		}	
		return mostWatchedMovies;
	}

	public List<Movie> getTopMovieByGenre() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Map<Integer,List<Movie>> getTopMovieByYear() {
		// TODO Auto-generated method stub
		Map<Integer,List<Movie>>topMovieByYear=new HashMap<Integer,List<Movie>>();
		Map<Integer,Integer>highestRateOfTheYear=new HashMap<Integer,Integer>();
		List<Rating>ratings=movieDatabase.getMovieRatingList();
		Map<Movie,Integer>totalRatingOfMovie=new HashMap<Movie,Integer>();
		
		for(Rating rate:ratings)
		{
			int totalRate=0;
			Movie movie=rate.getMovie();
			if(totalRatingOfMovie.containsKey(movie))
			{
				totalRate=totalRatingOfMovie.get(movie);
				totalRate+=rate.getRating();
			}
			totalRate+=rate.getRating();
			totalRatingOfMovie.put(movie,totalRate);
		}
		
		for(Movie movie:totalRatingOfMovie.keySet())
		{
			int year=Integer.parseInt(movie.getReleaseDate().trim().substring(7));
			int totalRate=totalRatingOfMovie.get(movie);
			List<Movie>listOfTopMovies;
			if(highestRateOfTheYear.containsKey(year))
			{
				if(totalRate>highestRateOfTheYear.get(year))
				{
					highestRateOfTheYear.put(year, totalRate);
					listOfTopMovies=topMovieByYear.get(year);
					listOfTopMovies.clear();
					listOfTopMovies.add(movie);
					topMovieByYear.put(year, listOfTopMovies);
				}
				else if(totalRate==highestRateOfTheYear.get(year))
				{
					listOfTopMovies=topMovieByYear.get(year);
					listOfTopMovies.add(movie);
					
				}
					
			}
			else
			  {
				listOfTopMovies=new ArrayList<Movie>();
				listOfTopMovies.add(movie);
				topMovieByYear.put(year, listOfTopMovies);
				highestRateOfTheYear.put(year, totalRate);
				}
			
		}
		return topMovieByYear;
		
	}

	public List<Genre> getMostWathedGenre() {
		Map<Genre,Integer>genreWatchedCountMap=new HashMap<Genre,Integer>();
		List<Rating>ratings=movieDatabase.getMovieRatingList();
		
		for(Rating rate:ratings)
		{
			Movie movie=rate.getMovie();
			int genreWatchCount=0;
			for(Genre genre:movie.getGenre())
			{
				if(genreWatchedCountMap.containsKey(genre))
				   genreWatchCount=genreWatchedCountMap.get(genre);
				genreWatchedCountMap.put(genre, genreWatchCount+1);
				
			}
		}
        List<Genre>mostWatchedGenreList=new ArrayList<Genre>();
		
		int maxNumberOfWatchedCount=Integer.MIN_VALUE;
		for(Genre user:genreWatchedCountMap.keySet())
		{
			if(genreWatchedCountMap.get(user)>maxNumberOfWatchedCount)
			{
				mostWatchedGenreList.clear();
				mostWatchedGenreList.add(user);  
				maxNumberOfWatchedCount=genreWatchedCountMap.get(user);
			}
		    
		   else if(genreWatchedCountMap.get(user)==maxNumberOfWatchedCount)
			 mostWatchedGenreList.add(user);
		}	
		return mostWatchedGenreList;
		
	}
	

	public List<User> getMostActiveUser() {
		// TODO Auto-generated method stub
		Map<User,Integer>activeUsers=new HashMap<User,Integer>();
		List<Rating>ratings=movieDatabase.getMovieRatingList();
		//Map<Integer,User>userMap=new HashMap<Integer,User>();
		
		for(Rating rate:ratings)
		{
			int moviesRated=0;
			if(activeUsers.containsKey(rate.getUser()))
			{
				moviesRated=activeUsers.get(rate.getUser());
			}
			activeUsers.put(rate.getUser(), moviesRated+1);
			
		}
		List<User>mostActiveUserList=new ArrayList<User>();
		
		int maxNumberOfRating=Integer.MIN_VALUE;
		for(User user:activeUsers.keySet())
		{
			if(activeUsers.get(user)>maxNumberOfRating)
			{
				mostActiveUserList.clear();
				mostActiveUserList.add(user);  
				maxNumberOfRating=activeUsers.get(user);
			}
		    
		   else if(activeUsers.get(user)==maxNumberOfRating)
			 mostActiveUserList.add(user);
		}	
		return mostActiveUserList;
	}

	public Set<Genre> getHighestRatedGenre() {

		List<Rating>ratings=movieDatabase.getMovieRatingList();
		int maxRate=Integer.MIN_VALUE;
		Set<Genre>genreSet=null;
		for(Rating rate:ratings)
		{
			if(maxRate<rate.getRating())
			{
				genreSet=rate.getMovie().getGenre();
			}
		}
		return genreSet ;
	}
		
	}
	
	
	

