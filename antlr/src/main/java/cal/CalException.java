package cal;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/23
 */
public class CalException extends Exception {
    private int line;
    private int column;
    private String msg;

    public CalException(int line,int column,String msg){
        this.line=line;
        this.column=column;
        this.msg=msg;
    }

    @Override
    public String toString() {
        return msg+",line:"+line+",column:"+column;
    }
}