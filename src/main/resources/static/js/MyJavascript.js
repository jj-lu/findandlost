var clock = '';
		var nums = 30;
		var btn;
		function sendCode(thisBtn) {
			btn = thisBtn;
			btn.disabled = true; //将按钮置为不可点击
			btn.value = '重新获取（'+nums+'）';
			clock = setInterval(doLoop, 1000); //一秒执行一次
		}

		function doLoop() {
			nums--;
			if (nums > 0) {
				btn.value = '重新获取（'+nums+'）';
			} else {
				clearInterval(clock); //清除js定时器
				btn.disabled = false;
				btn.value = '点击发送验证码';
				nums = 10; //重置时间
			}
		}
		
		function login(){
			var form = $("#loginform");
			var formdata = new FormData(form[0]);
			$.ajax({
				type:"post",
				url:"login",
				data:formdata,
				async:false,
				cache:false,
				contentType:false,
				processData:false,
				success:function(data){
// 					alert(data);
					if(data == "user"){
						alert("欢迎用户登录！");
						window.location.reload();
					}else if(data == "false"){
						alert("登录失败！请检查登录名和密码~");
					}else if(data == "admin"){
						alert("欢迎管理员登录！");
// 						var href= "[[@{/admin}]]";
						location.href= "admin";
					}
				}
			})
		}
		
		function regist(){
			var form = $("#registform");
			var formdata = new FormData(form[0]);
			$.ajax({
				type:"post",
				url:"insertUser",
				data:formdata,
				async:false,
				cache:false,
				contentType:false,
				processData:false,
				success:function(data){
					if(data == "OK"){
						alert("注册用户成功！");
					}else{
						alert("注册用户失败，请检查数据！")
					}
				}
			});
		}
	 
    $(function(){
			$('#carousel-example-generic').carousel({interval:2000});
		});
		
		//失物的状态与发布者
		function setStatus(status){
			try{
				var se = document.getElementById("ids").value;
				if(se == ""){
					throw "session为空";
				}else{
					$("#u_id").val(se)
					$("#c_status").val(status);
					$('#newGoodsDialog').modal('show');
				}
			}catch(err){
				alert("请登录后再进行物品发布！");
			}
			
		}

		// 创建物品
		function createGoods() {
			
			
// 			alert(se);
// 			if(se == null){
// 				alert("aaa");
// 			}else{
// 				alert(se);
// 			}
			var form = $("#new_goods_form");  
			var formdata = new FormData(form[0]);
			$.ajax({
				type : "POST",  
		        url : "insertGoods",  
		        data : formdata,
		        async: false,  
		        cache: false,  
		        contentType: false,  
		        processData: false,
		        success : function(data) {  
		            if(data == "OK"){
		            	alert("失物添加成功！");
		            	window.location.reload();
		            }else{
		            	alert("失物添加失败！");
		            	window.location.reload();
		            }
		        }  
			})
		}
		

//修改物品editGoods
		function updateGoods() {
// 			$.post("updateGoods", $("#edit_goods_form").serialize(), function(
// 					data) {
// 				if (data == "OK") {
// 					alert("物品修改成功！");
// 					window.location.reload();
// 				} else {
// 					alert("物品修改失败！");
// 					window.location.reload();
// 				}
// 			});
			var form = $("#edit_goods_form");
			var formdata = new FormData(form[0]);
			$.ajax({
				type:"post",
				url:"updateGoods",
				data:formdata,
				async: false,  
			    cache: false,  
			    contentType: false,  
			    processData: false,
			    success : function (data){
			    	 if(data == "OK"){
			    		 alert("物品修改成功");
			    		 window.location.reload();
			    	 }else{
			    		 alert("物品修改失败！");
			    		 window.location.reload();
			    	 }
			     }
			})
		}

		

		//editgoods
		function editGoods(id) {
			$.ajax({
				type : "post",
				url : "/findGoodsById",
				data : {
					"id" : id
				},
				success : function(data) {
					$("#g_name").val(data.g_name);
					$("#g_ltime").val(data.g_ltime);
					$("#g_place").val(data.g_place);
					$("#g_title").val(data.g_title);
					$("#g_describe").val(data.g_describe);
					$("#g_key").val(data.g_key);
					$("#g_type").val(data.g_type);
					$("#c_status").val(data.classification.c_status);
					//alert(data.classification.c_status);
					$("#g_picture").val(data.g_picture);
					$("#picture").attr("src","img/"+data.g_picture);
					$("#u_id").val(data.user.u_id);
					$("#g_id").val(data.g_id);
// 					alert(data.classification.c_status);
				}
			})
		}

		

		//删除物品
		function deleteGoods(id) {
			var deletedata = confirm("确定删除物品");
			if (deletedata == true) {
				$.ajax({
					type : "post",
					url : "/deleteGoods",
					data : {
						"id" : id
					},
					success : function(data) {
						if (data == "OK") {
							alert("物品删除成功");
							window.location.reload();
						} else {
							alert("物品删除失败");
							window.location.reload();
						}
					}
				})
			}
		}
		

$(document).ready(function() {
		//打开会员登录 
		$("#Login_start_").click(function() {
			$("#regist_container").hide();
			$("#_close").show();
			$("#_start").animate({
				left: '350px',
				height: '650px',
				width: '400px'
			}, 500, function() {
				$("#login_container").show(500);
				$("#_close").animate({
					height: '40px',
					width: '40px'
				}, 500);
			});
		});
		//打开会员注册
		$("#Regist_start_").click(function() {
			$("#login_container").hide();
			$("#_close").show();
			$("#_start").animate({
				left: '350px',
				height: '650px',
				width: '400px'
			}, 500, function() {
				$("#regist_container").show(500);
				$("#_close").animate({
					height: '40px',
					width: '40px'
				}, 500);
			});
		});
		//关闭
		$("#_close").click(function() {
			
			$("#_close").animate({
				height: '0px',
				width: '0px'
			}, 500, function() {
				$("#_close").hide(500);
				$("#login_container").hide(500);
				$("#regist_container").hide(500);
				$("#_start").animate({
					left: '0px',
					height: '0px',
					width: '0px'
				}, 500);
			});
		});
		//去 注册
		$("#toRegist").click(function(){
			$("#login_container").hide(500);
			$("#regist_container").show(500);
		});
		//去 登录
		$("#toLogin").click(function(){
			$("#regist_container").hide(500);
			$("#login_container").show(500);
		});
	});

//发布留言信息
function insertMessage(){
// 	判断用户是否登录，用户ID放在ids上，获取ids的值，如果为空抛出异常弹出警告框
	try{
		var session = document.getElementById("ids").value;
		if(session == ""){
			throw "session为空";
		}else{
			var form = $("#messageform");
			var formdata = new FormData(form[0]);
			var gid = document.getElementById("g_id").innerHTML;
			var m = formdata.get("message");
			formdata.append("user.u_id",session);
			formdata.append("g_id",gid);
			$.ajax({
				type:"post",
				url:"insertMessage",
				data:formdata,
				async: false,  
			    cache: false,  
			    contentType: false,  
			    processData: false,
			    success:function (data){
			    	if(data == "OK"){
			    		alert("留言发布成功");
			    		window.location.reload();
			    		
			    	}else{
			    		alert("留言发布失败");
			    		window.location.reload();
			    	}
			    }
			})
		}
	}catch(err){
		alert("登录后才可以进行留言操作！")
	}
}

	// 回复客户
	function insertreplyMessage() {
		$.post("insertMessage", $("#reply_Message_Dialog").serialize(),
				function(data) {
					if (data == "OK") {
						alert("回复成功！");
						window.location.reload();
					} else {
						alert("回复失败！");
						window.location.reload();
					}
				});
	}
	
	//更新留言信息
	function updateMessage(){
		$.post("updateMessage",$("#edit_message_form").serialize(),
				function(data){
					if(data == "OK"){
						alert("更新成功！");
						window.location.reload();
					}else{
						alert("更新失败");
						window.location.reload();
					}
				});
	}
	
	//导入留言信息
	function replyMessage(id) {
		$.ajax({
			type : "post",
			url : "/findMessageById",
			data : {
				"id" : id
			},
			success : function(data) {
				$("#loginname").val(data.user.loginname);
				$("#goods").val(data.goods.g_name);
				$("#oldMessage").val(data.message);
				$("#g_id").val(data.g_id);
				$("#u_id").val(1);
				$("#m_id").val(data.m_id);
			}
		})
	}
	
//	function editMessage(id){
//		$.ajax({
//			type:"post",
//			url:"/findMessageById",
//		})
//	}

	//删除留言
	function deleteMessage(id) {
		var deletedata = confirm("确定删除留言信息？");
		if (deletedata == true) {
			$.ajax({
				type : "post",
				url : "/deleteMessage",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "OK") {
						alert("留言删除成功");
						window.location.reload();
					} else {
						alert("留言删除失败");
						window.location.reload();
					}
				}
			})
		}
	}		


function insertApply(){
//判断用户是否登录，用户ID放在ids上，获取ids的值，如果为空抛出异常弹出警告框
	try{
		var session = document.getElementById("ids").value;
		if(session == ""){
			throw "session为空";
		}else{
			var form = $("#applyform");
			var formdata = new FormData(form[0]);
			var gid = document.getElementById("g_id").innerHTML;
			var m = formdata.get("a_key");
			formdata.append("user.u_id",session);
			formdata.append("goods.g_id",gid);
			$.ajax({
				type:"post",
				url:"insertApply",
				data:formdata,
				async: false,  
			    cache: false,  
			    contentType: false,  
			    processData: false,
			    success:function (data){
			    	if(data == "OK"){
			    		alert("发起申请物品成功，请等待管理员审核信息");
			    		window.location.reload();
			    		
			    	}else{
			    		alert("发起申领物品失败");
			    		window.location.reload();
			    	}
			    }
			})
		}
	}catch(err){
		alert("登录后才可以进行留言操作！")
	}
}

//审核状态
	function checkApply() {
		$.post("checkApply", $("#edit_apply_form").serialize(), function(
				data) {
			if (data == "OK") {
				alert("审核完成！");
				window.location.reload();
			} else {
				alert("审核失败！");
				window.location.reload();
			}
		});
	}
	
	
	function updateApply() {
		$.post("updateApply", $("#edit_apply_form").serialize(), function(
				data) {
			if (data == "OK") {
				alert("审核完成！");
				window.location.reload();
			} else {
				alert("审核失败！");
				window.location.reload();
			}
		});
	}
	
	//更新申请信息
//	function updateApply(){
//		$.post("updateApply",$("#edit_apply_form").serialize(),function(data){
//			if(data == "OK"){
//				alert("申领信息修改成功");
//				window.location.reload();
//			}else{
//				alert("申领信息修改失败");
//				window.location.reload();
//			}
//		});
//	}

	

	//导入修改用户数据
	function editApply(id) {
		$.ajax({
			type : "post",
			url : "/findApplyById",
			data : {
				"id" : id
			},
			success : function(data) {
				$("#applyg_name").val(data.goods.g_name);
				$("#applyg_picture").attr("src","img/"+data.goods.g_picture);
				$("#applyg_key").val(data.goods.g_key);
				$("#a_rtime").val(data.a_rtime);
				$("#a_key").val(data.a_key);
				$("#username").val(data.user.username);
				$("#a_status").val(data.a_status);	
				$("#a_id").val(data.a_id);
			}
		})
	}
	
	function dataApply(id){
		$.ajax({
			type:"post",
			url:"findApplyById",
			data:{
				"id":id
			},
			success:function(data){
				$("#dataa_rtime").val(data.a_rtime);
				$("#dataa_key").val(data.a_key);
				$("#datausername").val(data.user.username);
				$("#dataa_status").val(data.a_status);	
			}
		})
	}

	

	//删除用户
	function deleteApply(id) {
		var deletedata = confirm("确定删除信息？");
		if (deletedata == true) {
			$.ajax({
				type : "post",
				url : "/deleteApply",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "OK") {
						alert("信息删除成功");
						window.location.reload();
					} else {
						alert("信息删除失败");
						window.location.reload();
					}
				}
			})
		}
	}
	

//创建客户
	function createUser() {
		$.post("insertUser", $("#new_user_form").serialize(),
				function(data) {
					if (data == "OK") {
						alert("用户创建成功！");
						window.location.reload();
					} else {
						alert("用户创建失败！");
						window.location.reload();
					}
				});
	}

	//修改用户
	function updateUser() {
		$.post("updateUser", $("#edit_user_form").serialize(), function(
				data) {
			if (data == "OK") {
				alert("用户修改成功！");
				window.location.reload();
			} else {
				alert("用户修改失败！");
				window.location.reload();
			}
		});
	}

	

	//导入修改用户数据
	function editUser(id) {

		$.ajax({
			type : "post",
			url : "/findUserById",
			data : {
				"id" : id
			},
			success : function(data) {
				$("#edit_loginname").val(data.loginname);
				$("#edit_username").val(data.username);
				$("#edit_password").val(data.password);
				$("#edit_email").val(data.email);
				$("#edit_phone").val(data.phone);
				$("#edit_qq").val(data.qq);
				$("#edit_sex").val(data.sex);
				$("#edit_idcard").val(data.idcard);
				$("#edit_clazz").val(data.clazz);
				$("#edit_role").val(data.role);
				$("#id").val(data.u_id);
			}
		})

	}

	

	//删除用户
	function deleteUser(id) {
		var deletedata = confirm("确定删除用户？");
		if (deletedata == true) {
			$.ajax({
				type : "post",
				url : "/deleteUser",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "OK") {
						alert("用户删除成功");
						window.location.reload();
					} else {
						alert("用户删除失败");
						window.location.reload();
					}
				}
			})
		}
	}