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
        //���������ļ���
        FileInputStream inputStream=new FileInputStream(file);
        //ת��Ϊ�ַ���
        CharStream input= CharStreams.fromStream(inputStream);
        //�����ʷ�������
        CalLexer lexer=new CalLexer(input);
        //��ȡToken��
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        //�����﷨������
        CalParser parser=new CalParser(tokenStream);
        //�����﷨
        ParseTree tree=parser.prog();
        //�����﷨����������
        EvalVisitor visitor=new EvalVisitor();
        //��������ʱ��������᷵�ؿ�ָ�룬�����ﲶ��
        try{
            visitor.visit(tree);
        }catch (NullPointerException e){
            System.out.println("oops, we have some problem");
        }
    }
}
