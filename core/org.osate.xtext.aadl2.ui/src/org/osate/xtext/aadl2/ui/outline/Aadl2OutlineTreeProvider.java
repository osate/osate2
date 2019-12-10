/*
 * /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
