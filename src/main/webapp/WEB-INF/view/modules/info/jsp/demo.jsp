<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>KindEditor JSP</title>

<link rel="stylesheet" href="/static/kind/themes/default/default.css" />
<link rel="stylesheet" href="/static/kind/plugins/code/prettify.css" />

<script charset="utf-8" src="/static/kind/kindeditor-all-min.js"></script>
<script charset="utf-8" src="/static/kind/lang/zh-CN.js"></script>
<script charset="utf-8" src="/static/kind/plugins/code/prettify.js"></script>
<script>

	var create1;
		KindEditor.ready(function(K) {
			create1 =	K.create('#xxh',{
            	width:'700px',
            	height:'500px',
            	items:['emoticons','preview','undo','redo','cut','copy','paste','selectall','justifyleft','justifycenter','justifyright',
            	       'insertorderedlist','insertunorderedlist','indent','subscript','formatblock','fontname','/','fontsize','forecolor','hilitecolor','bold','underline','strikethrough','image','flash','media','hr','/',
            	       'link','unlink','fullscreen','about','code','map','baidumap','clearhtml','pagebreak','quickformat','insertfile','template','anchor'],
            	noDisableItems:['source', 'fullscreen'],
            	resizeType:0,
            	langType:'zh-CN',
            	fullscreenMode:false,
            	urlType:'',
            	useContextmenu:true,
            	colorTable:[
            	            ['#00008B','#008B8B','#FF7F50','#6495ED','#FFF8DC','#DC143C','#00FFFF'],
            	            ['#BDB76B','#8B008B','#556B2F','#9932CC','#FF8C00','#9400D3','#00BFFF'],
            	            ['red','green','blue']
            	            ],
           	
           	allowPreviewEmoticons:true,
           	allowFileManager:true,
           	fontSizeTable:['10px','20px','24px','30px','36px'],
            fullscreenShortcut:true,
            uploadJson : '../upload.do',
            fileManagerJson : '../manger.do',
           	            
           	            
           	          
            	            
            });
		
			editor.plugin.imageDialog({
				showRemote : false
			});
	
       	
    });
function tijiao(){
	
	var html = create1.html();
	        alert(html);
	        }
	</script>
</head>
<body>

	<form name="example" action="Announcement/kindadd.do" enctype=multipart/form-data">
		<!-- <input type="text" name="title" id="title"/>
		<input type="text" name="image" id="image"/> -->
		<textarea name="content1" id="xxh" cols="100" rows="8"visibility:hidden;"></textarea>
		<br /> <input type="submit" name="button" value="提交内容" />
		<button type="button" onclick="tijiao()">123</button>
	</form>
</body>
</html>
