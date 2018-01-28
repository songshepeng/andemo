package com.bwei.ssp.andemo.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/25.
 */

public class Duanzi_bean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"。。。。。。。。。。。。。。","createTime":"2018-01-25T09:20:26","imgUrls":null,"jid":1114,"praiseNum":null,"shareNum":null,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}},{"commentNum":null,"content":"你好 啊","createTime":"2018-01-25T09:17:04","imgUrls":null,"jid":1113,"praiseNum":null,"shareNum":null,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15162436520281516243653081.png","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"刘哲大晒比","createTime":"2018-01-25T08:51:33","imgUrls":null,"jid":1112,"praiseNum":null,"shareNum":null,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}},{"commentNum":null,"content":"哈哈哈哈","createTime":"2018-01-25T08:39:11","imgUrls":null,"jid":1111,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"哈喽你好，拼接下接口试试","createTime":"2018-01-25T08:36:36","imgUrls":null,"jid":1110,"praiseNum":null,"shareNum":null,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15162436520281516243653081.png","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"放假还是找工作","createTime":"2018-01-25T08:32:15","imgUrls":null,"jid":1109,"praiseNum":null,"shareNum":null,"uid":11164,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"ijuijijij\n","praiseNum":"null"}},{"commentNum":null,"content":"大发送到打发斯蒂芬是开发萨迪克福克斯的南方科技难解难分当升科技能否尽快斯诺伐克就能撒大口径放哪跨境电商你放开那看见你发","createTime":"2018-01-25T08:29:21","imgUrls":null,"jid":1108,"praiseNum":null,"shareNum":null,"uid":11164,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"ijuijijij\n","praiseNum":"null"}},{"commentNum":null,"content":"111111","createTime":"2018-01-25T08:28:26","imgUrls":null,"jid":1107,"praiseNum":null,"shareNum":null,"uid":11164,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"ijuijijij\n","praiseNum":"null"}},{"commentNum":null,"content":"哈喽你好，拼接下接口试试","createTime":"2018-01-24T21:44:33","imgUrls":null,"jid":1106,"praiseNum":null,"shareNum":null,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15162436520281516243653081.png","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"如果发布成功,我叫杨亚飞,请告诉我杨亚飞,杨亚飞...本人QQ:3137540256","createTime":"2018-01-24T21:41:51","imgUrls":null,"jid":1105,"praiseNum":null,"shareNum":null,"uid":4814,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}}]
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
         * commentNum : null
         * content : 。。。。。。。。。。。。。。
         * createTime : 2018-01-25T09:20:26
         * imgUrls : null
         * jid : 1114
         * praiseNum : null
         * shareNum : null
         * uid : 1758
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1516841991537timg.jpg
             * nickname : 熊猫
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
