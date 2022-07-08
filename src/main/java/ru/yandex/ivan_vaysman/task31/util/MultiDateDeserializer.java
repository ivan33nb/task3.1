package ru.yandex.ivan_vaysman.task31.util;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MultiDateDeserializer extends StdDeserializer<Date> {

    private static final String[] DATE_FORMATS = new String[] {
            "hh:mm:ss a",
            "MMMM dd, yyyy"
    };

    public MultiDateDeserializer() {
        this(null);
    }

    public MultiDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        final String date = node.textValue();

        if(date.equalsIgnoreCase("N/A")){
            throw new JsonParseException(jp, "date value is - " + date);
        }
        for (String DATE_FORMAT : DATE_FORMATS) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
                return simpleDateFormat.parse(date);
            } catch (ParseException e) {

            }
        }
        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}
