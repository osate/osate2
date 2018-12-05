package org.osate.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.osate.aadl2.ComponentClassifier;

public final class ClassifierInfoView extends ViewPart implements ISelectionListener {
	/**
	 * The current selection.
	 */
	private ISelection currentSelection;

	private Label label1;

	public ClassifierInfoView() {
		// TODO Auto-generated constructor stub
	}

	// ======================================================================
	// == Creation and clean up of all the UI stuff
	// ======================================================================

	@Override
	public void createPartControl(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		label1 = new Label(sash, SWT.LEFT);
		label1.setText("Hierarchy section");

		final Label label2 = new Label(sash, SWT.LEFT);
		label2.setText("Member section");
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		site.getPage().addPostSelectionListener(this);
		super.init(site);
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this);
		currentSelection = null;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	// ======================================================================
	// == Listeners
	// ======================================================================

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		if (part == null || selection == null | selection.equals(currentSelection)) {
			return;
		}

		currentSelection = selection;

		String classifier = null;
		if (selection.isEmpty()) {
			classifier = "<no selection>";
		} else if (selection instanceof IStructuredSelection) {
			final Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedObject == null) {
				classifier = "<selection is null>";
			} else if (selectedObject instanceof ComponentClassifier) {
				classifier = ((ComponentClassifier) selectedObject).getQualifiedName();
			} else {
				classifier = "<selection is not a component classifier: " + selectedObject.getClass() + ">";
			}
		} else {
			classifier = "<not structured>";
		}
		label1.setText(classifier);
	}

}
