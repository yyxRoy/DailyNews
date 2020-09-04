package com.example.dailynews.json;

import java.util.List;

public class MyNewsBean {

    /**
     * tflag : 1599194535018
     * datas : [{"_id":"5e8d92fa7ac1f2cf57f7a8c7","type":"event","title":"杜兰大学医学院罗伯特・加里教授等研究发现新型病毒不是在实验室中构建的，也不是有目的性的人为操控的病毒，而是是自然产生的。","category":"","time":"2020/03/29","geoInfo":[{"originText":"加里","geoName":"Garris","latitude":"43.3425","longitude":"-1.06111"}],"lang":"zh","influence":0.6233865924223966},{"_id":"5e8d92fa7ac1f2cf57f7a8c8","type":"event","title":"deCODE基因公司通过对冰岛确诊病例进行基因测序分析，发现40个新冠病毒的变体。病毒学家认为新冠病毒最终可能会进化为更具传染性但低致病性的病毒。","category":"","time":"2020/03/29","geoInfo":[{"originText":"冰岛","geoName":"Republic of Iceland","latitude":"65","longitude":"-18"}],"lang":"zh","influence":0.442798873672389}]
     */

    private long tflag;
    private List<DatasBean> datas;

    public long getTflag() {
        return tflag;
    }

    public void setTflag(long tflag) {
        this.tflag = tflag;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * _id : 5e8d92fa7ac1f2cf57f7a8c7
         * type : event
         * title : 杜兰大学医学院罗伯特・加里教授等研究发现新型病毒不是在实验室中构建的，也不是有目的性的人为操控的病毒，而是是自然产生的。
         * category :
         * time : 2020/03/29
         * geoInfo : [{"originText":"加里","geoName":"Garris","latitude":"43.3425","longitude":"-1.06111"}]
         * lang : zh
         * influence : 0.6233865924223966
         */

        private String _id;
        private String type;
        private String title;
        private String category;
        private String time;
        private String lang;
        private double influence;
        private List<GeoInfoBean> geoInfo;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public double getInfluence() {
            return influence;
        }

        public void setInfluence(double influence) {
            this.influence = influence;
        }

        public List<GeoInfoBean> getGeoInfo() {
            return geoInfo;
        }

        public void setGeoInfo(List<GeoInfoBean> geoInfo) {
            this.geoInfo = geoInfo;
        }

        public static class GeoInfoBean {
            /**
             * originText : 加里
             * geoName : Garris
             * latitude : 43.3425
             * longitude : -1.06111
             */

            private String originText;
            private String geoName;
            private String latitude;
            private String longitude;

            public String getOriginText() {
                return originText;
            }

            public void setOriginText(String originText) {
                this.originText = originText;
            }

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
        }
    }
}
