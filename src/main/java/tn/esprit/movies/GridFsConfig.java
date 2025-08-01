package tn.esprit.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class GridFsConfig {
    @Bean
    public GridFsTemplate gridFsTemplate(MongoDatabaseFactory dbFactory, MappingMongoConverter converter) {
        return new GridFsTemplate(dbFactory, converter);
    }
}
