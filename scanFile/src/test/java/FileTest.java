import org.junit.Test;

import java.io.File;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */
public class FileTest {


    @Test
    public void test(){
        File fileDirectory = new File("E:\\speedBattle");
        File[] files = fileDirectory.listFiles();
        for(File file:files){
            long l = file.lastModified();
            System.out.println();

        }


    }
}
