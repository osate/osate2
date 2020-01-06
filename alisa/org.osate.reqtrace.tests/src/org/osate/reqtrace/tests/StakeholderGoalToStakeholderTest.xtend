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
package org.osate.reqtrace.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.alisa.workbench.AlisaUiInjectorProvider
import org.osate.testsupport.BIRTTest
import org.osate.reqtrace.ReqTraceConfigDialog

import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(AlisaUiInjectorProvider)
class StakeholderGoalToStakeholderTest extends BIRTTest {
	val static REQTRACE_RPTDESIGN_URL = "platform:/plugin/org.osate.reqtrace/reqtrace.rptdesign"
	
	@Test
	def void testStakeholderGoalToStakeholder() {
		val org1FileName = "org1.org"
		val document1FileName = "document1.goaldoc"
		val systemRequirements1FileName = "systemRequirements1.reqspec"
		val pkg1FileName = "pkg1.aadl"
		val goals1FileName = "goals1.goals"
		createFiles(org1FileName -> '''
			organization org1
			stakeholder stakeholder1 []
		''', document1FileName -> '''
			document document1 [
				goal goal1: "Goal 1 description" [
					stakeholder org1.stakeholder1
				]
				goal goal2: "Goal 2 description" [
				]
			]
		''', systemRequirements1FileName -> '''
			system requirements systemRequirements1 for pkg1::sys1.i [
				requirement req1 [
					see goal document1.goal1
				]
				requirement req2 [
					see goal document1.goal2
				]
			]
		''', pkg1FileName -> '''
			package pkg1
			public
				system sys1
				end sys1;
				
				system implementation sys1.i
				end sys1.i;
			end pkg1;
		''', goals1FileName -> '''
			stakeholder goals goals1 for pkg1::sys1.i [
				goal goal1 [
					stakeholder org1.stakeholder1
					see goal document1.goal1
				]
				goal goal2 [
					see goal document1.goal2
				]
			]
		''')
		suppressSerialization
		assertReport(REQTRACE_RPTDESIGN_URL, expectedGoaldoc, newHashMap(
			"ProjectName" -> projectName,
			"Directories" -> "",
			"FileName" -> document1FileName,
			"AADLFile" -> '''/«projectName»/«document1FileName»''',
			"FileType" -> "goaldoc",
			"ReportType" -> ReqTraceConfigDialog.G2S
		))
		assertReport(REQTRACE_RPTDESIGN_URL, expectedPackage, newHashMap(
			"ProjectName" -> projectName,
			"Directories" -> "",
			"FileName" -> pkg1FileName,
			"AADLFile" -> '''/«projectName»/«pkg1FileName»''',
			"FileType" -> "package",
			"ReportType" -> ReqTraceConfigDialog.G2S
		))
		assertReport(REQTRACE_RPTDESIGN_URL, expectedGoals, newHashMap(
			"ProjectName" -> projectName,
			"Directories" -> "",
			"FileName" -> goals1FileName,
			"AADLFile" -> '''/«projectName»/«goals1FileName»''',
			"FileType" -> "goals",
			"ReportType" -> ReqTraceConfigDialog.G2S
		))
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			Assert.assertEquals("pkg1", name)
			publicSection.ownedClassifiers.get(1) as ComponentImplementation => [
				Assert.assertEquals("sys1.i", name)
				val instanceURI = buildInstanceModelFile.eResource.URI
				val directories = instanceURI.segment(2)
				val fileName = instanceURI.lastSegment
				assertReport(REQTRACE_RPTDESIGN_URL, expectedInstance, newHashMap(
					"ProjectName" -> projectName,
					"Directories" -> directories,
					"FileName" -> fileName,
					"AADLFile" -> '''/«projectName»/«directories»/«fileName»''',
					"FileType" -> "instance",
					"ReportType" -> ReqTraceConfigDialog.G2S
				))
			]
		]
	}
	
	val expectedGoaldoc = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_18 { border: medium solid black;}
							.style_17 { font-style: italic; font-weight: normal;}
							.style_19 { border-top: 1px solid black;}
							.style_14 { height: 0.292in;}
							.style_13 { font-style: italic;}
							.style_16 { padding: 0pt 0pt 3pt;}
							.style_15 { border-top: thin solid black; border-right: none black; border-left: none black;}
							.style_8 { border-right: thin solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { margin-top: 6pt; border: medium solid black;}
							.style_7 { border-bottom: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: none black; border-right: none black; border-bottom: 1px solid black; border-left: none black;}
							.style_21 { margin-top: auto; border: medium solid black;}
							.style_20 { border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;}
							.style_12 { height: 0.594in;}
							.style_11 { padding: 0pt; border-right: thin solid black;}
							.style_4 { font-weight: bold; font-size: 9pt;}
							.style_5 { font-style: italic; font-size: 9pt;}
							.style_2 { font-size: 14pt;}
							.style_3 { width: 7.931in;}
					</style>
					<script type="text/javascript">
					 //<![CDATA[
					   function redirect(target, url){
					       if (target =='_blank'){
					           open(url);
					       }
					       else if (target == '_top'){
					           window.top.location.href=url;
					       }
					       else if (target == '_parent'){
					           location.href=url;
					       }
					       else if (target == '_self'){
					           location.href =url;
					       }
					       else{
					           open(url);
					       }
					      }
					 //]]>
					</script>
				</head>
				<body class="style_0" style=" margin:0px;">
					<table cellpadding="0" style="empty-cells: show; border-collapse:collapse; width:8in; overflow: hidden; table-layout:fixed;">
						<col></col>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td valign="top">
								<div class="style_2" id="" style=" text-align:center;">Stakeholder Goal to Stakeholders Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">StakeholderGoalToStakeholderTest</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Folder:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">
												<div style="visibility:hidden">&#xa0;</div>
											</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">File:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">document1.goaldoc</div>
										</td>
									</tr>
								</table>
								<table class="style_18" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_3">
									<col></col>
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Goal</div>
										</th>
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal1</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 1 description</div>
													</td>
												</tr>
											</table>
										</td>
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_4">
												<col></col>
												<tr class="style_20" valign="top" align="left">
													<td class="style_16" style=" overflow:hidden; border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;">
														<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
															<col></col>
															<tr valign="top" align="left">
																<td style=" overflow:hidden;">
																	<div class="style_17">org1.stakeholder1</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table class="style_21" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_6">
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder Goals not Traceable to a Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal2</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 2 description</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div style="overflow:hidden; height:0.5in">
									<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
										<col></col>
										<col></col>
										<tr valign="top" align="left">
											<td style=" overflow:hidden;">
												<div style=" overflow:hidden;"></div>
											</td>
											<td style=" overflow:hidden;">
												<div style=" text-align:right;">1</div>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</body>
			</html>'''
	
	val expectedPackage = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_18 { border: medium solid black;}
							.style_17 { font-style: italic; font-weight: normal;}
							.style_19 { border-top: 1px solid black;}
							.style_14 { height: 0.292in;}
							.style_13 { font-style: italic;}
							.style_16 { padding: 0pt 0pt 3pt;}
							.style_15 { border-top: thin solid black; border-right: none black; border-left: none black;}
							.style_8 { border-right: thin solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { margin-top: 6pt; border: medium solid black;}
							.style_7 { border-bottom: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: none black; border-right: none black; border-bottom: 1px solid black; border-left: none black;}
							.style_21 { margin-top: auto; border: medium solid black;}
							.style_20 { border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;}
							.style_12 { height: 0.594in;}
							.style_11 { padding: 0pt; border-right: thin solid black;}
							.style_4 { font-weight: bold; font-size: 9pt;}
							.style_5 { font-style: italic; font-size: 9pt;}
							.style_2 { font-size: 14pt;}
							.style_3 { width: 7.931in;}
					</style>
					<script type="text/javascript">
					 //<![CDATA[
					   function redirect(target, url){
					       if (target =='_blank'){
					           open(url);
					       }
					       else if (target == '_top'){
					           window.top.location.href=url;
					       }
					       else if (target == '_parent'){
					           location.href=url;
					       }
					       else if (target == '_self'){
					           location.href =url;
					       }
					       else{
					           open(url);
					       }
					      }
					 //]]>
					</script>
				</head>
				<body class="style_0" style=" margin:0px;">
					<table cellpadding="0" style="empty-cells: show; border-collapse:collapse; width:8in; overflow: hidden; table-layout:fixed;">
						<col></col>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td valign="top">
								<div class="style_2" id="" style=" text-align:center;">Stakeholder Goal to Stakeholders Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">StakeholderGoalToStakeholderTest</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Folder:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">
												<div style="visibility:hidden">&#xa0;</div>
											</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">File:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">pkg1.aadl</div>
										</td>
									</tr>
								</table>
								<table class="style_18" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_5">
									<col></col>
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Goal</div>
										</th>
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal1</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 1 description</div>
													</td>
												</tr>
											</table>
										</td>
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_6">
												<col></col>
												<tr class="style_20" valign="top" align="left">
													<td class="style_16" style=" overflow:hidden; border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;">
														<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
															<col></col>
															<tr valign="top" align="left">
																<td style=" overflow:hidden;">
																	<div class="style_17">org1.stakeholder1</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table class="style_21" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_8">
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder Goals not Traceable to a Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal2</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 2 description</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div style="overflow:hidden; height:0.5in">
									<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
										<col></col>
										<col></col>
										<tr valign="top" align="left">
											<td style=" overflow:hidden;">
												<div style=" overflow:hidden;"></div>
											</td>
											<td style=" overflow:hidden;">
												<div style=" text-align:right;">1</div>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</body>
			</html>'''
	
	val expectedGoals = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_18 { border: medium solid black;}
							.style_17 { font-style: italic; font-weight: normal;}
							.style_19 { border-top: 1px solid black;}
							.style_14 { height: 0.292in;}
							.style_13 { font-style: italic;}
							.style_16 { padding: 0pt 0pt 3pt;}
							.style_15 { border-top: thin solid black; border-right: none black; border-left: none black;}
							.style_8 { border-right: thin solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { margin-top: 6pt; border: medium solid black;}
							.style_7 { border-bottom: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: none black; border-right: none black; border-bottom: 1px solid black; border-left: none black;}
							.style_21 { margin-top: auto; border: medium solid black;}
							.style_20 { border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;}
							.style_12 { height: 0.594in;}
							.style_11 { padding: 0pt; border-right: thin solid black;}
							.style_4 { font-weight: bold; font-size: 9pt;}
							.style_5 { font-style: italic; font-size: 9pt;}
							.style_2 { font-size: 14pt;}
							.style_3 { width: 7.931in;}
					</style>
					<script type="text/javascript">
					 //<![CDATA[
					   function redirect(target, url){
					       if (target =='_blank'){
					           open(url);
					       }
					       else if (target == '_top'){
					           window.top.location.href=url;
					       }
					       else if (target == '_parent'){
					           location.href=url;
					       }
					       else if (target == '_self'){
					           location.href =url;
					       }
					       else{
					           open(url);
					       }
					      }
					 //]]>
					</script>
				</head>
				<body class="style_0" style=" margin:0px;">
					<table cellpadding="0" style="empty-cells: show; border-collapse:collapse; width:8in; overflow: hidden; table-layout:fixed;">
						<col></col>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td valign="top">
								<div class="style_2" id="" style=" text-align:center;">Stakeholder Goal to Stakeholders Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">StakeholderGoalToStakeholderTest</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Folder:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">
												<div style="visibility:hidden">&#xa0;</div>
											</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">File:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">goals1.goals</div>
										</td>
									</tr>
								</table>
								<table class="style_18" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_3">
									<col></col>
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Goal</div>
										</th>
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">goals1.goal1</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>
															<div style="visibility:hidden">&#xa0;</div>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_4">
												<col></col>
												<tr class="style_20" valign="top" align="left">
													<td class="style_16" style=" overflow:hidden; border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;">
														<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
															<col></col>
															<tr valign="top" align="left">
																<td style=" overflow:hidden;">
																	<div class="style_17">org1.stakeholder1</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table class="style_21" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_6">
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder Goals not Traceable to a Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">goals1.goal2</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>
															<div style="visibility:hidden">&#xa0;</div>
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div style="overflow:hidden; height:0.5in">
									<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
										<col></col>
										<col></col>
										<tr valign="top" align="left">
											<td style=" overflow:hidden;">
												<div style=" overflow:hidden;"></div>
											</td>
											<td style=" overflow:hidden;">
												<div style=" text-align:right;">1</div>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</body>
			</html>'''
	
	val expectedInstance = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_18 { border: medium solid black;}
							.style_17 { font-style: italic; font-weight: normal;}
							.style_19 { border-top: 1px solid black;}
							.style_14 { height: 0.292in;}
							.style_13 { font-style: italic;}
							.style_16 { padding: 0pt 0pt 3pt;}
							.style_15 { border-top: thin solid black; border-right: none black; border-left: none black;}
							.style_8 { border-right: thin solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { margin-top: 6pt; border: medium solid black;}
							.style_7 { border-bottom: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: none black; border-right: none black; border-bottom: 1px solid black; border-left: none black;}
							.style_21 { margin-top: auto; border: medium solid black;}
							.style_20 { border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;}
							.style_12 { height: 0.594in;}
							.style_11 { padding: 0pt; border-right: thin solid black;}
							.style_4 { font-weight: bold; font-size: 9pt;}
							.style_5 { font-style: italic; font-size: 9pt;}
							.style_2 { font-size: 14pt;}
							.style_3 { width: 7.931in;}
					</style>
					<script type="text/javascript">
					 //<![CDATA[
					   function redirect(target, url){
					       if (target =='_blank'){
					           open(url);
					       }
					       else if (target == '_top'){
					           window.top.location.href=url;
					       }
					       else if (target == '_parent'){
					           location.href=url;
					       }
					       else if (target == '_self'){
					           location.href =url;
					       }
					       else{
					           open(url);
					       }
					      }
					 //]]>
					</script>
				</head>
				<body class="style_0" style=" margin:0px;">
					<table cellpadding="0" style="empty-cells: show; border-collapse:collapse; width:8in; overflow: hidden; table-layout:fixed;">
						<col></col>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td valign="top">
								<div class="style_2" id="" style=" text-align:center;">Stakeholder Goal to Stakeholders Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">StakeholderGoalToStakeholderTest</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Folder:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">instances</div>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">File:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">pkg1_sys1_i_Instance.aaxl2</div>
										</td>
									</tr>
								</table>
								<table class="style_18" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_5">
									<col></col>
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Goal</div>
										</th>
										<th class="style_8" style=" overflow:hidden;font-weight: normal; border-right: thin solid black; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal1</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 1 description</div>
													</td>
												</tr>
											</table>
										</td>
										<td class="style_11" style=" overflow:hidden; border-top: 1px solid black; border-right: thin solid black;">
											<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_6">
												<col></col>
												<tr class="style_20" valign="top" align="left">
													<td class="style_16" style=" overflow:hidden; border-top: none black; border-right: none black; border-bottom: thin solid black; border-left: none black;">
														<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
															<col></col>
															<tr valign="top" align="left">
																<td style=" overflow:hidden;">
																	<div class="style_17">org1.stakeholder1</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table class="style_21" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_8">
									<col></col>
									<tr class="style_7" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Stakeholder Goals not Traceable to a Stakeholder</div>
										</th>
									</tr>
									<tr class="style_19" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_12" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_13">document1.goal2</div>
													</td>
												</tr>
												<tr class="style_14" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>Goal 2 description</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div style="overflow:hidden; height:0.5in">
									<table style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="">
										<col></col>
										<col></col>
										<tr valign="top" align="left">
											<td style=" overflow:hidden;">
												<div style=" overflow:hidden;"></div>
											</td>
											<td style=" overflow:hidden;">
												<div style=" text-align:right;">1</div>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</body>
			</html>'''
}