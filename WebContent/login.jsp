<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery-2.0.0.min.js"></script>
<script src="./js/jquery-ui.js"></script>
<script type="text/javascript">
function ajaxSubmit(frm, fn) {
    var dataPara = getFormJson(frm);
    //console.log(frm);
    $.ajax({
        url: frm.action,
        type: frm.method,
        data: dataPara,
        success: fn
    });
}


function getFormJson(frm) {
    var o = {};
    var a = $(frm).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
}

$(document).ready(function(){
    $('.form-horizontal').bind('submit', function(event){
    	event.preventDefault();
    	//console.log(event.type);
        ajaxSubmit(this, function(data){
        	
        	var json = eval('(' + data + ')');
        	if(json.error==3){
        		window.location.href=json.url;
        	}
        	if(json.error==4){
        		alert("密码错误")
        	}
        	if(json.error==0){
        		alert("注册成功，请登录")
        	}
        	
        });
        return false;
    });
});

</script>

<title>登录</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3>请登录:</h3>
				<form class="form-horizontal" method="post" action="./user.jsp">
					<div class="control-group">
						<label class="control-label" for="inputEmail">用户名</label>
						<div class="controls">
							<input id="inputEmail" type="text"  name="username" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">密码</label>
						<div class="controls">
							<input id="inputPassword" type="password" name="password" />
						</div>
					</div>
					<input class="hide input-medium search-query"
						type="text" value="1" name="p" />
					<div class="control-group">
						<div class="controls">
							<label class="checkbox">
							<input type="checkbox" />
								记住我的名字</label>
							<button type="login" class="btn">登录或注册</button>
							<!--<button type="signin" class="btn" formaction="./user.jsp">登陆</button>-->
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
	</div>


</body>
</html>