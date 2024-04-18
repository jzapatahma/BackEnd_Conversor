package com.conversor;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HistorialConversion {
    public LocalDate fecha;
    public LocalDateTime hora;
    private String  base_code;
    private String target_code;
    private Double conversion_rate;
    private Double conversion_total;
    //
    public HistorialConversion(LocalDate fecha, LocalDateTime hora, String base_code, String target_code, Double conversion_rate, Double conversion_total) {
        this.fecha = fecha;
        this.hora = hora;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_total = conversion_total;
    }
    public HistorialConversion() {
    }
    //
    // Getter y Setter
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getBase_code() {
        return base_code;
    }
    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }
    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Double getConversion_total() {
        return conversion_total;
    }
    public void setConversion_total(Double conversion_total) {
        this.conversion_total = conversion_total;
    }
    //
    // Metodos
    public Double getConversion_rate() { return conversion_rate; }

    @Override
    public String toString() {
        return "HistorialConversion{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_total=" + conversion_total +
                '}';
    }
}


class LocalDateSerializer implements JsonSerializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    @Override
    public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(localDate));
    }
}

class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH::mm::ss");
    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(localDateTime));
    }
}

class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDate.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ENGLISH));
    }
}

class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("HH::mm::ss").withLocale(Locale.ENGLISH));
    }
}
