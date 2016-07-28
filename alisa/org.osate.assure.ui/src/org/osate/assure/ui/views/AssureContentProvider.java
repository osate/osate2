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

package org.osate.assure.ui.views;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.categories.categories.CategoryFilter;
import org.osate.verify.util.VerifyUtilExtension;

public class AssureContentProvider implements ITreeContentProvider {

	private CategoryFilter filter;
	private static final Object[] EMPTY = new Object[] {};

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		@SuppressWarnings("rawtypes")
		List roots = (List) inputElement;
		return roots.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
//		if (parentElement instanceof EObject) {
//			EObject node = (EObject) parentElement;
//			return node.eContents().toArray();
//		} else {
//			throw new IllegalArgumentException();
//		}

		// This is how we are applying filter in AssureProcessor
		if (parentElement instanceof ClaimResult) {
			ClaimResult claimResult = (ClaimResult) parentElement;
			if (VerifyUtilExtension.evaluateRequirementFilter(
					claimResult.getTargetReference().getRequirement().getRequirement(), filter)) {
				return claimResult.eContents().toArray();
			} else {
				return EMPTY;
			}

		} else if (parentElement instanceof VerificationActivityResult) {
			VerificationActivityResult vaResult = (VerificationActivityResult) parentElement;
			if (VerifyUtilExtension
					.evaluateVerificationActivityFilter(vaResult.getTargetReference().getVerificationActivity(), filter)
					&& VerifyUtilExtension.evaluateVerificationMethodFilter(
							vaResult.getTargetReference().getVerificationActivity(), filter)) {
				return vaResult.eContents().toArray();
			} else {
				return EMPTY;
			}
		} else if (parentElement instanceof EObject) {
			EObject node = (EObject) parentElement;
			return node.eContents().toArray();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof EObject) {
			EObject node = (EObject) element;
			return !node.eContents().isEmpty();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public CategoryFilter getFilter() {
		return filter;
	}

	public void setFilter(CategoryFilter filter) {
		this.filter = filter;
	}
}
