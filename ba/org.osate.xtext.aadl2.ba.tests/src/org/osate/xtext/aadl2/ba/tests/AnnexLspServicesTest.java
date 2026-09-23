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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.PrepareRenameParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameOptions;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService;
import org.eclipse.xtext.ide.server.rename.IRenameService2;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;
import org.osate.xtext.aadl2.ide.Aadl2IdeModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.itemis.xtext.testing.XtextTest;

/**
 * Exercises the public LSP services on external AADL fixtures. Rename
 * preparation, workspace edits, and exact highlight/reference ranges must work
 * for embedded BA and EMV2, including closed files.
 */
@RunWith(XtextRunner.class)
@InjectWith(AnnexLspServicesTest.IdeInjectorProvider.class)
public class AnnexLspServicesTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> helper;
	@Inject
	private ValidationTestHelper validation;
	@Inject
	private Injector injector;
	private Path directory;
	private ResourceSet resources;
	private ResourceDescriptionsData index;
	private final Map<URI, String> texts = new LinkedHashMap<>();

	@Test
	public void preparesBehaviorVariableDeclaration() throws Exception {
		var resource = load("issue3300", "Issue3300.aadl");
		assertPrepared(resource, "counter", 0);
	}
	@Test
	public void preparesBehaviorVariableReference() throws Exception {
		var resource = load("issue3300", "Issue3300.aadl");
		assertPrepared(resource, "counter", 1);
	}
	@Test
	public void renamesCorePortAndSymbolicUses() throws Exception {
		assertRename(load("issue3300", "Issue3300.aadl"), "input", 0, "new_input");
	}
	@Test
	public void renamesBehaviorVariableFromUse() throws Exception {
		assertRename(load("issue3300", "Issue3300.aadl"), "counter", 1, "new_counter");
	}
	@Test
	public void renamesBehaviorStateFromTransition() throws Exception {
		assertRename(load("issue3300", "Issue3300.aadl"), "idle", 1, "waiting");
	}
	@Test
	public void renamesSubcomponentAndSymbolicUses() throws Exception {
		assertRename(load("issue3300", "Issue3300.aadl"), "DesiredPositionState", 0, "new_state");
	}
	@Test
	public void renamesCoreFeatureAndEmv2Flows() throws Exception {
		assertRename(load("issue3302", "Issue3302.aadl"), "input", 0, "new_input");
	}
	@Test
	public void renamesFeatureFromQualifiedEmv2Flow() throws Exception {
		assertRename(load("issue3308", "Qualified.aadl"), "left", 2, "renamed_left");
	}
	@Test
	public void renamesLeafFeatureAcrossGroups() throws Exception {
		assertRename(load("issue3308", "Qualified.aadl"), "value", 4, "renamed_value");
	}
	@Test
	public void findsAndRenamesClosedBehaviorReferences() throws Exception {
		var resource = load("issue3295", "Definitions.aadl", "Issue3295.aadl");
		resources.getResource(uri("Issue3295.aadl"), false).unload();
		assertReferences(resource, "input", 0, 2);
		assertRename(resource, "input", 0, "new_input");
	}
	@Test
	public void renamesInheritedEmv2FeatureInClosedFile() throws Exception {
		var resource = load("issue3302", "Definitions.aadl", "Uses.aadl");
		resources.getResource(uri("Uses.aadl"), false).unload();
		assertRename(resource, "input", 0, "new_input");
	}
	@Test
	public void highlightsOnlyQualifiedPrefix() throws Exception {
		assertHighlights(load("issue3308", "Qualified.aadl"), "left", 2, 3);
	}
	@Test
	public void highlightsLeafAcrossGroups() throws Exception {
		assertHighlights(load("issue3308", "Qualified.aadl"), "value", 4, 5);
	}
	@Test
	public void locatesOnlyQualifiedReferenceSegment() throws Exception {
		assertReferences(load("issue3308", "Qualified.aadl"), "left", 2, 2);
	}
	@Test
	public void highlightsSymbolicBehaviorUses() throws Exception {
		assertHighlights(load("issue3300", "Issue3300.aadl"), "counter", 1, 4);
	}

	private XtextResource load(String project, String primary, String... additional) throws Exception {
		String prefix = "org.osate.xtext.aadl2.ba.tests/models/" + project + "/";
		var pkg = helper.parseFile(prefix + primary,
				java.util.Arrays.stream(additional).map(prefix::concat).toArray(String[]::new));
		resources = pkg.eResource().getResourceSet();
		directory = Files.createTempDirectory("annex-lsp-").toRealPath();
		var names = new ArrayList<>(List.of(additional));
		names.add(primary);
		for (String name : names) {
			var resource = (XtextResource) resources.getResource(URI.createURI(prefix + name), false);
			validation.assertNoIssues(resource);
			String text = resource.getParseResult().getRootNode().getText();
			Files.writeString(directory.resolve(name), text);
			resource.setURI(uri(name));
			resource.getCache().clear(resource);
			texts.put(resource.getURI(), text);
		}
		var descriptions = new ArrayList<IResourceDescription>();
		for (var resource : List.copyOf(resources.getResources())) {
			if (resource instanceof XtextResource xtext && xtext.getParseResult() != null) {
				descriptions.add(SerializableResourceDescription.createCopy(xtext.getResourceServiceProvider()
						.getResourceDescriptionManager().getResourceDescription(xtext)));
			}
		}
		index = new ResourceDescriptionsData(descriptions);
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resources, index);
		return (XtextResource) resources.getResource(uri(primary), true);
	}

	private void assertHighlights(XtextResource resource, String token, int occurrence, int expected) {
		var document = document(resource.getURI());
		var params = new DocumentHighlightParams(new TextDocumentIdentifier(resource.getURI().toString()),
				document.getPosition(offset(resource, token, occurrence)));
		var result = injector.getInstance(IDocumentHighlightService.class).getDocumentHighlights(document, resource,
				params, CancelIndicator.NullImpl);
		assertEquals(result.toString(), expected, result.size());
		for (var highlight : result) {
			assertEquals(token, slice(document, highlight.getRange()));
		}
		assertEquals("Duplicate highlight ranges", expected,
				result.stream().map(DocumentHighlight::getRange).distinct().count());
	}

	private void assertReferences(XtextResource resource, String token, int occurrence, int expected) {
		var result = injector.getInstance(DocumentSymbolService.class).getReferences(resource,
				offset(resource, token, occurrence), new IReferenceFinder.IResourceAccess() {
					@Override
					public <T> T readOnly(URI uri, IUnitOfWork<T, ResourceSet> work) {
						try {
							resources.getResource(uri.trimFragment(), true);
							return work.exec(resources);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}, index, CancelIndicator.NullImpl);
		assertEquals(result.toString(), expected, result.size());
		for (var location : result) {
			assertEquals(token, slice(document(URI.createURI(location.getUri())), location.getRange()));
		}
	}

	private void assertPrepared(XtextResource resource, String token, int occurrence) {
		var options = new IRenameService2.PrepareRenameOptions();
		options.setLanguageServerAccess(new Access());
		options.setCancelIndicator(CancelIndicator.NullImpl);
		options.setParams(new PrepareRenameParams(new TextDocumentIdentifier(resource.getURI().toString()),
				document(resource.getURI()).getPosition(offset(resource, token, occurrence))));
		var result = injector.getInstance(IRenameService2.class).prepareRename(options);
		assertNotNull("Rename should be available at " + token, result);
		assertTrue(result.isFirst());
		assertEquals(token, slice(document(resource.getURI()), result.getFirst()));
	}

	private void assertRename(XtextResource resource, String oldName, int occurrence, String newName) throws Exception {
		var options = new IRenameService2.Options();
		options.setLanguageServerAccess(new Access());
		options.setCancelIndicator(CancelIndicator.NullImpl);
		options.setRenameParams(new RenameParams(new TextDocumentIdentifier(resource.getURI().toString()),
				document(resource.getURI()).getPosition(offset(resource, oldName, occurrence)), newName));
		var edit = injector.getInstance(IRenameService2.class).rename(options);
		assertNotNull("Rename must produce an edit", edit);
		assertNotNull(edit.getChanges());
		var renamed = new LinkedHashMap<>(texts);
		for (var entry : edit.getChanges().entrySet()) {
			URI uri = canonical(URI.createURI(entry.getKey()));
			var doc = document(uri);
			var result = new StringBuilder(doc.getContents());
			var edits = entry.getValue().stream()
					.sorted(Comparator.comparingInt((TextEdit e) -> doc.getOffSet(e.getRange().getStart())).reversed())
					.toList();
			int previousStart = result.length();
			for (var textEdit : edits) {
				int start = doc.getOffSet(textEdit.getRange().getStart());
				int end = doc.getOffSet(textEdit.getRange().getEnd());
				assertTrue("Overlapping edits", end <= previousStart);
				result.replace(start, end, textEdit.getNewText());
				previousStart = start;
			}
			renamed.put(uri, result.toString());
		}
		for (var entry : texts.entrySet()) {
			assertEquals(
					entry.getKey().toString(), entry.getValue()
							.replaceAll("(?<![\\w])" + java.util.regex.Pattern.quote(oldName) + "(?![\\w])", newName),
					renamed.get(entry.getKey()));
		}
		var reparsed = freshResourceSet();
		for (var entry : renamed.entrySet()) {
			var target = reparsed.createResource(entry.getKey());
			target.load(new ByteArrayInputStream(entry.getValue().getBytes(StandardCharsets.UTF_8)), null);
		}
		for (var uri : texts.keySet())
			validation.assertNoIssues(reparsed.getResource(uri, true));
	}

	private ResourceSet freshResourceSet() {
		var result = injector.getInstance(XtextResourceSet.class);
		for (var resource : List.copyOf(resources.getResources())) {
			if (!texts.containsKey(resource.getURI()))
				result.getResource(resource.getURI(), true);
		}
		result.getURIConverter().getURIMap().putAll(resources.getURIConverter().getURIMap());
		return result;
	}

	private int offset(XtextResource resource, String token, int occurrence) {
		String text = texts.get(resource.getURI());
		var matches = java.util.regex.Pattern.compile("(?<![\\w])" + java.util.regex.Pattern.quote(token) + "(?![\\w])")
				.matcher(text);
		for (int i = 0; i <= occurrence; i++)
			assertTrue(token, matches.find());
		return matches.start() + 1;
	}

	private static String slice(Document document, Range range) {
		return document.getContents().substring(document.getOffSet(range.getStart()),
				document.getOffSet(range.getEnd()));
	}
	private URI uri(String name) {
		return URI.createFileURI(directory.resolve(name).toString());
	}
	private static URI canonical(URI uri) {
		return uri.isFile() ? URI.createFileURI(Path.of(java.net.URI.create(uri.toString())).toString()) : uri;
	}
	private Document document(URI uri) {
		String text = texts.get(canonical(uri));
		assertNotNull("Unknown document " + uri + " in " + texts.keySet(), text);
		return new Document(1, text);
	}

	@After
	public void cleanup() throws Exception {
		if (resources != null)
			resources.eAdapters().removeIf(ResourceDescriptionsData.ResourceSetAdapter.class::isInstance);
		if (directory != null) {
			try (var paths = Files.walk(directory)) {
				for (var path : paths.sorted(Comparator.reverseOrder()).toList())
					Files.delete(path);
			}
		}
	}

	private final class Access implements ILanguageServerAccess {
		@Override
		public <T> CompletableFuture<T> doRead(String uri, Function<Context, T> work) {
			return CompletableFuture.completedFuture(doSyncRead(uri, work));
		}
		@Override
		public <T> T doSyncRead(String uri, Function<Context, T> work) {
			var emfUri = canonical(URI.createURI(uri));
			return work.apply(
					new Context(resources.getResource(emfUri, true), document(emfUri), true, CancelIndicator.NullImpl));
		}
		@Override
		public <T> CompletableFuture<T> doReadIndex(Function<? super IndexContext, ? extends T> work) {
			return CompletableFuture.completedFuture(work.apply(new IndexContext(index, CancelIndicator.NullImpl)));
		}
		@Override
		public ResourceSet newLiveScopeResourceSet(URI uri) {
			var result = freshResourceSet();
			ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(result, index);
			return result;
		}
		@Override
		public InitializeParams getInitializeParams() {
			var params = new InitializeParams();
			params.setCapabilities(new ClientCapabilities());
			return params;
		}
		@Override
		public InitializeResult getInitializeResult() {
			var capabilities = new ServerCapabilities();
			capabilities.setRenameProvider(new RenameOptions(true));
			return new InitializeResult(capabilities);
		}
		@Override
		public LanguageClient getLanguageClient() {
			return null;
		}
		@Override
		public void addBuildListener(IBuildListener listener) {
		}
	}

	public static final class IdeInjectorProvider extends Aadl2InjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			new BehaviorAnnexStandaloneSetup().createInjectorAndDoEMFRegistration();
			new ErrorModelStandaloneSetup().createInjectorAndDoEMFRegistration();
			return new Aadl2StandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(Modules2.mixin(createRuntimeModule(), new Aadl2IdeModule()));
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}
}
