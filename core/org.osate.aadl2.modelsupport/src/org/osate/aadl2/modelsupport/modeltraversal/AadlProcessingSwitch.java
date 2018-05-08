/*
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
 * @version $Id: AadlProcessingSwitch.java,v 1.3 2009-05-01 18:05:22 jseibel Exp $
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
	public static final String copyright = "Copyright 2004-2013 by Carnegie Mellon University, all rights reserved";

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