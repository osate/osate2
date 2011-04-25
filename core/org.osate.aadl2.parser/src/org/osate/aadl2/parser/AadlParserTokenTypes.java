// $ANTLR : "aadl.g" -> "AadlParser.java"$
 
/** 
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 */
package org.osate.aadl2.parser; 

public interface AadlParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int PACKAGE = 4;
	int END = 5;
	int SEMI = 6;
	int PUBLIC = 7;
	int PRIVATE = 8;
	int IDENT = 9;
	int DOUBLECOLON = 10;
	int NONE = 11;
	int THREAD = 12;
	int EXTENDS = 13;
	int GROUP = 14;
	int PROCESS = 15;
	int SYSTEM = 16;
	int SUBPROGRAM = 17;
	int DATA = 18;
	int PROCESSOR = 19;
	int MEMORY = 20;
	int BUS = 21;
	int DEVICE = 22;
	int DOT = 23;
	int IMPL = 24;
	int FEATURES = 25;
	int COLON = 26;
	int REFINED = 27;
	int TO = 28;
	int PROVIDES = 29;
	int REQUIRES = 30;
	int REFINES = 31;
	int TYPE = 32;
	int SUBCOMPONENTS = 33;
	int ANNEX = 34;
	int ANNEX_TEXT = 35;
	int PROPERTY = 36;
	int SET = 37;
	int IS = 38;
	int BOOLEAN = 39;
	int STRING = 40;
	int ENUMERATION = 41;
	int LPAREN = 42;
	int COMMA = 43;
	int RPAREN = 44;
	int UNITS = 45;
	int ASSIGN = 46;
	int STAR = 47;
	int REAL = 48;
	int INTEGER = 49;
	int DOTDOT = 50;
	int PLUS = 51;
	int MINUS = 52;
	int NUMERIC_LIT = 53;
	int RANGE = 54;
	int OF = 55;
	int CLASSIFIER = 56;
	int REFERENCE = 57;
	int CONNECTIONS = 58;
	int SERVER = 59;
	int ACCESS = 60;
	int INHERIT = 61;
	int APPLIES = 62;
	int ALL = 63;
	int MODE = 64;
	int PORT = 65;
	int EVENT = 66;
	int FLOW = 67;
	int PARAMETER = 68;
	int LIST = 69;
	int CONSTANT = 70;
	int DELTA = 71;
	int PROPERTIES = 72;
	int LCURLY = 73;
	int RCURLY = 74;
	int ASSIGNPLUS = 75;
	int VALUE = 76;
	int IN = 77;
	int BINDING = 78;
	int OR = 79;
	int AND = 80;
	int TRUE = 81;
	int FALSE = 82;
	int NOT = 83;
	int STRING_LITERAL = 84;
	int CALLS = 85;
	int MODES = 86;
	int INITIAL = 87;
	int LTRANS = 88;
	int RTRANS = 89;
	int ARROW = 90;
	int OUT = 91;
	int INVERSE = 92;
	int DARROW = 93;
	int FLOWS = 94;
	int SOURCE = 95;
	int SINK = 96;
	int PATH = 97;
	int AADLSPEC = 98;
	int TRANSITIONS = 99;
	int HASH = 100;
	int DIGIT = 101;
	int EXPONENT = 102;
	int INT_EXPONENT = 103;
	int EXTENDED_DIGIT = 104;
	int BASED_INTEGER = 105;
	int BASE = 106;
	int ESC = 107;
	int HEX_DIGIT = 108;
	int WS = 109;
	int SL_COMMENT = 110;
}
