package org.osate.reqtrace.tests

import org.eclipse.xtext.junit4.InjectWith
import com.itemis.xtext.testing.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.alisa.workbench.AlisaUiInjectorProvider
import org.osate.core.test.BIRTTest

@RunWith(XtextRunner2)
@InjectWith(AlisaUiInjectorProvider)
class RequirementsReportTest extends BIRTTest {
	val static REQUIREMENTS_RPTDESIGN_URL = "platform:/plugin/org.osate.reqtrace/requirements.rptdesign"
	
	@Test
	def void testRequirementsReport() {
		val pkg1FileName = "pkg1.aadl"
		val systemRequirements1FileName = "systemRequirements1.reqspec"
		val document1FileName = "document1.reqdoc"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system sys1
				end sys1;
			end pkg1;
		''', systemRequirements1FileName -> '''
			system requirements systemRequirements1 for pkg1::sys1 [
				requirement req1 [
				]
			]
		''', document1FileName -> '''
			document document1 [
				requirement req2 [
				]
			]
		''')
		suppressSerialization
		assertReport(REQUIREMENTS_RPTDESIGN_URL, expectedClassifier, newHashMap(
			"selectedObject" -> (testFile(pkg1FileName).resource.contents.head as AadlPackage).publicSection.ownedClassifiers.head,
			"selectionType" -> "Classifier"
		))
		assertReport(REQUIREMENTS_RPTDESIGN_URL, expectedReqspec, newHashMap(
			"ProjectName" -> projectName,
			"Directories" -> "",
			"FileName" -> systemRequirements1FileName,
			"selectedObject" -> '''/«projectName»/«systemRequirements1FileName»''',
			"selectionType" -> "reqspec"
		))
		assertReport(REQUIREMENTS_RPTDESIGN_URL, expectedReqdoc, newHashMap(
			"ProjectName" -> projectName,
			"Directories" -> "",
			"FileName" -> document1FileName,
			"selectedObject" -> '''/«projectName»/«document1FileName»''',
			"selectionType" -> "reqdoc"
		))
	}
	
	val expectedClassifier = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_13 { height: 0.292in;}
							.style_8 { border-bottom: medium solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { width: 7.927in;}
							.style_7 { margin-top: auto; border: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: 1px solid black;}
							.style_12 { font-style: italic;}
							.style_11 { height: 0.594in;}
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
								<div class="style_2" id="" style=" text-align:center;">System Requirements Report</div>
								<table class="style_6" style="border-collapse: collapse; empty-cells: show; width: 7.927in; overflow:hidden; table-layout:fixed;" id="">
									<col style=" width: 0.865in;"></col>
									<col style=" width: 7.062in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Classifier:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">pkg1::sys1</div>
										</td>
									</tr>
								</table>
								<table class="style_7" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_2">
									<col></col>
									<tr class="style_8" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Requirements</div>
										</th>
									</tr>
									<tr class="style_10" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_11" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_12">systemRequirements1.req1</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>
															<div style="visibility:hidden">&#xa0;</div>
														</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
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
	
	val expectedReqspec = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_13 { height: 0.292in;}
							.style_8 { border-bottom: medium solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { width: 7.927in;}
							.style_7 { margin-top: auto; border: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: 1px solid black;}
							.style_12 { font-style: italic;}
							.style_11 { height: 0.594in;}
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
								<div class="style_2" id="" style=" text-align:center;">System Requirements Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">RequirementsReportTest</div>
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
											<div class="style_5">systemRequirements1.reqspec</div>
										</td>
									</tr>
								</table>
								<table class="style_7" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_2">
									<col></col>
									<tr class="style_8" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Requirements</div>
										</th>
									</tr>
									<tr class="style_10" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_11" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_12">systemRequirements1.req1</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>
															<div style="visibility:hidden">&#xa0;</div>
														</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
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
	
	val expectedReqdoc = '''
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
					<style type="text/css">
							.style_13 { height: 0.292in;}
							.style_8 { border-bottom: medium solid black;}
							.style_9 { font-weight: bold; font-size: 12pt;}
							.style_6 { width: 7.927in;}
							.style_7 { margin-top: auto; border: medium solid black;}
							.style_0 { font-family: serif; font-style: normal; font-variant: normal; font-weight: normal; font-size: 10pt; color: black; text-indent: 0em; letter-spacing: normal; word-spacing: normal; text-transform: none; white-space: normal; line-height: normal;}
							.style_10 { border-top: 1px solid black;}
							.style_12 { font-style: italic;}
							.style_11 { height: 0.594in;}
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
								<div class="style_2" id="" style=" text-align:center;">System Requirements Report</div>
								<table class="style_3" style="border-collapse: collapse; empty-cells: show; width: 7.931in; overflow:hidden; table-layout:fixed;" id="__bookmark_1">
									<col style=" width: 0.556in;"></col>
									<col style=" width: 7.375in;"></col>
									<tr valign="top" align="left">
										<td style=" overflow:hidden;">
											<div class="style_4" id="">Project:</div>
										</td>
										<td style=" overflow:hidden;">
											<div class="style_5">RequirementsReportTest</div>
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
											<div class="style_5">document1.reqdoc</div>
										</td>
									</tr>
								</table>
								<table class="style_7" style="border-collapse: collapse; empty-cells: show; width: 100%; overflow:hidden; table-layout:fixed;" id="__bookmark_2">
									<col></col>
									<tr class="style_8" valign="top" align="center">
										<th style=" overflow:hidden;font-weight: normal; border-bottom: medium solid black;">
											<div class="style_9" id="">Requirements</div>
										</th>
									</tr>
									<tr class="style_10" valign="top" align="left">
										<td style=" overflow:hidden; border-top: 1px solid black;">
											<table class="style_11" style="border-collapse: collapse; empty-cells: show; height: 0.594in; width: 100%; overflow:hidden; table-layout:fixed;" id="">
												<col></col>
												<tr valign="top" align="left">
													<td style=" overflow:hidden;">
														<div class="style_12">document1.req2</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
													<td style=" overflow:hidden;">
														<div>
															<div style="visibility:hidden">&#xa0;</div>
														</div>
													</td>
												</tr>
												<tr class="style_13" style=" height: 0.292in;" valign="top" align="left">
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
}