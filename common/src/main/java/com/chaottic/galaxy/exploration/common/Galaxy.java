package com.chaottic.galaxy.exploration.common;

public final class Galaxy {
    private final long seed;

    private Galaxy(long seed) {
        this.seed = seed;
    }

    public static Galaxy of(long seed) {
        return new Galaxy(seed);
    }
}
