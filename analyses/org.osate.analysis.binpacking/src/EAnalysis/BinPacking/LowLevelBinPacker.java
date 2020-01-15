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
package EAnalysis.BinPacking;

import java.util.TreeSet;

/**
 * @author Dionisio de Niz
 * 
 * This interface is the base class for low level bin packers. This class of
 * algorithms is designed to be used with a high level bin packers.
 *  
 */

public interface LowLevelBinPacker {
	/**
	 * @param softwareGraph
	 *            is the subset of software nodes that do not conflict with each
	 *            other and that must be deployed.
	 * 
	 * @param validProcesors
	 *            this is the set of current processors to which there is no
	 *            conflict with the software modules
	 * 
	 * @param problem
	 *            contains both the connectivity for the softwareGraph and the
	 *            hardware architecture over which the software is to be
	 *            deployed. This hardware can be expanded.
	 *  
	 */
	public boolean solve(TreeSet softwareGraph, TreeSet validProcessors, OutDegreeAssignmentProblem problem);

	/**
	 * Set the nominal size of the bins to check whether an breakable object
	 * would be part of an excess bin (Bin allocated in excess of the optimal)
	 * or not.
	 */
	public void setNominalBinSize(double d);

	/**
	 * Instructs the bin packer to avoid breaking objects that would not go into
	 * the excess bins.
	 */
	public void setBreakExcessBinObjectsOnly(boolean b);
}