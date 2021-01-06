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
package org.osate.analysis.resource.budgets.notbound;

import java.util.Deque;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.resource.budgets.internal.notbound.model.Budget;
import org.osate.analysis.resource.budgets.internal.notbound.model.Component;
import org.osate.analysis.resource.budgets.internal.notbound.model.MIPS;
import org.osate.analysis.resource.budgets.internal.notbound.model.Memory;
import org.osate.analysis.resource.budgets.internal.notbound.model.NotBoundModel;
import org.osate.analysis.resource.budgets.internal.notbound.model.ProcessorOrVirtualProcessor;
import org.osate.analysis.resource.budgets.internal.notbound.model.SubComponent;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;
import org.osate.analysis.resource.budgets.logic.GenericAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * Class for performing "not bound resource" analysis on a system.  Basically it makes sure all the connections and buses
 * have enough actual capacity to carry the data loads bound to them.
 *
 * <p>The format for the returned {@code AnalysisResult} object is as follows:
 *
 * <p>For the {@code AnalysisResult} object itself:
 * <ul>
 *   <li>analysis = "Not Bound Resources"
 *   <li>modelElement = {@code SystemInstance} being analyzed
 *   <li>resultType = SUCCESS
 *   <li>message = "Not bound resource analysis of ..."
 *   <li>diagnostics = empty list
 *   <li>parameters = empty list
 *   <li>results = one {@code Result} for each system operation mode
 *     <ul>
 *       <li>modelElement = {@code SystemOperationMode} instance object
 *       <li>resultType = SUCCESS
 *       <li>message = "" if the SOM is {@code null} or the empty SOM, otherwise "(xxx, ..., yyy)"
 *       <li>values = empty list
 *       <li>diagnostics = empty list
 *       <li>subResults = one {@code Result} for category of {@code Memory}
 *         <ul>
 *           <li>modelElement = {@code ComponentInstance} instance object
 *           <li>resultType = SUCCESS
 *           <li>message = The component's name from {@link ComponentInstance#getName()}
 *
 *           <li>values[0] = ComponentInstance category "Memory" (StringValue)
 *           <li>values[1] = SOM name (StringValue)
 *           <li>values[2] = Budget for Memory string in Kbytes (StringValue)
 *           <li>values[3] = Budget for RAM string in Kbytes (StringValue)
 *           <li>values[4] = Budget for ROM string in Kbytes (StringValue)
 *           <li>values[5] = Component category name from {@link ComponentInstance#getCategory()} (StringValue)
 *           <li>values[6] = Component path from {@link ComponentInstance#getComponentInstancePath()} (StringValue)
 *        	 <li>values[7] = Budget for Memory in Kbytes (RealValue)
 *           <li>values[8] = Budget for RAM in Kbytes (RealValue)
 *           <li>values[9] = Budget for ROM in Kbytes (RealValue)
 *           <li>values[10] = Capacity for Memory in Kbytes (RealValue)
 *           <li>values[11] = Capacity for RAM in Kbytes (RealValue)
 *           <li>values[12] = Capacity for ROM in Kbytes (RealValue)
 *           <li>diagnostics = Diagnostics associated with this memory.
 *           <li>subResults = one {@code Result} for each capacity
 *           	<ul>
	 *           	<li>values[0] = Capacity (RealValue)
	 *           	<li>values[1] = Capacity with unit (StringValue)
	 *           	<li>values[2] = Category: Memory, RAM or ROM (StringValue)
	 *           </ul>
 *         </ul>
 *       <li>subResults = one {@code Result} for category of {@code MIPS}
 *         <ul>
 *           <li>modelElement = {@code ComponentInstance} instance object
 *           <li>resultType = SUCCESS
 *           <li>message = The component's name from {@link ComponentInstance#getName()}
 *
 *           <li>values[0] = ComponentInstance category "MIPS" (StringValue)
 *           <li>values[1] = SOM name (StringValue)
 *           <li>values[2] = Budget string in MIPS (StringValue)
 *           <li>values[3] = Component category name from {@link ComponentInstance#getCategory()} (StringValue)
 *           <li>values[4] = Component path from {@link ComponentInstance#getComponentInstancePath()} (StringValue)
 *        	 <li>values[5] = Total budget in MIPS (RealValue)
 *           <li>values[6] = Total capacity in MIPS (RealValue)
 *           <li>diagnostics = Diagnostics associated with this mips.
 *           <li>subResults per each MIPS component
	 *           <ul>
	 *           	<li>values[0] = Budget subtotal for MIPS Component (RealValue)
	 *           	<li>values[1] = Actual budget for MIPS Component (RealValue)
	 *           	<li>values[2] = Notes on how budget and actual budget compare to each other (StringValue)
	 *              <li>values[3] = Resource name (StringValue)
	 *              <li>values[4] = Budget message (StringValue)
	 *              <li>values[5] = Actual budget message (StringValue)
	 *           </ul>
 *         </ul>
 *       <li>subResults = one {@code Result} for category of {@code ProcessorOrVirtualProcessor}
 *         <ul>
 *           <li>modelElement = {@code ComponentInstance} instance object
 *           <li>resultType = SUCCESS
 *           <li>message = The component's name from {@link ComponentInstance#getName()}
 *
 *           <li>values[0] = ComponentInstance category "MIPS" (StringValue)
 *           <li>values[1] = SOM name (StringValue)
 *           <li>values[2] = Total capacity for processor in MIPS (StringValue)
 *           <li>values[3] = Total capacity for virtual processor in MIPS (StringValue)
 *           <li>values[4] = Component path from {@link ComponentInstance#getComponentInstancePath()} (StringValue)
 *           <li>diagnostics is empty
 *           <li>subResults per each Processor and Virtual Processor component
	 *           <ul>
	 *           	<li>values[0] = ComponentInstance category name (StringValue)
	 *           	<li>values[1] = Capacity of Processor or Virtual Processor Component (RealValue)
	 *           	<li>values[2] = Capacity with unit (StringValue)
	 *              <li>values[3] = Component path from {@link ComponentInstance#getComponentInstancePath()} (StringValue)
	 *           </ul>
 *         </ul>
 *     </ul>
 * </ul>
 */

public class NewNotBoundResoureAnalysis extends GenericAnalysis {
	public NewNotBoundResoureAnalysis() {
		super();
	}

	public AnalysisResult invoke(final IProgressMonitor monitor, final SystemInstance systemInstance) {
		final IProgressMonitor pm = monitor == null ? new NullProgressMonitor() : monitor;
		return analyzeBody(pm, systemInstance);
	}

	private AnalysisResult analyzeBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Not  Bound", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Not bound resource analysis of " + root.getFullName());

			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final Result somResult = ResultUtil.createResult(
						Aadl2Util.isPrintableSOMName(som) ? Aadl2Util.getPrintableSOMMembers(som) : "", som,
						ResultType.SUCCESS);
				analysisResult.getResults().add(somResult);
				final NotBoundModel model = NotBoundModel.buildModel(root, som);

				// Analyze the model
				model.visit(new NotBoundAnalysisVisitor(somResult));
			}
			monitor.done();

			return analysisResult;
		} else {
			Dialog.showError("Not Bound Resource Analysis Error", "Can only check system instances");
			return null;
		}
	}

	// ==== Analysis Visitor ====

	private class NotBoundAnalysisVisitor implements Visitor {
		private Deque<Result> previousResult = new LinkedList<>();
		private Result currentResult;

		public NotBoundAnalysisVisitor(final Result rootResult) {
			this.currentResult = rootResult;
		}

		@Override
		public void visitMemoryPrefix(final Memory memory) {
			final ComponentInstance memInstance = memory.getComponentInstance();

			// Create a new result object for the memory
			final Result memResult = ResultUtil.createResult(memInstance.getName(), memInstance, ResultType.SUCCESS);
			currentResult.getSubResults().add(memResult);
			previousResult.push(currentResult);
			currentResult = memResult;
		}

		@Override
		public void visitMemoryPostfix(final Memory memory) {
			// unroll the result stack
			final Result memResult = currentResult;
			currentResult = previousResult.pop();

			UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(memory.getSystemInstance());

			for (final Component c : memory.getComponents()) {
				for (final SubComponent m : c.getMemories()) {
					double capacity = m.getCapacity();
					if (capacity > 0) {
						memory.setCapacityResourcesMemory(memory.getCapacityResourcesMemory() + 1);
					}

					/*
					 * String budgetmsg = GetProperties.toStringScaled(budget, unit) + ",";
					 * String front = ci == null ? "Total" : ci.getCategory().getName() + " " + ci.getComponentInstancePath();
					 * errManager.logInfo(front + ", " + budgetmsg);
					 */

					final Result capResult = ResultUtil.createResult(c.getLabel(), c.getComponentInstance(),
							ResultType.SUCCESS);
					ResultUtil.addRealValue(capResult, capacity);
					ResultUtil.addStringValue(capResult, GetProperties.toStringScaled(capacity, kbliteral));
					ResultUtil.addStringValue(capResult, "Memory");
					memResult.getSubResults().add(capResult);

					memory.setTotalCapacityMemory(memory.getTotalCapacityMemory() + capacity);
					memory.setResourcesMemory(memory.getResourcesMemory() + 1);
					for (final Budget b : m.getBudgetList()) {
						memory.setComponentsMemory(memory.getComponentsMemory() + b.getComponentsCount());
						memory.setBudgetedComponentsMemory(
								memory.getBudgetedComponentsMemory() + b.getBudgetedComponentsCount());
					}
				}

				for (final SubComponent ra : c.getRAMs()) {
					double capacity = ra.getCapacity();
					if (capacity > 0) {
						memory.setCapacityResourcesRAM(memory.getCapacityResourcesRAM() + 1);
					}

					memory.setTotalCapacityRAM(memory.getTotalCapacityRAM() + capacity);
					memory.setResourcesRAM(memory.getResourcesRAM() + 1);
					for (final Budget b : ra.getBudgetList()) {
						memory.setComponentsRAM(memory.getComponentsRAM() + b.getComponentsCount());
						memory.setBudgetedComponentsRAM(
								memory.getBudgetedComponentsRAM() + b.getBudgetedComponentsCount());
					}
				}

				for (final SubComponent ro : c.getROMs()) {
					double capacity = ro.getCapacity();
					if (capacity > 0) {
						memory.setCapacityResourcesROM(memory.getCapacityResourcesROM() + 1);
					}

					memory.setTotalCapacityROM(memory.getTotalCapacityROM() + capacity);
					memory.setResourcesROM(memory.getResourcesROM() + 1);
					for (final Budget b : ro.getBudgetList()) {
						memory.setComponentsROM(memory.getComponentsROM() + b.getComponentsCount());
						memory.setBudgetedComponentsROM(
								memory.getBudgetedComponentsROM() + b.getBudgetedComponentsCount());
					}
				}
			}

			for (final Component c : memory.getComponents()) {
				if (memory.getTotalCapacityMemory() > 0) {
					for (final SubComponent m : c.getMemories()) {
						for (final Budget b : m.getBudgetList()) {
							memory.setTotalBudgetMemory(memory.getTotalBudgetMemory() + b.getBudget());

							double budgetSub = b.getBudgetSub();
							double budgetSubtotal = b.getBudgetSubtotal();

							if (budgetSub > 0 && budgetSubtotal > budgetSub) {
								error(memResult, memory.getComponentInstance(),
										String.format(
												"Subtotal/actual exceeds budget %.3f by %.3f " + kbliteral.getName(),
												budgetSub, (budgetSubtotal - budgetSub)));
							}
						}
					}
				}

				if (memory.getTotalCapacityRAM() > 0) {
					for (final SubComponent ra : c.getRAMs()) {
						for (final Budget b : ra.getBudgetList()) {
							memory.setTotalBudgetRAM(memory.getTotalBudgetRAM() + b.getBudget());

							double budgetSub = b.getBudgetSub();
							double budgetSubtotal = b.getBudgetSubtotal();

							if (budgetSub > 0 && budgetSubtotal > budgetSub) {
								error(memResult, memory.getComponentInstance(),
										String.format(
												"Subtotal/actual exceeds budget %.3f by %.3f " + kbliteral.getName(),
												budgetSub, (budgetSubtotal - budgetSub)));
							}
						}
					}
				}

				if (memory.getTotalCapacityROM() > 0) {
					for (final SubComponent ro : c.getROMs()) {
						for (final Budget b : ro.getBudgetList()) {
							memory.setTotalBudgetROM(memory.getTotalBudgetROM() + b.getBudget());

							double budgetSub = b.getBudgetSub();
							double budgetSubtotal = b.getBudgetSubtotal();

							if (budgetSub > 0 && budgetSubtotal > budgetSub) {
								error(memResult, memory.getComponentInstance(),
										String.format(
												"Subtotal/actual exceeds budget %.3f by %.3f " + kbliteral.getName(),
												budgetSub, (budgetSubtotal - budgetSub)));
							}
						}
					}
				}
			}

			ComponentInstance ci = memory.getComponentInstance();

			ResultUtil.addStringValue(memResult, "Memory"); // category
			ResultUtil.addStringValue(memResult, memory.getSomName()); // somName

			ResultUtil.addStringValue(memResult,
					GetProperties.toStringScaled(memory.getTotalCapacityMemory(), kbliteral)); // budget for Memory string in Kbytes
			ResultUtil.addStringValue(memResult, GetProperties.toStringScaled(memory.getTotalCapacityRAM(), kbliteral)); // budget for RAM string in Kbytes
			ResultUtil.addStringValue(memResult, GetProperties.toStringScaled(memory.getTotalCapacityROM(), kbliteral)); // budget for ROM string in Kbytes

			ResultUtil.addStringValue(memResult, ci.getCategory().getName()); // component category name
			ResultUtil.addStringValue(memResult, ci.getComponentInstancePath()); // component path

			ResultUtil.addRealValue(memResult, memory.getTotalBudgetMemory(), kbliteral.getName()); // in Kbytes for Memory
			ResultUtil.addRealValue(memResult, memory.getTotalBudgetRAM(), kbliteral.getName()); // in Kbytes for RAM
			ResultUtil.addRealValue(memResult, memory.getTotalBudgetROM(), kbliteral.getName()); // in Kbytes for ROM

			ResultUtil.addRealValue(memResult, memory.getTotalCapacityMemory(), kbliteral.getName()); // in Kbytes for Memory
			ResultUtil.addRealValue(memResult, memory.getTotalCapacityRAM(), kbliteral.getName()); // in Kbytes for RAM
			ResultUtil.addRealValue(memResult, memory.getTotalCapacityROM(), kbliteral.getName()); // in Kbytes for ROM

			buildDiagnosys(memory, null, memResult, "Memory", kbliteral); // repeat of above?
			buildDiagnosys(memory, null, memResult, "RAM", kbliteral);
			buildDiagnosys(memory, null, memResult, "ROM", kbliteral);
		}

		@Override
		public void visitMIPSPrefix(final MIPS mips) {
			final ComponentInstance compInstance = mips.getComponentInstance();

			// Create a new result object for the MIPS
			final Result compResult = ResultUtil.createResult(compInstance.getName(), compInstance, ResultType.SUCCESS);
			currentResult.getSubResults().add(compResult);
			previousResult.push(currentResult);
			currentResult = compResult;
		}

		@Override
		public void visitMIPSPostfix(final MIPS mips) {
			// unroll the result stack
			final Result compResult = currentResult;
			currentResult = previousResult.pop();

			UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(mips.getSystemInstance());

			for (final Component c : mips.getComponents()) {
				for (final SubComponent s : c.getMIPS()) {
					for (final Budget m : s.getBudgetList()) {
						double budget = m.getBudget();
						if (budget > 0) {
							mips.setTotalBudget(m.getBudget() + mips.getTotalBudget());
						}

						mips.setTotalComponents(mips.getTotalComponents() + m.getComponentsCount());
						mips.setTotalBudgetedComponents(
								mips.getTotalBudgetedComponents() + m.getBudgetedComponentsCount());

						double budgetSub = m.getBudgetSub();
						double budgetSubtotal = m.getBudgetSubtotal();
						String notes = "";
						if (budgetSub > 0 && budgetSubtotal > budgetSub) {
							notes = String.format(
									"Subtotal/actual exceeds budget %.3f by %.3f " + mipsliteral.getName(), budgetSub,
									(budgetSubtotal - budgetSub));
							error(compResult, mips.getComponentInstance(), notes);
						} else if (budgetSub > 0 && budgetSubtotal < budgetSub) {
							notes = String.format(
									m.getCategory() + " " + c.getComponentPath() + " total %.3f "
											+ mipsliteral.getName() + " below budget %.3f " + mipsliteral.getName()
											+ " (%.1f %% slack)",
									budgetSubtotal, budgetSub, (budgetSub - budgetSubtotal) / budgetSub * 100);
						}

						// detailedLog(prefix, ci, budget, subtotal, resourceName, unit, notes);
						/*
						 * String budgetmsg = prefix + GetProperties.toStringScaled(budget, unit) + ",";
						 * String actualmsg = prefix + GetProperties.toStringScaled(actual, unit) + ",";
						 * errManager.logInfo(prefix + ci.getCategory().getName() + " " + ci.getComponentInstancePath() + ", "
						 * + budgetmsg + actualmsg + msg);
						 */

						final Result subResult = ResultUtil.createResult(c.getSomName(), c.getComponentInstance(),
								ResultType.SUCCESS);
						ResultUtil.addRealValue(subResult, budgetSub); // budget
						ResultUtil.addRealValue(subResult, budgetSubtotal); // actual
						ResultUtil.addStringValue(subResult, notes);
						ResultUtil.addStringValue(subResult, m.getLabel()); // resourceName
						ResultUtil.addStringValue(subResult, GetProperties.toStringScaled(budgetSub, mipsliteral)); // budget message
						ResultUtil.addStringValue(subResult, GetProperties.toStringScaled(budgetSubtotal, mipsliteral)); // actual budget message

						compResult.getSubResults().add(subResult);
					}
				}
			}

			ComponentInstance ci = mips.getComponentInstance();

			ResultUtil.addStringValue(compResult, "MIPS"); // category
			ResultUtil.addStringValue(compResult, mips.getSomName()); // somName
			ResultUtil.addStringValue(compResult, GetProperties.toStringScaled(mips.getTotalCapacity(), mipsliteral)); // budget string in MIPS
			ResultUtil.addStringValue(compResult, ci.getCategory().getName()); // component category name
			ResultUtil.addStringValue(compResult, ci.getComponentInstancePath()); // component path

			ResultUtil.addRealValue(compResult, mips.getTotalBudget(), mipsliteral.getName()); // in MIPS
			ResultUtil.addRealValue(compResult, mips.getTotalCapacity(), mipsliteral.getName()); // in MIPS
			ResultUtil.addStringValue(compResult, mipsliteral.getName());

			buildDiagnosys(null, mips, compResult, "MIPS", mipsliteral);
		}

		@Override
		public void visitProcessorOrVirtualProcessorPrefix(final ProcessorOrVirtualProcessor processor) {
			final ComponentInstance compInstance = processor.getComponentInstance();

			// Create a new result object for the memory
			final Result pResult = ResultUtil.createResult(compInstance.getName(), compInstance, ResultType.SUCCESS);
			currentResult.getSubResults().add(pResult);
			previousResult.push(currentResult);
			currentResult = pResult;
		}

		@Override
		public void visitProcessorOrVirtualProcessorPostfix(final ProcessorOrVirtualProcessor processor) {
			// unroll the result stack
			final Result compResult = currentResult;
			currentResult = previousResult.pop();

			for (final Component c : processor.getComponents()) {
				if (c.getCategoryName().equalsIgnoreCase(ComponentCategory.PROCESSOR.getName())) {
					double capacity = c.getCapacity();
					processor.setCapacity(processor.getCapacity() + capacity);
					processor.setResources(processor.getResources() + 1);
					if (capacity > 0) {
						processor.setCapacityResources(processor.getCapacityResources() + 1);
					}

					final Result pResult = ResultUtil.createResult(c.getSomName(), c.getComponentInstance(),
							ResultType.SUCCESS);
					ResultUtil.addStringValue(pResult, c.getCategoryName()); // 0
					ResultUtil.addRealValue(pResult, capacity); // 1
					ResultUtil.addStringValue(pResult, c.getCapacityWithUnit()); // 2
					ResultUtil.addStringValue(pResult, c.getComponentPath()); // 3
					compResult.getSubResults().add(pResult);
				} else if (c.getCategoryName().equalsIgnoreCase(ComponentCategory.VIRTUAL_PROCESSOR.getName())) {
					double capacity = c.getCapacity();
					processor.setVirtualCapacity(processor.getVirtualCapacity() + capacity);
					processor.setVirtualResources(processor.getVirtualResources() + 1);
					if (capacity > 0) {
						processor.setVirtualCapacityResources(processor.getVirtualCapacityResources() + 1);
					}

					final Result pResult = ResultUtil.createResult(c.getSomName(), c.getComponentInstance(),
							ResultType.SUCCESS);
					ResultUtil.addStringValue(pResult, c.getCategoryName()); // 0
					ResultUtil.addRealValue(pResult, capacity); // 1
					ResultUtil.addStringValue(pResult, c.getCapacityWithUnit()); // 2
					ResultUtil.addStringValue(pResult, c.getComponentPath()); // 3
					compResult.getSubResults().add(pResult);
				}
			}

			ComponentInstance ci = processor.getComponentInstance();
			UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(processor.getSystemInstance());

			ResultUtil.addStringValue(compResult, ci.getCategory().getName()); // component category name
			ResultUtil.addStringValue(compResult, processor.getSomName());
			ResultUtil.addStringValue(compResult, GetProperties.toStringScaled(processor.getCapacity(), mipsliteral)); // total capacity for processor in MIPS
			ResultUtil.addStringValue(compResult,
					String.format("%.3f " + mipsliteral.getName() + ",", processor.getVirtualCapacity())); // total capacity for virtual processor in MIPS
			ResultUtil.addStringValue(compResult, ci.getComponentInstancePath()); // component path
		}

		private void buildDiagnosys(Memory memory, MIPS mips, Result result, String resourceName,
				UnitLiteral unit) {
			SystemInstance si = null;
			ComponentInstance ci = null;

			double budgetTotal = 0;
			double capacity = 0;
			int capacityResources = 0;
			int resources = 0;
			int budgetedComponents = 0;
			int components = 0;
			String somName = "";

			if (resourceName.equalsIgnoreCase("Memory") || resourceName.equalsIgnoreCase("RAM")
					|| resourceName.equalsIgnoreCase("ROM")) {
				somName = memory.getSomName();
				si = memory.getSystemInstance();
				ci = memory.getComponentInstance();

				if (resourceName.equalsIgnoreCase("Memory")) {
					budgetTotal = memory.getTotalBudgetMemory();
					if (budgetTotal < 0) {
						budgetTotal = 0;
						memory.setTotalBudgetMemory(0);
					}

					capacity = memory.getTotalCapacityMemory();
					capacityResources = memory.getCapacityResourcesMemory();
					resources = memory.getResourcesMemory();
					budgetedComponents = memory.getBudgetedComponentsMemory();
					components = memory.getComponentsMemory();
				} else if (resourceName.equalsIgnoreCase("RAM")) {
					budgetTotal = memory.getTotalBudgetRAM();
					if (budgetTotal < 0) {
						budgetTotal = 0;
						memory.setTotalBudgetRAM(0);
					}

					capacity = memory.getTotalCapacityRAM();
					capacityResources = memory.getCapacityResourcesRAM();
					resources = memory.getResourcesRAM();
					budgetedComponents = memory.getBudgetedComponentsRAM();
					components = memory.getComponentsRAM();
				} else {
					budgetTotal = memory.getTotalBudgetROM();
					if (budgetTotal < 0) {
						budgetTotal = 0;
						memory.setTotalBudgetROM(0);
					}

					capacity = memory.getTotalCapacityROM();
					capacityResources = memory.getCapacityResourcesROM();
					resources = memory.getResourcesROM();
					budgetedComponents = memory.getBudgetedComponentsROM();
					components = memory.getComponentsROM();
				}
			} else if (mips != null) {
				somName = mips.getSomName();

				si = mips.getSystemInstance();
				ci = mips.getComponentInstance();

				budgetTotal = mips.getTotalBudget();
				if (budgetTotal < 0) {
					budgetTotal = 0;
					mips.setTotalBudget(0);
				}

				capacity = mips.getTotalCapacity();
				capacityResources = mips.getCapacityResources();
				resources = mips.getResources();
				budgetedComponents = mips.getTotalBudgetedComponents();
				components = mips.getTotalComponents();
			}

			if (ci == null || si == null) {
				return;
			}

			String modelStats = resourceName + " capacity " + GetProperties.toStringScaled(capacity, unit) + " : "
					+ resourceName + " budget " + GetProperties.toStringScaled(budgetTotal, unit);
			if (budgetTotal > capacity) {
				modelStats = "System " + si.getName() + " budgets over capacity: " + modelStats;
				error(result, ci, somName + " " + modelStats);
			} else {
				info(result, ci, somName + " " + modelStats);
			}
			modelStats = "  " + capacityResources + " out of " + resources + " with " + resourceName + " capacity";
			if (capacityResources < resources) {
				warning(result, ci, somName + " " + modelStats);
			} else {
				info(result, ci, somName + " " + modelStats);
			}
			modelStats = "  " + budgetedComponents + " out of " + components + " with " + resourceName + " budget\n";
			if (budgetedComponents < components) {
				warning(result, ci, somName + " " + modelStats);
			} else {
				info(result, ci, somName + " " + modelStats);
			}
		}
	}
}
