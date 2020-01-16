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
package org.osate.xtext.aadl2.ui.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class OrganizeWithHandler extends AbstractHandler {

	public OrganizeWithHandler() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object execute(ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			return null;
		}
		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
		if (xtextEditor != null) {
			IXtextDocument iXTextDoc = xtextEditor.getDocument();
			iXTextDoc.modify(new IUnitOfWork.Void() {
				@Override
				public void process(Object state) throws Exception {
					EObject rootObject = ((Resource) state).getContents().get(0);
					if (rootObject instanceof AadlPackage) {
						AadlPackage pkg = (AadlPackage) rootObject;
						List<PackageSection> pkgSections = new ArrayList<PackageSection>();
						if (pkg.getOwnedPublicSection() != null) {
							pkgSections.add(pkg.getOwnedPublicSection());
						}
						if (pkg.getOwnedPrivateSection() != null) {
							pkgSections.add(pkg.getOwnedPrivateSection());
						}
						for (PackageSection pkgSection : pkgSections) {
							organizeWithClauses(pkgSection);
						}
					} else if (rootObject instanceof PropertySet) {
						PropertySet propSet = (PropertySet) rootObject;
						organizeWithClauses(propSet);
					}
				}
			});
		}
		return null;
	}

	private void organizeWithClauses(PackageSection pkgSection) {
		List<ModelUnit> workingImportedUnits = new ArrayList<ModelUnit>();
		for (ModelUnit nextImportedUnit : pkgSection.getImportedUnits()) {
			workingImportedUnits.add(nextImportedUnit);
		}
		List<ModelUnit> unusedImportedUnits = getUnusedWiths(pkgSection);
		workingImportedUnits.removeAll(unusedImportedUnits);

		List<ModelUnit> missingWiths = findMissingWiths(pkgSection);
		workingImportedUnits.addAll(missingWiths);

		Collections.sort(workingImportedUnits, new Comparator<ModelUnit>() {
			@Override
			public int compare(ModelUnit obj1, ModelUnit obj2) {
				return obj1.getName().toLowerCase().compareTo(obj2.getName().toLowerCase());
			}
		});
		pkgSection.getImportedUnits().removeAll(pkgSection.getImportedUnits());
		pkgSection.getImportedUnits().addAll(workingImportedUnits);

	}

	private void organizeWithClauses(PropertySet propSet) {
		List<ModelUnit> workingImportedUnits = new ArrayList<ModelUnit>();
		for (ModelUnit nextImportedUnit : propSet.getImportedUnits()) {
			workingImportedUnits.add(nextImportedUnit);
		}
		List<ModelUnit> unusedImportedUnits = getUnusedWiths(propSet);
		workingImportedUnits.removeAll(unusedImportedUnits);

		List<ModelUnit> missingWiths = findMissingWiths(propSet);
		workingImportedUnits.addAll(missingWiths);

		Collections.sort(workingImportedUnits, new Comparator<ModelUnit>() {
			@Override
			public int compare(ModelUnit obj1, ModelUnit obj2) {
				return obj1.getName().toLowerCase().compareTo(obj2.getName().toLowerCase());
			}
		});
		propSet.getImportedUnits().removeAll(propSet.getImportedUnits());
		propSet.getImportedUnits().addAll(workingImportedUnits);
	}

	private List<ModelUnit> getUnusedWiths(PackageSection packageSection) {
		List<ModelUnit> importedUnits = packageSection.getImportedUnits();
		List<ModelUnit> unusedWiths = new ArrayList<ModelUnit>();
		ImportedUnitsLoop: for (ModelUnit nextImportedUnit : importedUnits) {
			if (nextImportedUnit.equals(packageSection.eContainer())) {
				unusedWiths.add(nextImportedUnit);
				continue ImportedUnitsLoop;
			}
			if (AadlUtil.isPredeclaredPropertySet(nextImportedUnit.getName())) {
				unusedWiths.add(nextImportedUnit);
				continue ImportedUnitsLoop;
			}

			TreeIterator<EObject> packageContents = packageSection.eAllContents();
			while (packageContents.hasNext()) {
				EObject nextObject = packageContents.next();
				EList<EObject> crossReferences = nextObject.eCrossReferences();
				for (EObject crossReference : crossReferences) {
					EObject container = crossReference.eContainer();
					if (nextImportedUnit.equals(container)) {
						continue ImportedUnitsLoop;
					} else {
						while (container != null && !(container instanceof AadlPackage)
								&& !(container instanceof PropertySet)) {
							container = container.eContainer();
							if (container.equals(nextImportedUnit)) {
								continue ImportedUnitsLoop;
							}
						}
					}
				}
			}
			unusedWiths.add(nextImportedUnit);
		}
		return unusedWiths;
	}

	private List<ModelUnit> getUnusedWiths(PropertySet propertySet) {
		List<ModelUnit> importedUnits = propertySet.getImportedUnits();
		List<ModelUnit> unusedWiths = new ArrayList<ModelUnit>();
		ImportedUnitsLoop: for (ModelUnit nextImportedUnit : importedUnits) {
			if (nextImportedUnit.equals(propertySet.eContainer())) {
				unusedWiths.add(nextImportedUnit);
				continue ImportedUnitsLoop;
			}
			if (AadlUtil.isPredeclaredPropertySet(nextImportedUnit.getName())) {
				unusedWiths.add(nextImportedUnit);
				continue ImportedUnitsLoop;
			}

			TreeIterator<EObject> packageContents = propertySet.eAllContents();
			while (packageContents.hasNext()) {
				EObject nextObject = packageContents.next();
				EList<EObject> crossReferences = nextObject.eCrossReferences();
				for (EObject crossReference : crossReferences) {
					EObject container = crossReference.eContainer();
					if (nextImportedUnit.equals(container)) {
						continue ImportedUnitsLoop;
					} else {
						while (container != null && !(container instanceof AadlPackage)
								&& !(container instanceof PropertySet)) {
							container = container.eContainer();
							if (container.equals(nextImportedUnit)) {
								continue ImportedUnitsLoop;
							}
						}
					}
				}
			}
			unusedWiths.add(nextImportedUnit);
		}
		return unusedWiths;
	}

	private List<ModelUnit> findMissingWiths(PackageSection pkgSection) {
		List<ModelUnit> currentWiths = pkgSection.getImportedUnits();
		List<ModelUnit> missingWiths = new ArrayList<ModelUnit>();
		TreeIterator<EObject> packageContents = pkgSection.eAllContents();
		while (packageContents.hasNext()) {
			EObject nextObject = packageContents.next();
			EList<EObject> crossReferences = nextObject.eCrossReferences();
			for (EObject crossReference : crossReferences) {
				EObject container = crossReference.eContainer();
				while (container != null) {
					if ((container instanceof PropertySet || container instanceof AadlPackage)
							&& (!AadlUtil.isPredeclaredPropertySet(((ModelUnit) container).getName()))
							&& (!((ModelUnit) container).equals(pkgSection.eContainer()))) {
						if (!currentWiths.contains(container) && !missingWiths.contains(container)) {
							missingWiths.add((ModelUnit) container);
						}
					}
					container = container.eContainer();
				}
			}
		}
		return missingWiths;
	}

	private List<ModelUnit> findMissingWiths(PropertySet propertySet) {
		List<ModelUnit> currentWiths = propertySet.getImportedUnits();
		List<ModelUnit> missingWiths = new ArrayList<ModelUnit>();
		TreeIterator<EObject> packageContents = propertySet.eAllContents();
		while (packageContents.hasNext()) {
			EObject nextObject = packageContents.next();
			EList<EObject> crossReferences = nextObject.eCrossReferences();
			for (EObject crossReference : crossReferences) {
				EObject container = crossReference.eContainer();
				while (container != null) {
					if ((container instanceof PropertySet || container instanceof AadlPackage)
							&& (!AadlUtil.isPredeclaredPropertySet(((ModelUnit) container).getName()))
							&& (!((ModelUnit) container).equals(propertySet))) {
						if (!currentWiths.contains(container) && !missingWiths.contains(container)) {
							missingWiths.add((ModelUnit) container);
						}
					}
					container = container.eContainer();
				}
			}
		}
		return missingWiths;
	}
}
