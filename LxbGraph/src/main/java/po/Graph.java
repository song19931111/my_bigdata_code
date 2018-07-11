package po;

import common.GraphObject;
import po.properties.CommonConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Graph {

    public List<Object>cells= new ArrayList<>();

    public void addEquipment(Object obj){
        cells.add(obj);
    }

    public void addLink(Object obj1,Object obj2) throws Exception {
        String portID="";
        String targetID="";
        String sourceId;

        if(obj1 instanceof Node){
            //节点连设备
            if(!(obj2 instanceof IEquipment)){
                throw  new Exception("一个是节点另外一个必须是设备");
            }
            IEquipment equipment = (IEquipment)obj2;
            List<String> portId = equipment.getPortId();
            if(portId.size() >2 || portId.size() ==0){
                throw  new Exception("该设备有2个以上的IN OUT 或者没有进出口");
            }
            portID =portId.get(0);
            targetID = ((Node)obj1).getId();
            sourceId = equipment.getId();
        }else if(obj1 instanceof  IEquipment){
            //设备连节点
            if(!(obj2 instanceof  Node)){
                throw  new Exception("一端是设备另一端要是节点");
            }
            IEquipment equipment = (IEquipment)obj1;
            sourceId = equipment.getId();
            List<String> portId = equipment.getPortId();
            if(portId.size() >2 || portId.size() ==0){
                throw  new Exception("该设备有2个以上的IN OUT 或者没有进出口");
            }
            if(portId.size() == 2){
                portID =portId.get(1);
            }else{
                portID =portId.get(0);
            }

            targetID = ((Node)obj2).getId();

        }else{
            throw  new Exception("对象传入不正常"+" "+obj1.getClass().getName()+" "+obj2.getClass().getName());
        }
        Link link = new Link(sourceId,portID,targetID);

        addEquipment(link);
    }



}
