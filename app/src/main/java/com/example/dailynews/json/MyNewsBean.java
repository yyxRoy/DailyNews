package com.example.dailynews.json;

import java.util.List;

public class MyNewsBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5f52393a9fced0a24b14b207
         * aminer_id : 5f074ac29e795e1a9f4aee6c
         * authors : [{"name":"Saroj Kumar Chandra"},{"name":"Avaneesh Singh"},{"id":"563179c245cedb3399e18e2c","name":"Manish Kumar Bajpai"}]
         * category :
         * content : COVID-19 is well known to everyone in the world. It has spread around the world. No vaccine or antiviral treatment is available till now. COVID-19 patients are increasing day by day. All countries have adopted social distancing as a preventive measure to reduce spread. It becomes necessary to estimate the number of peoples going to be affected with COVID-19 in advance so that necessary arrangements can be done. Mathematical models are used to provide early disease estimation based on limited parameters. In the present manuscript, a novel mathematical model with a social distancing parameter has been proposed to provide early COVID-19 spread estimation. The model has been validated with real data set. It has been observed that the proposed model is more accurate in spread estimation.
         * date : Tue, 28 Apr 2020 16:00:00 GMT
         * doi : 10.1101/2020.04.30.20086611
         * entities : [{"label":"social distancing","url":"http://xlore.org/instance/eni2552448"},{"label":"antiviral","url":"http://xlore.org/instance/eni24662"},{"label":"mathematical model","url":"http://xlore.org/instance/eni9914"},{"label":"measure","url":"https://covid-19.aminer.cn/kg/class/measure"},{"label":"COVID-19","url":"https://covid-19.aminer.cn/kg/resource/R332"},{"label":"antiviral","url":"https://covid-19.aminer.cn/kg/resource/R5643"},{"label":"disease","url":"https://covid-19.aminer.cn/kg/class/disease"}]
         * geoInfo : []
         * id : 5f074ac29e795e1a9f4aee6c
         * lang :
         * pdf : https://static.aminer.cn/upload/pdf/369/189/275/5f074ac29e795e1a9f4aee6c_0.pdf
         * seg_text : mathemat model social distanc paramet earli estim covid - 19 spread covid - 19 well known everyon world . It ha spread around world . No vaccin antivir treatment avail till . covid - 19 patient increas day day . countri adopt social distanc prevent measur reduc spread . It becom necessari estim number peopl go affect covid - 19 advanc necessari arrang done . mathemat model use provid earli diseas estim base limit paramet . In present manuscript , novel mathemat model social distanc paramet ha propos provid earli covid - 19 spread estim . model ha valid real data set . It ha observ propos model accur spread estim .
         * source :
         * tflag : 1599224122028
         * time : 2020/04/29
         * title : Mathematical Model with Social Distancing Parameter for Early Estimation of COVID-19 Spread
         * type : paper
         * urls : ["https://www.medrxiv.org/content/medrxiv/early/2020/05/05/2020.04.30.20086611.full.pdf","https://app.dimensions.ai/details/publication/pub.1127387728"]
         * year : 2020
         */

        private String _id;
        private String aminer_id;
        private String category;
        private String content;
        private String date;
        private String doi;
        private String id;
        private String lang;
        private String pdf;
        private String seg_text;
        private String source;
        private long tflag;
        private String time;
        private String title;
        private String type;
        private int year;
        private List<AuthorsBean> authors;
        private List<EntitiesBean> entities;
        private List<?> geoInfo;
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

        public String getDoi() {
            return doi;
        }

        public void setDoi(String doi) {
            this.doi = doi;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getPdf() {
            return pdf;
        }

        public void setPdf(String pdf) {
            this.pdf = pdf;
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

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<AuthorsBean> getAuthors() {
            return authors;
        }

        public void setAuthors(List<AuthorsBean> authors) {
            this.authors = authors;
        }

        public List<EntitiesBean> getEntities() {
            return entities;
        }

        public void setEntities(List<EntitiesBean> entities) {
            this.entities = entities;
        }

        public List<?> getGeoInfo() {
            return geoInfo;
        }

        public void setGeoInfo(List<?> geoInfo) {
            this.geoInfo = geoInfo;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public static class AuthorsBean {
            /**
             * name : Saroj Kumar Chandra
             * id : 563179c245cedb3399e18e2c
             */

            private String name;
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class EntitiesBean {
            /**
             * label : social distancing
             * url : http://xlore.org/instance/eni2552448
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
    }
}
