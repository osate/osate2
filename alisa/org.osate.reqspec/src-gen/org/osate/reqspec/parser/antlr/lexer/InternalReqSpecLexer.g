
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
lexer grammar InternalReqSpecLexer;


@header {
package org.osate.reqspec.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




Requirements : 'requirements';

Description : 'description';

Development : 'development';

Requirement : 'requirement';

Stakeholder : 'stakeholder';

Uncertainty : 'uncertainty';

Connection : 'connection';

Decomposes : 'decomposes';

Precedence : 'precedence';

Subprogram : 'subprogram';

Volatility : 'volatility';

Component : 'component';

Conflicts : 'conflicts';

Constants : 'constants';

Mitigates : 'mitigates';

Predicate : 'predicate';

Processor : 'processor';

Rationale : 'rationale';

Abstract : 'abstract';

Category : 'category';

Document : 'document';

Informal : 'informal';

Inherits : 'inherits';

Boolean : 'boolean';

Compute : 'compute';

Dropped : 'dropped';

Element : 'element';

Evolves : 'evolves';

Feature : 'feature';

Include : 'include';

Integer : 'integer';

Process : 'process';

Refines : 'refines';

Section : 'section';

Virtual : 'virtual';

Device : 'device';

Downto : 'downto';

Global : 'global';

Impact : 'impact';

Issues : 'issues';

Memory : 'memory';

String : 'string';

KW_System : 'system';

Thread : 'thread';

Typeof : 'typeof';

Delta : 'delta';

Endif : 'endif';

Error : 'error';

False : 'false';

Goals : 'goals';

Group : 'group';

Model : 'model';

State : 'state';

Units : 'units';

Value : 'value';

Data : 'data';

Else : 'else';

Flow : 'flow';

Goal : 'goal';

Mode : 'mode';

Real : 'real';

Root : 'root';

Self : 'self';

Then : 'then';

This : 'this';

True : 'true';

Upto : 'upto';

When : 'when';

With : 'with';

And : 'and';

Bus : 'bus';

Div : 'div';

For : 'for';

Img : 'img';

Mod : 'mod';

Not : 'not';

See : 'see';

Use : 'use';

Val : 'val';

ExclamationMarkEqualsSign : '!=';

AmpersandAmpersand : '&&';

FullStopFullStop : '..';

ColonColon : '::';

LessThanSignEqualsSign : '<=';

EqualsSignEqualsSign : '==';

GreaterThanSignLessThanSign : '><';

GreaterThanSignEqualsSign : '>=';

As : 'as';

If : 'if';

In : 'in';

Or : 'or';

VerticalLineVerticalLine : '||';

NumberSign : '#';

PercentSign : '%';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

LeftSquareBracket : '[';

RightSquareBracket : ']';



fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



