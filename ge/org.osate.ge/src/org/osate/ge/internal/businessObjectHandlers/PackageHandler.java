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
package org.osate.ge.internal.businessObjectHandlers;

import java.io.IOException;
import java.util.Collections;

import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.internal.di.DeleteRaw;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

public class PackageHandler {
	private final Graphic graphic = FolderGraphicBuilder.create().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg) {
		return pkg.getQualifiedName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg,
			final @Named(Names.NAME) String value,
			final @Named(InternalNames.PROJECT) IProject project, final NamingService namingService) {
		// If the name hasn't changed or has only changed case
		final String qualifiedName = getName(pkg);
		if (value.equalsIgnoreCase(qualifiedName)) {
			return null;
		}

		final String[] segments = value.split("::");
		for(String segment : segments) {
			if(segment.length() == 0) {
				return "One of the segments in the package name is empty.";
			}

			if(!namingService.isValidIdentifier(segment)) {
				return "The segment '" + segment + "' is not valid.";
			}
		}
		// Compare names with other packages
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())) {
			if(value.equalsIgnoreCase(desc.getQualifiedName().toString("::"))) {
				return "The specified name conflicts with an existing package.";
			}
		}

		// The value is valid
		return null;
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final ReferenceService refService) {
		return pkg.eResource() != null && !pkg.eResource().getURI().isPlatformPlugin();
	}

	@DeleteRaw
	public void delete(final @Named(Names.BUSINESS_OBJECT) AadlPackage pkg, final ReferenceService refService) {
		try {
			((AadlPackage) pkg).eResource().delete(Collections.emptyMap());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
