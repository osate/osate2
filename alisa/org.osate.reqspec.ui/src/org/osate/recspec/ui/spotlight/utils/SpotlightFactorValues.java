package org.osate.recspec.ui.spotlight.utils;

/**
 * Class for storing user assigned values for spotlight
 * @author klream
 *
 */
public class SpotlightFactorValues {
	//TODO; There will need to be a screen for user to enter these values and a way to persist this in OSATE
	private double data = 1.28;
	private double ruse = 1.15;
	private double docu = 1.23;
	private double pvol = 1.30;
	private double acap = 0.71;
	private double pcap = 0.76;
	private double pcon = 0.81;
	private double apex = 0.81;
	private double plex = 0.85;
	private double ltex = 0.84;
	private double tool = 0.78;
	private double site = 0.93;
	private double sced = 1.00;
	private double effortEstimationA = 2.94; 
	private double effortEstimationB = 0.91; 
	private double flex = 5.07;
	private double resl = 1.41;
	private double team = 1.10;
	private double pmat = 3.12;
	private double tlc = 10000;

	public SpotlightFactorValues() {
	}

	public double productOfFactorValues(){
		return data * ruse * docu * pvol * acap * pcap * pcon * apex * plex * ltex * tool * site * sced;
	}
	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public double getRuse() {
		return ruse;
	}

	public void setRuse(double ruse) {
		this.ruse = ruse;
	}

	public double getDocu() {
		return docu;
	}

	public void setDocu(double docu) {
		this.docu = docu;
	}

	public double getPvol() {
		return pvol;
	}

	public void setPvol(double pvol) {
		this.pvol = pvol;
	}

	public double getAcap() {
		return acap;
	}

	public void setAcap(double acap) {
		this.acap = acap;
	}

	public double getPcap() {
		return pcap;
	}

	public void setPcap(double pcap) {
		this.pcap = pcap;
	}

	public double getPcon() {
		return pcon;
	}

	public void setPcon(double pcon) {
		this.pcon = pcon;
	}

	public double getApex() {
		return apex;
	}

	public void setApex(double apex) {
		this.apex = apex;
	}

	public double getPlex() {
		return plex;
	}

	public void setPlex(double plex) {
		this.plex = plex;
	}

	public double getLtex() {
		return ltex;
	}

	public void setLtex(double ltex) {
		this.ltex = ltex;
	}

	public double getTool() {
		return tool;
	}

	public void setTool(double tool) {
		this.tool = tool;
	}

	public double getSite() {
		return site;
	}

	public void setSite(double site) {
		this.site = site;
	}

	public double getSced() {
		return sced;
	}

	public void setSced(double sced) {
		this.sced = sced;
	}

	public double getEffortEstimationA() {
		return effortEstimationA;
	}

	public void setEffortEstimationA(double effortEstimationA) {
		this.effortEstimationA = effortEstimationA;
	}

	public double getEffortEstimationB() {
		return effortEstimationB;
	}

	public void setEffortEstimationB(double effortEstimationB) {
		this.effortEstimationB = effortEstimationB;
	}

	public double getFlex() {
		return flex;
	}

	public void setFlex(double flex) {
		this.flex = flex;
	}

	public double getResl() {
		return resl;
	}

	public void setResl(double resl) {
		this.resl = resl;
	}

	public double getTeam() {
		return team;
	}

	public void setTeam(double team) {
		this.team = team;
	}

	public double getPmat() {
		return pmat;
	}

	public void setPmat(double pmat) {
		this.pmat = pmat;
	}

	public double getTlc() {
		return tlc;
	}

	public void setTlc(double tlc) {
		this.tlc = tlc;
	}


}
