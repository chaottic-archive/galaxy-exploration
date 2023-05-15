package com.chaottic.galaxy.exploration;

import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public final class RenderingTest {

    // Not out writing runtime exception details for this test!
    @Test
    public void test() {

        if (!glfwInit()) {
            throw new RuntimeException();
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6);
        glfwWindowHint(GLFW_CONTEXT_RELEASE_BEHAVIOR, GLFW_RELEASE_BEHAVIOR_FLUSH);

        long window;
        if ((window = glfwCreateWindow(100, 100, "Galaxy Exploration Rendering Test", NULL, NULL)) == NULL) {
            glfwTerminate();
            throw new RuntimeException();
        }

        var projection = new Matrix4f();
        var modelView = new Matrix4f();

        while (!glfwWindowShouldClose(window)) {

            glfwPollEvents();
            glfwSwapBuffers(window);
        }

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
    }
    
    private static InputStream getResource(String path) throws IOException {
        return Objects.requireNonNull(RenderingTest.class.getClassLoader().getResource(path)).openStream();
    }

    private static String readString(String path) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(getResource(path)))) {
            var builder = new StringBuilder();

            @Nullable
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            return builder.toString();
        }
    }
}
