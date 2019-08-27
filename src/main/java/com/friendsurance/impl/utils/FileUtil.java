package com.friendsurance.impl.utils;

import com.friendsurance.impl.executer.BatchMailExecutor;

public class FileUtil {

    public static String getFilePath(String name){
        String filePath = BatchMailExecutor.class.getClassLoader().getResource(name).getPath();

        return filePath;
    }
}
