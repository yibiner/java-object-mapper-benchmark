package com.javaetmoi.benchmark;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.apachebeanutils.ApacheBeanUtilsMapper;
import com.javaetmoi.benchmark.mapping.mapper.beancopier.BeanCopierMapper;
import com.javaetmoi.benchmark.mapping.mapper.bull.BullMapper;
import com.javaetmoi.benchmark.mapping.mapper.datus.DatusMapper;
import com.javaetmoi.benchmark.mapping.mapper.dozer.DozerMapper;
import com.javaetmoi.benchmark.mapping.mapper.jmapper.JMapperMapper;
import com.javaetmoi.benchmark.mapping.mapper.manual.ManualMapper;
import com.javaetmoi.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import com.javaetmoi.benchmark.mapping.mapper.modelmapper.ModelMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaAdvancedMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaSimpleMapper;
import com.javaetmoi.benchmark.mapping.mapper.remappe.ReMappeMapper;
import com.javaetmoi.benchmark.mapping.mapper.selma.SelmaMapper;
import com.javaetmoi.benchmark.mapping.mapper.springbeanutils.SpringBeanUtilsMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.OrderFactory;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;

@State(Scope.Benchmark)
public class MapperBenchmark {

    @Param({"Manual", "MapStruct", "Selma", "JMapper", "datus", "Orika", "ModelMapper", "BULL", "Dozer", "ReMap",
            "ApacheBeanUtils", "SpringBeanUtils", "OrikaSimple", "OrikaAdvanced", "BeanCopier"})
    private String type;

    private OrderMapper mapper;
    private Order order;

    @Setup(Level.Trial)
    public void setup() {
        switch (type) {
            case "Dozer":
                mapper = new DozerMapper();
                break;
            case "Orika":
                mapper = new OrikaMapper();
                break;
            case "ModelMapper":
                mapper = new ModelMapper();
                break;
            case "MapStruct":
                mapper = new MapStructMapper();
                break;
            case "Selma":
                mapper = new SelmaMapper();
                break;
            case "JMapper":
                mapper = new JMapperMapper();
                break;
            case "Manual":
                mapper = new ManualMapper();
                break;
            case "BULL":
                mapper = new BullMapper();
                break;
            case "datus":
                mapper = new DatusMapper();
                break;
            case "ReMap":
                mapper = new ReMappeMapper();
                break;
            case "ApacheBeanUtils":
                mapper = new ApacheBeanUtilsMapper();
                break;
            case "SpringBeanUtils":
                mapper = new SpringBeanUtilsMapper();
                break;
            case "OrikaSimple":
                mapper = new OrikaSimpleMapper();
                break;
            case "OrikaAdvanced":
                mapper = new OrikaAdvancedMapper();
                break;
            case "BeanCopier":
                mapper = new BeanCopierMapper();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + type);
        }
    }

    @Setup(Level.Iteration)
    public void preInit() {
        order = OrderFactory.buildOrder();
    }

    @Benchmark
    public OrderDTO mapper() {
        return mapper.map(order);
    }

    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
            .include(MapperBenchmark.class.getSimpleName())
            .warmupIterations(5)
            .measurementIterations(5)
            .jvmArgs("-server")
            .forks(1)
            .resultFormat(ResultFormatType.TEXT)
            .build();

        Collection<RunResult> results = new Runner(opts).run();
        for (RunResult result : results) {
            Result<?> r = result.getPrimaryResult();
            System.out.println("API replied benchmark score: "
                + r.getScore() + " "
                + r.getScoreUnit() + " over "
                + r.getStatistics().getN() + " iterations");
        }
    }

}
