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
package org.osate.aadl2.instantiation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
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
 * TODO: Add comment
 * @author lwrage
 */
public class CacheContainedPropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private SCProperties scProps;

	protected CacheContainedPropertyAssociationsSwitch(
			final HashMap<InstanceObject, InstantiatedClassifier> classifierCache, SCProperties scProps,
			final IProgressMonitor pm, final AnalysisErrorReporterManager errManager) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		this.classifierCache = classifierCache;
		this.scProps = scProps;
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
			final ComponentImplementation ci = si.getComponentImplementation();
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
			ComponentClassifier ctype = InstanceUtil.getComponentType(ci, 0, classifierCache);
			if (ctype != null) {
				processContainedPropertyAssociations(ci, ci, ctype.getAllPropertyAssociations());
			}
			ComponentClassifier cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
			if (cimpl != null) {
				processContainedPropertyAssociations(ci, ci, cimpl.getAllPropertyAssociations());
			}

			processContainedPropertyAssociations((ComponentInstance) ci.eContainer(), ci,
					ci.getSubcomponent().getOwnedPropertyAssociations());
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
				FeatureGroupType fgType = InstanceUtil.getFeatureGroupType(fi, 0, classifierCache);
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
		for (PropertyAssociation pa : propertyAssociations) {
			Property prop = pa.getProperty();
			if (Aadl2Util.isNull(prop) || Aadl2Util.isNull(prop.getType())) {
				// PA is missing the prop def, skip to the next one
				continue;
			}
			for (ContainedNamedElement cne : pa.getAppliesTos()) {
				final EList<ContainmentPathElement> cpes = cne.getContainmentPathElements();
				if (cpes != null && !cpes.isEmpty()) {
					final Collection<FeatureInstance> ios = fi.findFeatureInstances(cpes);

					if (!ios.isEmpty()) {
						for (InstanceObject io : ios) {
							PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE
									.createPropertyAssociationInstance();

							newPA.setProperty(prop);
							newPA.setPropertyAssociation(pa);
							newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));

							// replace reference values in the context of the contained PA's owner
							for (Iterator<Element> content = EcoreUtil.getAllProperContents(newPA, false); content
									.hasNext();) {
								Element elem = content.next();

								if (elem instanceof ReferenceValue) {
									PropertyExpression irv = ((ReferenceValue) elem).instantiate(fi);
									if (irv != null) {
										EcoreUtil.replace(elem, irv);
									}
								}
							}

							final PropertyAssociation existingPA = io.getPropertyValue(prop, false).first();
							if (existingPA != null && isConstant(existingPA)) {
								/*
								 * Cannot put the error on the property association that is affected because it might
								 * be a declarative model element at this point. Need to report the error on the
								 * instance object itself.
								 */
								final String classifierName = pa.getContainingClassifier().getQualifiedName();
								final Element owner = pa.getOwner();
								final String featureName = (owner instanceof Feature)
										? ("." + ((Feature) owner).getName())
										: "";
								getErrorManager().error(io, "Property association for \"" + prop.getQualifiedName()
										+ "\" is constant.  A contained property association in classifier \""
										+ classifierName + featureName + "\" tries to replace it.");
							} else {
								io.removePropertyAssociations(prop);
								io.getOwnedPropertyAssociations().add(newPA);
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
		for (PropertyAssociation pa : propertyAssociations) {
			// OsateDebug.osateDebug ("[CacheContainedProperty] Process contained property association: " + pa.getProperty().getName());
			Property prop = pa.getProperty();
			if (Aadl2Util.isNull(prop) || Aadl2Util.isNull(prop.getType())) {
				// PA is missing the prop def, skip to the next one
				// OsateDebug.osateDebug (" skip");

				continue;
			}
			// OsateDebug.osateDebug (" appliesto=" + pa.getAppliesTos());

			for (ContainedNamedElement cne : pa.getAppliesTos()) {
				final EList<ContainmentPathElement> cpes = cne.getContainmentPathElements();
				// OsateDebug.osateDebug (" cpes=" + cpes);

				if (cpes != null && !cpes.isEmpty()) {
					final NamedElement last = cpes.get(cpes.size() - 1).getNamedElement();
					final List<InstanceObject> ios = ci.findInstanceObjects(cpes);
					for (InstanceObject io : ios) {
						// OsateDebug.osateDebug (" io=" + io);

						PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE
								.createPropertyAssociationInstance();

						newPA.setProperty(prop);
						newPA.setPropertyAssociation(pa);
						newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));

						// replace reference values in the context of the contained PA's owner
						for (Iterator<Element> content = EcoreUtil.getAllProperContents(newPA, false); content
								.hasNext();) {
							Element elem = content.next();

							if (elem instanceof ReferenceValue) {
								// TODO: LW what if ref to connection?
								try {
									PropertyExpression irv = ((ReferenceValue) elem).instantiate(ci);
									if (irv != null) {
										EcoreUtil.replace(elem, irv);
									}
								} catch (InvalidModelException e) {
									error(io, e.getMessage());
								}
							}
						}

						if (last instanceof Connection) {
							final PropertyAssociation existingPA = scProps.retrieveSCProperty((ConnectionInstance) io,
									prop, (Connection) last);
							if (existingPA != null && isConstant(existingPA)) {
								/*
								 * Cannot put the error on the property association that is affected because it might
								 * be a declarative model element at this point. Need to report the error on the
								 * instance object itself.
								 */
								getErrorManager().error(io, "Property association for \"" + prop.getQualifiedName()
										+ "\" is constant.  A contained property association in classifier \""
										+ pa.getContainingClassifier().getQualifiedName() + "\" tries to replace it.");
							} else {
								scProps.recordSCProperty((ConnectionInstance) io, prop, (Connection) last, newPA);
							}
						} else {
							final PropertyAssociation existingPA = io.getPropertyValue(prop, false).first();
							if (existingPA != null && isConstant(existingPA)) {
								/*
								 * Cannot put the error on the property association that is affected because it might
								 * be a declarative model element at this point. Need to report the error on the
								 * instance object itself.
								 */
								getErrorManager().error(io, "Property association for \"" + prop.getQualifiedName()
										+ "\" is constant.  A contained property association in classifier \""
												+ pa.getContainingClassifier().getQualifiedName()
												+ "\" tries to replace it.");
							} else {
								io.removePropertyAssociations(prop);
								io.getOwnedPropertyAssociations().add(newPA);
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

	private static boolean isConstant(PropertyAssociation pa) {
		while (pa != null) {
			if (pa.isConstant()) {
				return true;
			}
			if (pa instanceof PropertyAssociationInstance) {
				pa = ((PropertyAssociationInstance) pa).getPropertyAssociation();
			} else {
				pa = null;
			}
		}
		return false;
	}
}
