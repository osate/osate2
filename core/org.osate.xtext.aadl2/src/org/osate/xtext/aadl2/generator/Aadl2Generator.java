/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.generator;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PackageSection;
import org.osate.annexsupport.AnnexGeneratorRegistry;
import org.osate.annexsupport.AnnexRegistry;

/**
 * Generates code from your model files on save.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 * @since 6.3
 */
public class Aadl2Generator extends AbstractGenerator {
	private AnnexGeneratorRegistry annexGeneratorRegistry;

	private void initAnnexGeneratorRegistry() {
		if (annexGeneratorRegistry == null) {
			annexGeneratorRegistry = (AnnexGeneratorRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_GENERATOR_EXT_ID);
		}
	}

	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource.getContents().size() == 1 && resource.getContents().get(0) instanceof AadlPackage pkg) {
			var annexNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			collectAnnexNames(pkg.getOwnedPublicSection(), annexNames);
			collectAnnexNames(pkg.getOwnedPrivateSection(), annexNames);
			for (var annexName : annexNames) {
				if (annexGeneratorRegistry == null) {
					initAnnexGeneratorRegistry();
				}
				if (annexGeneratorRegistry != null) {
					var generator = annexGeneratorRegistry.getAnnexGenerator(annexName);
					if (generator != null) {
						generator.doGenerate(resource, fsa, context);
					}
				}
			}
		}
	}

	private static void collectAnnexNames(PackageSection packageSection, Set<String> annexNames) {
		if (packageSection != null) {
			for (var library : packageSection.getOwnedAnnexLibraries()) {
				annexNames.add(library.getName());
			}
			for (var classifier : packageSection.getOwnedClassifiers()) {
				for (var subclause : classifier.getOwnedAnnexSubclauses()) {
					annexNames.add(subclause.getName());
				}
			}
		}
	}
}