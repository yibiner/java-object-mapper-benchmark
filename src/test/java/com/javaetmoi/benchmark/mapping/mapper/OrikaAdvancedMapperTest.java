package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaAdvancedMapper;

public class OrikaAdvancedMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new OrikaAdvancedMapper();
    }
}
