package house.brandstore.shoemarker.batch.client

import house.brandstore.shoemarker.batch.dto.response.MasterOfMaltSinglePageResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

class MasterOfMaltClient(
    private val webClient: WebClient
) {
    fun getSinglePage(url: String): MasterOfMaltSinglePageResponse {
        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(MasterOfMaltSinglePageResponse::class.java)
            .block()!!
    }

    fun getListPage(url: String): MasterOfMaltSinglePageResponse = TODO()
}