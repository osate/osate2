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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicPropertyAssociation;
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
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

/**
 * customization of the default outline structure
 *
 */
public class Aadl2OutlineTreeProvider extends DefaultOutlineTreeProvider {
	protected void _createChildren(DocumentRootNode parentNode, ModelUnit aadlModel) {
		if (aadlModel instanceof AadlPackage) {
			for (Element element : aadlModel.getChildren()) {
				createNode(parentNode, element);
			}
		} else {
			createNode(parentNode, aadlModel);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, Element modelElement) {
		EObject annexRoot = AnnexUtil.getAnnexRoot(modelElement);

		if (annexRoot != null) {
			// delegate to annex specific outline tree provider
			IParseResult annexParseResult = AnnexParseUtil.getParseResult(annexRoot);
			if (annexParseResult != null) {
				Injector injector = AnnexUtil.getInjector(annexParseResult);
				if (injector != null) {
					try {
						injector.getInstance(IOutlineTreeStructureProvider.class).createChildren(parentNode,
								modelElement);
					} catch (ConfigurationException e) {
						// ignore: no outline provider for this annex
					}
				}
			}
		} else {
			for (EObject childElement : modelElement.getChildren()) {
				if (childElement instanceof Realization || childElement instanceof TypeExtension
						|| childElement instanceof ImplementationExtension
						|| childElement instanceof ContainmentPathElement
						|| childElement instanceof PropertyAssociation) {
					continue;
				}

				createNode(parentNode, childElement);
			}
		}
	}

	@Override
	protected Object _text(Object modelElement) {
		String initialText;

		initialText = labelProvider.getText(modelElement);
		if (labelProvider instanceof IStyledLabelProvider) {
			StyledString styledString;

			styledString = ((IStyledLabelProvider) labelProvider).getStyledText(modelElement);
			return styledString;
		} else {
			return initialText;
		}
	}

	protected void _createChildren(DocumentRootNode parentNode, SystemInstance aadlModel) {
		createNode(parentNode, aadlModel);
	}

	protected boolean _isLeaf(ContainmentPathElement cpe) {
		return true;
	}

	protected boolean _isLeaf(ContainedNamedElement cpe) {
		return true;
	}

	protected boolean _isLeaf(SystemInstance feature) {
		return false;
	}

	protected boolean _isLeaf(FlowSpecification flowspec) {
		return true;
	}

	protected boolean _isLeaf(FlowImplementation flowimpl) {
		return true;
	}

	protected boolean _isLeaf(EndToEndFlowImpl flowimpl) {
		return true;
	}

	protected boolean _isLeaf(RangeValue rv) {
		return false;
	}

	protected boolean _isLeaf(ModalPropertyValue ml) {
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
	}

	protected boolean _isLeaf(BasicPropertyAssociation bpa) {

		if (bpa.eContainer() instanceof RecordValue) {
			return true;
		}
		return false;
	}

	protected boolean _isLeaf(ReferenceValue bpa) {

		if (bpa.eContainer() instanceof RecordValue) {
			return true;
		}
		return false;
	}

	protected boolean _isLeaf(IntegerLiteral bpa) {

		if (bpa.eContainer() instanceof RecordValue) {
			return false;
		}
		return false;
	}

	protected void _createChildren(IOutlineNode parentNode, SystemInstance sysInstance) {
		super._createChildren(parentNode, sysInstance);
	}

	// Uncomment the next set to limit outline for package and property set to

//	// Classifier nodes are leafs and not expandable
//	protected boolean _isLeaf(Classifier feature) {
//	    return true;
//	}

	// Property nodes are leafs and not expandable
	protected boolean _isLeaf(Property feature) {
		return true;
	}

	// PropertyConstant nodes are leafs and not expandable
	protected boolean _isLeaf(PropertyConstant feature) {
		return true;
	}

	// PropertyType nodes are leafs and not expandable
	protected boolean _isLeaf(PropertyType feature) {
		return true;
	}

}
