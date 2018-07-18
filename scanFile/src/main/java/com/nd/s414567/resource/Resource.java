package com.nd.s414567.resource;

import com.nd.s414567.file.FileStatus;
import org.darkphoenixs.pool.PoolConfig;
import org.darkphoenixs.pool.socket.SocketConnectionPool;

import java.io.File;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */


public class Resource {



    private static class Inner{
        static {
            PoolConfig config = new PoolConfig();
            config.setMaxTotal(20);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(1000);
            config.setTestOnBorrow(true);
            Properties props = new Properties();
            props.setProperty("address", "localhost:1234");
            props.setProperty("receiveBufferSize", "3072");
            props.setProperty("sendBufferSize", "3072");
            props.setProperty("connectionTimeout", "2000");
            props.setProperty("soTimeout", "2000");
            pool = new SocketConnectionPool(config, props);
        }


        public static SocketConnectionPool pool;
        public static ConcurrentHashMap<String,Object> map=new ConcurrentHashMap<>();
        public static BlockingQueue<FileStatus> queue=new ArrayBlockingQueue<>(16);



    }
    public static  ConcurrentHashMap getFileMap(){
        return Inner.map;
    }
    public static BlockingQueue getQueue(){
        return Inner.queue;
    }
    public static Socket getConnection(){
        return Inner.pool.getConnection();
    }
    public static void  returnConnection(Socket socket){
         Inner.pool.returnConnection(socket);
    }




}
