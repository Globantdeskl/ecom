
package com.example.aicodegen.dto;


public class CodeGenRequest {
	
	    private String basePackage;   // com.example.employee
	    private String moduleName;    // employee
	    private String tableSchema;   // table definition
	    private boolean generateDto;
	    private boolean generateController;
	    private boolean generateService;
	    private boolean generateRepository;
	    
	    
		public String getBasePackage() {
			return basePackage;
		}
		public void setBasePackage(String basePackage) {
			this.basePackage = basePackage;
		}
		public String getModuleName() {
			return moduleName;
		}
		public void setModuleName(String moduleName) {
			this.moduleName = moduleName;
		}
		public String getTableSchema() {
			return tableSchema;
		}
		public void setTableSchema(String tableSchema) {
			this.tableSchema = tableSchema;
		}
		public boolean isGenerateDto() {
			return generateDto;
		}
		public void setGenerateDto(boolean generateDto) {
			this.generateDto = generateDto;
		}
		public boolean isGenerateController() {
			return generateController;
		}
		public void setGenerateController(boolean generateController) {
			this.generateController = generateController;
		}
		public boolean isGenerateService() {
			return generateService;
		}
		public void setGenerateService(boolean generateService) {
			this.generateService = generateService;
		}
		public boolean isGenerateRepository() {
			return generateRepository;
		}
		public void setGenerateRepository(boolean generateRepository) {
			this.generateRepository = generateRepository;
		}
	    
	    
	    
	    
	}

