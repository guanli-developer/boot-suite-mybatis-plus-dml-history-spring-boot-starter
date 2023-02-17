package tech.guanli.boot.data.mybatis.plus.dml.history.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

import lombok.AllArgsConstructor;
import tech.guanli.boot.data.mybatis.plus.dml.history.Package;
import tech.guanli.boot.data.mybatis.plus.dml.history.component.DmlDeleteHistoryInnerInterceptor;
import tech.guanli.boot.data.mybatis.plus.dml.history.component.DmlUpdateHistoryInnerInterceptor;

@AutoConfiguration
@ComponentScan(basePackageClasses = Package.class)
@AllArgsConstructor
@EnableConfigurationProperties(MybatisPlusDmlHistoryAutoConfigurationProperty.class)
public class MybatisPlusDmlHistoryAutoConfiguation implements InitializingBean {

	private DmlUpdateHistoryInnerInterceptor dmlUpdateHistoryInnerInterceptor;

	private DmlDeleteHistoryInnerInterceptor dmlDeleteHistoryInnerInterceptor;

	private MybatisPlusInterceptor mybatisPlusInterceptor;

	private MybatisPlusDmlHistoryAutoConfigurationProperty property;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (property.getEnableUpdateAudit()) {
			mybatisPlusInterceptor.addInnerInterceptor(dmlUpdateHistoryInnerInterceptor);
		}
		if (property.getEnableDeleteAudit()) {
			mybatisPlusInterceptor.addInnerInterceptor(dmlDeleteHistoryInnerInterceptor);
		}
	}
}
