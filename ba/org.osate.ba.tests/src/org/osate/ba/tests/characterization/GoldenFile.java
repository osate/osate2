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
package org.osate.ba.tests.characterization;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Compares deterministic characterization output with reviewed golden files. Regeneration is deliberately gated by
 * {@code -Dosate.ba.tests.regenerate=true} so normal test runs cannot silently accept behavior changes.
 */
final class GoldenFile {
	private static final boolean REGENERATE = Boolean.getBoolean("osate.ba.tests.regenerate");

	private GoldenFile() {
	}

	static void assertMatches(final String suite, final String id, final String actual) throws IOException {
		final Path bundleDirectory = Paths.get(System.getProperty("user.dir"));
		final Path golden = bundleDirectory.resolve("expected").resolve(suite).resolve(id + ".txt");
		final String normalizedActual = normalize(actual);
		if (REGENERATE) {
			Files.createDirectories(golden.getParent());
			Files.write(golden, normalizedActual.getBytes(StandardCharsets.UTF_8));
		} else {
			final String expected = normalize(new String(Files.readAllBytes(golden), StandardCharsets.UTF_8));
			assertEquals("Golden file differs: " + golden, expected, normalizedActual);
		}
	}

	private static String normalize(final String text) {
		final String normalized = text.replace("\r\n", "\n").replace('\r', '\n');
		final String[] lines = normalized.split("\n", -1);
		final int lineCount = lines.length > 0 && lines[lines.length - 1].isEmpty() ? lines.length - 1 : lines.length;
		final StringBuilder result = new StringBuilder(normalized.length());
		for (int i = 0; i < lineCount; i++) {
			result.append(escapeTrailingWhitespace(lines[i])).append('\n');
		}
		return result.toString();
	}

	private static String escapeTrailingWhitespace(final String line) {
		int end = line.length();
		while (end > 0 && (line.charAt(end - 1) == ' ' || line.charAt(end - 1) == '\t')) {
			end--;
		}

		final StringBuilder result = new StringBuilder(line.length());
		result.append(line, 0, end);
		for (int i = end; i < line.length(); i++) {
			result.append(line.charAt(i) == ' ' ? "\\s" : "\\t");
		}
		return result.toString();
	}
}
