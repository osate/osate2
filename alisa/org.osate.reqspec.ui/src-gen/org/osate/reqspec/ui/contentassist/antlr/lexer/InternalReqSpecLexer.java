package org.osate.reqspec.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
@SuppressWarnings("all")
public class InternalReqSpecLexer extends Lexer {
    public static final int Val=82;
    public static final int Or=94;
    public static final int Memory=44;
    public static final int KW_System=46;
    public static final int Decomposes=11;
    public static final int String=45;
    public static final int False=52;
    public static final int Document=24;
    public static final int Feature=32;
    public static final int LessThanSign=107;
    public static final int Goal=62;
    public static final int LeftParenthesis=98;
    public static final int Development=6;
    public static final int Then=67;
    public static final int Boolean=27;
    public static final int GreaterThanSign=109;
    public static final int Root=65;
    public static final int RULE_ID=118;
    public static final int RULE_DIGIT=112;
    public static final int GreaterThanSignEqualsSign=90;
    public static final int ColonColon=86;
    public static final int Requirement=7;
    public static final int EqualsSignEqualsSign=88;
    public static final int See=80;
    public static final int PlusSign=101;
    public static final int RULE_INT=119;
    public static final int RULE_ML_COMMENT=121;
    public static final int LeftSquareBracket=110;
    public static final int If=92;
    public static final int Mitigates=18;
    public static final int Group=54;
    public static final int Description=5;
    public static final int Processor=20;
    public static final int In=93;
    public static final int VerticalLineVerticalLine=95;
    public static final int RULE_REAL_LIT=115;
    public static final int Self=66;
    public static final int GreaterThanSignLessThanSign=89;
    public static final int Comma=102;
    public static final int As=91;
    public static final int HyphenMinus=103;
    public static final int LessThanSignEqualsSign=87;
    public static final int Solidus=105;
    public static final int Upto=70;
    public static final int Refines=36;
    public static final int Bus=74;
    public static final int FullStop=104;
    public static final int Abstract=22;
    public static final int Use=81;
    public static final int Connection=10;
    public static final int Constants=17;
    public static final int Conflicts=16;
    public static final int Section=37;
    public static final int Thread=47;
    public static final int Flow=61;
    public static final int Div=75;
    public static final int RULE_EXPONENT=113;
    public static final int When=71;
    public static final int Delta=49;
    public static final int Model=55;
    public static final int Else=60;
    public static final int RULE_EXTENDED_DIGIT=116;
    public static final int ExclamationMarkEqualsSign=83;
    public static final int Precedence=12;
    public static final int Typeof=48;
    public static final int Include=33;
    public static final int True=69;
    public static final int Process=35;
    public static final int Requirements=4;
    public static final int Global=41;
    public static final int Predicate=19;
    public static final int RULE_INT_EXPONENT=114;
    public static final int PercentSign=97;
    public static final int Stakeholder=8;
    public static final int FullStopFullStop=85;
    public static final int Real=64;
    public static final int This=68;
    public static final int RULE_BASED_INTEGER=117;
    public static final int RightSquareBracket=111;
    public static final int Dropped=29;
    public static final int Impact=42;
    public static final int Img=77;
    public static final int Device=39;
    public static final int Inherits=26;
    public static final int For=76;
    public static final int RightParenthesis=99;
    public static final int Units=57;
    public static final int Not=79;
    public static final int State=56;
    public static final int And=73;
    public static final int NumberSign=96;
    public static final int Value=58;
    public static final int Subprogram=13;
    public static final int Goals=53;
    public static final int Uncertainty=9;
    public static final int Category=23;
    public static final int Volatility=14;
    public static final int Issues=43;
    public static final int Element=30;
    public static final int RULE_STRING=120;
    public static final int Evolves=31;
    public static final int With=72;
    public static final int RULE_SL_COMMENT=122;
    public static final int EqualsSign=108;
    public static final int AmpersandAmpersand=84;
    public static final int Rationale=21;
    public static final int Colon=106;
    public static final int Component=15;
    public static final int EOF=-1;
    public static final int Asterisk=100;
    public static final int Downto=40;
    public static final int Mod=78;
    public static final int RULE_WS=123;
    public static final int Endif=50;
    public static final int Mode=63;
    public static final int Error=51;
    public static final int Virtual=38;
    public static final int Data=59;
    public static final int RULE_ANY_OTHER=124;
    public static final int Integer=34;
    public static final int Informal=25;
    public static final int Compute=28;

    // delegates
    // delegators

    public InternalReqSpecLexer() {;} 
    public InternalReqSpecLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalReqSpecLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalReqSpecLexer.g"; }

    // $ANTLR start "Requirements"
    public final void mRequirements() throws RecognitionException {
        try {
            int _type = Requirements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:39:14: ( 'requirements' )
            // InternalReqSpecLexer.g:39:16: 'requirements'
            {
            match("requirements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Requirements"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:41:13: ( 'description' )
            // InternalReqSpecLexer.g:41:15: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Description"

    // $ANTLR start "Development"
    public final void mDevelopment() throws RecognitionException {
        try {
            int _type = Development;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:43:13: ( 'development' )
            // InternalReqSpecLexer.g:43:15: 'development'
            {
            match("development"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Development"

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:45:13: ( 'requirement' )
            // InternalReqSpecLexer.g:45:15: 'requirement'
            {
            match("requirement"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Requirement"

    // $ANTLR start "Stakeholder"
    public final void mStakeholder() throws RecognitionException {
        try {
            int _type = Stakeholder;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:47:13: ( 'stakeholder' )
            // InternalReqSpecLexer.g:47:15: 'stakeholder'
            {
            match("stakeholder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Stakeholder"

    // $ANTLR start "Uncertainty"
    public final void mUncertainty() throws RecognitionException {
        try {
            int _type = Uncertainty;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:49:13: ( 'uncertainty' )
            // InternalReqSpecLexer.g:49:15: 'uncertainty'
            {
            match("uncertainty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uncertainty"

    // $ANTLR start "Connection"
    public final void mConnection() throws RecognitionException {
        try {
            int _type = Connection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:51:12: ( 'connection' )
            // InternalReqSpecLexer.g:51:14: 'connection'
            {
            match("connection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Connection"

    // $ANTLR start "Decomposes"
    public final void mDecomposes() throws RecognitionException {
        try {
            int _type = Decomposes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:53:12: ( 'decomposes' )
            // InternalReqSpecLexer.g:53:14: 'decomposes'
            {
            match("decomposes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Decomposes"

    // $ANTLR start "Precedence"
    public final void mPrecedence() throws RecognitionException {
        try {
            int _type = Precedence;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:55:12: ( 'precedence' )
            // InternalReqSpecLexer.g:55:14: 'precedence'
            {
            match("precedence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Precedence"

    // $ANTLR start "Subprogram"
    public final void mSubprogram() throws RecognitionException {
        try {
            int _type = Subprogram;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:57:12: ( 'subprogram' )
            // InternalReqSpecLexer.g:57:14: 'subprogram'
            {
            match("subprogram"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Subprogram"

    // $ANTLR start "Volatility"
    public final void mVolatility() throws RecognitionException {
        try {
            int _type = Volatility;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:59:12: ( 'volatility' )
            // InternalReqSpecLexer.g:59:14: 'volatility'
            {
            match("volatility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Volatility"

    // $ANTLR start "Component"
    public final void mComponent() throws RecognitionException {
        try {
            int _type = Component;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:61:11: ( 'component' )
            // InternalReqSpecLexer.g:61:13: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Component"

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:63:11: ( 'conflicts' )
            // InternalReqSpecLexer.g:63:13: 'conflicts'
            {
            match("conflicts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Conflicts"

    // $ANTLR start "Constants"
    public final void mConstants() throws RecognitionException {
        try {
            int _type = Constants;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:65:11: ( 'constants' )
            // InternalReqSpecLexer.g:65:13: 'constants'
            {
            match("constants"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Constants"

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:67:11: ( 'mitigates' )
            // InternalReqSpecLexer.g:67:13: 'mitigates'
            {
            match("mitigates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mitigates"

    // $ANTLR start "Predicate"
    public final void mPredicate() throws RecognitionException {
        try {
            int _type = Predicate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:69:11: ( 'predicate' )
            // InternalReqSpecLexer.g:69:13: 'predicate'
            {
            match("predicate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Predicate"

    // $ANTLR start "Processor"
    public final void mProcessor() throws RecognitionException {
        try {
            int _type = Processor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:71:11: ( 'processor' )
            // InternalReqSpecLexer.g:71:13: 'processor'
            {
            match("processor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Processor"

    // $ANTLR start "Rationale"
    public final void mRationale() throws RecognitionException {
        try {
            int _type = Rationale;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:73:11: ( 'rationale' )
            // InternalReqSpecLexer.g:73:13: 'rationale'
            {
            match("rationale"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rationale"

    // $ANTLR start "Abstract"
    public final void mAbstract() throws RecognitionException {
        try {
            int _type = Abstract;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:75:10: ( 'abstract' )
            // InternalReqSpecLexer.g:75:12: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Abstract"

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:77:10: ( 'category' )
            // InternalReqSpecLexer.g:77:12: 'category'
            {
            match("category"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Category"

    // $ANTLR start "Document"
    public final void mDocument() throws RecognitionException {
        try {
            int _type = Document;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:79:10: ( 'document' )
            // InternalReqSpecLexer.g:79:12: 'document'
            {
            match("document"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Document"

    // $ANTLR start "Informal"
    public final void mInformal() throws RecognitionException {
        try {
            int _type = Informal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:81:10: ( 'informal' )
            // InternalReqSpecLexer.g:81:12: 'informal'
            {
            match("informal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Informal"

    // $ANTLR start "Inherits"
    public final void mInherits() throws RecognitionException {
        try {
            int _type = Inherits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:83:10: ( 'inherits' )
            // InternalReqSpecLexer.g:83:12: 'inherits'
            {
            match("inherits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Inherits"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:85:9: ( 'boolean' )
            // InternalReqSpecLexer.g:85:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Compute"
    public final void mCompute() throws RecognitionException {
        try {
            int _type = Compute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:87:9: ( 'compute' )
            // InternalReqSpecLexer.g:87:11: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Compute"

    // $ANTLR start "Dropped"
    public final void mDropped() throws RecognitionException {
        try {
            int _type = Dropped;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:89:9: ( 'dropped' )
            // InternalReqSpecLexer.g:89:11: 'dropped'
            {
            match("dropped"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dropped"

    // $ANTLR start "Element"
    public final void mElement() throws RecognitionException {
        try {
            int _type = Element;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:91:9: ( 'element' )
            // InternalReqSpecLexer.g:91:11: 'element'
            {
            match("element"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Element"

    // $ANTLR start "Evolves"
    public final void mEvolves() throws RecognitionException {
        try {
            int _type = Evolves;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:93:9: ( 'evolves' )
            // InternalReqSpecLexer.g:93:11: 'evolves'
            {
            match("evolves"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Evolves"

    // $ANTLR start "Feature"
    public final void mFeature() throws RecognitionException {
        try {
            int _type = Feature;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:95:9: ( 'feature' )
            // InternalReqSpecLexer.g:95:11: 'feature'
            {
            match("feature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Feature"

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:97:9: ( 'include' )
            // InternalReqSpecLexer.g:97:11: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Include"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:99:9: ( 'integer' )
            // InternalReqSpecLexer.g:99:11: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Process"
    public final void mProcess() throws RecognitionException {
        try {
            int _type = Process;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:101:9: ( 'process' )
            // InternalReqSpecLexer.g:101:11: 'process'
            {
            match("process"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Process"

    // $ANTLR start "Refines"
    public final void mRefines() throws RecognitionException {
        try {
            int _type = Refines;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:103:9: ( 'refines' )
            // InternalReqSpecLexer.g:103:11: 'refines'
            {
            match("refines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Refines"

    // $ANTLR start "Section"
    public final void mSection() throws RecognitionException {
        try {
            int _type = Section;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:105:9: ( 'section' )
            // InternalReqSpecLexer.g:105:11: 'section'
            {
            match("section"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Section"

    // $ANTLR start "Virtual"
    public final void mVirtual() throws RecognitionException {
        try {
            int _type = Virtual;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:107:9: ( 'virtual' )
            // InternalReqSpecLexer.g:107:11: 'virtual'
            {
            match("virtual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Virtual"

    // $ANTLR start "Device"
    public final void mDevice() throws RecognitionException {
        try {
            int _type = Device;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:109:8: ( 'device' )
            // InternalReqSpecLexer.g:109:10: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Device"

    // $ANTLR start "Downto"
    public final void mDownto() throws RecognitionException {
        try {
            int _type = Downto;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:111:8: ( 'downto' )
            // InternalReqSpecLexer.g:111:10: 'downto'
            {
            match("downto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Downto"

    // $ANTLR start "Global"
    public final void mGlobal() throws RecognitionException {
        try {
            int _type = Global;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:113:8: ( 'global' )
            // InternalReqSpecLexer.g:113:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Global"

    // $ANTLR start "Impact"
    public final void mImpact() throws RecognitionException {
        try {
            int _type = Impact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:115:8: ( 'impact' )
            // InternalReqSpecLexer.g:115:10: 'impact'
            {
            match("impact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Impact"

    // $ANTLR start "Issues"
    public final void mIssues() throws RecognitionException {
        try {
            int _type = Issues;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:117:8: ( 'issues' )
            // InternalReqSpecLexer.g:117:10: 'issues'
            {
            match("issues"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Issues"

    // $ANTLR start "Memory"
    public final void mMemory() throws RecognitionException {
        try {
            int _type = Memory;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:119:8: ( 'memory' )
            // InternalReqSpecLexer.g:119:10: 'memory'
            {
            match("memory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Memory"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:121:8: ( 'string' )
            // InternalReqSpecLexer.g:121:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "KW_System"
    public final void mKW_System() throws RecognitionException {
        try {
            int _type = KW_System;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:123:11: ( 'system' )
            // InternalReqSpecLexer.g:123:13: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_System"

    // $ANTLR start "Thread"
    public final void mThread() throws RecognitionException {
        try {
            int _type = Thread;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:125:8: ( 'thread' )
            // InternalReqSpecLexer.g:125:10: 'thread'
            {
            match("thread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Thread"

    // $ANTLR start "Typeof"
    public final void mTypeof() throws RecognitionException {
        try {
            int _type = Typeof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:127:8: ( 'typeof' )
            // InternalReqSpecLexer.g:127:10: 'typeof'
            {
            match("typeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Typeof"

    // $ANTLR start "Delta"
    public final void mDelta() throws RecognitionException {
        try {
            int _type = Delta;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:129:7: ( 'delta' )
            // InternalReqSpecLexer.g:129:9: 'delta'
            {
            match("delta"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Delta"

    // $ANTLR start "Endif"
    public final void mEndif() throws RecognitionException {
        try {
            int _type = Endif;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:131:7: ( 'endif' )
            // InternalReqSpecLexer.g:131:9: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Endif"

    // $ANTLR start "Error"
    public final void mError() throws RecognitionException {
        try {
            int _type = Error;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:133:7: ( 'error' )
            // InternalReqSpecLexer.g:133:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Error"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:135:7: ( 'false' )
            // InternalReqSpecLexer.g:135:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Goals"
    public final void mGoals() throws RecognitionException {
        try {
            int _type = Goals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:137:7: ( 'goals' )
            // InternalReqSpecLexer.g:137:9: 'goals'
            {
            match("goals"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goals"

    // $ANTLR start "Group"
    public final void mGroup() throws RecognitionException {
        try {
            int _type = Group;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:139:7: ( 'group' )
            // InternalReqSpecLexer.g:139:9: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Group"

    // $ANTLR start "Model"
    public final void mModel() throws RecognitionException {
        try {
            int _type = Model;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:141:7: ( 'model' )
            // InternalReqSpecLexer.g:141:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Model"

    // $ANTLR start "State"
    public final void mState() throws RecognitionException {
        try {
            int _type = State;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:143:7: ( 'state' )
            // InternalReqSpecLexer.g:143:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "State"

    // $ANTLR start "Units"
    public final void mUnits() throws RecognitionException {
        try {
            int _type = Units;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:145:7: ( 'units' )
            // InternalReqSpecLexer.g:145:9: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Units"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:147:7: ( 'value' )
            // InternalReqSpecLexer.g:147:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "Data"
    public final void mData() throws RecognitionException {
        try {
            int _type = Data;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:149:6: ( 'data' )
            // InternalReqSpecLexer.g:149:8: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Data"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:151:6: ( 'else' )
            // InternalReqSpecLexer.g:151:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Flow"
    public final void mFlow() throws RecognitionException {
        try {
            int _type = Flow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:153:6: ( 'flow' )
            // InternalReqSpecLexer.g:153:8: 'flow'
            {
            match("flow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Flow"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:155:6: ( 'goal' )
            // InternalReqSpecLexer.g:155:8: 'goal'
            {
            match("goal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goal"

    // $ANTLR start "Mode"
    public final void mMode() throws RecognitionException {
        try {
            int _type = Mode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:157:6: ( 'mode' )
            // InternalReqSpecLexer.g:157:8: 'mode'
            {
            match("mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mode"

    // $ANTLR start "Real"
    public final void mReal() throws RecognitionException {
        try {
            int _type = Real;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:159:6: ( 'real' )
            // InternalReqSpecLexer.g:159:8: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Real"

    // $ANTLR start "Root"
    public final void mRoot() throws RecognitionException {
        try {
            int _type = Root;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:161:6: ( 'root' )
            // InternalReqSpecLexer.g:161:8: 'root'
            {
            match("root"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Root"

    // $ANTLR start "Self"
    public final void mSelf() throws RecognitionException {
        try {
            int _type = Self;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:163:6: ( 'self' )
            // InternalReqSpecLexer.g:163:8: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Self"

    // $ANTLR start "Then"
    public final void mThen() throws RecognitionException {
        try {
            int _type = Then;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:165:6: ( 'then' )
            // InternalReqSpecLexer.g:165:8: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Then"

    // $ANTLR start "This"
    public final void mThis() throws RecognitionException {
        try {
            int _type = This;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:167:6: ( 'this' )
            // InternalReqSpecLexer.g:167:8: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "This"

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:169:6: ( 'true' )
            // InternalReqSpecLexer.g:169:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "Upto"
    public final void mUpto() throws RecognitionException {
        try {
            int _type = Upto;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:171:6: ( 'upto' )
            // InternalReqSpecLexer.g:171:8: 'upto'
            {
            match("upto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Upto"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:173:6: ( 'when' )
            // InternalReqSpecLexer.g:173:8: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "When"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:175:6: ( 'with' )
            // InternalReqSpecLexer.g:175:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "And"
    public final void mAnd() throws RecognitionException {
        try {
            int _type = And;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:177:5: ( 'and' )
            // InternalReqSpecLexer.g:177:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "And"

    // $ANTLR start "Bus"
    public final void mBus() throws RecognitionException {
        try {
            int _type = Bus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:179:5: ( 'bus' )
            // InternalReqSpecLexer.g:179:7: 'bus'
            {
            match("bus"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bus"

    // $ANTLR start "Div"
    public final void mDiv() throws RecognitionException {
        try {
            int _type = Div;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:181:5: ( 'div' )
            // InternalReqSpecLexer.g:181:7: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Div"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:183:5: ( 'for' )
            // InternalReqSpecLexer.g:183:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "Img"
    public final void mImg() throws RecognitionException {
        try {
            int _type = Img;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:185:5: ( 'img' )
            // InternalReqSpecLexer.g:185:7: 'img'
            {
            match("img"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Img"

    // $ANTLR start "Mod"
    public final void mMod() throws RecognitionException {
        try {
            int _type = Mod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:187:5: ( 'mod' )
            // InternalReqSpecLexer.g:187:7: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mod"

    // $ANTLR start "Not"
    public final void mNot() throws RecognitionException {
        try {
            int _type = Not;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:189:5: ( 'not' )
            // InternalReqSpecLexer.g:189:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Not"

    // $ANTLR start "See"
    public final void mSee() throws RecognitionException {
        try {
            int _type = See;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:191:5: ( 'see' )
            // InternalReqSpecLexer.g:191:7: 'see'
            {
            match("see"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "See"

    // $ANTLR start "Use"
    public final void mUse() throws RecognitionException {
        try {
            int _type = Use;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:193:5: ( 'use' )
            // InternalReqSpecLexer.g:193:7: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Use"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:195:5: ( 'val' )
            // InternalReqSpecLexer.g:195:7: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Val"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:197:27: ( '!=' )
            // InternalReqSpecLexer.g:197:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:199:20: ( '&&' )
            // InternalReqSpecLexer.g:199:22: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandAmpersand"

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:201:18: ( '..' )
            // InternalReqSpecLexer.g:201:20: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStop"

    // $ANTLR start "ColonColon"
    public final void mColonColon() throws RecognitionException {
        try {
            int _type = ColonColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:203:12: ( '::' )
            // InternalReqSpecLexer.g:203:14: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonColon"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:205:24: ( '<=' )
            // InternalReqSpecLexer.g:205:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:207:22: ( '==' )
            // InternalReqSpecLexer.g:207:24: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "GreaterThanSignLessThanSign"
    public final void mGreaterThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:209:29: ( '><' )
            // InternalReqSpecLexer.g:209:31: '><'
            {
            match("><"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignLessThanSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:211:27: ( '>=' )
            // InternalReqSpecLexer.g:211:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:213:4: ( 'as' )
            // InternalReqSpecLexer.g:213:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:215:4: ( 'if' )
            // InternalReqSpecLexer.g:215:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:217:4: ( 'in' )
            // InternalReqSpecLexer.g:217:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "Or"
    public final void mOr() throws RecognitionException {
        try {
            int _type = Or;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:219:4: ( 'or' )
            // InternalReqSpecLexer.g:219:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Or"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:221:26: ( '||' )
            // InternalReqSpecLexer.g:221:28: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:223:12: ( '#' )
            // InternalReqSpecLexer.g:223:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "PercentSign"
    public final void mPercentSign() throws RecognitionException {
        try {
            int _type = PercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:225:13: ( '%' )
            // InternalReqSpecLexer.g:225:15: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:227:17: ( '(' )
            // InternalReqSpecLexer.g:227:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:229:18: ( ')' )
            // InternalReqSpecLexer.g:229:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:231:10: ( '*' )
            // InternalReqSpecLexer.g:231:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:233:10: ( '+' )
            // InternalReqSpecLexer.g:233:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:235:7: ( ',' )
            // InternalReqSpecLexer.g:235:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:237:13: ( '-' )
            // InternalReqSpecLexer.g:237:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:239:10: ( '.' )
            // InternalReqSpecLexer.g:239:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:241:9: ( '/' )
            // InternalReqSpecLexer.g:241:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:243:7: ( ':' )
            // InternalReqSpecLexer.g:243:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:245:14: ( '<' )
            // InternalReqSpecLexer.g:245:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:247:12: ( '=' )
            // InternalReqSpecLexer.g:247:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:249:17: ( '>' )
            // InternalReqSpecLexer.g:249:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:251:19: ( '[' )
            // InternalReqSpecLexer.g:251:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:253:20: ( ']' )
            // InternalReqSpecLexer.g:253:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalReqSpecLexer.g:257:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalReqSpecLexer.g:257:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReqSpecLexer.g:257:36: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReqSpecLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalReqSpecLexer.g:257:47: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalReqSpecLexer.g:257:47: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_INT_EXPONENT"
    public final void mRULE_INT_EXPONENT() throws RecognitionException {
        try {
            // InternalReqSpecLexer.g:259:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // InternalReqSpecLexer.g:259:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReqSpecLexer.g:259:40: ( '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalReqSpecLexer.g:259:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // InternalReqSpecLexer.g:259:45: ( RULE_DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReqSpecLexer.g:259:45: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT_EXPONENT"

    // $ANTLR start "RULE_REAL_LIT"
    public final void mRULE_REAL_LIT() throws RecognitionException {
        try {
            int _type = RULE_REAL_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:261:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // InternalReqSpecLexer.g:261:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // InternalReqSpecLexer.g:261:17: ( RULE_DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalReqSpecLexer.g:261:17: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalReqSpecLexer.g:261:29: ( '_' ( RULE_DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReqSpecLexer.g:261:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // InternalReqSpecLexer.g:261:34: ( RULE_DIGIT )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalReqSpecLexer.g:261:34: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('.'); 
            // InternalReqSpecLexer.g:261:52: ( RULE_DIGIT )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReqSpecLexer.g:261:52: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // InternalReqSpecLexer.g:261:64: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalReqSpecLexer.g:261:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // InternalReqSpecLexer.g:261:69: ( RULE_DIGIT )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalReqSpecLexer.g:261:69: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalReqSpecLexer.g:261:83: ( RULE_EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalReqSpecLexer.g:261:83: RULE_EXPONENT
                    {
                    mRULE_EXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL_LIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalReqSpecLexer.g:263:21: ( '0' .. '9' )
            // InternalReqSpecLexer.g:263:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_EXTENDED_DIGIT"
    public final void mRULE_EXTENDED_DIGIT() throws RecognitionException {
        try {
            // InternalReqSpecLexer.g:265:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalReqSpecLexer.g:265:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXTENDED_DIGIT"

    // $ANTLR start "RULE_BASED_INTEGER"
    public final void mRULE_BASED_INTEGER() throws RecognitionException {
        try {
            // InternalReqSpecLexer.g:267:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // InternalReqSpecLexer.g:267:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // InternalReqSpecLexer.g:267:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='F')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='f')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalReqSpecLexer.g:267:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // InternalReqSpecLexer.g:267:52: ( '_' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0=='_') ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalReqSpecLexer.g:267:52: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    mRULE_EXTENDED_DIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INTEGER"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:269:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReqSpecLexer.g:269:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReqSpecLexer.g:269:11: ( '^' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='^') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalReqSpecLexer.g:269:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReqSpecLexer.g:269:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:271:10: ( ( '0' .. '9' )+ )
            // InternalReqSpecLexer.g:271:12: ( '0' .. '9' )+
            {
            // InternalReqSpecLexer.g:271:12: ( '0' .. '9' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReqSpecLexer.g:271:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:273:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReqSpecLexer.g:273:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReqSpecLexer.g:273:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\"') ) {
                alt19=1;
            }
            else if ( (LA19_0=='\'') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReqSpecLexer.g:273:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReqSpecLexer.g:273:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop17:
                    do {
                        int alt17=3;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='\\') ) {
                            alt17=1;
                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                            alt17=2;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalReqSpecLexer.g:273:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReqSpecLexer.g:273:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalReqSpecLexer.g:273:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReqSpecLexer.g:273:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<='&')||(LA18_0>='(' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalReqSpecLexer.g:273:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReqSpecLexer.g:273:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:275:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReqSpecLexer.g:275:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReqSpecLexer.g:275:24: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='*') ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1=='/') ) {
                        alt20=2;
                    }
                    else if ( ((LA20_1>='\u0000' && LA20_1<='.')||(LA20_1>='0' && LA20_1<='\uFFFF')) ) {
                        alt20=1;
                    }


                }
                else if ( ((LA20_0>='\u0000' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalReqSpecLexer.g:275:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:277:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReqSpecLexer.g:277:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReqSpecLexer.g:277:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReqSpecLexer.g:277:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalReqSpecLexer.g:277:40: ( ( '\\r' )? '\\n' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalReqSpecLexer.g:277:41: ( '\\r' )? '\\n'
                    {
                    // InternalReqSpecLexer.g:277:41: ( '\\r' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='\r') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalReqSpecLexer.g:277:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:279:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReqSpecLexer.g:279:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReqSpecLexer.g:279:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReqSpecLexer.g:281:16: ( . )
            // InternalReqSpecLexer.g:281:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalReqSpecLexer.g:1:8: ( Requirements | Description | Development | Requirement | Stakeholder | Uncertainty | Connection | Decomposes | Precedence | Subprogram | Volatility | Component | Conflicts | Constants | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Inherits | Boolean | Compute | Dropped | Element | Evolves | Feature | Include | Integer | Process | Refines | Section | Virtual | Device | Downto | Global | Impact | Issues | Memory | String | KW_System | Thread | Typeof | Delta | Endif | Error | False | Goals | Group | Model | State | Units | Value | Data | Else | Flow | Goal | Mode | Real | Root | Self | Then | This | True | Upto | When | With | And | Bus | Div | For | Img | Mod | Not | See | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | FullStopFullStop | ColonColon | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignLessThanSign | GreaterThanSignEqualsSign | As | If | In | Or | VerticalLineVerticalLine | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt25=116;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // InternalReqSpecLexer.g:1:10: Requirements
                {
                mRequirements(); 

                }
                break;
            case 2 :
                // InternalReqSpecLexer.g:1:23: Description
                {
                mDescription(); 

                }
                break;
            case 3 :
                // InternalReqSpecLexer.g:1:35: Development
                {
                mDevelopment(); 

                }
                break;
            case 4 :
                // InternalReqSpecLexer.g:1:47: Requirement
                {
                mRequirement(); 

                }
                break;
            case 5 :
                // InternalReqSpecLexer.g:1:59: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 6 :
                // InternalReqSpecLexer.g:1:71: Uncertainty
                {
                mUncertainty(); 

                }
                break;
            case 7 :
                // InternalReqSpecLexer.g:1:83: Connection
                {
                mConnection(); 

                }
                break;
            case 8 :
                // InternalReqSpecLexer.g:1:94: Decomposes
                {
                mDecomposes(); 

                }
                break;
            case 9 :
                // InternalReqSpecLexer.g:1:105: Precedence
                {
                mPrecedence(); 

                }
                break;
            case 10 :
                // InternalReqSpecLexer.g:1:116: Subprogram
                {
                mSubprogram(); 

                }
                break;
            case 11 :
                // InternalReqSpecLexer.g:1:127: Volatility
                {
                mVolatility(); 

                }
                break;
            case 12 :
                // InternalReqSpecLexer.g:1:138: Component
                {
                mComponent(); 

                }
                break;
            case 13 :
                // InternalReqSpecLexer.g:1:148: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 14 :
                // InternalReqSpecLexer.g:1:158: Constants
                {
                mConstants(); 

                }
                break;
            case 15 :
                // InternalReqSpecLexer.g:1:168: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 16 :
                // InternalReqSpecLexer.g:1:178: Predicate
                {
                mPredicate(); 

                }
                break;
            case 17 :
                // InternalReqSpecLexer.g:1:188: Processor
                {
                mProcessor(); 

                }
                break;
            case 18 :
                // InternalReqSpecLexer.g:1:198: Rationale
                {
                mRationale(); 

                }
                break;
            case 19 :
                // InternalReqSpecLexer.g:1:208: Abstract
                {
                mAbstract(); 

                }
                break;
            case 20 :
                // InternalReqSpecLexer.g:1:217: Category
                {
                mCategory(); 

                }
                break;
            case 21 :
                // InternalReqSpecLexer.g:1:226: Document
                {
                mDocument(); 

                }
                break;
            case 22 :
                // InternalReqSpecLexer.g:1:235: Informal
                {
                mInformal(); 

                }
                break;
            case 23 :
                // InternalReqSpecLexer.g:1:244: Inherits
                {
                mInherits(); 

                }
                break;
            case 24 :
                // InternalReqSpecLexer.g:1:253: Boolean
                {
                mBoolean(); 

                }
                break;
            case 25 :
                // InternalReqSpecLexer.g:1:261: Compute
                {
                mCompute(); 

                }
                break;
            case 26 :
                // InternalReqSpecLexer.g:1:269: Dropped
                {
                mDropped(); 

                }
                break;
            case 27 :
                // InternalReqSpecLexer.g:1:277: Element
                {
                mElement(); 

                }
                break;
            case 28 :
                // InternalReqSpecLexer.g:1:285: Evolves
                {
                mEvolves(); 

                }
                break;
            case 29 :
                // InternalReqSpecLexer.g:1:293: Feature
                {
                mFeature(); 

                }
                break;
            case 30 :
                // InternalReqSpecLexer.g:1:301: Include
                {
                mInclude(); 

                }
                break;
            case 31 :
                // InternalReqSpecLexer.g:1:309: Integer
                {
                mInteger(); 

                }
                break;
            case 32 :
                // InternalReqSpecLexer.g:1:317: Process
                {
                mProcess(); 

                }
                break;
            case 33 :
                // InternalReqSpecLexer.g:1:325: Refines
                {
                mRefines(); 

                }
                break;
            case 34 :
                // InternalReqSpecLexer.g:1:333: Section
                {
                mSection(); 

                }
                break;
            case 35 :
                // InternalReqSpecLexer.g:1:341: Virtual
                {
                mVirtual(); 

                }
                break;
            case 36 :
                // InternalReqSpecLexer.g:1:349: Device
                {
                mDevice(); 

                }
                break;
            case 37 :
                // InternalReqSpecLexer.g:1:356: Downto
                {
                mDownto(); 

                }
                break;
            case 38 :
                // InternalReqSpecLexer.g:1:363: Global
                {
                mGlobal(); 

                }
                break;
            case 39 :
                // InternalReqSpecLexer.g:1:370: Impact
                {
                mImpact(); 

                }
                break;
            case 40 :
                // InternalReqSpecLexer.g:1:377: Issues
                {
                mIssues(); 

                }
                break;
            case 41 :
                // InternalReqSpecLexer.g:1:384: Memory
                {
                mMemory(); 

                }
                break;
            case 42 :
                // InternalReqSpecLexer.g:1:391: String
                {
                mString(); 

                }
                break;
            case 43 :
                // InternalReqSpecLexer.g:1:398: KW_System
                {
                mKW_System(); 

                }
                break;
            case 44 :
                // InternalReqSpecLexer.g:1:408: Thread
                {
                mThread(); 

                }
                break;
            case 45 :
                // InternalReqSpecLexer.g:1:415: Typeof
                {
                mTypeof(); 

                }
                break;
            case 46 :
                // InternalReqSpecLexer.g:1:422: Delta
                {
                mDelta(); 

                }
                break;
            case 47 :
                // InternalReqSpecLexer.g:1:428: Endif
                {
                mEndif(); 

                }
                break;
            case 48 :
                // InternalReqSpecLexer.g:1:434: Error
                {
                mError(); 

                }
                break;
            case 49 :
                // InternalReqSpecLexer.g:1:440: False
                {
                mFalse(); 

                }
                break;
            case 50 :
                // InternalReqSpecLexer.g:1:446: Goals
                {
                mGoals(); 

                }
                break;
            case 51 :
                // InternalReqSpecLexer.g:1:452: Group
                {
                mGroup(); 

                }
                break;
            case 52 :
                // InternalReqSpecLexer.g:1:458: Model
                {
                mModel(); 

                }
                break;
            case 53 :
                // InternalReqSpecLexer.g:1:464: State
                {
                mState(); 

                }
                break;
            case 54 :
                // InternalReqSpecLexer.g:1:470: Units
                {
                mUnits(); 

                }
                break;
            case 55 :
                // InternalReqSpecLexer.g:1:476: Value
                {
                mValue(); 

                }
                break;
            case 56 :
                // InternalReqSpecLexer.g:1:482: Data
                {
                mData(); 

                }
                break;
            case 57 :
                // InternalReqSpecLexer.g:1:487: Else
                {
                mElse(); 

                }
                break;
            case 58 :
                // InternalReqSpecLexer.g:1:492: Flow
                {
                mFlow(); 

                }
                break;
            case 59 :
                // InternalReqSpecLexer.g:1:497: Goal
                {
                mGoal(); 

                }
                break;
            case 60 :
                // InternalReqSpecLexer.g:1:502: Mode
                {
                mMode(); 

                }
                break;
            case 61 :
                // InternalReqSpecLexer.g:1:507: Real
                {
                mReal(); 

                }
                break;
            case 62 :
                // InternalReqSpecLexer.g:1:512: Root
                {
                mRoot(); 

                }
                break;
            case 63 :
                // InternalReqSpecLexer.g:1:517: Self
                {
                mSelf(); 

                }
                break;
            case 64 :
                // InternalReqSpecLexer.g:1:522: Then
                {
                mThen(); 

                }
                break;
            case 65 :
                // InternalReqSpecLexer.g:1:527: This
                {
                mThis(); 

                }
                break;
            case 66 :
                // InternalReqSpecLexer.g:1:532: True
                {
                mTrue(); 

                }
                break;
            case 67 :
                // InternalReqSpecLexer.g:1:537: Upto
                {
                mUpto(); 

                }
                break;
            case 68 :
                // InternalReqSpecLexer.g:1:542: When
                {
                mWhen(); 

                }
                break;
            case 69 :
                // InternalReqSpecLexer.g:1:547: With
                {
                mWith(); 

                }
                break;
            case 70 :
                // InternalReqSpecLexer.g:1:552: And
                {
                mAnd(); 

                }
                break;
            case 71 :
                // InternalReqSpecLexer.g:1:556: Bus
                {
                mBus(); 

                }
                break;
            case 72 :
                // InternalReqSpecLexer.g:1:560: Div
                {
                mDiv(); 

                }
                break;
            case 73 :
                // InternalReqSpecLexer.g:1:564: For
                {
                mFor(); 

                }
                break;
            case 74 :
                // InternalReqSpecLexer.g:1:568: Img
                {
                mImg(); 

                }
                break;
            case 75 :
                // InternalReqSpecLexer.g:1:572: Mod
                {
                mMod(); 

                }
                break;
            case 76 :
                // InternalReqSpecLexer.g:1:576: Not
                {
                mNot(); 

                }
                break;
            case 77 :
                // InternalReqSpecLexer.g:1:580: See
                {
                mSee(); 

                }
                break;
            case 78 :
                // InternalReqSpecLexer.g:1:584: Use
                {
                mUse(); 

                }
                break;
            case 79 :
                // InternalReqSpecLexer.g:1:588: Val
                {
                mVal(); 

                }
                break;
            case 80 :
                // InternalReqSpecLexer.g:1:592: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 81 :
                // InternalReqSpecLexer.g:1:618: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 82 :
                // InternalReqSpecLexer.g:1:637: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 83 :
                // InternalReqSpecLexer.g:1:654: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 84 :
                // InternalReqSpecLexer.g:1:665: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 85 :
                // InternalReqSpecLexer.g:1:688: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 86 :
                // InternalReqSpecLexer.g:1:709: GreaterThanSignLessThanSign
                {
                mGreaterThanSignLessThanSign(); 

                }
                break;
            case 87 :
                // InternalReqSpecLexer.g:1:737: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 88 :
                // InternalReqSpecLexer.g:1:763: As
                {
                mAs(); 

                }
                break;
            case 89 :
                // InternalReqSpecLexer.g:1:766: If
                {
                mIf(); 

                }
                break;
            case 90 :
                // InternalReqSpecLexer.g:1:769: In
                {
                mIn(); 

                }
                break;
            case 91 :
                // InternalReqSpecLexer.g:1:772: Or
                {
                mOr(); 

                }
                break;
            case 92 :
                // InternalReqSpecLexer.g:1:775: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 93 :
                // InternalReqSpecLexer.g:1:800: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 94 :
                // InternalReqSpecLexer.g:1:811: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 95 :
                // InternalReqSpecLexer.g:1:823: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 96 :
                // InternalReqSpecLexer.g:1:839: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 97 :
                // InternalReqSpecLexer.g:1:856: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 98 :
                // InternalReqSpecLexer.g:1:865: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 99 :
                // InternalReqSpecLexer.g:1:874: Comma
                {
                mComma(); 

                }
                break;
            case 100 :
                // InternalReqSpecLexer.g:1:880: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 101 :
                // InternalReqSpecLexer.g:1:892: FullStop
                {
                mFullStop(); 

                }
                break;
            case 102 :
                // InternalReqSpecLexer.g:1:901: Solidus
                {
                mSolidus(); 

                }
                break;
            case 103 :
                // InternalReqSpecLexer.g:1:909: Colon
                {
                mColon(); 

                }
                break;
            case 104 :
                // InternalReqSpecLexer.g:1:915: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 105 :
                // InternalReqSpecLexer.g:1:928: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 106 :
                // InternalReqSpecLexer.g:1:939: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 107 :
                // InternalReqSpecLexer.g:1:955: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 108 :
                // InternalReqSpecLexer.g:1:973: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 109 :
                // InternalReqSpecLexer.g:1:992: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 110 :
                // InternalReqSpecLexer.g:1:1006: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 111 :
                // InternalReqSpecLexer.g:1:1014: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 112 :
                // InternalReqSpecLexer.g:1:1023: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 113 :
                // InternalReqSpecLexer.g:1:1035: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 114 :
                // InternalReqSpecLexer.g:1:1051: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 115 :
                // InternalReqSpecLexer.g:1:1067: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 116 :
                // InternalReqSpecLexer.g:1:1075: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\21\60\2\54\1\143\1\145\1\147\1\151\1\154\1\60\1\54\10\uffff\1\171\2\uffff\1\174\1\54\1\uffff\2\54\2\uffff\3\60\1\uffff\27\60\1\u00a7\1\u00ac\2\60\1\u00b0\23\60\15\uffff\1\u00c7\20\uffff\1\174\2\uffff\15\60\1\u00d6\5\60\1\u00dd\4\60\1\u00e2\7\60\1\u00ee\2\60\1\u00f2\1\60\1\u00f4\1\uffff\4\60\1\uffff\1\60\1\u00fa\1\60\1\uffff\1\60\1\u00fd\10\60\1\u0106\12\60\1\u0111\1\uffff\2\60\1\u0114\1\60\1\u0116\10\60\1\u011f\1\uffff\5\60\1\u0125\1\uffff\3\60\1\u0129\1\uffff\13\60\1\uffff\2\60\1\u0139\1\uffff\1\60\1\uffff\5\60\1\uffff\2\60\1\uffff\1\60\1\u0143\5\60\1\u0149\1\uffff\1\60\1\u014c\2\60\1\u014f\1\u0150\1\60\1\u0152\1\u0153\1\u0154\1\uffff\2\60\1\uffff\1\60\1\uffff\4\60\1\u015c\3\60\1\uffff\1\60\1\u0161\3\60\1\uffff\2\60\1\u0167\1\uffff\13\60\1\u0173\2\60\1\u0176\1\uffff\11\60\1\uffff\1\60\1\u0181\1\u0182\1\60\1\u0184\1\uffff\1\60\1\u0186\1\uffff\1\u0187\1\60\2\uffff\1\60\3\uffff\5\60\1\u018f\1\60\1\uffff\1\60\1\u0192\2\60\1\uffff\1\u0195\2\60\1\u0198\1\60\1\uffff\13\60\1\uffff\1\60\1\u01a6\1\uffff\5\60\1\u01ac\1\u01ad\3\60\2\uffff\1\60\1\uffff\1\u01b2\2\uffff\1\u01b3\1\u01b4\1\60\1\u01b6\3\60\1\uffff\2\60\1\uffff\1\u01bc\1\60\1\uffff\1\60\1\u01bf\1\uffff\5\60\1\u01c5\3\60\1\u01ca\1\60\1\u01cc\1\60\1\uffff\3\60\1\u01d1\1\u01d2\2\uffff\1\u01d3\1\u01d4\1\u01d5\1\u01d6\3\uffff\1\60\1\uffff\4\60\1\u01dc\1\uffff\2\60\1\uffff\5\60\1\uffff\1\u01e4\3\60\1\uffff\1\60\1\uffff\1\60\1\u01ea\1\u01eb\1\u01ec\6\uffff\1\60\1\u01ee\3\60\1\uffff\4\60\1\u01f6\1\u01f7\1\u01f8\1\uffff\1\60\1\u01fa\1\u01fb\1\60\1\u01fd\3\uffff\1\60\1\uffff\2\60\1\u0201\1\60\1\u0203\1\60\1\u0205\3\uffff\1\u0206\2\uffff\1\u0207\1\uffff\1\u0209\1\u020a\1\u020b\1\uffff\1\u020c\1\uffff\1\u020d\3\uffff\1\u020e\6\uffff";
    static final String DFA25_eofS =
        "\u020f\uffff";
    static final String DFA25_minS =
        "\1\0\2\141\1\145\1\156\1\141\1\162\1\141\1\145\1\142\1\146\1\157\1\154\1\141\1\154\2\150\1\157\1\75\1\46\1\56\1\72\2\75\1\74\1\162\1\174\10\uffff\1\52\2\uffff\1\56\1\101\1\uffff\2\0\2\uffff\1\141\1\164\1\157\1\uffff\2\143\1\157\1\164\1\166\1\141\1\142\1\143\1\163\1\143\1\164\1\145\1\155\1\164\1\145\1\154\1\162\1\154\1\164\1\155\1\144\1\163\1\144\2\60\1\147\1\163\1\60\1\157\1\163\1\145\1\157\1\144\1\162\1\141\1\154\1\157\1\162\1\157\1\141\1\157\1\145\1\160\1\165\1\145\2\164\15\uffff\1\60\20\uffff\1\56\2\uffff\1\165\1\151\1\154\1\151\1\164\1\143\1\145\1\157\1\164\1\165\1\156\1\160\1\141\1\60\1\153\1\151\1\160\1\164\1\146\1\60\1\164\1\145\1\164\1\157\1\60\1\146\1\160\1\145\2\143\1\141\1\164\1\60\1\151\1\157\1\60\1\164\1\60\1\uffff\1\157\1\145\1\154\1\145\1\uffff\1\141\1\60\1\165\1\uffff\1\154\1\60\1\155\1\145\1\154\1\151\1\157\1\164\1\163\1\167\1\60\1\142\1\154\1\165\1\145\1\156\1\163\2\145\1\156\1\150\1\60\1\uffff\1\151\1\156\1\60\1\157\1\60\1\162\1\154\1\143\1\155\1\141\1\155\1\164\1\160\1\60\1\uffff\2\145\1\156\1\162\1\151\1\60\1\uffff\1\145\1\162\1\163\1\60\1\uffff\1\145\1\154\1\164\1\157\1\147\1\145\1\151\1\145\1\164\1\165\1\145\1\uffff\1\147\1\162\1\60\1\uffff\1\162\1\uffff\2\162\1\165\1\147\1\143\1\uffff\2\145\1\uffff\1\145\1\60\1\166\1\146\1\162\1\165\1\145\1\60\1\uffff\1\141\1\60\1\160\1\141\2\60\1\157\3\60\1\uffff\1\162\1\145\1\uffff\1\156\1\uffff\1\151\1\157\1\145\1\160\1\60\1\145\1\157\1\145\1\uffff\1\150\1\60\1\147\2\157\1\uffff\1\155\1\164\1\60\1\uffff\1\143\1\151\1\141\1\156\1\164\1\157\1\144\1\143\1\163\1\151\1\141\1\60\1\141\1\171\1\60\1\uffff\1\141\1\155\1\151\1\144\1\145\1\164\1\163\1\141\1\156\1\uffff\1\145\2\60\1\162\1\60\1\uffff\1\154\1\60\1\uffff\1\60\1\144\2\uffff\1\146\3\uffff\1\145\1\163\1\141\2\160\1\60\1\157\1\uffff\1\156\1\60\1\144\1\157\1\uffff\1\60\1\147\1\156\1\60\1\141\1\uffff\1\164\1\143\1\156\2\145\1\162\1\145\1\141\1\163\2\154\1\uffff\1\164\1\60\1\uffff\1\143\1\141\1\164\1\145\1\162\2\60\1\156\1\164\1\163\2\uffff\1\145\1\uffff\1\60\2\uffff\2\60\1\155\1\60\1\154\1\164\1\155\1\uffff\1\163\1\164\1\uffff\1\60\1\154\1\uffff\1\162\1\60\1\uffff\2\151\2\164\1\156\1\60\1\171\1\156\1\164\1\60\1\151\1\60\1\145\1\uffff\1\164\1\154\1\163\2\60\2\uffff\4\60\3\uffff\1\145\1\uffff\1\145\1\151\2\145\1\60\1\uffff\1\144\1\141\1\uffff\1\156\1\157\2\163\1\164\1\uffff\1\60\1\143\1\145\1\162\1\uffff\1\164\1\uffff\1\163\3\60\6\uffff\1\156\1\60\1\157\1\156\1\163\1\uffff\1\145\1\155\1\164\1\156\3\60\1\uffff\1\145\2\60\1\171\1\60\3\uffff\1\164\1\uffff\1\156\1\164\1\60\1\162\1\60\1\171\1\60\3\uffff\1\60\2\uffff\1\60\1\uffff\3\60\1\uffff\1\60\1\uffff\1\60\3\uffff\1\60\6\uffff";
    static final String DFA25_maxS =
        "\1\uffff\1\157\1\162\1\171\1\163\1\157\1\162\2\157\2\163\1\165\1\166\1\157\1\162\1\171\1\151\1\157\1\75\1\46\1\56\1\72\3\75\1\162\1\174\10\uffff\1\57\2\uffff\1\137\1\172\1\uffff\2\uffff\2\uffff\1\161\1\164\1\157\1\uffff\1\166\1\167\1\157\1\164\1\166\1\162\1\142\1\154\1\163\1\151\1\164\1\145\1\156\1\164\1\157\1\154\1\162\1\154\1\164\1\155\1\144\1\163\1\144\2\172\1\160\1\163\1\172\1\157\2\163\1\157\1\144\1\162\1\141\1\154\1\157\1\162\1\157\1\141\1\157\1\162\1\160\1\165\1\145\2\164\15\uffff\1\172\20\uffff\1\137\2\uffff\1\165\1\151\1\154\1\151\1\164\1\143\1\151\1\157\1\164\1\165\1\156\1\160\1\141\1\172\1\164\1\151\1\160\1\164\1\146\1\172\1\164\1\145\1\164\1\157\1\172\1\163\1\160\1\145\1\144\1\143\1\141\1\164\1\172\1\151\1\157\1\172\1\164\1\172\1\uffff\1\157\1\145\1\154\1\145\1\uffff\1\141\1\172\1\165\1\uffff\1\154\1\172\1\155\1\145\1\154\1\151\1\157\1\164\1\163\1\167\1\172\1\142\1\154\1\165\1\145\1\156\1\163\2\145\1\156\1\150\1\172\1\uffff\1\151\1\156\1\172\1\157\1\172\1\162\1\154\1\143\1\155\1\141\1\155\1\164\1\160\1\172\1\uffff\2\145\1\156\1\162\1\151\1\172\1\uffff\1\145\1\162\1\163\1\172\1\uffff\1\145\1\154\1\164\1\165\1\147\1\145\1\151\1\145\1\164\1\165\1\145\1\uffff\1\147\1\162\1\172\1\uffff\1\162\1\uffff\2\162\1\165\1\147\1\143\1\uffff\2\145\1\uffff\1\145\1\172\1\166\1\146\1\162\1\165\1\145\1\172\1\uffff\1\141\1\172\1\160\1\141\2\172\1\157\3\172\1\uffff\1\162\1\145\1\uffff\1\156\1\uffff\1\151\1\157\1\145\1\160\1\172\1\145\1\157\1\145\1\uffff\1\150\1\172\1\147\2\157\1\uffff\1\155\1\164\1\172\1\uffff\1\143\1\151\1\141\1\156\1\164\1\157\1\144\1\143\1\163\1\151\1\141\1\172\1\141\1\171\1\172\1\uffff\1\141\1\155\1\151\1\144\1\145\1\164\1\163\1\141\1\156\1\uffff\1\145\2\172\1\162\1\172\1\uffff\1\154\1\172\1\uffff\1\172\1\144\2\uffff\1\146\3\uffff\1\145\1\163\1\141\2\160\1\172\1\157\1\uffff\1\156\1\172\1\144\1\157\1\uffff\1\172\1\147\1\156\1\172\1\141\1\uffff\1\164\1\143\1\156\2\145\1\162\1\145\1\141\1\163\2\154\1\uffff\1\164\1\172\1\uffff\1\143\1\141\1\164\1\145\1\162\2\172\1\156\1\164\1\163\2\uffff\1\145\1\uffff\1\172\2\uffff\2\172\1\155\1\172\1\154\1\164\1\155\1\uffff\1\163\1\164\1\uffff\1\172\1\154\1\uffff\1\162\1\172\1\uffff\2\151\2\164\1\156\1\172\1\171\1\156\1\164\1\172\1\151\1\172\1\145\1\uffff\1\164\1\154\1\163\2\172\2\uffff\4\172\3\uffff\1\145\1\uffff\1\145\1\151\2\145\1\172\1\uffff\1\144\1\141\1\uffff\1\156\1\157\2\163\1\164\1\uffff\1\172\1\143\1\145\1\162\1\uffff\1\164\1\uffff\1\163\3\172\6\uffff\1\156\1\172\1\157\1\156\1\163\1\uffff\1\145\1\155\1\164\1\156\3\172\1\uffff\1\145\2\172\1\171\1\172\3\uffff\1\164\1\uffff\1\156\1\164\1\172\1\162\1\172\1\171\1\172\3\uffff\1\172\2\uffff\1\172\1\uffff\3\172\1\uffff\1\172\1\uffff\1\172\3\uffff\1\172\6\uffff";
    static final String DFA25_acceptS =
        "\33\uffff\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\uffff\1\153\1\154\2\uffff\1\156\2\uffff\1\163\1\164\3\uffff\1\156\57\uffff\1\120\1\121\1\122\1\145\1\123\1\147\1\124\1\150\1\125\1\151\1\126\1\127\1\152\1\uffff\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\161\1\162\1\146\1\153\1\154\1\157\1\155\1\uffff\1\160\1\163\46\uffff\1\130\4\uffff\1\132\3\uffff\1\131\26\uffff\1\133\16\uffff\1\110\6\uffff\1\115\4\uffff\1\116\13\uffff\1\117\3\uffff\1\113\1\uffff\1\106\5\uffff\1\112\2\uffff\1\107\10\uffff\1\111\12\uffff\1\114\2\uffff\1\75\1\uffff\1\76\10\uffff\1\70\5\uffff\1\77\3\uffff\1\103\17\uffff\1\74\11\uffff\1\71\5\uffff\1\72\2\uffff\1\73\2\uffff\1\100\1\101\1\uffff\1\102\1\104\1\105\7\uffff\1\56\4\uffff\1\65\5\uffff\1\66\13\uffff\1\67\2\uffff\1\64\12\uffff\1\57\1\60\1\uffff\1\61\1\uffff\1\62\1\63\7\uffff\1\44\2\uffff\1\45\2\uffff\1\52\2\uffff\1\53\15\uffff\1\51\5\uffff\1\47\1\50\4\uffff\1\46\1\54\1\55\1\uffff\1\41\5\uffff\1\32\2\uffff\1\42\5\uffff\1\31\4\uffff\1\40\1\uffff\1\43\4\uffff\1\36\1\37\1\30\1\33\1\34\1\35\5\uffff\1\25\7\uffff\1\24\5\uffff\1\23\1\26\1\27\1\uffff\1\22\7\uffff\1\15\1\16\1\14\1\uffff\1\20\1\21\1\uffff\1\17\3\uffff\1\10\1\uffff\1\12\1\uffff\1\7\1\11\1\13\1\uffff\1\4\1\2\1\3\1\5\1\6\1\1";
    static final String DFA25_specialS =
        "\1\0\50\uffff\1\1\1\2\u01e4\uffff}>";
    static final String[] DFA25_transitionS = DFA25_transitionS_.DFA25_transitionS;
    private static final class DFA25_transitionS_ {
        static final String[] DFA25_transitionS = {
                "\11\54\2\53\2\54\1\53\22\54\1\53\1\22\1\51\1\33\1\54\1\34\1\23\1\52\1\35\1\36\1\37\1\40\1\41\1\42\1\24\1\43\12\46\1\25\1\54\1\26\1\27\1\30\2\54\32\50\1\44\1\54\1\45\1\47\1\50\1\54\1\11\1\13\1\5\1\2\1\14\1\15\1\16\1\50\1\12\3\50\1\10\1\21\1\31\1\6\1\50\1\1\1\3\1\17\1\4\1\7\1\20\3\50\1\54\1\32\uff83\54",
                "\1\56\3\uffff\1\55\11\uffff\1\57",
                "\1\64\3\uffff\1\61\3\uffff\1\65\5\uffff\1\62\2\uffff\1\63",
                "\1\70\16\uffff\1\66\1\67\3\uffff\1\71",
                "\1\72\1\uffff\1\73\2\uffff\1\74",
                "\1\76\15\uffff\1\75",
                "\1\77",
                "\1\102\7\uffff\1\101\5\uffff\1\100",
                "\1\104\3\uffff\1\103\5\uffff\1\105",
                "\1\106\13\uffff\1\107\4\uffff\1\110",
                "\1\114\6\uffff\1\112\1\111\4\uffff\1\113",
                "\1\115\5\uffff\1\116",
                "\1\117\1\uffff\1\121\3\uffff\1\122\3\uffff\1\120",
                "\1\124\3\uffff\1\123\6\uffff\1\125\2\uffff\1\126",
                "\1\127\2\uffff\1\130\2\uffff\1\131",
                "\1\132\11\uffff\1\134\6\uffff\1\133",
                "\1\135\1\136",
                "\1\137",
                "\1\140",
                "\1\141",
                "\1\142",
                "\1\144",
                "\1\146",
                "\1\150",
                "\1\152\1\153",
                "\1\155",
                "\1\156",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\167\4\uffff\1\170",
                "",
                "",
                "\1\175\1\uffff\12\176\45\uffff\1\175",
                "\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\0\177",
                "\0\177",
                "",
                "",
                "\1\u0083\4\uffff\1\u0082\12\uffff\1\u0081",
                "\1\u0084",
                "\1\u0085",
                "",
                "\1\u0088\10\uffff\1\u0089\6\uffff\1\u0086\2\uffff\1\u0087",
                "\1\u008a\23\uffff\1\u008b",
                "\1\u008c",
                "\1\u008d",
                "\1\u008e",
                "\1\u008f\20\uffff\1\u0090",
                "\1\u0091",
                "\1\u0092\1\uffff\1\u0094\6\uffff\1\u0093",
                "\1\u0095",
                "\1\u0096\5\uffff\1\u0097",
                "\1\u0098",
                "\1\u0099",
                "\1\u009b\1\u009a",
                "\1\u009c",
                "\1\u009d\11\uffff\1\u009e",
                "\1\u009f",
                "\1\u00a0",
                "\1\u00a1",
                "\1\u00a2",
                "\1\u00a3",
                "\1\u00a4",
                "\1\u00a5",
                "\1\u00a6",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\2\60\1\u00aa\2\60\1\u00a8\1\60\1\u00a9\13\60\1\u00ab\6\60",
                "\1\u00ae\10\uffff\1\u00ad",
                "\1\u00af",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00b1",
                "\1\u00b2",
                "\1\u00b3\15\uffff\1\u00b4",
                "\1\u00b5",
                "\1\u00b6",
                "\1\u00b7",
                "\1\u00b8",
                "\1\u00b9",
                "\1\u00ba",
                "\1\u00bb",
                "\1\u00bc",
                "\1\u00bd",
                "\1\u00be",
                "\1\u00c0\3\uffff\1\u00c1\10\uffff\1\u00bf",
                "\1\u00c2",
                "\1\u00c3",
                "\1\u00c4",
                "\1\u00c5",
                "\1\u00c6",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\175\1\uffff\12\176\45\uffff\1\175",
                "",
                "",
                "\1\u00c8",
                "\1\u00c9",
                "\1\u00ca",
                "\1\u00cb",
                "\1\u00cc",
                "\1\u00cd",
                "\1\u00ce\3\uffff\1\u00cf",
                "\1\u00d0",
                "\1\u00d1",
                "\1\u00d2",
                "\1\u00d3",
                "\1\u00d4",
                "\1\u00d5",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00d7\10\uffff\1\u00d8",
                "\1\u00d9",
                "\1\u00da",
                "\1\u00db",
                "\1\u00dc",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00de",
                "\1\u00df",
                "\1\u00e0",
                "\1\u00e1",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00e4\7\uffff\1\u00e3\4\uffff\1\u00e5",
                "\1\u00e6",
                "\1\u00e7",
                "\1\u00e8\1\u00e9",
                "\1\u00ea",
                "\1\u00eb",
                "\1\u00ec",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\24\60\1\u00ed\5\60",
                "\1\u00ef",
                "\1\u00f0",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\4\60\1\u00f1\25\60",
                "\1\u00f3",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u00f5",
                "\1\u00f6",
                "\1\u00f7",
                "\1\u00f8",
                "",
                "\1\u00f9",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00fb",
                "",
                "\1\u00fc",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u00fe",
                "\1\u00ff",
                "\1\u0100",
                "\1\u0101",
                "\1\u0102",
                "\1\u0103",
                "\1\u0104",
                "\1\u0105",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0107",
                "\1\u0108",
                "\1\u0109",
                "\1\u010a",
                "\1\u010b",
                "\1\u010c",
                "\1\u010d",
                "\1\u010e",
                "\1\u010f",
                "\1\u0110",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0112",
                "\1\u0113",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0115",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0117",
                "\1\u0118",
                "\1\u0119",
                "\1\u011a",
                "\1\u011b",
                "\1\u011c",
                "\1\u011d",
                "\1\u011e",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0120",
                "\1\u0121",
                "\1\u0122",
                "\1\u0123",
                "\1\u0124",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0126",
                "\1\u0127",
                "\1\u0128",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u012a",
                "\1\u012b",
                "\1\u012c",
                "\1\u012d\5\uffff\1\u012e",
                "\1\u012f",
                "\1\u0130",
                "\1\u0131",
                "\1\u0132",
                "\1\u0133",
                "\1\u0134",
                "\1\u0135",
                "",
                "\1\u0136",
                "\1\u0137",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\13\60\1\u0138\16\60",
                "",
                "\1\u013a",
                "",
                "\1\u013b",
                "\1\u013c",
                "\1\u013d",
                "\1\u013e",
                "\1\u013f",
                "",
                "\1\u0140",
                "\1\u0141",
                "",
                "\1\u0142",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0144",
                "\1\u0145",
                "\1\u0146",
                "\1\u0147",
                "\1\u0148",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u014a",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\22\60\1\u014b\7\60",
                "\1\u014d",
                "\1\u014e",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0151",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0155",
                "\1\u0156",
                "",
                "\1\u0157",
                "",
                "\1\u0158",
                "\1\u0159",
                "\1\u015a",
                "\1\u015b",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u015d",
                "\1\u015e",
                "\1\u015f",
                "",
                "\1\u0160",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0162",
                "\1\u0163",
                "\1\u0164",
                "",
                "\1\u0165",
                "\1\u0166",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0168",
                "\1\u0169",
                "\1\u016a",
                "\1\u016b",
                "\1\u016c",
                "\1\u016d",
                "\1\u016e",
                "\1\u016f",
                "\1\u0170",
                "\1\u0171",
                "\1\u0172",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0174",
                "\1\u0175",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0177",
                "\1\u0178",
                "\1\u0179",
                "\1\u017a",
                "\1\u017b",
                "\1\u017c",
                "\1\u017d",
                "\1\u017e",
                "\1\u017f",
                "",
                "\1\u0180",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0183",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u0185",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0188",
                "",
                "",
                "\1\u0189",
                "",
                "",
                "",
                "\1\u018a",
                "\1\u018b",
                "\1\u018c",
                "\1\u018d",
                "\1\u018e",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0190",
                "",
                "\1\u0191",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0193",
                "\1\u0194",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0196",
                "\1\u0197",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0199",
                "",
                "\1\u019a",
                "\1\u019b",
                "\1\u019c",
                "\1\u019d",
                "\1\u019e",
                "\1\u019f",
                "\1\u01a0",
                "\1\u01a1",
                "\1\u01a2",
                "\1\u01a3",
                "\1\u01a4",
                "",
                "\1\u01a5",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u01a7",
                "\1\u01a8",
                "\1\u01a9",
                "\1\u01aa",
                "\1\u01ab",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01ae",
                "\1\u01af",
                "\1\u01b0",
                "",
                "",
                "\1\u01b1",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01b5",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01b7",
                "\1\u01b8",
                "\1\u01b9",
                "",
                "\1\u01ba",
                "\1\u01bb",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01bd",
                "",
                "\1\u01be",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u01c0",
                "\1\u01c1",
                "\1\u01c2",
                "\1\u01c3",
                "\1\u01c4",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01c6",
                "\1\u01c7",
                "\1\u01c8",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\16\60\1\u01c9\13\60",
                "\1\u01cb",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01cd",
                "",
                "\1\u01ce",
                "\1\u01cf",
                "\1\u01d0",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "\1\u01d7",
                "",
                "\1\u01d8",
                "\1\u01d9",
                "\1\u01da",
                "\1\u01db",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u01dd",
                "\1\u01de",
                "",
                "\1\u01df",
                "\1\u01e0",
                "\1\u01e1",
                "\1\u01e2",
                "\1\u01e3",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01e5",
                "\1\u01e6",
                "\1\u01e7",
                "",
                "\1\u01e8",
                "",
                "\1\u01e9",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\u01ed",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01ef",
                "\1\u01f0",
                "\1\u01f1",
                "",
                "\1\u01f2",
                "\1\u01f3",
                "\1\u01f4",
                "\1\u01f5",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\1\u01f9",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u01fc",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "\1\u01fe",
                "",
                "\1\u01ff",
                "\1\u0200",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0202",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\1\u0204",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\22\60\1\u0208\7\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
                "",
                "",
                "",
                "",
                "",
                ""
        };
    }

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    static class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Requirements | Description | Development | Requirement | Stakeholder | Uncertainty | Connection | Decomposes | Precedence | Subprogram | Volatility | Component | Conflicts | Constants | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Inherits | Boolean | Compute | Dropped | Element | Evolves | Feature | Include | Integer | Process | Refines | Section | Virtual | Device | Downto | Global | Impact | Issues | Memory | String | KW_System | Thread | Typeof | Delta | Endif | Error | False | Goals | Group | Model | State | Units | Value | Data | Else | Flow | Goal | Mode | Real | Root | Self | Then | This | True | Upto | When | With | And | Bus | Div | For | Img | Mod | Not | See | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | FullStopFullStop | ColonColon | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignLessThanSign | GreaterThanSignEqualsSign | As | If | In | Or | VerticalLineVerticalLine | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0=='r') ) {s = 1;}

                        else if ( (LA25_0=='d') ) {s = 2;}

                        else if ( (LA25_0=='s') ) {s = 3;}

                        else if ( (LA25_0=='u') ) {s = 4;}

                        else if ( (LA25_0=='c') ) {s = 5;}

                        else if ( (LA25_0=='p') ) {s = 6;}

                        else if ( (LA25_0=='v') ) {s = 7;}

                        else if ( (LA25_0=='m') ) {s = 8;}

                        else if ( (LA25_0=='a') ) {s = 9;}

                        else if ( (LA25_0=='i') ) {s = 10;}

                        else if ( (LA25_0=='b') ) {s = 11;}

                        else if ( (LA25_0=='e') ) {s = 12;}

                        else if ( (LA25_0=='f') ) {s = 13;}

                        else if ( (LA25_0=='g') ) {s = 14;}

                        else if ( (LA25_0=='t') ) {s = 15;}

                        else if ( (LA25_0=='w') ) {s = 16;}

                        else if ( (LA25_0=='n') ) {s = 17;}

                        else if ( (LA25_0=='!') ) {s = 18;}

                        else if ( (LA25_0=='&') ) {s = 19;}

                        else if ( (LA25_0=='.') ) {s = 20;}

                        else if ( (LA25_0==':') ) {s = 21;}

                        else if ( (LA25_0=='<') ) {s = 22;}

                        else if ( (LA25_0=='=') ) {s = 23;}

                        else if ( (LA25_0=='>') ) {s = 24;}

                        else if ( (LA25_0=='o') ) {s = 25;}

                        else if ( (LA25_0=='|') ) {s = 26;}

                        else if ( (LA25_0=='#') ) {s = 27;}

                        else if ( (LA25_0=='%') ) {s = 28;}

                        else if ( (LA25_0=='(') ) {s = 29;}

                        else if ( (LA25_0==')') ) {s = 30;}

                        else if ( (LA25_0=='*') ) {s = 31;}

                        else if ( (LA25_0=='+') ) {s = 32;}

                        else if ( (LA25_0==',') ) {s = 33;}

                        else if ( (LA25_0=='-') ) {s = 34;}

                        else if ( (LA25_0=='/') ) {s = 35;}

                        else if ( (LA25_0=='[') ) {s = 36;}

                        else if ( (LA25_0==']') ) {s = 37;}

                        else if ( ((LA25_0>='0' && LA25_0<='9')) ) {s = 38;}

                        else if ( (LA25_0=='^') ) {s = 39;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||LA25_0=='h'||(LA25_0>='j' && LA25_0<='l')||LA25_0=='q'||(LA25_0>='x' && LA25_0<='z')) ) {s = 40;}

                        else if ( (LA25_0=='\"') ) {s = 41;}

                        else if ( (LA25_0=='\'') ) {s = 42;}

                        else if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {s = 43;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='$'||LA25_0==';'||(LA25_0>='?' && LA25_0<='@')||LA25_0=='\\'||LA25_0=='`'||LA25_0=='{'||(LA25_0>='}' && LA25_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_41 = input.LA(1);

                        s = -1;
                        if ( ((LA25_41>='\u0000' && LA25_41<='\uFFFF')) ) {s = 127;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_42 = input.LA(1);

                        s = -1;
                        if ( ((LA25_42>='\u0000' && LA25_42<='\uFFFF')) ) {s = 127;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}