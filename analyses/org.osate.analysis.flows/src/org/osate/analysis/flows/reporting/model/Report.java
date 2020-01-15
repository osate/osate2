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

import org.osate.aadl2.NamedElement;

/**
 * The Report class represent a generic Report. It
 * can be a text report or a table report.
 * A table report contains several sections
 * with several lines, each one representing
 * a section of the table.
 * A text report contains raw text, such as a text
 * file.
 * 
 * @author julien
 *
 */
public class Report {
	private List<Section> sections;
	private StringBuffer textContent;
	private ReportType type;
	private NamedElement relatedObject;
	private String reportFolder;
	private String reportPostfix;

	public enum ReportType {
		TABLE, TEXT
	}

	public Report(NamedElement ne, String reportFolder, String reportPostfix, ReportType rt) {
		this.type = rt;
		this.relatedObject = ne;
		this.textContent = new StringBuffer();
		this.sections = new ArrayList<Section>();
		this.reportFolder = reportFolder;
		this.reportPostfix = reportPostfix;
	}

	public void addSection(Section s) {
		this.sections.add(s);
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setTextContent(String s) {
		this.textContent = new StringBuffer(s);
	}

	public void appendTextContent(String s) {
		this.textContent.append(s);
	}

	public String getTextContent() {
		return this.textContent.toString();
	}

	public NamedElement getRelatedObject() {
		return this.relatedObject;
	}

	public String getReportFolder() {
		return this.reportFolder;
	}

	public String getReportPostfix() {
		return this.reportPostfix;
	}

}
