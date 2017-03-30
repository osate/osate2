package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.GetDefaultLabelConfiguration;
import org.osate.ge.internal.graphics.ModeGraphicBuilder;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeHandler {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1).first());
	private Graphic initialModeGraphic = ModeGraphicBuilder.create().initialMode().lineWidth(2).build();
	private Graphic modeGraphic = ModeGraphicBuilder.create().lineWidth(2).build();	
	private LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().center().build();
		
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ComponentClassifier classifier) {				
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().label("Mode").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getMode())).category(Categories.MODES).build()
		};
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return mode.isInitial() ? initialModeGraphic : modeGraphic;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return mode.getName();
	}
	
	@GetDefaultLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
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
