package com.example.dailynews.json;

import java.util.List;

public class NewsDetail {

    /**
     * data : {"_id":"5f05f3f69fced0a24b2f84ee","category":"","content":"HELSINKI, July 8 (Xinhua) -- Finnish think tank Sitra said on Wednesday a majority of Finns believe that their post-COVID-19 society will attach more importance to science and expertise and will witness heightened social tension and conflicts on economic interests.,Less than 20 percent of respondents said that people would become more interested in personally participating in political activities in the wake of the COVID-19 pandemic.,Antti Kivela, a director at Sitra, noted in a press release on Wednesday that based on the poll's findings, Finns want the decisions about their future to be \"based on researched information.\",Kalle Nieminen, a leading expert at Sitra, told Finnish newspaper Hufvudstadsbladet that Finland should not waste the opportunities offered by the COVID-19 epidemic.,The poll of about 4,000 individuals was conducted in May. Sitra is a leading Finnish think tank operating on a capital initially donated by the state in 1967.","date":"Wed, 08 Jul 2020 15:54:59 GMT","entities":[{"label":"hufvudstadsbladet","url":"http://xlore.org/instance/eni451410"},{"label":"sitra","url":"http://xlore.org/instance/eni820264"},{"label":"think tank","url":"http://xlore.org/instance/eni18475"},{"label":"xinhua","url":"http://xlore.org/instance/eni126120"},{"label":"finns","url":"http://xlore.org/instance/eni240847"},{"label":"helsinki","url":"http://xlore.org/instance/eni6431"},{"label":"finnish","url":"http://xlore.org/instance/eni4929"},{"label":"epidemic","url":"https://covid-19.aminer.cn/kg/class/epidemic"},{"label":"COVID-19","url":"https://covid-19.aminer.cn/kg/resource/R332"}],"geoInfo":[{"geoName":"Snoma Finnish Cemetery","latitude":"44.63303","longitude":"-103.68491","originText":"Finnish"},{"geoName":"Republic of Finland","latitude":"64","longitude":"26","originText":"Finland"}],"id":"xinhua13919810411110320","influence":0.2758120058205174,"lang":"en","related_events":[{"id":"5ec2d4809fced0a24b8e6b2d","score":0.9113580346658512},{"id":"5ee0cd1c9fced0a24b4f42ba","score":0.899462472807494},{"id":"5e9ded0a9fced0a24b5bc270","score":0.8976683557998417},{"id":"5ec7cdad9fced0a24bf35d30","score":0.8971055445251076},{"id":"5eb2d44b9fced0a24b741872","score":0.8966782151341071},{"id":"5ec57e959fced0a24b5fbc91","score":0.8949342654876311},{"id":"5ec16df09fced0a24bec32b9","score":0.894795169443423},{"id":"5e94b3c09fced0a24bf01117","score":0.8938918557235777},{"id":"5eb964d39fced0a24bd491eb","score":0.8933007474044586},{"id":"5e95fb919fced0a24b9e9d26","score":0.8932850056281226}],"seg_text":"finn believ crisi give boost scienc helsinki , juli 8 ( xinhua ) -- finnish think tank sitra said wednesday major finn believ post - covid - 19 societi attach import scienc expertis wit heighten social tension conflict econom interest . , less 20 percent respond said peopl would becom interest person particip polit activ wake covid - 19 pandem . , antti kivela , director sitra , note press releas wednesday base poll ' find , finn want decis futur `` base research inform . `` , kall nieminen , lead expert sitra , told finnish newspap hufvudstadsbladet finland wast opportun offer covid - 19 epidem . , poll 4 , 000 individu wa conduct may . sitra lead finnish think tank oper capit initi donat state 1967 .","source":"XINHUANET","tflag":1594225654814,"time":"2020-07-08 23:54:59","title":"Finns believe crisis gives boost to science","type":"news","urls":["http://www.xinhuanet.com/english/2020-07/08/c_139198104.htm"]}
     * status : true
     */

    private DataBean data;
    private boolean status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * _id : 5f05f3f69fced0a24b2f84ee
         * category :
         * content : HELSINKI, July 8 (Xinhua) -- Finnish think tank Sitra said on Wednesday a majority of Finns believe that their post-COVID-19 society will attach more importance to science and expertise and will witness heightened social tension and conflicts on economic interests.,Less than 20 percent of respondents said that people would become more interested in personally participating in political activities in the wake of the COVID-19 pandemic.,Antti Kivela, a director at Sitra, noted in a press release on Wednesday that based on the poll's findings, Finns want the decisions about their future to be "based on researched information.",Kalle Nieminen, a leading expert at Sitra, told Finnish newspaper Hufvudstadsbladet that Finland should not waste the opportunities offered by the COVID-19 epidemic.,The poll of about 4,000 individuals was conducted in May. Sitra is a leading Finnish think tank operating on a capital initially donated by the state in 1967.
         * date : Wed, 08 Jul 2020 15:54:59 GMT
         * entities : [{"label":"hufvudstadsbladet","url":"http://xlore.org/instance/eni451410"},{"label":"sitra","url":"http://xlore.org/instance/eni820264"},{"label":"think tank","url":"http://xlore.org/instance/eni18475"},{"label":"xinhua","url":"http://xlore.org/instance/eni126120"},{"label":"finns","url":"http://xlore.org/instance/eni240847"},{"label":"helsinki","url":"http://xlore.org/instance/eni6431"},{"label":"finnish","url":"http://xlore.org/instance/eni4929"},{"label":"epidemic","url":"https://covid-19.aminer.cn/kg/class/epidemic"},{"label":"COVID-19","url":"https://covid-19.aminer.cn/kg/resource/R332"}]
         * geoInfo : [{"geoName":"Snoma Finnish Cemetery","latitude":"44.63303","longitude":"-103.68491","originText":"Finnish"},{"geoName":"Republic of Finland","latitude":"64","longitude":"26","originText":"Finland"}]
         * id : xinhua13919810411110320
         * influence : 0.2758120058205174
         * lang : en
         * related_events : [{"id":"5ec2d4809fced0a24b8e6b2d","score":0.9113580346658512},{"id":"5ee0cd1c9fced0a24b4f42ba","score":0.899462472807494},{"id":"5e9ded0a9fced0a24b5bc270","score":0.8976683557998417},{"id":"5ec7cdad9fced0a24bf35d30","score":0.8971055445251076},{"id":"5eb2d44b9fced0a24b741872","score":0.8966782151341071},{"id":"5ec57e959fced0a24b5fbc91","score":0.8949342654876311},{"id":"5ec16df09fced0a24bec32b9","score":0.894795169443423},{"id":"5e94b3c09fced0a24bf01117","score":0.8938918557235777},{"id":"5eb964d39fced0a24bd491eb","score":0.8933007474044586},{"id":"5e95fb919fced0a24b9e9d26","score":0.8932850056281226}]
         * seg_text : finn believ crisi give boost scienc helsinki , juli 8 ( xinhua ) -- finnish think tank sitra said wednesday major finn believ post - covid - 19 societi attach import scienc expertis wit heighten social tension conflict econom interest . , less 20 percent respond said peopl would becom interest person particip polit activ wake covid - 19 pandem . , antti kivela , director sitra , note press releas wednesday base poll ' find , finn want decis futur `` base research inform . `` , kall nieminen , lead expert sitra , told finnish newspap hufvudstadsbladet finland wast opportun offer covid - 19 epidem . , poll 4 , 000 individu wa conduct may . sitra lead finnish think tank oper capit initi donat state 1967 .
         * source : XINHUANET
         * tflag : 1594225654814
         * time : 2020-07-08 23:54:59
         * title : Finns believe crisis gives boost to science
         * type : news
         * urls : ["http://www.xinhuanet.com/english/2020-07/08/c_139198104.htm"]
         */

        private String _id;
        private String category;
        private String content;
        private String date;
        private String id;
        private double influence;
        private String lang;
        private String seg_text;
        private String source;
        private long tflag;
        private String time;
        private String title;
        private String type;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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
             * label : hufvudstadsbladet
             * url : http://xlore.org/instance/eni451410
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
             * geoName : Snoma Finnish Cemetery
             * latitude : 44.63303
             * longitude : -103.68491
             * originText : Finnish
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
             * id : 5ec2d4809fced0a24b8e6b2d
             * score : 0.9113580346658512
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
