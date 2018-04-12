package com.example.datasource;

import com.example.common.DatabaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLFeatureNotSupportedException;

/**
 * 动态数据源
 *
 * @author guodahai
 * @version 2018/4/12 下午3:01
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private final Logger logger = LoggerFactory.getLogger(MultipleDataSource.class);

    /**
     * 设置进去的当前线程数据源进行数据源切换
     *
     * @return 数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        DatabaseType databaseType = DatabaseContextHolder.getDatabaseType();
        logger.info("当前线程数据源----------------:{}", databaseType);
        return databaseType;
    }

    @Override
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}