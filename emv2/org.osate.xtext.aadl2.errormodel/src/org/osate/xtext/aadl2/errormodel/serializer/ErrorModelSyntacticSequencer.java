package org.osate.xtext.aadl2.errormodel.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;

public class ErrorModelSyntacticSequencer extends AbstractErrorModelSyntacticSequencer {
	/**
	 * AppliesToKeywords:
	 * 	'applies' 'to'
	 * ;
	 */
	@Override
	protected String getAppliesToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "applies to";
	}

	/**
	 * ComponentErrorBehaviorKeywords:
	 * 	'component' 'error' 'behavior'
	 * ;
	 */
	@Override
	protected String getComponentErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "component error behavior";
	}

	/**
	 * CompositeErrorBehaviorKeywords:
	 * 	'composite' 'error' 'behavior'
	 * ;
	 */
	@Override
	protected String getCompositeErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "composite error behavior";
	}

	/**
	 * ConnectionErrorKeywords:
	 * 	'connection' 'error'
	 * ;
	 */
	@Override
	protected String getConnectionErrorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "connection error";
	}

	/**
	 * EndBehaviorKeywords:
	 * 	'end' 'behavior'
	 * ;
	 */
	@Override
	protected String getEndBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end behavior";
	}

	/**
	 * EndComponentKeywords:
	 * 	'end' 'component'
	 * ;
	 */
	@Override
	protected String getEndComponentKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end component";
	}

	/**
	 * EndCompositeKeywords:
	 * 	'end' 'composite'
	 * ;
	 */
	@Override
	protected String getEndCompositeKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end composite";
	}

	/**
	 * EndConnectionKeywords:
	 * 	'end' 'connection'
	 * ;
	 */
	@Override
	protected String getEndConnectionKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end connection";
	}

	/**
	 * EndMappingsKeywords:
	 * 	'end' 'mappings'
	 * ;
	 */
	@Override
	protected String getEndMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end mappings";
	}

	/**
	 * EndPathsKeywords:
	 * 	'end' 'paths'
	 * ;
	 */
	@Override
	protected String getEndPathsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end paths";
	}

	/**
	 * EndPropagationsKeywords:
	 * 	'end' 'propagations'
	 * ;
	 */
	@Override
	protected String getEndPropagationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end propagations";
	}

	/**
	 * EndSubclauseKeywords:
	 * 	'end' 'subclause'
	 * ;
	 */
	@Override
	protected String getEndSubclauseKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end subclause";
	}

	/**
	 * EndTransformationsKeywords:
	 * 	'end' 'transformations'
	 * ;
	 */
	@Override
	protected String getEndTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end transformations";
	}

	/**
	 * EndTypesKeywords:
	 * 	'end' 'types'
	 * ;
	 */
	@Override
	protected String getEndTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "end types";
	}

	/**
	 * ErrorBehaviorKeywords:
	 * 	'error' 'behavior'
	 * ;
	 */
	@Override
	protected String getErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error behavior";
	}

	/**
	 * ErrorEventKeywords:
	 * 	'error' 'event'
	 * ;
	 */
	@Override
	protected String getErrorEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error event";
	}

	/**
	 * ErrorPathKeywords:
	 * 	'error' 'path'
	 * ;
	 */
	@Override
	protected String getErrorPathKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error path";
	}

	/**
	 * ErrorPropagationsKeywords:
	 * 	'error' 'propagations'
	 * ;
	 */
	@Override
	protected String getErrorPropagationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error propagations";
	}

	/**
	 * ErrorSinkKeywords:
	 * 	'error' 'sink'
	 * ;
	 */
	@Override
	protected String getErrorSinkKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error sink";
	}

	/**
	 * ErrorSourceKeywords:
	 * 	'error' 'source'
	 * ;
	 */
	@Override
	protected String getErrorSourceKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error source";
	}

	/**
	 * ErrorTypesKeywords:
	 * 	'error' 'types'
	 * ;
	 */
	@Override
	protected String getErrorTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "error types";
	}

	/**
	 * InBindingKeywords:
	 * 	'in' 'binding'
	 * ;
	 */
	@Override
	protected String getInBindingKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "in binding";
	}

	/**
	 * InModesKeywords:
	 * 	'in' 'modes'
	 * ;
	 */
	@Override
	protected String getInModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "in modes";
	}

	/**
	 * ModeMappingsKeywords:
	 * 	'mode' 'mappings'
	 * ;
	 */
	@Override
	protected String getModeMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "mode mappings";
	}

	/**
	 * PropagationPathsKeywords:
	 * 	'propagation' 'paths'
	 * ;
	 */
	@Override
	protected String getPropagationPathsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "propagation paths";
	}

	/**
	 * PropagationPointKeywords:
	 * 	'propagation' 'point'
	 * ;
	 */
	@Override
	protected String getPropagationPointKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "propagation point";
	}

	/**
	 * RecoverEventKeywords:
	 * 	'recover' 'event'
	 * ;
	 */
	@Override
	protected String getRecoverEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "recover event";
	}

	/**
	 * RepairEventKeywords:
	 * 	'repair' 'event'
	 * ;
	 */
	@Override
	protected String getRepairEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "repair event";
	}

	/**
	 * SameStateKeywords:
	 * 	'same' 'state'
	 * ;
	 */
	@Override
	protected String getSameStateKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "same state";
	}

	/**
	 * TypeMappingsKeywords:
	 * 	'type' 'mappings'
	 * ;
	 */
	@Override
	protected String getTypeMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "type mappings";
	}

	/**
	 * TypeSetKeywords:
	 * 	'type' 'set'
	 * ;
	 */
	@Override
	protected String getTypeSetKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "type set";
	}

	/**
	 * TypeTransformationsKeywords:
	 * 	'type' 'transformations'
	 * ;
	 */
	@Override
	protected String getTypeTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "type transformations";
	}

	/**
	 * UseBehaviorKeywords:
	 * 	'use' 'behavior'
	 * ;
	 */
	@Override
	protected String getUseBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "use behavior";
	}

	/**
	 * UseMappingsKeywords:
	 * 	'use' 'mappings'
	 * ;
	 */
	@Override
	protected String getUseMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "use mappings";
	}

	/**
	 * UseTransformationsKeywords:
	 * 	'use' 'transformations'
	 * ;
	 */
	@Override
	protected String getUseTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "use transformations";
	}

	/**
	 * UseTypeEquivalenceKeywords:
	 * 	'use' 'type' 'equivalence'
	 * ;
	 */
	@Override
	protected String getUseTypeEquivalenceKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "use type equivalence";
	}

	/**
	 * UseTypesKeywords:
	 * 	'use' 'types'
	 * ;
	 */
	@Override
	protected String getUseTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null) {
			return getTokenText(node);
		}
		return "use types";
	}
}