package org.osate.importer.model.sm;

import org.osate.importer.Utils;

public class Transition {
	private String name;
	private State srcState;
	private State dstState;
	private int identifier;
	private int srcStateIdentifier;
	private int dstStateIdentifier;
	private String condition;
	private String action;

	public Transition() {
		this.name = null;
		this.identifier = Utils.INVALID_ID;
		this.srcState = null;
		this.dstState = null;
		this.srcStateIdentifier = Utils.INVALID_ID;
		this.dstStateIdentifier = Utils.INVALID_ID;
		this.condition = "";
		this.action = "";
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String s) {
		this.condition = s;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String a) {
		this.action = a;
	}

	public int getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(int i) {
		this.identifier = i;
	}

	public void setSrcStateIdentifier(int id) {
		this.srcStateIdentifier = id;
	}

	public void setDstStateIdentifier(int id) {
		this.dstStateIdentifier = id;
	}

	public int getDstStateIdentifier() {
		return this.dstStateIdentifier;
	}

	public int getSrcStateIdentifier() {
		return this.srcStateIdentifier;
	}

	public void setSrcState(State src) {
		this.srcState = src;
	}

	public void setDstState(State dst) {
		this.dstState = dst;
	}

	public State getDstState() {
		return (this.dstState);
	}

	public State getSrcState() {
		return (this.srcState);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		String s = n.replace('\n', '_');
		this.name = s;
	}

	public String toString() {
		String res;
		res = "";

		if (this.name != null) {
			res += "name=" + name;
		}

		if (this.identifier != Utils.INVALID_ID) {
			res += "|id=" + this.identifier;
		}

		if (this.srcState != null) {
			res += "|src state name=" + this.srcState.getName();
		}

		if (this.dstState != null) {
			res += "|dst state name=" + this.dstState.getName();
		}

		return res;
	}
}
