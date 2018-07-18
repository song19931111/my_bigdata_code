/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */
public class InnerClass {

    public static class AAA{

        public static  int XX=10;
        public AAA(){
            System.out.println("AAAA");
        }
        public void aaa(){
            System.out.println("aa");
        }
        public static void  BB(){
            System.out.println("BB");
        }

    }



    public static void main(String args[]){
        InnerClass.AAA.BB();;
    }
}

