# 基于jspSmartUpload上传文件

## 注意：
（1）此项目需要使用自己配置的Tomcat服务器运行项目。
    因为jspSmartUpload.jar不是通过maven导入的，所以使用maven的tomcat插件无法加载到该jar包，故不能使用maven的tomcat插件运行项目。

（2）在jsp-api的2.3.1版本中，jsp页面默认是忽略EL表达式的，若启用需要在page指令中添加isELIgnored="false"。

## 参考csdn博客地址：
https://blog.csdn.net/HeiSeHuoEr/article/details/78912996

## 各种图片上传案例：
https://www.cnblogs.com/straybirds/p/9212078.html