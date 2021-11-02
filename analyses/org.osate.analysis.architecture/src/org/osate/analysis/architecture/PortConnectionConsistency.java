/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.communication.CommunicationProperties;
import org.osate.aadl2.contrib.communication.RateSpec;
import org.osate.aadl2.contrib.communication.RateSpec.RateUnit_FieldType;
import org.osate.aadl2.contrib.util.AadlContribUtils;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.contribution.sei.datamodel.DataModel;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.RealRange;
import org.osate.ui.handlers.AbstractAaxlHandler;

/**
 * @author phf
 *
 * This class provides for checking properties on ports of a connection match up.
 *
 */
public class PortConnectionConsistency extends AadlProcessingSwitchWithProgress {

	private AbstractAaxlHandler handler;

	public PortConnectionConsistency(final IProgressMonitor pm, AbstractAaxlHandler handler) {
		super(pm, PROCESS_PRE_ORDER_ALL);
		this.handler = handler;
	}

	@Override
	public final void initSwitches() {

		/* here we are creating the connection checking switches */
		instanceSwitch = new InstanceSwitch<String>() {
			/**
			 * check port properties for connection end points
			 */
			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
//				monitorUpdate(conni.getName());
				ConnectionInstanceEnd srcFI = conni.getSource();
				ConnectionInstanceEnd dstFI = conni.getDestination();
				if (srcFI == null || dstFI == null) {
					error(conni, "Connection source or destination is null");
					return DONE;
				}
				if (srcFI instanceof FeatureInstance && dstFI instanceof FeatureInstance) {
					checkPortConsistency((FeatureInstance) srcFI, (FeatureInstance) dstFI, conni);
				}
				return DONE;
			}
		};
	}

	public void doHeaders() {
	}

	public void checkPortConsistency(FeatureInstance srcFI, FeatureInstance dstFI, ConnectionInstance conni) {
		double srcDataSize = AadlContribUtils.getDataSize(srcFI, SizeUnits.BYTES);
		double dstDataSize = AadlContribUtils.getDataSize(dstFI, SizeUnits.BYTES);

//		RecordValue srcRate = GetProperties.getOutPutRate(srcFI);
//		RecordValue dstRate = GetProperties.getInPutRate(dstFI);

		final Optional<RateSpec> srcRateOpt = CommunicationProperties.getOutputRate(srcFI);
		final Optional<RateSpec> dstRateOpt = CommunicationProperties.getInputRate(dstFI);

		RateUnit_FieldType srcRU = null;
		RateUnit_FieldType dstRU = null;
		double srcMaxRateValue = 0;
		double dstMaxRateValue = 0;
		double srcMinRateValue = 0;
		double dstMinRateValue = 0;

		if (srcRateOpt.isPresent() && dstRateOpt.isPresent()) {
//		if (srcRate != null && dstRate != null) {
			final RateSpec srcRate = srcRateOpt.get();
			final RateSpec dstRate = dstRateOpt.get();
			srcRU = srcRate.getRateUnit().orElse(null);
			dstRU = dstRate.getRateUnit().orElse(null);
			final RealRange srcRateRange = srcRate.getValueRange().orElse(RealRange.ZEROED);
			srcMaxRateValue = srcRateRange.getMaximum();
			srcMinRateValue = srcRateRange.getMinimum();
			final RealRange dstRateRange = dstRate.getValueRange().orElse(RealRange.ZEROED);
			dstMaxRateValue = dstRateRange.getMaximum();
			dstMinRateValue = dstRateRange.getMinimum();
//			srcRU = GetProperties.getRateUnit(srcRate);
//			dstRU = GetProperties.getRateUnit(dstRate);
//			srcMaxRateValue = GetProperties.getMaxDataRate(srcRate);
//			dstMaxRateValue = GetProperties.getMaxDataRate(dstRate);
//			srcMinRateValue = GetProperties.getMinDataRate(srcRate);
//			dstMinRateValue = GetProperties.getMinDataRate(dstRate);
		}
		// now try it as SEI::Data_Rate
//		public static double getMessageRatePerSecond(NamedElement ne) {
//			Property dr = GetProperties.lookupPropertyDefinition(ne, SEI._NAME, SEI.DATA_RATE);
//			if (dr == null) {
//				dr = GetProperties.lookupPropertyDefinition(ne, SEI._NAME, SEI.MESSAGE_RATE);
//			}
//			if (dr == null) {
//				return 0;
//			}
//			return PropertyUtils.getRealValue(ne, dr, 0.0);
//		}

		final double srcRateValue = Sei.getDataRate(srcFI)
				.map(v -> v.getValue())
				.orElseGet(() -> Sei.getMessageRate(srcFI).map(v -> v.getValue()).orElse(0.0));
		final double dstRateValue = Sei.getDataRate(dstFI)
				.map(v -> v.getValue())
				.orElseGet(() -> Sei.getMessageRate(dstFI).map(v -> v.getValue()).orElse(0.0));
//		double srcRateValue = GetProperties.getMessageRatePerSecond(srcFI);
//		double dstRateValue = GetProperties.getMessageRatePerSecond(dstFI);

		final Classifier srcC = DataModel.getBaseType(srcFI)
				.map(list -> list.size() == 1 ? list.get(0) : null)
				.orElse(null);
		final Classifier dstC = DataModel.getBaseType(dstFI)
				.map(list -> list.size() == 1 ? list.get(0) : null)
				.orElse(null);
//		Classifier srcC = GetProperties.getSingleBaseType(srcFI);
//		Classifier dstC = GetProperties.getSingleBaseType(dstFI);

		final String srcS = DataModel.getMeasurementUnit(srcFI).orElse(null);
		final String dstS = DataModel.getMeasurementUnit(dstFI).orElse(null);
//		String srcS = GetProperties.getMeasurementUnit(srcFI);
//		String dstS = GetProperties.getMeasurementUnit(dstFI);

		// error logging

		if (srcDataSize > 0 && dstDataSize > 0) {
			if (srcDataSize != dstDataSize) {
				error(conni, "Source data size " + srcDataSize + " Bytes and destination data size " + dstDataSize
						+ " Bytes differ");
			}
		} else {
			if (srcDataSize == 0 && dstDataSize > 0) {
				error(conni, "Source data size is missing or zero");
			}
			if (dstDataSize == 0 && srcDataSize > 0) {
				error(conni, "Destination data size is missing or zero");
			}
		}

		if (srcRU != null && dstRU != null && srcRU != dstRU) {
			error(conni, "Source rate unit " + srcRU.name() + " and destination rate unit " + dstRU.name()
					+ " differ");
		}

		if (srcMaxRateValue > 0 && dstMaxRateValue > 0) {
			if (srcMaxRateValue > dstMaxRateValue) {
				error(conni, "Maximum source data rate " + srcMaxRateValue
						+ " is greater than maximum destination data rate " + dstMaxRateValue);
			}
			if (srcMinRateValue < dstMinRateValue) {
				error(conni, "Minimum source data rate " + srcMinRateValue
						+ " is less than minimum destination data rate " + dstMinRateValue);
			}
		} else {
			if (srcRateOpt.isEmpty() || dstRateOpt.isEmpty()) {
//			if (srcRate != null || dstRate != null) {
				error(conni, "Missing input rate or output rate");
			}
		}

		if (srcRateValue > 0 && dstRateValue > 0) {
			if (srcRateValue != dstRateValue) {
				error(conni,
						"Source data rate " + srcRateValue + " and destination data rate " + dstRateValue + " differ");
			}
		} else {
			if (srcRateValue == 0 && dstRateValue > 0) {
				error(conni, "Source data rate is missing or zero");
			}
			if (dstRateValue == 0 && srcRateValue > 0) {
				error(conni, "Destination data rate is missing or zero");
			}
		}

		if (srcC != null && dstC != null) {
			if (srcC != dstC) {
				error(conni, "Source base type " + srcC.getName() + " and destination base type " + dstC.getName()
						+ " differ");
			}
		} else {
			if (srcC == null && dstC != null) {
				error(conni, "Source base type is missing");
			}
			if (dstC == null && srcC != null) {
				error(conni, "Destination base type is missing");
			}
		}

		if (srcS.length() > 0 && dstS.length() > 0) {
			if (!srcS.equalsIgnoreCase(dstS)) {
				error(conni,
						"Source measurement unit " + srcS + " and destination measurement unit " + dstS + " differ");
			}
		} else {
			if (srcS.length() == 0 && dstS.length() > 0) {
				error(conni, "Source measurement unit is missing");
			}
			if (dstS.length() == 0 && srcS.length() > 0) {
				error(conni, "Destination measurement unit is missing");
			}
		}
	}

	private static NamedElement previousNE = null;

	protected void error(NamedElement el, String s) {
		super.error(el, s);
		if (previousNE == null || previousNE != el) {
			if (previousNE != null) {
				handler.logInfo("");
			}
			handler.logInfo(el.getName() + "," + s);
		} else {
			handler.logInfo("," + s);
		}
		previousNE = el;
	}

}
