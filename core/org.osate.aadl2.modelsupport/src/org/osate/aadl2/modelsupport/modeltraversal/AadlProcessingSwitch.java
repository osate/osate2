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
package org.osate.aadl2.modelsupport.modeltraversal;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.util.Aadl2Switch;

/**
 * This class implements the traversal over an AADL model and the invoaction of
 * a case method for each of the classes in the AADL Meta model based on the EMF generated doSwitch.
 * It handles the fact that the AADL Meta model consists of multiple Meta model packages, thus, multiple switches
 * @author phf
 *
 */
public abstract class AadlProcessingSwitch extends ForAllElement {

	public static final String DONE = AadlConstants.emptyString;

	public static final String NOT_DONE = null;

	public static AadlProcessingSwitch INSTANCE = new AadlProcessingSwitch(false) {
		@Override
		protected final void initSwitches() {
			// do nothing
		}
	};

	/* here we are creating the various meta model package switches */

	protected Aadl2Switch<String> aadl2Switch = new Aadl2Switch<String>();

	protected InstanceSwitch<String> instanceSwitch = new InstanceSwitch<String>();

	// Constructors

	public AadlProcessingSwitch(final int defTraversal, final AnalysisErrorReporterManager errMgr) {
		super(defTraversal, errMgr);
		// Create the switches
		initSwitches();
	}

	public AadlProcessingSwitch(final int defTraversal) {
		this(defTraversal, AnalysisErrorReporterManager.NULL_ERROR_MANANGER);
	}

	/**
	 * Create an Aadl switch that delages to the given error manager.
	 */
	public AadlProcessingSwitch(final AnalysisErrorReporterManager errMgr) {
		this(DEFAULT_DEFAULT_TRAVERSAL, errMgr);
	}

	/**
	 * Create an Aadl switch that uses
	 * {@link AnalysisErrorReporterManager#NULL_ERROR_MANANGER}.
	 */
	public AadlProcessingSwitch() {
		this(AnalysisErrorReporterManager.NULL_ERROR_MANANGER);
	}

	/**
	 * Private constructor to create the prototype {@link #INSTANCE}. This
	 * special version does not invoke initSelfReference() because to do so can
	 * cause a loop in the class initialization sequence if one of the switch
	 * classes is loaded first. This results in a null pointer exception being
	 * thrown from initSelfReference because the field of the loaded switch
	 * class ends up being <code>null</code>. The initialization is instead
	 * performed by the process() method which checks to see if {@link #self}is
	 * <code>null</code>.
	 *
	 * @param flag
	 *                 Useless parameter used to distinguish this constructor from
	 *                 the public one.
	 */
	private AadlProcessingSwitch(final boolean flag) {
		// Do nothing
	}

	/**
	 * Subclasses override this method to set the switch fields
	 * {@link #coreSwitch},{@link #componentSwitch},
	 * {@link #connectionSwitch},{@link #featureSwitch},{@link #flowSwitch},
	 * {@link #instanceSwitch}, and {@link #propertySwitch}to
	 * analysis-specific switch implementations. Implementaions should take
	 * care, however, as this method is invoked by the constructor
	 * {@link #AadlProcessingSwitch()}. Only the switches that are actually
	 * needed need to be initialized, as the switch fields are previously
	 * inialized to default do-nothing switch implementations.
	 */
	protected abstract void initSwitches();

	/**
	 * get Aadl2Switch
	 *
	 * @return Aadl2Switch
	 */

	public final Aadl2Switch<String> getAadl2Switch() {
		return aadl2Switch;
	}

	/**
	 * get InstanceSwitch
	 *
	 * @return InstanceSwitch
	 */
	public final InstanceSwitch<String> getInstanceSwitch() {
		return instanceSwitch;
	}

	/**
	 * Calls the package-specific switch
	 */
	@Override
	public final void process(final Element theElement) {
		final EClass theEClass;
		/**
		 * This checks to make sure we only invoke doSwitch with non-null
		 * objects This is necessary as some feature retrieval methods may
		 * return null
		 */
		if (theElement == null) {
			return;
		}
		theEClass = theElement.eClass();
		if (aadl2Switch != null && (theEClass.eContainer() == Aadl2Package.eINSTANCE
				|| theElement instanceof AnnexLibrary || theElement instanceof AnnexSubclause)) {
			aadl2Switch.doSwitch(theElement);
		} else if (instanceSwitch != null && theEClass.eContainer() == InstancePackage.eINSTANCE) {
			instanceSwitch.doSwitch(theElement);
		}
	}
}