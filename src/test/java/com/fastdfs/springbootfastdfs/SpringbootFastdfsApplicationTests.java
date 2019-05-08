package com.fastdfs.springbootfastdfs;

import com.fastdfs.springbootfastdfs.utils.FastdfsClient;
import jdk.internal.util.xml.impl.Input;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootFastdfsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUpload() throws IOException, MyException {
//        ClientGlobal.init("E:\\mjf_project\\springboot-fastdfs\\src\\main\\resources\\fdfs_client.conf");
//        TrackerClient trackerClient = new TrackerClient();
//        TrackerServer connection = trackerClient.getConnection();
//        StorageServer storageServer = null;
//        StorageClient storageClient = new StorageClient(connection, storageServer);
//
//        String[] jpgs = storageClient.upload_file("C:\\Users\\admin\\Desktop\\5abb0fc1Neb913329.jpg", "jpg", null);
//        System.out.println(Arrays.toString(jpgs));

        FastdfsClient fastdfsClient = new FastdfsClient("classpath:fdfs_client.conf");
        String jpg = fastdfsClient.uploadFile("C:\\Users\\admin\\Desktop\\5abb0fc1Neb913329.jpg", "jpg", null);
        System.out.println(jpg);
    }

}
