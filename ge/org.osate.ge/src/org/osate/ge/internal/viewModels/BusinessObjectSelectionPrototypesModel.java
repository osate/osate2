package org.osate.ge.internal.viewModels;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.AbstractPrototype;
import org.osate.aadl2.BusPrototype;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DevicePrototype;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.MemoryPrototype;
import org.osate.aadl2.ProcessPrototype;
import org.osate.aadl2.ProcessorPrototype;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.SubprogramGroupPrototype;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SystemPrototype;
import org.osate.aadl2.ThreadGroupPrototype;
import org.osate.aadl2.ThreadPrototype;
import org.osate.aadl2.VirtualBusPrototype;
import org.osate.aadl2.VirtualProcessorPrototype;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.prototypes.PrototypeDirection;
import org.osate.ge.swt.prototypes.PrototypeType;
import org.osate.ge.swt.prototypes.PrototypesEditorModel;

import com.google.common.base.Strings;

// TODO: Implement
// TODO; WIll need to update with the BOS like the feature direction model
// TODO: Decide what type of object to use to referece classifier
public class BusinessObjectSelectionPrototypesModel extends BaseObservableModel
implements PrototypesEditorModel<String, Object> {
	private BusinessObjectSelection bos;
	private TreeSet<String> prototypes;
	private String selectedPrototype = null;

	public BusinessObjectSelectionPrototypesModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public Stream<String> getPrototypes() {
		return prototypes.stream();
	}

	@Override
	public void addPrototype() {
		// TODO
		// TODO; Update selected prototype?
	}

	@Override
	public void removePrototype(final String prototype) {
		// TODO
		// TODO: Update selected prototype if needed
	}

	@Override
	public String getSelectedPrototype() {
		return selectedPrototype;
	}

	@Override
	public void setSelectedPrototype(final String value) {
		if ((selectedPrototype == null && value != null)
				|| (selectedPrototype != null && !selectedPrototype.equalsIgnoreCase(value))) {
			this.selectedPrototype = value;
			triggerChangeEvent();
		}
	}

	@Override
	public String getPrototypeName(final String prototype) {
		return prototype;
	}

	@Override
	public void setPrototypeName(String prototype, String value) {
		// TODO
	}

	@Override
	public String validatePrototypeName(String prototype, String newName) {
		// TODO
		return null;
	}

	@Override
	public PrototypeDirection getPrototypeDirection(String prototype) {
		// TODO
		return null;
	}

	@Override
	public void setPrototypeDirection(String prototype, PrototypeDirection value) {
		// TODO
	}

	@Override
	public PrototypeType getPrototypeType(final String prototype) {
		// TODO: Is there a better pattern than doing this. Helper function? FetaureDirectioNModel does it too
		final List<PrototypeType> types = bos.bocStream().flatMap(boc -> getPrototypesByName(boc, prototype))
				.map(BusinessObjectSelectionPrototypesModel::prototypeToPrototypeType).distinct().limit(2)
				.collect(Collectors.toList());
		return types.size() == 1 ? types.get(0) : null;
	}

	@Override
	public void setPrototypeType(String prototype, PrototypeType value) {
		// TODO
	}

	@Override
	public Stream<Object> getConstrainingClassifierOptions(String prototype) {
		return Stream.empty();
	}

	@Override
	public String getClassifierLabel(Object classifier) {
		return "TODO";
	}

	@Override
	public Object getConstrainingClassifier(String prototype) {
		// TODO
		return null;
	}

	@Override
	public void setConstrainingClassifier(String prototype, Object value) {
		// TODO
	}

	@Override
	public Boolean isArray(String prototype) {
		// TODO
		return null;
	}

	@Override
	public void setArray(String prototype, boolean value) {
		// TODO
	}

	@Override
	public String getRefineableElementLabel(String prototype) {
		return "TODO";
	}

	@Override
	public Boolean isRefined(String prototype) {
		// TODO
		return null;
	}

	@Override
	public void setRefined(String prototype, boolean value) {
		// TODO
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		// Build a treeset containing unique prototype names
		prototypes = new TreeSet<>((o1, o2) -> o1.compareToIgnoreCase(o2));
		value.bocStream().flatMap(BusinessObjectSelectionPrototypesModel::getAllPrototypes).map(Prototype::getName)
		.filter(n -> !Strings.isNullOrEmpty(n)).forEachOrdered(prototypes::add);

		// TODO; Depend on whether things have changed?
		triggerChangeEvent();
	}

	// TODO: Document intention
	private static Stream<Prototype> getAllPrototypes(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if (bo instanceof ComponentClassifier) {
			return ((ComponentClassifier) bo).getAllPrototypes().stream();
		} else if (bo instanceof FeatureGroupType) {
			return ((FeatureGroupType) bo).getAllPrototypes().stream();
		} else {
			return Stream.empty();
		}
	}
	// TODO: Document intention

	private static Stream<Prototype> getPrototypesByName(final BusinessObjectContext boc, final String filterName) {
		return getAllPrototypes(boc).filter(p -> {
			final String name = p.getName();
			if (name == null) {
				return false;
			}

			return name.equalsIgnoreCase(filterName);
		});
	}

	private static PrototypeType prototypeToPrototypeType(final Prototype prototype) {
		if (prototype instanceof AbstractPrototype) {
			return PrototypeType.ABSTRACT;
		} else if (prototype instanceof BusPrototype) {
			return PrototypeType.BUS;
		} else if (prototype instanceof DataPrototype) {
			return PrototypeType.DATA;
		} else if (prototype instanceof DevicePrototype) {
			return PrototypeType.DEVICE;
		} else if (prototype instanceof MemoryPrototype) {
			return PrototypeType.MEMORY;
		} else if (prototype instanceof ProcessorPrototype) {
			return PrototypeType.PROCESSOR;
		} else if (prototype instanceof ProcessPrototype) {
			return PrototypeType.PROCESS;
		} else if (prototype instanceof SubprogramGroupPrototype) {
			return PrototypeType.SUBPROGRAM_GROUP;
		} else if (prototype instanceof SubprogramPrototype) {
			return PrototypeType.SUBPROGRAM;
		} else if (prototype instanceof SystemPrototype) {
			return PrototypeType.SYSTEM;
		} else if (prototype instanceof ThreadGroupPrototype) {
			return PrototypeType.THREAD_GROUP;
		} else if (prototype instanceof ThreadPrototype) {
			return PrototypeType.THREAD;
		} else if (prototype instanceof VirtualBusPrototype) {
			return PrototypeType.VIRTUAL_BUS;
		} else if (prototype instanceof VirtualProcessorPrototype) {
			return PrototypeType.VIRTUAL_PROCESSOR;
		} else if (prototype instanceof FeatureGroupPrototype) {
			return PrototypeType.FEATURE_GROUP;
		} else if (prototype instanceof FeaturePrototype) {
			return PrototypeType.FEATURE;
		} else {
			return null;
		}
	}
}
