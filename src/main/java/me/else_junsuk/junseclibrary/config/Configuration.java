package me.else_junsuk.junseclibrary.config;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private File customConfigFile;
    private FileConfiguration customConfig;

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public File getCustomFile() {
        return this.customConfigFile;
    }

    public void createCustomConfig(String fileName) {
        customConfigFile = new File(JunSecLibrary.getMain().getDataFolder(), fileName);
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            JunSecLibrary.main.saveResource(fileName, false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
