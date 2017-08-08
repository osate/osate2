package org.osate.aadl2.errormodel.analysis.cma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.errormodel.analysis.cma.CMAReportEntry.EntryType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.legacy.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.legacy.PropagationPathEnd;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class CMAUtils {

	public static final int SEVERITY_CATASTROPHIC = 1;
	public static final int SEVERITY_HAZARDOUS = 2;
	public static final int SEVERITY_SEVEREMAJOR = 2;
	public static final int SEVERITY_MAJOR = 3;
	public static final int SEVERITY_MINOR = 4;
	public static final int SEVERITY_NOEFFECT = 5;
	public static final int SEVERITY_UNKNOWN = 100;

	private static String currentSeverity;

	public static void setCurrentSeverity(String sev) {
		currentSeverity = sev;
	}

	/**
	 * The processState method is used to report all potential CMA report entry.
	 * These entries are then added to the complete CMA report.
	 * To process the state, we analyze the composite error states related to
	 * this behavior state and, when having an ANDed condition, we report
	 * all common cause of failure.
	 * @param                     - the analysis model containing all the propagation paths information
	 * @param componentInstance   - the instance component to be processed
	 * @param state               - the behavior state to process
	 * @param typeset             - the typeset associated with the state.
	 * @return
	 */
	public static List<CMAReportEntry> processState(AnalysisModel analysisModel, ComponentInstance componentInstance,
			ErrorBehaviorState state, TypeSet typeset) {
		ArrayList<CMAReportEntry> result = new ArrayList<CMAReportEntry>();

		for (CompositeState cs : EMV2Util.getAllCompositeStates(componentInstance)) {
			if (cs.getState() == state) {
				result.addAll(processConditionExpression(analysisModel, componentInstance, cs.getCondition()));
			}
		}
		return result;
	}

	/**
	 * Get the report entries related to a condition expression. Detect the ANDed
	 * elements and process then.
	 * @param                     - the analysis model containing all the propagation paths information
	 * @param componentInstance   - the component instance that contain the condition expression
	 * @param expression          - the condition expression to process
	 * @return                     - the list of entries to add
	 */
	public static List<CMAReportEntry> processConditionExpression(AnalysisModel analysisModel,
			ComponentInstance componentInstance, ConditionExpression expression) {
		List<CMAReportEntry> result = new ArrayList<CMAReportEntry>();
		List<ConditionElement> toAnalyze = new ArrayList<ConditionElement>();

//		OsateDebug.osateDebug("[CMAUtils] expression " + expression);

		if (expression instanceof AndExpression) {
			AndExpression sand = (AndExpression) expression;
			List<ConditionExpression> exprs = sand.getOperands();

			for (ConditionExpression element : exprs) {
//				OsateDebug.osateDebug("[CMAUtils] element " + element);
				if (element instanceof ConditionElement) {
					toAnalyze.add((ConditionElement) element);
				} else {

					OsateDebug.osateDebug("[CMAUtils] TODO - get all contributors to the ANDed branch");
				}
			}
			result.addAll(processConditionElements(analysisModel, componentInstance, toAnalyze));
		}

		if (expression instanceof SConditionElement) {
			SConditionElement element = (SConditionElement) expression;

			SubcomponentElement selt = element.getQualifiedState().getSubcomponent();
			Subcomponent subcomp = selt.getSubcomponent();
			ComponentInstance subcompInstance = findComponentInstance(analysisModel.getRoot().getComponentInstance(),
					subcomp);
			if (subcompInstance != null) {
				result.addAll(processState(analysisModel, subcompInstance, EMV2Util.getState(element),
						element.getConstraint()));
			}
		}

		return result;
	}

	/**
	 * processConditionElements then process all elements from an ANDed condition
	 * and look for all potential Common Cause of Failure.
	 * @param analysisModel     - the analysis model with the root component
	 * @param componentInstance - the top-level component that contains the condition
	 * @param elements          - the elements to consider
	 * @return                  - the list of entries to add in the report
	 */
	public static List<CMAReportEntry> processConditionElements(AnalysisModel analysisModel,
			ComponentInstance componentInstance, List<ConditionElement> elements) {

		List<CMAReportEntry> result;
		List<ComponentClassifier> usedClassifiers;
		List<PropagationPathEnd> relatedErrorSources;
		List<ComponentInstance> referencedInstances;

		/**
		 * The componentClassifiers map contains all the classifiers contained/used
		 * by a component instance so that we can later detect potential duplicates.
		 */
		Map<ComponentInstance, List<ComponentClassifier>> componentClassifiers;

		/**
		 * The errorSources map contains all the error sources contained/used
		 * by a component instance so that we can later detect potential duplicates.
		 */
		Map<ComponentInstance, List<PropagationPathEnd>> errorSources;

		result = new ArrayList<CMAReportEntry>();
		referencedInstances = new ArrayList<ComponentInstance>();
		componentClassifiers = new HashMap<ComponentInstance, List<ComponentClassifier>>();
		errorSources = new HashMap<ComponentInstance, List<PropagationPathEnd>>();

		for (ConditionElement elt : elements) {
			/**
			 * Here, the condition come from a subcomponent.
			 */
			if (elt instanceof SConditionElement) {
				SConditionElement scondelt = (SConditionElement) elt;
				if (scondelt.getQualifiedState() != null && scondelt.getQualifiedState().getNext() == null) {
					/**
					 * Here, we retrieve the subcomponent related to the condition.
					 */
					SubcomponentElement selt = scondelt.getQualifiedState().getSubcomponent();
					Subcomponent subcomp = selt.getSubcomponent();
					ComponentInstance subcompInstance = findComponentInstance(componentInstance, subcomp);
					referencedInstances.add(subcompInstance);

					/**
					 * Then, we get all the classifiers used by the subcomponent.
					 */
					usedClassifiers = new ArrayList<ComponentClassifier>();
					getAllClassifiers(subcompInstance, usedClassifiers);

					/**
					 * For each component involved in the condition, we stored
					 * all the used classifiers.
					 */
					componentClassifiers.put(subcompInstance, usedClassifiers);

					/**
					 * Then, we get all the error propagations that might
					 * impact the component.
					 */
					relatedErrorSources = new ArrayList<PropagationPathEnd>();
					getAllErrorSources(subcompInstance, analysisModel, relatedErrorSources);

					/**
					 * For each component involved in the condition, we stored
					 * all the used classifiers.
					 */
					errorSources.put(subcompInstance, relatedErrorSources);
				}
			}
		}

		/**
		 * In the following, we try to find common error sources between ANDed components.
		 */
		Map<ComponentInstance, List<PropagationPathEnd>> errorSourcesDuplicatedFound = new HashMap<ComponentInstance, List<PropagationPathEnd>>();
		for (ComponentInstance firstComponent : referencedInstances) {

			List<ComponentInstance> instancesDuplicates;
			boolean foundInOther;
			boolean duplicated;
			PropagationPathEnd ppe1;
			PropagationPathEnd ppe2;
			ComponentInstance secondComponent;

			secondComponent = null;
			for (int esInd1 = 0; esInd1 < errorSources.get(firstComponent).size(); esInd1++) {
				ppe1 = errorSources.get(firstComponent).get(esInd1);
				List<PropagationPathEnd> errorSourcesduplicates = new ArrayList<PropagationPathEnd>();
				instancesDuplicates = new ArrayList<ComponentInstance>();
				duplicated = true;
				for (int comp2Ind = 0; comp2Ind < referencedInstances.size(); comp2Ind++) {
					secondComponent = referencedInstances.get(comp2Ind);
					foundInOther = false;

					if (secondComponent == firstComponent) {
						continue;
					}

					for (int esInd2 = 0; esInd2 < errorSources.get(secondComponent).size(); esInd2++) {
						ppe2 = errorSources.get(secondComponent).get(esInd2);

						if (EMV2Util.getPropagationName(ppe1.getErrorPropagation())
								.equalsIgnoreCase(EMV2Util.getPropagationName(ppe2.getErrorPropagation()))) {
							foundInOther = true;
							errorSourcesduplicates.add(ppe1);
							errorSourcesduplicates.add(ppe2);

							if (!instancesDuplicates.contains(firstComponent)) {
								instancesDuplicates.add(firstComponent);
							}
							if (!instancesDuplicates.contains(secondComponent)) {
								instancesDuplicates.add(secondComponent);
							}
							continue;
						}
					}
					if (foundInOther == false) {
						duplicated = false;
					}
				}

				if (duplicated) {
					boolean alreadyReported = false;

					if (errorSourcesDuplicatedFound.containsKey(firstComponent)) {
						List<PropagationPathEnd> errorSourcesAlreadyFound = errorSourcesDuplicatedFound
								.get(firstComponent);
						if (errorSourcesAlreadyFound.containsAll(errorSourcesduplicates)) {
							alreadyReported = true;
						}
					}

					if (errorSourcesDuplicatedFound.containsKey(secondComponent)) {
						List<PropagationPathEnd> errorSourcesAlreadyFound = errorSourcesDuplicatedFound
								.get(secondComponent);
						if (errorSourcesAlreadyFound.containsAll(errorSourcesduplicates)) {
							alreadyReported = true;
						}
					}

					/**
					 * This report entry has not been reported yet, so, we add it in the report.
					 */
					if (!alreadyReported) {

						CMAReportEntry entry;
						String justification;
						String relatedFeatureName;

						relatedFeatureName = EMV2Util.getPrintName(ppe1.getErrorPropagation());

						entry = new CMAReportEntry();
						entry.setSource("Error source " + relatedFeatureName
								+ EMV2Util.getPrintName(ppe1.getErrorPropagation().getTypeSet()) + " affecting "
								+ componentInstance.getName());

						justification = "The same error source (on " + relatedFeatureName
								+ EMV2Util.getPrintName(ppe1.getErrorPropagation().getTypeSet()) + " on component "
								+ ppe1.getComponentInstance().getQualifiedName()
								+ " can impact the following components ";
						for (int i = 0; i < instancesDuplicates.size(); i++) {
							justification += instancesDuplicates.get(i).getName();
							if (i < (instancesDuplicates.size() - 1)) {
								justification += " and ";
							}
							entry.addRelatedComponent(instancesDuplicates.get(i));
						}
						entry.setJustification(justification);
						entry.setMode("Safety Specification");
						entry.setType(EntryType.FAULT);
						entry.setSeverity(currentSeverity);
						result.add(entry);

						List<PropagationPathEnd> duplicatesFound;
						if (errorSourcesDuplicatedFound.containsKey(firstComponent)) {
							duplicatesFound = errorSourcesDuplicatedFound.get(firstComponent);
							duplicatesFound.addAll(errorSourcesduplicates);
						} else {
							duplicatesFound = errorSourcesduplicates;
						}
						errorSourcesDuplicatedFound.put(firstComponent, duplicatesFound);

						if (errorSourcesDuplicatedFound.containsKey(secondComponent)) {
							duplicatesFound = errorSourcesDuplicatedFound.get(secondComponent);
							duplicatesFound.addAll(errorSourcesduplicates);
						} else {
							duplicatesFound = errorSourcesduplicates;
						}
						errorSourcesDuplicatedFound.put(secondComponent, duplicatesFound);

					}
				}
			}
		}

		/**
		 * In the following, we try to find common processor bindings between ANDed components.
		 */

		for (ComponentInstance firstComponent : referencedInstances) {

			for (ComponentInstance secondComponent : referencedInstances) {
				if (firstComponent == secondComponent) {
					continue;
				}

				for (ComponentInstance firstProcessor : GetProperties.getActualProcessorBinding(firstComponent)) {
					for (ComponentInstance secondProcessor : GetProperties.getActualProcessorBinding(secondComponent)) {
						if (firstProcessor == secondProcessor) {
							CMAReportEntry entry;
							String justification;

							entry = new CMAReportEntry();
							entry.setSource("Processor " + firstProcessor.getName());
							justification = "Processor associated with redundant components: "
									+ firstComponent.getName() + " and " + secondComponent.getName();
							entry.addRelatedComponent(firstComponent);
							entry.addRelatedComponent(secondComponent);
							entry.setJustification(justification);
							entry.setMode("Common bindings");
							entry.setType(EntryType.ARCHITECTURE_DESIGN);

							entry.setSeverity(currentSeverity);
							result.add(entry);

						}
					}
				}
			}
		}

		/**
		 * In the following, we try to find common memory bindings between ANDed components.
		 */
		for (ComponentInstance firstComponent : referencedInstances) {

			for (ComponentInstance secondComponent : referencedInstances) {
				if (firstComponent == secondComponent) {
					continue;
				}

				for (ComponentInstance firstMemory : GetProperties.getActualProcessorBinding(firstComponent)) {
					for (ComponentInstance secondMemory : GetProperties.getActualProcessorBinding(secondComponent)) {
						if (firstMemory == secondMemory) {
							CMAReportEntry entry;
							String justification;

							entry = new CMAReportEntry();
							entry.setSource("Memory " + firstMemory.getName());
							justification = "Memory associated with redundant components: " + firstComponent.getName()
									+ " and " + secondComponent.getName();
							entry.addRelatedComponent(firstComponent);
							entry.addRelatedComponent(secondComponent);
							entry.setJustification(justification);
							entry.setMode("Common bindings");
							entry.setType(EntryType.ARCHITECTURE_DESIGN);

							entry.setSeverity(currentSeverity);
							result.add(entry);
						}
					}
				}
			}
		}

		/**
		 * In the following, we will then try to find duplicates classifier between ANDed
		 * components.
		 */
		Map<ComponentClassifier, List<ComponentInstance>> classifierDuplicatedFound = new HashMap<ComponentClassifier, List<ComponentInstance>>();
		for (ComponentInstance ci : referencedInstances) {
			List<ComponentInstance> duplicatesContainer;
			boolean foundInOther;
			boolean duplicated;
			for (ComponentClassifier cl : componentClassifiers.get(ci)) {
				duplicated = true;

				duplicatesContainer = new ArrayList<ComponentInstance>();
				for (ComponentInstance ci2 : referencedInstances) {

					foundInOther = false;

					if (ci2 == ci) {
						continue;
					}

					for (ComponentClassifier cl2 : componentClassifiers.get(ci2)) {
						if (cl2 == cl) {
							foundInOther = true;
							if (!duplicatesContainer.contains(ci2)) {
								duplicatesContainer.add(ci2);
							}

							if (!duplicatesContainer.contains(ci)) {
								duplicatesContainer.add(ci);
							}
						}
					}
					if (foundInOther == false) {
						duplicated = false;
					}
				}

				if (duplicated) {
					boolean alreadyReported = false;
					/**
					 * The following condition checks that we already reported this issue/duplicate.
					 */
					alreadyReported = classifierDuplicatedFound.containsKey(cl)
							&& classifierDuplicatedFound.get(cl).containsAll(duplicatesContainer);

					if (!alreadyReported) {
						CMAReportEntry entry;
						String justification;

						entry = new CMAReportEntry();
						entry.setSource("System instance " + duplicatesContainer.get(0).getSystemInstance().getName());
						justification = "Classifier (component type) " + cl.getName()
								+ " is used within the following components: ";
						for (int i = 0; i < duplicatesContainer.size(); i++) {
							justification += duplicatesContainer.get(i).getName();
							if (i < (duplicatesContainer.size() - 1)) {
								justification += " and ";
							}
							entry.addRelatedComponent(duplicatesContainer.get(i));

						}
						entry.setJustification(justification);
						entry.setMode("Duplicate specification");
						entry.setType(EntryType.SPECIFICATION);

						entry.setSeverity(currentSeverity);
						result.add(entry);

						classifierDuplicatedFound.put(cl, duplicatesContainer);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Get all the classifiers used by a component. It browses its children and related
	 * components to register all sub-components classifiers.
	 * @param instance - the top-level component that contains the rest.
	 * @param result   - an initialized list that will contain the result (all the classifiers)
	 */
	public static void getAllClassifiers(ComponentInstance instance, List<ComponentClassifier> result) {
		result.add(instance.getComponentClassifier());
		for (ComponentInstance child : instance.getComponentInstances()) {
			getAllClassifiers(child, result);
		}
	}

	/**
	 * Get all the error sources related to a component and its subcomponent. We can then
	 * check if there is some overlap of error sources that impact two components.
	 * @param instance - the top-level component that contains the rest.
	 * @param result   - an initialized list that will contain the result (all the error sources)
	 */
	public static void getAllErrorSources(ComponentInstance instance, AnalysisModel analysisModel,
			List<PropagationPathEnd> result) {
		for (ErrorPropagation ep : EMV2Util.getAllIncomingErrorPropagations(instance)) {

			for (PropagationPathEnd ppe : analysisModel.getAllPropagationSourceEnds(instance, ep)) {
				result.add(ppe);
			}
		}

		for (ComponentInstance child : instance.getComponentInstances()) {
			getAllErrorSources(child, analysisModel, result);
		}
	}

	/**
	 * find a component instance in a component.
	 * @param rootComponent - the component that contains the subcomponent
	 * @param subcomponent  - the subcomponent to look for
	 * @return
	 */
	public static ComponentInstance findComponentInstance(ComponentInstance topComponent, Subcomponent subcomponent) {
		ComponentInstance result = null;
		for (ComponentInstance ci : topComponent.getComponentInstances()) {
			if (ci.getName().equalsIgnoreCase(subcomponent.getName())) {
				result = ci;
			}
		}
		return result;
	}

	public static int convertSeverity(String sev) {
		if (sev.equalsIgnoreCase("catastrophic")) {
			return SEVERITY_CATASTROPHIC;
		}

		if (sev.equalsIgnoreCase("hazardous")) {
			return SEVERITY_HAZARDOUS;
		}

		if (sev.equalsIgnoreCase("severemajor")) {
			return SEVERITY_SEVEREMAJOR;
		}

		if (sev.equalsIgnoreCase("major")) {
			return SEVERITY_MAJOR;
		}

		if (sev.equalsIgnoreCase("minor")) {
			return SEVERITY_MINOR;
		}

		if (sev.equalsIgnoreCase("noeffect")) {
			return SEVERITY_NOEFFECT;
		}

		return SEVERITY_UNKNOWN;
	}

}
