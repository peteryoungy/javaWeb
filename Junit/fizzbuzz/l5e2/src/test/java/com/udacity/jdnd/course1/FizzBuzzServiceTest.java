package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	public void testBuzzFizz(){

		FizzBuzzService fbs = new FizzBuzzService();

		// when occurrence > 0
		assertEquals("10", fbs.buzzFizz("Buzz",2));
		assertEquals("9", fbs.buzzFizz("Fizz",3));
		assertEquals("10", fbs.buzzFizz("FizzBuzz",2));

		// occurrence <= 0
		assertEquals("10", fbs.buzzFizz("Buzz",0));
		assertEquals("10", fbs.buzzFizz("Buzz",2));

		// input other strings
		assertThrows(NumberFormatException.class, () -> fbs.buzzFizz("lsjd",1));
		assertThrows(NumberFormatException.class, () -> fbs.buzzFizz("sdfsdf",-2);

	}
}
