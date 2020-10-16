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
package org.osate.ge.errormodel.ui.viewmodels;

import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Provides the error types contained in a project. Provides names provided by the element's
 * {@link IEObjectDescription}. This allows retrieving the name of matching objects without resolving the instance.
 *
 */
public class ProjectErrorTypesProvider implements NamedObjectsProvider<ErrorTypes> {
	private final ImmutableList<ErrorTypes> errorTypes;
	private final ImmutableMap<URI, String> typeToNameMap;

	public ProjectErrorTypesProvider(final IProject project) {
		// Build a list of available error types and a mapping from URI to type name
		final ImmutableList.Builder<ErrorTypes> errorTypesBuilder = ImmutableList.builder();
		final ImmutableMap.Builder<URI, String> typeToNameMap = new ImmutableMap.Builder<>();
		for (final IEObjectDescription d : AadlModelAccessUtil.getAllEObjectsByType(project,
				ErrorModelPackage.eINSTANCE.getErrorTypes())) {
			final String qualifiedName = ErrorModelViewModelUtil.getQualifiedName(d);
			final ErrorTypes type = (ErrorTypes) d.getEObjectOrProxy();

			errorTypesBuilder.add(type);
			typeToNameMap.put(EcoreUtil.getURI(type), qualifiedName);
		}

		this.errorTypes = errorTypesBuilder.build();
		this.typeToNameMap = typeToNameMap.build();
	}

	@Override
	public Stream<ErrorTypes> getValues() {
		return errorTypes.stream();
	}

	@Override
	public String getName(ErrorTypes value) {
		return typeToNameMap.get(EcoreUtil.getURI(value));
	}

}
