package house.brandstore.shoemarker.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class ShoemarkerBatchApplication

fun main(args: Array<String>) {
    runApplication<ShoemarkerBatchApplication>(*args)
}