package product.price.watcher.find.info


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import product.price.watcher.infrastructure.domain.repo.ProductInfoRepo


/**
 * 商品信息获取
 */
class ProductInfoFindTest {

    @Test
    fun readProductInfoFromFiles() {


        val findProductInfos = ProductInfoRepo()
            .findProductInfos()

        Assertions.assertNotNull(findProductInfos)

    }

    @ParameterizedTest(name = "获取文件信息中所有文件的内容")
    @CsvSource(
        "''"
    )
    fun readProductListFromFile(productListFile: String) {

    }


}