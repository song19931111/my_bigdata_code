package po;

import common.GraphObject;
import po.properties.CommonConfig;
import po.properties.Item;
import po.properties.Ports;
import po.properties.Position;

import java.util.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Insump implements IEquipment{
    String type="basic.Image";
    String modelType="insump";
    String modelText="½øË®³Ø";
    Integer z;
    Ports ports = new Ports(GraphObject.INSUMP);
    Position position;
    Integer angle= 0;
    String id =UUID.randomUUID().toString();
    Map<String,Object> size = new HashMap<String,Object>(){{
        put("width",50);
        put("height",75);
    }};
    Object property = CommonConfig.getInstance(GraphObject.INSUMP).getProperty();
    Object attrs = CommonConfig.getInstance(GraphObject.INSUMP).getAttrs();
    public Insump(String name,Double x ,Double y) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        this.z = CommonConfig.getZ();
        this.position = new Position(x,y);
        modelText = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelText() {
        return modelText;
    }

    public void setModelText(String modelText) {
        this.modelText = modelText;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Ports getPorts() {
        return ports;
    }

    public void setPorts(Ports ports) {
        this.ports = ports;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getSize() {
        return size;
    }

    public void setSize(Map<String, Object> size) {
        this.size = size;
    }

    public Object getProperty() {
        return property;
    }

    public void setProperty(Object property) {
        this.property = property;
    }

    public Object getAttrs() {
        return attrs;
    }

    public void setAttrs(Object attrs) {
        this.attrs = attrs;
    }
    @Override
    public List<String> getPortId() {

        List<String>result = new ArrayList<>();



        for(Item item :ports.items){

            result.add(item.getId());

        }
        return result;
    }
}
