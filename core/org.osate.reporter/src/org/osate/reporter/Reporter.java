/**
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.osate.aadl2.modelsupport.AadlConstants;

/**
 * Class contains static methods to generate a Problem Marker report.
 *
 * @author Joe Seibel
 */
public class Reporter {

	// Reporter is non-instantiable.
	private Reporter() {
	}

	/**
	 * Creates a Problem Marker report.  The report is based on the settings in the project's .reporterSettings file
	 * and contains Problem Markers assosiated with <code>IResource toReport</code>.  The report is sent to an HTML
	 * file specified by the user.
	 *
	 * @param toReport Used to retreive all assosiated Problem Markers and the current project.
	 * @param workbenchWindow Used to retrieve the shell which is used for displaying dialog boxes.
	 * @throws CoreException If this method fails. Reasons include:
	 * <ul>
	 * <li> This marker does not exist.</li>
	 * </ul>
	 */
	public static void report(IResource toReport, IWorkbenchWindow workbenchWindow) throws CoreException {
		try {
			String output = getHTMLText(toReport);
			File reportFile = getReportFile(toReport, workbenchWindow);
			if (reportFile != null) {
				try {
					FileWriter writer = new FileWriter(reportFile);
					writer.write(output);
					writer.close();
					toReport.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (IOException e) {
					MessageDialog.openError(null, "Output Error", e.getMessage());
				}
			}
		} catch (NoMarkersException e) {
			MessageDialog.openError(null, "Selection Error", e.getMessage());
		}
	}

	// Propmpts the user for a java.io.File to store the report.
	private static File getReportFile(IResource toReport, IWorkbenchWindow workbenchWindow) {
		FileDialog saveDialog = new FileDialog(workbenchWindow.getShell(), SWT.SAVE);
		saveDialog.setText("Save Report For \"" + toReport.getName() + "\" As");
		saveDialog.setFilterExtensions(new String[] { "*.html; *.htm", "*.*" });
		String fileString = null;
		do {
			fileString = saveDialog.open();
		} while (fileString != null && new File(fileString).exists() && !MessageDialog.openQuestion(null, "Save As",
				fileString + " already exists.\nDo you want to replace it?"));
		if (fileString != null && fileString.endsWith(".aadl")) {
			fileString += ".html";
		}
		return (fileString != null) ? new File(fileString) : null;
	}

	// Generates complete HTML text of a marker report. The report contains all the markers associated
	// with IResource toReport. The format of the report is specified by the .reporterSettings file
	// within the project associated with toReport.
	private static String getHTMLText(IResource toReport) throws CoreException, NoMarkersException {
		ReporterSettings settings = getSettings(toReport.getProject());
		SummaryTotals totals = new SummaryTotals(settings);
		IMarker[] markers = getProblemMarkers(toReport, settings);
		StringBuffer output = new StringBuffer("<html>\n" + "<head>\n" + "	<title>AADL Markers</title>\n" + "</head>\n"
				+ "<body>\n" + "<h1>AADL Markers For " + toReport.getName() + "</h1>\n" + "Report generated on "
				+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)
						.format(Calendar.getInstance().getTime())
				+ "<br>\n" + "<br>\n" + "<br>\n" + "<br>\n");
		String groupIdentifier = getGroupIdentifier(markers[0], settings);
		int groupStart = 0;
		for (int i = 1; i < markers.length; i++) {
			if (!getGroupIdentifier(markers[i], settings).equals(groupIdentifier)) {
				output.append(generateTable(markers, groupStart, i - 1, settings, totals));
				groupIdentifier = getGroupIdentifier(markers[i], settings);
				groupStart = i;
			}
		}
		output.append(generateTable(markers, groupStart, markers.length - 1, settings, totals));
		totals.setTotalMarkers(markers.length);
		if (settings.showSummary()) {
			output.append("<h2>Summary of " + toReport.getName() + "</h2>" + totals.getTotalsTable());
		}
		output.append("</body>\n" + "</html>\n");
		return output.toString();
	}

	// If there is a .reporterSettings file associated with the IProject project, then those settings
	// are read into a ReporterSettings object and returned. Otherwise a ReporterSettings object is
	// created with default values.
	private static ReporterSettings getSettings(IProject project) {
		ReporterSettings settings = null;
		File settingsFile = new File(project.getLocation().toOSString() + File.separator + ".reporterSettings");
		if (settingsFile.exists()) {
			try {
				FileInputStream fin = new FileInputStream(settingsFile);
				ObjectInputStream oin = new ObjectInputStream(fin);
				settings = (ReporterSettings) oin.readObject();
				oin.close();
				fin.close();
			} catch (Exception e) {
				settings = new ReporterSettings();
			}
		} else {
			settings = new ReporterSettings();
		}
		return settings;
	}

	// Returns an HTML table containing a list of Problem Markers from markers[groupStart] to markers[groupEnd].
	// The HTML table is formatted based on the ReporterSettings object. Each marker is also used to increment
	// the values of the SummaryTotals objecct.
	private static StringBuffer generateTable(IMarker[] markers, int groupStart, int groupEnd,
			ReporterSettings settings, SummaryTotals totals) throws CoreException {
		StringBuffer output = new StringBuffer("<h2>");
		if (settings.getGroupByAndSortBy(ReporterSettings.GROUP_BY_FIELD) == ReporterSettings.GROUP_BY_FILE) {
			output.append("Markers for ");
		}
		output.append(getGroupIdentifier(markers[groupStart], settings) + "</h2>\n");
		String[][] markersTable;
		int severityColumn = 0;
		int messageColumn = 2;
		int locationColumn = 3;
		int fileNameColumn = -1;
		int markerTypeColumn = -1;
		if (settings.getGroupByAndSortBy(ReporterSettings.GROUP_BY_FIELD) == ReporterSettings.GROUP_BY_TYPE) {
			fileNameColumn = 0;
			severityColumn++;
		} else {
			markerTypeColumn = 1;
		}
		markersTable = new String[groupEnd - groupStart + 2][4];
		markersTable[0][severityColumn] = "Severity";
		markersTable[0][messageColumn] = "Message";
		markersTable[0][locationColumn] = "Location";
		if (fileNameColumn != -1) {
			markersTable[0][fileNameColumn] = "File Name";
		} else {
			markersTable[0][markerTypeColumn] = "Type";
		}
		int destinationIndex = 1;
		for (int sourceIndex = groupStart; sourceIndex <= groupEnd; sourceIndex++) {
			totals.countFileNameAndMarkerType(markers[sourceIndex]);
			switch (((Integer) (markers[sourceIndex]).getAttribute(IMarker.SEVERITY)).intValue()) {
			case IMarker.SEVERITY_ERROR:
				markersTable[destinationIndex][severityColumn] = "Error";
				totals.addError();
				break;
			case IMarker.SEVERITY_INFO:
				markersTable[destinationIndex][severityColumn] = "Info";
				totals.addInfo();
				break;
			case IMarker.SEVERITY_WARNING:
				markersTable[destinationIndex][severityColumn] = "Warning";
				totals.addWarning();
				break;
			}
			markersTable[destinationIndex][messageColumn] = markers[sourceIndex].getAttribute(IMarker.MESSAGE)
					.toString();
			if (markers[sourceIndex].getResource().getName().endsWith(".aaxl")) {
				markersTable[destinationIndex][locationColumn] = formatObjectLocation(markers[sourceIndex]);
			} else if (markers[sourceIndex].getAttribute(IMarker.LINE_NUMBER) != null) {
				markersTable[destinationIndex][locationColumn] = "Line: "
						+ markers[sourceIndex].getAttribute(IMarker.LINE_NUMBER);
			}
			if (markerTypeColumn != -1) {
				markersTable[destinationIndex][markerTypeColumn] = markers[sourceIndex].getType()
						.substring(markers[sourceIndex].getType().lastIndexOf('.') + 1);
			} else {
				markersTable[destinationIndex][fileNameColumn] = markers[sourceIndex].getResource().getName();
			}
			destinationIndex++;
		}
		output.append(getHTMLTable(markersTable) + "<br>\n" + "<br>\n" + "<br>\n" + "<br>\n" + "<br>\n" + "<br>\n");
		return output;
	}

	// Generates an HTML table from the 2-D String array toPrint.
	private static StringBuffer getHTMLTable(String[][] toPrint) {
		StringBuffer output = new StringBuffer("<table style=\"text-align: left; width: 900px;\" border=\"1\"\n"
				+ "cellpadding=\"2\" cellspacing=\"2\"\n" + "	<tbody>\n" + "		<tr>\n");
		for (int column = 0; column < toPrint[0].length; column++) {
			output.append("			<td style=\"vertical-align: top;\">\n" + "			<h3>" + toPrint[0][column]
					+ "</h3>\n" + "			</td>\n");
		}
		output.append("		</tr>\n");
		for (int row = 1; row < toPrint.length; row++) {
			output.append("		<tr>\n");
			for (int column = 0; column < toPrint[row].length; column++) {
				output.append("			<td style=\"vertical-align: top;\">" + toPrint[row][column] + "<br>\n"
						+ "			</td>\n");
			}
			output.append("		</tr>\n");
		}
		output.append("	</tbody>\n" + "</table>\n");
		return output;
	}

	// Retreives all Problem Markers associated with the IResource markersSource. The markers
	// are sorted based on the grouping and sorting prefferences in the ReporterSettings settings and returned as
	// an array.
	private static IMarker[] getProblemMarkers(IResource markersSource, ReporterSettings settings)
			throws CoreException, NoMarkersException {
		IMarker[] markersArray = markersSource.findMarkers("org.eclipse.core.resources.problemmarker", true,
				IResource.DEPTH_INFINITE);
		if (markersArray.length == 0) {
			throw new NoMarkersException(markersSource.getName() + " does not contain any problem markers to report.");
		}
		ArrayList<IMarker> markers = new ArrayList<IMarker>();
		if (settings.getProblemMarkersToExclude() == null) {
			for (int i = 0; i < markersArray.length; i++) {
				markers.add(markersArray[i]);
			}
		} else {
			for (int i = 0; i < markersArray.length; i++) {
				if (!settings.getProblemMarkersToExclude().contains(markersArray[i].getType())) {
					markers.add(markersArray[i]);
				}
			}
		}
		if (markers.isEmpty()) {
			throw new NoMarkersException(
					markersSource.getName() + " does not contain any problem markers enabled from the filter.");
		}
		Collections.sort(markers, new AadlMarkerComparator(settings));
		return markers.toArray(new IMarker[0]);
	}

	// Gets the URI from toFormat and presents it in a clean appearance.
	private static String formatObjectLocation(IMarker toFormat) throws CoreException {
		String location = toFormat.getAttribute(AadlConstants.AADLURI).toString();
		int poundPosition = location.indexOf('#');
		if (poundPosition + 2 == location.length()) {
			location = "";
		} else {
			location = location.substring(poundPosition + 3);
			location = location.replaceAll("\\x5b@name=", ": ");
			location = location.replaceAll("]", "  ");
			location = location.replaceAll("/", "->");
		}
		return location;
	}

	// If settings specify to group by file, returns the file name from marker.
	// If settings specify to group by marker type, returns the marker's type.
	private static String getGroupIdentifier(IMarker marker, ReporterSettings settings) throws CoreException {
		if (settings.getGroupByAndSortBy(ReporterSettings.GROUP_BY_FIELD) == ReporterSettings.GROUP_BY_FILE) {
			return marker.getResource().getName();
		} else {
			return marker.getType().substring(marker.getType().lastIndexOf('.') + 1);
		}
	}

	// Holds the total number of errors, warnings, info, files, etc. The totals that are recorded
	// are specified by a ReporterSettings object. Use the method getTotalsTable to generate the
	// summary in HTML form.
	private static class SummaryTotals {
		// errorCount, warningCount, and infoCount will be set to 0 if severity is to be counted.
		private int errorCount = -1;
		private int warningCount = -1;
		private int infoCount = -1;
		// These booleans will be set to true depending on the ReporterSettings object sent to
		// the constructor.
		private boolean showNumOfTextAndObjectFiles = false;
		private boolean showNumOfFiles = false;
		private boolean showNumOfMarkerTypes = false;
		// Instanciated when the ReporterSettings object specifies to count number of markers per file,
		// number of files, or number of text and object files.
		private ArrayList<String> fileNames = null;
		// Only instanciated when the number of markers per files should be counted.
		private ArrayList<Integer> numOfMarkersPerFiles = null;
		// Instanciated when the ReporterSettings object specifies to count the number of markers per
		// marker type or the total number of marker types.
		private ArrayList<String> markerTypes = null;
		// Only instanciated when the number of markers per type should be counted.
		private ArrayList<Integer> numOfMarkersPerTypes = null;
		// Set to 0 if the total number of markers should be counted.
		private int totalMarkers = -1;

		// Sets up which totals are to be counted. After constructing an object, call the methods
		// addError, addWarning, addInfo, countFileNameAndMarkerType, and setTotalMarkers. These
		// methods will take action if the specific total is to be counted, otherwise the methods
		// will do nothing.
		public SummaryTotals(ReporterSettings settings) {
			showNumOfTextAndObjectFiles = settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_TEXT_AND_OBJECT_FILES);
			showNumOfFiles = settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_FILES);
			showNumOfMarkerTypes = settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_TYPES);
			if (settings.getShowInSummary(ReporterSettings.SHOW_SEVERITY_FIELD)) {
				errorCount = warningCount = infoCount = 0;
			}
			if (settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_MARKERS_PER_FILES)) {
				fileNames = new ArrayList<String>();
				numOfMarkersPerFiles = new ArrayList<Integer>();
			} else if (showNumOfFiles || showNumOfTextAndObjectFiles) {
				fileNames = new ArrayList<String>();
			}
			if (settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_MARKERS_PER_TYPE)) {
				markerTypes = new ArrayList<String>();
				numOfMarkersPerTypes = new ArrayList<Integer>();
			} else if (showNumOfMarkerTypes) {
				markerTypes = new ArrayList<String>();
			}
			if (settings.getShowInSummary(ReporterSettings.SHOW_TOTAL_NUM_OF_MARKERS)) {
				totalMarkers = 0;
			}
		}

		// If severity is to be counted, increments the error count.
		public void addError() {
			if (errorCount != -1) {
				errorCount++;
			}
		}

		// If severity is to be counted, increments the warning count.
		public void addWarning() {
			if (warningCount != -1) {
				warningCount++;
			}
		}

		// If severity is to be counted, increments the info count.
		public void addInfo() {
			if (infoCount != -1) {
				infoCount++;
			}
		}

		// Adds to fileNames, numOfMarkersPerFiles, markerTypes, and numOfMarkersPerTypes if those
		// ArrayLists are instanciated.
		public void countFileNameAndMarkerType(IMarker marker) throws CoreException {
			if (fileNames != null) {
				String fileNameAsString = marker.getResource().getName();
				if (!fileNames.contains(fileNameAsString)) {
					fileNames.add(fileNameAsString);
					if (numOfMarkersPerFiles != null) {
						numOfMarkersPerFiles.add(1);
					}
				} else if (numOfMarkersPerFiles != null) {
					int i = fileNames.indexOf(fileNameAsString);
					numOfMarkersPerFiles.set(i, numOfMarkersPerFiles.get(i) + 1);
				}
			}
			if (markerTypes != null) {
				String markerTypeAsString = marker.getType().substring(marker.getType().lastIndexOf('.') + 1);
				if (!markerTypes.contains(markerTypeAsString)) {
					markerTypes.add(markerTypeAsString);
					if (numOfMarkersPerTypes != null) {
						numOfMarkersPerTypes.add(1);
					}
				} else if (numOfMarkersPerTypes != null) {
					int i = markerTypes.indexOf(markerTypeAsString);
					numOfMarkersPerTypes.set(i, numOfMarkersPerTypes.get(i) + 1);
				}
			}
		}

		// If the total number of markers is to be counted, sets the value.
		public void setTotalMarkers(int totalMarkers) {
			if (this.totalMarkers != -1) {
				this.totalMarkers = totalMarkers;
			}
		}

		// Generates a summary in HTML form based on the ReporterSettings object sent to the constructor and calls to
		// addError, addWarning, addInfo, countFileNameAndMarkerType, and setTotalMarkers. If no elements of the summary
		// are to be counted, an empty String is returned.
		public String getTotalsTable() {
			String output = "";
			String[][] totalsTable = new String[2][((errorCount != -1) ? 3 : 0)
					+ ((showNumOfTextAndObjectFiles) ? 2 : 0) + ((showNumOfFiles) ? 1 : 0)
					+ ((showNumOfMarkerTypes) ? 1 : 0) + ((totalMarkers != -1) ? 1 : 0)];
			if (totalsTable[0].length > 0) {
				int i = 0;
				if (errorCount != -1) {
					totalsTable[0][0] = "Errors";
					totalsTable[0][1] = "Warnings";
					totalsTable[0][2] = "Info";
					totalsTable[1][0] = "" + errorCount;
					totalsTable[1][1] = "" + warningCount;
					totalsTable[1][2] = "" + infoCount;
					i = 3;
				}
				if (showNumOfTextAndObjectFiles) {
					totalsTable[0][i] = "Total AADL Files";
					totalsTable[0][i + 1] = "Total AAXL Files";
					int aadlCount = 0;
					int aaxlCount = 0;
					for (int j = 0; j < fileNames.size(); j++) {
						if (fileNames.get(j).endsWith(".aadl")) {
							aadlCount++;
						} else {
							aaxlCount++;
						}
					}
					totalsTable[1][i] = "" + aadlCount;
					totalsTable[1][i + 1] = "" + aaxlCount;
					i += 2;
				}
				if (showNumOfFiles) {
					totalsTable[0][i] = "Number of Files";
					totalsTable[1][i] = "" + fileNames.size();
					i++;
				}
				if (showNumOfMarkerTypes) {
					totalsTable[0][i] = "Number of Marker Types";
					totalsTable[1][i] = "" + markerTypes.size();
					i++;
				}
				if (totalMarkers != -1) {
					totalsTable[0][i] = "Total Markers";
					totalsTable[1][i] = "" + totalMarkers;
				}
				output += getHTMLTable(totalsTable);
			}
			if (numOfMarkersPerFiles != null) {
				output += getNumberOfMarkersPerFileTable();
			}
			if (numOfMarkersPerTypes != null) {
				output += getNumberOfMarkersPerTypeTable();
			}
			return output;
		}

		// Generates an HTML table showing each file name and the number of markers for each file.
		private StringBuffer getNumberOfMarkersPerFileTable() {
			String[][] markersPerFileTable = new String[fileNames.size() + 1][2];
			markersPerFileTable[0][0] = "File Name";
			markersPerFileTable[0][1] = "Number of Markers";
			for (int i = 0; i < fileNames.size(); i++) {
				markersPerFileTable[i + 1][0] = fileNames.get(i);
				markersPerFileTable[i + 1][1] = numOfMarkersPerFiles.get(i).toString();
			}
			return getHTMLTable(markersPerFileTable);
		}

		// Generates an HTML table showing each marker type and the number of markers for each type.
		private StringBuffer getNumberOfMarkersPerTypeTable() {
			String[][] markersPerTypeTable = new String[markerTypes.size() + 1][2];
			markersPerTypeTable[0][0] = "Marker Type";
			markersPerTypeTable[0][1] = "Number of Markers";
			for (int i = 0; i < markerTypes.size(); i++) {
				markersPerTypeTable[i + 1][0] = markerTypes.get(i);
				markersPerTypeTable[i + 1][1] = numOfMarkersPerTypes.get(i).toString();
			}
			return getHTMLTable(markersPerTypeTable);
		}
	}// End of class SummaryTotals.
}// End of class Reporter
