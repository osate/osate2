/**
 * AADL-BA-FrontEnd
 *
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.analyzers;

/**
 * How one type conforms to another. A conformance that rests on something other than the declared types is reported, so
 * that a model which relies on it says so; the type check still accepts it.
 */
public enum TypeConformance {
	/** The types do not conform. */
	NONE,

	/**
	 * The types conform as declared: the same classifier, an extension in either direction, a universal literal against
	 * a declared type, or an unresolved type that establishes no mismatch.
	 */
	EXACT,

	/** Two different numeric classifiers that share a data representation. */
	REPRESENTATION,

	/** A numeric value where one of a wider representation is expected, which keeps its value. */
	WIDENED,

	/** A numeric value where one of a narrower representation is expected, which may lose precision. */
	NARROWED;

	/** Returns {@code true} when the types conform at all. */
	public boolean conforms() {
		return this != NONE;
	}

	/** Returns {@code true} when the conformance rests on something the declared types do not state. */
	public boolean isConverted() {
		return this == REPRESENTATION || this == WIDENED || this == NARROWED;
	}

	/**
	 * Returns the stronger of two conformances. Neither operand of an operator is the expected one, so an operand check
	 * tries both orders and keeps the better result: a narrowing one way is a widening the other, and the operation is
	 * performed at the wider representation.
	 */
	public static TypeConformance best(TypeConformance first, TypeConformance second) {
		return first.strength() >= second.strength() ? first : second;
	}

	private int strength() {
		return switch (this) {
		case EXACT -> 4;
		case REPRESENTATION -> 3;
		case WIDENED -> 2;
		case NARROWED -> 1;
		case NONE -> 0;
		};
	}
}
