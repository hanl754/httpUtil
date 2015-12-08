<%--
  Created by IntelliJ IDEA.
  User: hanliang1
  Date: 2015/12/7
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simlefish's util</title>
    <script src="/js/jquery-1.6.2.min.js"></script>
    <style>
        .l {
            float: left;
            width: 35%;
        }
        .m {
            float: left;
            width: 5%;
        }
        .r {
            float: left;
            width: 55%;
        }
        .arrow {
            margin-top: 200px;
            margin-bottom: 25px;
        }
        .ipt {
            width: 300px;
            height: 25px;
        }
    </style>
</head>
<body>
    <div>
        baseUrl:
        <input class="ipt" type="text"/>
    </div>
    <div class="l">
        <textarea id="input" cols="85" rows="50">

        </textarea>
    </div>
    <div class="m">
        <select name="method" id="s">
            <option value="post">POST</option>
            <option value="get">GET</option>
        </select>
        <div class="arrow">======></div>
        <button id="go">GO</button>
    </div>
    <div class="r">
        <textarea id="output" cols="120" rows="50">

        </textarea>
    </div>
</body>
<script>
    $(function() {
        $("#go").click(function() {
            var params = $("#input").val();
            var baseUrl = $(".ipt").val();
            var method = $("#s").val();
//            alert(params + "|" + baseUrl + "|" + method);
            switch(method) {
                case "get":
                    doGet(baseUrl, params);
                    break;
                case "post":
                    doPost(baseUrl, params);
                    break;
            }
        });
    });

    function doGet(baseUrl, params) {
        $.post("/proxy/get/", {
            "baseUrl": baseUrl,
            "params": params,
            "extras": ""
        }, function(data) {
            alert(data);
        });
    }

    function doPost(baseUrl, params) {
        $.post("/proxy/post/", {
            "baseUrl": baseUrl,
            "params": params,
            "extras": ""
        }, function(data) {
            alert(data);
        });
    }

</script>
</html>