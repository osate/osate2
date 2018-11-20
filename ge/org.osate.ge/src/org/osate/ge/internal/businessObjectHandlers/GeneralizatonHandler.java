package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.BusinessObjectContext;
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
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class GeneralizatonHandler {
	private static final Graphic extendsGraphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static final Style extendsStyle = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	private static final Graphic implementsGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static final Style implementsStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dashed().build();
	private static final Graphic labelGraphic = LabelBuilder.create().build();
	private static StandaloneQuery nestedClassifierQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((Generalization g) -> getBusinessObjectPath(g.getGeneral())));

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) AadlPackage pkg) {
		return new PaletteEntry[] {
				PaletteEntryBuilder.create().connectionCreation().label("Extension").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getGeneralization().getName())).category(Categories.CLASSIFIERS).build()
		};
	}

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof Realization || bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}

	@CanDelete
	public boolean canDeleteGeneralization(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		final BusinessObjectContext destination = getDestination(boc, queryService);

		if(destination == null) {
			return GraphicalConfigurationBuilder.create().
					graphic(labelGraphic).
					decoration().
					build();
		} else {
			return GraphicalConfigurationBuilder.create().
					graphic(getConnectionGraphicalRepresentation(bo)).
					style(getStyle(bo)).
					source(boc.getParent()). // Source is the owner of the BO
					destination(getDestination(boc, queryService)).
					build();
		}
	}

	private Graphic getConnectionGraphicalRepresentation(final Object bo) {
		return bo instanceof Realization ? implementsGraphic : extendsGraphic;
	}

	private Style getStyle(final Object bo) {
		return bo instanceof Realization ? implementsStyle : extendsStyle;
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		final BusinessObjectContext pkgBoc = boc.getParent().getParent();
		if(pkgBoc == null) {
			return null;
		}

		final BusinessObjectContext packageParentBoc = pkgBoc.getParent();

		// Showing generalizations as connections is only supported on diagrams which contain package symbols
		if(packageParentBoc == null) {
			return null;
		}

		return queryService.getFirstResult(nestedClassifierQuery, packageParentBoc, boc.getBusinessObject());
	}

	private static Object[] getBusinessObjectPath(final Classifier c) {
		return new Object[] { c.getElementRoot(), c };
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Generalization generalization,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		// Don't show the name when displaying as a connection
		if(getDestination(boc, queryService) != null) {
			return null;
		}

		final Classifier general = generalization.getGeneral();
		if(general == null) {
			return null;
		}

		final Classifier specific = generalization.getSpecific();
		if (specific == null) {
			return null;
		}

		// Only show the name of the general element if both elements are in the same package.
		final String generalName;
		if (general.getElementRoot() == specific.getElementRoot()) {
			generalName = general.getName();
		} else {
			generalName = general.getQualifiedName();
		}

		return (generalization instanceof Realization ? "Implements " : "Extends ") + generalName;
	}

	@GetCreateOwner
	public BusinessObjectContext getCreateConnectionOwner(@Named(Names.SOURCE_BO) final Classifier subtype,
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext subtypeBoc) {
		return subtypeBoc;
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Classifier subtype) {
		// Determine whether it is a valid starting object
		if (subtype instanceof ComponentType) {
			final ComponentType ct = (ComponentType) subtype;
			return ct.getOwnedExtension() == null;
		} else if (subtype instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) subtype;
			return ci.getOwnedExtension() == null;
		} else if (subtype instanceof FeatureGroupType) {
			final FeatureGroupType fgt = (FeatureGroupType) subtype;
			return fgt.getOwnedExtension() == null;
		}

		return false;
	}

	@CanCreate
	public boolean canCreateGeneralization(@Named(Names.SOURCE_BO) final Object subtype, @Named(Names.DESTINATION_BO) final Classifier supertype) {
		// Ensure they are valid and are not the same
		if (subtype == null || supertype == null || subtype == supertype) {
			return false;
		}

		// Rules:
		// Abstract types can be extended by any type.
		// Types can be extended by other types in their category
		// Implementations can extend other implementations with same category and abstract implementation in some cases.
		// Feature Group Types can extend other feature group types
		if (subtype instanceof ComponentType) {
			return supertype instanceof AbstractType || supertype.getClass() == subtype.getClass();
		} else if (subtype instanceof ComponentImplementation) {
			return supertype instanceof AbstractImplementation || supertype.getClass() == subtype.getClass();
		} else if (subtype instanceof FeatureGroupType) {
			return supertype instanceof FeatureGroupType;
		}

		return false;
	}

	@Create
	public Generalization createGeneralization(@Named(Names.MODIFY_BO) final Classifier subtype,
			@Named(Names.DESTINATION_BO) final Classifier supertype) {
		// Import the package if necessary
		if(subtype.getNamespace() instanceof PackageSection && subtype.getNamespace().getOwner() instanceof AadlPackage &&
				supertype.getNamespace() instanceof PackageSection && supertype.getNamespace().getOwner() instanceof AadlPackage) {
			final PackageSection subtypeSection = (PackageSection)subtype.getNamespace();
			final AadlPackage supertypePackage = (AadlPackage)supertype.getNamespace().getOwner();
			AadlImportsUtil.addImportIfNeeded(subtypeSection, supertypePackage);
		}

		// Create the generalization
		if(subtype instanceof ComponentType) {
			final ComponentType ct = (ComponentType)subtype;
			final TypeExtension te = ct.createOwnedExtension();
			te.setExtended((ComponentType) supertype);
			return te;
		} else if(subtype instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)subtype;
			final ImplementationExtension ie = ci.createOwnedExtension();
			ie.setExtended((ComponentImplementation) supertype);
			return ie;
		} else if(subtype instanceof FeatureGroupType) {
			final FeatureGroupType fgt = (FeatureGroupType)subtype;
			final GroupExtension ge = fgt.createOwnedExtension();
			ge.setExtended((FeatureGroupType) supertype);
			return ge;
		}

		return null;
	}
}
