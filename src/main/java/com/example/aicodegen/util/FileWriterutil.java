package com.example.aicodegen.util;

import com.example.aicodegen.dto.CodeGenRequest;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Component
public class FileWriterutil {

	public void write(Map<String, String> code, CodeGenRequest req) {

		try {
			String root = System.getProperty("user.dir");
			String basePath = root + "/src/main/java/" + req.getBasePackage().replace(".", "/");

			create(basePath + "/entity/Entity.java", code.get("entity"));
			create(basePath + "/dto/Dto.java", code.get("dto"));
			create(basePath + "/repository/Repository.java", code.get("repository"));
			create(basePath + "/service/Service.java", code.get("service"));
			create(basePath + "/service/impl/ServiceImpl.java", code.get("serviceImpl"));
			create(basePath + "/controller/Controller.java", code.get("controller"));

		} catch (Exception e) {
			throw new RuntimeException("File generation failed", e);
		}
	}

	private void create(String path, String content) throws Exception {
		Path p = Path.of(path);
		Files.createDirectories(p.getParent());
		Files.writeString(p, content);
	}
}
