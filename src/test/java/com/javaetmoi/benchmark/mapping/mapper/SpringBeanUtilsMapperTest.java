package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.springbeanutils.SpringBeanUtilsMapper;

public class SpringBeanUtilsMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new SpringBeanUtilsMapper();
    }
}
