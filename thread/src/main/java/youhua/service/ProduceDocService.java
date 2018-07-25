package youhua.service;
import youhua.assist.SL_Busi;
import youhua.service.question.SingleQstService;
import youhua.vo.SrcDocVo;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：处理文档的服务，包括文档中题目的处理和文档生成后的上传
 */
public class ProduceDocService {

    /**
     * 上传文档到网络
     * @param docFileName 实际文档在本地的存储位置
     * @return 上传后的网络存储地址
     */
    public static String upLoadDoc(String docFileName){
        Random r = new Random();
        SL_Busi.buisness(9000+r.nextInt(400));
        return "http://www.xxxx.com/file/upload/"+docFileName;
    }

    /**
     * 将待处理文档处理为本地实际PDF文档
     * @param pendingDocVo 待处理文档
     * @return 实际文档在本地的存储位置
     */
    public static String makeDoc(SrcDocVo pendingDocVo){
        System.out.println("开始处理文档："+ pendingDocVo.getDocName());
        StringBuffer sb = new StringBuffer();
        //循环处理文档中的每个题目
        for(Integer questionId: pendingDocVo.getQuestionList()){
            sb.append(SingleQstService.makeQuestion(questionId));
        }
        return "complete_"+System.currentTimeMillis()+"_"
        	+ pendingDocVo.getDocName()+".pdf";
    }


}