/*******************************************************************************
 * Copyright (c) 2012 Andrey.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Andrey Loskutov - initial API and implementation
 *     Carnegie Mellon University Software Engineering Institute - moved into OSATE
 *******************************************************************************/
package org.osate.ui.wizards.workingsets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.internal.IWorkbenchConstants;
import org.osate.ui.OsateUiPlugin;

/**
 * @author Andrey
 */
@SuppressWarnings("restriction")
public class ImportPage extends WSPage {

	private static final String TITLE = "Import working sets from the local file system";
	private static final String DESCRIPTION = "Select the file path to import working "
			+ "sets from and working sets to import";

	protected boolean isMerge;

	protected ImportPage(String pageName, Shell shell) {
		super(pageName, TITLE, DESCRIPTION, "icons/workingsets/import_wiz.gif", shell, SWT.OPEN);
		isMerge = true;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		final Button chooserBtn = new Button(comp, SWT.CHECK);
		chooserBtn.setSelection(isMerge);
		chooserBtn.setText("Merge with existing working sets");
		chooserBtn.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// ignored
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				isMerge = chooserBtn.getSelection();
			}
		});
	}

	private String readSets() {
		String pathname = getFileString();
		if (pathname == null) {
			return "Please select a file";
		}
		File file = new File(pathname);
		FileInputStream input = null;
		BufferedReader reader;
		IMemento memento;
		try {
			input = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
			memento = XMLMemento.createReadRoot(reader);
		} catch (FileNotFoundException e) {
			return "Couldn't read working set file: " + file + ": " + e.getMessage();
		} catch (IOException e) {
			return "Couldn't read working set file: " + file + ": " + e.getMessage();
		} catch (CoreException e) {
			return "Couldn't read working set file: " + file + ": " + e.getMessage();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					OsateUiPlugin.log(e);
				}
			}
		}

		IMemento[] mementos = memento.getChildren("workingSet");
		List<IWorkingSet> sets = new ArrayList<IWorkingSet>();
		for (int i = 0; i < mementos.length; i++) {
			IWorkingSet set = restoreWorkingSet(mementos[i]);
			if (set != null) {
				sets.add(set);
			}
		}

		setInput(sets.toArray(new IWorkingSet[sets.size()]));

		try {
			String lastUsedFile = file.getCanonicalPath();
			IPreferenceStore store = OsateUiPlugin.getDefault().getPreferenceStore();
			store.setValue(LAST_USED_WS_FILE, lastUsedFile);
		} catch (IOException e) {
			OsateUiPlugin.log(e);
		}
		return null;
	}

	// see org.eclipse.ui.internal.AbstractWorkingSet
	protected IWorkingSet restoreWorkingSet(IMemento memento) {
		String factoryID = memento.getString(IWorkbenchConstants.TAG_FACTORY_ID);

		if (factoryID == null) {
			// if the factory id was not set in the memento
			// then assume that the memento was created using
			// IMemento.saveState, and should be restored using WorkingSetFactory
			factoryID = "org.eclipse.ui.internal.WorkingSetFactory";
		}
		IElementFactory factory = PlatformUI.getWorkbench().getElementFactory(factoryID);
		if (factory == null) {
			OsateUiPlugin.logErrorMessage("Unable to restore working set - cannot instantiate factory: " + factoryID);
			return null;
		}
		IAdaptable adaptable = factory.createElement(memento);
		if (adaptable == null) {
			OsateUiPlugin.logErrorMessage("Unable to restore working set - cannot instantiate working set: " + factoryID);
			return null;
		}
		if (!(adaptable instanceof IWorkingSet)) {
			OsateUiPlugin.logErrorMessage("Unable to restore working set - element is not an IWorkingSet: " + factoryID);
			return null;
		}
		return (IWorkingSet) adaptable;
	}

	public boolean finish() {
		importSelectedSets();
		return true;
	}

	private void importSelectedSets() {
		Object[] selected = getSelectedWorkingSets();
		if (selected == null) {
			return;
		}
		IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
		List<IWorkingSet> added = new ArrayList<IWorkingSet>();
		for (int i = 0; i < selected.length; i++) {
			IWorkingSet workingSet = (IWorkingSet) selected[i];
			IWorkingSet oldWorkingSet = workingSetManager.getWorkingSet(workingSet.getName());
			if (oldWorkingSet == null) {
				removeNonExistingChildren(workingSet);
				workingSetManager.addWorkingSet(workingSet);
				added.add(workingSet);
			} else if (isMerge) {
				removeNonExistingChildren(workingSet);
				mergeWorkingSets(oldWorkingSet, workingSet);
			}
		}
	}

	private static void removeNonExistingChildren(IWorkingSet workingSet) {
		IAdaptable[] elements = workingSet.getElements();
		List<IResource> existing = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {
			IResource resource = getResource(elements[i]);
			if (resource != null && resource.exists()) {
				existing.add(resource);
			}
		}
		workingSet.setElements(existing.toArray(new IAdaptable[existing.size()]));
	}

	public static class WorkingSetContentProvider implements ITreeContentProvider {
		private IWorkingSet[] workingSets;

		@Override
		public void dispose() {
			// noop
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof IWorkingSet[]) {
				workingSets = (IWorkingSet[]) newInput;
			}
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (workingSets == null) {
				return new Object[0];
			}
			List<IWorkingSet> sets = new ArrayList<IWorkingSet>();
			for (int i = 0; i < workingSets.length; i++) {
				IWorkingSet workingSet = workingSets[i];
				if (!workingSet.isAggregateWorkingSet()) {
					sets.add(workingSet);
				}
			}
			return sets.toArray(new IWorkingSet[sets.size()]);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}
	}

	@Override
	protected IStructuredContentProvider createContentProvider() {
		return new WorkingSetContentProvider();
	}

	@Override
	protected void selectionChanged() {
		String errorMessage = null;
		if (getSelectedWorkingSets().length == 0) {
			errorMessage = "Please select at least one working set";
		}
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
	}

	@Override
	protected boolean validateInput() {
		String errorMessage = null;
		String text = getFileString();
		if (text == null) {
			errorMessage = "Please select a file";
		}

		if (errorMessage != null) {
			setInput(new IWorkingSet[0]);
			setErrorMessage(errorMessage);
			setPageComplete(false);
			return false;
		}
		errorMessage = readSets();
		if (errorMessage != null) {
			errorMessage = "Working set import failed: " + errorMessage;
		} else if (getSelectedWorkingSets().length == 0) {
			errorMessage = "Please select at least one working set";
		}
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
		if (errorMessage != null) {
			setInput(new IWorkingSet[0]);
		}
		return errorMessage == null;
	}

	public void setInitialSelection(IStructuredSelection selection) {
		if (selection == null) {
			return;
		}
		IResource resource = getResource(selection);
		if (resource == null) {
			return;
		}
		IPath location = resource.getLocation();
		if (location != null && "wst".equals(location.getFileExtension()) && location.toFile().isFile()) {
			usedFiles.add(location.toOSString());
		}
	}

	private void mergeWorkingSets(IWorkingSet oldWorkingSet, IWorkingSet newWorkingSet) {
		if (!oldWorkingSet.isEditable()) {
			return;
		}
		IAdaptable[] elementsOld = oldWorkingSet.getElements();
		IAdaptable[] elementsNew = newWorkingSet.getElements();
		if (elementsNew == null || elementsOld == null || elementsNew.length == 0) {
			return;
		}
		LinkedHashSet<IAdaptable> set = new LinkedHashSet<IAdaptable>(Arrays.asList(elementsOld));
		ArrayList<IAdaptable> newList = new ArrayList<IAdaptable>(Arrays.asList(elementsNew));
		newList.removeAll(set);
		if (newList.size() == 0) {
			return;
		}
		elementsNew = oldWorkingSet.adaptElements(newList.toArray(new IAdaptable[newList.size()]));
		newList = new ArrayList<IAdaptable>(Arrays.asList(elementsNew));
		newList.removeAll(set);
		if (newList.size() == 0) {
			return;
		}
		set.addAll(newList);
		oldWorkingSet.setElements(set.toArray(new IAdaptable[set.size()]));
	}
	
	/**
	 * @param o
	 *     selection or some object which is or can be adapted to resource
	 * @return given object as resource, may return null
	 */
	private static IResource getResource(Object o) {
		IResource r = getAdapter(o, IResource.class);
		if (r != null) {
			return r;
		}
		return getAdapter(o, IFile.class);
	}

	/**
	 * Adapt object to given target class type
	 *
	 * @param o
	 *     selection or some object which is or can be adapted to given type
	 * @param target
	 * @param <V> type of target
	 * @return adapter from given object to given type, may return null
	 */
	private static <V> V getAdapter(Object o, Class<V> target) {
		if (o instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) o;
			if (selection.isEmpty()) {
				return null;
			}
			o = selection.getFirstElement();
		}
		if (o == null) {
			return null;
		}
		if (target.isInstance(o)) {
			return target.cast(o);
		}
		if (o instanceof IAdaptable) {
			V adapter = (V) ((IAdaptable) o).getAdapter(target);
			if (adapter != null) {
				return adapter;
			}
		}
		// If the source object is a platform object then it's already tried calling AdapterManager.getAdapter
		if (o instanceof PlatformObject) {
			return null;
		}
		Object adapted = Platform.getAdapterManager().getAdapter(o, target);
		return target.cast(adapted);
	}
}
