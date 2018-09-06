package com.ldlywt.hello.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ProjectBean implements Serializable{


    /**
     * curPage : 1
     * datas : [{"apkLink":"","author":"xujiaji","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个简洁漂亮的WanAndroid客户端，用了些Python，用了360插件还有些乱七八糟的吧！主要结构框架：MVVM + Dagger2 + DataBinding + Lifecycle + OkHttp + Retrofit2","envelopePic":"http://wanandroid.com/blogimgs/1f69dcaa-730d-4b86-89d0-a87a241bc6bf.png","fresh":false,"id":3351,"link":"http://www.wanandroid.com/blog/show/2323","niceDate":"2018-09-02","origin":"","projectLink":"https://github.com/xujiaji/WanAndroid","publishTime":1535878684000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"WanAndroid客户端 MVVM","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"zeleven","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"干货集中营Android app（MVP + RxJava2 + Dagger2 + Retrofit）\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/e43c013b-2475-4335-8983-236aa4687d17.png","fresh":false,"id":3342,"link":"http://www.wanandroid.com/blog/show/2319","niceDate":"2018-08-31","origin":"","projectLink":"https://github.com/zeleven/scallop","publishTime":1535646376000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"干货集中营Android app（MVP + RxJava2 + Dagger2 + Retrofit）scallop ","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"caiyonglong","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":" Android 音乐播放器\r\n支持本地音乐播放，百度音乐，QQ音乐、虾米音乐、网易云音乐等网络音乐播放\r\n支持在线歌曲下载\r\n歌词播放、桌面歌词、桌面小控件\r\n通知栏控制、线控播放、音频焦点控制\r\nQQ登录、在线歌单同步\r\n百度电台列表，网易云mv排行榜，mv播放评论\r\n酷狗歌词搜索、修改歌词样式","envelopePic":"http://www.wanandroid.com/blogimgs/d2aefebf-6d73-41ed-9228-a4bfc771133e.png","fresh":false,"id":3332,"link":"http://www.wanandroid.com/blog/show/2315","niceDate":"2018-08-28","origin":"","projectLink":"https://github.com/caiyonglong/MusicLake","publishTime":1535469466000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"一款开源在线音乐播放器 MusicLake","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"ywp0919","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"这是一个Flutter项目，基于Wan Android提供的api来完成的，非常感谢鸿阳大神，自己经常在这个网站上学习，做这个Flutter项目的话也可以装在自己手机上用来看一些技术文章。\r\n       已有功能：用户登录注册、首页文章列表、首页Banner、知识体系、知识体系下的文章、收藏文章管理。\r\n       待完成功能：在首页加入热门模块(包括热门搜索和热门网站)、加入搜索文章的功能。\r\n       \r\n","envelopePic":"http://wanandroid.com/blogimgs/ca28967d-a7cb-48ed-80ef-c63b544f2116.png","fresh":false,"id":3301,"link":"http://www.wanandroid.com/blog/show/2306","niceDate":"2018-08-22","origin":"","projectLink":"https://github.com/ywp0919/wan_android_flutter","publishTime":1534915840000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"玩Android Flutter 版本","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Hankkin","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"如果你是一个热衷于Android开发者，那么这款软件能帮助你阅读精品Android文章。同时Reading中还包含&quot;英文单词&quot;、&quot;账号本子&quot;、&quot;天气&quot;、&quot;查单词&quot;、&quot;快递查询&quot;等小工具。项目基于&quot;Kotlin+MVP&quot;架构开发，风格大概也许属于Material Desgin原质化风格，包含主题颜色切换、百变Logo等功能。","envelopePic":"http://wanandroid.com/blogimgs/8c1d1aba-c0c4-4392-9247-8cef299d0146.png","fresh":false,"id":3300,"link":"http://www.wanandroid.com/blog/show/2305","niceDate":"2018-08-22","origin":"","projectLink":"https://github.com/Hankkin/Reading","publishTime":1534904096000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"Reading一款不错的基于WanAndroid OpenApi 开发的开源APP-Kotlin版本","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"crazysunj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"[开源项目] 一款程序员日常放松的App，基于Material Design + MVP-Clean + Weex + RxJava2 + Retrofit + Dagger2 + Glide + Okhttp + MTRVA + BRVAH + 炫酷控件 + 炫酷动画\r\n","envelopePic":"http://wanandroid.com/blogimgs/e3c873e3-883e-4bdb-b982-d48094c1f72e.png","fresh":false,"id":3296,"link":"http://www.wanandroid.com/blog/show/2302","niceDate":"2018-08-21","origin":"","projectLink":"https://github.com/crazysunj/CrazyDaily","publishTime":1534853393000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"一款程序员日常放松的App CrazyDaily","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wzmyyj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一款采用MVP的仿《知音漫客》漫画APP。本程序仅供学习参考使用，严禁任何商业用途。欢迎各位进行技术讨论和交流。","envelopePic":"http://wanandroid.com/blogimgs/9545fefc-ed11-4659-96ac-3caa797d0f32.png","fresh":false,"id":3294,"link":"http://www.wanandroid.com/blog/show/2301","niceDate":"2018-08-21","origin":"","projectLink":"https://github.com/wzmyyj/ZYMK","publishTime":1534852366000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"一款采用MVP的仿《知音漫客》漫画APP。","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wjwang0914","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"由于之前自己就想开发一个TODO小应用，刚好看到了鸿神的玩android开放了TODO的API，就抽时间开发了一个TODO的小应用，非常感谢玩Android提供API","envelopePic":"http://www.wanandroid.com/blogimgs/02a131fe-0d71-4a8a-8e53-ac0e9cf652dd.png","fresh":false,"id":3262,"link":"http://www.wanandroid.com/blog/show/2292","niceDate":"2018-08-18","origin":"","projectLink":"https://github.com/wjwang0914/wj-todo-wanandroid/","publishTime":1534570492000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"玩 android 之 开源TODO项目  wj-todo-wanandroid","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xfhy","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"待办事项APP,纯kotlin开发,接口是鸿洋大大提供的,[地址](http://www.wanandroid.com/blog/show/2),并且我还加入了番茄时间,高效利用好时间.\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/d7ca2faf-ccd9-4e7c-bef1-aacdb8ce1969.png","fresh":false,"id":3278,"link":"http://www.wanandroid.com/blog/show/2299","niceDate":"2018-08-18","origin":"","projectLink":"https://github.com/xfhy/TODO-list","publishTime":1534570407000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"TODO清单 纯Kotlin开发,兼容Android P","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"hyzhan43","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"初学kotlin，所以做这个 豆瓣 app 来练练手，感受了 kotlin 的魅力~\r\nApp 数据采用 豆瓣 api  （如果不小心侵权了,sorry,联系我,我把它删除了,谢谢.）\r\n由于提供 api 数据有限，暂时只实现 电影，和 图书功能。","envelopePic":"http://www.wanandroid.com/blogimgs/43130d65-f8b3-4c65-a6f8-8b0fe675432f.png","fresh":false,"id":3277,"link":"http://www.wanandroid.com/blog/show/2298","niceDate":"2018-08-18","origin":"","projectLink":"https://github.com/hyzhan43/DouBanMovie","publishTime":1534570311000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"kotlin 开发一款 豆瓣 App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"smuyyh","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"&quot;任阅&quot; 网络小说阅读器，追书推荐收藏、书籍/标签检索、模拟翻书的翻页效果、缓存书籍、日夜间模式、书签、txt/pdf/epub书籍阅读、Wifi传书~\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/90eead13-f8ca-4e3d-8826-0dc94311ba16.png","fresh":false,"id":3276,"link":"http://www.wanandroid.com/blog/show/2297","niceDate":"2018-08-18","origin":"","projectLink":"https://github.com/smuyyh/BookReader","publishTime":1534568314000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"&quot;任阅&quot; 网络小说阅读器 BookReader","type":0,"userId":-1,"visible":0,"zan":0},{"apkLink":"","author":"WANZIzZ","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个简单的Kotlin版本Todo客户端，数据来源wanandroid（第一次分享没有写READMEo(╥﹏╥)o）","envelopePic":"http://www.wanandroid.com/blogimgs/97286574-9476-46b0-82d9-b1aa3a82ac4a.png","fresh":false,"id":3273,"link":"http://www.wanandroid.com/blog/show/2295","niceDate":"2018-08-16","origin":"","projectLink":"https://github.com/WANZIzZ/Todo","publishTime":1534412239000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"Todo客户端-Kotlin","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mtjsoft","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"基于鸿洋大神的玩android开放API&ldquo;http://www.wanandroid.com/blog/show/2&rdquo;完成的《玩android微信小程序版》，一起来学习小程序开发吧。","envelopePic":"http://www.wanandroid.com/blogimgs/81659f72-9b18-4bc2-8e88-695c4a59c730.png","fresh":false,"id":3251,"link":"http://www.wanandroid.com/blog/show/2284","niceDate":"2018-08-13","origin":"","projectLink":"https://github.com/mtjsoft/wanandroid","publishTime":1534160726000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"玩android微信小程序版 wanandroid","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"pengMaster","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"服务器：阿里云服务\r\n域名：pengmaster.com\r\n数据库：在服务器上装的mysql\r\n后台地址：https://github.com/pengMaster/marry_server\r\n项目中引用的网络资源若有侵权，请通知及时删除。该小程序为个人开发，一切解释权归作者所有，图片禁止传播。\r\n功能简介：\r\n新郎新娘图片展示\r\n婚礼现场导航\r\n点赞祝福，分享好友\r\n身份切换，制作属于自己的请柬","envelopePic":"http://www.wanandroid.com/blogimgs/efd0265a-d132-427e-a9da-39ce3650e74c.png","fresh":false,"id":3261,"link":"http://www.wanandroid.com/blog/show/2291","niceDate":"2018-08-13","origin":"","projectLink":"https://github.com/pengMaster/marry","publishTime":1534159682000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"婚礼邀请函 - 小程序+后台 marry","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaweizi","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"小程序 的火热程度我就不多说了，我之前对这个就蛮有兴趣的，于是花了大概5天的时间，完成了 学习-入门-写项目 这一套流程。","envelopePic":"http://www.wanandroid.com/blogimgs/b2f3ade5-fe52-4a73-a6b6-1f819c18a332.png","fresh":false,"id":3016,"link":"http://www.wanandroid.com/blog/show/2156","niceDate":"2018-08-12","origin":"","projectLink":"https://github.com/xiaweizi/QNews_we_chat","publishTime":1534067082000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"开源小程序 - 趣闻 QNews_we_chat","type":0,"userId":-1,"visible":0,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 5
     * size : 15
     * total : 69
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * apkLink :
         * author : xujiaji
         * chapterId : 294
         * chapterName : 完整项目
         * collect : false
         * courseId : 13
         * desc : 一个简洁漂亮的WanAndroid客户端，用了些Python，用了360插件还有些乱七八糟的吧！主要结构框架：MVVM + Dagger2 + DataBinding + Lifecycle + OkHttp + Retrofit2
         * envelopePic : http://wanandroid.com/blogimgs/1f69dcaa-730d-4b86-89d0-a87a241bc6bf.png
         * fresh : false
         * id : 3351
         * link : http://www.wanandroid.com/blog/show/2323
         * niceDate : 2018-09-02
         * origin :
         * projectLink : https://github.com/xujiaji/WanAndroid
         * publishTime : 1535878684000
         * superChapterId : 294
         * superChapterName : 开源项目主Tab
         * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
         * title : WanAndroid客户端 MVVM
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        private long publishTime;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<TagsBean> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * name : 项目
             * url : /project/list/1?cid=294
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
