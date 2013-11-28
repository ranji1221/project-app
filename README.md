<a href="https://code.csdn.net/ranji1221/project-app" target="_blank">项目首页</a>
|
<a href="http://www.ranji.org" target="_blank">个人站点</a>

## 介绍
* Project-App是企业计划利用JavaEE开发平台开发商用软件的模板平台，俗称“脚手架”。
* Project-App的特点为: 快速、稳定、易于扩展、安全。
* Project-App的SOA接口：Jersey/Restlet/SpringMVC任选其一进行设计，推荐使用Jersey，毕竟它是标准。

###核心功能
* 采用SpringMVC3+Spring3+MyBatis3作为基础的架构
* 采用Maven3管理项目
* 采用自动代码生成策略
* ......

###技术框架

####项目管理
* Maven3项目依赖及管理
* Git版本控制

####后台框架
* 持久层：MyBatis3，强大的ORM框架，便于后期SQL调优
* 业务层：Spring3.2.4，全世界范围内公认的JavaEE业务处理框架
* 表现层：SpringMVC 3，MVC设计模式的代表框架
* 安全框架：Apache Shiro，优秀的安全框架
* JavaEE规范组件：jsp2.0+servlet2.5
* JSon处理框架：FastJson/

####测试框架
* JUnit单元测试
* Travis-Ci持续集成测试: 优势明显，仅需要.travis.yml配置文件即可
* JMeter压力及性能测试

####辅助框架
* 数据源：C3p0/Druid
* 作业调度框架：Quartz

####前端框架
* JavaScript框架：jquery1.8+jquery-easyUI-1.8
* 字体图标插件：font-wesome：字体/图标插件
* 前端校验插件：Jquery Validation Engine 验证插件：配合SpringMVC的验证框架，页面的校验部分可以简化不少
* 富文本编辑器：kindEditor(暂定)
* zTree树框架
* jquery-fileUpload文件上传插件

####数据库
* 默认采用MySQL数据库，但由于采用MyBatis框架很容易可以支持Oracle/DB2/SQLServer等主流数据库

####支持的浏览器
* chrome
* firefox
* ie6/7/8/9/10
* 其他主流浏览器

####系统界面截图



