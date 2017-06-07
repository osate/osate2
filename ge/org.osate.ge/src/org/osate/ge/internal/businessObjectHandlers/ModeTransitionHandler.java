package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionHandler {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1).first());
	private static final StandaloneQuery componentClassifierQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier).first());
	private static final Graphic graphic = ConnectionBuilder.create().curved().destinationTerminator(ArrowBuilder.create().small().build()).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference((ModeTransition mt) -> mt.getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference((ModeTransition mt) -> mt.getDestination()));
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof ComponentClassifier;
		if(!applicable) {
			return null;
		}
		
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().connectionCreation().label("Mode Transition").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getModeTransition())).category(Categories.MODES).build()
		};
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				defaultForeground(AadlInheritanceUtil.isInherited(boc) ? Colors.INHERITED_ELEMENT_COLOR : null).
				build();
	}
	
	private BusinessObjectContext getSource(final BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}
	
	private BusinessObjectContext getDestination(final BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return mt.getName() == null ? "" : mt.getName(); 
	}
			
	private ComponentClassifier getComponentClassifier(final BusinessObjectContext modeBoc, final QueryService queryService) {
		return (ComponentClassifier)queryService.getFirstBusinessObject(componentClassifierQuery, modeBoc);
	}
	
	@GetCreateOwner
	public BusinessObjectContext getCreateConnectionOwner(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			final QueryService queryService) {
		return queryService.getFirstResult(componentClassifierQuery, srcBoc);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Mode mode, 
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext modeBoc, 
			final QueryService queryService) {
		final ComponentClassifier cc = getComponentClassifier(modeBoc, queryService);
		return cc != null && !cc.isDerivedModes();
	}	
	
	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BO) final Mode srcMode, 
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			@Named(Names.DESTINATION_BO) final Mode dstMode,
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc, 
			final QueryService queryService) {		
		return getComponentClassifier(srcBoc, queryService) == getComponentClassifier(dstBoc, queryService);
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
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final Object containerBo = queryService.getFirstBusinessObject(parentQuery, boc);
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
}
