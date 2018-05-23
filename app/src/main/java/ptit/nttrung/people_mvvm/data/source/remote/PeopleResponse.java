package ptit.nttrung.people_mvvm.data.source.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ptit.nttrung.people_mvvm.data.model.People;


public class PeopleResponse {

    @SerializedName("results")
    private List<People> mPeopleList;

    public List<People> getPeopleList() {
        return mPeopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        mPeopleList = peopleList;
    }
}
