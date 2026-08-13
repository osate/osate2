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
package org.osate.core.tests.instantiation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.aadl2.instantiation.testing.InstantiationCharacterization;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Instantiates a model in a resource set of its own, under a chosen connection
 * traversal strategy.
 *
 * <p>
 * Comparing two traversal strategies, or one strategy against itself for
 * determinism, requires that the runs share nothing. The characterization facade
 * cannot arrange that itself: loading an AADL model needs the Xtext resource
 * machinery and the plug-in contributed packages, which the production bundle must
 * not depend on. So resource-set ownership lives here.
 * </p>
 *
 * <p>
 * {@code TestResourceSetHelper} cannot be used for this. It hands out one shared
 * static {@code XtextResourceSet} and cleans it between calls, so two runs would
 * never be live at the same time and would share EMF objects. This class builds a
 * fresh resource set per run and initializes it the same way.
 * </p>
 */
public class IsolatedInstantiation {

	private static final List<URI> CONTRIBUTED = PluginSupportUtil.getContributedAadl();

	@Inject
	private Provider<XtextResourceSet> resourceSets;

	@Inject
	private TestHelper<AadlPackage> testHelper;

	/**
	 * Instantiate {@code implementationName} from {@code modelPath} in a fresh
	 * resource set.
	 *
	 * @param modelPath the fixture, as a path relative to the test workspace
	 * @param implementationName the component implementation to instantiate
	 * @param strategyName {@code "SOURCE_FIRST"} or {@code "ACROSS_FIRST"}
	 * @param observeDuplicateCandidates whether to keep pre-materialization
	 *            candidate observations
	 */
	public CharacterizationRun run(String modelPath, String implementationName, String strategyName,
			boolean observeDuplicateCandidates) throws Exception {
		return InstantiationCharacterization.run(load(modelPath, implementationName), strategyName,
				observeDuplicateCandidates);
	}

	/**
	 * Load {@code modelPath} into a fresh resource set and return the named
	 * implementation from it.
	 */
	public ComponentImplementation load(String modelPath, String implementationName) {
		XtextResourceSet resourceSet = resourceSets.get();
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		for (URI uri : CONTRIBUTED) {
			resourceSet.getResource(uri, true);
			uriMap.put(uri, URI.createPlatformResourceURI(uri.path().substring(7), false));
		}

		Resource resource = testHelper.loadFile(modelPath, resourceSet);
		if (resource == null || resource.getContents().isEmpty()) {
			throw new IllegalStateException("Could not load " + modelPath + " into an isolated resource set");
		}
		AadlPackage pkg = (AadlPackage) resource.getContents().get(0);
		return pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.filter(ComponentImplementation.class::isInstance)
				.map(ComponentImplementation.class::cast)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(
						"No component implementation named " + implementationName + " in " + modelPath));
	}
}
