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
package org.osate.ui.wizards.workingsets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.internal.dialogs.WorkingSetLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osate.ui.OsateUiPlugin;

/**
 * @author Andrey
 */
@SuppressWarnings("restriction")
public abstract class WSPage extends WizardPage {
	/** last used working set import/export file */
	protected static final String LAST_USED_WS_FILE = "lastUsedWsFile";

	private final Shell shell;
	private final int fileDialogStyle;
	private CheckboxTableViewer tv;
	protected Composite comp;
	protected List/* <String> */<String> usedFiles;
	private Combo dest;

	protected WSPage(String pageName, String title, String descr, String imagePath, Shell shell, int fileDialogStyle) {
		super(pageName, title, AbstractUIPlugin.imageDescriptorFromPlugin(OsateUiPlugin.PLUGIN_ID, imagePath));
		setDescription(descr);
		usedFiles = new ArrayList<String>();
		this.shell = shell;
		this.fileDialogStyle = fileDialogStyle;
	}

	@Override
	public void createControl(Composite parent) {
		comp = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		comp.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		comp.setLayoutData(gd);
		setControl(comp);

		tv = CheckboxTableViewer.newCheckList(comp,
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		IStructuredContentProvider contentProvider = createContentProvider();
		tv.setContentProvider(contentProvider);
		tv.setLabelProvider(new WorkingSetLabelProvider());
		tv.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tv.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				selectionChanged();
			}
		});

		setInput(contentProvider.getElements(null));

		Composite fileSelectCom = new Composite(comp, SWT.NONE);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		fileSelectCom.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileSelectCom.setLayoutData(gd);

		IPreferenceStore store = OsateUiPlugin.getDefault().getPreferenceStore();
		String lastUsedFile = store.getString(LAST_USED_WS_FILE);
		usedFiles.add(lastUsedFile);
		dest = new Combo(fileSelectCom, SWT.DROP_DOWN);
		dest.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		updateItems(lastUsedFile);

		dest.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});

		Button chooserBtn = new Button(fileSelectCom, SWT.NONE);
		chooserBtn.setText("Browse...");
		chooserBtn.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// ignored
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateItems(getFileFromUser());
				validateInput();
			}
		});

		validateInput();
	}

	protected void selectionChanged() {
		validateInput();
	}

	abstract protected IStructuredContentProvider createContentProvider();

	protected String getFileString() {
		String text = dest.getText();
		if ("".equals(text)) {
			return null;
		}
		return text;
	}

	protected boolean validateInput() {
		String errorMessage;
		String text = getFileString();
		if (text == null) {
			errorMessage = "Please select a file";
		} else if (getSelectedWorkingSets().length == 0) {
			errorMessage = "Please select at least one working set";
		} else {
			errorMessage = null;
		}
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
		return errorMessage == null;
	}

	@Override
	public void dispose() {
		tv = null;
		comp.dispose();
		super.dispose();
	}

	/**
	 * @param sets
	 */
	protected void setInput(Object[] elements) {
		tv.setInput(elements);
		for (int i = 0; i < elements.length; i++) {
			IWorkingSet workingSet = (IWorkingSet) elements[i];
			tv.setChecked(workingSet, workingSet.isVisible() && !workingSet.isEmpty());
		}
	}

	protected Object[] getSelectedWorkingSets() {
		return tv.getCheckedElements();
	}

	protected String getFileFromUser() {
		FileDialog fd = new FileDialog(shell, fileDialogStyle);
		String fileString = getFileString();
		if (fileString == null) {
			String property = System.getProperty("user.home");
			fd.setFilterPath(property);
		} else {
			fd.setFileName(fileString);
		}
		fd.setFilterExtensions(new String[] { "*.wst" });
		fileString = fd.open();
		if (fileString != null) {
			return fileString;
		}
		return null;
	}

	protected String[] getLastUsedPaths() {
		return usedFiles.toArray(new String[usedFiles.size()]);
	}

	protected void updateItems(String fileString) {
		if (fileString == null) {
			return;
		}
		if (!usedFiles.contains(fileString)) {
			usedFiles.add(0, fileString);
		}
		dest.setItems(getLastUsedPaths());
		if (dest.getItemCount() > 0) {
			dest.setText(dest.getItem(0));
		}
	}

}
