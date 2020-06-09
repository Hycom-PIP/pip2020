package com.pip.chatbot;

import com.pip.chatbot.repository.fortune.StockRepository;
import com.pip.chatbot.repository.fortune.SymbolRepository;
import com.pip.chatbot.repository.food.FoodRepository;
import com.pip.chatbot.repository.forecast.CitiesRepository;
import com.pip.chatbot.repository.forecast.CountriesRepository;
import com.pip.chatbot.repository.forecast.ForecastRepository;
import com.pip.chatbot.repository.joke.AdminJokesRepository;
import com.pip.chatbot.repository.joke.CategoriesRepository;
import com.pip.chatbot.repository.joke.JokesRepository;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider
                (new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DSLContext dsl(DefaultConfiguration configuration) {
        return new DefaultDSLContext(configuration);
    }

    @Bean
    public ForecastRepository forecastRepository(DSLContext dsl) {
        return new ForecastRepository(dsl);
    }

    @Bean
    public CitiesRepository citiesRepository(DSLContext dsl) {
        return new CitiesRepository(dsl);
    }

    @Bean
    public FoodRepository foodRepository(DSLContext dsl) {
        return new FoodRepository(dsl);
    }

    @Bean
    public CountriesRepository countriesRepository(DSLContext dsl) {
        return new CountriesRepository(dsl);
    }

    @Bean
    public JokesRepository jokesRepository(DSLContext dsl) {
        return new JokesRepository(dsl);
    }

    @Bean
    StockRepository stockRepository(DSLContext dsl){
        return new StockRepository(dsl);
    }

    @Bean
    SymbolRepository symbolRepository(DSLContext dsl){
        return new SymbolRepository(dsl);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

    @Bean
    public CategoriesRepository categoriesRepository(DSLContext dsl, ModelMapper modelMapper) {
        return new CategoriesRepository(dsl, modelMapper);
    }

    @Bean
    public AdminJokesRepository adminJokesRepository(DSLContext dsl, ModelMapper modelMapper) {
        return new AdminJokesRepository(dsl, modelMapper);
    }

    @Bean
    public DefaultConfiguration configuration(DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider);

        jooqConfiguration
                .set(new DefaultExecuteListenerProvider(new DefaultExecuteListener()));
        jooqConfiguration.setSQLDialect(SQLDialect.POSTGRES);

        return jooqConfiguration;
    }
}
