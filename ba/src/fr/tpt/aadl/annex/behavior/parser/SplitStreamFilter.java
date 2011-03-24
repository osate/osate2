/*
 * Created on Mar 20, 2004
 *
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
 * @version $Id: SplitStreamFilter.java,v 1.3 2007-12-11 15:36:37 dionisio_deniz Exp $
 */
package fr.tpt.aadl.annex.behavior.parser;

/**
 * @author phf
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
import java.util.Vector;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

/** This object is a TokenStream that passes through all
 *  tokens except for those that you tell it to split out.
 *  The split otu tokens are kept in a Vector until retrieved
 */
public class SplitStreamFilter extends CommonTokenStream {
	/** The set of token types to discard */
	protected BitSet splitoutMask;

	/** The input stream */
	protected TokenStream input;

	/** The comment buffer */
	protected Vector<Token> comments;

	public SplitStreamFilter(TokenStream input) {
		this.input = input;
		splitoutMask = new BitSet();
		comments = new Vector<Token>();
	}

	public void splitOut(int ttype) {
		splitoutMask.add(ttype);
	}

	public void SplitOut(BitSet mask) {
		splitoutMask = mask;
	}

	public Token LT(int i) { //throws TokenStreamException {
		Token tok = input.LT(i);
//		if (i>0){
//			while (tok != null && splitoutMask.member(tok.getType())) {
//				if (!comments.contains(tok))
//					comments.add(tok);
//				tok = input.LT(i+1);
//			}
//		}
			
		return tok;
	}

	/**
	 * returns the Vector of tokens that got split out
	 * @return
	 */
	public Vector<Token> getSplitTokens() {
		Vector<Token> v = this.comments;
		this.comments = new Vector<Token>();
		return v;
	}
}