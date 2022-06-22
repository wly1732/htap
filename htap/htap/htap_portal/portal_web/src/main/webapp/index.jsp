<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.bootcss.com/Swiper/4.5.0/css/swiper.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/about.css">
    <title>Document</title>
    <!--如果在页面中写了base标签后，当前页面中所有的路径都接着往下写就行了-->
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/locale/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
            //登录按钮绑定事件
            $('#btn').click(function () {
               $('#dlg').dialog('open').dialog('center').dialog('setTitle','欢迎登录');
            });
            //给登录表单中的登录按钮绑定事件，发送请求到后台
            $('#loginBtn').click(function () {
                $.post('http://localhost:8080/manager/host/login',$('#fm').serialize(),function (data) {
                    if(eval(data)){
                        $('#login_span').html('欢迎登录！');
                        $('#dlg').dialog('close');
                    }
                });
                
            });
        })
    </script>
</head>



<body>
     <!-- 顶部导航布局开始 -->
     <div>
        <div class="nav_login">
            <div class="juzhong">
                <p>group2主持人欢迎您！ 客服：17327195597</p>
                <p class="p_login"> <span id="login_span"> <a href="javascript:;" id="btn"> 登录 </a>  |<a href="register.jsp  "> 注册</a></span></p>
            </div>
        </div>
        <div class="nav_logo">
            <div class="juzhong">
                <img src="./img/logo.jpg" alt="">
            </div>
        </div>
        <div class="nav_img">
            <img src="./img/主持人_-_筛选列表_02.jpg" alt="">
        </div>
        <div class="nav_label">
            <div class="juzhong">
                <ui>
                    <li class="active"> <a href="#">首页</a> </li>
                    <li> <a href="details.html">主持人</a> </li>
                    <li> <a href="join.html">加入我们</a> </li>
                    <li> <a href="about.html">关于我们</a> </li>
                </ui>
            </div>
        </div>
    </div>
    <!-- 顶部导航布局结束 -->
    <!--     搜索部分开始 -->
    <div class="search_box">
        <div class="search_content">
            <div class="search_select">
                <span>典礼日期</span>
                <select name="" id="">
                    <option value=""></option>
                </select>
            </div>
            <div class="search_select">
                <span>时间</span>
                <select name="" id="">
                    <option value=""></option>
                </select>
            </div>
            <div class="search_select">
                <span>仪式风格</span>
                <select name="" id="">
                    <option value=""></option>
                </select>
            </div>
            <div class="select_btn">
                搜索主持人
            </div>
        </div>
        <!-- 搜索部分结束-->
        <!-- 热门推荐开始 -->
        <div class="hot_box">
            <div class="hot_title">
                <div class="every_day">
                    <img src="img/圆角矩形 4.png" alt="">
                </div>
                <div class="every_day_title">
                    <img src="img/火.png" alt="">
                    <img src="img/每日推荐.png" alt="">
                </div>
                <div class="watch_all">
                    查看所有主持人>>
                </div>
            </div>
            <div class="hot_content">
                <ul>
                    <li>
                        <div class="hot_content_img">
                             <a href='details.html'><img src="img/hot1.png" alt=""></a>
                        </div>
                        <div class="tuijian">
                            <a href='主持人详情.html'><img src="img/1.png" alt=""></a>
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：41000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot2.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot3.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot4.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot5.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot6.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot7.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot8.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot9.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot10.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot2.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot3.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot4.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot5.png" alt="">
                        </div>
                        <div class="tuijian">
                            <a href='主持人详情.html'></a><img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot6.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot7.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot8.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot9.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>

                    </li>
                    <li>
                        <div class="hot_content_img">
                            <img src="img/hot10.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/1.png" alt="">
                        </div>
                        <div class="tuijian">
                            <img src="img/星推荐.png" alt="">
                        </div>
                        <div class="hot_content_dec">
                            <p class="hot_content_name">张骏</p>
                            <p class="hot_content_price">主持价格：4000元</p>
                        </div>
                    </li>
                </ul>
            </div>

        </div>


        <!-- 热门推荐结束 -->
        <div class="advantage_box">
            <div class="hot_title">
                <div class="every_day">
                    <img src="img/圆角矩形 4.png" alt="">
                </div>
                <div class="every_day_title">
                    <img src="img/thumb-up-line.png" alt="">
                    <img src="img/我们的优势-1.png" alt="">
                </div>
                <div class="watch_all">
                </div>
            </div>
            <div class="swiper-container" id="banner">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <div class="lunbo">
                            <p>和谐的团队氛围</p>
                            <img src="img/图层 23 拷贝.png">
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="lunbo">
                            <p>和谐的团队氛围</p>
                            <img src="img/图层 23 拷贝.png">
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="lunbo">
                            <p>和谐的团队氛围</p>
                            <img src="img/图层 23 拷贝.png">
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="lunbo">
                            <p>和谐的团队氛围</p>
                            <img src="img/图层 23 拷贝.png">
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- 合作伙伴开始 -->
        <div class="friend_box">
            <div class="hot_title">
                <div class="every_day">
                    <img src="img/圆角矩形 4.png" alt="">
                </div>
                <div class="every_day_title">
                    <img src="img/合作.png" alt="">
                    <img src="img/合作伙伴.png" alt="">
                </div>
                <div class="watch_all">

                </div>
            </div>
            <div class="friend_content">
                <ul>
                    <li>
                        <img src="img/网站1.png" alt="">
                    </li>
                    <li>
                        <img src="img/网站2.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站3.png" alt="">
                    </li>
                    <li>
                        <img src="img/网站4.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站5.png" alt="">
                    </li>
                    <li>
                        <img src="img/网站6.png" alt="">
                    </li>
                    <li>
                        <img src="img/网站7.png" alt="">
                    </li>
                    <li>
                        <img src="img/首页_03.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站9.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站8.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站10.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站11.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站12.jpg" alt="">
                    </li>
                    <li>
                        <img src="img/网站13.png" alt="">
                    </li>
                </ul>



            </div>
        </div>
        <!-- 合作伙伴结束 -->



        <!-- 底部开始 -->
        <div class='footer'>
            <div class='footer_warp'>
                <div class='footer_left'>
                    <p class='footer_left_top'>联系我们</p>
                    <p class='footer_left_content'>公司地址：常州工学院辽河路666号 / 监督电话：17327195597</p>
                    <p class='footer_left_bottom'>copyright2000-2000 版权归常州工学院主持人所有 </p>
                </div>
                <div class='footer_right'>
                    <div class='QR_left'>
                        <img src="img/QR_04.png" alt="">
                        <div class='QR_left_img'>
                            <img src="img/QR_03.png" alt="">
                        </div>
                        <p>官方服务号</p>
                    </div>
                    <div class='QR_left'>
                        <img src="img/QR_02.png" alt="">
                        <div class='QR_left_img'>
                            <img src="img/QR_01.png" alt="">
                        </div>
                        <p>官方服务号</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部结束 -->
        <!-- 固定定位导航布局开始 -->
        <div class="QR_right">
            <div class='QR_right_top'>
                <!-- <img src="img/QR_small.png" alt=""> -->
                <img src="img/QR_small.png" alt="">
                <div class='QR_box'>
                    <div class='QR_box_content'>
                        <img src="img/QR_right.png" alt="">
                        <p class='QR_box_content_font'>关注官方二维码接受订单通知</p>
                    </div>
                    <div class='QR_box_triangle'>
                        <img src="img/sanjiao.png" alt="">
                    </div>
                </div>
            </div>
            <a href="#">
                <div class='QR_right_bottom'>
                    <img src="img/jiantou.png" alt="">
                </div>
            </a>
        </div>

        <!-- 固定定位导航布局结束 -->
        </div>
     <!-- 登录的对话框(dialog) -->
     <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin'">
         <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
             <div style="margin-bottom:10px">
                 <input name="hname" class="easyui-textbox" label="用户名:" style="width:100%">
             </div>
             <div style="margin-bottom:10px">
                 <input name="hpwd" class="easyui-textbox" label="密码:" style="width:100%">
             </div>
             <div style="margin-bottom:10px">
                 <a href="javascript:;" id="loginBtn" class="easyui-linkbutton">登录</a>
             </div>
         </form>
     </div>
</body>



<script src="https://cdn.bootcss.com/Swiper/4.5.0/js/swiper.min.js"></script>
<script type="text/javascript">
    // 轮播图
    $(function () {
        var mySwiper = new Swiper("#banner", {
            loop: true,
            loopedSlides: 5,
            slidesPerView: 'auto',
            autoplay: true,
            centeredSlides: true,
            initialSlide: 2,
            watchSlidesProgress: true,
            pagination: {
                el: '.banner_page',
                clickable: true,
            },
            on: {
                progress: function (progress) {
                    for (i = 0; i < this.slides.length; i++) {
                        var slide = this.slides.eq(i);
                        var slideProgress = this.slides[i].progress;
                        if (Math.abs(slideProgress) > 1) {
                            var modify = (Math.abs(slideProgress) - 1) * 0.4 + 1;
                        }
                        translate = slideProgress * modify * 318 + 'px';
                        scale = 1 - Math.abs(slideProgress) / 5;
                        zIndex = 999 - Math.abs(Math.round(10 * slideProgress));
                        slide.transform('translateX(' + translate + ') scale(' + scale + ')');
                        slide.css('zIndex', zIndex);
                        slide.css('opacity', 1);
                        if (Math.abs(slideProgress) > 3) {
                            slide.css('opacity', 0);
                        }
                    }
                },
                setTransition: function (transition) {
                    for (var i = 0; i < this.slides.length; i++) {
                        var slide = this.slides.eq(i)
                        slide.transition(transition);
                    }

                }
            }
        })
    })

</script>
<script> $(".nav_label li").click(function () {
    $(this).siblings('li').removeClass('active');
    $(this).addClass('active');
})</script>
</html>
