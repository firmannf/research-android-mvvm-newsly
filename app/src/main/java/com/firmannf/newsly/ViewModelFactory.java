package com.firmannf.newsly;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.firmannf.newsly.data.source.NewslyRepository;
import com.firmannf.newsly.screen.article.ArticleViewModel;
import com.firmannf.newsly.screen.article_detail.ArticleDetailViewModel;
import com.firmannf.newsly.screen.source.SourceViewModel;
import com.firmannf.newsly.util.Injection;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory INSTANCE;
    private final Application application;
    private final NewslyRepository repository;

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(application,
                            Injection.provideNewslyRepository(application.getApplicationContext()));
                }
            }
        }
        return INSTANCE;
    }

    private ViewModelFactory(Application application, NewslyRepository repository) {
        this.application = application;
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SourceViewModel.class)) {
            return (T) new SourceViewModel(application, repository);
        } else if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            return (T) new ArticleViewModel(application, repository);
        } else if (modelClass.isAssignableFrom(ArticleDetailViewModel.class)) {
            return (T) new ArticleDetailViewModel(application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
