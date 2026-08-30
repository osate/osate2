/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY OF FITNESS FOR PURPOSE
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
 * conditions contained in any such separate license file distributed with such Third Party Software. The parties who
 * own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this license with
 * respect to the terms applicable to such Third Party Software. Third Party Software licenses only apply to the Third
 * Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.ide.refactoring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

/**
 * Rewrites embedded EMV2 propagation-point names inside the containing AADL annex token. This avoids asking the AADL
 * partial serializer to serialize an EMV2 object while preserving the ordinary AADL strategy for all other targets.
 */
public class EmbeddedErrorModelRenameStrategy implements IRenameStrategy2 {
	private final IRenameStrategy2 delegate;

	public EmbeddedErrorModelRenameStrategy(IRenameStrategy2 delegate) {
		this.delegate = delegate;
	}

	@Override
	public void applyRename(RenameContext context) {
		var delegatedChanges = new ArrayList<RenameChange>();
		for (RenameChange change : context.getChanges()) {
			EObject target = context.getResourceSet().getEObject(change.getTargetURI(), true);
			if (target instanceof PropagationPoint) {
				context.addModification(change,
						object -> renamePropagationPoint((PropagationPoint) object, change.getNewName(), context));
			} else {
				delegatedChanges.add(change);
			}
		}
		if (!delegatedChanges.isEmpty()) {
			delegate.applyRename(new RenameContext(delegatedChanges, context.getResourceSet(),
					context.getChangeSerializer(), context.getIssues()));
		}
	}

	private static void renamePropagationPoint(PropagationPoint point, String newName, RenameContext context) {
		var annex = EcoreUtil2.getContainerOfType(point, DefaultAnnexSubclause.class);
		var document = context.getChangeSerializer().getModifiableDocument(point.eResource());
		if (annex == null || document == null) {
			context.getIssues().add(Severity.ERROR, "Unable to edit the containing EMV2 annex.", point);
			return;
		}
		var annexRegion = document.getOriginalTextRegionAccess().regionForEObject(annex);
		ISemanticRegion sourceRegion = annexRegion == null ? null
				: annexRegion.getRegionFor().feature(Aadl2Package.eINSTANCE.getDefaultAnnexSubclause_SourceText());
		if (sourceRegion == null) {
			context.getIssues().add(Severity.ERROR, "Unable to locate the containing EMV2 annex text.", point);
			return;
		}

		Set<ErrorPropagation> affectedPropagations = new HashSet<>();
		for (Setting setting : EcoreUtil.UsageCrossReferencer.find(point, point.eResource())) {
			if (setting.getEObject() instanceof FeatureorPPReference reference) {
				var propagation = EcoreUtil2.getContainerOfType(reference, ErrorPropagation.class);
				if (propagation != null) {
					affectedPropagations.add(propagation);
				}
			}
		}

		var affectedTargets = new HashSet<EObject>(affectedPropagations);
		affectedTargets.add(point);
		var affectedRanges = new HashSet<TextRange>();
		var errorModel = EcoreUtil2.getContainerOfType(point, ErrorModelSubclause.class);
		var errorModelNode = NodeModelUtils.findActualNodeFor(errorModel);
		if (errorModelNode != null) {
			for (var leaf : errorModelNode.getLeafNodes()) {
				if (!leaf.isHidden() && point.getName().equalsIgnoreCase(leaf.getText())) {
					var semanticObject = NodeModelUtils.findActualSemanticObjectFor(leaf);
					if (semanticObject == point || referencesAny(semanticObject, affectedTargets)) {
						affectedRanges.add(new TextRange(leaf.getOffset(), leaf.getLength()));
					}
				}
			}
		}

		var annexText = new StringBuilder(sourceRegion.getText());
		affectedRanges.stream()
				.filter(range -> range.offset() >= sourceRegion.getOffset()
						&& range.endOffset() <= sourceRegion.getEndOffset())
				.sorted(Comparator.comparingInt(TextRange::offset).reversed())
				.forEach(range -> {
					int relativeOffset = range.offset() - sourceRegion.getOffset();
					annexText.replace(relativeOffset, relativeOffset + range.length(), newName);
				});
		document.replace(sourceRegion, annexText.toString());
	}

	private static boolean referencesAny(EObject object, Set<EObject> targets) {
		if (object == null) {
			return false;
		}
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (!reference.isContainment() && !reference.isDerived()
					&& reference.getEContainingClass().getEPackage() == ErrorModelPackage.eINSTANCE
					&& object.eIsSet(reference)) {
				Object value = object.eGet(reference, false);
				if (value instanceof EObject && targets.contains(value)) {
					return true;
				}
				if (value instanceof List<?> && ((List<?>) value).stream().anyMatch(targets::contains)) {
					return true;
				}
			}
		}
		return false;
	}

	private record TextRange(int offset, int length) {
		int endOffset() {
			return offset + length;
		}
	}
}
