/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Carnegie Mellon University - adapted for use in OSATE
 *******************************************************************************/
package org.osate.workspace;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.eclipse.core.runtime.CoreException;

//import edu.cmu.sei.osate.internal.core.AadlModelStatus;

/**
 * A checked exception representing a failure in the Java model. Java model
 * exceptions contain a Java-specific status object describing the cause of the
 * exception.
 * <p>
 * This class is not intended to be subclassed by clients. Instances of this
 * class are automatically created by the Java model when problems arise, so
 * there is generally no need for clients to create instances.
 * </p>
 *
 * @see IAadlModelStatus
 */
public class AadlModelException extends CoreException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CoreException nestedCoreException;

	/**
	 * Creates a Java model exception that wrappers the given
	 * <code>Throwable</code>. The exception contains a Java-specific status
	 * object with severity <code>IStatus.ERROR</code> and the given status
	 * code.
	 *
	 * @param e the <code>Throwable</code>
	 * @param code one of the Java-specific status codes declared in
	 *            <code>IJavaModelStatusConstants</code>
	 * @see IJavaModelStatusConstants
	 * @see org.eclipse.core.runtime.IStatus#ERROR
	 */
	// public AadlModelException(Throwable e, int code) {
	// this(new AadlModelStatus(code, e));
	// }
	/**
	 * Creates a Java model exception for the given <code>CoreException</code>.
	 * Equivalent to
	 * <code>JavaModelException(exception,IJavaModelStatusConstants.CORE_EXCEPTION</code>
	 * .
	 *
	 * @param exception the <code>CoreException</code>
	 */
	public AadlModelException(CoreException exception) {
		super(exception.getStatus());
		nestedCoreException = exception;
	}

	/**
	 * Returns the underlying <code>Throwable</code> that caused the failure.
	 *
	 * @return the wrappered <code>Throwable</code>, or <code>null</code> if the
	 *         direct case of the failure was at the Java model layer
	 */
	public Throwable getException() {
		if (nestedCoreException == null) {
			return getStatus().getException();
		} else {
			return nestedCoreException;
		}
	}

	/**
	 * Returns the Java model status object for this exception. Equivalent to
	 * <code>(IJavaModelStatus) getStatus()</code>.
	 *
	 * @return a status object
	 */
	// public IAadlWorkspaceStatus getJavaModelStatus() {
	// IStatus status = this.getStatus();
	// if (status instanceof IAadlWorkspaceStatus) {
	// return (IAadlWorkspaceStatus)status;
	// } else {
	// // A regular IStatus is created only in the case of a CoreException.
	// // See bug 13492 Should handle JavaModelExceptions that contains
	// CoreException more gracefully
	// return new AadlModelStatus(this.nestedCoreException);
	// }
	// }
	/**
	 * Returns whether this exception indicates that a Java model element does
	 * not exist. Such exceptions have a status with a code of
	 * <code>IJavaModelStatusConstants.ELEMENT_DOES_NOT_EXIST</code>. This is a
	 * convenience method.
	 *
	 * @return <code>true</code> if this exception indicates that a Java model
	 *         element does not exist
	 * @see IAadlWorkspaceStatus#isDoesNotExist()
	 * @see IJavaModelStatusConstants#ELEMENT_DOES_NOT_EXIST
	 */

	// public boolean isDoesNotExist() {
	// IAadlWorkspaceStatus javaModelStatus = getJavaModelStatus();
	// return javaModelStatus != null && javaModelStatus.isDoesNotExist();
	// }
	/**
	 * Prints this exception's stack trace to the given print stream.
	 *
	 * @param output the print stream
	 * @since 3.0
	 */
	@Override
	public void printStackTrace(PrintStream output) {
		synchronized (output) {
			super.printStackTrace(output);
			Throwable throwable = getException();
			if (throwable != null) {
				output.print("Caused by: "); //$NON-NLS-1$
				throwable.printStackTrace(output);
			}
		}
	}

	/**
	 * Prints this exception's stack trace to the given print writer.
	 *
	 * @param output the print writer
	 * @since 3.0
	 */
	@Override
	public void printStackTrace(PrintWriter output) {
		synchronized (output) {
			super.printStackTrace(output);
			Throwable throwable = getException();
			if (throwable != null) {
				output.print("Caused by: "); //$NON-NLS-1$
				throwable.printStackTrace(output);
			}
		}
	}

	/*
	 * Returns a printable representation of this exception suitable for
	 * debugging purposes only.
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Java Model Exception: "); //$NON-NLS-1$
		if (getException() != null) {
			if (getException() instanceof CoreException) {
				CoreException c = (CoreException) getException();
				buffer.append("Core Exception [code "); //$NON-NLS-1$
				buffer.append(c.getStatus().getCode());
				buffer.append("] "); //$NON-NLS-1$
				buffer.append(c.getStatus().getMessage());
			} else {
				buffer.append(getException().toString());
			}
		} else {
			buffer.append(getStatus().toString());
		}
		return buffer.toString();
	}
}