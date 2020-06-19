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
package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;

public class Line {
	private List<ReportedCell> content;
	private ReportSeverity type;

	public Line() {
		this.content = new ArrayList<ReportedCell>();
		this.type = ReportSeverity.INFO;
	}

	public void setSeverity(ReportSeverity t) {
		this.type = t;
	}

	public ReportSeverity getSeverity() {
		return this.type;
	}

	public void addContent(String s) {
		this.content.add(new ReportedCell(s));
	}

	public void addInfo(String s) {
		this.content.add(new ReportedCell(DiagnosticType.INFO, s));
	}

	public void addWarning(String s) {
		this.content.add(new ReportedCell(DiagnosticType.WARNING, s));
	}

	public void addError(String s) {
		this.content.add(new ReportedCell(DiagnosticType.ERROR, s));
	}

	public void addHeaderContent(String s) {
		this.content.add(new ReportedCell(DiagnosticType.TBD, s));
	}

	public void addCell(ReportedCell cell) {
		this.content.add(cell);
	}

	public void addCells(List<Diagnostic> cells) {
		for (Diagnostic resultIssue : cells) {
			this.content.add(new ReportedCell(resultIssue.getDiagnosticType(), resultIssue.getMessage()));
		}
	}

	public List<ReportedCell> getContent() {
		return this.content;
	}

}
