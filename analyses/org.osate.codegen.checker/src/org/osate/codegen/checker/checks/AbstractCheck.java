package org.osate.codegen.checker.checks;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.codegen.checker.report.ErrorReport;

public abstract class AbstractCheck {
	private List<ErrorReport> errors;
	public static final int CHECKER_KIND_POK = 1;
	public static final int CHECKER_KIND_VXWORKS = 2;
	public static final int CHECKER_KIND_DEOS = 3;
	public static final int CHECKER_KIND_UNKNOWN = -1;

	private int kind;

	public AbstractCheck() {
		errors = new ArrayList<ErrorReport>();
	}

	public List<ErrorReport> getErrors() {
		return this.errors;
	}

	public void addError(ErrorReport er) {
		this.errors.add(er);
	}

	abstract public void perform(SystemInstance si);

	public boolean pok() {
		return (this.kind == CHECKER_KIND_POK);
	}

	public boolean vxworks() {
		return (this.kind == CHECKER_KIND_VXWORKS);
	}

	public boolean deos() {
		return (this.kind == CHECKER_KIND_DEOS);
	}

	public void setKind(int k) {
		this.kind = k;
	}
}
