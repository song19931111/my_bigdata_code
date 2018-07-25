package cal;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/23
 */
public class MyCalculator {

    public static void main(String[] args) throws IOException {

        String path  = MyCalculator.class.getClassLoader().getResource("").getPath();
        String file=path+"test.in";
        //创建输入文件流
        FileInputStream inputStream=new FileInputStream(file);
        //转化为字符流
        CharStream input= CharStreams.fromStream(inputStream);
        //创建词法分析器
        CalLexer lexer=new CalLexer(input);
        //获取Token集
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        //创建语法分析器
        CalParser parser=new CalParser(tokenStream);
        //分析语法
        ParseTree tree=parser.prog();
        //遍历语法树，输出结果
        EvalVisitor visitor=new EvalVisitor();
        //当遍历树时如果出错，会返回空指针，在这里捕获
        try{
            visitor.visit(tree);
        }catch (NullPointerException e){
            System.out.println("oops, we have some problem");
        }
    }
}
