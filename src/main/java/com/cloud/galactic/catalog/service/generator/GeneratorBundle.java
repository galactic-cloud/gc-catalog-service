package com.cloud.galactic.catalog.service.generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class GeneratorBundle implements IdentifierGenerator {
    private String prefix = "B";
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        String query="select b.id from Bundle b";
        Stream<String> ids = sharedSessionContractImplementor.createQuery(query, String.class).stream();

        Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);

        return prefix + (String.format("%04d", max + 1));

    }
}
