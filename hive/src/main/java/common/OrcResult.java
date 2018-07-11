package common;

import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/20
 */
public class OrcResult {
    Boolean isEqual;
    List<String>fields;
    List<String>types;
    List<String>comment;

    public Boolean getEqual() {
        return isEqual;
    }

    public List<String> getFields() {
        return fields;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setEqual(Boolean equal) {
        isEqual = equal;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }
}
