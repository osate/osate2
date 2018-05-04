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