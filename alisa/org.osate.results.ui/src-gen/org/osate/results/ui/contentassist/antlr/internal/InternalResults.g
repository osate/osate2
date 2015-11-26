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




// Entry rule entryRuleResultReports
entryRuleResultReports 
:
{ before(grammarAccess.getResultReportsRule()); }
	 ruleResultReports
{ after(grammarAccess.getResultReportsRule()); } 
	 EOF 
;

// Rule ResultReports
ruleResultReports
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultReportsAccess().getAlternatives()); }
(rule__ResultReports__Alternatives)
{ after(grammarAccess.getResultReportsAccess().getAlternatives()); }
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
{ before(grammarAccess.getResultReportAccess().getGroup()); }
(rule__ResultReport__Group__0)
{ after(grammarAccess.getResultReportAccess().getGroup()); }
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



// Entry rule entryRuleIssueReport
entryRuleIssueReport 
:
{ before(grammarAccess.getIssueReportRule()); }
	 ruleIssueReport
{ after(grammarAccess.getIssueReportRule()); } 
	 EOF 
;

// Rule IssueReport
ruleIssueReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIssueReportAccess().getGroup()); }
(rule__IssueReport__Group__0)
{ after(grammarAccess.getIssueReportAccess().getGroup()); }
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



rule__ResultReports__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); }
	ruleResultReport
{ after(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); }
	ruleResultReportCollection
{ after(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); }
	ruleIssueReport
{ after(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); }
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
{ before(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); }
(	'error' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); }
(	'warning' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); }
(	'info' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); }
(	'success' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); }
(	'fail' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); }
(	'unknown' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); }
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
{ before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); }

	'[' 

{ after(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); }
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
{ before(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); }

	'target' 

{ after(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); }
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
{ before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); }
(rule__ResultReportCollection__TargetAssignment_5)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); }
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






rule__ResultReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__0__Impl
	rule__ResultReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getResultReportAction_0()); }
(

)
{ after(grammarAccess.getResultReportAccess().getResultReportAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__1__Impl
	rule__ResultReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getReportKeyword_1()); }

	'report' 

{ after(grammarAccess.getResultReportAccess().getReportKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__2__Impl
	rule__ResultReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getNameAssignment_2()); }
(rule__ResultReport__NameAssignment_2)
{ after(grammarAccess.getResultReportAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__3__Impl
	rule__ResultReport__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getGroup_3()); }
(rule__ResultReport__Group_3__0)?
{ after(grammarAccess.getResultReportAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__4__Impl
	rule__ResultReport__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getTargetAssignment_4()); }
(rule__ResultReport__TargetAssignment_4)
{ after(grammarAccess.getResultReportAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__5__Impl
	rule__ResultReport__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getIssueTypeAssignment_5()); }
(rule__ResultReport__IssueTypeAssignment_5)
{ after(grammarAccess.getResultReportAccess().getIssueTypeAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__6__Impl
	rule__ResultReport__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getMessageAssignment_6()); }
(rule__ResultReport__MessageAssignment_6)
{ after(grammarAccess.getResultReportAccess().getMessageAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__7__Impl
	rule__ResultReport__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getGroup_7()); }
(rule__ResultReport__Group_7__0)?
{ after(grammarAccess.getResultReportAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__8__Impl
	rule__ResultReport__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8()); }

	'[' 

{ after(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__9__Impl
	rule__ResultReport__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getGroup_9()); }
(rule__ResultReport__Group_9__0)?
{ after(grammarAccess.getResultReportAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__10__Impl
	rule__ResultReport__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getGroup_10()); }
(rule__ResultReport__Group_10__0)?
{ after(grammarAccess.getResultReportAccess().getGroup_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__11__Impl
	rule__ResultReport__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getGroup_11()); }
(rule__ResultReport__Group_11__0)?
{ after(grammarAccess.getResultReportAccess().getGroup_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__12__Impl
	rule__ResultReport__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getIssuesAssignment_12()); }
(rule__ResultReport__IssuesAssignment_12)?
{ after(grammarAccess.getResultReportAccess().getIssuesAssignment_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group__13__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group__13__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13()); }

	']' 

{ after(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}






























rule__ResultReport__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_3__0__Impl
	rule__ResultReport__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getColonKeyword_3_0()); }

	':' 

{ after(grammarAccess.getResultReportAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getTitleAssignment_3_1()); }
(rule__ResultReport__TitleAssignment_3_1)
{ after(grammarAccess.getResultReportAccess().getTitleAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultReport__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_7__0__Impl
	rule__ResultReport__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getExceptionKeyword_7_0()); }

	'exception' 

{ after(grammarAccess.getResultReportAccess().getExceptionKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getExceptionTypeAssignment_7_1()); }
(rule__ResultReport__ExceptionTypeAssignment_7_1)
{ after(grammarAccess.getResultReportAccess().getExceptionTypeAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultReport__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_9__0__Impl
	rule__ResultReport__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0()); }

	'description' 

{ after(grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getDecriptionAssignment_9_1()); }
(rule__ResultReport__DecriptionAssignment_9_1)
{ after(grammarAccess.getResultReportAccess().getDecriptionAssignment_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultReport__Group_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_10__0__Impl
	rule__ResultReport__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getHeadingKeyword_10_0()); }

	'heading' 

{ after(grammarAccess.getResultReportAccess().getHeadingKeyword_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_10__1__Impl
	rule__ResultReport__Group_10__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getHeadingAssignment_10_1()); }
(rule__ResultReport__HeadingAssignment_10_1)
{ after(grammarAccess.getResultReportAccess().getHeadingAssignment_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_10__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_10__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_10__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getContentAssignment_10_2()); }
(rule__ResultReport__ContentAssignment_10_2)*
{ after(grammarAccess.getResultReportAccess().getContentAssignment_10_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ResultReport__Group_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_11__0__Impl
	rule__ResultReport__Group_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getResultsKeyword_11_0()); }

	'results' 

{ after(grammarAccess.getResultReportAccess().getResultsKeyword_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReport__Group_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReport__Group_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__Group_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); }
(rule__ResultReport__ResultDataAssignment_11_1)
{ after(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); }
)
(
{ before(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); }
(rule__ResultReport__ResultDataAssignment_11_1)*
{ after(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); }
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
{ before(grammarAccess.getResultContributorAccess().getResultContributorAction_0()); }
(

)
{ after(grammarAccess.getResultContributorAccess().getResultContributorAction_0()); }
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
{ before(grammarAccess.getResultContributorAccess().getContributorKeyword_1()); }

	'contributor' 

{ after(grammarAccess.getResultContributorAccess().getContributorKeyword_1()); }
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
{ before(grammarAccess.getResultContributorAccess().getTargetAssignment_2()); }
(rule__ResultContributor__TargetAssignment_2)
{ after(grammarAccess.getResultContributorAccess().getTargetAssignment_2()); }
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
{ before(grammarAccess.getResultContributorAccess().getIssueTypeAssignment_3()); }
(rule__ResultContributor__IssueTypeAssignment_3)
{ after(grammarAccess.getResultContributorAccess().getIssueTypeAssignment_3()); }
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
{ before(grammarAccess.getResultContributorAccess().getMessageAssignment_4()); }
(rule__ResultContributor__MessageAssignment_4)
{ after(grammarAccess.getResultContributorAccess().getMessageAssignment_4()); }
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
{ before(grammarAccess.getResultContributorAccess().getGroup_5()); }
(rule__ResultContributor__Group_5__0)?
{ after(grammarAccess.getResultContributorAccess().getGroup_5()); }
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
	rule__ResultContributor__Group__7
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
{ before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6()); }

	'[' 

{ after(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__7__Impl
	rule__ResultContributor__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getDataKeyword_7()); }

	'data' 

{ after(grammarAccess.getResultContributorAccess().getDataKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__8__Impl
	rule__ResultContributor__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultContributorAccess().getCellAssignment_8()); }
(rule__ResultContributor__CellAssignment_8)
{ after(grammarAccess.getResultContributorAccess().getCellAssignment_8()); }
)
(
{ before(grammarAccess.getResultContributorAccess().getCellAssignment_8()); }
(rule__ResultContributor__CellAssignment_8)*
{ after(grammarAccess.getResultContributorAccess().getCellAssignment_8()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__9__Impl
	rule__ResultContributor__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesAssignment_9()); }
(rule__ResultContributor__IssuesAssignment_9)*
{ after(grammarAccess.getResultContributorAccess().getIssuesAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__10__Impl
	rule__ResultContributor__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_10()); }
(rule__ResultContributor__SubcontributorAssignment_10)*
{ after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11()); }

	']' 

{ after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


























rule__ResultContributor__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_5__0__Impl
	rule__ResultContributor__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0()); }

	'exception' 

{ after(grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getExceptionTypeAssignment_5_1()); }
(rule__ResultContributor__ExceptionTypeAssignment_5_1)
{ after(grammarAccess.getResultContributorAccess().getExceptionTypeAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssueReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__0__Impl
	rule__IssueReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssueReportAction_0()); }
(

)
{ after(grammarAccess.getIssueReportAccess().getIssueReportAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__1__Impl
	rule__IssueReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssuesKeyword_1()); }

	'issues' 

{ after(grammarAccess.getIssueReportAccess().getIssuesKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__2__Impl
	rule__IssueReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssueTypeAssignment_2()); }
(rule__IssueReport__IssueTypeAssignment_2)
{ after(grammarAccess.getIssueReportAccess().getIssueTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__3__Impl
	rule__IssueReport__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getMessageAssignment_3()); }
(rule__IssueReport__MessageAssignment_3)
{ after(grammarAccess.getIssueReportAccess().getMessageAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__4__Impl
	rule__IssueReport__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getGroup_4()); }
(rule__IssueReport__Group_4__0)?
{ after(grammarAccess.getIssueReportAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__5__Impl
	rule__IssueReport__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getGroup_5()); }
(rule__IssueReport__Group_5__0)?
{ after(grammarAccess.getIssueReportAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getGroup_6()); }
(rule__IssueReport__Group_6__0)?
{ after(grammarAccess.getIssueReportAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__IssueReport__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_4__0__Impl
	rule__IssueReport__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getTargetKeyword_4_0()); }

	'target' 

{ after(grammarAccess.getIssueReportAccess().getTargetKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getTargetAssignment_4_1()); }
(rule__IssueReport__TargetAssignment_4_1)
{ after(grammarAccess.getIssueReportAccess().getTargetAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssueReport__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_5__0__Impl
	rule__IssueReport__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0()); }

	'exception' 

{ after(grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getExceptionTypeAssignment_5_1()); }
(rule__IssueReport__ExceptionTypeAssignment_5_1)
{ after(grammarAccess.getIssueReportAccess().getExceptionTypeAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssueReport__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_6__0__Impl
	rule__IssueReport__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0()); }

	'[' 

{ after(grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_6__1__Impl
	rule__IssueReport__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssuesAssignment_6_1()); }
(rule__IssueReport__IssuesAssignment_6_1)*
{ after(grammarAccess.getIssueReportAccess().getIssuesAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssueReport__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssueReport__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2()); }

	']' 

{ after(grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2()); }
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

rule__ResultReportCollection__TargetAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); }
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); }
	ruleURIID{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); }
)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); }
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

rule__ResultReport__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__TitleAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); }
(
{ before(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
	ruleURIID{ after(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__IssueTypeAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); }
	ruleResultIssueType{ after(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__MessageAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__ExceptionTypeAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__DecriptionAssignment_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__HeadingAssignment_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__ContentAssignment_10_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); }
	ruleResultContributor{ after(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__ResultDataAssignment_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); }
	ruleResultData{ after(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReport__IssuesAssignment_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); }
	ruleResultIssue{ after(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__TargetAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); }
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); }
	ruleURIID{ after(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__IssueTypeAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); }
	ruleResultIssueType{ after(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__MessageAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); }
	RULE_STRING{ after(grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__ExceptionTypeAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__CellAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); }
	RULE_STRING{ after(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__IssuesAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); }
	ruleResultIssue{ after(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__SubcontributorAssignment_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); }
	ruleResultContributor{ after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__IssueTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); }
	ruleResultIssueType{ after(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__MessageAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); }
	RULE_STRING{ after(grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__TargetAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); }
(
{ before(grammarAccess.getIssueReportAccess().getTargetEObjectURIIDParserRuleCall_4_1_0_1()); }
	ruleURIID{ after(grammarAccess.getIssueReportAccess().getTargetEObjectURIIDParserRuleCall_4_1_0_1()); }
)
{ after(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__ExceptionTypeAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); }
	RULE_STRING{ after(grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssueReport__IssuesAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); }
	ruleResultIssue{ after(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); }
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


