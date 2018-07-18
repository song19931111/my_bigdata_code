package com.nd.s414567.file;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */
public class FileStatus {

    public static final int MODIFY_ON = 1;
    public static final int MODIFY_OFF = 0;
    private  String fileName;
    private volatile long lastModify;
    private int startIndex=-1;
    private boolean isNeedRead =false;
    private volatile int status=MODIFY_OFF;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getLastModify() {
        return lastModify;
    }

    public void setLastModify(long lastModify) {
        this.lastModify = lastModify;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public boolean isNeedRead() {
        return isNeedRead;
    }

    public void setNeedRead(boolean needRead) {
        isNeedRead = needRead;
    }

}
