package org.linkedin.crawler.utils;

public enum Section {
	EDUCATION("Education", "education"), PROFESSIONAL_EXPERIENCE(
			"Professional Experience", "experience"), HOBBY("Hobbies", ""), SKILLS("Skills", "");

	private String section;
	private String idAttribute;

	Section(String section, String idAttribute) {
		this.setSection(section);
		this.setIdAttribute(idAttribute);
	}

	public String getSection() {
		return section;
	}

	private void setSection(String section) {
		this.section = section;
	}

	public String getIdAttribute() {
		return idAttribute;
	}

	private void setIdAttribute(String idAttribute) {
		this.idAttribute = idAttribute;
	}

}
