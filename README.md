# TrainingPoints

#### Description
此仓库用来整理实训项目中的专题知识。

#### 专题分类  
1.  分页功能：paginator

2.  文件上传：  
    （1）jspUpload:使用jsp实现文件上传  
    （2）servlet3Upload:使用servlet3实现文件上传  
    （3）uploadFileAndImage:使用SmartUpload插件实现文件上传  
    
3.  验证码：verificationCode   
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
    
5.  富文本编辑器：richTextEditor

    实现了传图片。

    关联：
    超好用的富文本编辑器froalaEditor（方便传图片和视频等）
    https://blog.csdn.net/lianzhang861/article/details/83590084?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase

6.  第三方登录
7.  发送验证码
8.  瀑布流
9.  站内搜索
10. 忘记密码-发邮件找回密码
11. 