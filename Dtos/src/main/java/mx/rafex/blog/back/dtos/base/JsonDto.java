package mx.rafex.blog.back.dtos.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDto {

    private JsonDto() {
    }

    public static Gson obtenerConvertidorJson(final boolean serializeNulls) {

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting()
                .disableHtmlEscaping();

        if (serializeNulls) {
            builder.serializeNulls();
        }

        return builder.create();
    }

    public static Gson obtenerConvertidorJson() {
        return obtenerConvertidorJson(false);
    }

    public static String aJson(final Object object) {
        return JsonDto.obtenerConvertidorJson().toJson(object);
    }

}
