package com.firmannf.newsly.data.source;

import android.support.annotation.NonNull;

import com.firmannf.newsly.data.ArticleModel;
import com.firmannf.newsly.data.SourceModel;

import java.util.List;

public interface NewslyDataSource {
    interface LoadSourcesCallback {
        void onSourcesLoaded(List<SourceModel> sources);

        void onDataNotAvailable(String message);
    }

    void getSources(@NonNull LoadSourcesCallback callback);

    void saveSource(@NonNull SourceModel source);

    void deleteAllSources();

    interface LoadArticlesCallback {
        void onArticlesLoaded(List<ArticleModel> articles);

        void onDataNotAvailable(String message);
    }

    void getArticlesBySource(@NonNull LoadArticlesCallback callback, String sourceId);

    void getArticlesBySourceAndQuery(@NonNull LoadArticlesCallback callback, String sourceId, String query);

    void saveArticle(@NonNull ArticleModel article);

    void deleteAllArticlesBySource(String sourceId);
}
