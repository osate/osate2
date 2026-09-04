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
package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * Utilities for traversing an error model library and the libraries it extends.
 */
public final class ErrorModelUtil {
	private ErrorModelUtil() {
	}

	public static Iterable<ErrorType> getAllErrorTypes(final ErrorModelLibrary library) {
		return getAllErrorLibraries(library).stream().flatMap(current -> current.getTypes().stream()).toList();
	}

	public static Iterable<TypeSet> getAllTypesets(final ErrorModelLibrary library) {
		return getAllErrorLibraries(library).stream().flatMap(current -> current.getTypesets().stream()).toList();
	}

	public static List<ErrorModelLibrary> getAllErrorLibraries(final ErrorModelLibrary library) {
		var result = new ArrayList<ErrorModelLibrary>();
		addErrorLibraries(library, new HashSet<>(), result);
		return List.copyOf(result);
	}

	private static void addErrorLibraries(final ErrorModelLibrary library, final Set<ErrorModelLibrary> visited,
			final List<ErrorModelLibrary> result) {
		if (!visited.add(library)) {
			return;
		}
		for (var extendedLibrary : library.getExtends()) {
			addErrorLibraries(extendedLibrary, visited, result);
		}
		result.add(library);
	}
}
