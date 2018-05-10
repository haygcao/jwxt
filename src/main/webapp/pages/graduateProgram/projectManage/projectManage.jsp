<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>课题管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

    <%-- qlq引入的公共的JSP --%>
    <%@include file="/tag.jsp"%>
    <%@ include file="/cssJs.jsp"%>

    <script src="${baseurl}/js/graduateProgram/projectManage/projectManage.js"></script>
</head>

<body>
<%-- qlq引入的公共的JSP --%>
<%@include file="/tag.jsp"%>
<!--面包屑-->
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="../../../welcome.jsp">首页</a>
        <a href="javascript:void(0)">毕业设计管理</a>
        <a href="javascript:void(0)">课题管理</a>
        <a>
          <cite>课题管理</cite>
        </a>
      </span>
    <a class="layui-btn layui-btn-small" style="margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="iconfont" style="line-height:30px">&#xe6aa;</i>
    </a>
    <a class="layui-btn layui-btn-warm layui-btn-small" style="margin-top:3px;float:right;margin-right:3px;"
       onclick="closeOther()" title="关闭其他">
        <i class="iconfont" style="line-height:30px">&#xe6b7;</i>
    </a>
</div>
<!--主体-->
<div class="x-body">
    <!--查询-->
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="y_formm">
            <input type="text" name="username" placeholder="教师名称" autocomplete="off" class="layui-input">
            <input type="text" name="username" placeholder="课题名称" autocomplete="off" class="layui-input">
            <input type="text" name="" class="layui-input" id="L_pass" placeholder="学年" autocomplete="off">
            <div class="layui-input-inline">
                <select name="contrller">
                    <option>是否确认</option>
                    <option>已确认</option>
                    <option>未确认</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="contrller">
                    <option>是否满足需求</option>
                    <option>满足</option>
                    <option>不满足</option>
                </select>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <!--end查询-->

    <!--操作区域-->
    <xblock>
        <!--这里不判断教师人数是否够-->
        <button class="layui-btn" onclick="x_admin_show('为学生分配毕设教师','./projectManage-assign.jsp')">为学生分配毕设教师 </button>
        <button class="layui-btn" onclick="x_admin_show('任务书管理','./projectManage-assigementCheck.jsp')">任务书管理</button>
        <button class="layui-btn layui-btn-normal" onclick="x_admin_show('导出/发布','./projectManage-output.jsp')">导出/发布</button>
    </xblock>
    <!--end 操作区域-->

    <!--表格内容-->
    <table class="layui-table">
        <thead>
        <tr>
            <th>选择</th>
            <th>学年</th>
            <th>课题名称</th>
            <th>教师</th>
            <th>专业</th>
            <th>所需人数</th>
            <th>确认人数</th>
            <th>是否确认</th>
            <th>是否满足需求</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">
                    &#xe605;</i></div>
            </td>
            <td>2014</td>
            <td>阿萨德发</td>
            <td>王丽</td>
            <td>软件工程</td>
            <td>3</td>
            <td>3</td>
            <td>已确认</td>
            <td>是</td>
            <td class="td-manage">
                <a title="详细信息" onclick="x_admin_show('详细信息','projectManage-view.jsp')">
                    <i class="layui-icon">&#xe63c;</i>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
    <!--end 表格内容-->

    <!--分页-->
    <div id="y_page"></div>
    <!--end 分页-->
</div>

</body>

</html>