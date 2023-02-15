package tech.guanli.boot.data.mybatis.plus.dml.history.component;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order
@Slf4j
@ConditionalOnMissingBean({ UpdateAuditor.class })
public class DefaultUpdateAuditor implements UpdateAuditor {
	@Override
	public void audit(String dmlSql) {
		log.info("update sql: {}", dmlSql);
	}
}
