package product.price.watcher.infrastructure.domain.acl.product.info

class TaobaoProductInfoClient(
    requestURL: String
) : PlatformProductClient(requestURL) {

    override fun getRealTimePriceFromWebPage(htmlText: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}