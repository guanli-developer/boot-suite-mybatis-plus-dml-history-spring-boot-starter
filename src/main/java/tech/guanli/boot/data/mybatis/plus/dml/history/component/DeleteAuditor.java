package tech.guanli.boot.data.mybatis.plus.dml.history.component;

public interface DeleteAuditor {

	void audit(String dmlSql);

}
