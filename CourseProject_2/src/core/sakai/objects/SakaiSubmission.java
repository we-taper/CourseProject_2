package core.sakai.objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "submission")
public class SakaiSubmission {

	private String attachment_url;
	private String feedback_comment;
	private String feedback_text;
	private String grade;
	private String status;
	private String submitted_text;

	@XmlAttribute(name = "attachment-url")
	public String getAttachment_url() {
		return attachment_url;
	}

	public void setAttachment_url(String attachment_url) {
		this.attachment_url = attachment_url;
	}

	@XmlAttribute(name = "feedback-comment")
	public String getFeedback_comment() {
		return feedback_comment;
	}

	public void setFeedback_comment(String feedback_comment) {
		this.feedback_comment = feedback_comment;
	}

	@XmlAttribute(name = "feedback-text")
	public String getFeedback_text() {
		return feedback_text;
	}

	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}

	@XmlAttribute(name = "grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@XmlAttribute(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlAttribute(name = "submitted-text")
	public String getSubmitted_text() {
		return submitted_text;
	}

	public void setSubmitted_text(String submitted_text) {
		this.submitted_text = submitted_text;
	}

	@Override
	public String toString() {
		return "SakaiSubmission [getAttachment_url()=" + getAttachment_url()
				+ ", getFeedback_comment()=" + getFeedback_comment()
				+ ", getFeedback_text()=" + getFeedback_text()
				+ ", getGrade()=" + getGrade() + ", getStatus()=" + getStatus()
				+ ", getSubmitted_text()=" + getSubmitted_text() + "]";
	}
}
