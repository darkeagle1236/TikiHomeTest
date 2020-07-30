

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
    companion object {


        private var retrofit: Retrofit? = null

        private const val BASE_URL = "https://api.tiki.vn/"


        val client: Retrofit
            get() {

                if (retrofit == null) {

                    retrofit = Retrofit.Builder()

                        .addConverterFactory(GsonConverterFactory.create())

                        .baseUrl(BASE_URL)

                        .build()

                }

                return retrofit!!

            }

    }
}