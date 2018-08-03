/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.TargetURIConverter;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class CommonReferenceHelper {

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private TargetURIConverter targetURIConverter;

	@Inject
	private IResourceDescriptions indexData;

	/**
	 * Find cross-references from other resources to a set of objects given by their URIs
	 */
	public Iterable<URI> getReferences(Iterable<URI> targets) {
		CommonReferenceHelper.ReferenceDescriptionAcceptor rda = new ReferenceDescriptionAcceptor();

		referenceFinder.findAllReferences(targetURIConverter.fromIterable(targets), null, indexData, rda, null);
		return rda.getURIs();
	}

	public Iterable<URI> getReferences(Iterable<URI> targets, String fileExt) {
		CommonReferenceHelper.ReferenceDescriptionAcceptor rda = new ReferenceDescriptionAcceptor();
		Set<URI> candidates = new HashSet<>();
		for (IResourceDescription rd : indexData.getAllResourceDescriptions()) {
			URI uri = rd.getURI();
			String ext = uri.fileExtension();
			if (ext != null && ext.equals(fileExt)) {
				candidates.add(uri);
			}
		}
		referenceFinder.findReferences(targetURIConverter.fromIterable(targets), candidates, null, indexData, rda,
				null);
		return rda.getURIs();
	}

	public <C extends EObject, T extends EObject> Iterable<T> getReferences(C target, Class<T> clazz) {
		ResourceSet resourceSet = target.eResource().getResourceSet();
		Iterable<URI> uris = Collections.singleton(EcoreUtil.getURI(target));
		Iterable<URI> refs = getReferences(uris);
		return convert(resourceSet, refs, clazz);
	}

	public <C extends EObject, T extends EObject> Iterable<T> getReferences(C target, String fileExt, Class<T> clazz) {
		ResourceSet resourceSet = target.eResource().getResourceSet();
		Iterable<URI> uris = Collections.singleton(EcoreUtil.getURI(target));
		Iterable<URI> refs = getReferences(uris, fileExt);
		return convert(resourceSet, refs, clazz);
	}

	public <C extends EObject, T extends EObject> Iterable<T> getReferences(Iterable<C> targets, Class<T> clazz) {
		Iterator<C> iter = targets.iterator();
		if (!iter.hasNext()) {
			return new ArrayList<>();
		}
		ResourceSet resourceSet = iter.next().eResource().getResourceSet();
		Stream<URI> uris = StreamSupport.stream(targets.spliterator(), false).map(target -> EcoreUtil.getURI(target));
		Iterable<URI> refs = getReferences(uris::iterator);
		return convert(resourceSet, refs, clazz);
	}

	public <C extends EObject, T extends EObject> Iterable<T> getReferences(Iterable<C> targets, String fileExt,
			Class<T> clazz) {
		Iterator<C> iter = targets.iterator();
		if (!iter.hasNext()) {
			return new ArrayList<>();
		}
		ResourceSet resourceSet = iter.next().eResource().getResourceSet();
		Stream<URI> uris = StreamSupport.stream(targets.spliterator(), false).map(target -> EcoreUtil.getURI(target));
		Iterable<URI> refs = getReferences(uris::iterator, fileExt);
		return convert(resourceSet, refs, clazz);
	}

	private <T extends EObject> Iterable<T> convert(ResourceSet resourceSet, Iterable<URI> uris, Class<T> clazz) {
		Stream<EObject> eobjs = StreamSupport.stream(uris.spliterator(), false)
				.map(uri -> resourceSet.getEObject(uri, true));
		@SuppressWarnings("unchecked")
		Stream<T> srss = (Stream<T>) eobjs.filter(it -> clazz.isAssignableFrom(it.getClass()));
		return srss.collect(Collectors.toList());
	}

	public static class ReferenceDescriptionAcceptor implements IReferenceFinder.Acceptor {

		protected ArrayList<URI> result = new ArrayList<URI>();

		@Override
		public void accept(IReferenceDescription referenceDescription) {
			if (referenceDescription.getSourceEObjectUri() != null) {
				result.add(referenceDescription.getSourceEObjectUri());
			}
		}

		@Override
		public void accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy,
				URI targetURI) {
			accept(new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, null));
		}

		public Iterable<URI> getURIs() {
			return result;
		}

	}
}
