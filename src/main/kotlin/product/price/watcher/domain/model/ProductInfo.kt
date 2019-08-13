package product.price.watcher.domain.model

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
        TODO()
    }

}


enum class ProduceType {

}