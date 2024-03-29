package product.price.watcher.domain.model

import product.price.watcher.domain.acl.IProductExtandInfoClient
import product.price.watcher.infrastructure.integration.DomainRegistry

class ProductInfo(
    /**
     * 商品名称
     */
    val name: String,
    /**
     * 商品类型
     */
    val produceType: String,
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
            .bean(IProductExtandInfoClient::class.java)
            .getRealTimePrice(buyingLink)

    }

}