package ptit.nttrung.people_mvvm;

import android.app.Application;
import android.content.Context;

import ptit.nttrung.people_mvvm.data.source.remote.Api;
import ptit.nttrung.people_mvvm.data.source.remote.RetrofitClient;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class PeopleApp extends Application {

    private Api mApi;
    private Scheduler mScheduler;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static PeopleApp get(Context context) {
        return (PeopleApp) context.getApplicationContext();
    }

    public static PeopleApp create(Context context) {
        return PeopleApp.get(context);
    }

    public Api getApi() {
        if (mApi == null) mApi = RetrofitClient.getApi();
        return this.mApi;

    }

    public void setApi(Api api) {
        this.mApi = api;
    }

    public Scheduler subscribleScheduler() {
        if (mScheduler == null) mScheduler = Schedulers.io();
        return mScheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        mScheduler = scheduler;
    }
}
