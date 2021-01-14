/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
lexer grammar InternalAadl2Lexer;

@header {
package org.osate.xtext.aadl2.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

Implementation : ('I'|'i')('M'|'m')('P'|'p')('L'|'l')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Subcomponents : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

Aadlboolean : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('B'|'b')('O'|'o')('O'|'o')('L'|'l')('E'|'e')('A'|'a')('N'|'n');

Aadlinteger : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('I'|'i')('N'|'n')('T'|'t')('E'|'e')('G'|'g')('E'|'e')('R'|'r');

Connections : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Enumeration : ('E'|'e')('N'|'n')('U'|'u')('M'|'m')('E'|'e')('R'|'r')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Aadlstring : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('S'|'s')('T'|'t')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

Classifier : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

Properties : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('I'|'i')('E'|'e')('S'|'s');

Prototypes : ('P'|'p')('R'|'r')('O'|'o')('T'|'t')('O'|'o')('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('S'|'s');

Subprogram : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m');

Parameter : ('P'|'p')('A'|'a')('R'|'r')('A'|'a')('M'|'m')('E'|'e')('T'|'t')('E'|'e')('R'|'r');

Processor : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Prototype : ('P'|'p')('R'|'r')('O'|'o')('T'|'t')('O'|'o')('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Reference : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Aadlreal : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('R'|'r')('E'|'e')('A'|'a')('L'|'l');

Abstract : ('A'|'a')('B'|'b')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('C'|'c')('T'|'t');

Constant : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

Features : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e')('S'|'s');

Internal : ('I'|'i')('N'|'n')('T'|'t')('E'|'e')('R'|'r')('N'|'n')('A'|'a')('L'|'l');

Property : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y');

Provides : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s');

Requires : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s');

Applies : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

Binding : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Extends : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('D'|'d')('S'|'s');

Feature : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e');

Inherit : ('I'|'i')('N'|'n')('H'|'h')('E'|'e')('R'|'r')('I'|'i')('T'|'t');

Initial : ('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('A'|'a')('L'|'l');

Inverse : ('I'|'i')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('S'|'s')('E'|'e');

Package : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e');

Private : ('P'|'p')('R'|'r')('I'|'i')('V'|'v')('A'|'a')('T'|'t')('E'|'e');

Process : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Refined : ('R'|'r')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e')('D'|'d');

Renames : ('R'|'r')('E'|'e')('N'|'n')('A'|'a')('M'|'m')('E'|'e')('S'|'s');

Virtual : ('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l');

Access : ('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Device : ('D'|'d')('E'|'e')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

Memory : ('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

Public : ('P'|'p')('U'|'u')('B'|'b')('L'|'l')('I'|'i')('C'|'c');

Record : ('R'|'r')('E'|'e')('C'|'c')('O'|'o')('R'|'r')('D'|'d');

Source : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e');

KW_System : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

Thread : ('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d');

Annex : ('A'|'a')('N'|'n')('N'|'n')('E'|'e')('X'|'x');

Calls : ('C'|'c')('A'|'a')('L'|'l')('L'|'l')('S'|'s');

Delta : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

Event : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Flows : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s');

Group : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Modes : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

Range : ('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

Units : ('U'|'u')('N'|'n')('I'|'i')('T'|'t')('S'|'s');

Data : ('D'|'d')('A'|'a')('T'|'t')('A'|'a');

Flow : ('F'|'f')('L'|'l')('O'|'o')('W'|'w');

List : ('L'|'l')('I'|'i')('S'|'s')('T'|'t');

Mode : ('M'|'m')('O'|'o')('D'|'d')('E'|'e');

None : ('N'|'n')('O'|'o')('N'|'n')('E'|'e');

Path : ('P'|'p')('A'|'a')('T'|'t')('H'|'h');

Port : ('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Self : ('S'|'s')('E'|'e')('L'|'l')('F'|'f');

Sink : ('S'|'s')('I'|'i')('N'|'n')('K'|'k');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

Type : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

With : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');

PlusSignEqualsSignGreaterThanSign : '+''=''>';

LessThanSignHyphenMinusGreaterThanSign : '<''-''>';

RightSquareBracketHyphenMinusGreaterThanSign : ']''-''>';

All : ('A'|'a')('L'|'l')('L'|'l');

Bus : ('B'|'b')('U'|'u')('S'|'s');

End : ('E'|'e')('N'|'n')('D'|'d');

Out : ('O'|'o')('U'|'u')('T'|'t');

Set : ('S'|'s')('E'|'e')('T'|'t');

HyphenMinusGreaterThanSign : '-''>';

HyphenMinusLeftSquareBracket : '-''[';

FullStopFullStop : '.''.';

ColonColon : ':'':';

EqualsSignGreaterThanSign : '=''>';

In : ('I'|'i')('N'|'n');

Is : ('I'|'i')('S'|'s');

Of : ('O'|'o')('F'|'f');

To : ('T'|'t')('O'|'o');

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Colon : ':';

Semicolon : ';';

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

RULE_ANNEXTEXT : '{**' ( options {greedy=false;} : . )*'**}';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
