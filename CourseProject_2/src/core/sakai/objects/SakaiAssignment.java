package core.sakai.objects;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="assignment")
public class SakaiAssignment {

	private String access;
	public void setAccess(String a) {
		access = a;
	}
	public String getAccess() {
		return access;
	}
	
	private SakaiResource attachment;
	public void setAttachment(SakaiResource a){
		attachment = a;
	}
	public SakaiResource getAttachment() {
		return attachment;
	}
	
	private String authorLastModified;
	public void setAuthorLastModified(String a) {
		authorLastModified = a;
	}
	public String getAuthorLastModified() {
		return authorLastModified;
	}
	
	private String[] authors;
	public void setAuthors(String[] a) {
		authors = a;
	}
	public String[] getAuthors() {
		return authors;
	}
	
	private SakaiTime closeTime;
	public void setCloseTime(SakaiTime t) {
		closeTime = t;
	}
	public SakaiTime getCloseTime() {
		return closeTime;
	}
	
	private String closeTimeString;
	public void setCloseTimeString(String s) {
		closeTimeString = s;
	}
	public String getCloseTimeString() {
		return closeTimeString;
	}
	
	private String content;//TODO what's this exactly
	public void setContent(String s) {
		content = s;
	}
	public String getContent() {
		return content;
	}
	
	private String contentReference;
	public void setContentReference(String s) {
		contentReference = s;
	}
	public String getContentReference(){
		return contentReference;
	}
	
	private String context;
	public void setContext(String s) {
		content = s;
	}
	public String getContext() {
		return context;
	}
	
	private String creator;
	public void setCreator(String s ){
		creator = s;
	}
	public String getCreator(){
		return creator;
	}
	
	private SakaiTime dropDeadTime;
	public void setdropDeadTime(SakaiTime t){
		dropDeadTime = t;
	}
	public SakaiTime getDropDeadTime(){
		return dropDeadTime;
	}
	
	private String dropDeadTimeString;
	public void setDropDeadTimeString(String s) {
		dropDeadTimeString = s;
	}
	public String getDropDeadTimeString() {
		return dropDeadTimeString;
	}
	
	private SakaiTime dueTime;
	public void setDueTime(SakaiTime t){
		dueTime = t;
	}
	public SakaiTime getDueTime(){
		return dueTime;
	}
	
	private String dueTimeString;
	public void setDueTimeString(String s) {
		dueTimeString = s;
	}
	public String getDueTimeString() {
		return dueTimeString;
	}
	
	private String groups;
	public void setGroups(String s) {
		groups = s;
	}
	public String getGroups() {
		return groups;
	}
	
	private String id;
	public void setId(String s){
		id = s;
	}
	public String getId(){
		return id;
	}
	
	private SakaiTime openTime;
	public void setOpenTime(SakaiTime t){
		openTime = t;
	}
	public SakaiTime getOpenTime(){
		return openTime;
	}
	
	private String openTimeString;
	public void setOpenTimeString(String s) {
		openTimeString = s;
	}
	public String getOpenTimeString() {
		return openTimeString;
	}
	
	private long position_order;
	public void setPosition_order(long t){
		position_order = t;
	}
	public long getPosition_order(){
		return position_order;
	}
	
	private String section;
	public void setSection(String s) {
		section = s;
	}
	public String getSection() {
		return section;
	}
	
	private String status;
	public void setStatus(String s) {
		status = s;
	}
	public String getStatus() {
		return status;
	}
	
	private SakaiTime timeCreated;
	public void setTimeCreated(SakaiTime t){
		timeCreated = t;
	}
	public SakaiTime getTimeCreated(){
		return timeCreated;
	}
	
	private SakaiTime timeLastModified;
	public void setTimeLastModified(SakaiTime t){
		timeLastModified = t;
	}
	public SakaiTime getTimeLastModified(){
		return timeLastModified;
	}
	
	private String title;
	public void setTitle(String s){
		title = s;
	}
	public String getTitle() {
		return title;
	}
	
	private boolean draft;
	public void setDraft(boolean t) {
		draft = t;
	}
	public boolean isDraft() {
		return draft;
	}
	
	private String entityURL;
	public void setEntityURL(String s){
		entityURL = s;
	}
	public String getEntityURL(){
		return entityURL;
	}
	
	private String entityId;
	public void setEntityId(String s){
		entityId = s;
	}
	public String getEntityId(){
		return entityId;
	}
	
	private String entityTitle;
	public void setEntityTitle(String s){
		entityTitle = s;
	}
	public String getEntityTitle(){
		return entityTitle;
	}
	
	@Override
	public String toString() {
		return String.format("Assignment:%s, ID:%s, Entity_URL:%s, Start data:%s",
				getTitle(), getId(), getEntityURL(), getOpenTime().getDisplay());
	}
	
	@XmlRootElement(name="content")
	public static class SakaiAssignmentContent{
		@Override
		public String toString() {
			return "SakaiAssignmentContent [allowAttachments="
					+ allowAttachments + ", allowReviewService="
					+ allowReviewService + ", allowStudentViewReport="
					+ allowStudentViewReport + ", attachments="
					+ Arrays.toString(attachments) + ", authorLastModified="
					+ authorLastModified + ", authors="
					+ Arrays.toString(authors) + ", context=" + context
					+ ", creator=" + creator + ", generateOriginalityReport="
					+ generateOriginalityReport + ", groupProject="
					+ groupProject + ", honorPledge=" + honorPledge + ", id="
					+ id + ", instructions=" + instructions
					+ ", maxGradePoint=" + maxGradePoint
					+ ", maxGradePointDisplay=" + maxGradePointDisplay
					+ ", properties=" + Arrays.toString(properties)
					+ ", reference=" + reference + ", submitReviewRepo="
					+ submitReviewRepo + ", timeCreated=" + timeCreated
					+ ", timeLastModified=" + timeLastModified + ", title="
					+ title + ", typeOfGrade=" + typeOfGrade
					+ ", typeOfSubmission=" + typeOfSubmission + ", url=" + url
					+ ", checkInstitution=" + checkInstitution
					+ ", checkInternet=" + checkInternet
					+ ", checkPublications=" + checkPublications
					+ ", checkTurnitin=" + checkTurnitin + "]";
		}
		private boolean allowAttachments;
		private boolean allowReviewService;
		private boolean allowStudentViewReport;
		private SakaiResource[] attachments;
		private String authorLastModified;
		private String[] authors;
		private String context;
		private String creator;
		private long generateOriginalityReport;
		private boolean groupProject;
		private long honorPledge;
		private String id;
		private String instructions;
		private double maxGradePoint;
		private String maxGradePointDisplay;
		private Object[] properties;
		private String reference;
		private long submitReviewRepo;
		private SakaiTime timeCreated;
		private SakaiTime timeLastModified;
		private String title;
		private long typeOfGrade;
		private long typeOfSubmission;
		private String url;
		private boolean checkInstitution;
		private boolean checkInternet;
		private boolean checkPublications;
		private boolean checkTurnitin;
		public boolean isAllowAttachments() {
			return allowAttachments;
		}
		public void setAllowAttachments(boolean allowAttachments) {
			this.allowAttachments = allowAttachments;
		}
		public boolean isAllowReviewService() {
			return allowReviewService;
		}
		public void setAllowReviewService(boolean allowReviewService) {
			this.allowReviewService = allowReviewService;
		}
		public boolean isAllowStudentViewReport() {
			return allowStudentViewReport;
		}
		public void setAllowStudentViewReport(boolean allowStudentViewReport) {
			this.allowStudentViewReport = allowStudentViewReport;
		}
		public SakaiResource[] getAttachments() {
			return attachments;
		}
		public void setAttachments(SakaiResource[] attachments) {
			this.attachments = attachments;
		}
		public String getAuthorLastModified() {
			return authorLastModified;
		}
		public void setAuthorLastModified(String authorLastModified) {
			this.authorLastModified = authorLastModified;
		}
		public String[] getAuthors() {
			return authors;
		}
		public void setAuthors(String[] authors) {
			this.authors = authors;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public long getGenerateOriginalityReport() {
			return generateOriginalityReport;
		}
		public void setGenerateOriginalityReport(long generateOriginalityReport) {
			this.generateOriginalityReport = generateOriginalityReport;
		}
		public boolean isGroupProject() {
			return groupProject;
		}
		public void setGroupProject(boolean groupProject) {
			this.groupProject = groupProject;
		}
		public long getHonorPledge() {
			return honorPledge;
		}
		public void setHonorPledge(long honorPledge) {
			this.honorPledge = honorPledge;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getInstructions() {
			return instructions;
		}
		public void setInstructions(String instructions) {
			this.instructions = instructions;
		}
		public double getMaxGradePoint() {
			return maxGradePoint;
		}
		public void setMaxGradePoint(double maxGradePoint) {
			this.maxGradePoint = maxGradePoint;
		}
		public String getMaxGradePointDisplay() {
			return maxGradePointDisplay;
		}
		public void setMaxGradePointDisplay(String maxGradePointDisplay) {
			this.maxGradePointDisplay = maxGradePointDisplay;
		}
		public Object[] getProperties() {
			return properties;
		}
		public void setProperties(Object[] properties) {
			this.properties = properties;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public long getSubmitReviewRepo() {
			return submitReviewRepo;
		}
		public void setSubmitReviewRepo(long submitReviewRepo) {
			this.submitReviewRepo = submitReviewRepo;
		}
		public SakaiTime getTimeCreated() {
			return timeCreated;
		}
		public void setTimeCreated(SakaiTime timeCreated) {
			this.timeCreated = timeCreated;
		}
		public SakaiTime getTimeLastModified() {
			return timeLastModified;
		}
		public void setTimeLastModified(SakaiTime timeLastModified) {
			this.timeLastModified = timeLastModified;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public long getTypeOfGrade() {
			return typeOfGrade;
		}
		public void setTypeOfGrade(long typeOfGrade) {
			this.typeOfGrade = typeOfGrade;
		}
		public long getTypeOfSubmission() {
			return typeOfSubmission;
		}
		public void setTypeOfSubmission(long typeOfSubmission) {
			this.typeOfSubmission = typeOfSubmission;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public boolean isCheckInstitution() {
			return checkInstitution;
		}
		public void setCheckInstitution(boolean checkInstitution) {
			this.checkInstitution = checkInstitution;
		}
		public boolean isCheckInternet() {
			return checkInternet;
		}
		public void setCheckInternet(boolean checkInternet) {
			this.checkInternet = checkInternet;
		}
		public boolean isCheckPublications() {
			return checkPublications;
		}
		public void setCheckPublications(boolean checkPublications) {
			this.checkPublications = checkPublications;
		}
		public boolean isCheckTurnitin() {
			return checkTurnitin;
		}
		public void setCheckTurnitin(boolean checkTurnitin) {
			this.checkTurnitin = checkTurnitin;
		}
	}
}
