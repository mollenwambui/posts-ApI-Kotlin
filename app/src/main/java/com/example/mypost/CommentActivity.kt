package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mypost.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()

    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID") ?:0
    }
    fun fetchPostById(){
        var apiClient=APIClient.buildApiClient((APIInterface::class.java))
        var request=apiClient.getPostById(postId)
        request.enqueue(object:Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
              if (response.isSuccessful){
                  var post=response.body()
                  binding.tvPostTitle.text=post?.title
                  binding.tvPostBody.text=post?.body
              }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}