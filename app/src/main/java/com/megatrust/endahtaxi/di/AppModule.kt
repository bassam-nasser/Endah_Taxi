package com.megatrust.endahtaxi.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.megatrust.endahtaxi.repo.RegisterFirbaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseStorageRepository(storage: FirebaseFirestore): RegisterFirbaseRepository {
        return RegisterFirbaseRepository(storage)
    }

    @Provides
    @Singleton
    fun provideFireStoreDataBase(@ApplicationContext appContext: Context): FirebaseFirestore {
        FirebaseApp.initializeApp(appContext) // Initialize Firebase
        return FirebaseFirestore.getInstance()
    }
}
