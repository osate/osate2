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
package org.osate.analysis.architecture;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.util.ResultUtil;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * @author phf
 */
public/* final */class PropertyTotals extends AadlProcessingSwitchWithProgress {
	public PropertyTotals(final IProgressMonitor monitor, AbstractAaxlHandler handler) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
	}

	public PropertyTotals() {
		super(new NullProgressMonitor(), PROCESS_PRE_ORDER_ALL);
	}

	@Override
	protected final void initSwitches() {
		/*
		 * We overwrite the case method for a class in the meta model
		 * specific switches.
		 */

	}

	public final double getPrice(ComponentInstance ci) {
		return calcPrice(ci);
	}

	private double calcPrice(ComponentInstance ci) {
		double price = 0.0;
		EList<ComponentInstance> cil = ci.getComponentInstances();
		for (ComponentInstance subi : cil) {
			price += calcPrice(subi);
		}
		price += GetProperties.getPrice(ci, 0.0);
		return price;
	}

	/**
	 * Performs the weight analysis on a {@code ComponentInstance}.
	 * <p>
	 * The calculated weight and any issues encountered are returned in the {@code AnalysisResult}. The following
	 * describes how the returned {@code AnalysisResult} is filled.
	 * <p>
	 * {@link AnalysisResult}:
	 * <ul>
	 *   <li>{@link AnalysisResult#getAnalysis()}: Set to the value {@code "Weight totals"}.
	 *   <li>{@link AnalysisResult#getSourceReference()}: Set to the {@link ComponentInstance} passed to this method.
	 *   <li>{@link AnalysisResult#getResults()}: One {@code Result} is created for the {@code ComponentInstance ci}.
	 * </ul>
	 * {@link Result}:
	 * <ul>
	 *   <li>{@link Result#getSourceReference()}: Set to the {@code ComponentInstance} for this {@code Result}.
	 *   <li>{@link Result#getValues()}: Four {@code RealValue} are created.
	 *   <ul>
	 *     <li>Index {@code 0} is a {@code RealValue} for the calculated weight.
	 *     <ul>
	 *       <li>{@link RealValue#getValue()}: The calculated weight of the component.
	 *       <li>{@link RealValue#getUnit()}: Weight units are in {@code kg}.
	 *     </ul>
	 *     <li>Index {@code 1} is a {@code RealValue} for the gross weight.
	 *     <ul>
	 *       <li>{@link RealValue#getValue()}: The value of the component's {@code SEI::GrossWeight} property.
	 *       <li>{@link RealValue#getUnit()}: Weight units are in {@code kg}.
	 *     </ul>
	 *     <li>Index {@code 2} is a {@code RealValue} for the net weight.
	 *     <ul>
	 *       <li>{@link RealValue#getValue()}: The value of the component's {@code SEI::NetWeight} property.
	 *       <li>{@link RealValue#getUnit()}: Weight units are in {@code kg}.
	 *     </ul>
	 *     <li>Index {@code 3} is a {@code RealValue} for the weight limit.
	 *     <ul>
	 *       <li>{@link RealValue#getValue()}: The value of the component's {@code SEI::WeightLimit} property.
	 *       <li>{@link RealValue#getUnit()}: Weight units are in {@code kg}.
	 *     </ul>
	 *   </ul>
	 *   <li>{@link Result#getDiagnostics()}: Zero or more {@code Diagnostic}s are created. Each one is a single issue
	 *       discovered by the analysis to be reported to the user.
	 *   <ul>
	 *     <li>{@link Diagnostic#getType()}: {@link DiagnosticType#ERROR}, {@link DiagnosticType#WARNING}, or
	 *         {@link DiagnosticType#INFO}.
	 *     <li>{@link Diagnostic#getSourceReference()}: The location of the issue. Either the {@code ComponentInstance}
	 *         of the {@code Result} or one of the component's {@link ConnectionInstance}s.
	 *     <li>{@link Diagnostic#getMessage()}: The text of the issue.
	 *   </ul>
	 *   <li>{@link Result#getSubResults()}: Zero or more {@code Result}s are created: one for each subcomponent.
	 * </ul>
	 *
	 * @param ci The component to run the weight analysis on.
	 * @return An {@code AnalysisResult} containing the weight of the component and all subcomponents as well as any
	 *         issues encountered during the analysis.
	 */
	public static AnalysisResult invoke(ComponentInstance ci) {
		AnalysisResult result = ResultUtil.createAnalysisResult("Weight totals", ci);
		result.getResults().add(calcWeight(ci, true));
		return result;
	}

	/**
	 * @deprecated Use {@link #invoke(ComponentInstance)} instead. Will be removed in 2.7.
	 */
	@Deprecated
	public final double getWeight(ComponentInstance ci) {
		return ResultUtil.getReal(calcWeight(ci, true), 0);
	}

	private static Result calcWeight(ComponentInstance ci, boolean needWeight) {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setModelElement(ci);

		final double net = GetProperties.getNetWeight(ci, 0.0);
		double weight = 0.0;
		final double gross = GetProperties.getGrossWeight(ci, 0.0);
		double sublimit = 0.0;
		EList<ComponentInstance> cil = ci.getComponentInstances();
		for (ComponentInstance subi : cil) {
			ComponentCategory subcat = subi.getCategory();
			if (!(subcat.equals(ComponentCategory.PROCESS) || subcat.equals(ComponentCategory.VIRTUAL_BUS)
					|| subcat.equals(ComponentCategory.VIRTUAL_PROCESSOR))) {
				Result subresult = calcWeight(subi, (needWeight && (gross == 0.0 || net > 0.0)));
				result.getSubResults().add(subresult);
				double subweight = ResultUtil.getReal(subresult, 0);
				weight += subweight;
				sublimit += GetProperties.getWeightLimit(subi, 0.0);
			}
		}
		EList<ConnectionInstance> connl = ci.getConnectionInstances();
		for (ConnectionInstance connectionInstance : connl) {
			ConnectionInstanceEnd source = connectionInstance.getSource();
			ConnectionInstanceEnd destination = connectionInstance.getDestination();
			if ((source instanceof FeatureInstance
					&& ((FeatureInstance) source).getCategory() == FeatureCategory.BUS_ACCESS)
					|| (destination instanceof FeatureInstance
							&& ((FeatureInstance) destination).getCategory() == FeatureCategory.BUS_ACCESS)) {
				double netconn = GetProperties.getNetWeight(connectionInstance, 0.0);
				double grossconn = GetProperties.getGrossWeight(connectionInstance, 0.0);
				weight += netconn > 0 ? netconn : grossconn;
				if (netconn > 0 || grossconn > 0) {
					String ResultMsg = String.format(
							connectionInstance.getName() + ": Weight of access connection is %.3f kg",
							netconn > 0 ? netconn : grossconn);
					result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(ResultMsg, connectionInstance));
				}
				sublimit += GetProperties.getWeightLimit(connectionInstance, 0.0);
			}
		}
		if (weight == 0.0 && cil.isEmpty()) {
			if (gross == 0 && net > 0) {
				weight = net;
			} else {
				weight = gross;
			}
		} else {
			weight += net;
		}
		if (gross > 0.0) {
			if (weight > gross) {
				// problem
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(
						String.format("[G] Sum of weights (%.3f kg) exceeds gross weight of %.3f kg", weight, gross),
						ci));
				// Set gross weight
			} else if (weight > 0 && weight < gross) {
				// problem
				result.getDiagnostics()
						.add(ResultUtil.createWarningDiagnostic(String.format(
								"[G] Sum of weights (%.3f kg) less than gross weight of %.3f kg (using gross weight)",
								weight, gross), ci));
				weight = gross;
			}
			if (weight == 0.0) {
				weight = gross;
			}
		}
		final double limit = GetProperties.getWeightLimit(ci, 0.0);
		if (limit > 0.0) {
			if (weight > limit) {
				// problem
				String ResultMsg = String.format("[A] Sum of weights (%.3f kg) exceeds weight limit of %.3f kg", weight,
						limit);
				result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(ResultMsg, ci));
			} else {
				if (sublimit > limit) {
					// problem
					result.getDiagnostics()
							.add(ResultUtil.createWarningDiagnostic(String.format(
									"[L] Sum of subcomponent weight limits (%.3f kg) exceeds weight limit of %.3f kg",
									sublimit, limit), ci));
				}
				if (weight < limit) {
					String ResultMsg = String.format(
							"[A] Sum of weights (%.3f kg) is below weight limit of %.3f kg (%.1f %% Weight slack)",
							weight, limit, (limit - weight) / limit * 100);
					result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(ResultMsg, ci));
				}
			}
		} else {
			if (weight > 0.0) {
				String ResultMsg = String.format("[L] Sum of weights / gross weight is %.3f kg (no limit specified)",
						weight);
				result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(ResultMsg, ci));
			} else if (needWeight) {
				String ResultMsg = "[L] No net weight plus subcomponent weight or no gross weight";
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(ResultMsg, ci));
			}
		}

		ResultUtil.addRealValue(result, weight, "kg");
		ResultUtil.addRealValue(result, gross, "kg");
		ResultUtil.addRealValue(result, net, "kg");
		ResultUtil.addRealValue(result, limit, "kg");
		return result;
	}
}
