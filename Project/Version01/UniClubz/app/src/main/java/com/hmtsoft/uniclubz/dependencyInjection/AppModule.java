package com.hmtsoft.uniclubz.dependencyInjection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.annotation.Nullable;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

//    @Singleton
//    @Provides
//    @Nullable
//    public FirebaseUser provideFirebaseUser(FirebaseAuth auth) {
//        return auth.getCurrentUser();
//    }

}
