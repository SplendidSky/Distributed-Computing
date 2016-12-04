首先打开mysql，并以root帐号登陆
然后注意，进到/src/main/resources/persistence-mysql.properties里修改你的root帐号密码
然后执行/src/main/resources/mysql_ddl.sql文件里的所有sql命令。

然后mvn compile tomcat7:run运行即可