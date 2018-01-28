package com.bwei.ssp.andemo.activity.fragment.myguanzhu;

import java.util.List;

/**
 * Created by lenovo on 2018/1/26.
 */

public class Myguabzhu_Bean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-29T15:46:56","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1514354957764cropped_1514354958473.jpg","latitude":null,"longitude":null,"mobile":"15701577147","money":0,"nickname":"乔君","password":"123456","praiseNum":null,"token":"FEBAD73B511796DE63A6FFFD8450ABD3","uid":144,"userId":null,"username":"15701577147"},{"age":null,"appkey":"4395ecef6d936cf7","appsecret":"24EF479F1E12B557EBF00BE4DCE52536","createtime":"2018-01-26T13:48:08","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","latitude":null,"longitude":null,"mobile":"13666668888","money":null,"nickname":"哈哈","password":"E76E4C064F4EF340593184DD8C778E9A","praiseNum":null,"token":"C430FE881D941971191E96707532FCDC","uid":1497,"userId":null,"username":"13666668888"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-23T17:02:54","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","latitude":null,"longitude":null,"mobile":"15810672623","money":0,"nickname":"小狼","password":"123456","praiseNum":null,"token":"28C3793F9AB8E555D523C46D8D867998","uid":150,"userId":null,"username":"15810672623"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-31T16:43:56","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","latitude":null,"longitude":null,"mobile":"13773359134","money":0,"nickname":"笑出腹肌的男人","password":"654321","praiseNum":null,"token":"B77920CD2D38574F335E2C137F821D61","uid":154,"userId":null,"username":"13773359134"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-25T14:48:05","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/86.jpg","latitude":null,"longitude":null,"mobile":"15011411273","money":0,"nickname":"GUODONG.","password":"111111","praiseNum":null,"token":"C4BF90E97420953ECE276A0D1287AFC0","uid":86,"userId":null,"username":"15011411273"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-29T15:46:56
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/1514354957764cropped_1514354958473.jpg
         * latitude : null
         * longitude : null
         * mobile : 15701577147
         * money : 0
         * nickname : 乔君
         * password : 123456
         * praiseNum : null
         * token : FEBAD73B511796DE63A6FFFD8450ABD3
         * uid : 144
         * userId : null
         * username : 15701577147
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private int gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private int money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
