
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
lexer grammar InternalErrorModelLexer;


@header {
package org.osate.xtext.aadl2.errormodel.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




Transformations : ('T'|'t')('R'|'r')('A'|'a')('N'|'n')('S'|'s')('F'|'f')('O'|'o')('R'|'r')('M'|'m')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Propagations : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('A'|'a')('G'|'g')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Equivalence : ('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('V'|'v')('A'|'a')('L'|'l')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Propagation : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('A'|'a')('G'|'g')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Transitions : ('T'|'t')('R'|'r')('A'|'a')('N'|'n')('S'|'s')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Classifier : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

Connection : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Detections : ('D'|'d')('E'|'e')('T'|'t')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Properties : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('I'|'i')('E'|'e')('S'|'s');

Component : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t');

Composite : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('S'|'s')('I'|'i')('T'|'t')('E'|'e');

Processor : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Reference : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Subclause : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('L'|'l')('A'|'a')('U'|'u')('S'|'s')('E'|'e');

Behavior : ('B'|'b')('E'|'e')('H'|'h')('A'|'a')('V'|'v')('I'|'i')('O'|'o')('R'|'r');

Bindings : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g')('S'|'s');

Constant : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

Mappings : ('M'|'m')('A'|'a')('P'|'p')('P'|'p')('I'|'i')('N'|'n')('G'|'g')('S'|'s');

Applies : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

Binding : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Extends : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('D'|'d')('S'|'s');

Initial : ('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('A'|'a')('L'|'l');

Library : ('L'|'l')('I'|'i')('B'|'b')('R'|'r')('A'|'a')('R'|'r')('Y'|'y');

Noerror : ('N'|'n')('O'|'o')('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Package : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e');

Recover : ('R'|'r')('E'|'e')('C'|'c')('O'|'o')('V'|'v')('E'|'e')('R'|'r');

Renames : ('R'|'r')('E'|'e')('N'|'n')('A'|'a')('M'|'m')('E'|'e')('S'|'s');

Access : ('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Events : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

Memory : ('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

Orless : ('O'|'o')('R'|'r')('L'|'l')('E'|'e')('S'|'s')('S'|'s');

Ormore : ('O'|'o')('R'|'r')('M'|'m')('O'|'o')('R'|'r')('E'|'e');

Others : ('O'|'o')('T'|'t')('H'|'h')('E'|'e')('R'|'r')('S'|'s');

Public : ('P'|'p')('U'|'u')('B'|'b')('L'|'l')('I'|'i')('C'|'c');

Repair : ('R'|'r')('E'|'e')('P'|'p')('A'|'a')('I'|'i')('R'|'r');

Source : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e');

States : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e')('S'|'s');

Annex : ('A'|'a')('N'|'n')('N'|'n')('E'|'e')('X'|'x');

Delta : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

Error : ('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Event : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Flows : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s');

Modes : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

Paths : ('P'|'p')('A'|'a')('T'|'t')('H'|'h')('S'|'s');

Point : ('P'|'p')('O'|'o')('I'|'i')('N'|'n')('T'|'t');

State : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e');

Types : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('S'|'s');

Mode : ('M'|'m')('O'|'o')('D'|'d')('E'|'e');

Path : ('P'|'p')('A'|'a')('T'|'t')('H'|'h');

Same : ('S'|'s')('A'|'a')('M'|'m')('E'|'e');

Sink : ('S'|'s')('I'|'i')('N'|'n')('K'|'k');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

Type : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

When : ('W'|'w')('H'|'h')('E'|'e')('N'|'n');

With : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');

AsteriskAsteriskRightCurlyBracket : '*''*''}';

PlusSignEqualsSignGreaterThanSign : '+''=''>';

RightSquareBracketHyphenMinusGreaterThanSign : ']''-''>';

All : ('A'|'a')('L'|'l')('L'|'l');

And : ('A'|'a')('N'|'n')('D'|'d');

End : ('E'|'e')('N'|'n')('D'|'d');

Not : ('N'|'n')('O'|'o')('T'|'t');

Out : ('O'|'o')('U'|'u')('T'|'t');

Set : ('S'|'s')('E'|'e')('T'|'t');

Use : ('U'|'u')('S'|'s')('E'|'e');

LeftCurlyBracketAsteriskAsterisk : '{''*''*';

HyphenMinusGreaterThanSign : '-''>';

HyphenMinusLeftSquareBracket : '-''[';

FullStopFullStop : '.''.';

ColonColon : ':'':';

EqualsSignGreaterThanSign : '=''>';

If : ('I'|'i')('F'|'f');

In : ('I'|'i')('N'|'n');

Or : ('O'|'o')('R'|'r');

To : ('T'|'t')('O'|'o');

ExclamationMark : '!';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Colon : ':';

Semicolon : ';';

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

CircumflexAccent : '^';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';



RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_INTEGER_LIT : ('0'..'9')+;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;



