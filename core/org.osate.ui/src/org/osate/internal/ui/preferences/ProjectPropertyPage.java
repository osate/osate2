/*
 * <copyright>
 * Copyright  2004-2013 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.internal.ui.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.osate.workspace.WorkspacePlugin;

/**
 * Property page for configuring the project directories
 *
 * @author jdelange
 */
public class ProjectPropertyPage extends FieldEditorPreferencePage implements IWorkbenchPropertyPage {

	/**
	 * The element.
	 */
	private IAdaptable element;

	/**
	 * The preference store.
	 */
	private PreferenceStore projectProperties = null;

	/**
	 * Constructor
	 */
	public ProjectPropertyPage() {
		super(GRID);
		setDescription("Set AADL text and XML folders for the current project");
	}

	private IProject getProject() {
		IAdaptable adaptable = getElement();
		if (adaptable != null) {
			return (IProject) adaptable;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {
		projectProperties = WorkspacePlugin.getPreferenceStore(getProject());
		setPreferenceStore(projectProperties);
		StringFieldEditor fe = new StringFieldEditor(WorkspacePlugin.AADL_PROJECT_FILE, "AADL_Project File",
				getFieldEditorParent());
		addField(fe);

		/*
		 * projectProperties = WorkspacePlugin.getPreferenceStore(getProject());
		 * setPreferenceStore(projectProperties);
		 * DirectoryFieldEditor de = new ProjectDirectoryFieldEditor(getProject(),
		 * "AADL text folder must exist in current project", WorkspacePlugin.PROJECT_SOURCE_DIR, "Aadl text folder:",
		 * getFieldEditorParent());
		 * addField(de);
		 * de = new ProjectDirectoryFieldEditor(getProject(), "XML model folder must exist in current project",
		 * WorkspacePlugin.PROJECT_MODEL_DIR, "XML model folder:", getFieldEditorParent());
		 * addField(de);
		 */
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#getElement()
	 */
	@Override
	public IAdaptable getElement() {
		return element;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public void setElement(IAdaptable element) {
		this.element = element;
	}
}