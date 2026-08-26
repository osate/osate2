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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.Aadl2Util;

/**
 * Copy the contained property associations of the declarative model to the instance objects they apply
 * to. The expressions are not evaluated here; only reference values are turned into references to
 * instance objects. {@link CachePropertyAssociationsSwitch} evaluates the properties afterwards.
 *
 * @author lwrage
 */
public class CacheContainedPropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	private enum Severity {
		ERROR, WARNING
	}

	private record Issue(Severity severity, Element element, String message) {
	}

	private final Map<InstanceObject, InstantiatedClassifier> classifierCache;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private final SCProperties scProps;

	/*
	 * The property definitions to cache, or null to cache all of them.
	 */
	private final List<Property> propertyFilter;

	protected CacheContainedPropertyAssociationsSwitch(
			final Map<InstanceObject, InstantiatedClassifier> classifierCache, SCProperties scProps,
			final IProgressMonitor pm, final AnalysisErrorReporterManager errManager) {
		this(classifierCache, scProps, pm, errManager, null);
	}

	/**
	 * @param propertyFilter cache only these property definitions, or <code>null</code> to cache all of
	 *            them
	 * @since 3.2
	 */
	protected CacheContainedPropertyAssociationsSwitch(
			final Map<InstanceObject, InstantiatedClassifier> classifierCache, SCProperties scProps,
			final IProgressMonitor pm, final AnalysisErrorReporterManager errManager,
			final List<Property> propertyFilter) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		this.classifierCache = classifierCache;
		this.scProps = scProps;
		this.propertyFilter = propertyFilter;
	}

	/**
	 * Is this property association one that must not be cached: either it is missing its definition or
	 * its definition's type, or the definition is not in the filter?
	 */
	private boolean isSkipped(PropertyAssociation pa) {
		var prop = pa.getProperty();
		return Aadl2Util.isNull(prop) || Aadl2Util.isNull(prop.getType()) || isFiltered(prop);
	}

	private boolean isFiltered(Property prop) {
		return propertyFilter != null && !propertyFilter.contains(prop);
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new myInstanceSwitch();
	}

	protected class myInstanceSwitch extends InstanceSwitch<String> {

		@Override
		public String caseSystemInstance(final SystemInstance si) {
			if (monitor.isCanceled()) {
				cancelTraversal();
				return DONE;
			}
			monitor.subTask("Caching system instance contained property associations");
			// N.B. System instance must be associated with a system implementation, so this will never be null
			final var ci = si.getComponentImplementation();
			processContainedPropertyAssociations(si, si, ci.getType().getAllPropertyAssociations());
			processContainedPropertyAssociations(si, si, ci.getAllPropertyAssociations());
			// TODO: Insert hooks here
			return DONE;
		}

		@Override
		public String caseComponentInstance(final ComponentInstance ci) {
			if (monitor.isCanceled()) {
				cancelTraversal();
				return DONE;
			}
			if (ci.getContainingComponentInstance() instanceof SystemInstance) {
				monitor.subTask("Caching contained property associations in " + ci.getName());
			}
			/*
			 * (1) Get the contained associations from the classifier of the
			 * subcomponents. (2) Get the contained associations from the
			 * subcomponent itself.
			 */
			var ctype = InstanceUtil.getComponentType(ci, 0, classifierCache);
			if (ctype != null) {
				processContainedPropertyAssociations(ci, ci, ctype.getAllPropertyAssociations());
			}
			var cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
			if (cimpl != null) {
				processContainedPropertyAssociations(ci, ci, cimpl.getAllPropertyAssociations());
			}

			if (ci.getSubcomponent() != null) {
				processContainedPropertyAssociations((ComponentInstance) ci.eContainer(), ci,
						ci.getSubcomponent().getOwnedPropertyAssociations());
			}
			return DONE;
		}

		/*
		 *
		 * FIXME: old code by JD to try to handle reference instance
		 * public String caseConnectionInstance(final ConnectionInstance conn)
		 * {
		 * ComponentInstance ci;
		 * EList<PropertyAssociation> pas = new BasicEList<PropertyAssociation> ();
		 *
		 * ci = conn.getContainingComponentInstance();
		 * OsateDebug.osateDebug("connection instance" + conn + "on" + ci);
		 * for (ConnectionReference ref : conn.getConnectionReferences())
		 * {
		 * OsateDebug.osateDebug("connection ref" + ref);
		 * for (PropertyAssociation pa : ref.getOwnedPropertyAssociations())
		 * {
		 * OsateDebug.osateDebug("connection pa" + pa);
		 * Property prop = pa.getProperty();
		 * PropertyAssociation newPA = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		 *
		 * newPA.setProperty(prop);
		 * newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));
		 *
		 *
		 * for (Iterator<Element> content = EcoreUtil.getAllProperContents(newPA, false); content
		 * .hasNext();) {
		 * Element elem = content.next();
		 * if (elem instanceof ModalPropertyValue)
		 * {
		 * ModalPropertyValue mpv = (ModalPropertyValue)elem;
		 * if (mpv.getOwnedValue() instanceof ListValue)
		 * {
		 * ListValue lv = (ListValue)mpv.getOwnedValue();
		 * for (Element e : lv.getOwnedListElements())
		 * {
		 * if (e instanceof ReferenceValue) {
		 * PropertyExpression irv = ((ReferenceValue) e).instantiate(ci);
		 * EcoreUtil.replace(e, irv);
		 * //ref.removePropertyAssociations(prop);
		 * ref.getOwnedPropertyAssociations().add(newPA);
		 * }
		 * }
		 * }
		 * }
		 * if (elem instanceof ReferenceValue) {
		 * PropertyExpression irv = ((ReferenceValue) elem).instantiate(ci);
		 * EcoreUtil.replace(elem, irv);
		 *
		 * ref.removePropertyAssociations(prop);
		 * ref.getOwnedPropertyAssociations().add(newPA);
		 * }
		 * }
		 *
		 *
		 *
		 * }
		 * }
		 * processContainedPropertyAssociations((ComponentInstance) ci.eContainer(), ci, pas);
		 *
		 * return DONE;
		 * }
		 */

		@Override
		public String caseFeatureInstance(final FeatureInstance fi) {
			if (monitor.isCanceled()) {
				cancelTraversal();
				return DONE;
			}
			if (fi.getCategory() == FeatureCategory.FEATURE_GROUP) {
				var fgType = InstanceUtil.getFeatureGroupType(fi, 0, classifierCache);
				if (fgType != null) {
					processContainedPropertyAssociations(fi, fgType.getAllPropertyAssociations());
				}
				processContainedPropertyAssociations(fi, fi.getFeature().getOwnedPropertyAssociations());
			}
			return DONE;
		}
	}

	protected void processContainedPropertyAssociations(final FeatureInstance fi,
			final EList<PropertyAssociation> propertyAssociations) {
		for (var pa : propertyAssociations) {
			if (isSkipped(pa)) {
				// PA is missing the prop def or is not being cached, skip to the next one
				continue;
			}
			var prop = pa.getProperty();

			for (var cne : pa.getAppliesTos()) {
				final var cpes = cne.getContainmentPathElements();
				if (cpes.isEmpty()) {
					continue;
				}

				for (var io : fi.findFeatureInstances(cpes)) {
					var newPA = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();

					newPA.setProperty(prop);
					newPA.setPropertyAssociation(pa);
					newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));

					final var existingPA = io.getPropertyValue(prop, false).first();
					if (existingPA != null && isConstant(existingPA)) {
						/*
						 * Cannot put the error on the property association that is affected because it might
						 * be a declarative model element at this point. Need to report the error on the
						 * instance object itself.
						 */
						final var owner = pa.getOwner();
						final var featureName = owner instanceof Feature feature ? "." + feature.getName() : "";
						reportConstantOverride(io, prop, pa, featureName);
					} else {
						io.removePropertyAssociations(prop);
						io.getOwnedPropertyAssociations().add(newPA);
						// replace reference values in the context of the contained PA's owner
						report(instantiateReferenceValues(newPA, fi));
					}
				}
			}
			checkIfCancelled();
			if (cancelled()) {
				break;
			}
		}
	}

	/**
	 * Copy contained property associations to the instance model.
	 * Don't fully evaluate the property expression. Just replace reference values with
	 * a reference to the referenced instance object.
	 *
	 * @param modeContext
	 * @param ci
	 * @param propertyAssociations
	 */
	protected void processContainedPropertyAssociations(final ComponentInstance modeContext, final ComponentInstance ci,
			final EList<PropertyAssociation> propertyAssociations) {
		for (var pa : propertyAssociations) {
			if (isSkipped(pa)) {
				// PA is missing the prop def or is not being cached, skip to the next one
				continue;
			}
			var prop = pa.getProperty();

			for (var cne : pa.getAppliesTos()) {
				final var cpes = cne.getContainmentPathElements();
				if (cpes.isEmpty()) {
					continue;
				}

				final var last = cpes.getLast().getNamedElement();
				for (var io : ci.findInstanceObjects(cpes)) {
					var newPA = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();

					newPA.setProperty(prop);
					newPA.setPropertyAssociation(pa);
					newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));

					// replace reference values in the context of the contained PA's owner
					var issues = instantiateReferenceValues(newPA, ci, io);

					if (last instanceof Connection conn) {
						final var existingPA = scProps.retrieveSCProperty((ConnectionInstance) io, prop, conn);
						if (existingPA != null && isConstant(existingPA)) {
							/*
							 * Cannot put the error on the property association that is affected because it might
							 * be a declarative model element at this point. Need to report the error on the
							 * instance object itself.
							 */
							reportConstantOverride(io, prop, pa, "");
						} else {
							scProps.recordSCProperty((ConnectionInstance) io, prop, conn, newPA);
						}
					} else {
						final var existingPA = io.getPropertyValue(prop, false).first();
						if (existingPA != null && isConstant(existingPA)) {
							/*
							 * Cannot put the error on the property association that is affected because it might
							 * be a declarative model element at this point. Need to report the error on the
							 * instance object itself.
							 */
							reportConstantOverride(io, prop, pa, "");
						} else {
							io.removePropertyAssociations(prop);
							if (!newPA.getOwnedValues().isEmpty()) {
								io.getOwnedPropertyAssociations().add(newPA);
								report(issues);
							}
						}
					}
				}
			}
			checkIfCancelled();
			if (cancelled()) {
				break;
			}
		}
	}

	/**
	 * Replace the reference values of a copied property association with references to the instance
	 * objects they denote in the context of {@code context}, reporting an error on {@code io} for a
	 * reference that cannot be evaluated at all.
	 *
	 * @return the problems found, which the caller reports only if it keeps the association
	 */
	private List<Issue> instantiateReferenceValues(final PropertyAssociationInstance pa, final ComponentInstance context,
			final InstanceObject io) {
		final var issues = new ArrayList<Issue>();

		for (var elem : properContentsOf(pa)) {
			if (elem instanceof ReferenceValue rv) {
				// TODO: LW what if ref to connection?
				try {
					var irv = rv.instantiate(context);
					if (irv != null) {
						EcoreUtil.replace(rv, irv);
					} else {
						issues.add(new Issue(Severity.ERROR, rv,
								"Referenced element does not exist in the instance model"));
					}
				} catch (InvalidModelException e) {
					error(io, e.getMessage());
				}
			}
		}
		return issues;
	}

	/**
	 * Replace the reference values of a copied property association with references to the instance
	 * objects they denote in the context of a feature instance.
	 *
	 * @return the problems found
	 */
	private static List<Issue> instantiateReferenceValues(final PropertyAssociationInstance pa,
			final FeatureInstance context) {
		final var issues = new ArrayList<Issue>();

		for (var elem : properContentsOf(pa)) {
			if (elem instanceof ReferenceValue rv) {
				var irv = rv.instantiate(context);
				if (irv != null) {
					EcoreUtil.replace(rv, irv);
				} else {
					issues.add(
							new Issue(Severity.ERROR, rv, "Referenced element does not exist in the instance model"));
				}
			}
		}
		return issues;
	}

	/**
	 * Report that a contained property association tries to replace a constant value.
	 *
	 * @param memberSuffix appended to the name of the classifier that holds the contained association, to
	 *            name the feature it is declared on, or empty
	 */
	private void reportConstantOverride(final InstanceObject io, final Property prop, final PropertyAssociation pa,
			final String memberSuffix) {
		error(io,
				"Property association for \"%s\" is constant.  A contained property association in classifier \"%s%s\" tries to replace it."
						.formatted(prop.getQualifiedName(), pa.getContainingClassifier().getQualifiedName(),
								memberSuffix));
	}

	private void report(final List<Issue> issues) {
		for (var issue : issues) {
			switch (issue.severity()) {
			case ERROR -> error(issue.element(), issue.message());
			case WARNING -> warning(issue.element(), issue.message());
			}
		}
	}

	private static boolean isConstant(PropertyAssociation pa) {
		while (pa != null) {
			if (pa.isConstant()) {
				return true;
			}
			pa = pa instanceof PropertyAssociationInstance pai ? pai.getPropertyAssociation() : null;
		}
		return false;
	}

	/**
	 * The contents of an element, excluding the contents of cross-resource contained children, as an
	 * {@code Iterable} so that it can be used in an enhanced for statement.
	 */
	private static Iterable<Element> properContentsOf(final EObject root) {
		return () -> EcoreUtil.getAllProperContents(root, false);
	}
}
