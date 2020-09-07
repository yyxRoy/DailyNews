package com.example.dailynews.json;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.dailynews.Converter.EntitiesBeanConverter;
import com.example.dailynews.Converter.GeoInfoBeanConverter;
import com.example.dailynews.Converter.RelatedEventsBeanConverter;
import com.example.dailynews.Converter.StringConverter;

import java.util.List;

public class MyNewsBean {


    /**
     * data : [{"_id":"5ec7ce549fced0a24bf4199f","aminer_id":"5448a76fdabfae87b7e5ac64","category":"","content":"","date":"Thu, 21 May 2020 16:00:00 GMT","entities":[{"label":"传染病学","url":"http://xlore.org/instance/bdi1016445"},{"label":"疫苗","url":"https://covid-19.aminer.cn/kg/class/the_vaccine"},{"label":"传染病","url":"https://covid-19.aminer.cn/kg/class/infectious_diseases"},{"label":"rna","url":"https://covid-19.aminer.cn/kg/resource/R327"},{"label":"新冠","url":"https://covid-19.aminer.cn/kg/resource/R25833"}],"expert":"Anthony S. Fauci","geoInfo":[{"geoName":"United States","latitude":"39.76","longitude":"-98.5","originText":"美国"}],"id":"d77e1e3bd9673716ad89ab9acaea24b0","influence":0.04700685372142846,"lang":"zh","related_events":[{"id":"5e8d92fa7ac1f2cf57f7b8a9","score":0.8755134635082309},{"id":"5eb2a4b29fced0a24b67c08c","score":0.8677345207478392},{"id":"5e96f2d49fced0a24b0ca64e","score":0.8619145435830788},{"id":"5e8d92fa7ac1f2cf57f7b479","score":0.856212338769918},{"id":"5e8d92fa7ac1f2cf57f7b47f","score":0.8525165110147629},{"id":"5ee3250e9fced0a24b514d3a","score":0.8439238074015085},{"id":"5ebbe3e89fced0a24b65f355","score":0.841333425667613},{"id":"5ea99ee09fced0a24ba6a4d0","score":0.8407931908326209},{"id":"5ee1e1549fced0a24bbb68e8","score":0.8369456098063135},{"id":"5efd61b89fced0a24b417fd6","score":0.836939813049519}],"seg_text":"美国 传染 染病 传染病 学 专家 安东 安东尼 · 福奇 博士 表示 ， 对 moderna 公司 研发 新冠 疫苗 保持 \u201c 谨慎 乐观 \u201d 态度 。 研究 仍处 早期 阶段 。","tflag":1590152788429,"time":"2020/05/22","title":"美国传染病学专家安东尼·福奇博士表示，对Moderna公司研发新冠疫苗保持\u201c谨慎乐观\u201d态度。研究仍处早期阶段。","type":"points","urls":["https://www.thepaper.cn/newsDetail_forward_7510604"]},{"_id":"5ec690a59fced0a24bf00551","aminer_id":"542adbe4dabfaec7081e4bc6","category":"","content":"","date":"Wed, 20 May 2020 16:00:00 GMT","entities":[{"label":"中国工程院院士","url":"http://xlore.org/instance/bdi653185"},{"label":"张伯礼","url":"http://xlore.org/instance/bdi3263341"}],"expert":"张伯礼","geoInfo":[],"id":"89f359b25edf1df9e0f6a59cd5858b38","influence":0.4417844974134587,"lang":"zh","related_events":[{"id":"5ee1afaa9fced0a24b8d96fa","score":0.8966880639518713},{"id":"5ee0304d9fced0a24b0b5788","score":0.8894923370192723},{"id":"5e959cc89fced0a24b61f995","score":0.8799830475717016},{"id":"5f1b8b3a9fced0a24b0c1c5a","score":0.8754595192222386},{"id":"5ea5884f9fced0a24b6281ce","score":0.8752960323725139},{"id":"5efb30f49fced0a24bb4c356","score":0.8712557260769894},{"id":"5e8d92fa7ac1f2cf57f7af91","score":0.870796272269521},{"id":"5f091e779fced0a24b4a09fa","score":0.8646072667648103},{"id":"5e8d92fa7ac1f2cf57f7a9a0","score":0.8637200615427583},{"id":"5f141e589fced0a24b9c9a72","score":0.8617320900850748}],"seg_text":"中国 工程 工程院 中国工程院 院士 张伯礼 建议 ， 有关 新冠 疫苗 研发 、 评价 、 检测 、 审批 各 相关 部门 应 按照 公共 卫生 公共卫生 重大 安全 事件 安全事件 反应 响应 机制 ， 全力 全力以赴 、 特事 特办 ， 在 遵循 评审 程序 和 保证 疫苗 质量 的 前提 下 ， 加快 进度 加快进度 ； 尽快 启动 iii 期 临床 试验 临床试验 ， 优化 试验 方案 ， 争取 做到 试验 研究 与 疫情 防控 有序 结合 。","tflag":1590071461574,"time":"2020/05/21","title":"中国工程院院士张伯礼建议，有关新冠疫苗研发、评价、检测、审批各相关部门应按照公共卫生重大安全事件反应响应机制，全力以赴、特事特办，在遵循评审程序和保证疫苗质量的前提下，加快进度；尽快启动III期临床试验，优化试验方案，争取做到试验研究与疫情防控有序结合。","type":"points","urls":["http://news.sciencenet.cn/htmlnews/2020/5/440108.shtm"]},{"_id":"5ec528e59fced0a24ba9d1cc","aminer_id":"53f35f4fdabfae4b3497efec","category":"","content":"","date":"Tue, 19 May 2020 16:00:00 GMT","entities":[{"label":"易聚","url":"http://xlore.org/instance/bdi4014044"},{"label":"常态化","url":"http://xlore.org/instance/bdi3082817"},{"label":"中国","url":"https://covid-19.aminer.cn/kg/resource/R25208"},{"label":"防控措施","url":"https://covid-19.aminer.cn/kg/class/measure"},{"label":"疫情","url":"https://covid-19.aminer.cn/kg/class/epidemic_situation"},{"label":"人群","url":"https://covid-19.aminer.cn/kg/class/crowds"},{"label":"公共场所","url":"https://covid-19.aminer.cn/kg/class/public_place"}],"expert":"冯召录","geoInfo":[{"geoName":"People\u2019s Republic of China","latitude":"35","longitude":"105","originText":"中国"}],"id":"f4dc0c189696130ab53758e97702d8c9","influence":0.26692750080230454,"lang":"zh","related_events":[{"id":"5e8d92fa7ac1f2cf57f7b3be","score":0.8766313243701164},{"id":"5efaf04a9fced0a24b3b2889","score":0.8706153371659239},{"id":"5ef3e56f9fced0a24b1bfadf","score":0.852711384988885},{"id":"5e8d92fa7ac1f2cf57f7b36f","score":0.8409862519254948},{"id":"5ef81f529fced0a24bf5f10b","score":0.8404171435399194},{"id":"5e8d92fa7ac1f2cf57f7bac3","score":0.8380243123513978},{"id":"5ef4060e9fced0a24b23f3cd","score":0.8371759715233003},{"id":"5ebbe3e89fced0a24b65f35d","score":0.8371095889539218},{"id":"5ee9dbe39fced0a24b00f91b","score":0.8358869778004532},{"id":"5ee9998a9fced0a24be5709b","score":0.8349696400769695}],"seg_text":"中国 中心 疾控中心 研究 研究员 冯录 召 表示 各地 疫情 防控 进入 常态 化 ， 诸如 影院 、 健身 场馆 等 一些 人员 易 聚集 的 公共 场所 公共场所 应 做好 防控 措施 。 同时 对 重点 人群 实施 应检尽检 ， 对 其他 人群 做到 愿检尽检 。","tflag":1589979365668,"time":"2020/05/20","title":"中国疾控中心研究员冯录召表示各地疫情防控进入常态化，诸如影院、健身场馆等一些人员易聚集的公共场所应做好防控措施。同时对重点人群实施应检尽检，对其他人群做到愿检尽检。","type":"points","urls":["https://www.thepaper.cn/newsDetail_forward_7477738"]},{"_id":"5ec3b5729fced0a24bfbc482","aminer_id":"543000fedabfaea2f5549374","category":"","content":"","date":"Mon, 18 May 2020 16:00:00 GMT","entities":[{"label":"科学问题","url":"http://xlore.org/instance/bdi5891321"},{"label":"传播途径","url":"http://xlore.org/instance/bdi1016286"},{"label":"系统回顾","url":"http://xlore.org/instance/bdi6051793"},{"label":"中间宿主","url":"http://xlore.org/instance/bdi731205"},{"label":"北京化工大学生命科学与技术学院","url":"http://xlore.org/instance/bdi1569716"},{"label":"疫情","url":"https://covid-19.aminer.cn/kg/class/epidemic_situation"},{"label":"流行","url":"https://covid-19.aminer.cn/kg/class/popular"},{"label":"宿主","url":"https://covid-19.aminer.cn/kg/class/host"},{"label":"病毒","url":"https://covid-19.aminer.cn/kg/class/virus"}],"expert":"童贻刚","geoInfo":[],"id":"12acc64c3865c1dd2e78dd1c7b83b70b","influence":0.44155299811411264,"lang":"zh","related_events":[{"id":"5ee0283a9fced0a24b09220a","score":0.8864525287317894},{"id":"5edc73da9fced0a24b0309b5","score":0.8839030564130963},{"id":"5e8d92fa7ac1f2cf57f7b151","score":0.8772763548079523},{"id":"5ed508169fced0a24b1614a7","score":0.8709293895935504},{"id":"5f07ecd99fced0a24be79357","score":0.869649966135259},{"id":"5f0735329fced0a24bbaeede","score":0.8647956149878616},{"id":"5edc749c9fced0a24b0321dd","score":0.8645837941832067},{"id":"5ea6f83c9fced0a24be6c613","score":0.8545442769031004},{"id":"5eb163269fced0a24bf1b011","score":0.8521527427781214},{"id":"5edf4ff49fced0a24bd0a39f","score":0.8520455371860396}],"seg_text":"北京 化工 工大 大学 北京化工大学 生命 科学 生命科学 与 技术 学院 院长 童贻刚 表示 研究 病毒 起源 是 一个 长期 复杂 的 科学 问题 ， 比如 hiv 全球 流行 等 疫情 的 溯源 问题 都 是 漫长 的 科学 研究 科学研究 ， 在 疫情 之后 科学 学界 科学界 一定 要 系统 回顾 总结 回顾总结 人类 面对 疫情 应 共同 关注 的 经验 和 教训 ， 追溯 病毒 传播 病毒传播 途径 、 中间 宿主 。","tflag":1589884274523,"time":"2020/05/19","title":"北京化工大学生命科学与技术学院院长童贻刚表示研究病毒起源是一个长期复杂的科学问题，比如HIV全球流行等疫情的溯源问题都是漫长的科学研究，在疫情之后科学界一定要系统回顾总结人类面对疫情应共同关注的经验和教训，追溯病毒传播途径、中间宿主。","type":"points","urls":["http://news.sciencenet.cn/htmlnews/2020/5/440028.shtm"]},{"_id":"5ec3b5729fced0a24bfbc47c","aminer_id":"542dcffadabfae11fc4a3a92","category":"","content":"","date":"Mon, 18 May 2020 16:00:00 GMT","entities":[{"label":"百日咳","url":"http://xlore.org/instance/bdi5685990"},{"label":"麻疹","url":"http://xlore.org/instance/bdi8153162"},{"label":"免疫屏障","url":"http://xlore.org/instance/bdi1208039"},{"label":"传染病","url":"http://xlore.org/instance/bdi1016420"},{"label":"首席科学家","url":"http://xlore.org/instance/bdi7941937"},{"label":"传染病","url":"https://covid-19.aminer.cn/kg/class/infectious_diseases"},{"label":"麻疹","url":"https://covid-19.aminer.cn/kg/resource/R602"},{"label":"中国","url":"https://covid-19.aminer.cn/kg/resource/R25208"},{"label":"百日咳","url":"https://covid-19.aminer.cn/kg/resource/R101"},{"label":"疫情","url":"https://covid-19.aminer.cn/kg/class/epidemic_situation"},{"label":"疫苗","url":"https://covid-19.aminer.cn/kg/class/the_vaccine"},{"label":"儿童","url":"https://covid-19.aminer.cn/kg/class/children"}],"expert":"曾光","geoInfo":[{"geoName":"People\u2019s Republic of China","latitude":"35","longitude":"105","originText":"中国"},{"geoName":"Duanshi","latitude":"31.02189","longitude":"105.09354","originText":"中断"}],"id":"d92e8a4d6cb9cfe5904a37ab5ebc3a94","influence":0.33060517370081133,"lang":"zh","related_events":[{"id":"5ee182c39fced0a24b7fddce","score":0.9092010845093328},{"id":"5e8dbd929fced0a24b6e636f","score":0.8772146683470082},{"id":"5e9e72ca9fced0a24bc8826e","score":0.8759777861025643},{"id":"5eeb46fe9fced0a24bc773e1","score":0.8728923009179812},{"id":"5f17a7169fced0a24bff5357","score":0.8678981645789926},{"id":"5eb163269fced0a24bf1afcd","score":0.8646824457225666},{"id":"5e8f3fd99fced0a24b8bc18e","score":0.8558217786020927},{"id":"5eece5929fced0a24bcd2f06","score":0.8537081153935346},{"id":"5e8d92fa7ac1f2cf57f7a9f0","score":0.8528993018905802},{"id":"5eb163289fced0a24bf1b0c4","score":0.8524092367599951}],"seg_text":"中国 中心 疾控中心 流行 病学 流行病 流行病学 首席 科学 学家 科学家 曾光 教授 表示 受 疫情 影响 ， 许多 传染 染病 传染病 的 疫苗 接种 工作 中断 ， 全球 传染 染病 传染病 免疫 屏障 面临 危机 。 在 我国 ， 百日 日咳 百日咳 、 麻疹 、 手足 口 等 传染 染病 传染病 传染 风险 增大 ， 正在 威胁 着 儿童 的 生命 健康 。","tflag":1589884274460,"time":"2020/05/19","title":"中国疾控中心流行病学首席科学家曾光教授表示受疫情影响，许多传染病的疫苗接种工作中断，全球传染病免疫屏障面临危机。在我国，百日咳、麻疹、手足口等传染病传染风险增大，正在威胁着儿童的生命健康。","type":"points","urls":["https://www.thepaper.cn/newsDetail_forward_7458470"]}]
     * pagination : {"page":1,"size":5,"total":346}
     * status : true
     */

    private PaginationBean pagination;
    private boolean status;
    private List<DataBean> data;

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PaginationBean {
        /**
         * page : 1
         * size : 5
         * total : 346
         */

        private int page;
        private int size;
        private int total;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
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
    }
    @Entity(tableName = "dataBean")  //实体类创建需要加上@Entity注解
    @TypeConverters({EntitiesBeanConverter.class, GeoInfoBeanConverter.class, RelatedEventsBeanConverter.class, StringConverter.class})
    public static class DataBean {
        /**
         * _id : 5ec7ce549fced0a24bf4199f
         * aminer_id : 5448a76fdabfae87b7e5ac64
         * category :
         * content :
         * date : Thu, 21 May 2020 16:00:00 GMT
         * entities : [{"label":"传染病学","url":"http://xlore.org/instance/bdi1016445"},{"label":"疫苗","url":"https://covid-19.aminer.cn/kg/class/the_vaccine"},{"label":"传染病","url":"https://covid-19.aminer.cn/kg/class/infectious_diseases"},{"label":"rna","url":"https://covid-19.aminer.cn/kg/resource/R327"},{"label":"新冠","url":"https://covid-19.aminer.cn/kg/resource/R25833"}]
         * expert : Anthony S. Fauci
         * geoInfo : [{"geoName":"United States","latitude":"39.76","longitude":"-98.5","originText":"美国"}]
         * id : d77e1e3bd9673716ad89ab9acaea24b0
         * influence : 0.04700685372142846
         * lang : zh
         * related_events : [{"id":"5e8d92fa7ac1f2cf57f7b8a9","score":0.8755134635082309},{"id":"5eb2a4b29fced0a24b67c08c","score":0.8677345207478392},{"id":"5e96f2d49fced0a24b0ca64e","score":0.8619145435830788},{"id":"5e8d92fa7ac1f2cf57f7b479","score":0.856212338769918},{"id":"5e8d92fa7ac1f2cf57f7b47f","score":0.8525165110147629},{"id":"5ee3250e9fced0a24b514d3a","score":0.8439238074015085},{"id":"5ebbe3e89fced0a24b65f355","score":0.841333425667613},{"id":"5ea99ee09fced0a24ba6a4d0","score":0.8407931908326209},{"id":"5ee1e1549fced0a24bbb68e8","score":0.8369456098063135},{"id":"5efd61b89fced0a24b417fd6","score":0.836939813049519}]
         * seg_text : 美国 传染 染病 传染病 学 专家 安东 安东尼 · 福奇 博士 表示 ， 对 moderna 公司 研发 新冠 疫苗 保持 “ 谨慎 乐观 ” 态度 。 研究 仍处 早期 阶段 。
         * tflag : 1590152788429
         * time : 2020/05/22
         * title : 美国传染病学专家安东尼·福奇博士表示，对Moderna公司研发新冠疫苗保持“谨慎乐观”态度。研究仍处早期阶段。
         * type : points
         * urls : ["https://www.thepaper.cn/newsDetail_forward_7510604"]
         */
        @NonNull
        @PrimaryKey

        private String _id;
        @ColumnInfo(name = "aminer_id")
        private String aminer_id;
        @ColumnInfo(name = "category")
        private String category;
        @ColumnInfo(name = "content")
        private String content;
        @ColumnInfo(name = "date")
        private String date;
        @ColumnInfo(name = "expert")
        private String expert;
        @ColumnInfo(name = "id2")
        private String id2;
        @ColumnInfo(name = "influence")
        private double influence;
        @ColumnInfo(name = "lang")
        private String lang;
        @ColumnInfo(name = "seg_text")
        private String seg_text;
        @ColumnInfo(name = "tflag")
        private long tflag;
        @ColumnInfo(name = "time")
        private String time;
        @ColumnInfo(name = "title")
        private String title;
        @ColumnInfo(name = "type")
        private String type;
        @ColumnInfo(name = "source")
        private String source;
        private List<EntitiesBean> entities;
        private List<GeoInfoBean> geoInfo;
        private List<RelatedEventsBean> related_events;
        private List<String> urls;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getAminer_id() {
            return aminer_id;
        }
        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setAminer_id(String aminer_id) {
            this.aminer_id = aminer_id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getExpert() {
            return expert;
        }

        public void setExpert(String expert) {
            this.expert = expert;
        }

        public String getId2() {
            return id2;
        }

        public void setId2(String id) {
            this.id2 = id;
        }

        public double getInfluence() {
            return influence;
        }

        public void setInfluence(double influence) {
            this.influence = influence;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getSeg_text() {
            return seg_text;
        }

        public void setSeg_text(String seg_text) {
            this.seg_text = seg_text;
        }

        public long getTflag() {
            return tflag;
        }

        public void setTflag(long tflag) {
            this.tflag = tflag;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<EntitiesBean> getEntities() {
            return entities;
        }

        public void setEntities(List<EntitiesBean> entities) {
            this.entities = entities;
        }

        public List<GeoInfoBean> getGeoInfo() {
            return geoInfo;
        }

        public void setGeoInfo(List<GeoInfoBean> geoInfo) {
            this.geoInfo = geoInfo;
        }

        public List<RelatedEventsBean> getRelated_events() {
            return related_events;
        }

        public void setRelated_events(List<RelatedEventsBean> related_events) {
            this.related_events = related_events;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public static class EntitiesBean {
            /**
             * label : 传染病学
             * url : http://xlore.org/instance/bdi1016445
             */

            private String label;
            private String url;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class GeoInfoBean {
            /**
             * geoName : United States
             * latitude : 39.76
             * longitude : -98.5
             * originText : 美国
             */

            private String geoName;
            private String latitude;
            private String longitude;
            private String originText;

            public String getGeoName() {
                return geoName;
            }

            public void setGeoName(String geoName) {
                this.geoName = geoName;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getOriginText() {
                return originText;
            }

            public void setOriginText(String originText) {
                this.originText = originText;
            }
        }

        public static class RelatedEventsBean {
            /**
             * id : 5e8d92fa7ac1f2cf57f7b8a9
             * score : 0.8755134635082309
             */

            private String id;
            private double score;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }
        }
    }
}
