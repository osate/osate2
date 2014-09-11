/**
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.tests;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider;
import org.osate.xtext.aadl2.tests.OsateTest;

@RunWith(XtextRunner2.class)
@InjectWith(Aadl2UiInjectorProvider.class)
@SuppressWarnings("all")
public class Aadl2JavaValidatorTest extends OsateTest {
  private final static String TEST_PROJECT_NAME = "Aadl2_Java_Validator_Test";
  
  @Before
  public void setUp() {
    this.createProject(Aadl2JavaValidatorTest.TEST_PROJECT_NAME, "packages");
    this.buildProject("Plugin_Resources", true);
    this.setResourceRoot((("platform:/resource/" + Aadl2JavaValidatorTest.TEST_PROJECT_NAME) + "/packages"));
  }
  
  @After
  public void cleanUp() {
    this.deleteProject(Aadl2JavaValidatorTest.TEST_PROJECT_NAME);
  }
  
  /**
   * Tests typeCheckAccessConnectionEnd, typeCheckFeatureConnectionEnd, typeCheckFeatureGroupConnectionEnd, typeCheckParameterConnectionEnd,
   * typeCheckPortConnectionEnd, and checkFlowFeatureType
   */
  @Test
  public void testConnectionAndFlowTypes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package legalTypeTest");
    _builder.newLine();
    _builder.append("public");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract container");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("da1: requires data access d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ba1: requires bus access;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("af1: feature;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fg1: feature group fgt1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep1: in event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep2: out event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp1: in data port a1.i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp2: in data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp1: in event data port a1.i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp2: out event data port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp3: in event data port d1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("flows");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource1: flow source da1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AbstractFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource2: flow source af1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource3: flow source fg1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource4: flow source ep2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource5: flow source dp1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.AbstractFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource6: flow source dp1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource7: flow source dp1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource8: flow source dp1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource9: flow source edp1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.AbstractFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource10: flow source edp1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource11: flow source edp1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource12: flow source edp1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource13: flow source fg1.da5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.AbstractFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource14: flow source fg1.af4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource15: flow source fg1.fg4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource16: flow source fg1.param4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource17: flow source fg1.ep8;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end container;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract implementation container.i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subcomponents");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("asub1: abstract a1.i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bsub1: bus;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dsub1: data d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Allow the error so that we can test the type");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--check validation for port connection ends");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--when the context is a DataSubcomponent.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dsub2: data a1.i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpgsub1: subprogram group;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpsub1: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("internal features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eds1: event data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("processor features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pp1: port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sp1: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("calls sequence1: {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("call1: subprogram subpcontainer.i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("connections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn1: bus access bsub1 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn2: data access dsub1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn3: subprogram group access subpgsub1 <-> asub1.subpga1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn4: subprogram access subpsub1 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn5: subprogram access processor.sp1 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn6: data access processor.pp1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn7: data access eds1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn8: data access af1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn9: data access fg1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn10: bus access ba1 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn11: data access da1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn12: data access ep1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn13: data access dp1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn14: data access edp1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn15: bus access dp1.bsub2 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn16: data access dp1.dsub4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn17: subprogram group access dp1.subpgsub2 <-> asub1.subpga1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn18: subprogram access dp1.subpsub3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn19: subprogram access dp1.sp3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn20: data access dp1.pp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn21: data access dp1.eds3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn22: data access dp1.af3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn23: data access dp1.fg3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn24: bus access dp1.ba2 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn25: data access dp1.da3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn26: data access dp1.ep5 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn27: data access dp1.dp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn28: data access dp1.edp6 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn29: bus access edp1.bsub2 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn30: data access edp1.dsub4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn31: subprogram group access edp1.subpgsub2 <-> asub1.subpga1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn32: subprogram access edp1.subpsub3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn33: subprogram access edp1.sp3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn34: data access edp1.pp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn35: data access edp1.eds3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn36: data access edp1.af3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn37: data access edp1.fg3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn38: bus access edp1.ba2 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn39: data access edp1.da3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn40: data access edp1.ep5 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn41: data access edp1.dp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn42: data access edp1.edp6 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn43: data access fg1.af4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn44: data access fg1.fg4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn45: data access fg1.param3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn46: bus access fg1.ba4 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn47: data access fg1.da5 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn48: data access fg1.ep7 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn49: data access fg1.dp6 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn50: data access fg1.edp7 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn51: bus access asub1.bsub2 <-> asub1.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn52: data access asub1.dsub4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn53: subprogram group access asub1.subpgsub2 <-> asub1.subpga1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn54: subprogram access asub1.subpsub3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn55: subprogram access asub1.sp3 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn56: data access asub1.pp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn57: data access asub1.eds3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn58: data access asub1.af3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn59: data access asub1.fg3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn60: data access subpsub1.param1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn61: bus access asub1.ba2 <-> asub1.ba3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn62: data access asub1.da3 <-> asub1.da4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn63: data access asub1.ep5 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn64: data access asub1.dp3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn65: data access asub1.edp6 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn66: data access call1.dsub3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn67: subprogram access call1.subpsub2 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn68: subprogram access call1.sp2 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn69: data access call1.pp2 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn70: data access call1.eds2 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn71: data access call1.af2 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn72: data access call1.fg2 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn73: data access call1.param1 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn74: subprogram access call1.subpa1 <-> asub1.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn75: data access call1.da2 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn76: data access call1.ep3 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn77: data access call1.edp4 <-> asub1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn1: feature bsub1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn2: feature dsub1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn3: feature subpgsub1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn4: feature subpsub1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn5: feature sp1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn6: feature pp1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn7: feature eds1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn8: feature af1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn9: feature fg1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn10: feature ba1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn11: feature da1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn12: feature ep1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn13: feature dp1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn14: feature edp1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn15: feature dp1.bsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn16: feature dp1.dsub4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn17: feature dp1.subpgsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn18: feature dp1.subpsub3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn19: feature dp1.sp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn20: feature dp1.pp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn21: feature dp1.eds3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn22: feature dp1.af3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn23: feature dp1.fg3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn24: feature dp1.ba2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn25: feature dp1.da3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn26: feature dp1.ep5 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn27: feature dp1.dp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn28: feature dp1.edp6 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn29: feature edp1.bsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn30: feature edp1.dsub4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn31: feature edp1.subpgsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn32: feature edp1.subpsub3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn33: feature edp1.sp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn34: feature edp1.pp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn35: feature edp1.eds3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn36: feature edp1.af3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn37: feature edp1.fg3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn38: feature edp1.ba2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn39: feature edp1.da3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn40: feature edp1.ep5 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn41: feature edp1.dp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn42: feature edp1.edp6 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn43: feature fg1.af4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn44: feature fg1.fg4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn45: feature fg1.param3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn46: feature fg1.ba4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn47: feature fg1.da5 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn48: feature fg1.ep7 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn49: feature fg1.dp6 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn50: feature fg1.edp7 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn51: feature asub1.bsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn52: feature asub1.dsub4 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn53: feature asub1.subpgsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn54: feature asub1.subpsub3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn55: feature asub1.sp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn56: feature asub1.pp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn57: feature asub1.eds3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn58: feature asub1.af3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn59: feature asub1.fg3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn60: feature subpsub1.param1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn61: feature asub1.ba2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn62: feature asub1.da3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn63: feature asub1.ep5 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn64: feature asub1.dp3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn65: feature asub1.edp6 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn66: feature call1.dsub3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn67: feature call1.subpsub2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn68: feature call1.sp2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn69: feature call1.pp2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn70: feature call1.eds2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn71: feature call1.af2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn72: feature call1.fg2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn73: feature call1.param1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn74: feature call1.subpa1 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn75: feature call1.da2 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn76: feature call1.ep3 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn77: feature call1.edp5 <-> asub1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn1: feature group bsub1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn2: feature group dsub1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn3: feature group subpgsub1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn4: feature group subpsub1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn5: feature group sp1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn6: feature group pp1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn7: feature group eds1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn8: feature group af1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn9: feature group fg1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn10: feature group ba1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn11: feature group da1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn12: feature group ep1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn13: feature group dp1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn14: feature group edp1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn15: feature group dp1.bsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn16: feature group dp1.dsub4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn17: feature group dp1.subpgsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn18: feature group dp1.subpsub3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn19: feature group dp1.sp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn20: feature group dp1.pp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn21: feature group dp1.eds3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn22: feature group dp1.af3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn23: feature group dp1.fg3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn24: feature group dp1.ba2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn25: feature group dp1.da3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn26: feature group dp1.ep5 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn27: feature group dp1.dp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn28: feature group dp1.edp6 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn29: feature group edp1.bsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn30: feature group edp1.dsub4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn31: feature group edp1.subpgsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn32: feature group edp1.subpsub3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn33: feature group edp1.sp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn34: feature group edp1.pp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn35: feature group edp1.eds3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn36: feature group edp1.af3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn37: feature group edp1.fg3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn38: feature group edp1.ba2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn39: feature group edp1.da3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn40: feature group edp1.ep5 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn41: feature group edp1.dp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn42: feature group edp1.edp6 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn43: feature group fg1.af4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn44: feature group fg1.fg4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn45: feature group fg1.param3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn46: feature group fg1.ba4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn47: feature group fg1.da5 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn48: feature group fg1.ep7 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn49: feature group fg1.dp6 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn50: feature group fg1.edp7 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn51: feature group asub1.bsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn52: feature group asub1.dsub4 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn53: feature group asub1.subpgsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn54: feature group asub1.subpsub3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn55: feature group asub1.sp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn56: feature group asub1.pp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn57: feature group asub1.eds3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn58: feature group asub1.af3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn59: feature group asub1.fg3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn60: feature group subpsub1.param1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn61: feature group asub1.ba2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn62: feature group asub1.da3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn63: feature group asub1.ep5 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn64: feature group asub1.dp3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn65: feature group asub1.edp6 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn66: feature group call1.dsub3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn67: feature group call1.subpsub2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn68: feature group call1.sp2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn69: feature group call1.pp2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn70: feature group call1.eds2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn71: feature group call1.af2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn72: feature group call1.fg2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn73: feature group call1.param1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn74: feature group call1.subpa1 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn75: feature group call1.da2 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn76: feature group call1.ep3 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn77: feature group call1.edp5 <-> asub1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn1: parameter bsub1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn2: parameter dsub1 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn3: parameter subpgsub1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn4: parameter subpsub1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn5: parameter sp1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn6: parameter pp1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn7: parameter eds1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn8: parameter af1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn9: parameter fg1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn10: parameter ba1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn11: parameter da1 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn12: parameter ep1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn13: parameter dp1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn14: parameter edp1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn15: parameter dp1.bsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn16: parameter dp1.dsub4 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn17: parameter dp1.subpgsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn18: parameter dp1.subpsub3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn19: parameter dp1.sp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn20: parameter dp1.pp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn21: parameter dp1.eds3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn22: parameter dp1.af3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn23: parameter dp1.fg3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn24: parameter dp1.ba2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn25: parameter dp1.da3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn26: parameter dp1.ep5 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn27: parameter dp1.dp3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn28: parameter dp1.edp6 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn29: parameter edp1.bsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn30: parameter edp1.dsub4 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn31: parameter edp1.subpgsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn32: parameter edp1.subpsub3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn33: parameter edp1.sp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn34: parameter edp1.pp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn35: parameter edp1.eds3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn36: parameter edp1.af3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn37: parameter edp1.fg3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn38: parameter edp1.ba2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn39: parameter edp1.da3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn40: parameter edp1.ep5 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn41: parameter edp1.dp3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn42: parameter edp1.edp6 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn43: parameter fg1.af4 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn44: parameter fg1.fg4 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn45: parameter fg1.param3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn46: parameter fg1.ba4 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn47: parameter fg1.da5 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn48: parameter fg1.ep7 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn49: parameter fg1.dp6 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn50: parameter fg1.edp7 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn51: parameter asub1.bsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn52: parameter asub1.dsub4 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn53: parameter asub1.subpgsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn54: parameter asub1.subpsub3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn55: parameter asub1.sp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn56: parameter asub1.pp3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn57: parameter asub1.eds3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn58: parameter asub1.af3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn59: parameter asub1.fg3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn60: parameter subpsub1.param1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn61: parameter asub1.ba2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn62: parameter asub1.da3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn63: parameter asub1.ep5 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn64: parameter asub1.dp3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn65: parameter asub1.edp6 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn66: parameter call1.dsub3 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn67: parameter call1.subpsub2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn68: parameter call1.sp2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn69: parameter call1.pp2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn70: parameter call1.eds2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn71: parameter call1.af2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn72: parameter call1.fg2 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn73: parameter call1.param1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn74: parameter call1.subpa1 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn75: parameter call1.da2 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn76: parameter call1.ep3 -> call1.param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn77: parameter call1.edp4 -> call1.param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn1: port bsub1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn2: port dsub1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn3: port subpgsub1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn4: port subpsub1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn5: port sp1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn6: port processor.pp1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn7: port self.eds1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn8: port af1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn9: port fg1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn10: port ba1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn11: port da1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn12: port ep1 -> asub1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn13: port dp2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn14: port edp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn15: port dp1.bsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn16: port dp1.dsub4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn17: port dp1.subpgsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn18: port dp1.subpsub3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn19: port dp1.sp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn20: port dp1.pp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn21: port dp1.eds3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn22: port dp1.af3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn23: port dp1.fg3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn24: port dp1.ba2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn25: port dp1.da3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn26: port dp1.ep5 -> asub1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn27: port dp1.dp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn28: port dp1.edp6 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn29: port edp1.bsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn30: port edp1.dsub4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn31: port edp1.subpgsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn32: port edp1.subpsub3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn33: port edp1.sp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn34: port edp1.pp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn35: port edp1.eds3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn36: port edp1.af3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn37: port edp1.fg3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn38: port edp1.ba2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn39: port edp1.da3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn40: port edp1.ep5 -> asub1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn41: port edp1.dp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--EventDataPort.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn42: port edp1.edp6 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn43: port fg1.af4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn44: port fg1.fg4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn45: port fg1.param3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn46: port fg1.ba4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn47: port fg1.da5 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn48: port fg1.ep7 -> asub1.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn49: port fg1.dp6 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroup.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn50: port fg1.edp7 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn51: port asub1.bsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn52: port asub1.dsub4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn53: port asub1.subpgsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn54: port asub1.subpsub3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn55: port asub1.sp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn56: port asub1.pp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn57: port asub1.eds3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn58: port asub1.af3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn59: port asub1.fg3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn60: port subpsub1.param1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn61: port asub1.ba2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn62: port asub1.da3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn63: port asub1.ep5 -> asub1.ep6;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn64: port asub1.dp3 -> asub1.dp4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Subcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn65: port asub1.edp6 -> asub1.dp4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn66: port dsub2.bsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn67: port dsub2.dsub4 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn68: port dsub2.subpgsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn69: port dsub2.subpsub3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn70: port dsub2.sp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn71: port dsub2.pp3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn72: port dsub2.eds3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn73: port dsub2.af3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn74: port dsub2.fg3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn75: port dsub2.ba2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn76: port dsub2.da3 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn77: port dsub2.ep5 -> asub1.ep6;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn78: port dsub2.dp3 -> asub1.dp4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--DataSubcomponent.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn79: port dsub2.edp6 -> asub1.dp4;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn80: port call1.dsub3 -> asub1.dp5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn81: port call1.subpsub2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn82: port call1.sp2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn83: port call1.pp2 -> asub1.dp5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn84: port call1.eds2 -> asub1.dp5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn85: port call1.af2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn86: port call1.fg2 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn87: port call1.param1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn88: port call1.subpa1 -> asub1.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn89: port call1.da2 -> asub1.dp5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn90: port call1.ep4 -> ep2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--SubprogramCall.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn91: port call1.edp5 -> edp2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end container.i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subprogram subpcontainer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("param1: in parameter a1.i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("param2: in parameter d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("param5: out parameter;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("af2: feature;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fg2: feature group;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpa1: requires subprogram access subpcontainer;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("da2: requires data access d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep3: in event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep4: out event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp4: in event data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp5: out event data port;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("flows");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource18: flow source param5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource19: flow source param1.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.AbstractFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource20: flow source param1.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource21: flow source param1.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fsource22: flow source param1.ep5;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subprogram implementation subpcontainer.i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subcomponents");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("asub2: abstract a1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dsub3: data d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpsub2: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("internal features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eds2: event data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("processor features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sp2: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pp2: port;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("connections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--AccessConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn78: data access param1 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn79: bus access param1.bsub2 <-> asub2.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn80: data access param1.dsub4 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn81: subprogram group access param1.subpgsub2 <-> asub2.subpga1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn82: subprogram access param1.subpsub3 <-> asub2.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn83: subprogram access param1.sp3 <-> asub2.subpa2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn84: data access param1.pp3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn85: data access param1.eds3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn86: data access param1.af3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn87: data access param1.fg3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn88: bus access param1.ba2 <-> asub2.ba2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn89: data access param1.da3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn90: data access param1.ep5 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn91: data access param1.dp3 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aconn92: data access param1.edp6 <-> asub2.da3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn78: feature param1 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn79: feature param1.bsub2 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn80: feature param1.dsub4 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn81: feature param1.subpgsub2 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn82: feature param1.subpsub3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn83: feature param1.sp3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn84: feature param1.pp3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn85: feature param1.eds3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn86: feature param1.af3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn87: feature param1.fg3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn88: feature param1.ba2 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn89: feature param1.da3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn90: feature param1.ep5 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn91: feature param1.dp3 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fconn92: feature param1.edp6 <-> asub2.af3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--FeatureGroupConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn78: feature group param1 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn79: feature group param1.bsub2 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn80: feature group param1.dsub4 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn81: feature group param1.subpgsub2 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn82: feature group param1.subpsub3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn83: feature group param1.sp3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn84: feature group param1.pp3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn85: feature group param1.eds3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn86: feature group param1.af3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn87: feature group param1.fg3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn88: feature group param1.ba2 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn89: feature group param1.da3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn90: feature group param1.ep5 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn91: feature group param1.dp3 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fgconn92: feature group param1.edp6 <-> asub2.fg3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--ParameterConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn78: parameter param1 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn79: parameter param1.bsub2 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn80: parameter param1.dsub4 -> param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn81: parameter param1.subpgsub2 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn82: parameter param1.subpsub3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn83: parameter param1.sp3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn84: parameter param1.pp3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn85: parameter param1.eds3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn86: parameter param1.af3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn87: parameter param1.fg3 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn88: parameter param1.ba2 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn89: parameter param1.da3 -> param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn90: parameter param1.ep5 -> param1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn91: parameter param1.dp3 -> param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paramconn92: parameter param1.edp6 -> param2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--PortConnections");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn92: port param1 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.BusSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn93: port param1.bsub2 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn94: port param1.dsub4 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramGroupSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn95: port param1.subpgsub2 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramSubcomponent");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn96: port param1.subpsub3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.SubprogramProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn97: port param1.sp3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.PortProxy");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn98: port param1.pp3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.InternalFeature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn99: port param1.eds3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Feature");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn100: port param1.af3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.FeatureGroup");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn101: port param1.fg3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Access");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn102: port param1.ba2 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataAccess");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn103: port param1.da3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.Port");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn104: port param1.ep5 -> asub2.ep5;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.DataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn105: port param1.dp3 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--Parameter.EventDataPort");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("portconn106: port param1.edp6 -> asub2.dp3;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end subpcontainer.i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract a1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("da3: requires data access d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("da4: provides data access d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ba2: requires bus access;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ba3: provides bus access;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpga1: requires subprogram group access;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpa2: requires subprogram access subpcontainer;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("af3: feature;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fg3: feature group;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep5: in event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep6: out event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp3: in data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp4: out data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp5: in out data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp6: in event data port d1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end a1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract implementation a1.i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subcomponents");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("asub3: abstract;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bsub2: bus;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dsub4: data d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpgsub2: subprogram group;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("subpsub3: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("internal features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eds3: event data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("processor features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pp3: port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sp3: subprogram subpcontainer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end a1.i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("feature group fgt1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("features");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("af4: feature;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fg4: feature group;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ba4: requires bus access;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("da5: requires data access d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep7: in event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ep8: out event port;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dp6: in data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edp7: in event data port d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("param3: in parameter d1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("param4: out parameter;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end fgt1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("data d1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("end d1;");
    _builder.newLine();
    _builder.append("end legalTypeTest;");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("legalTypeTest.aadl", _builder.toString());
    this.createFiles(_mappedTo);
    this.suppressSerialization();
    final FluentIssueCollection testFileResult = this.testFile("legalTypeTest.aadl");
    Resource _resource = testFileResult.getResource();
    ArrayList<Issue> _newArrayList = CollectionLiterals.<Issue>newArrayList();
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
    final FluentIssueCollection issueCollection = new FluentIssueCollection(_resource, _newArrayList, _newArrayList_1);
    Resource _resource_1 = testFileResult.getResource();
    EList<EObject> _contents = _resource_1.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Procedure1<AadlPackage> _function = new Procedure1<AadlPackage>() {
      public void apply(final AadlPackage it) {
        String _name = it.getName();
        Assert.assertEquals("legalTypeTest", _name);
        PublicPackageSection _publicSection = it.getPublicSection();
        EList<Classifier> _ownedClassifiers = _publicSection.getOwnedClassifiers();
        Classifier _get = _ownedClassifiers.get(0);
        final Procedure1<AbstractType> _function = new Procedure1<AbstractType>() {
          public void apply(final AbstractType it) {
            String _name = it.getName();
            Assert.assertEquals("container", _name);
            EList<FlowSpecification> _ownedFlowSpecifications = it.getOwnedFlowSpecifications();
            FlowSpecification _get = _ownedFlowSpecifications.get(4);
            final Procedure1<FlowSpecification> _function = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource5", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get, _function);
            EList<FlowSpecification> _ownedFlowSpecifications_1 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_1 = _ownedFlowSpecifications_1.get(5);
            final Procedure1<FlowSpecification> _function_1 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource6", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_1, _function_1);
            EList<FlowSpecification> _ownedFlowSpecifications_2 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_2 = _ownedFlowSpecifications_2.get(6);
            final Procedure1<FlowSpecification> _function_2 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource7", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_2, _function_2);
            EList<FlowSpecification> _ownedFlowSpecifications_3 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_3 = _ownedFlowSpecifications_3.get(7);
            final Procedure1<FlowSpecification> _function_3 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource8", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_3, _function_3);
            EList<FlowSpecification> _ownedFlowSpecifications_4 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_4 = _ownedFlowSpecifications_4.get(8);
            final Procedure1<FlowSpecification> _function_4 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource9", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in an \'event data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_4, _function_4);
            EList<FlowSpecification> _ownedFlowSpecifications_5 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_5 = _ownedFlowSpecifications_5.get(9);
            final Procedure1<FlowSpecification> _function_5 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource10", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in an \'event data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_5, _function_5);
            EList<FlowSpecification> _ownedFlowSpecifications_6 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_6 = _ownedFlowSpecifications_6.get(10);
            final Procedure1<FlowSpecification> _function_6 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource11", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in an \'event data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_6, _function_6);
            EList<FlowSpecification> _ownedFlowSpecifications_7 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_7 = _ownedFlowSpecifications_7.get(11);
            final Procedure1<FlowSpecification> _function_7 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource12", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in an \'event data port\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_7, _function_7);
          }
        };
        ObjectExtensions.<AbstractType>operator_doubleArrow(
          ((AbstractType) _get), _function);
        PublicPackageSection _publicSection_1 = it.getPublicSection();
        EList<Classifier> _ownedClassifiers_1 = _publicSection_1.getOwnedClassifiers();
        Classifier _get_1 = _ownedClassifiers_1.get(1);
        final Procedure1<AbstractImplementation> _function_1 = new Procedure1<AbstractImplementation>() {
          public void apply(final AbstractImplementation it) {
            String _name = it.getName();
            Assert.assertEquals("container.i", _name);
            EList<DataSubcomponent> _ownedDataSubcomponents = it.getOwnedDataSubcomponents();
            DataSubcomponent _get = _ownedDataSubcomponents.get(1);
            final Procedure1<DataSubcomponent> _function = new Procedure1<DataSubcomponent>() {
              public void apply(final DataSubcomponent it) {
                String _name = it.getName();
                Assert.assertEquals("dsub2", _name);
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(it, _issues, issueCollection, 
                  "A data subcomponent cannot refer to an abstract implementation that contains a bus subcomponent.", 
                  "A data subcomponent cannot refer to an abstract implementation that contains a subprogram group subcomponent.", 
                  "A data subcomponent cannot refer to an abstract type that contains a provides data access.", 
                  "A data subcomponent cannot refer to an abstract type that contains a requires data access.", 
                  "A data subcomponent cannot refer to an abstract type that contains an in out data port.", 
                  "A data subcomponent cannot refer to an abstract type that contains an in event port.", 
                  "A data subcomponent cannot refer to an abstract type that contains a provides bus access.", 
                  "A data subcomponent cannot refer to an abstract type that contains an in event data port.", 
                  "A data subcomponent cannot refer to an abstract type that contains an in data port.", 
                  "A data subcomponent cannot refer to an abstract type that contains an out data port.", 
                  "A data subcomponent cannot refer to an abstract type that contains an out event port.", 
                  "A data subcomponent cannot refer to an abstract type that contains a requires bus access.");
              }
            };
            ObjectExtensions.<DataSubcomponent>operator_doubleArrow(_get, _function);
            EList<AccessConnection> _ownedAccessConnections = it.getOwnedAccessConnections();
            AccessConnection _get_1 = _ownedAccessConnections.get(5);
            final Procedure1<AccessConnection> _function_1 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn6", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_1, _function_1);
            EList<AccessConnection> _ownedAccessConnections_1 = it.getOwnedAccessConnections();
            AccessConnection _get_2 = _ownedAccessConnections_1.get(6);
            final Procedure1<AccessConnection> _function_2 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn7", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_2, _function_2);
            EList<AccessConnection> _ownedAccessConnections_2 = it.getOwnedAccessConnections();
            AccessConnection _get_3 = _ownedAccessConnections_2.get(7);
            final Procedure1<AccessConnection> _function_3 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn8", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_3, _function_3);
            EList<AccessConnection> _ownedAccessConnections_3 = it.getOwnedAccessConnections();
            AccessConnection _get_4 = _ownedAccessConnections_3.get(8);
            final Procedure1<AccessConnection> _function_4 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn9", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_4, _function_4);
            EList<AccessConnection> _ownedAccessConnections_4 = it.getOwnedAccessConnections();
            AccessConnection _get_5 = _ownedAccessConnections_4.get(11);
            final Procedure1<AccessConnection> _function_5 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn12", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_5, _function_5);
            EList<AccessConnection> _ownedAccessConnections_5 = it.getOwnedAccessConnections();
            AccessConnection _get_6 = _ownedAccessConnections_5.get(12);
            final Procedure1<AccessConnection> _function_6 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn13", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_6, _function_6);
            EList<AccessConnection> _ownedAccessConnections_6 = it.getOwnedAccessConnections();
            AccessConnection _get_7 = _ownedAccessConnections_6.get(13);
            final Procedure1<AccessConnection> _function_7 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn14", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_7, _function_7);
            EList<AccessConnection> _ownedAccessConnections_7 = it.getOwnedAccessConnections();
            AccessConnection _get_8 = _ownedAccessConnections_7.get(14);
            final Procedure1<AccessConnection> _function_8 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn15", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_8, _function_8);
            EList<AccessConnection> _ownedAccessConnections_8 = it.getOwnedAccessConnections();
            AccessConnection _get_9 = _ownedAccessConnections_8.get(15);
            final Procedure1<AccessConnection> _function_9 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn16", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_9, _function_9);
            EList<AccessConnection> _ownedAccessConnections_9 = it.getOwnedAccessConnections();
            AccessConnection _get_10 = _ownedAccessConnections_9.get(16);
            final Procedure1<AccessConnection> _function_10 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn17", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_10, _function_10);
            EList<AccessConnection> _ownedAccessConnections_10 = it.getOwnedAccessConnections();
            AccessConnection _get_11 = _ownedAccessConnections_10.get(17);
            final Procedure1<AccessConnection> _function_11 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn18", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_11, _function_11);
            EList<AccessConnection> _ownedAccessConnections_11 = it.getOwnedAccessConnections();
            AccessConnection _get_12 = _ownedAccessConnections_11.get(18);
            final Procedure1<AccessConnection> _function_12 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn19", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_12, _function_12);
            EList<AccessConnection> _ownedAccessConnections_12 = it.getOwnedAccessConnections();
            AccessConnection _get_13 = _ownedAccessConnections_12.get(19);
            final Procedure1<AccessConnection> _function_13 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn20", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_13, _function_13);
            EList<AccessConnection> _ownedAccessConnections_13 = it.getOwnedAccessConnections();
            AccessConnection _get_14 = _ownedAccessConnections_13.get(20);
            final Procedure1<AccessConnection> _function_14 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn21", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_14, _function_14);
            EList<AccessConnection> _ownedAccessConnections_14 = it.getOwnedAccessConnections();
            AccessConnection _get_15 = _ownedAccessConnections_14.get(21);
            final Procedure1<AccessConnection> _function_15 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn22", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_15, _function_15);
            EList<AccessConnection> _ownedAccessConnections_15 = it.getOwnedAccessConnections();
            AccessConnection _get_16 = _ownedAccessConnections_15.get(22);
            final Procedure1<AccessConnection> _function_16 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn23", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_16, _function_16);
            EList<AccessConnection> _ownedAccessConnections_16 = it.getOwnedAccessConnections();
            AccessConnection _get_17 = _ownedAccessConnections_16.get(23);
            final Procedure1<AccessConnection> _function_17 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn24", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_17, _function_17);
            EList<AccessConnection> _ownedAccessConnections_17 = it.getOwnedAccessConnections();
            AccessConnection _get_18 = _ownedAccessConnections_17.get(24);
            final Procedure1<AccessConnection> _function_18 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn25", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_18, _function_18);
            EList<AccessConnection> _ownedAccessConnections_18 = it.getOwnedAccessConnections();
            AccessConnection _get_19 = _ownedAccessConnections_18.get(25);
            final Procedure1<AccessConnection> _function_19 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn26", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_19, _function_19);
            EList<AccessConnection> _ownedAccessConnections_19 = it.getOwnedAccessConnections();
            AccessConnection _get_20 = _ownedAccessConnections_19.get(26);
            final Procedure1<AccessConnection> _function_20 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn27", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_20, _function_20);
            EList<AccessConnection> _ownedAccessConnections_20 = it.getOwnedAccessConnections();
            AccessConnection _get_21 = _ownedAccessConnections_20.get(27);
            final Procedure1<AccessConnection> _function_21 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn28", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_21, _function_21);
            EList<AccessConnection> _ownedAccessConnections_21 = it.getOwnedAccessConnections();
            AccessConnection _get_22 = _ownedAccessConnections_21.get(28);
            final Procedure1<AccessConnection> _function_22 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn29", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_22, _function_22);
            EList<AccessConnection> _ownedAccessConnections_22 = it.getOwnedAccessConnections();
            AccessConnection _get_23 = _ownedAccessConnections_22.get(29);
            final Procedure1<AccessConnection> _function_23 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn30", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_23, _function_23);
            EList<AccessConnection> _ownedAccessConnections_23 = it.getOwnedAccessConnections();
            AccessConnection _get_24 = _ownedAccessConnections_23.get(30);
            final Procedure1<AccessConnection> _function_24 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn31", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_24, _function_24);
            EList<AccessConnection> _ownedAccessConnections_24 = it.getOwnedAccessConnections();
            AccessConnection _get_25 = _ownedAccessConnections_24.get(31);
            final Procedure1<AccessConnection> _function_25 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn32", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_25, _function_25);
            EList<AccessConnection> _ownedAccessConnections_25 = it.getOwnedAccessConnections();
            AccessConnection _get_26 = _ownedAccessConnections_25.get(32);
            final Procedure1<AccessConnection> _function_26 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn33", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_26, _function_26);
            EList<AccessConnection> _ownedAccessConnections_26 = it.getOwnedAccessConnections();
            AccessConnection _get_27 = _ownedAccessConnections_26.get(33);
            final Procedure1<AccessConnection> _function_27 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn34", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_27, _function_27);
            EList<AccessConnection> _ownedAccessConnections_27 = it.getOwnedAccessConnections();
            AccessConnection _get_28 = _ownedAccessConnections_27.get(34);
            final Procedure1<AccessConnection> _function_28 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn35", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_28, _function_28);
            EList<AccessConnection> _ownedAccessConnections_28 = it.getOwnedAccessConnections();
            AccessConnection _get_29 = _ownedAccessConnections_28.get(35);
            final Procedure1<AccessConnection> _function_29 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn36", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_29, _function_29);
            EList<AccessConnection> _ownedAccessConnections_29 = it.getOwnedAccessConnections();
            AccessConnection _get_30 = _ownedAccessConnections_29.get(36);
            final Procedure1<AccessConnection> _function_30 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn37", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_30, _function_30);
            EList<AccessConnection> _ownedAccessConnections_30 = it.getOwnedAccessConnections();
            AccessConnection _get_31 = _ownedAccessConnections_30.get(37);
            final Procedure1<AccessConnection> _function_31 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn38", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_31, _function_31);
            EList<AccessConnection> _ownedAccessConnections_31 = it.getOwnedAccessConnections();
            AccessConnection _get_32 = _ownedAccessConnections_31.get(38);
            final Procedure1<AccessConnection> _function_32 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn39", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_32, _function_32);
            EList<AccessConnection> _ownedAccessConnections_32 = it.getOwnedAccessConnections();
            AccessConnection _get_33 = _ownedAccessConnections_32.get(39);
            final Procedure1<AccessConnection> _function_33 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn40", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_33, _function_33);
            EList<AccessConnection> _ownedAccessConnections_33 = it.getOwnedAccessConnections();
            AccessConnection _get_34 = _ownedAccessConnections_33.get(40);
            final Procedure1<AccessConnection> _function_34 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn41", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_34, _function_34);
            EList<AccessConnection> _ownedAccessConnections_34 = it.getOwnedAccessConnections();
            AccessConnection _get_35 = _ownedAccessConnections_34.get(41);
            final Procedure1<AccessConnection> _function_35 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn42", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_35, _function_35);
            EList<AccessConnection> _ownedAccessConnections_35 = it.getOwnedAccessConnections();
            AccessConnection _get_36 = _ownedAccessConnections_35.get(42);
            final Procedure1<AccessConnection> _function_36 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn43", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_36, _function_36);
            EList<AccessConnection> _ownedAccessConnections_36 = it.getOwnedAccessConnections();
            AccessConnection _get_37 = _ownedAccessConnections_36.get(43);
            final Procedure1<AccessConnection> _function_37 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn44", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_37, _function_37);
            EList<AccessConnection> _ownedAccessConnections_37 = it.getOwnedAccessConnections();
            AccessConnection _get_38 = _ownedAccessConnections_37.get(44);
            final Procedure1<AccessConnection> _function_38 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn45", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_38, _function_38);
            EList<AccessConnection> _ownedAccessConnections_38 = it.getOwnedAccessConnections();
            AccessConnection _get_39 = _ownedAccessConnections_38.get(47);
            final Procedure1<AccessConnection> _function_39 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn48", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_39, _function_39);
            EList<AccessConnection> _ownedAccessConnections_39 = it.getOwnedAccessConnections();
            AccessConnection _get_40 = _ownedAccessConnections_39.get(48);
            final Procedure1<AccessConnection> _function_40 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn49", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_40, _function_40);
            EList<AccessConnection> _ownedAccessConnections_40 = it.getOwnedAccessConnections();
            AccessConnection _get_41 = _ownedAccessConnections_40.get(49);
            final Procedure1<AccessConnection> _function_41 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn50", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'feature group\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_41, _function_41);
            EList<AccessConnection> _ownedAccessConnections_41 = it.getOwnedAccessConnections();
            AccessConnection _get_42 = _ownedAccessConnections_41.get(50);
            final Procedure1<AccessConnection> _function_42 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn51", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_42, _function_42);
            EList<AccessConnection> _ownedAccessConnections_42 = it.getOwnedAccessConnections();
            AccessConnection _get_43 = _ownedAccessConnections_42.get(51);
            final Procedure1<AccessConnection> _function_43 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn52", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_43, _function_43);
            EList<AccessConnection> _ownedAccessConnections_43 = it.getOwnedAccessConnections();
            AccessConnection _get_44 = _ownedAccessConnections_43.get(52);
            final Procedure1<AccessConnection> _function_44 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn53", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_44, _function_44);
            EList<AccessConnection> _ownedAccessConnections_44 = it.getOwnedAccessConnections();
            AccessConnection _get_45 = _ownedAccessConnections_44.get(53);
            final Procedure1<AccessConnection> _function_45 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn54", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_45, _function_45);
            EList<AccessConnection> _ownedAccessConnections_45 = it.getOwnedAccessConnections();
            AccessConnection _get_46 = _ownedAccessConnections_45.get(54);
            final Procedure1<AccessConnection> _function_46 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn55", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_46, _function_46);
            EList<AccessConnection> _ownedAccessConnections_46 = it.getOwnedAccessConnections();
            AccessConnection _get_47 = _ownedAccessConnections_46.get(55);
            final Procedure1<AccessConnection> _function_47 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn56", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_47, _function_47);
            EList<AccessConnection> _ownedAccessConnections_47 = it.getOwnedAccessConnections();
            AccessConnection _get_48 = _ownedAccessConnections_47.get(56);
            final Procedure1<AccessConnection> _function_48 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn57", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_48, _function_48);
            EList<AccessConnection> _ownedAccessConnections_48 = it.getOwnedAccessConnections();
            AccessConnection _get_49 = _ownedAccessConnections_48.get(57);
            final Procedure1<AccessConnection> _function_49 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn58", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_49, _function_49);
            EList<AccessConnection> _ownedAccessConnections_49 = it.getOwnedAccessConnections();
            AccessConnection _get_50 = _ownedAccessConnections_49.get(58);
            final Procedure1<AccessConnection> _function_50 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn59", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_50, _function_50);
            EList<AccessConnection> _ownedAccessConnections_50 = it.getOwnedAccessConnections();
            AccessConnection _get_51 = _ownedAccessConnections_50.get(59);
            final Procedure1<AccessConnection> _function_51 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn60", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'subprogram subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_51, _function_51);
            EList<AccessConnection> _ownedAccessConnections_51 = it.getOwnedAccessConnections();
            AccessConnection _get_52 = _ownedAccessConnections_51.get(62);
            final Procedure1<AccessConnection> _function_52 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn63", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_52, _function_52);
            EList<AccessConnection> _ownedAccessConnections_52 = it.getOwnedAccessConnections();
            AccessConnection _get_53 = _ownedAccessConnections_52.get(63);
            final Procedure1<AccessConnection> _function_53 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn64", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_53, _function_53);
            EList<AccessConnection> _ownedAccessConnections_53 = it.getOwnedAccessConnections();
            AccessConnection _get_54 = _ownedAccessConnections_53.get(64);
            final Procedure1<AccessConnection> _function_54 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn65", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in an \'abstract subcomponent\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_54, _function_54);
            EList<AccessConnection> _ownedAccessConnections_54 = it.getOwnedAccessConnections();
            AccessConnection _get_55 = _ownedAccessConnections_54.get(65);
            final Procedure1<AccessConnection> _function_55 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn66", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_55, _function_55);
            EList<AccessConnection> _ownedAccessConnections_55 = it.getOwnedAccessConnections();
            AccessConnection _get_56 = _ownedAccessConnections_55.get(66);
            final Procedure1<AccessConnection> _function_56 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn67", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_56, _function_56);
            EList<AccessConnection> _ownedAccessConnections_56 = it.getOwnedAccessConnections();
            AccessConnection _get_57 = _ownedAccessConnections_56.get(67);
            final Procedure1<AccessConnection> _function_57 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn68", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_57, _function_57);
            EList<AccessConnection> _ownedAccessConnections_57 = it.getOwnedAccessConnections();
            AccessConnection _get_58 = _ownedAccessConnections_57.get(68);
            final Procedure1<AccessConnection> _function_58 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn69", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_58, _function_58);
            EList<AccessConnection> _ownedAccessConnections_58 = it.getOwnedAccessConnections();
            AccessConnection _get_59 = _ownedAccessConnections_58.get(69);
            final Procedure1<AccessConnection> _function_59 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn70", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_59, _function_59);
            EList<AccessConnection> _ownedAccessConnections_59 = it.getOwnedAccessConnections();
            AccessConnection _get_60 = _ownedAccessConnections_59.get(70);
            final Procedure1<AccessConnection> _function_60 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn71", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_60, _function_60);
            EList<AccessConnection> _ownedAccessConnections_60 = it.getOwnedAccessConnections();
            AccessConnection _get_61 = _ownedAccessConnections_60.get(71);
            final Procedure1<AccessConnection> _function_61 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn72", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_61, _function_61);
            EList<AccessConnection> _ownedAccessConnections_61 = it.getOwnedAccessConnections();
            AccessConnection _get_62 = _ownedAccessConnections_61.get(72);
            final Procedure1<AccessConnection> _function_62 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn73", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_62, _function_62);
            EList<AccessConnection> _ownedAccessConnections_62 = it.getOwnedAccessConnections();
            AccessConnection _get_63 = _ownedAccessConnections_62.get(75);
            final Procedure1<AccessConnection> _function_63 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn76", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_63, _function_63);
            EList<AccessConnection> _ownedAccessConnections_63 = it.getOwnedAccessConnections();
            AccessConnection _get_64 = _ownedAccessConnections_63.get(76);
            final Procedure1<AccessConnection> _function_64 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn77", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'subprogram call\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_64, _function_64);
            EList<FeatureConnection> _ownedFeatureConnections = it.getOwnedFeatureConnections();
            FeatureConnection _get_65 = _ownedFeatureConnections.get(0);
            final Procedure1<FeatureConnection> _function_65 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn1", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_65, _function_65);
            EList<FeatureConnection> _ownedFeatureConnections_1 = it.getOwnedFeatureConnections();
            FeatureConnection _get_66 = _ownedFeatureConnections_1.get(1);
            final Procedure1<FeatureConnection> _function_66 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn2", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_66, _function_66);
            EList<FeatureConnection> _ownedFeatureConnections_2 = it.getOwnedFeatureConnections();
            FeatureConnection _get_67 = _ownedFeatureConnections_2.get(2);
            final Procedure1<FeatureConnection> _function_67 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn3", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_67, _function_67);
            EList<FeatureConnection> _ownedFeatureConnections_3 = it.getOwnedFeatureConnections();
            FeatureConnection _get_68 = _ownedFeatureConnections_3.get(3);
            final Procedure1<FeatureConnection> _function_68 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn4", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_68, _function_68);
            EList<FeatureConnection> _ownedFeatureConnections_4 = it.getOwnedFeatureConnections();
            FeatureConnection _get_69 = _ownedFeatureConnections_4.get(4);
            final Procedure1<FeatureConnection> _function_69 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn5", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_69, _function_69);
            EList<FeatureConnection> _ownedFeatureConnections_5 = it.getOwnedFeatureConnections();
            FeatureConnection _get_70 = _ownedFeatureConnections_5.get(14);
            final Procedure1<FeatureConnection> _function_70 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn15", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_70, _function_70);
            EList<FeatureConnection> _ownedFeatureConnections_6 = it.getOwnedFeatureConnections();
            FeatureConnection _get_71 = _ownedFeatureConnections_6.get(15);
            final Procedure1<FeatureConnection> _function_71 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn16", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_71, _function_71);
            EList<FeatureConnection> _ownedFeatureConnections_7 = it.getOwnedFeatureConnections();
            FeatureConnection _get_72 = _ownedFeatureConnections_7.get(16);
            final Procedure1<FeatureConnection> _function_72 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn17", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_72, _function_72);
            EList<FeatureConnection> _ownedFeatureConnections_8 = it.getOwnedFeatureConnections();
            FeatureConnection _get_73 = _ownedFeatureConnections_8.get(17);
            final Procedure1<FeatureConnection> _function_73 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn18", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_73, _function_73);
            EList<FeatureConnection> _ownedFeatureConnections_9 = it.getOwnedFeatureConnections();
            FeatureConnection _get_74 = _ownedFeatureConnections_9.get(18);
            final Procedure1<FeatureConnection> _function_74 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn19", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_74, _function_74);
            EList<FeatureConnection> _ownedFeatureConnections_10 = it.getOwnedFeatureConnections();
            FeatureConnection _get_75 = _ownedFeatureConnections_10.get(19);
            final Procedure1<FeatureConnection> _function_75 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn20", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_75, _function_75);
            EList<FeatureConnection> _ownedFeatureConnections_11 = it.getOwnedFeatureConnections();
            FeatureConnection _get_76 = _ownedFeatureConnections_11.get(20);
            final Procedure1<FeatureConnection> _function_76 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn21", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_76, _function_76);
            EList<FeatureConnection> _ownedFeatureConnections_12 = it.getOwnedFeatureConnections();
            FeatureConnection _get_77 = _ownedFeatureConnections_12.get(21);
            final Procedure1<FeatureConnection> _function_77 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn22", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_77, _function_77);
            EList<FeatureConnection> _ownedFeatureConnections_13 = it.getOwnedFeatureConnections();
            FeatureConnection _get_78 = _ownedFeatureConnections_13.get(22);
            final Procedure1<FeatureConnection> _function_78 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn23", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_78, _function_78);
            EList<FeatureConnection> _ownedFeatureConnections_14 = it.getOwnedFeatureConnections();
            FeatureConnection _get_79 = _ownedFeatureConnections_14.get(23);
            final Procedure1<FeatureConnection> _function_79 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn24", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_79, _function_79);
            EList<FeatureConnection> _ownedFeatureConnections_15 = it.getOwnedFeatureConnections();
            FeatureConnection _get_80 = _ownedFeatureConnections_15.get(24);
            final Procedure1<FeatureConnection> _function_80 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn25", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_80, _function_80);
            EList<FeatureConnection> _ownedFeatureConnections_16 = it.getOwnedFeatureConnections();
            FeatureConnection _get_81 = _ownedFeatureConnections_16.get(25);
            final Procedure1<FeatureConnection> _function_81 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn26", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_81, _function_81);
            EList<FeatureConnection> _ownedFeatureConnections_17 = it.getOwnedFeatureConnections();
            FeatureConnection _get_82 = _ownedFeatureConnections_17.get(26);
            final Procedure1<FeatureConnection> _function_82 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn27", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_82, _function_82);
            EList<FeatureConnection> _ownedFeatureConnections_18 = it.getOwnedFeatureConnections();
            FeatureConnection _get_83 = _ownedFeatureConnections_18.get(27);
            final Procedure1<FeatureConnection> _function_83 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn28", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_83, _function_83);
            EList<FeatureConnection> _ownedFeatureConnections_19 = it.getOwnedFeatureConnections();
            FeatureConnection _get_84 = _ownedFeatureConnections_19.get(28);
            final Procedure1<FeatureConnection> _function_84 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn29", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_84, _function_84);
            EList<FeatureConnection> _ownedFeatureConnections_20 = it.getOwnedFeatureConnections();
            FeatureConnection _get_85 = _ownedFeatureConnections_20.get(29);
            final Procedure1<FeatureConnection> _function_85 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn30", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_85, _function_85);
            EList<FeatureConnection> _ownedFeatureConnections_21 = it.getOwnedFeatureConnections();
            FeatureConnection _get_86 = _ownedFeatureConnections_21.get(30);
            final Procedure1<FeatureConnection> _function_86 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn31", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_86, _function_86);
            EList<FeatureConnection> _ownedFeatureConnections_22 = it.getOwnedFeatureConnections();
            FeatureConnection _get_87 = _ownedFeatureConnections_22.get(31);
            final Procedure1<FeatureConnection> _function_87 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn32", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_87, _function_87);
            EList<FeatureConnection> _ownedFeatureConnections_23 = it.getOwnedFeatureConnections();
            FeatureConnection _get_88 = _ownedFeatureConnections_23.get(32);
            final Procedure1<FeatureConnection> _function_88 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn33", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_88, _function_88);
            EList<FeatureConnection> _ownedFeatureConnections_24 = it.getOwnedFeatureConnections();
            FeatureConnection _get_89 = _ownedFeatureConnections_24.get(33);
            final Procedure1<FeatureConnection> _function_89 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn34", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_89, _function_89);
            EList<FeatureConnection> _ownedFeatureConnections_25 = it.getOwnedFeatureConnections();
            FeatureConnection _get_90 = _ownedFeatureConnections_25.get(34);
            final Procedure1<FeatureConnection> _function_90 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn35", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_90, _function_90);
            EList<FeatureConnection> _ownedFeatureConnections_26 = it.getOwnedFeatureConnections();
            FeatureConnection _get_91 = _ownedFeatureConnections_26.get(35);
            final Procedure1<FeatureConnection> _function_91 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn36", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_91, _function_91);
            EList<FeatureConnection> _ownedFeatureConnections_27 = it.getOwnedFeatureConnections();
            FeatureConnection _get_92 = _ownedFeatureConnections_27.get(36);
            final Procedure1<FeatureConnection> _function_92 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn37", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_92, _function_92);
            EList<FeatureConnection> _ownedFeatureConnections_28 = it.getOwnedFeatureConnections();
            FeatureConnection _get_93 = _ownedFeatureConnections_28.get(37);
            final Procedure1<FeatureConnection> _function_93 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn38", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_93, _function_93);
            EList<FeatureConnection> _ownedFeatureConnections_29 = it.getOwnedFeatureConnections();
            FeatureConnection _get_94 = _ownedFeatureConnections_29.get(38);
            final Procedure1<FeatureConnection> _function_94 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn39", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_94, _function_94);
            EList<FeatureConnection> _ownedFeatureConnections_30 = it.getOwnedFeatureConnections();
            FeatureConnection _get_95 = _ownedFeatureConnections_30.get(39);
            final Procedure1<FeatureConnection> _function_95 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn40", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_95, _function_95);
            EList<FeatureConnection> _ownedFeatureConnections_31 = it.getOwnedFeatureConnections();
            FeatureConnection _get_96 = _ownedFeatureConnections_31.get(40);
            final Procedure1<FeatureConnection> _function_96 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn41", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_96, _function_96);
            EList<FeatureConnection> _ownedFeatureConnections_32 = it.getOwnedFeatureConnections();
            FeatureConnection _get_97 = _ownedFeatureConnections_32.get(41);
            final Procedure1<FeatureConnection> _function_97 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn42", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_97, _function_97);
            EList<FeatureConnection> _ownedFeatureConnections_33 = it.getOwnedFeatureConnections();
            FeatureConnection _get_98 = _ownedFeatureConnections_33.get(50);
            final Procedure1<FeatureConnection> _function_98 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn51", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_98, _function_98);
            EList<FeatureConnection> _ownedFeatureConnections_34 = it.getOwnedFeatureConnections();
            FeatureConnection _get_99 = _ownedFeatureConnections_34.get(51);
            final Procedure1<FeatureConnection> _function_99 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn52", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_99, _function_99);
            EList<FeatureConnection> _ownedFeatureConnections_35 = it.getOwnedFeatureConnections();
            FeatureConnection _get_100 = _ownedFeatureConnections_35.get(52);
            final Procedure1<FeatureConnection> _function_100 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn53", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_100, _function_100);
            EList<FeatureConnection> _ownedFeatureConnections_36 = it.getOwnedFeatureConnections();
            FeatureConnection _get_101 = _ownedFeatureConnections_36.get(53);
            final Procedure1<FeatureConnection> _function_101 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn54", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_101, _function_101);
            EList<FeatureConnection> _ownedFeatureConnections_37 = it.getOwnedFeatureConnections();
            FeatureConnection _get_102 = _ownedFeatureConnections_37.get(54);
            final Procedure1<FeatureConnection> _function_102 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn55", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_102, _function_102);
            EList<FeatureConnection> _ownedFeatureConnections_38 = it.getOwnedFeatureConnections();
            FeatureConnection _get_103 = _ownedFeatureConnections_38.get(55);
            final Procedure1<FeatureConnection> _function_103 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn56", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_103, _function_103);
            EList<FeatureConnection> _ownedFeatureConnections_39 = it.getOwnedFeatureConnections();
            FeatureConnection _get_104 = _ownedFeatureConnections_39.get(56);
            final Procedure1<FeatureConnection> _function_104 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn57", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'abstract subcomponent\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_104, _function_104);
            EList<FeatureConnection> _ownedFeatureConnections_40 = it.getOwnedFeatureConnections();
            FeatureConnection _get_105 = _ownedFeatureConnections_40.get(65);
            final Procedure1<FeatureConnection> _function_105 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn66", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in a \'subprogram call\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_105, _function_105);
            EList<FeatureConnection> _ownedFeatureConnections_41 = it.getOwnedFeatureConnections();
            FeatureConnection _get_106 = _ownedFeatureConnections_41.get(66);
            final Procedure1<FeatureConnection> _function_106 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn67", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'subprogram call\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_106, _function_106);
            EList<FeatureConnection> _ownedFeatureConnections_42 = it.getOwnedFeatureConnections();
            FeatureConnection _get_107 = _ownedFeatureConnections_42.get(67);
            final Procedure1<FeatureConnection> _function_107 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn68", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'subprogram call\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_107, _function_107);
            EList<FeatureConnection> _ownedFeatureConnections_43 = it.getOwnedFeatureConnections();
            FeatureConnection _get_108 = _ownedFeatureConnections_43.get(68);
            final Procedure1<FeatureConnection> _function_108 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn69", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'subprogram call\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_108, _function_108);
            EList<FeatureConnection> _ownedFeatureConnections_44 = it.getOwnedFeatureConnections();
            FeatureConnection _get_109 = _ownedFeatureConnections_44.get(69);
            final Procedure1<FeatureConnection> _function_109 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn70", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'subprogram call\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_109, _function_109);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_110 = _ownedFeatureGroupConnections.get(0);
            final Procedure1<FeatureGroupConnection> _function_110 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn1", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_110, _function_110);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_1 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_111 = _ownedFeatureGroupConnections_1.get(1);
            final Procedure1<FeatureGroupConnection> _function_111 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn2", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_111, _function_111);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_2 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_112 = _ownedFeatureGroupConnections_2.get(2);
            final Procedure1<FeatureGroupConnection> _function_112 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn3", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_112, _function_112);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_3 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_113 = _ownedFeatureGroupConnections_3.get(3);
            final Procedure1<FeatureGroupConnection> _function_113 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn4", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_113, _function_113);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_4 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_114 = _ownedFeatureGroupConnections_4.get(4);
            final Procedure1<FeatureGroupConnection> _function_114 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn5", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_114, _function_114);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_5 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_115 = _ownedFeatureGroupConnections_5.get(5);
            final Procedure1<FeatureGroupConnection> _function_115 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn6", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_115, _function_115);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_6 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_116 = _ownedFeatureGroupConnections_6.get(6);
            final Procedure1<FeatureGroupConnection> _function_116 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn7", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_116, _function_116);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_7 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_117 = _ownedFeatureGroupConnections_7.get(7);
            final Procedure1<FeatureGroupConnection> _function_117 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn8", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_117, _function_117);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_8 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_118 = _ownedFeatureGroupConnections_8.get(9);
            final Procedure1<FeatureGroupConnection> _function_118 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn10", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_118, _function_118);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_9 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_119 = _ownedFeatureGroupConnections_9.get(10);
            final Procedure1<FeatureGroupConnection> _function_119 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn11", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_119, _function_119);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_10 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_120 = _ownedFeatureGroupConnections_10.get(11);
            final Procedure1<FeatureGroupConnection> _function_120 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn12", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_120, _function_120);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_11 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_121 = _ownedFeatureGroupConnections_11.get(12);
            final Procedure1<FeatureGroupConnection> _function_121 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn13", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_121, _function_121);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_12 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_122 = _ownedFeatureGroupConnections_12.get(13);
            final Procedure1<FeatureGroupConnection> _function_122 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn14", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_122, _function_122);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_13 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_123 = _ownedFeatureGroupConnections_13.get(14);
            final Procedure1<FeatureGroupConnection> _function_123 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn15", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_123, _function_123);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_14 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_124 = _ownedFeatureGroupConnections_14.get(15);
            final Procedure1<FeatureGroupConnection> _function_124 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn16", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_124, _function_124);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_15 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_125 = _ownedFeatureGroupConnections_15.get(16);
            final Procedure1<FeatureGroupConnection> _function_125 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn17", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_125, _function_125);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_16 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_126 = _ownedFeatureGroupConnections_16.get(17);
            final Procedure1<FeatureGroupConnection> _function_126 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn18", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_126, _function_126);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_17 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_127 = _ownedFeatureGroupConnections_17.get(18);
            final Procedure1<FeatureGroupConnection> _function_127 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn19", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_127, _function_127);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_18 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_128 = _ownedFeatureGroupConnections_18.get(19);
            final Procedure1<FeatureGroupConnection> _function_128 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn20", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_128, _function_128);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_19 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_129 = _ownedFeatureGroupConnections_19.get(20);
            final Procedure1<FeatureGroupConnection> _function_129 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn21", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_129, _function_129);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_20 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_130 = _ownedFeatureGroupConnections_20.get(21);
            final Procedure1<FeatureGroupConnection> _function_130 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn22", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_130, _function_130);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_21 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_131 = _ownedFeatureGroupConnections_21.get(22);
            final Procedure1<FeatureGroupConnection> _function_131 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn23", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_131, _function_131);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_22 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_132 = _ownedFeatureGroupConnections_22.get(23);
            final Procedure1<FeatureGroupConnection> _function_132 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn24", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_132, _function_132);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_23 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_133 = _ownedFeatureGroupConnections_23.get(24);
            final Procedure1<FeatureGroupConnection> _function_133 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn25", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_133, _function_133);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_24 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_134 = _ownedFeatureGroupConnections_24.get(25);
            final Procedure1<FeatureGroupConnection> _function_134 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn26", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_134, _function_134);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_25 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_135 = _ownedFeatureGroupConnections_25.get(26);
            final Procedure1<FeatureGroupConnection> _function_135 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn27", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_135, _function_135);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_26 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_136 = _ownedFeatureGroupConnections_26.get(27);
            final Procedure1<FeatureGroupConnection> _function_136 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn28", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_136, _function_136);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_27 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_137 = _ownedFeatureGroupConnections_27.get(28);
            final Procedure1<FeatureGroupConnection> _function_137 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn29", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_137, _function_137);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_28 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_138 = _ownedFeatureGroupConnections_28.get(29);
            final Procedure1<FeatureGroupConnection> _function_138 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn30", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_138, _function_138);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_29 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_139 = _ownedFeatureGroupConnections_29.get(30);
            final Procedure1<FeatureGroupConnection> _function_139 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn31", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_139, _function_139);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_30 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_140 = _ownedFeatureGroupConnections_30.get(31);
            final Procedure1<FeatureGroupConnection> _function_140 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn32", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_140, _function_140);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_31 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_141 = _ownedFeatureGroupConnections_31.get(32);
            final Procedure1<FeatureGroupConnection> _function_141 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn33", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_141, _function_141);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_32 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_142 = _ownedFeatureGroupConnections_32.get(33);
            final Procedure1<FeatureGroupConnection> _function_142 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn34", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_142, _function_142);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_33 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_143 = _ownedFeatureGroupConnections_33.get(34);
            final Procedure1<FeatureGroupConnection> _function_143 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn35", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_143, _function_143);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_34 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_144 = _ownedFeatureGroupConnections_34.get(35);
            final Procedure1<FeatureGroupConnection> _function_144 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn36", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_144, _function_144);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_35 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_145 = _ownedFeatureGroupConnections_35.get(36);
            final Procedure1<FeatureGroupConnection> _function_145 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn37", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_145, _function_145);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_36 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_146 = _ownedFeatureGroupConnections_36.get(37);
            final Procedure1<FeatureGroupConnection> _function_146 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn38", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_146, _function_146);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_37 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_147 = _ownedFeatureGroupConnections_37.get(38);
            final Procedure1<FeatureGroupConnection> _function_147 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn39", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_147, _function_147);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_38 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_148 = _ownedFeatureGroupConnections_38.get(39);
            final Procedure1<FeatureGroupConnection> _function_148 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn40", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_148, _function_148);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_39 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_149 = _ownedFeatureGroupConnections_39.get(40);
            final Procedure1<FeatureGroupConnection> _function_149 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn41", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_149, _function_149);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_40 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_150 = _ownedFeatureGroupConnections_40.get(41);
            final Procedure1<FeatureGroupConnection> _function_150 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn42", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'event data port\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_150, _function_150);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_41 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_151 = _ownedFeatureGroupConnections_41.get(42);
            final Procedure1<FeatureGroupConnection> _function_151 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn43", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_151, _function_151);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_42 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_152 = _ownedFeatureGroupConnections_42.get(44);
            final Procedure1<FeatureGroupConnection> _function_152 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn45", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_152, _function_152);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_43 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_153 = _ownedFeatureGroupConnections_43.get(45);
            final Procedure1<FeatureGroupConnection> _function_153 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn46", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_153, _function_153);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_44 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_154 = _ownedFeatureGroupConnections_44.get(46);
            final Procedure1<FeatureGroupConnection> _function_154 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn47", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_154, _function_154);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_45 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_155 = _ownedFeatureGroupConnections_45.get(47);
            final Procedure1<FeatureGroupConnection> _function_155 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn48", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_155, _function_155);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_46 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_156 = _ownedFeatureGroupConnections_46.get(48);
            final Procedure1<FeatureGroupConnection> _function_156 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn49", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_156, _function_156);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_47 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_157 = _ownedFeatureGroupConnections_47.get(49);
            final Procedure1<FeatureGroupConnection> _function_157 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn50", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'feature group\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_157, _function_157);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_48 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_158 = _ownedFeatureGroupConnections_48.get(50);
            final Procedure1<FeatureGroupConnection> _function_158 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn51", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_158, _function_158);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_49 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_159 = _ownedFeatureGroupConnections_49.get(51);
            final Procedure1<FeatureGroupConnection> _function_159 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn52", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_159, _function_159);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_50 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_160 = _ownedFeatureGroupConnections_50.get(52);
            final Procedure1<FeatureGroupConnection> _function_160 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn53", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_160, _function_160);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_51 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_161 = _ownedFeatureGroupConnections_51.get(53);
            final Procedure1<FeatureGroupConnection> _function_161 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn54", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_161, _function_161);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_52 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_162 = _ownedFeatureGroupConnections_52.get(54);
            final Procedure1<FeatureGroupConnection> _function_162 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn55", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_162, _function_162);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_53 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_163 = _ownedFeatureGroupConnections_53.get(55);
            final Procedure1<FeatureGroupConnection> _function_163 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn56", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_163, _function_163);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_54 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_164 = _ownedFeatureGroupConnections_54.get(56);
            final Procedure1<FeatureGroupConnection> _function_164 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn57", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_164, _function_164);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_55 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_165 = _ownedFeatureGroupConnections_55.get(57);
            final Procedure1<FeatureGroupConnection> _function_165 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn58", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_165, _function_165);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_56 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_166 = _ownedFeatureGroupConnections_56.get(59);
            final Procedure1<FeatureGroupConnection> _function_166 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn60", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'subprogram subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_166, _function_166);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_57 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_167 = _ownedFeatureGroupConnections_57.get(60);
            final Procedure1<FeatureGroupConnection> _function_167 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn61", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_167, _function_167);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_58 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_168 = _ownedFeatureGroupConnections_58.get(61);
            final Procedure1<FeatureGroupConnection> _function_168 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn62", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_168, _function_168);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_59 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_169 = _ownedFeatureGroupConnections_59.get(62);
            final Procedure1<FeatureGroupConnection> _function_169 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn63", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_169, _function_169);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_60 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_170 = _ownedFeatureGroupConnections_60.get(63);
            final Procedure1<FeatureGroupConnection> _function_170 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn64", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_170, _function_170);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_61 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_171 = _ownedFeatureGroupConnections_61.get(64);
            final Procedure1<FeatureGroupConnection> _function_171 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn65", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in an \'abstract subcomponent\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_171, _function_171);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_62 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_172 = _ownedFeatureGroupConnections_62.get(65);
            final Procedure1<FeatureGroupConnection> _function_172 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn66", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_172, _function_172);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_63 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_173 = _ownedFeatureGroupConnections_63.get(66);
            final Procedure1<FeatureGroupConnection> _function_173 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn67", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_173, _function_173);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_64 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_174 = _ownedFeatureGroupConnections_64.get(67);
            final Procedure1<FeatureGroupConnection> _function_174 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn68", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_174, _function_174);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_65 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_175 = _ownedFeatureGroupConnections_65.get(68);
            final Procedure1<FeatureGroupConnection> _function_175 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn69", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_175, _function_175);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_66 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_176 = _ownedFeatureGroupConnections_66.get(69);
            final Procedure1<FeatureGroupConnection> _function_176 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn70", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_176, _function_176);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_67 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_177 = _ownedFeatureGroupConnections_67.get(70);
            final Procedure1<FeatureGroupConnection> _function_177 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn71", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_177, _function_177);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_68 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_178 = _ownedFeatureGroupConnections_68.get(71);
            final Procedure1<FeatureGroupConnection> _function_178 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn72", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_178, _function_178);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_69 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_179 = _ownedFeatureGroupConnections_69.get(72);
            final Procedure1<FeatureGroupConnection> _function_179 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn73", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_179, _function_179);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_70 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_180 = _ownedFeatureGroupConnections_70.get(73);
            final Procedure1<FeatureGroupConnection> _function_180 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn74", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_180, _function_180);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_71 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_181 = _ownedFeatureGroupConnections_71.get(74);
            final Procedure1<FeatureGroupConnection> _function_181 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn75", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_181, _function_181);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_72 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_182 = _ownedFeatureGroupConnections_72.get(75);
            final Procedure1<FeatureGroupConnection> _function_182 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn76", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_182, _function_182);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_73 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_183 = _ownedFeatureGroupConnections_73.get(76);
            final Procedure1<FeatureGroupConnection> _function_183 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn77", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram call\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_183, _function_183);
            EList<ParameterConnection> _ownedParameterConnections = it.getOwnedParameterConnections();
            ParameterConnection _get_184 = _ownedParameterConnections.get(0);
            final Procedure1<ParameterConnection> _function_184 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn1", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_184, _function_184);
            EList<ParameterConnection> _ownedParameterConnections_1 = it.getOwnedParameterConnections();
            ParameterConnection _get_185 = _ownedParameterConnections_1.get(2);
            final Procedure1<ParameterConnection> _function_185 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn3", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_185, _function_185);
            EList<ParameterConnection> _ownedParameterConnections_2 = it.getOwnedParameterConnections();
            ParameterConnection _get_186 = _ownedParameterConnections_2.get(3);
            final Procedure1<ParameterConnection> _function_186 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn4", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_186, _function_186);
            EList<ParameterConnection> _ownedParameterConnections_3 = it.getOwnedParameterConnections();
            ParameterConnection _get_187 = _ownedParameterConnections_3.get(4);
            final Procedure1<ParameterConnection> _function_187 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn5", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_187, _function_187);
            EList<ParameterConnection> _ownedParameterConnections_4 = it.getOwnedParameterConnections();
            ParameterConnection _get_188 = _ownedParameterConnections_4.get(5);
            final Procedure1<ParameterConnection> _function_188 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn6", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_188, _function_188);
            EList<ParameterConnection> _ownedParameterConnections_5 = it.getOwnedParameterConnections();
            ParameterConnection _get_189 = _ownedParameterConnections_5.get(6);
            final Procedure1<ParameterConnection> _function_189 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn7", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_189, _function_189);
            EList<ParameterConnection> _ownedParameterConnections_6 = it.getOwnedParameterConnections();
            ParameterConnection _get_190 = _ownedParameterConnections_6.get(7);
            final Procedure1<ParameterConnection> _function_190 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn8", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_190, _function_190);
            EList<ParameterConnection> _ownedParameterConnections_7 = it.getOwnedParameterConnections();
            ParameterConnection _get_191 = _ownedParameterConnections_7.get(8);
            final Procedure1<ParameterConnection> _function_191 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn9", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_191, _function_191);
            EList<ParameterConnection> _ownedParameterConnections_8 = it.getOwnedParameterConnections();
            ParameterConnection _get_192 = _ownedParameterConnections_8.get(9);
            final Procedure1<ParameterConnection> _function_192 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn10", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_192, _function_192);
            EList<ParameterConnection> _ownedParameterConnections_9 = it.getOwnedParameterConnections();
            ParameterConnection _get_193 = _ownedParameterConnections_9.get(11);
            final Procedure1<ParameterConnection> _function_193 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn12", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_193, _function_193);
            EList<ParameterConnection> _ownedParameterConnections_10 = it.getOwnedParameterConnections();
            ParameterConnection _get_194 = _ownedParameterConnections_10.get(14);
            final Procedure1<ParameterConnection> _function_194 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn15", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_194, _function_194);
            EList<ParameterConnection> _ownedParameterConnections_11 = it.getOwnedParameterConnections();
            ParameterConnection _get_195 = _ownedParameterConnections_11.get(16);
            final Procedure1<ParameterConnection> _function_195 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn17", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_195, _function_195);
            EList<ParameterConnection> _ownedParameterConnections_12 = it.getOwnedParameterConnections();
            ParameterConnection _get_196 = _ownedParameterConnections_12.get(17);
            final Procedure1<ParameterConnection> _function_196 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn18", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_196, _function_196);
            EList<ParameterConnection> _ownedParameterConnections_13 = it.getOwnedParameterConnections();
            ParameterConnection _get_197 = _ownedParameterConnections_13.get(18);
            final Procedure1<ParameterConnection> _function_197 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn19", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_197, _function_197);
            EList<ParameterConnection> _ownedParameterConnections_14 = it.getOwnedParameterConnections();
            ParameterConnection _get_198 = _ownedParameterConnections_14.get(19);
            final Procedure1<ParameterConnection> _function_198 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn20", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_198, _function_198);
            EList<ParameterConnection> _ownedParameterConnections_15 = it.getOwnedParameterConnections();
            ParameterConnection _get_199 = _ownedParameterConnections_15.get(20);
            final Procedure1<ParameterConnection> _function_199 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn21", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_199, _function_199);
            EList<ParameterConnection> _ownedParameterConnections_16 = it.getOwnedParameterConnections();
            ParameterConnection _get_200 = _ownedParameterConnections_16.get(21);
            final Procedure1<ParameterConnection> _function_200 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn22", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_200, _function_200);
            EList<ParameterConnection> _ownedParameterConnections_17 = it.getOwnedParameterConnections();
            ParameterConnection _get_201 = _ownedParameterConnections_17.get(22);
            final Procedure1<ParameterConnection> _function_201 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn23", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_201, _function_201);
            EList<ParameterConnection> _ownedParameterConnections_18 = it.getOwnedParameterConnections();
            ParameterConnection _get_202 = _ownedParameterConnections_18.get(23);
            final Procedure1<ParameterConnection> _function_202 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn24", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_202, _function_202);
            EList<ParameterConnection> _ownedParameterConnections_19 = it.getOwnedParameterConnections();
            ParameterConnection _get_203 = _ownedParameterConnections_19.get(24);
            final Procedure1<ParameterConnection> _function_203 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn25", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_203, _function_203);
            EList<ParameterConnection> _ownedParameterConnections_20 = it.getOwnedParameterConnections();
            ParameterConnection _get_204 = _ownedParameterConnections_20.get(25);
            final Procedure1<ParameterConnection> _function_204 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn26", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_204, _function_204);
            EList<ParameterConnection> _ownedParameterConnections_21 = it.getOwnedParameterConnections();
            ParameterConnection _get_205 = _ownedParameterConnections_21.get(26);
            final Procedure1<ParameterConnection> _function_205 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn27", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_205, _function_205);
            EList<ParameterConnection> _ownedParameterConnections_22 = it.getOwnedParameterConnections();
            ParameterConnection _get_206 = _ownedParameterConnections_22.get(27);
            final Procedure1<ParameterConnection> _function_206 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn28", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_206, _function_206);
            EList<ParameterConnection> _ownedParameterConnections_23 = it.getOwnedParameterConnections();
            ParameterConnection _get_207 = _ownedParameterConnections_23.get(28);
            final Procedure1<ParameterConnection> _function_207 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn29", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_207, _function_207);
            EList<ParameterConnection> _ownedParameterConnections_24 = it.getOwnedParameterConnections();
            ParameterConnection _get_208 = _ownedParameterConnections_24.get(30);
            final Procedure1<ParameterConnection> _function_208 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn31", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_208, _function_208);
            EList<ParameterConnection> _ownedParameterConnections_25 = it.getOwnedParameterConnections();
            ParameterConnection _get_209 = _ownedParameterConnections_25.get(31);
            final Procedure1<ParameterConnection> _function_209 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn32", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_209, _function_209);
            EList<ParameterConnection> _ownedParameterConnections_26 = it.getOwnedParameterConnections();
            ParameterConnection _get_210 = _ownedParameterConnections_26.get(32);
            final Procedure1<ParameterConnection> _function_210 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn33", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_210, _function_210);
            EList<ParameterConnection> _ownedParameterConnections_27 = it.getOwnedParameterConnections();
            ParameterConnection _get_211 = _ownedParameterConnections_27.get(33);
            final Procedure1<ParameterConnection> _function_211 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn34", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_211, _function_211);
            EList<ParameterConnection> _ownedParameterConnections_28 = it.getOwnedParameterConnections();
            ParameterConnection _get_212 = _ownedParameterConnections_28.get(34);
            final Procedure1<ParameterConnection> _function_212 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn35", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_212, _function_212);
            EList<ParameterConnection> _ownedParameterConnections_29 = it.getOwnedParameterConnections();
            ParameterConnection _get_213 = _ownedParameterConnections_29.get(35);
            final Procedure1<ParameterConnection> _function_213 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn36", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_213, _function_213);
            EList<ParameterConnection> _ownedParameterConnections_30 = it.getOwnedParameterConnections();
            ParameterConnection _get_214 = _ownedParameterConnections_30.get(36);
            final Procedure1<ParameterConnection> _function_214 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn37", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_214, _function_214);
            EList<ParameterConnection> _ownedParameterConnections_31 = it.getOwnedParameterConnections();
            ParameterConnection _get_215 = _ownedParameterConnections_31.get(37);
            final Procedure1<ParameterConnection> _function_215 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn38", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_215, _function_215);
            EList<ParameterConnection> _ownedParameterConnections_32 = it.getOwnedParameterConnections();
            ParameterConnection _get_216 = _ownedParameterConnections_32.get(38);
            final Procedure1<ParameterConnection> _function_216 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn39", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_216, _function_216);
            EList<ParameterConnection> _ownedParameterConnections_33 = it.getOwnedParameterConnections();
            ParameterConnection _get_217 = _ownedParameterConnections_33.get(39);
            final Procedure1<ParameterConnection> _function_217 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn40", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_217, _function_217);
            EList<ParameterConnection> _ownedParameterConnections_34 = it.getOwnedParameterConnections();
            ParameterConnection _get_218 = _ownedParameterConnections_34.get(40);
            final Procedure1<ParameterConnection> _function_218 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn41", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_218, _function_218);
            EList<ParameterConnection> _ownedParameterConnections_35 = it.getOwnedParameterConnections();
            ParameterConnection _get_219 = _ownedParameterConnections_35.get(41);
            final Procedure1<ParameterConnection> _function_219 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn42", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in an \'event data port\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_219, _function_219);
            EList<ParameterConnection> _ownedParameterConnections_36 = it.getOwnedParameterConnections();
            ParameterConnection _get_220 = _ownedParameterConnections_36.get(42);
            final Procedure1<ParameterConnection> _function_220 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn43", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'feature group\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_220, _function_220);
            EList<ParameterConnection> _ownedParameterConnections_37 = it.getOwnedParameterConnections();
            ParameterConnection _get_221 = _ownedParameterConnections_37.get(43);
            final Procedure1<ParameterConnection> _function_221 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn44", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'feature group\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_221, _function_221);
            EList<ParameterConnection> _ownedParameterConnections_38 = it.getOwnedParameterConnections();
            ParameterConnection _get_222 = _ownedParameterConnections_38.get(45);
            final Procedure1<ParameterConnection> _function_222 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn46", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'feature group\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_222, _function_222);
            EList<ParameterConnection> _ownedParameterConnections_39 = it.getOwnedParameterConnections();
            ParameterConnection _get_223 = _ownedParameterConnections_39.get(47);
            final Procedure1<ParameterConnection> _function_223 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn48", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'feature group\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_223, _function_223);
            EList<ParameterConnection> _ownedParameterConnections_40 = it.getOwnedParameterConnections();
            ParameterConnection _get_224 = _ownedParameterConnections_40.get(50);
            final Procedure1<ParameterConnection> _function_224 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn51", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_224, _function_224);
            EList<ParameterConnection> _ownedParameterConnections_41 = it.getOwnedParameterConnections();
            ParameterConnection _get_225 = _ownedParameterConnections_41.get(51);
            final Procedure1<ParameterConnection> _function_225 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn52", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_225, _function_225);
            EList<ParameterConnection> _ownedParameterConnections_42 = it.getOwnedParameterConnections();
            ParameterConnection _get_226 = _ownedParameterConnections_42.get(52);
            final Procedure1<ParameterConnection> _function_226 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn53", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_226, _function_226);
            EList<ParameterConnection> _ownedParameterConnections_43 = it.getOwnedParameterConnections();
            ParameterConnection _get_227 = _ownedParameterConnections_43.get(53);
            final Procedure1<ParameterConnection> _function_227 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn54", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_227, _function_227);
            EList<ParameterConnection> _ownedParameterConnections_44 = it.getOwnedParameterConnections();
            ParameterConnection _get_228 = _ownedParameterConnections_44.get(54);
            final Procedure1<ParameterConnection> _function_228 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn55", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_228, _function_228);
            EList<ParameterConnection> _ownedParameterConnections_45 = it.getOwnedParameterConnections();
            ParameterConnection _get_229 = _ownedParameterConnections_45.get(55);
            final Procedure1<ParameterConnection> _function_229 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn56", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_229, _function_229);
            EList<ParameterConnection> _ownedParameterConnections_46 = it.getOwnedParameterConnections();
            ParameterConnection _get_230 = _ownedParameterConnections_46.get(56);
            final Procedure1<ParameterConnection> _function_230 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn57", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_230, _function_230);
            EList<ParameterConnection> _ownedParameterConnections_47 = it.getOwnedParameterConnections();
            ParameterConnection _get_231 = _ownedParameterConnections_47.get(57);
            final Procedure1<ParameterConnection> _function_231 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn58", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_231, _function_231);
            EList<ParameterConnection> _ownedParameterConnections_48 = it.getOwnedParameterConnections();
            ParameterConnection _get_232 = _ownedParameterConnections_48.get(58);
            final Procedure1<ParameterConnection> _function_232 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn59", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_232, _function_232);
            EList<ParameterConnection> _ownedParameterConnections_49 = it.getOwnedParameterConnections();
            ParameterConnection _get_233 = _ownedParameterConnections_49.get(59);
            final Procedure1<ParameterConnection> _function_233 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn60", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'subprogram subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_233, _function_233);
            EList<ParameterConnection> _ownedParameterConnections_50 = it.getOwnedParameterConnections();
            ParameterConnection _get_234 = _ownedParameterConnections_50.get(60);
            final Procedure1<ParameterConnection> _function_234 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn61", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_234, _function_234);
            EList<ParameterConnection> _ownedParameterConnections_51 = it.getOwnedParameterConnections();
            ParameterConnection _get_235 = _ownedParameterConnections_51.get(61);
            final Procedure1<ParameterConnection> _function_235 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn62", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_235, _function_235);
            EList<ParameterConnection> _ownedParameterConnections_52 = it.getOwnedParameterConnections();
            ParameterConnection _get_236 = _ownedParameterConnections_52.get(62);
            final Procedure1<ParameterConnection> _function_236 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn63", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_236, _function_236);
            EList<ParameterConnection> _ownedParameterConnections_53 = it.getOwnedParameterConnections();
            ParameterConnection _get_237 = _ownedParameterConnections_53.get(63);
            final Procedure1<ParameterConnection> _function_237 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn64", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_237, _function_237);
            EList<ParameterConnection> _ownedParameterConnections_54 = it.getOwnedParameterConnections();
            ParameterConnection _get_238 = _ownedParameterConnections_54.get(64);
            final Procedure1<ParameterConnection> _function_238 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn65", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in an \'abstract subcomponent\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_238, _function_238);
            EList<ParameterConnection> _ownedParameterConnections_55 = it.getOwnedParameterConnections();
            ParameterConnection _get_239 = _ownedParameterConnections_55.get(65);
            final Procedure1<ParameterConnection> _function_239 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn66", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_239, _function_239);
            EList<ParameterConnection> _ownedParameterConnections_56 = it.getOwnedParameterConnections();
            ParameterConnection _get_240 = _ownedParameterConnections_56.get(66);
            final Procedure1<ParameterConnection> _function_240 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn67", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_240, _function_240);
            EList<ParameterConnection> _ownedParameterConnections_57 = it.getOwnedParameterConnections();
            ParameterConnection _get_241 = _ownedParameterConnections_57.get(67);
            final Procedure1<ParameterConnection> _function_241 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn68", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_241, _function_241);
            EList<ParameterConnection> _ownedParameterConnections_58 = it.getOwnedParameterConnections();
            ParameterConnection _get_242 = _ownedParameterConnections_58.get(68);
            final Procedure1<ParameterConnection> _function_242 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn69", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_242, _function_242);
            EList<ParameterConnection> _ownedParameterConnections_59 = it.getOwnedParameterConnections();
            ParameterConnection _get_243 = _ownedParameterConnections_59.get(69);
            final Procedure1<ParameterConnection> _function_243 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn70", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_243, _function_243);
            EList<ParameterConnection> _ownedParameterConnections_60 = it.getOwnedParameterConnections();
            ParameterConnection _get_244 = _ownedParameterConnections_60.get(70);
            final Procedure1<ParameterConnection> _function_244 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn71", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_244, _function_244);
            EList<ParameterConnection> _ownedParameterConnections_61 = it.getOwnedParameterConnections();
            ParameterConnection _get_245 = _ownedParameterConnections_61.get(71);
            final Procedure1<ParameterConnection> _function_245 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn72", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_245, _function_245);
            EList<ParameterConnection> _ownedParameterConnections_62 = it.getOwnedParameterConnections();
            ParameterConnection _get_246 = _ownedParameterConnections_62.get(73);
            final Procedure1<ParameterConnection> _function_246 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn74", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram access\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_246, _function_246);
            EList<ParameterConnection> _ownedParameterConnections_63 = it.getOwnedParameterConnections();
            ParameterConnection _get_247 = _ownedParameterConnections_63.get(74);
            final Procedure1<ParameterConnection> _function_247 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn75", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_247, _function_247);
            EList<ParameterConnection> _ownedParameterConnections_64 = it.getOwnedParameterConnections();
            ParameterConnection _get_248 = _ownedParameterConnections_64.get(75);
            final Procedure1<ParameterConnection> _function_248 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn76", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_248, _function_248);
            EList<ParameterConnection> _ownedParameterConnections_65 = it.getOwnedParameterConnections();
            ParameterConnection _get_249 = _ownedParameterConnections_65.get(76);
            final Procedure1<ParameterConnection> _function_249 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn77", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'subprogram call\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_249, _function_249);
            EList<PortConnection> _ownedPortConnections = it.getOwnedPortConnections();
            PortConnection _get_250 = _ownedPortConnections.get(0);
            final Procedure1<PortConnection> _function_250 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn1", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_250, _function_250);
            EList<PortConnection> _ownedPortConnections_1 = it.getOwnedPortConnections();
            PortConnection _get_251 = _ownedPortConnections_1.get(2);
            final Procedure1<PortConnection> _function_251 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn3", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_251, _function_251);
            EList<PortConnection> _ownedPortConnections_2 = it.getOwnedPortConnections();
            PortConnection _get_252 = _ownedPortConnections_2.get(3);
            final Procedure1<PortConnection> _function_252 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn4", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_252, _function_252);
            EList<PortConnection> _ownedPortConnections_3 = it.getOwnedPortConnections();
            PortConnection _get_253 = _ownedPortConnections_3.get(4);
            final Procedure1<PortConnection> _function_253 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn5", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_253, _function_253);
            EList<PortConnection> _ownedPortConnections_4 = it.getOwnedPortConnections();
            PortConnection _get_254 = _ownedPortConnections_4.get(7);
            final Procedure1<PortConnection> _function_254 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn8", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_254, _function_254);
            EList<PortConnection> _ownedPortConnections_5 = it.getOwnedPortConnections();
            PortConnection _get_255 = _ownedPortConnections_5.get(8);
            final Procedure1<PortConnection> _function_255 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn9", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_255, _function_255);
            EList<PortConnection> _ownedPortConnections_6 = it.getOwnedPortConnections();
            PortConnection _get_256 = _ownedPortConnections_6.get(9);
            final Procedure1<PortConnection> _function_256 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn10", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_256, _function_256);
            EList<PortConnection> _ownedPortConnections_7 = it.getOwnedPortConnections();
            PortConnection _get_257 = _ownedPortConnections_7.get(14);
            final Procedure1<PortConnection> _function_257 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn15", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_257, _function_257);
            EList<PortConnection> _ownedPortConnections_8 = it.getOwnedPortConnections();
            PortConnection _get_258 = _ownedPortConnections_8.get(16);
            final Procedure1<PortConnection> _function_258 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn17", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_258, _function_258);
            EList<PortConnection> _ownedPortConnections_9 = it.getOwnedPortConnections();
            PortConnection _get_259 = _ownedPortConnections_9.get(17);
            final Procedure1<PortConnection> _function_259 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn18", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_259, _function_259);
            EList<PortConnection> _ownedPortConnections_10 = it.getOwnedPortConnections();
            PortConnection _get_260 = _ownedPortConnections_10.get(18);
            final Procedure1<PortConnection> _function_260 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn19", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_260, _function_260);
            EList<PortConnection> _ownedPortConnections_11 = it.getOwnedPortConnections();
            PortConnection _get_261 = _ownedPortConnections_11.get(19);
            final Procedure1<PortConnection> _function_261 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn20", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_261, _function_261);
            EList<PortConnection> _ownedPortConnections_12 = it.getOwnedPortConnections();
            PortConnection _get_262 = _ownedPortConnections_12.get(20);
            final Procedure1<PortConnection> _function_262 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn21", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_262, _function_262);
            EList<PortConnection> _ownedPortConnections_13 = it.getOwnedPortConnections();
            PortConnection _get_263 = _ownedPortConnections_13.get(21);
            final Procedure1<PortConnection> _function_263 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn22", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_263, _function_263);
            EList<PortConnection> _ownedPortConnections_14 = it.getOwnedPortConnections();
            PortConnection _get_264 = _ownedPortConnections_14.get(22);
            final Procedure1<PortConnection> _function_264 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn23", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_264, _function_264);
            EList<PortConnection> _ownedPortConnections_15 = it.getOwnedPortConnections();
            PortConnection _get_265 = _ownedPortConnections_15.get(23);
            final Procedure1<PortConnection> _function_265 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn24", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_265, _function_265);
            EList<PortConnection> _ownedPortConnections_16 = it.getOwnedPortConnections();
            PortConnection _get_266 = _ownedPortConnections_16.get(24);
            final Procedure1<PortConnection> _function_266 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn25", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_266, _function_266);
            EList<PortConnection> _ownedPortConnections_17 = it.getOwnedPortConnections();
            PortConnection _get_267 = _ownedPortConnections_17.get(25);
            final Procedure1<PortConnection> _function_267 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn26", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_267, _function_267);
            EList<PortConnection> _ownedPortConnections_18 = it.getOwnedPortConnections();
            PortConnection _get_268 = _ownedPortConnections_18.get(26);
            final Procedure1<PortConnection> _function_268 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn27", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_268, _function_268);
            EList<PortConnection> _ownedPortConnections_19 = it.getOwnedPortConnections();
            PortConnection _get_269 = _ownedPortConnections_19.get(27);
            final Procedure1<PortConnection> _function_269 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn28", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_269, _function_269);
            EList<PortConnection> _ownedPortConnections_20 = it.getOwnedPortConnections();
            PortConnection _get_270 = _ownedPortConnections_20.get(28);
            final Procedure1<PortConnection> _function_270 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn29", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_270, _function_270);
            EList<PortConnection> _ownedPortConnections_21 = it.getOwnedPortConnections();
            PortConnection _get_271 = _ownedPortConnections_21.get(30);
            final Procedure1<PortConnection> _function_271 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn31", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_271, _function_271);
            EList<PortConnection> _ownedPortConnections_22 = it.getOwnedPortConnections();
            PortConnection _get_272 = _ownedPortConnections_22.get(31);
            final Procedure1<PortConnection> _function_272 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn32", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_272, _function_272);
            EList<PortConnection> _ownedPortConnections_23 = it.getOwnedPortConnections();
            PortConnection _get_273 = _ownedPortConnections_23.get(32);
            final Procedure1<PortConnection> _function_273 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn33", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_273, _function_273);
            EList<PortConnection> _ownedPortConnections_24 = it.getOwnedPortConnections();
            PortConnection _get_274 = _ownedPortConnections_24.get(33);
            final Procedure1<PortConnection> _function_274 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn34", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_274, _function_274);
            EList<PortConnection> _ownedPortConnections_25 = it.getOwnedPortConnections();
            PortConnection _get_275 = _ownedPortConnections_25.get(34);
            final Procedure1<PortConnection> _function_275 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn35", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_275, _function_275);
            EList<PortConnection> _ownedPortConnections_26 = it.getOwnedPortConnections();
            PortConnection _get_276 = _ownedPortConnections_26.get(35);
            final Procedure1<PortConnection> _function_276 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn36", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_276, _function_276);
            EList<PortConnection> _ownedPortConnections_27 = it.getOwnedPortConnections();
            PortConnection _get_277 = _ownedPortConnections_27.get(36);
            final Procedure1<PortConnection> _function_277 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn37", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_277, _function_277);
            EList<PortConnection> _ownedPortConnections_28 = it.getOwnedPortConnections();
            PortConnection _get_278 = _ownedPortConnections_28.get(37);
            final Procedure1<PortConnection> _function_278 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn38", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_278, _function_278);
            EList<PortConnection> _ownedPortConnections_29 = it.getOwnedPortConnections();
            PortConnection _get_279 = _ownedPortConnections_29.get(38);
            final Procedure1<PortConnection> _function_279 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn39", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_279, _function_279);
            EList<PortConnection> _ownedPortConnections_30 = it.getOwnedPortConnections();
            PortConnection _get_280 = _ownedPortConnections_30.get(39);
            final Procedure1<PortConnection> _function_280 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn40", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_280, _function_280);
            EList<PortConnection> _ownedPortConnections_31 = it.getOwnedPortConnections();
            PortConnection _get_281 = _ownedPortConnections_31.get(40);
            final Procedure1<PortConnection> _function_281 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn41", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_281, _function_281);
            EList<PortConnection> _ownedPortConnections_32 = it.getOwnedPortConnections();
            PortConnection _get_282 = _ownedPortConnections_32.get(41);
            final Procedure1<PortConnection> _function_282 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn42", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in an \'event data port\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_282, _function_282);
            EList<PortConnection> _ownedPortConnections_33 = it.getOwnedPortConnections();
            PortConnection _get_283 = _ownedPortConnections_33.get(42);
            final Procedure1<PortConnection> _function_283 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn43", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'feature group\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_283, _function_283);
            EList<PortConnection> _ownedPortConnections_34 = it.getOwnedPortConnections();
            PortConnection _get_284 = _ownedPortConnections_34.get(43);
            final Procedure1<PortConnection> _function_284 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn44", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'feature group\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_284, _function_284);
            EList<PortConnection> _ownedPortConnections_35 = it.getOwnedPortConnections();
            PortConnection _get_285 = _ownedPortConnections_35.get(44);
            final Procedure1<PortConnection> _function_285 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn45", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'feature group\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_285, _function_285);
            EList<PortConnection> _ownedPortConnections_36 = it.getOwnedPortConnections();
            PortConnection _get_286 = _ownedPortConnections_36.get(45);
            final Procedure1<PortConnection> _function_286 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn46", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'feature group\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_286, _function_286);
            EList<PortConnection> _ownedPortConnections_37 = it.getOwnedPortConnections();
            PortConnection _get_287 = _ownedPortConnections_37.get(50);
            final Procedure1<PortConnection> _function_287 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn51", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_287, _function_287);
            EList<PortConnection> _ownedPortConnections_38 = it.getOwnedPortConnections();
            PortConnection _get_288 = _ownedPortConnections_38.get(51);
            final Procedure1<PortConnection> _function_288 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn52", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data subcomponent\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_288, _function_288);
            EList<PortConnection> _ownedPortConnections_39 = it.getOwnedPortConnections();
            PortConnection _get_289 = _ownedPortConnections_39.get(52);
            final Procedure1<PortConnection> _function_289 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn53", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_289, _function_289);
            EList<PortConnection> _ownedPortConnections_40 = it.getOwnedPortConnections();
            PortConnection _get_290 = _ownedPortConnections_40.get(53);
            final Procedure1<PortConnection> _function_290 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn54", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_290, _function_290);
            EList<PortConnection> _ownedPortConnections_41 = it.getOwnedPortConnections();
            PortConnection _get_291 = _ownedPortConnections_41.get(54);
            final Procedure1<PortConnection> _function_291 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn55", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_291, _function_291);
            EList<PortConnection> _ownedPortConnections_42 = it.getOwnedPortConnections();
            PortConnection _get_292 = _ownedPortConnections_42.get(55);
            final Procedure1<PortConnection> _function_292 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn56", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_292, _function_292);
            EList<PortConnection> _ownedPortConnections_43 = it.getOwnedPortConnections();
            PortConnection _get_293 = _ownedPortConnections_43.get(56);
            final Procedure1<PortConnection> _function_293 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn57", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_293, _function_293);
            EList<PortConnection> _ownedPortConnections_44 = it.getOwnedPortConnections();
            PortConnection _get_294 = _ownedPortConnections_44.get(57);
            final Procedure1<PortConnection> _function_294 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn58", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_294, _function_294);
            EList<PortConnection> _ownedPortConnections_45 = it.getOwnedPortConnections();
            PortConnection _get_295 = _ownedPortConnections_45.get(58);
            final Procedure1<PortConnection> _function_295 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn59", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_295, _function_295);
            EList<PortConnection> _ownedPortConnections_46 = it.getOwnedPortConnections();
            PortConnection _get_296 = _ownedPortConnections_46.get(59);
            final Procedure1<PortConnection> _function_296 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn60", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'subprogram subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_296, _function_296);
            EList<PortConnection> _ownedPortConnections_47 = it.getOwnedPortConnections();
            PortConnection _get_297 = _ownedPortConnections_47.get(60);
            final Procedure1<PortConnection> _function_297 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn61", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in an \'abstract subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_297, _function_297);
            EList<PortConnection> _ownedPortConnections_48 = it.getOwnedPortConnections();
            PortConnection _get_298 = _ownedPortConnections_48.get(65);
            final Procedure1<PortConnection> _function_298 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn66", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_298, _function_298);
            EList<PortConnection> _ownedPortConnections_49 = it.getOwnedPortConnections();
            PortConnection _get_299 = _ownedPortConnections_49.get(67);
            final Procedure1<PortConnection> _function_299 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn68", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_299, _function_299);
            EList<PortConnection> _ownedPortConnections_50 = it.getOwnedPortConnections();
            PortConnection _get_300 = _ownedPortConnections_50.get(68);
            final Procedure1<PortConnection> _function_300 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn69", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_300, _function_300);
            EList<PortConnection> _ownedPortConnections_51 = it.getOwnedPortConnections();
            PortConnection _get_301 = _ownedPortConnections_51.get(69);
            final Procedure1<PortConnection> _function_301 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn70", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_301, _function_301);
            EList<PortConnection> _ownedPortConnections_52 = it.getOwnedPortConnections();
            PortConnection _get_302 = _ownedPortConnections_52.get(70);
            final Procedure1<PortConnection> _function_302 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn71", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_302, _function_302);
            EList<PortConnection> _ownedPortConnections_53 = it.getOwnedPortConnections();
            PortConnection _get_303 = _ownedPortConnections_53.get(71);
            final Procedure1<PortConnection> _function_303 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn72", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_303, _function_303);
            EList<PortConnection> _ownedPortConnections_54 = it.getOwnedPortConnections();
            PortConnection _get_304 = _ownedPortConnections_54.get(72);
            final Procedure1<PortConnection> _function_304 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn73", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_304, _function_304);
            EList<PortConnection> _ownedPortConnections_55 = it.getOwnedPortConnections();
            PortConnection _get_305 = _ownedPortConnections_55.get(73);
            final Procedure1<PortConnection> _function_305 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn74", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_305, _function_305);
            EList<PortConnection> _ownedPortConnections_56 = it.getOwnedPortConnections();
            PortConnection _get_306 = _ownedPortConnections_56.get(74);
            final Procedure1<PortConnection> _function_306 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn75", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'data subcomponent\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_306, _function_306);
            EList<PortConnection> _ownedPortConnections_57 = it.getOwnedPortConnections();
            PortConnection _get_307 = _ownedPortConnections_57.get(80);
            final Procedure1<PortConnection> _function_307 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn81", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_307, _function_307);
            EList<PortConnection> _ownedPortConnections_58 = it.getOwnedPortConnections();
            PortConnection _get_308 = _ownedPortConnections_58.get(81);
            final Procedure1<PortConnection> _function_308 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn82", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_308, _function_308);
            EList<PortConnection> _ownedPortConnections_59 = it.getOwnedPortConnections();
            PortConnection _get_309 = _ownedPortConnections_59.get(82);
            final Procedure1<PortConnection> _function_309 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn83", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_309, _function_309);
            EList<PortConnection> _ownedPortConnections_60 = it.getOwnedPortConnections();
            PortConnection _get_310 = _ownedPortConnections_60.get(83);
            final Procedure1<PortConnection> _function_310 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn84", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_310, _function_310);
            EList<PortConnection> _ownedPortConnections_61 = it.getOwnedPortConnections();
            PortConnection _get_311 = _ownedPortConnections_61.get(84);
            final Procedure1<PortConnection> _function_311 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn85", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_311, _function_311);
            EList<PortConnection> _ownedPortConnections_62 = it.getOwnedPortConnections();
            PortConnection _get_312 = _ownedPortConnections_62.get(85);
            final Procedure1<PortConnection> _function_312 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn86", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_312, _function_312);
            EList<PortConnection> _ownedPortConnections_63 = it.getOwnedPortConnections();
            PortConnection _get_313 = _ownedPortConnections_63.get(86);
            final Procedure1<PortConnection> _function_313 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn87", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_313, _function_313);
            EList<PortConnection> _ownedPortConnections_64 = it.getOwnedPortConnections();
            PortConnection _get_314 = _ownedPortConnections_64.get(87);
            final Procedure1<PortConnection> _function_314 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn88", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram access\' in a \'subprogram call\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_314, _function_314);
          }
        };
        ObjectExtensions.<AbstractImplementation>operator_doubleArrow(
          ((AbstractImplementation) _get_1), _function_1);
        PublicPackageSection _publicSection_2 = it.getPublicSection();
        EList<Classifier> _ownedClassifiers_2 = _publicSection_2.getOwnedClassifiers();
        Classifier _get_2 = _ownedClassifiers_2.get(2);
        final Procedure1<SubprogramType> _function_2 = new Procedure1<SubprogramType>() {
          public void apply(final SubprogramType it) {
            String _name = it.getName();
            Assert.assertEquals("subpcontainer", _name);
            EList<FlowSpecification> _ownedFlowSpecifications = it.getOwnedFlowSpecifications();
            FlowSpecification _get = _ownedFlowSpecifications.get(1);
            final Procedure1<FlowSpecification> _function = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource19", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'parameter\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get, _function);
            EList<FlowSpecification> _ownedFlowSpecifications_1 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_1 = _ownedFlowSpecifications_1.get(2);
            final Procedure1<FlowSpecification> _function_1 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource20", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'parameter\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_1, _function_1);
            EList<FlowSpecification> _ownedFlowSpecifications_2 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_2 = _ownedFlowSpecifications_2.get(3);
            final Procedure1<FlowSpecification> _function_2 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource21", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'parameter\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_2, _function_2);
            EList<FlowSpecification> _ownedFlowSpecifications_3 = it.getOwnedFlowSpecifications();
            FlowSpecification _get_3 = _ownedFlowSpecifications_3.get(4);
            final Procedure1<FlowSpecification> _function_3 = new Procedure1<FlowSpecification>() {
              public void apply(final FlowSpecification it) {
                String _name = it.getName();
                Assert.assertEquals("fsource22", _name);
                FlowEnd _outEnd = it.getOutEnd();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_outEnd, _issues, issueCollection, "Anything in a \'parameter\' is not a valid flow specification feature.");
              }
            };
            ObjectExtensions.<FlowSpecification>operator_doubleArrow(_get_3, _function_3);
          }
        };
        ObjectExtensions.<SubprogramType>operator_doubleArrow(
          ((SubprogramType) _get_2), _function_2);
        PublicPackageSection _publicSection_3 = it.getPublicSection();
        EList<Classifier> _ownedClassifiers_3 = _publicSection_3.getOwnedClassifiers();
        Classifier _get_3 = _ownedClassifiers_3.get(3);
        final Procedure1<SubprogramImplementation> _function_3 = new Procedure1<SubprogramImplementation>() {
          public void apply(final SubprogramImplementation it) {
            String _name = it.getName();
            Assert.assertEquals("subpcontainer.i", _name);
            EList<AccessConnection> _ownedAccessConnections = it.getOwnedAccessConnections();
            AccessConnection _get = _ownedAccessConnections.get(0);
            final Procedure1<AccessConnection> _function = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn78", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get, _function);
            EList<AccessConnection> _ownedAccessConnections_1 = it.getOwnedAccessConnections();
            AccessConnection _get_1 = _ownedAccessConnections_1.get(1);
            final Procedure1<AccessConnection> _function_1 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn79", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_1, _function_1);
            EList<AccessConnection> _ownedAccessConnections_2 = it.getOwnedAccessConnections();
            AccessConnection _get_2 = _ownedAccessConnections_2.get(2);
            final Procedure1<AccessConnection> _function_2 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn80", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_2, _function_2);
            EList<AccessConnection> _ownedAccessConnections_3 = it.getOwnedAccessConnections();
            AccessConnection _get_3 = _ownedAccessConnections_3.get(3);
            final Procedure1<AccessConnection> _function_3 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn81", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_3, _function_3);
            EList<AccessConnection> _ownedAccessConnections_4 = it.getOwnedAccessConnections();
            AccessConnection _get_4 = _ownedAccessConnections_4.get(4);
            final Procedure1<AccessConnection> _function_4 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn82", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_4, _function_4);
            EList<AccessConnection> _ownedAccessConnections_5 = it.getOwnedAccessConnections();
            AccessConnection _get_5 = _ownedAccessConnections_5.get(5);
            final Procedure1<AccessConnection> _function_5 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn83", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_5, _function_5);
            EList<AccessConnection> _ownedAccessConnections_6 = it.getOwnedAccessConnections();
            AccessConnection _get_6 = _ownedAccessConnections_6.get(6);
            final Procedure1<AccessConnection> _function_6 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn84", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_6, _function_6);
            EList<AccessConnection> _ownedAccessConnections_7 = it.getOwnedAccessConnections();
            AccessConnection _get_7 = _ownedAccessConnections_7.get(7);
            final Procedure1<AccessConnection> _function_7 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn85", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_7, _function_7);
            EList<AccessConnection> _ownedAccessConnections_8 = it.getOwnedAccessConnections();
            AccessConnection _get_8 = _ownedAccessConnections_8.get(8);
            final Procedure1<AccessConnection> _function_8 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn86", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_8, _function_8);
            EList<AccessConnection> _ownedAccessConnections_9 = it.getOwnedAccessConnections();
            AccessConnection _get_9 = _ownedAccessConnections_9.get(9);
            final Procedure1<AccessConnection> _function_9 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn87", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_9, _function_9);
            EList<AccessConnection> _ownedAccessConnections_10 = it.getOwnedAccessConnections();
            AccessConnection _get_10 = _ownedAccessConnections_10.get(10);
            final Procedure1<AccessConnection> _function_10 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn88", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_10, _function_10);
            EList<AccessConnection> _ownedAccessConnections_11 = it.getOwnedAccessConnections();
            AccessConnection _get_11 = _ownedAccessConnections_11.get(11);
            final Procedure1<AccessConnection> _function_11 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn89", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_11, _function_11);
            EList<AccessConnection> _ownedAccessConnections_12 = it.getOwnedAccessConnections();
            AccessConnection _get_12 = _ownedAccessConnections_12.get(12);
            final Procedure1<AccessConnection> _function_12 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn90", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_12, _function_12);
            EList<AccessConnection> _ownedAccessConnections_13 = it.getOwnedAccessConnections();
            AccessConnection _get_13 = _ownedAccessConnections_13.get(13);
            final Procedure1<AccessConnection> _function_13 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn91", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_13, _function_13);
            EList<AccessConnection> _ownedAccessConnections_14 = it.getOwnedAccessConnections();
            AccessConnection _get_14 = _ownedAccessConnections_14.get(14);
            final Procedure1<AccessConnection> _function_14 = new Procedure1<AccessConnection>() {
              public void apply(final AccessConnection it) {
                String _name = it.getName();
                Assert.assertEquals("aconn92", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid access connection end.");
              }
            };
            ObjectExtensions.<AccessConnection>operator_doubleArrow(_get_14, _function_14);
            EList<FeatureConnection> _ownedFeatureConnections = it.getOwnedFeatureConnections();
            FeatureConnection _get_15 = _ownedFeatureConnections.get(1);
            final Procedure1<FeatureConnection> _function_15 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn79", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_15, _function_15);
            EList<FeatureConnection> _ownedFeatureConnections_1 = it.getOwnedFeatureConnections();
            FeatureConnection _get_16 = _ownedFeatureConnections_1.get(2);
            final Procedure1<FeatureConnection> _function_16 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn80", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_16, _function_16);
            EList<FeatureConnection> _ownedFeatureConnections_2 = it.getOwnedFeatureConnections();
            FeatureConnection _get_17 = _ownedFeatureConnections_2.get(3);
            final Procedure1<FeatureConnection> _function_17 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn81", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_17, _function_17);
            EList<FeatureConnection> _ownedFeatureConnections_3 = it.getOwnedFeatureConnections();
            FeatureConnection _get_18 = _ownedFeatureConnections_3.get(4);
            final Procedure1<FeatureConnection> _function_18 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn82", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_18, _function_18);
            EList<FeatureConnection> _ownedFeatureConnections_4 = it.getOwnedFeatureConnections();
            FeatureConnection _get_19 = _ownedFeatureConnections_4.get(5);
            final Procedure1<FeatureConnection> _function_19 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn83", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_19, _function_19);
            EList<FeatureConnection> _ownedFeatureConnections_5 = it.getOwnedFeatureConnections();
            FeatureConnection _get_20 = _ownedFeatureConnections_5.get(6);
            final Procedure1<FeatureConnection> _function_20 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn84", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_20, _function_20);
            EList<FeatureConnection> _ownedFeatureConnections_6 = it.getOwnedFeatureConnections();
            FeatureConnection _get_21 = _ownedFeatureConnections_6.get(7);
            final Procedure1<FeatureConnection> _function_21 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn85", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_21, _function_21);
            EList<FeatureConnection> _ownedFeatureConnections_7 = it.getOwnedFeatureConnections();
            FeatureConnection _get_22 = _ownedFeatureConnections_7.get(8);
            final Procedure1<FeatureConnection> _function_22 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn86", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_22, _function_22);
            EList<FeatureConnection> _ownedFeatureConnections_8 = it.getOwnedFeatureConnections();
            FeatureConnection _get_23 = _ownedFeatureConnections_8.get(9);
            final Procedure1<FeatureConnection> _function_23 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn87", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_23, _function_23);
            EList<FeatureConnection> _ownedFeatureConnections_9 = it.getOwnedFeatureConnections();
            FeatureConnection _get_24 = _ownedFeatureConnections_9.get(10);
            final Procedure1<FeatureConnection> _function_24 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn88", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_24, _function_24);
            EList<FeatureConnection> _ownedFeatureConnections_10 = it.getOwnedFeatureConnections();
            FeatureConnection _get_25 = _ownedFeatureConnections_10.get(11);
            final Procedure1<FeatureConnection> _function_25 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn89", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_25, _function_25);
            EList<FeatureConnection> _ownedFeatureConnections_11 = it.getOwnedFeatureConnections();
            FeatureConnection _get_26 = _ownedFeatureConnections_11.get(12);
            final Procedure1<FeatureConnection> _function_26 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn90", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_26, _function_26);
            EList<FeatureConnection> _ownedFeatureConnections_12 = it.getOwnedFeatureConnections();
            FeatureConnection _get_27 = _ownedFeatureConnections_12.get(13);
            final Procedure1<FeatureConnection> _function_27 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn91", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_27, _function_27);
            EList<FeatureConnection> _ownedFeatureConnections_13 = it.getOwnedFeatureConnections();
            FeatureConnection _get_28 = _ownedFeatureConnections_13.get(14);
            final Procedure1<FeatureConnection> _function_28 = new Procedure1<FeatureConnection>() {
              public void apply(final FeatureConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fconn92", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature connection end.");
              }
            };
            ObjectExtensions.<FeatureConnection>operator_doubleArrow(_get_28, _function_28);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_29 = _ownedFeatureGroupConnections.get(0);
            final Procedure1<FeatureGroupConnection> _function_29 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn78", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_29, _function_29);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_1 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_30 = _ownedFeatureGroupConnections_1.get(1);
            final Procedure1<FeatureGroupConnection> _function_30 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn79", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_30, _function_30);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_2 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_31 = _ownedFeatureGroupConnections_2.get(2);
            final Procedure1<FeatureGroupConnection> _function_31 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn80", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_31, _function_31);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_3 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_32 = _ownedFeatureGroupConnections_3.get(3);
            final Procedure1<FeatureGroupConnection> _function_32 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn81", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_32, _function_32);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_4 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_33 = _ownedFeatureGroupConnections_4.get(4);
            final Procedure1<FeatureGroupConnection> _function_33 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn82", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_33, _function_33);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_5 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_34 = _ownedFeatureGroupConnections_5.get(5);
            final Procedure1<FeatureGroupConnection> _function_34 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn83", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_34, _function_34);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_6 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_35 = _ownedFeatureGroupConnections_6.get(6);
            final Procedure1<FeatureGroupConnection> _function_35 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn84", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_35, _function_35);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_7 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_36 = _ownedFeatureGroupConnections_7.get(7);
            final Procedure1<FeatureGroupConnection> _function_36 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn85", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_36, _function_36);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_8 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_37 = _ownedFeatureGroupConnections_8.get(8);
            final Procedure1<FeatureGroupConnection> _function_37 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn86", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_37, _function_37);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_9 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_38 = _ownedFeatureGroupConnections_9.get(9);
            final Procedure1<FeatureGroupConnection> _function_38 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn87", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_38, _function_38);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_10 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_39 = _ownedFeatureGroupConnections_10.get(10);
            final Procedure1<FeatureGroupConnection> _function_39 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn88", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_39, _function_39);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_11 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_40 = _ownedFeatureGroupConnections_11.get(11);
            final Procedure1<FeatureGroupConnection> _function_40 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn89", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_40, _function_40);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_12 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_41 = _ownedFeatureGroupConnections_12.get(12);
            final Procedure1<FeatureGroupConnection> _function_41 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn90", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_41, _function_41);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_13 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_42 = _ownedFeatureGroupConnections_13.get(13);
            final Procedure1<FeatureGroupConnection> _function_42 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn91", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_42, _function_42);
            EList<FeatureGroupConnection> _ownedFeatureGroupConnections_14 = it.getOwnedFeatureGroupConnections();
            FeatureGroupConnection _get_43 = _ownedFeatureGroupConnections_14.get(14);
            final Procedure1<FeatureGroupConnection> _function_43 = new Procedure1<FeatureGroupConnection>() {
              public void apply(final FeatureGroupConnection it) {
                String _name = it.getName();
                Assert.assertEquals("fgconn92", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid feature group connection end.");
              }
            };
            ObjectExtensions.<FeatureGroupConnection>operator_doubleArrow(_get_43, _function_43);
            EList<ParameterConnection> _ownedParameterConnections = it.getOwnedParameterConnections();
            ParameterConnection _get_44 = _ownedParameterConnections.get(1);
            final Procedure1<ParameterConnection> _function_44 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn79", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus subcomponent\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_44, _function_44);
            EList<ParameterConnection> _ownedParameterConnections_1 = it.getOwnedParameterConnections();
            ParameterConnection _get_45 = _ownedParameterConnections_1.get(3);
            final Procedure1<ParameterConnection> _function_45 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn81", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram group subcomponent\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_45, _function_45);
            EList<ParameterConnection> _ownedParameterConnections_2 = it.getOwnedParameterConnections();
            ParameterConnection _get_46 = _ownedParameterConnections_2.get(4);
            final Procedure1<ParameterConnection> _function_46 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn82", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram subcomponent\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_46, _function_46);
            EList<ParameterConnection> _ownedParameterConnections_3 = it.getOwnedParameterConnections();
            ParameterConnection _get_47 = _ownedParameterConnections_3.get(5);
            final Procedure1<ParameterConnection> _function_47 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn83", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'subprogram proxy\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_47, _function_47);
            EList<ParameterConnection> _ownedParameterConnections_4 = it.getOwnedParameterConnections();
            ParameterConnection _get_48 = _ownedParameterConnections_4.get(6);
            final Procedure1<ParameterConnection> _function_48 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn84", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'port proxy\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_48, _function_48);
            EList<ParameterConnection> _ownedParameterConnections_5 = it.getOwnedParameterConnections();
            ParameterConnection _get_49 = _ownedParameterConnections_5.get(7);
            final Procedure1<ParameterConnection> _function_49 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn85", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data source\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_49, _function_49);
            EList<ParameterConnection> _ownedParameterConnections_6 = it.getOwnedParameterConnections();
            ParameterConnection _get_50 = _ownedParameterConnections_6.get(8);
            final Procedure1<ParameterConnection> _function_50 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn86", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'abstract feature\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_50, _function_50);
            EList<ParameterConnection> _ownedParameterConnections_7 = it.getOwnedParameterConnections();
            ParameterConnection _get_51 = _ownedParameterConnections_7.get(9);
            final Procedure1<ParameterConnection> _function_51 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn87", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'feature group\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_51, _function_51);
            EList<ParameterConnection> _ownedParameterConnections_8 = it.getOwnedParameterConnections();
            ParameterConnection _get_52 = _ownedParameterConnections_8.get(10);
            final Procedure1<ParameterConnection> _function_52 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn88", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'bus access\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_52, _function_52);
            EList<ParameterConnection> _ownedParameterConnections_9 = it.getOwnedParameterConnections();
            ParameterConnection _get_53 = _ownedParameterConnections_9.get(11);
            final Procedure1<ParameterConnection> _function_53 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn89", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data access\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_53, _function_53);
            EList<ParameterConnection> _ownedParameterConnections_10 = it.getOwnedParameterConnections();
            ParameterConnection _get_54 = _ownedParameterConnections_10.get(12);
            final Procedure1<ParameterConnection> _function_54 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn90", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event port\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_54, _function_54);
            EList<ParameterConnection> _ownedParameterConnections_11 = it.getOwnedParameterConnections();
            ParameterConnection _get_55 = _ownedParameterConnections_11.get(13);
            final Procedure1<ParameterConnection> _function_55 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn91", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'data port\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_55, _function_55);
            EList<ParameterConnection> _ownedParameterConnections_12 = it.getOwnedParameterConnections();
            ParameterConnection _get_56 = _ownedParameterConnections_12.get(14);
            final Procedure1<ParameterConnection> _function_56 = new Procedure1<ParameterConnection>() {
              public void apply(final ParameterConnection it) {
                String _name = it.getName();
                Assert.assertEquals("paramconn92", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "An \'event data port\' in a \'parameter\' is not a valid parameter connection end.");
              }
            };
            ObjectExtensions.<ParameterConnection>operator_doubleArrow(_get_56, _function_56);
            EList<PortConnection> _ownedPortConnections = it.getOwnedPortConnections();
            PortConnection _get_57 = _ownedPortConnections.get(0);
            final Procedure1<PortConnection> _function_57 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn92", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "A \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_57, _function_57);
            EList<PortConnection> _ownedPortConnections_1 = it.getOwnedPortConnections();
            PortConnection _get_58 = _ownedPortConnections_1.get(1);
            final Procedure1<PortConnection> _function_58 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn93", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_58, _function_58);
            EList<PortConnection> _ownedPortConnections_2 = it.getOwnedPortConnections();
            PortConnection _get_59 = _ownedPortConnections_2.get(2);
            final Procedure1<PortConnection> _function_59 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn94", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_59, _function_59);
            EList<PortConnection> _ownedPortConnections_3 = it.getOwnedPortConnections();
            PortConnection _get_60 = _ownedPortConnections_3.get(3);
            final Procedure1<PortConnection> _function_60 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn95", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_60, _function_60);
            EList<PortConnection> _ownedPortConnections_4 = it.getOwnedPortConnections();
            PortConnection _get_61 = _ownedPortConnections_4.get(4);
            final Procedure1<PortConnection> _function_61 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn96", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_61, _function_61);
            EList<PortConnection> _ownedPortConnections_5 = it.getOwnedPortConnections();
            PortConnection _get_62 = _ownedPortConnections_5.get(5);
            final Procedure1<PortConnection> _function_62 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn97", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_62, _function_62);
            EList<PortConnection> _ownedPortConnections_6 = it.getOwnedPortConnections();
            PortConnection _get_63 = _ownedPortConnections_6.get(6);
            final Procedure1<PortConnection> _function_63 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn98", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_63, _function_63);
            EList<PortConnection> _ownedPortConnections_7 = it.getOwnedPortConnections();
            PortConnection _get_64 = _ownedPortConnections_7.get(7);
            final Procedure1<PortConnection> _function_64 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn99", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_64, _function_64);
            EList<PortConnection> _ownedPortConnections_8 = it.getOwnedPortConnections();
            PortConnection _get_65 = _ownedPortConnections_8.get(8);
            final Procedure1<PortConnection> _function_65 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn100", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_65, _function_65);
            EList<PortConnection> _ownedPortConnections_9 = it.getOwnedPortConnections();
            PortConnection _get_66 = _ownedPortConnections_9.get(9);
            final Procedure1<PortConnection> _function_66 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn101", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_66, _function_66);
            EList<PortConnection> _ownedPortConnections_10 = it.getOwnedPortConnections();
            PortConnection _get_67 = _ownedPortConnections_10.get(10);
            final Procedure1<PortConnection> _function_67 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn102", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_67, _function_67);
            EList<PortConnection> _ownedPortConnections_11 = it.getOwnedPortConnections();
            PortConnection _get_68 = _ownedPortConnections_11.get(11);
            final Procedure1<PortConnection> _function_68 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn103", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_68, _function_68);
            EList<PortConnection> _ownedPortConnections_12 = it.getOwnedPortConnections();
            PortConnection _get_69 = _ownedPortConnections_12.get(12);
            final Procedure1<PortConnection> _function_69 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn104", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_69, _function_69);
            EList<PortConnection> _ownedPortConnections_13 = it.getOwnedPortConnections();
            PortConnection _get_70 = _ownedPortConnections_13.get(13);
            final Procedure1<PortConnection> _function_70 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn105", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_70, _function_70);
            EList<PortConnection> _ownedPortConnections_14 = it.getOwnedPortConnections();
            PortConnection _get_71 = _ownedPortConnections_14.get(14);
            final Procedure1<PortConnection> _function_71 = new Procedure1<PortConnection>() {
              public void apply(final PortConnection it) {
                String _name = it.getName();
                Assert.assertEquals("portconn106", _name);
                ConnectedElement _source = it.getSource();
                List<Issue> _issues = testFileResult.getIssues();
                Aadl2JavaValidatorTest.assertError(_source, _issues, issueCollection, "Anything in a \'parameter\' is not a valid port connection end.");
              }
            };
            ObjectExtensions.<PortConnection>operator_doubleArrow(_get_71, _function_71);
          }
        };
        ObjectExtensions.<SubprogramImplementation>operator_doubleArrow(
          ((SubprogramImplementation) _get_3), _function_3);
      }
    };
    ObjectExtensions.<AadlPackage>operator_doubleArrow(
      ((AadlPackage) _head), _function);
    issueCollection.sizeIs(410);
    this.assertConstraints(issueCollection);
  }
  
  private static void assertError(final EObject eObject, final List<Issue> allIssues, final FluentIssueCollection issueCollection, final String... expectedMessages) {
    try {
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        public Boolean apply(final Issue it) {
          boolean _and = false;
          Severity _severity = it.getSeverity();
          boolean _equals = Objects.equal(_severity, Severity.ERROR);
          if (!_equals) {
            _and = false;
          } else {
            URI _uriToProblem = it.getUriToProblem();
            URI _uRI = EcoreUtil.getURI(eObject);
            boolean _equals_1 = Objects.equal(_uriToProblem, _uRI);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Issue> errorsForEObject = IterableExtensions.<Issue>filter(allIssues, _function);
      final Function1<Issue, String> _function_1 = new Function1<Issue, String>() {
        public String apply(final Issue it) {
          return it.getMessage();
        }
      };
      final Iterable<String> errorMessagesForEObject = IterableExtensions.<Issue, String>map(errorsForEObject, _function_1);
      Set<String> _set = IterableExtensions.<String>toSet(errorMessagesForEObject);
      Set<String> _set_1 = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(expectedMessages)));
      boolean _notEquals = (!Objects.equal(_set, _set_1));
      if (_notEquals) {
        String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(expectedMessages)), "\n");
        String _join_1 = IterableExtensions.join(errorMessagesForEObject, "\n");
        throw new ComparisonFailure("", _join, _join_1);
      }
      final Procedure1<Issue> _function_2 = new Procedure1<Issue>() {
        public void apply(final Issue it) {
          issueCollection.addIssue(it);
        }
      };
      IterableExtensions.<Issue>forEach(errorsForEObject, _function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
