package product.price.watcher.domain.acl

/**
 * 获取产品信息
 */
interface IProductExtandInfoClient {

    /**
     * 实时价格获取
     *
     * @param buyLink String
     * @return Int
     */
    fun getRealTimePrice(buyLink: String): Int

}