import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void testConvertToIntegers_1() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("I");
						
		// Assert
		assertEquals(1, result);
	}
	
	@Test
	public void testConvertToIntegers_500() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("D");
						
		// Assert
		assertEquals(500, result);
	}
	
	@Test
	public void testConvertToIntegers_3() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("III");
						
		// Assert
		assertEquals(3, result);
	}
	
	@Test
	public void testConvertToIntegers_4() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("IV");
						
		// Assert
		assertEquals(4, result);
	}
	
	@Test
	public void testConvertToIntegers_990() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("CMXC");
						
		// Assert
		assertEquals(990, result);
	}
	
	@Test
	public void testSplitString_IX() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		List<String> result = new ArrayList<String>();
						
		// Act
		result = numerals.splitString("IX");
						
		// Assert
		assertEquals("X", result.get(1));
	}
	
	@Test
	public void testVerifyRoman_InvalidVV() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("VV");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testVerifyRoman_InvalidXXXX() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("XXXX");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testMakeNumMap() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		Map<String, Integer> result = new HashMap<String, Integer>();
						
		// Act
		result = numerals.makeNumMap();
						
		// Assert
		assertEquals(Integer.valueOf(10), result.get("X"));
	}
	
	@Test
	public void testVerifyRoman_InvalidVX() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("VX");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testVerifyRoman_InvalidIL() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("IL");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testVerifyRoman_InvalidXXC() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("XXC");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testConvertToIntegers_1984() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("MCMLXXXIV");
						
		// Assert
		assertEquals(1984, result);
	}
	
	@Test
	public void testVerifyRoman_InvalidNumeral() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		boolean result = true;
						
		// Act
		result = numerals.verifyRoman("Hello");
						
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testConvertToIntegers_InvalidNumeral() {
		// Arrange
		RomanNumerals numerals = new RomanNumerals();
		int result = 0;
						
		// Act
		result = numerals.convertToInteger("Hello");
						
		// Assert
		assertEquals(0, result);
	}
}
