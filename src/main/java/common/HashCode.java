package common;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class HashCode {

    private HashCode() {
    }

    public static int reflectionHashCode(Object obj) {
        return HashCodeBuilder.reflectionHashCode(obj);
    }
}