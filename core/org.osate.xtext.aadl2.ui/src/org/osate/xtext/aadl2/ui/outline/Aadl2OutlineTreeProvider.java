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
package org.osate.xtext.aadl2.ui.outline;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.Realization;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.impl.EndToEndFlowImpl;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.ParseResultHolder;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.common.collect.Iterables;
import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

/**
 * customization of the default outline structure
 */
public class Aadl2OutlineTreeProvider extends BackgroundOutlineTreeProvider {
	@Override
	protected void internalCreateChildren(final DocumentRootNode parentNode, final EObject modelElement) {
		if (modelElement instanceof ModelUnit) {
			final ModelUnit modelUnit = (ModelUnit) modelElement;
			if (modelElement instanceof AadlPackage) {
				for (Element element : modelUnit.getChildren()) {
					createNode(parentNode, element);
				}
			} else {
				createNode(parentNode, modelUnit);
			}
		} else if (modelElement instanceof SystemInstance) {
			createNode(parentNode, modelElement);
		} else {
			super.internalCreateChildren(parentNode, modelElement);
		}
	}

	@Override
	protected void internalCreateChildren(final IOutlineNode parentNode, final EObject modelElement) {
		if (modelElement instanceof Element) {
			final Element element = (Element) modelElement;
			final EObject annexRoot = AnnexUtil.getAnnexRoot(element);

			if (annexRoot != null) {
				// delegate to annex specific outline tree provider
				IParseResult annexParseResult = ParseResultHolder.Factory.INSTANCE.adapt(annexRoot).getParseResult();
				if (annexParseResult != null) {
					Injector injector = AnnexUtil.getInjector(annexParseResult);
					if (injector != null) {
						try {
							final IOutlineTreeStructureProvider outlineTree = injector
									.getInstance(IOutlineTreeStructureProvider.class);
							if (outlineTree instanceof BackgroundOutlineTreeProvider) {
								outlineTree.createChildren(parentNode, element);
							} else {
								Aadl2Activator.getInstance()
										.getLog()
										.log(new Status(IStatus.ERROR, Aadl2Activator.PLUGIN_ID, IStatus.OK,
												"Annex outline tree structure provider '"
														+ outlineTree.getClass().getCanonicalName()
														+ "' does not implement BackgroundOutlineTreeProvider",
												null));
							}
						} catch (ConfigurationException e) {
							// ignore: no outline provider for this annex
						}
					}
				}
			} else {
				for (EObject childElement : element.getChildren()) {
					if (childElement instanceof Realization || childElement instanceof TypeExtension
							|| childElement instanceof ImplementationExtension
							|| childElement instanceof ContainmentPathElement
							|| childElement instanceof PropertyAssociation) {
						continue;
					}

					if (element instanceof Connection && childElement instanceof ConnectedElement) {
						continue;
					}

					createNode(parentNode, childElement);
				}
			}
		}
	}

	@Override
	protected boolean isLeaf(final EObject modelElement) {
		if (modelElement instanceof ContainmentPathElement || modelElement instanceof ContainedNamedElement
				|| modelElement instanceof FlowSpecification || modelElement instanceof FlowImplementation
				|| modelElement instanceof EndToEndFlowImpl || modelElement instanceof Property
				|| modelElement instanceof PropertyConstant || modelElement instanceof PropertyType
				|| modelElement instanceof Connection) {

			return true;
		} else if (modelElement instanceof SystemInstance || modelElement instanceof RangeValue) {
			return false;
		} else if (modelElement instanceof ModalPropertyValue) {
			final ModalPropertyValue ml = (ModalPropertyValue) modelElement;
			if (ml.getInModes().isEmpty()) {
				if (ml.getOwnedValue() instanceof RangeValue) {
					return false;
				}

				if (ml.getOwnedValue() instanceof ListValue) {
					return false;
				}

				if (ml.getOwnedValue() instanceof RecordValue) {
					return false;
				}

				return true;
			}
			return false;
		} else if (modelElement instanceof BasicPropertyAssociation) {
			return modelElement.eContainer() instanceof RecordValue;
		} else if (modelElement instanceof ReferenceValue) {
			return modelElement.eContainer() instanceof RecordValue;
		} else if (modelElement instanceof IntegerLiteral) {
			return false;
		} else {
			return !Iterables.any(modelElement.eClass().getEAllContainments(), containmentRef -> {
				EClass refType = containmentRef.getEReferenceType();
				if (refType == Aadl2Package.eINSTANCE.getRealization()
						|| refType == Aadl2Package.eINSTANCE.getTypeExtension()
						|| refType == Aadl2Package.eINSTANCE.getImplementationExtension()
						|| refType == Aadl2Package.eINSTANCE.getContainmentPathElement()
						|| refType == Aadl2Package.eINSTANCE.getPropertyAssociation()) {
					return false;
				} else {
					return modelElement.eIsSet(containmentRef);
				}
			});
		}
	}
}
