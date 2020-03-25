package com.flouis.changgou.file.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FastDFSFile {

	private String name; // 文件名称
	private byte[] content; // 文件内容
	private String ext; // 文件扩展名
	private String md5; // 文件MD5摘要值
	private String author; // 文件创建者

	public FastDFSFile(String name, byte[] content, String ext){
		super();
		this.setName(name);
		this.setContent(content);
		this.setExt(ext);
	}

}
