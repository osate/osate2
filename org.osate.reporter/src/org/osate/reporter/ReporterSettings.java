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

import java.io.Serializable;
import java.util.HashSet;

/**
 * Each instance of this class contains user preferences as to how the report generator
 * should group, sort, and filter markers.  It also specifies what should be displayed in the summary.
 * Objects of this class are instanciated by an int array, a boolean array, and a HashSet of Strings.
 *
 * <p>The int array should consist of 6 elements specifying the grouping and sorting prefferences.
 * When filling the array use the constants <code>GROUP_BY_FIELD</code>, <code>SORT_GROUPS_BY_FIELD</code>, <code>SORT_MARKERS_BY_FIRST</code>,
 * <code>SORT_MARKERS_BY_SECOND</code>, <code>SORT_MARKERS_BY_THIRD</code>, and <code>SORT_MARKERS_BY_FOURTH</code> to specify the cell of the
 * array and set it with one of the constants <code>DEFAULT</code>, <code>GROUP_BY_FILE</code>, <code>GROUP_BY_TYPE</code>, <code>SORT_BY_SEVERITY</code>,
 * <code>SORT_BY_MESSAGE</code>, <code>SORT_BY_LOCATION</code>, <code>SORT_BY_MARKER_TYPE</code>, <code>SORT_BY_FILE_NAME</code>, <code>SORT_BY_FILE_TYPE</code>.
 *
 * <p>The boolean array should consist of 7 elements specifying what should be shown in the summary.
 * When filling the array use the constants <code>SHOW_SEVERITY_FIELD</code>, <code>SHOW_NUM_OF_TEXT_AND_OBJECT_FILES</code>,
 * <code>SHOW_NUM_OF_FILES</code>, <code>SHOW_NUM_OF_TYPES</code>, <code>SHOW_NUM_OF_MARKERS_PER_FILES</code>, <code>SHOW_NUM_OF_MARKERS_PER_TYPE</code>,
 * and <code>SHOW_TOTAL_NUM_OF_MARKERS</code> to specify the cell of the array and set it with true or false
 * depending on whether you want to show the specific element in the summary.
 *
 * The HashSet should contain all the problem marker types that are to be excluded from the report.  The marker types are to be specified by
 * their unique identifier.  For example: to exclude the Java Problem Marker, include in the set the String "org.eclipse.jdt.core.marker".
 * To display all marker types in the report, pass null to the constructor instead of a HashSet.
 *
 * <p>The class is Serializable so that it can be saved to disk by <code>ReporterSettingsFrame</code> and read by
 * <code>{@link org.osate.reporter.Reporter Reporter}</code>.
 *
 * @author Joe Seibel
 */
public class ReporterSettings implements Serializable {
	/**
	 * Unspecified grouping or no sorting.  Used as a value for any of the cells in the int array.  The default
	 * for <code>GROUP_BY_FIELD</code> is <code>GROUP_BY_FILES</code>.
	 */
	public static final int DEFAULT = 0;
	/**
	 * Specifies to group each marker by the file it is from.  Used as a value for the <code>GROUP_BY_FIELD</code> cell in
	 * the int array.
	 */
	public static final int GROUP_BY_FILE = 1;
	/**
	 * Specifies to group each marker by its marker type.  Used as a value for the <code>GROUP_BY_FIELD</code> cell in the
	 * int array.
	 */
	public static final int GROUP_BY_TYPE = 2;
	/**
	 * Specifies to sort the markers in each group by severity.  Used as a value for <code>SORT_MARKERS_BY_FIRST</code> through
	 * <code>SORT_MARKERS_BY_FOURTH</code> cells in the int array.
	 */
	public static final int SORT_BY_SEVERITY = 3;
	/**
	 * Specifies to sort the markers in each group by message.  Used as a value for <code>SORT_MARKERS_BY_FIRST</code> through
	 * <code>SORT_MARKERS_BY_FOURTH</code> cells in the int array.
	 */
	public static final int SORT_BY_MESSAGE = 4;
	/**
	 * Specifies to sort the markers in each group by location.  Used as a value for <code>SORT_MARKERS_BY_FIRST</code> through
	 * <code>SORT_MARKERS_BY_FOURTH</code> cells in the int array.
	 */
	public static final int SORT_BY_LOCATION = 5;
	/**
	 * Specifies to sort the markers in each group by marker type.  Used as a value for <code>SORT_MARKERS_BY_FIRST</code> through
	 * <code>SORT_MARKERS_BY_FOURTH</code> cell in the int array.  This value should only be used when grouping markers by file.
	 */
	public static final int SORT_BY_MARKER_TYPE = 6;
	/**
	 * Specifies to sort the groups of markers or the markers in each group by the file that the marker is assosiated with.
	 * Used as a value for <code>SORT_GROUPS_BY_FIELD</code> when grouping by file.  Also used as a value for <code>SORT_MARKERS_BY_FIRST</code>
	 * through <code>SORT_MARKERS_BY_FOURTH</code> when grouping by marker type.
	 */
	public static final int SORT_BY_FILE_NAME = 7;
	/**
	 * Specifies to sort the groups of markers by file type(.aadl or .aaxl).  Used as a value for <code>SORT_GROUPS_BY_FIELD</code>
	 * when grouping by file.
	 */
	public static final int SORT_BY_FILE_TYPE = 8;

	/**
	 * Specifies the cell in the int array that controls whether markers are to be grouped by file or marker type.
	 * Set this cell with <code>GROUP_BY_FILE</code> or <code>GROUP_BY_TYPE</code>.
	 */
	public static final int GROUP_BY_FIELD = 0;
	/**
	 * Specifies the cell in the int array that controls how groups are to be sorted.  When grouping by file, use
	 * <code>SORT_BY_FILE_NAME</code> or <code>SORT_BY_FILE_TYPE</code>.  When grouping by marker type, the value of this cell has no affect.
	 */
	public static final int SORT_GROUPS_BY_FIELD = 1;
	/**
	 * Specifies the cell in the int array that controls how markers are to be sorted. Set this cell with <code>DEFAULT</code>,
	 * <code>SORT_BY_SEVERITY</code>, <code>SORT_BY_MESSAGE</code>, and <code>SORT_BY_LOCATION</code>.  When grouping by file, <code>SORT_BY_MARKER_TYPE</code> can be
	 * used and when grouping by marker type, <code>SORT_BY_FILE_NAME</code> can be used.
	 */
	public static final int SORT_MARKERS_BY_FIRST = 2;
	/**
	 * Specifies the cell in the int array that controls how markers are to be sorted. Set this cell with <code>DEFAULT</code>,
	 * <code>SORT_BY_SEVERITY</code>, <code>SORT_BY_MESSAGE</code>, and <code>SORT_BY_LOCATION</code>.  When grouping by file, <code>SORT_BY_MARKER_TYPE</code> can be
	 * used and when grouping by marker type, <code>SORT_BY_FILE_NAME</code> can be used.
	 */
	public static final int SORT_MARKERS_BY_SECOND = 3;
	/**
	 * Specifies the cell in the int array that controls how markers are to be sorted. Set this cell with <code>DEFAULT</code>,
	 * <code>SORT_BY_SEVERITY</code>, <code>SORT_BY_MESSAGE</code>, and <code>SORT_BY_LOCATION</code>.  When grouping by file, <code>SORT_BY_MARKER_TYPE</code> can be
	 * used and when grouping by marker type, <code>SORT_BY_FILE_NAME</code> can be used.
	 */
	public static final int SORT_MARKERS_BY_THIRD = 4;
	/**
	 * Specifies the cell in the int array that controls how markers are to be sorted. Set this cell with <code>DEFAULT</code>,
	 * <code>SORT_BY_SEVERITY</code>, <code>SORT_BY_MESSAGE</code>, and <code>SORT_BY_LOCATION</code>.  When grouping by file, <code>SORT_BY_MARKER_TYPE</code> can be
	 * used and when grouping by marker type, <code>SORT_BY_FILE_NAME</code> can be used.
	 */
	public static final int SORT_MARKERS_BY_FOURTH = 5;

	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the total number of errors,
	 * warinings, and info.
	 */
	public static final int SHOW_SEVERITY_FIELD = 0;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the total number of aadl files
	 * and the total number of aaxl files.
	 */
	public static final int SHOW_NUM_OF_TEXT_AND_OBJECT_FILES = 1;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the total number of files.
	 */
	public static final int SHOW_NUM_OF_FILES = 2;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the total number of marker types.
	 */
	public static final int SHOW_NUM_OF_TYPES = 3;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the number of markers for each
	 * individual file.
	 */
	public static final int SHOW_NUM_OF_MARKERS_PER_FILES = 4;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the number of markers for each
	 * marker type.
	 */
	public static final int SHOW_NUM_OF_MARKERS_PER_TYPE = 5;
	/**
	 * Specifies the cell in the boolean array that controls whether or not to display the total number of markers in
	 * the report.
	 */
	public static final int SHOW_TOTAL_NUM_OF_MARKERS = 6;

	/*
	 * 0: groupBy
	 * 1: sortGroupsBy
	 * 2: sortMarkersByFirst
	 * 3: sortMarkersBySecond
	 * 4: sortMarkersByThird
	 * 5: sortMarkersByFourth
	 */
	private int[] groupByAndSortBy = new int[] { GROUP_BY_FILE, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT };

	/*
	 * 0: severity
	 * 1: numOfTextAndObjectFiles
	 * 2: numOfFiles
	 * 3: numOfTypes
	 * 4: numOfMarkersPerFile
	 * 5: numOfMarkersPerType
	 * 6: totalMarkers
	 */
	private boolean[] showInSummary = new boolean[] { true, true, true, true, true, true, true };

	// HashSet of String. Contains the unique identifiers of the problem markers to exclude
	// in the report.
	private HashSet problemMarkersToExclude = new HashSet();

	/**
	 * Creates a new <code>ReporterSettings</code> object with the default settings.
	 *
	 */
	public ReporterSettings() {
	}

	/**
	 * Creates a new <code>ReporterSettings</code> object with custom settings specified by the two arrays and the HashSet.
	 *
	 * @param groupByAndSortBy 6 elements specifying how the markers should be grouped by, how the
	 * groups should be sorted, and how the markers should be sorted.
	 * @param showInSummary 7 elements specifying what should be shown in the report's summary.
	 * @param problemMarkersToExclude Set of Strings.  Unique identifiers of the problem markers to exclude in the report.
	 * For example: to exclude the Java Problem, include the String "org.eclipse.jdt.core.problem" in the set.
	 * To include all problem markers in the report, pass null to this constructor.
	 *
	 */
	public ReporterSettings(int[] groupByAndSortBy, boolean[] showInSummary, HashSet problemMarkersToExclude) {
		for (int i = 0; i < Math.min(groupByAndSortBy.length, this.groupByAndSortBy.length); i++) {
			this.groupByAndSortBy[i] = groupByAndSortBy[i];
		}
		for (int i = 0; i < Math.min(showInSummary.length, this.showInSummary.length); i++) {
			this.showInSummary[i] = showInSummary[i];
		}
		if (this.groupByAndSortBy[0] == DEFAULT) {
			this.groupByAndSortBy[0] = GROUP_BY_FILE;
		}
		this.problemMarkersToExclude = problemMarkersToExclude;
	}

	/**
	 * Gets the grouping or sorting setting for the field specified.
	 *
	 * @param field Specifies the element in the int array.  Use <code>GROUP_BY_FIELD</code>, <code>SORT_GROUPS_BY_FIELD</code>,
	 * <code>SORT_MARKERS_BY_FIRST</code>, <code>SORT_MARKERS_BY_SECOND</code>, <code>SORT_MARKERS_BY_THIRD</code>, or <code>SORT_MARKERS_BY_FOURTH</code>.
	 * @return The grouping or sorting settings specified by the field.  The value returned will be <code>DEFAULT</code>,
	 * <code>GROUP_BY_FILE</code>, <code>GROUP_BY_TYPE</code>, <code>SORT_BY_SEVERITY</code>, <code>SORT_BY_MESSAGE</code>, <code>SORT_BY_LOCATION</code>, <code>SORT_BY_MARKER_TYPE</code>,
	 * <code>SORT_BY_FILE_NAME</code>, or <code>SORT_BY_FILE_TYPE</code>.
	 */
	public int getGroupByAndSortBy(int field) {
		return groupByAndSortBy[field];
	}

	/**
	 * Gets the summary setting for the field specified.
	 *
	 * @param field Specifies the element in the boolean array.  Use <code>SHOW_SEVERITY_FIELD</code>, <code>SHOW_NUM_OF_TEXT_AND_OBJECT_FILES</code>,
	 * <code>SHOW_NUM_OF_FILES</code>, <code>SHOW_NUM_OF_TYPES</code>, <code>SHOW_NUM_OF_MARKERS_PER_FILES</code>, <code>SHOW_NUM_OF_MARKERS_PER_TYPE</code>, or
	 * <code>SHOW_TOTAL_NUM_OF_MARKERS</code>.
	 * @return true if the specified field is to be shown in the summary.
	 */
	public boolean getShowInSummary(int field) {
		return showInSummary[field];
	}

	/**
	 * Determines whether or not to show a summary  by searching for true elements in the boolean array.
	 *
	 * @return true is a summary to be shown.
	 */
	public boolean showSummary() {
		for (int i = 0; i < showInSummary.length; i++) {
			if (showInSummary[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets all the unique identifiers of problem markers to exclude from the report.
	 * If null is returned, all problem markers are to be displayed.
	 *
	 * @return HashSet of Strings of unique identifiers.
	 */
	public HashSet getProblemMarkersToExclude() {
		return problemMarkersToExclude;
	}
}