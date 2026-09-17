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
package org.osate.xtext.aadl2.ui.propertyview;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.pluginsupport.PluginSupportUtil;

class PropertySetFilterDialog extends Dialog {
	private static final List<String> PREDECLARED_PATH = List.of("Predeclared_Property_Sets");

	private final DialogContentProvider contentProvider;

	private CheckboxTreeViewer treeViewer;

	private Set<URI> selectedPropertySets;

	PropertySetFilterDialog(Shell parentShell, Map<URI, String> workspacePropertySets, Set<URI> selectedPropertySets) {
		super(parentShell);
		contentProvider = new DialogContentProvider(workspacePropertySets);
		this.selectedPropertySets = selectedPropertySets;
	}

	Set<URI> getSelectedPropertySets() {
		return selectedPropertySets;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Property Set Filters");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		var composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2, false));

		var label = new Label(composite, SWT.NONE);
		label.setText("Property Sets to Show:");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

		treeViewer = createTreeViewer(composite);
		createSelectAllButton(composite, "Select All", true);
		createSelectAllButton(composite, "Deselect All", false);
		return composite;
	}

	private CheckboxTreeViewer createTreeViewer(Composite composite) {
		var viewer = new CheckboxTreeViewer(composite);
		viewer.setContentProvider(contentProvider);
		viewer.setComparator(new ViewerComparator(String.CASE_INSENSITIVE_ORDER) {
			@Override
			public int category(Object element) {
				/* Predeclared and workspace groups come first, followed by other directories and property sets. */
				return switch (element) {
				case ContributedDirectory directory -> directory.path().equals(PREDECLARED_PATH) ? 0 : 2;
				case WorkspacePropertySets workspace -> 1;
				case PropertySetEntry propertySet -> 3;
				case null, default -> throw new AssertionError("Unexpected element: " + element);
				};
			}
		});
		// Inspired by the ICheckStateListener in org.eclipse.ui.internal.views.markers.TypesConfigurationArea
		viewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				viewer.setGrayed(event.getElement(), false);
				setChildrenChecked(event.getElement(), event.getChecked());
				setParentCheckState(event.getElement(), event.getChecked());
			}

			private void setChildrenChecked(Object element, boolean checked) {
				if (contentProvider.hasChildren(element)) {
					for (var child : contentProvider.getChildren(element)) {
						viewer.setChecked(child, checked);
						setChildrenChecked(child, checked);
					}
				}
			}

			private void setParentCheckState(Object element, boolean checked) {
				var parent = contentProvider.getParent(element);
				if (contentProvider.hasChildren(parent)) {
					var children = contentProvider.getChildren(parent);
					if (Arrays.stream(children).anyMatch(child -> viewer.getChecked(child) != checked)) {
						viewer.setGrayChecked(parent, true);
					} else {
						viewer.setGrayed(parent, false);
						viewer.setChecked(parent, checked);
					}
					setParentCheckState(parent, checked);
				}
			}
		});
		if (selectedPropertySets != null) {
			viewer.setCheckStateProvider(new ICheckStateProvider() {
				@Override
				public boolean isChecked(Object element) {
					if (element instanceof PropertySetEntry propertySet) {
						return selectedPropertySets.contains(propertySet.uri());
					}
					return Arrays.stream(contentProvider.getChildren(element)).anyMatch(this::isChecked);
				}

				@Override
				public boolean isGrayed(Object element) {
					var children = contentProvider.getChildren(element);
					if (Arrays.stream(children).anyMatch(this::isGrayed)) {
						return true;
					}
					var checkedChildrenCount = Arrays.stream(children).filter(this::isChecked).count();
					return checkedChildrenCount > 0 && checkedChildrenCount < children.length;
				}
			});
		}
		viewer.setInput(PluginSupportUtil.getContributedPropertySets());
		viewer.expandAll();
		if (selectedPropertySets == null) {
			for (var element : contentProvider.getElements(viewer.getInput())) {
				viewer.setSubtreeChecked(element, true);
			}
		}
		var layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
		layoutData.widthHint = convertWidthInCharsToPixels(45);
		layoutData.heightHint = convertHeightInCharsToPixels(20);
		viewer.getTree().setLayoutData(layoutData);
		return viewer;
	}

	private void createSelectAllButton(Composite composite, String text, boolean checkAll) {
		var button = new Button(composite, SWT.PUSH);
		button.setText(text);
		button.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (var element : contentProvider.getElements(treeViewer.getInput())) {
					treeViewer.setSubtreeChecked(element, checkAll);
				}
				treeViewer.setGrayedElements(new Object[0]);
			}
		});
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		selectedPropertySets = Arrays.stream(treeViewer.getCheckedElements())
				.filter(PropertySetEntry.class::isInstance)
				.map(element -> ((PropertySetEntry) element).uri())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		super.okPressed();
	}

	/**
	 * Is the first list a prefix of the second one?
	 */
	private static boolean isPrefix(List<String> first, List<String> second) {
		return first.size() <= second.size() && second.subList(0, first.size()).equals(first);
	}

	private record ContributedDirectory(Object parent, List<String> path) {
		@Override
		public String toString() {
			return path.equals(PREDECLARED_PATH) ? "Predeclared Property Sets" : path.getLast();
		}
	}

	private record WorkspacePropertySets(Map<URI, String> propertySets) {
		@Override
		public String toString() {
			return "Workspace Property Sets";
		}
	}

	private record PropertySetEntry(Object parent, URI uri, String name) {
		@Override
		public String toString() {
			return name;
		}
	}

	private static class DialogContentProvider implements ITreeContentProvider {
		private final WorkspacePropertySets workspacePropertySets;

		DialogContentProvider(Map<URI, String> workspacePropertySets) {
			this.workspacePropertySets = new WorkspacePropertySets(Map.copyOf(workspacePropertySets));
		}

		@Override
		public Object[] getElements(Object inputElement) {
			@SuppressWarnings("unchecked")
			var propertySets = (Map<URI, String>) inputElement;
			var contributedElements = propertySets.entrySet().stream().<Object> map(entry -> {
				var uri = entry.getKey();
				var firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri);
				if (isPropertySetItself(uri, firstSignificantIndex)) {
					return new PropertySetEntry(inputElement, uri, entry.getValue());
				}
				return new ContributedDirectory(inputElement, List.of(uri.segment(firstSignificantIndex.getAsInt())));
			}).distinct();
			return Stream.concat(contributedElements, Stream.of(workspacePropertySets)).toArray();
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof ContributedDirectory || element instanceof WorkspacePropertySets;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof WorkspacePropertySets workspace) {
				return workspace.propertySets()
						.entrySet()
						.stream()
						.map(entry -> new PropertySetEntry(workspace, entry.getKey(), entry.getValue()))
						.toArray();
			}
			if (!(parentElement instanceof ContributedDirectory directory)) {
				return new Object[0];
			}
			var directoryPath = directory.path();
			return PluginSupportUtil.getContributedPropertySets()
					.entrySet()
					.stream()
					.filter(entry -> isInDirectory(entry.getKey(), directoryPath))
					.<Object> map(entry -> {
						var uri = entry.getKey();
						var nextSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri).getAsInt()
								+ directoryPath.size();
						if (nextSignificantIndex == uri.segmentCount() - 1) {
							return new PropertySetEntry(parentElement, uri, entry.getValue());
						}
						var childPath = Stream
								.concat(directoryPath.stream(), Stream.of(uri.segment(nextSignificantIndex)))
								.toList();
						return new ContributedDirectory(parentElement, childPath);
					})
					.distinct()
					.toArray();
		}

		@Override
		public Object getParent(Object element) {
			return switch (element) {
			case ContributedDirectory directory -> directory.parent();
			case WorkspacePropertySets workspace -> null;
			case PropertySetEntry propertySet -> propertySet.parent();
			case null, default -> throw new AssertionError("Unexpected element: " + element);
			};
		}

		/**
		 * Does the URI name a property set that is shown at the top level, either because it has no significant
		 * directory at all or because its last significant segment is the file itself?
		 */
		private static boolean isPropertySetItself(URI uri, OptionalInt firstSignificantIndex) {
			return firstSignificantIndex.isEmpty() || firstSignificantIndex.getAsInt() == uri.segmentCount() - 1;
		}

		private static boolean isInDirectory(URI uri, List<String> directoryPath) {
			var firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri);
			if (isPropertySetItself(uri, firstSignificantIndex)) {
				return false;
			}
			var uriDirectory = uri.segmentsList().subList(firstSignificantIndex.getAsInt(), uri.segmentCount() - 1);
			return isPrefix(directoryPath, uriDirectory);
		}
	}
}
