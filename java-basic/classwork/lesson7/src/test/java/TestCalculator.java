import org.example.calculation.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TestCalculator {

	private Calculator calculator;

	@Before
	public void initCalculator(){
		System.out.println("BEFORE");
		calculator = new Calculator();
	}

	@After
	public void freeCalculator(){
		System.out.println("AFTER");
		calculator = null;
	}

	@Before
	public void initTime(){
		// set custom time
	}

	@After
	public void returnTime(){
		// set real time
	}

//	public static void main(String[] args) {
//		JUnitCore runner = new JUnitCore();
//		Result result = runner.run(TestCalculator.class);
//
//		System.out.println("run tests: " + result.getRunCount());
//		System.out.println("failed: " + result.getFailureCount());
//		System.out.println("ignored|" + result.getIgnoreCount());
//	}

	@Test
	public void testSumDefault() {
		assertTrue(calculator.sum(2, 4) == 6);

	}

	@Test
	public void testSumZero() {
		assertTrue(calculator.sum(2, 0) == 2);
	}

	@Test
	public void testSumMinus() {
		assertTrue(calculator.sum(2, -4) == -2);
	}

	@Ignore
	@Test
	public void testSumWithError() {
		assertTrue(calculator.sum(2, 4) == 5);
	}

	@Test(expected = IllegalAccessException.class)
	public void testSumWithError2() throws IllegalAccessException {
		assertTrue(calculator.sum2() == 5);
	}

}
