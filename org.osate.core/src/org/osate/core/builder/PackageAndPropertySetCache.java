/*
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
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
package org.osate.core.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.util.Aadl2ResourceImpl;


public final class PackageAndPropertySetCache
{
	private final Map<String, Set<PropertySet>> propertySetMap = new HashMap<String, Set<PropertySet>>();
	private final Map<String, Set<PublicPackageSection>> publicPartMap = new HashMap<String, Set<PublicPackageSection>>();
	private final Map<String, Set<PrivatePackageSection>> privatePartMap = new HashMap<String, Set<PrivatePackageSection>>();
	
	private PackageAndPropertySetCache()
	{
		//Only allow instantiation from within this class.
	}
	
	public static void checkForUniquePropertySetAndPackageNames(
			final AnalysisErrorReporterManager checkingErrManager) {
		final PackageAndPropertySetCache cache = new PackageAndPropertySetCache();
		final Iterator<Resource> rsrcIter =
			OsateResourceManager.getResourceSet().getResources().iterator();
		while (rsrcIter.hasNext()) {
			final Resource rsrc = rsrcIter.next();
			/* Lookup the reporter for the resource so that we make sure the
			 * markers for it are removed
			 */
			if (rsrc instanceof Aadl2ResourceImpl) {
				checkingErrManager.getReporter(rsrc);
				final PropertySet pset = OsateResourceManager.getPropertySet(rsrc);
				final AadlPackage pkg = OsateResourceManager.getAadlPackage(rsrc);
				if (pset != null) cache.addPropertySet(pset);
				if (pkg != null) cache.addAadlPackage(pkg);
			}
		}
		cache.markDuplicates(checkingErrManager);
	}
	
	//T should be PropertySet, PublicPackageSection, or PrivatePackageSection.
	private <T extends Namespace> Set<T> getSet(final Map<String, Set<T>> map, final String fname) {
		Set<T> files = map.get(fname);
		if (files == null) {
			files = new HashSet<T>();
			map.put(fname, files);
		}
		return files;
	}
	
	private String getCanonicalName(final String name) {
		return name.toLowerCase();
	}
	
	private void addPropertySet(final PropertySet pset) {
		getSet(propertySetMap, getCanonicalName(pset.getName())).add(pset);
	}
	
	private void addAadlPackage(final AadlPackage pkg) {
		final String name = getCanonicalName(pkg.getName());
		final PublicPackageSection pub = pkg.getOwnedPublicSection();
		final PrivatePackageSection priv = pkg.getOwnedPrivateSection();
		if (pub != null) {
			getSet(publicPartMap, name).add(pub);
		}
		if (pub != null) {
			getSet(privatePartMap, name).add(priv);
		}
	}
	
	private void markDuplicates(final AnalysisErrorReporterManager errManager) {
		//Mark property sets
		for (final Map.Entry<String, Set<PropertySet>> entry : propertySetMap.entrySet()) {
			final Set<PropertySet> psets = entry.getValue();
			if (psets.size() > 1) {
				/* Check to see if a property set in a project shadows a property set
				 * provided by a plug-in.  If there are multiple property sets with
				 * the same name provided by plug-ins, then we do not consider it
				 * shadowed because things are just really messed up.
				 */
				PropertySet predeclared = null;
				boolean multiplePredeclared = false;
				for (final PropertySet pset : psets) {
					if (OsateResourceManager.isPredeclaredResource(pset.eResource())) {
						if (predeclared == null) {
							predeclared = pset;
						} else {
							//Multiple predeclared with the same name -- this is just bad
							multiplePredeclared = true;
						}
					}
				}
				
				/* Report shadowing if there is a single plug-in provided property
				 * set and 1 or more property sets in projects with the same name.
				 */
				if (!multiplePredeclared && predeclared != null) {
					for (final PropertySet pset : psets) {
						if (pset != predeclared) {
							errManager.info(pset, "Property set \"" + entry.getKey() + "\" shadows a plug-in provided property set of the same name");
						} else {
//							OsateResourceManager.removeResource(predeclared.eResource());
							//Mark the Resource as shadowed
							((Aadl2ResourceImpl)predeclared.eResource()).setShadowed(true);
//							//Unmark the resource as being "just parsed" so it won't get name resolved
							((Aadl2ResourceImpl)predeclared.eResource()).setJustParsed(false);
						}
					}
					
					//Ignore the shadowed property set in the duplicates count
					if (psets.size() > 2) {
						for (final PropertySet pset : psets) {
							if (pset != predeclared) {
								errManager.error(pset, "Property set \"" + entry.getKey() + "\" defined more than once");
							}
						}
					}
				} else {
					for (final PropertySet pset : psets) {
						errManager.error(pset, "Property set \"" + entry.getKey() + "\" defined more than once");
					}
				}
			}
		}
		
		//Mark public sections of packages
		for (final Map.Entry<String, Set<PublicPackageSection>>entry : publicPartMap.entrySet()) {
			final Set<PublicPackageSection> pubs = entry.getValue();
			if (pubs.size() > 1) {
				for (final PublicPackageSection pub : pubs) {
					errManager.error(pub, "Public part of package \"" + entry.getKey() + "\" defined more than once");
				}
			}
		}
		
		//Mark private sections of packages
		for (final Map.Entry<String, Set<PrivatePackageSection>> entry : privatePartMap.entrySet()) {
			final Set<PrivatePackageSection> privs = entry.getValue();
			if (privs.size() > 1) {
				for (final PrivatePackageSection priv : privs) {
					errManager.error(priv, "Private part of package \"" + entry.getKey() + "\" defined more than once");
				}
			}
		}
		
		/*
		 * Mark packages and property sets that have the same name.  A property set and a package cannot share a name.
		 * This is because packages and property sets are a part of the global namespace in AADL2.
		 */
		//Get the intersection of publicPartMap.keySet() and propertySetMap.keySet()
		final Set<String> publicSectionNames = new HashSet<String>(publicPartMap.keySet());
		publicSectionNames.retainAll(propertySetMap.keySet());
		//Get the intersection of privatePartMap.keySet() and propertySetMap.keySet()
		final Set<String> privateSectionNames = new HashSet<String>(privatePartMap.keySet());
		privateSectionNames.retainAll(propertySetMap.keySet());
		//Get the union of publicSectionNames and privateSectionNames
		final Set<String> duplicateNames = new HashSet<String>(publicSectionNames);
		duplicateNames.addAll(privateSectionNames);
		//Are there packages and property sets that share a name?
		if (!duplicateNames.isEmpty())
		{
			//Get all the AadlPackage objects that share a name with a property set.  This is done so that error markers
			//are placed on the AadlPackage object, not on the PackageSection object.
			final Map<String, Set<AadlPackage>> aadlPackageMap = new HashMap<String, Set<AadlPackage>>();
			for (final String name : duplicateNames)
			{
				aadlPackageMap.put(name, new HashSet<AadlPackage>());
				for (final PublicPackageSection publicSection : publicPartMap.get(name))
					aadlPackageMap.get(name).add((AadlPackage)publicSection.eContainer());
				for (final PrivatePackageSection privateSection : privatePartMap.get(name))
					aadlPackageMap.get(name).add((AadlPackage)privateSection.eContainer());
			}
			//Mark the errors
			for (final String name : duplicateNames)
			{
				for (final PropertySet propertySet : propertySetMap.get(name))
					errManager.error(propertySet, "Property set \"" + name + "\" has the same name as a package.");
				for (final AadlPackage aadlPackage : aadlPackageMap.get(name))
					errManager.error(aadlPackage, "Package \"" + name + "\" has the same name as a property set.");
			}
		}
	}
}