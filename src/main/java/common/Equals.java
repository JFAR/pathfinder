package common;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Equals {

    private Equals() {
    }

    public static boolean reflectionEquals(Object obj1, Object obj2) {
        return reflectionEqualsIgnoringFields(obj1, obj2);
    }

    public static boolean reflectionEqualsIgnoringFields(Object obj1, Object obj2, String... fieldsToIgnore) {
        return EqualsBuilder.reflectionEquals(obj1, obj2, fieldsToIgnore);
    }
}