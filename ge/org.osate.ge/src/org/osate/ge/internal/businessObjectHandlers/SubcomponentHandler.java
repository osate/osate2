package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlArrayUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.AadlSubcomponentUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilderHelper;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.services.QueryService;

public class SubcomponentHandler {
	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext scBoc) {
		return GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(sc, scBoc)).
				style(StyleBuilder.create(
						AadlInheritanceUtil.isInherited(scBoc) ? Styles.INHERITED_ELEMENT : Style.EMPTY,
								getClassifierStyle(sc, scBoc))
						.labelsTop().labelsHorizontalCenter()
						.build())
				.
				build();
	}

	private Graphic getGraphicalRepresentation(final Subcomponent sc,
			final BusinessObjectContext scBoc) {
		final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(scBoc, sc);
		if(cc == null) {
			return AadlGraphics.getGraphic(sc.getCategory());
		} else {
			return AadlGraphics.getGraphic(cc);
		}
	}

	private Style getClassifierStyle(final Subcomponent sc, final BusinessObjectContext scBoc) {
		final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(scBoc, sc);
		if (cc == null) {
			return AadlGraphics.getStyle(sc.getCategory(), false);
		} else {
			return AadlGraphics.getStyle(cc);
		}
	}

	// Labels
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc) {
		return getSubcomponentName(sc) + AadlArrayUtil.getDimensionUserString(sc);
	}

	@GetNameForEditing
	public String getNameForEditing(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc) {
		return getSubcomponentName(sc);
	}

	private String getSubcomponentName(final Subcomponent sc) {
		return sc.getName() == null ? "" : sc.getName();
	}

	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if (!BusinessObjectHandlerUtil.diagramSupportsPackageOrClassifiers(diagramBo)) {
			return null;
		}

		// Disable for diagrams which are bound to a ComponentType
		if(diagramBo instanceof ComponentType) {
			return null;
		}

		final List<PaletteEntry> paletteEntries = new ArrayList<>();

		// Create palette entries for each subcomponent class which can be contained in the component implementation
		for (final EClass subcomponentType : AadlSubcomponentUtil.getSubcomponentTypes()) {
			if (diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof ComponentImplementation) {
				paletteEntries.add(PaletteEntryBuilder.create().
						label(StringUtil.camelCaseToUser(subcomponentType.getName())).
						icon(ImageHelper.getImage(subcomponentType.getName())).
						category(Categories.SUBCOMPONENTS).context(subcomponentType).
						build());
			}
		}

		return paletteEntries.toArray(new PaletteEntry[paletteEntries.size()]);
	}

	private static OperationBuilderHelper<ComponentImplementation> getClassifierOpBuilder(
			final EClass subcomponentType) {
		return OperationBuilderHelper.componentImplementations()
				.filter(ci -> AadlSubcomponentUtil.canContainSubcomponentType(ci, subcomponentType));
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Element bo,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType) {
		return getClassifierOpBuilder(subcomponentType).canBuildOperation(bo);
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(final @Named(Names.TARGET_BO) Element targetBo,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType,
			final QueryService queryService, final NamingService namingService) {
		return Operation.create(createOp -> {
			getClassifierOpBuilder(subcomponentType).buildOperation(createOp, targetBo)
			.modifyPreviousResult(owner -> {
				final String name = namingService.buildUniqueIdentifier(owner, "new_subcomponent");
				final Subcomponent sc = AadlSubcomponentUtil.createSubcomponent(owner, subcomponentType);
				sc.setName(name);

				// Reset the no subcomponents flag
				owner.setNoSubcomponents(false);

				return StepResultBuilder.create().showNewBusinessObject(targetBoc, sc).build();
			});
		});
	}

	// Renaming
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(sc, value);
	}
}
