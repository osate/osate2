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
grammar InternalResults;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.osate.results.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.osate.results.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.osate.results.services.ResultsGrammarAccess;

}

@parser::members {
 
 	private ResultsGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(ResultsGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleResultReport
entryRuleResultReport 
:
{ before(grammarAccess.getResultReportRule()); }
	 ruleResultReport
{ after(grammarAccess.getResultReportRule()); } 
	 EOF 
;

// Rule ResultReport
ruleResultReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultReportAccess().getAlternatives()); }
(rule__ResultReport__Alternatives)
{ after(grammarAccess.getResultReportAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultReportCollection
entryRuleResultReportCollection 
:
{ before(grammarAccess.getResultReportCollectionRule()); }
	 ruleResultReportCollection
{ after(grammarAccess.getResultReportCollectionRule()); } 
	 EOF 
;

// Rule ResultReportCollection
ruleResultReportCollection
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup()); }
(rule__ResultReportCollection__Group__0)
{ after(grammarAccess.getResultReportCollectionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultDataReport
entryRuleResultDataReport 
:
{ before(grammarAccess.getResultDataReportRule()); }
	 ruleResultDataReport
{ after(grammarAccess.getResultDataReportRule()); } 
	 EOF 
;

// Rule ResultDataReport
ruleResultDataReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup()); }
(rule__ResultDataReport__Group__0)
{ after(grammarAccess.getResultDataReportAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultContributor
entryRuleResultContributor 
:
{ before(grammarAccess.getResultContributorRule()); }
	 ruleResultContributor
{ after(grammarAccess.getResultContributorRule()); } 
	 EOF 
;

// Rule ResultContributor
ruleResultContributor
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultContributorAccess().getGroup()); }
(rule__ResultContributor__Group__0)
{ after(grammarAccess.getResultContributorAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIssuesReport
entryRuleIssuesReport 
:
{ before(grammarAccess.getIssuesReportRule()); }
	 ruleIssuesReport
{ after(grammarAccess.getIssuesReportRule()); } 
	 EOF 
;

// Rule IssuesReport
ruleIssuesReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup()); }
(rule__IssuesReport__Group__0)
{ after(grammarAccess.getIssuesReportAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultIssue
entryRuleResultIssue 
:
{ before(grammarAccess.getResultIssueRule()); }
	 ruleResultIssue
{ after(grammarAccess.getResultIssueRule()); } 
	 EOF 
;

// Rule ResultIssue
ruleResultIssue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultIssueAccess().getGroup()); }
(rule__ResultIssue__Group__0)
{ after(grammarAccess.getResultIssueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultData
entryRuleResultData 
:
{ before(grammarAccess.getResultDataRule()); }
	 ruleResultData
{ after(grammarAccess.getResultDataRule()); } 
	 EOF 
;

// Rule ResultData
ruleResultData
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultDataAccess().getGroup()); }
(rule__ResultData__Group__0)
{ after(grammarAccess.getResultDataAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIID
entryRuleURIID 
:
{ before(grammarAccess.getURIIDRule()); }
	 ruleURIID
{ after(grammarAccess.getURIIDRule()); } 
	 EOF 
;

// Rule URIID
ruleURIID
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); }
	RULE_STRING
{ after(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}




// Rule ResultIssueType
ruleResultIssueType
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueTypeAccess().getAlternatives()); }
(rule__ResultIssueType__Alternatives)
{ after(grammarAccess.getResultIssueTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__ResultReport__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); }
	ruleResultDataReport
{ after(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); }
	ruleResultReportCollection
{ after(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); }
	ruleIssuesReport
{ after(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssueType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); }
(	'tbd' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); }
(	'unknown' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); }
(	'error' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); }
(	'warning' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); }
(	'info' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); }
(	'success' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); }
(	'fail' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__ResultReportCollection__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__0__Impl
	rule__ResultReportCollection__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); }

	'reports' 

{ after(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__1__Impl
	rule__ResultReportCollection__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); }
(rule__ResultReportCollection__NameAssignment_1)
{ after(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__2__Impl
	rule__ResultReportCollection__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); }
(rule__ResultReportCollection__Group_2__0)?
{ after(grammarAccess.getResultReportCollectionAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__3__Impl
	rule__ResultReportCollection__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); }

	'for' 

{ after(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__4__Impl
	rule__ResultReportCollection__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); }
(rule__ResultReportCollection__TargetAssignment_4)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__5__Impl
	rule__ResultReportCollection__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); }

	'[' 

{ after(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__6__Impl
	rule__ResultReportCollection__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); }
(rule__ResultReportCollection__Group_6__0)?
{ after(grammarAccess.getResultReportCollectionAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__7__Impl
	rule__ResultReportCollection__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); }
(rule__ResultReportCollection__ContentAssignment_7)*
{ after(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__8__Impl
	rule__ResultReportCollection__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); }
(rule__ResultReportCollection__IssuesAssignment_8)?
{ after(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); }

	']' 

{ after(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__ResultReportCollection__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_2__0__Impl
	rule__ResultReportCollection__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); }

	':' 

{ after(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); }
(rule__ResultReportCollection__TitleAssignment_2_1)
{ after(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultReportCollection__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_6__0__Impl
	rule__ResultReportCollection__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); }

	'description' 

{ after(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); }
(rule__ResultReportCollection__DecriptionAssignment_6_1)
{ after(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__0__Impl
	rule__ResultDataReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); }

	'report' 

{ after(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__1__Impl
	rule__ResultDataReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); }
(rule__ResultDataReport__NameAssignment_1)
{ after(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__2__Impl
	rule__ResultDataReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_2()); }
(rule__ResultDataReport__Group_2__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__3__Impl
	rule__ResultDataReport__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getForKeyword_3()); }

	'for' 

{ after(grammarAccess.getResultDataReportAccess().getForKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__4__Impl
	rule__ResultDataReport__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); }
(rule__ResultDataReport__TargetAssignment_4)
{ after(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__5__Impl
	rule__ResultDataReport__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); }

	'[' 

{ after(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__6__Impl
	rule__ResultDataReport__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_6()); }
(rule__ResultDataReport__Group_6__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__7__Impl
	rule__ResultDataReport__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_7()); }
(rule__ResultDataReport__Group_7__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__8__Impl
	rule__ResultDataReport__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_8()); }
(rule__ResultDataReport__Group_8__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__9__Impl
	rule__ResultDataReport__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); }
(rule__ResultDataReport__IssuesAssignment_9)*
{ after(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); }

	']' 

{ after(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__ResultDataReport__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_2__0__Impl
	rule__ResultDataReport__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); }

	':' 

{ after(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); }
(rule__ResultDataReport__TitleAssignment_2_1)
{ after(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_6__0__Impl
	rule__ResultDataReport__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); }

	'description' 

{ after(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDecriptionAssignment_6_1()); }
(rule__ResultDataReport__DecriptionAssignment_6_1)
{ after(grammarAccess.getResultDataReportAccess().getDecriptionAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__0__Impl
	rule__ResultDataReport__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); }

	'heading' 

{ after(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__1__Impl
	rule__ResultDataReport__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); }
(rule__ResultDataReport__HeadingAssignment_7_1)
{ after(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); }
(rule__ResultDataReport__ContentAssignment_7_2)*
{ after(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ResultDataReport__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_8__0__Impl
	rule__ResultDataReport__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); }

	'results' 

{ after(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
(rule__ResultDataReport__ResultDataAssignment_8_1)
{ after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
)
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
(rule__ResultDataReport__ResultDataAssignment_8_1)*
{ after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultContributor__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__0__Impl
	rule__ResultContributor__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); }

	'contributor' 

{ after(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__1__Impl
	rule__ResultContributor__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); }
(rule__ResultContributor__TargetAssignment_1)
{ after(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__2__Impl
	rule__ResultContributor__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); }

	'[' 

{ after(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__3__Impl
	rule__ResultContributor__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getGroup_3()); }
(rule__ResultContributor__Group_3__0)?
{ after(grammarAccess.getResultContributorAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__4__Impl
	rule__ResultContributor__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); }
(rule__ResultContributor__IssuesAssignment_4)*
{ after(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__5__Impl
	rule__ResultContributor__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); }
(rule__ResultContributor__SubcontributorAssignment_5)*
{ after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); }

	']' 

{ after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ResultContributor__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_3__0__Impl
	rule__ResultContributor__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); }

	'results' 

{ after(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
(rule__ResultContributor__ResultDataAssignment_3_1)
{ after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
)
(
{ before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
(rule__ResultContributor__ResultDataAssignment_3_1)*
{ after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssuesReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__0__Impl
	rule__IssuesReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); }

	'issues' 

{ after(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__1__Impl
	rule__IssuesReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); }
(rule__IssuesReport__NameAssignment_1)
{ after(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__2__Impl
	rule__IssuesReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_2()); }
(rule__IssuesReport__Group_2__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_3()); }
(rule__IssuesReport__Group_3__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IssuesReport__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_2__0__Impl
	rule__IssuesReport__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); }

	'for' 

{ after(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); }
(rule__IssuesReport__TargetAssignment_2_1)
{ after(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssuesReport__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__0__Impl
	rule__IssuesReport__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); }

	'[' 

{ after(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__1__Impl
	rule__IssuesReport__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_3_1()); }
(rule__IssuesReport__Group_3_1__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__2__Impl
	rule__IssuesReport__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); }
(rule__IssuesReport__IssuesAssignment_3_2)*
{ after(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); }

	']' 

{ after(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IssuesReport__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3_1__0__Impl
	rule__IssuesReport__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); }

	'description' 

{ after(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); }
(rule__IssuesReport__DescriptionAssignment_3_1_1)
{ after(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__0__Impl
	rule__ResultIssue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssueKeyword_0()); }

	'issue' 

{ after(grammarAccess.getResultIssueAccess().getIssueKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__1__Impl
	rule__ResultIssue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1()); }
(rule__ResultIssue__IssueTypeAssignment_1)
{ after(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__2__Impl
	rule__ResultIssue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getMessageAssignment_2()); }
(rule__ResultIssue__MessageAssignment_2)
{ after(grammarAccess.getResultIssueAccess().getMessageAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__3__Impl
	rule__ResultIssue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_3()); }
(rule__ResultIssue__Group_3__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__4__Impl
	rule__ResultIssue__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_4()); }
(rule__ResultIssue__Group_4__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_5()); }
(rule__ResultIssue__Group_5__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ResultIssue__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_3__0__Impl
	rule__ResultIssue__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetKeyword_3_0()); }

	'target' 

{ after(grammarAccess.getResultIssueAccess().getTargetKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1()); }
(rule__ResultIssue__TargetAssignment_3_1)
{ after(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_4__0__Impl
	rule__ResultIssue__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0()); }

	'exception' 

{ after(grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1()); }
(rule__ResultIssue__ExceptionTypeAssignment_4_1)
{ after(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__0__Impl
	rule__ResultIssue__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); }

	'[' 

{ after(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__1__Impl
	rule__ResultIssue__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); }
(rule__ResultIssue__IssuesAssignment_5_1)*
{ after(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); }

	']' 

{ after(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ResultData__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__0__Impl
	rule__ResultData__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getNameAssignment_0()); }
(rule__ResultData__NameAssignment_0)
{ after(grammarAccess.getResultDataAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultData__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__1__Impl
	rule__ResultData__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); }

	'=' 

{ after(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultData__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getValueAssignment_2()); }
(rule__ResultData__ValueAssignment_2)
{ after(grammarAccess.getResultDataAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__ResultReportCollection__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); }
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
	ruleURIID{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__DecriptionAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__ContentAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); }
	ruleResultReport{ after(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__IssuesAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); }
	ruleResultIssue{ after(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); }
(
{ before(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
	ruleURIID{ after(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__DecriptionAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__HeadingAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__ContentAssignment_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); }
	ruleResultContributor{ after(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__ResultDataAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); }
	ruleResultData{ after(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__IssuesAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); }
	ruleResultIssue{ after(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__TargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); }
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); }
	ruleURIID{ after(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__ResultDataAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); }
	ruleResultData{ after(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__IssuesAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); }
	ruleResultIssue{ after(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__SubcontributorAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); }
	ruleResultContributor{ after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__TargetAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); }
(
{ before(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
	ruleURIID{ after(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__DescriptionAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__IssuesAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); }
	ruleResultIssue{ after(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__IssueTypeAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); }
	ruleResultIssueType{ after(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__MessageAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__TargetAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); }
(
{ before(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_3_1_0_1()); }
	ruleURIID{ after(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__ExceptionTypeAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__IssuesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); }
	ruleResultIssue{ after(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


