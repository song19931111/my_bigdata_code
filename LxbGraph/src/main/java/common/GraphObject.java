package common;


import po.properties.CommonConfig;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */

public enum  GraphObject{

    PIPE(1,CommonConfig.Pipe.class.getName()),
    PRESS(2,CommonConfig.Press.class.getName()),
    VALUE_B(3,CommonConfig.Value_B.class.getName()),
    VALUE_F(4,CommonConfig.Value_F.class.getName()),
    INSUMP(5,CommonConfig.InSump.class.getName()),
    OUTPOOL(6,CommonConfig.OutPool.class.getName()),
    NODE(7,CommonConfig.NODE.class.getName()),
    VALUE_A(8,CommonConfig.Value_A.class.getName()),
    VALUE_N(9,CommonConfig.Value_N.class.getName()),
    BLEEDER(10,CommonConfig.Bleeder.class.getName()),
    SURGETANK(11,CommonConfig.Surgetank.class.getName()),
    OVERFLOW(12,CommonConfig.Overflow.class.getName());



    Integer key;
    public  String className;

    GraphObject(Integer i,String className){
        key = i;
        this.className = className;
    }


}
