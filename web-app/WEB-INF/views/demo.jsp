<%--
  Created by IntelliJ IDEA.
  User: laiyz
  Date: 2018/11/26
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>demo</title>
    <!-- Bootstrap -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css">
    <link rel="stylesheet" href="/static/css/combo.select.css">

    <link rel="stylesheet" href="/static/css/bootstrap-select.css">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="/static/js/jquery.combo.select.js"></script>
    <script src="/static/js/dropdown.min.js"></script>
    <script src="/static/js/bootstrap-select.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>

    <%--<div class="col-md-2">--%>
        <%--<div class="combo-select">--%>
            <%--<select name="ops" tabindex="-1"></select>--%>
            <%--<ul class="combo-dropdown">--%>
                <%--<li class="option-item" data-index="0" data-value="0">选项1</li>--%>
                <%--<li class="option-item" data-index="1" data-value="1">选项2</li>--%>
                <%--<li class="option-item" data-index="2" data-value="2">选项3</li>--%>
                <%--<li class="option-item" data-index="3" data-value="3">选项4</li>--%>
            <%--</ul>--%>
            <%--<input type="text" placeholder="请选择" class="combo-input">--%>
            <%--<input type="text" placeholder="请选择">--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="col-md-8">
        <select id="comb_select" ></select>
    </div>

    <div class="col-md-5">
        <select class="selectpicker" data-live-search="true" multiple data-style="btn-primary">
            <option >Mustard</option>
            <option >Ketchup</option>
            <option >Relish</option>
        </select>
    </div>








</body>
<script>


    $(function(){
        singleComboSelect({
            id : 'comb_select',
            url : '/comboSelectJson',
            valueField : 'v',
            textField : 't',
            jsonData : [{
                'v' : 1,
                't' : '选项1'
            },{
                'v' : 2,
                't' : '选项2'
            },{
                'v' : 3,
                't' : '选项3'
            }]
        })

    });

    function singleComboSelect(info) {

        var id = info.id.trim();
        var url = info.url.trim();

        var valueField = 'value';
        var textField = 'name';

        if (info.valueField != undefined && info.valueField != null && info.valueField.trim() != ''){
            valueField = info.valueField;
        }

        if (info.textField != undefined && info.textField != null && info.textField.trim() != ''){
            textField = info.textField;
        }
        
        if (info.jsonData != undefined && info.jsonData.length > 0){
            var data = info.jsonData;
            for (var i=0; i<data.length; i++){
                $('#'+id).append("<option value='"+ data[i][valueField] + "'>"+data[i][textField]+"</option>");
            }
            $('#'+id).comboSelect();
        }else {
            $.get(url,function (data) {
                console.log(data);
                for (var i=0; i<data.length; i++){
                    $('#'+id).append("<option value='"+ data[i][valueField] + "'>"+data[i][textField]+"</option>");
                }
                $('#'+id).comboSelect();
            },'JSON');
        }


    }

</script>
</html>
