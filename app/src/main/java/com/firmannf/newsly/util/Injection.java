package com.firmannf.newsly.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.firmannf.newsly.data.source.NewslyRepository;
import com.firmannf.newsly.data.source.local.ArticleDatabase;
import com.firmannf.newsly.data.source.local.NewslyLocalDataSource;
import com.firmannf.newsly.data.source.local.SourceDatabase;
import com.firmannf.newsly.data.source.remote.NewslyRemoteDataSource;

public class Injection {
    public static NewslyRepository provideNewslyRepository(@NonNull Context context) {
        SourceDatabase sourceDatabase = SourceDatabase.getInstance(context);
        ArticleDatabase articleDatabase = ArticleDatabase.getInstance(context);
        return NewslyRepository.getInstance(NewslyRemoteDataSource.getInstance(),
                NewslyLocalDataSource.getInstance(new AppExecutors(), sourceDatabase.sourceDao(), articleDatabase.articleDao()));
    }
}
