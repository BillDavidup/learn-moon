package com.ning.learn.moon.userinfo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * u_userinfo
 * @author 
 */
@Data
public class UUserinfo implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String username;

    private String smallname;

    /**
     * 用户头像
     */
    private String head;

    /**
     * 用户拼音
     */
    private String pinyin;

    private String password;

    private String number;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 号码归属地json
     */
    private String mobileLocal;

    /**
     * 用户微信号
     */
    private String weixin;

    private Integer s0;

    private Integer s1;

    private Integer s2;

    private Integer s3;

    private Integer s4;

    private Integer s5;

    private Integer s6;

    private Integer type;

    private Integer status;

    private Integer substatus;

    private String orther;

    /**
     * 沟通记录
     */
    private String note;

    /**
     * 最近一次沟通时间
     */
    private Integer noteTime;

    /**
     * 线索创建时间
     */
    private Integer ctime;

    /**
     * 线索修改时间
     */
    private Integer utime;

    /**
     * 线索 创建操作者ID 系统创建为0
     */
    private Long cid;

    /**
     * 线索 修改者操作ID
     */
    private Long mid;

    /**
     * 线索所在渠道ID
     */
    private String channel;

    private String come;

    private String newsource;

    private String source;

    /**
     * 所负责用户的班主任
     */
    private Long master;

    /**
     * 所负责用户的老师
     */
    private Long teacher;

    /**
     * 所负责用户的课程顾问
     */
    private Long sales;

    /**
     * 线索所在省份
     */
    private String province;

    /**
     * 线索所在城市
     */
    private String city;

    private String area;

    private String street;

    /**
     * 用户收货地址 已摒弃
     */
    private String address;

    private Integer created;

    private Integer updated;

    private Long bycreated;

    private Long byupdated;

    /**
     * 是否缴费 1：是 0：否
     */
    private Integer payment;

    /**
     * 用户状态 0：失效,1：未分配,2：待跟进,3：跟进中,4：已邀约,5：已试听,6：已缴费
     */
    private Integer flowstatus;

    /**
     * 发货单号
     */
    private String expNum;

    /**
     * 发货状态 0：待审核,1：已发货,2：已签收,3：配送失败,4：审核失败,5：已审核
     */
    private Integer expstatus;

    /**
     * 是否删除 1：是 0：否
     */
    private Integer del;

    /**
     * 记录线索二次领取试听的时间
     */
    private Integer againTime;

    /**
     * 状态标签
     */
    private String statusTags;

    private Integer lessonstatus;

    private Integer lessonexstatus;

    /**
     * 快递状态更新时间
     */
    private Integer expTime;

    /**
     * 用户最后一次上课时间
     */
    private Integer fLessonTime;

    /**
     * 用户购买课时的时间
     */
    private Integer fBuyTime;

    private Integer life;

    private Integer apk;

    private Integer pc;

    /**
     * 再分配次数
     */
    private Byte fpCount;

    /**
     * 已有设备
     */
    private String equ;

    /**
     * 上课设备
     */
    private String lessonequ;

    /**
     * 分配时间
     */
    private Integer fpTime;

    /**
     * 分配标签
     */
    private String fpTags;

    /**
     * 是否开启自动分配1-开户，0-关闭
     */
    private Byte fpAuto;

    /**
     * 分配所需省份
     */
    private String fpProvince;

    /**
     * 分配所需市级
     */
    private String fpCity;

    /**
     * 线索所被分配的城市
     */
    private String region;

    private Long buyid;

    private Integer buyregtype;

    private Integer buystatus;

    /**
     * 是否重点客户，0：否；1：是
     */
    private Byte point;

    /**
     * 是否激活；1激活；2未激活；（电话接通为激活，电话未接通为未激活）
     */
    private Byte isactive;

    /**
     * 是否有意向
     */
    private Byte havemind;

    /**
     * 镜头版本，0老版;
     */
    private String camera;

    /**
     * 线索入库时的server信息
     */
    private String serverinfo;

    /**
     * boss警告
     */
    private Byte bosswarning;

    /**
     * boss库线索创建时间
     */
    private Integer bosstime;

    /**
     * 用户的父ID，主要针对于有子账号得用户
     */
    private Long parent;

    /**
     * 是否PC线索，通过跑脚本得出2018-7-2
     */
    private Byte pcScript;

    /**
     * 是否android线索，通过跑脚本得出2018-7-2
     */
    private Byte androidScript;

    /**
     * 线索所在国家电话区号前缀
     */
    private String areacode;

    /**
     * 所负责用户的tmk
     */
    private Integer tmk;

    /**
     * TMK池,0:默认,未入TMK池;1:已入TMK池
     */
    private Integer tmkpool;

    /**
     * 线索入TMK池时间
     */
    private Integer tmkstime;

    /**
     * 线索出TMK池时间
     */
    private Integer tmkltime;

    /**
     * 是否已经上传转介绍截图 1：是，0：否
     */
    private Boolean screenshot;

    /**
     * 线索分配到cc的分配来源
1：公有池
2：tmk池
     */
    private Boolean fpCcOrg;

    /**
     * 线索回访时间
     */
    private Integer noteReturnTime;

    /**
     * tmk激活状态；0待激活，1未激活，2已激活，3无效；
     */
    private Integer actStatus;

    /**
     * TMK激活类型（子状态）
     */
    private Integer actType;

    /**
     * TMK激活池,0默认,1未激活池,2激活失败池,3无效池,4已激活池
     */
    private Integer actPool;

    /**
     * 修改CC时间(分配CC时间)
     */
    private Integer editCcTime;

    /**
     * 修改TMK时间(分配TMK时间)
     */
    private Integer editTmkTime;

    /**
     * 是否新线索,1是,0否
     */
    private Boolean isNew;

    /**
     * 是否开启自动回收规则扫描，0开启，大于0不开启，大于0为锁定到期时间，到期后置零开启自动回收规则扫描
     */
    private Integer openRec;

    /**
     * 公海池，1CC公海池，2tmk公海池
     */
    private Boolean repool;

    /**
     * 推荐人（新）
     */
    private Integer referee;

    /**
     * 教务id
     */
    private Integer refereeMaster;

    /**
     * 跟进进度，同note表
     */
    private Byte flowPlan;

    /**
     * 入公海原因
     */
    private Boolean reComm;

    /**
     * 入公海时间
     */
    private Integer reTime;

    /**
     * 0:空闲，1：呼叫中———废弃
     */
    private Boolean callstatus;

    /**
     * 呼叫结束的时间———废弃
     */
    private Integer calltime;

    /**
     * 0：未锁定
大于0 ：锁定的adminID
     */
    private Integer lockoperator;

    /**
     * 教务的分配时间
     */
    private Integer masterFptime;

    /**
     * 渠道等级
     */
    private String channelLevel;

    /**
     * 缴费用户上课情况状态，
0：默认
1：定金不开课
2：未开课
3：正常上课
4：正常待续费
5：沉默停课
6：退费结课
7：结课待续费
8：结课不续费
     */
    private Boolean buylesstatus;

    /**
     * 群二维码
     */
    private String groupqrcode;

    /**
     * 跟进总次数
     */
    private Integer flowtotal;

    /**
     * 群二维码上传时间
     */
    private Integer groupqrcodeUptime;

    /**
     * 群二维码上传人
     */
    private String groupqrcodeUpuser;

    private static final long serialVersionUID = 1L;
}