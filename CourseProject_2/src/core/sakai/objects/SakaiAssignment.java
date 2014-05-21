package core.sakai.objects;

import javax.xml.bind.annotation.XmlElement;
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
	
	private Resource attachment;
	public void setAttachment(Resource a){
		attachment = a;
	}
	public Resource getAttachment() {
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
		return String.format("Assignment:%s, ID:%s, Entity_URL:%s",
				getTitle(), getId(), getEntityURL());
	}
}
