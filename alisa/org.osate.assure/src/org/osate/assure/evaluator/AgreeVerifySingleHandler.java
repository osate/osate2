/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.evaluator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.util.Pair;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.annexsupport.AnnexUtil;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.result.Diagnostic;
import org.osate.result.ResultFactory;

import com.rockwellcollins.atc.agree.agree.AgreeContractSubclause;
import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.AgreeSubclause;
import com.rockwellcollins.atc.agree.agree.Arg;
import com.rockwellcollins.atc.agree.agree.AssertStatement;
import com.rockwellcollins.atc.agree.agree.AssumeStatement;
import com.rockwellcollins.atc.agree.agree.GuaranteeStatement;
import com.rockwellcollins.atc.agree.agree.LemmaStatement;
import com.rockwellcollins.atc.agree.agree.PropertyStatement;
import com.rockwellcollins.atc.agree.analysis.Activator;
import com.rockwellcollins.atc.agree.analysis.AgreeException;
import com.rockwellcollins.atc.agree.analysis.AgreeLayout;
import com.rockwellcollins.atc.agree.analysis.AgreeLayout.SigType;
import com.rockwellcollins.atc.agree.analysis.AgreeRenaming;
import com.rockwellcollins.atc.agree.analysis.AgreeUtils;
import com.rockwellcollins.atc.agree.analysis.ConsistencyResult;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeASTBuilder;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeNode;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeProgram;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeStatement;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeVar;
import com.rockwellcollins.atc.agree.analysis.handlers.VerifySingleHandler;
import com.rockwellcollins.atc.agree.analysis.preferences.PreferencesUtil;
import com.rockwellcollins.atc.agree.analysis.translation.LustreAstBuilder;
import com.rockwellcollins.atc.agree.analysis.translation.LustreContractAstBuilder;

import jkind.JKindException;
import jkind.api.JRealizabilityApi;
import jkind.api.KindApi;
import jkind.api.results.AnalysisResult;
import jkind.api.results.CompositeAnalysisResult;
import jkind.api.results.JKindResult;
import jkind.api.results.JRealizabilityResult;
import jkind.api.results.PropertyResult;
import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.VarDecl;

/**
 * Most code are brought from VerifyHandler in Agree and edited to eliminate
 * link to GUI components which can't be set while running from Assure.
 * Also instantiation is performed outside of VerifyHandler.
 *
 */
public class AgreeVerifySingleHandler extends VerifySingleHandler {

	private AnalysisResult jobResult;
	private VerificationResult verificationResult;
	private TreeViewer progressTreeViewer;

	private String EMPTY_COMPOSITE_ANALYSIS_NAME = "";

	enum AgreeAnalysisType {
		AssumeGuarantee, Consistency, Realizability
	}

	AgreeVerifySingleHandler(VerificationResult result) {
		super();

		verificationResult = result;

	}

	public Object executeSystemInstance(ComponentInstance si, TreeViewer progressTreeViewer) {
		// window = HandlerUtil.getActiveWorkbenchWindow(event);

		this.progressTreeViewer = progressTreeViewer;

		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			// private IHandlerActivation terminateActivation;

			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {

				return runJobPrivate(si, monitor);

			}
		};

		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();

		return null;
	}

	private void updateProgress(VerificationResult result) {
		if (progressTreeViewer != null) {
			Display.getDefault().asyncExec(() -> progressTreeViewer.update(result, null));
		}
	}

	private IStatus runJobPrivate(ComponentInstance si, IProgressMonitor monitor) {
		// disableRerunHandler();

		// handlerService = (IHandlerService) getWindow().getService(IHandlerService.class);

//		if (!(root instanceof ComponentImplementation)) {
//			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Must select an AADL Component Implementation");
//		}

		try {

			// AnalysisResult result;
			CompositeAnalysisResult wrapper = new CompositeAnalysisResult(EMPTY_COMPOSITE_ANALYSIS_NAME);

			// ComponentImplementation ci = si.getComponentImplementation();
			ComponentImplementation ci = AgreeUtils.getInstanceImplementation(si);

			ComponentType sysType = AgreeUtils.getInstanceType(si);
			EList<AnnexSubclause> annexSubClauses = AnnexUtil.getAllAnnexSubclauses(sysType,
					AgreePackage.eINSTANCE.getAgreeContractSubclause());

			if (annexSubClauses.size() == 0) {
				throw new AgreeException("There is not an AGREE annex in the '" + sysType.getName() + "' system type.");
			}

			if (isRecursive()) {
				if (AgreeUtils.usingKind2()) {
					throw new AgreeException("Kind2 only supports monolithic verification");
				}
				jobResult = buildAnalysisResult(ci.getName(), si);
				wrapper.addChild(jobResult);
				jobResult = wrapper;
			} else if (isRealizability()) {
				AgreeProgram agreeProgram = new AgreeASTBuilder().getAgreeProgram(si, isMonolithic());
				Program program = LustreAstBuilder.getRealizabilityLustreProgram(agreeProgram);
				wrapper.addChild(createVerification("Realizability Check", si, program, agreeProgram,
						AgreeAnalysisType.Realizability));
				jobResult = wrapper;
			} else {
				wrapVerificationResult(si, wrapper);
				jobResult = wrapper;
			}

			// showView(result, linker);
			return doAnalysis(si, monitor);
		} catch (Throwable e) {
			String messages = getNestedMessages(e);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, messages, e);
		}
	}

	private IStatus doAnalysis(final Element root, final IProgressMonitor globalMonitor) {

		Thread analysisThread = new Thread() {
			@Override
			public void run() {
				// activateTerminateHandlers(globalMonitor);

				KindApi api = PreferencesUtil.getKindApi();
				KindApi consistApi = PreferencesUtil.getConsistencyApi();
				JRealizabilityApi realApi = PreferencesUtil.getJRealizabilityApi();

				while (!queue.isEmpty() && !globalMonitor.isCanceled()) {
					JKindResult result = queue.peek();
					NullProgressMonitor subMonitor = new NullProgressMonitor();
					monitorRef.set(subMonitor);

					Program program = linker.getProgram(result);
					try {
						if (result instanceof ConsistencyResult) {
							consistApi.execute(program, result, subMonitor);
						} else if (result instanceof JRealizabilityResult) {
							realApi.execute(program, (JRealizabilityResult) result, subMonitor);
						} else {
							api.execute(program, result, subMonitor);
						}
					} catch (JKindException e) {
						System.out.println("******** JKindException Text ********");
						e.printStackTrace(System.out);
						System.out.println("******** JKind Output ********");
						System.out.println(result.getText());
						System.out.println("******** Agree Lustre ********");
						System.out.println(program);
						break;
					}

					queue.remove();
				}

				while (!queue.isEmpty()) {
					queue.remove().cancel();
				}

				Resource res2 = verificationResult.eResource();
				if (res2 == null) {
					System.out.println("DDDDDDDDDDDDDDDDDDDDDDDD executeURI NULLLLLLLLLLLLLLLL  3333333333333333");
				}

				// translating results to Assure
				try {
					updateAgreeResults((CompositeAnalysisResult) jobResult);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// deactivateTerminateHandlers();
				// enableRerunHandler(root);

			}

		};
		analysisThread.start();
		return Status.OK_STATUS;
	}

	/**
	 * Top analysis result is always a CompositeAnalysisResult with empty string name
	 * @param compositeAnalysisResult
	 * @throws IOException
	 */
	protected void updateAgreeResults(CompositeAnalysisResult compositeAnalysisResult) throws IOException {
		// System.out.println("AgreeVerifySingleHandler.updateAgreeResults() 0000");

		for (Iterator iterator = compositeAnalysisResult.getChildren().iterator(); iterator.hasNext();) {
			AnalysisResult analysisResult = (AnalysisResult) iterator.next();

			// System.out.println("AgreeVerifySingleHandler.updateAgreeResults() 1111");
			if (analysisResult instanceof CompositeAnalysisResult) { // if agree all was used
				CompositeAnalysisResult subCompositeResult = (CompositeAnalysisResult) analysisResult;
				updateAgreeResults(subCompositeResult);
			} else if (analysisResult instanceof ConsistencyResult) {
				// TODO: showing consistency results

			} else if (analysisResult instanceof JRealizabilityResult) {
				// TODO: showing realizability results

			} else { // JKindResult. Row that shows Contract Guarantees
				JKindResult jKindResult = (JKindResult) analysisResult;
				// System.out.println("AgreeVerifySingleHandler.updateAgreeResults() 2222");
				switch (jKindResult.getMultiStatus().getOverallStatus()) {

				case VALID:
					AssureUtilExtension.setToSuccess(verificationResult);
					break;

				case WORKING:
				case INVALID:
				case UNKNOWN:
				case CANCELED:
				case ERROR:
				case WAITING:
					// case VALID_REFINED:
					Diagnostic topResultIssue = ResultFactory.eINSTANCE.createDiagnostic();
					for (Iterator<PropertyResult> iterator2 = jKindResult.getPropertyResults().iterator(); iterator2
							.hasNext();) {
						PropertyResult propertyResult = iterator2.next();

						System.out.println(
								"AgreeVerifySingleHandler.updateAgreeResults() Invalid --" + propertyResult.getName());

						Map<String, EObject> refMap = linker.getReferenceMap(propertyResult.getParent());
						EObject target = refMap.get(propertyResult.getName());

						switch (propertyResult.getStatus()) {
						case VALID:
							AssureUtilExtension.addSuccessIssue(topResultIssue, target, propertyResult.getName());
							break;

						case WORKING:
						case INVALID:
						case UNKNOWN:
						case CANCELED:
						case ERROR:
						case WAITING:
							// case VALID_REFINED:
							AssureUtilExtension.addFailIssue(topResultIssue, target,
									propertyResult.getStatus().toString() + "-" + propertyResult.getName());
							break;

						default:
							break;
						}
					}
					// System.out.println("AgreeVerifySingleHandler.updateAgreeResults() setToFail");
					AssureUtilExtension.setToFail(verificationResult, topResultIssue.getIssues());
				default:

				}
			}
		}

		verificationResult.eResource().save(null);
		updateProgress(verificationResult);
	}

	private AnalysisResult buildAnalysisResult(String name, ComponentInstance ci) {
		CompositeAnalysisResult result = new CompositeAnalysisResult("Verification for " + name);

		if (containsAGREEAnnex(ci)) {
			wrapVerificationResult(ci, result);
			ComponentImplementation compImpl = AgreeUtils.getInstanceImplementation(ci);
			for (ComponentInstance subInst : ci.getComponentInstances()) {
				if (AgreeUtils.getInstanceImplementation(subInst) != null) {
					AnalysisResult buildAnalysisResult = buildAnalysisResult(subInst.getName(), subInst);
					if (buildAnalysisResult != null) {
						result.addChild(buildAnalysisResult);
					}
				}
			}

			if (result.getChildren().size() != 0) {
				linker.setComponent(result, compImpl);
				return result;
			}
		}
		return null;
	}

	private boolean containsAGREEAnnex(ComponentInstance ci) {
		ComponentClassifier compClass = ci.getComponentClassifier();
		if (compClass instanceof ComponentImplementation) {
			compClass = ((ComponentImplementation) compClass).getType();
		}
		for (AnnexSubclause annex : AnnexUtil.getAllAnnexSubclauses(compClass,
				AgreePackage.eINSTANCE.getAgreeContractSubclause())) {
			if (annex instanceof AgreeContractSubclause) {
				return true;
			}
		}
		return false;
	}

	private void wrapVerificationResult(ComponentInstance si, CompositeAnalysisResult wrapper) {
		AgreeProgram agreeProgram = new AgreeASTBuilder().getAgreeProgram(si, isMonolithic());

		// generate different lustre depending on which model checker we are
		// using

		Program program;
		if (AgreeUtils.usingKind2()) {
			if (!isMonolithic()) {
				throw new AgreeException("Kind2 now only supports monolithic verification");
			}
			program = LustreContractAstBuilder.getContractLustreProgram(agreeProgram);
		} else {
			program = LustreAstBuilder.getAssumeGuaranteeLustreProgram(agreeProgram);
		}
		List<Pair<String, Program>> consistencies = LustreAstBuilder.getConsistencyChecks(agreeProgram);

		wrapper.addChild(createVerification("Contract Guarantees", si, program, agreeProgram,
				AgreeAnalysisType.AssumeGuarantee));
		for (Pair<String, Program> consistencyAnalysis : consistencies) {
			wrapper.addChild(createVerification(consistencyAnalysis.getFirst(), si, consistencyAnalysis.getSecond(),
					agreeProgram, AgreeAnalysisType.Consistency));
		}
	}

	private AnalysisResult createVerification(String resultName, ComponentInstance compInst, Program lustreProgram,
			AgreeProgram agreeProgram, AgreeAnalysisType analysisType) {

		AgreeRenaming renaming = new AgreeRenaming();
		AgreeLayout layout = new AgreeLayout();
		Node mainNode = null;
		for (Node node : lustreProgram.nodes) {
			if (node.id.equals(lustreProgram.main)) {
				mainNode = node;
				break;
			}
		}
		if (mainNode == null) {
			throw new AgreeException("Could not find main lustre node after translation");
		}

		List<String> properties = new ArrayList<String>();
		addRenamings(renaming, properties, layout, mainNode, agreeProgram);

		JKindResult result;
		switch (analysisType) {
		case Consistency:
			result = new ConsistencyResult(resultName, mainNode.properties, Collections.singletonList(true), renaming);
			break;
		case Realizability:
			result = new JRealizabilityResult(resultName, renaming);
			break;
		case AssumeGuarantee:
			result = new JKindResult(resultName, properties, renaming);
			break;
		default:
			throw new AgreeException("Unhandled Analysis Type");
		}
		queue.add(result);

		ComponentImplementation compImpl = AgreeUtils.getInstanceImplementation(compInst);
		linker.setProgram(result, lustreProgram);
		linker.setComponent(result, compImpl);
		linker.setContract(result, getContract(compImpl));
//		linker.setLayout(result, layout);   This cause NoClassDefFoundError. Don't know why. Used for counter example menu
		linker.setReferenceMap(result, renaming.getRefMap());
//		linker.setLog(result, AgreeLogger.getLog());

		// System.out.println(program);
		return result;

	}

	private void addRenamings(AgreeRenaming renaming, List<String> properties, AgreeLayout layout, Node mainNode,
			AgreeProgram agreeProgram) {
		for (VarDecl var : mainNode.inputs) {
			if (var instanceof AgreeVar) {
				addReference(renaming, layout, var);
			}
		}

		for (VarDecl var : mainNode.locals) {
			if (var instanceof AgreeVar) {
				addReference(renaming, layout, var);
			}
		}

		for (VarDecl var : mainNode.outputs) {
			if (var instanceof AgreeVar) {
				addReference(renaming, layout, var);
			}
		}

		// there is a special case in the AgreeRenaming which handles this translation
		if (AgreeUtils.usingKind2()) {
			addKind2Properties(agreeProgram.topNode, properties, renaming, "_TOP", "");
		} else {
			properties.addAll(mainNode.properties);
		}

	}

	void addKind2Properties(AgreeNode agreeNode, List<String> properties, AgreeRenaming renaming, String prefix,
			String userPropPrefix) {
		int i = 0;

		String propPrefix = (userPropPrefix.equals("")) ? "" : userPropPrefix + ": ";
		for (AgreeStatement statement : agreeNode.lemmas) {
			renaming.addExplicitRename(prefix + "[" + (++i) + "]", propPrefix + statement.string);
			properties.add(prefix.replaceAll("\\.", AgreeASTBuilder.dotChar) + "[" + i + "]");
		}
		for (AgreeStatement statement : agreeNode.guarantees) {
			renaming.addExplicitRename(prefix + "[" + (++i) + "]", propPrefix + statement.string);
			properties.add(prefix.replaceAll("\\.", AgreeASTBuilder.dotChar) + "[" + i + "]");
		}

		userPropPrefix = userPropPrefix.equals("") ? "" : userPropPrefix + ".";
		for (AgreeNode subNode : agreeNode.subNodes) {
			addKind2Properties(subNode, properties, renaming, prefix + "." + subNode.id, userPropPrefix + subNode.id);
		}
	}

	private void addReference(AgreeRenaming renaming, AgreeLayout layout, VarDecl var) {
		String refStr = getReferenceStr((AgreeVar) var);
		renaming.addExplicitRename(var.id, refStr);
		renaming.addToRefMap(var.id, ((AgreeVar) var).reference);
		String category = getCategory((AgreeVar) var);
		if (category != null && !layout.getCategories().contains(category)) {
			layout.addCategory(category);
		}
		layout.addElement(category, refStr, SigType.INPUT);
	}

	private String getCategory(AgreeVar var) {
		if (var.compInst == null || var.reference == null) {
			return null;
		}
		return LustreAstBuilder.getRelativeLocation("", var.compInst.getInstanceObjectPath());
	}

	private String getReferenceStr(AgreeVar var) {

		String prefix = getCategory(var);
		if (prefix == null) {
			return null;
		}
		if (var.id.endsWith(AgreeASTBuilder.clockIDSuffix)) {
			return null;
		}

		String seperator = (prefix == "" ? "" : ".");
		EObject reference = var.reference;
		if (reference instanceof GuaranteeStatement) {
			return ((GuaranteeStatement) reference).getStr();
		} else if (reference instanceof AssumeStatement) {
			return prefix + " assume: " + ((AssumeStatement) reference).getStr();
		} else if (reference instanceof LemmaStatement) {
			return prefix + " lemma: " + ((LemmaStatement) reference).getStr();
		} else if (reference instanceof AssertStatement) {
			throw new AgreeException("We really didn't expect to see an assert statement here");
		} else if (reference instanceof Arg) {
			return prefix + seperator + ((Arg) reference).getName();
		} else if (reference instanceof DataPort) {
			return prefix + seperator + ((DataPort) reference).getName();
		} else if (reference instanceof EventDataPort) {
			return prefix + seperator + ((EventDataPort) reference).getName() + "._EVENT_";
		} else if (reference instanceof FeatureGroup) {
			return prefix + seperator + ((FeatureGroup) reference).getName();
		} else if (reference instanceof PropertyStatement) {
			return prefix + seperator + ((PropertyStatement) reference).getName();
		} else if (reference instanceof ComponentType || reference instanceof ComponentImplementation) {
			return "Result";
		}
		throw new AgreeException("Unhandled reference type: '" + reference.getClass().getName() + "'");
	}

	private AgreeSubclause getContract(ComponentImplementation ci) {
		ComponentType ct = ci.getOwnedRealization().getImplemented();
		for (AnnexSubclause annex : ct.getOwnedAnnexSubclauses()) {
			if (annex instanceof AgreeSubclause) {
				return (AgreeSubclause) annex;
			}
		}
		return null;
	}

}
