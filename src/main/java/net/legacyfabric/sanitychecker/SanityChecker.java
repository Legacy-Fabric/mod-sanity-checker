package net.legacyfabric.sanitychecker;


import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class SanityChecker
{
    public static void markSane()
    {
        Path runDir = FabricLoader.getInstance().getGameDir();
        Path target = runDir.resolve("sane");
        try {
            Files.createFile(target);
        } catch (IOException e) {
            // what
        }
    }
}
