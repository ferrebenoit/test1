/**
 * 
 */
package org.distribution;

/**
 * @author ben
 *
 */
public enum InstallState {
	PLANNED   ("P"),
	INSTALLED ("I");

	private String shortName;

	InstallState(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return this.shortName;
	}

	public static InstallState fromShortName(String shortName) {
		for (InstallState v : InstallState.values()) {
			if (v.getShortName().equals(shortName)) {
				return v;
			}
		}

		throw new IllegalArgumentException("No Installstate with shortName ["
				+ shortName + "] found.");
	}


}
