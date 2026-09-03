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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Discovers the existing Behavior Annex test and example models so the characterization fence automatically covers
 * the complete checked-in corpus. The covering-syntax files are loaded as one project because they reference each
 * other; other corpus entries are self-contained or use contributed predeclared resources.
 */
final class BehaviorAnnexCorpus {
	static final class Case {
		private final String path;
		private final List<String> referencedPaths;

		private Case(final String path, final List<String> referencedPaths) {
			this.path = path;
			this.referencedPaths = referencedPaths;
		}

		String getPath() {
			return path;
		}

		String[] getReferencedPaths() {
			return referencedPaths.toArray(new String[referencedPaths.size()]);
		}

		String getId() {
			return path.replace(".aadl", "").replace('/', '_');
		}
	}

	private static final String COVERING_SYNTAX_PREFIX = "org.osate.ba.tests/models/covering_syntax/";
	private static final String CHARACTERIZATION_PREFIX = "org.osate.ba.tests/models/characterization/";

	private BehaviorAnnexCorpus() {
	}

	static List<Case> discover() throws IOException {
		var baDirectory = Paths.get(System.getProperty("user.dir")).getParent();
		var paths = new ArrayList<String>();
		paths.addAll(findAadlFiles(baDirectory, baDirectory.resolve("org.osate.ba.tests/models")));
		paths.addAll(findAadlFiles(baDirectory, baDirectory.resolve("org.osate.ba/examples")));
		Collections.sort(paths);

		var coveringSyntaxPaths = paths.stream()
				.filter(path -> path.startsWith(COVERING_SYNTAX_PREFIX))
				.toList();
		var characterizationPaths = paths.stream()
				.filter(path -> path.startsWith(CHARACTERIZATION_PREFIX))
				.filter(path -> !path.substring(CHARACTERIZATION_PREFIX.length()).contains("/"))
				.toList();
		var result = new ArrayList<Case>();
		for (var path : paths) {
			List<String> references;
			if (path.startsWith(COVERING_SYNTAX_PREFIX)) {
				references = coveringSyntaxPaths.stream()
						.filter(reference -> !reference.equals(path))
						.toList();
			} else if (characterizationPaths.contains(path)) {
				references = characterizationPaths.stream()
						.filter(reference -> !reference.equals(path))
						.toList();
			} else {
				references = List.of();
			}
			result.add(new Case(path, references));
		}
		return result;
	}

	private static List<String> findAadlFiles(final Path baDirectory, final Path root) throws IOException {
		try (var files = Files.walk(root)) {
			return files.filter(Files::isRegularFile)
					.filter(path -> path.getFileName().toString().endsWith(".aadl"))
					.sorted(Comparator.comparing(Path::toString))
					.map(baDirectory::relativize)
					.map(path -> path.toString().replace(path.getFileSystem().getSeparator(), "/"))
					.toList();
		}
	}
}
