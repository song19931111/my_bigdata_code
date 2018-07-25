package po.properties;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
public class Position {
    Double x;
    Double y;

    public Position(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
