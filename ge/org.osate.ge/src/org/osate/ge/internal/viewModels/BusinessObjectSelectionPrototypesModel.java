package org.osate.ge.internal.viewModels;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
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
import org.osate.aadl2.PackageSection;
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
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.viewModels.BusinessObjectSelectionPrototypesModel.EditablePrototype;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.prototypes.PrototypeDirection;
import org.osate.ge.swt.prototypes.PrototypeType;
import org.osate.ge.swt.prototypes.PrototypesEditorModel;

import com.google.common.base.Strings;

/**
 * {@link org.osate.ge.swt.prototypes.PrototypesEditorModel} implementation which uses the AADL model elements provided by a
 * {@link org.osate.ge.BusinessObjectSelection}.
 *
 * Classifiers provided by this model are either a {@link org.osate.aadl2.Classifier} or
 * @{link org.eclipse.xtext.resource.IEObjectDescription}. However, that is an implementation detail and users should not rely
 * on that.
 *
 */
public class BusinessObjectSelectionPrototypesModel extends BaseObservableModel
implements PrototypesEditorModel<EditablePrototype, Object> {
	private final Renamer renamer;
	private final NamingService namingService;
	private BusinessObjectSelection bos;
	private List<EditablePrototype> prototypes;
	private EditablePrototype selectedPrototype = null;

	/**
	 * Supplies a prototype with a given name. Created in the context of a business object context and is used to find the prototype
	 * that should be rename.
	 *
	 */
	public static interface PrototypeSupplier {
		/**
		 * Returns the prototype with the given name.
		 * @param currentName is the current name of the prototype
		 * @return the prototype
		 */
		Prototype getBusinessObject(final String currentName);
	}

	/**
	 * Interface of object which is used to rename a prototype
	 */
	public static interface Renamer {
		void rename(PrototypeSupplier prototypeSupplier, final String name, final String originalName);
	}

	/**
	 * Represents a prototype provided by the model.
	 */
	public static class EditablePrototype {
		// Business object context for the classifier containing the prototype
		final BusinessObjectContext classifierBoc;

		final String label;

		// The name is stored so that it will be available even if the model changes and the prototype itself is invalidated.
		// It is necessary to maintain selection after rename.
		final String name;

		final Prototype prototype;

		public EditablePrototype(final BusinessObjectContext boc, final String label, final String name,
				final Prototype prototype) {
			this.classifierBoc = Objects.requireNonNull(boc, "box must not be null");
			this.label = Objects.requireNonNull(label, "label must not be null");
			this.name = Objects.requireNonNull(name, "name must not be null");
			this.prototype = Objects.requireNonNull(prototype, "prototype must not be null");
		}

		@Override
		public int hashCode() {
			return Objects.hash(classifierBoc, label, name, prototype);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			EditablePrototype other = (EditablePrototype) obj;
			return Objects.equals(classifierBoc, other.classifierBoc) && Objects.equals(label, other.label)
					&& Objects.equals(name, other.name) && Objects.equals(prototype, other.prototype);
		}
	}

	public BusinessObjectSelectionPrototypesModel(final Renamer renamer,
			final NamingService namingService,
			final BusinessObjectSelection bos) {
		this.renamer = Objects.requireNonNull(renamer, "renamer must not be null");
		this.namingService = Objects.requireNonNull(namingService, "namingService must not be null");
		setBusinessObjectSelection(bos);
	}

	@Override
	public Stream<EditablePrototype> getPrototypes() {
		return prototypes.stream();
	}

	@Override
	public boolean canAddPrototype() {
		return bos.boStream(Classifier.class).limit(2).count() == 1;
	}

	@Override
	public void addPrototype() {
		bos.modify("Add Prototype", boc -> boc.getBusinessObject() instanceof Classifier,
				boc -> (Classifier) boc.getBusinessObject(),
				(c, boc) -> {
					// Create a new prototype
					final ComponentPrototype cp = (ComponentPrototype) c
							.createOwnedPrototype(Aadl2Factory.eINSTANCE.getAadl2Package().getDataPrototype());

					// Assign a name
					final String newName = namingService.buildUniqueIdentifier(c, "new_prototype");
					cp.setName(newName);

					// Update the selected prototype
					selectedPrototype = new EditablePrototype(boc, newName, newName, cp);
				});
	}

	@Override
	public void removePrototype(final EditablePrototype prototype) {
		modifyPrototype("Remove Prototype", prototype, EcoreUtil::remove);
	}

	@Override
	public String getPrototypeLabel(final EditablePrototype prototype) {
		return prototype.label;
	}

	@Override
	public EditablePrototype getSelectedPrototype() {
		return selectedPrototype;
	}

	@Override
	public void setSelectedPrototype(final EditablePrototype value) {
		if (!Objects.equals(selectedPrototype, value)) {
			this.selectedPrototype = value;
			triggerChangeEvent();
		}
	}

	@Override
	public String getPrototypeName(final EditablePrototype prototype) {
		return prototype.name;
	}

	/**
	 * Supplies the prototype that should be renamed. Stores a weak reference to the classifier business object context to avoid
	 * potential memory leaks.
	 *
	 */
	private static class RenamePrototypeSupplier implements PrototypeSupplier {
		private final WeakReference<BusinessObjectContext> weakClassifierBoc;

		public RenamePrototypeSupplier(final BusinessObjectContext classifierBoc) {
			this.weakClassifierBoc = new WeakReference<>(classifierBoc);
		}

		@Override
		public Prototype getBusinessObject(final String currentName) {
			final BusinessObjectContext classifierBoc = weakClassifierBoc.get();
			if (classifierBoc == null) {
				return null;
			}

			Prototype prototypeToRename = getPrototypeByName(classifierBoc.getBusinessObject(), currentName)
					.orElse(null);

			// Always rename the refined element to prevent issues with the refactoring producing invalid results
			while (prototypeToRename != null && prototypeToRename.getRefined() != null) {
				prototypeToRename = prototypeToRename.getRefined();
			}

			return prototypeToRename;
		}
	}


	@Override
	public void setPrototypeName(EditablePrototype prototype, String value) {
		renamer.rename(new RenamePrototypeSupplier(prototype.classifierBoc), value, prototype.name);

		// Select will be lost on undo/redo but this will retain selection on the original rename.
		selectedPrototype = new EditablePrototype(prototype.classifierBoc, value, value, prototype.prototype);
	}

	@Override
	public String validatePrototypeName(final EditablePrototype prototype, final String newName) {
		return namingService.checkNameValidity(prototype.prototype, newName);
	}

	@Override
	public PrototypeDirection getPrototypeDirection(EditablePrototype prototype) {
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
	public void setPrototypeDirection(final EditablePrototype prototype, final PrototypeDirection value) {
		modifyPrototype("Set Prototype Direction", prototype, p -> {
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
	}

	@Override
	public PrototypeType getPrototypeType(final EditablePrototype prototype) {
		return prototypeToPrototypeType(prototype.prototype);
	}

	@Override
	public void setPrototypeType(final EditablePrototype prototype, final PrototypeType value) {
		// Check if the type is different by comparing EClass values
		final EClass currentEClass = prototype.prototype.eClass();
		final EClass newEClass = prototypeTypeToEClass(value);
		if (newEClass == currentEClass) {
			return;
		}

		modifyOwningClassifier("Set Prototype Type", prototype, c -> {
			getPrototypeByName(c, prototype.name).ifPresent(p -> {
				// Store location in list
				final int index = c.getOwnedPrototypes().indexOf(p);
				if (index == -1) {
					throw new RuntimeException("Unable to get index of prototype being modified");
				}

				// Store fields
				final String name = p.getName();
				final Prototype refined = p.getRefined();
				ComponentClassifier cc = null;
				FeatureGroupType fgt = null;
				boolean in = false;
				boolean out = false;
				boolean array = false;

				if (p instanceof ComponentPrototype) {
					final ComponentPrototype cp = (ComponentPrototype) p;
					cc = cp.getConstrainingClassifier();
					array = cp.isArray();
				} else if (p instanceof FeatureGroupPrototype) {
					final FeatureGroupPrototype fp = (FeatureGroupPrototype) p;
					fgt = fp.getConstrainingFeatureGroupType();
				} else if (p instanceof FeaturePrototype) {
					final FeaturePrototype fp = (FeaturePrototype) p;
					cc = fp.getConstrainingClassifier();
					in = fp.isIn();
					out = fp.isOut();
				}

				// Create new prototype
				final Prototype newPrototype = (Prototype) EcoreUtil.create(newEClass);
				c.getOwnedPrototypes().add(index, newPrototype);

				if (refined == null) {
					newPrototype.setName(name);
				} else {
					newPrototype.setRefined(refined);
				}

				// Set fields
				if (newPrototype instanceof ComponentPrototype) {
					final ComponentPrototype cp = (ComponentPrototype) newPrototype;
					cp.setConstrainingClassifier(cc);
					cp.setArray(array);
				} else if (newPrototype instanceof FeatureGroupPrototype) {
					final FeatureGroupPrototype fp = (FeatureGroupPrototype) newPrototype;
					fp.setConstrainingFeatureGroupType(fgt);
				} else if (newPrototype instanceof FeaturePrototype) {
					final FeaturePrototype fp = (FeaturePrototype) newPrototype;
					fp.setConstrainingClassifier(cc);
					fp.setIn(in);
					fp.setOut(out);
				}

				// Move property associations
				newPrototype.getOwnedPropertyAssociations().addAll(p.getOwnedPropertyAssociations());

				// Remove old prototype
				EcoreUtil.remove(p);
			});
		});
	}

	@Override
	public Stream<Object> getConstrainingClassifierOptions(final EditablePrototype prototype) {
		if (prototype.prototype.eResource() == null) {
			return Stream.empty();
		}

		// Check the type of the prototype and get the EClass of the constraining classifier / constraining feature group type
		final Prototype p = prototype.prototype;
		final EClass filterEClass;
		if (p instanceof ComponentPrototype || p instanceof FeaturePrototype) {
			filterEClass = Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier();
		} else if (p instanceof FeatureGroupPrototype) {
			filterEClass = Aadl2Factory.eINSTANCE.getAadl2Package().getFeatureGroupType();
		} else {
			filterEClass = null;
		}

		// null is always a valid option
		Stream<Object> options = Stream.of((Object) null);

		// Concatenate all classifiers that match the supported EClass
		if (filterEClass != null) {
			options = Stream.concat(options,
					ScopedEMFIndexRetrieval.getAllEObjectsByType(prototype.prototype.eResource(), filterEClass).stream()
					.map(Object.class::cast));
		}

		return options;
	}

	@Override
	public String getClassifierLabel(Object classifier) {
		if (classifier == null) {
			return "<None>";
		} else if (classifier instanceof Classifier) {
			return ((Classifier) classifier).getQualifiedName();
		} else if (classifier instanceof IEObjectDescription) {
			return ((IEObjectDescription) classifier).getName().toString("::");
		} else {
			return "<Unknown>";
		}
	}

	@Override
	public Object getConstrainingClassifier(final EditablePrototype prototype) {
		final Prototype p = prototype.prototype;
		if (p instanceof ComponentPrototype) {
			return ((ComponentPrototype) p).getConstrainingClassifier();
		} else if (p instanceof FeatureGroupPrototype) {
			return ((FeatureGroupPrototype) p).getConstrainingFeatureGroupType();
		} else if (p instanceof FeaturePrototype) {
			return ((FeaturePrototype) p).getConstrainingClassifier();
		} else {
			return null;
		}
	}

	@Override
	public void setConstrainingClassifier(final EditablePrototype prototype, final Object value) {
		modifyPrototype("Set Constraining Classifier", prototype, p -> {
			EObject classifier = null;
			if (value == null) {
				classifier = null;
			} else if (value instanceof IEObjectDescription) {
				classifier = ((IEObjectDescription) value).getEObjectOrProxy();
			} else if (value instanceof Classifier) {
				classifier = (EObject) value;
			} else {
				throw new RuntimeException("Unexpected value: " + classifier);
			}

			if (classifier != null) {
				// Resolve the classifier in case it is a proxy
				classifier = EcoreUtil.resolve(classifier, prototype.prototype.eResource());

				// Import its package if necessary
				final AadlPackage pkg = (AadlPackage) p.getElementRoot();
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

			// Update the classifier
			if (p instanceof ComponentPrototype) {
				((ComponentPrototype) p).setConstrainingClassifier((ComponentClassifier) classifier);
			} else if (p instanceof FeatureGroupPrototype) {
				((FeatureGroupPrototype) p).setConstrainingFeatureGroupType((FeatureGroupType) classifier);
			} else if (p instanceof FeaturePrototype) {
				((FeaturePrototype) p).setConstrainingClassifier((ComponentClassifier) classifier);
			}
		});
	}

	@Override
	public Boolean isArray(final EditablePrototype prototype) {
		final Prototype p = prototype.prototype;
		if (p instanceof ComponentPrototype) {
			return ((ComponentPrototype) p).isArray();
		} else {
			return false;
		}
	}

	@Override
	public void setArray(EditablePrototype prototype, boolean value) {
		// Set whether the component prototype is an array
		modifyPrototype("Set Prototype Array", prototype, p -> {
			if (p instanceof ComponentPrototype) {
				((ComponentPrototype) p).setArray(value);
			}
		});
	}

	@Override
	public String getRefineableElementLabel(EditablePrototype prototype) {
		if (prototype.prototype.getRefinedElement() != null) {
			return prototype.prototype.getRefined().getQualifiedName();
		} else if (prototype.prototype.getContainingClassifier() == prototype.classifierBoc.getBusinessObject()) {
			return null;
		} else {
			return prototype.prototype.getQualifiedName();
		}
	}

	@Override
	public Boolean isRefined(final EditablePrototype prototype) {
		return prototype.prototype.getRefined() != null;
	}

	@Override
	public void setRefined(final EditablePrototype prototype, final boolean value) {
		if (value) {
			// Create refinement
			modifySelectedClassifier("Refine Prototype", prototype, c -> {
				final Prototype refinement = (Prototype) c.createOwnedPrototype(prototype.prototype.eClass());
				refinement.setRefined(prototype.prototype);
			});
		} else {
			// Remove refinement
			modifyPrototype("Remove Prototype Refinement", prototype, p -> EcoreUtil.remove(p));
		}
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		final boolean singleSelection = this.bos.boStream(Classifier.class).limit(2).count() == 1;

		// Build set of all editable prototypes..
		final ArrayList<EditablePrototype> newPrototypes = new ArrayList<>();
		value.bocStream().filter(boc -> boc.getBusinessObject() instanceof Classifier).forEachOrdered(boc -> {
			final Classifier c = (Classifier) boc.getBusinessObject();
			final String suffix = singleSelection ? "" : " [" + c.getQualifiedName() + "]";
			getAllPrototypes(boc.getBusinessObject()).forEach(p -> {
				final String name = p.getName();
				if (!Strings.isNullOrEmpty(name)) {
					newPrototypes.add(new EditablePrototype(boc, name + suffix, name, p));
				}
			});
		});

		// If a prototype was previously selected, update the selection based on the previously selected prototype's same classifier BOC and name.
		final EditablePrototype newSelectedPrototype = this.selectedPrototype == null ? null
				: newPrototypes.stream().filter(p -> {
					return p.classifierBoc == selectedPrototype.classifierBoc && p.name.equalsIgnoreCase(this.selectedPrototype.name);
				}).findAny().orElse(null);


		// Update fields and send notification if anything has changed.
		if (!Objects.equals(prototypes, newPrototypes) || !Objects.equals(selectedPrototype, newSelectedPrototype)) {
			prototypes = newPrototypes;
			selectedPrototype = newSelectedPrototype;

			triggerChangeEvent();
		}
	}

	void modifySelectedClassifier(final String label, final EditablePrototype editablePrototype,
			final Consumer<Classifier> modifier) {
		bos.modify(label, Classifier.class, boc -> boc == editablePrototype.classifierBoc, c -> modifier.accept(c));
	}

	void modifyOwningClassifier(final String label, final EditablePrototype editablePrototype,
			final Consumer<Classifier> modifier) {
		bos.modify(label, boc -> boc == editablePrototype.classifierBoc, boc -> editablePrototype.prototype.getContainingClassifier(),
				(c, boc) -> modifier.accept(c));
	}

	void modifyPrototype(final String label, final EditablePrototype editablePrototype, final Consumer<Prototype> modifier) {
		modifyOwningClassifier(label, editablePrototype, c -> getPrototypeByName(c, editablePrototype.name).ifPresent(p -> {
			modifier.accept(p);
		}));
	}

	/**
	 * Gets all prototypes owned by the specified classifier or more general classifiers.
	 * @param bo is the classifier for which to get prototypes.
	 * @return a stream of prototype objects or an empty stream if the bo is not a classifier.
	 */
	private static Stream<Prototype> getAllPrototypes(final Object bo) {
		if (bo instanceof ComponentClassifier) {
			return ((ComponentClassifier) bo).getAllPrototypes().stream();
		} else if (bo instanceof FeatureGroupType) {
			return ((FeatureGroupType) bo).getAllPrototypes().stream();
		} else {
			return Stream.empty();
		}
	}

	/**
	 * Finds the prototype owned by the specified business object or a more general classifiers with the specified name.
	 * @param bo is the classifier for which to get the prototype.
	 * @param filterName is the name of the prototype for which to look.
	 * @return an optional describing the prototype.
	 */
	private static Optional<Prototype> getPrototypeByName(final Object bo, final String filterName) {
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
			throw new RuntimeException("Unexpected object: " + prototype);
		}
	}

	private static EClass prototypeTypeToEClass(final PrototypeType type) {
		final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (type) {
		case ABSTRACT:
			return pkg.getAbstractPrototype();

		case BUS:
			return pkg.getBusPrototype();

		case DATA:
			return pkg.getDataPrototype();

		case DEVICE:
			return pkg.getDevicePrototype();

		case FEATURE:
			return pkg.getFeaturePrototype();

		case FEATURE_GROUP:
			return pkg.getFeatureGroupPrototype();

		case MEMORY:
			return pkg.getMemoryPrototype();

		case PROCESS:
			return pkg.getProcessPrototype();

		case PROCESSOR:
			return pkg.getProcessorPrototype();

		case SUBPROGRAM:
			return pkg.getSubprogramPrototype();

		case SUBPROGRAM_GROUP:
			return pkg.getSubprogramGroupPrototype();

		case SYSTEM:
			return pkg.getSystemPrototype();

		case THREAD:
			return pkg.getThreadPrototype();

		case THREAD_GROUP:
			return pkg.getThreadGroupPrototype();

		case VIRTUAL_BUS:
			return pkg.getVirtualBusPrototype();

		case VIRTUAL_PROCESSOR:
			return pkg.getVirtualProcessorPrototype();

		default:
			throw new RuntimeException("Unhandled case: " + type);
		}
	}
}
