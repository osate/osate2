/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.xtext.aadl2.ui.editor.occurrences;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMapWithExpectedSize;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singleton;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.occurrences.DefaultOccurrenceComputer;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.ComponentImplementation;
import org.osate.xtext.aadl2.util.Aadl2LocationInFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Aadl2OccurrenceComputer extends DefaultOccurrenceComputer {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	@Override
	public Map<Annotation, Position> createAnnotationMap(XtextEditor editor, final ITextSelection selection,
			final SubMonitor monitor) {
		final IXtextDocument document = editor.getDocument();
		if (document != null) {
			return document.readOnly(new IUnitOfWork<Map<Annotation, Position>, XtextResource>() {
				@Override
				public Map<Annotation, Position> exec(final XtextResource resource) throws Exception {
					if (resource != null) {
						EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, (selection).getOffset());
						if (target != null && !target.eIsProxy()) {
							monitor.setWorkRemaining(100);
							final List<IReferenceDescription> references = newArrayList();
							IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
								@Override
								public void accept(IReferenceDescription reference) {
									references.add(reference);
								}
							};
							SimpleLocalResourceAccess localResourceAccess = new SimpleLocalResourceAccess(
									resource.getResourceSet());
							referenceFinder.findReferences(getTargetURIs(target), singleton(resource.getURI()),
									localResourceAccess, acceptor, monitor.newChild(40));
							if (monitor.isCanceled()) {
								return emptyMap();
							}
							Map<Annotation, Position> result = newHashMapWithExpectedSize(references.size() + 1);
							if (target.eResource() == resource) {
								if (!references.isEmpty() || canBeReferencedLocally(target)) {
									ITextRegion declarationRegion = locationInFileProvider
											.getSignificantTextRegion(target);
									addOccurrenceAnnotation(DECLARATION_ANNOTATION_TYPE, document, declarationRegion,
											result);
									declarationRegion = ((Aadl2LocationInFile) locationInFileProvider)
											.getSecondaryTextRegion(target,
													!(target instanceof ComponentImplementation));
									if (declarationRegion != null) {
										addOccurrenceAnnotation(DECLARATION_ANNOTATION_TYPE, document,
												declarationRegion, result);
									}
								}
							}
							monitor.worked(5);
							for (IReferenceDescription reference : references) {
								try {
									EObject source = resource.getEObject(reference.getSourceEObjectUri().fragment());
									if (source != null && reference.getEReference() != null) { // prevent exception for outdated data
										ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(source,
												reference.getEReference(), reference.getIndexInList());
										addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document, textRegion,
												result);
									}
								} catch (Exception exc) {
									// outdated index information. Ignore
								}
							}
							monitor.worked(15);
							return result;
						}
					}
					return emptyMap();
				}
			});
		} else {
			return emptyMap();
		}
	}

}
