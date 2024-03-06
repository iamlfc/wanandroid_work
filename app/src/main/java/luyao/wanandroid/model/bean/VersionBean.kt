package luyao.wanandroid.model.bean

/**
 * @author: xiangyu
 * @date: 2021/12/14
 * @description:
 */
data class VersionBean(
    val id: Int,
    val version: String,//系统版本号
    val innerVersion: Int,//内部版本号
    val systemType: Int,//系统类型 1 安卓 2 IOS
    val downUrl: String,//下载地址
    val privateDownUrl: String,//私服下载地址
    val isForceUpdate: Int,//是否强制更新 0 否 1 是
    val remark: String,
    val updateContext: String,//更新内容描述
    val createTime: String,
    val updateTime: String,
    val isHome: Int,//是否首页弹框提醒（0否 1是）
    val isOpen: Int,
    val isHuaWei: Int,
    val isMI: Int,
    val isOPPO: Int,
    val isVIVO: Int,
    val sex: Int
)