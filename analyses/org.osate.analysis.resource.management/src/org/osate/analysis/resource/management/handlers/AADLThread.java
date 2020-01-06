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
package org.osate.analysis.resource.management.handlers;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import EAnalysis.BinPacking.SoftwareNode;

/**
 * SoftwareNode representing an AADL thread instance. Instances are created
 * using the <code>static</code> factory method
 * {@link #createInstance(ComponentInstance)}.
 *
 * @author aarong
 */
public final class AADLThread extends SoftwareNode {
	public static final long DEFAULT_PERIOD_NANOSECOND = 1L;

	// cycles: cycles per dispatch
	private AADLThread(final ComponentInstance thr, final long cycles, final long period, final long deadline) {
		super(cycles, period, deadline, thr.getName());
		setSemanticObject(thr);
	}

	public static AADLThread createInstance(final ComponentInstance thread) {
		final long period = (long) GetProperties.getPeriodinNS(thread);

		long deadline;
		long cycles = 0;
		try {
			deadline = (long) GetProperties.getDeadlineinNS(thread);
		} catch (PropertyNotPresentException e) {
			deadline = 0;
		}

//		double instructionsperdispatch = GetProperties.getSpecifiedThreadInstructionsinIPD(thread);
//		if (instructionsperdispatch == 0){
//			double mips = GetProperties.getThreadExecutioninMIPS(thread);
//			 if (mips == 0){
//				 mips = GetProperties.getMIPSBudgetInMIPS(thread);
//			 }
//			if (mips > 0){
//				// mips per sec, period in ns. cycles per period => mips / # dispatches * M
//				cycles = (long) (mips * period /1000);
//			}
//		} else {
//			cycles = (long) instructionsperdispatch ;
//		}

		cycles = (long) GetProperties.getThreadExecutionInCycles(thread, Binpack.defaultMIPS);

		return new AADLThread(thread, cycles, period, deadline);
	}

	/** Get the AADL thread component instance represented by this object. */
	public ComponentInstance getThread() {
		return (ComponentInstance) getSemanticObject();
	}

	public String getReport() {
		return "Thread " + this.name + " instructions " + this.cycles + " instr per sec " + this.cyclesPerSecond
				+ " Period " + this.period + " Deadline " + this.deadline;
	}

}