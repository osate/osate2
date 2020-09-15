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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osate.pluginsupport.PluginSupportPlugin;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;

/**
 * This class represents the OSATE > Instantiation workspace preferences.
 * @since 5.0
 */
public final class ContributedResourcesPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {
	private Map<URI, URI> originalOverriddenAadl;
	private final Map<URI, URI> overriddenAadl = new HashMap<>();

	private Button overrideButton;
	private Button restoreButton;
	private ListViewer contributedList;
	private Label uriLabel;

	public ContributedResourcesPreferencePage() {
		super("Contributed Resources");
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public Control createContents(final Composite parent) {
		// Save original settings, and initialize the local copy
		originalOverriddenAadl = PredeclaredProperties.getOverriddenResources();
		overriddenAadl.putAll(originalOverriddenAadl);

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));

		final List<URI> contributedAadl = PluginSupportUtil.getContributedAadl();
		contributedList = new ListViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		contributedList.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		contributedList.setContentProvider((IStructuredContentProvider) inputElement -> {
			if (inputElement == null) {
				return new String[0];
			} else {
				return ((List<?>) inputElement).toArray();
			}
		});
		contributedList.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				return uriToLabel((URI) element);
			}
		});
		contributedList.addSelectionChangedListener(event -> {
			final ISelection selection = event.getSelection();
			if (selection.isEmpty()) {
				restoreButton.setEnabled(false);
				uriLabel.setText("");
			} else {
				final URI uri = getURIFromSelection(selection);
				final boolean overridden = overriddenAadl.containsKey(uri);
				restoreButton.setEnabled(overridden);
				uriLabel.setText(uriToReadable(overridden ? overriddenAadl.get(uri) : uri));
			}
		});
		contributedList.setInput(contributedAadl);

		overrideButton = new Button(composite, SWT.PUSH);
		overrideButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		overrideButton.setText("Override");
		overrideButton.setToolTipText("Override the URI of the contributed resource with a URI from the workspace.");
		overrideButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final URI uri = getURIFromSelection(contributedList.getSelection());
				if (uri != null) {
					final URI newURI = getWorkspaceContributedResource(uri.lastSegment());
					overriddenAadl.put(uri, newURI);
					restoreButton.setEnabled(true);
					contributedList.refresh();
					uriLabel.setText(uriToReadable(newURI));
				}
			}
		});

		restoreButton = new Button(composite, SWT.PUSH);
		restoreButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
		restoreButton.setText("Restore");
		restoreButton.setToolTipText("Restore contributed resource to its plugin-specified URI.");
		restoreButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final URI uri = getURIFromSelection(contributedList.getSelection());
				if (uri != null) {
					overriddenAadl.remove(uri);
					restoreButton.setEnabled(false);
					contributedList.refresh();
					uriLabel.setText(uriToReadable(uri));
				}
			}
		});

		final Group labelGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		labelGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		labelGroup.setLayout(new GridLayout(1, true));

		labelGroup.setText("Contributed URI");
		uriLabel = new Label(labelGroup, SWT.NONE);
		uriLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		uriLabel.setText("Label!");


		// Initialize the list selection and the label text
		if (contributedAadl.isEmpty()) {
			uriLabel.setText("");
		} else {
			contributedList.setSelection(new StructuredSelection(contributedAadl.get(0)));
		}

		return composite;
	}

	private static URI getURIFromSelection(final ISelection selection) {
		return (URI) ((IStructuredSelection) selection).getFirstElement();
	}

	private static String uriToReadable(final URI uri) {
		final String uriAsString = uri.toString();
		final int firstSlash = uriAsString.indexOf('/');
		final int secondSlash = uriAsString.indexOf('/', firstSlash + 1);
		return uriAsString.substring(secondSlash + 1);
	}

	private String uriToLabel(final URI uri) {
		final String suffix = overriddenAadl.containsKey(uri) ? " [Overridden]" : "";
		return uriToReadable(uri) + suffix;
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(PluginSupportPlugin.getDefault().getPreferenceStore());
	}

	@Override
	public boolean performOk() {
		final boolean ok = super.performOk();

		/* Check if the preferences changed. Don't want to rebuild the workspace if they didn't */
		final boolean changed = !originalOverriddenAadl.equals(overriddenAadl);

		if (changed) {
			PredeclaredProperties.setOverriddenResources(overriddenAadl);

			/*
			 * Rebuilding or cleaning the workspace doesn't seem to get the job done. It leaves
			 * dangling links and other strangeness in the workspace. The most effective thing
			 * to do seems to be closing and reopening projects. Have no idea why.
			 *
			 * NB. THis CANNOT be a WorkspaceJob because that will cause various events to be suppressed or
			 * optimized away, and then the build won't happen correctly.
			 */
			final Job job = new Job("Contributed Resources Rebuild") {
				@Override
				public IStatus run(final IProgressMonitor monitor) {
					try {
						final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
						final List<IProject> projectsToOpenAndClose = new ArrayList<>(projects.length);

						// (1) close all the open projects
						for (final IProject project : projects) {
							if (project.isOpen()) {
								projectsToOpenAndClose.add(project);
								project.close(monitor);
							}
						}

						// (2) Reopen all the projects we closed
						for (final IProject project : projectsToOpenAndClose) {
							project.open(monitor);
						}

						return Status.OK_STATUS;
					} catch (final CoreException e) {
						return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, "Error building workspace");
					}
				}
			};
			job.setRule(ResourcesPlugin.getWorkspace().getRoot()); // Lock the workspace?
			job.schedule();
		}

		return ok;
	}

	private static boolean filterContainer(final Map<Object, Boolean> visible, final IResource irsrc,
			final String fileName) throws CoreException {
		boolean isViz = false;
		if (irsrc instanceof IFile) {
			isViz = irsrc.getName().contentEquals(fileName);
		} else if (irsrc instanceof IContainer) {
			for (final IResource child : ((IContainer) irsrc).members()) {
				isViz |= filterContainer(visible, child, fileName);
			}
		}
		visible.put(irsrc, isViz);
		return isViz;
	}

	private URI getWorkspaceContributedResource(final String fileName) {
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(),
				new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setTitle("Choose the Replacement Resource");
		dialog.setMessage(
				"Choose a file named \"" + fileName
						+ "\" in the workspace to override the contributed resource." + System.lineSeparator()
						+ "Only acceptable replacements are shown below.");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());

		final Map<Object, Boolean> visible = new HashMap<>();
		try {
			for (final IResource irsrc : ResourcesPlugin.getWorkspace().getRoot().members()) {
				filterContainer(visible, irsrc, fileName);
			}
		} catch (final CoreException e) {
			OsateUiPlugin.log(e);
		}

		dialog.setAllowMultiple(false); // only singleton selections
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
				return visible.getOrDefault(element, false);
			}
		});
		dialog.setValidator(selection -> {
			/*
			 * Must a be singleton selection of an IFile whose file name is
			 * the given filename.
			 */
			if (selection.length == 1 && selection[0] instanceof IFile &&
					((IFile) selection[0]).getName().equals(fileName)) {
				return new Status(IStatus.OK, OsateUiPlugin.PLUGIN_ID, "");
			} else {
				return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID,
						"Must select a file named '" + fileName + "'.");
			}
		});

		if (dialog.open() == Window.OK) {
			return URI.createPlatformResourceURI(((IResource) dialog.getFirstResult()).getFullPath().toString(), false);
		} else {
			return null;
		}
	}
}