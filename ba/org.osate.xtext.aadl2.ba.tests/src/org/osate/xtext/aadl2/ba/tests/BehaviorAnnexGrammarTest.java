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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AnnexSubclause;

import com.google.inject.Inject;

/**
 * Parses every Behavior Annex subclause that the legacy implementation accepts in the checked-in test and example
 * corpus. This keeps the phase-3 grammar aligned with existing syntax before later phases add linking, translation,
 * validation, and embedded-annex registration.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class BehaviorAnnexGrammarTest {
    private static final Pattern BEHAVIOR_ANNEX = Pattern.compile(
            "(?is)\\bannex\\s+behavior_specification\\s*\\{\\*\\*(.*?)\\*\\*\\}\\s*;");

    @Inject
    private ParseHelper<AnnexSubclause> parseHelper;

    @Test
    public void parseAcceptedBehaviorAnnexCorpus() throws Exception {
        final var baDirectory = findBaDirectory();
        final var failures = new ArrayList<String>();
        int annexCount = 0;

        for (final Path aadlFile : findAadlFiles(baDirectory)) {
            if (isFutureConformanceFixture(baDirectory, aadlFile)
                    || hasLegacySyntaxDiagnostics(baDirectory, aadlFile)) {
                continue;
            }

            final Matcher matcher = BEHAVIOR_ANNEX.matcher(Files.readString(aadlFile, StandardCharsets.UTF_8));
            int annexIndex = 0;
            while (matcher.find()) {
                annexCount++;
                annexIndex++;
                final AnnexSubclause annex = parseHelper.parse(matcher.group(1));
                final XtextResource resource = (XtextResource) annex.eResource();
                for (final INode error : resource.getParseResult().getSyntaxErrors()) {
                    failures.add(baDirectory.relativize(aadlFile) + "#" + annexIndex + ":"
                            + error.getStartLine() + "@" + error.getOffset() + " "
                            + error.getSyntaxErrorMessage().getMessage());
                }
            }
        }

        assertTrue("The accepted corpus did not contain any Behavior Annex subclauses", annexCount > 0);
        assertTrue("Xtext syntax errors in the accepted Behavior Annex corpus:\n" + String.join("\n", failures),
                failures.isEmpty());
    }

    private static Path findBaDirectory() {
        Path current = Paths.get(System.getProperty("user.dir")).toAbsolutePath();
        while (current != null && !Files.isDirectory(current.resolve("org.osate.ba.tests/models"))) {
            current = current.getParent();
        }
        assertFalse("Could not locate the BA reactor directory from " + System.getProperty("user.dir"),
                current == null);
        return current;
    }

    private static List<Path> findAadlFiles(final Path baDirectory) throws IOException {
        final var files = new ArrayList<Path>();
        files.addAll(findAadlFilesUnder(baDirectory.resolve("org.osate.ba.tests/models")));
        files.addAll(findAadlFilesUnder(baDirectory.resolve("org.osate.ba/examples")));
        return files;
    }

    private static List<Path> findAadlFilesUnder(final Path root) throws IOException {
        try (Stream<Path> paths = Files.walk(root)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".aadl"))
                    .sorted()
                    .toList();
        }
    }

    private static boolean isFutureConformanceFixture(final Path baDirectory, final Path aadlFile) {
        final String relativePath = baDirectory.relativize(aadlFile).toString().replace('\\', '/');
        return relativePath.startsWith("org.osate.ba.tests/models/characterization/conformance/");
    }

    private static boolean hasLegacySyntaxDiagnostics(final Path baDirectory, final Path aadlFile) throws IOException {
        final String relativePath = baDirectory.relativize(aadlFile).toString().replace('\\', '/');
        final String goldenName = relativePath.substring(0, relativePath.length() - ".aadl".length())
                .replace('/', '_') + ".txt";
        final var golden = baDirectory.resolve("org.osate.ba.tests/expected/diagnostics").resolve(goldenName);
        if (!Files.isRegularFile(golden)) {
            return false;
        }
        return Files.readAllLines(golden, StandardCharsets.UTF_8)
                .stream()
                .map(line -> line.toLowerCase(Locale.ROOT))
                .anyMatch(line -> line.contains("| syntax |"));
    }
}
