package me.else_junsuk.junseclibrary.datasapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class FolderApi {

    private JavaPlugin plugin;

    public FolderApi(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 폴더 속 새로운 파일을 생성합니다.
     *
     * @param folder 데이터 폴더 (상위 폴더)
     * @param path '/'를 제외한 파일명
     * @return {@link java.util.List}
     */
    public File getFolder(File folder, String path) {
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder + "/" + path);
        return file;
    }

}
