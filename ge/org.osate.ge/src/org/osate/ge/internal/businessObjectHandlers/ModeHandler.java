package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.graphics.ModeGraphicBuilder;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeHandler {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1).first());
	private Graphic initialModeGraphic = ModeGraphicBuilder.create().initialMode().lineWidth(2).build();
	private Graphic modeGraphic = ModeGraphicBuilder.create().lineWidth(2).build();	
	private LabelConfiguration labelConfiguration = LabelConfigurationBuilder.create().center().build();
		
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof ComponentClassifier;
		if(!applicable) {
			return null;
		}
			
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().label("Mode").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getMode())).category(Categories.MODES).build()
		};
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Mode mode,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		return GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(mode)).
				defaultLabelConfiguration(labelConfiguration).
				defaultForeground(AadlInheritanceUtil.isInherited(boc) ? Colors.INHERITED_ELEMENT_COLOR : null).
				build();
	}
	
	private Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return mode.isInitial() ? initialModeGraphic : modeGraphic;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return mode.getName();
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) ComponentClassifier classifier) {		
		return true;
	}
	
	@Create
	public Mode createBusinessObject(@Named(Names.OWNER_BO) final ComponentClassifier classifier, final NamingService namingService) {
		final String newModeName = namingService.buildUniqueIdentifier(classifier, "new_mode");
		
		final Mode newMode = classifier.createOwnedMode();
		newMode.setInitial(false);
		newMode.setName(newModeName);
		
		// Clear the no modes flag
		classifier.setNoModes(false);
		
		return newMode;
	}

	@ValidateName
    public String validateName(final @Named(Names.BUSINESS_OBJECT) Mode mode, final @Named(Names.NAME) String value, final NamingService namingService) {
    	return namingService.checkNameValidity(mode, value);
    }
	
	@CanRename
	@CanDelete
    public boolean canEdit(final @Named(Names.BUSINESS_OBJECT) Mode mode, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final Object containerBo = queryService.getFirstBusinessObject(parentQuery, boc);
		return mode.getContainingClassifier() == containerBo;
    }
    
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) Mode mode, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(mode, value);
	}
}
