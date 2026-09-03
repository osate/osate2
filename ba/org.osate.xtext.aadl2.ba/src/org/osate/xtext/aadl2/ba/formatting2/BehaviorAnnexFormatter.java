/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;

public class BehaviorAnnexFormatter extends PropertiesFormatter {

    protected void format(BehaviorAnnex behaviorAnnex, IFormattableDocument doc) {
        // TODO: format HiddenRegions around keywords, attributes, cross references, etc.
        for (BehaviorVariableGroup behaviorVariableGroup : behaviorAnnex.getVariableGroups()) {
            doc.format(behaviorVariableGroup);
        }
        for (BehaviorStateGroup behaviorStateGroup : behaviorAnnex.getStateGroups()) {
            doc.format(behaviorStateGroup);
        }
        for (BehaviorTransition behaviorTransition : behaviorAnnex.getTransitions()) {
            doc.format(behaviorTransition);
        }
    }

    protected void format(BehaviorVariableGroup behaviorVariableGroup, IFormattableDocument doc) {
        // TODO: format HiddenRegions around keywords, attributes, cross references, etc.
        for (BehaviorVariable behaviorVariable : behaviorVariableGroup.getVariables()) {
            doc.format(behaviorVariable);
        }
        doc.format(behaviorVariableGroup.getInitialValue());
        for (BehaviorPropertyAssociation behaviorPropertyAssociation : behaviorVariableGroup.getPropertyAssociations()) {
            doc.format(behaviorPropertyAssociation);
        }
    }

    // TODO: implement for BehaviorVariable, ArrayDimension, BehaviorPropertyAssociation, BehaviorStateGroup, BehaviorTransition, BehaviorCondition, ExecuteCondition, DispatchCondition, DispatchTriggerCondition, DispatchTriggerLogicalExpression, DispatchConjunction, ModeSwitchCondition, ModeSwitchConjunction, BehaviorActionBlock, BehaviorActionSequence, BehaviorActionSet, AssignmentAction, CommunicationAction, TimedAction, IfStatement, ElseIfClause, ForStatement, WhileStatement, DoUntilStatement, ElementValues, BehaviorTime, BinaryExpression, UnaryExpression, ReferenceExpression, HashPropertyReference, PropertyReferenceTail, NamedPropertyField, PropertyArrayIndex, UnindexedReferenceExpression, UnindexedReference, UnindexedReferenceTail, Reference, ReferenceTail, ReferenceSegment, ArrayIndex
}
