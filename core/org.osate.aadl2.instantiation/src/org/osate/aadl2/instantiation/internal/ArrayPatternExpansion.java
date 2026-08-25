/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instantiation.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongBinaryOperator;

import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * One expansion of a source array and a destination array into the pairs of elements that their
 * dimensions, a {@code Connection_Pattern} value or the default pattern pair up. The expansion walks the
 * dimensions of the two ends outside in, one pattern per dimension, and hands every combination of
 * indices the patterns pair up to a {@link Pairing}.
 * <p>
 * Two things are expanded this way, because both read the same property with the same meaning: a
 * connection between arrays of features or of components (see {@link ConnectionArrayExpander}), and a
 * flow specification between feature arrays (see {@link FlowSpecArrayExpander}). What differs is only
 * what a pair of indices is turned into and how the two are named in a report, which is why the subject
 * of a report is supplied by the caller rather than derived here.
 * <p>
 * The sizes and the patterns do not change; the three cursors and the two index lists are where the
 * expansion is. A cursor is advanced by {@link #expandNextDimension(int, int)} only, which also restores
 * it, so every level of the recursion sees the cursors and indices it established itself.
 * <p>
 * Patterns are read in the declarative frame: {@code isOpposite} means that the declared source is the
 * destination of what is being expanded, so a pattern that keeps the declared source fixed varies the
 * index of the destination.
 */
final class ArrayPatternExpansion {
	/**
	 * What an expansion hands each pair of paired-up element indices to.
	 */
	interface Pairing {
		/**
		 * @param srcIndices the index of the source element in every source dimension, outside in
		 * @param dstIndices the index of the destination element in every destination dimension, outside in
		 */
		void pair(List<Long> srcIndices, List<Long> dstIndices);
	}

	/**
	 * The values of the standard {@code Connection_Pattern} property, which are also the patterns the
	 * default expansion of an array uses. The name of a literal is the name of the constant, up to case,
	 * which is how {@link #parse(String)} looks a pattern of the model up.
	 * <p>
	 * Eleven of the patterns pair up the elements of a source dimension and a destination dimension of
	 * the same size, and differ only in which source elements take part and which destination element
	 * each of them is paired with. Those four numbers are the state of such a pattern: the first source
	 * index, how many elements at the end of the dimension are left out, the step from one source index
	 * to the next, and the destination index of a source index. The other three patterns have a shape of
	 * their own and carry none of it.
	 */
	private enum ConnectionPattern {
		/** Every element of the source dimension to every element of the destination dimension. */
		ALL_TO_ALL,

		/** The one element of the scalar declared source to every element of the destination dimension. */
		ONE_TO_ALL,

		/** Every element of the source dimension to the one element of the scalar declared destination. */
		ALL_TO_ONE,

		ONE_TO_ONE(1, 0, 1, (i, size) -> i),
		NEXT(1, 1, 1, (i, size) -> i + 1),
		PREVIOUS(2, 0, 1, (i, size) -> i - 1),
		CYCLIC_NEXT(1, 0, 1, (i, size) -> i == size ? 1 : i + 1),
		CYCLIC_PREVIOUS(1, 0, 1, (i, size) -> i == 1 ? size : i - 1),
		NEXT_NEXT(1, 2, 1, (i, size) -> i + 2),
		PREVIOUS_PREVIOUS(3, 0, 1, (i, size) -> i - 2),
		CYCLIC_NEXT_NEXT(1, 0, 1, (i, size) -> (i + 1) % size + 1),
		CYCLIC_PREVIOUS_PREVIOUS(1, 0, 1, (i, size) -> (i + size - 3) % size + 1),
		EVEN_TO_EVEN(2, 0, 2, (i, size) -> i),
		ODD_TO_ODD(1, 0, 2, (i, size) -> i);

		/** The first index of the source dimension that takes part. */
		private final long firstIndex;

		/** How many elements at the end of the source dimension do not take part. */
		private final int lastIndexOffset;

		/** The distance from one participating source index to the next. */
		private final long step;

		/** The destination index a source index is paired with, given the size of the dimension. */
		private final LongBinaryOperator destinationIndex;

		ConnectionPattern() {
			this(0, 0, 0, null);
		}

		ConnectionPattern(long firstIndex, int lastIndexOffset, long step, LongBinaryOperator destinationIndex) {
			this.firstIndex = firstIndex;
			this.lastIndexOffset = lastIndexOffset;
			this.step = step;
			this.destinationIndex = destinationIndex;
		}

		/**
		 * The pattern of a {@code Connection_Pattern} enumeration literal.
		 *
		 * @param name the name of the literal
		 * @return the pattern, or {@code null} if this is not a pattern the expansion supports
		 */
		static ConnectionPattern parse(String name) {
			for (ConnectionPattern pattern : values()) {
				if (pattern.name().equalsIgnoreCase(name)) {
					return pattern;
				}
			}
			return null;
		}
	}

	/** Which declared end of the expanded element a report is about. */
	private enum End {
		SOURCE("source"), DESTINATION("destination");

		private final String label;

		End(String label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	/**
	 * What a report is about, and where it goes. The texts are the ones the messages had when only
	 * connections were expanded this way, so a connection is reported exactly as it was.
	 *
	 * @param target the instance object a report about the expanded element is attached to
	 * @param kind what the expanded element is called, {@code connection} or {@code flow specification}
	 * @param name the name of the expanded element
	 * @param container the instance object a report about the whole declaration is attached to, used by
	 *            the short pattern report, which is about a value that describes no element at all
	 * @param containerName the name of what contains the expanded element, used by the array size
	 *            mismatch report
	 */
	record Subject(Element target, String kind, String name, Element container, String containerName) {
	}

	private final AnalysisErrorReporterManager errManager;
	private final Subject subject;
	private final boolean isOpposite;

	/** The pattern per dimension, or {@code null} to expand with the default pattern. */
	private final List<PropertyExpression> patterns;

	private final List<Integer> srcSizes;
	private final List<Integer> dstSizes;
	private final Pairing pairing;

	/** The indices collected for the dimensions the expansion has entered, outside in. */
	private final List<Long> srcIndices = new ArrayList<>();
	private final List<Long> dstIndices = new ArrayList<>();

	private int offset;
	private int srcOffset;
	private int dstOffset;

	/**
	 * @param errManager the error manager to report to
	 * @param subject what a report is about
	 * @param isOpposite whether the expanded element goes against the direction of the declaration
	 * @param patterns the value of {@code Connection_Pattern}, one literal per dimension, or {@code null}
	 *            to expand with the default pattern
	 * @param srcSizes the sizes of the array dimensions of the source end, outside in
	 * @param dstSizes the sizes of the array dimensions of the destination end, outside in
	 * @param pairing what to hand every paired-up combination of indices to
	 */
	ArrayPatternExpansion(AnalysisErrorReporterManager errManager, Subject subject, boolean isOpposite,
			List<PropertyExpression> patterns, List<Integer> srcSizes, List<Integer> dstSizes, Pairing pairing) {
		this.errManager = errManager;
		this.subject = subject;
		this.isOpposite = isOpposite;
		this.patterns = patterns;
		this.srcSizes = srcSizes;
		this.dstSizes = dstSizes;
		this.pairing = pairing;
	}

	/**
	 * Pair up the elements of the dimension the expansion is at and of every dimension inside it.
	 *
	 * @return whether what was expanded has to be dropped; a short pattern is rejected without a
	 *         replacement, while failures that may still describe one scalar element leave it in place
	 */
	boolean expand() {
		if (patterns != null && offset == 0 && patterns.size() < Math.max(srcSizes.size(), dstSizes.size())) {
			errManager.error(subject.container(), "Connection pattern has fewer dimensions than its array ends");
			return true;
		}
		if (patterns != null ? offset >= patterns.size()
				: srcOffset == srcSizes.size() && dstOffset == dstSizes.size()) {
			pairing.pair(srcIndices, dstIndices);
			return true;
		}
		var patternName = patternName();
		var pattern = ConnectionPattern.parse(patternName);
		/*
		 * An unsupported pattern is neither One_To_All nor All_To_One, so it needs an index at both ends,
		 * and it is reported below, after the size check the supported patterns go through.
		 */
		if (!hasIndexFor(End.SOURCE, pattern) || !hasIndexFor(End.DESTINATION, pattern)) {
			return false;
		}
		var result = true;
		if (pattern == ConnectionPattern.ALL_TO_ALL) {
			for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
				srcIndices.add(i);
				for (long j = 1; j <= dstSizes.get(dstOffset); j++) {
					dstIndices.add(j);
					result &= expandNextDimension(1, 1);
					dstIndices.removeLast();
				}
				srcIndices.removeLast();
			}
			return result;
		}
		if (pattern == (isOpposite ? ConnectionPattern.ALL_TO_ONE : ConnectionPattern.ONE_TO_ALL)) {
			// the declared source stays at its one element, so this dimension gives it no index
			for (long j = 1; j <= dstSizes.get(dstOffset); j++) {
				dstIndices.add(j);
				result &= expandNextDimension(0, 1);
				dstIndices.removeLast();
			}
			return result;
		}
		if (pattern == (isOpposite ? ConnectionPattern.ONE_TO_ALL : ConnectionPattern.ALL_TO_ONE)) {
			// the declared destination stays at its one element, so this dimension gives it no index
			for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
				srcIndices.add(i);
				result &= expandNextDimension(1, 0);
				srcIndices.removeLast();
			}
			return result;
		}
		// every remaining pattern pairs up two dimensions of the same size
		int size = srcSizes.get(srcOffset);
		if (size != dstSizes.get(dstOffset)) {
			errManager.error(subject.target(),
					"Array size mismatch (" + patternName + ") on " + subject.kind() + " " + subject.name() + " in "
							+ subject.containerName() + ": " + size + " at source and " + dstSizes.get(dstOffset)
							+ " at destination.");
			return false;
		}
		if (pattern == null) {
			/*
			 * A pattern the expansion does not know expands into nothing. Report it and keep what was to be
			 * expanded: returning true would tell the caller that it was expanded, and the caller would drop
			 * it without a replacement.
			 */
			errManager.error(subject.target(),
					"Unsupported connection pattern '" + patternName + "' on " + subject.kind() + " "
							+ subject.name());
			return false;
		}
		for (long i = pattern.firstIndex; i <= size - pattern.lastIndexOffset; i += pattern.step) {
			srcIndices.add(i);
			dstIndices.add(pattern.destinationIndex.applyAsLong(i, size));
			result &= expandNextDimension(1, 1);
			dstIndices.removeLast();
			srcIndices.removeLast();
		}
		return result;
	}

	/**
	 * Expand the dimensions inside the one the expansion is at with the indices collected for it, then
	 * undo the step, so that the caller continues with the cursors and indices it had.
	 *
	 * @param srcStep one if this dimension took an index from the source end, zero if it did not
	 * @param dstStep one if this dimension took an index from the destination end, zero if it did not
	 * @return whether the expansion succeeded
	 */
	private boolean expandNextDimension(int srcStep, int dstStep) {
		offset++;
		srcOffset += srcStep;
		dstOffset += dstStep;
		var result = expand();
		dstOffset -= dstStep;
		srcOffset -= srcStep;
		offset--;
		return result;
	}

	/**
	 * The name of the pattern of the dimension the expansion is at: the name of the enumeration literal of
	 * {@code Connection_Pattern}, or the name of the pattern the default expansion uses. The name is what
	 * the array size mismatch message reports, which is why the default expansion needs one at all.
	 */
	private String patternName() {
		if (patterns != null) {
			var nv = (NamedValue) patterns.get(offset);
			return ((EnumerationLiteral) nv.getNamedValue()).getName();
		}
		/*
		 * A default pattern pairs dimensions one-to-one. If only one end has dimensions, every element on
		 * that end maps to the one scalar end. The spelling of these three names is the spelling they had.
		 */
		if (srcSizes.isEmpty()) {
			return isOpposite ? "All_to_One" : "One_To_All";
		}
		if (dstSizes.isEmpty()) {
			return isOpposite ? "One_To_All" : "All_to_One";
		}
		return "One_to_One";
	}

	/**
	 * Does the dimension the expansion is at have an index to give to a declared end? Reports the end
	 * having fewer array dimensions than the patterns need indices for.
	 * <p>
	 * {@code End} names the declared end here, and the message follows it. Which of the two size lists to
	 * look in does not: with {@code isOpposite}, the declared source is the destination of what is being
	 * expanded, so its dimensions are the ones of the destination.
	 *
	 * @param end the declared end
	 * @param pattern the pattern of the dimension, {@code null} if the model names one that is not
	 *            supported
	 * @return whether the pattern has an index for this end
	 */
	private boolean hasIndexFor(End end, ConnectionPattern pattern) {
		// One_To_All takes no index from the declared source, All_To_One none from the declared destination
		if (pattern == (end == End.SOURCE ? ConnectionPattern.ONE_TO_ALL : ConnectionPattern.ALL_TO_ONE)) {
			return true;
		}
		var atSource = (end == End.SOURCE) != isOpposite;
		var offsetAtEnd = atSource ? srcOffset : dstOffset;
		var dimensions = (atSource ? srcSizes : dstSizes).size();
		if (offsetAtEnd < dimensions) {
			return true;
		}
		errManager.error(subject.target(),
				"Too few indices for " + subject.kind() + " " + end + " for " + subject.name());
		return false;
	}
}
