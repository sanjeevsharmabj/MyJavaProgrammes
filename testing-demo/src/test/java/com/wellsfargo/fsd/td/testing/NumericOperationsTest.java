package com.wellsfargo.fsd.td.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.wellsfargo.fsd.td.service.NumericOperations;

public class NumericOperationsTest {
	
	//required to indicate it is a junit test
	@Test
	@DisplayName("is Odd method is being tested")
	@Disabled
	void isOddTest() {
		
		NumericOperations nopt = new NumericOperations();
		//Assertions.assertTrue(nopt.isOdd(9));
		//Assertions.assertFalse(nopt.isOdd(18));
		//by making assertions class static in line 3 we can import all the methods and avoid use of assertions. everytime
		assertTrue(nopt.isOdd(-9),"-9 expected to be odd");
		assertFalse(nopt.isOdd(-18),"-18 expected to be even");
		assertFalse(nopt.isOdd(0),"0 expected to be even");
		assertTrue(nopt.isOdd(9),"9 expected to be odd");
		assertFalse(nopt.isOdd(18),"18 expected to be even");
		
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-9,9})
	@DisplayName("is Odd method is being tested for odd by passing params")
	void isOddTest2(int testdata) {
		
		NumericOperations nopt = new NumericOperations();
		assertTrue(nopt.isOdd(testdata),testdata+ "expected to be odd");
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-8,0,8})
	@DisplayName("is Odd method is being tested for odd by passing params")
	void isOddTest3(int testdata) {
		
		NumericOperations nopt = new NumericOperations();
		assertFalse(nopt.isOdd(testdata),testdata+ "expected to be even");
		
	}

}
