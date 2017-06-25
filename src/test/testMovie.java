package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.Movie;

public class testMovie {

	@Test
	public void test() {
		Movie movie = new Movie(123, "test", "130", "testCase", "D:", 45.3);
		assertEquals(45, (int)movie.getPrice());
		assertEquals(123, movie.getId());
	}

}
