package org.v5k.config;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.v5k.service.cache.CountryCacheLoader;
import org.v5k.service.cache.CountryCacheWriter;

import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class CacheConfig implements JCacheManagerCustomizer {

    public static final String COUNTRY = "country";

    @Override
    public void customize(javax.cache.CacheManager cacheManager) {
        cacheManager.createCache(COUNTRY, new MutableConfiguration<String, String>()
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 5)))
                .setCacheWriterFactory(FactoryBuilder.factoryOf(CountryCacheWriter.class))
                .setWriteThrough(true)
                .setCacheLoaderFactory(FactoryBuilder.factoryOf(CountryCacheLoader.class))
                .setReadThrough(true)
                .setManagementEnabled(true)
                .setStatisticsEnabled(true));
    }
}