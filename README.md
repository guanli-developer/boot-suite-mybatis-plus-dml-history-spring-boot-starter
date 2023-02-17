[TOC]
# Overview
this component is designed for save the dml history, so that we can do some dml operation physically

# How to use
## enable history
The update and delete history can be enable via set the config property `tech.guanli.boot.dml-history.enable-update-audit` and `tech.guanli.boot.dml-history.enable-delete-audit` to **true**

## implement your history
You just need to implement the interface `tech.guanli.boot.data.mybatis.plus.dml.history.component.DeleteAuditor` and `tech.guanli.boot.data.mybatis.plus.dml.history.component.UpdateAuditor`, override the `void audit(String dmlSql)` method and add your history logic in it. Finally, don't forget to add your implemention to spring context.