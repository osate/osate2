/*
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
package org.osate.ui.actions;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Element;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

/**
 * Provides common functionality for all analyses.  Provides an error manager
 * and ensures that the public methods are called in the correct order.
 *
 * @author jseibel
 *
 */
public abstract class AbstractAnalysis implements IAnalysis {
	private enum State {
		CREATED, PARAMETER_SET, CONFIGURATOR_KEYS_AND_VALUES_SET, READY_TO_RUN, NOT_READY_TO_RUN, ALREADY_RAN
	}

	private Element parameter = null;

	private State state = State.CREATED;
	private String notReadyToRunReason = "";
	private HashMap<String, String> configuratorKeysAndValues = null;
	private AnalysisErrorReporterManager errManager = null;

	@Override
	public final void setParameter(URI parameterPath, String readablePath) {
		switch (state) {
		case CREATED:
			try {
				EObject parameterAsEObject = OsateResourceUtil.getResourceSet().getEObject(parameterPath, true);
				if (parameterAsEObject instanceof Element) {
					parameter = (Element) parameterAsEObject;
				} else {
					notReadyToRunReason = "The Parameter \"" + readablePath + "\" cannot be found.";
				}
			} catch (WrappedException e) {
				notReadyToRunReason = "The Parameter \"" + readablePath + "\" cannot be found.";
			}
			state = State.PARAMETER_SET;
			break;
		case PARAMETER_SET:
			throw new IllegalStateException("Parameter already set.");
		case CONFIGURATOR_KEYS_AND_VALUES_SET:
			throw new IllegalStateException("Configurator keys and values already set.");
		case READY_TO_RUN:
		case NOT_READY_TO_RUN:
			throw new IllegalStateException("readyToRun() already called.");
		case ALREADY_RAN:
			throw new IllegalStateException("Already ran.");
		default:
			throw new AssertionError("Unknown enum constant: " + state.name());
		}
	}

	@Override
	public final void setConfiguratorKeysAndValues(HashMap<String, String> keysAndValues) {
		switch (state) {
		case CREATED:
			throw new IllegalStateException("Parameter not set.");
		case PARAMETER_SET:
			configuratorKeysAndValues = keysAndValues;
			state = State.CONFIGURATOR_KEYS_AND_VALUES_SET;
			break;
		case CONFIGURATOR_KEYS_AND_VALUES_SET:
			throw new IllegalStateException("Configurator keys and values already set.");
		case READY_TO_RUN:
		case NOT_READY_TO_RUN:
			throw new IllegalStateException("readyToRun() already called.");
		case ALREADY_RAN:
			throw new IllegalStateException("Already ran.");
		default:
			throw new AssertionError("Unknown enum constant: " + state.name());
		}
	}

	@Override
	public final boolean readyToRun() {
		switch (state) {
		case CREATED:
			throw new IllegalStateException("Parameter not set.");
		case PARAMETER_SET:
			throw new IllegalStateException("Configurator keys and values not set.");
		case CONFIGURATOR_KEYS_AND_VALUES_SET:
			if (parameter != null && readyToRunImpl()) {
				state = State.READY_TO_RUN;
				return true;
			} else {
				state = State.NOT_READY_TO_RUN;
				return false;
			}
		case READY_TO_RUN:
		case NOT_READY_TO_RUN:
			throw new IllegalStateException("readyToRun() already called.");
		case ALREADY_RAN:
			throw new IllegalStateException("Already ran.");
		default:
			throw new AssertionError("Unknown enum constant: " + state.name());
		}
	}

	@Override
	public final String getNotReadyToRunReason() {
		switch (state) {
		case CREATED:
			throw new IllegalStateException("Parameter not set.");
		case PARAMETER_SET:
			throw new IllegalStateException("Configurator keys and values not set.");
		case CONFIGURATOR_KEYS_AND_VALUES_SET:
			throw new IllegalStateException("readyToRun() not called.");
		case READY_TO_RUN:
			throw new IllegalStateException("Analysis is ready to run.");
		case NOT_READY_TO_RUN:
			return notReadyToRunReason;
		case ALREADY_RAN:
			throw new IllegalStateException("Already ran.");
		default:
			throw new AssertionError("Unknown enum constant: " + state.name());
		}
	}

	@Override
	public final boolean run() {
		switch (state) {
		case CREATED:
			throw new IllegalStateException("Parameter not set.");
		case PARAMETER_SET:
			throw new IllegalStateException("Configurator keys and values not set.");
		case CONFIGURATOR_KEYS_AND_VALUES_SET:
			throw new IllegalStateException("readyToRun() not called.");
		case READY_TO_RUN:
			errManager = new AnalysisErrorReporterManager(new MarkerAnalysisErrorReporter.Factory(getMarkerType()));
			state = State.ALREADY_RAN;
			return runImpl();
		case NOT_READY_TO_RUN:
			throw new IllegalStateException("Not ready to run.");
		case ALREADY_RAN:
			throw new IllegalStateException("Already ran.");
		default:
			throw new AssertionError("Unknown enum constant: " + state.name());
		}
	}

	protected String getMarkerType() {
		return AadlConstants.AADLOBJECTMARKER;
	}

	/**
	 * Returns an error manager that should be used by the analysis.  There is
	 * one error manager instance per analysis instance.  The error manager is
	 * created in the <code>run()</code> method before it calls
	 * <code>runImpl()</code>.
	 *
	 * @return The error manager for this analysis.
	 */
	protected final AnalysisErrorReporterManager getErrorManager() {
		return errManager;
	}

	/**
	 * If <code>readyToRunImpl()</code> determines that the analysis cannot
	 * run, the reason should be reported to this method.
	 *
	 * @param reason A human readable description of why the analysis cannot
	 * 		  run.
	 */
	protected final void setNotReadyToRunReason(String reason) {
		notReadyToRunReason = reason;
	}

	protected final Element getParameter() {
		return parameter;
	}

	protected final String getConfiguratorValue(String key) {
		return configuratorKeysAndValues.get(key);
	}

	/**
	 * Sets the <code>notReadyToRunReason</code> to the message that the
	 * specified <code>PropertyDefinition</code> could not be found.
	 *
	 * @param propertySet <code>PropertySet</code> that the
	 * 					  <code>PropertyDefinition</code> was expected to be
	 * 					  in.
	 * @param propertyDefinition <code>PropertyDefinition</code> that could not
	 * 							 be found.
	 */
	protected final void propertyDefinitionNotFound(String propertySet, String propertyDefinition) {
		setNotReadyToRunReason("Property Definition \"" + propertySet + "::" + propertyDefinition + "\" not found.");
	}

	/**
	 * Sets the <code>notReadyToRunReason</code> to the message that the
	 * specified <code>UnitsType</code> could not be found.
	 *
	 * @param propertySet <code>PropertySet</code> that the
	 * 					  <code>UnitsType</code> was expected to be in.
	 * @param unitsType <code>UnitsType</code> that could not be found.
	 */
	protected final void unitsTypeNotFound(String propertySet, String unitsType) {
		setNotReadyToRunReason("Units Type \"" + propertySet + "::" + unitsType + "\" not found.");
	}

	/**
	 * Sets the <code>notReadyToRunReason</code> to the message that the
	 * specified <code>UnitLiteral</code> could not be found.
	 *
	 * @param unitLiteral <code>UnitLiteral</code> that could not be found.
	 * @param unitsType <code>UnitsType</code> that the
	 * 					<code>UnitLiteral</code> was expected to be in.
	 */
	protected final void unitLiteralNotFound(String unitLiteral, UnitsType unitsType) {
		setNotReadyToRunReason("Unit Literal \"" + unitLiteral + "\" not found in Units Type \""
				+ unitsType.getNamespace().getName() + "::" + unitsType.getName() + "\".");
	}

	/**
	 * <code>readyToRun()</code> will call this method.  All the checks to
	 * ensure that <code>readyToRun()</code> is called in the correct order are
	 * handled by <code>readyToRun()</code>.  <code>readyToRunImpl()</code> is
	 * only called in the appropriate state.  In other words, don't worry about
	 * checking the state when overriding <code>readyToRunImpl()</code>.  The
	 * return value of <code>readyToRunImpl()</code> will be the return value
	 * of <code>readyToRun()</code>.
	 *
	 * @return <code>true</code> if the <code>run()</code> method can be
	 * 		   called; <code>false</code> if it cannot.
	 */
	protected abstract boolean readyToRunImpl();

	/**
	 * <code>run()</code> will call this method.  All the checks to ensure that
	 * <code>run()</code> is called in the correct order are handled by
	 * <code>run()</code>.  <code>runImpl()</code> is only called in the
	 * appropriate state.  In other words, don't worry about checking the state
	 * when overriding <code>runImpl()</code>.  The return value of
	 * <code>runImpl()</code> will be the return value of <code>run()</code>.
	 *
	 * @return <code>true</code> if the analysis passed; <code>false</code> if
	 * 		   it failed.
	 */
	protected abstract boolean runImpl();
}