/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.imv.aadldiagram.viewer.AadlDiagramViewerListener;
import org.osate.imv.aadldiagram.viewer.AadlPersistentDiagramViewer;
import org.osate.imv.image.AutoImageType;
import org.osate.imv.image.ImageSaver;
import org.osate.imv.model.FlowHighlighter;
import org.osate.imv.model.IImvModelProvider;
import org.osate.imv.model.ImvModelProvider;
import org.osate.imv.osate.delegates.OsateFlowHighlighterDelegate;
import org.osate.imv.osate.filters.ComponentFilter;
import org.osate.imv.osate.filters.FeatureFilter;
import org.osate.imv.osate.filters.ModeFilter;
import org.osate.imv.persistence.XmlAadlAdapterRestorerDelegate;
import org.osate.imv.persistence.XmlAadlAdapterSaverDelegate;
import org.osate.imv.providers.OsateAdapterProvider;
import org.osate.imv.providers.OsateContentProvider;
import org.osate.imv.ui.actions.AutoImageAction;
import org.osate.imv.ui.actions.AutoImageSaveNowAction;
import org.osate.imv.ui.actions.SaveImageAsAction;
import org.osate.imv.ui.outline.ImvContentOutlinePage;
import org.osate.workspace.WorkspacePlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ImvInstanceEditor extends EditorPart implements ISelectionListener, PropertyChangeListener, AadlDiagramViewerListener {

	// ID
	public static final String ID = "org.osate.imv.ui.editor";

	// Content outline page used by the editor's outline view.
	private ImvContentOutlinePage outlinePage;

	// The system instance associated with the editor.
	private SystemInstance si;
	private AadlPackage pkg;

	private ModeFilter modeFilter;

	private FeatureFilter featureFilter;

	private ComponentFilter componentFilter;

	private Composite parent;

	private Document imvDocument;

	private IFile resourceFile;

	private boolean isDirty;

	private boolean initialized;

	private OsateFlowHighlighterDelegate flowHighlighterDelegate;

	private ImageSaver imageSaver;

	private AadlPersistentDiagramViewer viewer;

	private ImvEditorToolbar toolbar;

	private IImvModelProvider modelProvider;

	// Default no-arg constructor.
	public ImvInstanceEditor() {
		this.isDirty = true;
		this.initialized = false;
	}

	@Override
	public void dispose() {
		this.removePropertyListeners();

		this.getModelProvider().dispose();

		if (this.toolbar != null)
			this.toolbar.dispose();

		this.getSite().setSelectionProvider(null);
		this.getSite().getPage().removeSelectionListener(this);

		this.viewer.removeAadlDiagramViewerListener(this);
		this.viewer.dispose();

		// We need to unload the resource so that any changes will be reloaded
		// when the editor is opened again.
		if (si != null)
			this.si.eResource().unload();
		if (pkg != null)
			this.pkg.eResource().unload();

		super.dispose();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(input.getName());

		FileEditorInput fileInput = (FileEditorInput) input;
		resourceFile = fileInput.getFile();
		String fileName = resourceFile.getName();
		IPath imvPath = resourceFile.getFullPath();
		IPath instancePath = imvPath.removeFileExtension().removeLastSegments(2);
		String instanceFileName = fileName.substring(0, fileName.indexOf('.') );
		
		if (instanceFileName.endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX))
		{
			instancePath = instancePath.append("instances").append(instanceFileName).addFileExtension(WorkspacePlugin.INSTANCE_FILE_EXT);
		} 
		else 
		{
			// TODO check about aadl2 extension
			instancePath = instancePath.append(instanceFileName).addFileExtension(WorkspacePlugin.SOURCE_FILE_EXT);
		}
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
		if (resourceSet != null) 
		{
			Resource r = null;
			try
			{
				r = resourceSet.getResource(URI.createPlatformResourceURI(instancePath.toString(), false), true);
			} catch (Exception e)
			{
				instancePath = instancePath.removeFileExtension().addFileExtension(WorkspacePlugin.SOURCE_FILE_EXT2);
				try
				{
					r = resourceSet.getResource(URI.createPlatformResourceURI(instancePath.toString(), false), true);
				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
			Object root = r.getContents().get(0);
			if (root instanceof SystemInstance) 
			{
				si = (SystemInstance) root;
			}
			if (root instanceof AadlPackage) 
			{
				pkg = (AadlPackage) root;
			}

			try 
			{
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				if (resourceFile.exists())
				{
					// Create Document object from file.
					imvDocument = docBuilder.parse(resourceFile.getContents());
					imvDocument.getDocumentElement().normalize();
				}
				else
				{
					// Create empty document object.
					imvDocument = docBuilder.newDocument();

					// Create root element.
					if (si != null)
					{
						Element rootElement = imvDocument.createElement("instance");
						rootElement.setAttribute("name", si.getFullName());
						imvDocument.appendChild(rootElement);
					} 
					else 
					{
						Element rootElement = imvDocument.createElement("package");
						rootElement.setAttribute("name", pkg.getFullName());
						imvDocument.appendChild(rootElement);
					}

					// write the content into xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(imvDocument);
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					StreamResult result = new StreamResult(outputStream);
					// Write document to output stream.
					transformer.transform(source, result);

					resourceFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true, null);
				}

				initialized = true;

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

	}

	public void createPartControl(Composite parent) {
		this.parent = parent;

		if(this.initialized) {
			// We will use grid layout to replicate a border type
			// layout (border layout is not supported by SWT).
			// We will use grid layout for this composite.
			GridLayout gridLayout = new GridLayout(1, false);
			gridLayout.marginHeight = 0;
			parent.setLayout(gridLayout);

			// Create and add editor toolbar.
			this.toolbar = addToolbar();

			// Create and add MevViewer.
			this.viewer = addViewer();

			toolbar.setMevViewer(this.viewer);

			// Setup filters.
			setupFilters();

			this.imageSaver = new ImageSaver((IFileEditorInput)this.getEditorInput(), this.viewer);

			registerPropertyListeners();

			// Set input to viewer.
			//XXX TODO si is null when we open a package
			viewer.setInput(si);
			this.isDirty = false;
		}

		createPopupMenu();
	}

	private void createPopupMenu() {
		// Top level menu.
		MenuManager menuMgr = new MenuManager("ImvPopup");

		// Save as action.
		SaveImageAsAction saveAsAction = new SaveImageAsAction(this.imageSaver);
		menuMgr.add(saveAsAction);

		// Automatic Image menu
		MenuManager autoImageMenu = new MenuManager("Automatic Image", "automaticImageMenu");
		menuMgr.add(autoImageMenu);

		// Save now action.
		AutoImageSaveNowAction saveNowAction = new AutoImageSaveNowAction(this.imageSaver);
		autoImageMenu.add(saveNowAction);

		// Add separator.
		autoImageMenu.add(new Separator());

		// Auto image actions.
		IWorkbenchAction noneAction = new AutoImageAction(AutoImageType.NONE, imageSaver);
		IWorkbenchAction pngAction = new AutoImageAction(AutoImageType.PNG, imageSaver);
		IWorkbenchAction jpgAction = new AutoImageAction(AutoImageType.JPG, imageSaver);

		GroupMarker imageTypeGroup = new GroupMarker("Image Type Group");

		autoImageMenu.add(imageTypeGroup);

		// Add auto image actions to group.
		autoImageMenu.appendToGroup("Image Type Group", noneAction);
		autoImageMenu.appendToGroup("Image Type Group", pngAction);
		autoImageMenu.appendToGroup("Image Type Group", jpgAction);

		Control control = this.viewer.getAadlDiagram();
		// Create popup menu.
		Menu popup = menuMgr.createContextMenu(control);
		// We want the popup to be displayed when the user right clicks on the aadl diagram.
		control.setMenu(popup);
	}

	protected AadlPersistentDiagramViewer addViewer() {
		Composite viewerContainer = new Composite(parent, SWT.NONE);
		viewerContainer.setLayout(new FillLayout());

		// Layout data for the viewer.
		GridData viewerLayoutData = new GridData(GridData.FILL_BOTH);
		viewerContainer.setLayoutData(viewerLayoutData);

		// Create MEV viewer to display AADL figures.
		AadlPersistentDiagramViewer viewer = new AadlPersistentDiagramViewer(viewerContainer);
		// Set delegate.
		viewer.addAadlDiagramViewerListener(this);
		// Label provider.
		viewer.setContentProvider(new OsateContentProvider());
		// Content provider.
		viewer.setAdapterProvider(new OsateAdapterProvider());
		// Delegate for saving the state of the diagram.
		viewer.setSaverDelegate(new XmlAadlAdapterSaverDelegate(this.imvDocument));
		// Delegate for restoring the state of the diagram.
		viewer.setRestorerDelegate(new XmlAadlAdapterRestorerDelegate(imvDocument));

		flowHighlighterDelegate = new OsateFlowHighlighterDelegate();
		viewer.setFlowHighlighterDelegate(flowHighlighterDelegate);

		// Add MEV viewer as a selection provider to the workbench site.
		getSite().setSelectionProvider(viewer);
		// Register this view as a selection listener.
		getSite().getPage().addSelectionListener(this);

		return viewer;
	}

	protected void registerPropertyListeners() {
		// Add property change listener for mode changes.
		this.getModelProvider().addPropertyChangeListener(IImvModelProvider.CURRENT_MODE_PROPERTY, this);
	}

	protected void removePropertyListeners() {
		// Remove property change listeners for flow highlighters.
		for (Iterator<FlowHighlighter> it = this.getModelProvider().getFlowHighlighters().iterator(); it.hasNext();) {
			FlowHighlighter fh = it.next();
			fh.removePropertyChangeListener(FlowHighlighter.HIGHLIGHT_PROPERTY, this);
			fh.removePropertyChangeListener(FlowHighlighter.COLOR_PROPERTY, this);
		}

		// Remove property change listener for mode changes.
		this.getModelProvider().removePropertyChangeListener(IImvModelProvider.CURRENT_MODE_PROPERTY, this);
	}

	protected ImvEditorToolbar addToolbar() {
		ImvEditorToolbar toolbar = new ImvEditorToolbar(this.parent);
		// Layout data for the toolbar.
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.heightHint = 21;
		toolbar.setLayoutData(layoutData);

		return toolbar;
	}

	protected void setupFilters() {
		// Create and add mode filter.
		modeFilter = new ModeFilter();
		viewer.addFilter(modeFilter);

		// Create and add component filter.
		componentFilter = new ComponentFilter(this.getModelProvider().getComponentInhibitList(), viewer);
		viewer.addFilter(componentFilter);

		// Create and add feature filter.
		featureFilter = new FeatureFilter(this.getModelProvider().getFeatureInhibitList(), viewer);
		viewer.addFilter(featureFilter);
	}

	protected void editorIsDirty(boolean isDirty) {
		this.isDirty = isDirty;
		this.firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	protected void saveEditorState() {

		this.imageSaver.forceAutomaticSave();

		try {
			this.viewer.save();

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;

			transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(imvDocument);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(outputStream);
			// Write document to output stream.
			transformer.transform(source, result);

			resourceFile.setContents(new ByteArrayInputStream(outputStream.toByteArray()), true, false, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.isDirty = false;
		this.firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		saveEditorState();
	}

	@Override
	public boolean isDirty() {
		return this.isDirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// "Save As" operation is NOT allowed.
		return false;
	}

	@Override
	public void doSaveAs() {
		// Explicitly do nothing.
	}

	@Override
	public void setFocus() {
		if(this.viewer != null)
			this.viewer.getControl().setFocus();
	}

	public SystemInstance getSystemInstance() {
		return si;
	}

	public AadlPackage getAadlPackage() {
		return pkg;
	}

	public IImvModelProvider getModelProvider() {
		if (modelProvider == null) {
			if (this.getSystemInstance() != null){
			modelProvider = new ImvModelProvider(this.getSystemInstance());
			} else {
				// it is a package
				modelProvider = new ImvModelProvider(null);
			}
		}
		return modelProvider;
	}

	public Object getAdapter(Class required) {
		if(!this.initialized)
			return null;

		if (IContentOutlinePage.class.equals(required)) {
			if (outlinePage == null) {
				outlinePage = new ImvContentOutlinePage(this);
			}
			return outlinePage;
		} else if(IImvModelProvider.class.equals(required)) {
			return this.getModelProvider();
		}
		return super.getAdapter(required);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part == null || selection == null)
			return;

		if (!(selection instanceof IStructuredSelection))
			return;

		Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
		if (selectedObject == null)
			return;

		if (part instanceof ContentOutline) {
			IPage currentPage = ((ContentOutline)part).getCurrentPage();
			if(currentPage != null && currentPage == this.outlinePage) {
				// Set this object to the active element in the MEV.
				if(viewer != null)  viewer.setInput(selectedObject);
			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if (propertyName.equals(FlowHighlighter.HIGHLIGHT_PROPERTY) || propertyName.equals(FlowHighlighter.COLOR_PROPERTY)) {

			if (viewer != null)
				viewer.runFilters();

		} else if (propertyName.equals(IImvModelProvider.CURRENT_MODE_PROPERTY)) {
			Mode newMode = (Mode) event.getNewValue();

			if (modeFilter != null && !modeFilter.getCurrentMode().equals(newMode)) {
				modeFilter.setCurrentMode(newMode);
				flowHighlighterDelegate.setCurrentMode(newMode);
				if (viewer != null)
					viewer.runFilters();
			}
		}
	}

	@Override
	public void inputElementWillChange(Object currentElement, Object newElement) {
		NamedElement component = (NamedElement) newElement;

		// Remove property change listeners for flow highlighters.
		for (Iterator<FlowHighlighter> it = this.getModelProvider().getFlowHighlighters().iterator(); it.hasNext();) {
			FlowHighlighter fh = it.next();
			fh.removePropertyChangeListener(FlowHighlighter.HIGHLIGHT_PROPERTY, this);
			fh.removePropertyChangeListener(FlowHighlighter.COLOR_PROPERTY, this);
		}


		this.getModelProvider().setContainerComponent(component);

		// Add property change listeners for flow highlighters.
		for (Iterator<FlowHighlighter> it = this.getModelProvider().getFlowHighlighters().iterator(); it.hasNext();) {
			FlowHighlighter highlighter = it.next();
			highlighter.addPropertyChangeListener(FlowHighlighter.HIGHLIGHT_PROPERTY, this);
			highlighter.addPropertyChangeListener(FlowHighlighter.COLOR_PROPERTY, this);
		}

		flowHighlighterDelegate.setCurrentMode(this.getModelProvider().getCurrentMode());
		flowHighlighterDelegate.setHighlighters(this.getModelProvider().getFlowHighlighters());
		modeFilter.setCurrentMode(this.getModelProvider().getCurrentMode());
	}

	@Override
	public void inputElementChanged(Object newElement) {
		// Explicitly do nothing.
	}

	@Override
	public void figureMoved(IFigure source) {
		editorIsDirty(true);
	}

}
