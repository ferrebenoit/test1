/**
 * 
 */
package org.distribution.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.distribution.InstallState;

/**
 * @author ben
 *
 */
@Converter(autoApply = true)
public class InstallstateConverter  implements AttributeConverter<InstallState, String> {

	@Override
	public String convertToDatabaseColumn(InstallState attribute) {
		return attribute.getShortName();
	}

	@Override
	public InstallState convertToEntityAttribute(String dbData) {
		return InstallState.fromShortName(dbData);
	}

}
