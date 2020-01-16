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
package TestBinPacker;

import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import EAnalysis.BinPacking.AssignmentResult;
import EAnalysis.BinPacking.BFCPBinPacker;
import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.CANBus;
import EAnalysis.BinPacking.CapacityComparator;
import EAnalysis.BinPacking.Channel;
import EAnalysis.BinPacking.CompositeMsgNode;
import EAnalysis.BinPacking.CompositeSoftNode;
import EAnalysis.BinPacking.DFBPBinPacker;
import EAnalysis.BinPacking.DFCPBinPacker;
import EAnalysis.BinPacking.DebugMonitor;
import EAnalysis.BinPacking.Disjoint;
import EAnalysis.BinPacking.Duct;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.Expansor;
import EAnalysis.BinPacking.HardwareNode;
import EAnalysis.BinPacking.Joint;
import EAnalysis.BinPacking.Link;
import EAnalysis.BinPacking.Location;
import EAnalysis.BinPacking.LowLevelBinPacker;
import EAnalysis.BinPacking.MPC555;
import EAnalysis.BinPacking.Message;
import EAnalysis.BinPacking.NFCExpansor;
import EAnalysis.BinPacking.NFCHoBinPacker;
import EAnalysis.BinPacking.NetInterface;
import EAnalysis.BinPacking.OutDegreeAssignmentProblem;
import EAnalysis.BinPacking.OutDegreeComparator;
import EAnalysis.BinPacking.ProcessingLoad;
import EAnalysis.BinPacking.Processor;
import EAnalysis.BinPacking.Site;
import EAnalysis.BinPacking.SiteArchitecture;
import EAnalysis.BinPacking.SiteGuest;
import EAnalysis.BinPacking.SoftwareNode;

/**
 * @author Dionisio de Niz
 * 
 * This class generates random: task sets, connectivity, and hardware platform
 * to try to bin pack it.
 */
public class MyBinPackerTester {
	Random randomGenerator;

	public MyBinPackerTester() {
		randomGenerator = new Random();
	}

	/**
	 * This method creates random software nodes (modules) and random messages
	 * among them. The randomness of the parameters of the software nodes are
	 * controlled by ranges of values.
	 * 
	 * @param problem
	 *            The assigment problem to which the software graph will be
	 *            added
	 * @param minimumNumberOfModules
	 *            Minimum number of modules
	 * @param maximumNumberOfModules
	 *            Maximum number of modules
	 * @param minimumCycles
	 *            Minimum value in the range of cycles
	 * @param maximumCycles
	 *            Maximum value in the range of cycles
	 * @param minimumPeriod
	 *            Minimum value in the range of periods in nanos
	 * @param maximumPeriod
	 *            Maximum value in the range of periods in nanos
	 * @param minimumMessageSize
	 *            Minimum value in the range of message size in bits
	 * @param maximumMessageSize
	 *            Maximum value in the range of message size in bits
	 * @param minimumMessagesPerModule
	 *            Minimum number of messages to/from a module
	 * @param maximumMessagesPerModule
	 *            Maximum number of messages to/from a module. This parameter
	 *            only guides the generator since it could generate more than
	 *            the maximum specified
	 */

	public void createSoftwareGraph(OutDegreeAssignmentProblem[] problem, int minimumNumberOfModules,
			int maximumNumberOfModules, long minimumCycles, long maximumCycles, long minimumPeriod, long maximumPeriod,
			long minimumMessageSize, long maximumMessageSize, int minimumMessagesPerModule,
			int maximumMessagesPerModule, double minimumProcessorSpeed) {
		int numberOfModules;

		if ((numberOfModules = maximumNumberOfModules - minimumNumberOfModules) <= 0)
			numberOfModules = maximumNumberOfModules;
		else {
			numberOfModules *= randomGenerator.nextDouble();
			numberOfModules += minimumNumberOfModules;
		}

		SoftwareNode[][] softwareNodes = new SoftwareNode[problem.length][numberOfModules];

		// Generate the modules
		boolean randomCycles = (maximumCycles - minimumCycles > 0);
		boolean randomPeriod = (maximumPeriod - minimumPeriod > 0);

		for (int i = 0; i < numberOfModules; i++) {
			long cycles;
			long period;
			long deadline;

			if (randomPeriod) {
				period = maximumPeriod - minimumPeriod;
				period *= randomGenerator.nextDouble();
				period += minimumPeriod;
			} else {
				period = maximumPeriod;
			}

			double dPeriodSeconds = (period / 1000000000.0);

			/*
			 * avoid having modules that take longer than half the speed of
			 * slowest processor
			 */
			double maxCycles = (minimumProcessorSpeed / dPeriodSeconds) / 2.0;
			long lMaxCycles = (long) maxCycles;
			if (randomCycles) {
				lMaxCycles = (maximumCycles > lMaxCycles) ? lMaxCycles : maximumCycles;
				long cyclesRange = lMaxCycles - minimumCycles;
				cycles = cyclesRange;
				cycles *= randomGenerator.nextDouble();
				cycles += minimumCycles;
			} else {
				cycles = (maximumCycles < lMaxCycles) ? maximumCycles : lMaxCycles;
			}

			// For now the deadline is fixed. Trying to get a deadline lower
			// than the period implies that
			// we know how long takes the module to run which would depend on
			// the speed of the processor.
			// One approach can be to consider the slower processor as the
			// reference
			deadline = period;

			for (int j = 0; j < problem.length; j++) {
				softwareNodes[j][i] = new SoftwareNode(cycles, period, deadline, problem[j].bwComparator,
						Integer.toString(i));
				problem[j].softwareGraph.add(softwareNodes[j][i]);
			}
		}

		// Now create the messages
		for (int i = 0; i < numberOfModules; i++) {
			int numberOfMessages;

			if ((numberOfMessages = maximumMessagesPerModule - minimumMessagesPerModule) <= 0)
				numberOfMessages = maximumMessagesPerModule;
			else {
				numberOfMessages *= randomGenerator.nextDouble();
				numberOfMessages += minimumMessagesPerModule;
			}

			SoftwareNode[] node = new SoftwareNode[problem.length];
			Hashtable[] connByTarget = new Hashtable[problem.length];

			for (int j = 0; j < problem.length; j++) {
				node[j] = softwareNodes[j][i];
				connByTarget[j] = (Hashtable) problem[j].softConnectivityByTarget.get(node[j]);
			}
			for (int j = 0; j < numberOfMessages; j++) {
				long size;

				if ((size = maximumMessageSize - minimumMessageSize) <= 0) {
					size = maximumMessageSize;
				} else {
					size *= randomGenerator.nextDouble();
					size += minimumMessageSize;
				}

				// any other module (except self)
				int partner = numberOfModules - 1;
				partner *= randomGenerator.nextDouble();

				// if self or greater shift one up (avoid self)
				partner += (partner >= i) ? 1 : 0;

				boolean connected = false;
				for (int k = 0; !connected && k < problem.length; k++) {
					SoftwareNode other = softwareNodes[k][partner];

					// avoid two messages to same target
					if (connByTarget[k] != null)
						if (connByTarget[k].get(other) != null) {
							connected = true;
							break;
						}

					Message message = new Message(size, node[k].getPeriod(), node[k].getDeadline(), node[k],
							softwareNodes[k][partner]);
					problem[k].addMessage(message);
					if (connByTarget[k] == null)
						connByTarget[k] = (Hashtable) problem[k].softConnectivityByTarget.get(node[k]);
				}
			}
		}
	}

	public long[] createSoftwareSizesForProcessor(long procSize, long largestSize) {
		Vector vectorSizes = new Vector();
		Vector toSplit = new Vector();
		if (procSize > largestSize)
			toSplit.add(new Long(procSize));
		while (toSplit.size() > 0) {
			long bigSize = ((Long) toSplit.remove(0)).longValue();
			long[] sizes = createSoftwareSizesForProcessor(bigSize);
			for (int i = 0; i < sizes.length; i++) {
				if (sizes[i] > largestSize)
					toSplit.add(new Long(sizes[i]));
				else
					vectorSizes.add(new Long(sizes[i]));
			}
		}
		long[] res = new long[vectorSizes.size()];
		for (int i = 0; i < vectorSizes.size(); i++)
			res[i] = ((Long) vectorSizes.get(i)).longValue();
		return res;
	}

	/**
	 * it would generate < log_2(procSize) different sizes
	 * 
	 * @return the exact number of sizes generated
	 */
	public long[] createSoftwareSizesForProcessor(long procSize) {
		// int [] primes = new int[]{1,3,5,7,11,13,17};
		double percentage[] = new double[] { 0.01, 0.02, 0.03, 0.04, 0.05 };
		long[] moduleSizes = new long[(int) Math.ceil(Math.log(procSize) / Math.log(2))];
		int numSize = 0;
		long nextSize = (procSize / 2);
		long difference = (procSize / 2) - (long) (nextSize * percentage[(int) (4 * randomGenerator.nextDouble())]);
		// primes[(int) (6 * randomGenerator.nextDouble())];
		while (((procSize % difference) == 0) && ((procSize % (nextSize - difference)) == 0))
			difference--;
		moduleSizes[0] = procSize - difference;
		while (difference > 30) {
			long nextDifference = (difference / 2)
					- (long) ((difference / 2) * percentage[(int) (4 * randomGenerator.nextDouble())]);
			// primes[(int) (6 * randomGenerator.nextDouble())];
			while (((procSize % nextDifference) == 0) && ((procSize % (difference - nextDifference)) == 0))
				nextDifference--;
			moduleSizes[++numSize] = difference - nextDifference;
			difference = nextDifference;
		}

		long prevSize = moduleSizes[numSize];
		nextSize = difference;
		while (((procSize % difference) == 0) && ((procSize % prevSize) == 0)) {
			difference--;
			prevSize++;
		}
		moduleSizes[++numSize] = difference;

		long[] result = new long[numSize + 1];
		for (int i = 0; i <= numSize; i++) {
			result[i] = moduleSizes[i];
		}

		return result;
	}

	public long[] createWorstSoftwareSizesForProcessor(long procSize, long epsilon) {
		long[] ret = new long[3];
		ret[0] = (procSize / 2) + epsilon;
		ret[1] = (procSize / 4) + epsilon;
		ret[2] = (procSize - ret[0] - ret[1]);
		return ret;
	}

	public long generateMessageBits(long minimumBits, long maximumBits) {
		long bits = 0;
		if (minimumBits == maximumBits)
			bits = maximumBits;
		else {
			bits = (long) ((maximumBits - minimumBits) * randomGenerator.nextDouble());
			bits += minimumBits;
		}
		return bits;
	}

	public void createWorstFitSoftwareGraph(OutDegreeAssignmentProblem hardwareTemplate,
			OutDegreeAssignmentProblem[] targets, long minimumMessageBits, long maximumMessageBits, long minimumPeriod,
			long maximumPeriod, int outDegree) {
		double bandwidthGenerated = 0.0;
		long procSize = (long) ((HardwareNode) hardwareTemplate.hardwareGraph.iterator().next()).cyclesPerSecond;
		long epsilon = (long) (procSize * 0.01);
		int numberOfProcessors = hardwareTemplate.hardwareGraph.size();

		long[] sizes = createWorstSoftwareSizesForProcessor(procSize, epsilon);
		long[] sizeSet1 = createSoftwareSizesForProcessor(sizes[0]);

		// if ((sizes[0] % 2) == 0)
		// {
		// // even
		// sizeSet1 = new long[]{sizes[0]/2, sizes[0]/2};
		// }
		// else
		// {
		// // odd
		// sizeSet1 = new long[]{sizes[0]/2, (sizes[0]/2)+1};
		// System.out.println(" --- odd division total("+sizes[0]+") =
		// half("+sizeSet1[0]+") + half("+sizeSet1[1]+")");
		// }

		long[] sizeSet2 = createSoftwareSizesForProcessor(sizes[1]);

		// if ((sizes[1] % 2) == 0)
		// {
		// // even
		// sizeSet2 = new long[]{sizes[1]/2, sizes[1]/2};
		// }
		// else
		// {
		// // odd
		// sizeSet2 = new long[]{sizes[1]/2, (sizes[1]/2)+1};
		// System.out.println(" --- odd division total("+sizes[1]+") =
		// half("+sizeSet2[0]+") + half("+sizeSet2[1]+")");
		// }

		long[] sizeSet3 = createSoftwareSizesForProcessor(sizes[2]);

		// if ((sizes[2] % 2) == 0)
		// {
		// // even
		// sizeSet3 = new long[]{sizes[2]/2, sizes[2]/2};
		// }
		// else
		// {
		// // odd
		// sizeSet3 = new long[]{sizes[2]/2, (sizes[2]/2)+1};
		// System.out.println(" --- odd division total("+sizes[2]+") =
		// half("+sizeSet3[0]+") + half("+sizeSet3[1]+")");
		// }

		long[] sizeSet4 = createSoftwareSizesForProcessor(sizes[1] + epsilon);

		// long sz4 = sizes[1] + epsilon;
		// if ((sz4 % 2) == 0)
		// {
		// // even
		// sizeSet4 = new long[]{sz4/2, sz4/2};
		// }
		// else
		// {
		// // odd
		// sizeSet4 = new long[]{sz4/2, (sz4/2)+1};
		// System.out.println(" --- odd division total("+sz4+") =
		// half("+sizeSet4[0]+") + half("+sizeSet4[1]+")");
		// }

		long ss1 = 0;
		long ss2 = 0;
		long ss3 = 0;
		long ss4 = 0;
		for (int i = 0; i < sizeSet1.length; i++)
			ss1 += sizeSet1[i];

		for (int i = 0; i < sizeSet2.length; i++)
			ss2 += sizeSet2[i];

		for (int i = 0; i < sizeSet3.length; i++)
			ss3 += sizeSet3[i];

		for (int i = 0; i < sizeSet4.length; i++)
			ss4 += sizeSet4[i];

		System.out.println("size[0](" + MyBinPackerTester.decFormat.format(sizes[0]) + ") sizeSet1.total("
				+ MyBinPackerTester.decFormat.format(ss1) + ")");
		System.out.println("size[1](" + MyBinPackerTester.decFormat.format(sizes[1]) + ") sizeSet2.total("
				+ MyBinPackerTester.decFormat.format(ss2) + ")");
		System.out.println("size[2](" + MyBinPackerTester.decFormat.format(sizes[2]) + ") sizeSet3.total("
				+ MyBinPackerTester.decFormat.format(ss3) + ")");
		System.out.println("size[3](" + MyBinPackerTester.decFormat.format(sizes[1] + epsilon) + ") sizeSet4.total("
				+ MyBinPackerTester.decFormat.format(ss4) + ")");

		System.out.println("sizes[0+1+2](" + MyBinPackerTester.decFormat.format(sizes[0] + sizes[1] + sizes[2]) + ")");
		System.out.println("sizes[3*2+2*2]("
				+ MyBinPackerTester.decFormat.format((2 * (sizes[1] + epsilon)) + (2 * sizes[2])) + ")");

		int partitionedProcessors = 0;
		long period = 1000000000l;

		System.out.println("Period(" + MyBinPackerTester.decFormat.format(period) + ")ns");
		// Generate three at a time
		for (int i = 0; (i + 3) < numberOfProcessors; i += 3) {
			partitionedProcessors += 3;

			Vector[][] modules = new Vector[targets.length][4];
			for (int j = 0; j < targets.length; j++) {
				modules[j][0] = new Vector();
				modules[j][1] = new Vector();
				modules[j][2] = new Vector();
				modules[j][3] = new Vector();
			}

			/* FIRST PROCESSOR */
			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet1[j];
					SoftwareNode module = new SoftwareNode(sizeSet1[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][0].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = j + 1; k < sizeSet1.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][0].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][0].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet2[j];
					SoftwareNode module = new SoftwareNode(sizeSet2[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][1].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = j + 1; k < sizeSet2.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][1].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][1].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet3[j];
					SoftwareNode module = new SoftwareNode(sizeSet3[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][2].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = j + 1; k < sizeSet3.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][2].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][2].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			/* SECOND PROCESSOR */
			for (int k = 0; k < targets.length; k++)
				modules[k][0].clear();

			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet1[j];
					SoftwareNode module = new SoftwareNode(sizeSet1[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][0].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = j + 1; k < sizeSet1.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][0].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][0].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int k = 0; k < targets.length; k++)
				modules[k][1].clear();

			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet2[j];
					SoftwareNode module = new SoftwareNode(sizeSet2[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][1].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = j + 1; k < sizeSet2.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][1].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][1].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int k = 0; k < targets.length; k++)
				modules[k][2].clear();

			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet3[j];
					SoftwareNode module = new SoftwareNode(sizeSet3[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][2].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = j + 1; k < sizeSet3.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][2].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][2].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			/* THIRD PROCESSOR - COMPLEMENT */

			for (int k = 0; k < targets.length; k++)
				modules[k][3].clear();

			for (int j = 0; j < sizeSet4.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet4[j];
					SoftwareNode module = new SoftwareNode(sizeSet4[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][3].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet4.length; j++) {
				for (int k = j + 1; k < sizeSet4.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][3].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][3].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int k = 0; k < targets.length; k++)
				modules[k][3].clear();

			for (int j = 0; j < sizeSet4.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet4[j];
					SoftwareNode module = new SoftwareNode(sizeSet4[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][3].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet4.length; j++) {
				for (int k = j + 1; k < sizeSet4.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][3].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][3].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int k = 0; k < targets.length; k++)
				modules[k][1].clear();

			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet3[j];
					SoftwareNode module = new SoftwareNode(sizeSet3[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][1].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = j + 1; k < sizeSet3.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][1].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][1].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int k = 0; k < targets.length; k++)
				modules[k][1].clear();

			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet3[j];
					SoftwareNode module = new SoftwareNode(sizeSet3[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][1].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = j + 1; k < sizeSet3.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][1].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][1].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			// for (int j=0; j<targets.length;j++)
			// {
			// SoftwareNode module1 = new SoftwareNode(sizes[0], period, period,
			// targets[0].bwComparator, Integer.toString(i));
			// SoftwareNode module2 = new SoftwareNode(sizes[1], period, period,
			// targets[0].bwComparator, Integer.toString(i+1));
			// SoftwareNode module3 = new SoftwareNode(sizes[2], period, period,
			// targets[0].bwComparator, Integer.toString(i+2));
			// targets[j].addSoftwareNode(module1);
			// modules[j].add(module1);
			// targets[j].addSoftwareNode(module2);
			// modules[j].add(module2);
			// targets[j].addSoftwareNode(module3);
			// modules[j].add(module3);

			// module1 = new SoftwareNode(sizes[0], period, period,
			// targets[0].bwComparator, Integer.toString(i+3));
			// module2 = new SoftwareNode(sizes[1], period, period,
			// targets[0].bwComparator, Integer.toString(i+4));
			// module3 = new SoftwareNode(sizes[2], period, period,
			// targets[0].bwComparator, Integer.toString(i+5));
			// targets[j].addSoftwareNode(module1);
			// modules[j].add(module1);
			// targets[j].addSoftwareNode(module2);
			// modules[j].add(module2);
			// targets[j].addSoftwareNode(module3);
			// modules[j].add(module3);

			// module1 = new SoftwareNode(sizes[1]+epsilon, period, period,
			// targets[0].bwComparator, Integer.toString(i+6));
			// module2 = new SoftwareNode(sizes[1]+epsilon, period, period,
			// targets[0].bwComparator, Integer.toString(i+7));
			// module3 = new SoftwareNode(sizes[2], period, period,
			// targets[0].bwComparator, Integer.toString(i+8));
			// SoftwareNode module4 = new SoftwareNode(sizes[2], period, period,
			// targets[0].bwComparator, Integer.toString(i+8));
			// targets[j].addSoftwareNode(module1);
			// modules[j].add(module1);
			// targets[j].addSoftwareNode(module2);
			// modules[j].add(module2);
			// targets[j].addSoftwareNode(module3);
			// modules[j].add(module3);
			// targets[j].addSoftwareNode(module4);
			// modules[j].add(module4);
			// }
		}

		System.out.println(" --- partitioned processors(" + partitionedProcessors + ") in 3 ");
		// numberOfprocessors % 3 remaining
		for (int i = partitionedProcessors; i < numberOfProcessors; i++) {
			partitionedProcessors++;

			Vector[][] modules = new Vector[targets.length][4];
			for (int j = 0; j < targets.length; j++) {
				modules[j][0] = new Vector();
				modules[j][1] = new Vector();
				modules[j][2] = new Vector();
				modules[j][3] = new Vector();
			}

			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet1[j];
					SoftwareNode module = new SoftwareNode(sizeSet1[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][0].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet1.length; j++) {
				for (int k = j + 1; k < sizeSet1.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][0].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][0].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet2[j];
					SoftwareNode module = new SoftwareNode(sizeSet2[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][1].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet2.length; j++) {
				for (int k = j + 1; k < sizeSet2.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][1].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][1].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = 0; k < targets.length; k++) {
					bandwidthGenerated += sizeSet3[j];
					SoftwareNode module = new SoftwareNode(sizeSet3[j], period, period, targets[0].bwComparator, "");
					targets[k].addSoftwareNode(module);
					modules[k][2].add(module);
				}
			}

			// Generate messages
			for (int j = 0; j < sizeSet3.length; j++) {
				for (int k = j + 1; k < sizeSet3.length; k++) {
					for (int degreeIndex = 0; degreeIndex < outDegree; degreeIndex++)
						for (int l = 0; l < targets.length; l++) {
							long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
							// (long) ((maximumMessageBits - minimumMessageBits)
							// * randomGenerator.nextDouble());
							SoftwareNode module1 = (SoftwareNode) modules[l][2].get(j);
							SoftwareNode module2 = (SoftwareNode) modules[l][2].get(k);
							Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1,
									module2);
							targets[l].addMessage(msg);
						}
				}
			}

			// for (int j=0; j<targets.length;j++)
			// {
			// SoftwareNode module1 = new SoftwareNode(sizes[0], period, period,
			// targets[0].bwComparator, Integer.toString(i));
			// SoftwareNode module2 = new SoftwareNode(sizes[1], period, period,
			// targets[0].bwComparator, Integer.toString(i+1));
			// SoftwareNode module3 = new SoftwareNode(sizes[2], period, period,
			// targets[0].bwComparator, Integer.toString(i+2));
			// targets[j].addSoftwareNode(module1);
			// modules[j].add(module1);
			// targets[j].addSoftwareNode(module2);
			// modules[j].add(module2);
			// targets[j].addSoftwareNode(module3);
			// modules[j].add(module3);
			// }
		}
		System.out.println("--- Total Partitioned Processors(" + partitionedProcessors + ") generated Load("
				+ MyBinPackerTester.decFormat.format(bandwidthGenerated) + ")--- ");
	}

	/**
	 * Generates a software graph that perfectly fits the hardware given in
	 * <code>hardwareTemplate</code>. 
	 * @param hardwareTemplate
	 *            the assignment problem with the hardware graph for which to
	 *            create software graph.
	 * @param target
	 *            Where to put the new software graph
	 */
	public void createPerfectFitSoftwareGraph(OutDegreeAssignmentProblem hardwareTemplate,
			OutDegreeAssignmentProblem target, long minimumMessageBits, long maximumMessageBits, long minimumPeriod,
			long maximumPeriod, int outDegree) {
		Hashtable procToModules = new Hashtable();
		HardwareNode[] hardwareNodes = new HardwareNode[hardwareTemplate.hardwareGraph.size()];
		int hardIndex = 0;
		for (Iterator iter = hardwareTemplate.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode proc = (HardwareNode) iter.next();
			hardwareNodes[hardIndex++] = proc;
			Vector modules = new Vector();
			procToModules.put(proc, modules);
			// Random upper limit in module sizes between 30-45%
			double sizeUpperBoundPercentage = 15.0 * randomGenerator.nextDouble();
			sizeUpperBoundPercentage = (sizeUpperBoundPercentage + 30.0) / 100.0;
			long[] moduleSizes = createSoftwareSizesForProcessor((long) proc.cyclesPerSecond,
					(long) (proc.cyclesPerSecond * sizeUpperBoundPercentage));// 1000000l);
			double remainder = 0.0;
			for (int i = 0; i < moduleSizes.length; i++) {
				/* Period in nanos */
				long period = 0;
				long cycles = 0;
				int tries = 0;
				while (tries < 10 && cycles < 10) {
					tries++;
					period = 0;
					if (maximumPeriod != minimumPeriod) {
						period = maximumPeriod - minimumPeriod;
						period *= randomGenerator.nextDouble();
						period += minimumPeriod;
					} else
						period = maximumPeriod;

					cycles = (moduleSizes[i] * period) / 1000000000;
				}
				if (cycles < 10) {
					period = 1000000000;
					cycles = (moduleSizes[i] * period) / 1000000000;
				}

				double cycleRemainder = ((moduleSizes[i] * period) / 1000000000.0) - cycles;
				cycleRemainder = cycleRemainder * (1000000000.0 / period);
				remainder += cycleRemainder;

				SoftwareNode module = new SoftwareNode(cycles, period, period, target.bwComparator,
						Integer.toString(i));
				target.addSoftwareNode(module);
				modules.add(module);
			}
			SoftwareNode module = new SoftwareNode((long) remainder, 1000000000, 1000000000, target.bwComparator,
					"remainder");
			target.addSoftwareNode(module);
			modules.add(module);
		}

		for (Iterator iter = hardwareTemplate.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode proc = (HardwareNode) iter.next();
			Vector modules = (Vector) procToModules.get(proc);
			int numberOfPartitions = 2;// (int)(randomGenerator.nextDouble() *
										// 8);
			numberOfPartitions += 2;
			int partSize = modules.size() / numberOfPartitions;
			int[][] partRegions = new int[numberOfPartitions][2];
			partRegions[0][0] = 0;
			partRegions[0][1] = partSize;
			for (int i = 1; i < numberOfPartitions - 1; i++) {
				partRegions[i][0] = partRegions[i - 1][1] + 1;
				partRegions[i][1] = partRegions[i][0] + partSize;
			}
			partRegions[numberOfPartitions - 1][0] = partRegions[numberOfPartitions - 2][1] + 1;
			partRegions[numberOfPartitions - 1][1] = modules.size() - 1;

			boolean[][] usedEdge = new boolean[modules.size()][modules.size()];
			int modulesSize = modules.size();
			for (int i = 0; i < modulesSize; i++)
				for (int j = i; j < modulesSize; j++)
					usedEdge[i][j] = false;

			for (int i = 0; i < modulesSize; i++) {
				int partner = (int) (randomGenerator.nextDouble()
						* (partRegions[i % numberOfPartitions][1] - partRegions[i % numberOfPartitions][0])); // (modulesSize - 1));
				partner += partRegions[i % numberOfPartitions][0];
				if (partner == i) {
					if (partner < modulesSize - 1)
						partner++;
					else
						partner--;
				}
				if (!usedEdge[i][partner]) {
					long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
					// (long) ((maximumMessageBits - minimumMessageBits) *
					// randomGenerator.nextDouble());
					SoftwareNode module1 = (SoftwareNode) modules.get(i);
					SoftwareNode module2 = (SoftwareNode) modules.get(partner);
					Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(), module1, module2);
					target.addMessage(msg);
					usedEdge[i][partner] = usedEdge[partner][i] = true;
				}
			}
		}
	}

	public void createPerfectFitSoftwareGraph(OutDegreeAssignmentProblem hardwareTemplate,
			OutDegreeAssignmentProblem[] targets, long minimumMessageBits, long maximumMessageBits, long minimumPeriod,
			long maximumPeriod, int outDegree) {
		Hashtable[] procToModules = new Hashtable[targets.length];
		for (int i = 0; i < targets.length; i++)
			procToModules[i] = new Hashtable();
		HardwareNode[][] hardwareNodes = new HardwareNode[targets.length][hardwareTemplate.hardwareGraph.size()];
		int hardIndex = 0;
		for (Iterator iter = hardwareTemplate.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode proc = (HardwareNode) iter.next();
			for (int i = 0; i < targets.length; i++)
				hardwareNodes[i][hardIndex] = proc;

			hardIndex++;

			Vector[] modules = new Vector[targets.length];
			for (int i = 0; i < targets.length; i++) {
				modules[i] = new Vector();
				procToModules[i].put(proc, modules[i]);
			}
			// Random upper limit in module sizes between 30-45%
			double sizeUpperBoundPercentage = 15.0 * randomGenerator.nextDouble();
			sizeUpperBoundPercentage = (sizeUpperBoundPercentage + 30.0) / 100.0;
			long[] moduleSizes = createSoftwareSizesForProcessor((long) proc.cyclesPerSecond,
					(long) (proc.cyclesPerSecond * sizeUpperBoundPercentage));// 1000000l);
			double remainder = 0.0;
			for (int i = 0; i < moduleSizes.length; i++) {
				/* Period in nanos */
				long period = 0;
				long cycles = 0;
				int tries = 0;
				while (tries < 10 && cycles < 10) {
					tries++;
					period = 0;
					if (maximumPeriod != minimumPeriod) {
						period = maximumPeriod - minimumPeriod;
						period *= randomGenerator.nextDouble();
						period += minimumPeriod;
					} else
						period = maximumPeriod;

					cycles = (moduleSizes[i] * period) / 1000000000;
				}
				if (cycles < 10) {
					period = 1000000000;
					cycles = (moduleSizes[i] * period) / 1000000000;
				}

				double cycleRemainder = ((moduleSizes[i] * period) / 1000000000.0) - cycles;
				cycleRemainder = cycleRemainder * (1000000000.0 / period);
				remainder += cycleRemainder;
				for (int j = 0; j < targets.length; j++) {
					SoftwareNode module = new SoftwareNode(cycles, period, period, targets[j].bwComparator,
							Integer.toString(i));
					targets[j].addSoftwareNode(module);
					modules[j].add(module);
				}
			}
			// for (int i=0; i<targets.length;i++)
			// {
			// System.out.print(" ["+i+"].#("+targets[i].softwareGraph.size()+")
			// v#("+modules[i].size()+")");
			// }
			// System.out.println(" ");

			if (remainder != 0) {
				for (int i = 0; i < targets.length; i++) {
					SoftwareNode module = new SoftwareNode((long) remainder, 1000000000, 1000000000,
							targets[i].bwComparator, "remainder");
					targets[i].addSoftwareNode(module);
					modules[i].add(module);
				}
			}
		}

		for (Iterator iter = hardwareTemplate.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode proc = (HardwareNode) iter.next();
			Vector[] modules = new Vector[targets.length];
			for (int i = 0; i < targets.length; i++) {
				modules[i] = (Vector) procToModules[i].get(proc);
			}

			// Generate at least two partitions
			int numberOfPartitions = 0; // (int)(randomGenerator.nextDouble() *
										// 8);
			numberOfPartitions += 2;

			// put all the module numbers in a "ticket" box to be randomly sent
			// to different
			// partitions
			Vector allNumbers = new Vector();
			for (int i = 0; i < modules[0].size(); i++)
				allNumbers.add(new Integer(i));

			Vector[] partitions = new Vector[numberOfPartitions];
			for (int i = 0; i < numberOfPartitions; i++) {
				partitions[i] = new Vector();
			}

			// sent ticket numbers to different partitions
			while (allNumbers.size() > 0) {
				int selectedIndex = (int) (randomGenerator.nextDouble() * (allNumbers.size() - 1));
				int selectedPartition = (int) (randomGenerator.nextDouble() * (numberOfPartitions - 1));
				partitions[selectedPartition].add(allNumbers.remove(selectedIndex));
			}

			boolean[][] usedEdge = new boolean[modules[0].size()][modules[0].size()];
			int modulesSize = modules[0].size();
			for (int i = 0; i < modulesSize; i++)
				for (int j = i; j < modulesSize; j++)
					usedEdge[i][j] = false;

			for (int i = 0; i < partitions.length; i++) {
				if (partitions[i].size() > 2) {
					for (int j = 0; j < partitions[i].size(); j++) {
						int moduleNumber = ((Integer) partitions[i].get(j)).intValue();

						// for (int r = 0; r<outDegree; r++)
						{
							int partnerNumber = ((Integer) partitions[i]
									.get((int) (randomGenerator.nextDouble() * (partitions[i].size() - 1)))).intValue();
							if (partnerNumber != moduleNumber) {
								if (!usedEdge[moduleNumber][partnerNumber]) {
									long bits = generateMessageBits(minimumMessageBits, maximumMessageBits);
									// (long) ((maximumMessageBits -
									// minimumMessageBits) *
									// randomGenerator.nextDouble());
									for (int k = 0; k < targets.length; k++) {
										SoftwareNode module1 = (SoftwareNode) modules[k].get(moduleNumber);
										SoftwareNode module2 = (SoftwareNode) modules[k].get(partnerNumber);
										Message msg = new Message(bits, module1.getPeriod(), module1.getDeadline(),
												module1, module2);
										targets[k].addMessage(msg);
									}
									usedEdge[moduleNumber][partnerNumber] = usedEdge[partnerNumber][moduleNumber] = true;
								}
							}
						}
					}
				}
			}
		}
	}

	public SiteArchitecture[] createSiteArchitecture(int numberOfClones, int minimumNumberOfSites,
			int maximumNumberOfSites, long minimumPower, long maximumPower, long minimumDuctPower,
			long maximumDuctPower, long minimumDuctsPerSite, long maximumDuctsPerSite, SiteGuest[] supportedProcessors,
			SiteGuest[] supportedLinks) {
		return createSiteArchitecture(numberOfClones, minimumNumberOfSites, maximumNumberOfSites, minimumPower,
				maximumPower, 0, // minimum
									// site
									// space
				0, // maximum site space
				minimumDuctPower, maximumDuctPower, 0, // minimum duct space
				0, // maximum site space
				minimumDuctsPerSite, maximumDuctsPerSite, supportedProcessors, supportedLinks);
	}

	/**
	 * This method creates random hardware nodes and links. The random creation
	 * of nodes is controlled by ranges (max,min) for each of the parameter of
	 * the modules
	 */
	public SiteArchitecture[] createSiteArchitecture(int numberOfClones, int minimumNumberOfSites,
			int maximumNumberOfSites, long minimumPower, long maximumPower, long minimumSiteSpace,
			long maximumSiteSpace, long minimumDuctPower, long maximumDuctPower, long minimumDuctSpace,
			long maximumDuctSpace, long minimumDuctsPerSite, long maximumDuctsPerSite, SiteGuest[] supportedProcessors,
			SiteGuest[] supportedLinks) {
		// DebugMonitor.println(DebugMonitor.channels[3],
		// "createSiteArchitecture(minSites("+Integer.toString(minimumNumberOfSites)+
		// ") maxSite("+Integer.toString(maximumNumberOfSites)+")
		// minPower("+Long.toString(minimumPower)+
		// ") maxPower("+Long.toString(maximumPower)+"))");
		// System.out.println("createSiteArchitecture -- suported processors");
		// for (int i=0; i<supportedProcessors.length;i++)
		// System.out.println("\t\t proce("+supportedProcessors[i]+")");
		SiteArchitecture[] siteArchitecture = new SiteArchitecture[numberOfClones];
		for (int i = 0; i < numberOfClones; i++)
			siteArchitecture[i] = new SiteArchitecture();

		int numberOfSites;

		if ((numberOfSites = maximumNumberOfSites - minimumNumberOfSites) <= 0) {
			numberOfSites = maximumNumberOfSites;
		} else {
			numberOfSites *= randomGenerator.nextDouble();
			numberOfSites += minimumNumberOfSites;
		}

		Site[][] sites = new Site[numberOfClones][numberOfSites];

		for (int i = 0; i < numberOfSites; i++) {
			long powerCapacity;
			long spaceCapacity;

			if ((powerCapacity = maximumPower - minimumPower) <= 0) {
				powerCapacity = maximumPower;
			} else {
				powerCapacity *= randomGenerator.nextDouble();
				powerCapacity += minimumPower;
			}

			if ((spaceCapacity = maximumSiteSpace - minimumSiteSpace) <= 0) {
				spaceCapacity = maximumSiteSpace;
			} else {
				spaceCapacity *= randomGenerator.nextDouble();
				spaceCapacity += minimumSiteSpace;
			}

			for (int j = 0; j < numberOfClones; j++) {
				Site site = new Site(powerCapacity, spaceCapacity, supportedProcessors);
				siteArchitecture[j].addSite(site);
				sites[j][i] = site;
			}
		}

		for (int i = 0; i < numberOfSites; i++) {
			long numberOfDucts;
			Site[] site = new Site[numberOfClones];
			for (int j = 0; j < numberOfClones; j++)
				site[j] = sites[j][i]; // sites[0][i];

			if ((numberOfDucts = (maximumDuctsPerSite - minimumDuctsPerSite)) <= 0) {
				numberOfDucts = maximumDuctsPerSite;
			} else {
				numberOfDucts *= randomGenerator.nextDouble();
				numberOfDucts += minimumDuctsPerSite;
			}

			TreeSet[] connVector = new TreeSet[numberOfClones];
			for (int j = 0; j < numberOfClones; j++) {
				connVector[j] = (TreeSet) siteArchitecture[j].siteConnectivityMatrix.get(site[j]);
			}

			if (sites[0].length > 1) {
				// System.out.println("..GENERATING DUCTS...");
				for (int j = 0; j < numberOfDucts; j++) {
					long powerCapacity;
					long spaceCapacity;

					if ((powerCapacity = maximumDuctPower - minimumDuctPower) <= 0)
						powerCapacity = maximumDuctPower;
					else {
						powerCapacity *= randomGenerator.nextDouble();
						powerCapacity += minimumDuctPower;
					}

					if ((spaceCapacity = maximumDuctSpace - minimumDuctSpace) <= 0)
						spaceCapacity = maximumDuctSpace;
					else {
						spaceCapacity *= randomGenerator.nextDouble();
						spaceCapacity += minimumDuctSpace;
					}

					// This scheme can generate multiple links between same pair
					// of processors
					int partner = numberOfSites - 1;

					Vector tickets = new Vector();
					for (int k = 0; k < (numberOfSites - 1); k++) {
						int t = k + (k >= i ? 1 : 0);
						tickets.add(new Integer(t));
					}

					// Select a not connected pair
					boolean connected = true;
					Vector checkedPartners = new Vector();
					while (connected) {
						// if checked all potential partners
						if (checkedPartners.size() == sites[0].length)
							break;

						// if no tickets to select finish
						if (tickets.size() == 0)
							break;

						// partner = numberOfSites - 1;
						int selected = tickets.size();
						selected = (int) Math.floor(selected * randomGenerator.nextDouble());
						// partner += (partner >= i) ? 1 : 0;
						// System.out.println("Selected("+selected+") --
						// tickets.size("+tickets.size()+")");
						Integer ticket = (Integer) tickets.get(selected);
						partner = ticket.intValue();
						Site other = sites[0][partner];
						if (checkedPartners.contains(other)) {
							tickets.remove(ticket);
							continue;
						}

						checkedPartners.add(other);

						connected = false;
						if (connVector[0] != null) {
							for (Iterator iter = connVector[0].iterator(); !connected && iter.hasNext();) {
								Duct d = (Duct) iter.next();
								if (d.siteMembers.contains(other)) {
									tickets.remove(ticket);
									connected = true;
									break;
								}
							}
						}
					}

					for (int k = 0; !connected && k < numberOfClones; k++) {
						Site other = sites[k][partner];
						// if (connVector[k] != null)
						// {
						// for (Iterator iter = connVector[k].iterator();
						// !connected && iter.hasNext();)
						// {
						// Duct d = (Duct) iter.next();
						// if (d.siteMembers.contains(other))
						// {
						// connected = true;
						// break;
						// }
						// }
						// }
						// if (connected)
						// break;

						Duct duct = new Duct(powerCapacity, spaceCapacity, supportedLinks);
						duct.addSite(site[k]);
						duct.addSite(other);
						// System.out.println("Adding Duct("++",)");
						siteArchitecture[k].addDuct(duct);
						if (connVector[k] == null)
							connVector[k] = (TreeSet) siteArchitecture[k].siteConnectivityMatrix.get(site[k]);
					}
					// // if connected skip this duct
					// if (connected)
					// continue;
				}
				// System.out.println("End of duct generation");
			}
		}
		// for (int i=0;i<numberOfClones;i++)
		// showSiteArchitecture(siteArchitecture[i]);
		return siteArchitecture;
	}

	public static void showSiteArchitecture(SiteArchitecture siteArchitecture) {
		JTextArea textArea = new JTextArea();
		textArea.append(" ********* Site Architecture *********\n");
		for (Iterator iter = siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
			Site s = (Site) iter.next();
			textArea.append("\t Site(" + Integer.toString(s.hashCode()) + ") power(" + Double.toString(s.maximumPower)
					+ "), space(" + Double.toString(s.maximumSpace) + ") \n");
			for (Iterator iter1 = s.potentialGuests.iterator(); iter1.hasNext();) {
				textArea.append("\t\t Guest(" + iter1.next().getClass() + ") \n");
			}
			TreeSet connVector = (TreeSet) siteArchitecture.siteConnectivityMatrix.get(s);
			if (connVector != null) {
				if (connVector.size() == 0) {
					textArea.append("\t\t ISOLATED 1\n");
				}
				for (Iterator iter1 = connVector.iterator(); iter1.hasNext();) {
					Duct d = (Duct) iter1.next();
					textArea.append("\t\t Duct power(" + Double.toString(d.maximumPower) + ") space("
							+ Double.toString(d.maximumSpace) + ")\n");
					int dSize = d.siteMembers.size();
					for (int j = 0; j < dSize; j++) {
						Site other = (Site) d.siteMembers.get(j);
						textArea.append("\t\t\t neighbor site(" + Integer.toString(other.hashCode()) + ")\n");
					}
				}
			} else {
				textArea.append("\t\t ISOLATED 2\n");
			}
		}
		JScrollPane spane = new JScrollPane(textArea);
		spane.setPreferredSize(new Dimension(700, 500));
		JOptionPane.showMessageDialog(null, spane, "Site Architecture", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This method creates random hardware nodes and links. The random creation
	 * of nodes is controlled by ranges (max,min) for each of the parameter of
	 * the modules
	 * 
	 * @param problem
	 *            Assignment problem to which the hardware is to be added
	 * @param minimumNumberOfProcessors
	 *            Minimum number of processors
	 * @param maximumNumberOfProcessors
	 *            Maximum number of processors
	 * @param minimumCyclesPerSecond
	 *            Minimum speed of processors in cycles / second
	 * @param maximumCyclesPerSecond
	 *            Maximum speed of processors in cycles / second
	 * @param minimumLinkBitsPerSecond
	 *            Minimum speed of links in bits / second
	 * @param maximumLinkBitsPerSecond
	 *            Maximum speed of links in bits / second
	 * @param minimumLinksPerProcessor
	 *            Minimum number of links per processor. Zero means that there
	 *            can be isolated processors
	 * @param maximumLinksPerProcessor
	 *            Maximum number of links per processor. Only to guide the
	 *            generator, the real number of processors can exceed this
	 *            number.
	 */
	public void createHardwareGraph(OutDegreeAssignmentProblem problem, int minimumNumberOfProcessors,
			int maximumNumberOfProcessors, long minimumCyclesPerSecond, long maximumCyclesPerSecond,
			long minimumLinkBitsPerSecond, long maximumLinkBitsPerSecond, int minimumLinksPerProcessor,
			int maximumLinksPerProcessor) {
		int numberOfProcessors;

		if ((numberOfProcessors = maximumNumberOfProcessors - minimumNumberOfProcessors) <= 0) {
			numberOfProcessors = maximumNumberOfProcessors;
		} else {
			numberOfProcessors *= randomGenerator.nextDouble();
			numberOfProcessors += minimumNumberOfProcessors;
		}

		HardwareNode[] hardwareNodes = new HardwareNode[numberOfProcessors];

		for (int i = 0; i < numberOfProcessors; i++) {
			long cyclesPerSecond;

			if ((cyclesPerSecond = maximumCyclesPerSecond - minimumCyclesPerSecond) <= 0) {
				cyclesPerSecond = maximumCyclesPerSecond;
			} else {
				cyclesPerSecond *= randomGenerator.nextDouble();
				cyclesPerSecond += minimumCyclesPerSecond;
			}

			HardwareNode node = new HardwareNode(Long.toString(i), new EDFScheduler(problem.bwComparator),
					cyclesPerSecond);
			problem.hardwareGraph.add(node);
			hardwareNodes[i] = node;
		}

		for (int i = 0; i < numberOfProcessors; i++) {
			int numberOfLinks;
			HardwareNode processor = hardwareNodes[i];

			if ((numberOfLinks = maximumLinksPerProcessor - minimumLinksPerProcessor) <= 0) {
				numberOfLinks = maximumLinksPerProcessor;
			} else {
				numberOfLinks *= randomGenerator.nextDouble();
				numberOfLinks += minimumLinksPerProcessor;
			}

			for (int j = 0; j < numberOfLinks; j++) {
				long bitsPerSecond;

				if ((bitsPerSecond = maximumLinkBitsPerSecond - minimumLinkBitsPerSecond) <= 0)
					bitsPerSecond = maximumLinkBitsPerSecond;
				else {
					bitsPerSecond *= randomGenerator.nextDouble();
					bitsPerSecond += minimumLinkBitsPerSecond;
				}

				Link link = new Link(problem.capComparator, new EDFScheduler(problem.bwComparator), bitsPerSecond);

				// This scheme can generate multiple links between same pair of
				// processors
				int partner = numberOfProcessors - 1;
				partner *= randomGenerator.nextDouble();
				partner += (partner >= j) ? 1 : 0;

				link.add(processor);
				link.add(hardwareNodes[partner]);
				problem.addLink(link);
			}
		}
	}

	/**
	 * Creates an experiment (vector of AssignmentProblems), to be run and
	 * plotted. Metrics for the experiement are. Fit - how well the assignement
	 * was done Time - How long it took to run
	 * 
	 * @param minimumNumberOfProcessors
	 *            Starting number of processors
	 * @param processorNumberIncrement
	 *            The number of processors can evolve as an arithmetic series or
	 *            geometric series. The next number is calculated by next =
	 *            (prev + processorNumberIncrement) * processorNumberFactor. As
	 *            a result if we want a arithmetic series we set the increment
	 *            to a constant and the factor to 1. On the other hand if we
	 *            want a geometric series we would set the increment to zero and
	 *            the factor to the desired one.
	 * @param processorNumberFactor
	 *            see <code>processorNumberIncrement</code>
	 * @param maximumNumberOfProcessors
	 *            The maximum number of processors to stop incrementing
	 * @param minimumCyclesPerSecond
	 *            Starting speed of the processors for the range of the random
	 *            set
	 * @param maximumCyclesPerSecond
	 *            End of range of processor speed
	 * @param minimumNumberOfLinksPerProcessor
	 *            Start of range of random variable of links per processor
	 * @param maximumNumberOfLinksPerProcessor
	 *            End of range see <code>minimumNumberOfLinksPerProcessor</code>
	 * @param minimumBitsPerSecond
	 *            Start of range of random variable of speed of link
	 * @param maximumBitsPerSecond
	 *            End of range see <code>minimumBitsPerSecond</code>
	 * @param minimumNumberOfModules
	 *            Starting number of modules to produce
	 * @param moduleNumberIncrement
	 *            Increment of series of module sets, see
	 *            <code>processorNumberIncrement</code>
	 * @param moduleNumberFactor
	 *            Factor for geometric series, see
	 *            <code>processorNumberIncrement</code>
	 * @param maximumNumberOfModules
	 *            Maximum number of modules allowed
	 * @param minimumCyclesPerModule
	 *            Start of range of random variable for WCET of module
	 * @param maximumCyclesPerModule
	 *            End of range of random variable for WCET of module
	 * @param minimumPeriod
	 *            Start of range of random variable for period of module
	 * @param maximumPeriod
	 *            End of range of random varaible for period of module
	 * @param minimumNumberOfMessagesPerModule
	 *            Start of range for random variable for number of messages per
	 *            module
	 * @param maximumNumberOfMessagesPerModule
	 *            End of range for random variable for number of messages per
	 *            module
	 * @param minimumMessageSize
	 *            Start of range for random variable for message size
	 * @param maximumMessageSize
	 *            End of range for random variable for message size
	 * @return Returns a Vector of Assignment problems to be run.
	 */
	public Vector createExperiment(int minimumNumberOfProcessors, int processorNumberIncrement,
			int processorNumberFactor, int maximumNumberOfProcessors, long minimumCyclesPerSecond,
			long maximumCyclesPerSecond, int minimumNumberOfLinksPerProcessor, int maximumNumberOfLinksPerProcessor,
			long minimumBitsPerSecond, long maximumBitsPerSecond, int minimumNumberOfModules, int moduleNumberIncrement,
			int moduleNumberFactor, int maximumNumberOfModules, long minimumCyclesPerModule,
			long maximumCyclesPerModule, long minimumPeriod, long maximumPeriod, int minimumNumberOfMessagesPerModule,
			int maximumNumberOfMessagesPerModule, long minimumMessageSize, long maximumMessageSize) {
		Vector problems = new Vector();
		// System.out.println("Creating minProcs("+minimumNumberOfProcessors+
		// ") maxProcs("+maximumNumberOfProcessors+
		// ") increments("+processorNumberIncrement+
		// ") factor("+processorNumberFactor+")");
		for (int i = minimumNumberOfProcessors; i <= maximumNumberOfProcessors; i = (i + processorNumberIncrement)
				* processorNumberFactor) {
			OutDegreeAssignmentProblem p = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
					new BandwidthComparator(), new CapacityComparator());
			createHardwareGraph(p, i, // min number of processors
					i, // max number of processors
					minimumCyclesPerSecond, maximumCyclesPerSecond, minimumBitsPerSecond, maximumBitsPerSecond,
					minimumNumberOfLinksPerProcessor, maximumNumberOfLinksPerProcessor);

			long totalCyclesPerSecond = 0;
			for (Iterator iter = p.hardwareGraph.iterator(); iter.hasNext();) {
				HardwareNode proc = (HardwareNode) iter.next();
				totalCyclesPerSecond += proc.cyclesPerSecond;
			}

			// System.out.println("\t Total Cycles Per
			// Second("+totalCyclesPerSecond+")");

			// cycles per nanosecond
			double maximumCyclesPerSecondDemanded = (double) maximumCyclesPerModule / (double) minimumPeriod;

			// System.out.println("Maximum cycles per
			// nanos("+maximumCyclesPerSecondDemanded+")");

			// cycles per second
			maximumCyclesPerSecondDemanded *= 1000000000.0;

			// System.out.println("\t Maximum cycles
			// demanded("+maximumCyclesPerSecondDemanded+")");
			// try to ensure that the modules would fit
			long maxNumModules = (long) (totalCyclesPerSecond / maximumCyclesPerSecondDemanded);

			maxNumModules = (maxNumModules < maximumNumberOfModules) ? maxNumModules : maximumNumberOfModules;

			// System.out.println("Creating minModules("+minimumNumberOfModules+
			// ") maxModules("+maxNumModules+
			// ") increments("+moduleNumberIncrement+
			// ") factor("+moduleNumberFactor+")");

			for (int j = minimumNumberOfModules; j <= maxNumModules; j = (j + moduleNumberIncrement)
					* moduleNumberFactor) {
				OutDegreeAssignmentProblem p1 = (OutDegreeAssignmentProblem) p.clone();
				// createSoftwareGraph(p1,
				// j, // min number of modules
				// j, // max number of modules - fixed
				// minimumCyclesPerModule,
				// maximumCyclesPerModule,
				// minimumPeriod,
				// maximumPeriod,
				// minimumMessageSize,
				// maximumMessageSize,
				// minimumNumberOfMessagesPerModule,
				// maximumNumberOfMessagesPerModule,
				// 1000000
				// );
				problems.add(p1);
			}
		}
		return problems;
	}

	// /**
	// * run the experiment (vector of assignment problems)
	// *
	// * @param experiment Vector of assignment problems
	// * @return Vector of AssignmentResults
	// */
	//
	// public Vector runExperiment(Vector experiment)
	// {
	// Vector results = new Vector();
	// int experimentSize = experiment.size();
	// for (int i=0; i<experimentSize;i++)
	// {
	// AssignmentProblem p = (AssignmentProblem) experiment.elementAt(i);
	// BinPacker packer = new BinPacker(p);
	// boolean res = packer.solve(p);
	// results.add(new AssignmentResult(p, res));
	// }
	// return results;
	// }

	public Vector runSiteBasedExperiment(Vector experiment, LowLevelBinPacker lowPacker, Expansor expansor) {
		Vector results = new Vector();
		int experimentSize = experiment.size();
		for (int i = 0; i < experimentSize; i++) {
			OutDegreeAssignmentProblem p = (OutDegreeAssignmentProblem) experiment.elementAt(i);
			expansor.setSiteArchitecture(p.siteArchitecture);
			NFCHoBinPacker packer = new NFCHoBinPacker(lowPacker);
			boolean res = packer.solve(p);
			results.add(new AssignmentResult(p, res));
		}
		return results;
	}

	/**
	 * Creates an experiment (vector of AssignmentProblems), to be run and
	 * plotted. Metrics for the experiement are. Fit - how well the assignement
	 * was done Time - How long it took to run
	 * 
	 * @param minimumCyclesPerSecond
	 *            Starting speed of the processors for the range of the random
	 *            set
	 * @param maximumCyclesPerSecond
	 *            End of range of processor speed
	 * @param minimumNumberOfModules
	 *            Starting number of modules to produce
	 * @param moduleNumberIncrement
	 *            Increment of series of module sets, see
	 *            <code>processorNumberIncrement</code>
	 * @param moduleNumberFactor
	 *            Factor for geometric series, see
	 *            <code>processorNumberIncrement</code>
	 * @param maximumNumberOfModules
	 *            Maximum number of modules allowed
	 * @param minimumCyclesPerModule
	 *            Start of range of random variable for WCET of module
	 * @param maximumCyclesPerModule
	 *            End of range of random variable for WCET of module
	 * @param minimumPeriod
	 *            Start of range of random variable for period of module
	 * @param maximumPeriod
	 *            End of range of random varaible for period of module
	 * @param minimumNumberOfMessagesPerModule
	 *            Start of range for random variable for number of messages per
	 *            module
	 * @param maximumNumberOfMessagesPerModule
	 *            End of range for random variable for number of messages per
	 *            module
	 * @param minimumMessageSize
	 *            Start of range for random variable for message size
	 * @param maximumMessageSize
	 *            End of range for random variable for message size
	 * @return Returns a Vector of Assignment problems to be run.
	 */
	public Vector createSiteBasedExperiment(int numberOfClones, int minimumNumberOfSites, int siteNumberIncrement,
			int siteNumberFactor, int maximumNumberOfSites, long minimumPower, long maximumPower,
			long minimumCyclesPerSecond, long cyclesPerSecondIncrement, long maximumCyclesPerSecond,
			long minimumDuctPower, long maximumDuctPower, long minimumDuctsPerSite, long maximumDuctsPerSite,
			int minimumNumberOfModules, int moduleNumberIncrement, int moduleNumberFactor, int maximumNumberOfModules,
			long minimumCyclesPerModule, long maximumCyclesPerModule, long minimumPeriod, long maximumPeriod,
			int minimumNumberOfMessagesPerModule, int maximumNumberOfMessagesPerModule, long minimumMessageSize,
			long maximumMessageSize) {
		Vector problems = new Vector();
		CANBus canbus1M = new CANBus(1000000.0);
		CANBus canbus500k = new CANBus(500000.0);
		CANBus canbus100k = new CANBus(100000.0);

		canbus1M.powerRequirement = 10;
		canbus500k.powerRequirement = 10;
		canbus100k.powerRequirement = 10;

		NetInterface[] netInterfaces = new NetInterface[] { new NetInterface(canbus1M), new NetInterface(canbus500k),
				new NetInterface(canbus100k) };

		NetInterface[] netInterfaces1 = new NetInterface[] { new NetInterface(canbus500k), new NetInterface(canbus500k),
				new NetInterface(canbus500k), new NetInterface(canbus500k), new NetInterface(canbus500k) };

		Vector siteGuest = new Vector();
		for (long l = minimumCyclesPerSecond; l <= maximumCyclesPerSecond; l += cyclesPerSecondIncrement) {
			// System.out.println("\t\t\t adding processor bw("+l+")");
			MPC555 proc = new MPC555("", new EDFScheduler(new BandwidthComparator()), l, netInterfaces1);
			// proc.powerRequirement = 10;
			siteGuest.add(proc);
		}
		Vector interfaces = new Vector();
		for (int i = 0; i < netInterfaces.length; i++) {
			siteGuest.add(netInterfaces[i].getLink());
			interfaces.add(netInterfaces[i].getLink());
		}

		SiteGuest[] supportedProcessors = new SiteGuest[siteGuest.size()];
		for (int i = 0; i < siteGuest.size(); i++)
			supportedProcessors[i] = (SiteGuest) siteGuest.get(i);

		SiteGuest[] supportedLinks = new SiteGuest[interfaces.size()];
		for (int i = 0; i < interfaces.size(); i++)
			supportedLinks[i] = (SiteGuest) interfaces.get(i);

		for (int i = minimumNumberOfSites; i <= maximumNumberOfSites; i = (i + siteNumberIncrement)
				* siteNumberFactor) {
			OutDegreeAssignmentProblem p = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
					new BandwidthComparator(), new CapacityComparator());

			SiteArchitecture siteArchitecture[] = createSiteArchitecture(1, i, // min
																				// number
																				// of
																				// sites
					i, // max number of sites
					minimumPower, maximumPower, minimumDuctPower, maximumDuctPower, minimumDuctsPerSite,
					maximumDuctsPerSite, supportedProcessors, supportedLinks);
			// showSiteArchitecture(siteArchitecture);
			p.siteArchitecture = siteArchitecture[0];

			Vector[] experiments = new Vector[numberOfClones];
			for (int k = 0; k < numberOfClones; k++)
				experiments[k] = new Vector();
			for (int j = minimumNumberOfModules; j <= maximumNumberOfModules; j = (j + moduleNumberIncrement)
					* moduleNumberFactor) {
				OutDegreeAssignmentProblem[] p1 = new OutDegreeAssignmentProblem[numberOfClones];
				for (int k = 0; k < numberOfClones; k++) {
					p1[k] = (OutDegreeAssignmentProblem) p.clone();
				}
				createSoftwareGraph(p1, j, // min number of modules
						j, // max number of modules - fixed
						minimumCyclesPerModule, maximumCyclesPerModule, minimumPeriod, maximumPeriod,
						minimumMessageSize, maximumMessageSize, minimumNumberOfMessagesPerModule,
						maximumNumberOfMessagesPerModule, minimumCyclesPerSecond);
				for (int k = 0; k < numberOfClones; k++)
					experiments[k].add(p1[k]);
			}

			for (int k = 0; k < numberOfClones; k++)
				problems.add(experiments[k]);
		}
		return problems;
	}

	public void showExperiments(Vector experiments) {
		JTextArea textArea = new JTextArea();

		int experimentsSize = experiments.size();
		for (int i = 0; i < experimentsSize; i++) {
			OutDegreeAssignmentProblem p = (OutDegreeAssignmentProblem) experiments.get(i);
			textArea.append("\n\n ----------------------- NEW PROBLEM ---------------------- \n");
			// Display site architecture
			textArea.append(" ********* Site Architecture *********\n");
			for (Iterator iter = p.siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
				Site s = (Site) iter.next();
				textArea.append("\t Site(" + Integer.toString(s.hashCode()) + ") power("
						+ Double.toString(s.maximumPower) + "), space(" + Double.toString(s.maximumSpace) + ")\n");
				TreeSet connVector = (TreeSet) p.siteArchitecture.siteConnectivityMatrix.get(s);
				if (connVector != null) {
					if (connVector.size() == 0) {
						textArea.append("\t\t ISOLATED 1\n");
					}
					for (Iterator iter1 = connVector.iterator(); iter1.hasNext();) {
						Duct d = (Duct) iter1.next();
						textArea.append("\t\t Duct (" + d.hashCode() + ") power(" + Double.toString(d.maximumPower)
								+ ") space(" + Double.toString(d.maximumSpace) + ")\n");
						int dSize = d.siteMembers.size();
						for (int j = 0; j < dSize; j++) {
							Site other = (Site) d.siteMembers.get(j);
							textArea.append("\t\t\t neighbor site(" + Integer.toString(other.hashCode()) + ")\n");
						}
					}
				} else {
					textArea.append("\t\t ISOLATED 2\n");
				}
			}

			textArea.append("######## SOFTWARE GRAPH #########\n");
			for (Iterator iter = p.softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode module = (SoftwareNode) iter.next();
				textArea.append("\t Module(" + Integer.toString(module.hashCode()) + ").name(" + module.name + ") C("
						+ Long.toString(module.getCycles()) + " cycles) T(" + Long.toString(module.getPeriod())
						+ " nanos) D(" + Long.toString(module.getDeadline()) + " nanos)\n");
				TreeMap msgs = (TreeMap) p.softwareConnectivity.get(module);
				if (msgs != null) {
					for (Iterator iter1 = msgs.entrySet().iterator(); iter1.hasNext();) {
						Map.Entry entry = (Map.Entry) iter1.next();
						Message msg = (Message) entry.getKey();
						SoftwareNode other = (SoftwareNode) entry.getValue();
						textArea.append("\t\t Msg(" + Integer.toString(msg.hashCode()) + ") BW("
								+ Double.toString(msg.getBandwidth()) + ") bits/s\n");
						textArea.append("\t\t\t to: module(" + Integer.toString(other.hashCode()) + ").name("
								+ other.name + ")\n");
					}
				}
			}
		}
		JScrollPane spane = new JScrollPane(textArea);
		spane.setPreferredSize(new Dimension(700, 500));
		JOptionPane.showMessageDialog(null, spane, "Experiment", JOptionPane.INFORMATION_MESSAGE);
	}

	public void saveStatistics(Vector results, String prefix) {
		Comparator intComparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				// Allow duplicates
				if (o1.hashCode() == o2.hashCode()) {
					return -1;
				}

				int i1 = ((Integer) o1).intValue();
				int i2 = ((Integer) o2).intValue();
				int diff = i1 - i2;

				// Allow duplicates
				if (diff == 0)
					return o1.hashCode() - o2.hashCode();

				return diff;
			}

			public boolean equals(Object o) {
				return getClass().equals(o.getClass());
			}
		};

		Comparator doubleComparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				// Allow Duplicates
				if (o1.hashCode() == o2.hashCode())
					return -1;

				double i1 = ((Double) o1).doubleValue();
				double i2 = ((Double) o2).doubleValue();
				double diff = i1 - i2;

				int answer;
				if (diff < 0)
					answer = (int) Math.floor(diff);
				else
					answer = (int) Math.ceil(diff);

				if (answer == 0)
					answer = o1.hashCode() - o2.hashCode();

				return answer;
			}

			public boolean equals(Object o) {
				return getClass().equals(o.getClass());
			}
		};

		int successfulExperiments = 0;
		int failedExperiments = 0;

		TreeMap bgmap = new TreeMap(doubleComparator);
		TreeMap ngmap = new TreeMap(intComparator);
		TreeMap hbmap = new TreeMap(doubleComparator);
		TreeMap mbgmap = new TreeMap(doubleComparator);
		TreeMap mngmap = new TreeMap(intComparator);
		TreeMap lbmap = new TreeMap(doubleComparator);
		TreeMap bcmap = new TreeMap(doubleComparator);
		TreeMap mbcmap = new TreeMap(doubleComparator);

		PrintWriter bgwriter = null;
		PrintWriter ngwriter = null;
		PrintWriter hbwriter = null;
		PrintWriter mbgwriter = null;
		PrintWriter mngwriter = null;
		PrintWriter sucwriter = null;
		PrintWriter lbwriter = null;
		PrintWriter bcwriter = null;
		PrintWriter mbcwriter = null;
		try {
			bgwriter = new PrintWriter(new FileOutputStream(prefix + "bg.txt"));
			ngwriter = new PrintWriter(new FileOutputStream(prefix + "ng.txt"));
			hbwriter = new PrintWriter(new FileOutputStream(prefix + "hb.txt"));
			mbgwriter = new PrintWriter(new FileOutputStream(prefix + "mbg.txt"));
			mngwriter = new PrintWriter(new FileOutputStream(prefix + "mng.txt"));
			sucwriter = new PrintWriter(new FileOutputStream(prefix + "suc.txt"));
			lbwriter = new PrintWriter(new FileOutputStream(prefix + "lb.txt"));
			bcwriter = new PrintWriter(new FileOutputStream(prefix + "bc.txt"));
			mbcwriter = new PrintWriter(new FileOutputStream(prefix + "mbc.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int resultsSize = results.size();
		for (int i = 0; i < resultsSize; i++) {
			AssignmentResult result = (AssignmentResult) results.elementAt(i);
			if (!result.success) {
				failedExperiments++;
				continue;
			}

			successfulExperiments++;
			double totalCapacityGap = 0.0;
			double totalBandwidthRequirement = 0.0;
			int moduleNumber = 0;
			double totalMessageBandwidth = 0.0;
			double totalLinkCapacity = 0.0;
			double totalLinkCapacityGap = 0.0;
			double totalCapacity = 0.0;
			int messageNumber = 0;
			Vector linksProcessed = new Vector();
			Vector msgsProcessed = new Vector();
			int linkNumber = 0;
			for (Iterator iter = result.problem.hardwareGraph.iterator(); iter.hasNext();) {
				HardwareNode n = (HardwareNode) iter.next();
				for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
					SoftwareNode m = (SoftwareNode) taskSet.next();
					if (m instanceof CompositeSoftNode) {
						CompositeSoftNode cn = (CompositeSoftNode) m;
						TreeSet set = cn.getBasicComponents();
						moduleNumber += set.size();
					} else
						moduleNumber++;
					totalBandwidthRequirement += m.getBandwidth();
				}
				totalCapacityGap += (n.getAvailableCapacity() / n.cyclesPerSecond);
				totalCapacity += n.getAvailableCapacity();
				TreeSet connVector = (TreeSet) result.problem.hardwareConnectivity.get(n);
				if (connVector != null) {
					for (Iterator iter1 = connVector.iterator(); iter1.hasNext();) {
						Link l = (Link) iter1.next();

						if (linksProcessed.contains(l))
							continue;
						linkNumber++;
						linksProcessed.add(l);
						totalLinkCapacity += l.getAvailableCapacity();
						totalLinkCapacityGap += (l.getAvailableCapacity() / l.cyclesPerSecond);
						for (Iterator msgs = l.getTaskSet().iterator(); msgs.hasNext();) {
							Message m = (Message) msgs.next();
							if (m instanceof CompositeMsgNode) {
								for (Iterator basicMsgs = ((CompositeMsgNode) m).components.iterator(); basicMsgs
										.hasNext();) {
									Message bm = (Message) basicMsgs.next();
									if (msgsProcessed.contains(bm))
										continue;

									messageNumber++;
									msgsProcessed.add(bm);
									totalMessageBandwidth += bm.getBandwidth();
								}
							} else {
								if (msgsProcessed.contains(m))
									continue;
								messageNumber++;
								msgsProcessed.add(m);
								totalMessageBandwidth += m.getBandwidth();
							}
						}
					}
				}

			}
			totalLinkCapacityGap /= linkNumber;
			totalCapacityGap /= result.problem.hardwareGraph.size();
			bgmap.put(new Double(totalBandwidthRequirement), new Double(totalCapacityGap));
			ngmap.put(new Integer(moduleNumber), new Double(totalCapacityGap));
			hbmap.put(new Double(totalBandwidthRequirement), new Integer(result.problem.hardwareGraph.size()));
			mbgmap.put(new Double(totalMessageBandwidth), new Double(totalLinkCapacityGap));
			lbmap.put(new Double(totalMessageBandwidth), new Integer(linkNumber));
			bcmap.put(new Double(totalBandwidthRequirement), new Double(totalCapacity));
			mbcmap.put(new Double(totalMessageBandwidth), new Double(totalLinkCapacity));
			mngmap.put(new Integer(messageNumber), new Double(totalLinkCapacityGap));
		}

		Iterator bgiter = bgmap.entrySet().iterator();
		Iterator ngiter = ngmap.entrySet().iterator();
		Iterator hbiter = hbmap.entrySet().iterator();
		Iterator mbgiter = mbgmap.entrySet().iterator();
		Iterator mngiter = mngmap.entrySet().iterator();
		Iterator lbiter = lbmap.entrySet().iterator();
		Iterator bciter = bcmap.entrySet().iterator();
		Iterator mbciter = mbcmap.entrySet().iterator();

		while (bgiter.hasNext()) {
			Map.Entry bgentry = (Map.Entry) bgiter.next();
			Map.Entry ngentry = (Map.Entry) ngiter.next();
			Map.Entry hbentry = (Map.Entry) hbiter.next();
			Map.Entry mbgentry = (Map.Entry) mbgiter.next();
			Map.Entry mngentry = (Map.Entry) mngiter.next();
			Map.Entry lbentry = (Map.Entry) lbiter.next();
			Map.Entry bcentry = (Map.Entry) bciter.next();
			Map.Entry mbcentry = (Map.Entry) mbciter.next();

			bgwriter.println(
					((Double) bgentry.getKey()).doubleValue() + " " + ((Double) bgentry.getValue()).doubleValue());
			ngwriter.println(
					((Integer) ngentry.getKey()).intValue() + " " + ((Double) ngentry.getValue()).doubleValue());
			hbwriter.println(
					((Double) hbentry.getKey()).doubleValue() + " " + ((Integer) hbentry.getValue()).intValue());
			mbgwriter.println(
					((Double) mbgentry.getKey()).doubleValue() + " " + ((Double) mbgentry.getValue()).doubleValue());
			mngwriter.println(
					((Integer) mngentry.getKey()).intValue() + " " + ((Double) mngentry.getValue()).doubleValue());
			lbwriter.println(
					((Double) lbentry.getKey()).doubleValue() + " " + ((Integer) lbentry.getValue()).intValue());
			bcwriter.println(
					((Double) bcentry.getKey()).doubleValue() + " " + ((Double) bcentry.getValue()).doubleValue());
			mbcwriter.println(
					((Double) mbcentry.getKey()).doubleValue() + " " + ((Double) mbcentry.getValue()).doubleValue());
		}

		sucwriter.println(successfulExperiments + " " + resultsSize);
		bgwriter.close();
		ngwriter.close();
		hbwriter.close();
		mbgwriter.close();
		mngwriter.close();
		sucwriter.close();
		lbwriter.close();
		bcwriter.close();
		mbcwriter.close();
	}

	public void showResults(Vector results, String title) {
		JTextArea textArea = new JTextArea();
		textArea.append("Results Size(" + Integer.toString(results.size()) + ")\n");
		int resultsSize = results.size();
		for (int i = 0; i < resultsSize; i++) {
			AssignmentResult result = (AssignmentResult) results.elementAt(i);
			textArea.append("\n\n -----  ASSIGNMENTS FOR PROBLEM(" + Integer.toString(i) + ") SUCCESS("
					+ Boolean.toString(result.success) + ")------\n");
			double totalCapacityGap = 0.0;
			double totalBandwidthRequirement = 0.0;
			int moduleNumber = 0;
			double totalMessageBandwidth = 0.0;
			double totalLinkCapacityGap = 0.0;
			int messageNumber = 0;
			Vector linksProcessed = new Vector();
			Vector msgsProcessed = new Vector();
			int linkNumber = 0;
			for (Iterator iter = result.problem.hardwareGraph.iterator(); iter.hasNext();) {
				HardwareNode n = (HardwareNode) iter.next();
				textArea.append("Node " + n.name + ":\n ");
				for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
					SoftwareNode m = (SoftwareNode) taskSet.next();
					if (m instanceof CompositeSoftNode) {
						CompositeSoftNode cn = (CompositeSoftNode) m;
						TreeSet set = cn.getBasicComponents();
						moduleNumber += set.size();
					} else
						moduleNumber++;
					totalBandwidthRequirement += m.getBandwidth();
					textArea.append("\t Module " + m.name + " " + "C(" + Long.toString(m.getCycles()) + " cycles),"
							+ "T(" + Long.toString(m.getPeriod()) + " nanos)," + "D(" + Long.toString(m.getDeadline())
							+ " nanos)\n" + "\t\t  BW Load(" + Double.toString(((ProcessingLoad) m).getBandwidth())
							+ ") cycles/sec\n");
				}
				textArea.append(
						"\t\t Available Capacity = " + Double.toString(n.getAvailableCapacity()) + " cycles / sec \n");
				totalCapacityGap += (n.getAvailableCapacity() / n.cyclesPerSecond);

				TreeSet connVector = (TreeSet) result.problem.hardwareConnectivity.get(n);
				if (connVector != null) {
					for (Iterator iter1 = connVector.iterator(); iter1.hasNext();) {
						Link l = (Link) iter1.next();

						textArea.append("LINK(" + Integer.toString(l.hashCode()) + ") BW("
								+ Double.toString(l.cyclesPerSecond) + " bits/s) Available Capacity("
								+ Double.toString((l.getAvailableCapacity() / l.cyclesPerSecond)) + ")\n");
						if (linksProcessed.contains(l))
							continue;
						linkNumber++;
						linksProcessed.add(l);
						totalLinkCapacityGap += (l.getAvailableCapacity() / l.cyclesPerSecond);
						for (Iterator msgs = l.getTaskSet().iterator(); msgs.hasNext();) {
							Message m = (Message) msgs.next();
							if (m instanceof CompositeMsgNode) {
								for (Iterator basicMsgs = ((CompositeMsgNode) m).components.iterator(); basicMsgs
										.hasNext();) {
									Message bm = (Message) basicMsgs.next();
									if (msgsProcessed.contains(bm))
										continue;

									messageNumber++;
									msgsProcessed.add(bm);
									totalMessageBandwidth += bm.getBandwidth();
								}
							} else {
								if (msgsProcessed.contains(m))
									continue;
								messageNumber++;
								msgsProcessed.add(m);
								totalMessageBandwidth += m.getBandwidth();
							}
						}
					}
				}

			}
			totalLinkCapacityGap /= linkNumber;
			totalCapacityGap /= result.problem.hardwareGraph.size();
			textArea.append("---------- END OF ASSIGNMENT PROBLEM --------------\n");
			textArea.append(" Number of Processors(" + Integer.toString(result.problem.hardwareGraph.size())
					+ ") Number of Links(" + Integer.toString(linkNumber) + ")\n");
			textArea.append("total Load(" + Double.toString(totalBandwidthRequirement) + ") total Message Bandwidth("
					+ totalMessageBandwidth + ")\n");
			textArea.append("total Capacity Gap (" + Double.toString(totalCapacityGap) + ")\n");
		}
		JScrollPane spane = new JScrollPane(textArea);
		spane.setPreferredSize(new Dimension(700, 500));
		JOptionPane.showMessageDialog(null, spane, "Results - " + title, JOptionPane.INFORMATION_MESSAGE);
	}

	public void fitProcessors(OutDegreeAssignmentProblem problem) {
		/* remove all empty processors */
		for (Iterator iter = problem.siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
			Site s = (Site) iter.next();
			for (Iterator iter1 = s.guests.iterator(); iter1.hasNext();) {
				HardwareNode guest = (HardwareNode) iter1.next();
				if (!(guest instanceof Processor))
					continue;

				if (guest.getTaskSet() == null || guest.getTaskSet().size() == 0) {
					/* remove this one completely */
					guest.setHost(null);
					iter1.remove();
					problem.hardwareGraph.remove(guest);
				}
			}
		}

		Hashtable originalToClone = new Hashtable();
		for (Iterator iter = problem.siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
			Site s = (Site) iter.next();
			for (Iterator iter1 = s.guests.iterator(); iter1.hasNext();) {
				HardwareNode guest = (HardwareNode) iter1.next();
				if (!(guest instanceof Processor))
					continue;

				HardwareNode replacement = s.replaceWithBestFit(guest);

				if (replacement == null)
					continue;

				Processor p1 = (Processor) replacement;
				Processor p2 = (Processor) guest;
				if (p1.classNetInterfaces.size() == 0) {
					for (Iterator nics = p2.classNetInterfaces.iterator(); nics.hasNext();) {
						p1.classNetInterfaces.add(nics.next());
					}
					for (Iterator nics = p2.netInterfaces.iterator(); nics.hasNext();) {
						NetInterface nic = (NetInterface) nics.next();
						p1.classNetInterfaces.add(nic.clone());
					}
				}
				// DebugMonitor.println(DebugMonitor.channels[2]," REPLACEMENT
				// PROC("+replacement.toString()+")
				// NICS.SIZE("+Integer.toString(
				// ((Processor)replacement).classNetInterfaces.size())+"):
				// ORIGINAL.NICS.SIZE("+Integer.toString(((Processor)guest).classNetInterfaces.size())+")");
				// for (Iterator iter5 =
				// ((Processor)replacement).classNetInterfaces.iterator();
				// iter5.hasNext();)
				// DebugMonitor.println(DebugMonitor.channels[2],"\t
				// NIC.LINK("+iter5.next().toString()+")");
				if (replacement != null) {
					originalToClone.put(guest, replacement);
				}
			}
		}
		for (Iterator iter = originalToClone.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			HardwareNode original = (HardwareNode) entry.getKey();
			HardwareNode clone = (HardwareNode) entry.getValue();

			TreeSet connVector = (TreeSet) problem.hardwareConnectivity.remove(original);
			if (connVector != null) {
				for (Iterator links = connVector.iterator(); links.hasNext();) {
					Link l = (Link) links.next();
					l.remove(original);
				}
				TreeSet cloneVector = new TreeSet(connVector.comparator());
				cloneVector.addAll(connVector);
				problem.hardwareConnectivity.put(clone, cloneVector);
			}
			problem.hardwareGraph.remove(original);
			problem.hardwareGraph.add(clone);

			Location s = original.getHost();
			if (s != null) {
				s.removeGuest(original);
				s.addGuest(clone);
			} else {
				System.out.println("replacing original(" + original + ") with clone(" + clone + ") site == null");
			}
		}
	}

	public void fitProcessors(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			OutDegreeAssignmentProblem p = (OutDegreeAssignmentProblem) v.get(i);
			fitProcessors(p);
		}
	}

	public void fitLinks(OutDegreeAssignmentProblem problem) {
		Vector replacedLinks = new Vector();

		for (Iterator iter = problem.siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
			Site s = (Site) iter.next();
			for (Iterator iter1 = s.guests.iterator(); iter1.hasNext();) {
				HardwareNode guest = (HardwareNode) iter1.next();
				if (!(guest instanceof Link))
					continue;

				if (replacedLinks.contains(guest))
					continue;

				replacedLinks.add(guest);

				HardwareNode replacement = s.replaceWithBestFit(guest);
				if (replacement != null) {
					Link original = (Link) guest;
					Link link = (Link) replacement;

					for (Iterator procs = link.getConnectedNodes().iterator(); // original.getConnectedNodes().iterator();
					procs.hasNext();) {
						Processor p = (Processor) procs.next();
						TreeSet connVector = (TreeSet) problem.hardwareConnectivity.get(p);
						// System.out.println("processor("+p+")");
						// System.out.println("connVector("+connVector+")");
						// System.out.println("original("+original+")");
						if (connVector == null) {

							connVector = new TreeSet(new CapacityComparator());
							problem.hardwareConnectivity.put(p, connVector);
						}
						connVector.remove(original);
						connVector.add(link);
					}
				} else {
					// DebugMonitor.println(DebugMonitor.channels[4],"NO
					// REPLACEMENT FOR LINK("+guest.toString()+
					// ") BW("+Double.toString(guest.cyclesPerSecond)+
					// ") AVAILABLE
					// CAPACITY("+Double.toString(guest.getAvailableCapacity())+")");
				}
			}
		}
	}

	public void fitLinks(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			OutDegreeAssignmentProblem p = (OutDegreeAssignmentProblem) v.get(i);
			fitLinks(p);
		}
	}

	public void checkInconsistencies(Vector experiment) {
		// DebugMonitor.println(DebugMonitor.channels[3]," DISCONNECTED
		// PROCESSORS");
		for (int i = 0; i < experiment.size(); i++) {
			OutDegreeAssignmentProblem problem = (OutDegreeAssignmentProblem) experiment.get(i);
			for (Iterator iter = problem.siteArchitecture.sitesBySize.iterator(); iter.hasNext();) {
				Site s = (Site) iter.next();
				for (Iterator iter1 = s.guests.iterator(); iter1.hasNext();) {
					HardwareNode guest = (HardwareNode) iter1.next();
					if (!(guest instanceof Link))
						continue;

					Link l = (Link) guest;
					for (Iterator iter2 = l.getConnectedNodes().iterator(); iter2.hasNext();) {
						Object p = iter2.next();
						Object o = problem.hardwareConnectivity.get(p);
						if (o == null) {
//							Processor n = (Processor) p;
							// DebugMonitor.println(DebugMonitor.channels[3],"
							// LINKS == NULL PROCESSOR("+n.toString()+") NIC");
							// for (Iterator nics = n.netInterfaces.iterator();
							// nics.hasNext();)
							// DebugMonitor.println(DebugMonitor.channels[3],"\t
							// NIC.LINK("+((NetInterface)nics.next()).link.toString()+")");
						}
					}
				}
			}
		}

		// DebugMonitor.println(DebugMonitor.channels[3],"--- DONE ---");

		// DebugMonitor.show();
	}

	public static int progress = 0;

	public static int toDeploy = 0;

	public static void main(String args[]) {
		MyBinPackerTester tester = new MyBinPackerTester();
		DebugMonitor.channels = new Channel[5];
		DebugMonitor.channels[0] = DebugMonitor.createChannel("Modules");
		DebugMonitor.channels[1] = DebugMonitor.createChannel("Partitions of DFCP");
		DebugMonitor.channels[2] = DebugMonitor.createChannel("Partitions of DFBP");
		DebugMonitor.channels[3] = DebugMonitor.createChannel("Partitions of BFCP");
		tryPerfectFit();
		runPerfectFitExperiment(args);
//		runWorstFitExperiment(args);
//		runWorstFitExperimentForExcessBinGuard(args);
		SimpleTest();
		DebugMonitor.show();
		System.exit(0);
	}

	public static DecimalFormat decFormat = new DecimalFormat("###,###,###,##0");

	public static int failureCode = 0;

	public static void runPerfectFitExperiment(String args[]) {
		int round = Integer.parseInt(args[0]);

		MyBinPackerTester tester = new MyBinPackerTester();

		OutDegreeAssignmentProblem hardwareTemplate = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		OutDegreeAssignmentProblem[] targets = new OutDegreeAssignmentProblem[4];

		for (int i = 0; i < targets.length; i++) {
			targets[i] = new OutDegreeAssignmentProblem(new OutDegreeComparator(), new BandwidthComparator(),
					new CapacityComparator());
		}

		CANBus canbus1M = new CANBus(1000000.0);
		CANBus canbus500k = new CANBus(500000.0);
		CANBus canbus100k = new CANBus(100000.0);

		NetInterface[] netInterfaces = new NetInterface[] { new NetInterface(canbus1M), new NetInterface(canbus500k),
				new NetInterface(canbus100k) };

		SiteGuest[] supportedHardware = new SiteGuest[13];
		long size = 100000000l;
		DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
		for (int i = 0; i < 10; i++) {
			supportedHardware[i] = new MPC555("", new EDFScheduler(new BandwidthComparator()), size, netInterfaces);
			System.out.println("Processor Size(" + format.format(size) + ")");
			size += 100000000l;
		}
		supportedHardware[10] = netInterfaces[0].getLink();
		supportedHardware[11] = netInterfaces[1].getLink();
		supportedHardware[12] = netInterfaces[2].getLink();

		for (int i = 0; i < 100; i++) {
			hardwareTemplate.hardwareGraph
					.add(new MPC555("", new EDFScheduler(new BandwidthComparator()), 1000000000l, netInterfaces));

		}

		tester.createPerfectFitSoftwareGraph(hardwareTemplate, targets, 512, // minimum
																				// message
																				// bits
				8000, // maximum message bits
				1000000000, // minimum period (nanos)
				1000000000, // maximum period (nanos)
				5 // outDegree
		);

		// for (Iterator iter =
		// targets[0].softwareGraph.iterator();iter.hasNext();)
		// {
		// SoftwareNode n =(SoftwareNode) iter.next();
		// DebugMonitor.println(DebugMonitor.channels[0],
		// decFormat.format(n.getBandwidth()));
		// }

		for (int i = 0; i < targets.length; i++) {
			double totalDemand = 0.0;
			for (Iterator iter = targets[i].softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Original Software(" + i + ") Demand(" + decFormat.format(totalDemand)
					+ " cycles/s) number of Modules (" + targets[i].softwareGraph.size() + ")");
		}

		for (int i = 0; i < targets.length; i++) {
			targets[i].siteArchitecture = new SiteArchitecture();
			targets[i].siteArchitecture.addSite(new Site(100.0, 100.0, supportedHardware));
		}

		NFCExpansor expansor = new NFCExpansor();

		String[] prefixes = new String[] { "dfc", "dfb", "bfc" };

		LowLevelBinPacker[] packers = new LowLevelBinPacker[] { new DFCPBinPacker(expansor),
				new DFBPBinPacker(expansor), new BFCPBinPacker(expansor) };

		for (int i = 0; i < packers.length; i++) {
			LowLevelBinPacker lowPacker = packers[i];
			OutDegreeAssignmentProblem problem = targets[i];

			expansor.setSiteArchitecture(problem.siteArchitecture);
			NFCHoBinPacker packer = new NFCHoBinPacker(lowPacker);
			boolean res = packer.solve(problem);
			if (res) {
				tester.fitProcessors(problem);
				tester.fitLinks(problem);
			} else
				System.out.println("Failure Code(" + failureCode + ")");
			AssignmentResult result = new AssignmentResult(problem, res);
			Vector v = new Vector();
			v.add(result);

			double totalDemand = 0.0;
			for (Iterator iter = result.problem.softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Result(" + i + ") Software Demand(" + totalDemand + " cycles/s)");

			// tester.showResults(v,prefixes[i]);
			tester.saveStatistics(v, prefixes[i] + Integer.toString(round));
		}

		// DebugMonitor.println(DebugMonitor.channels[1], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[0]).numberOfPartitions));
		// DebugMonitor.println(DebugMonitor.channels[2], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[1]).numberOfPartitions));
		// DebugMonitor.println(DebugMonitor.channels[3], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[2]).numberOfPartitions));
	}

	/**
	 * To play with site capacity limit we use power. For our experiments we
	 * first limit the number of processors with un unlimited capacity for links
	 * and then we try a limited capacity for links with an unlimited capacity
	 * for processors.
	 */
	public static void runWorstFitExperiment(String args[]) {
		int round = Integer.parseInt(args[0]);

		MyBinPackerTester tester = new MyBinPackerTester();

		OutDegreeAssignmentProblem hardwareTemplate = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		OutDegreeAssignmentProblem[] targets = new OutDegreeAssignmentProblem[4];

		for (int i = 0; i < targets.length; i++) {
			targets[i] = new OutDegreeAssignmentProblem(new OutDegreeComparator(), new BandwidthComparator(),
					new CapacityComparator());
		}

		CANBus canbus1M = new CANBus(1000000.0);
		CANBus canbus500k = new CANBus(500000.0);
		CANBus canbus100k = new CANBus(100000.0);

		NetInterface[] netInterfaces = new NetInterface[] { new NetInterface(canbus1M), new NetInterface(canbus500k),
				new NetInterface(canbus100k) };

		// set the power to limit number of links in ducts
		// netInterfaces[0].link.powerRequirement = 10.0;
		// netInterfaces[1].link.powerRequirement = 10.0;
		// netInterfaces[2].link.powerRequirement = 10.0;

		// we will use "space" to limit the number of links in ducts
		netInterfaces[0].getLink().spaceRequirement = 10.0;
		netInterfaces[1].getLink().spaceRequirement = 10.0;
		netInterfaces[2].getLink().spaceRequirement = 10.0;

		SiteGuest[] supportedHardware = new SiteGuest[13];
		SiteGuest[] supportedProcessors = new SiteGuest[10];
		SiteGuest[] supportedNets = new SiteGuest[3];
		long size = 100000000l;
		DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
		for (int i = 0; i < 10; i++) {
			supportedHardware[i] = new MPC555("", new EDFScheduler(new BandwidthComparator()), size, netInterfaces);
			// Set power requirements to limit the number of processors that can
			// fit.
			((HardwareNode) supportedHardware[i]).powerRequirement = 100.0;
			supportedProcessors[i] = supportedHardware[i];
			System.out.println("Processor Size(" + format.format(size) + ")");
			size += 100000000l;
		}
		supportedHardware[10] = netInterfaces[0].getLink();
		supportedHardware[11] = netInterfaces[1].getLink();
		supportedHardware[12] = netInterfaces[2].getLink();

		supportedNets[0] = netInterfaces[0].getLink();
		supportedNets[1] = netInterfaces[1].getLink();
		supportedNets[2] = netInterfaces[2].getLink();

		for (int i = 0; i < 100; i++) {
			hardwareTemplate.hardwareGraph
					.add(new MPC555("", new EDFScheduler(new BandwidthComparator()), 1000000000l, netInterfaces));

		}

		tester.createWorstFitSoftwareGraph(hardwareTemplate, targets, 250000, // minimum
																				// message
																				// bits
				250000, // maximum message bits
				1000000000, // minimum period (nanos)
				1000000000, // maximum period (nanos)
				2 // 4 // outDegree
		);

		// for (Iterator iter =
		// targets[0].softwareGraph.iterator();iter.hasNext();)
		// {
		// SoftwareNode n =(SoftwareNode) iter.next();
		// DebugMonitor.println(DebugMonitor.channels[0],
		// decFormat.format(n.getBandwidth()));
		// }

		for (int i = 0; i < targets.length; i++) {
			double totalDemand = 0.0;
			for (Iterator iter = targets[i].softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Original Software(" + i + ") Demand(" + decFormat.format(totalDemand)
					+ " cycles/s) number of Modules (" + targets[i].softwareGraph.size() + ")");
		}

		SiteArchitecture[] siteArchitectures = tester.createSiteArchitecture(targets.length, // number of clones
				4, // minimun number of sites
				4, // maximum number of sites
				2700, // minimum site power ceil(maxProcs(108) *
						// powerOfProc(100) / numSites(4)) = 2700
				2700, // maximum site power
				16250, // minimum site space
				16250, // maximum site space
				10, // minimum duct power just room for one links (10)
				10, // maximum duct power
				10000, // minimum duct space
				10000, // maximum duct space
				3, // minimum ducts per site
				3, // maximum ducts per site
				supportedHardware, // supportedProcessors, // supported
									// processors
				supportedNets // supported network links
		);

		for (int i = 0; i < targets.length; i++) {
			targets[i].siteArchitecture = siteArchitectures[i]; // new
																// SiteArchitecture();
			// targets[i].siteArchitecture.addSite(new Site(100.0, 100.0,
			// supportedHardware));
		}
		NFCExpansor expansor = new NFCExpansor();

		String[] prefixes = new String[] { "dfc", "dfb", "bfc" };

		LowLevelBinPacker[] packers = new LowLevelBinPacker[] { new DFCPBinPacker(expansor),
				new DFBPBinPacker(expansor), new BFCPBinPacker(expansor) };
		for (int i = 0; i < packers.length; i++) {
			LowLevelBinPacker lowPacker = packers[i];
			OutDegreeAssignmentProblem problem = targets[i];

			expansor.setSiteArchitecture(problem.siteArchitecture);
			NFCHoBinPacker packer = new NFCHoBinPacker(lowPacker);
			boolean res = packer.solve(problem);
			if (res) {
				tester.fitProcessors(problem);
				tester.fitLinks(problem);
			} else
				System.out.println("Failure Code(" + failureCode + ")");
			AssignmentResult result = new AssignmentResult(problem, res);
			Vector v = new Vector();
			v.add(result);

			double totalDemand = 0.0;
			for (Iterator iter = result.problem.softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Result(" + i + ") Software Demand(" + totalDemand + " cycles/s)");

			// tester.showResults(v,prefixes[i]);
			tester.saveStatistics(v, prefixes[i] + Integer.toString(round));
		}

		// DebugMonitor.println(DebugMonitor.channels[1], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[0]).numberOfPartitions));
		// DebugMonitor.println(DebugMonitor.channels[2], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[1]).numberOfPartitions));
		// DebugMonitor.println(DebugMonitor.channels[3], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[2]).numberOfPartitions));
	}

	public static void runWorstFitExperimentForExcessBinGuard(String args[]) {
		int round = Integer.parseInt(args[0]);

		MyBinPackerTester tester = new MyBinPackerTester();

		OutDegreeAssignmentProblem hardwareTemplate = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		OutDegreeAssignmentProblem diminishedHardwareTemplate = new OutDegreeAssignmentProblem(
				new OutDegreeComparator(), new BandwidthComparator(), new CapacityComparator());

		OutDegreeAssignmentProblem[] targets = new OutDegreeAssignmentProblem[4];

		for (int i = 0; i < targets.length; i++) {
			targets[i] = new OutDegreeAssignmentProblem(new OutDegreeComparator(), new BandwidthComparator(),
					new CapacityComparator());
		}

		CANBus canbus1M = new CANBus(1000000.0);
		CANBus canbus500k = new CANBus(500000.0);
		CANBus canbus100k = new CANBus(100000.0);

		NetInterface[] netInterfaces = new NetInterface[] { new NetInterface(canbus1M), new NetInterface(canbus500k),
				new NetInterface(canbus100k) };

		SiteGuest[] supportedHardware = new SiteGuest[13];
		long size = 100000000l;
		DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
		for (int i = 0; i < 10; i++) {
			supportedHardware[i] = new MPC555("", new EDFScheduler(new BandwidthComparator()), size, netInterfaces);
			System.out.println("Processor Size(" + format.format(size) + ")");
			size += 100000000l;
		}
		supportedHardware[10] = netInterfaces[0].getLink();
		supportedHardware[11] = netInterfaces[1].getLink();
		supportedHardware[12] = netInterfaces[2].getLink();

		for (int i = 0; i < 99; i++) {
			hardwareTemplate.hardwareGraph
					.add(new MPC555("", new EDFScheduler(new BandwidthComparator()), 1000000000l, netInterfaces));

		}

		int numberOfProcessors = 100;

		long diminishedProcessorSize = 1000000000l;// -
													// (1000000000l/numberOfProcessors);

		for (int i = 0; i < numberOfProcessors; i++) {
			diminishedHardwareTemplate.hardwareGraph.add(new MPC555("", new EDFScheduler(new BandwidthComparator()),
					diminishedProcessorSize, netInterfaces));

		}

		tester.createWorstFitSoftwareGraph(diminishedHardwareTemplate, // hardwareTemplate,
				targets, 512, // minimum message bits
				8000, // maximum message bits
				1000000000, // minimum period (nanos)
				1000000000, // maximum period (nanos)
				5 // outDegree
		);

		// for (Iterator iter =
		// targets[0].softwareGraph.iterator();iter.hasNext();)
		// {
		// SoftwareNode n =(SoftwareNode) iter.next();
		// DebugMonitor.println(DebugMonitor.channels[0],
		// decFormat.format(n.getBandwidth()));
		// }

		for (int i = 0; i < targets.length; i++) {
			double totalDemand = 0.0;
			for (Iterator iter = targets[i].softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Original Software(" + i + ") Demand(" + decFormat.format(totalDemand)
					+ " cycles/s) number of Modules (" + targets[i].softwareGraph.size() + ")");
		}

		for (int i = 0; i < targets.length; i++) {
			targets[i].siteArchitecture = new SiteArchitecture();
			targets[i].siteArchitecture.addSite(new Site(100.0, 100.0, supportedHardware));
		}

		NFCExpansor expansor = new NFCExpansor();

		String[] prefixes = new String[] { "bcn", "bcg" };

		LowLevelBinPacker[] packers = new LowLevelBinPacker[] { new BFCPBinPacker(expansor),
				new BFCPBinPacker(expansor) };

		// Guard disabled
		packers[0].setNominalBinSize(1000000000.0);
		packers[0].setBreakExcessBinObjectsOnly(false);

		// Guard enabled
		packers[1].setNominalBinSize(1000000000.0);
		packers[1].setBreakExcessBinObjectsOnly(true);

		for (int i = 0; i < packers.length; i++) {
			LowLevelBinPacker lowPacker = packers[i];
			OutDegreeAssignmentProblem problem = targets[i];

			expansor.setSiteArchitecture(problem.siteArchitecture);
			NFCHoBinPacker packer = new NFCHoBinPacker(lowPacker);
			boolean res = packer.solve(problem);
			if (res) {
				tester.fitProcessors(problem);
				tester.fitLinks(problem);
			} else
				System.out.println("Failure Code(" + failureCode + ")");

			AssignmentResult result = new AssignmentResult(problem, res);
			Vector v = new Vector();
			v.add(result);

			double totalDemand = 0.0;
			for (Iterator iter = result.problem.softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode n = (SoftwareNode) iter.next();
				totalDemand += n.getBandwidth();
			}

			System.out.println("Result(" + i + ") Software Demand(" + totalDemand + " cycles/s)");

			// tester.showResults(v,prefixes[i]);
			tester.saveStatistics(v, prefixes[i] + Integer.toString(round));
		}

		// DebugMonitor.println(DebugMonitor.channels[1], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[0]).numberOfPartitions));
		// DebugMonitor.println(DebugMonitor.channels[2], " total patitions
		// (events) =
		// "+Integer.toString(((BaseLowLevelBinPacker)packers[1]).numberOfPartitions));
	}

	public static void tryPerfectFit() {

		MyBinPackerTester tester = new MyBinPackerTester();

		OutDegreeAssignmentProblem hardwareTemplate = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());
		OutDegreeAssignmentProblem[] targets = new OutDegreeAssignmentProblem[4];

		for (int i = 0; i < 4; i++)
			targets[i] = new OutDegreeAssignmentProblem(new OutDegreeComparator(), new BandwidthComparator(),
					new CapacityComparator());

		CANBus canbus1M = new CANBus(1000000.0);
		CANBus canbus500k = new CANBus(500000.0);
		CANBus canbus100k = new CANBus(100000.0);

		NetInterface[] netInterfaces = new NetInterface[] { new NetInterface(canbus1M), new NetInterface(canbus500k),
				new NetInterface(canbus100k) };

		for (int i = 0; i < 100; i++) {
			hardwareTemplate.hardwareGraph
					.add(new MPC555("", new EDFScheduler(new BandwidthComparator()), 1000000000l, netInterfaces));
		}

		tester.createPerfectFitSoftwareGraph(hardwareTemplate, targets, 512, // minimum
																				// message
																				// bits
				8000, // maximum message bits
				1000000000, // minimum period (nanos)
				1000000000, // maximum period (nanos)
				5 // out degree
		);

		// PrintWriter writer = new PrintWriter(System.out);
		// hardwareTemplate.dumpHardwareText(writer, 0, 0, true);

		// target.dumpSoftGraphText(target.softwareGraph, writer, 0, 0, true);
		// writer.flush();

		double totalCapacity = 0.0;
		for (Iterator iter = hardwareTemplate.hardwareGraph.iterator(); iter.hasNext();) {
			HardwareNode node = (HardwareNode) iter.next();
			totalCapacity += node.getAvailableCapacity();
		}

		for (int i = 0; i < targets.length; i++) {
			double totalDemand = 0.0;
			for (Iterator iter = targets[i].softwareGraph.iterator(); iter.hasNext();) {
				SoftwareNode node = (SoftwareNode) iter.next();
				totalDemand += node.getBandwidth();
			}

			System.out.println("Total clone(" + i + ") Capacity(" + totalCapacity + ") Total Demand(" + totalDemand
					+ ") Gap(" + (totalCapacity - totalDemand) + ") #modules(" + targets[i].softwareGraph.size() + ")");
		}
		// writer.close();
	}

	public static void runTest(String args[]) {
		int round = Integer.parseInt(args[0]);
		// DebugMonitor.channels = new Channel[5];
		// DebugMonitor.channels[0] = DebugMonitor.createChannel("Module
		// Sizes");
		// DebugMonitor.channels[1] = DebugMonitor.createChannel("DFCP
		// Partitions");
		// DebugMonitor.channels[2] = DebugMonitor.createChannel("DFBP
		// Partitions");
		// DebugMonitor.channels[3] = DebugMonitor.createChannel("BFCP
		// Partitions");
		// DebugMonitor.channels[4] = DebugMonitor.createChannel("Hardware ->
		// Sites");

		MyBinPackerTester tester = new MyBinPackerTester();

		NFCExpansor expansor = new NFCExpansor();
		LowLevelBinPacker[] packers = new LowLevelBinPacker[3];
		packers[0] = new DFCPBinPacker(expansor);
		packers[1] = new DFBPBinPacker(expansor);
		packers[2] = new BFCPBinPacker(expansor);

		String[] prefixes = new String[] { "dfc", "dfb", "bfc" };

		// javax.swing.Timer timer=null;
		// ProgressMonitor progressMonitor = new
		// ProgressMonitor(null,"Deployment Progress","",0,100);
		// {
		// final ProgressMonitor progMonitor = progressMonitor;
		// timer = new javax.swing.Timer(3000, new ActionListener()
		// {
		// public void actionPerformed(ActionEvent evt)
		// {
		// progMonitor.setProgress(MyBinPackerTester.progress * 100 /
		// MyBinPackerTester.toDeploy);
		// }
		// }
		// );
		// }
		// timer.start();
		// progressMonitor.setMillisToDecideToPopup(0);
		for (int k = 0; k < 1; k++) {
			Vector v = tester.createSiteBasedExperiment(3, // number of clones
					1, // minimum number of sites
					1, // increment
					1, // factor
					1, // maximum sites
					300, // minimum power
					300, // maximum power
					10000, // minimum cycles per second
					10000, // cycles increment
					200000, // maximum cycles
					1000, // minimum duct power
					1000, // maximum duct power
					4, // minimum ducts per site
					4, // maximum ducts per site
					500, // minimum number of modules
					10, // module increment
					1, // module factor
					600, // maximum number of modules
					1000, // minimum cycles per module
					1000, // maximum cycles per module
					10000000, // minimum period (nanos)
					1000000000, // maximum period (nanos)
					1, // minimum messages per module
					1, // maximum messages per module
					1000, // minimum message size
					8000 // maximum message size
			);

			for (int i = 0; i < packers.length; i++) {
				System.out.print("Starting Experiment " + prefixes[i] + "...\r");
				Vector experiment = (Vector) v.get(i);
				// System.out.println("Experiment Size("+experiment.size()+")");

				// tester.showExperiments(experiment);

				Vector results = tester.runSiteBasedExperiment(experiment, packers[i], expansor);

				// tester.checkInconsistencies(experiment);

				// tester.showResults(results, "Before Fitting");
				// System.out.println("fiting experiments");

				tester.fitProcessors(experiment);

				// tester.checkInconsistencies(experiment);

				tester.fitLinks(experiment);

				// DebugMonitor.show();

				// tester.showResults(results,"After Fitting");

				tester.saveStatistics(results, prefixes[i] + Integer.toString(round));
				System.out.print("Starting Experiment " + prefixes[i] + Integer.toString(round) + "... DONE\n");
			}
		}
		// timer.stop();
		// progressMonitor.close();
		System.out.println("DONE");
		System.exit(0);
	}

	public static void SimpleTest() {
		NFCExpansor expansor = new NFCExpansor();
		BFCPBinPacker packer = new BFCPBinPacker(expansor);
		SiteArchitecture siteArchitecture = new SiteArchitecture();
		MPC555 supportedProcessor = new MPC555("anMPC555", // name of the
															// processor
				new EDFScheduler(new BandwidthComparator()), // scheduler to use
				1000000000l, // cycles per second
				new NetInterface[] { new NetInterface(new CANBus(1000000.0)) } // interfaces
																				// to
																				// links
		);
		MPC555 supportedProcessor1 = new MPC555("anMPC555", // name of the
															// processor
				new EDFScheduler(new BandwidthComparator()), // scheduler to use
				1000000000l, // cycles per second
				new NetInterface[] { new NetInterface(new CANBus(1000000.0)) } // interfaces
																				// to
																				// links
		);
		// supportedProcessor.requiredPower = 30.0;
		Site site = new Site(90.0, // power capacity for 3 processors
				100.0, // space capacity
				new SiteGuest[] { supportedProcessor, new CANBus(1000000.0) } // supported
																				// processors
		);
		siteArchitecture.addSite(site);
		expansor.setSiteArchitecture(siteArchitecture);
		OutDegreeAssignmentProblem problem = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());

		siteArchitecture.addSiteGuest(supportedProcessor, site);
		siteArchitecture.addSiteGuest(supportedProcessor1, site);

		problem.hardwareGraph.add(supportedProcessor);
		problem.hardwareGraph.add(supportedProcessor1);

		CANBus link = new CANBus(1000000.0);
		link.add(supportedProcessor);
		link.add(supportedProcessor1);
		problem.addLink(link);
		siteArchitecture.addSiteGuest(link, site);
		supportedProcessor.attachToLink(link);
		supportedProcessor1.attachToLink(link);

		SoftwareNode nA = new SoftwareNode(10, 50000, 50000, problem.bwComparator, "A");
		SoftwareNode nB = new SoftwareNode(10, 50000, 50000, problem.bwComparator, "B");
		SoftwareNode nC = new SoftwareNode(40, 100000, 100000, problem.bwComparator, "C");
		SoftwareNode nD = new SoftwareNode(5, 50000, 50000, problem.bwComparator, "D");
		SoftwareNode nE = new SoftwareNode(5, 50000, 50000, problem.bwComparator, "E");
		SoftwareNode nJ = new SoftwareNode(5, 50000, 50000, problem.bwComparator, "J");

		problem.softwareGraph.add(nA);
		problem.softwareGraph.add(nB);
		problem.softwareGraph.add(nC);
		problem.softwareGraph.add(nD);
		problem.softwareGraph.add(nE);
		problem.softwareGraph.add(nJ);

		Message m1 = new Message(64, 50000, 50000, nA, nC);
		problem.addMessage(m1);
		Message m2 = new Message(24, 50000, 50000, nB, nC);
		problem.addMessage(m2);
		Message m3 = new Message(10, 100000, 100000, nC, nD);
		problem.addMessage(m3);
		Message m4 = new Message(20, 100000, 100000, nC, nE);
		problem.addMessage(m4);
		Message m7 = new Message(20, 100000, 100000, nE, nJ);
		problem.addMessage(m7);

		SoftwareNode nF = new SoftwareNode(25, 100000, 100000, problem.bwComparator, "F");
		problem.softwareGraph.add(nF);

		SoftwareNode nG = new SoftwareNode(25, 100000, 100000, problem.bwComparator, "G");
		SoftwareNode nH = new SoftwareNode(60, 200000, 200000, problem.bwComparator, "H");
		SoftwareNode nI = new SoftwareNode(25, 100000, 100000, problem.bwComparator, "I");
		problem.softwareGraph.add(nG);
		problem.softwareGraph.add(nH);
		problem.softwareGraph.add(nI);

		Message m5 = new Message(30, 100000, 100000, nG, nH);
		problem.addMessage(m5);
		Message m6 = new Message(30, 100000, 100000, nH, nI);
		problem.addMessage(m6);

		// Constraints
		problem.addConstraint(new Joint(new SoftwareNode[] { nG, nF }));
		problem.addConstraint(new Disjoint(new SoftwareNode[] { nE, nJ }));

		NFCHoBinPacker highPacker = new NFCHoBinPacker(packer);
		boolean res = highPacker.solve(problem);
		Vector v = new Vector();
		v.add(new AssignmentResult(problem, res));
		MyBinPackerTester tester = new MyBinPackerTester();
		tester.showResults(v, "Simple Test");
		System.out.println("Result " + res);
	}
}