package com.javaetmoi.benchmark.mapping.mapper.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public final class OrikaSimpleMapperUtils {

    private static final MapperFacade MAPPER_FACADE;
    static {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder()
                .useAutoMapping(true)
                .mapNulls(true)
                .build();
        MAPPER_FACADE = mapperFactory.getMapperFacade();
    }

    /*************************** 工具方法部分 ***************************/
    public static <S, D> void map(S src, D dest) {
        MAPPER_FACADE.map(src, dest);
    }

    public static <S, D> D map(S src, Class<D> destClazz) {
        return MAPPER_FACADE.map(src, destClazz);
    }

    public static <S, D> List<D> mapAsList(Iterable<S> src, Class<D> destClazz) {
        return MAPPER_FACADE.mapAsList(src, destClazz);
    }
}
