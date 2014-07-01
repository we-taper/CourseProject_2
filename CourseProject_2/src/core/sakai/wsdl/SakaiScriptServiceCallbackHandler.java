
/**
 * SakaiScriptServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package core.sakai.wsdl;

    /**
     *  SakaiScriptServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SakaiScriptServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SakaiScriptServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SakaiScriptServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for changeSiteIconUrl method
            * override this method for handling normal response from changeSiteIconUrl operation
            */
           public void receiveResultchangeSiteIconUrl(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeSiteIconUrlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeSiteIconUrl operation
           */
            public void receiveErrorchangeSiteIconUrl(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removePageFromSite method
            * override this method for handling normal response from removePageFromSite operation
            */
           public void receiveResultremovePageFromSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemovePageFromSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removePageFromSite operation
           */
            public void receiveErrorremovePageFromSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSitesUserCanAccess method
            * override this method for handling normal response from getSitesUserCanAccess operation
            */
           public void receiveResultgetSitesUserCanAccess(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSitesUserCanAccessResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSitesUserCanAccess operation
           */
            public void receiveErrorgetSitesUserCanAccess(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewUser method
            * override this method for handling normal response from addNewUser operation
            */
           public void receiveResultaddNewUser(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewUser operation
           */
            public void receiveErroraddNewUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disallowAllFunctionsForRole method
            * override this method for handling normal response from disallowAllFunctionsForRole operation
            */
           public void receiveResultdisallowAllFunctionsForRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.DisallowAllFunctionsForRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disallowAllFunctionsForRole operation
           */
            public void receiveErrordisallowAllFunctionsForRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPagesAndToolsForSite method
            * override this method for handling normal response from getPagesAndToolsForSite operation
            */
           public void receiveResultgetPagesAndToolsForSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetPagesAndToolsForSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPagesAndToolsForSite operation
           */
            public void receiveErrorgetPagesAndToolsForSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForAuthzGroup method
            * override this method for handling normal response from checkForAuthzGroup operation
            */
           public void receiveResultcheckForAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForAuthzGroup operation
           */
            public void receiveErrorcheckForAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeMemberFromSite method
            * override this method for handling normal response from removeMemberFromSite operation
            */
           public void receiveResultremoveMemberFromSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveMemberFromSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeMemberFromSite operation
           */
            public void receiveErrorremoveMemberFromSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeAuthzGroup method
            * override this method for handling normal response from removeAuthzGroup operation
            */
           public void receiveResultremoveAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeAuthzGroup operation
           */
            public void receiveErrorremoveAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeSiteJoinable method
            * override this method for handling normal response from changeSiteJoinable operation
            */
           public void receiveResultchangeSiteJoinable(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeSiteJoinableResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeSiteJoinable operation
           */
            public void receiveErrorchangeSiteJoinable(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewRoleToAuthzGroup method
            * override this method for handling normal response from addNewRoleToAuthzGroup operation
            */
           public void receiveResultaddNewRoleToAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewRoleToAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewRoleToAuthzGroup operation
           */
            public void receiveErroraddNewRoleToAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGroupsInSite method
            * override this method for handling normal response from getGroupsInSite operation
            */
           public void receiveResultgetGroupsInSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetGroupsInSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGroupsInSite operation
           */
            public void receiveErrorgetGroupsInSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addMemberToAuthzGroupWithRole method
            * override this method for handling normal response from addMemberToAuthzGroupWithRole operation
            */
           public void receiveResultaddMemberToAuthzGroupWithRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddMemberToAuthzGroupWithRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addMemberToAuthzGroupWithRole operation
           */
            public void receiveErroraddMemberToAuthzGroupWithRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForMemberInAuthzGroupWithRole method
            * override this method for handling normal response from checkForMemberInAuthzGroupWithRole operation
            */
           public void receiveResultcheckForMemberInAuthzGroupWithRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForMemberInAuthzGroupWithRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForMemberInAuthzGroupWithRole operation
           */
            public void receiveErrorcheckForMemberInAuthzGroupWithRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRoleDescription method
            * override this method for handling normal response from setRoleDescription operation
            */
           public void receiveResultsetRoleDescription(
                    core.sakai.wsdl.SakaiScriptServiceStub.SetRoleDescriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRoleDescription operation
           */
            public void receiveErrorsetRoleDescription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeAllMembersFromAuthzGroup method
            * override this method for handling normal response from removeAllMembersFromAuthzGroup operation
            */
           public void receiveResultremoveAllMembersFromAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveAllMembersFromAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeAllMembersFromAuthzGroup operation
           */
            public void receiveErrorremoveAllMembersFromAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addMemberToSiteWithRole method
            * override this method for handling normal response from addMemberToSiteWithRole operation
            */
           public void receiveResultaddMemberToSiteWithRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddMemberToSiteWithRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addMemberToSiteWithRole operation
           */
            public void receiveErroraddMemberToSiteWithRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeUserInfo method
            * override this method for handling normal response from changeUserInfo operation
            */
           public void receiveResultchangeUserInfo(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeUserInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserInfo operation
           */
            public void receiveErrorchangeUserInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeSiteProperty method
            * override this method for handling normal response from removeSiteProperty operation
            */
           public void receiveResultremoveSiteProperty(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveSitePropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeSiteProperty operation
           */
            public void receiveErrorremoveSiteProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for copyResources method
            * override this method for handling normal response from copyResources operation
            */
           public void receiveResultcopyResources(
                    core.sakai.wsdl.SakaiScriptServiceStub.CopyResourcesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from copyResources operation
           */
            public void receiveErrorcopyResources(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for copyRole method
            * override this method for handling normal response from copyRole operation
            */
           public void receiveResultcopyRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.CopyRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from copyRole operation
           */
            public void receiveErrorcopyRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserType method
            * override this method for handling normal response from getUserType operation
            */
           public void receiveResultgetUserType(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUserTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserType operation
           */
            public void receiveErrorgetUserType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeSiteTitle method
            * override this method for handling normal response from changeSiteTitle operation
            */
           public void receiveResultchangeSiteTitle(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeSiteTitleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeSiteTitle operation
           */
            public void receiveErrorchangeSiteTitle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeSiteDescription method
            * override this method for handling normal response from changeSiteDescription operation
            */
           public void receiveResultchangeSiteDescription(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeSiteDescriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeSiteDescription operation
           */
            public void receiveErrorchangeSiteDescription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeUserEmail method
            * override this method for handling normal response from changeUserEmail operation
            */
           public void receiveResultchangeUserEmail(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeUserEmailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserEmail operation
           */
            public void receiveErrorchangeUserEmail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeUser method
            * override this method for handling normal response from removeUser operation
            */
           public void receiveResultremoveUser(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeUser operation
           */
            public void receiveErrorremoveUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeSite method
            * override this method for handling normal response from removeSite operation
            */
           public void receiveResultremoveSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeSite operation
           */
            public void receiveErrorremoveSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSiteSkin method
            * override this method for handling normal response from getSiteSkin operation
            */
           public void receiveResultgetSiteSkin(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSiteSkinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSiteSkin operation
           */
            public void receiveErrorgetSiteSkin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewToolToPage method
            * override this method for handling normal response from addNewToolToPage operation
            */
           public void receiveResultaddNewToolToPage(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewToolToPageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewToolToPage operation
           */
            public void receiveErroraddNewToolToPage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSiteDescription method
            * override this method for handling normal response from getSiteDescription operation
            */
           public void receiveResultgetSiteDescription(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSiteDescriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSiteDescription operation
           */
            public void receiveErrorgetSiteDescription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoleFromAuthzGroup method
            * override this method for handling normal response from removeRoleFromAuthzGroup operation
            */
           public void receiveResultremoveRoleFromAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveRoleFromAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoleFromAuthzGroup operation
           */
            public void receiveErrorremoveRoleFromAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setSiteProperty method
            * override this method for handling normal response from setSiteProperty operation
            */
           public void receiveResultsetSiteProperty(
                    core.sakai.wsdl.SakaiScriptServiceStub.SetSitePropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setSiteProperty operation
           */
            public void receiveErrorsetSiteProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForUser method
            * override this method for handling normal response from checkForUser operation
            */
           public void receiveResultcheckForUser(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForUser operation
           */
            public void receiveErrorcheckForUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewSite method
            * override this method for handling normal response from addNewSite operation
            */
           public void receiveResultaddNewSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewSite operation
           */
            public void receiveErroraddNewSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserDisplayName method
            * override this method for handling normal response from getUserDisplayName operation
            */
           public void receiveResultgetUserDisplayName(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUserDisplayNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserDisplayName operation
           */
            public void receiveErrorgetUserDisplayName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForRoleInAuthzGroup method
            * override this method for handling normal response from checkForRoleInAuthzGroup operation
            */
           public void receiveResultcheckForRoleInAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForRoleInAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForRoleInAuthzGroup operation
           */
            public void receiveErrorcheckForRoleInAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addConfigPropertyToTool method
            * override this method for handling normal response from addConfigPropertyToTool operation
            */
           public void receiveResultaddConfigPropertyToTool(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddConfigPropertyToToolResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addConfigPropertyToTool operation
           */
            public void receiveErroraddConfigPropertyToTool(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeSiteSkin method
            * override this method for handling normal response from changeSiteSkin operation
            */
           public void receiveResultchangeSiteSkin(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeSiteSkinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeSiteSkin operation
           */
            public void receiveErrorchangeSiteSkin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchForUsers method
            * override this method for handling normal response from searchForUsers operation
            */
           public void receiveResultsearchForUsers(
                    core.sakai.wsdl.SakaiScriptServiceStub.SearchForUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchForUsers operation
           */
            public void receiveErrorsearchForUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addConfigPropertyToPage method
            * override this method for handling normal response from addConfigPropertyToPage operation
            */
           public void receiveResultaddConfigPropertyToPage(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddConfigPropertyToPageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addConfigPropertyToPage operation
           */
            public void receiveErroraddConfigPropertyToPage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeUserName method
            * override this method for handling normal response from changeUserName operation
            */
           public void receiveResultchangeUserName(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserName operation
           */
            public void receiveErrorchangeUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeMemberFromAuthzGroup method
            * override this method for handling normal response from removeMemberFromAuthzGroup operation
            */
           public void receiveResultremoveMemberFromAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveMemberFromAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeMemberFromAuthzGroup operation
           */
            public void receiveErrorremoveMemberFromAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewToolToAllWorkspaces method
            * override this method for handling normal response from addNewToolToAllWorkspaces operation
            */
           public void receiveResultaddNewToolToAllWorkspaces(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewToolToAllWorkspacesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewToolToAllWorkspaces operation
           */
            public void receiveErroraddNewToolToAllWorkspaces(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addMemberToGroup method
            * override this method for handling normal response from addMemberToGroup operation
            */
           public void receiveResultaddMemberToGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddMemberToGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addMemberToGroup operation
           */
            public void receiveErroraddMemberToGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewAuthzGroup method
            * override this method for handling normal response from addNewAuthzGroup operation
            */
           public void receiveResultaddNewAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewAuthzGroup operation
           */
            public void receiveErroraddNewAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserEmail method
            * override this method for handling normal response from getUserEmail operation
            */
           public void receiveResultgetUserEmail(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUserEmailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserEmail operation
           */
            public void receiveErrorgetUserEmail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewPageToSite method
            * override this method for handling normal response from addNewPageToSite operation
            */
           public void receiveResultaddNewPageToSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddNewPageToSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewPageToSite operation
           */
            public void receiveErroraddNewPageToSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeAllRolesFromAuthzGroup method
            * override this method for handling normal response from removeAllRolesFromAuthzGroup operation
            */
           public void receiveResultremoveAllRolesFromAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.RemoveAllRolesFromAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeAllRolesFromAuthzGroup operation
           */
            public void receiveErrorremoveAllRolesFromAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkSession method
            * override this method for handling normal response from checkSession operation
            */
           public void receiveResultcheckSession(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckSessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkSession operation
           */
            public void receiveErrorcheckSession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disallowFunctionForRole method
            * override this method for handling normal response from disallowFunctionForRole operation
            */
           public void receiveResultdisallowFunctionForRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.DisallowFunctionForRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disallowFunctionForRole operation
           */
            public void receiveErrordisallowFunctionForRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeUserPassword method
            * override this method for handling normal response from changeUserPassword operation
            */
           public void receiveResultchangeUserPassword(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeUserPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserPassword operation
           */
            public void receiveErrorchangeUserPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSiteProperty method
            * override this method for handling normal response from getSiteProperty operation
            */
           public void receiveResultgetSiteProperty(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSitePropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSiteProperty operation
           */
            public void receiveErrorgetSiteProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for copySite method
            * override this method for handling normal response from copySite operation
            */
           public void receiveResultcopySite(
                    core.sakai.wsdl.SakaiScriptServiceStub.CopySiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from copySite operation
           */
            public void receiveErrorcopySite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for copyCalendarEvents method
            * override this method for handling normal response from copyCalendarEvents operation
            */
           public void receiveResultcopyCalendarEvents(
                    core.sakai.wsdl.SakaiScriptServiceStub.CopyCalendarEventsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from copyCalendarEvents operation
           */
            public void receiveErrorcopyCalendarEvents(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRoleForAuthzGroupMaintenance method
            * override this method for handling normal response from setRoleForAuthzGroupMaintenance operation
            */
           public void receiveResultsetRoleForAuthzGroupMaintenance(
                    core.sakai.wsdl.SakaiScriptServiceStub.SetRoleForAuthzGroupMaintenanceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRoleForAuthzGroupMaintenance operation
           */
            public void receiveErrorsetRoleForAuthzGroupMaintenance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSiteTitle method
            * override this method for handling normal response from getSiteTitle operation
            */
           public void receiveResultgetSiteTitle(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSiteTitleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSiteTitle operation
           */
            public void receiveErrorgetSiteTitle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserId method
            * override this method for handling normal response from getUserId operation
            */
           public void receiveResultgetUserId(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUserIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserId operation
           */
            public void receiveErrorgetUserId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isSiteJoinable method
            * override this method for handling normal response from isSiteJoinable operation
            */
           public void receiveResultisSiteJoinable(
                    core.sakai.wsdl.SakaiScriptServiceStub.IsSiteJoinableResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isSiteJoinable operation
           */
            public void receiveErrorisSiteJoinable(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addGroupToSite method
            * override this method for handling normal response from addGroupToSite operation
            */
           public void receiveResultaddGroupToSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.AddGroupToSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addGroupToSite operation
           */
            public void receiveErroraddGroupToSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersInAuthzGroup method
            * override this method for handling normal response from getUsersInAuthzGroup operation
            */
           public void receiveResultgetUsersInAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUsersInAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersInAuthzGroup operation
           */
            public void receiveErrorgetUsersInAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllUsers method
            * override this method for handling normal response from getAllUsers operation
            */
           public void receiveResultgetAllUsers(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetAllUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllUsers operation
           */
            public void receiveErrorgetAllUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForSite method
            * override this method for handling normal response from checkForSite operation
            */
           public void receiveResultcheckForSite(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForSiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForSite operation
           */
            public void receiveErrorcheckForSite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSessionForUser method
            * override this method for handling normal response from getSessionForUser operation
            */
           public void receiveResultgetSessionForUser(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetSessionForUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSessionForUser operation
           */
            public void receiveErrorgetSessionForUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkForUserInAuthzGroup method
            * override this method for handling normal response from checkForUserInAuthzGroup operation
            */
           public void receiveResultcheckForUserInAuthzGroup(
                    core.sakai.wsdl.SakaiScriptServiceStub.CheckForUserInAuthzGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkForUserInAuthzGroup operation
           */
            public void receiveErrorcheckForUserInAuthzGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllSitesForUser method
            * override this method for handling normal response from getAllSitesForUser operation
            */
           public void receiveResultgetAllSitesForUser(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetAllSitesForUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllSitesForUser operation
           */
            public void receiveErrorgetAllSitesForUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersInAuthzGroupWithRole method
            * override this method for handling normal response from getUsersInAuthzGroupWithRole operation
            */
           public void receiveResultgetUsersInAuthzGroupWithRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.GetUsersInAuthzGroupWithRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersInAuthzGroupWithRole operation
           */
            public void receiveErrorgetUsersInAuthzGroupWithRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for allowFunctionForRole method
            * override this method for handling normal response from allowFunctionForRole operation
            */
           public void receiveResultallowFunctionForRole(
                    core.sakai.wsdl.SakaiScriptServiceStub.AllowFunctionForRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from allowFunctionForRole operation
           */
            public void receiveErrorallowFunctionForRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeUserType method
            * override this method for handling normal response from changeUserType operation
            */
           public void receiveResultchangeUserType(
                    core.sakai.wsdl.SakaiScriptServiceStub.ChangeUserTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserType operation
           */
            public void receiveErrorchangeUserType(java.lang.Exception e) {
            }
                


    }
    