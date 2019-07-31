/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.pluginsupport.PluginSupportPlugin;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;

/**
 * This class represents the OSATE > Instantiation workspace preferences.
 */

public class ContributedResourcesPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	private final Map<String, Boolean> originalValues = new HashMap<>();

	public ContributedResourcesPreferencePage() {
		super(GRID);
//		setDescription("Contributed resources preferences");
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public void createFieldEditors() {
		final Composite parent = getFieldEditorParent();
		final IPreferenceStore prefs = getPreferenceStore();

		final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setText("Select Plug-in Contributed Resources to Use");

		for (final URI uri : PluginSupportUtil.getContributedAadl()) {
			final String preferenceNameForURI = PredeclaredProperties.getPreferenceNameForURI(uri);
			originalValues.put(preferenceNameForURI, prefs.getBoolean(preferenceNameForURI));
			final BooleanFieldEditor booleanEditor = new BooleanFieldEditor(
					preferenceNameForURI, uri.toString(), group);
			addField(booleanEditor);
		}
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(PluginSupportPlugin.getDefault().getPreferenceStore());
	}

	@Override
	public boolean performOk() {
		final boolean ok = super.performOk();

		/* Check if the preferences changed. Don't want to rebuild the workspace if they didn't */
		final IPreferenceStore prefs = getPreferenceStore();
		boolean changed = false;
		for (final Map.Entry<String, Boolean> elt : originalValues.entrySet()) {
			if (prefs.getBoolean(elt.getKey()) != elt.getValue()) {
				changed = true;
				break;
			}
		}

		// build the workspace
		if (changed) {
			new Job("Contributed Resources Rebuild") {
				@Override
				public IStatus run(final IProgressMonitor monitor) {
					try {
						ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, monitor);
						return Status.OK_STATUS;
					} catch (final CoreException e) {
						return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, "Error building workspace");
					}
				}
			}.schedule();
		}

		return ok;
	}
}