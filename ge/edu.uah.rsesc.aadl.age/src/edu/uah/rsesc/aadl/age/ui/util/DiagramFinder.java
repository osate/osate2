package edu.uah.rsesc.aadl.age.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.ui.editor.AgeDiagramBehavior;
import edu.uah.rsesc.aadl.age.ui.editor.AgeDiagramEditor;
import edu.uah.rsesc.aadl.age.util.Log;

/**
 * Class that provided methods for finding diagrams representing AADL model elements in the current eclipse workspace
 * @author philip.alldredge
 *
 */
// TODO: Need to take project references into account?
// TODO: Rename. Servicify
public class DiagramFinder {
	// TODO: Rename
	public static interface DiagramCallback {
		void onDiagram(final Diagram diagram);
	}
	
	// TODO: Need to get diagrams in the existing resource set if they are open. Otherwise modifications will results in needing to refresh
	
	/**
	 * Perform a read-only operation on all diagrams using a callback
	 * @param cb
	 */
	public void readDiagrams(final DiagramCallback cb) {
		for(final Diagram diagram : findDiagrams()) {
			cb.onDiagram(diagram);					
		}		
	}
	
	/**
	 * Returns all diagrams. If a diagram is open it returns the open diagram
	 * @return
	 */
	private List<Diagram> findDiagrams() {
		final List<Diagram> diagrams = new ArrayList<Diagram>();
		final Map<URI, Diagram> openDiagrams = new HashMap<URI, Diagram>();
		
		for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(true);
			if(editor instanceof AgeDiagramEditor) {
				final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editor;
				final AgeDiagramBehavior behavior = (AgeDiagramBehavior)diagramEditor.getDiagramBehavior();
				final Diagram diagram = behavior.getDiagramTypeProvider().getDiagram();
				
				openDiagrams.put(diagram.eResource().getURI(), diagram);
				diagrams.add(diagram);
			}
		}
		
		final List<IFile> files = findDiagramFiles(ResourcesPlugin.getWorkspace().getRoot(), null);
		final ResourceSet resourceSet = new ResourceSetImpl();
		for(final IFile file : files) {
			// Load the EMF Resource
			final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			
			// Check if the diagram is already open
			if(!openDiagrams.containsKey(uri)) {
				// Open the diagram
				final Resource resource = resourceSet.getResource(uri, true);
				if(resource != null) {
					for(final EObject obj : resource.getContents()) {
						if(obj instanceof Diagram) {
							// Add it to the list
							final Diagram diagram = (Diagram)obj;
							diagrams.add(diagram);			
						}											
					}
				}				
			}
		}
		
		return diagrams;
	}
	
	public List<Diagram> findDiagramsByRootBusinessObject(final NamedElement ne) {
		final List<Diagram> matchingDiagrams = new ArrayList<Diagram>();
		final String aadlElementName = ne.getQualifiedName();
		for(final Diagram diagram : findDiagrams()) {
			// Create a feature provider and check if it is linked to the aadl element
			final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
			if(featureProvider != null) {
				final Object bo = AadlElementWrapper.unwrap(featureProvider.getBusinessObjectForPictogramElement(diagram));
				if(bo != null && bo instanceof NamedElement) {
					if(((NamedElement)bo).getQualifiedName().equalsIgnoreCase(aadlElementName)) {
						matchingDiagrams.add(diagram);
					}
				}
			}
		}
		
		return matchingDiagrams;
	}

	/**
	 * Finds all files with the diagram extension in the specified container and its children
	 * @param container the container in which to look for diagrams
	 * @param diagramFiles a list to which to add the results. Optional.
	 * @return diagramFiles if specified otherwise, a newly created list containing the results
	 */
	private List<IFile> findDiagramFiles(final IContainer container, List<IFile> diagramFiles) {
		if(diagramFiles == null) {
			diagramFiles = new ArrayList<IFile>();
		}
		
		try {
			if(container.isAccessible()) {
				for(final IResource resource : container.members()) {
					 if (resource instanceof IContainer) {
				         findDiagramFiles((IContainer)resource, diagramFiles);
				     } else if (resource instanceof IFile) {
				         final IFile file = (IFile) resource;
				         if (file.getName().endsWith(AgeDiagramEditor.EXTENSION)) {
				              diagramFiles.add(file);
				         }
				     }
				}
			}
		} catch (CoreException e) {
			Log.error("Error finding diagrams", e);
			throw new RuntimeException(e);
		}
		
		return diagramFiles;
	}
}
