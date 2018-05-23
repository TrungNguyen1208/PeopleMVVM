package ptit.nttrung.people_mvvm.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ptit.nttrung.people_mvvm.R;
import ptit.nttrung.people_mvvm.data.model.People;
import ptit.nttrung.people_mvvm.databinding.ActivityPeopleBinding;

public class MainActivity extends AppCompatActivity implements PeopleViewModelContract.MainView{

    private ActivityPeopleBinding mActivityPeopleBinding;
    private PeopleViewModel mPeopleViewModel;
    private PeopleViewModelContract.MainView mMainView = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        initDataBinding();
        setSupportActionBar(mActivityPeopleBinding.toolbar);
        setupListPeopleView(mActivityPeopleBinding.listPeople);
    }

    private void initDataBinding() {
        mActivityPeopleBinding = DataBindingUtil.setContentView(this, R.layout.activity_people);
        mPeopleViewModel = new PeopleViewModel(mMainView, getContext());
        mActivityPeopleBinding.setMainViewModel(mPeopleViewModel);
    }

    private void setupListPeopleView(RecyclerView listPeople) {
        PeopleAdapter adapter = new PeopleAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void loadData(List<People> peoples) {
        PeopleAdapter peopleAdapter = (PeopleAdapter) mActivityPeopleBinding.listPeople.getAdapter();
        peopleAdapter.setPeopleList(peoples);
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPeopleViewModel.destroy();
    }
}
