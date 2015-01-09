package org.osate.alisa.common.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.FailResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;

public class AlisaResultContentProvider implements ITreeContentProvider {
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
		if (parentElement instanceof ResoluteResult) {
			ResoluteResult node = (ResoluteResult) parentElement;
			return flatten(node.getChildren()).toArray();
		} else {
			throw new IllegalArgumentException();
		}
	}

	private List<ResoluteResult> flatten(List<ResoluteResult> children) {
		List<ResoluteResult> results = new ArrayList<ResoluteResult>();
		for (ResoluteResult child : children) {
			if (child instanceof ClaimResult || child instanceof FailResult) {
				results.add(child);
			} else {
				results.addAll(flatten(child.getChildren()));
			}
		}
		return results;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ResoluteResult) {
			ResoluteResult node = (ResoluteResult) element;
			return !flatten(node.getChildren()).isEmpty();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
