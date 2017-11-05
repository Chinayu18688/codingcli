package coding.cli;

import coding.db.JdbcPojo;
import coding.db.JdbcUtil;
import coding.exception.ConfigException;
import coding.job.Job;
import coding.job.SHJob;

/**
 * mrs cli server
 * 用于快速创建模块增删改查功能
 * 可直接读取数据库获取表信息生成pojo类
 * 等
 *
 *
 */
public class CliServer
{
    protected final static String GALINA ="-";
    protected final static String HELP="help";
    protected final static String H="h";
    protected final static String U="u";
    protected final static String P="p";
    protected final static String URL="url";
    protected final static String DRIVER="driver";
    protected final static String USERNAME="username";
    protected final static String PASSWORD="password";

    private static JdbcPojo jdbcPojo;

    static {
        jdbcPojo = JdbcUtil.getInstance();
    }

    public CliServer() {}

    public static void main( String[] args ) throws Exception {
        System.out.println( "欢迎使用java web代码快速生成器" );
        if(args!=null && args.length>0){
            for(int i=0;i<args.length;i++){
                String arg=args[i];
                if(arg!=null && !arg.equals("")){
                    if(isCommand(arg)){
                        String value=null;
                        arg=clearGNUString(arg);
                        if (arg.equalsIgnoreCase(HELP) || arg.equalsIgnoreCase(H)) {
                            helpDocument();
                            //传入命名名称单独显示命令使用及说明
                        }else if(arg.equalsIgnoreCase(URL)){
                            if(assertParams(i,args)){
                                value=args[++i];
                                System.out.println(value);
                                jdbcPojo.setDbUrl(value);
                            }
                        }else if(arg.equalsIgnoreCase(DRIVER)){
                            if(assertParams(i,args)){
                                value=args[++i];
                                System.out.println(value);
                                jdbcPojo.setDbDriver(value);
                            }
                        }else if(arg.equalsIgnoreCase(USERNAME) || arg.equalsIgnoreCase(U)){
                            if(assertParams(i,args)){
                                value=args[++i];
                                System.out.println(value);
                                jdbcPojo.setDbUsername(value);
                            }
                        }else if(arg.equalsIgnoreCase(PASSWORD) || arg.equalsIgnoreCase(P)){
                            if(assertParams(i,args)){
                                value=args[++i];
                                System.out.println(value);
                                jdbcPojo.setDbPassword(value);
                            }
                        }
                        else{
                            System.out.println("无法解析 错误参数名："+arg);
                            throw new ConfigException("Unable to parse the error parameter name " +arg);
                        }
                    }

                }
            }
        }
        //参数中要配置架构信息
        jdbcPojo.setDbUrl("jdbc:mysql://localhost:3306/test");
        jdbcPojo.setDbDriver("com.mysql.jdbc.Driver");
        jdbcPojo.setDbUsername("root");
        jdbcPojo.setDbPassword("123456");
        Job job=new SHJob(jdbcPojo);
        job.initializationJob();

    }

    protected static void helpDocument(){
        System.out.println("-h,--help 进入帮助文档，可使用文档中提供的参数进行使用");
        System.out.println("数据库连接参数");
        System.out.println("--url <database url> 数据库连接地址");
        System.out.println("--driver <driver name> 驱动器名称");
        System.out.println("-u,--username <username> 数据库用户名");
        System.out.println("-p,--password <password> 数据库连接密码");
    }

    protected static boolean assertParams(int index,String... args) throws ConfigException {
        if(index+1 >= args.length){
            //数组下标越界 最后一个命令未设置参数
            System.out.println("命令未找到参数:"+args[index]);
            throw new ConfigException("Command not found parameters "+args[index]);
        }else{
            if(isCommand(args[index+1])){
                System.out.println("命令未找到参数:"+args[index]);
                throw new ConfigException("Command not found parameters "+args[index]);
            }else{
                return true;
            }
        }
        //return false;
    }

    protected static boolean isCommand(String arg){
        if(arg!=null && !arg.equals("")){
            if(arg.indexOf(GALINA)>-1){
                return true;
            }
        }
        return false;
    }

    protected static String clearGNUString(String arg){
        if(arg!=null && !arg.equals("")){
            return arg.replaceAll(GALINA,"");
        }
        return null;
    }



}
