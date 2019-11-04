package org.osate.analysis.security;

public enum Algorithm {
	AES(true, 128, 256), DES(true, 0, 0), TripleDES(true, 0, 0), RSA(false, 1024, 2048), ECC(false, 256, 512);

	private final boolean symmetric;
	private final int minKeyLength;
	private final int prefKeyLength;

	Algorithm(boolean symmetric, int minKeyLength, int prefKeyLength) {
		this.symmetric = symmetric;
		this.minKeyLength = minKeyLength;
		this.prefKeyLength = prefKeyLength;
	}

	public boolean isSymmetric() {
		return symmetric;
	}

	public boolean isASymmetric() {
		return !symmetric;
	}

	public int getMinKeyLength() {
		return minKeyLength;
	}

	public int getPrefKeyLength() {
		return prefKeyLength;
	}
}
