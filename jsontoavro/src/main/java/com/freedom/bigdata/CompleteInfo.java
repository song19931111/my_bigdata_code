package com.freedom.bigdata;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/07
 */
public class CompleteInfo implements Serializable {

    public Set<String> hashSet = new HashSet<>();
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> completequeue = new LinkedBlockingQueue<String>();

    public void remove(String key){
        hashSet.remove(key);
    }
    public void add(String key){
        hashSet.add(key);
    }
    public static void Serializable(CompleteInfo info) throws  Exception{
        File file = new File("completeInfo.process");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        fos.close();
    }
    public static CompleteInfo UnSerializable() throws  Exception{
        File file = new File("completeInfo.process");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        CompleteInfo obj= (CompleteInfo) ois.readObject();
        ois.close();
        fis.close();
        Iterator<String> iterator = obj.hashSet.iterator();

        while(iterator.hasNext()){
            String fileInfo  = iterator.next();
            queue.add(fileInfo);
        }
//        CompleteInfo.B



        return obj;


    }

    public static void main(String args[]) throws Exception {
        CompleteInfo info = new CompleteInfo();
        info.add("aaa");
        info.add("bb");
        info.add("acc");
        info.add("dddd");
        CompleteInfo.Serializable(info);
        CompleteInfo completeInfo1 = CompleteInfo.UnSerializable();
        Iterator<String> iterator = completeInfo1.hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
