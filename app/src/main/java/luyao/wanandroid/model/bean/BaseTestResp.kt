package luyao.wanandroid.model.bean

/**
 * json返回的基本类型
 */
class BaseResp<T> {
    var code: Int = -1
    var msg: String = ""
    val status: Int = -1
    var result: T? = null
        private set
    var dataState: DataState = DataState.STATE_DEFAULT
    var error: Throwable? = null
    val isSuccess: Boolean
        get() = code == 200
}

//code 30000 现金余额不足
//code 30001 乡豆余额不足

enum class DataState {
    STATE_DEFAULT,//默认
    STATE_CREATE,//创建
    STATE_LOADING,//加载中
    STATE_SUCCESS,//成功
    STATE_COMPLETED,//完成
    STATE_EMPTY,//数据为null
    STATE_FAILED,//接口请求成功但是服务器返回error
    STATE_ERROR,//请求失败
    STATE_NO_BEAN,//没有乡豆
    STATE_NO_MONEY,//没有现金
    STATE_GET_VERSION,//获取新版本
    STATE_USER_ERROR,//用户异常
    STATE_UNKNOWN//未知
}