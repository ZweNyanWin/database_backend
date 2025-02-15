package net.physiqueForge.ems.model.converter;
import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import net.physiqueForge.ems.model.constant.BaseEnum;

@Converter(autoApply = true)
public abstract class BaseEnumConverter<E extends Enum<E> & BaseEnum<V>, V> implements AttributeConverter<E, V> {

    private final Class<E> enumClass;

    protected BaseEnumConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public V convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public E convertToEntityAttribute(V dbData) {
        return dbData != null ? BaseEnum.fromValue(enumClass, dbData) : null;
    }
}
