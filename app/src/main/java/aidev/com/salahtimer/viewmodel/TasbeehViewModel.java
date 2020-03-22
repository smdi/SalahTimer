package aidev.com.salahtimer.viewmodel;

import androidx.lifecycle.ViewModel;

public class TasbeehViewModel  extends ViewModel {

    private int tasbeehCount = 0;

    public  int getTasbeehCount(){
        return  tasbeehCount;
    }

    public int reset(){
        tasbeehCount = 0;
        return tasbeehCount;
    }

    public int addCount(){
        tasbeehCount += 1;
        return tasbeehCount;
    }

    public  int minus(){
        tasbeehCount -= 1;
        return tasbeehCount;
    }

}
