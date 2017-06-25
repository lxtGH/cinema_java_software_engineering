package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.Movie;
import util.csvReader_util;

public class testMovieList {

	@Test
	public void test() {
		ArrayList<Movie> list = new csvReader_util().loadMovieFile("files/movies.csv");
		System.out.println(list.get(3).getName());
		assertEquals(5, list.size());
	}

}
