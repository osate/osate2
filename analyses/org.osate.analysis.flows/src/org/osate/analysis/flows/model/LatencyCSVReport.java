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
package org.osate.analysis.flows.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

public class LatencyCSVReport {

	private static StringBuffer getReportContent(AnalysisResult ar) {
		StringBuffer report = new StringBuffer();

		String reportheader = "Latency analysis with preference settings: "
				+ FlowLatencyUtil.getParametersAsDescriptions(ar);

		report.append(reportheader + System.lineSeparator() + System.lineSeparator());
		for (Result result : ar.getResults()) {
			String flowname = ((InstanceObject) result.getModelElement()).getComponentInstancePath();
			SystemInstance si = ((InstanceObject) result.getModelElement()).getSystemInstance();
			String systemName = si.getComponentClassifier().getName();
			String inMode = ResultUtil.getString(result, 0);
			String analysisheader = "Latency results for end-to-end flow '" + flowname + "' of system '" + systemName
					+ "'"
					+ inMode;
			report.append(analysisheader + System.lineSeparator() + System.lineSeparator());
			report.append("Result,Min Specified,Min Actual,Min Method,Max Specified,Max Actual,Max Method,Comments"
					+ System.lineSeparator());
			for (Result contributor : result.getSubResults()) {
				for (Result subc : contributor.getSubResults()) {
					addContributor(report, subc, true);
				}
				addContributor(report, contributor, false);
			}
			report.append("Latency Total," + ResultUtil.getReal(result, 3) + "ms," + ResultUtil.getReal(result, 1)
					+ "ms,," + ResultUtil.getReal(result, 4) + "ms," + ResultUtil.getReal(result, 2) + "ms"
					+ System.lineSeparator());
			report.append("Specified End To End Latency,," + ResultUtil.getReal(result, 5) + "ms,,,"
					+ ResultUtil.getReal(result, 6) + "ms" + System.lineSeparator());
			report.append("End to end Latency Summary" + System.lineSeparator());
			for (Diagnostic dia : result.getDiagnostics()) {
				report.append(dia.getDiagnosticType() + "," + dia.getMessage() + System.lineSeparator());
			}
			report.append(System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
		}
		return report;
	}

	private static void addContributor(StringBuffer report, Result contributor, boolean subcontributor) {
		String comp = FlowLatencyUtil.getContributorType(contributor.getModelElement()) + " "
				+ FlowLatencyUtil.getFullComponentContributorName((contributor.getModelElement()));
		if (subcontributor) {
			comp = "(" + comp + ")";
		}
		report.append(comp + "," + ResultUtil.getReal(contributor, 2) + "ms," + ResultUtil.getReal(contributor, 0)
				+ "ms," + ResultUtil.getString(contributor, 4) + "," + ResultUtil.getReal(contributor, 3) + "ms,"
				+ ResultUtil.getReal(contributor, 1) + "ms," + ResultUtil.getString(contributor, 5));
		for (Diagnostic dia : contributor.getDiagnostics()) {
			report.append("," + dia.getMessage());
		}
		report.append(System.lineSeparator());
	}

	public static void generateCSVReport(AnalysisResult latres) {
		IFile file;
		InputStream input;
		StringBuffer reportContent;

		reportContent = getReportContent(latres);
		file = getCSVFile(latres);
		input = new ByteArrayInputStream(reportContent.toString().getBytes());
		try {
			if (file.exists()) {
				file.setContents(input, true, true, null);
			} else {
				AadlUtil.makeSureFoldersExist(file.getFullPath());
				file.create(input, true, null);
			}
		} catch (final CoreException e) {
		}
	}

	public static IFile getCSVFile(AnalysisResult ar) {
		URI arURI = ar.eResource().getURI();
		URI csvURI = arURI.trimFileExtension().appendFileExtension("csv");
		return OsateResourceUtil.toIFile(csvURI);
	}

}
