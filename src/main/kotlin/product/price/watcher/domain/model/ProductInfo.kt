package product.price.watcher.domain.model

import product.price.watcher.domain.acl.IProductInfoClient
import product.price.watcher.infrastructure.integration.DomainRegistry

class ProductInfo(
    /**
     * 商品名称
     */
    val name: String,
    /**
     * 商品类型
     */
    val produceType: ProduceType,
    /**
     * 购买链接
     */
    val buyingLink: String
) {

    /**
     * 查询实时价格
     */
    fun findRealtimePricePrice(): Int {

        return DomainRegistry
            .bean(IProductInfoClient::class.java)
            .getRealTimePrice(buyingLink)

    }

}


enum class ProduceType {

}