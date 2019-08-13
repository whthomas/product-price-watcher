package product.price.watcher.app

import org.springframework.stereotype.Service
import product.price.watcher.domain.repo.IProductInfoRepo

/**
 * 商品应用服务
 */
@Service
class ProductAppService(
    var productInfoRepo: IProductInfoRepo
) {

    fun readInfo() {

        productInfoRepo
            .findProductInfos()
            .map {
                it.findRealtimePricePrice()
            }

    }

}