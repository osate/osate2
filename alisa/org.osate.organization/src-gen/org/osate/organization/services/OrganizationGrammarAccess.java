/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.organization.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class OrganizationGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class OrganizationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.organization.Organization.Organization");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOrganizationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cStakeholderAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStakeholderStakeholderParserRuleCall_2_0 = (RuleCall)cStakeholderAssignment_2.eContents().get(0);
		
		//Organization:
		//	'organization' name=ID
		//	stakeholder+=Stakeholder+;
		@Override public ParserRule getRule() { return rule; }

		//'organization' name=ID stakeholder+=Stakeholder+
		public Group getGroup() { return cGroup; }

		//'organization'
		public Keyword getOrganizationKeyword_0() { return cOrganizationKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//stakeholder+=Stakeholder+
		public Assignment getStakeholderAssignment_2() { return cStakeholderAssignment_2; }

		//Stakeholder
		public RuleCall getStakeholderStakeholderParserRuleCall_2_0() { return cStakeholderStakeholderParserRuleCall_2_0; }
	}

	public class StakeholderElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.organization.Organization.Stakeholder");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cUnorderedGroup.eContents().get(0);
		private final Keyword cStakeholderKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_0_3 = (UnorderedGroup)cGroup_0.eContents().get(3);
		private final Group cGroup_0_3_0 = (Group)cUnorderedGroup_0_3.eContents().get(0);
		private final Keyword cFullKeyword_0_3_0_0 = (Keyword)cGroup_0_3_0.eContents().get(0);
		private final Keyword cNameKeyword_0_3_0_1 = (Keyword)cGroup_0_3_0.eContents().get(1);
		private final Assignment cFullnameAssignment_0_3_0_2 = (Assignment)cGroup_0_3_0.eContents().get(2);
		private final RuleCall cFullnameSTRINGTerminalRuleCall_0_3_0_2_0 = (RuleCall)cFullnameAssignment_0_3_0_2.eContents().get(0);
		private final Group cGroup_0_3_1 = (Group)cUnorderedGroup_0_3.eContents().get(1);
		private final Keyword cTitleKeyword_0_3_1_0 = (Keyword)cGroup_0_3_1.eContents().get(0);
		private final Assignment cTitleAssignment_0_3_1_1 = (Assignment)cGroup_0_3_1.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_0_3_1_1_0 = (RuleCall)cTitleAssignment_0_3_1_1.eContents().get(0);
		private final Group cGroup_0_3_2 = (Group)cUnorderedGroup_0_3.eContents().get(2);
		private final Keyword cDescriptionKeyword_0_3_2_0 = (Keyword)cGroup_0_3_2.eContents().get(0);
		private final Assignment cDescriptionAssignment_0_3_2_1 = (Assignment)cGroup_0_3_2.eContents().get(1);
		private final RuleCall cDescriptionSTRINGTerminalRuleCall_0_3_2_1_0 = (RuleCall)cDescriptionAssignment_0_3_2_1.eContents().get(0);
		private final Group cGroup_0_3_3 = (Group)cUnorderedGroup_0_3.eContents().get(3);
		private final Keyword cRoleKeyword_0_3_3_0 = (Keyword)cGroup_0_3_3.eContents().get(0);
		private final Assignment cRoleAssignment_0_3_3_1 = (Assignment)cGroup_0_3_3.eContents().get(1);
		private final RuleCall cRoleSTRINGTerminalRuleCall_0_3_3_1_0 = (RuleCall)cRoleAssignment_0_3_3_1.eContents().get(0);
		private final Group cGroup_0_3_4 = (Group)cUnorderedGroup_0_3.eContents().get(4);
		private final Keyword cEmailKeyword_0_3_4_0 = (Keyword)cGroup_0_3_4.eContents().get(0);
		private final Assignment cEmailAssignment_0_3_4_1 = (Assignment)cGroup_0_3_4.eContents().get(1);
		private final RuleCall cEmailSTRINGTerminalRuleCall_0_3_4_1_0 = (RuleCall)cEmailAssignment_0_3_4_1.eContents().get(0);
		private final Group cGroup_0_3_5 = (Group)cUnorderedGroup_0_3.eContents().get(5);
		private final Keyword cPhoneKeyword_0_3_5_0 = (Keyword)cGroup_0_3_5.eContents().get(0);
		private final Assignment cPhoneAssignment_0_3_5_1 = (Assignment)cGroup_0_3_5.eContents().get(1);
		private final RuleCall cPhoneSTRINGTerminalRuleCall_0_3_5_1_0 = (RuleCall)cPhoneAssignment_0_3_5_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cUnorderedGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Keyword cSupervisorKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Assignment cSupervisorAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final CrossReference cSupervisorStakeholderCrossReference_1_0_1_0 = (CrossReference)cSupervisorAssignment_1_0_1.eContents().get(0);
		private final RuleCall cSupervisorStakeholderQIDParserRuleCall_1_0_1_0_1 = (RuleCall)cSupervisorStakeholderCrossReference_1_0_1_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		
		///*
		// * Stakeholder
		// */ Stakeholder:
		//	'stakeholder' name=ID
		//	'[' (('full' 'name' fullname=STRING)?
		//	& ('title' title=STRING)?
		//	& ('description' description=STRING)?
		//	& ('role' role=STRING)?
		//	& ('email' email=STRING)?
		//	& ('phone' phone=STRING)?) & ('supervisor' supervisor=[Stakeholder|QID])?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'stakeholder' name=ID '[' (('full' 'name' fullname=STRING)? & ('title' title=STRING)? & ('description'
		//description=STRING)? & ('role' role=STRING)? & ('email' email=STRING)? & ('phone' phone=STRING)?) & ('supervisor'
		//supervisor=[Stakeholder|QID])? ']'
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//'stakeholder' name=ID '[' (('full' 'name' fullname=STRING)? & ('title' title=STRING)? & ('description'
		//description=STRING)? & ('role' role=STRING)? & ('email' email=STRING)? & ('phone' phone=STRING)?)
		public Group getGroup_0() { return cGroup_0; }

		//'stakeholder'
		public Keyword getStakeholderKeyword_0_0() { return cStakeholderKeyword_0_0; }

		//name=ID
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_1_0() { return cNameIDTerminalRuleCall_0_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_0_2() { return cLeftSquareBracketKeyword_0_2; }

		//('full' 'name' fullname=STRING)? & ('title' title=STRING)? & ('description' description=STRING)? & ('role' role=STRING)?
		//& ('email' email=STRING)? & ('phone' phone=STRING)?
		public UnorderedGroup getUnorderedGroup_0_3() { return cUnorderedGroup_0_3; }

		//('full' 'name' fullname=STRING)?
		public Group getGroup_0_3_0() { return cGroup_0_3_0; }

		//'full'
		public Keyword getFullKeyword_0_3_0_0() { return cFullKeyword_0_3_0_0; }

		//'name'
		public Keyword getNameKeyword_0_3_0_1() { return cNameKeyword_0_3_0_1; }

		//fullname=STRING
		public Assignment getFullnameAssignment_0_3_0_2() { return cFullnameAssignment_0_3_0_2; }

		//STRING
		public RuleCall getFullnameSTRINGTerminalRuleCall_0_3_0_2_0() { return cFullnameSTRINGTerminalRuleCall_0_3_0_2_0; }

		//('title' title=STRING)?
		public Group getGroup_0_3_1() { return cGroup_0_3_1; }

		//'title'
		public Keyword getTitleKeyword_0_3_1_0() { return cTitleKeyword_0_3_1_0; }

		//title=STRING
		public Assignment getTitleAssignment_0_3_1_1() { return cTitleAssignment_0_3_1_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_0_3_1_1_0() { return cTitleSTRINGTerminalRuleCall_0_3_1_1_0; }

		//('description' description=STRING)?
		public Group getGroup_0_3_2() { return cGroup_0_3_2; }

		//'description'
		public Keyword getDescriptionKeyword_0_3_2_0() { return cDescriptionKeyword_0_3_2_0; }

		//description=STRING
		public Assignment getDescriptionAssignment_0_3_2_1() { return cDescriptionAssignment_0_3_2_1; }

		//STRING
		public RuleCall getDescriptionSTRINGTerminalRuleCall_0_3_2_1_0() { return cDescriptionSTRINGTerminalRuleCall_0_3_2_1_0; }

		//('role' role=STRING)?
		public Group getGroup_0_3_3() { return cGroup_0_3_3; }

		//'role'
		public Keyword getRoleKeyword_0_3_3_0() { return cRoleKeyword_0_3_3_0; }

		//role=STRING
		public Assignment getRoleAssignment_0_3_3_1() { return cRoleAssignment_0_3_3_1; }

		//STRING
		public RuleCall getRoleSTRINGTerminalRuleCall_0_3_3_1_0() { return cRoleSTRINGTerminalRuleCall_0_3_3_1_0; }

		//('email' email=STRING)?
		public Group getGroup_0_3_4() { return cGroup_0_3_4; }

		//'email'
		public Keyword getEmailKeyword_0_3_4_0() { return cEmailKeyword_0_3_4_0; }

		//email=STRING
		public Assignment getEmailAssignment_0_3_4_1() { return cEmailAssignment_0_3_4_1; }

		//STRING
		public RuleCall getEmailSTRINGTerminalRuleCall_0_3_4_1_0() { return cEmailSTRINGTerminalRuleCall_0_3_4_1_0; }

		//('phone' phone=STRING)?
		public Group getGroup_0_3_5() { return cGroup_0_3_5; }

		//'phone'
		public Keyword getPhoneKeyword_0_3_5_0() { return cPhoneKeyword_0_3_5_0; }

		//phone=STRING
		public Assignment getPhoneAssignment_0_3_5_1() { return cPhoneAssignment_0_3_5_1; }

		//STRING
		public RuleCall getPhoneSTRINGTerminalRuleCall_0_3_5_1_0() { return cPhoneSTRINGTerminalRuleCall_0_3_5_1_0; }

		//('supervisor' supervisor=[Stakeholder|QID])? ']'
		public Group getGroup_1() { return cGroup_1; }

		//('supervisor' supervisor=[Stakeholder|QID])?
		public Group getGroup_1_0() { return cGroup_1_0; }

		//'supervisor'
		public Keyword getSupervisorKeyword_1_0_0() { return cSupervisorKeyword_1_0_0; }

		//supervisor=[Stakeholder|QID]
		public Assignment getSupervisorAssignment_1_0_1() { return cSupervisorAssignment_1_0_1; }

		//[Stakeholder|QID]
		public CrossReference getSupervisorStakeholderCrossReference_1_0_1_0() { return cSupervisorStakeholderCrossReference_1_0_1_0; }

		//QID
		public RuleCall getSupervisorStakeholderQIDParserRuleCall_1_0_1_0_1() { return cSupervisorStakeholderQIDParserRuleCall_1_0_1_0_1; }

		//']'
		public Keyword getRightSquareBracketKeyword_1_1() { return cRightSquareBracketKeyword_1_1; }
	}

	public class QIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.organization.Organization.QID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QID:
		//	ID ('.' ID)?;
		@Override public ParserRule getRule() { return rule; }

		//ID ('.' ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//('.' ID)?
		public Group getGroup_1() { return cGroup_1; }

		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final OrganizationElements pOrganization;
	private final StakeholderElements pStakeholder;
	private final QIDElements pQID;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public OrganizationGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pOrganization = new OrganizationElements();
		this.pStakeholder = new StakeholderElements();
		this.pQID = new QIDElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.organization.Organization".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Organization:
	//	'organization' name=ID
	//	stakeholder+=Stakeholder+;
	public OrganizationElements getOrganizationAccess() {
		return pOrganization;
	}
	
	public ParserRule getOrganizationRule() {
		return getOrganizationAccess().getRule();
	}

	///*
	// * Stakeholder
	// */ Stakeholder:
	//	'stakeholder' name=ID
	//	'[' (('full' 'name' fullname=STRING)?
	//	& ('title' title=STRING)?
	//	& ('description' description=STRING)?
	//	& ('role' role=STRING)?
	//	& ('email' email=STRING)?
	//	& ('phone' phone=STRING)?) & ('supervisor' supervisor=[Stakeholder|QID])?
	//	']';
	public StakeholderElements getStakeholderAccess() {
		return pStakeholder;
	}
	
	public ParserRule getStakeholderRule() {
		return getStakeholderAccess().getRule();
	}

	//QID:
	//	ID ('.' ID)?;
	public QIDElements getQIDAccess() {
		return pQID;
	}
	
	public ParserRule getQIDRule() {
		return getQIDAccess().getRule();
	}

	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
