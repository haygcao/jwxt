package cn.xm.jwxt.utils;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class TransitionStatusUtil {
    /*将审核状态转化为文字*/
    public static String commitTransition(String commitNum){
        if(commitNum!=null){
            int num = Integer.parseInt(commitNum);
           switch(num){
               case 01: return "已提交";
               case 11: return "申请中";
               case 00: return "待提交";
               //申请过一次，不通过以后的待提交状态
               case 20: return "待提交";
               case 21: return "审核通过";
           }
        }
        return null;
    }
    public static Map<String,String> checkTransition(String status) {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("status1", "null");
        resultMap.put("result1", "null");
        //将字符类型转换为数字
        int num = Integer.parseInt(status);
        switch (num) {
            case 00:
                break;
            case 01:
                resultMap.put("status1", "待审核");
                resultMap.put("result1", "null");
                break;
            case 10:
                resultMap.put("status1", "辅导员已审核");
                resultMap.put("result1", "不通过");
                break;
            case 11:
                resultMap.put("status1", "辅导员已审核，下级学生工作副书记");
                resultMap.put("result1", "通过");
                break;
            case 20:
                resultMap.put("status1", "学生工作副书记已审核");
                resultMap.put("result1", "不通过");
                break;
            case 21:
                resultMap.put("status1", "学生工作副书记已审核，下级指导教师");
                resultMap.put("result1", "通过");
                break;
            case 30:
                resultMap.put("status1", "指导教师已审核");
                resultMap.put("result1", "不通过");
                break;
            case 31:
                resultMap.put("status1", "指导教师已审核，下级教研室主任");
                resultMap.put("result1", "通过");
                break;
            case 40:
                resultMap.put("status1", "教研室主任已审核");
                resultMap.put("result1", "不通过");
                break;
            case 41:
                resultMap.put("status1", "教研室主任已审核，下级系主任");
                resultMap.put("result1", "通过");

                break;
            case 50:
                resultMap.put("status1", "系主任已审核");
                resultMap.put("result1", "不通过");
                break;
            case 51:
                resultMap.put("status1", "系主任已审核，下级主管院长");
                resultMap.put("result1", "通过");
                break;
            case 60:
                resultMap.put("status1", "主管院长已审核");
                resultMap.put("result1", "不通过");
                break;
            case 61:
                resultMap.put("status1", "主管院长已审核，审核结束");
                resultMap.put("result1", "通过");
                break;

        }
        return resultMap;
    }


}
