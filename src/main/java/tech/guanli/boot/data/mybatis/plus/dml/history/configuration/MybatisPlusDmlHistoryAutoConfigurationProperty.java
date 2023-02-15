package tech.guanli.boot.data.mybatis.plus.dml.history.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "tech.guanli.boot.dml-history")
@Data
public class MybatisPlusDmlHistoryAutoConfigurationProperty {

	private Boolean enableUpdateAudit = false;

	private Boolean enableDeleteAudit = false;

}
