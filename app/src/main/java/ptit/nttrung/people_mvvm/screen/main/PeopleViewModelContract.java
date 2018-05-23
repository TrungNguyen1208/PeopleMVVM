package ptit.nttrung.people_mvvm.screen.main;

import android.content.Context;

import java.util.List;

import ptit.nttrung.people_mvvm.data.model.People;

public interface PeopleViewModelContract {

    interface MainView {
        void loadData(List<People> people);

        Context getContext();
    }

    interface ViewModel {
        void destroy();
    }
}
