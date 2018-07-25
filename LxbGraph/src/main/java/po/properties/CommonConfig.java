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
                "\"name\": \"�ܵ�����\"" +
                "}, {" +
                "\"Ename\": \"GD_NM\"," +
                "\"name\": \"�ܵ�����\"" +
                "}, {" +
                "\"Ename\": \"BEGIN_NODE_CD\"," +
                "\"name\": \"���ڵ���\"" +
                "}, {" +
                "\"Ename\": \"END_NODE_CD\"," +
                "\"name\": \"�յ�ڵ���\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"IN_HIGHT\"," +
                "\"name\": \"���ڵ׸߳�\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"OUT_HIGHT\"," +
                "\"name\": \"���ڵ׸߳�\"" +
                "}, {" +
                "\"Ename\": \"GD_MATE\"," +
                "\"name\": \"�ܲ�\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"GD_SIZE\"," +
                "\"name\": \"�ھ�\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"GD_THICK\"," +
                "\"name\": \"�ں�\"" +
                "}, {" +
                "\"unit\": \"��\"," +
                "\"Ename\": \"SLOPE\"," +
                "\"name\": \"�¶�\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"GD_LENGH\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"SHAPE\"," +
                "\"name\": \"������״\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"SLBJ\"," +
                "\"name\": \"ˮ���뾶\"" +
                "}, {" +
                "\"Ename\": \"ROUGHNESS\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"YCXS\"," +
                "\"name\": \"�س�ϵ��\"" +
                "}, {" +
                "\"unit\": \"m/s\"," +
                "\"Ename\": \"V\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"Ename\": \"YCSS\"," +
                "\"name\": \"�س���ʧ\"" +
                "}, {" +
                "\"Ename\": \"TJTXML\"," +
                "\"name\": \"�������ģ��\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"���ѹ�����\"" +
                "}, {" +
                "\"Ename\": \"SCBS\"," +
                "\"name\": \"ˮ������\"" +
                "}, {" +
                "\"Ename\": \"CYDJ\"," +
                "\"name\": \"��ѹ�ȼ�\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"QHYL\"," +
                "\"name\": \"����ѹ��\"" +
                "}, {" +
                "\"Ename\": \"XYZ\"," +
                "\"name\": \"�ڵ�\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
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
                "\"text\": \"ѹ����\"," +
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
                "\"xlink:href\": \"dist/assets/svg/ѹ����.svg\"" +
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
                "\"name\": \"ѹ��������\"," +
                "\"value\": \"�������2\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"," +
                "\"value\": \"234\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"TYPE\"," +
                "\"name\": \"����\"," +
                "\"value\": \"1\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"���ѹ��\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"LINK_WAY\"," +
                "\"name\": \"���ӷ�ʽ\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"unit\": \"ms\"," +
                "\"Ename\": \"CYPL\"," +
                "\"name\": \"����Ƶ��\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"JD\"," +
                "\"name\": \"����\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"," +
                "\"value\": \"1.0\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"," +
                "\"value\": \"12\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"," +
                "\"value\": \"12\"" +
                "}, {" +
                "\"Ename\": \"LC\"," +
                "\"name\": \"����\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"SIG_TPYE\"," +
                "\"name\": \"����ź�����\"," +
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
                "\"text\": \"��\"," +
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
                "\"xlink:href\": \"dist/assets/svg/��.svg\"" +
                "}" +
                "}";
        private String propertyText ="{" +
                "\"modifyLine\": [{" +
                "\"Ename\": \"KD_TM\"," +
                "\"name\": \"����ʱ���ϵ\"" +
                "}, {" +
                "\"Ename\": \"KD_ZLXS\"," +
                "\"name\": \"��������ϵ����ϵ\"" +
                "}]," +
                "\"modify\": [{" +
                "\"Ename\": \"VAV_NM\"," +
                "\"name\": \"����\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"," +
                "\"value\": \"\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"VAV_TYPE\"," +
                "\"name\": \"�������\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"Ename\": \"VAV_WORK\"," +
                "\"name\": \"������ʽ\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"�������\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"VAV_SIZE\"," +
                "\"name\": \"ֱ��\"," +
                "\"value\": \"3.8\"" +
                "}, {" +
                "\"Ename\": \"KD\"," +
                "\"name\": \"���ſ���\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"���ѹ��\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"ISMP\"," +
                "\"name\": \"��ѹ����\"," +
                "\"value\": \"48.0\"" +
                "}, {" +
                "\"unit\": \"MPa\"," +
                "\"Ename\": \"MAXMP\"," +
                "\"name\": \"��ѹ�������ѹ����\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"," +
                "\"value\": \"����\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"," +
                "\"value\": \"0.0\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"," +
                "\"value\": \"\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"," +
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
                "\"text\": \"����\"," +
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
                "\"xlink:href\": \"dist/assets/svg/����.svg\"" +
                "}" +
                "}";
        private String propertyText="{" +
                "\"modifyLine\": [{" +
                "\"Ename\": \"KD_TM\"," +
                "\"name\": \"����ʱ���ϵ\"" +
                "}, {" +
                "\"Ename\": \"KD_ZLXS\"," +
                "\"name\": \"��������ϵ����ϵ\"" +
                "}]," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"���ű���\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"" +
                "}, {" +
                "\"Ename\": \"VAV_NM\"," +
                "\"name\": \"��������\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"" +
                "}, {" +
                "\"Ename\": \"VAV_TYPE\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"Ename\": \"VAV_WORK\"," +
                "\"name\": \"������ʽ\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"VAV_SIZE\"," +
                "\"name\": \"ֱ��\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"ѹ���ȼ�\"" +
                "}, {" +
                "\"Ename\": \"ISMP\"," +
                "\"name\": \"��������\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MAXMP\"," +
                "\"name\": \"��ѹ�������ѹ����\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"" +
                "}, {" +
                "\"Ename\": \"USER_TYPE\"," +
                "\"name\": \"��;\"" +
                "}, {" +
                "\"unit\": \"\"," +
                "\"Ename\": \"AZGC\"," +
                "\"name\": \"��װ�߳�\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
                "}, {" +
                "\"Ename\": \"KD\"," +
                "\"name\": \"ʵʱ����\"" +
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
                "\"text\": \"��ˮ��\"," +
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
                "\"xlink:href\": \"dist/assets/svg/��ˮ��.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"��ˮ�ر���\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"" +
                "}, {" +
                "\"Ename\": \"CNW_NM\"," +
                "\"name\": \"��ˮ������\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"IN_W\"," +
                "\"name\": \"���ˮλ\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"PIPE_SIZE\"," +
                "\"name\": \"ˮ��ֱ��\"" +
                "}, {" +
                "\"Ename\": \"PIPE_C\"," +
                "\"name\": \"ˮ�ܸ���\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"���ѹ��\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
                "}, {" +
                "\"Ename\": \"Z\"," +
                "\"name\": \"ʵʱˮλ\"" +
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
                "\"text\": \"��ˮ��\"," +
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
                "\"xlink:href\": \"dist/assets/svg/��ˮ��.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"��ˮ�ر���\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"" +
                "}, {" +
                "\"Ename\": \"CNW_NM\"," +
                "\"name\": \"��ˮ������\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"OUT_W\"," +
                "\"name\": \"���ˮλ\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"PIPE_SIZE\"," +
                "\"name\": \"ˮ��ֱ��\"" +
                "}, {" +
                "\"Ename\": \"PIPE_C\"," +
                "\"name\": \"ˮ�ܸ���\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
                "}, {" +
                "\"Ename\": \"Z\"," +
                "\"name\": \"ʵʱˮλ\"" +
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
                "\"text\": \"������\"," +
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
                "\"xlink:href\": \"dist/assets/svg/������.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modifyLine\": []," +
                "\"modify\": [{" +
                "\"Ename\": \"MODEL_CD\"," +
                "\"name\": \"����������\"" +
                "}, {" +
                "\"Ename\": \"NODE_CD\"," +
                "\"name\": \"�ڵ����\"" +
                "}, {" +
                "\"Ename\": \"VAA_NM\"," +
                "\"name\": \"����������\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"INFLOW_SIZE\"," +
                "\"name\": \"������ֱ��\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"OUTFLOW_SIZE\"," +
                "\"name\": \"������ֱ��\"" +
                "}, {" +
                "\"unit\": \"mm\"," +
                "\"Ename\": \"MFLOW_SIZE\"," +
                "\"name\": \"΢��������ֱ��\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"" +
                "}, {" +
                "\"Ename\": \"VAA_TYPE\"," +
                "\"name\": \"�������\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
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
                "\"name\": \"�ڵ����\"" +
                "}, {" +
                "\"Ename\": \"NODE_NM\"," +
                "\"name\": \"�ڵ�����\"" +
                "}, {" +
                "\"Ename\": \"LGTD\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"LTTD\"," +
                "\"name\": \"γ��\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"HEIGHT\"," +
                "\"name\": \"�߳�\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"QHYL\"," +
                "\"name\": \"����ѹ��\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"Ename\": \"MP\"," +
                "\"name\": \"ѹ��\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"Ename\": \"Q\"," +
                "\"name\": \"����\"" +
                "}, {" +
                "\"Ename\": \"SZFD\"," +
                "\"name\": \"���ڷֶ�\"" +
                "}, {" +
                "\"Ename\": \"ORGID\"," +
                "\"name\": \"����λ\"" +
                "}, {" +
                "\"Ename\": \"ZRR\"," +
                "\"name\": \"������\"" +
                "}, {" +
                "\"Ename\": \"NT\"," +
                "\"name\": \"��ע\"" +
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
                "\"text\": \"������\"," +
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
                "\"xlink:href\": \"dist/assets/svg/������.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"���ű���\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"�ڵ����\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"��������\"," +
                "\"Ename\": \"VAV_NM\"" +
                "}, {" +
                "\"name\": \"����\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"γ��\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"name\": \"�������\"," +
                "\"Ename\": \"VAV_TYPE\"" +
                "}, {" +
                "\"name\": \"������ʽ\"," +
                "\"Ename\": \"VAV_WORK\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"ֱ��\"," +
                "\"Ename\": \"VAV_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"ѹ���ȼ�\"," +
                "\"Ename\": \"MP\"" +
                "}, {" +
                "\"name\": \"��������\"," +
                "\"Ename\": \"ISMP\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"��ѹ�������ѹ����\"," +
                "\"Ename\": \"MAXMP\"" +
                "}, {" +
                "\"name\": \"���ڷֶ�\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"name\": \"��;\"," +
                "\"Ename\": \"USER_TYPE\"" +
                "}, {" +
                "\"unit\": \"\"," +
                "\"name\": \"��װ�߳�\"," +
                "\"Ename\": \"AZGC\"" +
                "}, {" +
                "\"name\": \"����λ\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"������\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"��ע\"," +
                "\"Ename\": \"NT\"" +
                "}, {" +
                "\"name\": \"ʵʱ����\"," +
                "\"Ename\": \"KD\"" +
                "}]," +
                "\"modifyLine\": [{" +
                "\"name\": \"����ʱ���ϵ\"," +
                "\"Ename\": \"KD_TM\"" +
                "}, {" +
                "\"name\": \"��������ϵ����ϵ\"," +
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
                "\"text\": \"��ˮ��\"," +
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
                "\"xlink:href\": \"dist/assets/svg/��ˮ��.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"��ˮ�ڱ���\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"�ڵ����\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"��ˮ������\"," +
                "\"Ename\": \"WI_NM\"" +
                "}, {" +
                "\"name\": \"����\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"γ��\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"name\": \"��Ʒ�ˮ����\"," +
                "\"Ename\": \"Q\"" +
                "}, {" +
                "\"unit\": \"m?\"," +
                "\"name\": \"��ˮ�ڶ���ߴ�\"," +
                "\"Ename\": \"SECTION_SIZE\"" +
                "}, {" +
                "\"name\": \"����\"," +
                "\"Ename\": \"ROUGHNESS\"" +
                "}, {" +
                "\"name\": \"���ڷֶ�\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"��ˮ�ܾ�\"," +
                "\"Ename\": \"GD_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"���ιܵ�����\"," +
                "\"Ename\": \"XYGDCD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"����ĩ������ˮλ\"," +
                "\"Ename\": \"XYMDYLSW\"" +
                "}, {" +
                "\"name\": \"����λ\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"������\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"��ע\"," +
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
                "\"text\": \"��ѹ��\"," +
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
                "\"xlink:href\": \"dist/assets/svg/�򵥵�ѹ��.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"��ѹ������\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"�ڵ����\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"��ѹ������\"," +
                "\"Ename\": \"SUG_NM\"" +
                "}, {" +
                "\"name\": \"����\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"γ��\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m?/s\"," +
                "\"name\": \"�������\"," +
                "\"Ename\": \"Q\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�װ�߳�\"," +
                "\"Ename\": \"DB_HEIGHT\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"��ˮ��ֱ��\"," +
                "\"Ename\": \"WSP_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�߶�\"," +
                "\"Ename\": \"HEIGHT\"" +
                "}, {" +
                "\"unit\": \"m?\"," +
                "\"name\": \"��ѹ���������\"," +
                "\"Ename\": \"AREA\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"��ѹ������ߴ�\"," +
                "\"Ename\": \"SECTION_SIZE\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"���ѹ��\"," +
                "\"Ename\": \"MP\"" +
                "}, {" +
                "\"name\": \"������ʧϵ��\"," +
                "\"Ename\": \"LRSSXS\"" +
                "}, {" +
                "\"name\": \"������ʧϵ��\"," +
                "\"Ename\": \"LCSSXS\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�������ˮλ\"," +
                "\"Ename\": \"HIGH_W\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�������ˮλ\"," +
                "\"Ename\": \"LOW_W\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�����߳�\"," +
                "\"Ename\": \"YL_HEIGHT\"" +
                "}, {" +
                "\"name\": \"���ڷֶ�\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"name\": \"����λ\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"������\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"��ע\"," +
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
                "\"text\": \"������\"," +
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
                "\"xlink:href\": \"dist/assets/svg/������.svg\"" +
                "}" +
                "}";
        private String propertyText = "{" +
                "\"modify\": [{" +
                "\"name\": \"����������\"," +
                "\"Ename\": \"MODEL_CD\"" +
                "}, {" +
                "\"name\": \"�ڵ����\"," +
                "\"Ename\": \"NODE_CD\"" +
                "}, {" +
                "\"name\": \"����������\"," +
                "\"Ename\": \"OVW_NM\"" +
                "}, {" +
                "\"name\": \"����\"," +
                "\"Ename\": \"LGTD\"" +
                "}, {" +
                "\"name\": \"γ��\"," +
                "\"Ename\": \"LTTD\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"йˮ��ֱ��\"," +
                "\"Ename\": \"XSDZJ\"" +
                "}, {" +
                "\"name\": \"������ʧϵ��\"," +
                "\"Ename\": \"LRSSXS\"" +
                "}, {" +
                "\"name\": \"������ʧϵ��\"," +
                "\"Ename\": \"LCSSXS\"" +
                "}, {" +
                "\"name\": \"���ڷֶ�\"," +
                "\"Ename\": \"SZFD\"" +
                "}, {" +
                "\"unit\": \"m3/s\"," +
                "\"name\": \"���й����\"," +
                "\"Ename\": \"ZDXLL\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"����׸߳�\"," +
                "\"Ename\": \"DBDGC\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�߶��߳�\"," +
                "\"Ename\": \"YDGC\"" +
                "}, {" +
                "\"unit\": \"m\"," +
                "\"name\": \"�������װ�߳�\"," +
                "\"Ename\": \"YLJDBGC\"" +
                "}, {" +
                "\"unit\": \"m2\"," +
                "\"name\": \"�������ڶ���ߴ�\"," +
                "\"Ename\": \"SECTION_INSIZE\"" +
                "}, {" +
                "\"unit\": \"m2\"," +
                "\"name\": \"�����������ߴ�\"," +
                "\"Ename\": \"SECTION_OUTSIZE\"" +
                "}, {" +
                "\"name\": \"����������\"," +
                "\"Ename\": \"YLYLX\"" +
                "}, {" +
                "\"name\": \"����λ\"," +
                "\"Ename\": \"ORGID\"" +
                "}, {" +
                "\"name\": \"������\"," +
                "\"Ename\": \"ZRR\"" +
                "}, {" +
                "\"name\": \"��ע\"," +
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
                "\"text\": \"�ı�\"," +
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
