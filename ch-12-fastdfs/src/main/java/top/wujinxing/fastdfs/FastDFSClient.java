package top.wujinxing.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;

import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
/**
 * @author: wujinxing
 * @date: 2019/3/13 14:39
 * @description:
 */
public class FastDFSClient {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    //在类加载的时候读取配置信息，并进行初始化。
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        }catch (Exception e){
            logger.error("FastDFS Client Init Fail!",e);
        }
    }

    /*public static String[] upload(FastDFSFile file){
        logger.info("FIle Name: " + file.getName() + "File Length: " + file.getContent().length);

        //文件属性信息
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        StorageClient storageClient = null;

    }*/
}
