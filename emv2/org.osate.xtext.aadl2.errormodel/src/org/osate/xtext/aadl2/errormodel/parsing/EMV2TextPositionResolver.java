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
package org.osate.xtext.aadl2.errormodel.parsing;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.TextPositionInfo;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * @since 8.0
 */
public class EMV2TextPositionResolver implements AnnexTextPositionResolver {
	@Override
	public TextPositionInfo resolveElementAt(EObject annexRoot, int offset) {
		if (!(annexRoot instanceof ErrorModelSubclause) || !(annexRoot.eResource() instanceof XtextResource resource)) {
			return null;
		}
		var helper = resource.getResourceServiceProvider().get(EObjectAtOffsetHelper.class);
		if (helper.resolveCrossReferencedElementAt(resource, offset) instanceof ErrorPropagation propagation) {
			var path = featurePath(propagation);
			var tokens = tokens(helper.getCrossReferenceNode(resource, new TextRegion(offset, 0)));
			if (path.size() == tokens.size()) {
				for (var index = 0; index < path.size(); index++) {
					var token = tokens.get(index);
					if (path.get(index) instanceof Feature feature && offset >= token.getOffset()
							&& offset < token.getEndOffset()) {
						return new TextPositionInfo(feature, token.getOffset(), token.getLength());
					}
				}
			}
		}
		return null;
	}

	@Override
	public TextPositionInfo resolveCrossReferencedElementAt(EObject annexRoot, int offset) {
		return null;
	}

	@Override
	public void collectRelatedReferenceTargets(EObject annexRoot, Predicate<EObject> isTarget,
			Consumer<EObject> acceptor, IProgressMonitor monitor) {
		if (!(annexRoot instanceof ErrorModelSubclause)) {
			return;
		}
		var propagations = new LinkedHashSet<ErrorPropagation>();
		var contents = EcoreUtil.<EObject>getAllContents(List.of(annexRoot));
		while (contents.hasNext()) {
			checkCanceled(monitor);
			var source = contents.next();
			if (source instanceof ErrorPropagation propagation) {
				propagations.add(propagation);
			}
			for (var reference : source.eClass().getEAllReferences()) {
				if (!reference.isContainment() && !reference.isContainer() && !reference.isDerived()
						&& reference.getEReferenceType().isSuperTypeOf(ErrorModelPackage.Literals.ERROR_PROPAGATION)
						&& source.eIsSet(reference)) {
					var value = source.eGet(reference);
					if (value instanceof ErrorPropagation propagation) {
						propagations.add(propagation);
					} else if (value instanceof List<?> values) {
						for (var element : values) {
							if (element instanceof ErrorPropagation propagation) {
								propagations.add(propagation);
							}
						}
					}
				}
			}
		}
		for (var propagation : propagations) {
			checkCanceled(monitor);
			if (!propagation.eIsProxy() && featurePath(propagation).stream()
					.anyMatch(feature -> feature instanceof Feature && isTarget.test(feature))) {
				acceptor.accept(propagation);
			}
		}
	}

	@Override
	public TextPositionInfo getReferencePosition(EObject source, EReference reference, int index, EObject target) {
		if (!(target instanceof Feature) || reference == null || reference.isDerived()) {
			return null;
		}
		var value = source.eGet(reference);
		if (reference.isMany()) {
			var values = (List<?>) value;
			value = index >= 0 && index < values.size() ? values.get(index) : null;
		}
		if (value instanceof ErrorPropagation propagation && !propagation.eIsProxy()) {
			var nodes = NodeModelUtils.findNodesForFeature(source, reference);
			var nodeIndex = reference.isMany() ? index : 0;
			if (nodeIndex >= 0 && nodeIndex < nodes.size()) {
				var path = featurePath(propagation);
				var tokens = tokens(nodes.get(nodeIndex));
				if (path.size() == tokens.size()) {
					for (var segment = 0; segment < path.size(); segment++) {
						if (path.get(segment) == target) {
							var token = tokens.get(segment);
							return new TextPositionInfo(target, token.getOffset(), token.getLength());
						}
					}
				}
			}
		}
		return null;
	}

	private static List<NamedElement> featurePath(ErrorPropagation propagation) {
		var result = new ArrayList<NamedElement>();
		for (var segment = propagation.getFeatureorPPRef(); segment != null; segment = segment.getNext()) {
			var feature = segment.getFeatureorPP();
			if (feature == null || feature.eIsProxy()) {
				return List.of();
			}
			result.add(feature);
		}
		return result;
	}

	private static List<ILeafNode> tokens(INode node) {
		var result = new ArrayList<ILeafNode>();
		if (node != null) {
			for (var leaf : node.getLeafNodes()) {
				if (!leaf.isHidden() && !".".equals(leaf.getText())) {
					result.add(leaf);
				}
			}
		}
		return result;
	}

	private static void checkCanceled(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}
}
