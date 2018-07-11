package po.properties;

import common.GraphObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Ports {

    private  GraphObject gObject;
    public Map groups;
    public  Ports(GraphObject object) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        this.gObject = object;
        groups = CommonConfig.getInstance(object).getGroups();
        List<List<String>> groupList =  CommonConfig.getInstance(object).getGroup();
        for(List<String>list :groupList){
            Item item = new Item();
            item.setGroup(list);
            item.setId(UUID.randomUUID().toString());
            items.add(item);
        }

    }
    public List<Item> items = new ArrayList<>();





}
