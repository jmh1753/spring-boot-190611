package com.bit.web;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* Databaseconfig
*/
@Configuration
@MapperScan(basePackages = "com.bit.web.mapper")
@EnableTransactionManagement
public class Databaseconfig {

   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
   final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
   sessionFactory.setDataSource(dataSource);
   PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
   sessionFactory.setMapperLocations(resolver.getResources("classpath:com/bit/web/mapper/*.xml"));
   return sessionFactory.getObject();
  }

  @Bean
  public SqlSessionTemplate sessionTemplate(SqlSessionFactory sqlSessionFactory){
      final SqlSessionTemplate sqlSessionTemplate =new SqlSessionTemplate(sqlSessionFactory);
      return sqlSessionTemplate;

  }
}