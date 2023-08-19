package house.brandstore.shoemarker.batch.config

import house.brandstore.shoemarker.batch.client.MasterOfMaltClient
import house.brandstore.shoemarker.batch.client.WebClientBuilder
import house.brandstore.shoemarker.batch.config.property.MasterOfMaltClientProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class WebClientConfig {

    @Bean
    fun masterOfMaltClient(
        environment: Environment,
        masterOfMaltClientProperty: MasterOfMaltClientProperty,
    ) {
        MasterOfMaltClient(
            WebClientBuilder(masterOfMaltClientProperty)
                .enableDevLogging(environment.activeProfiles)
                .build()
        )
    }
}