package com.hashedin.test;
import java.util.Map;

import com.hashedin.movie.models.Movie;
import com.hashedin.movie.models.User;
import com.hashedin.movie.parser.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileParserTest {

	@Test
	public void testMovieParser() {
		FileParser fileParser=new FileParser();
		fileParser.setMovieFile("testMovie");
		Map<Integer,Movie> mapMovie=fileParser.movieParser();
		for(Integer key:mapMovie.keySet())
		{
			System.out.println(mapMovie.get(key));
		}
	}
	@Test
	public void testUserFileParser()
	{
		FileParser fileParser=new FileParser();
		fileParser.setUserFile("testUser");
		
	Map<Integer,User> mapUser=fileParser.userFileParser();
	for(Integer key:mapUser.keySet())
	{
		System.out.println(mapUser.get(key));
	}
	assertEquals(2,mapUser.size());
 }
	//@Test
/*	public void testRatingFileParser()
	{
		FileParser fileParser=new FileParser();
		fileParser.setUserFile("testRating");
		
	List<Rating>=fileParser.ratingFileParser();
	for(Integer key:mapUser.keySet())
	{
		System.out.println(mapUser.get(key));
	}
	assertEquals(2,mapUser.size());
 }*/
}
