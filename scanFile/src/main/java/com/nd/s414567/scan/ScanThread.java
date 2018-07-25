package com.nd.s414567.scan;

import com.nd.s414567.file.FileStatus;
import com.nd.s414567.resource.Resource;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */
public class ScanThread implements Runnable{


    private ConcurrentHashMap<String,Object>map;
    private BlockingQueue<FileStatus> queue;
    private String path="";
    public ScanThread(String path){
        this.path = path;
    }
    @Override
    public void run() {
        File fileDirectory = new File(path);
        File[] files = fileDirectory.listFiles();
        for(File file:files){
            if(Resource.getFileMap().containsKey(file.getAbsolutePath())){
                FileStatus fileStatus = (FileStatus)Resource.getFileMap().get(file.getAbsolutePath());
                if(fileStatus.getLastModify() != file.lastModified()){
                    fileStatus.setLastModify(file.lastModified());
                    fileStatus.setNeedRead(true);
                    try {
                        if(fileStatus.isNeedRead()){
                            Resource.getQueue().put(fileStatus);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }else{
                    fileStatus.setNeedRead(false);

                }
            }else{
                FileStatus fileStatus = new FileStatus();
                fileStatus.setLastModify(file.lastModified());
                fileStatus.setFileName(file.getAbsolutePath());
                fileStatus.setNeedRead(true);
                Resource.getFileMap().put(file.getAbsolutePath(),fileStatus);
                try {
                    Resource.getQueue().put(fileStatus);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return ;
                }
            }
        }


    }
}
