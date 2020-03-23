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
package org.osate.xtext.aadl2.serializer

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.INode
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.PropertySet

class Aadl2SyntacticSequencer extends AbstractAadl2SyntacticSequencer {
	/**
	 * Adds the ending identifier to classifiers, packages, and property sets when serializing.
	 */
	override protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (semanticObject instanceof Classifier) {
			semanticObject.name
		} else if (semanticObject instanceof AadlPackage) {
			semanticObject.name
		} else if (semanticObject instanceof PropertySet) {
			semanticObject.name
		} else {
			super.getIDToken(semanticObject, ruleCall, node)
		}
	}

	override protected String getFULLINAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (semanticObject instanceof ComponentImplementation) {
			semanticObject.name
		} else {
			super.getFULLINAMEToken(semanticObject, ruleCall, node)
		}
	}

	override protected String getPNAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (semanticObject instanceof AadlPackage) {
			semanticObject.name
		} else {
			super.getPNAMEToken(semanticObject, ruleCall, node)
		}
	}

	/**
	 * AbstractImplementationKeywords:
	 * 	'abstract' 'implementation'
	 * ;
	 */
	override protected String getAbstractImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"abstract implementation"
	}

	/**
	 * AppliesToKeywords:
	 * 	'applies' 'to'
	 * ;
	 */
	override protected String getAppliesToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"applies to"
	}

	/**
	 * BusAccessKeywords:
	 * 	'bus' 'access'
	 * ;
	 */
	override protected String getBusAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"bus access"
	}

	/**
	 * BusImplementationKeywords:
	 * 	'bus' 'implementation'
	 * ;
	 */
	override protected String getBusImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"bus implementation"
	}

	/**
	 * DataAccessKeywords:
	 * 	'data' 'access'
	 * ;
	 */
	override protected String getDataAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"data access"
	}

	/**
	 * DataImplementationKeywords:
	 * 	'data' 'implementation'
	 * ;
	 */
	override protected String getDataImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"data implementation"
	}

	/**
	 * DataPortKeywords:
	 * 	'data' 'port'
	 * ;
	 */
	override protected String getDataPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"data port"
	}

	/**
	 * DeviceImplementationKeywords:
	 * 	'device' 'implementation'
	 * ;
	 */
	override protected String getDeviceImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"device implementation"
	}

	/**
	 * EndToEndFlowKeywords:
	 * 	'end' 'to' 'end' 'flow'
	 * ;
	 */
	override protected String getEndToEndFlowKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"end to end flow"
	}

	/**
	 * EventDataKeywords:
	 * 	'event' 'data'
	 * ;
	 */
	override protected String getEventDataKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"event data"
	}

	/**
	 * EventDataPortKeywords:
	 * 	'event' 'data' 'port'
	 * ;
	 */
	override protected String getEventDataPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"event data port"
	}

	/**
	 * EventPortKeywords:
	 * 	'event' 'port'
	 * ;
	 */
	override protected String getEventPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"event port"
	}

	/**
	 * FeatureGroupKeywords:
	 * 	'feature' 'group'
	 * ;
	 */
	override protected String getFeatureGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"feature group"
	}

	/**
	 * InBindingKeywords:
	 * 	'in' 'binding'
	 * ;
	 */
	override protected String getInBindingKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"in binding"
	}

	/**
	 * InModesKeywords:
	 * 	'in' 'modes'
	 * ;
	 */
	override protected String getInModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"in modes"
	}

	/**
	 * InternalFeaturesKeywords:
	 * 	'internal' 'features'
	 * ;
	 */
	override protected String getInternalFeaturesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"internal features"
	}

	/**
	 * InverseOfKeywords:
	 * 	'inverse' 'of'
	 * ;
	 */
	override protected String getInverseOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"inverse of"
	}

	/**
	 * ListOfKeywords:
	 * 	'list' 'of'
	 * ;
	 */
	override protected String getListOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"list of"
	}

	/**
	 * MemoryImplementationKeywords:
	 * 	'memory' 'implementation'
	 * ;
	 */
	override protected String getMemoryImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"memory implementation"
	}

	/**
	 * ProcessImplementationKeywords:
	 * 	'process' 'implementation'
	 * ;
	 */
	override protected String getProcessImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"process implementation"
	}

	/**
	 * ProcessorFeaturesKeywords:
	 * 	'processor' 'features'
	 * ;
	 */
	override protected String getProcessorFeaturesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"processor features"
	}

	/**
	 * ProcessorImplementationKeywords:
	 * 	'processor' 'implementation'
	 * ;
	 */
	override protected String getProcessorImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"processor implementation"
	}

	/**
	 * RangeOfKeywords:
	 * 	'range' 'of'
	 * ;
	 */
	override protected String getRangeOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"range of"
	}

	/**
	 * RefinedToKeywords:
	 * 	'refined' 'to'
	 * ;
	 */
	override protected String getRefinedToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"refined to"
	}

	/**
	 * RequiresModesKeywords:
	 * 	'requires' 'modes'
	 * ;
	 */
	override protected String getRequiresModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"requires modes"
	}

	/**
	 * SubprogramAccessKeywords:
	 * 	'subprogram' 'access'
	 * ;
	 */
	override protected String getSubprogramAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"subprogram access"
	}

	/**
	 * SubprogramGroupAccessKeywords:
	 * 	'subprogram' 'group' 'access'
	 * ;
	 */
	override protected String getSubprogramGroupAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"subprogram group access"
	}

	/**
	 * SubprogramGroupImplementationKeywords:
	 * 	'subprogram' 'group' 'implementation'
	 * ;
	 */
	override protected String getSubprogramGroupImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"subprogram group implementation"
	}

	/**
	 * SubprogramGroupKeywords:
	 * 	'subprogram' 'group'
	 * ;
	 */
	override protected String getSubprogramGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"subprogram group"
	}

	/**
	 * SubprogramImplementationKeywords:
	 * 	'subprogram' 'implementation'
	 * ;
	 */
	override protected String getSubprogramImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"subprogram implementation"
	}

	/**
	 * SystemImplementationKeywords:
	 * 	'system' 'implementation'
	 * ;
	 */
	override protected String getSystemImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"system implementation"
	}

	/**
	 * ThreadGroupImplementationKeywords:
	 * 	'thread' 'group' 'implementation'
	 * ;
	 */
	override protected String getThreadGroupImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"thread group implementation"
	}

	/**
	 * ThreadGroupKeywords:
	 * 	'thread' 'group'
	 * ;
	 */
	override protected String getThreadGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"thread group"
	}

	/**
	 * ThreadImplementationKeywords:
	 * 	'thread' 'implementation'
	 * ;
	 */
	override protected String getThreadImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"thread implementation"
	}

	/**
	 * VirtualBusImplementationKeywords:
	 * 	'virtual' 'bus' 'implementation'
	 * ;
	 */
	override protected String getVirtualBusImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"virtual bus implementation"
	}

	/**
	 * VirtualBusKeywords:
	 * 	'virtual' 'bus'
	 * ;
	 */
	override protected String getVirtualBusKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"virtual bus"
	}

	/**
	 * VirtualProcessorImplementationKeywords:
	 * 	'virtual' 'processor' 'implementation'
	 * ;
	 */
	override protected String getVirtualProcessorImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall,
		INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"virtual processor implementation"
	}

	/**
	 * VirtualProcessorKeywords:
	 * 	'virtual' 'processor'
	 * ;
	 */
	override protected String getVirtualProcessorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			getTokenText(node)
		else
			"virtual processor"
	}

}
