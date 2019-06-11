package tagservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tagservice.repository.ITagDao;
import tagservice.repository.ITagJpaImpl;
import tagservice.repository.TagCache;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GameFrameTagService extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GameFrameTagService.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(GameFrameTagService.class, args);
    }

    @Bean
    public ITagDao tagDao(ITagJpaImpl tagJpa){

        TagCache cache = new TagCache();
        cache.init(tagJpa);

        return cache;

    }
}
