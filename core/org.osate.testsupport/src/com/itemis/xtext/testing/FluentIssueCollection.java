package com.itemis.xtext.testing;

import static com.itemis.xtext.testing.XtextUtils.ancestor;
import static com.itemis.xtext.testing.XtextUtils.eString;
import static com.itemis.xtext.testing.XtextUtils.egetAndResolve;
import static com.itemis.xtext.testing.XtextUtils.getEObject;
import static com.itemis.xtext.testing.XtextUtils.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterables;

/**
 * Offers a fluent way of asserting Xtext Issues (Validation Warnings and
 * Errors).
 *
 * @author Markus Voelter - Initial Contribution and API
 * @author Karsten Thoms
 * @author Lars Corneliussen
 */
public class FluentIssueCollection implements Iterable<Issue> {

	private static Logger LOGGER = Logger.getLogger(FluentIssueCollection.class);

	private final List<Issue> issues;
	private final List<String> messages;
	private final Resource resource;

	private boolean state;
	private boolean stateIsSet;

	public FluentIssueCollection(final Resource res, final List<Issue> issues, final List<String> messages) {
		resource = res;
		this.issues = issues;
		this.messages = messages;
	}

	public FluentIssueCollection(final Resource res, final List<String> messages) {
		issues = new ArrayList<Issue>();
		resource = res;
		this.messages = messages;
	}

	private void addMessage(final String m) {
		messages.add(m);
	}

	public void addIssue(final Issue issue) {
		issues.add(issue);
	}

	public FluentIssueCollection forType(final Class<? extends EObject> cls) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			final URI uri = i.getUriToProblem();
			final EObject eObject = resource.getEObject(uri.fragment());
			if (cls.isInstance(eObject)) {
				res.addIssue(i);
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("No issues found for type " + cls.getName());
		}
		return res;
	}

	public FluentIssueCollection get(final int index) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		if (index >= getIssueCount()) {
			res.addMessage("trying to get element at " + index + ", but only have " + getIssueCount()
					+ " elements -> creating empty collection!");
		} else {
			res.addIssue(getIssues().get(index));
		}
		return res;
	}

	public FluentIssueCollection inLine(final int lineNo) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		int rc = 0;
		for (final Issue i : issues) {
			if (i.getLineNumber() == lineNo) {
				res.addIssue(i);
				rc++;
			}
		}
		if (rc == 0) {
			res.addMessage("no issues found for line number " + lineNo);
		}
		return res;
	}

	public FluentIssueCollection withStringFeatureValue(final String featureName, final String value) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			final EObject eObject = getEObject(i, resource);
			final String v = eString(egetAndResolve(eObject, featureName, resource.getResourceSet()));
			if (v.contains(value)) {
				res.addIssue(i);
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("no elements found with feature " + featureName + " valued '" + value + "'");
		}
		return res;
	}

	public FluentIssueCollection except(final Set<Issue> toBeRemoved) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);

		if (toBeRemoved != null) {
			for (final Issue i : issues) {
				if (!toBeRemoved.contains(i)) {
					res.addIssue(i);
				}
			}
		}
		return res;
	}

	public FluentIssueCollection errorsOnly() {
		final Severity severity = Severity.ERROR;

		return withSeverity(severity);
	}

	public FluentIssueCollection warningsOnly() {
		final Severity severity = Severity.WARNING;

		return withSeverity(severity);
	}

	public FluentIssueCollection withSeverity(final Severity... severities) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			if (Iterables.contains(Arrays.asList(severities), i.getSeverity())) {
				res.addIssue(i);
			}
		}
		return res;
	}

	public FluentIssueCollection named(final String expectedName) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			final EObject eObject = getEObject(i, resource);
			final String name = name(eObject);
			if (name.contains(expectedName)) {
				res.addIssue(i);
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("no elements found with name " + expectedName);
		}
		return res;
	}

	public FluentIssueCollection forElement(final Class<? extends EObject> cls, final String name) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			final EObject eObject = getEObject(i, resource);
			if (cls.isInstance(eObject)) {
				if (name.equalsIgnoreCase(name(eObject))) {
					res.addIssue(i);
				}
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("no elements of type " + cls.getName() + " named '" + name + "' found");
		}
		return res;
	}

	private int getIssueCount() {
		return issues.size();
	}

	public FluentIssueCollection under(final Class<? extends EObject> cls) {
		return under(cls, null);
	}

	public FluentIssueCollection under(final Class<? extends EObject> cls, final String name) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			final URI uri = i.getUriToProblem();
			final EObject eObject = resource.getEObject(uri.fragment());
			final EObject p = ancestor(eObject, cls);
			if (p != null) {
				if (name != null) {
					if (name.equals(name(p))) {
						res.addIssue(i);
					}
				} else {
					res.addIssue(i);
				}
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("did not find issues under a " + cls.getName() + " named '" + name + "'");
		}
		return res;
	}

	public FluentIssueCollection sizeIs(final int i) {
		if (issues.size() == i) {
			state = true;
		} else {
			addMessage("failed size: expected " + i + ", actual " + issues.size());
			state = false;
		}
		return this;
	}

	public FluentIssueCollection oneOfThemContains(final String substring) {
		boolean found = false;
		for (final Issue i : issues) {
			if (i.getMessage().toLowerCase().contains(substring.toLowerCase())) {
				found = true;
			}
		}
		if (found) {
			reportOk();
		} else {
			addMessage("failed oneOfThemContains: none of the issues contains substring '" + substring + "'");
			reportError();
		}
		return this;
	}

	public FluentIssueCollection nOfThemContain(final int n, final String substring) {
		int count = 0;
		for (final Issue i : issues) {
			if (i.getMessage().toLowerCase().contains(substring.toLowerCase())) {
				count++;
			}
		}
		if (count == n) {
			reportOk();
		} else {
			addMessage("failed nOfThemContain: expected " + n + " with substring '" + substring + "', but '" + count
					+ "' found.");
			reportError();
		}
		return this;
	}

	public FluentIssueCollection allOfThemContain(final String substring) {
		for (final Issue i : issues) {
			if (!i.getMessage().toLowerCase().contains(substring.toLowerCase())) {
				reportError();
				addMessage("failed allOfThemContain: not all issues contain the substring '" + substring + "'");
			}
		}
		reportOk();
		return this;
	}

	public FluentIssueCollection theOneAndOnlyContains(final String substring) {
		if (issues.size() > 1) {
			reportError();
			addMessage("failed theOneAndOnlyContains: expecting a single issue (theSingleOneReads) but found: "
					+ issues.size());
			for (final Issue issue : issues) {
				LOGGER.debug("  line " + issue.getLineNumber() + ": " + issue.getMessage() + " / "
						+ issue.getUriToProblem());
			}
			return this;
		}
		return oneOfThemContains(substring);
	}

	/**
	 * Filters all issues with a specific {@link Issue#getCode() issue code}.
	 * 
	 * @param code
	 *            Issue code
	 * @return A new instance containing the issues with the given code.
	 */
	public FluentIssueCollection withCode(final String code) {
		final FluentIssueCollection res = new FluentIssueCollection(resource, messages);
		for (final Issue i : issues) {
			if (i.getCode().equals(code)) {
				res.addIssue(i);
			}
		}
		if (res.getIssueCount() == 0) {
			res.addMessage("failed withCode: no issues found with code '" + code + "'");
		}
		return res;
	}

	public boolean evaluate() {
		return state;
	}

	protected void reportOk() {
		if (stateIsSet) {
			if (state) {
				state = true;
			}
			if (!state) {
				state = false;
			}
		} else {
			state = true;
		}
		stateIsSet = true;
	}

	protected void reportError() {
		if (stateIsSet) {
			if (state) {
				state = false;
			}
			if (!state) {
				state = false;
			}
		} else {
			state = false;
		}
		stateIsSet = true;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public Resource getResource() {
		return resource;
	}

	public List<String> getMessages() {
		return messages;
	}

	public String getMessageString() {
		final StringBuffer sb = new StringBuffer();
		for (final String m : messages) {
			sb.append("\n  - " + m);
		}
		return sb.toString();
	}

	public void dumpIssues() {
		LOGGER.debug("--- Issues ---");
		for (final Issue i : issues) {
			dumpIssue(resource, i);
		}
	}

	public String getSummary() {
		if (issues.size() == 0) {
			return "No issues";
		}

		final StringBuffer sb = new StringBuffer();
		sb.append("Issues:");
		for (final Issue i : issues) {
			sb.append("\n  - " + getIssueSummary(resource, i));
		}
		return sb.toString();
	}

	public static void dumpIssue(final Resource resource, final Issue issue) {
		LOGGER.debug(getIssueSummary(resource, issue));
	}

	public static String getIssueSummary(final Resource resource, final Issue issue) {
		boolean validFragment = true;
		if (issue.getUriToProblem() == null || "//".equals(issue.getUriToProblem().fragment())) {
			validFragment = false;
		}

		if (validFragment) {
			final EObject eObject = resource.getEObject(issue.getUriToProblem().fragment());
			final EClass cls = eObject.eClass();
			return issue.getSeverity() + " at " + cls.getName() + "( line " + issue.getLineNumber() + "): "
					+ issue.getMessage();
		} else {
			return issue.getSeverity() + "( line " + issue.getLineNumber() + "): " + issue.getMessage();
		}
	}

	@Override
	public Iterator<Issue> iterator() {
		return issues.iterator();
	}

}
