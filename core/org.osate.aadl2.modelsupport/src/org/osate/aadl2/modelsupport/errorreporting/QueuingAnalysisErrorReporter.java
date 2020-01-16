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
package org.osate.aadl2.modelsupport.errorreporting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that reports
 * errors by storing them in a queue that can be retreived by calling
 * {@link #getErrors}.
 *
 * <p>Messages are stored as {@link QueuingAnalysisErrorReporter.Message} objects.
 *
 * @author aarong
 */
public final class QueuingAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	public static final String ERROR = "Error";
	public static final String WARNING = "Warning";
	public static final String INFO = "INFO";

	/** Singleton factory reference. */
	public static final Factory factory = new Factory();

	/** The list of messages */
	private final List<Message> queue;

	public QueuingAnalysisErrorReporter(final Resource rsrc) {
		super(rsrc);
		queue = new LinkedList<Message>();
	}

	private void queueMessage(final Element where, final String kind, final String message, final String[] attrs,
			final Object[] values) {
		queue.add(new Message(where, kind, message, attrs, values));
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		queueMessage(where, ERROR, message, attrs, values);
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		queueMessage(where, WARNING, message, attrs, values);
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		queueMessage(where, INFO, message, attrs, values);
	}

	@Override
	protected void deleteMessagesImpl() {
		queue.clear();
	}

	/**
	 * Get the errors.
	 * @return A List of {@link QueuingAnalysisErrorReporter.Message} objects.
	 */
	public List<Message> getErrors() {
		return new ArrayList<Message>(queue);
	}

	private static final class Factory implements AnalysisErrorReporterFactory {
		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			return new QueuingAnalysisErrorReporter(rsrc);
		}

	}

	/**
	 * Record of a reported error message/warning. Contains the
	 * {@link #where Element} on which the message is located, the
	 * {@link #kind category} of the message, and the
	 * {@link #message message itself}. The category is a string, and the set
	 * of current values is given by
	 * {@link QueuingAnalysisErrorReporter#ERROR},
	 * {@link QueuingAnalysisErrorReporter#WARNING}, and
	 * {@link QueuingAnalysisErrorReporter#INFO}.
	 *
	 * @author aarong
	 */
	public static final class Message {
		public final Element where;
		public final String kind;
		public final String message;
		public final String[] attributes;
		public final Object[] values;

		public Message(final Element loc, final String k, final String msg, final String[] attrs, final Object[] vals) {
			where = loc;
			kind = k;
			message = msg;
			attributes = attrs;
			values = vals;
		}
	}
}
