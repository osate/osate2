/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.services.impl;

import java.util.List;

/**
 * Helper class for encoding and decoding lists of strings to/from a string. This is useful when attempting to serialize a reference.
 */
public class ReferenceEncoder {
	private static final char OUTER_ESCAPE_CHAR = '$'; // Used to start an escape sequence or to indicate a space when used after an inner escape character
	private static final char INNER_ESCAPE_CHAR = '%';
	private static final String ESCAPED_INNER_ESCAPE_CHAR = Character.toString(INNER_ESCAPE_CHAR) + INNER_ESCAPE_CHAR;

	/**
	 * Encoded a list of string to a single string
	 * @param segs the segments which make up the reference
	 * @return the encoded string
	 */
	public static String encode(final List<String> segs) {
		final StringBuilder sb = new StringBuilder();
		ReferenceEncoder.encodeSegment(sb, segs.get(0));
		for (int i = 1; i < segs.size(); i++) {
			sb.append(' ');
			if (segs.get(i) == null) {
				return null;
			}

			encodeSegment(sb, segs.get(i));
		}

		return sb.toString();
	}

	/**
	 * Decodes an encoded string into an array of string.
	 * @param referenceStr the encoded string as returned by {@link ReferenceEncoder#encode(List)}
	 * @return the decoded array of string.
	 */
	public static String[] decode(final String referenceStr) {
		final String[] ref = referenceStr.split(" ");
		if(ref.length < 1) {
			return null;
		}

		// Restore spaces
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ref.length; i++) {
			sb.setLength(0);
			decodeSegment(sb, ref[i]);
			ref[i] = sb.toString();
		}

		return ref;
	}

	private static void encodeSegment(final StringBuilder sb, final String seg) {
		for(int i = 0; i < seg.length(); i++) {
			final char ch = seg.charAt(i);
			if(ch == OUTER_ESCAPE_CHAR) {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(ch);
			} else if(ch == INNER_ESCAPE_CHAR) {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(ESCAPED_INNER_ESCAPE_CHAR);
			} else if(ch == ' ') {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(INNER_ESCAPE_CHAR);
				sb.append(OUTER_ESCAPE_CHAR);
			} else {
				sb.append(ch);
			}
		}
	}

	private static void decodeSegment(final StringBuilder sb, final String seg) {
		final int len = seg.length();
		for(int i = 0; i < len; i++) {
			char ch = seg.charAt(i);
			if(ch == OUTER_ESCAPE_CHAR) {
				i++;
				if(i < len) {
					ch = seg.charAt(i);
					if(ch == OUTER_ESCAPE_CHAR) {
						sb.append(ch);
					} else if(ch == INNER_ESCAPE_CHAR) {
						i++;
						if(i < len) {
							ch = seg.charAt(i);
							if(ch == OUTER_ESCAPE_CHAR) {
								sb.append(' ');
							} else {
								sb.append(ch);
							}
						}
					}
				}
			} else {
				sb.append(ch);
			}
		}
	}

	/**
	 * Simple main function that encodes and decodes strings for testing purposes.
	 * @param args command line arguments
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public static void main(final String[] args) {
		final StringBuilder sb = new StringBuilder();
		testEncodeDecodeSegment(sb, "Test");
		testEncodeDecodeSegment(sb, "C$");
		testEncodeDecodeSegment(sb, "C$ DE");
		testEncodeDecodeSegment(sb, "C$_DE");
	}

	private static void testEncodeDecodeSegment(final StringBuilder sb, final String str) {
		sb.setLength(0);
		encodeSegment(sb, str);
		final String encoded = sb.toString();
		sb.setLength(0);
		decodeSegment(sb, encoded);
		final String decoded = sb.toString();
		System.out.println("'" + str + "' : '" + encoded + "' : '" + decoded + "'");
	}
}
