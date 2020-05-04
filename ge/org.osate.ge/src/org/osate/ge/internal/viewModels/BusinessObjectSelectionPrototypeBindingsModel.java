/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.viewModels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.AadlPrototypeUtil;
import org.osate.ge.internal.util.ProjectUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.classifiers.PrototypeBindingsModel;

import com.google.common.base.Strings;

/**
 * Abstract base class for view models for selecting classifiers and configuring prototype bindings.
 *
 * Directions must be DirectionType or AccessType instances.
 */
public abstract class BusinessObjectSelectionPrototypeBindingsModel extends BaseObservableModel implements
PrototypeBindingsModel<PrototypeBindingsModelNode, Object, PrototypeBindingType, NamedElementOrDescription> {
	private Map<PrototypeBindingsModelNode, PrototypeBindingsModelNodeData> dataMap = new HashMap<>();
	private BusinessObjectSelection bos;
	private IProject project;
	private ResourceSet resourceSet;

	/**
	 * Indicates whether there are multiple unique values for the selected business object selection. If true, the editor will not display the current. New values will replace
	 * the current value of all selected business objects.
	 */
	private boolean multipleValues = false;

	/**
	 * Indicates that the model currently contains an unsupported value.
	 */
	private boolean unsupportedValue = false;

	/**
	 * Creates a new instance which uses the specified {@link BusinessObjectSelection}
	 * @param bos the business objects which to edit. Supported business object types are dependent on the child class.
	 */
	public BusinessObjectSelectionPrototypeBindingsModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public final Stream<PrototypeBindingsModelNode> getChildren(final PrototypeBindingsModelNode parent) {
		return data(parent).children.stream();
	}

	/**
	 * Should be overridden by subclasses to handle multiple selections, etc.
	 */
	@Override
	public String getValueLabel(final PrototypeBindingsModelNode node) {
		if (node == null && multipleValues) {
			return "<Multiple>";
		} else if (unsupportedValue) {
			return "<Unsupported Value>";
		}

		final Object direction = getDirection(node);
		final PrototypeBindingType type = getType(node);
		final NamedElementOrDescription classifier = getClassifier(node);

		final StringBuilder sb = new StringBuilder();
		if (direction != null) {
			sb.append(getDirectionLabel(direction));
			sb.append(" ");
		}

		if (type != null) {
			sb.append(getTypeLabel(type));
			sb.append(" ");
		}

		if (classifier != null) {
			sb.append(getClassifierLabel(classifier));
		}

		// Children
		final String bindings = getChildrenLabel(node);
		if (!bindings.isEmpty()) {
			sb.append("(");
			sb.append(bindings);
			sb.append(")");
		}

		return sb.toString();
	}

	@Override
	public String getChildrenLabel(final PrototypeBindingsModelNode node) {
		// Needed to display a label in the prototype bindings field when multiple classifiers are selected.
		if (multipleValues) {
			return "<Multiple Elements Selected>";
		} else if (unsupportedValue) {
			return "<Unsupported Value>";
		}

		return getChildren(node).filter(c -> getDirection(c) != null || getType(c) != null || getClassifier(c) != null)
				.map(c -> getLabel(c) + " => " + getValueLabel(c)).collect(Collectors.joining(", "));
	}

	@Override
	public final String getLabel(final PrototypeBindingsModelNode node) {
		// The root node never has a label.
		if (node == null) {
			return "";
		}

		final Object bo = data(node).bo;

		// Return the name of the node's business object as the label for the node
		if (bo == null) {
			return "";
		} else if (bo instanceof NamedElement) {
			return Strings.nullToEmpty(((NamedElement) bo).getName());
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}

	@Override
	public final Stream<Object> getDirectionOptions(final PrototypeBindingsModelNode node) {
		final PrototypeBindingType type = getType(node);
		if (type instanceof AccessSpecificationBindingType) {
			return Arrays.stream(AccessType.values()).map(Object.class::cast);
		} else if (type instanceof PortSpecificationBindingType) {
			return Arrays.stream(DirectionType.values()).map(Object.class::cast);
		} else if (type instanceof FeatureReferenceBindingType) {
			return Stream.of(null, DirectionType.IN, DirectionType.OUT).map(Object.class::cast);
		} else {
			return Stream.empty();
		}
	}

	@Override
	public final String getDirectionLabel(final Object direction) {
		if (direction == null) {
			return "";
		}

		return direction.toString();
	}

	@Override
	public final Object getDirection(final PrototypeBindingsModelNode node) {
		return data(node).direction;
	}

	@Override
	public final void setDirection(final PrototypeBindingsModelNode node, final Object value) {
		data(node).direction = value;
		triggerChangeEvent();
	}

	@Override
	public final Stream<PrototypeBindingType> getTypeOptions(final PrototypeBindingsModelNode node) {
		// Display type options based on the node's business object. Only feature prototypes have types.
		final Object bo = data(node).bo;
		if (bo instanceof FeaturePrototype) {
			return PrototypeBindingType.instances().stream();
		} else {
			return Stream.empty();
		}
	}

	@Override
	public final String getTypeLabel(final PrototypeBindingType type) {
		return type == null ? "" : type.getLabel();
	}

	@Override
	public final PrototypeBindingType getType(final PrototypeBindingsModelNode node) {
		return data(node).type;
	}

	@Override
	public final void setType(final PrototypeBindingsModelNode node, final PrototypeBindingType value) {
		data(node).type = value;
		triggerChangeEvent();
	}

	@Override
	public final Stream<NamedElementOrDescription> getClassifierOptions(final PrototypeBindingsModelNode node) {
		if (node == null) {
			return getClassifierOptionsForRoot();
		}

		final Object bo = data(node).bo;
		if (bo == null) {
			return Stream.empty();
		}

		final PrototypeBindingType type = getType(node);

		// Determine which EClasses and prototypes to show
		Stream<EClass> filterEClasses;
		Class<?> prototypeFilter;
		boolean includeNull = true;
		if (bo instanceof ComponentPrototype) {
			final ComponentCategory category = ((ComponentPrototype) bo).getCategory();
			filterEClasses = componentCategoryToPrototypeFilterTypeEClasses(category);
			prototypeFilter = ComponentPrototype.class;
		} else if (bo instanceof FeatureGroupPrototype) {
			filterEClasses = Stream.of(Aadl2Factory.eINSTANCE.getAadl2Package().getFeatureGroupType());
			prototypeFilter = FeatureGroupPrototype.class;
		} else if (bo instanceof FeaturePrototype && type instanceof AccessSpecificationBindingType
				|| type instanceof PortSpecificationBindingType) {
			filterEClasses = Stream.of(Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier());
			prototypeFilter = null;
		} else if (bo instanceof FeaturePrototype && type instanceof FeatureReferenceBindingType) {
			filterEClasses = Stream.empty();
			prototypeFilter = FeaturePrototype.class;
			includeNull = false;
		} else {
			filterEClasses = Stream.empty();
			prototypeFilter = null;
			includeNull = false;
		}

		Stream<NamedElementOrDescription> options = includeNull ? Stream.of((NamedElementOrDescription) null)
				: Stream.empty();

		// Concatenate all classifiers that match the supported EClass
		options = Stream.concat(options, filterEClasses.flatMap(eclass -> ScopedEMFIndexRetrieval
				.getAllEObjectsByType(project, eclass).stream().map(NamedElementOrDescription::new)));

		// Show appropriate prototypes
		if (prototypeFilter != null) {
			options = Stream.concat(options, getReferenceablePrototypes().filter(prototypeFilter::isInstance)
					.map(NamedElementOrDescription::new));
		}

		return options;
	}

	@Override
	public final String getClassifierLabel(final NamedElementOrDescription classifier) {
		if (classifier == null) {
			return "<None>";
		}

		return classifier.getQualifiedName();
	}

	@Override
	public final NamedElementOrDescription getClassifier(final PrototypeBindingsModelNode node) {
		return data(node).classifier;
	}

	@Override
	public final void setClassifier(final PrototypeBindingsModelNode node, final NamedElementOrDescription value) {
		setNodeDataClassifier(node, value);
		triggerChangeEvent();
	}

	/**
	 * Gets the node data for the specified node. Creates a new data instance if it doesn't already exist.
	 * @param node is the node for which to retrieve the node data.
	 * @return the node data
	 */
	protected PrototypeBindingsModelNodeData data(final PrototypeBindingsModelNode node) {
		return dataMap.computeIfAbsent(node, n -> new PrototypeBindingsModelNodeData());
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		this.project = AadlHelper.getCommonProject(this.bos.boStream(Element.class).collect(Collectors.toList()))
				.orElse(null);
		this.resourceSet = project == null ? null : ProjectUtil.getLiveResourceSet(project);

		// Clear data
		multipleValues = false;
		unsupportedValue = false;
		dataMap.clear();

		if (project != null) {
			loadData();

			// Clear any partially populated data if an unsupported value was detected. This will prevent editing of such a value.
			if (unsupportedValue) {
				dataMap.clear();
			}
		}

		triggerChangeEvent();
	}

	@Override
	public final String validateNode(final PrototypeBindingsModelNode node) {
		return validateClassifierAndChildren(node, 1);
	}

	/**
	 * Validates just the classifier and children. Does not validate top level type and direction.
	 * This is expected behavior because this view model is used for cases such as a select classifier dialog
	 * where validation of the type of the same level is not desired.
	 * @param node is the node to validate.
	 * @param depthToValidate is the number of additional levels of children to validate. 0 disabled the validation of children.
	 * @return an error message describing an error if validation fails. Otherwise, null.
	 */
	private final String validateClassifierAndChildren(final PrototypeBindingsModelNode node,
			final int depthToValidate) {
		final PrototypeBindingsModelNodeData data = data(node);

		// Perform validation for the classifier of feature prototypes.
		if (data.bo instanceof FeaturePrototype) {
			final PrototypeBindingType type = data.type;
			if (type instanceof FeatureReferenceBindingType) {
				if (data.classifier == null
						|| !(data.classifier.getResolvedValue(resourceSet) instanceof FeaturePrototype)) {
					return "Component classifier not set";
				}
			}
		}

		// Stop recursing if we've reached the requested depth
		if (depthToValidate <= 0) {
			return null;
		}

		// Check children
		return getChildren(node).map(c -> {
			final String error = validateChild(c, depthToValidate - 1);
			return error == null ? error : getLabel(c) + ": " + error;
		}).filter(e -> e != null).findFirst().orElse(null);
	}

	/**
	 * Validates a node's classifier and children and then performs validation of the direction of access and port specifications.
	 * @param node is the node to validate.
	 * @param depthToValidate is the number of additional levels of children to validate. 0 disabled the validation of children.
	 * @return an error message describing an error if validation fails. Otherwise, null.
	 */
	private final String validateChild(final PrototypeBindingsModelNode node, final int depthToValidate) {
		final String result = validateClassifierAndChildren(node, depthToValidate);
		if (result != null) {
			return result;
		}

		final PrototypeBindingsModelNodeData data = data(node);

		// Perform validation for feature prototypes. Feature prototypes have multiple fields and multiple fields must be set in order for the binding to be
		// saved.
		if (data.bo instanceof FeaturePrototype) {
			// Validate current state of data
			final PrototypeBindingType type = data.type;
			if (type instanceof AccessSpecificationBindingType) {
				if (!(data.direction instanceof AccessType)) {
					return "Access type not set";
				}
			} else if (type instanceof PortSpecificationBindingType) {
				if (!(data.direction instanceof DirectionType)) {
					return "Port direction not set";
				}
			}
		}

		return null;
	}

	/**
	 * Sets the multiple values flag.
	 * @param value the new value
	 */
	protected final void setMultipleValues(final boolean value) {
		this.multipleValues = value;
	}

	protected final BusinessObjectSelection getBusinessObjectSelection() {
		return bos;
	}

	protected final ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Returns the classifier options for the root. Intended to be overridden by subclasses.
	 * @return the classifier options for the root.
	 */
	protected Stream<NamedElementOrDescription> getClassifierOptionsForRoot() {
		return Stream.empty();
	}

	/**
	 * Returns the prototypes which are available based on the current selection.
	 * @return the prototypes which are available for referencing.
	 */
	protected abstract Stream<Prototype> getReferenceablePrototypes();

	/**
	 * Updates the state of the model based on the currently set business object selection
	 */
	protected abstract void loadData();

	/**
	 * Returns whether a classifier has any prototypes for which bindings can be created or modified.
	 * @param classifier is classifier to check.
	 * @return whether the specified classifier has any prototypes for which bindings can be created or modified.
	 */
	public static boolean hasAvailableBindings(final Classifier classifier) {
		return AadlPrototypeUtil.getAllPrototypes(getExtendedOrImplemented(classifier)).limit(1).count() != 0;
	}

	/**
	 * Gets the extended classifier or the implemented type.
	 * @param bo the classifier for which to get the extended classifier or implemented type.
	 * @return the extended classifier or implemented type. Null of neither of those exists or if the business object is not a classifier.
	 */
	private static Classifier getExtendedOrImplemented(final EObject bo) {
		if (!(bo instanceof Classifier)) {
			return null;
		}

		final Classifier classifier = (Classifier) bo;
		Classifier result = classifier.getExtended();
		if (result == null && bo instanceof ComponentImplementation) {
			result = ((ComponentImplementation) bo).getType();
		}

		return result;
	}

	// Populate the model's data structure based on the specified bindings
	protected void loadBindingData(final PrototypeBindingsModelNode parent,
			final Collection<PrototypeBinding> bindings) {
		for (final PrototypeBinding b : bindings) {
			// Create a new node for the binding
			PrototypeBindingsModelNode newChild = new PrototypeBindingsModelNode(parent, b);

			// Ignore null bindings
			if (b == null) {

			} else if (b instanceof ComponentPrototypeBinding) {
				final List<ComponentPrototypeActual> actuals = ((ComponentPrototypeBinding) b).getActuals();
				// If the actual specified multiple values, flag the model as having an unsupported value
				if (actuals.size() == 1) {
					final ComponentPrototypeActual actual = actuals.get(0);
					if (actual != null) {
						setNodeDataClassifier(newChild, actual.getSubcomponentType());
						loadBindingData(newChild, actual.getBindings());
					}
				} else {
					unsupportedValue = true;
					return;
				}
			} else if (b instanceof FeatureGroupPrototypeBinding) {
				final FeatureGroupPrototypeActual actual = ((FeatureGroupPrototypeBinding) b).getActual();
				if (actual != null) {
					setNodeDataClassifier(newChild, actual.getFeatureType());
					loadBindingData(newChild, actual.getBindings());
				}
			} else if (b instanceof FeaturePrototypeBinding) {
				final FeaturePrototypeActual actual = ((FeaturePrototypeBinding) b).getActual();

				// Populate data based on the type of actual
				if (actual == null) {
				} else if (actual instanceof AccessSpecification) {
					final AccessSpecification as = (AccessSpecification) actual;
					data(newChild).direction = as.getKind();
					data(newChild).type = new AccessSpecificationBindingType(as.getCategory());
					setNodeDataClassifier(newChild, as.getClassifier());
				} else if (actual instanceof FeaturePrototypeReference) {
					final FeaturePrototypeReference fpr = (FeaturePrototypeReference) actual;
					data(newChild).direction = fpr.getDirection();
					data(newChild).type = new FeatureReferenceBindingType();
					setNodeDataClassifier(newChild, fpr.getPrototype());
				} else if (actual instanceof PortSpecification) {
					final PortSpecification ps = (PortSpecification) actual;
					data(newChild).direction = ps.getDirection();
					data(newChild).type = new PortSpecificationBindingType(ps.getCategory());
					setNodeDataClassifier(newChild, ps.getClassifier());
				} else {
					throw new RuntimeException("Unhandled feature prototype actual type: " + actual);
				}
			} else {
				throw new RuntimeException("Unhandled prototype binding type: " + b);
			}
		}
	}

	protected final void setNodeDataClassifier(final PrototypeBindingsModelNode node, final EObject classifierValue) {
		if (classifierValue == null || classifierValue instanceof NamedElement) {
			setNodeDataClassifier(node,
					classifierValue == null ? null : new NamedElementOrDescription((NamedElement) classifierValue));
		} else {
			throw new RuntimeException("Unexpected object type: " + classifierValue);
		}
	}

	protected final void setNodeDataClassifier(final PrototypeBindingsModelNode node,
			final IEObjectDescription classifierValue) {
		setNodeDataClassifier(node, new NamedElementOrDescription(classifierValue));
	}

	/**
	 * Sets the classifier field of the node data and creates children.
	 * @param node the node for which to set the classifier and create children.
	 * @param classifierValue the new value for the classifier field
	 */
	private final void setNodeDataClassifier(final PrototypeBindingsModelNode node,
			final NamedElementOrDescription classifierValue) {
		data(node).classifier = classifierValue;
		data(node).children.clear();

		if (classifierValue != null) {
			// Only support children for business objects which support bindings
			final Object bo = data(node).bo;
			if (bo instanceof Classifier || bo instanceof Subcomponent || bo instanceof ComponentPrototype
					|| bo instanceof FeatureGroupPrototype) {

				// We need to get an actual EObject to determine children.
				final EObject eobj = classifierValue.getResolvedValue(resourceSet);

				final EObject prototypeSource = bo instanceof Classifier ? getExtendedOrImplemented(eobj) : eobj;

				// Get all the prototypes for the business object and create a child node for each of them
				AadlPrototypeUtil.getAllPrototypes(prototypeSource).forEachOrdered(c -> {
					final PrototypeBindingsModelNode newChild = new PrototypeBindingsModelNode(node, c);
					data(node).children.add(newChild);
					data(newChild).bo = c;
				});
			}
		}
	}

	/**
	 * Creates new prototype binding business objects based on the state of the model. Bindings which are not valid are ignored.
	 * @param parent is the parent node for binding. Used to retrieve child binding nodes.
	 * @param classifier is the classifier which to use to retrieve prototypes
	 * @param boBeingModified is the top level business object which is being modified. Used to add imports to appropriate package.
	 * @param newBindings is the list to which to add created bindings.
	 */
	protected final void createNewBindings(final PrototypeBindingsModelNode parent, final Object classifier,
			final Element boBeingModified, final List<PrototypeBinding> newBindings) {
		final Aadl2Factory f = Aadl2Factory.eINSTANCE;

		// Check for a binding for each prototype of the specified classifier
		AadlPrototypeUtil.getAllPrototypes(classifier).forEachOrdered(p -> {
			final PrototypeBindingsModelNode child = new PrototypeBindingsModelNode(parent, p);
			final PrototypeBindingsModelNodeData cd = data(child);
			final EObject childClassifier = cd.classifier == null ? null : cd.classifier.getResolvedValue(getResourceSet());

			if (p instanceof ComponentPrototype) {
				// Ignore classifiers which are not of the appropriate type. They could be carry overs from children which no longer exist
				if (childClassifier instanceof SubcomponentType) {
					final ComponentPrototypeBinding b = f.createComponentPrototypeBinding();
					b.setFormal(p);
					final ComponentPrototypeActual a = b.createActual();

					// Set subcomponent type and create child bindings
					a.setSubcomponentType((SubcomponentType) childClassifier);
					AadlImportsUtil.ensurePackageIsImportedForClassifier(boBeingModified, childClassifier);
					createNewBindings(child, childClassifier, boBeingModified, a.getBindings());

					// Determine and set the component category
					final ComponentCategory category;
					if (childClassifier instanceof ComponentClassifier) {
						category = ((ComponentClassifier) childClassifier).getCategory();
					} else if (childClassifier instanceof ComponentPrototype) {
						category = ((ComponentPrototype) childClassifier).getCategory();
					} else {
						category = null;
					}

					if (category == null) {
						throw new RuntimeException("Unable to determine component category for " + childClassifier);
					}

					a.setCategory(category);

					// Add the binding to the specified list
					newBindings.add(b);
				}
			} else if (p instanceof FeatureGroupPrototype) {
				if (childClassifier instanceof FeatureType) {
					// Create the binding and the actual
					final FeatureGroupPrototypeBinding b = f.createFeatureGroupPrototypeBinding();
					b.setFormal(p);
					final FeatureGroupPrototypeActual a = b.createActual();

					// Set feature type and create child bindings
					a.setFeatureType((FeatureType) childClassifier);
					AadlImportsUtil.ensurePackageIsImportedForClassifier(boBeingModified, childClassifier);
					createNewBindings(child, childClassifier, boBeingModified, a.getBindings());

					// Add the binding to the specified list
					newBindings.add(b);
				}
			} else if (p instanceof FeaturePrototype) {
				// Ignore any bindings for which a type is not set
				if (cd.type != null) {
					final FeaturePrototypeBinding b = f.createFeaturePrototypeBinding();
					b.setFormal(p);

					if (cd.type instanceof AccessSpecificationBindingType) {
						if (cd.direction instanceof AccessType) {
							final AccessSpecificationBindingType type = (AccessSpecificationBindingType) cd.type;
							final AccessSpecification actual = (AccessSpecification) b
									.createActual(Aadl2Package.eINSTANCE.getAccessSpecification());

							// Configure the category and kind of the access specification
							actual.setCategory(type.getCategory());
							actual.setKind((AccessType) cd.direction);

							// Set optional classifier
							if (childClassifier instanceof ComponentClassifier) {
								actual.setClassifier((ComponentClassifier) childClassifier);
								AadlImportsUtil.ensurePackageIsImportedForClassifier(boBeingModified, childClassifier);
							}
						}
					} else if (cd.type instanceof PortSpecificationBindingType) {
						if (cd.direction instanceof DirectionType) {
							final PortSpecificationBindingType type = (PortSpecificationBindingType) cd.type;
							final PortSpecification actual = (PortSpecification) b
									.createActual(Aadl2Package.eINSTANCE.getPortSpecification());
							actual.setCategory(type.getCategory());

							// Set the direction
							final DirectionType direction = (DirectionType) cd.direction;
							switch (direction) {
							case IN:
								actual.setIn(true);
								actual.setOut(false);
								break;
							case OUT:
								actual.setIn(false);
								actual.setOut(true);
								break;
							case IN_OUT:
								actual.setIn(true);
								actual.setOut(true);
								break;
							}

							// Set optional classifier
							if (childClassifier instanceof ComponentClassifier) {
								AadlImportsUtil.ensurePackageIsImportedForClassifier(boBeingModified, childClassifier);
								actual.setClassifier((ComponentClassifier) childClassifier);
							}
						}
					} else if (cd.type instanceof FeatureReferenceBindingType) {
						// Classifier is required
						if (childClassifier instanceof FeaturePrototype) {
							final FeaturePrototypeReference actual = (FeaturePrototypeReference) b
									.createActual(Aadl2Package.eINSTANCE.getFeaturePrototypeReference());

							// Direction is optional. Ignore IN_OUT as it is not a valid option
							if (cd.direction instanceof DirectionType) {
								final DirectionType direction = (DirectionType) cd.direction;
								switch (direction) {
								case IN:
									actual.setIn(true);
									actual.setOut(false);
									break;
								case OUT:
									actual.setIn(false);
									actual.setOut(true);
									break;
								default:
									break;
								}
							}

							actual.setPrototype((FeaturePrototype) childClassifier);
						}
					} else {
						throw new RuntimeException("Unexpected type: " + cd.type);
					}

					// Don't add the binding if it wasn't completely created
					if (b.getActual() != null) {
						// Add the binding to the specified list
						newBindings.add(b);
					}
				}
			} else {
				throw new RuntimeException("Unexpected prototype class: " + p);
			}
		});
	}

	// Returns a stream containing EClass instances to use to filter component prototype classifier options
	private static Stream<EClass> componentCategoryToPrototypeFilterTypeEClasses(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case ABSTRACT:
			return Stream.of(p.getAbstractClassifier(), p.getSystemClassifier(), p.getProcessClassifier(),
					p.getThreadGroupClassifier(), p.getThreadClassifier(), p.getSubprogramClassifier(),
					p.getSubprogramGroupClassifier(), p.getDataClassifier(), p.getVirtualBusClassifier(),
					p.getVirtualProcessorClassifier(), p.getBusClassifier(), p.getProcessorClassifier(),
					p.getDeviceClassifier(), p.getMemoryClassifier());

		case SYSTEM:
			return Stream.of(p.getSystemClassifier());

		case PROCESS:
			return Stream.of(p.getProcessClassifier());

		case THREAD_GROUP:
			return Stream.of(p.getThreadGroupClassifier());

		case THREAD:
			return Stream.of(p.getThreadClassifier());

		case SUBPROGRAM:
			return Stream.of(p.getSubprogramClassifier());

		case SUBPROGRAM_GROUP:
			return Stream.of(p.getSubprogramGroupClassifier());

		case DATA:
			return Stream.of(p.getDataClassifier());

		case VIRTUAL_BUS:
			return Stream.of(p.getVirtualBusClassifier());

		case VIRTUAL_PROCESSOR:
			return Stream.of(p.getVirtualProcessorClassifier());

		case BUS:
			return Stream.of(p.getBusClassifier());

		case PROCESSOR:
			return Stream.of(p.getProcessorClassifier());

		case DEVICE:
			return Stream.of(p.getDeviceClassifier());

		case MEMORY:
			return Stream.of(p.getMemoryClassifier());

		default:
			throw new RuntimeException("Unexpected category: " + category);
		}
	}

}

/**
 * The "Node" for the prototype bindings model. It is a class that provide a reference to a specific prototype binding.
 */
class PrototypeBindingsModelNode {
	private PrototypeBindingsModelNode parent;
	private final String key;

	public PrototypeBindingsModelNode(final PrototypeBindingsModelNode parent, final PrototypeBinding binding) {
		this.parent = parent;
		this.key = Strings.nullToEmpty(binding.getFormal().getName()).toLowerCase();
	}

	public PrototypeBindingsModelNode(final PrototypeBindingsModelNode parent, final Prototype prototype) {
		this.parent = parent;
		this.key = Strings.nullToEmpty(prototype.getName()).toLowerCase();
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, parent);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PrototypeBindingsModelNode other = (PrototypeBindingsModelNode) obj;
		return Objects.equals(key, other.key) && Objects.equals(parent, other.parent);
	}

	@Override
	public String toString() {
		return (parent == null ? parent : parent.toString()) + "/" + key;
	}

	public final String getKey() {
		return key;
	}
}

/**
 * Used to store actual data associated with a node. Will be retained even if the
 */
class PrototypeBindingsModelNodeData {
	public Object direction;
	public PrototypeBindingType type;
	public NamedElementOrDescription classifier;
	public Object bo; // Excepted to be either the root BO or a Prototype instance

	/**
	 * List of children based on the node's list of prototypes. Node data from previous children is retained but the children list reflects
	 * the children which will be shown in the UI.
	 */
	public final Set<PrototypeBindingsModelNode> children = new TreeSet<>(
			(n1, n2) -> n1.getKey().compareTo(n2.getKey()));
}

/**
 * This class and subclasses represent a "type" in the context of the {@link BusinessObjectSelectionPrototypeBindingsModel} class.
 */
abstract class PrototypeBindingType {
	private static final List<PrototypeBindingType> instances = new ArrayList<>();

	static {
		instances.add(null);

		for (final PortCategory category : PortCategory.values()) {
			instances.add(new PortSpecificationBindingType(category));
		}

		for (final AccessCategory category : AccessCategory.values()) {
			instances.add(new AccessSpecificationBindingType(category));
		}

		instances.add(new FeatureReferenceBindingType());
	}

	/**
	 * Returns the list of all types. The type list is populated once based on AADL meta model enumerations.
	 * @return a list of all types.
	 */
	public static List<PrototypeBindingType> instances() {
		return Collections.unmodifiableList(instances);
	}

	/**
	 * Returns a label which is appropriate to display to the user.
	 * @return the label for the type.
	 */
	public abstract String getLabel();
}

class PortSpecificationBindingType extends PrototypeBindingType {
	private final PortCategory category;

	public PortSpecificationBindingType(final PortCategory category) {
		this.category = Objects.requireNonNull(category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category);
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
		PortSpecificationBindingType other = (PortSpecificationBindingType) obj;
		return category == other.category;
	}

	@Override
	public String getLabel() {
		return StringUtil.camelCaseToUser(this.category.toString()).toLowerCase() + " port";
	}

	public final PortCategory getCategory() {
		return category;
	}
}

class AccessSpecificationBindingType extends PrototypeBindingType {
	private final AccessCategory category;

	public AccessSpecificationBindingType(final AccessCategory category) {
		this.category = Objects.requireNonNull(category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AccessSpecificationBindingType other = (AccessSpecificationBindingType) obj;
		return category == other.category;
	}

	@Override
	public String getLabel() {
		return this.category.toString() + " access";
	}

	public final AccessCategory getCategory() {
		return category;
	}
}

class FeatureReferenceBindingType extends PrototypeBindingType {
	@Override
	public String getLabel() {
		return "prototype";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		return true;
	}
}