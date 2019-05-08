package com.fastdfs.springbootfastdfs.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * @ClassName: FastdfsUtils
 * @Auther: admin
 * @Date: 2019/5/8 17:55
 * @Description:
 */
public class FastdfsClient {

    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    private StorageClient storageClient = null;

    public FastdfsClient(String conf) throws IOException, MyException {
        if (conf.contains("classpath:")) {
            conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient = new StorageClient(trackerServer, storageServer);
    }

    public String uploadFile(String filePath, String extName, NameValuePair[] metas) throws IOException, MyException {
        String[] path = storageClient.upload_file(filePath, extName, metas);
        return path[0] + "/" + path[1];
    }

    public String uploadFile(String filePath) throws IOException, MyException {
        return uploadFile(filePath, null, null);
    }

    public String uploadFile(String filePath, String extName) throws IOException, MyException {
        return uploadFile(filePath, extName, null);
    }

    public String uploadFile(byte[] bytes, String extName, NameValuePair[] metas) throws IOException, MyException {
        String[] path = storageClient.upload_file(bytes, extName, metas);
        return path[0] + "/" + path[1];
    }

    public String uploadFile(byte[] bytes, String extName) throws IOException, MyException {
       return uploadFile(bytes, extName, null);
    }

    public String uploadFile(byte[] bytes) throws IOException, MyException {
        return uploadFile(bytes, null, null);
    }

}
