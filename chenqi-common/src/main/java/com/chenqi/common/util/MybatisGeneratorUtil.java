package com.chenqi.common.util;

import com.alibaba.dubbo.rpc.filter.EchoFilter;
import org.apache.velocity.VelocityContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 代码生成类
 * Created by chenqi on 2018/05/08
 */
public class MybatisGeneratorUtil {
    //generatorConfig模板路径
    private static String generatorConfig_vm = "/template/generatorConfig.vm";
    //Service模板路径
    private static String service_vm = "/template/Service.vm";
    //ServiceMock模板路径
    private static String serviceMock_vm = "/template/ServiceMock.vm";
    //ServiceImpl模板路径
    private static String serviceImpl_vm = "/template/ServiceImpl.vm";

//    /**
//     * 根据摸吧生成generatorConfig.xml文件
//     * @param jdbcDriver 驱动路径
//     * @param jdbcurl   链接
//     * @param jdbcusername 账号
//     * @param jdbcpassword 密码
//     * @param module 项目模块
//     * @param database  数据库
//     * @param tablePrefix 表前缀
//     * @param packageName 包名
//     */
    public static void generator(
            String jdbcDriver,
            String jdbcUrl,
            String jdbcUsername,
            String jdbcPassword,
            String module,
            String database,
            String tablePrefix,
            String packageName,
            Map<String, String> lastInsertIdTables) throws Exception{
        String os = System.getProperty("os.name");   ///windows7系统执行是windows7
        String targetProject = module + "/" + module + "-dao";
        String basePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes", "").replace(targetProject, "");
        if(os.toLowerCase().startsWith("win")){
            generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
            service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
            serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath().replaceFirst("/", "");
            serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
            basePath = basePath.replaceFirst("/", "");
        } else {
            generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
            service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
            serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath();
            serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
        }

        String generatorConfigXml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "")+ "/src/main/resources/generatorConfig.xml";
        targetProject = basePath + targetProject;
        String sql = "SELECT table_name FROM INFORMATION_SCHEME.TABLES WHERE table_schema= '" + database + "' AND table_name LIKE '" + tablePrefix + "_%';";
        System.out.println("===============可是生成generatorConfig.xml文件===========");
        List<Map<String, Object>> tables = new ArrayList<>();
        try{
            VelocityContext context = new VelocityContext();
            Map<String, Object> table;

            JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, AESUtil.aesDecode(jdbcPassword));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
