<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2022/6/16
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--如果在页面中写了base标签后，当前页面中所有的路径都接着往下写就行了-->
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>


</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'团队背景',collapsible:false" style="width:40%;padding:10px;">
    <font size="5">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随着互联网的发展,很多线下销售的产品陆陆续续变为线上销<p></p>售,打破空间的限制.每年国内有成百上千万的人结婚,每对新人都<p></p>希望自己的婚礼和谐幸福圆满的展开.
        一个美好的婚礼,需要一位<p></p>高素质高质量的婚礼主持人,需要一个认真负责有想法的婚礼策划<p></p>团队,而现实生活中,大部分人仍然是按照熟人推荐的方式寻找适合<p></p>的婚礼主持人和策划团队,无法保证质量,对于主持人和策划团队没<p></p>有量化的评估,以及客户的客观评价等.
        而婚礼是人生的头等大<p></p>事,group2主持人项目采用O2O的方式,线上预约主持人和婚礼策<p></p>划团队,通过种种量化手段,尽量保证每位新人都能寻找到合适的主<p></p>持人选和策划团队,人生不留遗憾........</font>



</div>
<div data-options="region:'center'" title="关于我们" style="width: 60%">
    <div class="page-content-main">
        <div class="article">

            <p ><a href="http://localhost:8081/portal" target="_blank"><strong >Group2</strong></a>（localhost:8081/portal），是由“常州工学院第二组”开发的一家专注于在线预约优秀婚礼主持人的网站，我们整合了全国多个城市的优秀婚礼主持人，搭建了结婚新人与婚礼主持人的桥梁，让结婚新人精准的找到适合自己婚礼风格优秀司仪，让优秀司仪能为更多的结婚新人服务。
            </p>

            <h4 ><strong>为什么要选择Group2</strong></h4>
            <p>Group2的婚礼主持人司仪，经过全国各地层层筛选，严格审查，平台所展示的司仪图片、视频及其他信息真实有效。</p>
            <h4><strong>关于主持人的价格</strong></h4>
            <p>通过Group2在线预约司仪，避开婚庆公司中间抽水环节，直接在线预订婚礼主持人，价格透明，无中间差价。</p>

            <h4><strong>还有什么其他婚庆服务</strong></h4>
            <p>关于婚庆其他服务，例如婚礼策划、婚礼拍摄、婚车租赁，等业务我们正在筹备中，喜匠网致力打造一个全方位为结婚新人服务的优秀平台。</p>




        </div>
    </div>


</div>

</body>
</html>
