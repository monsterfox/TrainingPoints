# 功能点-TrainingPoints

## Description
此仓库用来整理实训项目中的专题知识，包括java项目和javaWeb项目。

对于有些web-*模块，需要连接数据库，案例中都是使用的MySQL自带的测试数据库test。各模块需要用到的表，在resources中有对应的db.sql文件。在自己电脑上运行脚本即可。
另外，在测试代码时，需要检查代码中的连接数据库的账号和密码，是否跟你的电脑上的账号密码一致。


## 模块分类说明
### Java模块
1.  图形用户界面案例：java-fx



### Web模块  
1.  分页功能：web-paginator
    本模块运行需要连接数据库，需在test数据库中创建books表，建表语句在模块下的resources/db.sql中
2.  文件上传：  
    （1）web-upload-apacheplugins:使用apache的commons-fileupload组件实现文件上传  
    （2）web-upload-servlet3:使用servlet3实现文件上传
        本模块运行需要连接数据库，需在test数据库中创建source表，建表语句在模块下的resources/db.sql中   
3.  验证码：web-verificationCode   
    讲解了四种验证码的实现    
    （1）数字验证码   
    （2）英文+数字验证码   
    （3）中文验证码   
    （4）表达式验证码   
4.  MD5加密：暂无对应模块
    spring 自带的 DigestUtils 工具类可以进行 md5 加密  
    //导入包  
    import org.springframework.util.DigestUtils;
    //对密码进行 md5 加密
    String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
5.  富文本编辑器：web-rte
    实现了传图片。
    关联：
    超好用的富文本编辑器froalaEditor（方便传图片和视频等）
    https://blog.csdn.net/lianzhang861/article/details/83590084?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase

6.  第三方登录
7.  发送验证码
8.  瀑布流
9.  站内搜索
10. 忘记密码-发邮件找回密码
11. xxx 