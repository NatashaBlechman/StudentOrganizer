package com.myschooljournal.service.dropboxservice;


import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DeleteArg;
import com.dropbox.core.v2.files.DeleteBatchLaunch;
import com.dropbox.core.v2.files.DownloadZipResult;
import com.dropbox.core.v2.files.FileMetadata;
import com.myschooljournal.util.PropertyLoader;

import java.io.*;
import java.util.List;

import static com.myschooljournal.service.ServiceConstants.DROPBOX_TOKEN;

public class DropboxClient implements ILibraryClient {

    public static final DropboxClient DROPBOX_CLIENT=init();
    private static final String PERSONAL_PACKAGE = "Dropbox personal package";
    private DbxClientV2 clientV2;

    public DropboxClient(DbxClientV2 clientV2) {
        this.clientV2=clientV2;
    }

    private static  DropboxClient init() {
       DbxRequestConfig config =DbxRequestConfig.newBuilder(PERSONAL_PACKAGE)
                .withUserLocale("en_US")
                .build();
        DbxClientV2 clientV2 = new DbxClientV2(config, PropertyLoader.getProperty(DROPBOX_TOKEN));
        return new DropboxClient(clientV2);
    }
    @Override
    public void downloadFile(String name, String link) {
        try(FileOutputStream outputStream = new FileOutputStream(name)) {
            DbxDownloader<FileMetadata> loader = clientV2.files().download(link);
            loader.download(outputStream);
        } catch (IOException | DbxException e) {
            throw new DropBoxRuntimeException(e);

        }


    }

    @Override
    public void uploadFile(String link, String nameToSave)  {
        try (InputStream in = new FileInputStream(link)) {
            clientV2.files().uploadBuilder(nameToSave).uploadAndFinish(in);
        } catch (Exception e) {
            throw new DropBoxRuntimeException(e);
        }

    }
//todo test after fixing dropbox;
    @Override
    public void deleteFile(String name) {

        try {
            clientV2.files().deleteV2(name);
        } catch (DbxException e) {
            throw new DropBoxRuntimeException(e);
        }


    }

    @Override
    public void downloadFileInZip(String name) {
        try {
            clientV2.files().downloadZipBuilder(name);
        }catch(Exception e){
            throw  new DropBoxRuntimeException(e);
        }

    }


    @Override
    public DeleteBatchLaunch deleteFiles(List<DeleteArg> files) {

        try {
            return clientV2.files().deleteBatch(files);
        } catch (DbxException e) {
            throw new DropBoxRuntimeException(e);
        }

    }

    @Override
    public DbxDownloader<DownloadZipResult> downloadZipFolder(String name) {
        try {
            return clientV2.files().downloadZip(name);
        } catch (DbxException e) {
            throw new DropBoxRuntimeException(e);
        }
    }


}
