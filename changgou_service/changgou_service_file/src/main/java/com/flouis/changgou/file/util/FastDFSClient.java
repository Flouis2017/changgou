package com.flouis.changgou.file.util;

import com.flouis.changgou.common.util.ResourceUtil;
import com.flouis.changgou.file.pojo.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

public class FastDFSClient {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    /***
     * 初始化加载FastDFS的TrackerServer配置
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!",e);
        }
    }

    /***
     * 文件上传
     * @param file
     * @return String[0]:文件的组名  String[1]:文件的路径信息
     */
    public static String[] upload(FastDFSFile file) throws IOException, MyException {
        //获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        //接收返回数据
        String[] uploadResults;
        StorageClient storageClient = getStorageClient();
        uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        if (uploadResults == null) {
            logger.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        return uploadResults;
    }

    /***
     * 获取文件信息
     * @param groupName：组名 如 group1
     * @param remoteFileName：文件存储完整名 如 M00/00/00/rBEAA157eYWATKhNAAUO_fS6PJI578.jpg
     */
    public static FileInfo getFile(String groupName, String remoteFileName) throws IOException, MyException{
        StorageClient storageClient = getStorageClient();
        return storageClient.get_file_info(groupName, remoteFileName);
    }

    /***
     * 文件下载
     * @param groupName
     * @param remoteFileName
     */
    public static void download(String groupName, String remoteFileName) throws IOException, MyException{
        // 获取后缀名
        String ext = remoteFileName.substring(remoteFileName.lastIndexOf("."));
        StorageClient storageClient = getStorageClient();
        // 下载文件到本地
        byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
        InputStream is = new ByteArrayInputStream(fileByte);
        // 没有文件夹创建文件夹：
        String localSaveDirPath = ResourceUtil.getProperty("localSaveDirPath");
        File dir = new File(localSaveDirPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(localSaveDirPath + System.currentTimeMillis() + ext);
        // 缓冲区
        byte[] buffer = new byte[1024];
        while (is.read(buffer) != -1){
            fos.write(buffer);
        }
        fos.flush();
        fos.close();
        is.close();
    }

    /***
     * 文件删除
     * @param groupName
     * @param remoteFileName
     */
    public static void deleteFile(String groupName, String remoteFileName) throws IOException, MyException{
        StorageClient storageClient = getStorageClient();
        storageClient.delete_file(groupName, remoteFileName);
    }

    /***
     * 获取Storage组
     * @param groupName
     */
    public static StorageServer[] getStorages(String groupName) throws IOException {
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //获取TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Storage组
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    /***
     * 获取Storage信息,IP和端口
     * @param groupName
     * @param remoteFileName
     */
    public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    /***
     * 获取Tracker服务地址
     */
    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }

    /***
     * 获取Storage客户端
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        return new StorageClient(trackerServer, null);
    }

    /***
     * 获取Tracker
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        return trackerClient.getConnection();
    }

}
