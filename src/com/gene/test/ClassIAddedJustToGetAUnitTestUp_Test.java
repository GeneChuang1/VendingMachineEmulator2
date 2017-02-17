package com.gene.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gene.sample.ClassIAddedJustToGetAUnitTestUp;

public class ClassIAddedJustToGetAUnitTestUp_Test {
	ClassIAddedJustToGetAUnitTestUp c = new ClassIAddedJustToGetAUnitTestUp();
	//This is a comment.
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int result= c.add(1, 1);
		assertEquals(result, 2);
		// fail("Not yet implemented");
	}

}
