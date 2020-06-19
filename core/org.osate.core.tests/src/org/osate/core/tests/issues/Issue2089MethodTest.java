package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.osate.xtext.aadl2.properties.valueconversion.PropertiesValueConverter;

public final class Issue2089MethodTest {
	private static final String EMPTY_STRING = "";
	private static final String X = "x";
	private static final String X_Y = "x::y";
	private static final String ONE_TWO_THREE = "one::two::three";

	/* Create a subclass so we have access to the protected method */
	private final static class TestClass extends PropertiesValueConverter {
		private static void test(final String input, String expected) {
			assertEquals(expected, removeSpacesFromQualifiedName(input));
		}
	}

	@Test
	public void testRemoveSpacesFromQualifiedName() {
		TestClass.test(EMPTY_STRING, EMPTY_STRING);
		TestClass.test(" ", EMPTY_STRING);

		TestClass.test(X, X);
		TestClass.test(" x", X);
		TestClass.test("x ", X);
		TestClass.test(" x ", X);

		TestClass.test(X_Y, X_Y);
		TestClass.test(" x::y", X_Y);
		TestClass.test("x ::y", X_Y);
		TestClass.test(" x ::y", X_Y);

		TestClass.test("x:: y", X_Y);
		TestClass.test(" x:: y", X_Y);
		TestClass.test("x :: y", X_Y);
		TestClass.test(" x :: y", X_Y);

		TestClass.test("x::y ", X_Y);
		TestClass.test(" x::y ", X_Y);
		TestClass.test("x ::y ", X_Y);
		TestClass.test(" x ::y ", X_Y);

		TestClass.test("x:: y ", X_Y);
		TestClass.test(" x:: y ", X_Y);
		TestClass.test("x :: y ", X_Y);
		TestClass.test(" x :: y ", X_Y);

		TestClass.test(ONE_TWO_THREE, ONE_TWO_THREE);
		TestClass.test(" one::two::three", ONE_TWO_THREE);
		TestClass.test("one ::two::three", ONE_TWO_THREE);
		TestClass.test(" one ::two::three", ONE_TWO_THREE);

		TestClass.test("one:: two::three", ONE_TWO_THREE);
		TestClass.test(" one:: two::three", ONE_TWO_THREE);
		TestClass.test("one :: two::three", ONE_TWO_THREE);
		TestClass.test(" one :: two::three", ONE_TWO_THREE);

		TestClass.test("one::two ::three", ONE_TWO_THREE);
		TestClass.test(" one::two ::three", ONE_TWO_THREE);
		TestClass.test("one ::two ::three", ONE_TWO_THREE);
		TestClass.test(" one ::two ::three", ONE_TWO_THREE);

		TestClass.test("one:: two ::three", ONE_TWO_THREE);
		TestClass.test(" one:: two ::three", ONE_TWO_THREE);
		TestClass.test("one :: two ::three", ONE_TWO_THREE);
		TestClass.test(" one :: two ::three", ONE_TWO_THREE);

		TestClass.test("one::two:: three", ONE_TWO_THREE);
		TestClass.test(" one::two:: three", ONE_TWO_THREE);
		TestClass.test("one ::two:: three", ONE_TWO_THREE);
		TestClass.test(" one ::two:: three", ONE_TWO_THREE);

		TestClass.test("one:: two:: three", ONE_TWO_THREE);
		TestClass.test(" one:: two:: three", ONE_TWO_THREE);
		TestClass.test("one :: two:: three", ONE_TWO_THREE);
		TestClass.test(" one :: two:: three", ONE_TWO_THREE);

		TestClass.test("one::two :: three", ONE_TWO_THREE);
		TestClass.test(" one::two :: three", ONE_TWO_THREE);
		TestClass.test("one ::two :: three", ONE_TWO_THREE);
		TestClass.test(" one ::two :: three", ONE_TWO_THREE);

		TestClass.test("one:: two :: three", ONE_TWO_THREE);
		TestClass.test(" one:: two :: three", ONE_TWO_THREE);
		TestClass.test("one :: two :: three", ONE_TWO_THREE);
		TestClass.test(" one :: two :: three", ONE_TWO_THREE);

		TestClass.test("one::two::three ", ONE_TWO_THREE);
		TestClass.test(" one::two::three ", ONE_TWO_THREE);
		TestClass.test("one ::two::three ", ONE_TWO_THREE);
		TestClass.test(" one ::two::three ", ONE_TWO_THREE);

		TestClass.test("one:: two::three ", ONE_TWO_THREE);
		TestClass.test(" one:: two::three ", ONE_TWO_THREE);
		TestClass.test("one :: two::three ", ONE_TWO_THREE);
		TestClass.test(" one :: two::three ", ONE_TWO_THREE);

		TestClass.test("one::two ::three ", ONE_TWO_THREE);
		TestClass.test(" one::two ::three ", ONE_TWO_THREE);
		TestClass.test("one ::two ::three ", ONE_TWO_THREE);
		TestClass.test(" one ::two ::three ", ONE_TWO_THREE);

		TestClass.test("one:: two ::three ", ONE_TWO_THREE);
		TestClass.test(" one:: two ::three ", ONE_TWO_THREE);
		TestClass.test("one :: two ::three ", ONE_TWO_THREE);
		TestClass.test(" one :: two ::three ", ONE_TWO_THREE);

		TestClass.test("one::two:: three ", ONE_TWO_THREE);
		TestClass.test(" one::two:: three ", ONE_TWO_THREE);
		TestClass.test("one ::two:: three ", ONE_TWO_THREE);
		TestClass.test(" one ::two:: three ", ONE_TWO_THREE);

		TestClass.test("one:: two:: three ", ONE_TWO_THREE);
		TestClass.test(" one:: two:: three ", ONE_TWO_THREE);
		TestClass.test("one :: two:: three ", ONE_TWO_THREE);
		TestClass.test(" one :: two:: three ", ONE_TWO_THREE);

		TestClass.test("one::two :: three ", ONE_TWO_THREE);
		TestClass.test(" one::two :: three ", ONE_TWO_THREE);
		TestClass.test("one ::two :: three ", ONE_TWO_THREE);
		TestClass.test(" one ::two :: three ", ONE_TWO_THREE);

		TestClass.test("one:: two :: three ", ONE_TWO_THREE);
		TestClass.test(" one:: two :: three ", ONE_TWO_THREE);
		TestClass.test("one :: two :: three ", ONE_TWO_THREE);
		TestClass.test(" one :: two :: three ", ONE_TWO_THREE);
	}

}
