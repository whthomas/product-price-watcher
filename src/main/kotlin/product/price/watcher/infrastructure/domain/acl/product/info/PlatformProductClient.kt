package product.price.watcher.infrastructure.domain.acl.product.info

import okhttp3.OkHttpClient

abstract class PlatformProductClient(
    protected val requestURL: String,
    protected val okHttpClient: OkHttpClient = OkHttpClient()
) {

    /**
     * 读取实时价格
     *
     * @return Int
     */
    abstract fun readRealTimePrice(): Int

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