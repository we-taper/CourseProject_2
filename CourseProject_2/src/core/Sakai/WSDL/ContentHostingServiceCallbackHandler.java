
/**
 * ContentHostingServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package core.Sakai.WSDL;

    /**
     *  ContentHostingServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ContentHostingServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ContentHostingServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ContentHostingServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getAllSitesCollectionSize method
            * override this method for handling normal response from getAllSitesCollectionSize operation
            */
           public void receiveResultgetAllSitesCollectionSize(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetAllSitesCollectionSizeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllSitesCollectionSize operation
           */
            public void receiveErrorgetAllSitesCollectionSize(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createContentItem method
            * override this method for handling normal response from createContentItem operation
            */
           public void receiveResultcreateContentItem(
                    core.Sakai.WSDL.ContentHostingServiceStub.CreateContentItemResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createContentItem operation
           */
            public void receiveErrorcreateContentItem(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getResources method
            * override this method for handling normal response from getResources operation
            */
           public void receiveResultgetResources(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetResourcesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getResources operation
           */
            public void receiveErrorgetResources(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVirtualRoot method
            * override this method for handling normal response from getVirtualRoot operation
            */
           public void receiveResultgetVirtualRoot(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetVirtualRootResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVirtualRoot operation
           */
            public void receiveErrorgetVirtualRoot(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createFolder method
            * override this method for handling normal response from createFolder operation
            */
           public void receiveResultcreateFolder(
                    core.Sakai.WSDL.ContentHostingServiceStub.CreateFolderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createFolder operation
           */
            public void receiveErrorcreateFolder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createTopFolder method
            * override this method for handling normal response from createTopFolder operation
            */
           public void receiveResultcreateTopFolder(
                    core.Sakai.WSDL.ContentHostingServiceStub.CreateTopFolderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createTopFolder operation
           */
            public void receiveErrorcreateTopFolder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSiteCollectionSize method
            * override this method for handling normal response from getSiteCollectionSize operation
            */
           public void receiveResultgetSiteCollectionSize(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetSiteCollectionSizeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSiteCollectionSize operation
           */
            public void receiveErrorgetSiteCollectionSize(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContentData method
            * override this method for handling normal response from getContentData operation
            */
           public void receiveResultgetContentData(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetContentDataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContentData operation
           */
            public void receiveErrorgetContentData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInfo method
            * override this method for handling normal response from getInfo operation
            */
           public void receiveResultgetInfo(
                    core.Sakai.WSDL.ContentHostingServiceStub.GetInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInfo operation
           */
            public void receiveErrorgetInfo(java.lang.Exception e) {
            }
                


    }
    