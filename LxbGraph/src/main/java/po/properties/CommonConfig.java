package po.properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.GraphObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */

public class CommonConfig {


        public static  int z = 0;
        public static  int getZ(){
            z++;
            return z;
        }


               static  Map<String,Object>map_class = new HashMap<String,Object>(){{
                try {
                    put(GraphObject.PIPE.className,Class.forName(GraphObject.PIPE.className).newInstance());
                    put(GraphObject.PRESS.className,Class.forName(GraphObject.PRESS.className).newInstance());
                    put(GraphObject.NODE.className,Class.forName(GraphObject.NODE.className).newInstance());
                    put(GraphObject.INSUMP.className,Class.forName(GraphObject.INSUMP.className).newInstance());
                    put(GraphObject.OUTPOOL.className,Class.forName(GraphObject.OUTPOOL.className).newInstance());
                    put(GraphObject.VALUE_A.className,Class.forName(GraphObject.VALUE_A.className).newInstance());
                    put(GraphObject.VALUE_B.className,Class.forName(GraphObject.VALUE_B.className).newInstance());
                    put(GraphObject.VALUE_F.className,Class.forName(GraphObject.VALUE_F.className).newInstance());
                    put(GraphObject.SURGETANK.className,Class.forName(GraphObject.SURGETANK.className).newInstance());
                    put(GraphObject.VALUE_N.className,Class.forName(GraphObject.VALUE_N.className).newInstance());
                    put(GraphObject.BLEEDER.className,Class.forName(GraphObject.BLEEDER.className).newInstance());
                    put(GraphObject.OVERFLOW.className,Class.forName(GraphObject.OVERFLOW.className).newInstance());
                    put(GraphObject.TEXT.className,Class.forName(GraphObject.TEXT.className).newInstance());

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }};






        public static  ICommonConfig getInstance(GraphObject  object) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


            return (ICommonConfig)map_class.getOrDefault(object.className,null);
        }


        public  static  class Pipe implements ICommonConfig {


            public Map getAttrs(){
                return this.attrs;
            }
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }

        public Pipe(){
             this.groups = JSONObject.parseObject(text, Map.class);
             this.property = JSONObject.parseObject(propertyText, Map.class);
        }
        public Map  groups;
        public Map property;
        public Map attrs = new HashMap();
        private String text = "{" +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"absolute\"," +
                "\"args\": {" +
                "\"x\": \"100%\"," +
                "\"y\": \"50%\"" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"absolute\"," +
                "\"args\": {" +
                "\"x\": \"0%\"," +
                "\"y\": \"50%\"" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
        private String propertyText ="{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"管道代码\"" +
                "}, {" +
                "\"Ename\": \"GD_NM\"," +
                "\"name\": \"管道名称\"" +
                "}, {" +
                "\"Ename\": \"BEGIN_NODE_CD\"," +
                "\"name\": \"起点节点编号\"" +
                "}, {" +
                "\"Ename\": \"END_NODE_CD\"," +
                "\"name\": \"终点节点编号\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"IN_HIGHT\"," +
                "\"name\": \"进口底高程\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"OUT_HIGHT\"," +
                "\"name\": \"出口底高程\"" +
                "}, {" +
                "\"Ename\": \"GD_MATE\"," +
                "\"name\": \"管材\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"GD_SIZE\"," +
                "\"name\": \"内径\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"GD_THICK\"," +
                "\"name\": \"壁厚\"" +
                "}, {" +
                "\"unit\": \"°\"," +
                "\"Ename\": \"SLOPE\"," +
                "\"name\": \"坡度\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"GD_LENGH\"," +
                "\"name\": \"长度\"" +
                "}, {" +
                "\"Ename\": \"SHAPE\"," +
                "\"name\": \"断面形状\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"SLBJ\"," +
                "\"name\": \"水力半径\"" +
                "}, {" +
                "\"Ename\": \"ROUGHNESS\"," +
                "\"name\": \"糙率\"" +
                "}, {" +
                "\"Ename\": \"YCXS\"," +
                "\"name\": \"沿程系数\"" +
                "}, {" +
                "\"unit\": \"m/s\"," +
                "\"Ename\": \"V\"," +
                "\"name\": \"设计流速\"" +
                "}, {" +
                "\"Ename\": \"YCSS\"," +
                "\"name\": \"沿程损失\"" +
                "}, {" +
                "\"Ename\": \"TJTXML\"," +
                "\"name\": \"体积弹性模量\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"设计流量\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"设计压力标高\"" +
                "}, {" +
                "\"Ename\": \"SCBS\"," +
                "\"name\": \"水锤波速\"" +
                "}, {" +
                "\"Ename\": \"CYDJ\"," +
                "\"name\": \"承压等级\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"QHYL\"," +
                "\"name\": \"汽化压力\"" +
                "}, {" +
                "\"Ename\": \"XYZ\"," +
                "\"name\": \"内点\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}]" +
                "}";

            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("in");
                    }});
                    add(new ArrayList<String>(){{
                        add("out");
                    }});
                }};
            }
        }
        public static class  Press implements ICommonConfig{
            public Map getAttrs(){
                return this.attrs;
            }
            public Map getProperty(){
                return  this.property;
            }
            public Map getGroups(){
                return  this.groups;
            }
        public Press(){
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs = JSONObject.parseObject(attrText, Map.class);;
        }
        public  Map attrs;
        public Map  groups;
        public  Map property;
        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"压力计\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/压力表.svg\"" +
                "}" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -8" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -8" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -8" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -8" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
        private  String propertyText ="{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MP_NM\"," +
                "\"name\": \"压力计名称\"," +
                "\"value\": \"测试添加2\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"," +
                "\"value\": \"234\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"TYPE\"," +
                "\"name\": \"类型\"," +
                "\"value\": \"1\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"设计压力\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"LINK_WAY\"," +
                "\"name\": \"连接方式\"," +
                "\"value\": \"光纤\"" +
                "}, {" +
                "\"unit\": \"ms\"," +
                "\"Ename\": \"CYPL\"," +
                "\"name\": \"采样频率\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"JD\"," +
                "\"name\": \"精度\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"," +
                "\"value\": \"二段\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"负责人\"," +
                "\"value\": \"12\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"," +
                "\"value\": \"12\"" +
                "}, {" +
                "\"Ename\": \"LC\"," +
                "\"name\": \"量程\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"SIG_TPYE\"," +
                "\"name\": \"输出信号类型\"," +
                "\"value\": \"0\"" +
                "}]" +
                "}";


            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("iN");
                    }});
                }};
            }
        }
        public static class Value_B implements ICommonConfig{
            public Map getAttrs(){
                return this.attrs;
            }
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
        public Value_B(){
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property =JSONObject.parseObject(propertyText, Map.class);
            this.attrs =JSONObject.parseObject(attrText, Map.class);
        }
        public Map  groups;
        public   Map property;
        public Map attrs;


        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"球阀\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/球阀.svg\"" +
                "}" +
                "}";
        private String propertyText ="{" +
                "\"modifyLine\": [{" +
                "\"Ename\": \"KD_TM\"," +
                "\"name\": \"开度时间关系\"" +
                "}, {" +
                "\"Ename\": \"KD_ZLXS\"," +
                "\"name\": \"开度阻力系数关系\"" +
                "}]," +
                "\"modify\": [{" +
                "\"Ename\": \"VAV_NM\"," +
                "\"name\": \"名称\"," +
                "\"value\": \"阀门\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"," +
                "\"value\": \"\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"VAV_TYPE\"," +
                "\"name\": \"阀门类别\"," +
                "\"value\": \"其它\"" +
                "}, {" +
                "\"Ename\": \"VAV_WORK\"," +
                "\"name\": \"工作方式\"," +
                "\"value\": \"其它\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"设计流量\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"VAV_SIZE\"," +
                "\"name\": \"直径\"," +
                "\"value\": \"3.8\"" +
                "}, {" +
                "\"Ename\": \"KD\"," +
                "\"name\": \"阀门开度\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"设计压力\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"ISMP\"," +
                "\"name\": \"有压工作\"," +
                "\"value\": \"48.0\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MAXMP\"," +
                "\"name\": \"有压工作最大压力差\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"," +
                "\"value\": \"其它\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"负责人\"," +
                "\"value\": \"\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"," +
                "\"value\": \"\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -2" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -2" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -2" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -2" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("in");
                    }});
                    add(new ArrayList<String>(){{
                        add("out");
                    }});
                }};
            }

    }
        public static class Value_F implements  ICommonConfig{
            public Map getProperty(){
                return  this.property;
            }
            public Map getGroups(){
                return  this.groups;
            }
            public Map getAttrs(){
                return this.attrs;
            }
        public Value_F(){
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs = JSONObject.parseObject(attrText, Map.class);
        }
        public Map  groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"蝶阀\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/蝶阀.svg\"" +
                "}" +
                "}";
        private String propertyText="{" +
                "\"modifyLine\": [{" +
                "\"Ename\": \"KD_TM\"," +
                "\"name\": \"开度时间关系\"" +
                "}, {" +
                "\"Ename\": \"KD_ZLXS\"," +
                "\"name\": \"开度阻力系数关系\"" +
                "}]," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"阀门编码\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"" +
                "}, {" +
                "\"Ename\": \"VAV_NM\"," +
                "\"name\": \"阀门名称\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"" +
                "}, {" +
                "\"Ename\": \"VAV_TYPE\"," +
                "\"name\": \"阀门类别\"" +
                "}, {" +
                "\"Ename\": \"VAV_WORK\"," +
                "\"name\": \"驱动方式\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"VAV_SIZE\"," +
                "\"name\": \"直径\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"压力等级\"" +
                "}, {" +
                "\"Ename\": \"ISMP\"," +
                "\"name\": \"开启条件\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MAXMP\"," +
                "\"name\": \"带压开启最大压力差\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"" +
                "}, {" +
                "\"Ename\": \"USER_TYPE\"," +
                "\"name\": \"用途\"" +
                "}, {" +
                "\"unit\": \"\"," +
                "\"Ename\": \"AZGC\"," +
                "\"name\": \"安装高程\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"责任人\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}, {" +
                "\"Ename\": \"KD\"," +
                "\"name\": \"实时开度\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
            @Override
            public  List<List<String>> getGroup() {
                List<List<String>> list=   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("in");
                    }});
                    add(new ArrayList<String>(){{
                        add("out");
                    }});
                }};
                return  list;
            }



        }
        public static class InSump implements ICommonConfig{
            public Map getProperty(){
                return  this.property;
            }
            public Map getGroups(){
                return  this.groups;
            }
            public Map getAttrs(){
                return this.attrs;
            }
        public InSump() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrsText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;
        private String attrsText="{" +
                "\"text\": {" +
                "\"text\": \"进水池\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/进水池.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"进水池编码\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"" +
                "}, {" +
                "\"Ename\": \"CNW_NM\"," +
                "\"name\": \"进水池名称\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"设计流量\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"IN_W\"," +
                "\"name\": \"设计水位\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"PIPE_SIZE\"," +
                "\"name\": \"水管直径\"" +
                "}, {" +
                "\"Ename\": \"PIPE_C\"," +
                "\"name\": \"水管根数\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"设计压力\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"责任人\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}, {" +
                "\"Ename\": \"Z\"," +
                "\"name\": \"实时水位\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("out");
                    }});
                }};
            }


    }
        public static class OutPool implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
            public Map getAttrs(){
                return this.attrs;
            }
        public OutPool() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs = JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"出水池\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/出水池.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"出水池编码\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"" +
                "}, {" +
                "\"Ename\": \"CNW_NM\"," +
                "\"name\": \"出水池名称\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"设计流量\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"OUT_W\"," +
                "\"name\": \"设计水位\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"PIPE_SIZE\"," +
                "\"name\": \"水管直径\"" +
                "}, {" +
                "\"Ename\": \"PIPE_C\"," +
                "\"name\": \"水管根数\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"责任人\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}, {" +
                "\"Ename\": \"Z\"," +
                "\"name\": \"实时水位\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 1" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";
            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("in");
                    }});
                }};
            }

        }
        public static class Value_A implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
            public Map getAttrs(){
                return this.attrs;
            }
        public Value_A() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"空气阀\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/空气阀.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"空气阀编码\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"节点编码\"" +
                "}, {" +
                "\"Ename\": \"VAA_NM\"," +
                "\"name\": \"空气阀名称\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"INFLOW_SIZE\"," +
                "\"name\": \"进气孔直径\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"OUTFLOW_SIZE\"," +
                "\"name\": \"排气孔直径\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"MFLOW_SIZE\"," +
                "\"name\": \"微量排气孔直径\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"" +
                "}, {" +
                "\"Ename\": \"VAA_TYPE\"," +
                "\"name\": \"阀门类别\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"责任人\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";

            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("iN");
                    }});
                }};
            }
    }

        public static class NODE implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  null;
        }
            public Map getAttrs(){
                return this.attrs;
            }
        public NODE() {
            //this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs = JSONObject.parseObject(attrsText, Map.class);
        }

       // public Map groups;
        public Map property;
        public Map attrs;

        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"节点编码\"" +
                "}, {" +
                "\"Ename\": \"NODE_NM\"," +
                "\"name\": \"节点名称\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"经度\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"纬度\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"HEIGHT\"," +
                "\"name\": \"高程\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"QHYL\"," +
                "\"name\": \"汽化压力\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"压力\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"流量\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"所在分段\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"管理单位\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"责任人\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"备注\"" +
                "}]" +
                "}";
      //  private String text = "";
        private String attrsText="{" +
                "\"circle\": {" +
                "\"fill\": \"#EE7942\"," +
                "\"stroke\": \"#EE7942\"," +
                "\"stroke-width\": 2" +
                "}," +
                "\"text\": {" +
                "\"fill\": \"white\"" +
                "}," +
                "\".\": {" +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}" +
                "}";

            @Override
            public  List<List<String>> getGroup() {
                return   new ArrayList<List<String>>(){{
                    add(new ArrayList<String>(){{
                        add("out");
                    }});
                    add(new ArrayList<String>(){{
                        add("in");
                    }});
                }};
            }
        }

    public static class Value_N implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
        public Map getAttrs(){
            return this.attrs;
        }
        public Value_N() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"调流阀\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/调流阀.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"阀门编码\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"节点编码\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"阀门名称\"," +
                "\"Ename\": \"VAV_NM\"" +
                "}, {" +
                "\"name\": \"经度\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"纬度\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"name\": \"阀门类别\"," +
                "\"Ename\": \"VAV_TYPE\"" +
                "}, {" +
                "\"name\": \"驱动方式\"," +
                "\"Ename\": \"VAV_WORK\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"直径\"," +
                "\"Ename\": \"VAV_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"压力等级\"," +
                "\"Ename\": \"MP\"" +
                "}, {" +
                "\"name\": \"开启条件\"," +
                "\"Ename\": \"ISMP\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"带压开启最大压力差\"," +
                "\"Ename\": \"MAXMP\"" +
                "}, {" +
                "\"name\": \"所在分段\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"name\": \"用途\"," +
                "\"Ename\": \"USER_TYPE\"" +
                "}, {" +
                "\"unit\": \"\"," +
                "\"name\": \"安装高程\"," +
                "\"Ename\": \"AZGC\"" +
                "}, {" +
                "\"name\": \"管理单位\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"责任人\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"备注\"," +
                "\"Ename\": \"NT\"" +
                "}, {" +
                "\"name\": \"实时开度\"," +
                "\"Ename\": \"KD\"" +
                "}]," +
                "\"modifyLine\": [{" +
                "\"name\": \"开度时间关系\"," +
                "\"Ename\": \"KD_TM\"" +
                "}, {" +
                "\"name\": \"开度阻力系数关系\"," +
                "\"Ename\": \"KD_ZLXS\"" +
                "}]" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";

        @Override
        public  List<List<String>> getGroup() {
            return   new ArrayList<List<String>>(){{
                add(new ArrayList<String>(){{
                    add("in");
                }});
                add(new ArrayList<String>(){{
                    add("out");
                }});
            }};
        }
    }

    public static class Bleeder implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
        public Map getAttrs(){
            return this.attrs;
        }
        public Bleeder() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"分水口\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/分水口.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"分水口编码\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"节点编码\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"分水口名称\"," +
                "\"Ename\": \"WI_NM\"" +
                "}, {" +
                "\"name\": \"经度\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"纬度\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"name\": \"设计分水流量\"," +
                "\"Ename\": \"Q\"" +
                "}, {" +
                "\"unit\": \"m?\"," +
                "\"name\": \"分水口断面尺寸\"," +
                "\"Ename\": \"SECTION_SIZE\"" +
                "}, {" +
                "\"name\": \"糙率\"," +
                "\"Ename\": \"ROUGHNESS\"" +
                "}, {" +
                "\"name\": \"所在分段\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"分水管径\"," +
                "\"Ename\": \"GD_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"下游管道长度\"," +
                "\"Ename\": \"XYGDCD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"下游末端溢流水位\"," +
                "\"Ename\": \"XYMDYLSW\"" +
                "}, {" +
                "\"name\": \"管理单位\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"责任人\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"备注\"," +
                "\"Ename\": \"NT\"" +
                "}]," +
                "\"modifyLine\": []" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": 9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";



        @Override
        public  List<List<String>> getGroup() {
            return   new ArrayList<List<String>>(){{
                add(new ArrayList<String>(){{
                    add("In");
                }});
            }};
        }
    }

    public static class Surgetank implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
        public Map getAttrs(){
            return this.attrs;
        }
        public Surgetank() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"调压井\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/简单调压井.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"调压井编码\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"节点编码\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"调压井名称\"," +
                "\"Ename\": \"SUG_NM\"" +
                "}, {" +
                "\"name\": \"经度\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"纬度\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"name\": \"设计流量\"," +
                "\"Ename\": \"Q\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"底板高程\"," +
                "\"Ename\": \"DB_HEIGHT\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"补水管直径\"," +
                "\"Ename\": \"WSP_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"高度\"," +
                "\"Ename\": \"HEIGHT\"" +
                "}, {" +
                "\"unit\": \"m?\"," +
                "\"name\": \"调压井断面面积\"," +
                "\"Ename\": \"AREA\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"调压井断面尺寸\"," +
                "\"Ename\": \"SECTION_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"设计压力\"," +
                "\"Ename\": \"MP\"" +
                "}, {" +
                "\"name\": \"流入损失系数\"," +
                "\"Ename\": \"LRSSXS\"" +
                "}, {" +
                "\"name\": \"流出损失系数\"," +
                "\"Ename\": \"LCSSXS\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"最高运行水位\"," +
                "\"Ename\": \"HIGH_W\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"最低运行水位\"," +
                "\"Ename\": \"LOW_W\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"溢流高程\"," +
                "\"Ename\": \"YL_HEIGHT\"" +
                "}, {" +
                "\"name\": \"所在分段\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"name\": \"管理单位\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"责任人\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"备注\"," +
                "\"Ename\": \"NT\"" +
                "}]," +
                "\"modifyLine\": []" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -9" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";



        @Override
        public  List<List<String>> getGroup() {
            return   new ArrayList<List<String>>(){{
                add(new ArrayList<String>(){{
                    add("iN");
                }});
            }};
        }
    }

    public static class Overflow implements ICommonConfig{
        public Map getProperty(){
            return  this.property;
        }
        public Map getGroups(){
            return  this.groups;
        }
        public Map getAttrs(){
            return this.attrs;
        }
        public Overflow() {
            this.groups = JSONObject.parseObject(text, Map.class);
            this.property = JSONObject.parseObject(propertyText, Map.class);
            this.attrs =  JSONObject.parseObject(attrText, Map.class);
        }

        public Map groups;
        public Map property;
        public Map attrs;

        private String attrText="{" +
                "\"text\": {" +
                "\"text\": \"溢流井\"," +
                "\"display\": \"none\"" +
                "}," +
                "\".\": {" +
                "\"magnet\": false," +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}," +
                "\"image\": {" +
                "\"width\": 40," +
                "\"height\": 60," +
                "\"xlink:href\": \"dist/assets/svg/溢流井.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"溢流井编码\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"节点编码\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"溢流井名称\"," +
                "\"Ename\": \"OVW_NM\"" +
                "}, {" +
                "\"name\": \"经度\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"纬度\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"泄水洞直径\"," +
                "\"Ename\": \"XSDZJ\"" +
                "}, {" +
                "\"name\": \"流入损失系数\"," +
                "\"Ename\": \"LRSSXS\"" +
                "}, {" +
                "\"name\": \"流出损失系数\"," +
                "\"Ename\": \"LCSSXS\"" +
                "}, {" +
                "\"name\": \"所在分段\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"unit\": \"m3/s\"," +
                "\"name\": \"最大泄流量\"," +
                "\"Ename\": \"ZDXLL\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"顶板底高程\"," +
                "\"Ename\": \"DBDGC\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"堰顶高程\"," +
                "\"Ename\": \"YDGC\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"溢流井底板高程\"," +
                "\"Ename\": \"YLJDBGC\"" +
                "}, {" +
                "\"unit\": \"m2\"," +
                "\"name\": \"溢流井内断面尺寸\"," +
                "\"Ename\": \"SECTION_INSIZE\"" +
                "}, {" +
                "\"unit\": \"m2\"," +
                "\"name\": \"溢流井外断面尺寸\"," +
                "\"Ename\": \"SECTION_OUTSIZE\"" +
                "}, {" +
                "\"name\": \"溢流堰类型\"," +
                "\"Ename\": \"YLYLX\"" +
                "}, {" +
                "\"name\": \"管理单位\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"责任人\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"备注\"," +
                "\"Ename\": \"NT\"" +
                "}]," +
                "\"modifyLine\": []" +
                "}";
        private String text = "{" +
                "\"in\": {" +
                "\"position\": {" +
                "\"name\": \"left\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"out\": {" +
                "\"position\": {" +
                "\"name\": \"right\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#008B00\"," +
                "\"stroke\": \"#008B00\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"In\": {" +
                "\"position\": {" +
                "\"name\": \"top\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}," +
                "\"iN\": {" +
                "\"position\": {" +
                "\"name\": \"bottom\"," +
                "\"args\": {" +
                "\"dx\": 0," +
                "\"dy\": -7" +
                "}" +
                "}," +
                "\"attrs\": {" +
                "\"circle\": {" +
                "\"fill\": \"#FF0000\"," +
                "\"stroke\": \"#FF0000\"," +
                "\"stroke-width\": 2," +
                "\"r\": 3," +
                "\"magnet\": true" +
                "}" +
                "}" +
                "}" +
                "}";



        @Override
        public  List<List<String>> getGroup() {
            return   new ArrayList<List<String>>(){{
                add(new ArrayList<String>(){{
                    add("iN");
                }});
            }};
        }
    }



    public static class Text implements ICommonConfig {
        public Map getAttrs() {
            return this.attrs;
        }

        public Text() {
            this.attrs = JSONObject.parseObject(attrText, Map.class);
        }

        //public Map groups;
        //public Map property;
        public Map attrs;

        private String attrText = "{" +
                "\"text\": {" +
                "\"fill\": \"black\"," +
                "\"text\": \"文本\"," +
                "\"font-family\": \"Montserrat\"," +
                "\"font-weight\": \"normal\"" +
                "}," +
                "\".\": {" +
                "\"data-tooltip-position\": \"left\"," +
                "\"data-tooltip-position-selector\": \".joint-stencil\"" +
                "}" +
                "}";

        @Override
        public List<List<String>> getGroup() {
            return null;
        }

        @Override
        public Map getProperty() {
            return null;
        }

        @Override
        public Map getGroups() {
            return null;
        }
    }

}
