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
package org.osate.ui.search;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkingSet;
import org.osate.search.AadlFinder;
import org.osate.search.AadlFinder.Scope;
import org.osate.search.AadlSearchQuery;
import org.osate.search.AadlSearchQuery.LimitTo;
import org.osate.search.AadlSearchQuery.SearchFor;

public final class AadlSearchPage extends DialogPage implements ISearchPage {
	private static enum ScopeSelection {
		WORKSPACE, SELECTED, OPEN_EDITORS;
	}

	private ISearchPageContainer searchPageContainer;
	private Text substringText;

	private SearchFor searchFor;
	private LimitTo limitTo;
	private ScopeSelection scope;

	public AadlSearchPage() {
		super();
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NULL);
		root.setLayout(new GridLayout(3, true));

		final Group searchTextGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		searchTextGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		searchTextGroup.setText("Identifier Substring  (AADL Identifiers are Case Insensitive)");

		searchTextGroup.setLayout(new GridLayout(1, true));
		substringText = new Text(searchTextGroup, SWT.BORDER);
		substringText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final Group searchForGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		searchForGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		searchForGroup.setText("Search For");

		searchForGroup.setLayout(new RowLayout(SWT.VERTICAL));
		createRadioButton(searchForGroup, "Classifier", true, this::setSearchFor, SearchFor.CLASSIFIER);
		createRadioButton(searchForGroup, "Property", false, this::setSearchFor, SearchFor.PROPERTY);

		final Group limitToGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		limitToGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		limitToGroup.setText("Limit To");

		limitToGroup.setLayout(new RowLayout(SWT.VERTICAL));
		createRadioButton(limitToGroup, "All occurances", false, this::setLimitTo, LimitTo.ALL);
		createRadioButton(limitToGroup, "References", true, this::setLimitTo, LimitTo.REFERENCES);
		createRadioButton(limitToGroup, "Declarations", false, this::setLimitTo, LimitTo.DECLARATIONS);

		final Group scopeGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		scopeGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		scopeGroup.setText("Scope");

		scopeGroup.setLayout(new RowLayout(SWT.VERTICAL));
		final ISelection selection = searchPageContainer.getSelection();
		final boolean hasSelection = selection instanceof IStructuredSelection && !selection.isEmpty();
		createRadioButton(scopeGroup, "Workspace", !hasSelection, this::setScope, ScopeSelection.WORKSPACE);
		final Button selectedButton = createRadioButton(scopeGroup, hasSelection ? "Selected" : "No Selection",
				hasSelection, this::setScope,
				ScopeSelection.SELECTED);
		selectedButton.setEnabled(hasSelection);
		final IEditorInput input = searchPageContainer.getActiveEditorInput();
		final Button editorButton = createRadioButton(scopeGroup,
				input == null ? "No Open Editor" : "Front Editor: " + input.getName(), false,
				this::setScope, ScopeSelection.OPEN_EDITORS);
		editorButton.setEnabled(input != null);
		setControl(root);
	}

	private <T> Button createRadioButton(final Group group, final String label, final boolean selected,
			final Consumer<T> setter,
			final T value) {
		final Button radio = new Button(group, SWT.RADIO);
		radio.setText(label);

		radio.setSelection(selected);
		if (selected) {
			setter.accept(value);
		}

		radio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				setter.accept(value);
			}
		});

		return radio;
	}

	private void setSearchFor(final SearchFor v) {
		searchFor = v;
	}

	private void setLimitTo(final LimitTo v) {
		limitTo = v;
	}

	private void setScope(final ScopeSelection s) {
		scope = s;
	}

	private Scope getScope() {
		if (scope == ScopeSelection.WORKSPACE) {
			return AadlFinder.WORKSPACE_SCOPE;
		} else if (scope == ScopeSelection.SELECTED) {
			return getSelectedResourcesScope();
		} else if (scope == ScopeSelection.OPEN_EDITORS) {
			return getOpenEditorsScope();
		} else {
			// Shouldn't get here
			return AadlFinder.EMPTY_SCOPE;
		}
	}

	/*
	 * This is based on org.eclipse.search.internal.ui.text.TestSearchPage.getSelectedResourcesScope(). It probably
	 * does more than is truly needed here.
	 */
	private Scope getSelectedResourcesScope() {
		final Set<IResource> resources = new HashSet<>();
		final ISelection selection = searchPageContainer.getSelection();
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			for (final Object selectedItem : ((IStructuredSelection) selection).toList()) {
				if (selectedItem instanceof IWorkingSet) {
					// XXX Come back to this
				} else if (selectedItem instanceof IAdaptable) {
					final IResource resource = ((IAdaptable) selectedItem).getAdapter(IResource.class);
					if (resource != null && resource.isAccessible()) {
						resources.add(resource);
					}
				}
			}
		}
		return new AadlFinder.ResourceSetScope(resources);
	}

	/*
	 * This is based on org.eclipse.search.internal.ui.text.TestSearchPage.getSelectedResourcesScope(). It probably
	 * does more than is truly needed here.
	 */
	private Scope getOpenEditorsScope() {
		final Set<IResource> resources = new HashSet<>();
		resources.add(searchPageContainer.getActiveEditorInput().getAdapter(IFile.class));
		return new AadlFinder.ResourceSetScope(resources);

	}

	@Override
	public boolean performAction() {
		final AadlSearchQuery query = new AadlSearchQuery(substringText.getText(), searchFor, limitTo,
				getScope());
		NewSearchUI.runQueryInBackground(query);

		return true;
	}

	@Override
	public void setContainer(final ISearchPageContainer container) {
		searchPageContainer = container;
	}
}
