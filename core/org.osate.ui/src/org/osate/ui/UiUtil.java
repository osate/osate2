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
package org.osate.ui;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.provider.InstanceItemProviderAdapterFactory;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.provider.Aadl2ItemProviderAdapterFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

public final class UiUtil {
	public static final int SUCCESS = 0;
	public static final int SILENT_FAILURE = 1;
	public static final int NO_DIAGRAM_FILE = 2;
	public static final int SYNTAX_ERROR = 3;

	private static ComposedAdapterFactory adapterFactory = null;
	private static AdapterFactoryLabelProvider labelProvider = null;
	private static AdapterFactoryContentProvider contentProvider = null;

	@Inject
	private ILocationInFileProvider locationProvider;

	private static final UiUtil PROTOTYPE = new UiUtil();

	private UiUtil() {
		final Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		injector.injectMembers(this);
	}

	public static final UiUtil getInstance() {
		return PROTOTYPE;
	}

	private static boolean openEditor(final IWorkbenchPage page, final IFile input, final boolean activate) {
		final class Result {
			public volatile boolean value = true;
		}

		final Result result = new Result();
		Display.getDefault().syncExec(() -> {
			try {
				IDE.openEditor(page, input, activate);
			} catch (PartInitException e) {
				OsateUiPlugin.log(e);
				result.value = false;
			}
		});
		return result.value;
	}

	public static boolean openEditor(final IWorkbenchPage page, final IMarker marker, final boolean activate) {
		final class Result {
			public volatile boolean value = true;
		}

		final Result result = new Result();
		Display.getDefault().syncExec(() -> {
			try {
				IDE.openEditor(page, marker, activate);
			} catch (PartInitException e) {
				OsateUiPlugin.log(e);
				result.value = false;
			}
		});
		return result.value;
	}

//	/**
//	 * goto aaxl model through the editor associated with aaxl files. assumes
//	 * that the text file has been saved and compiled.
//	 *
//	 * @param page
//	 *            Workbench page
//	 * @param root
//	 *            Root AObject of model to go to
//	 * @param linenumber
//	 *            line number in text whose locationin the object should be the
//	 *            target
//	 */
//	public static void gotoAaxlModel(IWorkbenchPage page, final Element root, int linenumber) {
//		if (root == null){
//			return;
//		}
//		Aadl2ResourceImpl res = (Aadl2ResourceImpl)root.eResource();
//		Element target = AadlUtil.findElement(root, linenumber);
//		if (target != null){
//			gotoAaxlModel(page, target);
//		}
//	}

	/**
	 * goto declarative model object through the editor associated with aadl files.
	 * @param page Workbench page
	 * @param io InstanceObject whose source in the declarative model is the target of the goto
	 */
	public static void gotoInstanceObjectSource(IWorkbenchPage page, InstanceObject io) {
		if (io != null) {
			gotoDeclarativeModelElement(page, AadlUtil.getInstanceOrigin(io));
		}
	}

	/**
	 * Goto declarative model object through the editor associated with aadl files.
	 * @param page Workbench page
	 * @param pai instance model property association whose source in the declarative model is the target of the goto
	 */
	public static void gotoInstanceObjectSource(IWorkbenchPage page, PropertyAssociationInstance pai) {
		if (pai != null) {
			gotoDeclarativeModelElement(page, pai.getPropertyAssociation());
		}
	}

	/**
	 * goto Xtext model through the editor associated with aadl files.
	 * @param page Workbench page
	 * @param target Element that is the target object
	 */
	/*
	 * XXX this method is obsolete, I think, it does a poor job of locating the
	 * source text in the declarative model.
	 */
	public static void gotoDeclarativeModelElement(IWorkbenchPage page, Element target) {
		if (target == null) {
			return;
		}
		Resource res = target.eResource();
		final IFile ires = OsateResourceUtil.toIFile(res.getURI());
		if (ires.exists()) {
			try {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(target);
				int offset = node.getTotalEndOffset();
				int line = node.getTotalEndLine();
				IMarker marker_p;
				marker_p = ires.createMarker(AadlConstants.AADLGOTOMARKER);
				marker_p.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				String dest = EcoreUtil.getURI(target).toString();
				marker_p.setAttribute(IMarker.MESSAGE, "Going to " + dest);
				marker_p.setAttribute(IMarker.LOCATION, offset);
				marker_p.setAttribute(IMarker.LINE_NUMBER, line);
				marker_p.setAttribute(EValidator.URI_ATTRIBUTE, dest);
				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
				// editor opened --- get rid of goto marker
				ires.deleteMarkers(AadlConstants.AADLGOTOMARKER, false, IResource.DEPTH_ZERO);
			} catch (final CoreException e) {
				OsateUiPlugin.log(e);
			}
		}
	}

	/**
	 * Open an editor and hightlight the source text of the given declarative AADL element.
	 *
	 * <p><em>Assumes the caller has already locked the workspace.</em>  If the workspace
	 * is not already locked, you can use {@link #openDeclarativeModelElementAsJob(IWorkbenchPage, Element)}.
	 *
	 * @param page The workbench page.
	 * @param target The AADL element to highlight.
	 */
	public void openDeclarativeModelElement(final IWorkbenchPage page, final Element target) {
		if (target == null) {
			return;
		}
		Resource res = target.eResource();
		final IFile ires = OsateResourceUtil.toIFile(res.getURI());
		if (ires.exists()) {
			try {
				final IMarker marker_p = ires.createMarker(AadlConstants.AADLGOTOMARKER);
				marker_p.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				final String targetURI = EcoreUtil.getURI(target).toString();
				marker_p.setAttribute(IMarker.MESSAGE, "Going to " + targetURI);
				final ITextRegion where = locationProvider.getFullTextRegion(target);
				final int start = where.getOffset();
				final int end = start + where.getLength();
				marker_p.setAttribute(IMarker.CHAR_START, start);
				marker_p.setAttribute(IMarker.CHAR_END, end);
				marker_p.setAttribute(AadlConstants.AADLURI, targetURI);
				marker_p.setAttribute(EValidator.URI_ATTRIBUTE, targetURI);

				openEditor(page, marker_p, OpenStrategy.activateOnOpen());

				// editor opened --- get rid of goto marker
				ires.deleteMarkers(AadlConstants.AADLGOTOMARKER, false, IResource.DEPTH_ZERO);
			} catch (final CoreException e) {
				OsateUiPlugin.log(e);
			}
		}
	}

	public void openDeclarativeModelElementAsJob(final IWorkbenchPage page, final Element target) {
		if (page == null || target == null) {
			return;
		}
		final Job job = new WorkspaceJob("Goto AADL Element") {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
				openDeclarativeModelElement(page, target);
				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();
	}

//
//	/**
//	 * goto aaxldi model in editor associated with diagram files.
//	 * assumes that the text file has been saved and compiled.
//	 * @param page Workbench page
//	 * @param root Root AObject of model to go to
//	 * @param linenumber line number in text whose locationin the object should be the target
//	 */
//	public static int gotoAaxldiModel(IWorkbenchPage page, final Element root, int linenumber) {
//		Element target = AadlUtil.findElement(root, linenumber);
//		if (target == null){
//			return SILENT_FAILURE;
//		}
//		return gotoAaxldiModel(page,target);
//	}
//
//	/**
//	 * goto aaxldi model in editor associated with diagram files.
//	 * assumes that the text file has been saved and compiled.
//	 * @param page Workbench page
//	 * @param target AObject that is the target object
//	 */
//	public static int gotoAaxldiModel(IWorkbenchPage page, Element target) {
//		if (target == null){
//			return SILENT_FAILURE;
//		}
//		if (target instanceof InstanceObject){
//			target = AadlUtil.getInstanceOrigin((InstanceObject)target);
//			if (target == null){
//				return SILENT_FAILURE;
//			}
//		}
//		Aadl2ResourceImpl res = (Aadl2ResourceImpl)target.eResource();
//		final IResource ires = OsateResourceUtil.convertToIResource(res);
//		if (ires == null){
//			return SILENT_FAILURE;
//		}
//		IFile aaxlFile = (IFile) ires;
//		IPath p = aaxlFile.getFullPath();
//		p = p.removeFileExtension().addFileExtension( "aaxldi");
//		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//		IResource diaFile =  myWorkspaceRoot.getFile(p);
//		if (!diaFile.exists()) {
//			return NO_DIAGRAM_FILE;
//		}
//		if (ires != null && ires.exists())
//		{
//			try {
//				IMarker marker_p;
//				marker_p = diaFile.createMarker(EValidator.MARKER);
//				marker_p.setAttribute(IMarker.SEVERITY,
//						IMarker.SEVERITY_INFO);
//				String dest = EcoreUtil.getURI(target).toString();
//				marker_p.setAttribute(IMarker.MESSAGE, "Going to "
//						+ dest);
//				marker_p.setAttribute(AadlConstants.AADLURI, dest);
//				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
//				// editor opened --- get rid of goto marker
//				diaFile.deleteMarkers(EValidator.MARKER,
//						false, IResource.DEPTH_ZERO);
//			} catch (CoreException e) {
//				OsateUiPlugin.log(e);
//			}
//		}
//		return SUCCESS;
//	}
//
//	/**
//	 * go to the source text location corresponding to the location of the specified AObject
//	 * The method will ensure that the source text is up to date with the model file
//	 */
//	public static void gotoSourceText(IWorkbenchPage page, Element obj) {
//		if (obj instanceof InstanceObject){
//			obj = AadlUtil.getInstanceOrigin((InstanceObject)obj);
//			if (obj == null){
//				return;
//			}
//		}
//		final IResource aaxlResource = OsateResourceUtil.convertToIResource(obj.eResource());
//		if (aaxlResource == null || !aaxlResource.exists() ){
//			return;
//		}
//		final IResource aadlResource = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlResource).getAadlFile((IFile)aaxlResource);
//		LocationReference loc = obj.getLocationReference();
//		if (loc != null ) {
//			try {
//				final IMarker marker_p =
//					aadlResource.createMarker(AadlConstants.AADLTEXTGOTOMARKER);
//				marker_p.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
//				String dest = EcoreUtil.getURI(obj).toString();
//				marker_p.setAttribute(IMarker.MESSAGE, "Going to " + dest);
//				marker_p.setAttribute(IMarker.LINE_NUMBER, loc.getLine());
//
//				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
//
//				// editor opened --- get rid of goto marker
//				aadlResource.deleteMarkers(AadlConstants.AADLTEXTGOTOMARKER,
//						false, IResource.DEPTH_ZERO);
//			} catch (CoreException e) {
//				OsateUiPlugin.log(e);
//			}
//		}
//	}

	/**
	 * Open an object editor for the given model object. Ensures that the editor
	 * is the front editor, and is the active workbench component. Enters
	 * entries into the Eclipse log if the editor could not be opened.
	 *
	 * @param obj
	 *            The object to open the editor for. The editor is opened on the
	 *            resource that contains the object.
	 * @return The editing domain for the Resource if the editor was opened;
	 *         <code>null</code> if the editor was not able to be opened.
	 */
	public static final EditingDomain openEditorFor(final Element obj) {
		final IFile file = OsateResourceUtil.toIFile(obj.eResource().getURI());
		if (openEditor(OsateUiPlugin.getActiveWorkbenchPage(), file, true)) {
			return AdapterFactoryEditingDomain.getEditingDomainFor(obj);
		} else {
			return null;
		}
	}

	/**
	 * Execute the given command using the editing domain for the given model
	 * object. This is preferrable to calling
	 * <code>editingDomain.getCommandStack().execute(command)</code> directly
	 * because it makes sure that the appropriate resource is locked in the
	 * eclipse workspace. The command is not executed if the Eclipse IResource
	 * for the given object cannot be found, or if the editing domain is not
	 * found. In either of these cases a error message is written to the Eclipse
	 * log.
	 *
	 * @param obj
	 *            The AADL model object from which the editing domain is
	 *            derived.
	 * @param command
	 *            The editor command to execute.
	 */
	public static final void executeCommand(final Element obj, final Command command) {
		final IFile file = OsateResourceUtil.toIFile(obj.eResource().getURI());
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(obj);
		if (editingDomain != null) {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			try {
				workspace.run((IWorkspaceRunnable) monitor -> editingDomain.getCommandStack().execute(command), file, IWorkspace.AVOID_UPDATE, null);
			} catch (final CoreException e) {
				OsateUiPlugin.log(e);
			}
		} else {
			OsateUiPlugin.logErrorMessage("Couldn't get editing domain for " + obj);
		}
	}

	/**
	 * Open an object editor for the given model object and executes the
	 * given command in the associated editing domain. Ensures that the editor
	 * is the front editor, and is the active workbench component. Enters
	 * entries into the Eclipse log if the editor could not be opened or if
	 * the editing domain could not be retreived.  The command is executed
	 * with the Eclipse IResource for the given object locked.
	 *
	 * @param obj
	 *            The object to open the editor for. The editor is opened on the
	 *            resource that contains the object.
	 * @param command
	 *            The editor command to execute.
	 */
	public static final void openEditorAndExecute(final Element obj, final Command command) {
		final IFile file = OsateResourceUtil.toIFile(obj.eResource().getURI());
		if (openEditor(OsateUiPlugin.getActiveWorkbenchPage(), file, true)) {
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(obj);
			if (editingDomain != null) {
				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				try {
					workspace.run((IWorkspaceRunnable) monitor -> editingDomain.getCommandStack().execute(command), file, IWorkspace.AVOID_UPDATE, null);
				} catch (final CoreException e) {
					OsateUiPlugin.log(e);
				}
			} else {
				OsateUiPlugin.logErrorMessage("Couldn't get editing domain for " + obj);
			}
		}
	}

	/**
	 * Returns a label provider similar to the one used by the aadl object editor.
	 * Use this method when you want an <code>org.eclipse.jface.viewers.Viewer</code>
	 * to display the same text labels and icons as the object editor.
	 *
	 * @return A label provider that returns standard labels and icons for AObjects.
	 */
	public static final AdapterFactoryLabelProvider getModelElementLabelProvider() {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(getAdapterFactory());
		}
		return labelProvider;
	}

	/**
	 * Returns a content provider similar to the one used by the aadl object editor.
	 * Use this method when you want an <code>org.eclipse.jface.viewers.TreeViewer</code>
	 * to display the same contents as the object editor.
	 *
	 * @return A content provider that is used for displaying the standard hierarchical contents of an AObject.
	 */
	public static final AdapterFactoryContentProvider getModelElementContentProvider() {
		if (contentProvider == null) {
			contentProvider = new AdapterFactoryContentProvider(getAdapterFactory());
		}
		return contentProvider;
	}

	/**
	 * Returns an adapter factory that can be used to create content providers, label
	 * providers, editing domains, etc.  The adapter factory is composed a
	 * {@link ResourceItemProviderAdapterFactory}, a {@link ComponentItemProviderAdapterFactory},
	 * a {@link FeatureItemProviderAdapterFactory}, a {@link CoreItemProviderAdapterFactory},
	 * an {@link InstanceItemProviderAdapterFactory}, a {@link PropertyItemProviderAdapterFactory},
	 * a {@link FlowItemProviderAdapterFactory}, a {@link ConnectionItemProviderAdapterFactory},
	 * and a {@link ReflectiveItemProviderAdapterFactory}.
	 *
	 * @return An adapter factory composed of the AADL adapter factories.
	 */
	public static final ComposedAdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			ArrayList<ComposeableAdapterFactory> factories = new ArrayList<ComposeableAdapterFactory>();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new Aadl2ItemProviderAdapterFactory());
			factories.add(new InstanceItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());
			adapterFactory = new ComposedAdapterFactory(factories);
		}
		return adapterFactory;
	}

	public static String BestDecPoint(double value) {
		if (value < 1) {
			return String.format("%.3f", value);
		} else if (value < 10) {
			return String.format("%.2f", value);
		} else {
			return String.format("%.1f", value);
		}
	}

	public static String OneDecPoint(double value) {
		return String.format("%.1f", value);
	}

	public static String TwoDecPoint(double value) {
		return String.format("%.2f", value);
	}
}