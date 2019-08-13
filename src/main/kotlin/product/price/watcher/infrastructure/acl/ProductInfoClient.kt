package product.price.watcher.infrastructure.acl

import org.springframework.stereotype.Component
import product.price.watcher.domain.acl.IProductInfoClient
import product.price.watcher.infrastructure.acl.product.info.PlatformProductClient

@Component
class ProductInfoClient : IProductInfoClient {

    override fun getRealTimePrice(buyLink: String): Int {

        return PlatformProductClient
            .choosePlatform(buyLink) // 选择平台
            .readRealTimePrice()     // 查询价格

    }

}