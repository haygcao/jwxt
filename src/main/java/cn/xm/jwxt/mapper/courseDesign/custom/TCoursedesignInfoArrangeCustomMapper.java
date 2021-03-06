package cn.xm.jwxt.mapper.courseDesign.custom;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TCoursedesignInfoArrangeCustomMapper {

    /**
     *  查询需要安排的课设
     * @param condition
     * @return
     */
    List<Map<String,Object>> findNeedArrangeCourseDesign(Map<String, Object> condition) throws SQLException;

    /**
     *  安排课设 ，在三个表中插入数据
     * @param condition
     * @return
     */
    public boolean addCourseDesignerinfoArrange(Map<String,Object> condition) throws SQLException;
    public boolean addCourseDesignTeacherArrange(Map<String,Object> condition) throws SQLException;
    public boolean addCourseDesignTeacherStudent(Map<String,Object> condition) throws SQLException;
    public boolean addCourseDesignClassArrange(Map<String,Object> condition) throws SQLException;

    /**
     *  删除安排信息
     * @param courseDesignArrangeID
     * @return
     */
    public boolean deleteCourseDesignerinfoArrange(String courseDesignArrangeID) throws SQLException;
    public boolean deleteCourseDesignTeacherArrange(String courseDesignArrangeID) throws SQLException;
    public boolean deleteCourseDesignClassArrange(String courseDesignArrangeID) throws SQLException;
    public boolean deleteCourseDesignTeacherStudent(String courseDesignTeacherArrangeID) throws SQLException;

    /**
     *  修改安排信息的显示状态
     * @param condition  存两个参数，一个是id的list集合，一个是要改变的最终display的状态值
     * @return
     */
    public boolean modifyCourseDesignerinfoArrange(Map<String,Object> condition) throws SQLException;
    public boolean modifyCourseDesignTeacherArrange(Map<String,Object> condition) throws SQLException;
    public boolean modifyCourseDesignTeacherStudent(Map<String,Object> condition) throws SQLException;
    public boolean modifyCourseDesignClassArrange(Map<String,Object> condition) throws SQLException;

    /**
     * 根据trainCourseID查询详细安排信息
     * //@param  condition  trainCourseID  yearNum  majorID
     * @param courseDesignArrangeID
     * @return
     */
    List<Map<String,Object>> findArrangeInfoDetailByCondition(String courseDesignArrangeID) throws SQLException;

    /**
     *  根据courseDesignTeacherArrangeID 查询学生列表
     * @param courseDesignTeacherArrangeID
     * @return
     */
    List<String> findStudentListBycourseDesignTeacherArrangeID(String courseDesignTeacherArrangeID) throws SQLException;

    /**
     * 教研室主任查看已安排的课设详细信息
     * @param condition  存多个参数
     * @return  返回t_courseDesign_info，trainSchemeCourseDesign的组合
     */
    List<Map<String,Object>> findAllTCoursedesignInfo(Map<String, Object> condition) throws SQLException;


}