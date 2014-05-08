
/**
 * SakaiScriptServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package taper.Sakai.WSDL;

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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeSiteIconUrlResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemovePageFromSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSitesUserCanAccessResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewUserResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.DisallowAllFunctionsForRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetPagesAndToolsForSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveMemberFromSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeSiteJoinableResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewRoleToAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetGroupsInSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddMemberToAuthzGroupWithRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForMemberInAuthzGroupWithRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.SetRoleDescriptionResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveAllMembersFromAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddMemberToSiteWithRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeUserInfoResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveSitePropertyResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CopyResourcesResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CopyRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUserTypeResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeSiteTitleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeSiteDescriptionResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeUserEmailResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveUserResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSiteSkinResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewToolToPageResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSiteDescriptionResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveRoleFromAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.SetSitePropertyResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForUserResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUserDisplayNameResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForRoleInAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddConfigPropertyToToolResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeSiteSkinResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.SearchForUsersResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddConfigPropertyToPageResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeUserNameResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveMemberFromAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewToolToAllWorkspacesResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddMemberToGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUserEmailResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddNewPageToSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.RemoveAllRolesFromAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckSessionResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.DisallowFunctionForRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeUserPasswordResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSitePropertyResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CopySiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CopyCalendarEventsResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.SetRoleForAuthzGroupMaintenanceResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSiteTitleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUserIdResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.IsSiteJoinableResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AddGroupToSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUsersInAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetAllUsersResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForSiteResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetSessionForUserResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.CheckForUserInAuthzGroupResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetAllSitesForUserResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.GetUsersInAuthzGroupWithRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.AllowFunctionForRoleResponse result
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
                    taper.Sakai.WSDL.SakaiScriptServiceStub.ChangeUserTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserType operation
           */
            public void receiveErrorchangeUserType(java.lang.Exception e) {
            }
                


    }
    