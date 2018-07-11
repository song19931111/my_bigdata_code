package po;

import po.properties.CommonConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Link {
    String type="link";
    Map<String,Object> source = new HashMap<String,Object>(){{
        put("selector","g:nth-child(1) > g:nth-child(3) > circle:nth-child(1)");
    }};

    Map<String,Object> target = new HashMap<String,Object>();


    String markup ="<path class=\"connection\" stroke=\"black\" stroke-width=\"2\" d=\"M 0 0 0 0\"/><path class=\"marker-source\" fill=\"black\" stroke=\"black\" d=\"M 0 0 0 0\"/><path class=\"marker-target\" fill=\"black\" stroke=\"black\" d=\"M 0 0 0 0\"/><path class=\"connection-wrap\" d=\"M 0 0 0 0\"/><g class=\"marker-vertices\"/><g class=\"marker-arrowheads\"/>";

    Map<String,Object> router = new HashMap<String,Object>(){{
        put("name","manhattan");
    }};
    Map<String,Object> connector = new HashMap<String,Object>(){{
        put("name","rounded");
    }};
    String id = UUID.randomUUID().toString();
    Integer z = CommonConfig.getZ();

    Map<String,Object> attrs = new HashMap<String,Object>();


    public Link(String sourceId,String sourcePort,String targetId){
        source.put("id",sourceId);
        source.put("port",sourcePort);
        target.put("id",targetId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public void setSource(Map<String, Object> source) {
        this.source = source;
    }

    public Map<String, Object> getTarget() {
        return target;
    }

    public void setTarget(Map<String, Object> target) {
        this.target = target;
    }

    public String getMarkup() {
        return markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    public Map<String, Object> getRouter() {
        return router;
    }

    public void setRouter(Map<String, Object> router) {
        this.router = router;
    }

    public Map<String, Object> getConnector() {
        return connector;
    }

    public void setConnector(Map<String, Object> connector) {
        this.connector = connector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }
}
