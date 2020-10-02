package den.work.test.dm

import den.work.test.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


class DmApi @Inject constructor(){

    interface IPostsLoad{
        fun onPostData(data : ArrayList<Post>?)
    }

    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private var mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getApi(): IApi {
        return mRetrofit.create(IApi::class.java)
    }

    fun loadPosts(listener : IPostsLoad){
        getApi().getPosts().enqueue(object : Callback<ArrayList<Post>?> {
            override fun onResponse(call: Call<ArrayList<Post>?>, response: Response<ArrayList<Post>?>) {
                val list = response.body()
                listener.onPostData(list)
            }

            override fun onFailure(call: Call<ArrayList<Post>?>, t: Throwable) {
                listener.onPostData(null)
            }
        })
    }

}