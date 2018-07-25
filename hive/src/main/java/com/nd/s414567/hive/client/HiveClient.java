package com.nd.s414567.hive.client;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.RetryingMetaStoreClient;
import org.apache.hadoop.hive.metastore.TableType;
import org.apache.hadoop.hive.metastore.api.*;
import org.apache.hadoop.hive.ql.io.StorageFormatDescriptor;
import org.apache.hadoop.hive.ql.plan.PrivilegeDesc;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.thrift.TException;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/20
 */
public class HiveClient {



    protected final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


    private IMetaStoreClient client;

    public HiveClient() {
        try {

            System.setProperty("HADOOP_USER_NAME","hadoop");
            System.out.println(UserGroupInformation.getCurrentUser());
            URL resource = this.getClass().getResource("/hive-site.xml");
            HiveConf hiveConf = new HiveConf();
            hiveConf.addResource(resource);
            client = RetryingMetaStoreClient.getProxy(hiveConf, true);

        } catch (MetaException ex) {
            logger.error(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllDatabases() {
        List<String> databases = null;
        try {
            databases = client.getAllDatabases();
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return databases;
    }

    public Database getDatabase(String db) {
        Database database = null;
        try {
            database = client.getDatabase(db);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return database;
    }

    public List<FieldSchema> getSchema(String db, String table) {
        List<FieldSchema> schema = null;
        try {
            schema = client.getSchema(db, table);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return schema;
    }

    public List<String> getAllTables(String db) {
        List<String> tables = null;
        try {
            tables = client.getAllTables(db);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return tables;
    }

    public String getLocation(String db, String table) {
        String location = null;
        try {
            location = client.getTable(db, table).getSd().getLocation();
        }catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return location;
    }

    public void getTest() throws TException {


        Table table = client.getTable("game_analysis", "github_orc");
        System.out.println(111);
    }


    public void insert() throws TException, IOException, InterruptedException {

        long time = new Date().getTime();
        StorageDescriptor sd =  new StorageDescriptor();

        sd.setInputFormat("org.apache.hadoop.hive.ql.io.orc.OrcInputFormat");
        sd.setOutputFormat("org.apache.hadoop.hive.ql.io.orc.OrcOutputFormat");
       sd.setCompressed(true);
        sd.setLocationIsSet(false);
        List<FieldSchema>list = new ArrayList<>();

        list.add(new FieldSchema("aaa","bigint","√Ë ˆ"));
        //System.setProperty("HADOOP_USER_NAME","spark");
        UserGroupInformation proxyUser = UserGroupInformation.createProxyUser("spark", UserGroupInformation.getCurrentUser());
        Table table2 = client.getTable("game_analysis", "github_orc");
        Table table = new Table("abcdef","game_analysis","spark",(int)time,(int)time,0,sd,list,null,null,null, "MANAGED_TABLE");
        StorageDescriptor sd1 = table2.getSd();
        sd.setLocation(sd1.getLocation());
        sd.setSerdeInfo(sd1.getSerdeInfo());
        sd.setSkewedInfo(sd1.getSkewedInfo());
        sd.setStoredAsSubDirectories(false);
        sd.setParameters(new HashMap<>());
        sd.setCols(list);
        PrincipalPrivilegeSet set = new PrincipalPrivilegeSet();
        ArrayList<PrivilegeGrantInfo> privilegeGrantInfos = new ArrayList<>();

        PrivilegeGrantInfo privilegeGrantInfo = new PrivilegeGrantInfo("SELECT",(int)time,UserGroupInformation.getCurrentUser().toString(),PrincipalType.USER,false);
        privilegeGrantInfos.add(new PrivilegeGrantInfo("SELECT",(int)time,"spark",PrincipalType.USER,false));
        privilegeGrantInfos.add(new PrivilegeGrantInfo("INSERT",(int)time,"spark",PrincipalType.USER,false));
        privilegeGrantInfos.add(new PrivilegeGrantInfo("UPDATE",(int)time,"spark",PrincipalType.USER,false));
        set.putToUserPrivileges("spark",privilegeGrantInfos);
        table.setPrivileges(set);
        client.createTable(table);



    }
     public static void main(String args[]) throws TException, IOException, InterruptedException {

         HiveClient client = new HiveClient();
         List<String> allDatabases = client.getAllDatabases();
         List<FieldSchema> schemas = client.getSchema("game_analysis", "github_orc");
         client.insert();
//         for(FieldSchema schema:schemas){
//             System.out.println(schema);
//         }

     }




}
