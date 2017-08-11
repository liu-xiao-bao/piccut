<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/imgareaselect-default.css">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/jquery.imgareaselect.js"></script>
</head>
<body>
	<h1>图片剪切</h1>

	<div>
		<form action="uploadimg" method="post" enctype="multipart/form-data">
			<input id="upload_image" type="file" name="myFile" accept="image/*" /><span class="error">${request.notExist}</span><br>
			<input type="hidden" name="x1" id="x1"/>
			<input type="hidden" name="y1" id="y1"/>
			<input type="hidden" name="width" id="width"/>
			<input type="hidden" name="height" id="height"/> 
			<img src="" id="selectbanner">
			<input type="submit" value="上传" class="btn" />
		</form>
	</div>



	<script type="text/javascript">
		$(function() {
			$("#upload_image").change(function(event) {
				var files = event.target.files;
				var URL = window.URL;
				var file;
				var imgURL;
				if (files && files.length > 0) {
					file = files[0];
					if (!/image\/\w+/.test(file.type)) {
						alert("请确保文件类型为图像类型");
						return false;
					}
					imgURL = URL.createObjectURL(file);

					$("#selectbanner").attr('src', imgURL);
				}
			});
			
			
			$('#selectbanner').imgAreaSelect({
		        handles: true,
		        onSelectEnd:function(img, selection){
		        	$("#x1").val(selection.x1);
		        	$("#y1").val(selection.y1);
		        	$("#width").val(selection.width);
		        	$("#height").val(selection.height);
		        }
		    });
			
		});
	</script>
</body>
</html>