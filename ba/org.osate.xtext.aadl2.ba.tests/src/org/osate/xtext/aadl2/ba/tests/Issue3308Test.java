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
import static org.junit.Assert.assertSame;
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
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
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
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3308Test extends XtextTest {
	private static final String DIRECTORY = "org.osate.xtext.aadl2.ba.tests/models/issue3308/";

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

	@Before
	public void registerEmv2() {
		ErrorModelStandaloneSetup.doSetup();
	}

	@Test
	public void highlightsFlowsFromCoreDeclaration() throws Exception {
		assertOccurrences("Issue3308.aadl", "Commanded_Position", 6, 0, 6, List.of(0));
	}

	@Test
	public void highlightsCoreAndPropagationsFromErrorFlow() throws Exception {
		assertOccurrences("Issue3308.aadl", "Commanded_Position", 6, 0, 6, List.of(4, 5));
	}

	@Test
	public void highlightsFromPositiveAndNegativePropagationNames() throws Exception {
		assertOccurrences("Issue3308.aadl", "Commanded_Position", 6, 0, 6, List.of(2, 3));
	}

	@Test
	public void highlightsOutputSourcesAndPaths() throws Exception {
		assertOccurrences("Issue3308.aadl", "result", 6, 0, 6, List.of(0, 2, 3, 4, 5));
	}

	@Test
	public void distinguishesSameNamedFeatures() throws Exception {
		assertOccurrences("Scopes.aadl", "Commanded_Position", 9, 0, 6, List.of(0, 4, 5));
		assertOccurrences("Scopes.aadl", "Commanded_Position", 9, 6, 9, List.of(6, 7, 8));
	}

	@Test
	public void highlightsOnlyTheSelectedFeatureGroupPrefix() throws Exception {
		assertOccurrences("Qualified.aadl", "left", 3, 0, 3, List.of(0, 1, 2));
		assertOccurrences("Qualified.aadl", "right", 3, 0, 3, List.of(0, 1, 2));
	}

	@Test
	public void highlightsLeafFeaturesAcrossGroupUses() throws Exception {
		assertOccurrences("Qualified.aadl", "value", 5, 0, 5, List.of(0, 1, 2, 3, 4));
	}

	@Test
	public void findsErrorFlowsFromCoreFeature() throws Exception {
		assertSearch(false, false);
	}

	@Test
	public void findsReferencesFromErrorFlowSelection() throws Exception {
		assertSearch(true, false);
	}

	@Test
	public void avoidsDuplicatesWhenPropagationTargetsAreAlreadyIncluded() throws Exception {
		assertSearch(false, true);
	}

	@Test
	public void preservesTheSemanticErrorPropagationCrossReference() throws Exception {
		var resource = load("Issue3308.aadl");
		var offset = offsets(resource, "Commanded_Position").getLast();
		assertTrue(ui().getInstance(EObjectAtOffsetHelper.class)
				.resolveCrossReferencedElementAt(resource, offset) instanceof ErrorPropagation);
	}

	@Test
	public void honorsCancellation() throws Exception {
		var resource = load("Issue3308.aadl");
		var target = ui().getInstance(EObjectAtOffsetHelper.class)
				.resolveElementAt(resource, offsets(resource, "Commanded_Position").getFirst());
		var monitor = new NullProgressMonitor();
		monitor.setCanceled(true);
		assertThrows(OperationCanceledException.class,
				() -> finder.findReferences(targets(target), resource, new Matches(), monitor));
	}

	@Test
	public void findsInheritedPropagationsInAnUnopenedFile() throws Exception {
		var uses = load("Uses.aadl", "Definitions.aadl");
		var resourceSet = uses.getResourceSet();
		var definitions = (XtextResource) resourceSet.getResource(URI.createURI(DIRECTORY + "Definitions.aadl"), false);
		validation.assertNoIssues(definitions);
		var target = ui().getInstance(EObjectAtOffsetHelper.class)
				.resolveElementAt(definitions, offsets(definitions, "input").getFirst());
		var index = new ResourceDescriptionsData(List.of(persist(descriptions.getResourceDescription(uses)),
				persist(descriptions.getResourceDescription(definitions))));
		uses.unload();
		assertFalse(uses.isLoaded());
		var matches = new Matches();
		var readResources = new ArrayList<URI>();
		finder.findAllReferences(targets(target), new IReferenceFinder.IResourceAccess() {
			@Override
			public <Result> Result readOnly(URI uri, IUnitOfWork<Result, ResourceSet> work) {
				readResources.add(uri);
				try {
					var resource = resourceSet.getResource(uri, false);
					assertNotNull(resource);
					if (!resource.isLoaded()) {
						try (var stream = Files.newInputStream(Path.of(System.getProperty("user.dir"), "..", uri.toString()))) {
							resource.load(stream, resourceSet.getLoadOptions());
						}
					}
					return work.exec(resourceSet);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			}
		}, index, matches, new NullProgressMonitor());
		assertEquals(3, matches.references.size());
		assertTrue(readResources.contains(uses.getURI()));
		assertStructuralMatches(resourceSet, matches, "input");
	}

	private void assertSearch(boolean fromFlow, boolean includePropagations) throws Exception {
		var resource = load("Issue3308.aadl");
		var expected = offsets(resource, "Commanded_Position");
		var helper = ui().getInstance(EObjectAtOffsetHelper.class);
		var declaration = helper.resolveElementAt(resource, expected.getFirst());
		var target = helper.resolveElementAt(resource, fromFlow ? expected.getLast() : expected.getFirst());
		assertSame(declaration, target);
		var targetURIs = targets(target);
		if (includePropagations) {
			for (var propagation : EcoreUtil2.getAllContentsOfType(resource.getContents().getFirst(), ErrorPropagation.class)) {
				if (propagation.getFeatureorPPRef().getFeatureorPP() == target) {
					targetURIs.addURI(EcoreUtil2.getPlatformResourceOrNormalizedURI(propagation));
				}
			}
		}
		var matches = new Matches();
		finder.findReferences(targetURIs, resource, matches, new NullProgressMonitor());
		assertEquals(expected.subList(1, expected.size()), matches.references.stream().map(reference -> {
			var source = resource.getResourceSet().getEObject(reference.getSourceEObjectUri(), true);
			return locations.getSignificantTextRegion(source, reference.getEReference(), reference.getIndexInList()).getOffset();
		}).sorted().toList());
		assertStructuralMatches(resource.getResourceSet(), matches, "Commanded_Position");
	}

	private void assertStructuralMatches(ResourceSet resourceSet, Matches matches, String name) {
		assertEquals(matches.references.size(), matches.references.stream()
				.map(reference -> reference.getSourceEObjectUri() + ":" + reference.getEReference() + ":" + reference.getIndexInList())
				.distinct().count());
		for (var reference : matches.references) {
			assertNotNull("Keep structural EMV2 references for rename", reference.getEReference());
			var source = resourceSet.getEObject(reference.getSourceEObjectUri(), true);
			var region = locations.getSignificantTextRegion(source, reference.getEReference(), reference.getIndexInList());
			var text = ((XtextResource) source.eResource()).getParseResult().getRootNode().getText();
			assertEquals(name, text.substring(region.getOffset(), region.getOffset() + region.getLength()));
		}
	}

	private void assertOccurrences(String file, String name, int total, int from, int to, List<Integer> selections)
			throws Exception {
		var resource = load(file);
		var injector = ui();
		var document = injector.getInstance(XtextDocument.class);
		document.set(resource.getParseResult().getRootNode().getText());
		document.setInput(resource);
		var editor = new XtextEditor() {
			@Override
			public IXtextDocument getDocument() {
				return document;
			}
		};
		try {
			var allOffsets = offsets(resource, name);
			assertEquals(total, allOffsets.size());
			var expected = allOffsets.subList(from, to);
			for (var selection : selections) {
				var annotations = injector.getInstance(IOccurrenceComputer.class).createAnnotationMap(editor,
						new TextSelection(allOffsets.get(selection) + 1, 0), SubMonitor.convert(new NullProgressMonitor()));
				assertEquals("Selection " + selection + " of " + name, expected,
						annotations.values().stream().map(position -> position.offset).sorted().toList());
				annotations.values().forEach(position -> assertEquals(name.length(), position.length));
			}
		} finally {
			document.disposeInput();
		}
	}

	private XtextResource load(String file, String... additionalFiles) {
		var additional = java.util.Arrays.stream(additionalFiles).map(DIRECTORY::concat).toArray(String[]::new);
		var model = testHelper.parseFile(DIRECTORY + file, additional);
		validation.assertNoIssues(model);
		return (XtextResource) model.eResource();
	}

	private static List<Integer> offsets(XtextResource resource, String name) {
		var result = new ArrayList<Integer>();
		var matcher = Pattern.compile("\\b" + Pattern.quote(name) + "\\b")
				.matcher(resource.getParseResult().getRootNode().getText());
		while (matcher.find()) {
			result.add(matcher.start());
		}
		return result;
	}

	private static Injector ui() throws Exception {
		FrameworkUtil.getBundle(Aadl2Activator.class).start();
		return Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	}

	private TargetURIs targets(EObject target) {
		var result = targets.get();
		result.addURI(EcoreUtil2.getPlatformResourceOrNormalizedURI(target));
		return result;
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
