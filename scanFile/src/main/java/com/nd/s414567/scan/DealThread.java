package com.nd.s414567.scan;

import com.nd.s414567.file.FileStatus;
import com.nd.s414567.resource.Resource;

import java.io.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/18
 */
public class DealThread implements Runnable {

    private FileStatus fileStatus;

    public DealThread(FileStatus fileStatus){
        this.fileStatus = fileStatus;
    }
    @Override
    public void run() {



            LineNumberReader reader = null;
            FileReader in =null;
            try {
                if(fileStatus.getStatus() == FileStatus.MODIFY_ON){
                    return;
                }

                if (fileStatus.isNeedRead() == false) {
                    return;
                }
                 in = new FileReader(fileStatus.getFileName());
                 reader = new LineNumberReader(in);
                 fileStatus.setStatus(FileStatus.MODIFY_ON);
                int startIndex = 1;
                if (fileStatus.getStartIndex() != -1) {
                    startIndex = fileStatus.getStartIndex();
                }
                String line = reader.readLine();
                int lineIndex = 0;
                while (line != null) {
                    if (reader.getLineNumber() >= startIndex) {
                        System.out.println(line);
                        startIndex++;
                    }
                    line = reader.readLine();
                }
                fileStatus.setStartIndex(startIndex);
            } catch (Exception e) {
                    e.printStackTrace();
            }finally {
                fileStatus.setStatus(FileStatus.MODIFY_OFF);
                try {
                    reader.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
