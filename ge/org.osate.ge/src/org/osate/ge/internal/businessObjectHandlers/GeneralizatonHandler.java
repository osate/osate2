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
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
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
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.model.ProjectOverview;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.DiagramElementQuery;

public class GeneralizatonHandler {
	private static final Graphic extendsGraphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static final Graphic implementsGraphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().open().build()).dashed().build();
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if(!(diagramBo instanceof AadlPackage || diagramBo instanceof ProjectOverview)) {
			return null;
		}
		
		return new PaletteEntry[] { 
			PaletteEntryBuilder.create().connectionCreation().label("Extension").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getGeneralization().getName())).category(Categories.RELATIONSHIPS).build()
		};
	}
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof Realization || bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}
	
	@CanDelete
	public boolean canDeleteGeneralization() {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof Realization ? implementsGraphic : extendsGraphic;
	}
	
	@CreateParentQuery
	public <T> DiagramElementQuery<T> createParentDiagramElementQuery(final @Named(Names.SOURCE_ROOT_QUERY) DiagramElementQuery<T> srcRootQuery, final @Named(Names.DESTINATION_ROOT_QUERY) DiagramElementQuery<T> dstRootQuery) {
		// Owner will be the common ancestor for the shapes. Works for both overview and generalization diagram?
		return srcRootQuery.commonAncestors(dstRootQuery);
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<Generalization> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<Generalization> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject(g -> g.getSpecific());
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<Generalization> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<Generalization> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject(g -> g.getGeneral());
	}
	
	@GetCreateOwner
	public Classifier getCreateConnectionOwner(@Named(Names.SOURCE_BO) final Classifier subtype) {
		return subtype;
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
	public Generalization createConnectionBusinessObject(@Named(Names.SOURCE_BO) final Classifier subtype, @Named(Names.DESTINATION_BO) final Classifier supertype) {
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
