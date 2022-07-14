package com.hegunhee.subwayarrivalinfoapp.domain

import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.Util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.awaitResponse
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class InsertSubwayInfoListUseCase @Inject constructor(
    private val repository: Repository
) : UseCase {
    suspend operator fun invoke(){
        repository.getAllSubwayList().awaitResponse().body()?.let {
            it.searchInfoBySubwayNameService.let {  service->
                if(service.result.code == "INFO-000"){
                    service.row.filter { it.line_num.substring(1) in subway_line_limit }.groupBy { it.station_nm }.map { subway ->
                        SubwayInfoEntity(subway.key,subway.value.map{it.line_num.substring(1)})
                    }.let {
                        repository.insertSubwayInfoList(it)
                    }
                }
            }
        }
    }
}