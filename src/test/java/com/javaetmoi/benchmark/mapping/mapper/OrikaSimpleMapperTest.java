package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaSimpleMapper;

public class OrikaSimpleMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new OrikaSimpleMapper();
    }
}
