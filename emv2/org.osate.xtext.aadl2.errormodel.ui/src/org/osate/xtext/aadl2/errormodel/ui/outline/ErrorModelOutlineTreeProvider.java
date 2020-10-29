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
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
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
public class ErrorModelOutlineTreeProvider extends BackgroundOutlineTreeProvider {
	@Inject
	private ErrorModelGrammarAccess grammarAccess;

	@Override
	protected void internalCreateChildren(final DocumentRootNode parentNode, final EObject modelElement) {
		if (modelElement instanceof EMV2Root) {
			final EMV2Root emv2Root = (EMV2Root) modelElement;
			if (emv2Root.getLibrary() != null) {
				createNode(parentNode, emv2Root.getLibrary());
			} else {
				emv2Root.getSubclauses().forEach(subclause -> createNode(parentNode, subclause));
			}
		} else {
			super.internalCreateChildren(parentNode, modelElement);
		}
	}

	@Override
	protected void internalCreateChildren(final IOutlineNode parentNode, final EObject modelElement) {
		if (parentNode instanceof ErrorPropagationsOutlineNode) {
			_createChildren((ErrorPropagationsOutlineNode) parentNode, (ErrorModelSubclause) modelElement);
		} else if (parentNode instanceof ComponentErrorBehaviorOutlineNode) {
			_createChildren((ComponentErrorBehaviorOutlineNode) parentNode, (ErrorModelSubclause) modelElement);
		} else if (parentNode instanceof CompositeErrorBehaviorOutlineNode) {
			_createChildren((CompositeErrorBehaviorOutlineNode) parentNode, (ErrorModelSubclause) modelElement);
		} else if (parentNode instanceof ConnectionErrorOutlineNode) {
			_createChildren((ConnectionErrorOutlineNode) parentNode, (ErrorModelSubclause) modelElement);
		} else if (parentNode instanceof PropagationPathsOutlineNode) {
			_createChildren((PropagationPathsOutlineNode) parentNode, (ErrorModelSubclause) modelElement);
		} else if (parentNode instanceof ErrorTypesOutlineNode) {
			_createChildren((ErrorTypesOutlineNode) parentNode, (ErrorModelLibrary) modelElement);
		} else {
			if (modelElement instanceof DefaultAnnexLibrary) {
				_createChildren(parentNode, (DefaultAnnexLibrary) modelElement);
			} else if (modelElement instanceof DefaultAnnexSubclause) {
				_createChildren(parentNode, (DefaultAnnexSubclause) modelElement);
			} else if (modelElement instanceof ErrorModelSubclause) {
				_createChildren(parentNode, (ErrorModelSubclause) modelElement);
			} else if (modelElement instanceof ErrorBehaviorStateMachine) {
				_createChildren(parentNode, (ErrorBehaviorStateMachine) modelElement);
			} else if (modelElement instanceof ErrorModelLibrary) {
				_createChildren(parentNode, (ErrorModelLibrary) modelElement);
			}
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

	protected void _createChildren(ErrorTypesOutlineNode parentNode, ErrorModelLibrary errorModelLibrary) {
		errorModelLibrary.getTypes().forEach(type -> createNode(parentNode, type));
		errorModelLibrary.getTypesets().forEach(typeSet -> createNode(parentNode, typeSet));
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
		INode errorNode = null;
		INode endPropagationsSemiNode = null;
		INode componentNode = null;
		INode endComponentSemiNode = null;
		INode compositeNode = null;
		INode endCompositeSemiNode = null;
		INode connectionNode = null;
		INode endConnectionSemiNode = null;
		INode propagationNode = null;
		INode endPathsSemiNode = null;
		for (INode node : NodeModelUtils.getNode(errorModelSubclause).getChildren()) {
			if (node.getGrammarElement() instanceof Keyword) {
				Keyword keyword = (Keyword) node.getGrammarElement();
				if (keyword == grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_5_0()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_7_0()) {
					errorNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_6()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_6()) {
					endPropagationsSemiNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_0()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getComponentKeyword_8_0()) {
					componentNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_11()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_11()) {
					endComponentSemiNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_0()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getCompositeKeyword_9_0()) {
					compositeNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_6()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_6()) {
					endCompositeSemiNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_0()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getConnectionKeyword_10_0()) {
					connectionNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_6()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_6()) {
					endConnectionSemiNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getPropagationKeyword_9_0()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getPropagationKeyword_11_0()) {
					propagationNode = node;
				} else if (keyword == grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_6()
						|| keyword == grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_6()) {
					endPathsSemiNode = node;
				}
			}
		}
		if (errorNode != null && endPropagationsSemiNode != null) {
			new ErrorPropagationsOutlineNode(parentNode, errorModelSubclause, errorNode, endPropagationsSemiNode);
		}
		if (componentNode != null && endComponentSemiNode != null) {
			new ComponentErrorBehaviorOutlineNode(parentNode, errorModelSubclause, componentNode, endComponentSemiNode);
		}
		if (compositeNode != null && endCompositeSemiNode != null) {
			new CompositeErrorBehaviorOutlineNode(parentNode, errorModelSubclause, compositeNode, endCompositeSemiNode);
		}
		if (connectionNode != null && endConnectionSemiNode != null) {
			new ConnectionErrorOutlineNode(parentNode, errorModelSubclause, connectionNode, endConnectionSemiNode);
		}
		if (propagationNode != null && endPathsSemiNode != null) {
			new PropagationPathsOutlineNode(parentNode, errorModelSubclause, propagationNode, endPathsSemiNode);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, ErrorModelLibrary errorModelLibrary) {
		// Create Error Types outline node.
		INode errorNode = null;
		INode endTypesSemiNode = null;
		for (INode node : NodeModelUtils.getNode(errorModelLibrary).getChildren()) {
			if (node.getGrammarElement() instanceof Keyword) {
				Keyword keyword = (Keyword) node.getGrammarElement();
				if (keyword == grammarAccess.getErrorModelLibraryAccess().getErrorKeyword_1_0()
						|| keyword == grammarAccess.getEMV2LibraryAccess().getErrorKeyword_0_1_2_0()
						|| keyword == grammarAccess.getEMV2LibraryAccess().getErrorKeyword_1_6_0()) {
					errorNode = node;
				} else if (keyword == grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_8()
						|| keyword == grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_8()
						|| keyword == grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_8()) {
					endTypesSemiNode = node;
				}
			}
		}
		if (errorNode != null && endTypesSemiNode != null) {
			new ErrorTypesOutlineNode(parentNode, errorModelLibrary, errorNode, endTypesSemiNode);
		}

		errorModelLibrary.getBehaviors().forEach(behavior -> createNode(parentNode, behavior));
		errorModelLibrary.getMappings().forEach(mapping -> createNode(parentNode, mapping));
		errorModelLibrary.getTransformations().forEach(transformation -> createNode(parentNode, transformation));
	}

	protected void _createChildren(IOutlineNode parentNode, ErrorBehaviorStateMachine errorBehaviorStateMachine) {
		errorBehaviorStateMachine.getEvents().forEach(event -> createNode(parentNode, event));
		errorBehaviorStateMachine.getStates().forEach(state -> createNode(parentNode, state));
		errorBehaviorStateMachine.getTransitions().forEach(transition -> createNode(parentNode, transition));
	}

	@Override
	protected boolean isLeaf(final EObject modelElement) {
		return modelElement instanceof TypeSet || modelElement instanceof TypeTransformation
				|| modelElement instanceof TypeMapping || modelElement instanceof ErrorPropagation
				|| modelElement instanceof ErrorFlow || modelElement instanceof PropagationPath
				|| modelElement instanceof ErrorBehaviorEvent || modelElement instanceof ErrorBehaviorState
				|| modelElement instanceof ErrorBehaviorTransition
				|| modelElement instanceof OutgoingPropagationCondition || modelElement instanceof ErrorDetection
				|| modelElement instanceof ErrorStateToModeMapping || modelElement instanceof CompositeState;
	}

	private abstract class AbstractSectionOutlineNode extends AbstractOutlineNode {
		private final URI eObjectURI;
		private final ITextRegion significantRegion;

		public AbstractSectionOutlineNode(IOutlineNode parent, EObject modelElement, String text, INode startNode,
				INode endNode) {
			super(parent, getLabelProvider().getImage(AbstractSectionOutlineNode.class), text, false);
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