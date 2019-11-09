/*
 * Created on July 7, 2004
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
 * @version $Id: PropertyTotals.java,v 1.1.2.11 2009-04-21 13:54:35 relief Exp $
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
