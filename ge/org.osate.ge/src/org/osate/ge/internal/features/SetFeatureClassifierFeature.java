// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

public class SetFeatureClassifierFeature extends AbstractCustomFeature {
	private static Map<EClass, FeatureClassifierSetterInfo> featureTypeToClassifierSetterMap = new HashMap<EClass, FeatureClassifierSetterInfo>();

	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		featureTypeToClassifierSetterMap.put(p.getBusAccess(), new FeatureClassifierSetterInfo(p.getBusSubcomponentType(), BusSubcomponentType.class, "setBusFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getDataAccess(), new FeatureClassifierSetterInfo(p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramAccess(), new FeatureClassifierSetterInfo(p.getSubprogramSubcomponentType(), SubprogramSubcomponentType.class, "setSubprogramFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramGroupAccess(), new FeatureClassifierSetterInfo(p.getSubprogramGroupSubcomponentType(), SubprogramGroupSubcomponentType.class, "setSubprogramGroupFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getAbstractFeature(), new FeatureClassifierSetterInfo(p.getFeatureClassifier(), FeatureClassifier.class, "setAbstractFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getFeatureGroup(), new FeatureClassifierSetterInfo(p.getFeatureType(), FeatureType.class, "setFeatureType"));
		featureTypeToClassifierSetterMap.put(p.getParameter(), new FeatureClassifierSetterInfo(p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getDataPort(), new FeatureClassifierSetterInfo(p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getEventDataPort(), new FeatureClassifierSetterInfo(p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getEventDataSource(), new FeatureClassifierSetterInfo(p.getDataClassifier(), DataClassifier.class, "setDataClassifier"));
		featureTypeToClassifierSetterMap.put(p.getPortProxy(), new FeatureClassifierSetterInfo(p.getDataClassifier(), DataClassifier.class, "setDataClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramProxy(), new FeatureClassifierSetterInfo(p.getSubprogramClassifier(), SubprogramClassifier.class, "setSubprogramClassifier"));
	}
	
	private static class FeatureClassifierSetterInfo {
		private final EClass classifierEClass;
		private final Class<?> classifierClass;
		private final String setterName;
		
		public FeatureClassifierSetterInfo(final EClass classifierEClass, final Class<?> classifierClass, final String setterName) {
			this.classifierEClass = classifierEClass;
			this.classifierClass = classifierClass;
			this.setterName = setterName;
		}
	}
	
	@Inject
	public SetFeatureClassifierFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
		
	}

	@Override
    public String getName() {
        return "Set Classifier...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}

		// Check that the shape represents a feature and that the feature is owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		if(!(bo instanceof NamedElement)) {
			return false;
		}

		final NamedElement feature = (NamedElement)bo;
		return feature.getContainingClassifier() == containerBo && featureTypeToClassifierSetterMap.containsKey(feature.eClass());
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		final NamedElement feature = (NamedElement)bor.getBusinessObjectForPictogramElement(pe);

		// Prompt the user for the classifier
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier.", getPotentialFeatureClassifiers(feature));
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}

		// Set the classifier
		aadlModService.modify(feature, new AbstractModifier<NamedElement, Object>() {
			@Override
			public Object modify(final Resource resource, final NamedElement feature) {
				// Import the package if necessary
				EObject selectedType = (EObject)dlg.getFirstSelectedElement();
				if(selectedType != null) {
					// Resolve the reference
					selectedType = EcoreUtil.resolve(selectedType, resource);
					
					// Import its package if necessary
					final AadlPackage pkg = (AadlPackage)feature.getElementRoot();
					if(selectedType instanceof Classifier && ((Classifier)selectedType).getNamespace() != null && pkg != null) {
						final PackageSection section = pkg.getPublicSection();
						final AadlPackage selectedClassifierPkg = (AadlPackage)((Classifier)selectedType).getNamespace().getOwner();
						if(pkg != selectedClassifierPkg && !section.getImportedUnits().contains(selectedClassifierPkg)) {
							section.getImportedUnits().add(selectedClassifierPkg);
						}
					}
				}				
				
				// Set the classifier
				setFeatureClassifier(feature, dlg.getFirstSelectedElement());

				return null;
			}			
		});
	}	
	
	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential subcomponent types for the specified subcomponent
	 * @return
	 */
	private List<Object> getPotentialFeatureClassifiers(final NamedElement feature) {
		final List<Object> featureClassifiers = new ArrayList<Object>();
		featureClassifiers.add(null);
		
		final FeatureClassifierSetterInfo setterInfo = featureTypeToClassifierSetterMap.get(feature.eClass());
		// Populate the list with valid classifier descriptions
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(feature.eResource(), setterInfo.classifierEClass)) {
			featureClassifiers.add(desc);
		}
		
		// Add any prototypes that are of the appropriate type
		if(feature.getContainingClassifier() instanceof ComponentClassifier) {
			for(final Prototype p : ((ComponentClassifier)feature.getContainingClassifier()).getAllPrototypes()) {
				if(setterInfo.classifierEClass.isInstance(p)) {
					featureClassifiers.add(p);
				}			
			}		
		}

		return featureClassifiers;
	}
	
	private static void setFeatureClassifier(final NamedElement feature, final Object classifier) {
		final FeatureClassifierSetterInfo setterInfo = featureTypeToClassifierSetterMap.get(feature.eClass());
		try {
			final Method method = feature.getClass().getMethod(setterInfo.setterName, setterInfo.classifierClass);
			method.invoke(feature, classifier);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
