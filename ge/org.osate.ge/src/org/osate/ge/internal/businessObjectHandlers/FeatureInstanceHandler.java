package org.osate.ge.internal.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.di.GetDefaultDockingPosition;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.graphics.FolderGraphicBuilder;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ImageHelper;

public class FeatureInstanceHandler {	
	// TODO
	private static final LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().aboveTop().horizontalCenter().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return true;
	}
	
	@GetDefaultDockingPosition
	public DockingPosition getDockingPropertes(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return fi.getDirection() == DirectionType.OUT ? DockingPosition.RIGHT : DockingPosition.LEFT;
	}
		
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		// Determine the direction of access feature instances using the type of the feature.
		// This is needed because as of 2016-12-09 access feature instances have a direction of IN OUT. The AccessType may not be reliable because it could be inverted
		// by being inside an inverse of feature group.
		// TODO: Fix when/if OSATE provides direction.
		final DirectionType direction;
		if(fi.getFeature() instanceof Access) {
			direction = ((Access)fi.getFeature()).getKind() == AccessType.PROVIDES ? DirectionType.OUT : DirectionType.IN;
		} else {
			direction = fi.getDirection();
		}
		return AadlGraphics.getGraphic(fi.getFeature().eClass(), direction); 
	}	
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return fi.getName();
	}
	
	@GetNameLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) FeatureInstance fi) {
		return fi.getFeatureInstances().stream();
	}
}
