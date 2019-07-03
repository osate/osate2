/*
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 * $Id: CacheContainedPropertyAssociationsSwitch.java,v 1.4 2010-06-14 01:21:51 lwrage Exp $
 *
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
