/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluatedProperty.MpvProxy;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.OsateDebug;

/**
 * Evaluate the properties in the filter for every instance object and store the results as property
 * association instances. The values are looked up in the declarative model, so this switch must run
 * after {@link CacheContainedPropertyAssociationsSwitch}, which puts the contained associations in
 * place.
 *
 * @author lwrage
 */
public class CachePropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	private enum Severity {
		ERROR, WARNING
	}

	private record Issue(Severity severity, Element element, String message) {
	}

	/*
	 * PropertyFilter contains all properties used in the model.
	 */
	private final List<Property> propertyFilter;

	private final Map<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	private final Map<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private final SCProperties scProps;

	/**
	 * @since 4.0
	 */
	protected CachePropertyAssociationsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errManager,
			final List<Property> filter, final Map<InstanceObject, InstantiatedClassifier> classifierCache,
			final SCProperties scProps, final Map<ModeInstance, List<SystemOperationMode>> mode2som) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		propertyFilter = filter;
		this.classifierCache = classifierCache;
		this.scProps = scProps;
		this.mode2som = mode2som;
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				if (ci instanceof SystemInstance si) {
					var size = si.getComponentImplementation().getOwnedPropertyAssociations().size();
					monitor.subTask("Caching " + size + " property associations");
				} else if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Caching property associations in " + ci.getName());
				}

				cachePropertyAssociations(ci);
				return DONE;
			}

			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				cacheConnectionPropertyAssociations(conni);
				return DONE;
			}

			@Override
			public String caseConnectionReference(ConnectionReference cr) {
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				return DONE;
			}

			@Override
			public String caseInstanceObject(InstanceObject iobj) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				cachePropertyAssociations(iobj);
				return DONE;
			}
		};
	}

	protected void cachePropertyAssociations(InstanceObject io) {
		for (var property : propertyFilter) {
			if (io.acceptsProperty(property)) {
				try {
					/*
					 * Just look up the property. The property doesn't yet have a
					 * local association, so lookup will get the value from the
					 * declarative model. Property lookup process now corrects
					 * reference values to instance reference values.
					 */
					var result = property.evaluate(new EvaluationContext(io, classifierCache), 0);
					var evaluated = result.getEvaluated();

					if (!evaluated.isEmpty()) {
						var newPA = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();

						io.removePropertyAssociations(property);
						newPA.setProperty(property);
						newPA.setPropertyAssociation(getDeclarativePA(result.getPa()));
						var issues = fillPropertyValue(io, newPA, evaluated);
						if (!newPA.getOwnedValues().isEmpty()) {
							io.getOwnedPropertyAssociations().add(newPA);
							report(issues);
						}
					}
				} catch (IllegalStateException e) {
					// circular dependency
					// xxx: this is a misleading place to put the marker
					OsateDebug.osateDebug("IllegalStateException raised in cachePropertyAssociations");
					error(io, e.getMessage());
				} catch (InvalidModelException e) {
					OsateDebug.osateDebug("InvalidModelException raised in cachePropertyAssociations");
					error(e.getElement(), e.getMessage());
				}
			}
			checkIfCancelled();
			if (cancelled()) {
				break;
			}
		}
	}

	private static PropertyAssociation getDeclarativePA(PropertyAssociation pa) {
		while (pa instanceof PropertyAssociationInstance pai) {
			pa = pai.getPropertyAssociation();
		}
		return pa;
	}

	protected void cacheConnectionPropertyAssociations(final ConnectionInstance conni) {
		try {
			/*
			 * propertyFilter contains all properties used by the system, so, we try to
			 * use the one associated to the connection instance and their reference and
			 * see if the user declares a specific value.
			 */
			for (var prop : propertyFilter) {
				PropertyAssociation setPA = null;

				for (final var connRef : conni.getConnectionReferences()) {
					/*
					 * In the following piece of code, we check that a property
					 * is consistent all along the connection reference.
					 * For example, we check that the timing property (immediate, delayed)
					 * is consistent for each connection.
					 */
					if (!connRef.acceptsProperty(prop)) {
						continue;
					}
					/*
					 * Just look up the property. The property doesn't yet have
					 * a local association, so lookup will get the value from
					 * the declarative model. Property lookup process now
					 * corrects reference values to instance reference values.
					 */
					final var propAssociation = scProps.retrieveSCProperty(conni, prop, connRef.getConnection());
					final var ctx = new EvaluationContext(connRef, classifierCache, propAssociation);
					final var result = prop.evaluate(ctx, 0);
					final var evaluated = result.getEvaluated();

					if (evaluated.isEmpty()) {
						continue;
					}

					var newPA = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();

					newPA.setProperty(prop);
					newPA.setPropertyAssociation(getDeclarativePA(result.getPa()));
					fillPropertyValue(connRef, newPA, evaluated);
					if (newPA.getOwnedValues().isEmpty()) {
						continue;
					}
					/*
					 * The values were instantiated in the context of the connection reference, which
					 * resolves nothing that a containment path names, because a connection reference
					 * contains no instance objects. Retry what is left in the context of the connection's
					 * component instance, which is where a reference to a bus, a connection, or another
					 * part of the enclosing component resolves.
					 */
					instantiateConnectionReferenceValues(newPA, conni.getContainingComponentInstance());

					scProps.recordSCProperty(conni, prop, connRef.getConnection(), newPA);

					if (setPA == null) {
						setPA = newPA;
						conni.getOwnedPropertyAssociations().add(newPA);
					} else {
						checkConsistencyAlongConnection(conni, setPA, newPA);
					}
				}
				checkIfCancelled();
				if (cancelled()) {
					break;
				}
			}
		} catch (IllegalStateException e) {
			// circular dependency
			// xxx: this is a misleading place to put the marker
			error(conni, e.getMessage());
			OsateDebug.osateDebug("IllegalStateException raised in cacheConnectionPropertyAssociations");
		} catch (InvalidModelException e) {
			error(conni, e.getMessage());
			OsateDebug.osateDebug("InvalidModelException raised in cacheConnectionPropertyAssociations");
		}
	}

	/**
	 * Report an error if a property has different values on two connection references of the same
	 * semantic connection.
	 */
	private void checkConsistencyAlongConnection(final ConnectionInstance conni, final PropertyAssociation setPA,
			final PropertyAssociation newPA) {
		for (var som : conni.getSystemInstance().getSystemOperationModes()) {
			if (!newPA.valueInMode(som).sameAs(setPA.valueInMode(som))) {
				error(conni, "Value for property " + setPA.getProperty().getQualifiedName()
						+ " not consistent along connection");
				break;
			}
		}
	}

	private List<Issue> fillPropertyValue(InstanceObject io, PropertyAssociation pa, List<EvaluatedProperty> values) {
		final var issues = new ArrayList<Issue>();
		final var proxies = values.getFirst().getProxies();
		/*
		 * The values that the first one appends to, flattened into the elements that go in front of every
		 * modal value of the appending association, least specific first.
		 */
		final var appendedTo = new ArrayList<PropertyExpression>();

		for (var value : values.subList(1, values.size())) {
			var prx = value.getProxies().getFirst();

			if (prx.isModal()) {
				throw new InvalidModelException(pa, "Trying to append to a modal list value");
			}
			appendedTo.addAll(0, ((ListValue) prx.getValue()).getOwnedListElements());
		}

		for (var proxy : proxies) {
			var newVal = Aadl2Factory.eINSTANCE.createModalPropertyValue();

			newVal.setOwnedValue(EcoreUtil.copy(proxy.getValue()));
			if (!appendedTo.isEmpty()) {
				((ListValue) newVal.getOwnedValue()).getOwnedListElements().addAll(0,
						EcoreUtil.copyAll(appendedTo));
			}

			boolean valueIsUsed;
			if (!proxy.isModal()) {
				valueIsUsed = true;
				pa.getOwnedValues().add(newVal);
			} else {
				for (var som : systemOperationModesOf(io, proxy)) {
					if (io.isActive(som)) {
						newVal.getInModes().add(som);
					}
				}
				valueIsUsed = !newVal.getInModes().isEmpty();
				if (valueIsUsed) {
					pa.getOwnedValues().add(newVal);
				}
			}
			if (valueIsUsed) {
				// replace reference values in the context of the contained PA's owner
				issues.addAll(instantiateReferenceValues(newVal, io));
			}
		}
		return issues;
	}

	/**
	 * The system operation modes that the modes of a modal value map to for an instance object.
	 */
	private List<SystemOperationMode> systemOperationModesOf(final InstanceObject io, final MpvProxy proxy) {
		final var inSOMs = new ArrayList<SystemOperationMode>();

		for (var mode : proxy.getModes()) {
			if (mode instanceof SystemOperationMode som) {
				inSOMs.add(som);
			} else if (io instanceof ConnectionReference connRef) {
				var conniModes = ((ConnectionInstance) io.eContainer()).getInSystemOperationModes();
				if (conniModes.isEmpty()) {
					conniModes = io.getSystemInstance().getSystemOperationModes();
				}

				for (var mi : connRef.getContext().getModeInstances()) {
					if (mi.getMode() == mode) {
						for (var som : conniModes) {
							if (som.getCurrentModes().contains(mi)) {
								inSOMs.add(som);
							}
						}
						break;
					}
				}
			} else {
				var holderModes = io instanceof ComponentInstance ci ? ci.getModeInstances()
						: io.getContainingComponentInstance().getModeInstances();

				for (var mi : holderModes) {
					if (mi.getMode() == mode) {
						var soms = mode2som.get(mi);
						if (soms != null) {
							inSOMs.addAll(soms);
							break;
						}
					}
				}
			}
		}
		return inSOMs;
	}

	/**
	 * Replace the reference values of a cached value with references to the instance objects they denote
	 * in the context of {@code io}. Returns the problems found, which the caller reports only if it keeps
	 * the value.
	 * <p>
	 * A value that has already been instantiated is an {@link InstanceReferenceValue}, which is not a
	 * {@link ReferenceValue}, so the test below leaves it alone. The same holds for the other passes that
	 * instantiate reference values, here and in {@link CacheContainedPropertyAssociationsSwitch}.
	 */
	private static List<Issue> instantiateReferenceValues(final ModalPropertyValue value, final InstanceObject io) {
		final var issues = new ArrayList<Issue>();

		for (var elem : properContentsOf(value)) {
			if (elem instanceof ReferenceValue rv) {
				try {
					var irv = rv.instantiate(io);
					if (irv != null) {
						EcoreUtil.replace(rv, irv);
					} else {
						issues.add(new Issue(Severity.ERROR, rv,
								"Referenced element does not exist in the instance model"));
					}
				} catch (InvalidModelException e) {
					issues.add(new Issue(Severity.ERROR, io, e.getMessage()));
				}
			}
		}
		return issues;
	}

	/**
	 * Retry the reference values of a property association cached on a semantic connection that the
	 * connection reference could not resolve, this time in the context of the connection's component
	 * instance. The values that {@link #instantiateReferenceValues} has already replaced are
	 * {@link InstanceReferenceValue}s, which are not {@link ReferenceValue}s, so the test below leaves
	 * them alone; a value that this context cannot resolve either is left alone as well.
	 */
	private static void instantiateConnectionReferenceValues(final PropertyAssociationInstance pa,
			final ComponentInstance context) {
		for (var elem : properContentsOf(pa)) {
			if (elem instanceof ReferenceValue rv) {
				var irv = rv.instantiate(context);
				if (irv != null) {
					EcoreUtil.replace(rv, irv);
				}
			}
		}
	}

	private void report(final List<Issue> issues) {
		for (var issue : issues) {
			switch (issue.severity()) {
			case ERROR -> error(issue.element(), issue.message());
			case WARNING -> warning(issue.element(), issue.message());
			}
		}
	}

	/**
	 * The contents of an element, excluding the contents of cross-resource contained children, as an
	 * {@code Iterable} so that it can be used in an enhanced for statement.
	 */
	private static Iterable<Element> properContentsOf(final EObject root) {
		return () -> EcoreUtil.getAllProperContents(root, false);
	}
}
