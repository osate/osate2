package org.osate.ge.internal.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.DiagramElementQuery;

public class ModeTransitionHandler {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1).first());
	private static final StandaloneDiagramElementQuery componentClassifierQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier).first());
	private static final Graphic graphic = ConnectionBuilder.create().curved().destinationTerminator(ArrowBuilder.create().small().build()).build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ComponentClassifier classifier) {				
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().connectionCreation().label("Mode Transition").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getModeTransition())).category(Categories.MODES).build()
		};
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return mt.getName() == null ? "" : mt.getName(); 
	}
	
	@CreateParentQuery
	public DiagramElementQuery<ModeTransition> createParentDiagramElementQuery(final @Named(Names.SOURCE_ROOT_QUERY) DiagramElementQuery<ModeTransition> srcRootQuery) {
		// Find the subcomponent or component classifier that owns the mode transition connection.
		return srcRootQuery.ancestor(1).filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier || fa.getBusinessObject() instanceof Subcomponent).first();
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<ModeTransition> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<ModeTransition> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject((mt) -> mt.getSource());
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<ModeTransition> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<ModeTransition> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject((mt) -> mt.getDestination());
	}
	
	private ComponentClassifier getComponentClassifier(final DiagramElementProxy modeDiagramElement, final QueryService queryService) {
		return (ComponentClassifier)queryService.getFirstBusinessObject(componentClassifierQuery, modeDiagramElement);
	}
	
	@GetCreateOwner
	public ComponentClassifier getCreateConnectionOwner(@Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy srcDiagramElement, 
			final QueryService queryService) {
		return getComponentClassifier(srcDiagramElement, queryService);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Mode mode, 
			@Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy srcDiagramElement, 
			final QueryService queryService) {
		final ComponentClassifier cc = getCreateConnectionOwner(srcDiagramElement, queryService);
		return cc != null && !cc.isDerivedModes();
	}	
	
	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BO) final Object srcMode, 
			@Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy srcDiagramElement, 
			@Named(Names.DESTINATION_BO) final Object dstMode,
			@Named(InternalNames.DESTINATION_DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy dstDiagramElement, 
			final QueryService queryService) {		
		return getComponentClassifier(srcDiagramElement, queryService) == getComponentClassifier(dstDiagramElement, queryService);
	}

	@Create
	public ModeTransition createBusinessObject(@Named(Names.OWNER_BO) final ComponentClassifier cc, 
			@Named(Names.SOURCE_BO) final Mode srcMode, 
			@Named(Names.DESTINATION_BO) final Mode dstMode, 
			final NamingService namingService) {
		// Determine the name for the new mode transition
		final String newElementName = namingService.buildUniqueIdentifier(cc, "new_transition");
		
		// Prompt for transition triggers
		final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog.promptForTriggers(cc, null);
		if(selectedTriggers == null) {
			return null;
		}
		
		// Create the new mode transition
		final ModeTransition newModeTransition = cc.createOwnedModeTransition();
		
		// Clear the no modes flag
		cc.setNoModes(false);
		
		// Set the name
		newModeTransition.setName(newElementName);
		
		// Set the source and destination
		newModeTransition.setSource(srcMode);
		newModeTransition.setDestination(dstMode);
		
		// Create Triggers
		for(ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
			final ModeTransitionTrigger mtt = newModeTransition.createOwnedTrigger();
			mtt.setTriggerPort(selectedPort.port);
			mtt.setContext(selectedPort.context);
		}
		
		return newModeTransition;
	}

	@CanRename
	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		final Object containerBo = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return mt.getContainingClassifier() == containerBo;
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(mt, value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(mt, value);
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return mt.getOwnedTriggers().stream();
	}
}
