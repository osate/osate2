
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
lexer grammar InternalReqSpecLexer;


@header {
package org.osate.reqspec.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




Timecriticality : 'timecriticality';

Scheduleimpact : 'scheduleimpact';

Maturityindex : 'maturityindex';

Requirements : 'requirements';

Description : 'description';

Development : 'development';

Familiarity : 'familiarity';

Requirement : 'requirement';

Stakeholder : 'stakeholder';

Uncertainty : 'uncertainty';

Costimpact : 'costimpact';

Decomposes : 'decomposes';

Subprogram : 'subprogram';

Volatility : 'volatility';

Attribute : 'attribute';

Conflicts : 'conflicts';

Constants : 'constants';

Mitigates : 'mitigates';

Predicate : 'predicate';

Processor : 'processor';

Rationale : 'rationale';

Riskindex : 'riskindex';

Selection : 'selection';

Abstract : 'abstract';

Document : 'document';

Informal : 'informal';

Compute : 'compute';

Dropped : 'dropped';

Evolves : 'evolves';

Process : 'process';

Quality : 'quality';

Refines : 'refines';

Section : 'section';

Virtual : 'virtual';

Device : 'device';

Global : 'global';

Issues : 'issues';

Memory : 'memory';

KW_System : 'system';

Thread : 'thread';

Delta : 'delta';

False : 'false';

Goals : 'goals';

Group : 'group';

Value : 'value';

Data : 'data';

Goal : 'goal';

Null : 'null';

This : 'this';

True : 'true';

Type : 'type';

User : 'user';

With : 'with';

FullStopFullStopLessThanSign : '..<';

All : 'all';

Bus : 'bus';

For : 'for';

Img : 'img';

See : 'see';

Use : 'use';

Val : 'val';

ExclamationMarkEqualsSign : '!=';

AmpersandAmpersand : '&&';

AsteriskAsterisk : '**';

HyphenMinusGreaterThanSign : '->';

FullStopFullStop : '..';

ColonColon : '::';

LessThanSignGreaterThanSign : '<>';

EqualsSignEqualsSign : '==';

EqualsSignGreaterThanSign : '=>';

GreaterThanSignEqualsSign : '>=';

QuestionMarkColon : '?:';

VerticalLineVerticalLine : '||';

ExclamationMark : '!';

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

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';



fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



