import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/17
 */
public class GenerateSqlAndMapper {
    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件


        String path = GenerateSqlAndMapper.class.getClassLoader().getResource(".").getPath()+"generatorConfig.xml";
        File configFile = new File(path);
        System.out.println(configFile.getAbsoluteFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {

            //System.out.println(GenerateSqlAndMapper.class.getClassLoader().getResource(".").getPath());
            GenerateSqlAndMapper generatorSqlmap = new GenerateSqlAndMapper();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
