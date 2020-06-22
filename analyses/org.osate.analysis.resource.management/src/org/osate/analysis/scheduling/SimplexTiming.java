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
package org.osate.analysis.scheduling;

import java.util.Vector;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  this file contains some global values used in this package.
 *  the following is some comment or memo when I implemented the C++ version of
 *  of the algorithms:
 *
 *This SimplexTiming.cc mainly involves two algorithms:
 * 1. the schedulability analysis based on the worst case response time
 *    calculation considering the phase offset in the ARU;
 * 2. the correponding sensitivity analysis based on S. Vestal's sensitivity
 *    analysis algorithm. However, the phase offset is considered. Something
 *    needs to be paid attention is the following:
 *
 *    a) with any task i and a particular phase offset W(i,k)
 *       for any task j with a lower priority, for every calculation point S,
 *       the slacks XS(j,l) are calculated with different W(j,l), and then
 *       XS(j,S) = min(Xs(j,l,S)) since we want every S is committed.
 *       and the final XS = max {XS(j,S)}.
 *    b) The evaluation is such that: if task i has Deltai>0 and all tasks
 *       with lower priority than i are schedulable, then this task i can
 *       increase Deltai without any problem; If some task j with lower priority
 *       than i is not schedulable, than change execution time to Ci+Deltai
 *       with make all the tasks with lower priority than task i shedulable
 *       again.
 *
 *
 *        Jun Li
 *        Nov. 10, 1997
 *
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 *
 */
public class SimplexTiming {

	/** the flat of Exact or Tractable is that Exact = false , Tractable = true;
	*/
	private boolean exactOrTractable;
	private Vector ARCList;
	private Vector ProcessList;

	// trivial constructor
	public SimplexTiming() {
		ARCList = new Vector();
		ProcessList = new Vector();
	}

	public void setExactOrTractable(boolean flag) {
		exactOrTractable = flag;
	}

	public boolean getExactOrTractable() {
		return exactOrTractable;
	}

	public void cleanARCList() {
		ARCList.removeAllElements();
	}

	public void initilization() {
		RuntimeProcess process = new RuntimeProcess(39, 39, 9, 12, 7, 1);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(39, 39, 6, 27, 6, 1);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(178, 178, 47, 39, 5, 2);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(178, 178, 27, 76, 4, 2);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(700, 700, 60, 223, 3, 3);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(700, 700, 42, 129, 2, 3);
		addProcessToList(process, process.getARCID());

		process = new RuntimeProcess(800, 800, 32, 20, 1, 4);
		addProcessToList(process, process.getARCID());

		processStatusValidate();
	}

	public void addProcessToList(RuntimeProcess process, int ARCID) {
		Vector processList;
		boolean matched = false;

		for (int i = 0; i < ARCList.size(); i++) {
			ARC curARC = (ARC) ARCList.elementAt(i);
			if (curARC.getARCID() == ARCID) {
				matched = true;
				processList = curARC.getProcessList();
				processList.addElement(process);
			}
		}

		if (!matched) {
			ARC newARC = new ARC(ARCID);
			newARC.getProcessList().addElement(process);
			ARCList.addElement(newARC);
		}

	}

	public void processStatusValidate() {
		ARC arcInstance = null;
		RuntimeProcess processInstance = null;
		Vector processList = null;
		int counter;
		int period;
		double utilization = 0;

		System.out.println("period----deadline---execution time--phase--priority--ARC id");
		for (int i = 0; i < ARCList.size(); i++) {
			ARC curARC = (ARC) ARCList.elementAt(i);
			processList = curARC.getProcessList();
			counter = 0;
			period = -1;

			for (int j = 0; j < processList.size(); j++) {
				processInstance = (RuntimeProcess) processList.elementAt(j);
				utilization += (double) processInstance.getExecutionTime() / processInstance.getPeriod();
				counter++;

				System.out.println(processInstance.getPeriod() + "\t" + processInstance.getDeadline() + "\t"
						+ processInstance.getExecutionTime() + "\t" + processInstance.getPhaseOffset() + "\t"
						+ processInstance.getPriority() + "\t" + processInstance.getARCID());
				if (period == -1) {
					period = processInstance.getPeriod();
				} else {
					if (period != processInstance.getPeriod()) {
						System.err.println(" period discrepency detected in the ARC with id: " + curARC.getARCID());
					}
				}
			}
			System.out.println("....totally, number of Processes inside is: " + counter + "...." + "\n");
		}

		System.out.println(".......Utilization = " + utilization);

		if (utilization > 1.00) {
			System.out.println(" No Scheduling policy appropriate to this task set.");
			return;
		}
	}

	/** timing analysis return true if all the tasks are schedulable and false if
	 *  at least one task fails to meet the deadline.
	 */
	public boolean schedulabilityAnalysis() {
		int numberOfARCs;
		int numberOfProcesses, i, j, k, m, n;
		ARC arcInstance = null;
		Vector arrayInstance = null;
		Vector processList = null;
		RuntimeProcess processInstance = null;

		double w1, w2;
		DoubleArray phaseListInMySelfArray = null, phaseListNotInMySelfArray = null;
		DoubleArray responseArray = null, ARCResponseArray = null;
		double windowOffsetWithinMySelf, windowOffsetRelativeToMySelf;

		ARCForArray ARCElement = null, ARCEG = null;
		double response, ARCResponse;
		double maxResponseTime;
		int label = 1;
		double phaseMe, phaseOther;

		numberOfARCs = ARCList.size();
		System.out.println("number of ARCs is: " + numberOfARCs);

		arrayInstance = new Vector(numberOfARCs);

		for (i = 0; i < ARCList.size(); i++) {
			arcInstance = (ARC) ARCList.elementAt(i);
			processList = arcInstance.getProcessList();
			numberOfProcesses = processList.size();
			System.out.println("number of processes is:  " + numberOfProcesses);
			ARCElement = new ARCForArray(numberOfProcesses);
			for (j = 0; j < processList.size(); j++) {
				ARCElement.addProcess(j, (RuntimeProcess) processList.elementAt(j));
			}
			arrayInstance.addElement(ARCElement);
		}

		for (i = 0; i < arrayInstance.size(); i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				System.out.println("process: " + j + " in ARC: " + processInstance.getARCID() + " has priority of : "
						+ processInstance.getPriority() + " and period: " + processInstance.getPeriod());
			}
		}

		System.out.println(" next is the tractable timing analysis........");

		if (getExactOrTractable()) {
			for (i = 0; i < numberOfARCs; i++) {
				ARCElement = (ARCForArray) arrayInstance.elementAt(i);
				for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
					processInstance = ARCElement.getProcess(j);
					ARCResponseArray = new DoubleArray();
					phaseListInMySelfArray = phaseConstructionInARC(ARCElement, processInstance);

					for (n = 0; n < phaseListInMySelfArray.getNumberOfItemsInArray(); n++) {
						windowOffsetWithinMySelf = phaseListInMySelfArray.getItemInArray(n);
						w1 = processInstance.getExecutionTime();
						while (w1 < Global.TERMINATION_TIME) {
							w2 = processInstance.getExecutionTime();
							for (k = 0; k < numberOfARCs; k++) {
								ARCEG = (ARCForArray) arrayInstance.elementAt(k);
								phaseListNotInMySelfArray = phaseConstructionInARC(ARCEG, processInstance);
								if (phaseListNotInMySelfArray.getNumberOfItemsInArray() > 0) {
									responseArray = new DoubleArray();
									for (m = 0; m < phaseListNotInMySelfArray.getNumberOfItemsInArray(); m++) {
										windowOffsetRelativeToMySelf = phaseListNotInMySelfArray.getItemInArray(m);
										System.out.println("...phase in the loop to check ZERO is: "
												+ windowOffsetRelativeToMySelf);
										response = Auxillary.processOtherThanMySelfContribution(w1,
												windowOffsetWithinMySelf, windowOffsetRelativeToMySelf, processInstance,
												(ARCForArray) arrayInstance.elementAt(k));
										System.out.println("\t\t\t\t....response is: " + response);
										responseArray.addItemInArray(response);
									}
									System.out.println("\t\t get out of this inner loop already");
									response = findMaxOrMinInList(responseArray, true);
									System.out.println("the response after MaxMin routine is: " + response);
									phaseListNotInMySelfArray.removeItems();
									w2 += response;
								}
							}

							if (java.lang.Math.abs(w2 - w1) < 1.0) {
								w1 = w2;
								break;
							} else {
								w1 = w2;
							}
						}

						System.out.println("\t\t\t\t the result of W1 finally is: " + w1);

						ARCResponse = w1 + windowOffsetWithinMySelf;
						ARCResponseArray.addItemInArray(ARCResponse);
					}

					maxResponseTime = findMaxOrMinInList(ARCResponseArray, true);
					ARCResponseArray.removeItems();
					processInstance.setMaxResponseTime(maxResponseTime);
					if (maxResponseTime <= processInstance.getDeadline()) {
						processInstance.setSchedulability(true);
					} else {
						processInstance.setSchedulability(false);
					}

					((ARCForArray) arrayInstance.elementAt(i)).setProcess(j, processInstance);

					phaseListInMySelfArray.removeItems();
				}
			} // end of all process scanning.

			// put back to the list...
			for (i = 0; i < ARCList.size(); i++) {
				arcInstance = (ARC) ARCList.elementAt(i);
				processList = arcInstance.getProcessList();
				// I can not purget completely down to the detailed objects.
				processList.removeAllElements();
				ARCForArray t = (ARCForArray) arrayInstance.elementAt(i);
				for (j = 0; j < t.getNumberOfProcesses(); j++) {
					RuntimeProcess tp = t.getProcess(j);
					processList.addElement(tp);
					processInstance = t.getProcess(j);
					System.out.println("process: " + tp.getComponentName() + " in ARC: " + i + " with priority: "
							+ processInstance.getPriority() + " is "
							+ (processInstance.getSchedulability() ? "" : "not ") + "schedulable"
							+ " with response time (- offset): "
							+ (processInstance.getMaxResponseTime() - processInstance.getPhaseOffset()));
					if (processInstance.getSchedulability() == false) {
						label = 0;
					}
				}
			}
		} else {
			System.out.println("Sorry, the Exact Analysis is not feasible for BIG system...");

		}

		return (label == 1);
	}

	public DoubleArray phaseConstructionInARC(ARCForArray element, RuntimeProcess processInstance) {
		int numberOfProcesses = element.getNumberOfProcesses();
		int i, j;
		double phase;
		RuntimeProcess process;
		DoubleArray phaseArray = new DoubleArray();

		Vector tempPhase = new Vector(numberOfProcesses);

		for (i = 0; i < numberOfProcesses; i++) {
			process = element.getProcess(i);
			if ((Auxillary.compareNotMySelf(process, processInstance) == false)
					|| (process.getPriority() > processInstance.getPriority())) {
				tempPhase.addElement(new Double(Auxillary.phaseConversion(process, processInstance)));
			} else {
				tempPhase.addElement(new Double(Global.NEGATIVE_MAX));
			}
		}

		for (i = 0; i < numberOfProcesses; i++) {
			for (j = i + 1; j < numberOfProcesses; j++) {
				double t1 = ((Double) tempPhase.elementAt(i)).doubleValue();
				double t2 = ((Double) tempPhase.elementAt(j)).doubleValue();
				if ((java.lang.Math.abs(t1 - t2) < 0.5) && (!(t1 < Global.NEGATIVE_MAX / 2))) {
					tempPhase.setElementAt(new Double(Global.NEGATIVE_MAX), j);
				}
			}
		}

		for (i = 0; i < numberOfProcesses; i++) {
			phase = ((Double) tempPhase.elementAt(i)).doubleValue();
			if (!(phase < Global.NEGATIVE_MAX / 2)) {
				phaseArray.addItemInArray(phase);
			}
		}

		tempPhase.removeAllElements();
		return (phaseArray);
	}

	public double findMaxOrMinInList(DoubleArray array, boolean switches) {

		double maxOrMin;
		double element;
		int i;

		if (switches) {
			maxOrMin = Global.NEGATIVE_MAX;
			for (i = 0; i < array.getNumberOfItemsInArray(); i++) {
				element = array.getItemInArray(i);
				if (element > maxOrMin) {
					maxOrMin = element;
				}
			}
		} else {
			maxOrMin = Global.POSITIVE_MAX;
			for (i = 0; i < array.getNumberOfItemsInArray(); i++) {
				element = array.getItemInArray(i);
				if (element < maxOrMin) {
					maxOrMin = element;
				}
			}
		}

		System.out.println(" the Max or Min in the final stage is: " + maxOrMin);
		return (maxOrMin);
	}

	public DoubleArray giveMeSList(Vector arrayInstance, int numberOfARCs, RuntimeProcess process,
			double windowOffsetWithinMySelf) {
		ARCForArray ARCElement = null;
		RuntimeProcess processInstance = null;
		int i, j, k, l, counterLimit, z;
		double lowRange, highRange;
		double tentativePoint;
		DoubleArray phaseArray = new DoubleArray();
		DoubleArray returnArray = new DoubleArray();

		lowRange = -windowOffsetWithinMySelf;
		if (lowRange < 0) {
			lowRange = 0;
		}
		highRange = process.getDeadline() - windowOffsetWithinMySelf;

		returnArray.addItemInArray(highRange);
		for (i = 0; i < numberOfARCs; i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				if (processInstance.getPriority() > process.getPriority()) {
					if (processInstance.getARCID() == process.getARCID()) {
						phaseArray.addItemInArray(windowOffsetWithinMySelf);
					} else {
						phaseArray = phaseConstructionInARC(ARCElement, process);
					}
					// ------------------------------------------------------
					System.out.println("the number of possible phases is:  " + phaseArray.getNumberOfItemsInArray());
					for (z = 0; z < phaseArray.getNumberOfItemsInArray(); z++) {
						System.out.println("::: " + phaseArray.getItemInArray(z) + "::");
					}
					counterLimit = (int) java.lang.Math
							.ceil(((double) (process.getDeadline() + process.getPeriod()))
									/ processInstance.getPeriod())
							+ 1;
					// --------------------------------------------------------
					for (k = 0; k < counterLimit; k++) {
						for (l = 0; l < phaseArray.getNumberOfItemsInArray(); l++) {
							tentativePoint = k * processInstance.getPeriod() - phaseArray.getItemInArray(l)
									+ Auxillary.phaseConversion(processInstance, process);
							if ((tentativePoint > lowRange) && (tentativePoint <= highRange)) {
								returnArray.addItemInArray(tentativePoint);
							}
						}
					}
					phaseArray.removeItems();
				}
			}
		}

		for (k = 0; k < returnArray.getNumberOfItemsInArray(); k++) {
			System.out.println("  " + returnArray.getItemInArray(k));
		}
		System.out.println(" come back to the caller from giveMeSList");

		return returnArray;
	}

	public void sensitivityAnalysis() {
		ARC arcInstance = null;
		RuntimeProcess processInstance = null;
		Vector processList = null;
		int numberOfARCs;
		int numberOfProcesses;
		Vector arrayInstance = null;
		ARCForArray ARCElement = null;
		int i, j, k, l, m, counter, iz;

		Vector firstLevelArray = null, secondLevelArray = null, thirdLevelArray = null;
		DoubleArray phaseArray = null;
		double instancePhase, delta;
		double sensitivity;

		numberOfARCs = ARCList.size();
		arrayInstance = new Vector(numberOfARCs);

		for (i = 0; i < numberOfARCs; i++) {
			arcInstance = (ARC) ARCList.elementAt(i);
			processList = arcInstance.getProcessList();
			numberOfProcesses = processList.size();
			ARCElement = new ARCForArray(numberOfProcesses);

			for (j = 0; j < processList.size(); j++) {
				ARCElement.addProcess(j, (RuntimeProcess) processList.elementAt(j));
			}
			arrayInstance.addElement(ARCElement);
		}

		for (i = 0; i < numberOfARCs; i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				System.out.println("process: " + j + " in ARC: " + i + " has priority of : "
						+ processInstance.getPriority() + " and period: " + processInstance.getPeriod());
			}
		}

		counter = 0;

		for (i = 0; i < numberOfARCs; i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				processInstance.setCoordinate(counter);
				ARCElement.setProcess(j, processInstance);
				counter++;
			}
		}

		firstLevelArray = new Vector(counter);
		secondLevelArray = new Vector(counter);
		thirdLevelArray = new Vector(counter);
		// creation
		for (i = 0; i < counter; i++) {
			firstLevelArray.addElement(new DoubleArray());
			secondLevelArray.addElement(new DoubleArray());
			thirdLevelArray.addElement(new DoubleArray());
		}

		for (i = 0; i < numberOfARCs; i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				phaseArray = phaseConstructionInARC(ARCElement, processInstance);
				for (l = 0; l < phaseArray.getNumberOfItemsInArray(); l++) {
					instancePhase = phaseArray.getItemInArray(l);

					constructFirstLevelArray(arrayInstance, numberOfARCs, processInstance, instancePhase, counter,
							firstLevelArray);
					for (m = 0; m < counter; m++) {
						if (((DoubleArray) firstLevelArray.elementAt(m)).getNumberOfItemsInArray() > 0) {
							delta = findMaxOrMinInList((DoubleArray) firstLevelArray.elementAt(m), true); // max
							System.out.println("..........." + m + " .................." + delta);
							((DoubleArray) firstLevelArray.elementAt(m)).removeItems();
							((DoubleArray) secondLevelArray.elementAt(m)).addItemInArray(delta);
						}
					}
				} // end of the phase loop.

				phaseArray.removeItems();

				// now the phase issue
				for (m = 0; m < counter; m++) {
					DoubleArray t = (DoubleArray) secondLevelArray.elementAt(m);
					if (t.getNumberOfItemsInArray() > 0) {
						delta = findMaxOrMinInList(t, false); // min
						System.out.println("-----------" + m + "-------------------" + delta);
						t.removeItems();
						((DoubleArray) thirdLevelArray.elementAt(m)).addItemInArray(delta);
					}
				}
			} // end of the looping of all the processes....
		}

		// now the sensitivity is described by the MiniMum of thirdLevelArray.
		counter = 0;
		for (i = 0; i < numberOfARCs; i++) {
			ARCElement = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
				processInstance = ARCElement.getProcess(j);
				DoubleArray t = (DoubleArray) thirdLevelArray.elementAt(counter);
				if (t.getNumberOfItemsInArray() == 0) {
					System.err.println("hwe can the sensitivity analysis with zero or less candidates...");
				} else {
					sensitivity = findMaxOrMinInList(t, false);
					t.removeItems();
					processInstance.setSensitivity(sensitivity);
					((ARCForArray) arrayInstance.elementAt(i)).setProcess(j, processInstance);
				}
				counter++;
			}
		} // end of processing of the whole set of processes....

		for (i = 0; i < ARCList.size(); i++) {
			arcInstance = (ARC) ARCList.elementAt(i);
			processList = arcInstance.getProcessList();
			processList.removeAllElements();

			ARCForArray t = (ARCForArray) arrayInstance.elementAt(i);
			for (j = 0; j < t.getNumberOfProcesses(); j++) {
				RuntimeProcess temp = t.getProcess(j);
				processList.addElement(temp);
				System.out.println(
						" process: " + j + " in ARC : " + i + " has sensitivity margin of : " + temp.getSensitivity()
								+ " and response time of: " + (temp.getMaxResponseTime() - temp.getPhaseOffset())
								+ " and schedulable or not: " + temp.getSchedulability());
			}
		}

		firstLevelArray.removeAllElements();
		secondLevelArray.removeAllElements();
		thirdLevelArray.removeAllElements();

	}

	/**@param firstLevelArray has been initilized and create memory space already in the caller side
	*/
	public void constructFirstLevelArray(Vector arrayInstance, int numberOfARCs, RuntimeProcess process, double phase,
			int totalProcess, Vector firstLevelArray) {

		Vector phasePossibleArray = null;
		DoubleArray timePoints = null;
		int i, j, k, l, m, n, ARCPos, processPos, iz;
		double xz;
		int desired, counter;
		ARCForArray ARCElement = null;
		RuntimeProcess processInstance = null;
		Vector phaseDesiredArray = null;
		double timePoint, summation;
		DoubleArray responseArray;

		double difference, newDifference, localDelta, gDiff;
		double zeroPrevent;
		double response, recoverPhase, recoverResponse, variedPhase, renewResponse;
		DoubleArray newDifferenceArray = null;

		timePoints = giveMeSList(arrayInstance, numberOfARCs, process, phase);
		if (timePoints.getNumberOfItemsInArray() == 0) {
			return;
		}
		System.out.println(" number of points in array " + timePoints.getNumberOfItemsInArray());

		for (i = 0; i < timePoints.getNumberOfItemsInArray(); i++) {
			System.out.print("++++" + timePoints.getItemInArray(i) + "++");
			System.out.print("\n");

			phasePossibleArray = new Vector(numberOfARCs);
			phaseDesiredArray = new Vector(numberOfARCs);

			for (i = 0; i < numberOfARCs; i++) {
				ARCElement = (ARCForArray) arrayInstance.elementAt(i);
				processInstance = ARCElement.getProcess(0);
				phaseDesiredArray.addElement(new DoubleArray());
				if (processInstance.getARCID() == process.getARCID()) {
					DoubleArray tarray = new DoubleArray();
					tarray.addItemInArray(phase);
					phasePossibleArray.insertElementAt(tarray, i);
				} else {
					phasePossibleArray.insertElementAt(phaseConstructionInARC(ARCElement, process), i);
				}
				ARCElement.setCoordinate(i);
			}

			for (i = 0; i < numberOfARCs; i++) {
				ARCElement = (ARCForArray) arrayInstance.elementAt(i);
				DoubleArray t = (DoubleArray) phasePossibleArray.elementAt(i);
				if (t.getNumberOfItemsInArray() > 0) {
					for (j = 0; j < t.getNumberOfItemsInArray(); j++) {
						System.out.print(t.getItemInArray(j));
					}
					System.out.print("\n");
				}
			}

			responseArray = new DoubleArray();
			newDifferenceArray = new DoubleArray();

			System.out.println(" number of time points is: " + timePoints.getNumberOfItemsInArray());

			for (l = 0; l < timePoints.getNumberOfItemsInArray(); l++) {
				timePoint = timePoints.getItemInArray(l);
				summation = process.getExecutionTime();
				for (i = 0; i < numberOfARCs; i++) {
					ARCElement = (ARCForArray) arrayInstance.elementAt(i);
					processInstance = ARCElement.getProcess(0);
					ARCPos = ARCElement.getCoordinate();
					if (processInstance.getARCID() == process.getARCID()) {
						summation += Auxillary.processOtherThanMySelfContribution(timePoint, phase, 0, process,
								ARCElement);
						((DoubleArray) phaseDesiredArray.elementAt(ARCPos)).addItemInArray(phase);
					} else {
						DoubleArray t = (DoubleArray) phasePossibleArray.elementAt(ARCPos);
						for (m = 0; m < t.getNumberOfItemsInArray(); m++) {
							variedPhase = t.getItemInArray(m);
							response = Auxillary.processOtherThanMySelfContribution(timePoint, phase, variedPhase,
									process, ARCElement);
							responseArray.addItemInArray(response);
						}

						desired = 0; // to make the compiler happier.
						if (responseArray.getNumberOfItemsInArray() > 0) {
							response = Global.NEGATIVE_MAX;
							for (k = 0; k < responseArray.getNumberOfItemsInArray(); k++) {
								if (responseArray.getItemInArray(k) > response) {
									response = responseArray.getItemInArray(k);
									desired = k;
								}
							}
							responseArray.removeItems();
							summation += response;

							xz = ((DoubleArray) phasePossibleArray.elementAt(ARCPos)).getItemInArray(desired);
							((DoubleArray) phaseDesiredArray.elementAt(ARCPos)).addItemInArray(xz);
						}
					}
				}

				difference = timePoint - summation;
				for (i = 0; i < numberOfARCs; i++) {
					ARCElement = (ARCForArray) arrayInstance.elementAt(i);
					for (j = 0; j < ARCElement.getNumberOfProcesses(); j++) {
						processInstance = ARCElement.getProcess(j);
						if (Auxillary.compareNotMySelf(process, processInstance) == false) {
							processPos = process.getCoordinate();
							((DoubleArray) firstLevelArray.elementAt(processPos)).addItemInArray(difference);
						} else {
							ARCPos = ARCElement.getCoordinate();
							processPos = processInstance.getCoordinate();
							if (processInstance.getPriority() > process.getPriority()) {
								recoverPhase = ((DoubleArray) phaseDesiredArray.elementAt(ARCPos)).getItemInArray(0);
								recoverResponse = Auxillary.processOtherThanMySelfContribution(timePoint, phase,
										recoverPhase, process, ARCElement);
								for (n = 0; n < ((DoubleArray) phasePossibleArray.elementAt(ARCPos))
										.getNumberOfItemsInArray(); n++) {
									variedPhase = ((DoubleArray) phasePossibleArray.elementAt(ARCPos))
											.getItemInArray(n);
									renewResponse = Auxillary.processOtherThanMySelfContribution(timePoint, phase,
											variedPhase, process, ARCElement);
									newDifference = difference + recoverResponse - renewResponse;
									zeroPrevent = Auxillary.processInARCContribution(timePoint, variedPhase,
											processInstance, process) / processInstance.getExecutionTime();
									if (java.lang.Math.abs(zeroPrevent) > 1.0e-6) {
										localDelta = newDifference / zeroPrevent;
										newDifferenceArray.addItemInArray(localDelta);
									}
								}
								if (newDifferenceArray.getNumberOfItemsInArray() > 0) {
									newDifference = findMaxOrMinInList(newDifferenceArray, false);
									newDifferenceArray.removeItems();
									((DoubleArray) firstLevelArray.elementAt(processPos)).addItemInArray(newDifference);
								}
							}
						} // end of else
					}
				} // end of for (i=0;i< numberOfARCs; i++)...

				for (i = 0; i < numberOfARCs; i++) {
					if (((DoubleArray) phaseDesiredArray.elementAt(i)).getNumberOfItemsInArray() > 0) {
						((DoubleArray) phaseDesiredArray.elementAt(i)).removeItems();
					}
				}
			} // end of all the time points....

			timePoints.removeItems();
		}
	}

}