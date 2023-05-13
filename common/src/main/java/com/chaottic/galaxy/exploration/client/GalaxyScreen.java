package com.chaottic.galaxy.exploration.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL31.glDrawElementsInstanced;
import static org.lwjgl.opengl.GL45.*;
import static org.lwjgl.system.MemoryUtil.*;

public final class GalaxyScreen extends Screen {
    private final InstanceRenderer renderer = new InstanceRenderer();

    public GalaxyScreen(Component $$0) {
        super($$0);
    }

    @Override
    public void render(PoseStack $$0, int $$1, int $$2, float $$3) {
        renderer.drawnInstances(0);
    }

    @Override
    public void onClose() {
        super.onClose();
        renderer.destroy();
    }

    // Requires OpenGL 4.6 DSA.
    private static final class InstanceRenderer {
        private final int vao;
        private final int vbo;
        private final int ebo;

        private InstanceRenderer() {
            try (var memoryStack = MemoryStack.stackPush()) {
                var buffer = memoryStack.callocInt(3);

                var address = memAddress(buffer);

                nglCreateVertexArrays(1, address);
                nglCreateBuffers(2, address + 4);

                vao = buffer.get(0);
                vbo = buffer.get(1);
                ebo = buffer.get(2);

                glVertexArrayVertexBuffer(vao, 0, vbo, 0, 16);
                glVertexArrayAttribBinding(vao, 0, 0);
                glVertexArrayAttribFormat(vao, 0, 4, GL_FLOAT, false, 0);

                glVertexArrayElementBuffer(vao, ebo);

                // Upload mesh.
                var cube = createCube();
                var vertices = 16 * 4;
                var elements = 6 * 4;
                var flags = GL_MAP_READ_BIT;

                cube.limit(vertices);
                glNamedBufferStorage(vbo, cube, flags);
                cube.position(vertices);

                cube.limit(vertices + elements);
                glNamedBufferStorage(ebo, cube, flags);
                cube.position(0);

                memFree(cube);
            }
        }

        private void drawnInstances(int previous) {
            glBindVertexArray(vao);

            glEnableVertexArrayAttrib(vao, 0);

            glDrawElementsInstanced(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0, 0);

            glDisableVertexArrayAttrib(vao, 0);

            glBindVertexArray(previous);
        }

        private void destroy() {
            glDeleteVertexArrays(vao);
            glDeleteBuffers(vbo);
            glDeleteBuffers(ebo);
        }

        private static ByteBuffer createCube() {
            var buffer = memCalloc(88 * 4);

            // Front.
            buffer
                    .putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).putFloat(1.0F)
                    .putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).putFloat(1.0F)
                    .putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).putFloat(1.0F)
                    .putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).putFloat(1.0F);

            return buffer.flip();
        }
    }
}
