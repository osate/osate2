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
package org.osate.xtext.aadl2.ba.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * Verifies the Phase 8 formatter through Xtext's formatter test harness so whitespace, indentation, and reparsing are
 * checked on the real Behavior Annex grammar rather than on a string-only helper.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class BehaviorAnnexFormatterTest {
	@Inject
	private FormatterTestHelper formatter;

	@Test
	public void formatsDeclarationsTransitionsAndNestedActions() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted(
					"variables counter,other:Base_Types::Integer:=1;states idle:initial state;running:final state;"
							+ "transitions start:idle-[counter=1]->running{counter:=counter+1;output!(counter)};");
			request.setExpectation("""
					variables
						counter, other: Base_Types::Integer := 1;
					states
						idle: initial state;
						running: final state;
					transitions
						start: idle -[counter = 1]-> running {
							counter := counter + 1;
							output!(counter)
						};
					""");
		});
	}

	@Test
	public void indentsBranchesWithoutAnActionBlockOnLinesOfTheirOwn() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{if(counter=1)"
					+ "counter:=2 elsif(counter=2)counter:=3 else counter:=4 end if};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							if (counter = 1)
								counter := 2
							elsif (counter = 2)
								counter := 3
							else
								counter := 4
							end if
						};
					""");
		});
	}

	@Test
	public void startsTheFirstSectionWithoutLeadingWhitespace() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("   states idle:initial state;");
			request.setExpectation("""
					states
						idle: initial state;
					""");
		});
	}

	@Test
	public void keepsTheCaseOfKeywordsThatAreNotWrittenInLowerCase() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("VaRiAbLeS counter:Base_Types::Integer;StAtEs idle:INITIAL state;");
			request.setExpectation("""
					VaRiAbLeS
						counter: Base_Types::Integer;
					StAtEs
						idle: INITIAL state;
					""");
		});
	}

	@Test
	public void hugsUnaryOperatorsToTheirOperand() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{counter:=-1;counter:=-counter+1};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							counter := -1;
							counter := -counter + 1
						};
					""");
		});
	}

	@Test
	public void startsANestedActionBlockOnALineOfItsOwn() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{{counter:=1}};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							{
								counter := 1
							}
						};
					""");
		});
	}

	@Test
	public void separatesTheTimeoutKeywordFromAPropertyValue() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{counter:=1}timeout#ps::c ms;");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							counter := 1
						} timeout #ps::c ms;
					""");
		});
	}

	@Test
	public void leavesPropertyValuesToTheAadlFormatter() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer:=0"
					+ "{Data_Model::Initial_Value => (\"1\");};states idle:initial state;");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer := 0 {
							Data_Model::Initial_Value => ("1");
						};
					states
						idle: initial state;
					""");
		});
	}

	@Test
	public void hugsTheNumberSignOfAPropertyReferenceOnlyWhenItFollowsAReference() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{counter:=#ps::p;counter:=counter#ps::p;"
					+ "counter:=counter+#ps::p};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							counter := #ps::p;
							counter := counter#ps::p;
							counter := counter + #ps::p
						};
					""");
		});
	}

	@Test
	public void putsNoSpaceInsideTheLockAllAction() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{*!<;*!>};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							*!<;
							*!>
						};
					""");
		});
	}

	@Test
	public void indentsANestedIfStatementInsideItsBranch() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{if(counter=1)if(counter=2)counter:=3 end if end if};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							if (counter = 1)
								if (counter = 2)
									counter := 3
								end if
							end if
						};
					""");
		});
	}

	@Test
	public void keepsTheOpeningBraceOfABranchOnTheLineOfItsCondition() {
		formatter.assertFormatted(request -> {
			request.setUseSerializer(false);
			request.setAllowUnformattedWhitespace(false);
			request.setToBeFormatted("variables counter:Base_Types::Integer;states idle:initial state;"
					+ "transitions start:idle-[]->idle{if(counter=1)"
					+ "{counter:=2}elsif(counter=2){counter:=3}else{counter:=4}end if};");
			request.setExpectation("""
					variables
						counter: Base_Types::Integer;
					states
						idle: initial state;
					transitions
						start: idle -[]-> idle {
							if (counter = 1) {
								counter := 2
							} elsif (counter = 2) {
								counter := 3
							} else {
								counter := 4
							} end if
						};
					""");
		});
	}
}
