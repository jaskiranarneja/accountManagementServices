package com.accountservice.account.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MaskStringValueSerializer extends StdSerializer<Object> implements ContextualSerializer {
    String asterisk;
    private Mask annot;

    public MaskStringValueSerializer() {
        super(Object.class);
    }

    public MaskStringValueSerializer(String asterisk) {
        super(Object.class);
        this.asterisk = asterisk;
    }

    public void serialize(Object s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(asterisk);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        annot = beanProperty.getAnnotation(Mask.class);
        return new MaskStringValueSerializer(annot.value());
    }
}
