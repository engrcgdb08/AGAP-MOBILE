package com.example.agap;

public class uploadinformation {

    public String reportersName;
    public String imageURL;
    public  String imageAddress;
    public  String imageComplaint;

    public uploadinformation(){}

    public uploadinformation(String name,String address,String complaint,  String url) {
        this.reportersName = name;
        this.imageURL = url;
        this.imageAddress = address;
        this.imageComplaint = complaint;
    }


    public String getReportersName() {
        return reportersName;
    }
    public String getImageURL() {
        return imageURL;
        }
}
