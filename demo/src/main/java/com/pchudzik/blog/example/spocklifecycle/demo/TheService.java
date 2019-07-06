package com.pchudzik.blog.example.spocklifecycle.demo;

import java.util.List;
import java.util.stream.Collectors;

public class TheService {
    private final Toggler toggler;

    public TheService(Toggler toggler) {
        this.toggler = toggler;
    }

    public List<Integer> doProcess(List<Integer> integers) {
        return integers.stream()
                .map(i -> i + 1)
                .map(this::doExtraProcessing)
                .collect(Collectors.toList());
    }

    private int doExtraProcessing(Integer i) {
        final int extraValue = toggler.isExtraProcessingEnabled() ? -1 : 1;
        return i * extraValue;
    }
}
