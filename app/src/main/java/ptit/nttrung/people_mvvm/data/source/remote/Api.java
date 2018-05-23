package ptit.nttrung.people_mvvm.data.source.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET("/")
    Observable<PeopleResponse> fetchPeople(@Query("results") int numberResult, @Query("nat") String position);
}
