package org.osate.assure.ui.views;

	import java.util.ArrayList;
	import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
	import org.eclipse.jface.viewers.Viewer;


	public class AssureContentProvider implements ITreeContentProvider {
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
			if (parentElement instanceof EObject) {
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
	}
