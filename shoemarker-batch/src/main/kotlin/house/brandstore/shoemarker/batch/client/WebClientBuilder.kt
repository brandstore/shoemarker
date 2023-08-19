package house.brandstore.shoemarker.batch.client

import house.brandstore.shoemarker.batch.config.property.HttpProperty
import house.brandstore.shoemarker.batch.util.CollectionsUtil
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

class WebClientBuilder(
    private val httpProperty: HttpProperty
) {

    private val logger = LoggerFactory.getLogger(WebClientBuilder::class.java)

    private val socketTimeout = httpProperty.socketTimeoutMs
    private val connectionTimeout = httpProperty.connectionTimeoutMs

//    private var httpClientBuilder: HttpClient = HttpClient.create()
    private val webClient = WebClient.builder()
    private var enabledDevLogging = false
    private val devProfiles = listOf("test", "local", "dev")

    private val filters = mutableListOf<ExchangeFilterFunction>()


    fun enableDevLogging(actives: Array<String>): WebClientBuilder {
        if (CollectionsUtil.contains(devProfiles, actives.toList())) {
            this.enabledDevLogging = true
        }
        return this
    }

    private fun addDevLoggingFilter() {
        filters.add(
            ExchangeFilterFunction.ofRequestProcessor { request ->
                val sb = StringBuilder("[${request.method()}] ${request.url()} =====> \n\n")
                sb.append("Header: \n")
                request
                    .headers()
                    .forEach { name, values ->
                        sb.append("$name : [ ")
                        values.forEach { value ->
                            sb.append("$value ,")
                        }
                        sb.append(" ]")
                    }
                sb.append("======>")
                logger.info(sb.toString())
                Mono.just(request)
            }
        )
        // TODO (larry.x) Request 와 Response 로그가 연속적으로 찍히도록
    }
    fun build(): WebClient {
        if (this.enabledDevLogging)
            addDevLoggingFilter()

        return webClient.baseUrl(httpProperty.url)
            .filters {
                filters.forEach { filter -> it.add(filter) }
            }
            .build()
    }
}