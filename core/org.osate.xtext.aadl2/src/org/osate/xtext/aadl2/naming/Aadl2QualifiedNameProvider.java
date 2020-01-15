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
package org.osate.xtext.aadl2.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;

public class Aadl2QualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	AnnexLinkingServiceRegistry annexlinkingserviceregistry;

	protected AnnexLinkingServiceRegistry getAnnexLinkingServiceRegistry() {
		if (annexlinkingserviceregistry == null) {
			annexlinkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		}
		return annexlinkingserviceregistry;
	}

	// Enable to limit indexing to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (!(obj instanceof NamedElement)) {
			return null;
		}
		NamedElement annex = AadlUtil.getContainingAnnex(obj);
		if (annex != null) {
			String annexName = annex.getName();
			if (annexName != null) {
				if (annexlinkingserviceregistry == null) {
					getAnnexLinkingServiceRegistry();
				}
				if (annexlinkingserviceregistry != null) {
					AnnexLinkingService linkingservice = getAnnexLinkingServiceRegistry()
							.getAnnexLinkingService(annexName);
					if (linkingservice != null) {
						return linkingservice.getFullyQualifiedName(obj);
					}
				}
			}
		}
		if (obj instanceof AadlPackage || obj instanceof Classifier || obj instanceof PropertyConstant
				|| obj instanceof Property || obj instanceof PropertySet || obj instanceof PropertyType ||
				// DB: We also want a qualified name for package sections
				obj instanceof PackageSection) {
			if (((NamedElement) obj).getName() == null) {
				return null;
			}
			return getConverter().toQualifiedName(getTheName((NamedElement) obj));
		}
		return null;
	}

	protected String getTheName(NamedElement namedElement) {
		if (namedElement.getName() != null) {
			Namespace namespace = namedElement.getNamespace();
			if (namespace != null) {
				if (namespace instanceof PropertySet && namespace.hasName()) {
					return namespace.getName() + "::" + namedElement.getName();
				} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
					return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
				} else {
					return namedElement.getName();
				}
			} else {
				return namedElement.getName();
			}
		} else {
			return "<noname>";
		}
	}

	public String getDelimiter() {
		return "::";
	}

}