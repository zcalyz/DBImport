
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>upload your service</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/supersized.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/style.css">
    </head>
    <body>

        <div class="page-container">
            <h1>文件上传</h1>
            <form method="post" action="upload" enctype="multipart/form-data">
            	
            	<input id="file" type="file" name="service_file" height="100px"/>
                <button type="submit">上传</button>
            </form>
 
        </div>    
        <!-- Javascript -->
        <script src="<%=request.getContextPath() %>/assets/js/jquery-1.8.2.min.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/supersized.3.2.7.min.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/supersized-init.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/scripts.js"></script>
    </body>
</html>

