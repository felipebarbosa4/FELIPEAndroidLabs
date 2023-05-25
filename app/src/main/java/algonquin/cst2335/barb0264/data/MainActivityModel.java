package algonquin.cst2335.barb0264.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// correspond to what's on MainActivity
public class MainActivityModel extends ViewModel {

    public String theText = "Hello World";
    public MutableLiveData<Boolean> checkboxState = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> switchState = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> radioButtonState = new MutableLiveData<>(false);
}
