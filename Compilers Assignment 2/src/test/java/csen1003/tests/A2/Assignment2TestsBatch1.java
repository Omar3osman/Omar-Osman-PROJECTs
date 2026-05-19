package csen1003.tests.A2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1003.main.A2.Assignment2Lexer;
import csen1003.main.A2.Assignment2Parser;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Assignment2TestsBatch1 {
	
	/**
     * Parses a provided string using Assignment2's grammar
     * and gets the value of the attribute "check" of the variable "s"
     *
     * @param input a string to parse
     * @return the value of the attribute "check" of the variable "s"
     */
    public static int sValValue(String input) {
        Assignment2Lexer lexer = new Assignment2Lexer(CharStreams.fromString(input));
	Assignment2Parser parser = new Assignment2Parser(new CommonTokenStream(lexer));
        return parser.s().check;
    }


	@Test
	public void testString1() {
		assertEquals(0,
        sValValue("3, 42, 55"));
	}

	@Test
	public void testString2() {
		assertEquals(1,
        sValValue("63, 77, 3"));
	}

	@Test
	public void testString3() {
		assertEquals(0,
        sValValue("22, 22, 3"));
	}

	@Test
	public void testString4() {
		assertEquals(1,
        sValValue("12, 4, 44"));
	}

	@Test
	public void testString5() {
		assertEquals(1,
        sValValue("22, 70, 66, 86, 50"));
	}

	@Test
	public void testString6() {
		assertEquals(1,
        sValValue("34"));
	}

	@Test
	public void testString7() {
		assertEquals(1,
        sValValue("85, 6"));
	}

	@Test
	public void testString8() {
		assertEquals(0, 
        sValValue("87, 65, 56"));
	}

	@Test
	public void testString9() {
		assertEquals(0,
        sValValue("59, 36, 47, 48, 9"));
	}

	@Test
	public void testString10() {
		assertEquals(0,
        sValValue("12, 69, 67, 61, 72"));
	}


	@Test
	public void testString11() {
		assertEquals(1,
        sValValue(""));
	}
}