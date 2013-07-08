package edu.uah.rsesc.aadl.age.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagram.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.editor.AgeDiagramEditor;

/**
 * Class that provided methods for finding diagrams representing AADL model elements in the current eclipse workspace
 * @author philip.alldredge
 *
 */
// TODO: Need to take project references into account?
public class DiagramFinder {
	/**
	 * Finds resources containing diagrams that represent the specified AADL element
	 * @param ne the named element for which to find diagram resources.
	 * @return a list containing resources containing diagrams for the specified AADL element
	 */
	public List<Resource> findDiagramResources(final NamedElement ne) {
		return findDiagramResources(ne.getQualifiedName());
	}
	
	/**
	 * Finds resources containing diagrams that represent the specified AADL element
	 * @param aadlElementName the qualified name of the AADL element for which to look for diagram
	 * @return a list containing resources containing diagrams for the specified AADL element
	 */
	public List<Resource> findDiagramResources(final String aadlElementName) {
		final List<IFile> files = findDiagrams(ResourcesPlugin.getWorkspace().getRoot(), null);
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		final List<Resource> matchingDiagramResources = new ArrayList<Resource>();
		for(final IFile file : files) {
			// Load the EMF Resource
			final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			final Resource resource = resourceSet.getResource(uri, true);
			if(resource != null) {
				for(final EObject obj : resource.getContents()) {
					if(obj instanceof Diagram) {
						final Diagram diagram = (Diagram)obj;
						
						// Create a feature provider and check if it is linked to the aadl element
						final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
						if(featureProvider != null) {
							final Object bo = AadlElementWrapper.unwrap(featureProvider.getBusinessObjectForPictogramElement(diagram));
							if(bo != null && bo instanceof NamedElement) {
								if(((NamedElement)bo).getQualifiedName().equalsIgnoreCase(aadlElementName)) {
									matchingDiagramResources.add(resource);	
								}
							}
						}
					}					
					
				}
			}
		}		
		
		return matchingDiagramResources;
	}
	
	/**
	 * Finds all files with the diagram extension in the specified container and its children
	 * @param container the container in which to look for diagrams
	 * @param diagramFiles a list to which to add the results. Optional.
	 * @return diagramFiles if specified otherwise, a newly created list containing the results
	 */
	private List<IFile> findDiagrams(final IContainer container, List<IFile> diagramFiles) {
		if(diagramFiles == null) {
			diagramFiles = new ArrayList<IFile>();
		}
		
		try {
			if(container.isAccessible()) {
				for(final IResource resource : container.members()) {
					 if (resource instanceof IContainer) {
				         findDiagrams((IContainer)resource, diagramFiles);
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
