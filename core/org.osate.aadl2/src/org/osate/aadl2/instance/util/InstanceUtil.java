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
package org.osate.aadl2.instance.util;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * @author lwrage
 */
public class InstanceUtil {

	/**
	 * @author lwrage
	 */
	// TODO-LW: handle arrays
	public static class InstantiatedClassifier {
		/** Special value used to represent NULL return value in the classifier cache. */
		public static final InstantiatedClassifier NULL = new InstantiatedClassifier(null, null);

		/**
		 *
		 */
		public Classifier classifier;
		/**
		 *
		 */
		public EList<PrototypeBinding> bindings;

		InstantiatedClassifier() {
		}

		public InstantiatedClassifier(Classifier classifier, EList<PrototypeBinding> bindings) {
			this.classifier = classifier;
			this.bindings = bindings;
		}
	}

	public static EList<PrototypeBinding> noBindings = new BasicEList<PrototypeBinding>();

	/**
	 * Get the component type of a component instance. Resolve prototypes if
	 * needed.
	 *
	 * @param ci the component instance
	 * @param index the index of the instance object in an array
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return the component type
	 */
	public static ComponentType getComponentType(ComponentInstance ci, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		ComponentType type = null;

		if (ci instanceof SystemInstance) {
			type = ((SystemInstance) ci).getComponentImplementation().getType();
		} else {
			final InstantiatedClassifier ic = getInstantiatedClassifier(ci, index, classifierCache);

			if (ic != null) {
				ComponentClassifier cc = (ComponentClassifier) ic.classifier;

				if (cc != null && cc instanceof ComponentImplementation) {
					if (cc instanceof ComponentImplementation) {
						type = ((ComponentImplementation) cc).getType();
					}
				} else {
					type = (ComponentType) cc;
				}
			}
		}
		return type;
	}

	/**
	 * Get the component implementation of a component instance. Resolve
	 * prototypes if needed.
	 *
	 * @param ci the component instance
	 * @param index the index of the instance object in an array
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return the component implementation
	 */
	public static ComponentImplementation getComponentImplementation(ComponentInstance ci, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		ComponentImplementation impl = null;
		if (ci instanceof SystemInstance) {
			impl = ((SystemInstance) ci).getComponentImplementation();
		} else {
			final InstantiatedClassifier ic = getInstantiatedClassifier(ci, index, classifierCache);

			if (ic != null) {
				final ComponentClassifier cc = (ComponentClassifier) ic.classifier;

				if (cc != null && cc instanceof ComponentImplementation) {
					impl = (ComponentImplementation) cc;
				}
			}
		}
		return impl;
	}

	/**
	 * Get the component classifier of a component instance. Resolve
	 * prototypes if needed.
	 *
	 * @param ci the component instance
	 * @param index the index of the instance object in an array
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return the component classifier
	 */
	public static ComponentClassifier getComponentClassifier(ComponentInstance ci, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		ComponentClassifier cc = null;
		if (ci instanceof SystemInstance) {
			cc = ((SystemInstance) ci).getComponentImplementation();
		} else {
			final InstantiatedClassifier ic = getInstantiatedClassifier(ci, index, classifierCache);

			if (ic != null) {
				cc = (ComponentClassifier) ic.classifier;
			}
		}
		return cc;
	}

	/**
	 * Get the feature group classifier of a feature instance. Resolve
	 * prototypes if needed.
	 *
	 * @param fi the feature instance
	 * @param index the index of the instance object in an array
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return the feature group classifier, null if the feature instance isn't a feature group
	 */
	public static FeatureGroupType getFeatureGroupType(FeatureInstance fi, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		FeatureGroupType fgt = null;
		if (fi.getCategory() == FeatureCategory.FEATURE_GROUP) {
			final InstantiatedClassifier ic = getInstantiatedClassifier(fi, index, classifierCache);

			if (ic != null) {
				fgt = (FeatureGroupType) ic.classifier;
			}
		}
		return fgt;
	}

	/**
	 * Get the component or feature group classifier that is instantiated by an
	 * instance object. Resolve prototypes if needed.
	 *
	 * @param iobj the instance object
	 * @param index the index of the instance object in an array
	 * @return the instantiated classifier together with bindings for anonymous
	 *         classifiers
	 */
	public static InstantiatedClassifier getInstantiatedClassifier(InstanceObject iobj, int index) {
		return getInstantiatedClassifier(iobj, index, null);
	}

	/**
	 * Get the component or feature group classifier that is instantiated by an
	 * instance object. Resolve prototypes if needed.
	 *
	 * @param iobj the instance object
	 * @param index the index of the instance object in an array
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return the instantiated classifier together with bindings for anonymous
	 *         classifiers
	 */
	public static InstantiatedClassifier getInstantiatedClassifier(InstanceObject iobj, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		InstantiatedClassifier ic = null;

		if (classifierCache != null) {
			final InstantiatedClassifier temp = classifierCache.get(iobj);
			if (temp != null) {
				return temp == InstantiatedClassifier.NULL ? null : temp;
			}
		}
		if (iobj instanceof SystemInstance) {
			ic = new InstantiatedClassifier(((SystemInstance) iobj).getComponentImplementation(), null);
		}
		if (ic == null) {
			Classifier classifier = null;
			EList<PrototypeBinding> prototypeBindings = null;
			Prototype prototype = null;
			if (iobj instanceof ComponentInstance) {
				Subcomponent sub = ((ComponentInstance) iobj).getSubcomponent();

				classifier = sub.getClassifier();
				prototypeBindings = sub.getOwnedPrototypeBindings();
				prototype = sub.getPrototype();
			} else if (iobj instanceof FeatureInstance) {
				FeatureType ft = ((FeatureGroup) ((FeatureInstance) iobj).getFeature()).getFeatureType();

				classifier = (ft instanceof Classifier) ? (Classifier) ft : null;
				prototype = (ft instanceof Prototype) ? (Prototype) ft : null;
			} else {
				return null;
			}
			if (classifier != null) {
				ic = new InstantiatedClassifier(classifier, prototypeBindings);
			}

			// no classifier => try prototype
			if (ic == null) {
				if (prototype != null) {
					// resolve prototype
					if (prototype instanceof ComponentPrototype) {
						ComponentPrototypeActual cpa = resolveComponentPrototype(prototype, iobj, classifierCache);

						if (cpa != null) {
							ic = new InstantiatedClassifier((ComponentClassifier) cpa.getSubcomponentType(),
									cpa.getBindings());
						} else {
							// ISSUE 986: If the constraining classifier is missing (null), then don't create an InstantiatedClassifier object
							final ComponentClassifier cc = ((ComponentPrototype) prototype).getConstrainingClassifier();
							if (cc != null) {
								ic = new InstantiatedClassifier(cc, noBindings);
							}
						}
					} else if (prototype instanceof FeatureGroupPrototype) {
						FeatureGroupPrototypeActual fpa = resolveFeatureGroupPrototype(prototype, iobj,
								classifierCache);

						if (fpa != null) {
							ic = new InstantiatedClassifier((FeatureGroupType) fpa.getFeatureType(), fpa.getBindings());
						} else {
							ic = new InstantiatedClassifier(
									((FeatureGroupPrototype) prototype).getConstrainingFeatureGroupType(), noBindings);
						}
					}
				}
			}
		}

		if (classifierCache != null) {
			classifierCache.put(iobj, ic == null ? InstantiatedClassifier.NULL : ic);
		}

		return ic;
	}

	/**
	 * Find the binding for a given component prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a
	 *            subcomponent instance
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return The component prototype actual that the prototype resolves to.
	 */
	public static ComponentPrototypeActual resolveComponentPrototype(Prototype proto, InstanceObject context,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		ComponentPrototypeActual cpa = null;
		ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) resolvePrototype(proto, context, classifierCache);

		if (cpb == null) {
			// cannot resolve
			return null;
		}
		EList<ComponentPrototypeActual> actuals = cpb.getActuals();

		if (actuals != null && actuals.size() > 0) {
			ComponentPrototypeActual actual = actuals.get(0);

			if (actual.getSubcomponentType() instanceof ComponentClassifier) {
				cpa = actual;
			} else {
				// resolve recursively
				cpa = resolveComponentPrototype((ComponentPrototype) actual.getSubcomponentType(),
						context.getContainingComponentInstance(), classifierCache);
			}
		}
		return cpa;
	}

	/**
	 * Find the binding for a given feature group prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a
	 *            subcomponent instance
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return The feature group prototype actual the prototype is bound to.
	 */
	public static FeatureGroupPrototypeActual resolveFeatureGroupPrototype(Prototype proto, InstanceObject context,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		FeatureGroupPrototypeActual result = null;
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) resolvePrototype(proto, context,
				classifierCache);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		FeatureGroupPrototypeActual actual = fgpb.getActual();

		if (actual.getFeatureType() instanceof FeatureGroupType) {
			result = actual;
		} else {
			// resolve recursively
			result = resolveFeatureGroupPrototype((FeatureGroupPrototype) actual.getFeatureType(),
					context.getContainingComponentInstance(), classifierCache);
		}
		return result;
	}

	/**
	 * Find the binding for a given feature prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a
	 *            subcomponent instance
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return The actual feature this prototype resolves to.
	 */
	public static FeaturePrototypeActual resolveFeaturePrototype(Prototype proto, InstanceObject context,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		FeaturePrototypeActual result = null;
		FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) resolvePrototype(proto, context, classifierCache);

		if (fpb == null) {
			return null;
		}
		result = fpb.getActual();
		if (result instanceof FeaturePrototypeReference) {
			// resolve recursively
			result = resolveFeaturePrototype(((FeaturePrototypeReference) fpb.getActual()).getPrototype(),
					context.getContainingComponentInstance(), classifierCache);
		}
		return result;
	}

	/**
	 * Find the binding for a given prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a
	 *            subcomponent instance
	 * @param classifierCache an optional cache of known instantiated
	 *            classifiers, may be null
	 * @return The binding that assigns the value to the prototype relative to
	 *         its usage context.
	 */
	public static PrototypeBinding resolvePrototype(Prototype proto, InstanceObject context,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		PrototypeBinding result = null;
		InstanceObject parent = (InstanceObject) context.getOwner();

		// prototype binding may be attached to parent (anonymous component classifier)
		if (parent instanceof SystemInstance) {
			ComponentImplementation impl = ((SystemInstance) parent).getComponentImplementation();

			if (impl == null) {
				return null;
			}
			result = impl.lookupPrototypeBinding(proto);
		} else if (parent instanceof ComponentInstance) {
			Subcomponent parentSub = ((ComponentInstance) parent).getSubcomponent();

			if (parentSub == null) {
				return null;
			}
			result = parentSub.lookupPrototypeBinding(proto);
		}
		// lookup in parent's classifier (nested prototype bindings)
		if (result == null && parent != null) {
			InstantiatedClassifier parentClassifier = getInstantiatedClassifier(parent, 0, classifierCache);

			if (parentClassifier.bindings != null) {
				for (PrototypeBinding binding : parentClassifier.bindings) {
					if (binding.getFormal() == proto) {
						result = binding;
						break;
					}
				}
			}
			if (result == null) {
				result = parentClassifier.classifier.lookupPrototypeBinding(proto);
			}
		}
		return result;
	}

	public static final String NORMAL_SOM_NAME = "No Modes";

	public static boolean isNoMode(SystemOperationMode som) {
		return som.getName().equalsIgnoreCase(NORMAL_SOM_NAME) || som.getName().equalsIgnoreCase("NoModes");
	}

	/**
	 * find connection instance with connection of name "name" in component instance
	 * @param ci
	 * @param name
	 * @return
	 */
	public static ConnectionInstance findConnectionInstance(ComponentInstance ci, Connection conn) { // String name) {
		for (ConnectionInstance ei : ci.getConnectionInstances()) {
			for (ConnectionReference connref : ei.getConnectionReferences()) {
//				Connection conn = connref.getConnection();
				if (conn == connref.getConnection()) {
					return ei;
				}
			}
		}
		return null;
	}

	public static ComponentInstance findConnectionContext(ConnectionInstance conni, Connection conn) {
		for (ConnectionReference connref : conni.getConnectionReferences()) {
//			Connection conn = connref.getConnection();
			if (conn == connref.getConnection()) {
				return connref.getContext();
			}
		}
		return null;
	}

	/**
	 * return cross connection of a connection instance
	 * @param conni
	 * @return Connection
	 */
	public static Connection getCrossConnection(ConnectionInstance conni) {
		for (ConnectionReference connref : conni.getConnectionReferences()) {
			Connection conn = connref.getConnection();
			if (conn.getSource().getContext() instanceof Subcomponent
					&& conn.getDestination().getContext() instanceof Subcomponent) {
				return conn;
			}
		}
		return null;
	}

}
