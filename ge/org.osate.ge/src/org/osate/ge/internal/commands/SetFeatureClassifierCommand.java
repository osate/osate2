package org.osate.ge.internal.commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

@ModifiesBusinessObjects
public class SetFeatureClassifierCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	private static Map<EClass, FeatureClassifierSetterInfo> featureTypeToClassifierSetterMap = new HashMap<EClass, FeatureClassifierSetterInfo>();
	
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
	
	@GetLabel
	public String getLabel() {
		return "Set Classifier...";
	}
	
	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final NamedElement feature, 
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		return feature.getContainingClassifier() == queryService.getFirstBusinessObject(parentQuery, diagramElement) && 
				featureTypeToClassifierSetterMap.containsKey(feature.eClass());		
	}
	
	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final NamedElement feature) {
		// Prompt the user for the classifier
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier.", getPotentialFeatureClassifiers(feature));
		if(dlg.open() == Dialog.CANCEL) {
			return false;
		}
		
		// Import the package if necessary
		EObject selectedType = (EObject)dlg.getFirstSelectedElement();
		if(selectedType != null) {
			// Resolve the reference
			selectedType = EcoreUtil.resolve(selectedType, feature.eResource());
			
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
		
		return true;
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
