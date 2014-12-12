/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.formatting;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementMatcher;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementPattern;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.formatting.impl.FormattingConfig.LinewrapLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig.SpaceLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig2;
import org.eclipse.xtext.formatting.impl.FormattingConfigBasedStream;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.util.Pair;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 *
 * IMPORTANT:
 * formatting based on rules does not work properly because the formatter gets confused
 * about the position in the parse tree when it sees a property association of the form
 * Period => 10ms;
 * The formatter interprets that as a numeric range, and after this association formatting
 * with rules doesn't work any more.
 */
public class Aadl2Formatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		Aadl2GrammarAccess g = (Aadl2GrammarAccess) getGrammarAccess();
		c.setAutoLinewrap(120);
		c.setWrappedLineIndentation(2);

		// find common keywords an specify formatting for them
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("(", ")")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setNoSpace().after(pair.getFirst());
			c.setLinewrap(0, 0, 1).after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setNoSpace().before(pair.getSecond());
			c.setLinewrap(0, 0, 1).before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("[", "]")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setNoSpace().after(pair.getFirst());
			c.setLinewrap(0, 0, 1).after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setNoSpace().before(pair.getSecond());
			c.setLinewrap(0, 0, 1).before(pair.getSecond());
		}
		for (Keyword annex : g.findKeywords("annex")) {
			c.setLinewrap(1, 1, 2).before(annex);
			c.setIndentationDecrement().before(annex);
			c.setIndentationIncrement().after(annex);
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("{**", "**}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap().after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setLinewrap().before(pair.getSecond());
			c.setIndentationIncrement().after(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("{", "}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setNoSpace().after(pair.getFirst());
			c.setLinewrap(0, 0, 1).after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setNoSpace().before(pair.getSecond());
			c.setLinewrap(0, 0, 1).before(pair.getSecond());
		}
		for (Keyword comma : g.findKeywords(",")) {
			c.setNoSpace().before(comma);
			c.setNoLinewrap().before(comma);
			c.setLinewrap(0, 0, 1).after(comma);
		}
		for (Keyword semi : g.findKeywords(";")) {
			c.setNoSpace().before(semi);
			c.setNoLinewrap().before(semi);
			c.setLinewrap(0, 1, 2).after(semi);
		}
		for (Keyword dot : g.findKeywords(".")) {
			c.setNoSpace().around(dot);
			c.setNoLinewrap().around(dot);
		}
		for (Keyword colon : g.findKeywords(":")) {
			c.setNoSpace().before(colon);
			c.setNoLinewrap().before(colon);
		}
		for (Keyword doublecolon : g.findKeywords("::")) {
			c.setNoSpace().around(doublecolon);
			c.setNoLinewrap().around(doublecolon);
		}
		for (Keyword left : g.findKeywords("-[")) {
			c.setNoSpace().after(left);
			c.setNoLinewrap().after(left);
		}
		for (Keyword right : g.findKeywords("]->")) {
			c.setNoSpace().before(right);
			c.setNoLinewrap().before(right);
		}
		for (Keyword arrow : g.findKeywords("->")) {
			c.setLinewrap(0, 0, 1).after(arrow);
		}
		for (Keyword section : g.findKeywords("prototypes", "subcomponents", "connections", "flows", "calls",
				"properties")) {
			indentSection(c, section);
		}
		for (Keyword applies : g.findKeywords("applies")) {
			c.setLinewrap(0, 0, 1).before(applies);
			c.setNoLinewrap().after(applies);
		}
		for (Keyword in : g.findKeywords("in")) {
			c.setLinewrap(0, 0, 1).before(in);
			c.setNoLinewrap().after(in);
		}

		c.setIndentationIncrement().after(g.getAadlPackageAccess().getPackageKeyword_0());
		c.setIndentationDecrement().before(g.getAadlPackageAccess().getEndKeyword_4());

		c.setLinewrap(1, 1, 2).around(g.getPublicPackageSectionAccess().getPublicKeyword_1());
		c.setIndentationDecrement().before(g.getPublicPackageSectionAccess().getPublicKeyword_1());
		c.setIndentationIncrement().after(g.getPublicPackageSectionAccess().getPublicKeyword_1());

		c.setLinewrap(1, 1, 2).around(g.getPrivatePackageSectionAccess().getPrivateKeyword_1());
		c.setIndentationDecrement().before(g.getPrivatePackageSectionAccess().getPrivateKeyword_1());
		c.setIndentationIncrement().after(g.getPrivatePackageSectionAccess().getPrivateKeyword_1());

		c.setLinewrap(1, 1, 2).around(g.getPublicPackageSectionAccess().getSemicolonKeyword_2_0_3());

		// @formatter:off
		indentInComponent(c, g.getAbstractTypeAccess().getAbstractKeyword_0(), g.getAbstractTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getAbstractTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getAbstractImplementationAccess().getAbstractKeyword_0(), g.getAbstractImplementationAccess().getEndKeyword_17());
		c.setLinewrap(2).after(g.getAbstractImplementationAccess().getSemicolonKeyword_19());
		indentInComponent(c, g.getBusTypeAccess().getBusKeyword_0(), g.getBusTypeAccess().getEndKeyword_8());
		c.setLinewrap(2).after(g.getBusTypeAccess().getSemicolonKeyword_10());
		indentInComponent(c, g.getBusImplementationAccess().getBusKeyword_0(), g.getBusImplementationAccess().getEndKeyword_13());
		c.setLinewrap(2).after( g.getBusImplementationAccess().getSemicolonKeyword_15());
		indentInComponent(c, g.getDataTypeAccess().getDataKeyword_0(), g.getDataTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getDataTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getDataImplementationAccess().getDataKeyword_1(), g.getDataImplementationAccess().getEndKeyword_16());
		c.setLinewrap(2).after(g.getDataImplementationAccess().getSemicolonKeyword_18());
		indentInComponent(c, g.getDeviceTypeAccess().getDeviceKeyword_0(), g.getDeviceTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getDeviceTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getDeviceImplementationAccess().getDeviceKeyword_0(), g.getDeviceImplementationAccess().getEndKeyword_16());
		c.setLinewrap(2).after(g.getDeviceImplementationAccess().getSemicolonKeyword_18());
		indentInComponent(c, g.getMemoryTypeAccess().getMemoryKeyword_0(), g.getMemoryTypeAccess().getEndKeyword_8());
		c.setLinewrap(2).after(g.getMemoryTypeAccess().getSemicolonKeyword_10());
		indentInComponent(c, g.getMemoryImplementationAccess().getMemoryKeyword_0(), g.getMemoryImplementationAccess().getEndKeyword_14());
		c.setLinewrap(2).after(g.getMemoryImplementationAccess().getSemicolonKeyword_16());
		indentInComponent(c, g.getProcessTypeAccess().getProcessKeyword_0(), g.getProcessTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getProcessTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getProcessImplementationAccess().getProcessKeyword_0(), g.getProcessImplementationAccess().getEndKeyword_16());
		c.setLinewrap(2).after(g.getProcessImplementationAccess().getSemicolonKeyword_18());
		indentInComponent(c, g.getProcessorTypeAccess().getProcessorKeyword_0(), g.getProcessorTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getProcessorTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getProcessorImplementationAccess().getProcessorKeyword_0(), g.getProcessorImplementationAccess().getEndKeyword_15());
		c.setLinewrap(2).after(g.getProcessorImplementationAccess().getSemicolonKeyword_17());
		indentInComponent(c, g.getSystemTypeAccess().getSystemKeyword_0(), g.getSystemTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getSystemTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getSystemImplementationAccess().getSystemKeyword_0(), g.getSystemImplementationAccess().getEndKeyword_16());
		c.setLinewrap(2).after(g.getSystemImplementationAccess().getSemicolonKeyword_18());
		indentInComponent(c, g.getSubprogramTypeAccess().getSubprogramKeyword_0(), g.getSubprogramTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getSubprogramTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getSubprogramImplementationAccess().getSubprogramKeyword_0(), g.getSubprogramImplementationAccess().getEndKeyword_17());
		c.setLinewrap(2).after(g.getSubprogramImplementationAccess().getSemicolonKeyword_19());
		indentInComponent(c, g.getSubprogramGroupTypeAccess().getSubprogramKeyword_0(), g.getSubprogramGroupTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getSubprogramGroupTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getSubprogramGroupImplementationAccess().getSubprogramKeyword_0(), g.getSubprogramGroupImplementationAccess().getEndKeyword_16());
		c.setLinewrap(2).after(g.getSubprogramGroupImplementationAccess().getSemicolonKeyword_18());
		indentInComponent(c, g.getThreadTypeAccess().getThreadKeyword_0(), g.getThreadTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getThreadTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getThreadImplementationAccess().getThreadKeyword_0(), g.getThreadImplementationAccess().getEndKeyword_17());
		c.setLinewrap(2).after(g.getThreadImplementationAccess().getSemicolonKeyword_19());
		indentInComponent(c, g.getThreadGroupTypeAccess().getThreadKeyword_0(), g.getThreadGroupTypeAccess().getEndKeyword_10());
		c.setLinewrap(2).after(g.getThreadGroupTypeAccess().getSemicolonKeyword_12());
		indentInComponent(c, g.getThreadGroupImplementationAccess().getThreadKeyword_0(), g.getThreadGroupImplementationAccess().getEndKeyword_17());
		c.setLinewrap(2).after(g.getThreadGroupImplementationAccess().getSemicolonKeyword_19());
		indentInComponent(c, g.getVirtualBusTypeAccess().getVirtualKeyword_0(), g.getVirtualBusTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getVirtualBusTypeAccess().getSemicolonKeyword_11());
		indentInComponent(c, g.getVirtualBusImplementationAccess().getVirtualKeyword_0(), g.getVirtualBusImplementationAccess().getEndKeyword_14());
		c.setLinewrap(2).after(g.getVirtualBusImplementationAccess().getSemicolonKeyword_16());
		indentInComponent(c, g.getVirtualProcessorTypeAccess().getVirtualKeyword_0(), g.getVirtualProcessorTypeAccess().getEndKeyword_10());
		c.setLinewrap(2).after(g.getVirtualProcessorTypeAccess().getSemicolonKeyword_12());
		indentInComponent(c, g.getVirtualProcessorImplementationAccess().getVirtualKeyword_0(), g.getVirtualProcessorImplementationAccess().getEndKeyword_17());
		c.setLinewrap(2).after(g.getVirtualProcessorImplementationAccess().getSemicolonKeyword_19());
		indentInComponent(c, g.getFeatureGroupTypeAccess().getFeatureKeyword_0(), g.getFeatureGroupTypeAccess().getEndKeyword_9());
		c.setLinewrap(2).after(g.getFeatureGroupTypeAccess().getSemicolonKeyword_11());
		// @formatter:on

		// features section in types
		indentSection(c, g.getAbstractTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getBusTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getDataTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getDeviceTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getMemoryTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getProcessTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getProcessorTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getSystemTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getSubprogramTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getSubprogramGroupTypeAccess().getFeaturesKeyword_5_0());
		indentSection(c, g.getThreadTypeAccess().getFeaturesKeyword_4_0());
		indentSection(c, g.getThreadGroupTypeAccess().getFeaturesKeyword_5_0());
		indentSection(c, g.getVirtualBusTypeAccess().getFeaturesKeyword_5_0());
		indentSection(c, g.getVirtualProcessorTypeAccess().getFeaturesKeyword_5_0());
		indentSection(c, g.getFeatureGroupTypeAccess().getFeaturesKeyword_5_0());

		// @formatter:off
		indentTwoKeywordSection(c, g.getAbstractTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getAbstractTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getBusTypeAccess().getDerivedModesRequiresKeyword_5_0_0_0(), g.getBusTypeAccess().getModesKeyword_5_0_1());
		indentTwoKeywordSection(c, g.getDataTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getDataTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getDeviceTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getDeviceTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getMemoryTypeAccess().getDerivedModesRequiresKeyword_5_0_0_0(), g.getMemoryTypeAccess().getModesKeyword_5_0_1());
		indentTwoKeywordSection(c, g.getProcessTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getProcessTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getProcessorTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getProcessorTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getSystemTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getSystemTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getSubprogramTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getSubprogramTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getThreadTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getThreadTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getThreadGroupTypeAccess().getDerivedModesRequiresKeyword_7_0_0_0(), g.getThreadGroupTypeAccess().getModesKeyword_7_0_1());
		indentTwoKeywordSection(c, g.getVirtualBusTypeAccess().getDerivedModesRequiresKeyword_6_0_0_0(), g.getVirtualBusTypeAccess().getModesKeyword_6_0_1());
		indentTwoKeywordSection(c, g.getVirtualProcessorTypeAccess().getDerivedModesRequiresKeyword_7_0_0_0(), g.getVirtualProcessorTypeAccess().getModesKeyword_7_0_1());
		// @formatter:on

		// simple modes section in types
		indentSection(c, g.getAbstractTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getBusTypeAccess().getModesKeyword_5_1_0());
		indentSection(c, g.getDataTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getDeviceTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getMemoryTypeAccess().getModesKeyword_5_1_0());
		indentSection(c, g.getProcessTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getProcessorTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getSystemTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getSubprogramTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getThreadTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getThreadGroupTypeAccess().getModesKeyword_7_1_0());
		indentSection(c, g.getVirtualBusTypeAccess().getModesKeyword_6_1_0());
		indentSection(c, g.getVirtualProcessorTypeAccess().getModesKeyword_7_1_0());

		// Internal features section in types
		// @formatter:off
		indentTwoKeywordSection(c, g.getAbstractImplementationAccess().getInternalKeyword_9_0(), g.getAbstractImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getBusImplementationAccess().getInternalKeyword_9_0(), g.getBusImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getDataImplementationAccess().getInternalKeyword_10_0(), g.getDataImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getDeviceImplementationAccess().getInternalKeyword_9_0(), g.getDeviceImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getMemoryImplementationAccess().getInternalKeyword_9_0(), g.getMemoryImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getProcessImplementationAccess().getInternalKeyword_9_0(), g.getProcessImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getProcessorImplementationAccess().getInternalKeyword_9_0(), g.getProcessorImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getSystemImplementationAccess().getInternalKeyword_9_0(), g.getSystemImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getSubprogramImplementationAccess().getInternalKeyword_9_0(), g.getSubprogramImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getThreadImplementationAccess().getInternalKeyword_9_0(), g.getThreadImplementationAccess().getFeaturesKeyword_9_1());
		indentTwoKeywordSection(c, g.getThreadGroupImplementationAccess().getInternalKeyword_10_0(), g.getThreadGroupImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getVirtualBusImplementationAccess().getInternalKeyword_10_0(), g.getVirtualBusImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getVirtualProcessorImplementationAccess().getInternalKeyword_10_0(), g.getVirtualProcessorImplementationAccess().getFeaturesKeyword_10_1());
		// @formatter:on

		// processor features section in types
		// @formatter:off
		indentTwoKeywordSection(c, g.getAbstractImplementationAccess().getProcessorKeyword_10_0(), g.getAbstractImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getDeviceImplementationAccess().getProcessorKeyword_10_0(), g.getDeviceImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getProcessImplementationAccess().getProcessorKeyword_10_0(), g.getProcessImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getSystemImplementationAccess().getProcessorKeyword_10_0(), g.getSystemImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getSubprogramImplementationAccess().getProcessorKeyword_10_0(), g.getSubprogramImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getThreadImplementationAccess().getProcessorKeyword_10_0(), g.getThreadImplementationAccess().getFeaturesKeyword_10_1());
		indentTwoKeywordSection(c, g.getThreadGroupImplementationAccess().getProcessorKeyword_11_0(), g.getThreadGroupImplementationAccess().getFeaturesKeyword_11_1());
		indentTwoKeywordSection(c, g.getVirtualProcessorImplementationAccess().getProcessorKeyword_11_0(), g.getVirtualProcessorImplementationAccess().getFeaturesKeyword_11_1());
		// @formatter:on

		// modes section in component implementation
		indentSection(c, g.getAbstractImplementationAccess().getModesKeyword_14_0());
		indentSection(c, g.getBusImplementationAccess().getModesKeyword_10_0());
		indentSection(c, g.getDataImplementationAccess().getModesKeyword_13_0());
		indentSection(c, g.getDeviceImplementationAccess().getModesKeyword_13_0());
		indentSection(c, g.getMemoryImplementationAccess().getModesKeyword_11_0());
		indentSection(c, g.getProcessImplementationAccess().getModesKeyword_13_0());
		indentSection(c, g.getProcessorImplementationAccess().getModesKeyword_12_0());
		indentSection(c, g.getSystemImplementationAccess().getModesKeyword_13_0());
		indentSection(c, g.getSubprogramImplementationAccess().getModesKeyword_14_0());
		indentSection(c, g.getThreadImplementationAccess().getModesKeyword_14_0());
		indentSection(c, g.getThreadGroupImplementationAccess().getModesKeyword_14_0());
		indentSection(c, g.getVirtualBusImplementationAccess().getModesKeyword_11_0());
		indentSection(c, g.getVirtualProcessorImplementationAccess().getModesKeyword_14_0());

		// set indentation for continuation lines
		for (Keyword colon : g.findKeywords(":")) {
			indentTwiceAfter(c, colon);
		}

		unindentTwiceAfter(c, g.getPrototypeRule());

		unindentTwiceAfter(c, g.getBusAccessRule());
		unindentTwiceAfter(c, g.getDataAccessRule());
		unindentTwiceAfter(c, g.getSubprogramAccessRule());
		unindentTwiceAfter(c, g.getSubprogramGroupAccessRule());
		unindentTwiceAfter(c, g.getDataPortRule());
		unindentTwiceAfter(c, g.getEventDataPortRule());
		unindentTwiceAfter(c, g.getEventPortRule());
		unindentTwiceAfter(c, g.getFeatureGroupRule());
		unindentTwiceAfter(c, g.getParameterRule());
		unindentTwiceAfter(c, g.getAbstractFeatureRule());

		unindentTwiceAfter(c, g.getPortConnectionRule());
		unindentTwiceAfter(c, g.getAccessConnectionRule());
		unindentTwiceAfter(c, g.getFeatureGroupConnectionRule());
		unindentTwiceAfter(c, g.getFeatureConnectionRule());
		unindentTwiceAfter(c, g.getParameterConnectionRule());

		unindentTwiceAfter(c, g.getFlowSpecificationRule());
		unindentTwiceAfter(c, g.getFlowImplementationRule());
		unindentTwiceAfter(c, g.getEndToEndFlowRule());

		unindentTwiceAfter(c, g.getAbstractSubcomponentRule());
		unindentTwiceAfter(c, g.getBusSubcomponentRule());
		unindentTwiceAfter(c, g.getDataSubcomponentRule());
		unindentTwiceAfter(c, g.getDeviceSubcomponentRule());
		unindentTwiceAfter(c, g.getMemorySubcomponentRule());
		unindentTwiceAfter(c, g.getProcessSubcomponentRule());
		unindentTwiceAfter(c, g.getProcessorSubcomponentRule());
		unindentTwiceAfter(c, g.getSubprogramGroupSubcomponentRule());
		unindentTwiceAfter(c, g.getSubprogramSubcomponentRule());
		unindentTwiceAfter(c, g.getSystemSubcomponentRule());
		unindentTwiceAfter(c, g.getThreadGroupSubcomponentRule());
		unindentTwiceAfter(c, g.getThreadSubcomponentRule());
		unindentTwiceAfter(c, g.getVirtualBusSubcomponentRule());
		unindentTwiceAfter(c, g.getVirtualProcessorSubcomponentRule());

		unindentTwiceAfter(c, g.getModeRule());
		unindentTwiceAfter(c, g.getModeTransitionRule());

		unindentTwiceAfter(c, g.getSubprogramCallRule());
		unindentTwiceAfter(c, g.getSubprogramCallSequenceRule());

		unindentTwiceAfter(c, g.getInternalFeatureRule());
		unindentTwiceAfter(c, g.getProcessorFeatureRule());

		unindentTwiceAfter(c, g.getPropertyTypeRule());
		unindentTwiceAfter(c, g.getPropertyDefinitionRule());
		unindentTwiceAfter(c, g.getPropertyConstantRule());
		unindentTwiceAfter(c, g.getRecordFieldRule());

		indentTwiceAfter(c, g.getPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
		indentTwiceAfter(c, g.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
		unindentTwiceAfter(c, g.getPropertyAssociationRule());
		unindentTwiceAfter(c, g.getContainedPropertyAssociationRule());

		// inverse of in feature group type
		{
			Keyword keyword = g.getFeatureGroupTypeAccess().getInverseKeyword_6_0();
			c.setLinewrap(1, 1, 2).before(keyword);
			c.setIndentationDecrement().before(keyword);
			c.setIndentationIncrement().after(keyword);
		}

		// Property sets
		c.setIndentationIncrement().after(g.getPropertySetAccess().getIsKeyword_3());
		c.setLinewrap(1, 1, 2).after(g.getPropertySetAccess().getIsKeyword_3());
		c.setIndentationDecrement().before(g.getPropertySetAccess().getEndKeyword_7());
		c.setLinewrap(1, 1, 2).before(g.getPropertySetAccess().getEndKeyword_7());

		// It's usually a good idea to activate the following three statements.
		// They will add and preserve newlines around comments
		c.setLinewrap(0, 1, 2).before(g.getSL_COMMENTRule());
		// c.setLinewrap(0, 1, 2).before(getGrammarAccess().getML_COMMENTRule());
		// c.setLinewrap(0, 1, 1).after(getGrammarAccess().getML_COMMENTRule());
	}

	protected void unindentTwiceAfter(FormattingConfig c, ParserRule rule) {
		c.setIndentationDecrement().after(rule);
		c.setIndentationDecrement().after(rule);
	}

	protected void indentTwiceAfter(FormattingConfig c, Keyword keyword) {
		c.setIndentationIncrement().after(keyword);
		c.setIndentationIncrement().after(keyword);
	}

	protected void unindentTwiceBefore(FormattingConfig c, Keyword keyword) {
		c.setIndentationDecrement().before(keyword);
		c.setIndentationDecrement().before(keyword);
	}

	protected void indentInComponent(FormattingConfig c, Keyword start, Keyword end) {
		indentTwiceAfter(c, start);
		c.setLinewrap(1, 1, 2).before(end);
		unindentTwiceBefore(c, end);
	}

	protected void indentSection(FormattingConfig c, Keyword keyword) {
		c.setLinewrap(1, 1, 2).before(keyword);
		c.setLinewrap().after(keyword);
		c.setIndentationDecrement().before(keyword);
		c.setIndentationIncrement().after(keyword);
	}

	protected void indentTwoKeywordSection(FormattingConfig c, Keyword first, Keyword second) {
		c.setLinewrap(1, 1, 2).before(first);
		c.setNoLinewrap().between(first, second);
		c.setLinewrap().after(second);
		c.setIndentationDecrement().before(first);
		c.setIndentationIncrement().after(second);
	}

	// Prevent the formatter from using the same line separator for all files in the workspace

	private class FormattingConfig3 extends FormattingConfig2 {
		public FormattingConfig3(IGrammarAccess grammarAccess, IHiddenTokenHelper hiddenTokenHelper,
				IIndentationInformation indentInfo, ILineSeparatorInformation lineSeparatorInfo) {
			super(grammarAccess, hiddenTokenHelper, indentInfo, lineSeparatorInfo);
		}

		public void setLineSeparatorInfo(ILineSeparatorInformation lsi) {
			lineSeparatorInfo = lsi;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected FormattingConfig createFormattingConfig() {
		FormattingConfig cfg = new FormattingConfig3(getGrammarAccess(), getHiddenTokenHelper(), getIndentInfo(),
				getLineSeparatorInfo());
		cfg.setWhitespaceRule(getWSRule());
		return cfg;
	}

	@Override
	protected synchronized FormattingConfig getConfig() {
		FormattingConfig3 config = (FormattingConfig3) super.getConfig();
		config.setLineSeparatorInfo(getLineSeparatorInfo());
		return config;
	}

	// The following changes allow newlines when nospace is set

	@Override
	public ITokenStream createFormatterStream(String indent, ITokenStream out, boolean preserveWhitespaces) {
		return new Aadl2FormatterTokenStream(out, indent, getConfig(), createMatcher(), getHiddenTokenHelper(),
				preserveWhitespaces);
	}

	@Override
	public ITokenStream createFormatterStream(EObject context, String indent, ITokenStream out,
			boolean preserveWhitespaces) {
		super.createFormatterStream(context, indent, out, preserveWhitespaces);
		return new Aadl2FormatterTokenStream(out, indent, getConfig(), createMatcher(), getHiddenTokenHelper(),
				preserveWhitespaces);
	}

	private static class Aadl2FormatterTokenStream extends FormattingConfigBasedStream {

		protected class MyLine extends FormattingConfigBasedStream.Line {
			protected MyLine(List<LineEntry> initialEntries, int leftover) {
				super(initialEntries, leftover);
			}

			@Override
			public String getSpacesStr(LineEntry e, boolean isLineStart) {
				MyLineEntry entry = (MyLineEntry) e;
				if (preserveSpaces && entry.getLeadingWS() != null) {
					return entry.getLeadingWS();
				}
				if (entry.getLeadingLocators() == null) {
					return null;
				}

				int def = isLineStart && startWithNL && leftover <= 0 ? 1 : 0, min = def, max = def;
				boolean noWrap = false;
				for (ElementLocator leadingLocator : entry.getLeadingLocators()) {
					if (leadingLocator instanceof LinewrapLocator) {
						LinewrapLocator l = (LinewrapLocator) leadingLocator;
						min = Math.max(min, l.getMinWrap());
						def = Math.max(def, l.getDefaultWrap());
						max = Math.max(max, l.getMaxWrap());
						if (l.getMaxWrap() == 0) {
							noWrap = true;
						}
					}
				}
				String space = null;
				for (ElementLocator leadingLocator : entry.getLeadingLocators()) {
					if (leadingLocator instanceof SpaceLocator) {
						String s = ((SpaceLocator) leadingLocator).getSpace();
						if (space == null || s.length() > space.length()) {
							space = s;
						}
					}
				}
				if ((noWrap || (min == 0 && !isLineStart)) && space != null) {
					return space;
				}
				if (!noWrap) {
					if (min != max) {
						int existing = entry.countExistingLeadingNewlines();
						if (existing >= 0) {
							def = existing;
						}
					}
					def = Math.max(min, Math.min(def, max));
					if (def > 0) {
						return wrap(def, indent);
					} else if (isLineStart && indent.length() > 0) {
						return indent;
					}
				}
				return isLineStart && !startWithNL ? null : " ";
			}

		}

		protected class MyLineEntry extends FormattingConfigBasedStream.LineEntry {
			public MyLineEntry(EObject grammarElement, String value, boolean isHidden,
					Set<ElementLocator> beforeLocators, String leadingWS, int indent, ParserRule hiddenTokenDefition) {
				super(grammarElement, value, isHidden, beforeLocators, leadingWS, indent, hiddenTokenDefition);
			}

			@Override
			protected boolean isBreakable() {
				if (leadingLocators == null) {
					return false;
				}
				for (ElementLocator e : leadingLocators) {
					if (e instanceof LinewrapLocator && ((LinewrapLocator) e).getMaxWrap() == 0) {
						return false;
					}
				}
				return hiddenTokenHelper.getWhitespaceRuleFor(hiddenTokenDefinition, getLineSeparator()) != null;
			}

			protected String getLeadingWS() {
				return leadingWS;
			}

			protected Set<ElementLocator> getLeadingLocators() {
				return leadingLocators;
			}

			@Override
			protected int countExistingLeadingNewlines() {
				return super.countExistingLeadingNewlines();
			}
		}

		public Aadl2FormatterTokenStream(ITokenStream out, String indentation, FormattingConfig cfg,
				IElementMatcher<ElementPattern> matcher, IHiddenTokenHelper hiddenTokenHelper, boolean preserveSpaces) {
			super(out, indentation, cfg, matcher, hiddenTokenHelper, preserveSpaces);
		}

		@Override
		protected MyLine createLine(List<LineEntry> initialEntries, int leftover) {
			return new MyLine(initialEntries, leftover);
		}

		@Override
		public MyLineEntry createLineEntry(EObject grammarElement, String value, boolean isHidden,
				Set<ElementLocator> beforeLocators, String leadingWS, int indent, ParserRule hiddenTokenDefition) {
			return new MyLineEntry(grammarElement, value, isHidden, beforeLocators, leadingWS, indent,
					hiddenTokenDefition);
		}

		// potential fix for comment indentations
//		private EObject previous = null;
//
//		@Override
//		public void writeSemantic(EObject grammarElement, String value) throws IOException {
//			previous = grammarElement;
//			super.writeSemantic(grammarElement, value);
//		}
//
//		@Override
//		public void writeHidden(EObject grammarElement, String value) throws IOException {
//			String newValue = value;
//
//			if (grammarElement instanceof TerminalRule) {
//				if ("SL_COMMENT".equals(((TerminalRule) grammarElement).getName())) {
//					if (previous instanceof Keyword) {
//						if ("{".equals(((Keyword) previous).getValue())) {
//							newValue = "\t" + value;
//						}
//					}
//				}
//				if ("ML_COMMENT".equals(((TerminalRule) grammarElement).getName())) {
//					StringBuilder sb = new StringBuilder();
//					sb.append("\r\n\r\n");
//					for (int i = 0; i < indentationLevel; i++) {
//						sb.append("\t");
//					}
//
//					if (previous instanceof Keyword) {
//						if ("{".equals(((Keyword) previous).getValue())) {
//							sb.append("\t");
//						}
//					}
//					sb.append(value).append("\r\n");
//					newValue = sb.toString();
//				}
//			}
//			super.writeHidden(grammarElement, newValue);
//		}
//
//		@Override
//		public void flush() throws IOException {
//			super.flush();
//		}
	};

}
