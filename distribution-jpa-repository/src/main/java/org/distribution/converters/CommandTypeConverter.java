/**
 * 
 */
package org.distribution.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.distribution.CommandType;

/**
 * @author ben
 *
 */
@Converter(autoApply = true)
public class CommandTypeConverter  implements AttributeConverter<CommandType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CommandType attribute) {
		return attribute.getShortName();
	}

	@Override
	public CommandType convertToEntityAttribute(Integer dbData) {
		return CommandType.fromShortName(dbData);
	}

}
