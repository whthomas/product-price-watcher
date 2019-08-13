package product.price.watcher.infrastructure.domain.acl.product.info

import okhttp3.OkHttpClient

abstract class PlatformProductClient(
    private val requestURL: String,
    private val okHttpClient: OkHttpClient = OkHttpClient()
) {

    /**
     * 读取HTML文本
     */
    private fun readHtmlText(): String {

        return okhttp3
            .Request
            .Builder()
            .get()
            .url(requestURL)
            .build()
            .run {
                okHttpClient.newCall(this).execute()
            }
            .run {
                this.body?.string() ?: "<html></html>"
            }

    }

    /**
     * 读取实时的价格
     *
     * @param requestURL String
     * @return Int
     */
    fun readRealTimePrice(): Int {

        return readHtmlText()
            .run {
                getRealTimePriceFromWebPage(this)
            }

    }

    /**
     * 从页面中获取数据
     *
     * @param htmlText String
     * @return Int
     */
    abstract fun getRealTimePriceFromWebPage(htmlText: String): Int

    companion object {

        fun choosePlatform(requestURL: String): PlatformProductClient {

            return when {
                requestURL.toLowerCase().contains("jd.com") -> JDProductInfoClient(requestURL)
                requestURL.toLowerCase().contains("taobao.com") -> TaobaoProductInfoClient(requestURL)
                else -> JDProductInfoClient(requestURL)
            }

        }

    }


}