package cn.xm.jwxt.service.impl.graduateDesign.graduateManage;

import cn.xm.jwxt.bean.baseInfo.TMajorBaseInfo;
import cn.xm.jwxt.bean.graduateDesign.Gradeuatebaseinfo;
import cn.xm.jwxt.mapper.graduateDesign.graduateManage.GraduateManageMapper;
import cn.xm.jwxt.service.graduateDesign.graduateManage.GraduateManageService;
import cn.xm.jwxt.utils.DateHandler;
import cn.xm.jwxt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class GraduateManageServiceImpl implements GraduateManageService {

    @Autowired
    GraduateManageMapper graduateManageMapper;

    @Override
    public List<String> getYearNum() throws Exception {
        return graduateManageMapper.selectYearNum();
    }

    @Override
    public Boolean addGraduateInfo(Gradeuatebaseinfo gradeuatebaseinfo) throws Exception {
        gradeuatebaseinfo.setGradesignid(UUIDUtil.getUUID2());

        //默认设置当前学年
        String currentYearNum = "";
        String currentSemesterNum = "";
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(calendar.MONTH) + 1;
        int year = calendar.get(calendar.YEAR);
        if (3 <= month && month < 8) { //第二学期
            currentYearNum = (year - 1) + "-" + year;
            currentSemesterNum = "二";
        } else {
            currentYearNum = year + "-" + (year + 1);
            currentSemesterNum = "一";
        }
        gradeuatebaseinfo.setYearnum(currentYearNum);
        gradeuatebaseinfo.setSemesternum(currentSemesterNum);

        int res = graduateManageMapper.insertGraduateInfo(gradeuatebaseinfo);
        return res > 0 ? true : false;
    }

    @Override
    public List<Map<String, String>> getGraduateInfoByCondition(Map<String, String> condition) throws Exception {
        return graduateManageMapper.selectGraduateInfoByCondition(condition);
    }

    @Override
    public Boolean removeGraduateInfo(String graDesignID) throws Exception {
        int res = graduateManageMapper.deleteGraduateInfo(graDesignID);
        return res > 0 ? true : false;
    }

    @Override
    public Boolean modifyGraduateInfo(Gradeuatebaseinfo gradeuatebaseinfo) throws Exception {
        int res = graduateManageMapper.updateGraduateInfo(gradeuatebaseinfo);
        return res > 0 ? true : false;
    }

    @Override
    public List<TMajorBaseInfo> getMajor() throws Exception {
        return graduateManageMapper.selectMajor();
    }

    @Override
    public String getMajorGraduateNum(String userid) throws Exception {
        //默认设置当前学年
        String currentYearNum = DateHandler.getCurrentYearNum();
        String currentSemesterNum = "";
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(calendar.MONTH) + 1;
        if (3 <= month && month < 8) { //第二学期
            currentSemesterNum = "二";
        } else {
            currentSemesterNum = "一";
        }
        //根据用户id，查询专业id
        String MajorID = graduateManageMapper.selectMajorIDByUserID(userid);

        Gradeuatebaseinfo gradeuatebaseinfo = new Gradeuatebaseinfo();
        gradeuatebaseinfo.setYearnum(currentYearNum);
        gradeuatebaseinfo.setSemesternum(currentSemesterNum);
        gradeuatebaseinfo.setYearnum(currentSemesterNum);
        gradeuatebaseinfo.setMajorid(MajorID);

        int res = graduateManageMapper.selectMajorGraduateNum(gradeuatebaseinfo);

        return Integer.toString(res);
    }

    @Override
    public Boolean getTeacherTitleNum(String graDesignID) throws Exception {
        int res = graduateManageMapper.selectTeacherTitleNum(graDesignID);
        return res > 0 ? false : true;
    }
}
