package tech.guanli.boot.data.mybatis.plus.dml.history.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

@AutoConfiguration
public class MybatisPlusInterceptorConfiguration {
	@Bean(name = "mybatisPlusInterceptor")
	@Order
	@ConditionalOnMissingBean({ MybatisPlusInterceptor.class })
	public MybatisPlusInterceptor getMybatisPlusInterceptor() {
		return new MybatisPlusInterceptor();
	}
}
