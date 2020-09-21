/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;

/**
 * Class containing utility functions useful for implementing plugins adding annex support to the OSATE graphical editor.
 * @noextend
 * @since 2.0
 */
public class GraphicalAnnexUtil {
	/**
	 * Source value to use when creating a new annex library or subclause
	 */
	private static final String DEFAULT_ANNEX_SOURCE = "{** **}";

	/**
	 * The token used for the start of an annex source block
	 */
	private static final String ANNEX_SOURCE_START = "{**";

	/**
	 * The token used for the end of an annex source block
	 */
	private static final String ANNEX_SOURCE_END = "**}";

	// All methods are static
	private GraphicalAnnexUtil() {
	}

	/**
	 * Finds and returns the parsed annex library for the first annex library in the package with the specified name. Creates a new annex
	 * library if one does not exist.
	 * An exception is thrown if an existing annex library is found but it does not have a parsed annex library of the expected type.
	 * @param <T> the type of the parsed annex library
	 * @param pkg is the package in which to look for the annex library
	 * @param annexName is the name of the annex library to look for
	 * @param parsedEType is the {@link EClass} of the parsed annex library created if it the annex library doesn't exist.
	 * @param parsedType is the java type that the parsed library is expected to be an instance of.
	 * @return the parsed annex library
	 */
	public static <T> T getOrCreateParsedAnnexLibrary(final AadlPackage pkg, final String annexName,
			final EClass parsedEType, final Class<T> parsedType) {
		// Get or create the DefaultAnnexLibrary
		final DefaultAnnexLibrary defaultLib = getFirstDefaultAnnexLibrary(pkg, annexName).orElseGet(() -> {
			// Create the public section of the package if it does not exist.
			if (pkg.getPublicSection() == null) {
				pkg.createOwnedPublicSection();
			}

			// Must create new annex
			final DefaultAnnexLibrary lib = (DefaultAnnexLibrary) pkg.getPublicSection()
					.createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getDefaultAnnexLibrary());
			lib.setName(annexName);
			lib.setSourceText(DEFAULT_ANNEX_SOURCE);
			return lib;
		});

		// Create the parsed library as needed
		final T result = getParsedAnnexLibrary(defaultLib, parsedType).orElse(null);
		if(result != null) {
			return result;
		}

		if (isEmptyAnnexSource(defaultLib.getSourceText())) {
			return parsedType.cast(defaultLib.createParsedAnnexLibrary(parsedEType));
		} else {
			throw new AadlGraphicalEditorException("Parsed annex library is null but source text is not empty");
		}
	}

	/**
	 * Finds and returns the parsed annex library for the first annex library in the package with the specified name.
	 * An exception is thrown if an annex library is found and it has a parsed annex library which is not an instance of the expected type.
	 * @param <T> the type of the parsed annex library
	 * @param pkg is the package in which to look for the annex library
	 * @param annexName is the name of the annex library to look for
	 * @param parsedType is the java type that the parsed library is expected to be an instance of.
	 * @return an optional containing the parsed annex library for the first annex with the specified name.
	 */
	public static <T> Optional<T> getFirstParsedAnnexLibrary(final AadlPackage pkg, final String annexName,
			final Class<T> parsedType) {
		return getFirstDefaultAnnexLibrary(pkg, annexName)
				.flatMap(defaultLib -> getParsedAnnexLibrary(defaultLib, parsedType));
	}

	/**
	 * Returns an optional containing the first default annex library with the specified name.
	 * @param pkg is the package in which to look for the annex library.
	 * @param annexName is the name to look for.
	 * @return the annex library. Returns empty if an annex library with the specified name does not exist in the package.
	 */
	private static Optional<DefaultAnnexLibrary> getFirstDefaultAnnexLibrary(final AadlPackage pkg,
			final String annexName) {
		if (pkg.getPublicSection() == null) {
			return Optional.empty();
		}

		for (final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if (lib.getName().equalsIgnoreCase(annexName) && lib instanceof DefaultAnnexLibrary) {
				return Optional.of((DefaultAnnexLibrary) lib);
			}
		}

		return Optional.empty();
	}

	/**
	 * Retrieves the parsed annex library from a {@link DefaultAnnexLibrary} instance.
	 * Throws an exception if a parsed library was found but was of an unexpected type.
	 * @param <T> is the type of the parsed annex library
	 * @param defaultLib is the annex library to return the parsed library for
	 * @param parsedType is the java type that the parsed library is expected to be an instance of.
	 * @return an optional describing the library. Empty if the parsed library is null.
	 */
	private static <T> Optional<T> getParsedAnnexLibrary(final DefaultAnnexLibrary defaultLib,
			final Class<T> parsedType) {
		final AnnexLibrary parsedAnnexLibrary = defaultLib.getParsedAnnexLibrary();
		if (parsedAnnexLibrary == null) {
			return Optional.empty();
		}

		if (parsedType.isInstance(parsedAnnexLibrary)) {
			return Optional.of(parsedType.cast(parsedAnnexLibrary));
		} else {
			throw new IllegalArgumentException(
					"Invalid parsed type. Parsed annex library is not of specified type. Specified: "
							+ parsedType.getName() + ". Actual: " + parsedAnnexLibrary.getClass().getName());
		}
	}

	/**
	 * Finds and returns the parsed annex subclause for the first annex subclause in the classifier with the specified name.
	 * Creates a new annex subclause if one does not exist.
	 * An exception is thrown if an existing annex subclause is found but it does not have a parsed annex subclause of the expected type.
	 * @param <T> the type of the parsed annex subclause
	 * @param classifier is the classifier in which to look for the annex subclause
	 * @param annexName is the name of the annex subclause to look for
	 * @param parsedEType is the {@link EClass} of the parsed annex subclause created if the annex subclause doesn't exist.
	 * @param parsedType is the java type that the parsed subclause is expected to be an instance of.
	 * @return the parsed annex subclause
	 */
	public static <T> T getOrCreateParsedAnnexSubclause(final Classifier classifier, final String annexName,
			final EClass parsedEType, final Class<T> parsedType) {
		// Get or create the DefaultAnnexSubclause
		final DefaultAnnexSubclause defaultSubclause = getAllDefaultAnnexSubclauses(classifier, annexName).findFirst()
				.orElseGet(() -> {
					// Must create new annex
					final DefaultAnnexSubclause subclause = classifier.createOwnedAnnexSubclause();
					subclause.setName(annexName);
					subclause.setSourceText(DEFAULT_ANNEX_SOURCE);
					return subclause;
				});

		// Create the parsed subclause as needed
		final T result =  getParsedAnnexSubclause(defaultSubclause, parsedType).orElse(null);
		if (result != null) {
			return result;
		}

		if (isEmptyAnnexSource(defaultSubclause.getSourceText())) {
			return parsedType.cast(defaultSubclause.createParsedAnnexSubclause(parsedEType));
		} else {
			throw new AadlGraphicalEditorException("Parsed annex subclause is null but source text is not empty");
		}
	}

	/**
	 * Finds and returns the parsed annex subclause for the first annex subclause in the classifier with the specified name.
	 * An exception is thrown if an annex subclause is found and it has a parsed annex subclause which is not an instance of the expected type.
	 * @param <T> the type of the parsed annex subclause
	 * @param classifier is the classifier in which to look for the annex subclause
	 * @param annexName is the name of the annex subclause to look for
	 * @param parsedType is the java type that the parsed subclause is expected to be an instance of.
	 * @return an optional containing the parsed annex subclause for the first annex with the specified name.
	 */
	public static <T> Optional<T> getFirstParsedAnnexSubclause(final Classifier classifier, final String annexName,
			final Class<T> parsedType) {
		return getAllParsedAnnexSubclauses(classifier, annexName, parsedType).findFirst();
	}

	/**
	 * Returns a stream of all the {@link DefaultAnnexSubclause} instances in the classifier with a name matching a specified annex name.
	 * @param classifier is the classifier in which to look for the annex subclauses.
	 * @param annexName is the name of the annex subclauses to look for
	 * @return a stream containing the matching subclauses
	 */
	private static Stream<DefaultAnnexSubclause> getAllDefaultAnnexSubclauses(final Classifier classifier, final String annexName) {
		return classifier.getOwnedAnnexSubclauses().stream()
				.filter(subclause -> annexName.equalsIgnoreCase(subclause.getName())
						&& subclause instanceof DefaultAnnexSubclause)
				.map(DefaultAnnexSubclause.class::cast);
	}

	/**
	 * Returns a stream of all the non-null parsed annex subclauses of the annex subclauses in the specified classifier with the
	 * specified annex name.
	 * Throws an exception if a parsed annex subclause is non-null but is not of the expected type.
	 * @param <T> is the type of the parsed annex subclause
	 * @param classifier is the classifier in which to look for the annex subclauses.
	 * @param annexName is the name of the annex subclauses to look for.
	 * @param parsedType is the java type that the parsed subclause is expected to be an instance of.
	 * @return a stream containing the matching subclauses.
	 */
	public static <T> Stream<T> getAllParsedAnnexSubclauses(final Classifier classifier, final String annexName,
			final Class<T> parsedType) {
		return getAllDefaultAnnexSubclauses(classifier, annexName)
				.map(subclause -> getParsedAnnexSubclause(subclause, parsedType).orElse(null))
				.filter(Objects::nonNull);
	}

	/**
	 * Retrieves the parsed annex subclause from a {@link DefaultAnnexSubclause} instance.
	 * Throws an exception if a parsed subclause was found but was of an unexpected type.
	 * @param <T> is the type of the parsed annex subclause
	 * @param defaultSubclause is the annex subclause to return the parsed subclause for
	 * @param parsedType is the java type that the parsed subclause is expected to be an instance of.
	 * @return an optional describing the subclause. Empty if the parsed subclause is null.
	 */
	private static <T> Optional<T> getParsedAnnexSubclause(final DefaultAnnexSubclause defaultSubclause,
			final Class<T> parsedType) {
		final AnnexSubclause parsedSubclause = defaultSubclause.getParsedAnnexSubclause();
		if (parsedSubclause == null) {
			return Optional.empty();
		}

		if (parsedType.isInstance(parsedSubclause)) {
			return Optional.of(parsedType.cast(parsedSubclause));
		} else {
			throw new IllegalArgumentException(
					"Invalid parsed type. Parsed annex subclause is not of specified type. Specified: "
							+ parsedType.getName() + ". Actual: " + parsedSubclause.getClass().getName());
		}
	}

	/**
	 * Returns true if the specified text is an annex source block which is empty except for the starting and ending tokens.
	 * @param src is the source text to check.
	 * @return true if the source represents an empty annex source block. Otherwise, false.
	 */
	private static boolean isEmptyAnnexSource(final String src) {
		final String trimmedSrc = src.trim();
		if (trimmedSrc.startsWith(ANNEX_SOURCE_START) && trimmedSrc.endsWith(ANNEX_SOURCE_END)) {
			final String innerSrc = trimmedSrc
					.substring(ANNEX_SOURCE_START.length(), trimmedSrc.length() - ANNEX_SOURCE_END.length()).trim();
			return innerSrc.isEmpty();
		}

		return false;
	}
}
