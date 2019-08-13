package product.price.watcher.infrastructure.domain.acl.product.info

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class JDProductInfoClient(
    requestURL: String
) : PlatformProductClient(requestURL) {

    override fun readRealTimePrice(): Int {

        val skuid = this
            .requestURL
            .substring("https://item.jd.com/".length)
            .replace(".html", "")

        return okhttp3
            .Request
            .Builder()
            .get()
            .url("http://p.3.cn/prices/mgets?skuIds=J_$skuid&type=1")
            .build()
            .run {
                okHttpClient.newCall(this).execute()
            }
            .run {
                this.body?.string() ?: "{}"
            }
            .run {
                ObjectMapper()
                    .registerKotlinModule()
                    .readTree(this)
                    .toList()
                    .first()
                    .run { this.get("p").asInt() }
            }
    }

}