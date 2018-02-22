package org.osate.ge.internal.ui.properties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BusFeatureClassifier;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SetFeatureClassifierPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof Feature) {
					final Feature feature = (Feature) bo;
					return featureTypeToClassifierSetterMap.containsKey(feature.eClass());
				}

				return false;
			});
		}
	}

	private static Map<EClass, FeatureClassifierSetterInfo> featureTypeToClassifierSetterMap = new HashMap<EClass, FeatureClassifierSetterInfo>();

	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		featureTypeToClassifierSetterMap.put(p.getBusAccess(), new FeatureClassifierSetterInfo(
				p.getBusSubcomponentType(), BusSubcomponentType.class, "setBusFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getBusAccess(), new FeatureClassifierSetterInfo(
				p.getBusSubcomponentType(), BusFeatureClassifier.class, "setBusFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getDataAccess(), new FeatureClassifierSetterInfo(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramAccess(), new FeatureClassifierSetterInfo(
				p.getSubprogramSubcomponentType(), SubprogramSubcomponentType.class, "setSubprogramFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramGroupAccess(),
				new FeatureClassifierSetterInfo(p.getSubprogramGroupSubcomponentType(),
						SubprogramGroupSubcomponentType.class, "setSubprogramGroupFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getAbstractFeature(), new FeatureClassifierSetterInfo(
				p.getFeatureClassifier(), FeatureClassifier.class, "setAbstractFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getFeatureGroup(),
				new FeatureClassifierSetterInfo(p.getFeatureType(), FeatureType.class, "setFeatureType"));
		featureTypeToClassifierSetterMap.put(p.getParameter(), new FeatureClassifierSetterInfo(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getDataPort(), new FeatureClassifierSetterInfo(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getEventDataPort(), new FeatureClassifierSetterInfo(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier"));
		featureTypeToClassifierSetterMap.put(p.getEventDataSource(),
				new FeatureClassifierSetterInfo(p.getDataClassifier(), DataClassifier.class, "setDataClassifier"));
		featureTypeToClassifierSetterMap.put(p.getPortProxy(),
				new FeatureClassifierSetterInfo(p.getDataClassifier(), DataClassifier.class, "setDataClassifier"));
		featureTypeToClassifierSetterMap.put(p.getSubprogramProxy(), new FeatureClassifierSetterInfo(
				p.getSubprogramClassifier(), SubprogramClassifier.class, "setSubprogramClassifier"));
	}

	private static class FeatureClassifierSetterInfo {
		private final EClass classifierEClass;
		private final Class<?> classifierClass;
		private final String setterName;

		public FeatureClassifierSetterInfo(final EClass classifierEClass, final Class<?> classifierClass,
				final String setterName) {
			this.classifierEClass = classifierEClass;
			this.classifierClass = classifierClass;
			this.setterName = setterName;
		}
	}

	private BusinessObjectSelection selectedBos;
	private Label curFeatureClassifier;
	private Button chooseBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite container = getWidgetFactory().createComposite(composite);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Classifier:");

		container.setLayout(new FormLayout());
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		container.setLayoutData(fd);

		curFeatureClassifier = getWidgetFactory().createLabel(container, new String());
		fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		curFeatureClassifier.setLayoutData(fd);

		chooseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, null, setClassifierListener,
				"Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(curFeatureClassifier, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(curFeatureClassifier, 0, SWT.CENTER);
		chooseBtn.setLayoutData(fd);
	}

	final SelectionListener setClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final List<Feature> features = selectedBos.boStream(Feature.class).collect(Collectors.toList());
			final Iterator<Feature> it = features.iterator();
			final Feature feature = it.next();
			final List<Object> potentialFeatureClassifiers = new ArrayList<>(getPotentialFeatureClassifiers(feature));
			// List will contain classifiers that are available to all selected elements
			while (it.hasNext()) {
				potentialFeatureClassifiers.retainAll(getPotentialFeatureClassifiers(it.next()));
			}

			// Prompt the user for the element
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier", "Select a classifier.", potentialFeatureClassifiers);
			if (dlg.open() != Window.CANCEL) {
				// Import the package if necessary
				final EObject selectedType;
				if (dlg.getFirstSelectedElement() != null) {
					// Resolve the reference
					selectedType = EcoreUtil.resolve((EObject) dlg.getFirstSelectedElement(), feature.eResource());
				} else {
					selectedType = null;
				}

				// Set the classifier
				selectedBos.modify(Feature.class, f -> {
					setFeatureClassifier(f, selectedType);
				});
			}
		}

		private void setFeatureClassifier(final NamedElement feature, final Object classifier) {
			if (classifier != null) {
				// Import its package if necessary
				final AadlPackage pkg = (AadlPackage) feature.getElementRoot();
				if (classifier instanceof Classifier && ((Classifier) classifier).getNamespace() != null
						&& pkg != null) {
					final PackageSection section = pkg.getPublicSection();
					final AadlPackage selectedClassifierPkg = (AadlPackage) ((Classifier) classifier).getNamespace()
							.getOwner();
					if (selectedClassifierPkg != null && pkg != selectedClassifierPkg) {
						AadlImportsUtil.addImportIfNeeded(section, selectedClassifierPkg);
					}
				}
			}

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
	};

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<Feature> features = selectedBos.boStream(Feature.class).collect(Collectors.toList());
		curFeatureClassifier.setText(getFeatureClassifierLabel(features));
	}

	private static String getFeatureClassifierLabel(final List<Feature> features) {
		final Iterator<Feature> it = features.iterator();
		final FeatureClassifier fc = it.next().getFeatureClassifier();
		while (it.hasNext()) {
			// If feature classifiers are not the same, set to multiple
			if (fc != it.next().getFeatureClassifier()) {
				return "<Multiple>";
			}
		}

		return getFeatureClassifierName(fc);
	}

	private static String getFeatureClassifierName(final FeatureClassifier fc) {
		if (fc != null && fc.eResource() != null) {
			return fc.eResource().getURI().trimFileExtension().lastSegment() + "::"
					+ ((NamedElement) fc).getName();
		}

		return "<None>";
	}

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified feature
	 * @return
	 */
	private List<Object> getPotentialFeatureClassifiers(final NamedElement feature) {
		final List<Object> featureClassifiers = new ArrayList<Object>();
		featureClassifiers.add(null);

		final FeatureClassifierSetterInfo setterInfo = featureTypeToClassifierSetterMap.get(feature.eClass());
		// Populate the list with valid classifier descriptions
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(feature.eResource(),
				setterInfo.classifierEClass)) {
			featureClassifiers.add(desc);
		}

		// Add any prototypes that are of the appropriate type
		if (feature.getContainingClassifier() instanceof ComponentClassifier) {
			for (final Prototype p : ((ComponentClassifier) feature.getContainingClassifier()).getAllPrototypes()) {
				if (setterInfo.classifierEClass.isInstance(p)) {
					featureClassifiers.add(p);
				}
			}
		}

		return featureClassifiers;
	}
}
