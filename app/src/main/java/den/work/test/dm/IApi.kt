package den.work.test.dm

import den.work.test.model.Post
import retrofit2.Call
import retrofit2.http.GET




interface IApi {
    @GET("/posts")
    fun getPosts(): Call<ArrayList<Post>?>
}