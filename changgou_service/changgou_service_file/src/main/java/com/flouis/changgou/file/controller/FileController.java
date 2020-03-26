package com.flouis.changgou.file.controller;

import com.flouis.changgou.common.entity.Result;
import com.flouis.changgou.file.pojo.FastDFSFile;
import com.flouis.changgou.file.util.FastDFSClient;
import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.FileInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

	/**
	 * @description 文件上传
	 */
	@PostMapping("/upload")
	public Result uploadFile(MultipartFile file){
		try {
			//判断文件是否存在
			if (file == null){
				return Result.fail("无法上传空文件");
			}
			//获取文件的完整名称
			String originalFilename = file.getOriginalFilename();
			if (StringUtils.isEmpty(originalFilename)){
				return Result.fail("文件不存在");
			}
			//获取文件扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			//获取文件内容
			byte[] content = file.getBytes();
			//创建文件上传的封装实体类
			FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, content, extName);
			//基于工具类进行文件上传,并接受返回参数 String[]
			String[] uploadResult = FastDFSClient.upload(fastDFSFile);
			//封装返回结果
			String url = FastDFSClient.getTrackerUrl() + uploadResult[0] + "/" + uploadResult[1];

			// todo 数据库落地


			return Result.success("文件上传成功", url);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail("文件上传失败");
		}
	}

	/**
	 * @description 文件(服务器)信息获取
	 */
	@GetMapping
	public Result getFile(String groupName, String remoteFileName){
		try {
			FileInfo fileInfo = FastDFSClient.getFile(groupName, remoteFileName);
			return Result.success(fileInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
	}

	/**
	 * @description 文件下载
	 */
	@GetMapping("/download")
	public Result download(String groupName, String remoteFileName){
		try {
			FastDFSClient.download(groupName, remoteFileName);
			return Result.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
	}


}
