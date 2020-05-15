package cn.funeralobjects.demo.jpa.converter;

import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author FuneralObjects
 * Create date: 2020/5/15 4:02 PM
 */
public class PathConverter implements AttributeConverter<List<Integer>, String> {
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return CollectionUtils.isEmpty(attribute) ? null : attribute.stream().filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(":"));
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        return dbData == null ? new ArrayList<>(0) : Arrays.stream(dbData.split(":")).map(Integer::valueOf).collect(Collectors.toList());
    }
}
