/* Created on Feb 8, 2006
 */
package org.osate.core.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.core.AadlNature;
import org.osate.core.OsateCorePlugin;


/**
 * Not a public class.  Only for use by the aadl builder.  There is only
 * one instance of this class accessed through {@link #getInstance()}.
 * @author aarong
 */
/* Should be package visible only, but changed to public because 
 * Andrew Weaver of Freemont Associates needs to be able to see this class
 * because they are extending the AadlBuilder.
 */
public class FilenameCache {
	private static final String DUPLICATE_WARNING_MESSAGE =
		"Another file with the same name exists in the workspace.  This may cause problems and result in duplicate package/property set definitions.";

	private static final FilenameCache instance = new FilenameCache();
	
	private final Map<String, Set<IFile>> fileMap = new HashMap<String, Set<IFile>>();
	
	
	
	/** Private to enforce singleton pattern */
	private FilenameCache() {
		super();
	}
	
	
	
	public static FilenameCache getInstance() {
		return instance;
	}
	
	/**
	 * Clears the model.  Individual files cannot be removed from the model.
	 * The model can only be cleared and reconstructed.
	 */
	public synchronized void reset() {
		for (final Set<IFile> set : fileMap.values()) {
			set.clear();
		}
	}
	
	private Set<IFile> getFiles(final String fname) {
		Set<IFile> files = fileMap.get(fname);
		if (files == null) {
			files = new HashSet<IFile>();
			fileMap.put(fname, files);
		}
		return files;
	}

	private String getCanonicalFilename(final IFile file) {
		return file.getName().toLowerCase();
	}
	
	public synchronized void addFile(final IFile file) {
		if (AadlNature.hasNature(file.getProject())){
			getFiles(getCanonicalFilename(file)).add(file);
		}
	}
	
	private void markAsDuplicate(final IFile file) {
		try {
			// Do nothing if already marked
			final IMarker[] markers = 
				file.findMarkers(AadlConstants.DUPLICATE_FILE_MARKER, false, IResource.DEPTH_ZERO);
			if (markers.length == 0) {
				final IMarker marker = file.createMarker(AadlConstants.DUPLICATE_FILE_MARKER);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				marker.setAttribute(IMarker.MESSAGE, DUPLICATE_WARNING_MESSAGE);
			}
		} catch (CoreException e1) {
			OsateCorePlugin.log(e1);
		}
	}
	
	private void removeDuplicateMark(final IFile file) {
		try {
			file.deleteMarkers(AadlConstants.DUPLICATE_FILE_MARKER, false, IResource.DEPTH_ZERO);
		} catch (final CoreException e) {
			OsateCorePlugin.log(e);
		}
	}
	
	public synchronized void updateDuplicateMarkers() {
		for (final Map.Entry<String, Set<IFile>> entry : fileMap.entrySet()) {
			final Set<IFile> files = entry.getValue();
			if (files.size() > 1) {
				for (final IFile file : files) {
					markAsDuplicate(file);
				}
			} else if (files.size() == 1) {
				final IFile file = (IFile) files.iterator().next();
				removeDuplicateMark(file);
			}
		}
	}
}
