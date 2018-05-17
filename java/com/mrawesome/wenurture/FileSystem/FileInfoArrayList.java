package com.mrawesome.wenurture.FileSystem;

/**
 * Created by sanch on 07-04-2018 for WeNurture-SQLiteConnectivity.
 */
public class FileInfoArrayList {

    private String fileName;
    private final int NO_ID = -1;
    private int fileType;
    private String fileDir; //path where file is saved

    public FileInfoArrayList(String fileName, int fileType, String fileDir) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileDir = fileDir;
    }
    public FileInfoArrayList(String fileName, int fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileType() {
        return fileType;
    }

    public String getFileDir() {
        return fileDir;
    }
}
