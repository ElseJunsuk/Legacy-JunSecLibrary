/*
 *     Copyright (c) 2016-2017 SparklingComet @ http://shanerx.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.else_junsuk.junseclibrary.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author Lori00
 * @version 2.0.1
 *
 * This small collection of methods has been created by @Lori00.
 * Creation date: 22-12-2016
 *
 * This software is open source and free. You may use it for every need without explicit permission from the author. This includes adaptations, modifications and commercial use.
 */
@Deprecated
public class YamlConfig {

    private File YamlConfig;
    private FileConfiguration config;
    private File pluginDataFolder;
    private String name;


    /**
     * @since 1.0.0
     * @param pluginDataFolder The plugin's data directory, accessible with JavaPlugin#getDataFolder();
     * @param name The name of the config file excluding file extensions.
     *
     * Please notice that the constructor does not yet create the YAML-configuration file. To create the file on the disk, use {@link YamlConfig#createConfig()}.
     */

    public YamlConfig(File pluginDataFolder, String name) {

        StringBuilder fileName = new StringBuilder();
        fileName.append(name).append(".yml");
        this.name = fileName.toString();

        YamlConfig = new File(pluginDataFolder, this.name);
        this.pluginDataFolder = pluginDataFolder;
        config = YamlConfiguration.loadConfiguration(YamlConfig);
    }


    /**
     * @since 1.0.0
     * This creates the configuration file. If the data folder is invalid, it will be created along with the config file.
     */
    public void createConfig() {

        if (! YamlConfig.exists()) {

            if (! this.pluginDataFolder.exists()) {

                this.pluginDataFolder.mkdir();
            }

            try {
                YamlConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @since 1.1.0
     * @return ConfigurationSection을 반환합니다.
     */
    public ConfigurationSection getConfigurationSection(String path) {
        return config.getConfigurationSection(path);
    }

    /**
     * @since 1.0.0
     * @return The configuration file's directory. To get its name, use {@link YamlConfig#getName()} instead.
     */
    public File getDirectory() {
        return pluginDataFolder;
    }

    /**
     * @since 1.0.0
     * @return The name of the configuration file, including file extensions.
     * This returns the name of the configuration file with the .yml extension. To get the file's directory, use {@link YamlConfig#getDirectory()}.
     */
    public String getName() {
        return name;
    }


    /**
     * @since 1.0.0
     * @return The config file.
     * This returns the actual File object of the config file.
     */
    public File getFile() {
        return YamlConfig;
    }


    /**
     * @since 1.0.0
     * @return The FileConfiguration object.
     * This returns the actual FileConfiguration object of the config file.
     */
    public FileConfiguration getConfig() {
        return config;
    }


    /**
     * @since 1.0.0
     * @param key The config key, including the path.
     * @param value the config value.
     * Set a default configuration value: if the entered key already exists (and it holds another value), it will do nothing. If it doesn't, it will create the key with the wanted value.
     */
    public void addDefault(String key, String value) {
        if (config.getString(key) == null) {

            config.set(key, value);

            try {
                config.save(YamlConfig);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @since 1.0.0
     * @param defaults A map containing the default configuration keys and values.
     * This sets the default configuration values as the ones contained in the map.
     */
    public void addDefaults(Map<String,Object> defaults) {
        for (String s : defaults.keySet()) {
            this.config.set(s, defaults.get(s));
            try {
                config.save(YamlConfig);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @since 1.0.0
     * This saves the configuration file. Saving is required every time you write to it.
     */
    public void save() {
        try {
            config.save(YamlConfig);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @since 1.0.0
     * This reloads the configuration file, making Java acknowledge and load the new config and its values.
     */
    public void reload() {
        config = YamlConfiguration.loadConfiguration(YamlConfig);
    }


    /**
     * @since 1.0.0
     * This deletes the config file.
     */
    public void deleteFile() {
        YamlConfig.delete();
    }


    /**
     * @since 2.0.0
     * This deletes the config file's directory and all it's contents.
     */
    public void deleteParentDir() {
        this.getDirectory().delete();
    }


    /**
     * @since 1.0.0
     * This deletes and recreates the file, wiping all its contents.
     */
    public void reset() {
        this.deleteFile();
        try {
            YamlConfig.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @since 1.0.0
     * Wipe the config file's directory, including the file itself.
     */
    public void wipeDirectory() {
        this.getDirectory().delete();
        this.pluginDataFolder.mkdir();
    }


    /**
     * @since 1.0.0
     * @param name The sub directory's name.
     * @throws IOException If the entered string has a file extension or already exists.
     * This will create a sub-directory in the plugin's data folder, which can be accessed with {@link YamlConfig#getDirectory()}.
     * If the entered name is not a valid name for a directory or the sub-directory already exists or the data folder does not exist, an IOException will be thrown.
     */
    public void createSubDirectory(String name) throws IOException {
        if (!pluginDataFolder.exists()) {
            throw new IOException("폴더를 찾을 수 없습니다.");
        }

        File subDir = new File(pluginDataFolder, name);

        if (subDir.exists()) {
            throw new IOException("서브 디렉토리(Sub directory)가 이미 존재합니다.");
        }

        subDir.mkdir();
    }


    /**
     * @since 1.0.0
     * @param value
     * @return true or false
     * This returns true if the config contains the given value.
     */
    public boolean contains(String value) {
        return config.contains(value);
    }
}
