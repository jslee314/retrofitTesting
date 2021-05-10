package com.jslee.retrofittesting.success

import android.app.Application
import androidx.lifecycle.*
import com.jslee.retrofittesting.data.local.dao.ScoreDao
import com.jslee.retrofittesting.data.local.dao.UserDao
import com.jslee.retrofittesting.data.local.entity.Score
import com.jslee.retrofittesting.data.remote.RemoteImg
import kotlinx.coroutines.launch

class SuccessViewModel(val userDataSource: UserDao,
                       val scoreDataSource: ScoreDao,
                       application: Application) : AndroidViewModel(application) {


    /**
     * @내용 : 점수 (캡슐화)
     * @작성자 : 이재선
     **/
    private val _score = MutableLiveData<Score?>()
    val score: LiveData<Score?>
        get() = _score

    val scoreString = Transformations.map(score){_score ->
        _score?.numRightQuiz.toString()

    }

    private val _properties = MutableLiveData<List<RemoteImg>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<RemoteImg>>
        get() = _properties


    /**
     * @내용 : 선택 완료 버튼 (캡슐화)
     * @작성자 : 이재선
     **/
    private val _eventClickSuccess = MutableLiveData<Boolean>()
    val eventClickSuccess:LiveData<Boolean>
        get() = _eventClickSuccess

    init {

        getScoreFromRoomDB()
//        getMarsRealEstateProperties(imgRes)
    }

    private fun getMarsRealEstateProperties(imgRes:IntArray) {



//        _properties.value.

    }


    fun onClickedSuccessBtn(){
        _eventClickSuccess.value = true

    }


    override fun onCleared() {
        super.onCleared()
    }

    /**
     *  viewModelScope 사용 함수들     */
    fun getScoreFromRoomDB(){
        viewModelScope.launch {
            _score.value = getScore()
        }
    }

    /**
     *  DB에 데이터 삽입 삭제 등과 관련된 함수들
     *  이 함수들은 suspend 함수들로
     *  코틀린을 사용해서 비동기 처리를 함*/

    private suspend fun getScore(): Score?{

        val score = scoreDataSource.selectLatestScore()
        return score
    }

}