package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.preferences.Values;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.analysis.flows.reporting.model.ReportedCell;
import org.osate.analysis.flows.reporting.model.Section;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/*
 * A report entry corresponds to the entry within the report.
 * It just contains all the contributors for a flow latency.
 * We should have one report entry for each end to end flow
 */

public class LatencyReportEntry {

	List<LatencyContributor> contributors;
	EndToEndFlowInstance relatedEndToEndFlow;
	List<ReportedCell> issues;
	boolean doSynchronous = false;
	// lastSampled may be a task, partition if no tasks inside the partition, sampling bus, or a sampling device/system
	LatencyContributor lastSampled = null;

	public LatencyReportEntry() {
		this.contributors = new ArrayList<LatencyContributor>();
	}

	public LatencyReportEntry(EndToEndFlowInstance etef) {
		this();
		this.relatedEndToEndFlow = etef;
	}

	public void resetSynchronous() {
		doSynchronous = true;
		lastSampled = null;
	}

	public void resetAsynchronous() {
		doSynchronous = false;
		lastSampled = null;
	}

	public boolean doSynchronous() {
		return doSynchronous;
	}

	public void addContributor(LatencyContributor lc) {
		this.contributors.add(lc);
	}

	public void setLastSampled(LatencyContributor lc) {
		lastSampled = lc;
	}

	public boolean wasSampled() {
		return lastSampled != null;
	}

	public double getMinimumCumLatency(LatencyContributor current) {
		double result = 0;
		if (lastSampled == null) {
			return 0;
		}
		int idx = this.contributors.indexOf(lastSampled);
		int me = this.contributors.indexOf(current);
		if (idx < 0 || me < 0) {
			return 0;
		}
		for (int i = idx + 1; i < me; i++) {
			LatencyContributor lc = this.contributors.get(i);
			if (!(lc.isSamplingContributor())) {
				result = result + lc.getTotalMinimum();
			}
		}
		return result;
	}

	public double getCumLatency(LatencyContributor current, boolean doMax) {
		if (doMax)
			return getMaximumCumLatency(current);
		else
			return getMinimumCumLatency(current);
	}

	public double getMaximumCumLatency(LatencyContributor current) {
		double result = 0;
		if (lastSampled == null) {
			return 0;
		}
		int idx = this.contributors.indexOf(lastSampled);
		int me = this.contributors.indexOf(current);
		if (idx < 0 || me < 0)
			return 0;
		for (int i = idx + 1; i < me; i++) {
			LatencyContributor lc = this.contributors.get(i);
			if (!(lc.isSamplingContributor())) {
				result = result + lc.getTotalMaximum();
			}
		}
		return result;
	}

	public List<LatencyContributor> getContributors() {
		return this.contributors;
	}

	public LatencyContributor getPrevious(LatencyContributor lc) {
		int idx = contributors.indexOf(lc);
		return idx == 0 ? null : contributors.get(idx - 1);
	}

	public boolean isConnection(LatencyContributor lc) {
		return (lc.getContributor() instanceof ConnectionInstance);
	}

	public boolean isPreviousConnectionSynchronous(LatencyContributor lc) {
		int idx = contributors.indexOf(lc);
		for (int i = idx - 1; i >= 0; i--) {
			LatencyContributor plc = contributors.get(idx - 1);
			if (plc.getContributor() instanceof ConnectionInstance) {
				return plc.isSynchronous();
			}
		}
		return false;
	}

	public boolean isPreviousConnectionSyncUnknown(LatencyContributor lc) {
		int idx = contributors.indexOf(lc);
		for (int i = idx - 1; i >= 0; i--) {
			LatencyContributor plc = contributors.get(idx - 1);
			if (plc.getContributor() instanceof ConnectionInstance) {
				return plc.isSyncUnknown();
			}
		}
		return false;
	}

	public double getLastPartitionOffset(LatencyContributor lc) {
		int idx = contributors.indexOf(lc);
		for (int i = idx - 1; i >= 0; i--) {
			LatencyContributor plc = contributors.get(idx - 1);
			if (plc.isPartitionOffset()) {
				return plc.getPartitionOffset();
			}
		}
		return -1;
	}

//	public double getMinimumActualLatency() {
//		double res = 0.0;
//		double diff;
//
//		for (LatencyContributor lc : contributors) {
//			if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.FIRST_SAMPLED)) {
//				// skip the first sampled if it is the first element in the contributor list
//				// and remember initial sample
//				// XXX: if we sample external events by sensor this might have to be added as sampling latency
//				lastSampled = lc;
//			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED)) {
//				// lets deal with the sampling case
//				LatencyContributor last = getPrevious(lc);
//				if (last != null && last.isPartition()) {
//					if (lc.getSamplingPeriod() > last.getSamplingPeriod()) {
//						diff = lc.getSamplingPeriod() - last.getSamplingPeriod();
//						res = res + diff;
//						reportMinSubtotal(lc, res);
//						lc.reportInfo("Min: Added " + diff + "ms");
//					} else if (lc.getSamplingPeriod() < last.getSamplingPeriod()) {
//						lc.reportWarning("Min: Task period smaller than partition period");
//					} else {
//						lc.reportInfo("Min: No added latency");
//					}
//				} else if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
//						&& wasSampled()) {
//					// there was a previous sampling component. We can to the roundup game.
//					diff = FlowLatencyUtil.roundUpDiff(getMinimumCumLatency(lc), lc.getSamplingPeriod());
//					res = res + diff;
//					reportMinSubtotal(lc, res);
//					lc.reportInfo("Min: Sync added " + diff + "ms");
//				} else {
//					reportMinSubtotal(lc, res);
//				}
//				lastSampled = lc;
//			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED)) {
//				LatencyContributor last = getPrevious(lc);
//				if (last.isPartition()) {
//					if (lc.getSamplingPeriod() > last.getSamplingPeriod()) {
//						diff = lc.getSamplingPeriod() - last.getSamplingPeriod();
//						res = res + diff;
//						reportMinSubtotal(lc, res);
//						lc.reportInfo("Min: Added " + diff + "ms");
//					} else if (lc.getSamplingPeriod() < last.getSamplingPeriod()) {
//						lc.reportWarning("Min: Task period smaller than partition period");
//					} else {
//						lc.reportInfo("Min: No added latency");
//					}
//				} else if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
//						&& wasSampled()) {
//					// there was a previous sampling component. We can to the roundup game.
//					double cumMin = getMinimumCumLatency(lc);
//					double framediff = FlowLatencyUtil.roundUp(getMaximumCumLatency(lc), lc.getSamplingPeriod())
//							- FlowLatencyUtil.roundUp(cumMin, lc.getSamplingPeriod());
//					diff = FlowLatencyUtil.roundUpDiff(cumMin, lc.getSamplingPeriod()) + framediff;
//					res = res + diff;
//					reportMinSubtotal(lc, res);
//					lc.reportInfo("Min: Sync added " + diff + "ms");
//					if (framediff > 0) {
//						lc.reportWarning("Min: Aligned min latency with max by adding " + diff + "ms");
//					}
//				} else {
//					res = res + lc.getSamplingPeriod();
//					reportMinSubtotal(lc, res);
//				}
//				lastSampled = lc;
//			} else if (lc.isPartition()) {
//				// ignore if partition is the first entry as it goes along with FIRST_SAMPLED
//				// partition boundary has been crossed
//				if (contributors.indexOf(lc) > 0) {
//					if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
//							&& wasSampled()) {
//						// there was a previous sampling component. We can to the roundup game.
//						if (lc.isPartitionFrame()) {
//							diff = FlowLatencyUtil.roundUpDiff(getMinimumCumLatency(lc), lc.getSamplingPeriod());
//							res = res + diff;
//							reportMinSubtotal(lc, res);
//							lc.reportInfo("Min: Sync added " + diff + "ms");
//						} else {
//							// we have a partition offset.
//							double mincum = getMinimumCumLatency(lc);
//							double myOffset = lc.getPartitionOffset();
//							if (myOffset > -1) {
//								double prevOffset = -1;
//								if (lastSampled.isPartitionOffset()) {
//									prevOffset = lastSampled.getPartitionOffset();
//								}
//								LatencyContributor prev = getPrevious(lastSampled);
//								if (prevOffset == -1 && prev != null && prev.isPartitionOffset()) {
//									prevOffset = prev.getPartitionOffset();
//								}
//								if (prevOffset > -1) {
//									// now we do the offset based roundup
//									double prevPlus = prevOffset + mincum;
//									while ((myOffset - prevPlus) < 0) {
//										myOffset = myOffset + lc.getSamplingPeriod();
//									}
//									diff = myOffset - prevPlus;
//									res = res + diff;
//									reportMinSubtotal(lc, res);
//									lc.reportInfo("Min: Added " + diff + "ms (offset to offset roundup)");
//								} else {
//									// the previous one is not based on a schedule
//									// this branch should not be reached since both partitions are on same processor, thus
//// have the same schedule
//									diff = FlowLatencyUtil.roundUpDiff(mincum, lc.getSamplingPeriod());
//									res = res + diff;
//									reportMinSubtotal(lc, res);
//									lc.reportInfo("Min: Added " + diff + "ms");
//								}
//							} else {
//								// the previous one is not based on a schedule
//								// this branch should not be reached since both partitions are on same processor, thus have
//// the same schedule
//								diff = FlowLatencyUtil.roundUpDiff(mincum, lc.getSamplingPeriod());
//								res = res + diff;
//								reportMinSubtotal(lc, res);
//								lc.reportInfo("Min: Added " + diff + "ms");
//							}
//						}
//					} else {
//						// add the period. Even for partition with offset we have the worst case of a period
//						res = res + lc.getSamplingPeriod();
//						reportMinSubtotal(lc, res);
//					}
//				}
//				lastSampled = lc;
//
//			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.IMMEDIATE)) {
//				// no sampling. We are part of an immediate connection sequence
//			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.LAST_IMMEDIATE)) {
//				// No sampling. we are the last of an immediate connection sequence.
//				if (lc.getDeadline() > 0.0 && getMinimumCumLatency(lc) > lc.getDeadline()) {
//					lc.reportError("Min immediate latency sequence exceeds deadline " + lc.getDeadline() + "ms");
//				}
//			} else {
//				res = res + lc.getTotalMinimum();
//				reportMinSubtotal(lc, res);
//			}
//		}
//
//		return res;
//	}
//

	private String getMinMaxLabel(boolean doMax) {
		if (doMax) {
			return "Max: ";
		} else
			return "Min: ";
	}

	public double getActualLatency(boolean doMaximum) {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			// do some consistency checking
			if (lc.getImmediateDeadline() > 0.0) {
				// No sampling. we are the last of an immediate connection sequence.
				double cum = this.getCumLatency(lc, doMaximum) + lc.getTotal(doMaximum);
				if (cum > lc.getImmediateDeadline()) {
					lc.reportError(getMinMaxLabel(doMaximum) + "immediate latency sequence exceeds deadline "
							+ lc.getImmediateDeadline() + "ms");
				}
			}

			if (lc.getLatencyContributorMethod(doMaximum).equals(LatencyContributorMethod.FIRST_SAMPLED)) {
				// skip the first sampled if it is the first element in the contributor list
				// and remember initial sample
				// TODO: if we sample external events by sensor this might have to be added as sampling latency
				lastSampled = lc;
			} else if (lc.getLatencyContributorMethod(doMaximum).equals(LatencyContributorMethod.SAMPLED)) {
				// lets deal with the sampling case
				LatencyContributor last = getPrevious(lc);
				if (last != null && last.isPartition()) {
					// if it is a task and is preceded by a partition then accommodate for additional sampling latency
					if (lc.getSamplingPeriod() > last.getSamplingPeriod()) {
						double diff = lc.getSamplingPeriod() - last.getSamplingPeriod();
						res = res + diff;
						lc.reportSubtotal(res, doMaximum);
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
					} else if (lc.getSamplingPeriod() < last.getSamplingPeriod()) {
						lc.reportWarning(getMinMaxLabel(doMaximum) + "Task period smaller than partition period");
					} else {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "No added latency");
					}
				} else if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
						&& wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
					double diff = FlowLatencyUtil.roundUpDiff(getCumLatency(lc, doMaximum), lc.getSamplingPeriod());
					res = res + diff;
					lc.reportSubtotal(res, doMaximum);
					lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
					if (doSynchronous() && isPreviousConnectionSyncUnknown(lc)) {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Assume synchronous communication");
					} else {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Synchronous communication on same platform");
					}
				} else {
					res = res + lc.getSamplingPeriod();
					lc.reportSubtotal(res, doMaximum);
				}
				lastSampled = lc;
			} else if (lc.getLatencyContributorMethod(doMaximum).equals(LatencyContributorMethod.DELAYED)) {
				// if it is a task and is preceded by a partition then accommodate for additional sampling latency
				LatencyContributor last = getPrevious(lc);
				if (last.isPartition()) {
					if (lc.getSamplingPeriod() > last.getSamplingPeriod()) {
						double diff = lc.getSamplingPeriod() - last.getSamplingPeriod();
						res = res + diff;
						lc.reportSubtotal(res, doMaximum);
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
					} else if (lc.getSamplingPeriod() < last.getSamplingPeriod()) {
						lc.reportWarning(getMinMaxLabel(doMaximum) + "Task period smaller than partition period");
					} else {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "No added latency");
					}
				} else if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
						&& wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
//				     double cumMin = getMinimumCumLatency(lc);
//				     double framediff = FlowLatencyUtil.roundUp(getMaximumCumLatency(lc), lc.getSamplingPeriod())
//				       - FlowLatencyUtil.roundUp(cumMin, lc.getSamplingPeriod());
//				     diff = FlowLatencyUtil.roundUpDiff(cumMin, lc.getSamplingPeriod()) + framediff; //FlowLatencyUtil.roundUp(getMaximumCumLatency(lc), lc.getSamplingPeriod())
//				     res = res + diff;
					double diff = FlowLatencyUtil.roundUpDiff(getCumLatency(lc, doMaximum), lc.getSamplingPeriod());// FlowLatencyUtil.roundUp(getMaximumCumLatency(lc),
// lc.getSamplingPeriod())
					res = res + diff;
					lc.reportSubtotal(res, doMaximum);
					lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
					if (doSynchronous() && isPreviousConnectionSyncUnknown(lc)) {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Assume synchronous communication");
					} else {
						lc.reportInfo(getMinMaxLabel(doMaximum) + "Synchronous communication on same platform");
					}
				} else {
					res = res + lc.getSamplingPeriod();
					lc.reportSubtotal(res, doMaximum);
				}
				lastSampled = lc;
			} else if (lc.isPartition()) {
				// ignore if partition is the first entry as it goes along with FIRST_SAMPLED
				// partition boundary has been crossed
				if (contributors.indexOf(lc) > 0) {
					// add partition latency unless the first component
					if (((doSynchronous() && isPreviousConnectionSyncUnknown(lc)) || isPreviousConnectionSynchronous(lc))
							&& wasSampled()) {
						// there was a previous sampling component. We can to the roundup game.
						if (lc.isPartitionFrame()) {
							double diff = FlowLatencyUtil.roundUpDiff(getCumLatency(lc, doMaximum),
									lc.getSamplingPeriod());
							res = res + diff;
							lc.reportSubtotal(res, doMaximum);
							lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
						} else {
							// we have a partition offset.
							double cum = getCumLatency(lc, doMaximum);
							double myOffset = lc.getPartitionOffset();
							if (myOffset > -1) {
								// get the previous partition offset
								// it could be the lastSampled or the partition latency contributor right before that
								double prevOffset = getLastPartitionOffset(lc);
								if (prevOffset > -1) {
									// now we do the offset based roundup
									double prevPlus = prevOffset + cum;
									while ((myOffset - prevPlus) < 0) {
										myOffset = myOffset + lc.getSamplingPeriod();
									}
									double diff = myOffset - prevPlus;
									res = res + diff;
									lc.reportSubtotal(res, doMaximum);
									lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff
											+ "ms (offset to offset roundup)");
								} else {
									// the previous one is not based on a schedule
									// this branch should not be reached since both partitions are on same processor
									// thus they have the same schedule
									double diff = FlowLatencyUtil.roundUpDiff(cum, lc.getSamplingPeriod());
									res = res + diff;
									lc.reportSubtotal(res, doMaximum);
									lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
								}
							} else {
								// the current does not have an offset despite being marked as PARTITION_SCHEDULE
								// this branch should not be reached
								double diff = FlowLatencyUtil.roundUpDiff(cum, lc.getSamplingPeriod());
								res = res + diff;
								lc.reportSubtotal(res, doMaximum);
								lc.reportInfo(getMinMaxLabel(doMaximum) + "Added " + diff + "ms");
							}
						}
						if (doSynchronous() && isPreviousConnectionSyncUnknown(lc)) {
							lc.reportInfo(getMinMaxLabel(doMaximum) + "Assume synchronous communication");
						} else {
							lc.reportInfo(getMinMaxLabel(doMaximum) + "Synchronous communication on same platform");
						}
					} else {
						// add the period. Even for partition with offset we have the worst case of a period
						res = res + lc.getSamplingPeriod();
						lc.reportSubtotal(res, doMaximum);
					}
				}
				// remember the partition in all cases as a sampling unit
				lastSampled = lc;
			} else if (lc.isPartitionIODelay()) {
				// deal with partition I/O delay, then add communication latency
				// do it as major frame delay or as partition end delay depending on preference setting
				if (Values.doMajorFrameDelay()) {
					// round up to next major frame
					double diff = FlowLatencyUtil.roundUpDiff(getCumLatency(lc, doMaximum), lc.getSamplingPeriod());
					res = res + diff;
				} else {
					// round up to window duration. Note the cumulative could be more than the window
					double diff = FlowLatencyUtil.roundUpDiff(getCumLatency(lc, doMaximum), lc.getSamplingPeriod(),
							lc.getPartitionDuration());
					res = res + diff;
				}
				lc.reportSubtotal(res, doMaximum);
			} else {
				res = res + lc.getTotal(doMaximum);
				lc.reportSubtotal(res, doMaximum);
			}
		}

		return res;
	}

	public double getMaximumSpecifiedLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMaximumSpecified();
		}

		return res;
	}

	public double getMinimumSpecifiedLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMinimumSpecified();
		}

		return res;
	}

	private void reportSummaryError(String str) {
		issues.add(new ReportedCell(ReportSeverity.ERROR, str));
		CheckFlowLatency.getInstance().error(relatedEndToEndFlow, str);
	}

	private void reportSummaryInfo(String str) {
		issues.add(new ReportedCell(ReportSeverity.SUCCESS, str));
		CheckFlowLatency.getInstance().info(relatedEndToEndFlow, str);
	}

	private void reportSummaryWarning(String str) {
		issues.add(new ReportedCell(ReportSeverity.WARNING, str));
		CheckFlowLatency.getInstance().warning(relatedEndToEndFlow, str);
	}

	private String getSyncLabel() {
		if (doSynchronous) {
			return " (S)";
		} else {
			return " (A)";
		}
	}

	private String getSyncModeName() {
		if (doSynchronous) {
			return "synchronous";
		} else {
			return "asynchronous";
		}
	}

	public Section export() {

		Section section;
		Line line;
		double minValue;
		double maxValue;
		double minSpecifiedValue;
		double maxSpecifiedValue;
		double expectedMaxLatency;
		double expectedMinLatency;
		String sectionName;

		minValue = 0.0;
		maxValue = 0.0;
		minSpecifiedValue = 0.0;
		maxSpecifiedValue = 0.0;

		issues = new ArrayList<ReportedCell>();

		expectedMaxLatency = GetProperties.getMaximumLatencyinMilliSec(this.relatedEndToEndFlow);
		expectedMinLatency = GetProperties.getMinimumLatencyinMilliSec(this.relatedEndToEndFlow);

		if (relatedEndToEndFlow != null) {
			sectionName = relatedEndToEndFlow.getComponentInstancePath();
		} else {
			sectionName = "Unnamed flow";
		}

		section = new Section(sectionName + getSyncLabel());

		line = new Line();
		line.addHeaderContent("Latency analysis for " + sectionName + " in " + getSyncModeName() + " system");
		section.addLine(line);
		line = new Line();
		section.addLine(line);
		line = new Line();
		line.addHeaderContent("Contributor");
		line.addHeaderContent("Min Specified");
		line.addHeaderContent("Min Value");
		if (Values.doReportSubtotals()) {
			line.addHeaderContent("Min Subtotals");
		}
		line.addHeaderContent("Min Method");
		line.addHeaderContent("Max Specified");
		line.addHeaderContent("Max Value");
		if (Values.doReportSubtotals()) {
			line.addHeaderContent("Max Subtotals");
		}
		line.addHeaderContent("Max Method");
		line.addHeaderContent("Comments");
		section.addLine(line);

		// will populate the comments section
		minValue = getActualLatency(false);
		maxValue = getActualLatency(true);
		minSpecifiedValue = getMinimumSpecifiedLatency();
		maxSpecifiedValue = getMaximumSpecifiedLatency();

		// reporting each entry
		for (LatencyContributor lc : this.contributors) {
			for (Line l : lc.export()) {
				section.addLine(l);
			}
		}

		line = new Line();
		line.addContent("Latency Total");
		line.addContent(minSpecifiedValue + "ms");
		line.addContent(minValue + "ms");
		if (Values.doReportSubtotals()) {
			line.addHeaderContent("");
		}
		line.addContent("");
		line.addContent(maxSpecifiedValue + "ms");
		line.addContent(maxValue + "ms");
		if (Values.doReportSubtotals()) {
			line.addHeaderContent("");
		}
		line.addContent("");
		section.addLine(line);

		line = new Line();
		line.setSeverity(ReportSeverity.SUCCESS);

		line.addContent("End to End Latency");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");
		line.addContent("");
		line.addContent(expectedMaxLatency + "ms");
		line.addContent("");

		/*
		 * In that case, the end to end flow has a minimum latency
		 */
		if (expectedMinLatency >= 0) {
			if (minSpecifiedValue < expectedMinLatency) {
				reportSummaryWarning("Sum of minimum specified latencies (" + minSpecifiedValue
						+ " ms) is less than expected minimum end to end latency (" + expectedMinLatency + "ms)");
			}

			if (minValue < expectedMinLatency) {
				reportSummaryError("Sum of minimum actual latencies (" + minValue
						+ " ms) is less than expected minimum end to end latency (" + expectedMinLatency + "ms)");
			}
		}

		/**
		 * Here, the max latency value has been defined
		 */
		if (expectedMaxLatency > 0) {
			if (expectedMaxLatency < maxSpecifiedValue) {
				reportSummaryError("Sum of maximum specified latency (" + maxSpecifiedValue
						+ "ms) exceeds end to end latency (" + expectedMaxLatency + "ms)");
			}

			if (expectedMaxLatency < maxValue) {
				reportSummaryError("Sum of maximum actual latencies (" + maxValue + "ms) exceeds end to end latency ("
						+ expectedMaxLatency + "ms)");
			}
		} else {
			reportSummaryWarning("End to end latency is not specified");
		}

		/**
		 * If the expected latency is defined and consistent with the max value, everything should be ok
		 * It means that the number calculated from the component is correct and less than
		 * the latency specifications.
		 * In case of Min latency the actual sum should be higher.
		 */
		if ((minValue > 0) && (maxValue > 0) && (expectedMaxLatency > 0) && (expectedMinLatency > 0)
				&& (minValue >= expectedMinLatency) && (expectedMaxLatency >= maxValue)) {
			reportSummaryInfo("end-to-end flow latency for " + this.relatedEndToEndFlow.getName()
					+ " calculated from the components is correct with the expected latency specifications");
		}
		section.addLine(line);

		if (issues.size() > 0) {
			line = new Line();
			line.addHeaderContent("End to end Latency Summary");
			section.addLine(line);
			for (ReportedCell issue : issues) {
				line = new Line();
				String msg = issue.getMessage();
				issue.setMessage(issue.getSeverity().toString());
				line.addCell(issue);
				line.addContent(msg);
				section.addLine(line);
			}
		}

		return section;
	}
}
