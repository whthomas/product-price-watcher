package product.price.watcher.infrastructure.domain.repo

import org.springframework.stereotype.Component
import product.price.watcher.domain.model.ProduceType
import product.price.watcher.domain.model.ProductInfo
import product.price.watcher.domain.repo.IProductInfoRepo
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors.toList


@Component
class ProductInfoRepo : IProductInfoRepo {

    override fun findProductInfos(): List<ProductInfo> {

        this::class
            .java
            .classLoader
            .getResourceAsStream("static/products.txt")
            .use {
                InputStreamReader(it).use {
                    BufferedReader(it).run {
                        
                        val results = this.lines().map { t -> t.toString() }.collect(toList())
                        this.close()
                        results
                    }
                }
            }
            .run {
                return this.map { it.toProductInfo()  }
            }

    }

}

fun String.toProductInfo(): ProductInfo {

    val infos = this.split("-")
    // 根据约定
    return ProductInfo(
        name = infos[1],
        produceType = ProduceType.valueOf(infos[0]),
        buyingLink = infos[2]
    )

}