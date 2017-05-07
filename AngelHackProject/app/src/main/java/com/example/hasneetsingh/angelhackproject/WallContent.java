package com.example.hasneetsingh.angelhackproject;

/**
 * Created by hasneetsingh on 06/05/17.
 */

    public class WallContent {
        private String title;
        private String ngoName;
        private float raised;
        private float target;
        private int postImageId;
        private int ngoImageId;

        public WallContent(String title,String ngoName,int raised,int target,int postImageId,int ngoImageId){
            this.title=title;
            this.ngoName=ngoName;
            this.raised=raised;
            this.target=target;
            this.postImageId=postImageId;
            this.ngoImageId=ngoImageId;
        }

        public String getTitle() {
            return title;
        }

        public String getNgoName() {
            return ngoName;
        }

        public float getRaised() {
            return raised;
        }

        public float getTarget() {
            return target;
        }

        public int getImageId() {
            return postImageId;
        }

        public int getNgoImageId(){
            return ngoImageId;
        }
}
