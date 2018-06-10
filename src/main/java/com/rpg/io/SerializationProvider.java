package com.rpg.io;

import com.rpg.util.KillMonsterConstants;

import java.io.*;

public class SerializationProvider<T extends Serializable> {

    public void serializeObject(T object) {
        try {
            FileOutputStream f = new FileOutputStream(new File(KillMonsterConstants.FILE_PATH));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(object);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deSerializeObject(T object) {
        try {
            FileInputStream fi = new FileInputStream(new File(KillMonsterConstants.FILE_PATH));
            ObjectInputStream oi = new ObjectInputStream(fi);
            object = (T) oi.readObject();
            oi.close();
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
