package com.nd.s414567;

import com.nd.s414567.file.FileStatus;
import com.nd.s414567.resource.Resource;
import com.nd.s414567.scan.DealThread;
import com.nd.s414567.scan.ScanThread;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17c
 */
public class ThreadMain {
    public static  void main(String args[]) throws InterruptedException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*2+1);
        executorService.scheduleAtFixedRate(new ScanThread("D:\\MirServer\\LogServer\\BaseDir\\2018-05-16"),1000,3000,TimeUnit.MILLISECONDS);

        ExecutorService execute = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1);







        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    FileWriter fileWriter =null;
                    Random r = new Random();
                    int randomIndex = r.nextInt(10);

                    File file = new File("D:\\MirServer\\LogServer\\BaseDir\\2018-05-16\\log"+String.valueOf(randomIndex)+".txt");
                    try {
                         fileWriter = new FileWriter(file,true);
                         for(int i=0;i<10;i++)
                        fileWriter.write("abcdefg"+String.valueOf(randomIndex)+IOUtils.LINE_SEPARATOR);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        t.start();





        while(true){

            FileStatus fileStatus= (FileStatus)Resource.getQueue().take();
            DealThread thread = new DealThread(fileStatus);
            execute.execute(thread);
        }
    }
}
