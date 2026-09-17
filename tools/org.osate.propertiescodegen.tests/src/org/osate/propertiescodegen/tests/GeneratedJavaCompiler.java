/*******************************************************************************
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.propertiescodegen.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.propertiescodegen.GeneratedPackage;
import org.osate.propertiescodegen.PropertiesCodeGen;

/** Compiles actual generator output against the same OSATE classes used by the OSGi test runtime. */
final class GeneratedJavaCompiler {
	private GeneratedJavaCompiler() {
	}

	static GeneratedPackage generateAndCompile(PropertySet propertySet) throws Exception {
		try (var compiled = compile(propertySet)) {
			return compiled.generatedPackage();
		}
	}

	static CompiledJava compile(PropertySet propertySet) throws Exception {
		var compiler = ToolProvider.getSystemJavaCompiler();
		assertNotNull("Generated-code tests require a JDK with the Java compiler", compiler);
		var directory = Files.createTempDirectory("osate-generated-java-");
		try {
			var packages = new LinkedHashMap<PropertySet, GeneratedPackage>();
			generateDependencies(propertySet, packages);
			var sources = new ArrayList<Path>();
			for (var generated : packages.values()) {
				var packageDirectory = directory.resolve(generated.getPackagePath());
				Files.createDirectories(packageDirectory);
				for (var source : generated.getClasses()) {
					var path = packageDirectory.resolve(source.getFileName());
					Files.writeString(path, source.getContents(), StandardCharsets.UTF_8);
					sources.add(path);
				}
			}
			var classes = Files.createDirectory(directory.resolve("classes"));
			var diagnostics = new DiagnosticCollector<JavaFileObject>();
			try (var files = compiler.getStandardFileManager(diagnostics, null, StandardCharsets.UTF_8)) {
				files.setLocationFromPaths(StandardLocation.CLASS_PATH, classPath());
				files.setLocationFromPaths(StandardLocation.CLASS_OUTPUT, List.of(classes));
				var success = compiler
						.getTask(null, files, diagnostics, List.of("--release", "21", "-proc:none"), null,
								files.getJavaFileObjectsFromPaths(sources))
						.call();
				assertTrue("Generated Java failed to compile for " + propertySet.getName() + ":\n"
						+ diagnostics.getDiagnostics().stream().map(Object::toString).collect(Collectors.joining("\n")),
						success);
			}
			return new CompiledJava(packages.get(propertySet), directory, new URLClassLoader(
					new URL[] { classes.toUri().toURL() }, GeneratedJavaCompiler.class.getClassLoader()));
		} catch (Exception | AssertionError e) {
			try {
				deleteDirectory(directory);
			} catch (IOException cleanupFailure) {
				e.addSuppressed(cleanupFailure);
			}
			throw e;
		}
	}

	private static void generateDependencies(PropertySet propertySet, Map<PropertySet, GeneratedPackage> packages) {
		if (packages.containsKey(propertySet)) {
			return;
		}
		packages.put(propertySet, PropertiesCodeGen.generateJava(propertySet));
		for (var imported : propertySet.getImportedUnits()) {
			if (imported instanceof PropertySet dependency) {
				generateDependencies(dependency, packages);
			}
		}
	}

	private static List<Path> classPath() throws Exception {
		// java.class.path contains the Equinox launcher, not the bundles supplying generated-code APIs.
		var locations = new LinkedHashSet<Path>();
		for (var anchor : List.of(IAdaptable.class, URI.class, EObject.class, NamedElement.class,
				Aadl2GlobalScopeUtil.class, CodeGenUtil.class)) {
			locations.add(Path.of(anchor.getProtectionDomain().getCodeSource().getLocation().toURI()));
		}
		return List.copyOf(locations);
	}

	private static void deleteDirectory(Path directory) throws IOException {
		try (var paths = Files.walk(directory)) {
			for (var path : paths.sorted(Comparator.reverseOrder()).toList()) {
				Files.delete(path);
			}
		}
	}

	record CompiledJava(GeneratedPackage generatedPackage, Path directory, URLClassLoader loader)
			implements AutoCloseable {
		Class<?> loadClass(String name) throws ClassNotFoundException {
			return loader.loadClass(name);
		}

		@Override
		public void close() throws IOException {
			try {
				loader.close();
			} finally {
				deleteDirectory(directory);
			}
		}
	}
}
