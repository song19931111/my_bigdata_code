package youhua.service.question;

import java.util.Random;
import youhua.assist.SL_Busi;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：单个题目的处理器，可以看成DAO层
 */
public class BaseQuestionProcessor {
    /**
     * 对题目进行处理，如解析文本，下载图片等等工作
     * @param questionId 题目id
     * @return 题目解析后的文本
     */
    public static String makeQuestion(Integer questionId,String questionSrc){
        Random r = new Random();
        SL_Busi.buisness(450+r.nextInt(100));
        return "CompleteQuestion[id="+questionId
                +" content=:"+ questionSrc+"]";
    }
}
