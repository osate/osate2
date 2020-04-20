package org.osate.ge.internal.viewModels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.SubcomponentUtil;

// TODO: Cleanup, rename implement, etc
public class SubcomponentBusinessObjectSelectionPrototypeBindingsModel
extends BusinessObjectSelectionPrototypeBindingsModel {
	public SubcomponentBusinessObjectSelectionPrototypeBindingsModel(BusinessObjectSelection bos) {
		super(bos);
	}

	@Override
	public Set<Object> getClassifierForRoot() {
		return bos.boStream(Subcomponent.class)
				.map(SubcomponentBusinessObjectSelectionPrototypeBindingsModel::getAllSubcomponentType)
				.collect(Collectors.toSet());
	}

	@Override
	public Stream<Object> getClassifierOptionsForRoot() {
		// Get options which are valid for all selected subcomponents
		final List<Subcomponent> scs = bos.boStream(Subcomponent.class).collect(Collectors.toList());
		final Iterator<Subcomponent> it = scs.iterator();
		final Subcomponent sc = it.next();
		final List<Object> potentialFeatureClassifiers = new ArrayList<>(getPotentialSubcomponentTypes(sc));
		while (it.hasNext()) {
			potentialFeatureClassifiers.retainAll(getPotentialSubcomponentTypes(it.next()));
		}

		return getPotentialSubcomponentTypes(sc).stream();

	}

	@Override
	public void flush() {
		// Get any subcomponent. Will be used to resolve selected classifier
		final Subcomponent currentSc = bos.boStream(Subcomponent.class).findFirst().orElse(null);
		if (currentSc == null) {
			throw new RuntimeException("Unable to retrieve subcomponent");
		}

		// Get the actual object.
		Object classifierValue = getClassifier(null);

		// Return if value hasn't changed
		if (classifierValue instanceof Collection<?>) {
			return;
		}

		if (classifierValue instanceof IEObjectDescription) {
			classifierValue = ((IEObjectDescription) classifierValue).getEObjectOrProxy();
		}

		if (classifierValue != null && !(classifierValue instanceof SubcomponentType)) {
			throw new RuntimeException("Unexpected value: " + classifierValue);
		}

		if (classifierValue != null) {
			classifierValue = EcoreUtil.resolve((SubcomponentType) classifierValue, currentSc);
		}

		final SubcomponentType newSubcomponentType = (SubcomponentType) classifierValue;
		bos.modify(Subcomponent.class, sc -> {
			// Set subcomponent type
			SubcomponentUtil.setClassifier(sc, newSubcomponentType);

			// TODO: Update root bindings and nested bindings
			// sc.getOwnedPrototypeBindings()
		});
	}

	private static SubcomponentType getAllSubcomponentType(Subcomponent sc) {
		SubcomponentType result;
		do {
			result = sc.getSubcomponentType();
			sc = sc.getRefined();
		} while (sc != null && result == null);

		return result;
	}

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified subcomponent
	 * @return
	 */
	private List<Object> getPotentialSubcomponentTypes(final Subcomponent sc) {
		final List<Object> subcomponentTypes = new ArrayList<Object>();
		subcomponentTypes.add(null);

		// Populate the list with valid classifier descriptions
		final EClass subcomponentTypeClass = componentCategoryToSubcomponentTypeEClass(sc.getCategory());
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(sc.eResource(),
				subcomponentTypeClass)) {
			subcomponentTypes.add(desc);
		}

		// Add any prototypes that are of the appropriate type
		for (final Prototype p : sc.getContainingComponentImpl().getAllPrototypes()) {
			if (subcomponentTypeClass.isInstance(p)) {
				subcomponentTypes.add(p);
			}
		}

		return subcomponentTypes;
	}

	private EClass componentCategoryToSubcomponentTypeEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case SYSTEM:
			return p.getSystemSubcomponentType();

		case PROCESS:
			return p.getProcessSubcomponentType();

		case THREAD_GROUP:
			return p.getThreadGroupSubcomponentType();

		case THREAD:
			return p.getThreadSubcomponentType();

		case SUBPROGRAM:
			return p.getSubprogramSubcomponentType();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupSubcomponentType();

		case DATA:
			return p.getDataSubcomponentType();

		case ABSTRACT:
			return p.getAbstractSubcomponentType();

		case VIRTUAL_BUS:
			return p.getVirtualBusSubcomponentType();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorSubcomponentType();

		case BUS:
			return p.getBusSubcomponentType();

		case PROCESSOR:
			return p.getProcessorSubcomponentType();

		case DEVICE:
			return p.getDeviceSubcomponentType();

		case MEMORY:
			return p.getMemorySubcomponentType();

		default:
			throw new RuntimeException("Unexpected category: " + category);
		}
	}
}
