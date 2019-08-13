package product.price.watcher.domain.repo

import product.price.watcher.domain.model.ProductInfo

interface IProductInfoRepo {

    /**
     * 查询商品信息
     */
    fun findProductInfos(): List<ProductInfo>

}