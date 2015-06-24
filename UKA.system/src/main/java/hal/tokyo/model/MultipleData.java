package hal.tokyo.model;

import java.io.File;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MultipleData implements Serializable {
	private File file;
	private MultipartFile multipartFile;
	private String description;
	private String title;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void upload() {

		try {
			this.multipartFile.transferTo(this.file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
