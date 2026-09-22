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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3295Test extends XtextTest {
	private static final String DIRECTORY = "org.osate.xtext.aadl2.ba.tests/models/issue3295/";

	@Inject
	private TestHelper<AadlPackage> testHelper;
	@Inject
	private ValidationTestHelper validation;
	@Inject
	private IReferenceFinder finder;
	@Inject
	private Provider<TargetURIs> targets;
	@Inject
	private IResourceDescription.Manager descriptions;
	@Inject
	private ILocationInFileProvider locations;

	@Test
	public void findsLocalVariableUses() {
		var source = load();
		var implementation = (ComponentImplementation) source.getOwnedPublicSection().getOwnedClassifiers().get(1);
		var annex = (BehaviorAnnex) ((DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses().getFirst())
				.getParsedAnnexSubclause();
		var variable = annex.getVariableGroups().getFirst().getVariables().getFirst();
		var matches = new Matches();
		finder.findReferences(targets(variable), source.eResource(), matches, new NullProgressMonitor());
		assertMatches(source.eResource().getResourceSet(), matches, "counter", 2);
	}

	@Test
	public void findsLoadedPortReferences() {
		var source = load();
		var matches = new Matches();
		finder.findReferences(targets(input(source)), source.eResource(), matches, new NullProgressMonitor());
		assertMatches(source.eResource().getResourceSet(), matches, "input", 2);
	}

	@Test
	public void respectsTheRequestedSubtree() {
		var source = load();
		var segment = EcoreUtil2.getAllContentsOfType(source, ReferenceSegment.class).stream()
				.filter(reference -> reference.getName().equals("input")).findFirst().orElseThrow();
		var matches = new Matches();
		finder.findReferences(targets(input(source)), segment, matches, new NullProgressMonitor());
		assertMatches(source.eResource().getResourceSet(), matches, "input", 1);
	}

	@Test
	public void updatesReferencesAfterReparsing() throws Exception {
		var source = load();
		var resource = (XtextResource) source.eResource();
		var targetURIs = targets(input(source));
		var original = new Matches();
		finder.findReferences(targetURIs, resource, original, new NullProgressMonitor());
		assertMatches(resource.getResourceSet(), original, "input", 2);
		resource.reparse(resource.getParseResult().getRootNode().getText().replace("input'count", "0"));
		validation.assertNoIssues(resource);
		var updated = new Matches();
		finder.findReferences(targetURIs, resource, updated, new NullProgressMonitor());
		assertMatches(resource.getResourceSet(), updated, "input", 1);
	}

	@Test
	public void ignoresAnUnresolvedReference() throws Exception {
		var source = load();
		var resource = (XtextResource) source.eResource();
		var targetURIs = targets(input(source));
		resource.reparse(resource.getParseResult().getRootNode().getText().replace("input'count", "missing'count"));
		var matches = new Matches();
		finder.findReferences(targetURIs, resource, matches, new NullProgressMonitor());
		assertMatches(resource.getResourceSet(), matches, "input", 1);
	}

	@Test
	public void preservesOrdinaryIndexedReferences() throws Exception {
		var source = load();
		var base = ((ComponentType) source.getOwnedPublicSection().getOwnedClassifiers().getFirst()).getExtended();
		var matches = new Matches();
		finder.findReferences(targets(base), persist(descriptions.getResourceDescription(source.eResource())), null,
				matches, new NullProgressMonitor());
		assertMatches(source.eResource().getResourceSet(), matches, "ReferenceDefinitions::Base", 1);
	}

	@Test
	public void honorsCancellation() {
		var source = load();
		var monitor = new NullProgressMonitor();
		monitor.setCanceled(true);
		assertThrows(OperationCanceledException.class,
				() -> finder.findReferences(targets(input(source)), source.eResource(), new Matches(), monitor));
	}

	@Test
	public void findsUsesInAnUnloadedFileAfterIndexSerialization() throws Exception {
		var source = load();
		var sourceResource = (XtextResource) source.eResource();
		var target = input(source);
		var resourceSet = sourceResource.getResourceSet();
		var plain = testHelper.loadFile(DIRECTORY + "Plain.aadl", resourceSet);
		validation.assertNoIssues(plain);
		var index = new ResourceDescriptionsData(List.of(persist(descriptions.getResourceDescription(sourceResource)),
				persist(descriptions.getResourceDescription(target.eResource())),
				persist(descriptions.getResourceDescription(plain))));
		var targetURIs = targets(target);
		sourceResource.unload();
		plain.unload();
		assertFalse(sourceResource.isLoaded());
		var matches = new Matches();
		var readResources = new ArrayList<URI>();
		finder.findAllReferences(targetURIs, new IReferenceFinder.IResourceAccess() {
			@Override
			public <Result> Result readOnly(URI uri, IUnitOfWork<Result, ResourceSet> work) {
				readResources.add(uri);
				try {
					var resource = resourceSet.getResource(uri, false);
					assertNotNull(resource);
					if (!resource.isLoaded()) {
						var file = Path.of(System.getProperty("user.dir"), "..", uri.toString());
						try (var stream = Files.newInputStream(file)) {
							resource.load(stream, resourceSet.getLoadOptions());
						}
					}
					return work.exec(resourceSet);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			}
		}, index, matches, new NullProgressMonitor());
		assertMatches(resourceSet, matches, "input", 2);
		assertTrue("The closed BA file must be searched", readResources.contains(sourceResource.getURI()));
		assertFalse("Files without annex references must not be loaded", readResources.contains(plain.getURI()));
	}

	private AadlPackage load() {
		var source = testHelper.parseFile(DIRECTORY + "Issue3295.aadl", DIRECTORY + "Definitions.aadl");
		validation.assertNoIssues(source);
		var base = ((ComponentType) source.getOwnedPublicSection().getOwnedClassifiers().getFirst()).getExtended();
		validation.assertNoIssues(base.eResource());
		return source;
	}

	private static EObject input(AadlPackage source) {
		return ((ComponentType) source.getOwnedPublicSection().getOwnedClassifiers().getFirst())
				.getExtended().getOwnedFeatures().getFirst();
	}

	private TargetURIs targets(EObject target) {
		var result = targets.get();
		result.addURI(EcoreUtil2.getPlatformResourceOrNormalizedURI(target));
		return result;
	}

	private void assertMatches(ResourceSet resourceSet, Matches matches, String token, int count) {
		assertEquals(matches.references.toString(), count, matches.references.size());
		for (var reference : matches.references) {
			var source = resourceSet.getEObject(reference.getSourceEObjectUri(), true);
			var region = reference.getEReference() == null ? locations.getSignificantTextRegion(source)
					: locations.getSignificantTextRegion(source, reference.getEReference(), reference.getIndexInList());
			assertNotNull(region);
			assertEquals(region,
					locations.getSignificantTextRegion(source, reference.getEReference(), reference.getIndexInList()));
			var text = ((XtextResource) source.eResource()).getParseResult().getRootNode().getText();
			assertEquals(token, text.substring(region.getOffset(), region.getOffset() + region.getLength()));
		}
	}

	private static IResourceDescription persist(IResourceDescription description) throws Exception {
		var bytes = new ByteArrayOutputStream();
		try (var output = new ObjectOutputStream(bytes)) {
			output.writeObject(SerializableResourceDescription.createCopy(description));
		}
		try (var input = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
			return (IResourceDescription) input.readObject();
		}
	}

	private static final class Matches implements IReferenceFinder.Acceptor {
		private final List<IReferenceDescription> references = new ArrayList<>();

		@Override
		public void accept(IReferenceDescription description) {
			references.add(description);
		}

		@Override
		public void accept(EObject source, URI sourceURI, EReference reference, int index, EObject target, URI targetURI) {
			accept(new DefaultReferenceDescription(sourceURI, targetURI, reference, index, null));
		}
	}
}
