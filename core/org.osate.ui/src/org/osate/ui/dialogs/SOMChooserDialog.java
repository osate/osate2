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
package org.osate.ui.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.provider.InstanceItemProviderAdapterFactory;
import org.osate.aadl2.provider.Aadl2ItemProviderAdapterFactory;
import org.osate.ui.OsateUiPlugin;

/**
 * This dialog is used to allow the user to create a <code>SystemOperationMode</code> from a <code>SystemInstance</code>.
 * The SOM is created by the user selecting a mode for each modal component.  The user must also enter a name for the SOM.
 * This is done so that a SOM can have an easily identifiable name such as "Departure" instead of
 * "Spec1_System1_impl_Instance.Mode1,Spec1_System1_impl_Instance.Subcomponent1.Mode2".  The name and SOM object can be
 * retrieved through <code>getSOMName()</code> and <code>getSOM()</code> only after <code>open()</code> has returned
 * <code>Window.OK</code>.  The name is not stored in the <code>SystemOperationMode</code>.  The expression
 * <code>getSOM().getName().equals(getSOM().toString())</code> is <code>true</code>.
 *
 * @author jseibel
 *
 */
public class SOMChooserDialog extends Dialog {
	private static final String MODE_SET_ICON = "icons/mode_set.gif";
	private static final String MODE_NOT_SET_ICON = "icons/mode_not_set.gif";
	private static final String NONEXISTENT_ICON = "icons/nonexistent.gif";
	private static final String COLUMN_COMPONENT_INSTANCE = "Component Instance";
	private static final String COLUMN_MODE_INSTANCE = "Mode Instance";
	private static final int NAME_INPUT_WIDTH = 300;
	private static final int VIEWER_WIDTH = 800;
	private static final int VIEWER_HEIGHT = 300;
	private static final ComposedAdapterFactory adapterFactory;
	private static final AdapterFactoryLabelProvider baseLabelProvider;

	private Composite composite = null;
	private TreeViewer viewer = null;
	private Text nameInput = null;

	private final SystemInstance systemInstance;
	// Map from each ComponentInstance in systemInstance to a mode of that ComponentInstance, or null if the mode has not been set by the user.
	private final HashMap<ComponentInstance, ModeInstance> selectedModes;
	// Created only after the user clicks OK.
	private SystemOperationMode newSOM = null;
	private String newSOMName = null;

	private final boolean requireName;

	/**
	 * Creates a new dialog that allows the user to compile a <code>SystemOperationMode</code>.  Call
	 * {@link #openThreadSafe()} after construction to display the dialog.
	 *
	 * @param parentShell The parent shell, or <code>null</code> to create a top-level shell.
	 * @param systemInstance The system to base the <code>SystemOperationMode</code> off of.
	 * @param requireName If <code>true</code>, the user must enter an alias for the selected system
	 * operation mode; if <code>false</code>, no name is necessary.
	 * @throws IllegalArgumentException Thrown if <code>systemInstance</code> is not modal.
	 */
	public SOMChooserDialog(final Shell parentShell, final SystemInstance systemInstance, final boolean requireName)
			throws IllegalArgumentException {
		super(parentShell);
		this.requireName = requireName;
		int flags = getShellStyle();
		flags |= SWT.RESIZE;
		setShellStyle(flags);
		if (systemInstance.getSystemOperationModes().size() == 1
				&& systemInstance.getSystemOperationModes().get(0).getName().equals("No Modes")) {
			throw new IllegalArgumentException("Cannot create a SOMChooserDialog for the SystemInstance "
					+ systemInstance.getName() + " because it does not contain multiple SystemOperationModes.");
		}
		this.systemInstance = systemInstance;
		selectedModes = new HashMap<ComponentInstance, ModeInstance>();
		for (final ComponentInstance component : systemInstance.getAllComponentInstances()) {
			if (component.getModeInstances().size() >= 1) {
				selectedModes.put(component, null);
			}
		}
	}

	/**
	 * Creates a new dialog that allows the user to compile a <code>SystemOperationMode</code>
	 * that requires the user to enter a name for the mode.  Call
	 * {@link #openThreadSafe()} after construction to display the dialog.
	 *
	 * @param parentShell The parent shell, or <code>null</code> to create a top-level shell.
	 * @param systemInstance The system to base the <code>SystemOperationMode</code> off of.
	 * @throws IllegalArgumentException Thrown if <code>systemInstance</code> is not modal.
	 */
	public SOMChooserDialog(final Shell parentShell, final SystemInstance systemInstance)
			throws IllegalArgumentException {
		this(parentShell, systemInstance, true);
	}

	/**
	 * Open the dialog.  Forces the open call to occur in the SWT thread.
	 * Otherwise, it is indentical to {@link #open()}.
	 */
	public int openThreadSafe() {
		abstract class IntAnswer implements Runnable {
			/*
			 * Needs to be volatile because it will be set in the SWT thread
			 * and read from the Eclipse builder thread.
			 */
			public volatile int answer = -1;
		}

		final IntAnswer obj = new IntAnswer() {
			@Override
			public void run() {
				answer = SOMChooserDialog.this.open();
			}
		};
		Display.getDefault().syncExec(obj);
		return obj.answer;
	}

	/**
	 * Creates a new dialog that allows the user to compile a <code>SystemOperationMode</code>.  The modes for each component are preset
	 * based on <code>SOMPathText</code>.  Use this constructor to modify a <code>SystemOperationMode</code>.  Call <code>open()</code>
	 * after construction to display the dialog.
	 *
	 * @param parentShell The parent shell, or <code>null</code> to create a top-level shell.
	 * @param systemInstance The system to base the <code>SystemOperationMode</code> off of.
	 * @param SOMName The name of the <code>SystemOperationMode</code> to modify.  The name field will be preset with this value.
	 * @param SOMPathText The String representation of the <code>SystemOperationMode</code> to modify.  This can be retrieved by calling
	 * 			<code>SystemOperationMode.toString()</code> or <code>SystemOperationMode.getName()</code>.
	 * @throws IllegalArgumentException Thrown if <code>systemInstance</code> is not modal or if <code>SOMPathText</code> contains segments
	 * 			that do not describe a <code>ModeInstance</code>.
	 */
	public SOMChooserDialog(final Shell parentShell, final SystemInstance systemInstance, final String SOMName,
			final String SOMPathText) throws IllegalArgumentException {
		this(parentShell, systemInstance);
		newSOMName = SOMName;
		final String[] individualModePaths = SOMPathText.split(",");
		for (int pathIndex = 0; pathIndex < individualModePaths.length; pathIndex++) {
			final String[] modePathElements = individualModePaths[pathIndex].split("\\x2e");
			if (modePathElements.length < 2) {
				throw new IllegalArgumentException(
						individualModePaths[pathIndex] + " is not a valid ModeInstance path.");
			}
			ComponentInstance parentComponent = systemInstance;
			for (int elementIndex = 1; parentComponent != null
					&& elementIndex < modePathElements.length - 1; elementIndex++) {
				final ComponentInstance childComponent = findComponentInstance(parentComponent,
						modePathElements[elementIndex]);
				if (childComponent == null || !componentExistsInCurrentMode(childComponent)) {
					parentComponent = null;
				} else {
					parentComponent = childComponent;
				}
			}
			final ComponentInstance currentComponent = parentComponent;
			if (currentComponent != null && selectedModes.containsKey(currentComponent)) {
				final ModeInstance currentMode = findModeInstance(currentComponent,
						modePathElements[modePathElements.length - 1]);
				if (currentMode != null) {
					selectedModes.put(currentComponent, currentMode);
				}
			}
		}
	}

	/**
	 * Returns the <code>SystemOperationMode</code> that was generated by the dialog when the user clicked ok.
	 *
	 * @return A <code>SystemOperationMode</code> that applies to the <code>SystemInstance</code> that was passed to the constructor.
	 * @throws IllegalStateException Thrown if this method was called and <code>open()</code> has not returned <code>Window.OK</code>.
	 */
	public SystemOperationMode getSOM() throws IllegalStateException {
		if (newSOM == null) {
			throw new IllegalStateException(
					"Method called out of order.  Only call getSOM() when open() has returned Dialog.OK");
		} else {
			return newSOM;
		}
	}

	/**
	 * Returns the name that the user assigned to the <code>SystemOperationMode</code>.
	 *
	 * @return A human-readable identifier of a <code>SystemOperationMode</code>.
	 * @throws IllegalStateException Thrown if this method was called and <code>open()</code> has not returned <code>Window.OK</code>.
	 */
	public String getSOMName() throws IllegalStateException {
		if (newSOM == null) {
			throw new IllegalStateException(
					"Method called out of order.  Only call getSOMName() when open() has returned Dialog.OK");
		} else {
			return newSOMName;
		}
	}

	/**
	 * Called by org.eclipse.jface.dialogs.Dialog
	 * Do not call this method directly.
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setText("Create a System Operation Mode");

		Label message = new Label(composite, SWT.NONE);
		message.setText(
				"Enter a &name for the new SOM.  A name can consist of letters (A-Z, a-z), numbers(0-9), the dash (-),"
						+ " or the underscore character(_):");
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, false, false);
		message.setLayoutData(layoutData);

		nameInput = new Text(composite, SWT.BORDER | SWT.SINGLE);
		if (newSOMName != null) {
			nameInput.setText(newSOMName);
		}
		layoutData = new GridData(SWT.LEFT, SWT.FILL, false, false);
		layoutData.widthHint = NAME_INPUT_WIDTH;
		nameInput.setLayoutData(layoutData);
		nameInput.setEnabled(requireName);

		message = new Label(composite, SWT.NONE);
		layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		layoutData.heightHint = 20;
		message.setLayoutData(layoutData);

		message = new Label(composite, SWT.NONE);
		message.setText("Select a &mode for each component:");
		layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		message.setLayoutData(layoutData);

		viewer = new TreeViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		configureViewer();
		layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.widthHint = VIEWER_WIDTH;
		layoutData.heightHint = VIEWER_HEIGHT;
		viewer.getControl().setLayoutData(layoutData);

		addListeners();

		return composite;
	}

	/**
	 * Called by org.eclipse.jface.dialogs.Dialog
	 * Do not call this method directly.
	 */
	@Override
	protected void okPressed() {
		generateSOM();
		newSOMName = nameInput.getText();
		super.okPressed();
	}

	/**
	 * Called by org.eclipse.jface.dialogs.Dialog
	 * Do not call this method directly.
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		updateOkEnabled();
	}

	private void generateSOM() {
		/*
		 * 12 February 2007 -- Rewrote this so that it always a returns
		 * one of the system operation mode objects that is already being
		 * used by the system instance model. This makes traversals work
		 * much better -- aarong
		 */
		final List<ModeInstance> modeInstances = new ArrayList<ModeInstance>(selectedModes.values());
		final List<SystemOperationMode> soms = systemInstance.getSystemOperationModesFor(modeInstances);
		if (soms.size() != 1) {
			throw new IllegalStateException("Couldn't find exact system operation mode.");
		}
		newSOM = soms.get(0);
	}

	private boolean componentExistsInCurrentMode(ComponentInstance component) {
		if (component instanceof SystemInstance) {
			return true;
		}
		ComponentInstance parentComponent = component;
		do {
			component = parentComponent;
			parentComponent = parentComponent.getContainingComponentInstance();
			if (selectedModes.containsKey(parentComponent)) {
				final ModeInstance mode = selectedModes.get(parentComponent);
				if (mode == null || (component.getInModes().size() > 0 && !component.getInModes().contains(mode))) {
					return false;
				}
			}
		} while (!(parentComponent instanceof SystemInstance));
		return true;
	}

	private void configureViewer() {
		final Tree tree = viewer.getTree();
		TableLayout tableLayout = new TableLayout();
		tree.setLayout(tableLayout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		new TreeColumn(tree, SWT.LEFT).setText(COLUMN_COMPONENT_INSTANCE);
		new TreeColumn(tree, SWT.LEFT).setText(COLUMN_MODE_INSTANCE);
		tableLayout.addColumnData(new ColumnWeightData(2, true));
		tableLayout.addColumnData(new ColumnWeightData(1, true));
		viewer.setColumnProperties(new String[] { COLUMN_COMPONENT_INSTANCE, COLUMN_MODE_INSTANCE });
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		class ComponentAndModeLabelProvider extends LabelProvider implements ITableLabelProvider {
			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				if (columnIndex == 0) {
					return baseLabelProvider.getImage(element);
				} else if (columnIndex == 1) {
					final ComponentInstance component = (ComponentInstance) element;
					if (componentExistsInCurrentMode(component)) {
						if (selectedModes.containsKey(component)) {
							if (selectedModes.get(component) == null) {
								return OsateUiPlugin.getImageDescriptor(MODE_NOT_SET_ICON).createImage();
							} else {
								return OsateUiPlugin.getImageDescriptor(MODE_SET_ICON).createImage();
							}
						} else {
							return null;
						}
					} else {
						return OsateUiPlugin.getImageDescriptor(NONEXISTENT_ICON).createImage();
					}
				}
				return null;
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				if (columnIndex == 0) {
					return baseLabelProvider.getText(element);
				} else if (columnIndex == 1) {
					final ComponentInstance component = (ComponentInstance) element;
					if (componentExistsInCurrentMode(component)) {
						if (selectedModes.containsKey(component)) {
							if (selectedModes.get(component) == null) {
								return "Mode Not Set";
							} else {
								return selectedModes.get(component).getName();
							}
						} else {
							return null;
						}
					} else {
						return "Component Does Not Exist In Current Mode";
					}
				}
				return null;
			}
		}
		viewer.setLabelProvider(new ComponentAndModeLabelProvider());
		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof ComponentInstance) {
					for (ComponentInstance component : ((ComponentInstance) element).getAllComponentInstances()) {
						if (component.getModeInstances().size() > 0) {
							return true;
						}
					}
				}
				return false;
			}
		});
		viewer.setCellEditors(new CellEditor[] { null, new ComboBoxCellEditor(tree, new String[0], SWT.READ_ONLY) });
		viewer.setCellModifier(new ICellModifier() {
			@Override
			public void modify(Object element, String property, Object value) {
				int selection = ((Integer) value).intValue();
				if (selection != -1) {
					selectedModes.put((ComponentInstance) ((TreeItem) element).getData(),
							((ComponentInstance) ((TreeItem) element).getData()).getModeInstances().get(selection));
					updateOkEnabled();
					viewer.refresh();
					viewer.getTree().redraw();
				}
			}

			@Override
			public Object getValue(Object element, String property) {
				final ModeInstance mode = selectedModes.get(element);
				if (mode != null) {
					return new Integer(((ComponentInstance) element).getModeInstances().indexOf(mode));
				} else {
					return new Integer(-1);
				}
			}

			@Override
			public boolean canModify(Object element, String property) {
				if (viewer.getSelection() instanceof IStructuredSelection
						&& ((IStructuredSelection) viewer.getSelection()).size() == 1) {
					final ComponentInstance selectedComponent = (ComponentInstance) ((IStructuredSelection) viewer
							.getSelection()).getFirstElement();
					final ArrayList<String> modeNames = new ArrayList<String>();
					for (ModeInstance mode : selectedComponent.getModeInstances()) {
						modeNames.add(mode.getName());
					}
					((ComboBoxCellEditor) viewer.getCellEditors()[1]).setItems(modeNames.toArray(new String[0]));
				}
				final ComponentInstance component = (ComponentInstance) element;
				return property.equals(COLUMN_MODE_INSTANCE) && (selectedModes.containsKey(component)
						&& (component instanceof SystemInstance || componentExistsInCurrentMode(component)));
			}
		});
		viewer.setInput(systemInstance.eResource());
		viewer.expandAll();
	}

	private void updateOkEnabled() {
		if (requireName && nameInput.getText().length() <= 0) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			return;
		}
		for (final ComponentInstance component : selectedModes.keySet()) {
			if (selectedModes.get(component) == null && componentExistsInCurrentMode(component)) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				return;
			}
		}
		getButton(IDialogConstants.OK_ID).setEnabled(true);
	}

	private void addListeners() {
		nameInput.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateOkEnabled();
			}
		});
		nameInput.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					char ch = e.text.charAt(i);
					if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9') && ch != '_'
							&& ch != '-') {
						e.doit = false;
						return;
					}
				}
			}
		});
	}

	static {
		ArrayList<ComposeableAdapterFactory> factories = new ArrayList<ComposeableAdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new Aadl2ItemProviderAdapterFactory());
		factories.add(new InstanceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		adapterFactory = new ComposedAdapterFactory(factories);
		baseLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * Finds a <code>ComponentInstance</code> that is a direct child of <code>parent</code> with the name of <code>childName</code>.
	 * This is a utility method and is used outside of this class.  If there are more uses of this method, we should consider moving it
	 * to a Util class.
	 *
	 * @param parent The <code>ComponentInstance</code> to search in.
	 * @param childName The <code>ComponentInstance</code> to search for.
	 * @return The <code>ComponentInstance</code> with the name of <code>childName</code> or null if it cannot be found.
	 */
	public static ComponentInstance findComponentInstance(final ComponentInstance parent, final String childName) {
		for (final ComponentInstance component : parent.getComponentInstances()) {
			if (component.getName().equals(childName)) {
				return component;
			}
		}
		return null;
	}

	/**
	 * Finds a <code>ModeInstance</code> that is a direct child of <code>parent</code> with the name of <code>modeName</code>.
	 * This is a utility method and is used outside of this class.  If there are more uses of this method, we should consider moving it
	 * to a Util class.
	 *
	 * @param parent The <code>ComponentInstance</code> to search in.
	 * @param modeName The <code>ModeInstance</code> to search for.
	 * @return The <code>ModeInstance</code> with the name of <code>modeName</code> or null if it cannot be found.
	 */
	public static ModeInstance findModeInstance(final ComponentInstance parent, final String modeName) {
		for (final ModeInstance mode : parent.getModeInstances()) {
			if (mode.getName().equals(modeName)) {
				return mode;
			}
		}
		return null;
	}
}