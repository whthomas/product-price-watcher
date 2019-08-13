package product.price.watcher.find.info

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import product.price.watcher.domain.model.ProduceType
import product.price.watcher.domain.model.ProductInfo
import product.price.watcher.infrastructure.domain.repo.ProductInfoRepo


/**
 * 读取文件列表(static/products.txt)中所有的商品地址(目前仅支持京东)，获取商品的页面之后，列出最新的价格。
 *
 * 1. 从指定文件中获取商品信息
 * 2. 从指定URL上获取商品的价格
 * 3. 将所有商品的价格信息列出
 *
 */
class ProductInfoFindTest {

    @Test
    fun `从指定文件中获取商品信息`() {

        val findProductInfos = ProductInfoRepo().findProductInfos()

        Assertions.assertNotNull(findProductInfos)

    }

    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource(
        "'电视', 'https://www.baidu.com' ",
        "'空调', 'https://www.baidu.com' "
    )
    fun `从指定URL上获取商品的价格`(name: String, link: String) {

        val findRealtimePricePrice = ProductInfo(
            name,
            ProduceType.TV,
            link
        ).findRealtimePricePrice()

        Assertions.assertEquals(findRealtimePricePrice::class.java, Int::class.java)

    }

    @Test
    fun `将所有商品的价格信息列出`() {

        ProductInfoRepo()
            .findProductInfos()
            .map {
                it.name to it.findRealtimePricePrice()
            }.run {
                Assertions.assertNotNull(this)
            }

    }


}