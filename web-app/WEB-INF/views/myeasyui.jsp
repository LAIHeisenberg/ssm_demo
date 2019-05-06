<%--
  Created by IntelliJ IDEA.
  User: laiyz
  Date: 2018/11/27
  Time: 下午12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>easyui</title>
    <link rel="stylesheet" type="text/css" href="/static/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <script type="text/javascript" src="/static/js/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/yi23.js" ></script>
</head>
<body>
    <h2>Basic Panel</h2>
    <p>The panel is a container for other components or elements.</p>
    <div style="margin:20px 0 10px 0;">
        <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
        <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
    </div>
    <div id="p" class="easyui-panel" title="Basic Panel" style="width:700px;height:200px;padding:10px;">
        <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
        <ul>
            <li>easyui is a collection of user-interface plugin based on jQuery.</li>
            <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
            <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
            <li>complete framework for HTML5 web page.</li>
            <li>easyui save your time and scales while developing your products.</li>
            <li>easyui is very easy but powerful.</li>
        </ul>
    </div>
    <div>
        <input id="add_stime" type="text" name="add_stime" />
    </div>
    <div>
        <input id="combox" />
    </div>
</body>
</html>

<script>

    $(function(){


        var jsonData = [{
            "id":1,
            "text":"text1"
        },{
            "id":2,
            "text":"text2"
        },{
            "id":3,
            "text":"text3",
            "selected":true
        },{
            "id":4,
            "text":"text4"
        },{
            "id":5,
            "text":"text5"
        }];

        $('#combox').combobox({
            url:'combobox_data.json',
            valueField:'id',
            textField:'text',
            data : jsonData,

        });

        $('#add_stime').datetimebox({
            width:200,
            currentText : '今天',
            closeText : '关闭',
            okText : '确定',
            fit: true,
            formatter : function (date) {
                console.log(date);
                var d = Yi23.util.formatDate(date,'YYYY-MM-DD hh:mm:ss');
                console.log("add_etime: "+d);
                // return "2018-12-19 22:50:55";
                return d;
            },
            parser : function (s) {
                console.log("parser....");
                if(Yi23.util.isNotEmpty(s)){
                    return new Date(s.replace(/-/g,"/"));
                }else {
                    return new Date();
                }
            }
        });
    })
</script>