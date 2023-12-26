package com.aeo.checkout.fraud.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aeo.checkout.fraud.model.aci.ACIException;
import com.liveprocessor.LPClient.LPClient;
import com.liveprocessor.LPClient.LPIniFileException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LPClientConfig {

	private static final String DEFAULT_FILEPATH = "src/main/resources/data/security";

	private final String filePath;

	public LPClientConfig(FraudConfig config) {
		this.filePath = config.getConfigPath();
		LPClient.addProviders();
	}
	
	@Profile("kubernetes")
	@Bean("lpClient")
	public LPClient lpClientK8s() throws ACIException {
		findFile(this.filePath);
		LPClient lpClient = null;
		try {
			lpClient = new LPClient(this.filePath, true);
		} catch (LPIniFileException e) {
			throw new ACIException("Could not create LPClient", e);
		}
		return lpClient;
	}

	@Profile("cloud")
	@Bean("lpClient")
	public LPClient lpClientCloud() throws ACIException {
		updateIniFilePaths(this.filePath);
		LPClient lpClient = null;
		try {
			lpClient = new LPClient(this.filePath, true);
		} catch (LPIniFileException e) {
			throw new ACIException("Could not create LPClient", e);
		}
		return lpClient;
	}

	@Profile("!cloud & !kubernetes")
	@Bean("lpClient")
	public LPClient lpClient() throws ACIException {
		LPClient lpClient = null;
		try {
			lpClient = new LPClient(DEFAULT_FILEPATH, true);
		} catch (LPIniFileException e) {
			throw new ACIException("Could not create LPClient", e);
		}
		return lpClient;
	}
	
	private static File findFile(String configFilePath) {
		File lpFile = new File(configFilePath + "/lp53.ini");
		if(!lpFile.exists()) {
			log.warn("LP File Does Not Exist: {}", configFilePath);
		} else {
			log.info("LP File: {}", configFilePath);
		}
		return lpFile;
	}

	private static void updateIniFilePaths(String configFilePath) {
		File lpFile = findFile(configFilePath);
		try {
			String oldContent = readFile(lpFile);
			String newContent = oldContent.replaceAll(DEFAULT_FILEPATH, configFilePath);
			writeFile(lpFile, newContent);
		} catch (IOException e) {
			log.error("modifyFile()", e);
		}
	}

	private static void writeFile(File lpFile, String content) throws IOException {
		FileWriter writer = new FileWriter(lpFile);
		try {
			writer.write(content);
		} finally {
			writer.close();
		}
	}

	private static String readFile(File lpFile) throws IOException {
		StringBuilder oldContent = new StringBuilder("");
		BufferedReader reader = new BufferedReader(new FileReader(lpFile));
		try {
			String line = reader.readLine();
			while (line != null) {
				oldContent.append(line);
				oldContent.append(System.lineSeparator());
				line = reader.readLine();
			}
		} finally {
			reader.close();
		}
		return oldContent.toString();
	}

}
