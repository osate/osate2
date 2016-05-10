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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osate.alisa.workbench.alisa.AssuranceCase;

public class AlisaTreeContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = new Object[] {};

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
//		System.out.println("AlisaTreeContentProvider.getElements() " + inputElement.getClass() + "         size: "
//				+ ((ArrayList<AssuranceCase>) inputElement).size());
		return ((ArrayList<AssuranceCase>) inputElement).toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
//		return EMPTY;
		if (parentElement instanceof AssuranceCase) {
			AssuranceCase node = (AssuranceCase) parentElement;
			return node.getAssurancePlans().toArray();
		} else {
			return EMPTY;
			// throw new IllegalArgumentException();
		}
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
//		return false;
		if (element instanceof AssuranceCase) {
			AssuranceCase node = (AssuranceCase) element;
			return !node.getAssurancePlans().isEmpty();
		} else {
			return false;
		}
	}
}
