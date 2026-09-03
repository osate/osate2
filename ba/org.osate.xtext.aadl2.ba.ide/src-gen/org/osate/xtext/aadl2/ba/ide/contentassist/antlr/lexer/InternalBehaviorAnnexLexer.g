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
lexer grammar InternalBehaviorAnnexLexer;

@header {
package org.osate.xtext.aadl2.ba.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

Computation : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Transitions : ('T'|'t')('R'|'r')('A'|'a')('N'|'n')('S'|'s')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Classifier : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

Otherwise : ('O'|'o')('T'|'t')('H'|'h')('E'|'e')('R'|'r')('W'|'w')('I'|'i')('S'|'s')('E'|'e');

Reference : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Variables : ('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('B'|'b')('L'|'l')('E'|'e')('S'|'s');

Complete : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('L'|'l')('E'|'e')('T'|'t')('E'|'e');

Constant : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

Dispatch : ('D'|'d')('I'|'i')('S'|'s')('P'|'p')('A'|'a')('T'|'t')('C'|'c')('H'|'h');

Applies : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

Binding : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Initial : ('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('A'|'a')('L'|'l');

Timeout : ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('O'|'o')('U'|'u')('T'|'t');

Forall : ('F'|'f')('O'|'o')('R'|'r')('A'|'a')('L'|'l')('L'|'l');

Frozen : ('F'|'f')('R'|'r')('O'|'o')('Z'|'z')('E'|'e')('N'|'n');

States : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e')('S'|'s');

Count : ('C'|'c')('O'|'o')('U'|'u')('N'|'n')('T'|'t');

Delta : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

Elsif : ('E'|'e')('L'|'l')('S'|'s')('I'|'i')('F'|'f');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Final : ('F'|'f')('I'|'i')('N'|'n')('A'|'a')('L'|'l');

Fresh : ('F'|'f')('R'|'r')('E'|'e')('S'|'s')('H'|'h');

Modes : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

State : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e');

Until : ('U'|'u')('N'|'n')('T'|'t')('I'|'i')('L'|'l');

While : ('W'|'w')('H'|'h')('I'|'i')('L'|'l')('E'|'e');

Else : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Stop : ('S'|'s')('T'|'t')('O'|'o')('P'|'p');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

PlusSignEqualsSignGreaterThanSign : '+''=''>';

RightSquareBracketHyphenMinusGreaterThanSign : ']''-''>';

Abs : ('A'|'a')('B'|'b')('S'|'s');

And : ('A'|'a')('N'|'n')('D'|'d');

Any : ('A'|'a')('N'|'n')('Y'|'y');

End : ('E'|'e')('N'|'n')('D'|'d');

For : ('F'|'f')('O'|'o')('R'|'r');

Mod : ('M'|'m')('O'|'o')('D'|'d');

Not : ('N'|'n')('O'|'o')('T'|'t');

Rem : ('R'|'r')('E'|'e')('M'|'m');

Xor : ('X'|'x')('O'|'o')('R'|'r');

ExclamationMarkLessThanSign : '!''<';

ExclamationMarkEqualsSign : '!''=';

ExclamationMarkGreaterThanSign : '!''>';

AsteriskAsterisk : '*''*';

HyphenMinusLeftSquareBracket : '-''[';

FullStopFullStop : '.''.';

ColonColon : ':'':';

ColonEqualsSign : ':''=';

LessThanSignEqualsSign : '<''=';

EqualsSignGreaterThanSign : '=''>';

GreaterThanSignEqualsSign : '>''=';

GreaterThanSignGreaterThanSign : '>''>';

Do : ('D'|'d')('O'|'o');

If : ('I'|'i')('F'|'f');

In : ('I'|'i')('N'|'n');

On : ('O'|'o')('N'|'n');

Or : ('O'|'o')('R'|'r');

To : ('T'|'t')('O'|'o');

ExclamationMark : '!';

NumberSign : '#';

Ampersand : '&';

Apostrophe : '\'';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

Semicolon : ';';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

QuestionMark : '?';

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : '"' ('""'|~('"'))* '"';

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
