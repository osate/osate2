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
package org.osate.xtext.aadl2.ui.editor.occurrences;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMapWithExpectedSize;
import static java.util.Collections.emptyMap;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.occurrences.DefaultOccurrenceComputer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.xtext.aadl2.util.Aadl2LocationInFile;

import com.google.inject.Inject;
import com.google.inject.Provider;

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

	@Inject
	private Provider<TargetURIs> targetURIsProvider;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	private static class EObjectReferenceAndIndex {
		EObject source;
		EReference reference;
		int idx;
	}

	@Override
	public Map<Annotation, Position> createAnnotationMap(XtextEditor editor, final ITextSelection selection,
			final SubMonitor monitor) {
		final IXtextDocument document = editor.getDocument();
		if (document != null) {
			return document.tryReadOnly(new CancelableUnitOfWork<Map<Annotation, Position>, XtextResource>() {

				@Override
				public Map<Annotation, Position> exec(XtextResource resource, final CancelIndicator cancelIndicator)
						throws Exception {
					EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, selection.getOffset());
					if (target != null && !target.eIsProxy()) {
						final List<EObjectReferenceAndIndex> references = newArrayList();
						IReferenceFinder.Acceptor acceptor = new IReferenceFinder.Acceptor() {
							@Override
							public void accept(IReferenceDescription reference) {
								throw new UnsupportedOperationException("Local references are announced per object");
							}

							@Override
							public void accept(EObject source, URI sourceURI, EReference eReference, int index,
									EObject targetOrProxy, URI targetURI) {
								EObjectReferenceAndIndex acceptMe = new EObjectReferenceAndIndex();
								acceptMe.source = source;
								acceptMe.reference = eReference;
								acceptMe.idx = index;
								references.add(acceptMe);
							}
						};
						Iterable<URI> targetURIs = getTargetURIs(target);
						if (!(targetURIs instanceof TargetURIs)) {
							TargetURIs result = targetURIsProvider.get();
							result.addAllURIs(targetURIs);
							targetURIs = result;
						}
						IProgressMonitor localMonitor = new NullProgressMonitor() {
							@Override
							public boolean isCanceled() {
								return monitor.isCanceled() || cancelIndicator.isCanceled();
							}
						};
						referenceFinder.findReferences((TargetURIs) targetURIs, resource, acceptor, localMonitor);
						operationCanceledManager.checkCanceled(cancelIndicator);
						Map<Annotation, Position> result = newHashMapWithExpectedSize(references.size() + 1);
						if (target.eResource() == resource) {
							if (!references.isEmpty() || canBeReferencedLocally(target)) {
								ITextRegion declarationRegion = locationInFileProvider.getSignificantTextRegion(target);
								addOccurrenceAnnotation(DECLARATION_ANNOTATION_TYPE, document, declarationRegion,
										result);
								declarationRegion = ((Aadl2LocationInFile) locationInFileProvider)
										.getSecondaryTextRegion(target, !(target instanceof ComponentImplementation));
								if (declarationRegion != null) {
									addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document, declarationRegion,
											result);
									if (target instanceof ComponentType) {
										ModelUnit pkg = EcoreUtil2.getContainerOfType(target, ModelUnit.class);
										for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg,
												ComponentImplementation.class)) {
											if (impl.getType() == target) {
												declarationRegion = ((Aadl2LocationInFile) locationInFileProvider)
														.getSecondaryTextRegion(impl, true);
												if (declarationRegion != null) {
													addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document,
															declarationRegion, result);
												}
											}
										}
									}
								}
							}
						}
						for (EObjectReferenceAndIndex highlightMe : references) {
							try {
								if (localMonitor.isCanceled()) {
									return emptyMap();
								}
								ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(
										highlightMe.source, highlightMe.reference, highlightMe.idx);
								if (target instanceof ComponentImplementation) {
									ComponentImplementation impl = (ComponentImplementation) target;
									textRegion = getAdjustedRegion(document, textRegion, impl.getImplementationName(),
											textRegion);
								} else if (target instanceof ComponentType || target instanceof Property
										|| target instanceof PropertyType || target instanceof PropertyConstant) {
									NamedElement named = (NamedElement) target;
									textRegion = getAdjustedRegion(document, textRegion, named.getName(), textRegion);
								} else if (target instanceof ModelUnit) {
									NamedElement named = (NamedElement) target;
									textRegion = getAdjustedRegion(document, textRegion, named.getName(), null);
								}
								if (textRegion != null) {
									addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document, textRegion, result);
								}
							} catch (Exception exc) {
								// outdated index information. Ignore
							}
						}
						return result;
					}
					return emptyMap();
				}
			}, () -> emptyMap());
		} else {
			return emptyMap();
		}
	}

	protected ITextRegion getAdjustedRegion(IXtextDocument document, ITextRegion original, String name,
			ITextRegion notFound)
			throws BadLocationException {
		String text = document.get(original.getOffset(), original.getLength());
		int offset = text.indexOf(name);
		return (offset < 0) ? notFound : new TextRegion(original.getOffset() + offset, name.length());
	}

}
