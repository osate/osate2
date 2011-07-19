/**
 * <copyright>Copyright 2004 by Carnegie Mellon University, all rights
 * reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms
 * of the license set forth at http://www.eclipse.org/legal/cpl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY
 * OR RIGHTS GRANTED OR PROVIDED BY CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS
 * LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS. CARNEGIE
 * MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A
 * PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT, NONINFRINGEMENT,
 * OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR
 * INDIRECT, SPECIAL OR CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR
 * INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE, REGARDLESS
 * OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE
 * AGREES THAT IT WILL NOT MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON
 * UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE APPLICATION OF
 * OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie
 * Mellon University, its trustees, officers, employees, and agents from all
 * claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub
 * licensees' negligent use or willful misuse of or negligent conduct or willful
 * misconduct regarding the Software, facilities, or other rights or assistance
 * granted by Carnegie Mellon University under this License, including, but not
 * limited to, any claims of product liability, personal injury, death, damage
 * to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon University Software Engineering Institute authored documents
 * are sponsored by the U.S. Department of Defense under Contract
 * F19628-00-C-0003. Carnegie Mellon University retains copyrights in all
 * material produced under this contract. The U.S. Government retains a
 * non-exclusive, royalty-free license to publish or reproduce these documents,
 * or allow others to do so, for U.S. Government purposes only pursuant to the
 * copyright license under the contract clause at 252.227.7013.
 * 
 * </copyright>
 * 
 * @version $Id: AadlBuilder.java,v 1.220 2010-06-16 20:46:17 jseibel Exp $
 */
package org.osate.core.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.GlobalNamespace;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisToParseErrorReporterAdapter;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterFactory;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporterManager;
import org.osate.aadl2.parser.Aadl2Parser;
import org.osate.aadl2.parser.AadlParseUtil;
import org.osate.aadl2.parser.ReferenceRecord;
import org.osate.aadl2.parser.ReferenceRecordComparator;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.annexsupport.AnnexResolverController;
import org.osate.core.OsateCorePlugin;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.workspace.IAadlElement;
import org.osate.workspace.IAadlProject;
import org.osate.workspace.IAadlWorkspace;
import org.osate.workspace.IResourceUtility;
import org.osate.workspace.WorkspacePlugin;


public class AadlBuilder extends IncrementalProjectBuilder {
	/*
	 * Changed all the private fields/methods to be protected because Andrew
	 * Weaver of Freemont Associates really wants to extend this class.
	 */

	public static final String copyright = "Copyright 2004 by Carnegie Mellon University, all rights reserved";

	public static final String BUILDER_ID = OsateCorePlugin.PLUGIN_ID + ".aadlbuilder";

	public static final String DEBUG_OPTION = OsateCorePlugin.PLUGIN_ID + "/builder/debug";

	public static boolean DEBUG = OsateCorePlugin.isDebug(DEBUG_OPTION);

	protected static IResourceChangeListener resourceChangeListener = null;

	/** Set of AADL specifications (IFile objects) to parse */
	protected static Set<IFile> specsToDo = new HashSet<IFile>();

	/** Set of package names (Strings) to parse */
	protected static Set/* Contains IFiles and Strings */packagesToDo = new HashSet();

	/** Set of property set names (Strings) to parse */
	protected static Set/* Contains IFiles and Strings */propertysetsToDo = new HashSet();

	/** The set of files that have been processed in this build. */
	protected static Set<IFile> filesDone = new HashSet<IFile>();

	/** A reference to the current workspace. */
	protected IAadlWorkspace workspace = AadlWorkspace.getAadlWorkspace();

	/** incremental build requires a full build */
	protected static boolean requestFullIncremenalBuild = false;

	protected static boolean didFullIncrementalBuild = false;

	protected static boolean doAutoBuild = true;

	protected boolean reportedMissingPredeclared = false;
	/** This value is only meaningful if {@link #reportedMissingPredeclared} is <code>true</code> */
	protected boolean askedAboutMissingPredeclared = false;
	/** This value is only meaningful if {@link #askedAboutMissingPredeclared} is <code>true</code> */
	protected boolean parseMissingPredeclared = false;

	/** Files are added to this list when checking if each source file
	 * is in the project's source directory.  The list is later accessed to
	 * add warning markers to the files.  The markers are not added to the
	 * files during the check because all markers are deleted and regenerated
	 * after the source dir check.
	 */
	protected ArrayList<IFile> sourceFilesNotInSourceDir = null;

	/**Each element in this list correspond to the element with the same
	 * index in sourceFilesNotInSourceDir.
	 */
	protected ArrayList<String> markerMessagesForFilesNotInSourceDir = null;

	/**
	 * Cache of project preference stores.  Reset at the start of each build.
	 */
	protected final Map<IProject, PreferenceStore> prefCache = new HashMap<IProject, PreferenceStore>();

	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());
	protected static final ParseErrorReporterFactory parseErrorLoggerFactory = new LogParseErrorReporter.Factory(
			OsateCorePlugin.getDefault().getBundle());
	protected static final AnalysisErrorReporterFactory analysisErrorLoggerFactory = new LogAnalysisErrorReporter.Factory(
			OsateCorePlugin.getDefault().getBundle());

	protected final FilenameCache fcache = FilenameCache.getInstance();

	/**
	 * Model files that were changed and need to have their sanity checked.
	 */
	protected Set /* <Resource> */modelsToSanityCheck = new HashSet();
	protected Set /* <Resource> */justGenerated = new HashSet();

	public AadlBuilder() {
		initBuildListener();
	}

	public static boolean switchAutoBuild() {
		doAutoBuild = !doAutoBuild;
		return doAutoBuild;
	}

	public static boolean getAutoBuild() {
		return doAutoBuild;
	}

	public static void setAutoBuild(boolean dobuild) {
		doAutoBuild = dobuild;
	}

	/**
	 * deletes all declarative model files in the current projects
	 */
	protected void clean(final IProgressMonitor monitor) throws CoreException {
		final IProject project = getProject();

		// Kill all the problem markers for the project
		try {
			project.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e1) {
			OsateCorePlugin.log(e1);
		}

		// make sure any aaxl file has been saved and unparsed
//		synchronizeResources(monitor);
//		OsateResourceManager.unloadResources();
		workspace.getAadlProject(getProject()).cleanAllDeclarativeModelFiles(monitor);
		workspace.getAadlProject(getProject()).cleanAllAADLTextFiles(monitor);
	}

	/**
	 * deletes all declarative model files in all projects
	 */
	protected void cleanAll(IProgressMonitor monitor) {
		// make sure any aaxl file that has been changed externally is unparsed
		//TODO: AADL2: Fix this after the Unparser is created.
//		AadlUnparser.getAadlUnparser().doUnparseFiles(monitor);
//		OsateResourceManager.unloadResources();
//		loadStandardPropertySets();
//		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
//		for (int i = 0 ; i < projects.length;i++){
//			final IProject project = projects[i];
//			// Kill all the problem markers for the project
//			try {
//				project.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
//			} catch (CoreException e1) {
//				OsateCorePlugin.log(e1);
//			}
//			workspace.getAadlProject(project).cleanAllDeclarativeModelFiles(monitor);
//			workspace.getAadlProject(project).cleanAllAADLTextFiles(monitor);
//		}
	}

	/**
	 * sets the resource change event listener for build events
	 */
	protected void initBuildListener() {
		if (resourceChangeListener == null) {
			resourceChangeListener = new IResourceChangeListener() {
				public void resourceChanged(IResourceChangeEvent event) {
					if (event.getType() == IResourceChangeEvent.POST_BUILD) {
						requestFullIncremenalBuild = false;
						didFullIncrementalBuild = false;
						filesDone.clear();
					}
				}
			};
			workspace.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_BUILD);
		}
	}

	/**
	 * add all source files for processing if their XML files don't exist or are marked as with syntax errors
	 * @param monitor
	 */
	protected void addAllSourceFilesWithCompileNeed(final IProgressMonitor monitor) {
		IAadlProject[] projects = null;
		projects = AadlWorkspace.getAadlWorkspace().getOpenAadlProjects();
		if (projects == null)
			return;
		for (int i = 0; i < projects.length; i++) {
			EList<IFile> srcFiles = projects[i].getAllSourceFiles();
			for (IFile file : srcFiles) {
				if (projects[i].getRecentAaxlFile(file) == null) {
					processAadlFileInternal(file);
				}
			}
		}
		return;
	}

	/**
	 * add all source files for processing if their XML files don't exist or are marked as with syntax errors
	 * @param monitor
	 */
	protected void addAllSourceFiles(Set justGenerated, final IProgressMonitor monitor) {
		IAadlProject[] projects = null;
		projects = AadlWorkspace.getAadlWorkspace().getOpenAadlProjects();
		if (projects == null)
			return;
		for (int i = 0; i < projects.length; i++) {
			EList<IFile> srcFiles = projects[i].getAllSourceFiles();
			for (IFile file : srcFiles) {
				if (!file.isReadOnly() && !justGenerated.contains(file)) {
					processAadlFileInternal(file);
				} else if (file.isReadOnly()) {
					IResource aaxlfile = IResourceUtility.getComplementFile(file);
					if (projects[i].getRecentAaxlFile(file) == null) {
						processAadlFileInternal(file);
					}
				}
			}
		}
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		// we need to use a resource listener to reinit the data structures of a builder.
		// because the builder is reused.  
		// We cannot initialize here and test for firstProject, because
		// projects are listed as built although the build method is not invoked if nothing is to be built.

		// first project handled by listener

		/*
		 * We use three error reporter managers: (1) one for reporting errors
		 * during parsing, (2) one for reporting name resolution errors, and (3)
		 * one for reporting semantic checking issues.
		 * 
		 * The error reporter manager for (1) parsing is initialized after this
		 * comment. We initialize the error reporter managers for (2) and (3)
		 * later because we need to build the resource-to-filename map during
		 * the parsing of all the text files so that the name resolver error
		 * reporter can know which source file goes with which Resource when it
		 * reports errors.
		 * 
		 * We use the logging error reporter as the secondary reporter to the
		 * marker reporters so that errors in the standard property sets are
		 * sent to the Eclipse error log. The marker error reporter will not
		 * find an IResource for them because they are not inside the Workspace,
		 * and thus don't have IResources that can be marked.
		 */

		if (didFullIncrementalBuild) {
			requestFullIncremenalBuild = false;
			return null;
		}

		if (kind == FULL_BUILD) {
			boolean dobuild = doAutoBuild;
			setAutoBuild(true);
			buildAll(null, monitor);
			setAutoBuild(dobuild);
			didFullIncrementalBuild = true;
		}

		return null;

//
//		final ParseErrorReporterManager parseErrManager =
//			new ParseErrorReporterManager(
//					internalErrorLogger,
//					new MarkerParseErrorReporter.Factory(
//							"org.osate.aadl2.parser.ParseErrorMarker",
//							parseErrorLoggerFactory));
//				
//
//		// post parsing actions, need to do this at most once per build		
//		final AnalysisErrorReporterManager nameErrManager =
//			new AnalysisErrorReporterManager(
//					internalErrorLogger,
//					new AnalysisToParseErrorReporterAdapter.Factory(
//							new MarkerParseErrorReporter.Factory(
//									"org.osate.aadl2.parser.NameResolutionErrorMarker",
//									parseErrorLoggerFactory)));
//		
//		final AnalysisErrorReporterManager checkingErrManager = 
//			new AnalysisErrorReporterManager(
//					internalErrorLogger,
//					new MarkerAnalysisErrorReporter.Factory(
//							"org.osate.aadl2.parser.SemanticErrorMarker",
//							analysisErrorLoggerFactory));
//		
//		// Error manager for checking for duplicate packages, etc
//		final AnalysisErrorReporterManager dupErrManager = 
//			new AnalysisErrorReporterManager(
//					internalErrorLogger,
//					new MarkerAnalysisErrorReporter.Factory(
//							"org.osate.core.DuplicatePackageOrPropertySetErrorMarker",
//							analysisErrorLoggerFactory));
//		
//		
//		// Error manager for checking model files 
//		final AnalysisErrorReporterManager modelErrManager = 
//			new AnalysisErrorReporterManager(
//					internalErrorLogger,
//					new MarkerAnalysisErrorReporter.Factory(
//							"org.osate.aadl2.parser.ModelError",
//							analysisErrorLoggerFactory));
//
//		IProject project = getProject();
////		if (!AadlNature.hasNature(project)){
////			return null;
////		}
//
//
//		monitor.beginTask("Building project \"" + getProject().getName() + "\"",7);
//
//		IResourceDelta delta = (kind != FULL_BUILD ? getDelta(getProject()) : null);
//		reportedMissingPredeclared = false;
//		askedAboutMissingPredeclared = false;
//		parseMissingPredeclared = false;
//		// determine file type and add to the appropriate set
//		specsToDo.clear();
//		packagesToDo.clear();
//		propertysetsToDo.clear();
//		modelsToSanityCheck.clear();
//		justGenerated.clear();
//		
//		// Clear the preference cache
//		clearProjectPrefsCache();
//		
//
//		if (delta == null || kind == FULL_BUILD) {
//			project.accept(new Visitor());
//			requestFullIncremenalBuild = false;
//			didFullIncrementalBuild = false;
//			if (kind == FULL_BUILD){
//				requestFullIncremenalBuild = true;
//			}
//		} else {
//			//check that source file is in source directory
//			delta.accept(new DeltaVisitor());
//		}
//		
//		if (requestFullIncremenalBuild){
//			addAllSourceFiles(justGenerated,monitor);
//			justGenerated.clear();
//			requestFullIncremenalBuild = false;
//			didFullIncrementalBuild = true;
//			
//		}		
//
//		// make sure any external change to aaxl files gets unparsed
//		AadlUnparser.getAadlUnparser().doUnparseFiles(monitor);
//		
////		// Parse the plug-in provided property sets
////		for (final Iterator<Resource> i = OsateResourceManager.getResourceSet().getResources().iterator(); i.hasNext();) {
////			final Resource rsrc = i.next();
////			if (OsateResourceManager.isPredeclaredResource(rsrc)) {
////				try {
////					URI uri = rsrc.getURI();
////					URIConverter uricvt = rsrc.getResourceSet().getURIConverter();
////					InputStream aaxlis = uricvt.createInputStream(uri);
////					InputStream aadlis = uricvt.createInputStream(uri.trimFileExtension().appendFileExtension(WorkspacePlugin.SOURCE_FILE_EXT));;
////					String pluginName = uri.segment(1);
////
////					parsePluginProvided(aadlis, aaxlis, pluginName, rsrc);
////				} catch(IOException e) {
////					// TODO error message / log
////				}
////			}
////		}
//		
//		boolean didSpecs = !specsToDo.isEmpty();
//		
//		processAll(parseErrManager, monitor);
//		markFilesNotInSourceDirectory(parseErrManager);
//		
//		/* Check for duplicate file names.  This is global across the workspace
//		 * and the effort is duplicated for each project that is built.  This is
//		 * wasteful, but I cannot get it to work correctly in a distributed 
//		 * manner because I don't know how to remove the markers *before* a file
//		 * is deleted/moved somewhere else.  This caused old markers to stay 
//		 * with a moved file, and I didn't have a good way of getting rid of them.
//	     */
//		fcache.reset();
//		workspace.getWorkspace().getRoot().accept(new DuplicateModelsVisitor());
//		fcache.updateDuplicateMarkers();
//
//		/* Run over *all* the loaded resources and check for unique
//		 * property set and package names.  Need to do this first so that
//		 * any shadowed plug-in property sets marked as being shadowed and has
//		 * its "just parsed" flag unset, so it won't get resolved below.
//		 */
//		monitor.worked(1);
//		monitor.subTask("Check property set and package names");
//		checkForUniquePropertySetAndPackageNames(dupErrManager);
//
//		// Resolve all the names across all the models
//		monitor.worked(1);
//		monitor.subTask("Resolving parsed models");
//		resolveAllParsed(nameErrManager);
//		
//		// Similarly, check the sanity of any non-derived models
//		monitor.worked(1);
//		monitor.subTask("Checking sanity of models");
//		final Set modelsToSemanticCheck =
//			checkModelSanity(modelErrManager, modelsToSanityCheck);
//		modelsToSanityCheck.clear();
//		
//		/* At this point we consider the models to be "sane" so any model
//		 * that passes name resolution is saved.
//		 */
//		monitor.worked(1);
//		monitor.subTask("Saving model files");
//		OsateResourceManager.saveAllParsed();
//		
//		/* Now the model semantics are checked.
//		 */
//		monitor.worked(1);
//		monitor.subTask("Checking model semantics");
//		checkAll(checkingErrManager, modelsToSemanticCheck);
//		
//		// Update any derived files
//		monitor.worked(1);
//		if (didSpecs){
//			updateInstanceModelFiles( monitor);
//		}
//		
//		/* Clear the status of any just parsed files---they don't need
//		 * to be considered as "newly parsed" any more.
//		 */ 
//		OsateResourceManager.clearJustParsed();
//		
//		//Resolve any proxies that have been created during the build process.
//		EcoreUtil.resolveAll(OsateResourceManager.getResourceSet());
//		
//		monitor.done();
//		
//		return null;//tmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void buildAll(Resource res, IProgressMonitor monitor) {

		if (!doAutoBuild)
			return;

		/*
		 * We use three error reporter managers: (1) one for reporting errors
		 * during parsing, (2) one for reporting name resolution errors, and (3)
		 * one for reporting semantic checking issues.
		 * 
		 * The error reporter manager for (1) parsing is initialized after this
		 * comment. We initialize the error reporter managers for (2) and (3)
		 * later because we need to build the resource-to-filename map during
		 * the parsing of all the text files so that the name resolver error
		 * reporter can know which source file goes with which Resource when it
		 * reports errors.
		 * 
		 * We use the logging error reporter as the secondary reporter to the
		 * marker reporters so that errors in the standard property sets are
		 * sent to the Eclipse error log. The marker error reporter will not
		 * find an IResource for them because they are not inside the Workspace,
		 * and thus don't have IResources that can be marked.
		 */
		final ParseErrorReporterManager parseErrManager = new ParseErrorReporterManager(internalErrorLogger,
				new MarkerParseErrorReporter.Factory("org.osate.aadl2.parser.ParseErrorMarker",
						parseErrorLoggerFactory));

		// post parsing actions, need to do this at most once per build		
		final AnalysisErrorReporterManager nameErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.parser.NameResolutionErrorMarker", parseErrorLoggerFactory)));

		final AnalysisErrorReporterManager checkingErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new MarkerAnalysisErrorReporter.Factory("org.osate.aadl2.parser.SemanticErrorMarker",
						analysisErrorLoggerFactory));

		// Error manager for checking for duplicate packages, etc
		final AnalysisErrorReporterManager dupErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new MarkerAnalysisErrorReporter.Factory(
						"org.osate.core.DuplicatePackageOrPropertySetErrorMarker", analysisErrorLoggerFactory));

		// Error manager for checking model files 
		final AnalysisErrorReporterManager modelErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new MarkerAnalysisErrorReporter.Factory("org.osate.aadl2.parser.ModelError",
						analysisErrorLoggerFactory));

		monitor.beginTask("Building ", 7);

		reportedMissingPredeclared = false;
		askedAboutMissingPredeclared = false;
		parseMissingPredeclared = false;
		// determine file type and add to the appropriate set
		specsToDo.clear();
		packagesToDo.clear();
		propertysetsToDo.clear();
		modelsToSanityCheck.clear();
		justGenerated.clear();
		if (res != null) {
			IResource ires = OsateResourceManager.convertToIResource(res);
			justGenerated.add(IResourceUtility.getComplementFile((IFile) ires));
		}

		// Clear the preference cache
		clearProjectPrefsCache();

		addAllSourceFiles(justGenerated, monitor);

		// make sure any external change to aaxl files gets unparsed
		//TODO: AADL2: Fix this after the Unparser is created.
//		AadlUnparser.getAadlUnparser().doUnparseFiles(monitor);

		TreeSet<ReferenceRecord> referenceRecords = new TreeSet<ReferenceRecord>(new ReferenceRecordComparator());

		processAll(referenceRecords, parseErrManager, monitor);
		markFilesNotInSourceDirectory(parseErrManager);

		/*
		 * Check for duplicate file names. This is global across the workspace
		 * and the effort is duplicated for each project that is built. This is
		 * wasteful, but I cannot get it to work correctly in a distributed
		 * manner because I don't know how to remove the markers *before* a file
		 * is deleted/moved somewhere else. This caused old markers to stay with
		 * a moved file, and I didn't have a good way of getting rid of them.
		 */
		fcache.reset();
		try {
			workspace.getWorkspace().getRoot().accept(new DuplicateModelsVisitor());
		} catch (CoreException e) {
		}
		fcache.updateDuplicateMarkers();

		/*
		 * Run over *all* the loaded resources and check for unique property set
		 * and package names. Need to do this first so that any shadowed plug-in
		 * property sets marked as being shadowed and has its "just parsed" flag
		 * unset, so it won't get resolved below.
		 */
		monitor.worked(1);
		monitor.subTask("Check property set and package names");
		PackageAndPropertySetCache.checkForUniquePropertySetAndPackageNames(dupErrManager);

		// Resolve all the names across all the models
		monitor.worked(1);
		monitor.subTask("Resolving parsed models");
		if (parseErrManager.getNumErrors() == 0)
			resolveAllParsed(referenceRecords, nameErrManager);

		// Similarly, check the sanity of any non-derived models
		monitor.worked(1);
		monitor.subTask("Checking sanity of models");
		final Set modelsToSemanticCheck = checkModelSanity(modelErrManager, modelsToSanityCheck);
		modelsToSanityCheck.clear();

		/*
		 * At this point we consider the models to be "sane" so any model that
		 * passes name resolution is saved.
		 */
		monitor.worked(1);
		monitor.subTask("Saving model files");
		OsateResourceManager.saveAllParsed();

		/*
		 * Now the model semantics are checked.
		 */
		monitor.worked(1);
		monitor.subTask("Checking model semantics");
		checkAll(checkingErrManager, modelsToSemanticCheck);

		// Update any derived files
		monitor.worked(1);
//		updateInstanceModelFiles( monitor);

		/*
		 * Clear the status of any just parsed files---they don't need to be
		 * considered as "newly parsed" any more.
		 */
		OsateResourceManager.clearJustParsed();

		//Resolve any proxies that have been created during the build process.
		EcoreUtil.resolveAll(OsateResourceManager.getResourceSet());

		monitor.subTask("Done");
		monitor.done();

		didFullIncrementalBuild = true;
		return;//tmp;
	}

	protected class Visitor implements IResourceVisitor {
		public Visitor() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
		 * .resources.IResource)
		 */
		public boolean visit(IResource resource) {
			if (resource instanceof IFile) {
				// see if this is it
				IFile file = (IFile) resource;
				if (file.exists()) {
					if (IResourceUtility.isAadlFile(file)) {
						fcache.addFile(file);
						IAadlProject aadlProject = workspace.getAadlProject(file);
						IFile aaxlfile = aadlProject.getRecentAaxlFile(file);

						if (aaxlfile == null) {
							processAadlFileInternal(file);
						}
					} else if (IResourceUtility.isModelFile(file)) {
						Resource res = OsateResourceManager.getResource(file);
						EList<EObject> reslist = res.getContents();
						if (!reslist.isEmpty()) {
							EObject root = reslist.get(0);
							if (root instanceof AadlPackage || root instanceof PropertySet) {
								modelsToSanityCheck.add(res);
							}
						}
					}
				}
			}
			return true;
		}
	}

	protected class DuplicateModelsVisitor implements IResourceVisitor {
		public DuplicateModelsVisitor() {
		}

		public boolean visit(IResource resource) {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.exists()) {
					if (IResourceUtility.isAadlFile(file)) {
						fcache.addFile(file);
					}
				}
			}
			return true;
		}
	}

	protected class DeltaVisitor implements IResourceDeltaVisitor {
		public DeltaVisitor() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
		 * .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta aDelta) {
			IResource resource = aDelta.getResource();
			if (resource instanceof IFile) {
				// Only check AADL files
				IFile file = (IFile) resource;
				switch (aDelta.getKind()) {
				case IResourceDelta.ADDED:
				case IResourceDelta.CHANGED:
					if ((aDelta.getFlags() & IResourceDelta.CONTENT) != 0) {
						if (file.exists()) {
							IAadlProject aadlProject = workspace.getAadlProject(file);
							if (IResourceUtility.isAadlFile(file)) {
								// handle files that may have been modified outside the AADLTextEditor
								IFile aaxlfile = aadlProject.getRecentAaxlFile(file);
								if (aaxlfile == null) {
									processAadlFileInternal(file);
								}
							} else if (IResourceUtility.isModelFile(file)) {
								// do (re-)compile any files with syntax error only if save was for Property set or for Package
//							if (IResourceUtility.isGenerated(file)){
								Resource res = OsateResourceManager.getResource(file);
								EList<EObject> reslist = res.getContents();
								if (!reslist.isEmpty()) {
									EObject root = reslist.get(0);
									if (root instanceof AadlPackage || root instanceof PropertySet) {
										modelsToSanityCheck.add(res);
										if ((root instanceof AadlPackage && ((AadlPackage) root)
												.getOwnedPublicSection() != null)
												|| root instanceof PropertySet) {
											requestFullIncremenalBuild = true;
											justGenerated.add(aadlProject.getAadlFile((IFile) file));
										}
									}
								}
//						}
							}
						}
					}
					break;
				case IResourceDelta.REMOVED:
					/*
					 * Do nothing right now. We used to delete the so-called
					 * complement file. That is, if the user deleted the .aadl
					 * file, we also delete the .aaxl file, and if the user
					 * deleted the .aaxl file, then we also deleted the .aadl
					 * file. Niether Peter nor Aaron liked this too much.
					 */
					OsateResourceManager.deleteComplementFile(file);
					break;
				}
			}
			return true;
		}
	}

	/**
	 * Process an AADL file including referenced external packages/propertysets.
	 * This internal version cannot be called from a UI action.
	 * 
	 * @param file
	 *                the AADL file to process
	 */
	protected void processAadlFileInternal(IFile file) {
		if (filesDone.contains(file)) {
			return;
		}
		IPath filepath = file.getProjectRelativePath().removeFileExtension();
		IPath sourceDirPath = new Path(getProjectPrefs(file.getProject()).getString(WorkspacePlugin.PROJECT_SOURCE_DIR));
		if (sourceDirPath.segmentCount() > 0 && filepath.matchingFirstSegments(sourceDirPath) == 0) {
			if (sourceFilesNotInSourceDir == null) {
				sourceFilesNotInSourceDir = new ArrayList<IFile>();
				markerMessagesForFilesNotInSourceDir = new ArrayList<String>();
			}
			sourceFilesNotInSourceDir.add(file);
			markerMessagesForFilesNotInSourceDir.add("Source file \""
					+ file.getName()
					+ "\" not in the source directory \""
					+ new Path(getProjectPrefs(file.getProject()).getString(WorkspacePlugin.PROJECT_SOURCE_DIR))
							.toOSString() + "\" for the project \"" + file.getProject().getName() + "\"");
		}

		specsToDo.add(file);
	}

	/**
	 * returns true if named segment is contained in path as segment
	 * @param path
	 * @param segmentName
	 */
	protected boolean containsSegment(IPath path, String segmentName) {
		int n = path.segmentCount();
		for (int i = 0; i < n; i++) {
			if (path.segment(i).equalsIgnoreCase(segmentName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Process an AADL file but not any referenced external packages/propertysets. This method is used 
	 * by the text editor.
	 * <p>
	 * This method parses the source file, loads the corresponding model file (if necessary and present), and 
	 * copies all location references to the resource. 
	 * 
	 * @param file
	 *                the AADL file to process
	 * @param monitor
	 *                the progress monitor for this operation
	 */
	public void parseSingleAadlFile(final IFile file, final IProgressMonitor monitor) {
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		//  have write permissions on the editing domain.
		try {
			((TransactionalCommandStack) domain.getCommandStack()).execute(new RecordingCommand(domain) {
				protected void doExecute() {
					parseSingleAadlFileInt(file, monitor);
				}
			}, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void parseSingleAadlFileInt(final IFile file, IProgressMonitor monitor) {
		boolean doMonitor = false;
		if (doMonitor)
			monitor.beginTask("Compiling \"" + file.getName() + "\"", 5);
		IPath filepath = file.getProjectRelativePath();
		final ParseErrorReporterManager parseErrManager = new ParseErrorReporterManager(internalErrorLogger,
				new MarkerParseErrorReporter.Factory("org.osate.aadl2.parser.ParseErrorMarker",
						parseErrorLoggerFactory));

		TreeSet<ReferenceRecord> referenceRecords = new TreeSet<ReferenceRecord>(new ReferenceRecordComparator());
		Resource aaxlres = parseFile(file, referenceRecords, parseErrManager);
		if (parseErrManager.getNumErrors() > 0) {
			OsateResourceManager.clearJustParsed();
			if (doMonitor)
				monitor.done();
			return;
		}

		/*
		 * We get the resource at this point because calling parseFile() might
		 * cause a build and as might be turned into a proxy. Get the resource
		 * here decreases the chances that as.eRsource() returns null.
		 */

		final AnalysisErrorReporterManager resolveErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.parser.NameResolutionErrorMarker", parseErrorLoggerFactory)));
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Resolving parsed model");
		resolveAllParsed(referenceRecords, resolveErrManager);
		if (resolveErrManager.getNumErrors() > 0) {
			OsateResourceManager.clearJustParsed();
			if (doMonitor)
				monitor.done();
			return;
		}

		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Saving model file");
		OsateResourceManager.saveAllParsed();

		final AnalysisErrorReporterManager checkingErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.parser.SemanticErrorMarker", parseErrorLoggerFactory)));

		/*
		 * Now the model semantics are checked.
		 */
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Checking model's semantics");
		checkAll(checkingErrManager, Collections.EMPTY_SET);
		OsateResourceManager.saveAllParsed();
		IResource ires = OsateResourceManager.convertToIResource(aaxlres);

//		// Update any derived files
//		if (doMonitor) monitor.worked(1);
//		if (doMonitor) monitor.subTask("Updating instance models");
//		if (ires != null){
//		updateInstanceModelFiles(monitor);
//		}
		/*
		 * Clear the status of any just parsed files---they don't need to be
		 * considered as "newly parsed" any more.
		 */
		OsateResourceManager.clearJustParsed();

		if (doMonitor)
			monitor.worked(1);
//		if (doMonitor) monitor.subTask("Checking \"" + ires.getName() + "\" for unresolved proxies");
//		checkUnresolvedProxies(monitor);
		if (doMonitor)
			monitor.done();
	}
	
	public void parseAllAadlFiles(final IProgressMonitor monitor)
	{
		final ArrayList<IFile> sourceFiles = new ArrayList<IFile>();
		IAadlProject[] openProjects = AadlWorkspace.getAadlWorkspace().getOpenAadlProjects();
		for (IAadlProject project : openProjects)
			sourceFiles.addAll(project.getAllSourceFiles());
		try
		{
			for (IFile file : sourceFiles)
			{
				file.touch(null);
				file.setDerived(false);
			}
		}
		catch (CoreException e)
		{
			e.printStackTrace();
		}
		final TransactionalEditingDomain domain =
			TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		try
		{
			((TransactionalCommandStack)domain.getCommandStack()).execute(
					new RecordingCommand(domain)
					{
						@Override
						protected void doExecute()
						{
							parseAllAadlFilesInt(sourceFiles, monitor);
						}
					}, null);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (RollbackException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void parseAllAadlFilesInt(final List<IFile> files, IProgressMonitor monitor)
	{
		boolean doMonitor = false;
		if (doMonitor)
			monitor.beginTask("Compiling", 5);
		final ParseErrorReporterManager parseErrManager = new ParseErrorReporterManager(internalErrorLogger,
				new MarkerParseErrorReporter.Factory("org.osate.aadl2.parser.ParseErrorMarker", parseErrorLoggerFactory));
		
		TreeSet<ReferenceRecord> referenceRecords = new TreeSet<ReferenceRecord>(new ReferenceRecordComparator());
		for (IFile file : files)
			parseFile(file, referenceRecords, parseErrManager);
		
		final AnalysisErrorReporterManager resolveErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.parser.NameResolutionErrorMarker", parseErrorLoggerFactory)));
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Resolving parsed model");
		resolveAllParsed(referenceRecords, resolveErrManager);
		
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Saving model file");
		OsateResourceManager.saveAllParsed();
		
		final AnalysisErrorReporterManager checkingErrManager = new AnalysisErrorReporterManager(internalErrorLogger,
				new AnalysisToParseErrorReporterAdapter.Factory(new MarkerParseErrorReporter.Factory(
						"org.osate.aadl2.parser.SemanticErrorMarker", parseErrorLoggerFactory)));
		
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.subTask("Checking model's semantics");
		checkAll(checkingErrManager, Collections.EMPTY_SET);
		OsateResourceManager.saveAllParsed();
		
		OsateResourceManager.clearJustParsed();
		
		if (doMonitor)
			monitor.worked(1);
		if (doMonitor)
			monitor.done();
	}

	/**
	 * Parse all AADL specification files in the <code>specsToDo</code> set as
	 * well as all packages and property sets in the sets packagesToDo and
	 * propertysetsToDo, respectively.
	 * 
	 * @param monitor
	 *                the progress monitor for this job
	 */
	protected void processAll(TreeSet<ReferenceRecord> referenceRecords, final ParseErrorReporterManager errManager,
			final IProgressMonitor monitor) {
		Set<IFile> copy = new HashSet<IFile>(specsToDo);
		// AADL specifications cannot be referenced from outside the spec. Go
		// through the set once and be done.
		// Referenced packages are collected in <code>packagesToDo</code>.
		// Referenced property sets are collected in
		// <code>propertysetsToDo</code>.
		for (Iterator<IFile> specs = copy.iterator(); specs.hasNext();) {
			final IFile specFile = specs.next();
			processFile(IAadlElement.AADL_SPECIFICATION, specFile, referenceRecords, errManager, monitor);
			filesDone.add(specFile);
			specsToDo.remove(specFile);

		}

	}

	protected boolean hasNames(Set set) {
		boolean hasname = false;
		final Set copy = new HashSet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof String) {
				hasname = true;
				copy.add(obj);
			}
		}
		if (hasname) {
			set.removeAll(copy);
		}
		return hasname;
	}

	/**
	 * Process an AADL file. Load the corresponding model file if it is present
	 * in the workspace and current. Otherwise delegate processing to the
	 * parser.
	 * @param sourceFile
	 *                the file to process in the current workspace
	 * @param monitor
	 *                the progress monitor to use
	 */
	protected void processFile(int fileType, IFile sourceFile, TreeSet<ReferenceRecord> referenceRecords,
			ParseErrorReporterManager errManager, IProgressMonitor monitor) {
//		IAadlProject aadlProject = workspace.getAadlProject(sourceFile);
		monitor.subTask("Parsing \"" + sourceFile.getFullPath().toString() + "\"");
		if (filesDone.contains(sourceFile)
		//	|| aadlProject.getRecentAaxlFile(sourceFile) != null
		) {
		} else {
			parseFile(sourceFile, referenceRecords, errManager);
		}
	}

	/**
	 * Parse an AADL file. Before this method can be called the AADL compilation
	 * unit must be resolved to a file in the current workspace. The object
	 * model for this file is added to the osate resource set and needs to be name resolved.
	 * @param file
	 *                the file to parse in the current workspace
	 * @return An AADL spec object containing the parsed model or
	 * <code>null</code> if there were parse errors.
	 */
	protected Resource parseFile(final IFile file, TreeSet<ReferenceRecord> referenceRecords,
			final ParseErrorReporterManager parseErrManager) {
		final String filename = file.getLocation().toOSString();
		final ParseErrorReporter errReporter = parseErrManager.getReporter(file);

		URI outURI = makeOutURI(file);
		if (outURI == null) {
			return null;
		}

		final Resource aaxlResource = OsateResourceManager.getEmptyResource(outURI);

		// Kill all the problem markers for the file
		try {
			if (((IResource) file).exists()) {
				file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			}
		} catch (CoreException e1) {
			OsateCorePlugin.log(e1);
		}

		if (aaxlResource instanceof Aadl2ResourceImpl) {
			((Aadl2ResourceImpl) aaxlResource).setJustParsed(true);
		}

		final String fileNameAlone = file.getName().substring(0, file.getName().lastIndexOf('.'));
		try {
			InputStream is = file.getContents();
			final Aadl2Parser parser = AadlParseUtil.getAadlParser(filename, is, errReporter);
			boolean oldProp = OsateResourceManager.getResourceSet().isPropagateNameChange();
			OsateResourceManager.getResourceSet().setPropagateNameChange(false);
			parser.aadl_specification(GlobalNamespace.INSTANCE, aaxlResource, referenceRecords);
			is.close();
			NamedElement rootObject = aaxlResource.getContents().isEmpty() ? null : (NamedElement) aaxlResource
					.getContents().get(0);
			if ((rootObject instanceof AadlPackage && ((AadlPackage) rootObject).getOwnedPublicSection() != null)
					|| rootObject instanceof PropertySet) {
				requestFullIncremenalBuild = true;
			}
			OsateResourceManager.getResourceSet().setPropagateNameChange(oldProp);
			// If the source file has parse errors delete the generated object
			// file
			if (errReporter.getNumErrors() > 0) {
				// TODO tag the file as model with syntax errors and don't
				// delete
				// reload to get the old model back, if it exists
				if (aaxlResource instanceof Aadl2ResourceImpl) {
					((Aadl2ResourceImpl) aaxlResource).setJustParsed(false);
				}
				if (OsateResourceManager.convertToIResource(aaxlResource).exists()) {
					OsateResourceManager.reload(aaxlResource);
				} else {
					OsateResourceManager.saveAsDerived(aaxlResource);
				}
				OsateResourceManager.tagModelWithSyntaxErrors(aaxlResource);
			} else {
				OsateResourceManager.untagModelWithSyntaxErrors(aaxlResource);
			}
		} catch (Throwable t) {
			// TODO tag the file as model with syntax errors (see above)
			if (aaxlResource != null) {
				// reload to get the old model back, if it exists
				if (aaxlResource instanceof Aadl2ResourceImpl) {
					((Aadl2ResourceImpl) aaxlResource).setJustParsed(false);
				}
				if (OsateResourceManager.convertToIResource(aaxlResource).exists()) {
					OsateResourceManager.reload(aaxlResource);
				} else {
					OsateResourceManager.saveAsDerived(aaxlResource);
					IResourceUtility.setGenerated(OsateResourceManager.convertToIResource(aaxlResource), true);
				}
				OsateResourceManager.tagModelWithSyntaxErrors(aaxlResource);
			}
			OsateCorePlugin.log(t);
		}
		return aaxlResource;
	}

	/**
	 * Parse an AADL file. Before this method can be called the AADL compilation
	 * unit must be resolved to a file in the current workspace. The object
	 * model for this file is added to the osate resource set and needs to be name resolved.
	 * 
	 * @return An AADL spec object containing the parsed model or
	 * <code>null</code> if there were parse errors.
	 */
//	protected void parsePluginProvided(
//			InputStream aadlis, InputStream aaxlis, String pluginName, Resource outRsrc) {
//		/* Reset the Resource: clear the contents and set it be "just parsed"
//		 * and reset it's shadowed state.
//		 */
//		if (outRsrc.isLoaded()) {
//			outRsrc.unload();
//		}
//		if (!outRsrc.getContents().isEmpty()) {
//			outRsrc.getContents().clear();
//		}
//		if (outRsrc instanceof Aadl2ResourceImpl) {
//			((Aadl2ResourceImpl) outRsrc).setJustParsed(true);
//		}
//
//		try {
//			ParseErrorReporter parseErr = new LogParseErrorReporter(OsateCorePlugin.getDefault().getBundle());
//			Aadl2Parser parser =
//				AadlParseUtil.getAadlParser(pluginName, aadlis, parseErr);
//			boolean oldProp =
//				OsateResourceManager.getResourceSet().isPropagateNameChange();
//			OsateResourceManager.getResourceSet().setPropagateNameChange(false);
//			parser.aadl_specification(GlobalNamespace.INSTANCE, outRsrc);
//			aadlis.close();
//			as.setName(pluginName.substring(0, pluginName.lastIndexOf('.')));
//			OsateResourceManager.getResourceSet().setPropagateNameChange(oldProp);
//			// If the source file has parse errors delete the generated object
//			// file
//			if (parseErr.getNumErrors() > 0) {
//				if (outRsrc instanceof CoreResourceImpl) {
//					((CoreResourceImpl) outRsrc).setJustParsed(false);
//				}
//				try {
//					outRsrc.load(aaxlis, null);
//				} catch(final IOException e) {
//					outRsrc.getContents().clear();
//				}
//			}
//		} catch (Throwable t) {
//			if (outRsrc instanceof CoreResourceImpl) {
//				((CoreResourceImpl) outRsrc).setJustParsed(false);
//			}
//			try {
//				outRsrc.load(aaxlis, null);
//			} catch(final IOException e) {
//				outRsrc.getContents().clear();
//			}
//		}
//		return as;
//	}

	protected boolean fileNameMatchesName(String fn, String n) {
		return (fn.equalsIgnoreCase(n.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
				WorkspacePlugin.FILE_PACKAGE_SEPARATOR))
				|| fn.equalsIgnoreCase(n.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, "_")) || fn
				.equalsIgnoreCase(n.replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR, ".")));
	}

	protected void resolveAllParsed(TreeSet<ReferenceRecord> referenceRecords, final AnalysisErrorReporterManager errMgr) {

		try {
			final Set<Aadl2ResourceImpl> parsedResources = OsateResourceManager.getAllParsedResources();

			/*
			 * Files that have parse errors are not checked here because the
			 * parseFile() method has already removed them from the resource
			 * set.
			 */
			final Set unresolvable = new HashSet();
			AadlParseUtil.resolveParsedModels(parsedResources, referenceRecords, errMgr, unresolvable);

			checkAnnexes(parsedResources,errMgr);
			// XXX: Check that this step worked?

			// Tag object models files as model with syntax errors instead of remove
			for (final Iterator iter = unresolvable.iterator(); iter.hasNext();) {
				final Resource r = (Resource) iter.next();
				// reload to get the old model back, if it exists
				((Aadl2ResourceImpl) r).setJustParsed(false);
				if (OsateResourceManager.convertToIResource(r).exists()) {
					OsateResourceManager.reload(r);
					OsateResourceManager.tagModelWithSyntaxErrors(r);
				} else {
					OsateResourceManager.removeResource(r);
				}
			}
		} catch (Throwable t) {
			/*
			 * Find out what is the correct way to log errors from a task. Other
			 * eclipse features seem to have a way of causing a dialog box to
			 * appear indicating that a task/build failed and showing the errors
			 * that were generated as a result. Ideally, we should not be
			 * opening dialogs ourselves here.
			 */
			showError("Internal Error", "Stacktrace logged in your workspace .metadata/.log");
			OsateCorePlugin.log(t);
		}
	}

	protected Set checkModelSanity(final AnalysisErrorReporterManager errMgr, final Set modelsToCheck) {
		try {
			return AadlParseUtil.checkModelReferences(modelsToCheck, errMgr, new HashSet());
		} catch (Throwable t) {
			/*
			 * Find out what is the correct way to log errors from a task. Other
			 * eclipse features seem to have a way of causing a dialog box to
			 * appear indicating that a task/build failed and showing the errors
			 * that were generated as a result. Ideally, we should not be
			 * opening dialogs ourselves here.
			 */
			showError("Internal Error", "Stacktrace logged in your workspace .metadata/.log");
			OsateCorePlugin.log(t);
			return Collections.EMPTY_SET;
		}
	}

	/**
	 * This method collects all checks that need to be done on the workspace /
	 * resource set after parsing, including
	 * <ul>
	 * <li>Semantic checking</li>
	 * <li>Property checking.</li>
	 * </ul>
	 * 
	 */
	protected void checkAll(final AnalysisErrorReporterManager analErrMgr, final Set modelsToCheck) {
		try {
			/*
			 * We want to check all the "just parsed" resources that don't have
			 * syntax errors.
			 */
			final Set<Aadl2ResourceImpl> parsedResources = OsateResourceManager.getAllParsedResources();
			final Set noSyntaxError = new HashSet(modelsToCheck);
			for (Aadl2ResourceImpl r : parsedResources) {
				if (!OsateResourceManager.isModelTaggedWithSyntaxErrors(r)) {
					noSyntaxError.add(r);
//					System.out.println("yes "+ r.toString());
//				} else {
//					System.out.println("no "+ r.toString());
				}
			}
			// Check the semantics; we don't care about which files fail
			AadlParseUtil.checkModelSemantics(noSyntaxError, analErrMgr, new HashSet());
		} catch (Exception t) {
			/*
			 * Find out what is the correct way to log errors from a task. Other
			 * eclipse features seem to have a way of causing a dialog box to
			 * appear indicating that a task/build failed and showing the errors
			 * that were generated as a result. Ideally, we should not be
			 * opening dialogs ourselves here.
			 */
			showError("Internal Error", "Stacktrace logged in your workspace .metadata/.log");
			OsateCorePlugin.log(t);
		}
	}

	protected void checkAnnexes(Set resources, AnalysisErrorReporterManager errMgr) {
		AnnexResolverController controller = new AnnexResolverController(errMgr);		
		controller.resolveAllAnnexes(resources);
	}

	public void checkModelSemantics(Resource res) {
		final Set<Aadl2ResourceImpl> resources = new HashSet<Aadl2ResourceImpl>();
		if (res instanceof Aadl2ResourceImpl) {
			resources.add((Aadl2ResourceImpl) res);
			final AnalysisErrorReporterManager checkingErrManager = new AnalysisErrorReporterManager(
					internalErrorLogger, new MarkerAnalysisErrorReporter.Factory(
							"org.osate.aadl2.parser.SemanticErrorMarker", analysisErrorLoggerFactory));
			AadlParseUtil.checkModelReferences(resources, checkingErrManager, new HashSet());
			AadlParseUtil.checkModelSemantics(resources, checkingErrManager, new HashSet());
		}
	}

	/**
	 * @param file
	 */
	protected URI makeOutURI(IFile file) {
		IPath outPath = workspace.getAadlProject(file).getAaxlPath(file);

		if (outPath == null) {
			return null;
		}
		return URI.createPlatformResourceURI(outPath.toString(), false);
	}

	/**
	 * This method doesn't do anything anymore now that we treat the
	 * standard property sets as plug-in provided property sets.
	 * It is here for API compatibility.
	 * 
	 * @deprecated This method call is a noop, you can remove it.
	 */
	public static void loadStandardPropertySets() {
	}

	/** 
	 * This method doesn't do anything anymore now that we treat the
	 * standard property sets as plug-in provided property sets.
	 * It is here for API compatibility.
	 * 
	 * @deprecated This method call is a noop, you can remove it.
	 */
	public static void loadStandardPropertySets(final ParseErrorReporterManager parseErrManager,
			final AnalysisErrorReporterManager checkingErrManager) {
	}

	/**
	 * This method doesn't do anything anymore now that we treat the
	 * standard property sets as plug-in provided property sets.
	 * It is here for API compatibility.
	 * 
	 * @deprecated This method call is a noop, you can remove it.
	 */
	protected void loadStandardPropertySets(final ParseErrorReporterManager parseErrManager,
			final AnalysisErrorReporterManager nameErrManager, final AnalysisErrorReporterManager checkingErrManager) {
	}

//	protected void updateInstanceModelFiles(
//			 IProgressMonitor monitor) {
//		
//		if (!WorkspacePlugin.getDefault().getPluginPreferences().getBoolean(WorkspacePlugin.AUTO_REINSTANTIATE))
//			return;
//		
//		IAadlProject[] projects = null;
//			projects = AadlWorkspace.getAadlWorkspace().getOpenAadlProjects();
//
//		for (int i = 0; i < projects.length; i++) {
//				EList<IFile> files = projects[i].getAllInstanceModelFiles(monitor);
//				for (IFile ires : files) {
//					doReinstantiate(ires, monitor);
//				}
//		}
//	}

	public boolean doReinstantiate(IResource ires, IProgressMonitor monitor){
		if (!IResourceUtility.isInstanceFile(ires)) return false;
		Resource res = OsateResourceManager.getResource(ires);
		final EList<EObject> inst = res.getContents();
		boolean removeInstance = false;
		boolean cancelled = false;

		if (!inst.isEmpty()) {
			final EObject o = inst.get(0);
			if (o instanceof SystemInstance) {
				final SystemImplementation simpl = ((SystemInstance) o).getSystemImplementation();
				Aadl2ResourceImpl sires = (Aadl2ResourceImpl)simpl.eResource();
				if (!simpl.eIsProxy() && sires !=null && OsateResourceManager.isNewerThan(sires, res)) {
					final InstantiateModel instantiateModel =
						new InstantiateModel(monitor,
								new AnalysisErrorReporterManager(
										internalErrorLogger,
										new MarkerAnalysisErrorReporter.Factory(
												AadlConstants.INSTANTIATION_OBJECT_MARKER)));
					if (instantiateModel.buildInstanceModelFile(simpl) == null) {
						// We were cancelled, delete the model
						cancelled = true;
					}
				} 
				if (simpl.eIsProxy() && ! OsateResourceManager.isModelTaggedWithSyntaxErrors(sires)) {
					removeInstance = true;
				}
			} 
		}else {
			removeInstance = true;
		}
		if (removeInstance) {
			try {
				OsateResourceManager.removeResource(ires);
				ires.delete(true, null);
			} catch (CoreException e) {
				internalErrorLogger.internalError(e);
			}
		}
		return cancelled;
	}

	public void removeUnresolvedInstanceModelFiles( ){
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0 ; i < projects.length;i++){
			removeUnresolvedInstanceModelFiles(projects[i]);
		}
		
	}

	public void removeUnresolvedInstanceModelFiles(IProject project ){
		EList<IFile> files = workspace.getAadlProject(project).getAllInstanceModelFiles(null);
		for (IFile ires : files){
			Resource res = OsateResourceManager.getResource(ires);
			EList<EObject> inst = res.getContents();
			if (!inst.isEmpty()){
				SystemInstance si = (SystemInstance)inst.get(0);
				SystemImplementation simpl = si.getSystemImplementation();
				if (simpl.eIsProxy()){
					try {
						OsateResourceManager.removeResource(ires);
						ires.delete(true,null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					};
				}
			} else {
				try {
					OsateResourceManager.removeResource(ires);
					ires.delete(true,null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
	//				e.printStackTrace();
				};
			}
		}
	}

	/**
	 * Creates new warning markers with messages from
	 * markerMessagesForFilesNotInSourceDir and adds them to
	 * the corresponding file in sourceFilesNotInSourceDir.
	 *
	 */
	protected void markFilesNotInSourceDirectory(final ParseErrorReporterManager errManager) {
		if (sourceFilesNotInSourceDir != null) {
			for (int i = 0; i < sourceFilesNotInSourceDir.size(); i++) {
				final IFile aadlFile = sourceFilesNotInSourceDir.get(i);
				final ParseErrorReporter errReporter = errManager.getReporter(aadlFile);
				errReporter
						.warning(aadlFile.getLocation().toOSString(), 0, markerMessagesForFilesNotInSourceDir.get(i));
			}
		}
	}

	protected void clearProjectPrefsCache() {
		prefCache.clear();
	}

	protected PreferenceStore getProjectPrefs(final IProject project) {
		PreferenceStore ps = prefCache.get(project);
		if (ps == null) {
			ps = WorkspacePlugin.getPreferenceStore(project);
			checkProjectPreferences(project, ps);
			prefCache.put(project, ps);
		}
		return ps;
	}

	protected void checkProjectPreferences(final IProject project, final PreferenceStore projectProperties) {
		/*
		 * Check that the paths in the preferences use "/" as the separator
		 * character. This didn't used to be the standard, so we might have some
		 * old .aadlsettings out there that need to be fixed.
		 * 
		 * Check for this could definitely be more sophisticated, but simply
		 * checking for "\\" at the start of the path is probably good enough.
		 */
		boolean updated = false;
		final StringBuffer msg = new StringBuffer();

		final String srcDir = projectProperties.getString(WorkspacePlugin.PROJECT_SOURCE_DIR);
		String newSrcDir = srcDir;
		if (srcDir.charAt(0) == '\\') {
			newSrcDir = srcDir.replace('\\', '/');
			projectProperties.setValue(WorkspacePlugin.PROJECT_SOURCE_DIR, newSrcDir);
			updated = true;
			msg.append("replacing \"");
			msg.append(srcDir);
			msg.append("\" with \"");
			msg.append(newSrcDir);
			msg.append("\"");
		}
		final String modDir = projectProperties.getString(WorkspacePlugin.PROJECT_MODEL_DIR);
		String newModDir = modDir;
		if (modDir.charAt(0) == '\\') {
			newModDir = modDir.replace('\\', '/');
			projectProperties.setValue(WorkspacePlugin.PROJECT_MODEL_DIR, newModDir);
			updated = true;
			if (msg.length() != 0)
				msg.append(", ");
			msg.append("replacing \"");
			msg.append(modDir);
			msg.append("\" with \"");
			msg.append(newModDir);
			msg.append("\"");
		}

		if (updated) {
			/*
			 * Find out what is the correct way to log errors from a task. Other
			 * eclipse features seem to have a way of causing a dialog box to
			 * appear indicating that a task/build failed and showing the errors
			 * that were generated as a result. Ideally, we should not be
			 * opening dialogs ourselves here.
			 */
			showInfo("Updating Project Preferences", "The directory preferences for project " + project.getName()
					+ " are being updated: " + msg.toString() + ".");
			try {
				projectProperties.save();
			} catch (final IOException e) {
				OsateCorePlugin.log(e);
			}
			try {
				project.refreshLocal(1, null);
			} catch (final CoreException e) {
				OsateCorePlugin.log(e);
			}
		}
	}

	/**
	 * makes sure the aadl file exists and is up to date with respect to the aaxl file.
	 * The aaxl file must exist and must not be an instance file.
	 * It will ensure up-to-date location references on the object model
	 */
//	public static IFile getUpToDateAadlFile(IFile aaxlFile){
//		IFile textfile = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlFile).getAadlFile( aaxlFile);
//		Resource res = OsateResourceManager.getResource(aaxlFile);
//		if (OsateResourceManager.isModelTaggedWithSyntaxErrors(aaxlFile)){
//		// do not do this: the XML could be bad:	addLocationInformation(res);
//			return textfile;
//		}
//		if (!IResourceUtility.isGenerated(((IResource)aaxlFile)) ){
//			if (res.getContents().isEmpty()){
//				return textfile;
//			}
//			if (!textfile.exists()||((Aadl2ResourceImpl)res).isNewerThan(textfile)){
//				AObject obj = (AObject)res.getContents().get(0);
//				textfile = AadlUnparser.getAadlUnparser().doUnparseToFile(obj,textfile.getFullPath());
//			} else {
//				addLocationInformation(res);
//			}
//			return textfile;
//		} else {
//			// attach location references if they do not exist
//			addLocationInformation(res);
//		}
//		return  textfile;
//	}

	/**
	 * adds location information to object model if not present
	 * @param res declarative model resource
	 */
//	public static void addLocationInformation(Resource res){
//		if (res == null || res.getContents().isEmpty()){
//			return;
//		}
//		AObject obj = (AObject)res.getContents().get(0);
//		if (obj instanceof AadlSpec){
//			EList l = ((AadlSpec)obj).getChildren();
//			if (!l.isEmpty()){
//				AObject first = (AObject)l.get(0);
//				if (first.getLocationReference() == null){
//					AadlUnparser.getAadlUnparser().doNoTextUnparse(obj);
//				}
//			}
//		}
//	}

//	public void checkUnresolvedProxies(final IProgressMonitor monitor){
//		OsateResourceSet ors = OsateResourceManager.getResourceSet();
//		Set<Resource> resources = ors.doFindUnresolved();
//		for (Resource res : resources){
//			IResource ires = OsateResourceManager.convertToIResource(res);
//			if (IResourceUtility.isModelFile(ires) && ires.exists() ){
//				// unparse to make sure the text is uptodate
//				IFile textFile = getUpToDateAadlFile((IFile)ires);
//				// mark IResource as having syntax errors
//				IResourceUtility.tagModelWithSyntaxErrors(ires);
//				try {
//					IResourceUtility.setGenerated(textFile,false);
//					// Make sure its time stamp is newer than the XML file
//					if (textFile != null){
//						textFile.touch(null);
//					}
//				} catch (CoreException e) {
//				}
//			}
//		}
//	}

	/**
	 * Given a resource was saved, make sure any affected XML models get saved to update their XPath.
	 * Also unparse any text files that are out of date to reflect the propagated change.
	 * @param monitor
	 */
//	public static void synchronizeResources(IProgressMonitor monitor){
//		OsateResourceManager.getResourceSet().saveAll();
//		checkAllModelSemantics();
//		AadlUnparser.getAadlUnparser().doUnparseFiles(monitor);
//	}

//	public static void checkAllModelSemantics(){
//		final Set<Aadl2ResourceImpl> resources = new HashSet<Aadl2ResourceImpl>();
//		for (Resource resource : OsateResourceManager.getResourceSet().getResources())
//		{
//			if (resource instanceof Aadl2ResourceImpl&& resource.isModified()) {
//				if (!resource.getContents().isEmpty()&&resource.getContents().get(0) instanceof AadlSpec){
//						resources.add((Aadl2ResourceImpl)resource);
//				}
//			}
//		}
//			final AnalysisErrorReporterManager checkingErrManager = 
//				new AnalysisErrorReporterManager(
//						internalErrorLogger,
//						new MarkerAnalysisErrorReporter.Factory(
//								"org.osate.aadl2.parser.SemanticErrorMarker",
//								analysisErrorLoggerFactory));
//			AadlParseUtil.checkModelReferences(resources, checkingErrManager, new HashSet());
//			AadlParseUtil.checkModelSemantics(resources, checkingErrManager, new HashSet());
//	}

	/*
	 * Copied from our specialized Dialog class (now in edu.cmu.sei.osate.ui).
	 * We cannot use the class here because it would create a dependency cycle
	 * between the org.osate.core and edu.cmu.sei.osate.ui plug-ins.
	 */
	private static void showInfo(final String title, final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(getShell(), title, msg);
			}
		});
	}

	/*
	 * Copied from our specialized Dialog class (now in edu.cmu.sei.osate.ui).
	 * We cannot use the class here because it would create a dependency cycle
	 * between the org.osate.core and edu.cmu.sei.osate.ui plug-ins.
	 */
	private static void showError(final String title, final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(getShell(), title, msg);
			}
		});
	}

	/*
	 * Copied from our specialized Dialog class (now in edu.cmu.sei.osate.ui).
	 * We cannot use the class here because it would create a dependency cycle
	 * between the org.osate.core and edu.cmu.sei.osate.ui plug-ins.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}