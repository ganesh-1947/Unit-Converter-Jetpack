package com.ganesh.unitconverterjetpack.di

import android.app.Application
import androidx.room.Room
import com.ganesh.unitconverterjetpack.data.ConverterDataBase
import com.ganesh.unitconverterjetpack.data.ConverterRepository
import com.ganesh.unitconverterjetpack.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application) : ConverterDataBase {
        return Room.databaseBuilder(app, ConverterDataBase::class.java, "converter_data_database").build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(dataBase: ConverterDataBase): ConverterRepository {
        return ConverterRepositoryImpl(dataBase.converterDAO)
    }
}