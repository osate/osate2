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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.SystemType;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Tests AADL linking against serialized descriptions from an earlier build while the target package
 * is absent from the fresh resource set. This distinguishes returning an index proxy from eagerly
 * loading the target, and the build-order cases guard the #1009 behavior needed before #1836 can
 * restore unresolved-proxy caching.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3119Test extends AbstractIncrementalBuilderTest {
	private static final String MODEL_PATH = "models/issue3119/";

	@Override
	protected IResourceServiceProvider.Registry getLanguages() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

	@Test
	public void terminalReferenceCurrentlyLoadsPersistedIndexTarget() throws Exception {
		StagedBuild staged = buildTargetThenReference();

		assertNotNull(staged.referenceResourceSet().getResource(staged.targetUri(), false));

		DataPort port = findDataPort(staged.referenceResourceSet(), staged.referenceUri());
		EObject rawClassifier = (EObject) port.eGet(Aadl2Package.eINSTANCE.getDataPort_DataFeatureClassifier(), false);
		assertNotNull(rawClassifier);
		assertFalse(rawClassifier.eIsProxy());
	}

	@Test
	public void addingTargetAfterReferenceRebuildsAffectedFile() throws Exception {
		URI reference = newFile("Issue3119.aadl", readModel("Issue3119.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(List.of(reference))));
		assertFalse(describeIssues().isEmpty());

		URI target = newFile("Other.aadl", readModel("Other.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(List.of(target))));
		assertTrue(describeIssues().toString(), describeIssues().isEmpty());
	}

	@Test
	public void cleanBuildIsIndependentOfDirtyFileOrder() throws Exception {
		assertCleanBuildHasNoIssues(List.of("Issue3119.aadl", "Other.aadl"));
	}

	@Test
	public void cleanBuildAlsoWorksInReverseDirtyFileOrder() throws Exception {
		assertCleanBuildHasNoIssues(List.of("Other.aadl", "Issue3119.aadl"));
	}

	private StagedBuild buildTargetThenReference() throws Exception {
		URI target = newFile("Other.aadl", readModel("Other.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(List.of(target))));
		assertTrue(describeIssues().toString(), describeIssues().isEmpty());

		URI reference = newFile("Issue3119.aadl", readModel("Issue3119.aadl"));
		BuildRequest referenceContext = newBuildRequest(request -> request.setIndexOnly(true));
		XtextResourceSet referenceResourceSet = referenceContext.getResourceSet();
		assertNull(referenceResourceSet.getResource(target, false));
		var referenceResource = referenceResourceSet.getResource(reference, true);
		EcoreUtil2.resolveLazyCrossReferences(referenceResource, CancelIndicator.NullImpl);
		assertTrue(referenceResource.getErrors().toString(), referenceResource.getErrors().isEmpty());
		return new StagedBuild(target, reference, referenceResourceSet);
	}

	private void assertCleanBuildHasNoIssues(List<String> dirtyFileOrder) throws Exception {
		URI reference = newFile("Issue3119.aadl", readModel("Issue3119.aadl"));
		URI target = newFile("Other.aadl", readModel("Other.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(dirtyFileOrder.stream()
				.map(name -> name.equals("Other.aadl") ? target : reference)
				.toList())));

		assertTrue(describeIssues().toString(), describeIssues().isEmpty());
	}

	private static DataPort findDataPort(XtextResourceSet resourceSet, URI referenceUri) {
		var resource = resourceSet.getResource(referenceUri, false);
		var pkg = (AadlPackage) resource.getContents().get(0);
		var system = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().get(0);
		return (DataPort) system.getOwnedFeatures().get(0);
	}

	private String readModel(String name) throws IOException {
		try (var stream = getClass().getClassLoader().getResourceAsStream(MODEL_PATH + name)) {
			assertNotNull(name, stream);
			return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
		}
	}

	private List<String> describeIssues() {
		return issues.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.toList();
	}

	private record StagedBuild(URI targetUri, URI referenceUri, XtextResourceSet referenceResourceSet) {
	}
}
