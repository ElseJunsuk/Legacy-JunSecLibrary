package me.else_junsuk.junseclibrary.datasapi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SLAPI = Saving/Loading API
 * API for Saving and Loading Objects.
 * 오브젝트를 저장/로드할 수 있는 API입니다.
 * @author Tomsik68
 */
public class D {

    public static void save(Object obj, String path) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public static Object load(String path) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Object result = ois.readObject();
        ois.close();
        return result;
    }

}
