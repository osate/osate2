package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
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
import org.osate.ge.internal.CreateOperation;
import org.osate.ge.internal.CreateOperation.CreateStepResult;
import org.osate.ge.internal.di.BuildCreateOperation;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlArrayUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.AadlSubcomponentUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
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
		final ComponentImplementation ci = diagramBo instanceof ComponentImplementation ? (ComponentImplementation)diagramBo : null;

		// Create palette entries for each subcomponent class which can be contained in the component implementation
		for (final EClass subcomponentType : AadlSubcomponentUtil.getSubcomponentTypes()) {
			if (ci == null || AadlSubcomponentUtil.canContainSubcomponentType(ci, subcomponentType)) {
				paletteEntries.add(PaletteEntryBuilder.create().
						label(StringUtil.camelCaseToUser(subcomponentType.getName())).
						icon(ImageHelper.getImage(subcomponentType.getName())).
						category(Categories.SUBCOMPONENTS).context(subcomponentType).
						build());
			}
		}

		return paletteEntries.toArray(new PaletteEntry[paletteEntries.size()]);
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Element bo,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType) {
		return getPotentialOwners(bo, subcomponentType).size() > 0 || bo instanceof Subcomponent;
	}

	@BuildCreateOperation
	public void buildCreateOperation(@Named(InternalNames.OPERATION) final CreateOperation createOp,
			final @Named(Names.TARGET_BO) Element targetBo,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType,
			final QueryService queryService, final NamingService namingService) {

		if (targetBo instanceof Subcomponent) {
			final Subcomponent tmpSc = (Subcomponent) targetBo;
			if (!(tmpSc.getClassifier() instanceof ComponentImplementation)) {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Component Implementation Not Set",
						"The subcomponent '" + tmpSc.getQualifiedName()
						+ "' does not have a component implementation set. Set a component implementation before creating a subcomponent.");
				return;
			}
		}
		// Determine which classifier should own the new element
		final ComponentImplementation selectedClassifier = (ComponentImplementation) ClassifierEditingUtil
				.getClassifierToModify(getPotentialOwners(targetBo, subcomponentType));
		if (selectedClassifier == null) {
			return;
		}

		// Create the subcomponent
		createOp.addStep(selectedClassifier, (resource, owner) -> {
			final String name = namingService.buildUniqueIdentifier(owner, "new_subcomponent");
			final Subcomponent sc = AadlSubcomponentUtil.createSubcomponent(owner, subcomponentType);
			sc.setName(name);

			// Reset the no subcomponents flag
			owner.setNoSubcomponents(false);

			return new CreateStepResult(targetBoc, sc);
		});
	}

	private static List<ComponentImplementation> getPotentialOwners(final Element bo,
			final EClass subcomponentType) {
		if (bo instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) bo;
			if (AadlSubcomponentUtil.canContainSubcomponentType(ci, subcomponentType)) {
				return Collections.singletonList(ci);
			} else {
				return Collections.emptyList();
			}
		} else if (bo instanceof Subcomponent) {
			final ComponentImplementation ci = ((Subcomponent) bo).getComponentImplementation();
			if (ci == null) {
				return Collections.emptyList();
			} else {
				return ci.getSelfPlusAllExtended().stream()
						.filter(tmp -> tmp instanceof ComponentImplementation
								&& AadlSubcomponentUtil.canContainSubcomponentType(ci, subcomponentType))
						.map(ComponentImplementation.class::cast)
						.collect(Collectors.toList());
			}
		} else {
			return Collections.emptyList();
		}
	}

	// Renaming
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(sc, value);
	}
}
