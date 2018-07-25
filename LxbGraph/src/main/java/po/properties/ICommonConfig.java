package po.properties;

import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public interface ICommonConfig {

    public List<List<String>> getGroup();
    public Map getProperty();
    public Map getGroups();
    public Map getAttrs();
}
