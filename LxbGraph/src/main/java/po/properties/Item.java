package po.properties;

import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Item {

    public List<String> group;
    String id;


    public List<String> getGroup() {
        return group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }
}



