import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis-plus 自动生成 需要和 一起使用 效果最佳
 *
 * @author 刘斌
 */
public class Main {
    public static void main(String[] args) {
        //用来获取mybatis-plus.properties文件的配置信息
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C:\\logs\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(false);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("刘斌");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/jpa_demo?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        dsc.setUsername("jpa_demo");
        dsc.setPassword("jpa_demo");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成的表名
        strategy.setInclude("user");
        strategy.setEntityColumnConstant(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityClass("com.caomu.bootstrap.domain.BaseEntity");
        strategy.setSuperServiceClass("com.caomu.bootstrap.service.BaseService");
        strategy.setSuperServiceImplClass("com.caomu.bootstrap.service.BaseServiceImpl");
        strategy.setSuperEntityColumns("id", "creator_id", "deleted", "create_time", "updater_id", "update_time");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.caomu.demo");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);


        // 执行生成
        mpg.execute();
    }
}
