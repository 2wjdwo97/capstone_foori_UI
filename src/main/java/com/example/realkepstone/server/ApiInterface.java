package com.example.realkepstone.server;

import android.widget.Button;

import com.example.realkepstone.data.ButtonData;
import com.example.realkepstone.data.ChangeTagData;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.data.HomeData;
import com.example.realkepstone.data.MyReviewData;
import com.example.realkepstone.data.OrderData;
import com.example.realkepstone.data.PasswordChangeData;
import com.example.realkepstone.data.RevReqData;
import com.example.realkepstone.data.RevResData;
import com.example.realkepstone.data.ReviewSaveData;
import com.example.realkepstone.data.TodayData;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    // base_url + "api/login" 으로 POST 통신
    @POST("users/login/")
    Call<ResLoginData> requestPostLogin(@Body ReqLoginData reqLoginData );   // @Body : request 파라미터

    @Multipart
    @POST("imageupload/")
    Call<FoodAfter> postImage(@Part MultipartBody.Part image, @Part("name") RequestBody name);

    @POST("users/signup/")
    Call<JoinData> requestJoin(@Body JoinData joinData );   // @Body : request 파라미터

    @POST("users/help/id/")
    Call<FindIdData> requestId(@Body FindIdData findIdData );   // @Body : request 파라미터

    @POST("users/help/pw/")
    Call<FindpwData> requestPw(@Body FindpwData findpwData );   // @Body : request 파라미터


    @POST("users/taste/")
    Call<TagData> requestTag(@Body TagData tagData );   // @Body : request 파라미터

    @POST("reviews/eaten/get/")
    Call<List<RevResData>> requestRevReq(@Body RevReqData RevReqData );   // @Body : request 파라미터

    @POST("reviews/eaten/save/")
    Call<OrderData> requestOrder(@Body OrderData orderData );   // @Body : request 파라미터

    @POST("reviews/save/")
    Call<ReviewSaveData> requestReviewSave(@Body ReviewSaveData reviewSaveData);   // @Body : request 파라미터

    @POST("users/modify/pw/")
    Call<PasswordChangeData> requestpwchange(@Body PasswordChangeData passwordChangeData);   // @Body : request 파라미터


    @POST("reviews/get_user/")
    Call<List<MyReviewData>> requestMyReview(@Body RevReqData revReqData);   // @Body : request 파라미터


    @POST("users/modify/")
    Call<ChangeTagData> requestTagChange(@Body ChangeTagData changeTagData);   // @Body : request 파라미터


    @POST("foods/get/order/review/")
    Call<List<HomeData>> requestHome(@Body ButtonData buttonData);   // @Body : request 파라미터

    @POST("foods/get/order/star/")
    Call<List<HomeData>> requestMost(@Body ButtonData buttonData);   // @Body : request 파라미터

    @POST("users/delete/")
    Call<ReqLoginData> requestDelete(@Body ReqLoginData reqLoginData );   // @Body : request 파라미터


    @GET("foods/get/order/today/")
    Call<List<TodayData>> requestToday();   // @Body : request 파라미터



}