
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
package org.osate.reqspec.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




DiagnosticId : 'diagnosticId';

Requirements : 'requirements';

Connections : 'connections';

Description : 'description';

Development : 'development';

Requirement : 'requirement';

Stakeholder : 'stakeholder';

Uncertainty : 'uncertainty';

Decomposes : 'decomposes';

Precedence : 'precedence';

Subprogram : 'subprogram';

Volatility : 'volatility';

Conflicts : 'conflicts';

Constants : 'constants';

Exception : 'exception';

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

Include : 'include';

Integer : 'integer';

Process : 'process';

Refines : 'refines';

Section : 'section';

Success : 'success';

Virtual : 'virtual';

Warning : 'warning';

Device : 'device';

Downto : 'downto';

Global : 'global';

Impact : 'impact';

Issues : 'issues';

Memory : 'memory';

String : 'string';

KW_System : 'system';

Target : 'target';

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

Fail : 'fail';

Goal : 'goal';

Info : 'info';

Mode : 'mode';

Real : 'real';

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

Tbd : 'tbd';

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



