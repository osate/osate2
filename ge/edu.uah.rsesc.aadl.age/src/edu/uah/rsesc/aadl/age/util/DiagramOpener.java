package edu.uah.rsesc.aadl.age.util;

import java.io.IOException;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

/**
 * Class responsible for providing a mechanism for opening and creating diagrams for AADL model elements
 * @author philip.alldredge
 *
 */
public class DiagramOpener {
	/**
	 * The diagram finder is used to find diagrams when determining whether to open or create a diagram for a model element
	 */
	private DiagramFinder diagramFinder;
	
	/**
	 * Constructs the diagram opener
	 * @param diagramFinder the diagram finder to use to look for diagrams
	 */
	public DiagramOpener(final DiagramFinder diagramFinder) {
		this.diagramFinder = diagramFinder;
	}
	
	/**
	 * Create a new DiagramOpener using a new DiagramFinder
	 * @return a new DiagramOpener
	 */
	public static DiagramOpener create() {
		return new DiagramOpener(new DiagramFinder());
	}
	/**
	 * Opens the first found existing diagram for an element. If a diagram is not found, a diagram of the appropriate type is created.
	 * @param element the element for which to open/create the diagram
	 */
	public void openOrCreateDiagram(final NamedElement element) {
		// Look for an existing diagram
		final List<Resource> diagramResources = diagramFinder.findDiagramResources(element);
		if(diagramResources.size() == 0) {
			// If a diagram can not be found, create a new diagram
			Log.info("Existing diagram not found.");
			
			// Create and open the new resource
			final Resource diagramResource = createNewDiagram(element);
			openEditor(diagramResource);
		} else {
			// Open the first resource.
			Log.info("Existing diagram found. Opening...");
			openEditor(diagramResources.get(0));
		}
	}
	
	/**
	 * Creates a new diagram for the specified element
	 * @param namedElement the element for which to create the diagram 
	 * @return the new resource containing the created diagram
	 */
	private Resource createNewDiagram(final NamedElement namedElement) {
		// Determine the diagram type id
		final String diagramTypeId = getDiagramTypeId(namedElement);
		Log.info("Creating diagram of type '" + diagramTypeId + "' for model element '" + namedElement.getName() + "'");
		
		// Get the default resource set to hold the new resource
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resourceSet);
		boolean editingDomainCreated = false;
		if(editingDomain == null) {
			Log.info("Creating a editing domain");
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
			editingDomainCreated = true;
		}
		
		// Create the diagram and its file
		final IPeService peService = Graphiti.getPeService();
		final Diagram diagram = peService.createDiagram(diagramTypeId, namedElement.getQualifiedName(), true);
		
		final PictogramLink link = PictogramsFactory.eINSTANCE.createPictogramLink();
		link.getBusinessObjects().add(namedElement);
		diagram.setLink(link);
		
		// Create a resource to hold the diagram	
		final Resource createdResource = createDiagramResource(editingDomain.getResourceSet(), buildBaseFilename(namedElement));
		
		// Store the diagram in the resource
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				createdResource.getContents().add(diagram);
			}			
		});		
		
		try {
			createdResource.save(null);
		} catch (IOException e) {
			throw new RuntimeException("Error saving new diagram");
		}
		
		// Dispose of the editing domain if we created it
		if(editingDomainCreated) {
			editingDomain.dispose();
		}
		
		return createdResource;
	}
	
	/**
	 * Creates a new resource to hold a new diagram.  
	 * @param resourceSet the resource set that will contain the new resource.
	 * @param baseFilename the desired filename of the file that will store the resource. The method will adjust the filename to avoid overwriting an existing file.
	 * @return the resource containing the new diagram
	 */
	private Resource createDiagramResource(final ResourceSet resourceSet, final String baseFilename) { 
		boolean retry;
		String suffix = "";
		int tryCount = 1;
		Resource createdResource = null;
		
		do
		{
			retry = false;
			final IFolder diagramFolder = SelectionHelper.getProject().getFolder("diagrams/");
			final IFile diagramFile = diagramFolder.getFile(baseFilename + suffix + ".diagram");
			final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			
			// Try to get the resource in case it is already in the resource set, otherwise create a new one
			createdResource = resourceSet.getResource(uri, false);
			if(createdResource == null) {
				createdResource = resourceSet.createResource(uri);	
			} else {
				if(createdResource.isLoaded()) {
					if(resourceSet.getURIConverter().exists(uri, null)) {
						retry = true;
						tryCount++;
						suffix = Integer.toString(tryCount);
						continue;
					}
				}
				createdResource.unload();
			}
		} while(retry);
		
		return createdResource;
	}
	
	/**
	 * Builds the base part of the filename for a named element. 
	 * @param namedElement the element to build the base filename for
	 * @return the base filename for the element. The base filename is the filename without any suffixes or extension.
	 */
	private String buildBaseFilename(final NamedElement namedElement) {
		return namedElement.getQualifiedName().replace("::",  "__").replace('.', '_');
	}
	
	/**
	 * Opens a diagram editor for the specified resource.
	 * @param resource the resource to edit. Must contain a diagram object.
	 */
	private void openEditor(final Resource resource) {
		if(resource.getContents().size() == 0) {
			throw new RuntimeException("Error opening editor. Resource is empty");
		} else {
			final Diagram diagram = (Diagram)resource.getContents().get(0); 
			final String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());	
			final DiagramEditorInput editorInput = DiagramEditorInput.createEditorInput(diagram, providerId);
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, DiagramEditor.DIAGRAM_EDITOR_ID);
			} catch (PartInitException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Determines the diagram type id for the type of diagram used to edit the specified element
	 * @param element the element for which to lookup the diagram type. AadlPackage, ComplementImplementation, ComponentClassifier, and FeatureGroupType objects are supported
	 * @return the diagram type id
	 */
	private String getDiagramTypeId(final NamedElement element) {
		if(element instanceof AadlPackage) {
			return "AADL Package";
		} if(element instanceof ComponentImplementation) {
			return "AADL Component Implementation";
		} else if(element instanceof ComponentClassifier || element instanceof FeatureGroupType) {
			return "AADL Type";
		} else {
			throw new RuntimeException("Unexpected named element type: " + element.getClass().getSimpleName());
		}
	}
}
