package com.pchudzik.blog.example.spocklifecycle.demo;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public final class Toggler {
    public static final String EXTRA_PROCESSING = "extraProcessingEnabled";
    private static final Toggler INSTANCE = new Toggler();
    private final Map<String, Boolean> toggles = Stream
            .of(
                    new SimpleEntry<>(EXTRA_PROCESSING, false))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

    private Toggler() {
    }

    public static Toggler getInstance() {
        return INSTANCE;
    }

    public boolean isExtraProcessingEnabled() {
        return toggles.getOrDefault(EXTRA_PROCESSING, false);
    }

    public boolean getValue(String key) {
        return toggles.get(key);
    }

    public void setValue(String key, boolean value) {
        toggles.put(key, value);
    }
}
