package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Terminal implements Expression {
	private String name;
	private boolean isUpdate;

	public Terminal(String s) {
		name = s;
		isUpdate = false;
	}

	public Terminal(String s, boolean update) {
		this(s);
		isUpdate = update;
	}

	public void setUpdate(boolean b) {
		isUpdate = b;
	}

	public boolean getUpdate() {
		return isUpdate;
	}

	@Override
	public String toString() {
		if (isUpdate) {
			return name + "\'";
		}

		return name;
	}
}
