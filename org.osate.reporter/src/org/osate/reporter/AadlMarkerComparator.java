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

import java.util.Comparator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.ui.OsateUiPlugin;

/**
 * Comparator used to compare two <code>IMarkers</code> based on an instance of <code>{@link org.osate.reporter.reporterSettings.ReporterSettings ReporterSettings}</code>
 *
 * @author Joe Seibel
 */
public class AadlMarkerComparator implements Comparator<IMarker> {
	private ReporterSettings settings = null;

	/**
	 * Creates a new <code>AadlMarkerComparator</code> with the specified <code>ReporterSettings</code>.
	 *
	 * @param settings Used to compare two <code>IMarkers</code>.
	 */
	public AadlMarkerComparator(ReporterSettings settings) {
		this.settings = settings;
	}

	/**
	 * Compares two AadlMarkers based on the <code>ReporterSettings</code> that an object of this class
	 * is constructed with.
	 *
	 * @param marker1 The first AadlMarker to be compared.
	 * @param marker2 The second AadlMarker to be compared.
	 * @return a negative integer, zero, or a positive integer as the first marker is less than, equal to, or greater than the second.
	 * @throws CoreException If this method fails. Reasons include:
	 * <ul>
	 * <li> This marker does not exist.</li>
	 * </ul>
	 */
	@Override
	public int compare(IMarker marker1, IMarker marker2) {
		try {
			int compareResult = 0;
			if (settings.getGroupByAndSortBy(ReporterSettings.GROUP_BY_FIELD) == ReporterSettings.GROUP_BY_FILE) {
				if (settings.getGroupByAndSortBy(
						ReporterSettings.SORT_GROUPS_BY_FIELD) == ReporterSettings.SORT_BY_FILE_TYPE) {
					boolean marker1IsAadl = marker1.getResource().getName().endsWith(".aadl");
					boolean marker2IsAadl = marker2.getResource().getName().endsWith(".aadl");
					if (marker1IsAadl != marker2IsAadl) {
						compareResult = (marker1IsAadl) ? -1 : 1;
					}
				}
				if (compareResult == 0) {
					compareResult = marker1.getResource().getName().compareTo(marker2.getResource().getName());
				}
			}
			// group by type
			else {
				compareResult = marker1.getType().compareTo(marker2.getType());
			}
			for (int i = ReporterSettings.SORT_MARKERS_BY_FIRST; (i <= ReporterSettings.SORT_MARKERS_BY_FOURTH)
					&& (compareResult == 0); i++) {
				switch (settings.getGroupByAndSortBy(i)) {
				case ReporterSettings.SORT_BY_SEVERITY:
					int marker1Severity = ((Integer) marker1.getAttribute(IMarker.SEVERITY)).intValue();
					int marker2Severity = ((Integer) marker2.getAttribute(IMarker.SEVERITY)).intValue();
					if (marker1Severity != marker2Severity) {
						compareResult = (marker1Severity > marker2Severity) ? -1 : 1;
					}
					break;
				case ReporterSettings.SORT_BY_MESSAGE:
					compareResult = marker1.getAttribute(IMarker.MESSAGE).toString()
							.compareTo(marker2.getAttribute(IMarker.MESSAGE).toString());
					break;
				case ReporterSettings.SORT_BY_LOCATION:
					String marker1Location = (marker1.getType().endsWith("AadlTextMarker"))
							? marker1.getAttribute(IMarker.LINE_NUMBER).toString()
							: marker1.getAttribute(AadlConstants.AADLURI).toString();
					String marker2Location = (marker2.getType().endsWith("AadlTextMarker"))
							? marker2.getAttribute(IMarker.LINE_NUMBER).toString()
							: marker2.getAttribute(AadlConstants.AADLURI).toString();
					compareResult = marker1Location.compareTo(marker2Location);
					break;
				case ReporterSettings.SORT_BY_FILE_NAME:
					compareResult = marker1.getResource().getName().compareTo(marker2.getResource().getName());
					break;
				case ReporterSettings.SORT_BY_MARKER_TYPE:
					compareResult = marker1.getType().compareTo(marker2.getType());
					break;
				}
			}
			return compareResult;
		} catch (CoreException e) {
			OsateUiPlugin.log(e);
			return 0;
		}
	}
}
