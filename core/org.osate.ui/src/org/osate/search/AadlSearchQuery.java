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
package org.osate.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.xtext.resource.IResourceDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.search.AadlFinder.ResourceConsumer;
import org.osate.search.AadlFinder.Scope;

public final class AadlSearchQuery implements ISearchQuery {
	public enum SearchFor {
		CLASSIFIER {
			@Override
			public EClass declarationEClass() {
				return Aadl2Package.eINSTANCE.getClassifier();
			}

			@Override
			public String toString() {
				return "classifier";
			}
		},

		PROPERTY {
			@Override
			public EClass declarationEClass() {
				return Aadl2Package.eINSTANCE.getProperty();
			}

			@Override
			public String toString() {
				return "property";
			}
		};

		public abstract EClass declarationEClass();
	}

	public enum LimitTo {
		ALL {
			@Override
			public boolean references() {
				return true;
			}

			@Override
			public boolean declarations() {
				return true;
			}

			@Override
			public String toString() {
				return "references and declarations";
			}
		},

		REFERENCES {
			@Override
			public boolean references() {
				return true;
			}

			@Override
			public boolean declarations() {
				return false;
			}

			@Override
			public String toString() {
				return "references";
			}
		},

		DECLARATIONS {
			@Override
			public boolean references() {
				return false;
			}

			@Override
			public boolean declarations() {
				return true;
			}

			@Override
			public String toString() {
				return "declarations";
			}
		};

		public abstract boolean references();
		public abstract boolean declarations();
	}

	/**
	 * The substring to search for in the identifier name.  This is always in all uppercase because AADL identifiers
	 * are case insensitive.
	 */
	private final String substring;
	private final SearchFor searchFor;
	private final LimitTo limitTo;
	private final Scope scope;
	private final AadlSearchResult searchResult;

	public AadlSearchQuery(final String substring, final SearchFor searchFor, final LimitTo limitTo,
			final Scope scope) {
		this.substring = substring.toUpperCase();
		this.searchFor = searchFor;
		this.limitTo = limitTo;
		this.scope = scope;
		this.searchResult = new AadlSearchResult(this);
	}

	private boolean findSubstring(final String testIdentifier) {
		return testIdentifier.toUpperCase().contains(substring);
	}

	@Override
	public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
		// TDOD Make a proper task out of this!

		// make sure the progress monitor is not null
		final IProgressMonitor nonNullmonitor = monitor == null ? new NullProgressMonitor() : monitor;
		try {
			final AadlFinder aadlFinder = AadlFinder.getInstance();
			final EClass declarationEClass = searchFor.declarationEClass();
			aadlFinder.processAllAadlFilesInScope(scope, new ResourceConsumer<IResourceDescription>() {
				@Override
				protected void begin(final int count) {
					searchResult.setResourceSet(getResourceSet());
					nonNullmonitor.beginTask(getLabel(), count);
				}

				@Override
				protected void skipped(final IResourceDescription rsrcDesc) {
					nonNullmonitor.worked(1);
				}

				@Override
				protected void inScope(final IResourceDescription rsrcDesc) {
					final String fileString = rsrcDesc.getURI().lastSegment();
					nonNullmonitor.subTask(fileString);
					if (limitTo.declarations()) {
						aadlFinder.getAllObjectsOfTypeInResource(rsrcDesc, 
								searchFor.declarationEClass(), objDesc -> {
									// now check the name, which in the last segment (skip over the package names)
									final String testIdentifier = objDesc.getName().getLastSegment();
									if (findSubstring(testIdentifier)) {
										// FOUND A MATCH
										searchResult.addFoundDeclaration(getResourceSet(), objDesc);
									}
								});
						nonNullmonitor.worked(1);
					}

					if (nonNullmonitor.isCanceled()) {
						throw new OperationCanceledException();
					}

					if (limitTo.references()) {
						aadlFinder.getAllReferencesToTypeInResource(rsrcDesc, getResourceSet(), refDesc -> {
							final URI targetURI = refDesc.getTargetEObjectUri();
							final EObject eObj = getResourceSet().getEObject(targetURI, true);
									if (eObj != null) { // target object might be null if the file being searched has errors
										// filter by eClass
										if (declarationEClass.isSuperTypeOf(eObj.eClass())) {
											// filter by name
											if (eObj instanceof NamedElement
													&& findSubstring(((NamedElement) eObj).getName())) {
												// FOUND A MATCH
										searchResult.addFoundReference(getResourceSet(), refDesc);
											}
										}
									}
								});
						nonNullmonitor.worked(1);
					}

					if (nonNullmonitor.isCanceled()) {
						throw new OperationCanceledException();
					}
				}
			});
		} finally {
			nonNullmonitor.done();
		}
		return Status.OK_STATUS;
	}

	@Override
	public String getLabel() {
		return "\"" + substring + "\" in " + searchFor + " " + limitTo;
	}

	@Override
	public boolean canRerun() {
		return true;
	}

	@Override
	public boolean canRunInBackground() {
		return true;
	}

	@Override
	public ISearchResult getSearchResult() {
		return searchResult;
	}

	public LimitTo getLimitTo() {
		return limitTo;
	}
}
