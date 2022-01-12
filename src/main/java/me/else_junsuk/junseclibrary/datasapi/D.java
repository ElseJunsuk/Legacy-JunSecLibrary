package me.else_junsuk.junseclibrary.datasapi;

import java.io.*;

public class D {

    /**
     * 새로운 파일을 생성합니다.
     *
     * @param datafolder 데이터 폴더
     * @param path '/'는 제외하여 폴더명만 기입 해야 합니다
     * @return file
     */
    public static File getPathFolder(File datafolder, String path) {
        File file = new File(datafolder + "/" + path);
        return file;
    }

}
