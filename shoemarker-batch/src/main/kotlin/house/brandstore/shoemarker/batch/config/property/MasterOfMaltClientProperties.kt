package house.brandstore.shoemarker.batch.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("webclient.batch.masterofmalt")
class MasterOfMaltClientProperties(
    override val url: String,
    override val connectionTimeoutMs: Int,
    override val socketTimeoutMs: Long,
): HttpProperties
