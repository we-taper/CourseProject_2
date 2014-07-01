
/**
 * AssignmentsServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package core.sakai.wsdl;

    /**
     *  AssignmentsServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AssignmentsServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AssignmentsServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AssignmentsServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for undeleteAssignments method
            * override this method for handling normal response from undeleteAssignments operation
            */
           public void receiveResultundeleteAssignments(
                    core.sakai.wsdl.AssignmentsServiceStub.UndeleteAssignmentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from undeleteAssignments operation
           */
            public void receiveErrorundeleteAssignments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSubmissionsForAssignment method
            * override this method for handling normal response from getSubmissionsForAssignment operation
            */
           public void receiveResultgetSubmissionsForAssignment(
                    core.sakai.wsdl.AssignmentsServiceStub.GetSubmissionsForAssignmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSubmissionsForAssignment operation
           */
            public void receiveErrorgetSubmissionsForAssignment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setAssignmentGradeCommentforUser method
            * override this method for handling normal response from setAssignmentGradeCommentforUser operation
            */
           public void receiveResultsetAssignmentGradeCommentforUser(
                    core.sakai.wsdl.AssignmentsServiceStub.SetAssignmentGradeCommentforUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setAssignmentGradeCommentforUser operation
           */
            public void receiveErrorsetAssignmentGradeCommentforUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createAssignment method
            * override this method for handling normal response from createAssignment operation
            */
           public void receiveResultcreateAssignment(
                    core.sakai.wsdl.AssignmentsServiceStub.CreateAssignmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createAssignment operation
           */
            public void receiveErrorcreateAssignment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addSubmissionAttachment method
            * override this method for handling normal response from addSubmissionAttachment operation
            */
           public void receiveResultaddSubmissionAttachment(
                    core.sakai.wsdl.AssignmentsServiceStub.AddSubmissionAttachmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addSubmissionAttachment operation
           */
            public void receiveErroraddSubmissionAttachment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAssignmentsForContext method
            * override this method for handling normal response from getAssignmentsForContext operation
            */
           public void receiveResultgetAssignmentsForContext(
                    core.sakai.wsdl.AssignmentsServiceStub.GetAssignmentsForContextResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAssignmentsForContext operation
           */
            public void receiveErrorgetAssignmentsForContext(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createSubmission method
            * override this method for handling normal response from createSubmission operation
            */
           public void receiveResultcreateSubmission(
                    core.sakai.wsdl.AssignmentsServiceStub.CreateSubmissionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createSubmission operation
           */
            public void receiveErrorcreateSubmission(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setAssignmentAcceptUntil method
            * override this method for handling normal response from setAssignmentAcceptUntil operation
            */
           public void receiveResultsetAssignmentAcceptUntil(
                    core.sakai.wsdl.AssignmentsServiceStub.SetAssignmentAcceptUntilResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setAssignmentAcceptUntil operation
           */
            public void receiveErrorsetAssignmentAcceptUntil(java.lang.Exception e) {
            }
                


    }
    