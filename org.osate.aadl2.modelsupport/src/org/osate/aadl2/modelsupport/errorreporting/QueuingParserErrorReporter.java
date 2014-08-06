/**
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
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
 * </copyright>
 */
package org.osate.aadl2.modelsupport.errorreporting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that reports
 * errors by storing them in a queue that can be retreived by calling
 * {@link #getErrors}.
 *
 * <p>Messages are stored as {@link QueuingParserErrorReporter.Message} objects.
 *
 * @author aarong
 */
public final class QueuingParserErrorReporter extends AbstractParseErrorReporter {
	public static final String ERROR = "Error";
	public static final String WARNING = "Warning";
	public static final String INFO = "INFO";

	/** Singleton factory reference. */
	public static final Factory factory = new Factory();

	/** The list of messages */
	private final List<Message> queue;

	public QueuingParserErrorReporter() {
		super();
		queue = new LinkedList<Message>();
	}

	private void queueMessage(final String fname, final int line, final String kind, final String message) {
		queue.add(new Message(fname, line, kind, message));
	}

	@Override
	protected void errorImpl(final String filename, final int line, final String message) {
		queueMessage(filename, line, ERROR, message);
	}

	@Override
	protected void warningImpl(final String filename, final int line, final String message) {
		queueMessage(filename, line, WARNING, message);
	}

	@Override
	protected void infoImpl(final String filename, final int line, final String message) {
		queueMessage(filename, line, INFO, message);
	}

	@Override
	protected void deleteMessagesImpl() {
		queue.clear();
	}

	/**
	 * Get the errors.
	 * @return A List of {@link QueuingParserErrorReporter.Message} objects.
	 */
	public List<Message> getErrors() {
		return new ArrayList<Message>(queue);
	}

	private static final class Factory implements ParseErrorReporterFactory {
		/**
		 * The given AADL IResource is allowed to be <code>null</code>.
		 */
		@Override
		public ParseErrorReporter getReporterFor(final IResource aadlRsrc) {
			return new QueuingParserErrorReporter();
		}

	}

	/**
	 * Record of a reported error message/warning. Contains the
	 * {@link #filename name of the file} in which the message is located, the
	 * {@link #line line number} where the message is located, the
	 * {@link #kind category} of the message, and the
	 * {@link #message message itself}. The category is a string, and the set
	 * of current values is given by
	 * {@link QueuingParserErrorReporter#ERROR},
	 * {@link QueuingParserErrorReporter#WARNING}, and
	 * {@link QueuingParserErrorReporter#INFO}.
	 *
	 * @author aarong
	 */
	public static final class Message {
		public final String filename;
		public final int line;
		public final String kind;
		public final String message;

		public Message(final String fn, final int ln, final String k, final String msg) {
			filename = fn;
			line = ln;
			kind = k;
			message = msg;
		}
	}
}
