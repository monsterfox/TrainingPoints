## 参考csdn博客地址：
https://blog.csdn.net/HeiSeHuoEr/article/details/78912996

## 注意：
（1）因为jspSmartUpload.jar不是通过maven导入的，所以使用maven的tomcat插件无法加载到该jar包，
因此需要使用自己的Tomcat服务器运行项目。
（2）在jsp-api的2.3.1版本中，jsp页面默认是忽略EL表达式的，若启用需要在page指令中添加isELIgnored="false"。

# 各种图片上传案例：
https://www.cnblogs.com/straybirds/p/9212078.html