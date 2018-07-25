import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import common.GraphObject;
import org.junit.Test;
import po.*;
import po.properties.CommonConfig;
import po.properties.Item;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class testUUID {


    @Test
    public void test(){


       // System.out.println(UUID.randomUUID());
        Item item = new Item();

        List<String> ls = new ArrayList<>();
        ls.add("abc");
        ls.add("abc2");
        item.setId("ewrewrewr");
        item.setGroup(ls);
       //System.out.println(JSONObject.toJSON(item));


        //System.out.println(JSONObject.toJSON(item));
    }

    @Test
    public void testGroup() throws Exception {


      //  CommonConfig.getInstance(GraphObject.PIPE);
//        System.out.println(JSONObject.toJSON(new Graph()));
//        System.out.println(JSONObject.toJSON(new Pipe("�ܵ�1",10.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Insump("��ˮ��",20.0,100.0)));System.out.println(JSONObject.toJSON(new OutPool("��ˮ��",30.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Value_A("����fa",30.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Value_B("��",40.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Value_F("����",50.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Press("ѹ������",60.0,100.0)));
//        System.out.println(JSONObject.toJSON(new Node("�ڵ�",70.0,100.0)));
//        System.out.println(JSONObject.toJSON(new OutPool("��ˮ��",80.0,100.0)));

        //����һ��ͼ
       Graph graph = new Graph();
//       Pipe pipe1 = new Pipe("�ܵ�1",10.0,100.0);
//       Pipe pipe2 = new Pipe("�ܵ�2",60.0,100.0);
//       OutPool pool = new OutPool("��ˮ��",0.0,100.0);
//       Insump  insumppool = new Insump("��ˮ��",200.0,100.0);
//       Node node1 = new Node("�ڵ�1",5.0,100.0);
//        Node node2 = new Node("�ڵ�2",35.0,100.0);
//        Node node3 = new Node("�ڵ�3",65.0,100.0);

    Surgetank surgetank = new Surgetank("��ˮ��",1.0,10.0);
    OverFlow overFlow = new OverFlow("������",2.0,3.0);
    Value_N value_n = new Value_N("������",1.3,3.5);
    Bleeder bleeder = new Bleeder("��ˮ��",1.3,3.5);
    graph.addEquipment(surgetank);
    graph.addEquipment(overFlow);
    graph.addEquipment(value_n);
    graph.addEquipment(bleeder);

//        graph.addLink(pool,node1);
//        graph.addLink(node1,pipe1);
//        graph.addLink(pipe1,node2);
//        graph.addLink(node2,pipe2);
//        graph.addLink(pipe2,node3);
//        graph.addLink(node3,insumppool);
//        graph.addEquipment(pipe1);
//        graph.addEquipment(pipe2);
//        graph.addEquipment(pool);
//        graph.addEquipment(insumppool);
//        graph.addEquipment(node1);
//        graph.addEquipment(node2);
//        graph.addEquipment(node3);
//        JSONObject.toJSON(graph);
        SerializeConfig config = new SerializeConfig();
        System.out.println(JSONObject.toJSONString(graph,SerializerFeature.DisableCircularReferenceDetect));
        //System.out.println(JSONObject.toJSON(CommonConfig.getInstance(GraphObject.PRESS)));
       // System.out.println(JSONObject.toJSON(CommonConfig.getInstance(GraphObject.VALUE_B)));
       // System.out.println(JSONObject.toJSON(CommonConfig.getInstance(GraphObject.VALUE_F)));
    }
}
