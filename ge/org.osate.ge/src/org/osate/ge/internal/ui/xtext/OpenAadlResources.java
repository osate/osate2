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
package org.osate.ge.internal.ui.xtext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.NamedElement;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Streams;

/**
 * Data structure for tracking open AADL resources  and listening for changes.
 * If multiple Xtext editors are open for a single AADL resource, it is treated as a single open document.
 * This structure actually tracks all xtext resources, not just AADL files.
 */
class OpenAadlResources {
	private final Map<IXtextDocument, OpenAadlResource> documentToOpenResourceMap = new HashMap<>();

	// qualified names may not be unique not unique. Qualified names will be stored in lowercase format
	// ater OpenAadlResource values are considered newer.
	private final ListMultimap<String, OpenAadlResource> qualifiedNameToOpenResourcesMap = ArrayListMultimap.create();
	private final Map<IXtextDocument, IXtextModelListener> documentToInternalModelListenerMap = new HashMap<>();
	private final List<XtextDocumentChangeListener> externalModelListeners = new CopyOnWriteArrayList<>();

	private static class OpenAadlResource {
		public final IXtextDocument document; // Linked list of documents for the resource. More recently updated documents will be sorted before other
		// documents
		public URI uri;
		public String rootQualifiedName; // May be null. Must be lowercase

		public OpenAadlResource(final URI uri, final IXtextDocument document) {
			this.uri = uri;
			this.document = document;
		}
	}

	public Set<IXtextDocument> getOpenXtextDocuments() {
		return documentToOpenResourceMap.keySet().stream().collect(Collectors.toSet());
	}

	public IXtextDocument getDocument(String qualifiedName, final URI resourceUri) {
		if (qualifiedName == null || resourceUri == null) {
			return null;
		}

		qualifiedName = qualifiedName.toLowerCase();

		final Optional<OpenAadlResource> openResource = Streams.findLast(qualifiedNameToOpenResourcesMap.get(qualifiedName).stream()
				.filter(r -> resourceUri.equals(r.uri)));
		return openResource.map(r -> r.document).orElse(null);
	}

	public void onXtextDocumentOpened(final IXtextDocument document, final URI resourceUri) {
		removeEntriesForDocument(document);

		// Create a new open resource object
		final OpenAadlResource openAadlResource = new OpenAadlResource(resourceUri, document);

		// Add the IXtextDocument -> OpenAadlResource mapping
		documentToOpenResourceMap.put(document, openAadlResource);

		// Create a new model listener
		final IXtextModelListener newModelListener = createModelListener(document);
		documentToInternalModelListenerMap.put(document, newModelListener);
		document.addModelListener(newModelListener);

		// Trigger the initial model changed event.
		document.readOnly(resource -> {
			newModelListener.modelChanged(resource);
			return null;
		});
	}

	/**
	 *
	 * @param document
	 * @return the previously open resource if any.
	 */
	private OpenAadlResource removeEntriesForDocument(final IXtextDocument document) {
		// Remove the document if it was previously opened
		final OpenAadlResource prevOpenResource = documentToOpenResourceMap.remove(document);
		if (prevOpenResource != null) {
			removeQualifiedNameMapping(prevOpenResource);
		}

		documentToInternalModelListenerMap.remove(document);

		// Remove the model listener
		final IXtextModelListener modelListener = documentToInternalModelListenerMap.get(document);
		if (modelListener != null) {
			document.removeModelListener(modelListener);
			documentToInternalModelListenerMap.remove(document);
		}

		return prevOpenResource;
	}

	public void onXtextDocumentClosed(final IXtextDocument document) {
		final OpenAadlResource prevOpenResource = removeEntriesForDocument(document);
		if (prevOpenResource != null) {
			// Notify listeners of one last change since the resource is no longer open
			for (final XtextDocumentChangeListener l : externalModelListeners) {
				l.documentChanged(prevOpenResource.uri);
			}
		}
	}

	private IXtextModelListener createModelListener(final IXtextDocument document) {
		return resource -> {
			final OpenAadlResource openResource = documentToOpenResourceMap.get(document);
			if(openResource != null) {
				openResource.uri = resource.getURI();

				// Determine the new qualified name
				String newQualifiedName = null;
				if (resource != null && resource.getContents().size() > 0) {
					final EObject obj = resource.getContents().get(0);
					if(obj instanceof NamedElement) {
						final String elementQualifiedName = ((NamedElement)obj).getQualifiedName();
						newQualifiedName = elementQualifiedName == null ? null : elementQualifiedName.toLowerCase();
					}
				}

				// If the qualified name has changed, update qualified name and mapping
				if((openResource.rootQualifiedName == null && newQualifiedName != null) ||
						(openResource.rootQualifiedName != null && !openResource.rootQualifiedName.equals(newQualifiedName))) {
					// Remove old name from mapping
					removeQualifiedNameMapping(openResource);

					// Update the qualified name
					openResource.rootQualifiedName = newQualifiedName;

					// Add new name to mapping to the end of the list. Entries on the end of the list are used first by getDocument()
					if(newQualifiedName != null) {
						qualifiedNameToOpenResourcesMap.put(newQualifiedName, openResource);
					}
				}

				// Notify others
				for (final XtextDocumentChangeListener l : externalModelListeners) {
					l.documentChanged(resource.getURI());
				}
			}
		};
	}

	public void addModelListener(final XtextDocumentChangeListener listener) {
		externalModelListeners.add(listener);
	}

	public void removeModelListener(final XtextDocumentChangeListener listener) {
		externalModelListeners.remove(listener);
	}

	private void removeQualifiedNameMapping(final OpenAadlResource openResource) {
		if (openResource.rootQualifiedName != null) {
			qualifiedNameToOpenResourcesMap.remove(openResource.rootQualifiedName, openResource);
		}
	}

	/**
	 * Method for troubleshooting issues with the mappings
	 */
	@SuppressWarnings("unused")
	private void dumpStats() {
		System.out.println("Document to Open Resource Mappings: " + documentToOpenResourceMap.size());
		System.out.println("Qualified Names to Open Resources Mappings: " + qualifiedNameToOpenResourcesMap.size());
		System.out.println("Document to Model Listener Mappings: " + documentToInternalModelListenerMap.size());
	}
}
