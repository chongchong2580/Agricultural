package com.gricultural.utils;


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/1 21:13
 * @Description:
 */
public class QiniuUtils {
    public static String accessKey = "6G3UI7axcC0aJ1f9fXNtMHGAiHhKCLEay4z-0dQj";
    public static String secretKey = "FqAxWvBO5oM4ZZehQrp2ZDgFz_wVJrA1emxW4ixT";
    public static String bucket = "agricultural-project";

    //根据文件地址进行文件上传操作
    public static void upload2Qiniu(String filePath,String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);
        Response response = null;
        try {
            response = uploadManager.put(filePath,fileName,upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        } catch (QiniuException e) {
            Response r = e.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex) {
                ex.printStackTrace();
            }
        }
    }

    //上传文件
    public static void upload2Qiniu(byte[] bytes,String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        Auth auth = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes,key,upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException e) {
            Response r = e.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex) {
                ex.printStackTrace();
            }
        }
    }

    //删除文件
    public static void deleteFileFromQiniu(String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        String key = fileName;
        Auth auth = Auth.create(accessKey,secretKey);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        try {
            bucketManager.delete(bucket,key);
        } catch (QiniuException e) {
           //如果遇到异常，说明删除失败
            System.err.println(e.code());
            System.err.println(e.response.toString());
        }
    }
}
