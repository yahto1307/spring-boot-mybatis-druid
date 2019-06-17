package com.yahto.hydra.mybatis;

import tk.mybatis.mapper.entity.Example;

/**
 * Created by yahto on 2019-06-17 23:09
 *
 * @author yahto
 */
public class CasExample extends Example {
    public CasExample(Class<?> entityClass) {
        super(entityClass);
    }

    public CasExample(Class<?> entityClass, boolean exists) {
        super(entityClass, exists);
    }

    public CasExample(Class<?> entityClass, boolean exists, boolean notNull) {
        super(entityClass, exists, notNull);
    }


}
