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
package org.osate.xtext.aadl2.errormodel.ui.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.util.ITextRegion;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

import com.google.inject.Inject;

/**
 * customization of the default outline structure
 *
 */
public class ErrorModelOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Inject
	private ErrorModelGrammarAccess grammarAccess;

	protected void _createChildren(DocumentRootNode parentNode, EMV2Root emv2Root) {
		if (emv2Root.getLibrary() != null) {
			createNode(parentNode, emv2Root.getLibrary());
		} else {
			emv2Root.getSubclauses().forEach(subclause -> createNode(parentNode, subclause));
		}
	}

	protected void _createChildren(IOutlineNode parentNode, DefaultAnnexLibrary defaultAnnexLibrary) {
		if (defaultAnnexLibrary.getParsedAnnexLibrary() instanceof ErrorModelLibrary) {
			_createChildren(parentNode, (ErrorModelLibrary) defaultAnnexLibrary.getParsedAnnexLibrary());
		}
	}

	protected void _createChildren(IOutlineNode parentNode, DefaultAnnexSubclause defaultAnnexSubclause) {
		if (defaultAnnexSubclause.getParsedAnnexSubclause() instanceof ErrorModelSubclause) {
			_createChildren(parentNode, (ErrorModelSubclause) defaultAnnexSubclause.getParsedAnnexSubclause());
		}
	}

	protected void _createChildren(IOutlineNode parentNode, ErrorModelSubclause errorModelSubclause) {
		/*
		 * Create Error Propagations, Component Error Behavior, Composite Error Behavior, Connection Error, and
		 * Propagation Paths outline nodes.
		 */
		INode errorPropagationsNode = null;
		INode endPropagationsSemiNode = null;
		INode componentErrorBehaviorNode = null;
		INode endComponentSemiNode = null;
		INode compositeErrorBehaviorNode = null;
		INode endCompositeSemiNode = null;
		INode connectionErrorNode = null;
		INode endConnectionSemiNode = null;
		INode propagationPathsNode = null;
		INode endPathsSemiNode = null;
		for (INode node : NodeModelUtils.getNode(errorModelSubclause).getChildren()) {
			if (node.getGrammarElement() instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) node.getGrammarElement();
				if (ruleCall.getRule() == grammarAccess.getErrorPropagationsKeywordsRule()) {
					errorPropagationsNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndPropagationsKeywordsRule()) {
					endPropagationsSemiNode = node.getNextSibling();
				} else if (ruleCall.getRule() == grammarAccess.getComponentErrorBehaviorKeywordsRule()) {
					componentErrorBehaviorNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndComponentKeywordsRule()) {
					endComponentSemiNode = node.getNextSibling();
				} else if (ruleCall.getRule() == grammarAccess.getCompositeErrorBehaviorKeywordsRule()) {
					compositeErrorBehaviorNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndCompositeKeywordsRule()) {
					endCompositeSemiNode = node.getNextSibling();
				} else if (ruleCall.getRule() == grammarAccess.getConnectionErrorKeywordsRule()) {
					connectionErrorNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndConnectionKeywordsRule()) {
					endConnectionSemiNode = node.getNextSibling();
				} else if (ruleCall.getRule() == grammarAccess.getPropagationPathsKeywordsRule()) {
					propagationPathsNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndPathsKeywordsRule()) {
					endPathsSemiNode = node.getNextSibling();
				}
			}
		}
		if (errorPropagationsNode != null && endPropagationsSemiNode != null) {
			new ErrorPropagationsOutlineNode(parentNode, errorModelSubclause, errorPropagationsNode,
					endPropagationsSemiNode);
		}
		if (componentErrorBehaviorNode != null && endComponentSemiNode != null) {
			new ComponentErrorBehaviorOutlineNode(parentNode, errorModelSubclause, componentErrorBehaviorNode,
					endComponentSemiNode);
		}
		if (compositeErrorBehaviorNode != null && endCompositeSemiNode != null) {
			new CompositeErrorBehaviorOutlineNode(parentNode, errorModelSubclause, compositeErrorBehaviorNode,
					endCompositeSemiNode);
		}
		if (connectionErrorNode != null && endConnectionSemiNode != null) {
			new ConnectionErrorOutlineNode(parentNode, errorModelSubclause, connectionErrorNode, endConnectionSemiNode);
		}
		if (propagationPathsNode != null && endPathsSemiNode != null) {
			new PropagationPathsOutlineNode(parentNode, errorModelSubclause, propagationPathsNode, endPathsSemiNode);
		}
	}

	protected void _createChildren(ErrorPropagationsOutlineNode parentNode, ErrorModelSubclause errorModelSubclause) {
		errorModelSubclause.getPropagations().forEach(propagation -> createNode(parentNode, propagation));
		errorModelSubclause.getFlows().forEach(flow -> createNode(parentNode, flow));
	}

	protected void _createChildren(ComponentErrorBehaviorOutlineNode parentNode,
			ErrorModelSubclause errorModelSubclause) {
		errorModelSubclause.getEvents().forEach(event -> createNode(parentNode, event));
		errorModelSubclause.getTransitions().forEach(transition -> createNode(parentNode, transition));
		errorModelSubclause.getOutgoingPropagationConditions().forEach(condition -> createNode(parentNode, condition));
		errorModelSubclause.getErrorDetections().forEach(detection -> createNode(parentNode, detection));
		errorModelSubclause.getErrorStateToModeMappings().forEach(mapping -> createNode(parentNode, mapping));
	}

	protected void _createChildren(CompositeErrorBehaviorOutlineNode parentNode,
			ErrorModelSubclause errorModelSubclause) {
		errorModelSubclause.getStates().forEach(state -> createNode(parentNode, state));
	}

	protected void _createChildren(ConnectionErrorOutlineNode parentNode, ErrorModelSubclause errorModelSubclause) {
		errorModelSubclause.getConnectionErrorSources().forEach(errorSource -> createNode(parentNode, errorSource));
	}

	protected void _createChildren(PropagationPathsOutlineNode parentNode, ErrorModelSubclause errorModelSubclause) {
		errorModelSubclause.getPoints().forEach(point -> createNode(parentNode, point));
		errorModelSubclause.getPaths().forEach(path -> createNode(parentNode, path));
	}

	protected void _createChildren(IOutlineNode parentNode, ErrorModelLibrary errorModelLibrary) {
		// Create Error Types outline node.
		INode errorTypesNode = null;
		INode endTypesSemiNode = null;
		for (INode node : NodeModelUtils.getNode(errorModelLibrary).getChildren()) {
			if (node.getGrammarElement() instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) node.getGrammarElement();
				if (ruleCall.getRule() == grammarAccess.getErrorTypesKeywordsRule()) {
					errorTypesNode = node;
				} else if (ruleCall.getRule() == grammarAccess.getEndTypesKeywordsRule()) {
					endTypesSemiNode = node.getNextSibling();
				}
			}
		}
		if (errorTypesNode != null && endTypesSemiNode != null) {
			new ErrorTypesOutlineNode(parentNode, errorModelLibrary, errorTypesNode, endTypesSemiNode);
		}

		errorModelLibrary.getBehaviors().forEach(behavior -> createNode(parentNode, behavior));
		errorModelLibrary.getMappings().forEach(mapping -> createNode(parentNode, mapping));
		errorModelLibrary.getTransformations().forEach(transformation -> createNode(parentNode, transformation));
	}

	protected void _createChildren(ErrorTypesOutlineNode parentNode, ErrorModelLibrary errorModelLibrary) {
		errorModelLibrary.getTypes().forEach(type -> createNode(parentNode, type));
		errorModelLibrary.getTypesets().forEach(typeSet -> createNode(parentNode, typeSet));
	}

	protected void _createChildren(IOutlineNode parentNode, ErrorBehaviorStateMachine errorBehaviorStateMachine) {
		errorBehaviorStateMachine.getEvents().forEach(event -> createNode(parentNode, event));
		errorBehaviorStateMachine.getStates().forEach(state -> createNode(parentNode, state));
		errorBehaviorStateMachine.getTransitions().forEach(transition -> createNode(parentNode, transition));
	}

	protected boolean _isLeaf(TypeSet typeSet) {
		return true;
	}

	protected boolean _isLeaf(TypeTransformation typeTransformation) {
		return true;
	}

	protected boolean _isLeaf(TypeMapping typeMapping) {
		return true;
	}

	protected boolean _isLeaf(ErrorPropagation errorPropagation) {
		return true;
	}

	protected boolean _isLeaf(ErrorFlow errorFlow) {
		return true;
	}

	protected boolean _isLeaf(PropagationPath propagationPath) {
		return true;
	}

	protected boolean _isLeaf(ErrorBehaviorEvent errorBehaviorEvent) {
		return true;
	}

	protected boolean _isLeaf(ErrorBehaviorState errorBehaviorState) {
		return true;
	}

	protected boolean _isLeaf(ErrorBehaviorTransition errorBehaviorTransition) {
		return true;
	}

	protected boolean _isLeaf(OutgoingPropagationCondition outgoingPropagationCondition) {
		return true;
	}

	protected boolean _isLeaf(ErrorDetection errorDetection) {
		return true;
	}

	protected boolean _isLeaf(ErrorStateToModeMapping errorStateToModeMapping) {
		return true;
	}

	protected boolean _isLeaf(CompositeState compositeState) {
		return true;
	}

	private abstract class AbstractSectionOutlineNode extends AbstractOutlineNode {
		private final URI eObjectURI;
		private final ITextRegion significantRegion;

		public AbstractSectionOutlineNode(IOutlineNode parent, EObject modelElement, String text, INode startNode,
				INode endNode) {
			super(parent, labelProvider.getImage(AbstractSectionOutlineNode.class), text, false);
			eObjectURI = EcoreUtil.getURI(modelElement);
			significantRegion = startNode.getTextRegionWithLineInformation();
			setTextRegion(significantRegion.merge(endNode.getTextRegionWithLineInformation()));
		}

		@Override
		public ITextRegion getSignificantTextRegion() {
			return significantRegion;
		}

		@Override
		protected URI getEObjectURI() {
			return eObjectURI;
		}
	}

	private class ErrorPropagationsOutlineNode extends AbstractSectionOutlineNode {
		public ErrorPropagationsOutlineNode(IOutlineNode parent, ErrorModelSubclause errorModelSubclause,
				INode startNode, INode endNode) {
			super(parent, errorModelSubclause, "Error Propagations", startNode, endNode);
		}
	}

	private class ComponentErrorBehaviorOutlineNode extends AbstractSectionOutlineNode {
		public ComponentErrorBehaviorOutlineNode(IOutlineNode parent, ErrorModelSubclause errorModelSubclause,
				INode startNode, INode endNode) {
			super(parent, errorModelSubclause, "Component Error Behavior", startNode, endNode);
		}
	}

	private class CompositeErrorBehaviorOutlineNode extends AbstractSectionOutlineNode {
		public CompositeErrorBehaviorOutlineNode(IOutlineNode parent, ErrorModelSubclause errorModelSubclause,
				INode startNode, INode endNode) {
			super(parent, errorModelSubclause, "Composite Error Behavior", startNode, endNode);
		}
	}

	private class ConnectionErrorOutlineNode extends AbstractSectionOutlineNode {
		public ConnectionErrorOutlineNode(IOutlineNode parent, ErrorModelSubclause errorModelSubclause, INode startNode,
				INode endNode) {
			super(parent, errorModelSubclause, "Connection Error", startNode, endNode);
		}
	}

	private class PropagationPathsOutlineNode extends AbstractSectionOutlineNode {
		public PropagationPathsOutlineNode(IOutlineNode parent, ErrorModelSubclause errorModelSubclause,
				INode startNode, INode endNode) {
			super(parent, errorModelSubclause, "Propagation Paths", startNode, endNode);
		}
	}

	private class ErrorTypesOutlineNode extends AbstractSectionOutlineNode {
		public ErrorTypesOutlineNode(IOutlineNode parent, ErrorModelLibrary errorModelLibrary, INode startNode,
				INode endNode) {
			super(parent, errorModelLibrary, "Error Types", startNode, endNode);
		}
	}
}