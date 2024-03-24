package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.apachebeanutils.ApacheBeanUtilsMapper;

public class ApacheBeanUtilsMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new ApacheBeanUtilsMapper();
    }
}
