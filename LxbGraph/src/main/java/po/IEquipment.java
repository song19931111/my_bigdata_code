package po;

import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public interface IEquipment {

    /**
     *
     * @return 第一个IN的port 第二个Out的port
     */
    public List<String> getPortId();
    public String getId();

}