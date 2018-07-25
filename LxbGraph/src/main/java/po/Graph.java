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
            //�ڵ����豸
            if(!(obj2 instanceof IEquipment)){
                throw  new Exception("һ���ǽڵ�����һ���������豸");
            }
            IEquipment equipment = (IEquipment)obj2;
            List<String> portId = equipment.getPortId();
            if(portId.size() >2 || portId.size() ==0){
                throw  new Exception("���豸��2�����ϵ�IN OUT ����û�н�����");
            }
            portID =portId.get(0);
            targetID = ((Node)obj1).getId();
            sourceId = equipment.getId();
        }else if(obj1 instanceof  IEquipment){
            //�豸���ڵ�
            if(!(obj2 instanceof  Node)){
                throw  new Exception("һ�����豸��һ��Ҫ�ǽڵ�");
            }
            IEquipment equipment = (IEquipment)obj1;
            sourceId = equipment.getId();
            List<String> portId = equipment.getPortId();
            if(portId.size() >2 || portId.size() ==0){
                throw  new Exception("���豸��2�����ϵ�IN OUT ����û�н�����");
            }
            if(portId.size() == 2){
                portID =portId.get(1);
            }else{
                portID =portId.get(0);
            }

            targetID = ((Node)obj2).getId();

        }else{
            throw  new Exception("�����벻����"+" "+obj1.getClass().getName()+" "+obj2.getClass().getName());
        }
        Link link = new Link(sourceId,portID,targetID);

        addEquipment(link);
    }



}
