package it.partec.java_junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalcolatoreTests {

	private final Calcolatore calcolatore = new Calcolatore();

	@BeforeAll
	static void init() {
		System.out.println("Inizio dei test sul calcolatore");
	}

	@AfterAll
	static void tearDown() {
		System.out.println("Fine dei test");
	}

	@BeforeEach
	void initCalc() {
		calcolatore.canc();
	}

	@AfterEach
	void result(TestInfo testInfo) {
		System.out.println("Il risultato  del test " + testInfo.getDisplayName() + 
				" è " + calcolatore.getResult());
	}

	@Test
	@DisplayName("Test addizione")
	void addTest() {
		assertEquals(2, calcolatore.add(1, 1));
	}

	@Test
	void addMultiplyTest() {
		assertAll(
				() -> assertEquals(2, calcolatore.add(1, 1)),
				() -> assertEquals(4, calcolatore.add(1, 1))
				);
	}

	@Test
	void divExceptionTest() {
		assertThrows(ArithmeticException.class,
				() -> calcolatore.div(3, 0)
				);
	}
	
	@Test
	void check0Test() {
		assertTrue(calcolatore.checkResult0());
	}
	
	@Test
	void checkNo0Test() {
		calcolatore.add(1, 1);
		assertFalse(calcolatore.checkResult0());
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 1",
		"2, 4",
		"4, 5"
	})
	void addParameter1(int a, int b) {
		assertEquals(a + b, calcolatore.add(a, b));
	}
	
	static Stream<Arguments> getAddParams() {
		return Stream.of(
					arguments(1, 1),
					arguments(2, 4),
					arguments(4, 5)
				);
	}
	
	@ParameterizedTest
	@MethodSource("getAddParams")
	void addParameter2(int a, int b) {
		assertEquals(a + b, calcolatore.add(a, b));
	}
	
	@ParameterizedTest
	@ArgumentsSource(ArgumentProvider.class)
	void addParameter3(int a, int b) {
		assertEquals(a + b, calcolatore.add(a, b));
	}
}
