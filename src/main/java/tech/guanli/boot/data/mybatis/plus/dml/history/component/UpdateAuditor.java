package tech.guanli.boot.data.mybatis.plus.dml.history.component;

public interface UpdateAuditor {

	void audit(String dmlSql);

}
