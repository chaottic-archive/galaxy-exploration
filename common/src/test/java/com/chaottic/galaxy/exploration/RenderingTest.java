package com.chaottic.galaxy.exploration;

import org.joml.Matrix4f;
import org.junit.jupiter.api.Test;

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
}
