package com.myschooljournal.service.dropboxservice;


import com.dropbox.core.DbxDownloader;
import com.dropbox.core.v2.files.DeleteArg;
import com.dropbox.core.v2.files.DeleteBatchLaunch;
import com.dropbox.core.v2.files.DownloadZipResult;

import java.util.List;

public interface ILibraryClient {

    void downloadFile(String name, String link);

    void uploadFile(String link, String nameToSave);

    void deleteFile(String name);

    void downloadFileInZip(String name);

    DeleteBatchLaunch deleteFiles(List<DeleteArg> files);

    DbxDownloader<DownloadZipResult> downloadZipFolder(String name);


}
