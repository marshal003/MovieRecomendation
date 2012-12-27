package com.hashedin.movie.parser;
import java.util.List;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;



import com.hashedin.movie.models.Genre;
import com.hashedin.movie.models.Movie;
import com.hashedin.movie.models.Rating;
import com.hashedin.movie.models.User;

import com.hashedin.movie.models.MovieDatabase;

public class FileParser implements MDBParser{
String movieFile;
String userFile;
String ratingFile;
String genreFile;

	@Override
	public MovieDatabase getMovieDatabase() {
		// TODO Auto-generated method stub
		Map<Integer,Movie>movieMap=movieParser();
		System.out.println("movie file parsed");
		Map<Integer,User>userMap=userFileParser();
		System.out.println("user file parsed");
		List<Rating>ratingList=ratingFileParser(movieMap,userMap);
		System.out.println("rating file parsed");
		MovieDatabase movieDatabase=new MovieDatabase(movieMap,userMap,ratingList);
		return movieDatabase;
	}

	public FileParser(String movieFile, String userFile, String ratingFile,
			String genreFile) {
		this.movieFile = movieFile;
		this.userFile = userFile;
		this.ratingFile = ratingFile;
		this.genreFile = genreFile;
	}
	public FileParser()
	{
		
		
	}
	public String getMovieFile() {
		return movieFile;
	}

	public void setMovieFile(String movieFile) {
		this.movieFile = movieFile;
	}

	public String getUserFile() {
		return userFile;
	}

	public void setUserFile(String userFile) {
		this.userFile = userFile;
	}

	public String getRatingFile() {
		return ratingFile;
	}

	public void setRatingFile(String ratingFile) {
		this.ratingFile = ratingFile;
	}

	public String getGenreFile() {
		return genreFile;
	}

	public void setGenreFile(String genreFile) {
		this.genreFile = genreFile;
	}

	private List<String>tokenizeLine(String line,String delimeter)
	{
		StringTokenizer st=new StringTokenizer(line,delimeter);
		List<String>lst=new ArrayList<String>();
		while(st.hasMoreElements())
			lst.add(st.nextToken());
		return lst;
	}
	
	
	public Map<Integer,User>userFileParser()
	{
		Map<Integer,User>mapUser=new HashMap<Integer,User>();
		BufferedReader bufferedReader=null;
		try{
		    bufferedReader=new BufferedReader(new FileReader(userFile));
			String line;
		   while((line=bufferedReader.readLine())!=null)
			{
			 List<String>tokens=tokenizeLine(line,"|"); 
			 Iterator<String>itr=tokens.iterator();
			 if(tokens.size()<5)continue;
			 User user=new User();
			 try{
			 user.setUserId(Integer.parseInt(itr.next().trim()));
			 user.setAge(Integer.parseInt(itr.next().trim()));
			 user.setGender(itr.next().trim().charAt(0));
			 user.setOccupation(itr.next());
			 user.setZipCode(Integer.parseInt(itr.next().trim()));
			 mapUser.put(user.getUserId(), user);
			   }
		     catch(NumberFormatException e)
		     {
		    	System.out.println("line cannot be parsed");
		      }
			 
			}
		   
		} catch(IOException e)
	        {
	        	System.out.println("I/o Error file ");
	        }
	        finally{
	        	try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }   	    
			return mapUser;
	}
	
	
	public Map<Integer,Movie>movieParser()
	{
		
		Map<Integer,Movie>mapMovie=new HashMap<Integer,Movie>();
		BufferedReader bufferedReader=null;
		try{
		    bufferedReader=new BufferedReader(new FileReader(movieFile));
			String line;
		   while((line=bufferedReader.readLine())!=null)
			{
			 List<String>tokens=tokenizeLine(line,"|"); 
			 Iterator<String>itr=tokens.iterator();
			 Movie movie=new Movie();
			 try{
			 if(tokens.size()<23)continue;
			 movie.setMovieID(Integer.parseInt(itr.next()));
			 movie.setTitle(itr.next());
			 movie.setReleaseDate(itr.next());
			 movie.setVideoReleaseDate(null);
			 movie.setURL(itr.next());
			 int index=0;
			 Set<Genre>genre=new HashSet<Genre>();
			 while(itr.hasNext())
			 {
				 if(itr.next().equals("1"))
				 {
					genre.add(Genre.values()[index]) ;
					
				 }
				 index+=1;
			 }
			 movie.setGenre(genre);
			 mapMovie.put(movie.getMovieID(), movie);
			 }catch(Exception e)
				{
					System.out.println("this line has error");
				}
			}
			
		}
		catch(IOException e)
		{
		  System.out.println("file cannot be opened");  
		}
		
		finally{
			     try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return mapMovie;
	}
    public List<Rating>ratingFileParser(Map<Integer,Movie>movieMap,Map<Integer,User>userMap)
    {
    	BufferedReader bufferedReader=null; 
    	List<Rating>ratingList=null;
    	try{
    		bufferedReader=new BufferedReader(new FileReader(ratingFile));
    		String line;
    		ratingList=new ArrayList<Rating>();
 		   while((line=bufferedReader.readLine())!=null)
 			{
 			 List<String>tokens=tokenizeLine(line,"\t"); 
 			 Iterator<String>itr=tokens.iterator();
 			 if(tokens.size()<4)continue;
 			 
 			 
 				 try{
 				 int userId=Integer.parseInt(itr.next().trim());
 				 int movieId=Integer.parseInt(itr.next().trim());
 				 if(userMap.containsKey(userId)&& movieMap.containsKey(movieId))
 				 {
 					 User user=userMap.get(userId);
 					 Movie movie=movieMap.get(movieId);
 					 int rate=Integer.parseInt(itr.next().trim());
 					 ratingList.add(new Rating(movie,user,rate));
 				 }
 				 else
 					 continue;
 				 }catch(NumberFormatException e)
 				 {
 					 System.out.println("line cannot be parsed");
 				 }
 			 }
 			
    	}
    	catch(IOException e)
    	{
    	  System.out.println(e);
    	}
    	finally{
    		 try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	}
    	return ratingList;
    }
	
	
}
