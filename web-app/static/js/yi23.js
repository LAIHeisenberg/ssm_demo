var Yi23 = {

    //工具类
    util: {
        //验证字符串是否为空
        isEmpty:function(str){
            return (typeof str=== 'undefined' || str===null || (typeof str==='string' && str.trim() ==='') || str === 'null');
        },

        isNotEmpty:function(v){
            return !Yi23.util.isEmpty(v);
        },

        /**
         * 时间格式化 返回格式化的时间
         * @param date {object}  可选参数，要格式化的data对象，没有则为当前时间
         * @param fomat {string} 格式化字符串，例如：'YYYY年MM月DD日 hh时mm分ss秒 星期' 'YYYY/MM/DD week' (中文为星期，英文为week)
         * @return {string} 返回格式化的字符串
         *
         * 例子:
         * formatDate(new Date("january 01,2012"));
         * formatDate(new Date());
         * formatDate('YYYY年MM月DD日 hh时mm分ss秒 星期 YYYY-MM-DD week');
         * formatDate(new Date("january 01,2012"),'YYYY年MM月DD日 hh时mm分ss秒 星期 YYYY/MM/DD week');
         *
         * 格式：
         *    YYYY：4位年,如1993
         　　 *　　YY：2位年,如93
         　　 *　　MM：月份
         　　 *　　DD：日期
         　　 *　　hh：小时
         　　 *　　mm：分钟
         　　 *　　ss：秒钟
         　　 *　　星期：星期，返回如 星期二
         　　 *　　周：返回如 周二
         　　 *　　week：英文星期全称，返回如 Saturday
         　　 *　　www：三位英文星期，返回如 Sat
         */
        formatDate :function (date, format) {

            function addZero(str,length){
                return new Array(length-(''+str).length+1).join("0") + str;
            }

            if (arguments.length < 2 && !date.getTime) {
                format = date;
                date = new Date();
            }
            typeof format !== 'string' && (format = 'YYYY年MM月DD日 hh时mm分ss秒');
            var week = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', '日', '一', '二', '三', '四', '五', '六'];
            return format.replace(/YYYY|YY|MM|DD|hh|mm|ss|星期|周|www|week/g, function(a) {
                switch (a) {
                    case "YYYY": return date.getFullYear();
                    case "YY": return (date.getFullYear()+"").slice(2);
                    case "MM": return addZero(date.getMonth() + 1,2);
                    case "DD": return addZero(date.getDate(),2);
                    case "hh": return addZero(date.getHours(),2);
                    case "mm": return addZero(date.getMinutes(),2);
                    case "ss": return addZero(date.getSeconds(),2);
                    case "星期": return "星期" + week[date.getDay() + 7];
                    case "周": return "周" +  week[date.getDay() + 7];
                    case "week": return week[date.getDay()];
                    case "www": return week[date.getDay()].slice(0,3);
                }
            });
        },

        //取cookie
        getCookie:function(objName){//获取指定名称的cookie的值

            var arrStr = document.cookie.split("; ");

            for(var i = 0;i < arrStr.length;i ++){

                var temp = arrStr[i].split("=");

                if(temp[0] === objName) {
                    return unescape(temp[1]);
                }

            }

            return undefined;

        },

        //设置Cookie
        setCookie:function (name,value,expires){

            var exp  = new Date();

            exp.setTime(exp.getTime() + expires);

            document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+';';

        } ,

        //删除cookie
        delCookie:function(name){//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
            var date = new Date();
            date.setTime(date.getTime() - 10000);
            document.cookie = name + "=0; path=/;expires=" + date.toGMTString();
        },

        //url 参数
        getUrlParams: function(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");

            var r = window.location.search.substr(1).match(reg);

            if (r !== null)
                return r[2];

            return null;
        },

        isInteger:function(obj) {
            return Math.floor(obj) === obj
        },

        toInteger:function (floatNum) {
            var ret = {times: 1, num: 0};
            if (Yi23.util.isInteger(floatNum)) {
                ret.num = floatNum;
                return ret
            }
            var strfi  = floatNum + '';
            var dotPos = strfi.indexOf('.');
            var len    = strfi.substr(dotPos+1).length;
            var times  = Math.pow(10, len);
            var intNum = parseInt(floatNum * times + 0.5, 10);
            ret.times  = times;
            ret.num    = intNum;
            return ret
        },

        operation:function (a, b, op) {
            var o1 = Yi23.util.toInteger(a);
            var o2 = Yi23.util.toInteger(b);
            var n1 = o1.num;
            var n2 = o2.num;
            var t1 = o1.times;
            var t2 = o2.times;
            var max = t1 > t2 ? t1 : t2;
            var result = null;
            switch (op) {
                case 'add':
                    if (t1 === t2) { // 两个小数位数相同
                        result = n1 + n2
                    } else if (t1 > t2) { // o1 小数位 大于 o2
                        result = n1 + n2 * (t1 / t2)
                    } else { // o1 小数位 小于 o2
                        result = n1 * (t2 / t1) + n2
                    }
                    return result / max;
                case 'subtract':
                    if (t1 === t2) {
                        result = n1 - n2
                    } else if (t1 > t2) {
                        result = n1 - n2 * (t1 / t2)
                    } else {
                        result = n1 * (t2 / t1) - n2
                    }
                    return result / max;
                case 'multiply':
                    result = (n1 * n2) / (t1 * t2);
                    return result;
                case 'divide':
                    result = (n1 / n2) * (t2 / t1);
                    return result
            }
        }
    }

};

var yiCombobox = function(obj){

    var id = obj.id;

    var vf = "value";
    var tf = "text";
    var method = 'GET';
    var multiple = false;
    if(Yi23.util.isNotEmpty(obj.valueField)){
        vf = obj.valueField;
    }
    if(Yi23.util.isNotEmpty(obj.textField)){
        tf = obj.textField;
    }
    if(Yi23.util.isNotEmpty(obj.method)){
        method = obj.method;
    }
    if(Yi23.util.isNotEmpty(obj.multiple)){
        multiple = obj.multiple;
    }

    var url = obj.url;
    var jsonData = [];

    $.ajax({
        url : url,
        method : method,
        async : false,
        dataType : 'json',
        success : function (data) {
            jsonData = data;
        }
    });

    var tmp = {};
    tmp[tf] = obj.placeholder;
    tmp[vf] = '';
    jsonData.push(tmp);

    $("#"+id).combobox({
        valueField : vf,
        textField : tf,
        fit : true,
        value:'',
        data : jsonData,
        multiple : multiple
    });
    $("#"+id).combobox('setText',obj.placeholder);

}

var yiDatetime = function(obj){


    var id = obj.id;
    var groupField = obj.groupField;

    if(Yi23.util.isNotEmpty(groupField)){
        $("#"+id).attr("groupField",groupField);
    }
    var $input = $("#"+id);
    $($input).datetimebox({
        width:200,
        currentText : '今天',
        closeText : '关闭',
        okText : '确定',
        fit: true,
        formatter : function (date) {
            return Yi23.util.formatDate(date,'YYYY-MM-DD hh:mm:ss');
        }
        // onSelect: function (date) {
        //     console.log(date);
        //     var arr = $("input[groupField='"+groupField+"']");
        //
        //     var beginTime = $(arr[0]).datetimebox('getValue');
        //     var endTime = $(arr[0]).datetimebox('getValue');
        //
        //     beginTime = new Date(beginTime.replace(/-/g,"/")).getTime();
        //     endTime = new Date(endTime.replace(/-/g,'/')).getTime();
        //     console.log("beginTime: "+beginTime);
        //     console.log("endTime: "+ endTime);
        //     if(endTime < beginTime){
        //         swal("截止日期不能早于起始日期");
        //     }
        //     return true;
        //
        // }
    });

    var placeholder = obj.placeholder;
    if(Yi23.util.isNotEmpty(placeholder)){
        $('#'+id).setText(placeholder);
    }

}
//回到顶部
function goTop() {
    $('html,body').animate({
        'scrollTop': 0
    }, 600);
}
