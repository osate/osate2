/*
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
 *
 * @version $Id$
 */
package org.osate.aadl2.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;



/**
 * Utility methods for parsing and checking AADL models.
 * 
 * @author aarong
 */
public class AadlParseUtil {
	/* The following contants are related to interpreting AADL
	 * numeric literals.
	 */
	private static final char UNDERLINE = '_';
	private static final char HASHMARK = '#';
	private static final char EXPONENT = 'E';
	private static final char PLUS = '+';
	private static final char MINUS = '-';

	
	
	/**
	 * Get an AADL parser for the given input stream.
	 * 
	 * @param filename
	 *            The name of the file being parsed. This name is used only for
	 *            generating error messages and may be <code>null</code>.
	 * @param inputStream
	 *            The stream to be parsed.
	 * @param parseErrReporter
	 *            The error reporter to use to report scanning and parsing
	 *            errors.
	 * @return A parser for AADL initialized to parse from the given stream.
	 */
	public static Aadl2Parser getAadlParser(
			final String filename, final InputStream inputStream,
			final ParseErrorReporter parseErrReporter) {
		// Create a scanner that reads from the file
		Aadl2Lexer lexer=null;
		try {
			lexer = new Aadl2Lexer(new CaseInsensitiveStringStream(inputStream));
		} catch (IOException e){
			e.printStackTrace();
		}
		return getAadlParserInternal(filename, lexer, parseErrReporter);
	}

	/**
	 * Get an AADL parser for the given reader.
	 * 
	 * @param filename
	 *            The name of the file being parsed. This name is used only for
	 *            generating error messages and may be <code>null</code>.
	 * @param reader
	 *            The reader to be parsed.
	 * @param parseErrReporter
	 *            The error reporter to use to report scanning and parsing
	 *            errors.
	 * @return A parser for AADL initialized to parse from the given stream.
	 */
	
	
//	public static Aadl2Parser getAadlParser(
//			final String filename, final Reader reader,
//			final ParseErrorReporter parseErrReporter) {
//		// Create a scanner that reads from the file
//		final Aadl2Lexer lexer = new Aadl2Lexer(reader);
//		return getAadlParserInternal(filename, lexer, parseErrReporter);
//	}

	/**
	 * Get an AADL parser for the given lexer. This method is just a helper
	 * method to abstract the common functionality of the various
	 * <code>getAadlParser</code> methods.
	 * 
	 * @param filename
	 *            The name of the file being parsed. This name is used only for
	 *            generating error messages and may be <code>null</code>.
	 * @param lexer
	 *            The lexer object to use.
	 * @param parseErrReporter
	 *            The error reporter to use to report scanning and parsing
	 *            errors.
	 * @return A parser for AADL initialized to parse from the given lexer.
	 */
	private static Aadl2Parser getAadlParserInternal(
			final String filename, final Aadl2Lexer lexer,
			final ParseErrorReporter parseErrReporter) {
		lexer.setFilename(filename);
		lexer.setParseErrorReporter(parseErrReporter);
		final SplitStreamFilter filter = new SplitStreamFilter(new CommonTokenStream(lexer));
// TODO support for multiline comments		filter.splitOut(AadlParser.ML_COMMENT);
		filter.splitOut(Aadl2Parser.SL_COMMENT);

		// Create a parser that reads from the scanner
		//final Aadl2Parser parser = new Aadl2Parser(filter);
		MultiChannelTokenStream lexerFilter = new MultiChannelTokenStream(lexer);
		final Aadl2Parser parser = new Aadl2Parser(lexerFilter);
		parser.setFilename(filename);
		parser.setParseErrorReporter(parseErrReporter);
		parser.setFilter(filter);

		return parser;
	}
	
	// ------------------------------------------------------------------------
	// -- Helper methods for resolving, checking models
	// --
	// -- These methods standardize the name resolving/sanity checking/semantic
	// -- checking processes.
	// ------------------------------------------------------------------------
	
	/**
	 * Get the set of name resolution analyses.  To be used with
	 * {@link ForAllAObject#processResources(Set, ForAllAObject[], Set)}
	 * or {@link ForAllAObject#processTree(edu.cmu.sei.aadl.model.core.AObject, ForAllAObject[])}.
	 */
//	public static ForAllElement[] getNameResolvers(
//			final AnalysisErrorReporterManager errManager) {
//		return new ForAllElement[] {
//				new NameResolverPass1(errManager),
//				new NameResolverPass2(errManager),
//				new NameResolverPass3(errManager),
//				new NameResolverPass4(errManager),
//				new AadlUniqueNamesSwitch(errManager),
//				new AadlNumericResolver(errManager) };
//	}
	
	/**
	 * Get the set of model reference checkers.  To be used with
	 * {@link ForAllAObject#processResources(Set, ForAllAObject[], Set)}
	 * or {@link ForAllAObject#processTree(edu.cmu.sei.aadl.model.core.AObject, ForAllAObject[])}.
	 */
//	public static ForAllAObject[] getReferenceCheckers(
//			final AnalysisErrorReporterManager errManager) {
//		return new ForAllAObject[] {
//				new AadlModelSanityChecker(errManager),
//				new AadlUniqueNamesSwitch(errManager) };
//	}
	
	/**
	 * Get the set of semantic checking analyses.  To be used with
	 * {@link ForAllAObject#processResourcesIgnoreFailure(Set, ForAllAObject[], Set)}
	 * or {@link ForAllAObject#processTreeIgnoreFailure(edu.cmu.sei.aadl.model.core.AObject, ForAllAObject[])}.
	 */
	public static ForAllElement[] getSemanticCheckers(
			final AnalysisErrorReporterManager errManager) {
		return new ForAllElement[] {
				new AadlSemanticCheckSwitch(errManager)//,
//				new AadlPropertyCheckSwitch(errManager)
				};
	}
	
	
	
	/**
	 * Resolve references in newly parsed models. This is achieved by applying
	 * the following analyses in order:
	 * <ol>
	 * <li>Name resolver pass 1
	 * <li>Name resolver pass 2
	 * <li>Name resolver pass 3
	 * <li>Unique name checker
	 * <li>Numeric resolver
	 * </ol>
	 * 
	 * <p>
	 * If a resource has errors from pass N, it is not processed on passes > N.
	 * 
	 * @param inputResourceSet
	 *            The Set of Resources to resolve. The resources are assumed to
	 *            be AADL Object models. Furthermore, they are assumed to be
	 *            newly parsed models.
	 * @param errManager The error manager to use.
	 * @param outputBad
	 *            Set that is modified by the method to include all elements of
	 *            <code>inputResourceSet</code> that fail name resolution
	 * @return An unmodifiable set of resources that do not have resolution
	 *         errors.
	 */
	public static /*Set<Resource>*/void resolveParsedModels(final Set<? extends Resource> inputResourceSet,
			final Set<? extends ReferenceRecord> references,
			final AnalysisErrorReporterManager errManager,
			final Set<? super Resource> outputBad) {
		//Models cannot fail the AadlPackageReferenceSwitch.
		ForAllElement.processResources(inputResourceSet,
				new ForAllElement[]{new AadlPackageReferenceSwitch(errManager)}, outputBad);
		new NameResolver(references, errManager).process();
	}

	/**
	 * Check the references in of a set of AADL model resources. This consists
	 * of using
	 * <ol>
	 * <li>AADL Santiy Check switch
	 * <li>Unique names checker
	 * </ol>
	 * 
	 * <p>
	 * If a resource has errors from pass N, it is not processed on passes > N.
	 * 
	 * <p>
	 * This method is meant to be used on object models that were created with
	 * an object editor or that were imported from unknown sources. It is not
	 * necessary&mdash;although it is not harmful&mdash;to run this on models
	 * that were parsed and that passed
	 * {@link #resolveParsedModels(Set, AnalysisErrorReporterManager, Set)}.
	 * 
	 * @param inputResourceSet
	 *            The Set of Resources to resolve. The resources are assumed to
	 *            be AADL Object models.
	 * @param errManager
	 *            The error manager to use.
	 * @param outputBad
	 *            Set that is modified by the method to include all elements of
	 *            <code>inputResourceSet</code> that fail reference checking.
	 * @return An unmodifiable set of resources that do not have reference
	 *         errors.
	 */
	public static Set checkModelReferences(final Set inputResourceSet,
			final AnalysisErrorReporterManager errManager,
			final Set outputBad) {
		return Collections.EMPTY_SET;
		
//		return ForAllAObject.processResources(inputResourceSet, 
//				getReferenceCheckers(errManager), outputBad);
	}

	/**
	 * Check the semantics of a set of resources.  This consists of using
	 * <ol>
	 * <li>AADL Semantic check switch
	 * <li>AADL Property check switch
	 * </ol>
	 * 
	 * <p>Unlike {@link #resolveParsedModels(Set, AnalysisErrorReporterManager, Set)},
	 * all the analyses are run on all the given resources even if the an earlier
	 * analysis reports errors.
	 * 
	 * @param inputResourceSet
	 *            The Set of Resources to resolve. The resources are assumed to
	 *            be AADL Object models.  It is assumed each model has passed
	 *            either {@link #resolveParsedModels(Set, AnalysisErrorReporterManager, Set)}
	 *            or {@link #checkModelReferences(Set, AnalysisErrorReporterManager, Set)}.
	 * @param errManager The error manager to use.
	 * @param outputBad
	 *            Set that is modified by the method to include all elements of
	 *            <code>inputResourceSet</code> that fail semantic checking.
	 * @return An unmodifiable set of resources that do not have semantic errors.
	 */
	public static Set<Resource> checkModelSemantics(final Set<? extends Resource> inputResourceSet,
			final AnalysisErrorReporterManager errManager,
			final Set<? super Resource> outputBad) {
		return ForAllElement.processResourcesIgnoreFailure(
				inputResourceSet, getSemanticCheckers(errManager), outputBad);
	}

	

	// ------------------------------------------------------------------------
	// -- Helper methods for parsing AADL numeric values
	// ------------------------------------------------------------------------
	
	/**
	 * Parse a string representation of an aadlinteger.
	 * @param stringValue The string to parse.
	 * @return An array of length 2: the first element is the base
	 * and the second element is the value.
	 * @exception IllegalArgumentException thrown if there is some kind of 
	 * parsing error.
	 */
	public static long[] parseAadlInteger(final String stringValue) {
		/* First remove '_', convert to upper case, get as char[]. We assume
		 * the result still has at least one 1 character in it. (Should have
		 * at least one digit in it and have no '.' in it; otherwise the
		 * parser/lexer failed us).
		 */
		final char[] valueAsChars = normalizeValue(stringValue);

		// Get the sign
		int currentIdx = 0;
		final boolean isNegative;
		if (valueAsChars[0] == PLUS) {
			isNegative = false;
			currentIdx = 1;
		} else if (valueAsChars[0] == MINUS) {
			isNegative = true;
			currentIdx = 1;
		} else {
			isNegative = false;
		}
		
		// Process as base 10 until we hit end of string, 'E' or '#'
		long value = 0L;
		for (; currentIdx < valueAsChars.length; currentIdx++) {
			final char c = valueAsChars[currentIdx];
			if (c == EXPONENT || c == HASHMARK) {
				break;
			} else if ('0' <= c && c <= '9') {
				value = (value * 10) + Character.digit(c, 10);
				if (value < 0) {
					throw new IllegalArgumentException("Integer value is not representable");
				}
			} else {
				throw new IllegalArgumentException("Unexpected character '" +
						c + "' at string index " + currentIdx);
			}
		}
		
		final int base;
		if (currentIdx == valueAsChars.length)  {
			// Hit end of string, it's a simple decimal integer
			base = 10;
		} else {
			if (valueAsChars[currentIdx] == EXPONENT) {
				// Decimal integer with exponent
				base = 10;
			} else {
				// based_integer
				base = (int) value;
				if (base < 2 || base > 16) { // base is bad
					throw new IllegalArgumentException(
							"Base not between 2 and 16: " + base);
				} else { // base is good
					value = 0L;
					char c = valueAsChars[++currentIdx];
					while (c != HASHMARK) {
						final int digit = Character.digit(c, base);
						if (digit == -1) {
							throw new IllegalArgumentException(
									"'" + c + "' at string index " + currentIdx +
									" is not an extended digit in base " + base);
						} else {
							value = (value * base) + digit;
							if (value < 0) {
								throw new IllegalArgumentException(
										"Integer value is not representable");
							}
						}
						c = valueAsChars[++currentIdx];
					}
					// eat hashmark
					currentIdx += 1;
				}			
			}
			
			// eat the 'e'; based integers don't have to have an exponent
			if (++currentIdx < valueAsChars.length) {
				// deal with sign
				char c = valueAsChars[currentIdx];
				if (c == MINUS) {
					throw new IllegalArgumentException(
							"Integers cannot have a negative exponent");
				} else if (c == PLUS) {
					currentIdx += 1;
				}
				
				int exponent = 0;
				while (currentIdx < valueAsChars.length) {
					c = valueAsChars[currentIdx++];
					if ('0' <= c && c <= '9') {
						exponent = (exponent * 10) + Character.digit(c, 10);
						if (exponent < 0) {
							throw new IllegalArgumentException(
								"Integer value is not representable: cannot represent exponent");
						}
					} else {
						throw new IllegalArgumentException("Unexpected character '" +
								c + "' at string index " + currentIdx);
					}
				}
				
				for (int i = 0; i < exponent; i++) {
					value *= base;
					if (value < 0) {
						throw new IllegalArgumentException(
								"Integer value is not representable");
					}
				}
			}
		}
		
		if (isNegative) value = -value;

		return new long[] { base, value };
	}
	
	/**
	 * Parse a string representation of an aadlreal.
	 * 
	 * @param stringValue
	 *            The real value to resolve.
	 * @return The value
	 * @exception IllegalArgumentException Thrown if the value is not
	 * parsable into an aadlreal value.
	 */
	public static double parseAadlReal(final String stringValue) {
		try {
			return Double.parseDouble(stringValue);
		} catch(final NumberFormatException e) {
			throw new IllegalArgumentException(
					"Couldn't resolve literal: " + e.getMessage());
		}
	}


	/**
	 * Remove the underlines, &ldquo; <code>_</code>,&rdquo; from the numeric
	 * literal and forces letters to be uppercase.
	 * 
	 * @param value
	 *            The string to process
	 * @return The provided string with all the underlines removed, returned as
	 *         a character array.
	 */
	private static char[] normalizeValue(final String value) {
		int nextUnderlineLoc = value.indexOf(UNDERLINE);
		if (nextUnderlineLoc == -1) {
			return value.toUpperCase().toCharArray();
		} else {
			// size of the new string <= size of value
			final StringBuffer working = new StringBuffer(value.length());
			int lastUnderlineLoc = 0;
			// already found the first underscore...
			do {
				working.append(value.substring(lastUnderlineLoc, nextUnderlineLoc).toUpperCase());
				lastUnderlineLoc = nextUnderlineLoc+1;
				nextUnderlineLoc = value.indexOf(UNDERLINE, lastUnderlineLoc);
			} while (nextUnderlineLoc != -1);
			// append the last portion of the string
			working.append(value.substring(lastUnderlineLoc));
			return working.toString().toCharArray();
		}
	}
	
	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentType parent, ComponentType child)
	{
		String parentCategory = parent.getCategory();
		String childCategory = child.getCategory();
		return parentCategory.equals(childCategory) || parentCategory.equals("abstract");
	}
	
	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentImplementation parent, ComponentImplementation child)
	{
		String parentCategory = parent.getCategory();
		String childCategory = child.getCategory();
		return parentCategory.equals(childCategory) || parentCategory.equals("abstract");
	}
}
