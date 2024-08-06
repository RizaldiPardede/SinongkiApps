//package api;
//
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//
//public interface ApiService {
//    @GET("mahasiswa")
//    Call<MahasiswaResponse> getMahasiswa(@Query("nrp")String nrp);
//    @POST("mahasiswa")
//    @FormUrlEncoded
//    Call<AddMahasiswaResponse> addMahasiswa(
//            @Field("nrp") String nrp,
//            @Field("nama") String nama,
//            @Field("email") String email,
//            @Field("jurusan") String jurusan
//    );
//}
