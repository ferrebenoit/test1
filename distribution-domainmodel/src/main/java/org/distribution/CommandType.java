/**
 * 
 */
package org.distribution;

/**
 * @author ben
 *
 */
public enum CommandType {
	INSTALL (1),
	REMOVE  (2),
	UPDATE  (3);

	private Integer shortName;

	CommandType(Integer shortName) {
		this.shortName = shortName;
	}

	public Integer getShortName() {
		return this.shortName;
	}

	public static CommandType fromShortName(Integer shortName) {
		for (CommandType v : CommandType.values()) {
			if (v.getShortName().equals(shortName)) {
				return v;
			}
		}

		throw new IllegalArgumentException("No Installstate with shortName ["
				+ shortName + "] found.");
	}



}
