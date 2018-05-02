package com.myschooljournal.service;


import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.myschooljournal.util.PropertyLoader;

import java.io.FileInputStream;
import java.io.InputStream;

import static com.myschooljournal.service.ServiceConstants.DROPBOX_TOKEN;

public class DropboxClient implements ILibraryClient {

    public static final DropboxClient DROPBOX_CLIENT=init();
    private DbxClientV2 client;


   private DropboxClient(DbxClientV2 client) {
       this.client=client;

    }

   private static  DropboxClient init() {
       //todo: change code/ don't use deprecate constructor

        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, PropertyLoader.getProperty(DROPBOX_TOKEN));

        return new DropboxClient(client);
    }
    @Override
    public void downloadFile(String link) {

    }

    @Override
    public void uploadFile(String link, String nameToSave)  {
        try (InputStream in = new FileInputStream(link)) {
            FileMetadata metadata = client.files().uploadBuilder(nameToSave)
                   .uploadAndFinish(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
