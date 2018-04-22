package com.rust.jdbc.transaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * FileName: RollBackInTransaction
 * Author:   Rust
 * Date:     2018/4/12
 * Description: 在做事物处理是，如何捕获异常后，手动回滚
 * History:
 */
public class RollBackInTransaction {

    DataSourceTransactionManager transactionManager;

    @Transactional
    public void rollBackIfNecessary() throws Exception {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setName("txnName");
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

        try {
        //    do business

        } catch (Exception ep) {
            transactionManager.rollback(transactionStatus);
            throw ep;
        }


    }
}
