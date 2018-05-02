package com.myschooljournal.service;

public interface ILibraryClient {

    void downloadFile(String link);
    void uploadFile(String link, String nameToSave);


}
