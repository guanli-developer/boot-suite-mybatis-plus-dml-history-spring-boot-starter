package tech.guanli.boot.data.mybatis.plus.dml.history.component;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DmlUpdateHistoryInnerInterceptor extends DmlHistoryInnerInterceptor {
	private List<UpdateAuditor> auditors;

	@Override
	protected void audit(String sql) {
		auditors.forEach(auditor -> {
			auditor.audit(sql);
		});
	}

	@Override
	public void beforeUpdate(Executor executor, MappedStatement mappedStatement, Object parameter) throws SQLException {
		if (Objects.equals(SqlCommandType.UPDATE, mappedStatement.getSqlCommandType())) {
			audit(resolveSql(mappedStatement, parameter));
		}
	}

}
