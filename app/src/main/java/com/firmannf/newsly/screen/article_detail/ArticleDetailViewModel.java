package com.firmannf.newsly.screen.article_detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.firmannf.newsly.data.ArticleModel;
import com.firmannf.newsly.data.source.NewslyDataSource;
import com.firmannf.newsly.data.source.NewslyRepository;
import com.firmannf.newsly.util.SingleLiveEvent;

import java.util.List;

public class ArticleDetailViewModel extends AndroidViewModel {

    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<String> sourceId = new ObservableField<>();

    public ArticleDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void start(String url) {
        this.url.set(url);
    }
}
