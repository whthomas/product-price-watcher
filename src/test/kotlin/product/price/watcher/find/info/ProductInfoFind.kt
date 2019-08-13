package product.price.watcher.find.info

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * 商品信息获取
 */
class ProductInfoFind {

    @ParameterizedTest(name = "获取文件信息中所有文件的内容")
    @CsvSource(
        "''"
    )
    fun readProductListFromFile(productListFile: String) {

    }

}