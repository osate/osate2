/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.faulttree.tests;

import java.util.Objects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;

/**
 * Exercises fault-tree, trace, cut-set, optimization, and probability scenarios to preserve analysis behavior.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class FTATest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	private Object primaryroot = null;

	private static SystemInstance instance1;

	private static SystemInstance instance2;

	private static SystemInstance instance3;

	private static SystemInstance instancecommon1;

	private static SystemInstance instancecommon2;

	private static SystemInstance instancecommon3;

	private static SystemInstance instancecomposite;

	private static SystemInstance instanceredundant;

	private static SystemInstance instanceredundant21;

	private static SystemInstance instanceredundant22;

	private static SystemInstance instanceredundant23;

	private static SystemInstance instancevoter;

	private static SystemInstance instanceDualFGS;

	private static SystemInstance instanceFilteredFlow;

	private static SystemInstance instanceAllFlows;

	private static SystemInstance instanceOptimize;

	private static SystemInstance instanceTransitionBranch;

	private static SystemInstance instanceOR1OFProbability;

	private static SystemInstance instancePathProbability;

	private static SystemInstance instanceIssue1819;

	private static SystemInstance instanceIssue1882;

	private static SystemInstance instanceIssue1893;

	private static SystemInstance instanceIssue1913;

	private static SystemInstance instanceIssue1915;

	private static SystemInstance instanceIssue1899;

	private static SystemInstance instanceIssue1837;

	private static SystemInstance instanceIssue1837bis;

	private static SystemInstance instanceIssue1962;

	private static SystemInstance instanceIssue1961;

	private static SystemInstance instanceIssue1384;

	private static SystemInstance instanceIssues21232425;

	private static SystemInstance instanceIssue2112;

	private static SystemInstance instanceIssue2177;

	private static SystemInstance instanceIssue2546Untyped;

	private static SystemInstance instanceIssue2546Typed;

	private static SystemInstance instanceIssue2391;

	private static final String stateFail = "state Failed";

	private static final String stateFailStop = "state FailStop";

	private static final String stateOp = "state Operational";

	private final String modelroot = "org.osate.aadl2.errormodel.faulttree.tests/models/FTATests/";

	private final String fta1File = "fta1Test.aadl";

	private final String fta2File = "fta2Test.aadl";

	private final String fta3File = "fta3Test.aadl";

	private final String common1File = "common-error.aadl";

	private final String common2File = "common-error2.aadl";

	private final String common3File = "common-error3.aadl";

	private final String nestedcompositeFile = "nestedcomposite.aadl";

	private final String redundantFile = "redundant.aadl";

	private final String redundant2File = "redundant2.aadl";

	private final String voterFile = "voter.aadl";

	private final String errorlibFile = "ErrorModellibrary.aadl";

	private final String FTerrorlibFile = "FTerrorlibrary.aadl";

	private final String dualfgsFile = "DualFGS.aadl";

	private final String fgselibFile = "FGSErrorModelLibrary.aadl";

	private final String filteredflowsFile = "FilteredFlows.aadl";

	private final String allflowsFile = "AllFlows.aadl";

	private final String optimizeFile = "OptimizeTree.aadl";

	private final String transitionbranchFile = "branchtransitions.aadl";

	private final String SysErrorLibFile = "Sys_Error_Lib.aadl";

	private final String OR1OFProbabilityfile = "OR1OFProbability.aadl";

	private final String PathProbabilityfile = "PathProbability.aadl";

	private final String Issue1819file = "Issue1819.aadl";

	private final String Issue1882file = "Issue1882.aadl";

	private final String GPSErrorLibraryFile = "GPSErrorLibrary.aadl";

	private final String GPSPartsFile = "GPSParts.aadl";

	private final String GPSSystemFile = "GPSSystem.aadl";

	private final String HardwarePartsFile = "HardwareParts.aadl";

	private final String EMTypesFile = "EMTypes.aadl";

	private final String ScrubbedTSFile = "ScrubbedTS.aadl";

	private final String ScrubbedClFile = "ScrubbedCl.aadl";

	private final String accessfeaturesFile = "accessfeatures.aadl";

	private final String Issue1837file = "Issue1837.aadl";

	private final String Issue1962file = "Issue1962.aadl";

	private final String Issue1961file = "Issue1961.aadl";

	private final String Issue1384file = "modeling_file.aadl";

	private final String Issue1384Errortypesfile = "emv2_errortype_definition.aadl";

	private final String ErrorStateWithTypesfile = "ErrorStateWithTypes.aadl";

	private final String Issue2177file = "Issue2177.aadl";

	private final String Issue2546UntypedFile = "Issue2546UntypedTest.aadl";

	private final String Issue2546TypedFile = "Issue2546TypedTest.aadl";

	private final String Issue2391File = "Issue2391.aadl";

	@Before
	public void initWorkspace() throws Exception {
		this.primaryroot = this.testHelper.parseFile((this.modelroot + this.fta1File), (this.modelroot + this.fta2File),
				(this.modelroot + this.fta3File), (this.modelroot + this.common1File),
				(this.modelroot + this.common2File), (this.modelroot + this.common3File),
				(this.modelroot + this.nestedcompositeFile), (this.modelroot + this.redundantFile),
				(this.modelroot + this.redundant2File), (this.modelroot + this.voterFile),
				(this.modelroot + this.dualfgsFile), (this.modelroot + this.filteredflowsFile),
				(this.modelroot + this.allflowsFile), (this.modelroot + this.optimizeFile),
				(this.modelroot + this.transitionbranchFile), (this.modelroot + this.fgselibFile),
				(this.modelroot + this.errorlibFile), (this.modelroot + this.FTerrorlibFile),
				(this.modelroot + this.SysErrorLibFile), (this.modelroot + this.OR1OFProbabilityfile),
				(this.modelroot + this.PathProbabilityfile), (this.modelroot + this.Issue1819file),
				(this.modelroot + this.Issue1882file), (this.modelroot + this.GPSErrorLibraryFile),
				(this.modelroot + this.HardwarePartsFile), (this.modelroot + this.GPSPartsFile),
				(this.modelroot + this.GPSSystemFile), (this.modelroot + this.EMTypesFile),
				(this.modelroot + this.ScrubbedTSFile), (this.modelroot + this.ScrubbedClFile),
				(this.modelroot + this.accessfeaturesFile), (this.modelroot + this.Issue1837file),
				(this.modelroot + this.Issue1962file), (this.modelroot + this.Issue1961file),
				(this.modelroot + this.Issue1384Errortypesfile), (this.modelroot + this.Issue1384file),
				(this.modelroot + this.ErrorStateWithTypesfile), (this.modelroot + this.Issue2177file),
				(this.modelroot + this.Issue2546UntypedFile), (this.modelroot + this.Issue2546TypedFile),
				(this.modelroot + this.Issue2391File));
		FTATest.instance1 = this.instanceGenerator((this.modelroot + this.fta1File), "main.i");
		FTATest.instance2 = this.instanceGenerator((this.modelroot + this.fta2File), "main.i");
		FTATest.instance3 = this.instanceGenerator((this.modelroot + this.fta3File), "main.i");
		FTATest.instancecommon1 = this.instanceGenerator((this.modelroot + this.common1File), "main.commonsource");
		FTATest.instancecommon2 = this.instanceGenerator((this.modelroot + this.common2File), "main.commonevents");
		FTATest.instancecommon3 = this.instanceGenerator((this.modelroot + this.common3File),
				"main.commoneventssingleport");
		FTATest.instancecomposite = this.instanceGenerator((this.modelroot + this.nestedcompositeFile),
				"main.nestedstate");
		FTATest.instanceredundant = this.instanceGenerator((this.modelroot + this.redundantFile),
				"main.compositestate");
		FTATest.instanceredundant21 = this.instanceGenerator((this.modelroot + this.redundant2File),
				"main2.connection");
		FTATest.instanceredundant22 = this.instanceGenerator((this.modelroot + this.redundant2File),
				"main2.compositesametype");
		FTATest.instanceredundant23 = this.instanceGenerator((this.modelroot + this.redundant2File),
				"main2.transition");
		FTATest.instancevoter = this.instanceGenerator((this.modelroot + this.voterFile), "voter.i");
		FTATest.instanceDualFGS = this.instanceGenerator((this.modelroot + this.dualfgsFile), "FGS.impl");
		FTATest.instanceFilteredFlow = this.instanceGenerator((this.modelroot + this.filteredflowsFile), "FGS.impl");
		FTATest.instanceAllFlows = this.instanceGenerator((this.modelroot + this.allflowsFile), "FGS.impl");
		FTATest.instanceOptimize = this.instanceGenerator((this.modelroot + this.optimizeFile), "Top.impl");
		FTATest.instanceTransitionBranch = this.instanceGenerator((this.modelroot + this.transitionbranchFile),
				"BTCU.i");
		FTATest.instanceOR1OFProbability = this.instanceGenerator((this.modelroot + this.OR1OFProbabilityfile),
				"S01.i");
		FTATest.instancePathProbability = this.instanceGenerator((this.modelroot + this.PathProbabilityfile), "main.i");
		FTATest.instanceIssue1819 = this.instanceGenerator((this.modelroot + this.Issue1819file), "Thermoheater.impl");
		FTATest.instanceIssue1882 = this.instanceGenerator((this.modelroot + this.Issue1882file), "ac.twoengine");
		FTATest.instanceIssue1893 = this.instanceGenerator((this.modelroot + this.GPSSystemFile), "GPS.Dual");
		FTATest.instanceIssue1913 = this.instanceGenerator((this.modelroot + this.ScrubbedTSFile), "top.vccl");
		FTATest.instanceIssue1915 = this.instanceGenerator((this.modelroot + this.ScrubbedClFile), "top.vc");
		FTATest.instanceIssue1899 = this.instanceGenerator((this.modelroot + this.accessfeaturesFile), "top.ii");
		FTATest.instanceIssue1837 = this.instanceGenerator((this.modelroot + this.Issue1837file), "TMR_Archetype.impl");
		FTATest.instanceIssue1837bis = this.instanceGenerator((this.modelroot + this.Issue1837file),
				"TMR_Archetype.impl2");
		FTATest.instanceIssue2112 = this.instanceGenerator((this.modelroot + this.Issue1837file), "top.impl");
		FTATest.instanceIssue1962 = this.instanceGenerator((this.modelroot + this.Issue1962file), "ac.impl");
		FTATest.instanceIssue1961 = this.instanceGenerator((this.modelroot + this.Issue1961file), "ac.impl");
		FTATest.instanceIssue1384 = this.instanceGenerator((this.modelroot + this.Issue1384file), "sys.i");
		FTATest.instanceIssues21232425 = this.instanceGenerator((this.modelroot + this.ErrorStateWithTypesfile),
				"iPCA_Safety.i");
		FTATest.instanceIssue2177 = this.instanceGenerator((this.modelroot + this.Issue2177file), "SubSys1.EMV2");
		FTATest.instanceIssue2546Untyped = this.instanceGenerator((this.modelroot + this.Issue2546UntypedFile),
				"sys.i");
		FTATest.instanceIssue2546Typed = this.instanceGenerator((this.modelroot + this.Issue2546TypedFile), "sys.i");
		FTATest.instanceIssue2391 = this.instanceGenerator((this.modelroot + this.Issue2391File),
				"GPS.parts_SingleSensorTransient");
	}

	public SystemInstance instanceGenerator(final String filename, final String rootclassifier) throws Exception {
		var ac = ((AadlPackage) this.primaryroot);
		var rs = ac.eResource().getResourceSet();
		var targetsrc = rs.getResource(URI.createURI(filename), true);
		var pkg = ((AadlPackage) (targetsrc.getContents()).getFirst());
		var cls = pkg.getOwnedPublicSection().getOwnedClassifiers();

		Assert.assertTrue("",
				cls.stream().anyMatch(classifier -> Objects.equals(classifier.getName(), rootclassifier)));
		var sysImpl = (ComponentImplementation) cls.stream()
				.filter(classifier -> Objects.equals(classifier.getName(), rootclassifier)).findFirst().orElseThrow();
		return InstantiateModel.instantiate(sysImpl);

	}

	/**
	 * example of simple composite error state with an AND operator.
	 * The subcomponents have two states and a transition triggered by an error event.
	 * The error event is a Basic Event.
	 */
	@Test
	public void fta1Test1() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instance1, FTATest.stateFail);
		Assert.assertEquals(ft.getEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(
				((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedInstanceObject()).getName(), "s1");
	}

	@Test
	public void fta2Test1() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instance2, FTATest.stateFail);
		Assert.assertEquals(ft.getEvents().size(), 11);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube2.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals((sube1.getSubEvents()).getFirst().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals((sube2.getSubEvents()).getFirst().getSubEventLogic(), LogicOperation.OR);
	}

	@Test
	public void fta2Test2() {
		var ftr = CreateFTAModel.createFaultTrace(FTATest.instance2, FTATest.stateFail);
		Assert.assertEquals(ftr.getEvents().size(), 18);
	}

	@Test
	public void fta2Test3() {
		var ftparts = CreateFTAModel.createPartsFaultTree(FTATest.instance2, FTATest.stateFail);
		Assert.assertEquals(ftparts.getEvents().size(), 8);
		var ev1 = (ftparts.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(ev1.getSubEventLogic(), LogicOperation.AND);
		var sube11 = (ev1.getSubEvents()).getFirst();
		var sube22 = ev1.getSubEvents().get(1);
		Assert.assertEquals(sube11.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube22.getSubEventLogic(), LogicOperation.XOR);
	}

	@Test
	public void fta3Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instance3, FTATest.stateFail);
		Assert.assertEquals(ft.getEvents().size(), 9);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(((NamedElement) sube1.getRelatedInstanceObject()).getName(), "s1");
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.OR);
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(sube1.getSubEvents().size(), 3);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
	}

	@Test
	public void common1Test1() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instancecommon1, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(((NamedElement) ft.getRoot().getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertTrue((ft.getRoot().getRelatedEMV2Object() instanceof ErrorBehaviorState));
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube1.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"a0");
		Assert.assertEquals(((NamedElement) sube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(), "a1");
	}

	@Test
	public void common1Test2() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instancecommon1, FTATest.stateOp);
		Assert.assertEquals(ft.getEvents().size(), 1);
	}

	@Test
	public void common2Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instancecommon2, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 7);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(((NamedElement) ft.getRoot().getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertTrue((ft.getRoot().getRelatedEMV2Object() instanceof ErrorBehaviorState));
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube1.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"a0");
		Assert.assertEquals(((NamedElement) sube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(), "a1");
	}

	@Test
	public void common3Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instancecommon3, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 7);
		Assert.assertEquals(((NamedElement) ft.getRoot().getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertTrue((ft.getRoot().getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube1.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"a0");
		Assert.assertEquals(((NamedElement) sube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(), "a1");
	}

	@Test
	public void compositeerrorfta() {
		var ft = CreateFTAModel.createModel(FTATest.instancecommon1, FTATest.stateFailStop,
				FaultTreeType.COMPOSITE_PARTS);
		Assert.assertEquals(ft.getEvents().size(), 4);
		for (final Event event : ft.getEvents()) {
			if ((!Objects.equals(event.getType(), EventType.INTERMEDIATE))) {
				Assert.assertTrue((event.getRelatedEMV2Object() instanceof ErrorBehaviorState));
			}
		}
	}

	@Test
	public void nestedcompositepartsfta() {
		var ft = CreateFTAModel.createPartsFaultTree(FTATest.instancecomposite, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 11);
		for (final Event event : ft.getEvents()) {
			if ((!Objects.equals(event.getType(), EventType.INTERMEDIATE))) {
				Assert.assertTrue((event.getRelatedEMV2Object() instanceof ErrorBehaviorState));
			}
		}
	}

	@Test
	public void nestedcompositefta() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instancecomposite, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 8);
		for (final Event event : ft.getEvents()) {
			if ((!Objects.equals(event.getType(), EventType.INTERMEDIATE))) {
				Assert.assertTrue((event.getRelatedEMV2Object() instanceof ErrorEvent));
			}
		}
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 3);
		Assert.assertEquals(((NamedElement) ft.getRoot().getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertTrue((ft.getRoot().getRelatedEMV2Object() instanceof ErrorBehaviorState));
		var sube2 = (ft.getRoot().getSubEvents()).getFirst();
		var sube1 = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		Assert.assertEquals(sube2.getSubEvents().size(), 2);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube1.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"thr1");
		Assert.assertEquals(((NamedElement) sube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(), "thr2");
		Assert.assertTrue(((sube2.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube2.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube2.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(((NamedElement) sube2.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor2");
	}

	@Test
	public void redundantTest() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceredundant, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.XOR);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		var sube2 = ft.getRoot().getSubEvents().get(1);
		var sube3 = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "actuator");
		Assert.assertEquals(((NamedElement) sube3.getRelatedInstanceObject()).getName(), "thr");
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		Assert.assertTrue(((sube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((ErrorEvent) (sube1.getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"Failure");
		Assert.assertEquals(((NamedElement) (sube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(((NamedElement) sube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor2");
	}

	@Test
	public void redundant21ConnectionBindingTest() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceredundant21, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 16);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 9);
		var sube1 = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(((NamedElement) sube1.getRelatedInstanceObject()).getName(), "thr");
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube1 = (sube1.getSubEvents()).getFirst();
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube1.getSubEvents().size(), 2);
		Assert.assertEquals(subsube2.getSubEvents().size(), 2);
		Assert.assertTrue(((subsube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorSource));
		Assert.assertEquals(((NamedElement) (subsube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(((NamedElement) subsube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) (subsube1.getSubEvents()).getFirst().getRelatedErrorType())),
				"LateDelivery");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube1.getSubEvents().get(1).getRelatedErrorType())),
				"OutOfRange");
		Assert.assertTrue(((subsube2.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorSource));
		Assert.assertEquals(((NamedElement) (subsube2.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor2");
		Assert.assertEquals(((NamedElement) subsube2.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor2");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) (subsube2.getSubEvents()).getFirst().getRelatedErrorType())),
				"LateDelivery");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube2.getSubEvents().get(1).getRelatedErrorType())),
				"OutOfRange");

		Assert.assertTrue(ft.getRoot().getSubEvents().stream()
				.anyMatch(event -> event.getRelatedInstanceObject() instanceof ConnectionInstance));
	}

	@Test
	public void redundant22Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceredundant22, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 11);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		var sube1 = (ft.getRoot().getSubEvents()).getFirst();
		Assert.assertEquals(((NamedElement) sube1.getRelatedInstanceObject()).getName(), "actuator");
	}

	@Test
	public void redundant23Test() {
		var start = "outgoing propagation on externaleffect{serviceomission}";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceredundant23, start);
		Assert.assertEquals(ft.getEvents().size(), 14);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		var sube1 = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube1 = (sube1.getSubEvents()).getFirst();
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube1.getSubEvents().size(), 2);
		Assert.assertEquals(subsube2.getSubEvents().size(), 2);
		Assert.assertTrue(((subsube1.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorSource));
		Assert.assertEquals(((NamedElement) (subsube1.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(((NamedElement) subsube1.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor1");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) (subsube1.getSubEvents()).getFirst().getRelatedErrorType())),
				"LateDelivery");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube1.getSubEvents().get(1).getRelatedErrorType())),
				"OutOfRange");
		Assert.assertTrue(((subsube2.getSubEvents()).getFirst().getRelatedEMV2Object() instanceof ErrorSource));
		Assert.assertEquals(((NamedElement) (subsube2.getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"sensor2");
		Assert.assertEquals(((NamedElement) subsube2.getSubEvents().get(1).getRelatedInstanceObject()).getName(),
				"sensor2");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) (subsube2.getSubEvents()).getFirst().getRelatedErrorType())),
				"LateDelivery");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube2.getSubEvents().get(1).getRelatedErrorType())),
				"OutOfRange");
	}

	@Test
	public void redundant2VoterFaultTreeTest() {
		var start = "outgoing propagation on valueout{ItemOmission}";
		var ft = CreateFTAModel.createFaultTree(FTATest.instancevoter, start);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube1 = (sube1.getSubEvents()).getFirst();
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertTrue((subsube1.getRelatedEMV2Object() instanceof ErrorPropagation));
		Assert.assertEquals(EMV2Util.getPrintName(((NamedElement) subsube1.getRelatedEMV2Object())), "valuein1");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube1.getRelatedErrorType())), "OutOfRange");
		Assert.assertTrue((subsube2.getRelatedEMV2Object() instanceof ErrorPropagation));
		Assert.assertEquals(EMV2Util.getPrintName(((NamedElement) subsube2.getRelatedEMV2Object())), "valuein2");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) subsube2.getRelatedErrorType())), "OutOfRange");
	}

	@Test
	public void redundant2VoterFaultTreeInconsistentValueTest() {
		var start = "outgoing propagation on valueout{InconsistentValue}";
		var ft = CreateFTAModel.createFaultTree(FTATest.instancevoter, start);
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube1.getRelatedEMV2Object()).getName(), "ComputeError");
	}

	@Test
	public void redundant2VoterFaultTreeFailStopTest() {
		var start = "state FailStop";
		var ft = CreateFTAModel.createFaultTree(FTATest.instancevoter, start);
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube1.getRelatedEMV2Object()).getName(), "Failure");
	}

	@Test
	public void redundant2VoterFaultTreeDegradedTest() {
		var start = "state Degraded";
		var ft = CreateFTAModel.createFaultTree(FTATest.instancevoter, start);
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube1.getRelatedEMV2Object()).getName(), "ComputeError");
	}

	@Test
	public void DualFGSFaultTreeCriticalTest() {
		var start = "state CriticalModeFailure";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceDualFGS, start);
		Assert.assertEquals(ft.getEvents().size(), 10);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube2.getSubEvents().size(), 2);
		Assert.assertEquals(subsube2.getSubEventLogic(), LogicOperation.OR);
		var sube31 = subsube2.getSubEvents().get(0);
		Assert.assertTrue((sube31.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube31.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) sube31.getRelatedInstanceObject()).getName(), "AP2");
		var sube32 = subsube2.getSubEvents().get(1);
		Assert.assertTrue((sube32.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube32.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) sube32.getRelatedInstanceObject()).getName(), "FG2");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "AC");
		var sube3 = ft.getRoot().getSubEvents().get(2);
		Assert.assertTrue((sube3.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) sube3.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) sube3.getRelatedInstanceObject()).getName(), "network");
	}

	@Test
	public void DualFGSFaultTraceCriticalTest() {
		var start = "state CriticalModeFailure";
		var ft = CreateFTAModel.createFaultTrace(FTATest.instanceDualFGS, start);
		Assert.assertEquals(ft.getEvents().size(), 17);
		var ev = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(ev.getSubEvents().size(), 3);
		Assert.assertEquals(ev.getSubEventLogic(), LogicOperation.OR);
		var sube1 = ev.getSubEvents().get(2);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube2.getSubEvents().size(), 2);
		Assert.assertEquals(subsube2.getSubEventLogic(), LogicOperation.OR);
		var sube31 = subsube2.getSubEvents().get(0);
		Assert.assertTrue((sube31.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube31.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube31.getRelatedInstanceObject()).getName(), "AP2");
		var sube32 = subsube2.getSubEvents().get(1);
		Assert.assertTrue((sube32.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube32.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube32.getRelatedInstanceObject()).getName(), "FG2");
		var sube2 = ev.getSubEvents().get(0);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "AC");
		var subev2 = sube2.getSubEvents().get(0);
		Assert.assertTrue((subev2.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) subev2.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) subev2.getRelatedInstanceObject()).getName(), "AC");
		var sube3 = ev.getSubEvents().get(1);
		Assert.assertTrue((sube3.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube3.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube3.getRelatedInstanceObject()).getName(), "network");
	}

	@Test
	public void DualFGSPartsFaultTreeCriticalTest() {
		var start = "state CriticalModeFailure";
		var ft = CreateFTAModel.createPartsFaultTree(FTATest.instanceDualFGS, start);
		Assert.assertEquals(ft.getEvents().size(), 11);
		var ev1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(ev1.getSubEvents().size(), 3);
		Assert.assertEquals(ev1.getSubEventLogic(), LogicOperation.OR);
		var sube1 = ev1.getSubEvents().get(2);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube2.getSubEvents().size(), 2);
		Assert.assertEquals(subsube2.getSubEventLogic(), LogicOperation.OR);
		var sube31 = subsube2.getSubEvents().get(0);
		Assert.assertTrue((sube31.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube31.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube31.getRelatedInstanceObject()).getName(), "AP2");
		var sube32 = subsube2.getSubEvents().get(1);
		Assert.assertTrue((sube32.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube32.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube32.getRelatedInstanceObject()).getName(), "FG2");
		var sube2 = ev1.getSubEvents().get(0);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "AC");
		var sube3 = ev1.getSubEvents().get(1);
		Assert.assertTrue((sube3.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube3.getRelatedEMV2Object()).getName(), "Failed");
		Assert.assertEquals(((NamedElement) sube3.getRelatedInstanceObject()).getName(), "network");
	}

	@Test
	public void DualFGSCutsetCriticalTest() {
		var start = "state CriticalModeFailure";
		var ft = CreateFTAModel.createMinimalCutSet(FTATest.instanceDualFGS, start);
		Assert.assertEquals(13, ft.getEvents().size());
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 6);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube1 = sube2.getSubEvents().get(0);
		Assert.assertTrue((subsube1.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) subsube1.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) subsube1.getRelatedInstanceObject()).getName(), "FG1");
		var subsube2 = sube2.getSubEvents().get(1);
		Assert.assertTrue((subsube2.getRelatedEMV2Object() instanceof ErrorEvent));
		Assert.assertEquals(((NamedElement) subsube2.getRelatedEMV2Object()).getName(), "Failure");
		Assert.assertEquals(((NamedElement) subsube2.getRelatedInstanceObject()).getName(), "AP2");
		var sube3 = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(sube3.getSubEvents().size(), 2);
		var sube4 = ft.getRoot().getSubEvents().get(3);
		Assert.assertEquals(sube4.getSubEvents().size(), 2);
		var sube5 = ft.getRoot().getSubEvents().get(4);
		Assert.assertEquals(sube5.getSubEvents().size(), 1);
		var sube6 = ft.getRoot().getSubEvents().get(5);
		Assert.assertEquals(sube6.getSubEvents().size(), 1);
	}

	@Test
	public void DualFGSFaultTreeNonCriticalTest() {
		var start = "state NonCriticalModeFailure";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceDualFGS, start);
		Assert.assertEquals(ft.getEvents().size(), 16);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(subsube2.getSubEvents().size(), 3);
		Assert.assertEquals(subsube2.getSubEventLogic(), LogicOperation.AND);
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "Operational");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "AC");
		var sube3 = ft.getRoot().getSubEvents().get(2);
		Assert.assertTrue((sube3.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube3.getRelatedEMV2Object()).getName(), "Operational");
		Assert.assertEquals(((NamedElement) sube3.getRelatedInstanceObject()).getName(), "network");
	}

	@Test
	public void filteredFlowTest() {
		var start = "outgoing propagation on outport{NoValue}";
		var ft = CreateFTAModel.createFaultTrace(FTATest.instanceFilteredFlow, start);
		Assert.assertEquals(ft.getEvents().size(), 9);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var subsube1 = sube1.getSubEvents().get(0);
		Assert.assertEquals(subsube1.getSubEvents().size(), 1);
		var subsubsube1 = subsube1.getSubEvents().get(0);
		Assert.assertEquals(subsubsube1.getSubEvents().size(), 1);
	}

	@Test
	public void allFlowFaultTreeTest() {
		var start = "outgoing propagation on outport{ValueProblem}";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceAllFlows, start);
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue(Objects.equals(sube1.getType(), EventType.EXTERNAL));
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorPropagation));
		Assert.assertEquals(EMV2Util.getPrintName(((NamedElement) sube1.getRelatedEMV2Object())), "inport");
	}

	@Test
	public void allFlowFaultTraceTest() {
		var start = "outgoing propagation on outport{ValueProblem}";
		var ft = CreateFTAModel.createFaultTrace(FTATest.instanceAllFlows, start);
		Assert.assertEquals(12, ft.getEvents().size());
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(sube1.getSubEvents().size(), 3);
		var sube11 = sube1.getSubEvents().get(0);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorPropagation));
		Assert.assertEquals(EMV2Util.getPrintName(((NamedElement) sube12.getRelatedEMV2Object())), "FromAP1Port");
		var sube13 = sube1.getSubEvents().get(2);
		Assert.assertTrue((sube13.getRelatedEMV2Object() instanceof ErrorPropagation));
		Assert.assertEquals(EMV2Util.getPrintName(((NamedElement) sube13.getRelatedEMV2Object())), "FromAP2Port");
	}

	@Test
	public void allOptimizeFaultTreeTest1() {
		var stateFailStop = "state FailStop";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube11 = sube1.getSubEvents().get(0);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube11.getRelatedInstanceObject()).getName(), "Sub2");
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub3");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest2() {
		var stateFailStop = "state Fail1";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube11 = sube1.getSubEvents().get(0);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube11.getRelatedInstanceObject()).getName(), "Sub2");
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub3");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest3() {
		var stateFailStop = "state Fail2";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube11 = sube1.getSubEvents().get(0);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube11.getRelatedInstanceObject()).getName(), "Sub2");
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub3");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest4() {
		var stateFailStop = "state Fail3";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 10);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube11 = sube1.getSubEvents().get(0);
		Assert.assertEquals(sube11.getSubEvents().size(), 3);
		Assert.assertEquals(sube11.getSubEventLogic(), LogicOperation.OR);
		var sube111 = sube11.getSubEvents().get(2);
		Assert.assertEquals(sube111.getSubEvents().size(), 2);
		Assert.assertEquals(sube111.getSubEventLogic(), LogicOperation.AND);
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub3");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest5() {
		var stateFailStop = "state Fail4";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue((sube1.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube1.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube1.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest6() {
		var stateFailStop = "state Fail5";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(4, ft.getEvents().size());
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.XOR);
		Assert.assertEquals(sube1.getSubEvents().size(), 2);
		var sube11 = sube1.getSubEvents().get(0);
		var sube12 = sube1.getSubEvents().get(1);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube11.getRelatedInstanceObject()).getName(), "Sub1");
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub6");
		var sube2 = ft.getRoot().getSubEvents().get(1);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allOptimizeFaultTraceTest7() {
		var stateFailStop = "state Fail6";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOptimize, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(sube1.getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(sube1.getSubEvents().size(), 3);
		var sube11 = sube1.getSubEvents().get(0);
		var sube12 = sube1.getSubEvents().get(1);
		var sube13 = sube1.getSubEvents().get(2);
		Assert.assertTrue((sube11.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube11.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube11.getRelatedInstanceObject()).getName(), "Sub2");
		Assert.assertTrue((sube12.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube12.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube12.getRelatedInstanceObject()).getName(), "Sub4");
		Assert.assertTrue((sube13.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube13.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube13.getRelatedInstanceObject()).getName(), "Sub6");
		var sube2 = ft.getRoot().getSubEvents().get(0);
		Assert.assertTrue((sube2.getRelatedEMV2Object() instanceof ErrorBehaviorState));
		Assert.assertEquals(((NamedElement) sube2.getRelatedEMV2Object()).getName(), "FailStop");
		Assert.assertEquals(((NamedElement) sube2.getRelatedInstanceObject()).getName(), "Sub1");
	}

	@Test
	public void allTransitionBranchFaultTreeTest() {
		var stateFailStop = "state FailStop";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceTransitionBranch, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		var asube1 = sube1.getSubEvents().get(0);
		var asube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 6.0e-8, 1.0e-12);
		Assert.assertEquals(sube1.getComputedProbability().doubleValue(), 9.0e-16, 1.0e-20);
		Assert.assertEquals(asube1.getScale().doubleValue(), 0.6, 0.001);
		Assert.assertEquals(asube2.getScale().doubleValue(), 0.6, 0.001);
	}

	@Test
	public void allTransitionBranchCutSetTest() {
		var stateFailStop = "state FailStop";
		var ft = CreateFTAModel.createMinimalCutSet(FTATest.instanceTransitionBranch, stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(0);
		var asube1 = sube1.getSubEvents().get(0);
		var asube2 = sube1.getSubEvents().get(1);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 6.0e-8, 1.0e-12);
		Assert.assertEquals(sube1.getComputedProbability().doubleValue(), 9.0e-16, 1.0e-20);
		Assert.assertEquals(asube1.getScale().doubleValue(), 0.6, 0.001);
		Assert.assertEquals(asube2.getScale().doubleValue(), 0.6, 0.001);
	}

	@Test
	public void OR1OFProbabilityFaultTreeTest() {
		var outProp = "outgoing propagation on o{BadData}";
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceOR1OFProbability, outProp);
		Assert.assertEquals(ft.getEvents().size(), 9);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 2);
		var sube1 = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 1.30285e-1, 1.0e-5);
		Assert.assertEquals(sube1.getComputedProbability().doubleValue(), 1.215e-1, 1.0e-5);
	}

	@Test
	public void PathProbabilityFaultTreeTest() {
		var outProp = "state FaultyState";
		var ft = CreateFTAModel.createFaultTree(FTATest.instancePathProbability, outProp);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 4);
		var sube3 = ft.getRoot().getSubEvents().get(2);
		var sube4 = ft.getRoot().getSubEvents().get(3);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 9.79e-7, 1.0e-10);
		Assert.assertEquals(sube3.getScale().doubleValue(), 0.7, 0.001);
		Assert.assertEquals(sube4.getScale().doubleValue(), 0.6, 0.001);
	}

	@Test
	public void issue1819Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1819,
				"outgoing propagation on effect{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"heaterfails");
		Assert.assertEquals(
				((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"heater");
	}

	@Test
	public void issue1882Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1882,
				"outgoing propagation on aceffect{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedEMV2Object()).getName(),
				"engineFailure");
		Assert.assertEquals(
				((NamedElement) (ft.getRoot().getSubEvents()).getFirst().getRelatedInstanceObject()).getName(),
				"engine1");
	}

	@Test
	public void issue1893Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1893,
				"outgoing propagation on location{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 11);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 8);
		var andnode = ft.getRoot().getSubEvents().get(1);
		Assert.assertEquals(andnode.getSubEventLogic(), LogicOperation.AND);
		Assert.assertEquals(andnode.getSubEvents().size(), 2);
	}

	@Test
	public void issue1913Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1913, "outgoing propagation on effect{Bad}");
		Assert.assertEquals(ft.getEvents().size(), 1);
	}

	@Test
	public void issue1915Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1915, "outgoing propagation on effect{Bad}");
		Assert.assertEquals(ft.getEvents().size(), 2);
		var faultsource = ft.getRoot().getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) faultsource.getRelatedEMV2Object()).getName(), "d");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) faultsource.getRelatedErrorType())), "ClFail");
	}

	@Test
	public void issue1899Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1899,
				"outgoing propagation on msg{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 5);
	}

	@Test
	public void issue1837Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1837, "state FailStop");
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 1.04e-1, 0.01);
		Assert.assertEquals(ft.getRoot().getSubEvents().get(1).getSubEventLogic(), LogicOperation.KORMORE);
	}

	@Test
	public void issue1837bisTest() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1837bis, "state FailStop");
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 0.0414, 0.01);
		Assert.assertEquals(ft.getRoot().getSubEvents().get(1).getSubEventLogic(), LogicOperation.KORMORE);
	}

	@Test
	public void issue2112Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue2112, "state FailStop");
		Assert.assertEquals(ft.getEvents().size(), 6);
		Assert.assertEquals(ft.getRoot().getSubEventLogic(), LogicOperation.OR);
		Assert.assertEquals(ft.getRoot().getComputedProbability().doubleValue(), 0.0414, 0.01);
		Assert.assertEquals(ft.getRoot().getSubEvents().get(1).getSubEventLogic(), LogicOperation.KORMORE);
	}

	@Test
	public void issue1962Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1962,
				"outgoing propagation on aceffect{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 7);
		var pilotand = ft.getRoot().getSubEvents().get(0);
		var errorevent = pilotand.getSubEvents().get(1);
		Assert.assertEquals(((NamedElement) errorevent.getRelatedInstanceObject()).getName(), "pilot");
		Assert.assertEquals(((NamedElement) errorevent.getRelatedEMV2Object()).getName(), "mistakes");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) errorevent.getRelatedErrorType())), "TimingError");
	}

	@Test
	public void issue1961Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1961,
				"outgoing propagation on aceffect{ServiceOmission}");
		Assert.assertEquals(ft.getEvents().size(), 8);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 3);
		var pilotand1 = ft.getRoot().getSubEvents().get(0);
		var pilotand2 = ft.getRoot().getSubEvents().get(1);
		var engine = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(pilotand1.getSubEventLogic(), LogicOperation.PRIORITY_AND);
		Assert.assertEquals(pilotand2.getSubEventLogic(), LogicOperation.PRIORITY_AND);
		Assert.assertEquals(((NamedElement) engine.getRelatedInstanceObject()).getName(), "engine1");
		Assert.assertEquals(((NamedElement) engine.getRelatedEMV2Object()).getName(), "engineFailure");
		Assert.assertEquals(EMV2Util.getName(((TypeToken) engine.getRelatedErrorType())), "ServiceOmission");
	}

	@Test
	public void issue1384Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue1384, FTATest.stateFailStop);
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 3);
		var tdd = ft.getRoot().getSubEvents().get(2);
		Assert.assertEquals(tdd.getSubEvents().size(), 3);
		var btcu = tdd.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) btcu.getRelatedEMV2Object()).getName(), "Failure");
		var ccus = tdd.getSubEvents().get(1);
		Assert.assertEquals(((NamedElement) ccus.getRelatedEMV2Object()).getName(), "Failure");
	}

	@Test
	public void issue2124Test() {
		var ft = CreateFTAModel.createFaultTrace(FTATest.instanceIssues21232425, "state undetected_failure");
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(), "iPCA_Safety_i_Instance");
		Assert.assertEquals(ev1.getSubEvents().size(), 1);
		var ev2 = ev1.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev2.getRelatedInstanceObject()).getName(), "error_detect");
	}

	@Test
	public void issue2123Test() {
		var ft = CreateFTAModel.createFaultTrace(FTATest.instanceIssues21232425, "state undetected_failure");
		Assert.assertEquals(ft.getEvents().size(), 3);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(), "iPCA_Safety_i_Instance");
		var ev2 = ev1.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev2.getRelatedInstanceObject()).getName(), "error_detect");
		var ev3 = ev2.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev3.getRelatedInstanceObject()).getName(), "error_detect");
		Assert.assertEquals(((NamedElement) ev3.getRelatedEMV2Object()).getName(), "post_not_detect_failure");
	}

	@Test
	public void issue2177Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue2177, "state LossOfData");
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(), "SubSys1_EMV2_Instance");
		var ev2 = ev1.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev2.getRelatedEMV2Object()).getName(), "Internal_Service_Error");
	}

	@Test
	public void issue2546UntypedTest() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue2546Untyped,
				"outgoing propagation on dout{ItemValueError}");
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(), "sys_i_Instance");
	}

	@Test
	public void issue2546TypedTest() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue2546Typed,
				"outgoing propagation on dout{NoValue}");
		Assert.assertEquals(ft.getEvents().size(), 2);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 1);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(), "sys_i_Instance");
		var ev2 = ev1.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev2.getRelatedEMV2Object()).getName(), "esrc");
	}

	public void issue2391Test() {
		var ft = CreateFTAModel.createFaultTree(FTATest.instanceIssue2391, "state FailStop");
		Assert.assertEquals(ft.getEvents().size(), 5);
		Assert.assertEquals(ft.getRoot().getSubEvents().size(), 4);
		var ev1 = ft.getRoot();
		Assert.assertEquals(((NamedElement) ev1.getRelatedInstanceObject()).getName(),
				"GPS_parts_SingleSensorTransient_Instance");
		var ev2 = ev1.getSubEvents().get(0);
		Assert.assertEquals(((NamedElement) ev2.getRelatedEMV2Object()).getName(), "FailStop");
		var ev3 = ev1.getSubEvents().get(1);
		Assert.assertEquals(((NamedElement) ev3.getRelatedInstanceObject()).getName(), "network");
		var ev4 = ev1.getSubEvents().get(2);
		Assert.assertEquals(((NamedElement) ev4.getRelatedInstanceObject()).getName(), "SatelliteSignalReceiver1");
		var ev5 = ev1.getSubEvents().get(3);
		Assert.assertEquals(((NamedElement) ev5.getRelatedInstanceObject()).getName(), "powersupply1");
	}
}
