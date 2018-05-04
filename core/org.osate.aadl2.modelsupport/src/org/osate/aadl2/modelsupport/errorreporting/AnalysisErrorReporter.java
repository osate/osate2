/* Created on Sep 14, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

import org.osate.aadl2.Element;

public interface AnalysisErrorReporter extends ErrorReporter {
	/**
	 * Report an error on an Element (AADL object model object). The error may
	 * have additional attributes to be used by the reporter.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 * @param attrs
	 *            attributes of the error to be set
	 * @param values
	 *            the values to set the attributes to.
	 * @exception IllegalArgumentException
	 *                Thrown if
	 *                <code>(attrs == null) || (values == null) || (attrs.length != values.length)</code>.
	 */
	public void error(Element obj, String msg, String[] attrs, Object[] values);

	/**
	 * Report a warning on an Element (AADL object model object). The warning
	 * may have additional attributes to be used by the reporter.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 * @param attrs
	 *            attributes of the error to be set
	 * @param values
	 *            the values to set the attributes to.
	 * @exception IllegalArgumentException
	 *                Thrown if
	 *                <code>(attrs == null) || (values == null) || (attrs.length != values.length)</code>.
	 */
	public void warning(Element obj, String msg, String[] attrs, Object[] values);

	/**
	 * Report an information message on an Element (AADL object model object).
	 * The information may have additional attributes to be used by the reporter.
	 *
	 * @param obj
	 *            the object to which the marker is pointing
	 * @param msg
	 *            the message as string
	 * @param attrs
	 *            attributes of the error to be set
	 * @param values
	 *            the values to set the attributes to.
	 * @exception IllegalArgumentException
	 *                Thrown if
	 *                <code>(attrs == null) || (values == null) || (attrs.length != values.length)</code>.
	 */
	public void info(Element obj, String msg, String[] attrs, Object[] values);
}
