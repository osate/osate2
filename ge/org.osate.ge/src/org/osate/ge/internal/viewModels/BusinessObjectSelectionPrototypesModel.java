package org.osate.ge.internal.viewModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.osate.aadl2.AbstractPrototype;
import org.osate.aadl2.BusPrototype;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
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
import org.osate.ge.internal.viewModels.BusinessObjectSelectionPrototypesModel.PrototypeData;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.prototypes.PrototypeDirection;
import org.osate.ge.swt.prototypes.PrototypeType;
import org.osate.ge.swt.prototypes.PrototypesEditorModel;

import com.google.common.base.Strings;

// TODO: Implement
// TODO; WIll need to update with the BOS like the feature direction model
// TODO: Decide what type of object to use to referece classifier
public class BusinessObjectSelectionPrototypesModel extends BaseObservableModel
implements PrototypesEditorModel<PrototypeData, Object> {
	private BusinessObjectSelection bos;
	private List<PrototypeData> prototypes;
	private PrototypeData selectedPrototype = null;

	// TODO: Rename
	public static class PrototypeData {
		// TODO: BOC or reference for context
		final BusinessObjectContext boc;

		final String label;
		final String name; // TODO: Needed to maintain selection?

		final Prototype prototype;

		public PrototypeData(final BusinessObjectContext boc, final String label, final String name,
				final Prototype prototype) {
			this.boc = Objects.requireNonNull(boc, "box must not be null");
			this.label = Objects.requireNonNull(label, "label must not be null");
			this.name = Objects.requireNonNull(name, "name must not be null");
			this.prototype = Objects.requireNonNull(prototype, "prototype must not be null");
		}

		// TODO; Need equals support? Is there a benefit from comparing that way when dealing with selections, etc?
	}

	public BusinessObjectSelectionPrototypesModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public Stream<PrototypeData> getPrototypes() {
		return prototypes.stream();
	}

	@Override
	public void addPrototype() {
		// TODO
		// TODO; Update selected prototype?
	}

	@Override
	public void removePrototype(final PrototypeData prototype) {
		// TODO
		// TODO: Update selected prototype if needed
	}

	@Override
	public String getPrototypeLabel(final PrototypeData prototype) {
		return prototype.label;
	}

	@Override
	public PrototypeData getSelectedPrototype() {
		return selectedPrototype;
	}

	@Override
	public void setSelectedPrototype(final PrototypeData value) {
		if (!Objects.equals(selectedPrototype, value)) {
			this.selectedPrototype = value;
			triggerChangeEvent();
		}
	}

	@Override
	public String getPrototypeName(final PrototypeData prototype) {
		return prototype.name;
	}

	@Override
	public void setPrototypeName(PrototypeData prototype, String value) {
		// TODO. Will need to update selection appropriately
	}

	@Override
	public String validatePrototypeName(PrototypeData prototype, String newName) {
		// TODO
		return null;
	}

	@Override
	public PrototypeDirection getPrototypeDirection(PrototypeData prototype) {
		if (prototype.prototype instanceof FeaturePrototype) {
			final FeaturePrototype fp = (FeaturePrototype) prototype.prototype;
			if (fp.isIn()) {
				return PrototypeDirection.INPUT;
			} else if (fp.isOut()) {
				return PrototypeDirection.OUTPUT;
			} else {
				return PrototypeDirection.UNSPECIFIED;
			}
		} else {
			return null;
		}
	}

	@Override
	public void setPrototypeDirection(final PrototypeData prototype, final PrototypeDirection value) {
		bos.modify(boc -> boc == prototype.boc, Classifier.class, c -> {
			getPrototypeByName(c, prototype.name).ifPresent(p -> {
				if (p instanceof FeaturePrototype) {
					final FeaturePrototype fp = (FeaturePrototype) p;
					switch (value) {
					case INPUT:
						fp.setIn(true);
						fp.setOut(false);
						break;
					case OUTPUT:
						fp.setIn(false);
						fp.setOut(true);
						break;
					case UNSPECIFIED:
						fp.setIn(false);
						fp.setOut(false);
						break;
					default:
						break;

					}
				}
			});
		});
	}

	@Override
	public PrototypeType getPrototypeType(final PrototypeData prototype) {
		return prototypeToPrototypeType(prototype.prototype);
	}

	@Override
	public void setPrototypeType(PrototypeData prototype, PrototypeType value) {
		// TODO
	}

	@Override
	public Stream<Object> getConstrainingClassifierOptions(final PrototypeData prototype) {
		return Stream.empty();
	}

	@Override
	public String getClassifierLabel(Object classifier) {
		if (classifier == null) {
			return "<None>";
		}

		if (classifier instanceof Classifier) {
			return ((Classifier) classifier).getQualifiedName();
		}


		// TODO
		return "TODO";
	}

	@Override
	public Object getConstrainingClassifier(PrototypeData prototype) {
		final Prototype p = prototype.prototype;
		final Classifier c;
		if (p instanceof ComponentPrototype) {
			c = ((ComponentPrototype) p).getConstrainingClassifier();
		} else if (p instanceof FeatureGroupPrototype) {
			c = ((FeatureGroupPrototype) p).getConstrainingFeatureGroupType();
		} else if (p instanceof FeaturePrototype) {
			c = ((FeaturePrototype) p).getConstrainingClassifier();
		} else {
			c = null;
		}

		// TODO: Is returning a Classifier object preferred?
		return c;
	}

	@Override
	public void setConstrainingClassifier(PrototypeData prototype, Object value) {
		// TODO
	}

	@Override
	public Boolean isArray(final PrototypeData prototype) {
		final Prototype p = prototype.prototype;
		if (p instanceof ComponentPrototype) {
			return ((ComponentPrototype) p).isArray();
		} else {
			return false;
		}
	}

	@Override
	public void setArray(PrototypeData prototype, boolean value) {
		// TODO
		bos.modify(boc -> boc == prototype.boc, Classifier.class, c -> {
			getPrototypeByName(c, prototype.name).ifPresent(p -> {
				if (p instanceof ComponentPrototype) {
					((ComponentPrototype) p).setArray(value);
				}
			});
		});
	}

	@Override
	public String getRefineableElementLabel(PrototypeData prototype) {
		if (prototype.prototype.getContainingClassifier() == prototype.boc.getBusinessObject()) {
			return null;
		} else {
			return prototype.prototype.getQualifiedName();
		}
	}

	@Override
	public Boolean isRefined(PrototypeData prototype) {
		return prototype.prototype.getRefined() != null;
	}

	@Override
	public void setRefined(PrototypeData prototype, boolean value) {
		// TODO
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		final boolean singleSelection = this.bos.boStream(Classifier.class).limit(2).count() == 1;

		// Build set of all editable prototypes..
		// TODO: Is there any chance of conflict? Just use a list
		prototypes = new ArrayList<>(); // TODO: Initial size? Just clear the other one...
		value.bocStream().filter(boc -> boc.getBusinessObject() instanceof Classifier).forEachOrdered(boc -> {
			final Classifier c = (Classifier) boc.getBusinessObject();
			final String suffix = singleSelection ? "" : " [" + c.getQualifiedName() + "]";
			getAllPrototypes(boc.getBusinessObject()).forEach(p -> {
				final String name = p.getName();
				if (!Strings.isNullOrEmpty(name)) {
					prototypes.add(new PrototypeData(boc, name + suffix, name, p));
				}
			});
		});

		// TODO: Update selection with potentially new BOC/prototype? Model so prototype object would change... BOC would change?
		if(this.selectedPrototype != null)  {
			this.selectedPrototype = prototypes.stream().filter(p -> {
				return p.boc == selectedPrototype.boc && p.name.equalsIgnoreCase(this.selectedPrototype.name);
			}).findAny().orElse(null);
		}

		// TODO; Depend on whether things have changed?
		triggerChangeEvent();
	}

	// TODO: Document intention
	private static Stream<Prototype> getAllPrototypes(final Object bo) {
		if (bo instanceof ComponentClassifier) {
			return ((ComponentClassifier) bo).getAllPrototypes().stream();
		} else if (bo instanceof FeatureGroupType) {
			return ((FeatureGroupType) bo).getAllPrototypes().stream();
		} else {
			return Stream.empty();
		}
	}
	// TODO: Document intention

	private static Optional<Prototype> getPrototypeByName(final Object bo,
			final String filterName) {
		return getAllPrototypes(bo).filter(p -> {
			final String name = p.getName();
			if (name == null) {
				return false;
			}

			return name.equalsIgnoreCase(filterName);
		}).findAny();
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
