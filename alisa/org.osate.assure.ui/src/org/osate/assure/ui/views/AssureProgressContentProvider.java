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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.categories.categories.CategoryFilter;

public class AssureProgressContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = new Object[] {};

	// Use filter to show subset of verification results
	private CategoryFilter filter;

	public AssureProgressContentProvider(CategoryFilter filter) {
		this.filter = filter;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		@SuppressWarnings("rawtypes")
		AssuranceCaseResult roots = (AssuranceCaseResult) inputElement;
		ArrayList<VerificationResult> elemList = new ArrayList<VerificationResult>();

		for (Iterator iterator = roots.eAllContents(); iterator.hasNext();) {
			EObject verificationResult = (EObject) iterator.next();
			if (verificationResult instanceof VerificationResult) {
				elemList.add((VerificationResult) verificationResult);
			}
		}
		return elemList.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return EMPTY;
//		if (parentElement instanceof EObject) {
//			EObject node = (EObject) parentElement;
//			return node.eContents().toArray();
//		} else {
//			throw new IllegalArgumentException();
//		}
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
//		if (element instanceof EObject) {
//			EObject node = (EObject) element;
//			return !node.eContents().isEmpty();
//		} else {
//			throw new IllegalArgumentException();
//		}
	}
}
