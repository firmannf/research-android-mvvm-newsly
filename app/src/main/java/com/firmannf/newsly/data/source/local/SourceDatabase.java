package com.firmannf.newsly.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.firmannf.newsly.data.SourceModel;

@Database(entities = {SourceModel.class}, version = 1)
public abstract class SourceDatabase extends RoomDatabase {
    private static SourceDatabase INSTANCE;

    public abstract SourceDao sourceDao();

    public static SourceDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    SourceDatabase.class, "Sources.db")
                    .build();
        }
        return INSTANCE;
    }
}
