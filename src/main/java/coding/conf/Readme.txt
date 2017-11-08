启动脚本
文件结构
bin/cg.sh cg.bat
conf/template-site.xml conf-site.xml command-site.xml function-site.xml log4j.perpies
template/*.ftl
lib/oracle mysql驱动包 log4j junit freemarker
执行脚本样式
1、通过单个表生成定义好的一套模板文件
bin/cg.sh --url jdbc:mysql://192.168.4.106:3306/test \
--driver com.mysql.jdbc.Driver \
--user root \
--password 1234 \
--table t_user \
--templateType <templateType> \
--outputPath <outputPath> \
--module <moduleName>