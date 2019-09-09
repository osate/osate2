/*
 *
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
