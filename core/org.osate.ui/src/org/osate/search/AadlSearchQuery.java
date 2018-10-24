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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
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
			nonNullmonitor.beginTask(getLabel(), IProgressMonitor.UNKNOWN);
			final AadlFinder aadlFinder = AadlFinder.getInstance();
			final EClass declarationEClass = searchFor.declarationEClass();
			aadlFinder.processAllAadlFilesInScope(scope, (callback, resourceSet, rsrcDesc) -> {
				final String fileString = rsrcDesc.getURI().lastSegment();
				nonNullmonitor.subTask(fileString);
				if (limitTo.declarations()) {
					callback.getAllObjectsOfTypeInResource(rsrcDesc, resourceSet, searchFor.declarationEClass(),
							(callback2, resourceSet2, objDesc2) -> {
								// now check the name, which in the last segment (skip over the package names)
								final String testIdentifier = objDesc2.getName().getLastSegment();
								if (findSubstring(testIdentifier)) {
									// FOUND A MATCH
									searchResult.addFoundDeclaration(resourceSet2, objDesc2);
								}
							});
					nonNullmonitor.worked(1);
				}

				if (nonNullmonitor.isCanceled()) {
					throw new OperationCanceledException();
				}

				if (limitTo.references()) {
					callback.getAllReferencesToTypeInResource(rsrcDesc, resourceSet,
							(callback2, resourceSet2, refDesc2) -> {
								final URI targetURI = refDesc2.getTargetEObjectUri();
								final EObject eObj = resourceSet2.getEObject(targetURI, true);
								if (eObj != null) { // target object might be null if the file being searched has errors
									// filter by eClass
									if (declarationEClass.isSuperTypeOf(eObj.eClass())) {
										// filter by name
										if (eObj instanceof NamedElement
												&& findSubstring(((NamedElement) eObj).getName())) {
											// FOUND A MATCH
											searchResult.addFoundReference(resourceSet2, refDesc2);
										}
									}
								}
							});
					nonNullmonitor.worked(1);
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
