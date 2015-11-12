package org.osate.units.test
import org.junit.Test
import static org.junit.Assert.*
import static extension org.osate.units.Time.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runners.model.Statement
import org.junit.runner.Description

class UnitsTest {
	
	@Test def timeAdd() {
		assertEquals(1.h, 67.sec + 59.min - 5_000.msec)
	}
	@Test def timeMultiplyInt() {
		assertEquals(2.min, 60.sec * 2)
	}
	@Test def timeMultiplyFloat() {
		assertEquals(2.min, 60.sec * 1.5)
	}
	
}