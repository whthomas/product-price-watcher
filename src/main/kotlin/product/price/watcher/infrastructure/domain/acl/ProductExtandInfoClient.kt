package product.price.watcher.infrastructure.domain.acl

import org.springframework.stereotype.Component
import product.price.watcher.domain.acl.IProductExtandInfoClient
import product.price.watcher.infrastructure.domain.acl.product.info.PlatformProductClient

@Component
class ProductExtandInfoClient : IProductExtandInfoClient {

    override fun getRealTimePrice(buyLink: String): Int {

        return PlatformProductClient
            .choosePlatform(buyLink) // 选择平台
            .readRealTimePrice()     // 查询价格

    }

}